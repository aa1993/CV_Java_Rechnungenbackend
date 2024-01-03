# CV_Java_Rechnungenbackend ![Java](https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png) ![Maven](https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png) ![Spring Boot](https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png) ![Hibernate](https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png) ![MySQL](https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png) ![Intellij](https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png)

Dieses Projekt stellt eine Backend RESTapi Schnittstelle zur Verwaltung der Daten in der MySQL Datenbanken dienen. Bei den Daten handelt es sich um Informationen über Recchnungen. Das Schema der Datenbank und Dummydaten sind in [dieser Repository](https://github.com/aa1993/CV_MYSQL_Rechnungsdatenbank) zugänglich.

| HTTP Anfragen   | Pfad                                     | Beschreibung                                                                                     |
| :--------------:| :--------------------------------------- | :----------------------------------------------------------------------------------------------- |
| GET             | /api/v1/kunde/                           | Liste von allen Kunden                                                                           |
| GET             | /api/v1/kunde/{kundennummer}             | Kunden mit der Kundennummer kundennummer                                                         |
| POST            | /api/v1/kunde/                           | füge neuen Kunden hinzu                                                                          |
| DELETE          | /api/v1/kunde/{kundennummer}             | lösche den Kunden mit der Kundennummer kundennummer                                              |
| GET             | /api/v1/produkt/                         | Liste von allen Produkten                                                                        |
| GET             | /api/v1/produkt/{artikelnummer}          | Produkt mit der Artikelnummer artikelnummer                                                      |
| POST            | /api/v1/produkt/                         | füge neues Produkt hinzu                                                                         |
| DELETE          | /api/v1/produkt/{artikelnummer}          | lösche das Produkt mit der Artikelnummer artikelnummer                                           |
| GET             | /api/v1/rechnung/                        | Liste von allen Rechnungen                                                                       |
| GET             | /api/v1/rechnung/{rechnungsnummer}       | Rechnung mit der Rechnungsnummer rechnungsnummer                                                 |
| POST            | /api/v1/rechnung/                        | füge neue Rechnung hinzu                                                                         |
| DELETE          | /api/v1/rechnung/{rechnungsnummer}       | lösche die Rechnung mit der Rechnungsnummer rechnungsnummer                                      |
| GET             | /api/v1/rechnungsliste/{rechnunsgnummer} | Liste von allen Produkten mit Einkaufsanzahl der Rechnung mit Rechnungsnummer rechnungsnummmer   |
| GET             | /api/v1/totalpreis/{rechnungsnummer}     | Gesamtpreis der Rechnungen mit der Rechnungsnummer rechnungsnummer                               |
