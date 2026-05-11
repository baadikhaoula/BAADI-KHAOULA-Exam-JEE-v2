package ma.khaoulabaadi.jeeexam.repositories;

import ma.khaoulabaadi.jeeexam.entities.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<InsuranceContract, Long> {
    List<InsuranceContract> findByCustomerId(Long customerId);
}
