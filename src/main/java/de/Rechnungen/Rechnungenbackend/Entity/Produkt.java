package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name="Produkt")
public class Produkt {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "artikelnummer", unique = true, nullable = false)
    private long artikelnummer;
    @Column(name = "produktname", nullable = false)
    private String produktname;
    @Column(name = "preis", nullable = false)
    private double preis;

    //@OneToMany(mappedBy = "produkt") //mappedBy variablename in der Kauft Klasse
    //private List<Kauft> kauft;


    public Produkt() {
    }

    public Produkt(long artikelnummer, String produktname, double preis) {
        artikelnummer = artikelnummer;
        produktname = produktname;
        preis = preis;
    }

    public Produkt(String produktname, double preis) {
        this.produktname = produktname;
        this.preis = preis;
    }


    public long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    //@JsonIgnore
    //public List<Kauft> getKauft() {
    //    return kauft;
    //}

    //public void setKauft(List<Kauft> kauft) {
    //    this.kauft = kauft;
    //}

    @Override
    public String toString() {
        return "Produkt{" +
                "artikelnummer=" + artikelnummer +
                ", produktname='" + produktname + '\'' +
                ", preis=" + preis +
                '}';
    }
}
