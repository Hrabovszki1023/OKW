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

import javax.xml.bind.annotation.*;
import okw.parser.*;;

// \~german
// \brief
// Property-Klasse die Umgebungseigenschaften von OKW zur Verfügung stellt.
// 
// Diese Klasse darf ausschliesslich nur über die OKW.OK_Ini verwendet werden.
// 
// __Anmerkung:__ Die Klasse ist public, weil diese mit System.Xml.Serialization in/aus der Datei OKW_Ini.xml
// serialisert/deserialisert wird.
// 
// * Folgende Umgebungswerte werden durch OKW_Enviroment zur Verfügung gestellt:
// * 
// * Name            | Beschreibung
// * --------------- | -------------
// * OKW.OKW_Root    | Wurzelverzeichniss von OKW. In diesem Verzechniss sind die Bestandteile von OKW abgelegt
// * OKW.OKW_DocuXml | Pfad und Dateiname, der zuladenden Docu_XML.xml Datei.
// *
// * 
// * \~english
// * \~
// * \author Zoltán Hrabovszki
// * \date 2013.11.28
// */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OKW_Enviroment
{
	
	// \~german
	// \brief Variable hält den Pfad zum XML Verzeichniss vor
	//
	// \~english 
	// \brief Variable has in store the path to Folder _XML_.
	// 
	// \~ 
	// \author Zoltán Hrabovszki 
	// \date 2014_10_25
	private String	Folder_XML;

	// \~german
	// \brief Variable hält den Pfad zum _LogMessages_ Verzeichniss vor
	//
	// \~english
	// \brief Variable has in store the path to Folder _LogMessages_.
	// 
	// \~
	// \author Zoltán Hrabovszki
	// \date 2014.10.25
	private String	Folder_LogMessages;

	//
	// \~german
	// \brief Variable hält Pfad und Dateinamen der OKW_Ini.xml vor.
	// 
	//
	// \~english 
	// \brief Variable has in store the path- and filename of
	// OKW_Ini.xml.
	// 
	//
	// \~
	// \author Zoltán Hrabovszki
	// \date 2014_10_25
	private String	File_OKW_Ini_xml;

	// \~german 
	// \brief Privates Feld der Eigenschaft OKW_Const. Enthält den Pfad
	// und den Dateinamen auf die Datei OKW_Const.xml.
	// 
	// Siehe zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br/> Beschreibung
	// des Propertys ist unter OKW.OKW_Enviroment zufinden.
	// 
	// \~english
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.12.02
	private String	File_OKW_Const_xml					= "${Folder_XML}\\OKW_Const.xml";

	//
	// \~german 
	// \brief Privates Feld der Eigenschaft OKW_Keymaps. Enthält den
	// Pfad und den Dateinamen auf die Datei OKW_Keymaps.xml.
	// 
	// Siehe zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br/>
	// Beschreibung des Properties ist unter OKW.OKW_Enviroment zufinden.
	// 
	// \~english 
	// \~ 
	// \author Zoltán Hrabovszki 
	// \date 2013.12.02
	private String	File_OKW_Keymaps_xml				= "${Folder_XML}\\OKW_Keymaps.xml";

	//
	// \~german
	// \brief Privates Feld der Eigenschaft OKW_Memorize. Enthält den
	// Pfad und den Dateinamen auf die Datei OKW_Memorize.xml.
	// 
	// Siehe zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br/> Beschreibung
	// des Propertys ist unter OKW.OKW_Enviroment zufinden.
	// 
	// \~english
	// \~ 
	// \author Zoltán Hrabovszki 
	// \date 2013.12.02
	//
	private String	File_OKW_Memorize_xml				= "${Folder_XML}\\OKW_Memorize.xml";

	//
	// \~german 
	// \brief Privates Feld der Eigenschaft OKW_Docu. Enthält den Pfad
	// und den Dateinamen auf die Datei OKW_Memorize.xml.
	// 
	// Siehe zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br/> Beschreibung
	// des Propertys ist unter OKW.OKW_Enviroment zufinden.
	// 
	// \~english
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.12.02
	private String	File_OKW_Docu_xml_					= "${Folder_XML}\\OKW_Docu.xml";

	//
	// \~german
	// \brief Privates Feld der Eigenschaft OKW_ImplementationMatrix.
	// Enthält den Pfad und den Dateinamen auf die Datei
	// OKW_ImplementationMatrix.xml.
	// 
	// Siehe zum Ablauf der Initialisierung unter OKW.OKW_Ini.<br/>
	// Beschreibung des Properties ist unter OKW.OKW_Enviroment zufinden.
	// 
	// \~english
	// \~
	// \author Zoltán Hrabovszki
	// \date 2013.12.02
	private String	File_OKW_ImplementationMatrix_xml	= "${Folder_XML}\\OKW_ImplementationMatrix.xml";

	 //
	 // \~german 
	 // \brief Konstruktor der Klasse OKW_Enviroment.
	 // 
	 // __Anmerkung:__ Konstruktor ist public, weil diese Klasse mit
	 // System.Xml.Serialization in/aus der Datei OKW_Ini.xml
	 // serialisert/deserialisert wird. System.Xml.Serialization verlangt dazu
	 // einen öffentlichen Konstruktor.
	 // 
	 // \~english
	 // \~ 
	 // \author Zoltán Hrabovszki \date 2013.11.28
	 //
	public OKW_Enviroment()
	{
	}

	//
	// \~german 
	// \brief Property get/set von __Folder_XML
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.__Folder_XML 
	// \~english
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlIgnore]
	public String getFolder_XML()
	{
		return OKW_FileHelper.convertDirectorySeperator(this.Folder_XML);
	}

	public void setFolder_XML( String value )
	{
		this.Folder_XML = value;
	}

	//
	// \~german \brief Property get/set von __Folder_LogMessages
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.__Folder_LogMessages
	// \~english 
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("Folder_LogMessages")]
	public String getFolder_LogMessages()
	{
		return OKW_FileHelper.convertDirectorySeperator(this.Folder_LogMessages);
	}

	public void setFolder_LogMessages( String value )
	{
		this.Folder_LogMessages = value;
	}

	// \~german \brief Property get/set von File_OKW_Ini_xml
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.File_OKW_Ini_xml
	// \~english 
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("File_OKW_Ini_xml")]
	public String getFile_OKW_Ini_xml()
	{
		String myPath = Parser.ParseMe(this.File_OKW_Ini_xml);
		
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_Ini_xml( String value )
	{
		this.File_OKW_Ini_xml = value;
	}

	// \~german
	// \brief Property get/set von File_OKW_Keymaps_xml
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.File_OKW_Keymaps_xml
	// \~english
	// \~
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("File_OKW_Keymaps_xml")]
	public String getFile_OKW_Keymaps_xml()
	{
		String myPath = Parser.ParseMe(this.File_OKW_Keymaps_xml);
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_Keymaps_xml( String value )
	{
		this.File_OKW_Keymaps_xml = value;
	}

	// \~german 
	// \brief Property get/set von File_OKW_Memorize_xml
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.File_OKW_Memorize_xml
	// \~english
	// \~
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("File_OKW_Memorize_xml")]
	public String getFile_OKW_Memorize_xml()
	{
		String myPath = Parser.ParseMe(this.File_OKW_Memorize_xml);
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_Memorize_xml( String value )
	{
		this.File_OKW_Memorize_xml = value;
	}

	//
	// \~german
	// \brief Property get/set von File_OKW_ImplementationMatrix_xml
	// 
	// \see Beschreibung des Wertes siehe:
	// OKW_Enviroment.File_OKW_ImplementationMatrix_xml 
	// \~english 
	// \~ 
	// \author Zoltán Hrabovszki 
	// \date 2013.11.28
	//
	// [XmlElement("File_OKW_ImplementationMatrix_xml")]
	public String getFile_OKW_ImplementationMatrix_xml()

	{
		String myPath = Parser.ParseMe(this.File_OKW_ImplementationMatrix_xml);
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_ImplementationMatrix_xml( String value )
	{
		this.File_OKW_ImplementationMatrix_xml = value;
	}

	//
	// \~german
	// \brief Property get/set von File_OKW_Const_xml
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.File_OKW_Const_xml
	// \~english
	// \~
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("File_OKW_Const_xml")]
	public String getFile_OKW_Const_xml()

	{
		String myPath = Parser.ParseMe(this.File_OKW_Const_xml);
		
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_Const_xml( String value )
	{
		this.File_OKW_Const_xml = value;
	}

	//
	// \~german 
	// \brief Property get/set von File_OKW_Const_xml
	// 
	// \see Beschreibung des Wertes siehe: OKW_Enviroment.File_OKW_Const_xml
	// \~english 
	// \~ 
	// \author Zoltán Hrabovszki
	// \date 2013.11.28
	//
	// [XmlElement("OKW_Docu.xml")]
	public String getFile_OKW_Docu_xml()

	{
		String myPath = Parser.ParseMe(this.File_OKW_Docu_xml_);
		
		return OKW_FileHelper.convertDirectorySeperator(myPath);
	}

	public void setFile_OKW_Docu_xml( String value )
	{
		this.File_OKW_Docu_xml_ = value;
	}

}
