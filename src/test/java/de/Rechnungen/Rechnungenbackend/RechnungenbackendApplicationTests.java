package de.Rechnungen.Rechnungenbackend;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Repository.KundeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
class RechnungenbackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private KundeRepository kundeRepository;

	@Test
	void testAddKundeRepo() throws Exception{
		Kunde kunde = new Kunde("Michael", "Vagner", "Müllerstraße", 4, 50192, "Köln");
		Long kundennummer = kundeRepository.save(kunde).getKundennummer();

		Optional<Kunde> optionalKundeGefunden = kundeRepository.findById(kundennummer);
		assertThat(optionalKundeGefunden.isPresent()).isTrue();

		Kunde kundeGefunden = optionalKundeGefunden.get();
		assertThat(kundeGefunden.getVorname()).isEqualTo("Michael");
		assertThat(kundeGefunden.getNachname()).isEqualTo("Vagner");
		assertThat(kundeGefunden.getStrasse()).isEqualTo("Müllerstraße");
		assertThat(kundeGefunden.getHausnummer()).isEqualTo(4);
		assertThat(kundeGefunden.getPLZ()).isEqualTo(50192);
		assertThat(kundeGefunden.getOrt()).isEqualTo("Köln");
	}

	@Test
	void testAddKunde() throws Exception{
		mockMvc.perform(post("http://localhost:8080/api/v1/kunde/")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"vorname\": \"Michael\"," +
								 "\"nachname\": \"Vagner\"," +
								 "\"strasse\": \"Müllerstraße\"," +
								 "\"hausnummer\": 4," +
								 "\"plz\": 50192," +
								 "\"ort\": \"Köln\"}"))
						.andExpect(status().isCreated());
	}

}
