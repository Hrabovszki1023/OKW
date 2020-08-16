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

import okw.exceptions.*;
import org.stringtemplate.v4.*;

 /**  \~german
 *  LogMessenger liest Log-Meldungen sprachspezifisch für die im Konstruktor gegeben Klasse aus der Zugehörigen XML-Datei.
 *  
 *  Die Log-Meldungen sind in XML-Dateien ausgelagert.
 *  Die XML-Dateien müssn in Verzeichniss gegeben in OKW_Ini.Instance.OKW_Enviroment.PathLog abgelegt sein.
 *  (Defaultwert: <code>/XML/Log</code>)
 *  
 *  Die XML-Struktur sieh wie folgt aus:
 *  
 *  ~~~~~~~~~~~~~~~{.c}
 *  <Class name="MeineKlasse">
 * 	    <Method name="MeineMethode">
 *          <Text key="MeinTextschlüssel">
 *              <en>Text with Parameter '{0:}'.</en>
 *              <de>Text mit einem Parameter '{0:}'.</de>
 *          </Text>
 *      </Method>
 *  </Class>
 *  ~~~~~~~~~~~~~~~
 *  
 *  Dabei können
 *  
 *  - je Klasse n-Methoden
 *  - je Methode n-Textschlüssel.
 *  - Je Textschlüssel können n-Überstezungen
 *  definiert werden.
 *  
 *  Die aktuelle Sprache kommt aus OKW.OKWLanguage.getInstance.Language
 *  
 *  @info
 *  Die englische Üersetzung _muss_ immer vorhanden sein.
 *  Sollte eine andere Übersetzung fehlen, dann wir die englische Log-Meldung zurückgeliefert.
 *  
 *  \~english
 *  
 *  \~
 *  @author Zoltan Hrabovszki
 *  \date 2013_12_22
 */
public class LogMessenger
{

	private String		  cvsClassName	= "";
	private OKW_XmlReader myXmlReader;
	

	/**  \~german
	 * 
	 * -# Speichern des Klassennamens.
	 * -# Initialisieren der Klasse.
	 * 
	 * @param fpsClassname Name der Klasse. Wird verwendet um die Instanz der
	 *  Klasse mit der zugehärige XML-Datei zu verbinden.
	 * \~english
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2013_12_22
	 */
	public LogMessenger(String fpsClassname)
	{
		try
		{
			this.cvsClassName = fpsClassname;
			String myXMLFile = "/xml/logmessages/LM_" + this.cvsClassName + ".xml";
			myXmlReader = new OKW_XmlReader(myXMLFile);
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}
	}
	
	/**
	 * \~german
	 *  Holt die Log-Meldung für MethodeNmae/Textkey ohne weitere Parameter.
	 * 
	 *  @param MethodName Name der Methode
	 *  @param TextKey Text-Schlüssel
	 * 
	 *  @return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	 * 
	 *  \~english
	 *  Gets the Message for the Methodename/TextKey without any Parametres.
	 * 
	 *  @param MethodName Name of the Method
	 *  @param TextKey of the message
	 * 
	 *  @return Log-Message for the given Parameter.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.12.22
	 */
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

