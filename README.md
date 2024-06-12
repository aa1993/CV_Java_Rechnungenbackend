# Rechnungenbackend

<img src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="drawing" width="40"/> <img src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" alt="drawing" width="40"/> <img src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="drawing" width="40"/> <img src="https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png" alt="drawing" width="40"/> <img src="https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png" alt="drawing" width="40"/> <img src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="drawing" width="40"/>

Das "Rechnungenbackend" ist ein Beispielprojekt, das meine Fähigkeiten und mein Verständnis in der Entwicklung von Backend-Anwendungen mit Java und dem SpringBoot-Framework demonstriert. Es bietet eine RESTful API zur Verwaltung von Rechnungsdaten, die von einer MySQL-Datenbank abgerufen werden.

In diesem Projekt habe ich mich intensiv mit der Implementierung eines Backends mithilfe von SpringBoot und der Integration von Hibernate für den Datenbankzugriff auseinandergesetzt. Die Datenbank enthält Informationen über Rechnungen, ähnlich einer Einkaufsliste, sowie Kundeninformationen.

Durch die Erstellung dieses Demonstrationsprojekts konnte ich meine Kenntnisse und Fertigkeiten in den folgenden Bereichen unter Beweis stellen:

1. Entwurf und Implementierung einer RESTful API mit SpringBoot.
2. Integration von Hibernate zur Datenbankanbindung.
3. Modellierung und Verwaltung von Datenbankrelationen.
4. Entwicklung von Endpunkten zur Datenmanipulation und -abfrage.
5. Umgang mit Fehlerbehandlung und Statusmeldungen
6. Erstellen von Dockerfile und docker-compose Dateien
7. Multi-stages Building mit Docker
8. Verwaltung von mehreren Docker Images 

Das "Rechnungenbackend" dient als praktisches Beispiel für meine Fähigkeiten in der Entwicklung von Backend-Anwendungen mit Java und SpringBoot sowie meiner Fähigkeit, komplexe Datenbankstrukturen zu verwalten und effizienten Zugriff auf diese zu ermöglichen.

| HTTP Anfragen | Pfad                                                       | Beschreibung                                                                                                            |
|:-------------:|:-----------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------|
|      GET      | /api/v1/kunden                                             | Liste von allen Kunden                                                                                                  |
|      GET      | /api/v1/kunden/{kundennummer}                              | Kunden mit der Kundennummer kundennummer                                                                                |
|     POST      | /api/v1/kunden                                             | füge neuen Kunden hinzu                                                                                                 |
|    DELETE     | /api/v1/kunden/{kundennummer}                              | lösche den Kunden mit der Kundennummer kundennummer                                                                     |
|      PUT      | /api/v1/kunden/{kundennummer}                              | ändert den Kunden mit der Kundennummer kundennummer                                                                     |
|      GET      | /api/v1/produkt                                            | Liste von allen Produkten                                                                                               |
|      GET      | /api/v1/produkt/{artikelnummer}                            | Produkt mit der Artikelnummer artikelnummer                                                                             |
|     POST      | /api/v1/produkt                                            | füge neues Produkt hinzu                                                                                                |
|    DELETE     | /api/v1/produkt/{artikelnummer}                            | lösche das Produkt mit der Artikelnummer artikelnummer                                                                  |
|      PUT      | /api/v1/produkt/{artikelnummer}                            | ändert das Produkt mit der Artikelnummer artikelnummer                                                                  |
|      GET      | /api/v1/rechnungen                                         | Liste von allen Rechnungen                                                                                              |
|      GET      | /api/v1/rechnungen/{rechnungsnummer}                       | Rechnung mit der Rechnungsnummer rechnungsnummer                                                                        |
|     POST      | /api/v1/rechnungen                                         | füge neue Rechnung hinzu                                                                                                |
|    DELETE     | /api/v1/rechnungen/{rechnungsnummer}                       | lösche die Rechnung mit der Rechnungsnummer rechnungsnummer                                                             |
|      PUT      | /api/v1/rechnungen/{rechnungsnummer}                       | ändert die Rechnung mit der Rechnungsnummer rechnungsnummer                                                             |
|      GET      | /api/v1/rechnungen/{rechnungsnummer}/liste                 | Liste von aller Rechnungseinträge der Rechnung mit der Rechnungsnummer rechnungsnummer                                  |
|      GET      | /api/v1/rechnungen/{rechnungsnummer}/liste/{artikelnummer} | Rechnungseinträge der Rechnung mit der Rechnungsnummer rechnungsnummer                                                  |
|     POST      | /api/v1/rechnungen/{rechnungsnummer}/liste                 | füge neue Rechnungseintrag in die Rechnung mit der Rechnungsnummer rechnungsnummer hinzu                                |
|    DELETE     | /api/v1/rechnungen/{rechnungsnummer}/liste/{artikelnummer} | lösche den Rechnungseintrag mit der Artikelnummer artikelnummer in die Rechnung mit der Rechnungsnummer rechnungsnummer |
|      PUT      | /api/v1/rechnungen/{rechnungsnummer}/liste/{artikelnummer} | ändere den Rechnungseintrag mit der Artikelnummer artikelnummer in die Rechnung mit der Rechnungsnummer rechnungsnummer |
|      GET      | /api/v1/rechnungen/{rechnungsnummer}/gesamtpreis           | Gesamtpreis der Rechnungen mit der Rechnungsnummer rechnungsnummer                                                      |

## Anwendung starten
Um die Anwendung zu kompilieren und zu starten, führen Sie einfach den folgenden Befehl aus:

``` sh
docker-compose up --build
```

Dieser Befehl baut die Docker-Images und startet alle definierten Container im docker-compose.yml-File.

## Voraussetzungen
Stellen Sie sicher, dass die folgenden Voraussetzungen erfüllt sind:

- Docker ist installiert und läuft.
- Docker Compose ist installiert.

## Zusätzliche Hinweise
- Verwenden Sie **'docker-compose down'**, um die Container zu stoppen und zu entfernen, wenn Sie die Anwendung nicht mehr benötigen.
- Um die Anwendung ohne erneutes Bauen der Images zu starten, können Sie den Befehl ohne --build ausführen:
``` sh
docker-compose up
```