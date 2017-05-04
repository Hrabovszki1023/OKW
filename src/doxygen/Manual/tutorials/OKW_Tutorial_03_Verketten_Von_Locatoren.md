# OKW Tutorial 3: Verketten von Locatoren

## Wozu die Verkettung von Lokatoren?
Eine Verkettung von Locatoren kann notwendig werden, wenn ein Kind-Objekt zusammen mit seinem Eltern-Objekt erkannt werden muss.  

So kann Eingabefeld wie `User`, aus dem Beispiel in [[OKW Tutorial 3: Der Locator|OKW-Tutorial-3:--Der-Locator]], in mehreren Fenstern vorkommen und erst in Verbindung mit dem Locator des Eltern-Objektes (=Fenster) kann eine Verwechselung mit einem anderen Objekt ausgeschlossen werden.

## DRY

Nun könnte ohne Verkettung jedes Kind-Objekt einfach die Erkennungseigenschaft des Eltern Objektes mit eingebaut bekommen.

Das zieht jedoch immer dann einen Wartungsaufwand nach sich, wenn die Objekt-Erkennungseigenschaft des Eltern-Objektes sich ändert: Dann müssen alle Kind-Objekte angepasst werden, die eine Objekterkennungseigenschaft des Eltern-Objektes besitzen.

Eine Anpassung kann sehr aufwendig werden und der Umstand, dass sich ein Fehler in der Objekt-Erkennungseigenschaft erst _während_ der Ausführung äussert, erschwert und verzögert die Wartung.

Dem DRY-Prinzip gemäß, liegt eine mögliche Lösung in der Verkettung von Locatoren. - Das wird nun hier in diesem Tutorial gezeigt.

## Verkettung von Eltern-Objekt Locator und Kind-Objekt Locator

Wir nehmen das Beispiel aus dem [[OKW Tutorial 3: Der Locator|OKW-Tutorial-3:--Der-Locator]] und verketten die Locatoren von _Eltern-Objekt_ und _Kind-Objekt_.

### Ziel

Das Ziel ist hier, dass der Locator des Eltern-Objektes `wp_login` dem der Locator des Kind-Objektes `User` vorangestellt wird:

* Eltern-Object Locator: `"//body/div[@id='login']/.."`
* Kind-Object Locator: `"//*[@id='user_login']"`

* **Ergebniss:** Soll `"//body/div[@id='login']/..//*[@id='user_login']"` ergeben

### Die Methoden `getLOCATOR()` und `getLocator()`
Zunächst müssen wir zwei Methoden kennen lernen:
1. Die Methode `getLOCATOR()` holt die Referenz auf den Locator werden.<br>
   **Hinweis:** Jede GUI-Adapter Klasse im Paket "se" besitzt ein Field vom Typ `OKWLocator`.
2. Die Methode 'getLocator()' (man beachte die GROSS und klein Schreibung!), die (ggf. den vollständig rekursiv aufgelösten) aktuellen Wert des Locators (hier als XPath) zurückgibt.

### Eltern-Objekt Locator
Wir lassen den Locator des Eltern-Objektes (`wp_login`) unverändert.
Dieser wird im Konstruktor des Klasse definiert:

```java
public wp_login()
{
    super("//body/div[@id='login']/..");
}
```

Entscheidend ist hier `super("//body/div[@id='login']/..");`. Hiermit wird in der _XPATH_ Wert
`"//body/div[@id='login']/.."` in der Locator Klasse des Fensters abgelegt.

### Kind-Objekt Locator
Wir erweitern nun den Locator des Kind-Objektes um den Locator des Eltern-Objektes:

`public SeInputText Username = new SeInputText("%1$s//*[@id='user_login']", this.getLOCATOR() );`

* Die _Referenz_ des Eltern-Objekt Locators wird im Konstruktor des Kind-Objektes übergeben.
* `%1$s` gibt an, an welcher Stelle, der _Wert_ des Eltern-Objekt Locators ein gesetzt werden soll. 

Das Ganze im Überblick:

```java
@OKW(FN="WP-Login")
public class wp_login extends SeBrowserChild
{

    @OKW (FN="Username")
    public SeInputText Username = new SeInputText("%1$s//*[@id='user_login']", this.getLOCATOR() );

    public wp_login()
    {
    	super("//body/div[@id='login']/..");
    }
}
```

Das war´s auch schon prinzipiell: Wenn der Locator der Klasse `wp-login"` geändert wird, dann bekommen die _Verketteten_ Kind-Objekte automatisch die Änderung mit.

### Hinweis 1

Dem Konstruktor können mehrere (prinzipiell beliebig viele) Locatoren mitgegeben werden. Der erste Parameter ist vom Typ `String` und enthält typischer weise die XPATH. Danach kommen 0 oder mehr LOCATOR-Referenzen. Der 1. LOCATOR Wert wird für `%1$s` ersetzt, der 2. LOCATOR wird für `%2$s` ersetzt usw.

### Hinweis 2.

Ein LOCATOR kann auch an mehreren Stellen eingesetzt werden.

```java
OKWLocator Locator_1 = new OKWLocator("L1");
OKWLocator Locator_2 = new OKWLocator("L2");
OKWLocator Locator = new OKWLocator("L2=%2$s, L1=%1$s, L2=%2$s, L1=%1$s", Locator_1, Locator_2);

assertEquals("L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator());
``` 


Damit sind wir mit diesem Tutorial auch schon fertig.
