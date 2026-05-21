package com.example.laboratorio_3.repository;
import com.example.laboratorio_3.domain.entity.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
}
