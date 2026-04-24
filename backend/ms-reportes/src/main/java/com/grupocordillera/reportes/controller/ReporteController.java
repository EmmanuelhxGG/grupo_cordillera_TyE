package com.grupocordillera.reportes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupocordillera.reportes.model.PlantillaReporte;
import com.grupocordillera.reportes.repository.PlantillaReporteRepository;

@RestController
@RequestMapping("/api/reportes/plantillas")
@CrossOrigin(origins = "*")
public class ReporteController {

    private final PlantillaReporteRepository repository;

    public ReporteController(PlantillaReporteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PlantillaReporte> listarPlantillas(
            @RequestParam(required = false) String sucursal) {
        if (sucursal != null && !sucursal.isBlank()) {
            return repository.findBySucursalIgnoreCase(sucursal.trim());
        }
        return repository.findAll();
    }

    @PostMapping
    public PlantillaReporte crearPlantilla(@RequestBody PlantillaReporte plantilla) {
        if (plantilla.getSucursal() != null && plantilla.getSucursal().isBlank()) {
            plantilla.setSucursal(null);
        }
        return repository.save(plantilla);
    }

    @DeleteMapping("/{id}")
    public void eliminarReporte(@PathVariable Long id) {
        // En tu informe sugerías borrado lógico, así que actualizamos el estado
        repository.findById(id).ifPresent(plantilla -> {
            plantilla.setEstado("Inactivo");
            repository.save(plantilla);
        });
    }
}
