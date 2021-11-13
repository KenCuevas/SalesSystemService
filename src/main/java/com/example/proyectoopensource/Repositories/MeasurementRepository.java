package com.example.proyectoopensource.Repositories;

import com.example.proyectoopensource.Models.UnidadesMedidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<UnidadesMedidas, Long> {
}
