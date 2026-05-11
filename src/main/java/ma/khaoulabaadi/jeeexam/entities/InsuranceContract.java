package ma.khaoulabaadi.jeeexam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.khaoulabaadi.jeeexam.enums.ContractStatus;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date subscriptionDate;
    @Enumerated(EnumType.STRING)
    private ContractStatus status;
    private Date validationDate;
    private double cotisation;
    private int duration;
    private double coverageRate;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
    private List<Payment> payments;
}
