package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"Kunde\"")
public class Kunde {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "Kundennummer", unique = true, nullable = false)
    private long kundennummer;
    @Column(name = "Vorname", nullable = false)
    private String vorname;
    @Column(name = "Nachname",nullable = false)
    private String nachname;
    @Column(name = "Strasse", nullable = false)
    private String strasse;
    @Column(name = "Hausnummer", nullable = false)
    private int hausnummer;
    @Column(name = "PLZ", nullable = false)
    private int pLZ;
    @Column(name = "Ort", nullable = false)
    private String ort;

    @OneToMany(mappedBy = "kunde") //mappedBy variablename in der Kauft Klasse
    private List<Kauft> kauft;

    public Kunde() {
    }

    public Kunde(long kundennummer, String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort) {
        this.kundennummer = kundennummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.pLZ = pLZ;
        this.ort = ort;
    }

    public Kunde(String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.pLZ = pLZ;
        this.ort = ort;
    }

    public Kunde(long kundennummer, String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort, List<Kauft> kauft) {
        this.kundennummer = kundennummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.pLZ = pLZ;
        this.ort = ort;
        this.kauft = kauft;
    }

    public Kunde(String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort, List<Kauft> kauft) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.pLZ = pLZ;
        this.ort = ort;
        this.kauft = kauft;
    }

    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPLZ() {
        return pLZ;
    }

    public void setPLZ(int pLZ) {
        this.pLZ = pLZ;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
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
        return "Kunde{" +
                "kundennummer=" + kundennummer +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hausnummer=" + hausnummer +
                ", pLZ=" + pLZ +
                ", ort='" + ort + '\'' +
                '}';
    }
}
