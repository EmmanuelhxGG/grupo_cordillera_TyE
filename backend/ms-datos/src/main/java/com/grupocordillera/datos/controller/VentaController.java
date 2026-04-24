package com.grupocordillera.datos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupocordillera.datos.model.Venta;
import com.grupocordillera.datos.repository.VentaRepository;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaRepository repository;

    public VentaController(VentaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/registrar")
    public Venta registrarVenta(@RequestBody Venta venta) {
        if (venta.getFechaVenta() == null) {
            venta.setFechaVenta(LocalDateTime.now());
        }
        return repository.save(venta);
    }

    @GetMapping
    public List<Venta> listarVentas() {
        return repository.findAll();
    }
}
