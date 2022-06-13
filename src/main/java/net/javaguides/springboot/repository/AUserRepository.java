package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AUserRepository extends JpaRepository<AUser, Long> {
}
