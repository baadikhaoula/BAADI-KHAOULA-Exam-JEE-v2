package ma.khaoulabaadi.jeeexam.repositories;

import ma.khaoulabaadi.jeeexam.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContains(String name);
}
