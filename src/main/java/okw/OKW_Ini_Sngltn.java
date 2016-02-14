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

package okw;

import java.io.File;
import java.nio.file.Paths;
import java.security.CodeSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import okw.exceptions.OKWFileDoesNotExistsException;
import okw.log.Logger_Sngltn;

/*
* \brief
* OKW.OKW_Ini ist die Klasse zur Konfigurationsdatei OKW_Ini.xml.<br/>
* 
* Die Klasse OKW_Ini hält alle Konfigurationsparameter vor und stellt
* diese als Eigenschaften(Properties) zur Verfügung.
* 
* Die Eigenschaften werden in zwei Bereiche eingeteilt
* 
* Name                           | Beschreibung
* ------------------------------ | -------------
* OKW.OKW_Ini.OKW_Enviroment     | Umgebungseigenschaften, wie z.B. Pfade.<br/> Genaue Beschreibung in der referenzierten Klasse.
* OKW.OKW_Ini.OKW_CustomSettings | Allgemeine Einstellungen, wie TimeOuts <br/>Genaue Beschreibung in der referenzierten Klasse.
* 
* Die Klasse ist als Singelton konstruiert.<br/>
* __Die Verwendung dieser Klasse erfolgt__ _nicht_ über den Konstruktor, sondern __ausschließlich
* über die Eigenschaft OKW.OKW_Ini.Instance.__<br/>
* 
* ## Verwendung der Klasse OKW.OKW_Ini ##
* ### Paket einbinden ###
* Das Paket OKW enthält die Klasse OKW_Ini. Die kann mit
* ~~~~~~~~~~~~~{.py}
* use OKW;
* ~~~~~~~~~~~~~
* erfolgen.
* 
* ### Instanz des Singelton holen ###
* Eine Instanz der Klasse wird wie folgt geholt:<br/>
* ~~~~~~~~~~~~~{.py}
* OKW_Ini myOKW_Ini = OKW_Ini.Instance;
* ~~~~~~~~~~~~~
* 
* ### Wert einer Eigenschaft referenzieren ###
* ~~~~~~~~~~~~~{.py}
* String MeinWert myOKW_Ini.CustomSettings.TimeOutExists;
* ~~~~~~~~~~~~~
* 
* ## Hinweis für OKW Entwickler ##
* ### Erweiterung der Propertys ###
* Im folgenden soll anhand eines Beispiels gezeigt werden, wie eine neue Eigenschaft
* _NewProperty_ der OKW_Ini hinzugefügt werden kann.
* 
* Die neue Eigenschaft _NewProperty_ wird mit _"Default Value"_ initialisiert.
* Für _NewProperty_ wird wie folgt definiert:
* ~~~~~~~~~~~~~{.py}
* private String __NewProperty = "Default Value";
*
* [XmlElement("NewProperty")]
* public String NewProperty {
*     get{ return __NewProperty; }
*     set{ __NewProperty = value; }
* }
* ~~~~~~~~~~~~~
* 
* __Anmerkung:__ Die _private_ Variable <code>__NewProperty</code> ist notwendig,
* weil die Eigenschaft <code>NewProperty</code>
* zunächst auf einen Default-Wert initialisiert wird. Da OKW_Ini automatisch eine
* vollständige OKW_Ini.xml-Datei erstellen soll, ist es nicht möglich via Attributdefinition
* die Eigenschaft auf einen default Wert zu setzen,
* da in <code>System.Xml.Serialization</code> nur Eigenschaften serialisert werden, die sich
*	vom Default-Wert unterscheiden.
* 
* ### Automatische Serialisierung ###
* Die so eingefügte neue Eigenschaft _NewProperty_ wird automatisch mit den anderen Eigenschaften
*	in die _OKW_Ini.xml_ serialisiert/deserialisiert.
* 
* ### Quellen:
*   http://www.mkyong.com/java/jaxb-hello-world-example/
* \~english
* \brief
* OKW.OKW_Ini is the related class to the configuration file OKW_Ini.xml.<br/>
* 
* The class OKW_Ini is holding in store all configuration parameters and is providing
* this properties.
* 
* The properties are divided in two sections:
* 
* Name                           | Description
* ------------------------------ | -------------
* OKW.OKW_Ini.OKW_Enviroment     | Environmental characteristics, such as paths.<br/> Detailed description in the referenced class.
* OKW.OKW_Ini.OKW_CustomSettings | General settings such as time-outs <br/>Detailed description in the referenced class.
* 
* The class is created as singleton.<br/>
* __The use of this class is__ _not_ done with the constructor, but __exclusively
* with the property OKW.OKW_Ini.Instance.__<br/>
* 
* ## Usage of the class OKW.OKW_Ini ##
* ### Integration of package ###
* The package OKW contains the class OKW_Ini. The class can be affected with
* ~~~~~~~~~~~~~{.py}
* use OKW;
* ~~~~~~~~~~~~~
* 
* ### Getting the instance of the singleton ###
* An instance of the class is taken as follows:<br/>
* ~~~~~~~~~~~~~{.py}
* OKW_Ini myOKW_Ini = OKW_Ini.Instance;
* ~~~~~~~~~~~~~
* 
* ### Referencing the value of a property ###
* ~~~~~~~~~~~~~{.py}
* String MeinWert myOKW_Ini.CustomSettings.TimeOutExists;
* ~~~~~~~~~~~~~
* 
* ## Hint for OKW Developers ##
* ### Extension of Properties ###
* The following should be shown by way of example, as a new property
* _NewProperty_ of OKW_Ini can be added.
* 
* The new property _NewProperty_ is initialized with _"Default Value"_ .
* For _NewProperty_ will be defined as follows:
* ~~~~~~~~~~~~~{.py}
* private String __NewProperty = "Default Value";
*
* [XmlElement("NewProperty")]
* public String NewProperty {
*     get{ return __NewProperty; }
*     set{ __NewProperty = value; }
* }
* ~~~~~~~~~~~~~
* 
* __Note:__ The _private_ variable <code>__NewProperty</code> is necessary,
* because the property <code>NewProperty</code>
* is initialized first with a Default-Value.
* Since OKW_Ini will automatically create a complete OKW_Ini.xml file,
* it is not possible to set the property via attribute definition to a default value,
* since <code>System.Xml.Serialization</code>, only properties serializing, which
* differ from the default value.
* 
* ### Automatical Serializing ###
* The new property _NewProperty_ inserted this wax is automatically serialized/ deserialized
* with the other properties in the _OKW_Ini.xml_ .
* 
*
* \~
* \author Zoltán Hrabovszki
* \date 2014-10-25/jn
 */

