package ma.khaoulabaadi.jeeexam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.khaoulabaadi.jeeexam.enums.HousingType;

@Entity
@DiscriminatorValue("HOME")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeContract extends InsuranceContract {
    @Enumerated(EnumType.STRING)
    private HousingType housingType;
    private String address;
    private double area;
}
