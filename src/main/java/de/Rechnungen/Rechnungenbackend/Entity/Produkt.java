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
    private Long artikelnummer;
    @Column(name = "produktname", nullable = false)
    private String produktname;
    @Column(name = "preis", nullable = false)
    private Double preis;

    public Produkt() {
    }

    public Produkt(Long artikelnummer, String produktname, Double preis) {
        artikelnummer = artikelnummer;
        produktname = produktname;
        preis = preis;
    }

    public Produkt(String produktname, Double preis) {
        this.produktname = produktname;
        this.preis = preis;
    }


    public Long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "artikelnummer=" + artikelnummer +
                ", produktname='" + produktname + '\'' +
                ", preis=" + preis +
                '}';
    }
}
