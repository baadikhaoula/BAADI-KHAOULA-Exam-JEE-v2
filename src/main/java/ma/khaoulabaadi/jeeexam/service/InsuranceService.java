package ma.khaoulabaadi.jeeexam.service;

import ma.khaoulabaadi.jeeexam.dtos.CustomerDTO;
import ma.khaoulabaadi.jeeexam.entities.InsuranceContract;
import ma.khaoulabaadi.jeeexam.entities.Payment;
import ma.khaoulabaadi.jeeexam.enums.PaymentType;

import java.util.List;

public interface InsuranceService {
    CustomerDTO saveCustomer(CustomerDTO dto);
    List<CustomerDTO> listCustomers();
    CustomerDTO getCustomer(Long id) throws Exception;
    CustomerDTO updateCustomer(CustomerDTO dto);
    void deleteCustomer(Long id);

    InsuranceContract saveAutoContract(double cotisation, int duration,
                                       String immat, String brand, String model, Long customerId) throws Exception;
    List<InsuranceContract> listContracts();
    List<InsuranceContract> getContractsByCustomer(Long customerId);

    Payment savePayment(double amount, PaymentType type, Long contractId) throws Exception;
}
