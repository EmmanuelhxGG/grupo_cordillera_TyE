package com.grupocordillera.reportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupocordillera.reportes.model.PlantillaReporte;

@Repository
public interface PlantillaReporteRepository extends JpaRepository<PlantillaReporte, Long> {
	List<PlantillaReporte> findBySucursalIgnoreCase(String sucursal);
}
