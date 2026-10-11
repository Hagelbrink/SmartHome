Reflektionsuppgift:

1. Klassdesign

Klassen SmartDevice hanterar alla gemensamma fält och metoder för de olika enhetsklasserna som ärver ifrån SmartDevice. 
Anledningen är för att samla de gemensamma egenskaperna på ett ställe och undvika upprepning av kod.

Klassen SmartHome hanterar samlingen av enheter genom t ex att lägga till eller ta bort enheter.
Anledningen var för att klasserna ska ha tydliga ansvarsområden.


2. Arv eller komposition

Alla unika klasser för enheter (t ex Lamp) ärver ifrån klassen SmartDevice.

Då de alla har gemensamma egenskaper och metoder så var det ett effektivt sätt att lösa det på och gör också koden
lättare att vidarutveckla i framtiden.

En alternativ lösning hade varit att implementera alla gemensamma fält och metoder separat i varje enhetsklass. 
Det hade dock lett till mycket upprepad kod och gjort systemet svårare att underhålla och vidareutveckla.


3. Interface

I mitt projekt löser interface Activatable inte jättemycket egentligen eftersom alla enheter ärver metoderna från 
SmartDevice. Programmet hade fungerat utan interfacet så det fungerar främst som ett kontrakt för tillfället
som talar om att klasser som implementerar Activatable behöver ha metoderna activate() och deactivate().
Fördelen är att andra klasser skulle kunna implementera Activatable utan att behöva ärva från SmartDevice.


4. SOLID

Jag valde OCP. Det syns genom att jag har gjort så att enheterna ärver från SmartDevice. Så vill ma lägga till en ny
enhet så behöver den bara ärva av SmartDevice för att enkelt få med alla fält och metoder en enhet ska innehålla.
Det hjälper till att undvika att man behöver ändra befintlig kod när man lägger till nya enheter och minskar risken
för att nya ändringar orsakar problem i kod som redan fungerar.


5. Vidareutveckling

Jag tycker att min nuvarande design är bra förberedd för det eftersom jag har en tydlig struktur med uppdelat ansvar
i de olika paketen och klasserna. Eftersom alla enheter ärver från SmartDevice kan jag lägga till nya enheter utan
att behöva ändra hur SmartHome använder dem.


Ändra så att de olika enheterna får unika funktioner. 
Ifall det skulle ha blivit ett "riktigt" program så hade jag lagt till en meny också. Just nu visar programmet bara 
att allting fungerar men det ser inte så snyggt ut.


AI-användning

Ett exempel på när jag ändrade ett AI-genererat kodförslag var vid utskriften av en enhets status i Main. 
AI föreslog att jag skulle använda metoden .formatted() men jag valde att ändra till "text" + "text" istället. 
Mitt alternativ är nödvändigtvis inte bättre men jag tycker det är lättare att läsa och förstå eftersom det är ett
sätt jag är mer van vid att skriva det på.

AIs förslag:
IO.println("%s aktiv: %s".formatted(lamp.getName(), lamp.isActive()));

Min ändring:
IO.println(lamp.getName() + " - aktiv: " + lamp.isActive());