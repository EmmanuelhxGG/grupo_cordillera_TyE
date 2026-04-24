package com.grupocordillera.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grupocordillera.auth.model.Usuario;
import com.grupocordillera.auth.repository.UsuarioRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@SuppressWarnings("unused")
	CommandLineRunner inicializarUsuarios(UsuarioRepository repository) {
		return args -> {
			if (repository.findByUsername("admin").isEmpty()) {
				repository.save(new Usuario(null, "admin", "admin1", "ADMIN", null));
			}

			if (repository.findByUsername("admin.cordillera").isEmpty()) {
				repository.save(new Usuario(null, "admin.cordillera", "Admin123!", "ADMIN", null));
			}

			if (repository.findByUsername("empleado.concepcion").isEmpty()) {
				repository.save(new Usuario(
					null,
					"empleado.concepcion",
					"tienda123",
					"EMPLEADO_TIENDA",
					"Concepción"));
			}
		};
	}
}
