package com.grupocordillera.kpis;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grupocordillera.kpis.model.Kpi;
import com.grupocordillera.kpis.repository.KpiRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@SuppressWarnings("unused")
	CommandLineRunner inicializarKpis(KpiRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.save(new Kpi(
					null,
					"Cumplimiento de Meta",
					"ventas_totales / meta_mensual",
					0.0,
					LocalDateTime.now()));

				repository.save(new Kpi(
					null,
					"Crecimiento Mensual",
					"(ventas_mes_actual - ventas_mes_anterior) / ventas_mes_anterior",
					0.0,
					LocalDateTime.now()));
			}
		};
	}
}
