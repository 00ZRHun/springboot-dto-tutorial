package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.BLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BLocationRepository extends JpaRepository<BLocation, Long> {
}
