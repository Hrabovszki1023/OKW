@defgroup Tutorial Tutorials
@addtogroup <Tutorial>
@{ 
# OKW Tutorial 1
## OpenKeyWord `OKW_Tutorial`-Project mit Maven anlegen: "Hello Test" - Teil 1
 
### Vorraussetzung:

1. Java 8 (Version 1.8) ist auf dem Rechner installiert.
2. Maven (M2) ist auf dem Rechner installiert.
3. Eclipse ist installiert.

> **Tip:** Das Eclipse Paket **"Neon.2 Eclipse IDE for Java Developers"** enthält bereits alle benötigten Plugin´s wie Maven und einen Git-client. Dieses Paket kann von https://eclipse.org/downloads/eclipse-packages/ geladen werden.

> **momobee:** Idee in der Beschreibung eventuell Referenz auf andere Youtube Videos verweisen, die zeigen,
wie Maven und/oder/für Eclipse installiert wird.
 
### Reines OKW Testprojekt anlegen

#### Ein neues Maven Projekt anlegen.

```java
 StartApp("Eclipse");
 SelectWindow("Eclipse")
 SelectMenu("File->New->Project...");

 SelectWindow("New Project");
 Select( "Project Type", "Maven/Maven Project");
 ClickOn( "Next");

 Select("Create a Simple Project", "CHECKED");
 Select("Use default" Workspace set, "CHECKED");
 ClickOn( "Next");

 SetValue("Group Id", "de.openkeyword");
 SetValue("Artifact Id", "OKW_Tutorial");
 SetValue("Version", "${IGNORE}") // => den "*Snapshot"-wert übernehmen

 // optional
 SetValue("Name", "Add here Artifact Name");
 SetValue("Description", "Add here your Artifact Description");

 ClickOn( "Finish"); 
```

#### Entstandene pom.xml-Datei anpassen.

Dazu im `Project Explorer` die `pom.xml` öffnen:
```java
	DoubleClickOn("Project Explorer", "OKW_Tutorial/pom.xml)
```

##### 1. Java 8 einstellen
Die Java Version im ```maven-compiler-plugin``` Prüfen und ggf. einstellen. - Wir benötigen Java 1.8.
Im pom-Editor unten den Reiter `pom.xml` auswählen. Wenn das Projekt frisch angelegt wurde, dann sollte der folgende Abschnitt nach `project/description>` eingefügt werden. (einfach kopieren und unter `<description>` einfügen)
```xml
<build>
	<plugins>
		<plugin>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.2</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
	</plugins>
</build>
```

##### 2. OKW dependency eingeben
Nun auf den Reiter `Dependencies` gehen und dort

```java
SelectWindow("Dependency Properties")
SetValue( "Group Id", "de.openkeyword" )
SetValue( "Artifact Id", "se" )
SetValue( "Version", "0.0.23" )

// Alle anderen Werte werden nicht verändert.
// SetValue( "Classifier", "${IGNORE}" )
// SetValue( "Type", "${IGNORE}" )
// SetValue( "Scope", "${IGNORE}" )
// SetValue( "System Path", "${IGNORE}" )
// SetValue( "Optional", "${IGNORE}" )
```
> **Anmerkung 1:** `Version` ggf. anpassen.

> **Anmerkung 2:** Um OKW mit HTML/Selenium zu verwenden muss lediglich `se` eingebunden werden.
D.h. OKW `core` wird automatisch durch Maven miteingebunden.

Alternativ kann der Folgende block im Reiter `pom.xml` unter `dependencies` eingefügt werden:
```xml
	<dependency>
		<groupId>de.openkeyword</groupId>
		<artifactId>se</artifactId>
		<version>0.0.23</version>
	</dependency>
```

eingeben.

##### 3. JUnit 
JUnit wird wie OKW `se` eingebunden: Dazu müssen folgende Werte auf dem Tab Dependencies im pom-Editor eingeben:
Wie bei OKW ggf. die Versions Nummer aktualisieren:

```xml
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
```
### Update Projekt
```java
SelectContextMenu( "Project Explorer", "OKW_Tutorial", "Maven->Update Project..." )
```
> @momobee Maven Dependency zeigen: Benötigte Bibliotheken sind automatisch von Maven geladen worden.
 
> Projekt ist für die Erstellung von OKW-Testfälle vorbereitet.

@}