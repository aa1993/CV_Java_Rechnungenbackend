package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Rechnung")
public class Rechnung {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Rechnungsnummer", unique = true, nullable = false)
    private Long rechnungsnummer;
    @Column(name = "kundennummer", nullable = false)
    private Long kundennummer;

    @Column(name = "Rechnungsdatum", nullable = false)

    private LocalDate rechnungsdatum;

    public Rechnung() {
    }

    public Rechnung(Long rechnungsnummer, Long kundennummer, LocalDate rechnungsdatum) {
        this.rechnungsnummer = rechnungsnummer;
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
    }

    public Rechnung(Long kundennummer, LocalDate rechnungsdatum) {
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
    }

    public Long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public Long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(Long kundennummer) {
        this.kundennummer = kundennummer;
    }

    public void setRechnungsnummer(Long rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public LocalDate getRechnungsdatum() {
        return rechnungsdatum;
    }

    public void setRechnungsdatum(LocalDate rechnungsdatum) {
        this.rechnungsdatum = rechnungsdatum;
    }

}
