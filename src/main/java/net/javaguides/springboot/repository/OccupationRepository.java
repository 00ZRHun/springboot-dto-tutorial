package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.OccupationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<OccupationModel, Long> {
}
