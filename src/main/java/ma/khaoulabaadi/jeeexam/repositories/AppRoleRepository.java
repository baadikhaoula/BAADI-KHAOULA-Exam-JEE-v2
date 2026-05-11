package ma.khaoulabaadi.jeeexam.repositories;

import ma.khaoulabaadi.jeeexam.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
