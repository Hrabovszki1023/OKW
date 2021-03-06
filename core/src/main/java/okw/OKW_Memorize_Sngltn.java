/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

//import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import javax.xml.bind.JAXBException;
//import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

//import org.xml.sax.SAXException;

import okw.exceptions.OKWMemorizeKeyNotExistsException;
import okw.log.Logger_Sngltn;

/** \~german
 *  OKW_Memorize ist die Speicher-Klasse hinter den Merke*-Schlüsselwörter.
 *  
 *  Mit Memorize*( "BN", "myKeyname" ) wird ein Wert 
 *  
 *  Diese Klasse ist nach dem Singelton-Pattern aufgebaut.
 *  Eine Instanz der Klasse wird wie folgt erstellt:
 *  
 *  ~~~~~~~~~~~~~{.java}
 *  OKW.OKW_Memorrize.getInstance()
 *  ~~~~~~~~~~~~~
 *  
 *  \~english
 *  \~
 *  \author Zoltán Hrabovszki
 *  \date 2013.12.06
 *  \
 */
public class OKW_Memorize_Sngltn
{
	/**  \~german
	 *  Variable hält Pfad und Dateinamen der OKW_Memorize.xml.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 */
	public String OKW_Memorize_xml	= "";

	/**  \~german
	 *  Dictionary speichert die Schlüssel-Wert Paare.
	 *  
	 *  Die Hier gespeicherten werte sind nicht persistent.
	 * 
	 *  \~english
	 *  \brief
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 */
	protected Map<String, String> Value = new HashMap<String, String>();

	/**  \~german
	 *  Dictionary speichert Schlüssel-Wert Paare.
	 *  
	 *  Die Hier gespeicherten werte sind persistent.
	 *  Die Werte werden aus/in die Datei gespeichert
	 *  der Datei
	 * 
	 *  \~english
	 *  \brief
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2019.11.25
	 */
	protected Map<String, String> ValuePersistent = new HashMap<String, String>();


	/**  \~german
	 *  Singelton spezifisch: Dieses Feld speichert die einzige Instanz dieser
	 *  Klasse.
	 *  
	 *  Es wird die Properties Datein geladen, die im OKW-Property "OKW_Memorize.properties" angegeben ist
	 *  Der Default Wert ist "OKW_Memorize.properties".
	 *  
	 *  Diese Datei wird automatisch beim Initialisieren der Klasse geladen
	 *  und bei jedem Setzen des wertes in der Datei, gegeben in "OKW_Memorize.properties", gespeichert.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 */
	protected static OKW_Memorize_Sngltn	Instance;


	/** \~german
	 *  Eine lokale Instanz des OKW.Log.LogMssenger.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.12.28
	 */
	protected LogMessenger LM	= null;

	/**  \~german
	 *  Referenz auf die einzige Instanz des Klasse OKW.Logger.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 */
	protected Logger_Sngltn Log = Logger_Sngltn.getInstance();

	protected OKW_Properties Properties  = OKW_Properties.getInstance();

