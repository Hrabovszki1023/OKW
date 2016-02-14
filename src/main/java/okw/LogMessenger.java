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

import okw.exceptions.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

/// \~german
/// \brief
/// LogMessenger liest Log-Meldungen sprachspezifisch für die im Konstruktor gegeben Klasse aus der Zugehörigen XML-Datei.
/// 
/// Die Log-Meldungen sind in XML-Dateien ausgelagert.
/// Die XML-Dateien müssn in Verzeichniss gegeben in OKW_Ini.Instance.OKW_Enviroment.PathLog abgelegt sein.
/// (Defaultwert: <code>/XML/Log</code>)
/// 
/// Die XML-Struktur sieh wie folgt aus:
/// 
/// ~~~~~~~~~~~~~~~{.c}
/// <Class name="MeineKlasse">
///	    <Method name="MeineMethode">
///         <Text key="MeinTextschlüssel">
///             <en>Text with Parameter '{0:}'.</en>
///             <de>Text mit einem Parameter '{0:}'.</de>
///         </Text>
///     </Method>
/// </Class>
/// ~~~~~~~~~~~~~~~
/// 
/// Dabei können
/// 
/// - je Klasse n-Methoden
/// - je Methode n-Textschlüssel.
/// - Je Textschlüssel können n-Überstezungen
/// definiert werden.
/// 
/// Die aktuelle Sprache kommt aus OKW.OKWLanguage.getInstance.Language
/// 
/// \info
/// Die englische Üersetzung _muss_ immer vorhanden sein.
/// Sollte eine andere Übersetzung fehlen, dann wir die englische Log-Meldung zurückgeliefert.
/// 
/// 
/// \~english
/// 
/// 
/// \brief
/// \~
/// \author Zoltan Hrabovszki
/// \date 2013_12_22 <br/>
public class LogMessenger
{

	private Boolean					bInit			= false;
	private String					cvsClassName	= "";

	private Path					myXMLFile;
	private Document				myXMLDocument;
	private DocumentBuilderFactory	mydbFactory;
	private DocumentBuilder			mydBuilder;
	private XPath					myXPath;

	public String getXMLFile()
	{
		return myXMLFile.toString();
	}

	public void setXMLFile( String xMLFile )
	{
		myXMLFile = Paths.get(xMLFile);
	}

	/// \~german
	/// \brief
	///
	/// -# Speichern des Klassennamens.
	/// -# Initialisieren der Klasse.
	///
	/// \param fpsClassname Name der Klasse. Wird verwendet um die Instanz der
	/// Klasse mit der zugehärige XML-Datei zu verbinden.
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013_12_22
	public LogMessenger(String fpsClassname)
	{
		try
		{
			this.cvsClassName = fpsClassname;
			this.Init();
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}
	}

	/// \~german
	/// \brief
	/// Holt die Log-Meldung für MethodeNmae/Textkey ohne weitere Parameter.
	///
	/// \param MethodName Name der Methode
	/// \param TextKey Text-Schlüssel
	///
	/// \return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	///
	/// \~english
	/// Gets the Message for the Methodename/TextKey without any Parametres.
	///
	/// \param MethodName Name of the Method
	/// \param TextKey of the message
	///
	/// \return Log-Message for the given Parameter.
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.22
	public String GetMessage( String MethodName, String TextKey )
	{
		String lvs_Return = "Message Not Found!";

		try
		{
			lvs_Return = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvs_Return;
	}

	/// \~german
	/// \brief
	/// Holt die Log-Meldung für MethodeNmae/Textkey und einem Parameter.
	///
	/// \param MethodName Name der Methode
	/// \param TextKey Text-Schlüssel
	/// \param Parameter_1 Wert der in der Log_Meldung mit ausgegeben wird.
	///
	/// \return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	///
	/// \~english
	/// \brief
	/// Gets the Message for the Methodename/TextKey with _one_ Parametres.
	///
	/// \param MethodName Name of the Method
	/// \param TextKey of the message
	/// \param Parameter_1 One Value inserted in the Log-Message
	/// \return Log-Message for the given Parameter.
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.22
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1 )
	{
		String lvs_Return = "";

		try
		{
			lvs_Return = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
			lvs_Return = String.format(lvs_Return, Parameter_1);
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvs_Return;
	}

	/// \~german
	/// \brief
	/// Holt die Log-Meldung für MethodeNmae/Textkey und einem Parameter.
	///
	/// \param MethodName Name der Methode
	/// \param TextKey Text-Schlüssel
	/// \param Parameter_1 1. Wert der in der Log_Meldung mit ausgegeben wird.
	/// \param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	///
	/// \return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	///
	/// \~english
	/// \brief
	/// Gets the Message for the Methodename/TextKey with _one_ Parametres.
	///
	/// \param MethodName Name of the Method
	/// \param TextKey of the message
	/// \param Parameter_1 First Value inserted in the Log-Message
	/// \param Parameter_2 Second Value inserted in the Log-Message
	///
	/// \return Log-Message for the given Parameter.
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.22
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1, Object Parameter_2 )
			throws XPathExpressionException
	{
		String lvs_Return = "Message Not Found!";

		lvs_Return = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
		lvs_Return = String.format(lvs_Return, Parameter_1, Parameter_2);

		return lvs_Return;
	}

