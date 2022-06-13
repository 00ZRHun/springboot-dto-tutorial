package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {
}