@XmlRootElement
public class OKW_Ini_Sngltn
{

	/*
	 * \brief Dieses Feld hält den Abschnitt OKW_CustomSettings der OKW_Ini.xml
	 * vor.
	 *
	 * \~english \brief This field has in store the section OKW_CustomSettings
	 * of OKW_Ini.xml.
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/jn
	 */
	@XmlElement
	public OKW_CustomSettings	OKW_CustomSettings	= new OKW_CustomSettings();

	/*
	 * \brief Dieses Feld hält den Abschnitt OKW_Enviroment der OKW_Ini.xml vor.
	 *
	 *
	 * \~english \brief This field has in store the section OKW_Enviroment of
	 * OKW_Ini.xml.
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/jnic
	 */
	@XmlElement
	public OKW_Enviroment		OKW_Enviroment		= new OKW_Enviroment();

	/*
	 * \brief Singelton-Pattern: Feld enthält die einzige gültige Instanz dieser
	 * Klasse.
	 *
	 *
	 * \~english* \brief Singelton-Pattern: Field contains the only valid
	 * instance of this class.
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/jnic
	 */
	private static OKW_Ini_Sngltn		Instance;

	// \copydoc CurrentObject::Log()
	private static Logger_Sngltn		Log					= Logger_Sngltn.getInstance();

