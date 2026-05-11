package ma.khaoulabaadi.jeeexam.mappers;

import ma.khaoulabaadi.jeeexam.dtos.CustomerDTO;
import ma.khaoulabaadi.jeeexam.entities.Customer;
import org.springframework.beans.BeanUtils;

public class jeeexamImpl {
    public CustomerDTO fromCustomer(Customer c) {
        CustomerDTO dto = new CustomerDTO();
        BeanUtils.copyProperties(c, dto);
        return dto;
    }
    public Customer fromCustomerDTO(CustomerDTO dto) {
        Customer c = new Customer();
        BeanUtils.copyProperties(dto, c);
        return c;
    }

}
