/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

/* \~german
* \brief
* Property-Klasse von OKW.OKW_Ini. Stellt Umgebungseigenschaften von OKW zur Verfügung.
* 
* Diese Klasse darf ausschliesslich nur über die OKW.OK_Ini verwendet werden.<br>
* __Anmerkung:__ Die Klasse ist public, weil diese mit System.Xml.Serialization in/aus der Datei OKW_Ini.xml
* serialisert/deserialisert wird. System.Xml.Serialization verlangt einen öffentliche Felder und einen öffentlichen Konstruktor.
* 
* Folgende Umgebungswerte werden durch OKW_Enviroment zur Verfügung gestellt:
* 
* Name                                    | Beschreibung
* --------------------------------------- | -------------
* OKW.OKW_CustomSettings.Language         | Default Spracheinstellung für Log- oder sonstige Ausgaben.
* OKW.OKW_CustomSettings.FramePrefix      | Frame-Prefix, Frame Definitionen üssen mit diesen Zeichen Anfangen.
* OKW.OKW_CustomSettings.PathSep          | Pfad Separator. z.B. "\" in C:\temp.
* OKW.OKW_CustomSettings.TimeOutExists    | GUI-Objekt Exitenz-Prüfung, TimeOut wenn erwartet wird, dass das GUI-Objekt vorhaden ist.
* OKW.OKW_CustomSettings.TimeOutNotExists | GUI-Objekt Exitenz-Prüfung, TimeOut wenn erwartet wird, dass das GUI-Objekt nicht vorhaden ist.
* 
* 
* \~english
* \~
* \author Zoltán Hrabovszki
* \date 2013.11.28
 */
// [XmlRoot("CustomSettings"), Serializable]
public class OKW_CustomSettings
{

	/*
	 * \~german \brief Privates Feld des Propertys Language.
	 * 
	 * Wert wird 1. auf Default initialisiert 2. danach auf den Wert aus
	 * XML_Ini.xml deseariliser, vorhanden.
	 * 
	 * Siehe Beschreibung zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br>
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings zufinden.
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	private String	Language			= "en";

	/*
	 * \~german \brief Privates Feld des Propertys PathSep.
	 * 
	 * Wert wird 1. auf Default initialisiert 2. danach auf den Wert aus
	 * XML_Ini.xml deseariliser, vorhanden.
	 * 
	 * Siehe Beschreibung zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br>
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings zufinden.
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	private String	PathSep				= "/";

	/*
	 * \~german \brief Privates Feld des Propertys TimeOutExists.
	 * 
	 * Wert wird 1. auf Default initialisiert 2. danach auf den Wert aus
	 * XML_Ini.xml deseariliser, vorhanden.
	 * 
	 * Siehe Beschreibung zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br>
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings zufinden.
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	private int		TimeOutExists		= 30;

	/*
	 * \~german \brief Privates Feld des Propertys TimeOutNotExists.
	 * 
	 * Wert wird 1. auf Default initialisiert 2. danach auf den Wert aus
	 * XML_Ini.xml desearilisert.
	 * 
	 * Siehe Beschreibung zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br>
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings zufinden.
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	private Integer	TimeOutNotExists	= 30;

	/*
	 * \~german \brief Konstruktor der Klasse OKW_CustomSetting.<br>
	 * __Anmerkung:__ Konstruktor ist public, weil diese Klasse mit
	 * System.Xml.Serialization in/aus der Datei OKW_Ini.xml
	 * serialisert/deserialisert wird. System.Xml.Serialization verlangt einen
	 * öffentlichen Konstruktor.
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.11.28
	 */
	public OKW_CustomSettings()
	{
	}

	/*
	 * \~german \brief Öffentliches Property "Language".
	 *
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings
	 * zufinden.<br> Siehe auch die Beschreibung zu
	 * OKW.OKW_CustomSettings.__Language
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	// [XmlElement("Language")]
	public String getLanguage()
	{
		return this.Language;
	}

	public void setLanguage( String value )
	{
		this.Language = value;
	}

	/*
	 * \~german \brief Öffentliches Property "PathSep".
	 *
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings
	 * zufinden.<br> Siehe auch die Beschreibung zu
	 * OKW.OKW_CustomSettings.__PathSep
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	// [XmlElement("PathSep")]
	public String getPathSep()
	{
		return this.PathSep;
	}

	public void setPathSep( String value )
	{
		this.PathSep = value;
	}

	/*
	 * \~german \brief Öffentliches Property "TimeOutExists".
	 *
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings
	 * zufinden.<br> Siehe auch die Beschreibung zu
	 * OKW.OKW_CustomSettings.__TimeOutExists
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	// [XmlElement("TimeOutExists")]
	public Integer getTimeOutExists()
	{
		return this.TimeOutExists;
	}

	public void setTimeOutExists( Integer value )
	{
		this.TimeOutExists = value;
	}

	/*
	 * \~german \brief Öffentliches Property "TimeOutNotExists".
	 *
	 * Beschreibung des Propertys ist unter OKW.OKW_CustomSettings
	 * zufinden.<br> Siehe auch die Beschreibung zu
	 * OKW.OKW_CustomSettings.__TimeOutNotExists
	 * 
	 * \~english \~ \author Zoltán Hrabovszki \date 2013.12.02
	 */
	// [XmlElement("TimeOutNotExists")]
	public Integer getTimeOutNotExists()
	{
		return this.TimeOutNotExists;
	}

	public void getTimeOutNotExists( Integer value )
	{
		this.TimeOutNotExists = value;
	}
}
