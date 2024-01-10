package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"Kunde\"")
public class Kunde {
    @Id
 //   @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "kundennummer", unique = true, nullable = false)
    private long kundennummer;
    @Column(name = "vorname", nullable = false)
    private String vorname;
    @Column(name = "nachname",nullable = false)
    private String nachname;
    @Column(name = "strasse", nullable = false)
    private String strasse;
    @Column(name = "hausnummer", nullable = false)
    private int hausnummer;
    @Column(name = "plz", nullable = false)
    private int plz;
    @Column(name = "ort", nullable = false)
    private String ort;

    public Kunde() {
    }

    public Kunde(long kundennummer, String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort) {
        this.kundennummer = kundennummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = pLZ;
        this.ort = ort;
    }

    public Kunde(String vorname, String nachname, String strasse, int hausnummer, int pLZ, String ort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = pLZ;
        this.ort = ort;
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
        return plz;
    }

    public void setPLZ(int pLZ) {
        this.plz = pLZ;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundennummer=" + kundennummer +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hausnummer=" + hausnummer +
                ", pLZ=" + plz +
                ", ort='" + ort + '\'' +
                '}';
    }
}
