# OKW Tutorial 2: Calculator

2. Testfall am Beispiel Taschenrechner-Addition "1 + 1 = 2" in Schlüsselwort-Notation aufschreiben.

```java
   EN.TestcaseBegin( "Addition" );
   EN.StartApp( "Firefox" );
   EN.TypeKey( "URL", "http://Taschenrechner" );
 
   EN.SelectWindow( "Calculator" );
   EN.ClickOn( "1" );
   EN.ClickOn( "+" );
   EN.ClickOn( "1" );
   EN.ClickOn( "=" );
 
   EN VerifyValue( "Display", "2" )
```
3. Testfall funktioniert nicht: Die Objekt-Erkennung fehlt -> Frame erstellen:
   Testclasse im Package okw.frame anlegen.
 
   mit den Klassen
 
   "SeBrowserWindow" das Fenster des Calkulators definieren
   "SeInputButton" die Tasten definieren.
   "SeInputField" die Anzeige (Display) definieren.
 
4. Test Laufen lassen...