	/*
	 * \brief Diese Klasse ist ein Singelton.
	 *
	 * Wie für ein Singelton-Pattern typisch, wird eine Instanz nicht mit dem
	 * Konstruktor erzeugt, sondern über das Property OKW_Ini.Instance
	 * aufgerufen.
	 *
	 * __Wichtig:__ Verwende nicht diesen Konstuktor, um eine Instanz der Klasse
	 * zu erstellen.
	 *
	 * __Anmerkung:__ Der Konstruktor sollte bei einem Singelton 'private' sein.
	 * Dieser Konstuktor muss wegen der Serialisierung 'public' sein!
	 *
	 * \note Näheres zum Thema Singeleton unter
	 * http://csharpindepth.com/Articles/General/Singleton.aspx (nur in
	 * englischer Sprache verfügbar)
	 *
	 *
	 * \~english \brief This class is a Singelton.
	 *
	 * As typical for a Singelton-Pattern an instance is not created with the
	 * constructor, but called with the property OKW_Ini.Instance.
	 *
	 * __Important:__ Do not use this constructor to create an instance of the
	 * class.
	 *
	 * __Note:__ The constructor should be 'private' with a singleton. This
	 * constructor must be 'public' because of the serializing!
	 *
	 * \note Further Information to the topic Singeleton at
	 * http://csharpindepth.com/Articles/General/Singleton.aspx
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/jnic
	 */
	public OKW_Ini_Sngltn()
	{
		try
		{
			Init();
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, Instance.getClass());
		}
	}

	/*
	 * \brief Singelton-Pattern: Instanz gibt die aktuelle, gültige und einzige
	 * Innstanz der Klasse zurück.
	 *
	 * Beim der ersten Verwendung dieser Klasse wird automatisch eine Instanz
	 * dieser Klasse erzeugt.
	 *
	 * __Wichtig:__ Um eine Instanz der OKW.OKW_Ini zu erhalten ausschliesslich
	 * nur diese Eigenschaft verwenden!
	 *
	 *
	 * \~english \brief Singelton-Pattern: instance returns the actual valid and
	 * only instance of the class.
	 *
	 * At the first use of this class an instance of this class is automatically
	 * created.
	 *
	 * __Important:__ To receive an instance of OKW.OKW_Ini use exclusively this
	 * property only!
	 *
	 *
	 * \~
	 * \author Zoltán Hrabovszki
	 * \date 2014.10.25
	 */
	public static OKW_Ini_Sngltn getInstance()
	{
		// Lazy Initialization (If required then only)
		if (Instance == null)
		{
			// Thread Safe. Might be costly operation in some case
			synchronized (OKW_Ini_Sngltn.class)
			{
				if (Instance == null)
				{
					Instance = new OKW_Ini_Sngltn();
				}
			}
		}
		return Instance;
	}

	/*
	 * \brief Löschen und zurücksetzten der Klasse.
	 *
	 * Wird in erster Linie für die Unittests benötigt.
	 *
	 * \~english \brief Deleting and resetting of the class.
	 *
	 * Is needed primarily for the unittests.
	 *
	 * \~ \author Zoltan Hrabovszki \date 2014-10-25/jnic
	 */
	public static void Reset()
	{
		Instance = null;
	}

	/*
	 * \brief Initialsiert die Klasse OKW.OKW_Ini
	 *
	 * Die Initialisierung der Klasse OKW.OKW_Ini läuft wie folgt ab:
	 *
	 *
	 * - Löschen aller Klassen-Variablen der OKW_Ini. - Lesen der
	 * Umgebungsvariable OKW_Xml + wenn die Umgebunsvariable vorhanden ist... *
	 * und die Datei existiert, dann lesen der Datei. * und mit diesen Werten
	 * eine Datei an der gegebene Stelle erstellen. + wenn die Umgebungsvariable
	 * fehlt oder nicht gesetzt ist, * dann werden alle werden alle
	 * Eigenschaften auf "Default-Wert" gesetzt. * Es wird jedoch keine Datei
	 * geschrieben.(Weil die Zieldatei Fehlt!) * Warnung wird ausgegeben, dass
	 * die Umgebungsvariable fehlt.
	 *
	 * \exception OKWEnviromentVarNotSetException Wenn die Umgebungsvariable
	 * OKW_Xml nicht gesetzt ist. \exception OKWFileDoesNotExistsException wird
	 * ausgelöst, wenn die Datei, gegeben als OKW_Ini.Xml_Ini_xml, nicht
	 * existiert. Vorher wurde eine Vorlagedatei angelegt.
	 *
	 *
	 * \~english \brief Initializes the class OKW.OKW_Ini
	 *
	 * The initialization of the class OKW.OKW_Ini is scheduled as follows:
	 *
	 * @startuml{OKW_Ini_en.png} start :Clear class variables; :read environment
	 * variable **OKW_Xml**; if (is **OKW_Xml** defined?) then (yes)
	 *
	 * if (**OKW_Xml** exists as file?) then (yes) :read data\naus **OKW_Xml**;
	 * else (no) :**OKW_xml** create\ntemplatefile; :Trigger Exception:\n
	 * ""OKWFileDoesNotExistsException""; endif
	 *
	 * else (nein) :give out message:\n"//OKW_Xml is not set//" ; :Trigger
	 * Exception:\n ""OKWEnviromentVarNotSetException"";
	 *
	 * endif
	 *
	 * stop
	 *
	 * @enduml
	 *
	 * - clear all class variables of OKW_Ini. - read environment variable
	 * OKW_Xml + if the environment variable is existing... * and file exists,
	 * then read the file. * and with this values create a file at the given
	 * place. + if the environment variable is missing or not set, * then all
	 * properties are set on "Default-Value". * No file will be written, because
	 * the target file is missing! * Warning is given that the environment
	 * variable is missing.
	 *
	 * \exception OKWEnviromentVarNotSetException If the environment variable
	 * OKW_Xml is not set. \exception OKWFileDoesNotExistsException is
	 * triggered, if the file, given as OKW_Ini.Xml_Ini_xml, is not existing.
	 * Before a template file was created.
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/jnic
	 */
	public void Init() throws JAXBException
	{
		Log.LogFunctionStart(this.getClass().getName() + ".Init");

		// Klassen Variablen erst löschen...
		this.OKW_Enviroment.setFile_OKW_Ini_xml("");
		this.OKW_Enviroment.setFolder_XML("");

		// ... und dann alles Initialisieren!
		try
		{
			// 1. Lese OKWINI-Ümgebungsvariable
			this.OKW_Enviroment.setFolder_XML(System.getenv("OKW_Xml"));

			// Ist die Umgebungsvariable gesetzt?
			if (OKW_Helper.StringIsNullOrEmpty(this.OKW_Enviroment.getFolder_XML()))
			{
				// OKW_Xml ist nicht gesetzt -> OKW_Ini_xml auf Assambly
				// Verzeichnis setzen...
				this.OKW_Enviroment.setFolder_XML(Paths.get(MyDirectory(), "XML").toString());
			}

			// Existiert die Datei?
			Boolean bXML_Folder_Exists = OKW_FileHelper.DirectoryExists(this.OKW_Enviroment.getFolder_XML());

			if (bXML_Folder_Exists)
			{
				this.OKW_Enviroment.setFolder_LogMessages(
						Paths.get(this.OKW_Enviroment.getFolder_XML(), "LogMessages").toString());
				this.OKW_Enviroment
						.setFile_OKW_Ini_xml(Paths.get(this.OKW_Enviroment.getFolder_XML(), "OKW_Ini.xml").toString());
						// Datei Existiert -> Lesen der Daten

				// Existiert die Datei?
				Boolean bFile_OKW_Ini_xml_Exists = OKW_FileHelper
						.FileExists(this.OKW_Enviroment.getFile_OKW_Ini_xml());

				if (bFile_OKW_Ini_xml_Exists)
				{
					Log.LogPrint("Folder_XML: >>" + this.OKW_Enviroment.getFolder_XML() + "<<");
				}
				else
				{
					this.Save();
				}
				this.LogAll();

			}
			else
			{
				// Verzeichniss fehlt: Abbruch!
				throw new OKWFileDoesNotExistsException(
						"Directory not found: >>" + this.OKW_Enviroment.getFolder_XML() + "<<");
			}
		}
		finally
		{
			Log.LogFunctionEnd();
		}

		return;
	}

	/*
	 * \brief Liest die Eigenschaften der Klasse OKW_Ini aus einer Datei,
	 * gegeben in OKW.OKW_Ini.Xml_Ini_xml, ein. Es wird eine XML Datei
	 * geschrieben. Hierzu wird die Klasse OKW_Ini mit System.Xml.XmlSerializer
	 * serialisiert.
	 *
	 *
	 * \~english \brief Reads the properties of the class OKW_Ini from a file,
	 * given in OKW.OKW_Ini.Xml_Ini_xml. An XML file is written. For this
	 * purpose the class OKW_Ini is serialized with
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25
	 */
	public void Read() throws JAXBException
	{
		Log.LogFunctionStartDebug(this.getClass().getName() + ".Read()");

		try
		{

			File file = new File(OKW_Enviroment.getFile_OKW_Ini_xml());
			JAXBContext jaxbContext = JAXBContext.newInstance(OKW_Ini_Sngltn.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			OKW_Ini_Sngltn customer = (OKW_Ini_Sngltn) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		}
		finally
		{
			Log.LogFunctionEndDebug();
		}

		return;
	}

	public void LogAll()
	{

		Log.ResOpenList("Enviroment...");

		try
		{

			Log.LogPrint("----------------------------------------------------------------");
			Log.LogPrint("        Assambly Path: " + this.MyDirectory());
			Log.LogPrint("----------------------------------------------------------------");
			Log.LogPrint("     OKW_Ini.xml Path: " + this.OKW_Enviroment.getFile_OKW_Ini_xml());
			Log.LogPrint("   OKW_Const.xml Path: " + this.OKW_Enviroment.getFile_OKW_Const_xml());
			Log.LogPrint("    OKW_Docu.xml Path: " + this.OKW_Enviroment.getFile_OKW_Docu_xml());
			Log.LogPrint("  OKW_Keymap.xml Path: " + this.OKW_Enviroment.getFile_OKW_Keymaps_xml());
			Log.LogPrint("OKW_Memorize.xml Path: " + this.OKW_Enviroment.getFile_OKW_Memorize_xml());
			Log.LogPrint("----------------------------------------------------------------");
			Log.LogPrint(
					"OKW_ImplementationMatrix.xml Path: " + this.OKW_Enviroment.getFile_OKW_ImplementationMatrix_xml());
			Log.LogPrint("----------------------------------------------------------------");
			Log.LogPrint("  XML Verzechnis: " + this.OKW_Enviroment.getFolder_XML());
			Log.LogPrint("    LogMessanges: " + this.OKW_Enviroment.getFolder_LogMessages());
			Log.LogPrint("----------------------------------------------------------------");
			Log.LogPrint("        Language: " + this.OKW_CustomSettings.getLanguage());
			Log.LogPrint("         PathSep: " + this.OKW_CustomSettings.getPathSep());
			Log.LogPrint("   TimeOutExists: " + this.OKW_CustomSettings.getTimeOutExists());
			Log.LogPrint("TimeOutNotExists: " + this.OKW_CustomSettings.getTimeOutNotExists());
			Log.LogPrint("----------------------------------------------------------------");
		}
		finally
		{
			Log.ResCloseList();
		}

		return;
	}

	/*
	 * \brief Schreibt die Eigenschaften der Klasse OKW_Ini in eine Datei,
	 * gegeben in OKW.OKW_Ini.Xml_Ini_xml. Es wird eine XML Datei geschrieben.
	 * Hierzu wird die Klasse OKW_Ini mit der Klasse System.Xml.XmlSerializer
	 * serialisiert.
	 *
	 *
	 * \~english \brief Writes the property of the class OKW_Ini in a file,
	 * given in OKW.OKW_Ini.Xml_Ini_xml. An XML file is written. For this
	 * purpose the class OKW_Ini with the class System.Xml.XmlSerializer is
	 * serialized.
	 *
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/ rev.
	 */
	public void Save() throws JAXBException
	{
		Log.LogFunctionStartDebug(this.getClass().getName() + ".Save()");

		try
		{
			File file = new File(OKW_Enviroment.getFile_OKW_Ini_xml());
			JAXBContext jaxbContext = JAXBContext.newInstance(OKW_Ini_Sngltn.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this, file);
			jaxbMarshaller.marshal(this, System.out);
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}

		return;
	}

	/*
	 * \brief Ermittelt den Pfad zu assambly _OKW.dll_.
	 *
	 *
	 * \~english \brief Gets the path to the assembly _OKW.dll_.
	 *
	 * \~ \author Zoltán Hrabovszki \date 2014-10-25/ rev.
	 */
	public String MyDirectory()
	{
		String lvsReturn = "";

		Log.LogFunctionStartDebug(this.getClass().getName() + ".MyDirectory()");

		try
		{
			final CodeSource source = this.getClass().getProtectionDomain().getCodeSource();

			if (source != null)
			{
				lvsReturn = source.getLocation().getPath();
			}
			else
			{
				// \todo TODO: Hier Ausnahme auslösen Pfad nicht ermittelt...
				lvsReturn = "";
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}
		return lvsReturn;

	}
}