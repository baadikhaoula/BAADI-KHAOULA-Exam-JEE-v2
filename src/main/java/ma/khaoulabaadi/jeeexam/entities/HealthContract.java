package ma.khaoulabaadi.jeeexam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HLTH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthContract extends InsuranceContract {
    @Enumerated(EnumType.STRING)
    private CoverageLevel coverageLevel;
    private int nbPersonsCovered;
}