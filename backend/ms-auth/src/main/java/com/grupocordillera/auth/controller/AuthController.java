package com.grupocordillera.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.grupocordillera.auth.dto.LoginResponse;
import com.grupocordillera.auth.model.Usuario;
import com.grupocordillera.auth.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository repository;

    public AuthController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
        public ResponseEntity<LoginResponse> iniciarSesion(@RequestBody Usuario credentials) {
        // Simulación de generacion JWT según requerimiento
        return repository.findByUsername(credentials.getUsername())
                .filter(u -> u.getPassword().equals(credentials.getPassword()))
            .map(u -> ResponseEntity.ok(new LoginResponse(
                "fake-jwt-token-para-" + u.getUsername(),
                u.getUsername(),
                u.getRol(),
                u.getSucursal())))
            .orElse(ResponseEntity.status(401).build());
    }

    @GetMapping("/validar")
    public ResponseEntity<String> validarSesion(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("Token valido: " + token);
    }

    @PutMapping("/usuarios/{id}/rol")
    public Usuario actualizarRol(@PathVariable Long id, @RequestBody Usuario request) {
        return repository.findById(id).map(u -> {
            u.setRol(request.getRol());
            return repository.save(u);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    @PutMapping("/usuarios/username/{username}/rol")
    public Usuario actualizarRolPorUsername(@PathVariable String username, @RequestBody Usuario request) {
        return repository.findByUsername(username).map(u -> {
            u.setRol(request.getRol());
            return repository.save(u);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }
}
