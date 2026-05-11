package ma.khaoulabaadi.jeeexam.repositories;

import ma.khaoulabaadi.jeeexam.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByContractId(Long contractId);
}
