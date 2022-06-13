package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.COccupationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface COccupationCategoryRepository extends JpaRepository<COccupationCategory, Long> {
}
