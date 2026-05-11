package ma.khaoulabaadi.jeeexam;

import ma.khaoulabaadi.jeeexam.entities.AutoContract;
import ma.khaoulabaadi.jeeexam.entities.Customer;
import ma.khaoulabaadi.jeeexam.entities.InsuranceContract;
import ma.khaoulabaadi.jeeexam.entities.Payment;
import ma.khaoulabaadi.jeeexam.enums.ContractStatus;
import ma.khaoulabaadi.jeeexam.enums.PaymentType;
import ma.khaoulabaadi.jeeexam.repositories.ContractRepository;
import ma.khaoulabaadi.jeeexam.repositories.CustomerRepository;
import ma.khaoulabaadi.jeeexam.repositories.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JeEexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeEexamApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepo,
                                        ContractRepository contractRepo,
                                        PaymentRepository paymentRepo) {
        return args -> {

            Stream.of("Ali Benali", "Sara Chraibi", "Youssef Idrissi").forEach(name -> {
                Customer c = new Customer();
                c.setName(name);
                c.setEmail(name.replace(" ", ".").toLowerCase() + "@gmail.com");
                customerRepo.save(c);
            });


            customerRepo.findAll().forEach(customer -> {
                AutoContract auto = new AutoContract();
                auto.setSubscriptionDate(new Date());
                auto.setStatus(ContractStatus.EN_COURS);
                auto.setCotisation(500 + Math.random() * 1000);
                auto.setDuration(12);
                auto.setCoverageRate(80);
                auto.setImmatriculation("12345-A-" + (int)(Math.random() * 99));
                auto.setBrand("Renault");
                auto.setModel("Clio");
                auto.setCustomer(customer);
                InsuranceContract saved = contractRepo.save(auto);


                for (int i = 0; i < 3; i++) {
                    Payment p = new Payment();
                    p.setDate(new Date());
                    p.setAmount(saved.getCotisation() / 12);
                    p.setType(PaymentType.MENSUALITE);
                    p.setContract(saved);
                    paymentRepo.save(p);
                }
            });
        };
    }

}