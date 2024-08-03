package com.hfg.users.usermanagement.repository;

import com.hfg.users.usermanagement.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}