
/*
    ==============================================================================
    Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
    ============================================================================== 

    This file is part of OpenKeyWord.

    OpenKeyWord is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenKeyWord is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

    Diese Datei ist Teil von OpenKeyWord.

    OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
    der GNU General Public License, wie von der Free Software Foundation,
    Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
    veröffentlichten Version, weiterverbreiten und/oder modifizieren.

    OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
    OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
    Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
    Siehe die GNU General Public License für weitere Details.

    Sie sollten eine Kopie der GNU General Public License zusammen mit 
    OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
*/



    /// \brief
    /// \~german
    /// IOKW_State ist die Schnittstelle der OKW-Klasse.
    /// Die OKW-Klasse wird vom State-Design-Muster abgeleitet
    ///
    /// \~english
    /// IOKW_state is the Interface of OKW-Class.
    /// The OKW-Class is derived from the State-Design-Pattern
    /// 
package okw.core;

public interface IOKW_State
    {

		/// \~german
        /// \brief
        /// Markiert den Anfang eines neuen Testfalls. 
        ///
        /// Beschreibung des Handlungsablaufes
        /// 
		/// \note Alle Testfälle sollten mit BeginneTest afangen: 
		/// Dieses Schlüsselwort initialisiert OKW und versetz diesen in einen initialen Zustand, d.h. als wäre OKW neu gestartet.
        /// 
		/// \param fpsTestname Name oder Bezeichnung des Testfalls.
        ///
        /// \~english
        /// \brief
        /// Begins a test.
        ///
        /// Description of the allgorithm
        /// \note Keyword initalis
        /// 
		/// \param fpsTestname No explanation available 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18
        void BeginTest(String fpsTestname) throws Exception;

        /// \~german
        /// \brief
        /// Klickt auf das gegebene Objekt.
        /// 
        /// _Beispiel: Klicke auf das Objekt mit Namen "MeinObjekt":_<br/>
        /// \verbatim Klicke auf: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Clicks on given object.
        /// 
        /// _Example: Click on the object with the name "My Object":_<br/>
        /// \verbatim click on: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// _Example: Click on "My Object":_
        /// 
        /// \verbatim click on: "MyObject" \endverbatim
        /// \paramfpsFunctionalname Functional name of the object 
        /// 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18/jnic
        void ClickOn(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Klickt auf das gegebene Objekt.
        /// 
        /// _Beispiel: Klicke auf das Objekt mit Namen "MeinObjekt":_<br/>
        /// \verbatim Klicke auf: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsClickType Doppelklick" um mit Doppelklick auszuwählen, "Einfachklick" um mit einfachem Klick 
        ///
        /// \~english
        /// \brief
        /// Clicks on given object.
        /// 
        /// _Example: Click on the object with the name "My Object":_<br/>
        /// \verbatim click on: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsClickType Doubleclick" to select via doubleclick, "Singleclick" to select via singleclick (default) 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18
        void ClickOn(String FN, String fpsClickType) throws Exception;

        /// \~german
        /// \brief
        /// Beendet den Test, bzw. den Testfall.
        ///
        /// Beschreibung der Arbeitsweise.
        /// \note Zusätzliche Bemerkungen zum Schlüsselwort
        /// 
        ///
        /// \~english
        /// \brief
        /// Terminates the test respectively the testcase.
        ///
        /// Description of the mode of operation.
        /// \note Additional remark to the keyword
        /// 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18/jnic
        void EndTest() throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "LogCaption" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// No description for "LogCaption" available
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void LogCaption(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Protokolliert, ob das gegebene Objekt existiert.
        /// 
        /// _Beispiel: Protokolliert, ob das Objekt mit Namen "Mein Objekt" vorhanden ist:_<br/>
        /// \verbatim logge vorhanden: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs whether the given object is existing.
        /// 
        /// _Example: Logs whether the object with the name "My Object" is existing:_<br/>
        /// \verbatim log exists: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-18/jnic
        void LogExists(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den Fokus-Status des gegebenen Objekts.
        /// 
        /// _Beispiel: Protokolliert den Fokus-Zustand von "Mein Objekt":_<br/>
        /// \verbatim Logge hat Fokus: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs the focus status of the given object.
        /// 
        /// _Example: Logs the focus status of "My Object":_<br/>
        /// \verbatim LoghasFocus: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void LogHasFocus(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den Status des gegebenen Objekts.
        /// 
        /// _Beispiel: Protokolliert den Aktivzustand von "Mein Objekt":_<br/>
        /// \verbatim LoggeIstAktiv: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs the status of the given object.
        /// 
        /// _Example: Logs the active status of "My Object":_<br/>
        /// \verbatim LogIsActive: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void LogIsActive(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "LogLabel" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// No description for "LogLabel" available
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void LogLabel(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den markierten Text des gegebenen Objekts.
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs the marked text of the given object.
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void LogSelected(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den Wert der ausgewählten Zelle.
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Logs the value of the selected tablecell.
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->Beschreibung überprüfen
        void LogTablecellValue(String FN, String fpsCol, String fpsRow) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert die Kurzinfo zu einem Werkzeug des gegebenen Objekts.
        /// 
        /// _Beispiel: Protokolliert den Kurzinformationstext (Tooltip) von "Mein Objekt":_<br/>
        /// \verbatim LoggeTooltip: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs the Tooltip of the given object.
        /// 
        /// _Example: Logs the tooltip text of "My Object":_<br/>
        /// \verbatim LogToolip: "MyObject" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void LogTooltip(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den Standartwert eines Objekts.
        /// 
        /// Der Standardwert des Objektes (in den meisten Fällen ist dies der angezeigte Text)
        /// wird ausgelesen und in der aktuellen Dokumentationsdatei ausgegeben.<br/>
        /// _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten Wert "Django" entspricht:_<br/>
        /// \verbatim Prüfe Wert: "MeinObjekt", "Django" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Logs the standard value of an object.
        ///
        /// The standard value of the object (in most cases the visible text) is detected
        /// and returned in the actual log-file<br/>
        /// _Example: Check if the value (text) of object "MyObject" equals the expected value "Django":_<br/>
        /// \verbatim Verify Value: "MyObject", "Django" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void LogValue(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "MemorizeCaption" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// No description for "MemorizeCaptione" available
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void MemorizeCaption(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Merkt sich den aktuell existierenden Zustand des Objekts.
        ///
        /// Der Wert wird unter dem als Parameter übergebenen Schlüssel gespeichert.<br/>
        /// _Beispiel: Merkt sich den vorhandenen Zustand des Objektes "MeinObjekt" unter dem
        /// Schlüssel "Mein Schlüssel".:_<br/>
        /// \verbatim Merke Existiert: "MeinObjekt", "Mein Schlüssel" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// Memorizes the actual existing Status of the object.
        ///
        /// The value is stored under the key returned as parameter.<br/>
        /// _Example: Memorizes the existent state of the object "My Object" under the key "My Key":_<br/>
        /// \verbatim Memorize Exists: "MyObject", "MyKey" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void MemorizeExists(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "MemorizeHasFocus" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// No description for "MemorizeHasFocus" available
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void MemorizeHasFocus(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Merkt sich den Zustand des gegebenen Objekts.
        ///
        /// Der Wert wird unter dem als Parameter übergebenen Schlüssel gespeichert.<br/>
        /// _Beispiel: Merkt den Zustand des Objektes "MeinObjekt" unter dem Schlüssel "Mein Schlüssel":_<br/>
        /// \verbatim Merke Ist Aktiv: "MeinObjekt", "Mein Schlüssel" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// Memorizes the state of the given object.
        ///
        /// The value is stored under the key which is given as parameter.<br/>
        /// _Example Memorizes the object-state of MyObject under the key "MyKey":_<br/>
        /// \verbatim Memorize Is Active: "MyObject", "MyKey" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void MemorizeIsActive(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "MemorizeLabel" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// No description for "MemorizeLabel" available
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void MemorizeLabel(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Keine Beschreibung zu "MemorizeSelectedValue" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// No description for "MemorizeSelectedValue" available
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        /// \todo jnic-->keine Beschreibung vorhanden
        void MemorizeSelectedValue(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Merkt sich den Wert der gegebenen Zelle in der Tabelle.
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Memorizes the value of the given tablecell.
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void MemorizeTablecellValue(String FN, String fpsCol, String fpsRow, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Dokumentiert den Tooltip-Text (Kurzinformation) des gegebenen Objekts.
        /// 
        /// _Beispiel Dokumentiert den Tooltip-Text des Objektes "MeinObjekt":_<br/>
        /// \verbatim Logge Tooltip: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// Logs the tooltip-text of the given object.
        /// 
        /// _Example logs the tooltip text of the given object "my object"_<br/>
        /// \verbatim Logge Tooltip: "MeinObjekt" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void MemorizeTooltip(String FN, String fpsMemKeyName) throws Exception;

        /// \~german
        /// \brief
        /// Merkt sich den Standartwert eines Objekts.
        ///
        /// Der Standartwert des Objektes (in den meisten Fällen ist dies der angezeigte Text)
        /// wird ausgelesen und intern unter dem übergebenen Schlüssel gespeichert. Der Wert kann
        /// danach mit dem Schlüsselwort XXXXX wieder ausgelesen werden.<br/>
        /// _Beispiel: Legt sich den Wert (Text) des Objekts "MeinObjekt" unter dem Schlüssel "MeinSchlüssel" ab:_<br/>
        /// \verbatim Merke Wert: "MeinObjekt", "MeinSchlüssel" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsMemKeyName Name des Schlüssels 
        ///
        /// \~english
        /// \brief
        /// Memorizes the standard value of an object.
        ///
        /// The standard value of the object -mostly this is the displayed text- is picked out
        /// and stored under the internal given key. The value can read out with the keyword XXXXX after it.<br/>
        /// _Example Memorizes the value (text) of object "MyObject" under the key "MyKey":_<br/>
        /// \verbatim Memorize the value (text) of object "MyObject" under the key "MyKey" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsMemKeyName Name of the key 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void MemorizeValue(String FN, String fpsMemKeyName) throws Exception;
        
        /// \~german
        /// \brief
        /// Auswahl aller Zeilen einer Liste/Tabelle, welche die gegebenen Daten enthalten.
        ///
        /// Tabellenspalten werden zeilenweise zusammengefasst, so dass Listen und Tabellen identisch verarbeitet
        ///	werden. Die erste Zeile, welche die gegebenen Daten enthält, wird ausgewählt. Die
        ///	Zeile wird über einen einfachen Klick angewählt. Die Übergabe des zusätzlichen Parameters
        ///	"Doppelklick" führt zur Verwendung eines Doppelklicks.
        /// Die {HSEP}-Konstante kann verwendet werden, wenn definierte Werte in mehreren
        /// Spalten gefordert sind.<br/>
        /// _Beispiel 1: Wähle alle Zeilen aus, die den Text "Wert" enthalten:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert" \endverbatim <br/>
        /// _Beispiel 2: Wähle alle Zeilen aus, die mit dem Text "Wert1" beginnen und
        /// deren zweite Spalte den Text "Wert2" enthält:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert1{HSEP}, Wert2" \endverbatim <br/>
        /// _Beispiel 3: Wähle alle Zeilen aus, die mit dem Text "Wert1" beginnen und
        /// deren dritte Spalte den Text "Wert2" enthält:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert1{HSEP}{HSEP}Wert2" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        ///
        /// \~english
        /// \brief
        /// Select all rows in a list/chart, which contain the given data.
        ///
        /// Chart columns are merged row by row to process lists and charts identical.
        ///	The first row which contains the given data will be selected. The row is selected by a single click.
        /// The delivery of an additional parameter "Doubleclick" leads to the use of a doubleclick.
        /// The {HSEP}-constant can be used, if defined values in multiple columns are required.<br/>
        /// _Example #1: Select all rows which contain the text "Value":_<br/>
        /// \verbatim Select: "MyTable", "Value" \endverbatim <br/>
        /// _Example #2: Select all rows which contain the text "Value1" in the first column,
        /// followed by the text "Value2" in any of the remaining columns:_ <br/>
        /// \verbatim Select: "MyTable", "Value1{HSEP}Value2" \endverbatim <br/>
        /// _Example #3: Select all rows which contain the text "Value1", followed by any (or no)
        /// text in the first column, followed by an empty column, followed by the text "Value2"
        /// in the third  column:_ <br/>
        /// \verbatim Select: "MyTable", "Value1{HSEP}{HSEP}Value2" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19
        void Select(String FN, String Val) throws Exception;

        /// \~german
        /// \brief
        /// Auswahl aller Zeilen einer Liste/Tabelle, welche die gegebenen Daten enthalten.
        ///
        /// Tabellenspalten werden zeilenweise zusammengefasst, so dass Listen und Tabellen identisch verarbeitet
        ///	werden. Die erste Zeile, welche die gegebenen Daten enthält, wird ausgewählt. Die
        ///	Zeile wird über einen einfachen Klick angewählt. Die Übergabe des zusätzlichen Parameters
        ///	"Doppelklick" führt zur Verwendung eines Doppelklicks.
        /// Die {HSEP}-Konstante kann verwendet werden, wenn definierte Werte in mehreren Spalten gefordert sind.<br/>
        /// _Beispiel 1: Wähle alle Zeilen aus, die den Text "Wert" enthalten:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert" \endverbatim <br/>
        /// _Beispiel 2: Wähle alle Zeilen aus, die mit dem Text "Wert1" beginnen und
        /// deren zweite Spalte den Text "Wert2" enthält:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert1{HSEP}, Wert2" \endverbatim <br/>
        /// _Beispiel 3: Wähle alle Zeilen aus, die mit dem Text "Wert1" beginnen und
        /// deren dritte Spalte den Text "Wert2" enthält:_<br/>
        /// \verbatim Wähle aus: "MeineTabelle", "Wert1{HSEP}{HSEP}Wert2" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        /// \param fpsClickType Doppelklick" um mit Doppelklick,
        /// "Einfachklick" um mit einfachem Klick auszuwählen. 
        ///
        /// \~english
        /// \brief
        /// Select all rows in a list/chart, which contain the given data.
        ///
        /// Chart columns are merged row by row to process lists and charts identical.
        ///	The first row which contains the given data will be selected. The row is selected by a single click.
        /// The delivery of an additional parameter "Doubleclick" leads to the use of a doubleclick.
        /// The {HSEP}-constant can be used, if defined values in multiple columns are required.<br/>
        /// _Example #1: Select all rows which contain the text "Value":_<br/>
        /// \verbatim Select: "MyTable", "Value" \endverbatim <br/>
        /// _Example #2: Select all rows which contain the text "Value1" in the first column,
        /// followed by the text "Value2" in any of the remaining columns:_ <br/>
        /// \verbatim Select: "MyTable", "Value1{HSEP}Value2" \endverbatim <br/>
        /// _Example #3: Select all rows which contain the text "Value1", followed by any (or no)
        /// text in the first column, followed by an empty column, followed by the text "Value2"
        /// in the third  column:_ <br/>
        /// \verbatim Select: "MyTable", "Value1{HSEP}{HSEP}Value2" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        /// \param fpsClickType Doubleclick" to select via doubleclick, "Singleclick" to select via singleclick (default) 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void Select(String FN, String Val, String fpsClickType) throws Exception;

        /// \~german
        /// \brief
        /// Wählt den gegebenen Menüeintrag aus
        /// 
        /// _Beispiel: Wähle Menüeintrag mit Namen "MeinMenü":_<br/>
        /// \verbatim Wähle Aus Menü: "MeinMenü" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Selects the given menu item.
        /// 
        /// _Example Select menu item with name "MyMenu":_ <br/>
        /// \verbatim Select menu: "MyMenu" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void SelectMenu(String FN) throws Exception;

        /// \~german
        /// \brief
        /// Wählt den gegebenen Menüeintrag aus.
        /// 
        /// _Beispiel: Wähle Menüeintrag mit Namen "MeinMenü":_<br/>
        /// \verbatim Wähle Aus Menü: "MeinMenü" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        ///
        /// \~english
        /// \brief
        /// Selects the given menu item.
        /// 
        /// _Example Select menu item with name "MyMenu":_ <br/>
        /// \verbatim Select menu: "MyMenu" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void SelectMenu(String FN, String Val) throws Exception;

        /// \~german
        /// \brief
        /// Wählt die gegebene Tabellenzelle aus.
        ///
        /// Die Parameter für die Spalten- und Zeilenpositionen werden immer als Strings eingegeben.
        ///	Wenn ein Positionsparameter mit einem Hash (#) beginnt, dann wird er als Zahl interpretiert, z.B. "#1".
        ///	Wenn das Hashzeichen als Text interpretiert werden soll, dann muss dies über einen vorangestellten
        ///	Backslash gekennzeichnet werden, z.B. "#1 Text mit vorangestellter Nummer".
        /// 
        ///	Die Kopfzeile der Tabelle wird über den Index "0" angesprochen. Die erste Datenzeile beginnt
        /// mit dem Index 1. Für Tabellen mit mehrzeiligen Kopfzeilen kann im Objekt selbst der Offset
        /// zur ersten Datenzeile festgelegt werden. Der Spaltenindex beginnt mit der Nummer 1. <br/>
        /// _Beispiel 1: Auswahl der Zelle in Spalte 2 und Zeile 5:_ <br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "#2", "#5" \endverbatim
        /// _Beispiel 2: Auswahl der Zelle in erster Spalte mit Text "Toni" und Zeile mit dem Namen "Tester":_ <br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "Toni", "Tester" \endverbatim
        /// _Beispiel 3: Auswahl der Zelle in erster Spalte mit Text "Toni" und Zeile 3:_<br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "Toni", "#3" \endverbatim
        /// _Beispiel 4: Auswahl der Zelle in Spalte 1 und erster Zeile mit Text "42":_<br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "#1", "42" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Selects the given table cell.
        ///
        /// The column and row positions are always entered as strings.
        /// If such a parameter is starting with a hash (#) the String is interpreted as an index number, e.g. "#1").
        /// If a hash sign should be interpreted as text it must signed with a backslash,
        /// e.g. "\#1 text with leading number").
        /// 
        /// The header row is addressed with the index "0". The first data row starts with the index 1.
        /// For tables with multiline headers the offset to the first data row can be set
        /// The column index starts with the number 1.<br/>
        /// _Example #1: Select cell at first column with text "Toni" and row with number 3:_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "Toni", "#3" \endverbatim
        /// _Example #2: Select cell at column with number 1 and row with name "Address":_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "Address" \endverbatim
        /// _Example #3: Select cell at column number 1 and row 1:_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "#1" \endverbatim
        /// _Example #4: Select cell at col number 1 and first row with text "42":_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "42" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void SelectTablecell(String FN, String fpsCol, String fpsRow) throws Exception;

        /// \~german
        /// \brief
        /// Wählt die gegebene Tabellenzelle aus.
        ///
        /// Die Parameter für die Spalten- und Zeilenpositionen werden immer als Strings eingegeben.
        ///	Wenn ein Positionsparameter mit einem Hash (#) beginnt, dann wird er als Zahl interpretiert, z.B. "#1".
        ///	Wenn das Hashzeichen als Text interpretiert werden soll, dann muss dies über einen vorangestellten
        ///	Backslash gekennzeichnet werden, z.B. "#1 Text mit vorangestellter Nummer".
        ///	Die Kopfzeile der Tabelle wird über den Index "0" angesprochen. Die erste Datenzeile beginnt
        /// mit dem Index 1. Für Tabellen mit mehrzeiligen Kopfzeilen kann im Objekt selbst der Offset
        /// zur ersten Datenzeile festgelegt werden. Der Spaltenindex beginnt mit der Nummer 1.<br/>
        /// _Beispiel 1: Auswahl der Zelle in Spalte 2 und Zeile 5:_ <br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "#2", "#5" \endverbatim
        /// _Beispiel 2: Auswahl der Zelle in erster Spalte mit Text "Toni" und Zeile mit dem Namen "Tester":_ <br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "Toni", "Tester" \endverbatim
        /// _Beispiel 3: Auswahl der Zelle in erster Spalte mit Text "Toni" und Zeile 3:_<br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "Toni", "#3" \endverbatim
        /// _Beispiel 4: Auswahl der Zelle in Spalte 1 und erster Zeile mit Text "42":_<br/>
        /// \verbatim Wähle aus Tabellenzelle: "MeineTabelle", "#1", "42" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param fpsClickType Doppelklick" um mit Doppelklick auszuwählen, "Einfachklick" um mit einfachem Klick 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Selects the given table cell.
        ///
        /// The column and row positions are always entered as strings.
        /// If such a parameter is starting with a hash (#) the String is interpreted as an index number, e.g. "#1").
        /// If a hash sign should be interpreted as text it must signed with a backslash,
        /// e.g. "\#1 text with leading number").
        /// The header row is addressed with the index "0". The first data row starts with the index 1.
        /// For tables with multiline headers the offset to the first data row can be set
        /// The column index starts with the number 1.<br/>
        /// _Example #1: Select cell at first column with text "Toni" and row with number 3:_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "Toni", "#3" \endverbatim
        /// _Example #2: Select cell at column with number 1 and row with name "Address":_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "Address" \endverbatim
        /// _Example #3: Select cell at column number 1 and row 1:_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "#1" \endverbatim
        /// _Example #4: Select cell at col number 1 and first row with text "42":_ <br/>
        /// \verbatim Select Tablecell: "MyTable", "#1", "42" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param fpsClickType Doubleclick" to select via doubleclick, "Singleclick" to select via singleclick (default) 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void SelectTablecell(String FN, String fpsCol, String fpsRow, String fpsClickType) throws Exception;

        /// \~german
        /// \brief
        /// Setzt den Kontext auf das gegebene Fenster.
        /// 
        /// Das Fenster wird aktiviert und in den Vordergrund geholt.
        /// Alle nachfolgen GUI-Schlüssleworte (z.B. Gib ein) beziehen sich auf das gegeben Fenster.
        /// Der Kontext wechselt erst mit dem nächsten _Wähle aus Fenster_ auf ein anderes Fenster.
        /// 
        /// \todo zh: jnic die englische Beschreibung für Selectwindow anpassen.
        /// 
        /// _Beispiel: Auswahl des Fensters mit dem Namen "MeinFenster":_ <br/>
        /// \verbatim Wähle aus Fenster: "MeinFenster" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        ///
        /// \~english
        /// \brief
        /// Setting the context for the given window and ensuring that the window
        /// is active and in the foreground.
        /// 
        /// _Example: Select window with name "MyWindow":_ <br/>
        /// \verbatim Select Window: "MyWindow" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-19/jnic
        void SelectWindow(String FN) throws Exception;

        
        /** \~german
         *  \brief
         *  Ruft die Sequenz eines Fensters auf.
         *  
         *  Sequenzen sind je Fenster definiert und haben innerhalb des Fenster einen eindeutigen Sequenznamen.
         *  Einzugebende Datensätze werden mit der Sequenz-ID referenziert.
         *  
         *  _Beispiel: Aufrufen der Sequenz _Anmelden_ des Fensters _Login_ mit dem Datensatz _Administrator_:_ <br/>
         *  \verbatim Sequenz: "Login", "Anmelden" = "Administrator" \endverbatim
         *  
         *  \param FN Funktionaler Name des Fensterobjekts, in der die Sequenz definiert ist. 
         *  \param fpsSequenceName Name der Sequenz, die aufgerufen werden soll. 
         *  \param SEQ_ID Sequenz ID des Datensatzes, die als Eingabe verwendet werden soll. 
         * 
         *  \~english
         *  \brief
         *  Calls the sequence of the window.
         *  
         *  Sequences are defined per window and have a unique sequence name within the window.
         *  Entered records are referenced with the sequence ID.
         *  
         *  _Example: Calling the sequence _Login_ of the window _Login_ with the record _Administrator_:_ <br/>
         *  \verbatim Sequence: "Login", "Login" = "Administrator" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param fpsSequenceName No explanation available 
         *  \param SEQ_ID No explanation available 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
         *  \todo jnic-->Beschreibung erledigt 2014-10-26
         */
        void Sequence(String FN, String fpsSequenceName, String SEQ_ID) throws Exception;


        /**
         *  \~german
         *  \brief
         *  Setzt den Fokus auf das gegebene Fensterobjekt.
         *  
         *  \param FN Funktionaler Name des Objekts 
         * 
         *  \~english
         *  \brief
         *  Setting the focus to the given window object.
         *  
         *  \param FN Functional name of the object 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        void SetFocus(String FN) throws Exception;


        /// \~german
        /// \brief
        /// Interne Methode zum setzen der Sprache für die sprachabhängigen Ausgaben der Dokumentation (Log).
        /// 
        /// Die auswählbaren Sprachen sind in OKWLanguage::cvLsLanguagesImplemented
        /// definiert und werden mit dieser Liste abgeprüft.
        /// 
        /// \param Language Sprache die ausgewählt werden soll, z.B. mit "de"  
        ///
        /// \~english
        /// \brief
        /// Internal method to set the language of the language depending outputs of the log documentation.
        /// 
        /// The choosable languages are defined in OKWLanguage::cvLsLanguagesImplemented
		/// and are prooved with this list.
		/// 
        /// \param Language Select "en" 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        /// \todo jnic-->Beschreibung erledigt 2014-10-26
        void SetLanguage(String Language);

        /**
         *  \~german
         *  \brief
         *  Setzt den Wert des gegebenen Fensterobjekts auf den gegebenen Wert.
         * 
         *  Der Wert wird nicht durch die Simulation einzelner Tastatureingaben
         *  eingegeben, sondern direkt ins Objekte geschrieben:<br/>
         *  Sollte z.B. in einem TextFeld bereits ein Wert vorhanden sein,
		 *  dann wird dieser mit _fpsValue_ überschrieben.
         *  
         *  __Beispiel:__ Setze den Wert des Objekts "MeinObjekt" auf "Hallo": <br/>
         *  \verbatim Setze Wert: "Name", "Zoltan" \endverbatim
         *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param Val Sich ergebender Wert 
         * 
         *  \~english
         *  \brief
         *  Setting the value of the given window object to the given value.
		 * 
         *  The input is not working with the simulation of single keyboard inputs,
		 *  but with High-Level Setter-Methods of the objects:<br/>
         *  Inputs of the object are written over with "Val".
		 * 
         *  _Example: Set the value of the objekt "MyWindow" to "Hello":_ <br/>
         *  \verbatim Set Value: "Name", "Zoltan" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param Val Resulting value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
        /// \date 2014-09-21
		 */
        void SetValue(String FN, String Val) throws Exception;
        
        /// \~german
        /// \brief
        /// Startet die gegebene Anwendung.
        /// 
        /// _Beispiel: Befehl zum Starten der Anwendung "InternetExplorer":_ <br/>
        /// \verbatim Starte Anwendung: "InternetExplorer"\endverbatim
        /// 
        /// \remark Die Methode "StartApp()" muss in der Klasse "fpsApplikatioName"
        /// implementiert werden. Der fachliche Bezeichner muss nicht zwangsläufing
        /// mit dem Namen der Exe-Datei übereinstimmen: Hier findet ein Mapping/Zuordnung
        ///         zwischen fachlichen Bezeichner und der aufzurufenden "*.exe" statt.<br/>
        /// Ein Beispiel, wie eine Ausimplementierung aussehen kann, ist 
		/// in SeInternetExplorerApp.StartApp zu finden.
        /// 
        /// \param fpsApplicationName Der fachliche Name der Anwendung. 
        ///
        /// \~english
        /// \brief
        /// Starts the given application.
        /// 
        /// _Example: Order to start the application "InternetExplorer":_ <br/>
        /// \verbatim Start Application: "InternetExplorer"\endverbatim
        /// 
        /// \remark Te method "StartApp()" must be implemented in the class "fpsApplikatioName".
        /// The technical identifier must not inevitably be identical to the name of 
        /// the exe file: here we hav e a mapping between the technical identifier and the invoked "*.exe"<br/>
        /// An example how a full Implementation can look at, is to be find in SeInternetExplorerApp.StartApp
		/// 
        /// \param fpsApplicationName No explanation available 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
		/// \todo jnic-->Beschreibung angepasst 2014-10-26
        void StartApp(String fpsApplicationName) throws Exception;

        /// \~german
        /// \brief
        /// Beendet eine gegebene Anwendung.
        /// 
        /// _Beispiel: Befehl zum Starten der Anwendung "InternetExplorer":_ <br/>
        /// \verbatim Beende Anwendung: "InternetExplorer"\endverbatim
        /// 
        /// \remark Die Methode "StopApp()" muss in der Klasse "fpsApplikatioName"
        /// implementiert werden. Das Framework kann nicht wissen, wie eine spezielle Anwendung
        /// beendet werden muss. Das muss projektspezifisch ausimplementiert werden.<br/>
        /// Ein Beispiel, wie eine Ausimplementierung aussehen kann, ist in SeInternetExplorerApp.StopApp zu finden.
        /// 
        /// \param fpsApplicationName Derf achliche Name der Anwendung 
        ///
        /// \~english
        /// \brief
        /// Ends a given application.
		/// 
        /// _Example: Order to start the application "InternetExplorer":_ <br/>
        /// \verbatim End Application: "InternetExplorer"\endverbatim
        /// 
        /// \remark The method "StopApp()" must be implemented in the class "fpsApplikatioName"
        /// The framework is not able to know, how a specific application is to be closed.
        /// The must be fully implemented specific to the project.<br/>
        /// An example, how the full implementation can look at is to be find at SeInternetExplorerApp.StopApp.
        /// 
        /// \param fpsApplicationName The technical name of the application 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
		/// todo jnic-->Beschreibung angepasst 2014-10-26
        void StopApp(String fpsApplicationName) throws Exception;
        
        /// \~german
        /// \brief
        /// Tastatureingaben von Daten in das aktive Fensterobjekt.
        ///
        /// Die Daten werden als Tastureingaben an das Kindobjekt des aktiven Fenters
        /// gesendet. Dies ermöglicht die Verwendung von Hotkeys und Funktionstasten als
        /// Eingabedaten. Wenn mit Hilfe des Wertseparators {SEP} mehrere Werte im Parameter
        /// übergeben werden, dann werden alle Werte als Tastatureingabe an das Fensterobjekt
        /// gesendet, getrennt durch einen Zeilenumbruch.
        ///
        /// __Beispiel "Einfache Eingabe":__<br/>
        /// \verbatim Gib ein: "MeinFensterObjekt", "EingabeWert" \endverbatim
        ///
        /// __Beispiel "Eingabe einer Konstanten":__<br/>
        /// \verbatim Gib ein: "MeinFensterObjekt", "{F2}" \endverbatim
        ///
        /// __Beispiel "Eingabe mehrerer Werte":__<br/>
        ///
        /// \verbatim Gib ein: "MeinFensterObjekt", "Eingabewert1{SEP}Eingabewert2" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        ///
        /// \~english
        /// \brief
        /// Keyboard inputs of data in the active windows object.
        ///
        /// The data are sent as keyboard inputs to the child object of the active window.
        /// This enables the use of hot keys and function keys as input data.
        /// If with help of the valueseparator (SEP) multiple values are passed in the parameter,
        /// ​​then all values ​​are sent as keyboard input to the window object, separated by a line break.
        ///
        /// __Example: "Simple Input":__<br/>
        /// \verbatim Type Key: "MyWindowObjekt", "InputValue" \endverbatim
        ///
        /// __Example: "Input of constant value":__<br/>
        /// \verbatim Type Key: "MainWindow", "{F2}" \endverbatim
        ///
        /// __Example: "Input of more than one value":__<br/>
        /// \verbatim Type Key: "MyWindowObjekt", "InputValue1{SEP}InputValue2" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void TypeKey(String FN, String Val) throws Exception;

        /// \~german
        /// \brief
        /// Eingabe von Daten in eine gegebene Tabellenzelle über die Tastatur.
        ///
        /// Die Daten werden als Tastureingaben an die gegebene Zelle einer Tabelle gesendet.
        /// Dies ermöglicht die Verwendung von Hotkeys (Schnellzugang)und Funktionstasten als Eingabedaten.
        /// Die Parameter für die Spalten- und Zeilenpositionen werden immer als Strings eingegeben.
        ///	Wenn ein Positionsparameter mit einem Hash (#) beginnt, dann wird er als Zahl interpretiert, z.B. "#1".
        ///	Wenn das Hashzeichen als Text interpretiert werden soll, dann muss dies über einen vorangestellten
        ///	Backslash gekennzeichnet werden, z.B. "#1 Text mit vorangestellter Nummer".
        ///	Die Kopfzeile der Tabelle wird über den Index "0" angesprochen.
        /// Die erste Datenzeile beginnt mit dem Index 1.
        /// Für Tabellen mit mehrzeiligen Kopfzeilen kann im Objekt selbst der Offset zur ersten Datenzeile festgelegt werden.
        ///	Der Spaltenindex beginnt mit der Nummer 1.<br/>
        /// _Beispiel 1: Einfache Eingabe in Zelle an Spalte 2 und Zeile 5:_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", 2, 5, "Eingabewert" \endverbatim
        /// _Beispiel 2: Einfache Eingabe in Zelle an erster Spalte mit Text "Toni"
        /// und Zeile mit dem Namen "Tester":_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", "Toni", "Tester", "Eingabewert" \endverbatim
        /// _Beispiel 3: Einfache Eingabe in Zelle an erster Spalte mit Text "Toni" und Zeile 3:_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle": "MeineTabelle", "Toni", 3, "Eingabewert" \endverbatim
        /// _Beispiel 4: Einfache Eingabe in Zelle an Spalte 1 und Zeile mit Namen "Adresse":_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", 1, "Adresse", "Eingabewert" \endverbatim
        /// _Beispiel 5: Eingabe der Konstanten "F2" in Zelle an Spalte 1 und Zeile 1:_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", 1, 1, "{F2}" \endverbatim
        /// _Beispiel 6: Eingabe mehrerer Werte in Zelle an erster Spalte mit Test "Ernie" und Zeile 3:_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", "Ernie", 3, "Wer1{SEP}Wert2" \endverbatim
        /// _Beispiel 7: Eingabe des Wertes "HiHo" in Zelle an Spalte 1 und erster Zeile mit Text "42":_ <br/>
        /// \verbatim Gib ein Tabellenzelle: "MeineTabelle", "#1", "42", "HiHo" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Input of date to a given tablecell by the keyboard.
        ///
        /// The data are sent as keyboard inputs to the given tablecell.
        /// This ensures the use of hotkeys and functional tabs as input data.
        /// The parameters of the row and column positions are always set as strings.
        /// If such a parameter is starting with a hash (#) the String is interpreted as an index number, e.g. "#1").
        /// If a hash sign should be interpreted as text it must signed with a backslash,
        /// e.g. "\#1 text with leading number").
        /// The header row is adressed with the index "0". The first data row starts with the index 1.
        /// For tables with multiline headers the offset to the first data row can be set
        /// The column index starts with the number 1.<br/>
        /// _Example #1: Simple Input in cell at column 2 and row 5:_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", 2, 5, "InputValue" \endverbatim
        /// _Example #2: Simple Input in cell at first column with text "Toni" and row with name "Tester":_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", "Toni", "Tester", "InputValue" \endverbatim
        /// _Example #3: Simple Input in cell at first column with text "Toni" and row with number 3:_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", "Toni", 3, "InputValue" \endverbatim
        /// _Example #4: Simple Input in cell at column with number 1 and row with name "Address":_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", 1, "Address", "InputValue" \endverbatim
        /// _Example #5: Input of constant value named "F2" in cell at column number 1 and row 1:_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", 1, 1, "{F2}" \endverbatim
        /// _Example #6: Input of more than one value in cell at first column with
        /// text "Ernie" and third row:_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", "Ernie", 3, "InputValue1{SEP}InputValue2" \endverbatim
        /// _Example #7: Input of value "Hiho" into cell at column number 1 and first row with text "42":_ <br/>
        /// \verbatim Type Key Tablecell: "MyTable", "#1", "42", "HiHo" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void TypeKeyTablecell(String FN, String fpsCol, String fpsRow, String Val) throws Exception;

        /// \~german
        /// \brief
        /// Tastatureingabe in ein bestimmtes Fensterobjekt.
        ///
        /// Die Daten werden als Tastureingaben an das Fensterobjekt gesendet.
        /// Dies ermöglicht die Verwendung von Hotkeys (Schnellzugang) und Funktionstasten als Eingabedaten.
        /// Mehrere Werte können mit Hilfe der Konstanten {SEP} eingegeben werden (siehe Beispiele).
        /// Die Werte werden dann bei der Eingabe durch Zeilenumbrüche getrennt.<br/>
        /// _Beispiel 1: Einfache Eingabe:_ <br/>
        /// \verbatim Gib ein Fenster: "MeinFensterObjekt", "EingabeWert" \endverbatim
        /// _Beispiel 2: Eingabe einer Konstanten:_ <br/>
        /// \verbatim Gib ein Fenster: "MeinFensterObjekt", "{F2}" \endverbatim
        /// _Beispiel 3: Eingabe mehrerer Werte:_Beispiel
        /// \verbatim Gib ein Fenster: "MeinFensterObjekt", "Eingabewert1{SEP}Eingabewert2" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param Val Sich ergebender Wert 
        ///
        /// \~english
        /// \brief
        /// Keyboard input to a particular window object.
        ///
        /// The data will be sent as keyboard inputs to the window object.
        /// This ensures the use of hotkeys an functional keys as input data.
        /// Multiple values can be given as input by help of the constant {SEP} (see examples).
        /// The values are divided with tabstops with the input.<br/>
        /// _Example #1: Simple Input:_ <br/>
        /// \verbatim Type Key Window: "MyWindowObjekt", "InputValue" \endverbatim
        /// _Example #2: Input of constant value:_ <br/>
        /// \verbatim Type Key Window: "MainWindow", "{F2}" \endverbatim
        /// _Example #3: Input of more than one value:_ <br/>
        /// \verbatim Type Key Window: "MyWindowObjekt", "InputValue1{SEP}InputValue2" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param Val Resulting value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void TypeKeyWindow(String FN, String Val) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Überprüft die Überschrift des Objektes.
         *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert 
         * 
         *  \~english
         *  \brief
         *  No description for "VerifyCaption" available
         *  
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
         *  \todo jnic-->keine Beschreibung vorhanden
         */
        void VerifyCaption(String FN, String ExpVal) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Überprüft die Überschrift des Objektes.
         *  Der Sollwert wird als Wildcard-Match angegeben.
         *  
         *  Folgende Platzhalter sind möglich:
         *  * "?" - genau ein beliebiges Zeichen wird Maskiert
         *  * "*" - (0-n) beliebiges Zeichen wird Maskiert
         *  * "#" - genau eine Ziffer [0..9] kann maskiert werden
         *  _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten
         *  Wert "\\.jango" entspricht:_ <br/>
         *  
        *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert 
         * 
         *  \~english
         *  \brief
         *  No description for "VerifyCaption" available
         *  
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
         *  \todo jnic-->keine Beschreibung vorhanden
         */
        void VerifyCaptionWCM(String FN, String ExpVal) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Überprüft die Überschrift des Objektes.
         *  Reguläre aus drücke als sollwert sind erlaubt.
         *  
         *  _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten
         *  Wert "\\.jango" entspricht:_ <br/>
         *  
         *  \verbatim PrüfeWertREGX: "MeinObjekt", "$Django" \endverbatim
         *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert 
         * 
         *  \~english
         *  \brief
         *  No description for "VerifyCaption" available
         *  
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
         *  \todo jnic-->keine Beschreibung vorhanden
         */
        void VerifyCaptionREGX(String FN, String ExpVal) throws Exception;

        /// \~german
        /// \brief
        /// Prüft, ob das gegebene Objekt existiert.<br/>
        /// _Beispiel 1: Prüfe, ob das Objekt "MeinObjekt" existiert:_ <br/>
        /// \verbatim Prüfe Existiert: "MeinObjekt", "JA" \endverbatim
        /// _Beispiel 2: Prüfe, ob das Objekt "MeinObjekt" nicht existiert: <br/>
        /// \verbatim Prüfe Existiert: "MeinObjekt", "NEIN" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param ExpVal Erwarteter Wert 
        ///
        /// \~english
        /// \brief
        /// Checks the existence of the given object.<br/>
        /// _Example #1: Check if the object MyObject exists:_ <br/>
        /// \verbatim Verify Exists: "MyObject", "YES" \endverbatim
        /// _Example #2: Check if the object MyObject does not exist:_ <br/>
        /// \verbatim Verify Exists: "MyObject", "NO" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param ExpVal Expected value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void VerifyExists(String FN, String ExpVal) throws Exception;

        
        /**
         *  \~german
         *  \brief
         *  Vergleicht den Fokus-Zustand des gegebenen Objekts mit dem erwarteten Wert.
         *  
         *  _Beispiel 1: Prüfe, ob das Objekt "MeinObjekt" den Fokus besitzt:_ <br/>
         *  \verbatim Prüfe Hat Fokus: "MeinObjekt", "JA" \endverbatim
         *  _Beispiel 2: Prüfe, ob das Objekt "MeinObjekt" den Fokus NICHT besitzt:_ <br/>
         *  \verbatim Prüfe Hat Fokus: "MeinObjekt", "NEIN" \endverbatim
         *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert. Erlaubte Werte sind: "JA", "NEIN" und "IGNORIEREN". 
         * 
         *  \~english
         *  \brief
         *  Compares the focus status of the given object with the expected value.
         *  
         *  _Example #1: Verify if the object MyObject has the focus:_ <br/>
         *  \verbatim Verify Has Focus: "MyObject", "YES" \endverbatim
         *  _Example #2: Verify if the object MyObject has NOT the focus:_ <br/>
         *  \verbatim Verify Has Focus: "MyObject", "NO" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value. Following values are Allowed here: "YES, "NO", and "IGNORE".  
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
         */
        void VerifyHasFocus(String FN, String ExpVal) throws Exception;

        
        /**
         *  \~german
         *  \brief
         *  Vergleicht den Fokus-Status des gegebenen Objekts mit dem erwarteten Wert.
         * 
         *  _Beispiel: Prüfe, ob das Objekt "MeinObjekt" sich im Status "aktiv" befindet:_ <br/>
         *  \verbatim Prüfe Ist Aktiv: "MeinObjekt", "JA" \endverbatim
         * 
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert. Erlaubte Werte sind: "JA", "NEIN" und "IGNORIEREN". 
         *
         *  \~english
         *  \brief
         *  Compares the focus status of the given object with the expected value.
         * 
         *  _Example: Verify if the object MyObject is in the state "active":_ <br/>
         *  \verbatim Verify Is Active: "MyObject", "YES" \endverbatim
         * 
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value. Following values are Allowed here: "YES, "NO", and "IGNORE". 
         *
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21/jnic
        */
        void VerifyIsActive(String FN, String ExpVal) throws Exception;

        
        /// \~german
        /// \brief
        /// Keine Beschreibung zu "VerifyLabel" verfügbar
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param ExpVal Erwarteter Wert. Erlaubte Werte sind: "JA", "NEIN" und "IGNORIEREN". 
        ///
        /// \~english
        /// \brief
        /// No description for "VerifyLabel" available
        /// 
        /// \param FN Functional name of the object 
        /// \param ExpVal Expected value. Following values are Allowed here: "YES, "NO", and "IGNORE". 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        /// \todo TODO: keine Beschreibung vorhanden
        void VerifyLabel(String FN, String ExpVal) throws Exception;

        /// \~german
        /// \brief
        /// Vergleicht den ausgewählten Wert des gegebenen Listenobjekts mit dem erwarteten Wert.
        ///
        /// Eine Liste ist eine einfache Liste, eine Tabelle oder eine Baumansicht.
        /// Bei erwarteten Werten in Baumansichten (Treeview) wird immer die gesamte Hierarchie
        /// angegeben (siehe Beispiel).
        /// Dabei werden die Hierarchie-Elemente über den Separator {SEP} getrennt.<br/>
        /// _Beispiel 1: Prüfe, ob das Element "Henry" in der Liste "MeineListe" ausgewählt ist:_ <br/>
        /// \verbatim Prüfe Ausgewählter Wert: "MeineListe", "Henry" \endverbatim
        /// _Beispiel 2: Prüfe, ob das Element "Namen{SEP}Henry" in der Baumansicht "MeinTreeview" ausgewählt ist:_ <br/>
        /// \verbatim Prüfe Ausgewählter Wert: "MeinTreeview", "Namen{SEP}Henry" \endverbatim
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param ExpVal Erwarteter Wert 
        ///
        /// \~english
        /// \brief
        /// Compares the selected value of the given listobject with the expected value.
        ///
        /// A list can be a simple list, a table or a tree-view.
        /// Expected values in tree-views are indicated with the whole hierarchy (see example).
        /// With this the hierarchical elements are divided with the separator {SEP}.<br/>
        /// _Example #1: Check if the list entry "Henry" is selected in the list "MyList":_ <br/>
        /// \verbatim Verify Selected Value: "MyList", "Henry" \endverbatim
        /// _Example #2: Check if the entry "Names{SEP}Henry" is selected in the treeview "MyTreeview":_ <br/>
        /// \verbatim Verify Selected Value: "MyTreeview", "Names{SEP}Henry" \endverbatim
        /// 
        /// \param FN Functional name of the object 
        /// \param ExpVal Expected value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void VerifySelectedValue(String FN, String ExpVal) throws Exception;

        /// \~german
        /// \brief
        /// Vergleicht den Inhalt der gegebenen Tabellenzeile mit dem erwarteten Wert.
        /// 
        /// \param FN Funktionaler Name des Objekts 
        /// \param ExpVal Erwarteter Wert 
        /// \param fpsRow Zeilennummer der zu wählenden Zelle, beginnend mit 1. 
        /// \param fpsCol Spaltennummer der zu wählenden Zelle, beginnend mit 1. 
        ///
        /// \~english
        /// \brief
        /// Compares the content of the given table cell with the expected value.
        /// 
        /// \param FN Functional name of the object 
        /// \param ExpVal Expected value 
        /// \param fpsRow Row number of cell to be selected, starting with 1. 
        /// \param fpsCol Column number of cell to be selected, starting with 1. 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21/jnic
        void VerifyTablecellValue(String FN, String fpsCol, String fpsRow, String ExpVal) throws Exception;

        /// \~german
        /// \brief
        /// \todo TODO: Keine Beschreibung zu "VerifyTooltip" verfügbar
        ///
        /// \param FN Funktionaler Name des Objekts 
        /// \param ExpVal Erwarteter Wert 
        ///
        /// \~english
        /// \brief
        /// No description for "VerifyTooltip" available
        /// 
        /// \param FN Functional name of the object 
        /// \param ExpVal Expected value 
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21
        void VerifyTooltip(String FN, String ExpVal) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Prüft den Standardwert eines Objektes (in den meisten Fällen ist dies der angezeigte Text).
         *  
         *  _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten
         *  Wert "Django" entspricht:_ <br/>
         *  
         *  \verbatim Prüfe Wert: "MeinObjekt", "Django" \endverbatim
         *  
         *  Dieses Schlüsselwort prüft die exakte Übereinstimmung. Wildkards sind nicht möglich. 
         *  
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert 
         * 
         *  \~english
         *  \brief
         *  Checks the standard value of an object (in most cases this is the displayed text).
         *  
         *  _Example: Check if the value (text) of object "MyObject" equals the expected value "Django":_<br/>
         *  \verbatim Verify Value: "MyObject", "Django" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        void VerifyValue(String FN, String ExpVal) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Prüft den Standardwert eines Objektes (in den meisten Fällen ist dies der angezeigte Text). 
         *  Der Sollwert wird als RegulererAusdruck angegeben.
         *  
         *  _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten
         *  Wert "\\.jango" entspricht:_ <br/>
         *  
         *  \verbatim PrüfeWertREGX: "MeinObjekt", "$Django" \endverbatim
         *           
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert 
         * 
         *  \~english
         *  \brief
         *  Checks the standard value of an object (in most cases this is the displayed text). The expected Value is givan as Regularexpression
         *  
         *  _Example: Check if the value (text) of object "MyObject" equals the expected value "Django":_<br/>
         *  \verbatim Verify Value: "MyObject", "Django" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param fpsVerifictionType Allowed values: "REGX"-Regularexpression and "WCM"-Wildcard match 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        void VerifyValueREGX(String FN, String ExpVal) throws Exception;

        /**
         *  \~german
         *  \brief
         *  Prüft den Standardwert eines Objektes (in den meisten Fällen ist dies der angezeigte Text). 
         *  Der Sollwert wird als Wildcard-Match angegeben.
         *  
         *  Folgende Platzhalter sind möglich:
         *  * "?" - genau ein beliebiges Zeichen wird Maskiert
         *  * "*" - (0-n) beliebiges Zeichen wird Maskiert
         *  * "#" - genau eine Ziffer [0..9] kann maskiert werden
         *  _Beispiel: Prüfe, ob der Wert (Text) des Objekts "MeinObjekt" dem erwarteten
         *  Wert "\\.jango" entspricht:_ <br/>
         *  
         *  \verbatim PrüfeWertWCM: "MeinObjekt", "$Django" \endverbatim
         *           
         *  \param FN Funktionaler Name des Objekts 
         *  \param ExpVal Erwarteter Wert / Sollwert.
         * 
         *  \~english
         *  \brief
         *  Checks the standard value of an object (in most cases this is the displayed text). The expected Value is givan as Regularexpression
         *  
         *  _Example: Check if the value (text) of object "MyObject" equals the expected value "Django":_<br/>
         *  \verbatim Verify Value: "MyObject", "Django" \endverbatim
         *  
         *  \param FN Functional name of the object 
         *  \param fpsVerifictionType Allowed values: "REGX"-Regularexpression and "WCM"-Wildcard match 
         *  \param ExpVal Expected value 
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        void VerifyValueWCM(String FN, String ExpVal) throws Exception;

        ///
		void CopyFile(String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName) throws Exception;

		/// \~german
		/// \brief Löscht die gegebene Datei.
		/// 
		/// 
		/// Inder Pfadangabe sind 
		/// - OKW-Parser angaben sind erlaubt <code>${umgebungsvariable}</code>, <code>${merkewertschlüssel}</code>.
		/// - im Dateinamen sind Wildcards <code>*</code> + <code>?</code> erlaubt.
		/// 
		/// \note
		/// Dieses Schlüsselwort stellt sicher, dass _nach_ der Ausführung die angegebene Datei oder Dateien nicht (mehr) existiert/existieren.
		/// Falls die gegebene Datei _nicht_ existiert, dann wird _ohne Fehlermeldung_ und auslösen einer Ausnahme
		/// das Schlüsselwort beendet.
		/// 
		/// \par Beispiel
		/// DE.LöscheDatei( "C:\temp\meineDatei.txt" ) - Löscht die Datei <code>meineDatei.txt</code> im Verzeichniss <code>C:\temp</code>
		/// DE.LöscheDatei( "C:\temp\*.*" ) - Löscht alle Dateien im Verzeichniss <code>C:\temp</code>
		/// 
		/// \par Siehe auch
		/// - DE::LöscheDatei(string)
		/// - EN::FileDelete(string)
		/// - Core::FileDelete(string)
		/// - OK::FileDelete(string)
		/// - NOK::FileDelete(string)
		/// - OK_TRY::FileDelete(string)
		/// - NOK_TRY::FileDelete(string)
		/// 
		/// - IOKW_State::FileDelete(string)
		/// 
		/// \param fpsPathAndFileName Vollständiger Pfad und Dateiname.
		///
		/// \~english
		/// \brief Deletes the given file.
		/// 
		/// If the file does not exist, then this keyword ends without error message and an exception will not rais.
		/// 
		/// - OKW-Parser is included.
		/// - widcarsd ar in the filename allowed.
		/// 
		/// \param fpsPathAndFileName Full path of teh File
		///
		/// \~
		/// \author Zoltán Hrabovszki
		/// \date 2015.08.20
		void FileDelete(String fpsPathAndFileName) throws Exception;

		/// \~german
        /// \brief
        /// Prüft, ob die gegebene Datei existiert.
        /// 
        /// \param fpsPathAndFileName Pfad und Name der Datei, die Geprüft werden soll 
        /// \param ExpVal Erwarteter Wert. Möglich Werte sind: "JA"/"NEIN"/"${IGNORIERE}"
        ///
        /// /exception OKWFileDoesNotExistsException
        ///            Wenn die gegeben Datei ein Verzeichniss ist, also eben keine Datei, dann wird ein OKWFileDoesNotExistsException ausgelöst.
        /// \~english
        /// \brief
        /// 
        /// \param fpsPath Path and name of the file. 
        /// \param ExpVal Expected value. ExpVal: "YES"/"NO"/"${IGNORE}"
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2015-06-26
		void VerifyFileExists(String fpsPathAndFileName, String ExpVal) throws Exception;

		/// \~german
		/// \brief
		/// Prüft, ob das gegebene Verzeichnis existiert.
		/// 
		/// \param fpsPathA Pfad des Verzeichnisses, die Geprüft werden soll 
		/// \param ExpVal Erwarteter Wert. Möglich Werte sind: "JA"/"NEIN"/"${IGNORIERE}"
		///
		/// \~english
		/// \brief
		/// 
		/// \param fpsPathAndFileName Functional name of the object 
		/// \param ExpVal Expected value. ExpVal: "YES"/"NO"/"${IGNORE}"
		///
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2015-06-26
		void VerifyDirectoryExists(String fpsPath, String ExpVal) throws Exception;
	}
