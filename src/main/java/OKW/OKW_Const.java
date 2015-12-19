/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
      www.OpenKeyWord.de
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

package OKW;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import OKW.Exceptions.OKWConst4InternalnameNotFoundException;
import OKW.Exceptions.OKWNotAllowedValueException;
import OKW.Log.Logger;

    /* \~german
    * \brief
    * OKW_Const verwaltet die sprachabhängigen OKW-Konstanten.
    * 
    * Entwurfsmuster: Singleton - es gilt das Highländer-Prinzip "Es kann nur einen geben". <br/>
	* Das bedeutet, dass es nur eine Instanz dieser Klasse gibt, die zum Lesen der Nachrichten zuständig ist.
    * 
    * Die sprachabhängigen Werte, die zu dieser Klasse gehören, stehen in der Datei "OKW_Const.xml".
    * 
    * Diese Klasse selbst ist eine OKW-Fundametalklasse und gibt selbst keine Dokumentationen (Logs) aus.<br/>
    * 
    * Begriffe: <br/>
    * Hier ist eine Liste der Bezeichner/ Namen/ Begriff zusammengestellt,
    *	die im Rahmen dieser Klasse verwendet werden.
    * 
    * - __Const__ ist die sprachabhängige Konstante zu einer internen Konstante (ohne Klammerung).
    * - __OKWConst__ ist die sprachabhängige Konstante, die nach außen hin in Erscheinung tritt.
    * Sie hat die Form für die deutsche Implementierung: _${Bezeichner}_ und enstpricht
    * der _Const_ mit Klammerung.
    * - __Internalname__ ist die sprachunabhängige interne Bezeichnung einer Const. Siehe folgende Tabelle:
    * 
    * | Internalname | Const (DE) | OKWConst (DE) |
    * | -----------: | :--------: | :-----------: |
    * | SEP          | SEP        | ${SEP}        |
    * | VSEP         | VSEP       | ${VSEP}       |
    * | VSEP         | VSEP       | ${VSEP}       |
    * | DELETE       | LÖSCHEN    | ${LÖSCHEN}    |
    * | EMPTY        | LEER       | ${LEER}       |
    * | IGNORE       | IGNORIEREN | ${IGNORIEREN} |
    * | YES          | JA         | -             |
    * | NO           | NEIN       | -             |
    * | CHECKED      | ANGEWÄHLT  | -             |
    * | UNCHECKED    | ABGEWÄHLT  | -             |
    * | LEFTBRACE    | ${         | -             |
    * | RIGHTBRACE   | }          | -             |
    *
    * \~english
    * \brief
    * OKW_Const manages the language dependent OKW-Constants.
    * 
    * Designpattern: Singleton - the Highlander-Principle is valid "There only can be one!". <br/>
    * 
    * This means there is only one instance of this class, which is responsible for reading the news.
    * The language dependent values belonging to this class are in the file "OKW_Const.xml"
    * 
    * This class itself is an OKW-fundamental-class and returns no logs for its own. <br/>
    * 
    * Terms <br/>
    * Here is a list of identifier / name / term created to be used in this class.
    * 
    * - _Const_ is the language dependent constant to an internal constant(no brackets)
    * - __OKWConst__ is the language dependent constant, appearing outward.
    *   It has the form for the German implementation: _${Bezeichner}_ and corresponds _Const_ with brackets.
    * - _Internalname_ is the non language dependent internal identifier of a Const. Look following table:
    * 
    * | Internal Name| Const (EN) | OKW_Const (EN)|
    * | -----------: | :--------- | :------------ |
    * | SEP          | SEP        | ${SEP}        |
    * | VSEP         | VSEP       | ${VSEP}       |
    * | HSEP         | HSEP       | ${HSEP}       |
    * | DELETE       | DELETE     | ${DELETE}     |
    * | EMPTY        | EMPTY      | ${EMPTY}      |
    * | IGNORE       | IGNORE     | ${IGNORE}     |
    * | YES          | YES        | -             |
    * | NO           | NO         | -             |
    * | CHECKED      | CHECKED    | -             |
    * | UNCHECKED    | UNCHECKED  | -             |
    * | LEFTBRACE    | ${         | -             |
    * | RIGHTBRACE   | }          | -             |
    * 
    * \~
    * \author Zoltan Hrabovszki
    * \date 2013_12_22 <br/>
	* Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_22_jnic)
	* \todo (Zeile 22) Zukünftige Funktionalität: Nachricht auf einen anderen Tag weiterverlinken.
	* \todo (Zeile 41) Tabellenüberschrift wird als Verlinkung gelesen und blau auf blau dargestellt - OKWConst/DE
	* \todo (Zeile 75) Tabellenüberschrift wird als Verlinkung gelesen und blau auf blau dargestellt - OKWConst/EN
	 */
    public class OKW_Const
    {

    	/// \copydoc CurrentObject::Log()
    	private static Logger		Log	= Logger.getInstance();

    	private static OKW_Const instance = new OKW_Const();

        /* \~german
        * \brief
        * Aktuelle Spracheinstellung (Current Language) wird in der Klasse OKWLanguage verwaltet.<br/>
        * http://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste
        *
        * \~english
        * \brief
		* The actual language settings (current language) are administrated in the classe OKWLanguage.<br/>
        * http://en.wikipedia.org/wiki/ISO_3166-1
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_22_jnic)
	     */
        private OKWLanguage CL = OKWLanguage.getInstance();

        /* \~german
        * \brief
        * Referenz auf OKW.Log.LogMessenger
        * 
        * \~english
        * \brief
		* Reference to OKW.Log.LogMessenger
        * 
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_22_jnic)
	     */
        LogMessenger LM_OKW_Const_xml = null;
        
        private XPathDocument MyXPathDocument;
        private XPathNavigator MyXPathNavigator;
        
        /* \~german
        * \brief
        * Enthält den vollständigen Pfad und den Dateinamen zu der Datei OKW_Const.xml.
        * 
        * Die Initialisierung erfolgt im Konstruktor OKW_Const.OKW_Const
		*
        * \~english
        * \brief
        * Contains the complete path and filename referring to the file OKW_Const.xml.
		*
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_22_jnic)
	     */
        String OKW_Const_xml = "";

        /* \~german
        * \brief
        * Privater Konstruktor ohne Parameter im Entwurfsmuster Singelton initialisiert die Klasse OKW_Const.
        * 
        * Die Initialisierung erfolgt wie folgt:
        * @startuml{OKW_Const_de.png}
        * start
        * :Löse Pfad zu\n   **"OKW_Const.xml"**\n auf ;
        * note right: Wird aus der Umgebungvariable\n        **PathXML**\n gebildet
        * 
        * if ( \nExistiert die Datei\n **"OKW_Const.xml"**?\n) then (ja)
        *   :Erzeuge
        *      **XPathDocument()**
        *      **CreateNavigator()**;
        * else (nein)
        *   :Löse
        *         **FileNotFoundException** 
        * aus;
        *    note right: Danach wird\n die Ausführung\n des Skriptes beendet.
        * endif
        * 
        * stop
        * @enduml
        * 
        * \remark Diese Klasse ist ein Singleton, daher ist der Konstruktor _privat_!
        * Benutzen Sie OKW_Const.Instance um _die_ Instanz der Klasse zu erhalten.
        * 
        * Beispiel:
        * ~~~~~~~~~~~~~{.cs}
        *         // Split giveneExpected Value
        *         List&gt;string&lt; lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);
        * ~~~~~~~~~~~~~
        * 
        * \exception
        * Es wird eine _System.IO.FileNotFoundException_ ausgelöst, wenn die Datei OKW_Const.xml
        * nicht gefunden wird.
        *
        * \~english
        * \brief
        * Private constructor without a parameter like singleton pattern: initializes the class OKW_Const.
        * 
        * The initialization is effected as follows:
        * @startuml{OKW_Const_en.png}
        * 
        * start
        * :Dissolve path to\n   **"OKW_Const.xml"**\n;
        * note right: Created on Environmentvariable\n        **PathXML**\n
        * 
        * if ( \nExists the file\n **"OKW_Const.xml"**?\n) then (yes)
        *   :Create
        *      **XPathDocument()**
        *      **CreateNavigator()**;
        * else (No)
        *   :Dissolve
        *         **FileNotFoundException** ;
        *    note right: Stopping\n the execution\n of the script.
        * endif
        * 
        * stop
        * 
        * @enduml
        * 
        * \remark This class is a singleton, therefore the constructor is private.
        * Use OKW_Const.Instance to receive _the_ instance of the class.
        * 
        * Example:
        * ~~~~~~~~~~~~~{.cs}
        *         // Split giveneExpected Value
        *         List&gt;string&lt; lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);
        * ~~~~~~~~~~~~~
        * 
        * \exception
        * A _System.IO.FileNotFoundException_ is triggered, if the file OKW_Const.xml
        * is not found.
        * 
		* \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 
	    * \date Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        private OKW_Const()
        {

            String myOKW_Const = OKW.ANTLR4.MyParser.ParseMe(OKW_Ini.Instance.OKW_Enviroment.File_OKW_Const_xml);
        	this.OKW_Const_xml = System.IO.Path.Combine(OKW_Ini.Instance.OKW_Enviroment.Folder_XML, "OKW_Const.xml");
        	System.Console.WriteLine( "OKW_Const.xml: >>" + this.OKW_Const_xml + "<<");

       		this.LM_OKW_Const_xml = new LogMessenger(this.GetType().Name);
            
            if (!System.IO.File.Exists(this.OKW_Const_xml))
            {
                String lvsMessage = this.LM_OKW_Const_xml.GetMessage("OKW_Const", "FileNotFoundException", this.OKW_Const_xml);
                throw new FileNotFoundException(lvsMessage);
            }
            else
            {
                MyXPathDocument = new XPathDocument(this.OKW_Const_xml);
                MyXPathNavigator = this.MyXPathDocument.CreateNavigator();
            }
        }

        /* \~german
        * \brief
        * Holt die einzige Instanz dieser Klasse.<br/>
        * <value>
        * Die Instanz dieser Klasse.
        * </value>
        *
        * \~english
        * \brief
        * Gets the only instance of this class.<br/>
        * <value>
        * The instance of this class.
        * </value>
		*
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public static OKW_Const getInstance()
        {
                return instance;
        }

        
        /* \~german
        * \brief
        * Konvertiert WAHR/FALSCH (true/false) sprachabhängig nach "Ja"/"Nein" (Yes/No)
        * \param fpbTrueOrFalse WAHR oder FALSCH
        * \return "Ja" für true<br/> "Nein" für false
        * 
        * \~english
        * \brief
        * Converts true/false language dependent to yes/no
        * \param fps_YesOrNo true or false
        * \return "yes" in case of true<br/> "no" in case of false
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String Boolean2YesNo(Boolean fpbTrueOrFalse)
        {
            String lvs_Return = "" ;
            String lvsInternalname = "" ;

            try
            {
                Log.LogFunctionStartDebug(this.getClass().getName() + ".Boolean2YesNo", "fpbTrueOrFalse", fpbTrueOrFalse.toString());

                if (fpbTrueOrFalse)
                {
                    // If TRUE -> YES
                    lvs_Return = this.GetConst4Internalname("YES");
                }
                else
                {
                    // Else FALSE -> NO
                    lvs_Return = this.GetConst4Internalname("NO");
                }
            }
            finally
            {
                Log.LogFunctionEndDebug(lvs_Return);
            }

            return lvs_Return;
        }

        /* \~german
        * \brief
        * Methode _verbindet_ die einzelne Strings eines <code>List&lt;Strings&gt;</code> zu einem
        * <code>string</code> und trennt diese mit der Konstante ${HSEP}.
        *
        * Die Methode arbeitet sprachabhängig, womit die Trennkonstante in der aktuellen
        * Sprache verwendet wird.
        * 
        * \param  fpLs_ListString2Concat List-String, der zu einem String verbunden werden soll.
        * Beispiel: {"Wert1", "Wert2", "Wert3", "Wert4"}
        * 
        * \return Verbundene Werte "Wert1${HSEP}Wert2${HSEP}Wert3${HSEP}Wert4
        *
        * \~english
        * \brief
        * The method connects single strings of a list-String to one String and separates
        * it with the constant ${HSEP}.
        *
        * The method is working language dependent meaning that the separation constant is
        * used in the actual language.
        * 
        * \param  fpLs_ListString2Concat List-String, to be combined to a single string.<br/>
        *  Example: {"Value1", "Value2", "Value3", "Value4"}
        * 
        * \return Combined Values "Value1${HSEP}Value2${HSEP}Value3${HSEP}Value
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String ConcatHSEP(ArrayList<String> fpLs_ListString2Concat)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".ConcatHSEP", "fpLs_ListString2Concat", fpLs_ListString2Concat.toString());

            String lvs_Return = "" ;

            try
            {
                lvs_Return = OKW_Helper.ListStringConcat(fpLs_ListString2Concat, this.GetOKWConst4Internalname("HSEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvs_Return);
            }

            return lvs_Return;
        }

        /* \~german
        * \brief
        * Methode _verbindet_ die einzelne Strings eines <code>List&lt;Strings&gt;</code> zu einem
        * <code>string</code> und trennt diese mit der Konstante ${SEP}.
        * 
        * Die Methode arbeitet sprachabhängig, d.h. es wird die Trennkonstante der aktuellen Sprache verwendet.
        * 
        * \param fpLs_ListString2Concat List-String, die zu einem String verbunden werden soll.
        * Beispiel: {"Wert1", "Wert2", "Wert3", "Wert4"}
        * 
        * \return Verbundene Werte "Wert1${SEP}Wert2${SEP}Wert3${SEP}Wert4
        *
        * \~english
        * \brief
        * Method combines single strings of a listString to one String and separates it with
        * the constant ${SEP}.
        * 
        * The method works language dependent using the separation constant with the actual language.
        * 
        * \param  fpLs_ListString2Concat ListString to be combined to one string.
        *  Example: {"Value1", "Value2", "Value3", "Value4"}
        * 
        * \return Combined values "Value${SEP}Value2${SEP}Value3${SEP}Value
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String ConcatSEP(ArrayList<String> fpLs_ListString2Concat)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".ConcatSEP", "fpLs_ListString2Concat", fpLs_ListString2Concat.toString());

            String lvs_Return = "" ;

            try
            {
                lvs_Return = OKW_Helper.ListStringConcat(fpLs_ListString2Concat, this.GetOKWConst4Internalname("SEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvs_Return);
            }

            return lvs_Return;
        }

        /* \~german
        * \brief
        * Methode _verbindet_ die einzelnen Strings eines <code>List&lt;Strings&gt;</code> zu einem
        * <code>string</code> und trennt diese mit der Konstante ${VSEP}.
        * 
        * Die Methode arbeitet sprachabhänging, d.h es wird die Trennkonstante der aktuellen Sprache verwendet.
        * 
        * \param fpLs_ListString2Concat List-String, der zu einem String verbunden werden soll.
        * Beispiel: {"Wert1", "Wert2", "Wert3", "Wert4"}
        * 
        * \return Verbundene Werte "Wert1${VSEP}Wert2${VSEP}Wert3${VSEP}Wert4
        *
        * \~english
        * \brief
        * Method combines single strings of a listString to a single string
        * and separates it with the constant ${VSEP}.
        * 
        * The method is working language dependent using the separation constant of the actual language
        * 
        * \param fpLs_ListString2Concat List-String, to be combined to a single string.
        * Example: {"Value1", "Value2", "Value3", "Value"}
        * 
        * \return Combined values "Value1${VSEP}Value2${VSEP}Value3${VSEP}Value4
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String ConcatVSEP(ArrayList<String> fpLs_ListString2Concat)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".ConcatVSEP", "fpLs_ListString2Concat", fpLs_ListString2Concat.toString());

            String lvs_Return = "" ;

            try
            {
                lvs_Return = OKW_Helper.ListStringConcat(fpLs_ListString2Concat, this.GetOKWConst4Internalname("VSEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvs_Return);
            }

            return lvs_Return;
        }

        /* \~german
        * \brief
        * Methode ermittelt für __Internalname__ und der aktuell eingestellten Sprache den Wert für __Const__.
        * 
        * GetConst4Internalname ist die Kernmethode dieser Klasse und ermittelt für
        * 
        * - fpsInternalname und
        * - CL.Language enstpricht OKWLanguage.Instance.Language
        * 
        * die sprachabhängige Konstante.
        * 
        * \exception
        * Wird für fpsInternalname kein Wert gefunden, dann wird die Ausnahme 
		* OKWConst4InternalnameNotFoundException ausgelöst.
        * 
        * \param fpsInternalname Interner Bezeichner einer Konstante, die in eine
        * sprachabhängige Konstante umgestetzt wird.
        * (_Internalname_ -> _Const_)
        * 
        * \return
        *
        * \~english
        * \brief
		* Method detects the value for __Const__ for the __internalname__ and the actual selected language.
        * 
        * GetConst4Internalname is the core method of this class and detects for
        * 
        * - fpsInternalname and
        * - CL.Language corresponds to OKWLanguage.Instance.Language
        * 
        * the language dependent constant.
        * 
        * \exception
        * If no value is found for fpsInternalname, then the exception
		* OKWConst4InternalnameNotFoundException is triggered.
        * 
        * \param fpsInternalname Internal identifier of a constant, which is converted
        * to a language dependent constant.
        * (_Internalname_ -> _Const_)
        * 
        * \return
        *
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String GetConst4Internalname(String fpsInternalname)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".ReadConst", "fpsInternalname", fpsInternalname);

            String lvs_temp = "" ;

            String myXPath = "//okwconst[@internalname='" + fpsInternalname + "']/name/" + CL.getLanguage();

            Log.LogPrintDebug("myXPath: " + myXPath);

            try
            {
                XPathNodeIterator iter = this.MyXPathNavigator.Select(myXPath);

                if (iter.Count > 0)
                {
                    while (iter.MoveNext())
                    {
                        lvs_temp = iter.Current.Value;
                    }
                }
                else
                {
                    String lvsMessage = this.LM_OKW_Const_xml.GetMessage("GetConst4Internalname",
                                                             "ExceptionConst4Internalname",
                                                             fpsInternalname,
                                                             CL.getLanguage(),
                                                             this.LM_OKW_Const_xml.getXMLFile());
                    throw new OKWConst4InternalnameNotFoundException(lvsMessage);
                }
            }
            finally
            {
                if (lvs_temp == "" )
                {
                    Log.LogFunctionEndDebug();
                }
                else
                {
                    Log.LogFunctionEndDebug(lvs_temp);
                }
            }

            return lvs_temp;
        }


        /* \~german
        * \brief
        * Methode ermittelt für __Internalname__ und der aktuell eingestellten Sprache den Wert für __OKWConst__.
        * 
        * GetOKWConst4Internalname wählt für
        * 
        * - fpsInternalname und
        * - CL.Language (Lokale Referenz auf OKWLanguage.Instance.Language)
        * 
        * die sprachabhängige Konstante aus und setzt diese in Klammern.
        * 
        * | Internalname | OKW_Const (DE)|
        * | -----------: | :------------ |
        * | SEP          | ${SEP}        |
        * | VSEP         | ${VSEP}       |
        * | HSEP         | ${HSEP}       |
        * | DELETE       | ${LÖSCHEN}    |
        * | EMPTY        | ${LEER}       |
        * | IGNORE       | ${IGNORIEREN} |
        * 
        * Beispiel: <code>"$IGNORIEREN" == GetOKWConst4Internalname("IGNORE")</code>
        * 
        * \param fpsInternalname Internalname der Konstante. Beispiel: "IGNORE"
        * 
        * \return Eingeklammerte Konstante. Beispiel: "${IGNORIEREN}" für "IGNORE"
        *
        * \~english
        * \brief
        * Method detects for __Internalname__ and the actual selected language the value for __OKWConst__.
        * 
        * GetOKWConst4Internalname selects for
        * 
        * - fpsInternalname and
        * - CL.Language (local reference for OKWLanguage.Instance.Language)
        * 
        * the language dependent constant and places it in brackets.
        * 
        * | Internalname | OKW_Const (DE)|
        * | -----------: | :------------ |
        * | SEP          | ${SEP}        |
        * | VSEP         | ${VSEP}       |
        * | HSEP         | ${HSEP}       |
        * | DELETE       | ${DELETE}     |
        * | EMPTY        | ${EMPTY}      |
        * | IGNORE       | ${IGNORE}     |
        * 
        * Example: <code>"$IGNORE" == GetOKWConst4Internalname("IGNORE")</code>
        * 
        * \param fpsInternalname Internalname of constant. Example: "IGNORE"
        * 
        * \return Bracketed constant. Example: "${IGNORIEREN}" for "IGNORE"
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public String GetOKWConst4Internalname(String fpsInternalname)
        {
            String lvsReturn = "" ;

            Log.LogFunctionStartDebug( this.getClass().getName() + ".GetOKWConst4Internalname", "fpsInternalname", fpsInternalname);

            try
            {
                lvsReturn =
                    this.GetConst4Internalname("LEFTBRACE") +
                    this.GetConst4Internalname(fpsInternalname) +
                    this.GetConst4Internalname("RIGHTBRACE");
            }
            finally
            {
                Log.LogFunctionEndDebug(lvsReturn);
            }

            return lvsReturn;
        }


        /* \~german
        * \brief
        * Methode trennt einen String und wandelt diesen in eine ListString um. 
		* Der Schnitt wird an der Konstante ${HSEP} vorgenommen.
        * 
        * Die Methode arbeitet sprachabhänging, d.h es wird jeweils die Trennkonstante der 
		* aktuellen Sprache verwendet.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitSEP()<br/>
        * OKWConst::SplitVSEP()
        * 
        * \param fpsString2Split  Ein oder mehrere Werte, die mit ${HSEP} getrennt sind.<br/>
        * Beispiel: "Wert1${HSEP}Wert2${HSEP}Wert2"
        * 
        * \return Getrennte Werte als Liste. Beispiel: {"Wert1", "Wert2", "Wert3"}
        *
        * \~english
        * \brief
		* Method separates a String and converts it to a liststring.
        * The cut is set at the constant ${HSEP}.
        * 
        * The method is working language dependent meaning it is used the separation constant
		* of the actual language.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitSEP()<br/>
        * OKWConst::SplitVSEP()
        * 
        * \param fpsString2Split  One or more values, which are divided with ${HSEP}.<br/>
        * Example: "Value1${HSEP}Value2${HSEP}Value2"
        * 
        * \return Separated values as a list. Example: {"Value1", "Value2", "Value3"}
		*
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public ArrayList<String> SplitHSEP(String fpsString2Split)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".SplitHSEP", "fpsString2Split", fpsString2Split);
            ArrayList<String> lvls_2Plit = new ArrayList<String>();

            try
            {
                lvls_2Plit = OKW_Helper.StrSplit(fpsString2Split, this.GetOKWConst4Internalname("HSEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvls_2Plit.toString());
            }

            return lvls_2Plit;
        }

        
        /* \~german
        * \brief
        * Methode trennt einen String und wandelt diesen in einen ListString um. 
		* Der Schnitt wird an der Konstante ${SEP} vorgenommen.
        * 
        * Die Methode arbeitet sprachabhänging, d.h es wird jeweils die Trennkonstante
     	*	der aktuellen Sprache verwendet.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitHSEP()<br/>
        * OKWConst::SplitVSEP()
        * 
        * \param fpsString2Split  Ein oder mehrere Werte, die mit ${SEP} getrennt sind.<br/>
        * Beispiel: "Wert1${SEP}Wert2${SEP}Wert2"
        * 
        * \return Getrennte Werte als Liste. Beispiel: {"Wert1", "Wert2", "Wert3"}
        *
        * \~english
        * \brief
        * Method separates a String and converts it to a liststring.
		* The cut is set at the constant ${SEP}
		* 
        * The method is working language dependant meaning it is used the separation constant 
        * of the actual language.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitHSEP()<br/>
        * OKWConst::SplitVSEP()
        * 
        * \param fpsString2Split  One or more values, which are separated with ${SEP}.<br/>
        * Example: "Value1${SEP}Value2${SEP}Value2"
        * 
        * \return Separated values as a list: {"value1", "value2", "value3"}
        * 
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public ArrayList<String> SplitSEP(String fpsString2Split)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".SplitSEP", "fpsString2Split", fpsString2Split);

            ArrayList<String> lvls_2Plit = null;

            try
            {
                lvls_2Plit = OKW_Helper.StrSplit(fpsString2Split, this.GetOKWConst4Internalname("SEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvls_2Plit.toString());
            }

            return lvls_2Plit;
        }

        /* \~german
        * \brief
        * Methode trennt einen String und wandelt diesen in einen ListString um. 
		* Der Schnitt wird an der Konstante ${VSEP} vorgenommen.
        * 
        * Die Methode arbeitet sprachabhänging, d.h es wird jeweils die Trennkonstante
      	*	der aktuellen Sprache verwendet.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitHSEP()<br/>
        * OKWConst::SplitSEP()
        * 
        * \param fpsString2Split  Ein oder mehrer Werte, die mit ${VSEP} getrennt sind.<br/>
        * Beispiel: "Wert1${VSEP}Wert2${VSEP}Wert2"
        * 
        * \return Getrennte Werte als Liste. Beispiel: {"Wert1", "Wert2", "Wert3"}
        *
        * \~english
        * \brief
		* Method devides a String and converts it to a liststring.
        * The cut is set at the constant ${VSEP}
        * 
        * The method is working language dependent meaning it is used the separation constant
      	*	of the actual language.
        * 
        * 
        * \see
        * OKWConst::ConcatSEP()<br/>
        * OKWConst::ConcatHSEP()<br/>
        * OKWConst::ConcatVSEP()<br/>
        * OKWConst::SplitHSEP()<br/>
        * OKWConst::SplitSEP()
        * 
        * \param fpsString2Split  One or more values, which are separated with ${VSEP}.<br/>
        * Example: "value1${VSEP}value2${VSEP}value2"
        * 
        * \return Separated values as a list. Example: {"value1", "value2", "value3"}
		*
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_22 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public ArrayList<String> SplitVSEP(String fps_String2Split)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".SplitHSEP", "fps_String2Split", fps_String2Split);
            ArrayList<String> lvls_2Plit = new ArrayList<String>();

            try
            {
                lvls_2Plit = OKW_Helper.StrSplit(fps_String2Split, this.GetOKWConst4Internalname("VSEP"));
            }
            finally
            {
                Log.LogFunctionEndDebug(lvls_2Plit.toString());
            }

            return lvls_2Plit;
        }

        
        /* \~german
        * \brief
        * Konvertiert sprachabhängig Ja/Nein zu einem Booleanean Wert (Wahr/Falsch).<br/>
        * 
        * Beispiele:
        * Sprache ist "de": Eingabe "JA" -> Ausgabe Wahr <br/>
        * Sprache ist "de": Eingabe "NEIN" -> Ausgabe Falsch <br/>
        * Sprache ist "en": Eingabe "JA" oder "NEIN" -> löst die Exception OKWNotAllowedValueException aus.
        * 
        * Beim der Eingabe muss die GROSS- und kleinschreibung nicht beachtet werden. "Ja", "JA" oder "ja" ist gleichwertig.
        * 
        * \exception
        * OKWNotAllowedValueException wird ausgelöst, wenn nicht eine sprachabhängiges Ja/Nein als Parameter eingegeben wird.
        * 
        * \param fpsYesOrNo sprachabhängig Ja/Nein
        * \return WAHR wenn sprachabhängiger Wert ist "Ja"<br/> FALSCH, wenn sprachabhängiger Wert "Nein"
        *
        * \~english
        * \brief
        * Converts a Language dependent Yes/No to Boolean.<br/>
        * 
        * e.g. Language is "en": Input "Yes" returns true <br/>
        * e.g. Language is "en": Input "No" returns false <br/>
        * e.g. Language is "de": Input "Yes" or "No" - raises the exception OKWNotAllowedValueException.<br/>
        * 
        * \param fpsYesOrNo Language dependent Yes/No
        * \return true if Language dependent value is "yes"<br/> false if language dependent "No"
        *
        * \~
        * \author Zoltan Hrabovszki
        * \date 2013_12_09 <br/>
	    * Reviews:(2014_12_18_jnic, 2014_12_22_zh, 2014_12_26_jnic)
	     */
        public Boolean YesNo2Boolean(String fpsYesOrNo)
        {
            Log.LogFunctionStartDebug(this.getClass().getName() + ".YesNo2Boolean", "fpsYesOrNo", fpsYesOrNo);
            Boolean lvb_Return = false;

            String lvs_Yes = "" ;
            String lvs_No  = "" ;

            try
            {
                lvs_Yes = this.GetConst4Internalname("YES");
                lvs_No  = this.GetConst4Internalname("NO");

                if (lvs_Yes.toUpperCase() == fpsYesOrNo.toUpperCase())
                {
                    lvb_Return = true;
                }
                else if (lvs_No.toUpperCase() == fpsYesOrNo.toUpperCase())
                {
                    lvb_Return = false;
                }
                else
                {
                    Log.LogFunctionEndDebug();

                    String lvsMessage = this.LM_OKW_Const_xml.GetMessage("YesNo2Boolean", "ValueNotAllowed", fpsYesOrNo, lvs_Yes + "'/'" + lvs_No);
                    throw new OKWNotAllowedValueException(lvsMessage);
                }
            }
            finally
            {
                Log.LogFunctionEndDebug(lvb_Return);
            }

            return lvb_Return;
        }

    }
