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
    private long rechnungsnummer;
    @Column(name = "kundennummer", nullable = false)
    private long kundennummer;

    @Column(name = "Rechnungsdatum", nullable = false)

    private LocalDate rechnungsdatum;

    //@ManyToOne
    //@JoinColumn(name = "kundennummer")
    //private Kunde kunde ;


    public Rechnung() {
    }

    public Rechnung(long rechnungsnummer, long kundennummer, LocalDate rechnungsdatum) {
        this.rechnungsnummer = rechnungsnummer;
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
    }

    public Rechnung(long kundennummer, LocalDate rechnungsdatum) {
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
    }

    /*public Rechnung(long rechnungsnummer, long kundennummer, LocalDate rechnungsdatum, Kunde kunde) {
        this.rechnungsnummer = rechnungsnummer;
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
        this.kunde = kunde;
    }

    public Rechnung(long kundennummer, LocalDate rechnungsdatum, Kunde kunde) {
        this.kundennummer = kundennummer;
        this.rechnungsdatum = rechnungsdatum;
        this.kunde = kunde;
    }*/

    public long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
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

    //@JsonBackReference
    //public Kunde getKunde() {
    //    return kunde;
    //}

    //public void setKunde(Kunde kunde) {
    //    this.kunde = kunde;
    //}

    //@JsonIgnore
    //public List<Kauft> getKauft() {
    //    return kauft;
    //}

    //public void setKauft(List<Kauft> kauft) {
    //    this.kauft = kauft;
    //}


}
