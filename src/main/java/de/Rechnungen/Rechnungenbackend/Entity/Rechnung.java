package de.Rechnungen.Rechnungenbackend.Entity;

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
    private long rechnungsnummer;
    @Column(name = "Rechnungsdatum", nullable = false)

    private LocalDate rechnungsdatum;

    @OneToMany(mappedBy = "rechnung") //mappedBy variablename in der Kauft Klasse
    private List<Kauft> kauft;


    public Rechnung() {
    }

    public Rechnung(long rechnungsnummer, LocalDate rechnungsdatum) {
        this.rechnungsnummer = rechnungsnummer;
        this.rechnungsdatum = rechnungsdatum;
    }

    public Rechnung(LocalDate rechnungsdatum) {
        this.rechnungsdatum = rechnungsdatum;
    }

    public Rechnung(long rechnungsnummer, LocalDate rechnungsdatum, List<Kauft> kauft) {
        this.rechnungsnummer = rechnungsnummer;
        this.rechnungsdatum = rechnungsdatum;
        this.kauft = kauft;
    }

    public Rechnung(LocalDate rechnungsdatum, List<Kauft> kauft) {
        this.rechnungsdatum = rechnungsdatum;
        this.kauft = kauft;
    }

    public long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public void setRechnungsnummer(long rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public LocalDate getRechnungsdatum() {
        return rechnungsdatum;
    }

    public void setRechnungsdatum(LocalDate rechnungsdatum) {
        this.rechnungsdatum = rechnungsdatum;
    }

    @JsonIgnore
    public List<Kauft> getKauft() {
        return kauft;
    }

    public void setKauft(List<Kauft> kauft) {
        this.kauft = kauft;
    }

    @Override
    public String toString() {
        return "Rechnung{" +
                "Rechnungsnummer=" + rechnungsnummer +
                ", Rechnungsdatum=" + rechnungsdatum +
                '}';
    }
}
