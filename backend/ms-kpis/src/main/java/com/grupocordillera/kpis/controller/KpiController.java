package com.grupocordillera.kpis.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupocordillera.kpis.model.Kpi;
import com.grupocordillera.kpis.repository.KpiRepository;

@RestController
@RequestMapping("/api/kpis")
@CrossOrigin(origins = "*")
public class KpiController {

    private final KpiRepository repository;

    public KpiController(KpiRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Kpi> listarKpis() {
        return repository.findAll();
    }

    @PutMapping("/{id}/formula")
    public Kpi actualizarFormula(@PathVariable Long id, @RequestBody Kpi request) {
        return repository.findById(id).map(kpi -> {
            kpi.setFormula(request.getFormula());
            kpi.setFechaActualizacion(LocalDateTime.now());
            return repository.save(kpi);
        }).orElseThrow(() -> new RuntimeException("KPI no encontrado"));
    }
}