	/// \~german
	/// \brief
	/// Holt die Log-Meldung für MethodeNmae/Textkey und drei Parameter.
	///
	/// \param MethodName Name der Methode
	/// \param TextKey Text-Schlüssel
	/// \param Parameter_1 1. Wert der in der Log_Meldung mit ausgegeben wird.
	/// \param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	/// \param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	///
	/// \return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	///
	/// \~english
	/// \brief
	/// Gets the Message for the Methodename/TextKey with _one_ Parametres.
	///
	/// \param MethodName Name of the Method
	/// \param TextKey of the message
	/// \param Parameter_1 First Value inserted in the Log-Message
	/// \param Parameter_2 Second Value inserted in the Log-Message
	///
	/// \return Log-Message for the given Parameter.
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.22
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1, Object Parameter_2,
			Object Parameter_3 )
	{
		String lvs_Return = "Message Not Found!";
		
		try
		{
			lvs_Return = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
			lvs_Return = String.format(lvs_Return, Parameter_1, Parameter_2, Parameter_3);
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvs_Return;
	}

	/// \~german
	/// \brief
	/// Initialisiert die Klasse:
	///
	/// * LM- Dateinamen als ermitteln
	///
	/// \~english
	/// \brief
	/// This constructor has no Parameter and uses the default values for the
	/// config-file and Actual/default language(=EN)
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013_12_22
	private void Init() throws JAXBException, ParserConfigurationException, SAXException, IOException
	{
		if (!this.bInit)
		{
			try
			{

				this.myXMLFile = Paths.get(OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFolder_LogMessages(),
						"LM_" + this.cvsClassName + ".xml");

				if (!OKW_FileHelper.FileExists(myXMLFile.toString()))
				{
					System.out.println(
							"============================================================================================================");
					System.out.println("OKW Exception: File not found! -> '" + myXMLFile.toString() + "'");
					System.out.println(
							"============================================================================================================");

					throw new FileNotFoundException(
							"File not found! The File was: '" + this.myXMLFile.toString() + "'");
				}
				else
				{
					this.mydbFactory = DocumentBuilderFactory.newInstance();
					this.mydBuilder = mydbFactory.newDocumentBuilder();
					this.myXMLDocument = mydBuilder.parse(this.myXMLFile.toFile());
					this.myXPath = XPathFactory.newInstance().newXPath();
				}

				this.bInit = true;
			}
			finally
			{
				System.out.println("");
			}
		}
	}

	/// \~german
	/// \brief
	/// Interne Kernfunktion holt die Log-Meldung mit Platzhaltern aus der
	/// XML-Datei.
	/// "ClassName", "MethodName" and "TextKey" and Actual language from
	/// ini-file.
	///
	/// \param ClassName Name of the Class.
	/// \param MethodName Name of the Method.
	/// \param TextKey Key for the Text-Message.
	///
	/// \~english
	/// \brief
	/// \exception OKWMessageNotFoundException if a Message ist not found or if
	/// more then one Message is found for the Given Parmeter.
	///
	/// \param ClassName Name of the Class.
	/// \param MethodName Name of the Method.
	/// \param TextKey Key for the Text-Message.
	///
	/// \return Rreturns the Message for the given language or default language
	/// if given languae does not exist<br/>
	/// _"Message Not Found!"_ will be returnd, if a doesn´s exist.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013_12_22
	private String ReadMessage( String ClassName, String MethodName, String TextKey )
	{
		String lvsReturn = "Message Not Found!";

		try
		{
			String myXPathExpression = "//Class[@name='" + ClassName + "']/Method[@name='" + MethodName
					+ "']/Text[@key='" + TextKey + "']/" + okw.OKWLanguage.getInstance().getLanguage();

			NodeList myNodeList = (NodeList) myXPath.compile(myXPathExpression).evaluate(this.myXMLDocument,
					XPathConstants.NODESET);

			if (myNodeList.getLength() > 0)
			{
				Node myNode = myNodeList.item(0);
				lvsReturn = myNode.getTextContent();
			}
			else
			{
				throw new OKWMessageNotFoundException("Message not Found. Class: " + ClassName + ",  Method: "
						+ MethodName + ", TextKey: " + TextKey);
			}
		}
		catch (OKWMessageNotFoundException | XPathExpressionException e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvsReturn;
	}

}
