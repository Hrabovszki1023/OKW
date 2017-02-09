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
package okw.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW_TimeOut;
import okw.core.IOKW_FN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.*;

/** \brief
 * Description of AnyWin.
 */ 
public abstract class AnyWinBase
{
	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	protected OKWLocator _locator;
	
	/** \~german
   *  Holt den vollständig (rekursiv) aufgelösten  (z.B. XPath-Wert) des Locators.
   *  
   *  Beim Aufruf dieser Methode wird der Locator vollständig neu berechnet und der aktuelle Wert Zurückgeliefert.
   *  (Dynamischer Locator)
   *  
   *  @return Aktueller Wert des Locators
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */
  public String getLocator()
  {
          return this._locator.getLocator();
  }

  /** \~german
   *  Holt die Refrenz auf den (OKWLocator) den Locator selbst.
   *   
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */  
  public OKWLocator getLOCATOR()
  {
          return this._locator;
  }

  
  /** \~german
   *  Prüft die Existenz des aktuellen Objektes.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Hier wird die Ausnahme OKWFrameObjectMethodNotImplemented ausgelöst.
   *  
   *  Hinweis zur Implementierung:
   *  - Implementierung durcg Methoden überschreiung in den GUI-Klassen.
   *  - Ist eine elementare Funktion, muss Werkzeugspezifisch (für Selenium, AutoIt, SilkTets usw.) defiert sein/werden.
   *  - Warten nicht auf die Existenz eines Objektes!
   *  - Es wird nur ein eiziges mal die Existenz geprüft.
   *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist!
   *  
   *  @return true, falls das eindeutig Objekt gefunden worden ist ist, sonst false.
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2017.01.31
   */  
  public Boolean getExists()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getExists() is not definden for you GUI-Object. Please define first the methode!");
  }

  
  public AnyWinBase()
    {
        this._locator = new OKWLocator("");
    }


    public AnyWinBase(String fpsLocator, OKWLocator... fpLocators )
    {
        if ( fpLocators.length != 0 )
        {
            this._locator = new OKWLocator(fpsLocator, fpLocators);
        }
        else
        {
            this._locator = new OKWLocator(fpsLocator);
        }
    }
   
    
    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionStartDebug(fps_FunctionName),
    /// und erweitert den gegebenen Methodenname in fps_FunctionName mit this.GetType().FullName um den Klassenbezeichner.
    /// 
    /// \param fpsMethodName Name der Method  nicht "full quolified reference".
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \param fpsMethodName
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.27
    protected void LogFunctionStartDebug(String fpsMethodName)
    {
    	myLogger.LogFunctionStartDebug(this.getClass().getName() + "." + fpsMethodName);
    }

    /** \~german
     *  \brief
     *  Methode ruft die Methode Logger.Instance.LogFunctionStartDebug(string,string,string),
     *  erweitert den gegebenen Methodenname in fps_FunctionName mit this.GetType().FullName um den Klassenbezeichner.
     *  
     *  @param fpsMethodName Name der Method, aber ohne Paket Angabe.
     *  @param P1_Name Name/Bezeichnung des (ersten) Parameters.
     *  @param P1_Value Wert des ersten Parameters.
     * 
     *  \~english
     *  @todo TODO: LogFunctionStartDebug(String fpsMethodName, String P1_Name, String P1_Value) Übersetzung ins Englische fehlt...
     * 
     *  @param fpsMethodName
     *  @param P1_Name Name/Bezeichnung des ersten Parameters.
     *  @param P1_Value Wert des ersten Parameters.
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    protected void LogFunctionStartDebug(String fpsMethodName, String P1_Name, String P1_Value)
    {
    	myLogger.LogFunctionStartDebug(this.getClass().getName() + "." + fpsMethodName, P1_Name, P1_Value);
    }

    /** \~german
     *  Methode ruft die Methode Logger.Instance.LogFunctionEndDebug() auf.
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.01.18
     */
    protected void LogFunctionEndDebug()
    {
    	myLogger.LogFunctionEndDebug();
    }

    /** \~german
     *  \brief
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(string) auf.
     *  
     *  @param fpsReturn Zu loggender Rückgabewert.
     *  
     *  \~english
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  @param fpsReturn
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.01.18
     */
    protected void LogFunctionEndDebug(String fpReturn)
    {
      if( fpReturn != null) myLogger.LogFunctionEndDebug(fpReturn);
      else myLogger.LogFunctionEnd();
    }

    
    /** \~german
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(bool) auf.
     *  
     *  @param fpbReturn Zu loggender Rückgabewert.
     *  
     *  \~english
     *  \brief
     *  \todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.01.18
     */
    protected void LogFunctionEndDebug(Boolean fpReturn)
    {
      if( fpReturn != null) myLogger.LogFunctionEndDebug(fpReturn);
      else myLogger.LogFunctionEnd();

    }

    /**
     *  \~german
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(ArrayList&lt;string&gt;) auf.
     *  
     *  @param fpLsReturn Zu loggender Rückgabeert.
     *  
     *  \~english
     *  @todo TODO:  Übersetzung ins Englische...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.01.18
     */
    protected void LogFunctionEndDebug(ArrayList<String> fpReturn)
    {
      if( fpReturn != null) myLogger.LogFunctionEndDebug(fpReturn);
      else myLogger.LogFunctionEnd();
    }
}