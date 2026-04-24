package com.grupocordillera.kpis.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kpis")
public class Kpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String formula;
    private Double valorCalculado;
    private LocalDateTime fechaActualizacion;

    public Kpi() {
    }

    public Kpi(Long id, String nombre, String formula, Double valorCalculado, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.formula = formula;
        this.valorCalculado = valorCalculado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getValorCalculado() {
        return valorCalculado;
    }

    public void setValorCalculado(Double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