	/**  \~german
	 *  Privater Konstruktor dieser Klasse.
	 * 
	 *  @note Der Konstruktor _muss private_ da Singelton.
	 *  
	 *  Verwende die Methode OKW_Memorize.Instace() um eine Instanz dieser
	 *  Klasse zu erhalten.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.14.27
	 */
	private OKW_Memorize_Sngltn()
	{
		try
		{
			LM = new LogMessenger("OKW_Memorize");
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, Instance.getClass());
		}
	}

	/**  \~german
	 *  Diese Methode gibt die einzige Instanz dieser Klasse zurück.
	 * 
	 *  Nachdem Singelton-Muster wird die einzige Instanz der Klasse mit einer
	 *  Methode abgerufen.
	 * 
	 *  Diese Methode erzeug eine Instanz dieser Klasse und initialisiert
	 *  diesen, sofern nicht bereits eine Instanz
	 *  der Klasse exsistiert.
	 *  Wenn eine Instenz bereits vorhanden ist, dann wird nur die Referenz auf
	 *  die Instanz zurückgeliefert
	 * 
	 *  Beipsiele für die Verwendung sind unter der Beschreibung dieser Klasse,
	 *  OKW.OKW_Memorize, zu finden.
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.14.27
	 */
	public static OKW_Memorize_Sngltn getInstance()
	{
		// Lazy Initialization (If required then only)
		if (Instance == null)
		{
			// Thread Safe. Might be costly operation in some case
			synchronized (OKW_Const_Sngltn.class)
			{
				if (Instance == null)
				{
					Instance = new OKW_Memorize_Sngltn();
					Instance.init();
				}
			}
		}

		return Instance;
	}

	/** \~german
	 * Methode setzt diese Klasse zurück.
	 *
	 * Nach Aufruf dieser Methode befinden sich die Klasse im Initialzustand.
	 * Dazu wird die Instance-Variable auf__null__ gesetzt.
	 *  Wird in erster Linie für die Unittest benötigt.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.11.25
	 */
	public void reset()
	{
		Instance = null;
		getInstance();
	}

	/**  \~german
	 *  Prüft ob es eine Eintrag zum Schlüssel _fpsKey_ vorhanden ist.
	 * 
	 *  Nach Aufruf dieser Methode befinden sich die Klasse im Initialzustand.
	 *  Dazu wird die Instance-Variable auf__null__ gesetzt.
	 *  Wird in erster Linie für die Unittest benötigt.
	 * 
	 *  \param fpsKey Schlüssel, der geprüft werden soll.
	 *  \returntrue, falls der gegeben schlüssel existiert, sonst false\return
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.11.25
	 */
	public Boolean exists( String fpsKey )
	{
		Boolean lvbReturn = false;

		if ( Value.containsKey(fpsKey))
		{
			lvbReturn = true;
		}
		else
		{
			lvbReturn = false;
		}

		return lvbReturn;
	}

	/** \~german
	 *
	 *  Holt den aktuellen Wert des gegebennen Schlüssels.
	 * 
	 *  Kernfunktion dieser Klasse. Holt zum gegeben Schlüssel _fpsKey_ den
	 *  aktuellwert aus OKW_Memmorize._Value.
	 * 
	 *  @exception Es wird die Ausnahme OKWMemorizeKeyNotExistsException
	 *  ausgelöst, wenn ein Schlüssel abgefragt wird,
	 *  der vorher nicht eigespeichert wurde.
	 * 
	 *  \param fpsKey
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.12.27
	 */
	public String get( String fpsKey )
	{
		String lvsReturn = null;

		if ( Value.containsKey(fpsKey))
		{
			lvsReturn = Value.get(fpsKey);
		}
		else
		{
			String ErrorText = LM.GetMessage("Get", "OKWMemorizeKeyNotExistsException", fpsKey);
			throw new OKWMemorizeKeyNotExistsException(ErrorText);
		}

		return lvsReturn;
	}

	/** \~german
	 *
	 *  Holt die aktuelle Anzahl der gespeicherten Werte.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.12.27
	 */
	public Integer getKeysCount( )
	{
		Integer lvnReturn = 0;

		lvnReturn = Value.size();
		lvnReturn = lvnReturn + this.ValuePersistent.size();

		return lvnReturn;
	}


	/**  \~german
	 *  Initialsiert die Klasse OKW.OKW_Memorize
	 * 
	 *  Die Initialisierung der Klasse OKW.OKW_Ini läuft wie folgt ab:
	 * 
	 *  /startuml{OKW_Memorize_de.png}
	 *  start
	 * 
	 *  :Lösche alle Werte im Speicher (**_Value**);
	 *  :Hole Pfad und Dateiname\naus der **OKW_Ini.xml**;
	 * 
	 *  if (Ist Pfad und Dateiname\n für\n **OWK_Memorize.xml**\n gegeben?) then
	 *  (ja)
	 * 
	 *  if (Ist die gegebene Datei\n vorhanden?) then (ja)
	 *  :this.Read()>
	 *  else (nein)
	 *  :Gebe eine Warnung aus ;
	 *  endif
	 * 
	 *  else(nein)
	 *  :Gebe eine Warnung: **'OKW_Memorize'** ist nicht gesetzt!;
	 *  endif
	 * 
	 *  stop
	 *  /enduml
	 * 
	 *  \~english
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 */
	public void init()
	{
		// Klassen Variablen erst löschen...

		Instance.OKW_Memorize_xml = "";
		Instance.Value.clear();

		// ... und dann alles Initialisieren!
		// 1. Setze Pfad und
		OKW_Memorize_xml = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Memorize_xml();

		if (!OKW_Helper.isStringNullOrEmpty(this.OKW_Memorize_xml))
		{
			this.Log.LogPrintDebug("OKW Memorize Datei = >>" + this.OKW_Memorize_xml + "<<");
			if (OKW_FileHelper.fileExists(this.OKW_Memorize_xml))
			{
				// Lesen der Daten...
				//this.Read();
			}
			else
			{
				// Deafault Werte Lesen.
				Log.LogWarning("Datei: >>" + this.OKW_Memorize_xml + "<< nicht gefunden.");
			}
		}
		else
		{
			Log.LogWarning("Enviroment variable 'OKWIni' not set!");
		}

	}

	/** \~german
	 *  Schreibt die Felder (fields) der Klasse OKW_Memorize in eine Datei.
	 * 
	 *  Es wird eine XML Datei geschrieben. Hierzu wird die Klasse OKW_Ini mit
	 *  der
	 *  Klasse System.Xml.XmlSerializer serialisiert.
	 * 
	 *  Pfad und Name der XML-Datei. Dies wird in der XML/OKW_Ini.xml
	 *  vorgegeben:
	 *  XPATH: OKW_Ini/OKW_Enviroment/OKW_Memorize_xml
	 *  \~english
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2013.11.28
	 *  
	 *  /TODO: Prüfen wozu das hier nich benötigt wird.
	 */
	public void save()
	{
		// Hint: The Name of Property with the Path nad Filename of the Properties-file
		// to be loaded is "OKW_Memorize.properties"
		Properties.getProperty( "OKW_Memorize.properties", "OKW_Memorize.properties" );
	}

	/** \~german
	 * Setzt/Merkt sich das MemKey/Value-Paar.
	 * 
	 * @param fpsKey MemKey - Schlüssel für den Zugriff auf den Wert.
	 * @param fpsValue Wert, der gemerkt werden soll.
	 * @throws XPathExpressionException 
	 *  \~english
	 * @param fpsKey
	 * @param fpsValue
	 * @throws XPathExpressionException
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2014.12.27
	 */
	public void set( String fpsKey, String fpsValue ) throws XPathExpressionException
	{

		// Are we overwriting an existing MemKey?
		if (Value.containsKey(fpsKey))
		{
			String lvsOverwriteKey = LM.GetMessage("Set", "OverwriteKey", fpsKey);
			String lvsOldValue = LM.GetMessage("Set", "OldValue", Value.get(fpsKey));
			String lvsNewValue = LM.GetMessage("Set", "NewValue", fpsValue);

			if (!lvsOldValue.equals( lvsNewValue ))
			{
				Log.ResOpenList(lvsOverwriteKey);
				Log.LogPrint(lvsOldValue);
				Log.LogPrint(lvsNewValue);
				Log.ResCloseList();
			}
			Instance.Value.put(fpsKey, fpsValue);
		}
		else
		{
			Instance.Value.put(fpsKey, fpsValue);

			Log.ResOpenList(LM.GetMessage("Set", "SetValue", fpsKey, fpsValue));
			String lvsMessage = LM.GetMessage("Set", "SetKeyAndValue", fpsKey, fpsValue);
			Log.LogPrint( lvsMessage);
			Log.ResCloseList();
		}

		// persistentes Speichern aller Daten...
		// TODO: Prüfen: das wurde ebntfern. Frage soll hier eine Persisntes eingebaut werden?
		// Instance.save();
	}
}
