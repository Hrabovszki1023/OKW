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
 *  Die Daten werden vie Serialisierung in eine XML Datei geschrieben.
 *  Zur Serialisierung wird die Klasse System.Xml.XmlSerializer verwendet.
 *  
 *  Pfad und Name der XML-Datei. Dies wird in der XML/OKW_Ini.xml vorgegeben:
 *  <code>XPATH: OKW_Ini/OKW_Enviroment/OKW_Memorize_xml</code>
 *  
 *  Diese Klasse ist nach denm Singelton-Muster aufgebaut.
 *  
 *  Die Instanz der Klasse wird wie folgt abgerufen:
 *  
 *  ~~~~~~~~~~~~~{.py}
 *  OKW.OKW_Memorrize.Instanz
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
	 *  @date 2013.11.28
	 */
	public String OKW_Memorize_xml	= "";

	 /**  \~german
	 *  Dictionary speichert die Schlüssel-Wert Paare.
	 * 
	 *  @note Dieses Feld _muss_ wegen der Serialisierung _public_ sein.
	 *   http://howtodoinjava.com/2013/07/30/jaxb-example-marshalling-and-unmarshalling-hashmap-in-java/
	 *  \~english
	 *  \brief
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  @date 2013.11.28
	 */
	public Map<String, String>	_Value	= new HashMap<String, String>();

	 /**  \~german
	 *  Singelton spezifisch: Dieses Feld speichert die einzige Instanz dieser
	 *  Klasse.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.11.28
	 */
	private static OKW_Memorize_Sngltn	Instance;

	
	/** \~german
	 *  Eine lokale Instanz des OKW.Log.LogMssenger.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2014.12.28
	 */
	private LogMessenger LM	= null;

	 /**  \~german
	 *  Referenz auf die einzige Instanz des Klasse OKW.Logger.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.11.28
	 */
	private Logger_Sngltn									Log					= Logger_Sngltn.getInstance();

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
	 *  @date 2014.14.27
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
	 *  @date 2014.14.27
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
	 *  @date 2013.11.25
	 */
	public static void Reset()
	{
		Instance = null;
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
	 *  @date 2013.11.25
	 */
	public Boolean Exists( String fpsKey )
	{
		Boolean lvbReturn = false;

		Log.LogFunctionStartDebug(Instance.getClass().getName() + ".Exists", "String fpsKey", fpsKey);

		if (_Value.containsKey(fpsKey))
		{
			lvbReturn = true;
		}

		Log.LogFunctionEndDebug(lvbReturn);

		return lvbReturn;
	}

	/** \~german
	 *
	 *  Holt den Aktuellen Wert eines Schlüssels.
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
	 *  @date 2014.12.27
	 */
	public String Get( String fpsKey )
	{
		String lvsReturn = null;

		Log.LogFunctionStartDebug(Instance.getClass().getName() + ".Get", "String fpsKey", fpsKey);

		try
		{
			if (_Value.containsKey(fpsKey))
			{
				lvsReturn = _Value.get(fpsKey);
			}
			else
			{
				String ErrorText = LM.GetMessage("Get", "OKWMemorizeKeyNotExistsException", fpsKey);
				throw new OKWMemorizeKeyNotExistsException(ErrorText);
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
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
	public void Init()
	{
		Log.LogFunctionStartDebug(this.getClass().getName() + ".Init");

		// Klassen Variablen erst löschen...
		Instance.OKW_Memorize_xml = "";
		Instance._Value.clear();

		// ... und dann alles Initialisieren!
		// 1. Setze Pfad und
		OKW_Memorize_xml = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Memorize_xml();

		if (!OKW_Helper.isStringNullOrEmpty(this.OKW_Memorize_xml))
		{
			this.Log.LogPrintDebug("OKW Memorize Datei = >>" + this.OKW_Memorize_xml + "<<");
			if (OKW_FileHelper.fileExists(this.OKW_Memorize_xml))
			{
				// Lesen der Daten...
				this.Read();
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

		Log.LogFunctionEndDebug();
	}

	/** \~german
	 *  Liest die Werte der Klasse OKW_Memorize aus einer Datei,
	 *  gegeben in OKW.OKW_Ini.Xml_Ini_xml, ein.
	 *  Es wird eine XML Datei gelesen. Hierzu wird die Klasse OKW_Memorize mit
	 *  System.Xml.XmlSerializer deserialisiert.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.11.28
	 */
	public void Read()
	{
		Log.LogFunctionStartDebug(Instance.getClass().getName() + "Read()");

		try
		{
			OKW_XmlReader myXMLReader = new OKW_XmlReader("xml/OKW_Memorize.xml");			
		}
		catch(Exception e)
		{
			Log.LogPrintDebug(e.getMessage());
		}
		finally
		{
			Log.LogFunctionEndDebug();
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
	 */
	public void Save()
	{
		Log.LogFunctionStartDebug(Instance.getClass().getName() + ".Save");

		try
		{
/*			XmlSerializer serializer = new XmlSerializer(typeof(OKW_Memorize_Sngltn));
			StreamWriter fs = new StreamWriter(this.OKW_Memorize_xml, false);
			serializer.Serialize(fs, Instance);
			fs.Close();
			
			
			JAXBContext context = JAXBContext.newInstance( Player.class );
			Marshaller m = context.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.marshal( johnPeel, System.out );
*/			
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}
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
	public void Set( String fpsKey, String fpsValue ) throws XPathExpressionException
	{
		Log.LogFunctionStartDebug(Instance.getClass().getName() + ".Set", "String fpsKey", fpsKey,
				"String fpsValue", fpsValue);

		try
		{
			// Are we overwriting an existing MemKey?
			if (_Value.containsKey(fpsKey))
			{
				String lvsOverwriteKey = LM.GetMessage("Set", "OverwriteKey", fpsKey);
				String lvsOldValue = LM.GetMessage("Set", "OldValue", _Value.get(fpsKey));
				String lvsNewValue = LM.GetMessage("Set", "NewValue", fpsValue);
				
				if (!lvsOldValue.equals( lvsNewValue ))
				{
				    Log.ResOpenList(lvsOverwriteKey);
				    Log.LogPrint(lvsOldValue);
				    Log.LogPrint(lvsNewValue);
				    Log.ResCloseList();
				}
				Instance._Value.put(fpsKey, fpsValue);
			}
			else
			{
				Instance._Value.put(fpsKey, fpsValue);

				Log.ResOpenList(LM.GetMessage("Set", "SetValue", fpsKey, fpsValue));
				String lvsMessage = LM.GetMessage("Set", "SetKeyAndValue", fpsKey, fpsValue);
				Log.LogPrint( lvsMessage);
				Log.ResCloseList();
			}

			// persistentes Speichern aller Daten...
			Instance.Save();
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}
	}
}
