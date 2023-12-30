package de.Rechnungen.Rechnungenbackend;

import de.Rechnungen.Rechnungenbackend.Kunde.Kunde;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class RechnungenbackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(RechnungenbackendApplication.class, args);
	}

	@GetMapping
	public List<Kunde> hello(){
		return List.of(
				new Kunde(
						1L,
						"Max",
						"Mustermann",
						"Musterstraße",
						4,
						11111,
						"Musterstadt"
				)
		);
	}

}
