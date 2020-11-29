package com.gp.inmotion.repository;

import com.gp.inmotion.models.Role;
import com.gp.inmotion.security.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ApplicationUserRole name);
}
