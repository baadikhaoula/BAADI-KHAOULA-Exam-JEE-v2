package ma.khaoulabaadi.jeeexam.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ContractDTO {
    private Long id;
    private String type;
    private Date subscriptionDate;
    private String status;
    private double cotisation;
    private CustomerDTO customer;
}
