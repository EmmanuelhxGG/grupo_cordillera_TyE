package com.grupocordillera.reportes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plantillas_reporte")
public class PlantillaReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String configuracionVisual;
    private String estado;
    private String sucursal;

    public PlantillaReporte() {
    }

    public PlantillaReporte(Long id, String titulo, String configuracionVisual, String estado, String sucursal) {
        this.id = id;
        this.titulo = titulo;
        this.configuracionVisual = configuracionVisual;
        this.estado = estado;
        this.sucursal = sucursal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConfiguracionVisual() {
        return configuracionVisual;
    }

    public void setConfiguracionVisual(String configuracionVisual) {
        this.configuracionVisual = configuracionVisual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