	/**
	 *   \~german
	 *  Holt die Log-Meldung für MethodeNmae/Textkey und einem Parameter.
	 * 
	 *  @param MethodName Name der Methode
	 *  @param TextKey Text-Schlüssel
	 *  @param Parameter_1 Wert der in der Log_Meldung mit ausgegeben wird.
	 * 
	 *  @return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	 * 
	 *  \~english
	 *  \brief
	 *  Gets the Message for the Methodename/TextKey with _one_ Parametres.
	 * 
	 *  @param MethodName Name of the Method
	 *  @param TextKey of the message
	 *  @param Parameter_1 One Value inserted in the Log-Message
	 *  @return Log-Message for the given Parameter.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.12.22
	 */
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1 )
	{
		String lvsReturn = "";
    String lvsTemplate = "";
		try
		{
		  lvsTemplate = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
			
			ST st = new ST(lvsTemplate, '$', '$');
			st.add("P1", Parameter_1);
			lvsReturn = st.render();
			
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvsReturn;
	}

	/**  \~german
	 *  Holt die Log-Meldung für MethodeNmae/Textkey und einem Parameter.
	 * 
	 *  @param MethodName Name der Methode
	 *  @param TextKey Text-Schlüssel
	 *  @param Parameter_1 1. Wert der in der Log_Meldung mit ausgegeben wird.
	 *  @param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	 * 
	 *  @return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	 * 
	 *  \~english
	 *  Gets the Message for the Methodename/TextKey with _one_ Parametres.
	 * 
	 *  @param MethodName Name of the Method
	 *  @param TextKey of the message
	 *  @param Parameter_1 First Value inserted in the Log-Message
	 *  @param Parameter_2 Second Value inserted in the Log-Message
	 * 
	 *  @return Log-Message for the given Parameter.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.12.22
	 */
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1, Object Parameter_2 )
  {
    String lvsReturn = "";
    String lvsTemplate = "";
    try
    {
      lvsTemplate = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
      
      ST st = new ST(lvsTemplate, '$', '$');
      st.add("P1", Parameter_1);
      st.add("P2", Parameter_2);
      lvsReturn = st.render();
      
    }
    catch (Exception e)
    {
      OKW_HandleException.StopRunning(e, this.getClass());
    }

    return lvsReturn;
  }


	 /**  \~german
	 *  \brief
	 *  Holt die Log-Meldung für MethodeNmae/Textkey und drei Parameter.
	 * 
	 *  @param MethodName Name der Methode
	 *  @param TextKey Text-Schlüssel
	 *  @param Parameter_1 1. Wert der in der Log_Meldung mit ausgegeben wird.
	 *  @param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	 *  @param Parameter_2 2. Wert der in der Log_Meldung mit ausgegeben wird.
	 * 
	 *  @return Log-Meldung für die gegebene Paremeter und aktuelle Sprache.
	 * 
	 *  \~english
	 *  Gets the Message for the Methodename/TextKey with _one_ Parametres.
	 * 
	 *  @param MethodName Name of the Method
	 *  @param TextKey of the message
	 *  @param Parameter_1 First Value inserted in the Log-Message
	 *  @param Parameter_2 Second Value inserted in the Log-Message
	 * 
	 *  @return Log-Message for the given Parameter.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.12.22
	 */
	public String GetMessage( String MethodName, String TextKey, Object Parameter_1, Object Parameter_2,
			Object Parameter_3 )
  {
    String lvsReturn = "";
    String lvsTemplate = "";
    try
    {
      lvsTemplate = this.ReadMessage(this.cvsClassName, MethodName, TextKey);
      
      ST st = new ST(lvsTemplate, '$', '$');
      st.add("P1", Parameter_1);
      st.add("P2", Parameter_2);
      st.add("P3", Parameter_3);
      lvsReturn = st.render();
      
    }
    catch (Exception e)
    {
      OKW_HandleException.StopRunning(e, this.getClass());
    }

    return lvsReturn;
  }


	/**
	 *  \~german
	 *  Interne Kernfunktion holt die Log-Meldung mit Platzhaltern aus der
	 *  XML-Datei.
	 *  "ClassName", "MethodName" and "TextKey" and Actual language from
	 *  ini-file.
	 * 
	 *  @param ClassName Name of the Class.
	 *  @param MethodName Name of the Method.
	 *  @param TextKey Key for the Text-Message.
	 * 
	 *  \~english
	 * 
	 *  @param ClassName Name of the Class.
	 *  @param MethodName Name of the Method.
	 *  @param TextKey Key for the Text-Message.
	 * 
	 *  @return Rreturns the Message for the given language or default language
	 *  if given languae does not exist<br>
	 *  
	 *  _"Message Not Found!"_ will be returnd, if a doesn´s exist.
	 *  
     *  @exception OKWMessageNotFoundException if a Message ist not found or if
     *  more then one Message is found for the Given Parmeter.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2013_12_22
	 */
	private String ReadMessage( String ClassName, String MethodName, String TextKey )
	{
		String lvsReturn = "Message Not Found!";

		try
		{
			String Language = OKWLanguage.getInstance().getLanguage();
			
			String myXPathExpression = "//Class[@name='" + ClassName + "']/Method[@name='" + MethodName + "']/Text[@key='" + TextKey + "']/" + Language;
			
			lvsReturn = myXmlReader.getTextContentSingleValue(myXPathExpression);

			if (lvsReturn.isEmpty())
			{
				throw new OKWMessageNotFoundException("Message not Found. Class: " + ClassName + ",  Method: "
						+ MethodName + ", TextKey: " + TextKey);
			}
		}
		catch (OKWMessageNotFoundException e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvsReturn;
	}
}
