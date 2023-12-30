package de.Rechnungen.Rechnungenbackend.Kunde;

public class Kunde {
    private long kundennummer;
    private String vorname;
    private String nachname;
    private String strasse;
    private int hausnummer;
    private int pLZ;
    private String ort;

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
