package scamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scamp.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
