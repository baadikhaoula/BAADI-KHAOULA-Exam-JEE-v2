package ma.khaoulabaadi.jeeexam.repositories;

import ma.khaoulabaadi.jeeexam.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
