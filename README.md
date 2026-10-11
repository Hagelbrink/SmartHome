# Smart Home

Ett konsolbaserat Smart Home-system utvecklat i Java 25 som en individuell fördjupningsuppgift.

## Funktionalitet

Systemet hanterar tre typer av smarta enheter: lampor, kameror och radiatorer.

Det går att:
- Lägga till och ta bort enheter.
- Söka efter enheter via ID eller namn.
- Lista alla registrerade enheter.
- Aktivera och avaktivera enheter.
- Se enheternas status och tidsstämplar.
- Hantera fel, exempelvis om en enhet redan är aktiverad eller om ett ID saknas.

Programmet demonstrerar funktionerna automatiskt när `Main` körs. Det finns ännu ingen interaktiv meny.

## Projektstruktur

- `app` – innehåller `Main`, som demonstrerar systemet.
- `model` – innehåller `SmartDevice`, `Activatable` och de tre enhetstyperna.
- `service` – innehåller `SmartHome`, som hanterar samlingen av enheter.
- `exception` – innehåller egna undantagsklasser.

## Tekniker

- Java 25
- Maven
- JUnit 5
- Mockito
- Java Collections (`HashMap`)
- Java Time API

## Bygga och köra

Projektet kräver JDK 25 och Maven.

Bygg projektet:

```bash
mvn clean package
```

Starta programmet:

```bash
java -jar target/SmartHome-1.0-SNAPSHOT.jar
```

## Tester

Kör testerna med:

```bash
mvn test
```

Det går även att köra `test` och `package` via Maven-panelen i IntelliJ IDEA.

Projektet innehåller tio automatiserade tester med JUnit och Mockito. Bland annat testas aktivering, avaktivering, felhantering, sökning och användning av ett mockat `Clock`-beroende.