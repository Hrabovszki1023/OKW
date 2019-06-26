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
package okw.gui;

import java.util.ArrayList;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.*;

/** \brief
 * Description of AnyWin.
 */ 
public abstract class AnyWinBase
{
	private Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	protected OKWLocator _locator = null;

  /** \~german
   *  FN - Funktionaler Name des aktuellen GUI-Objektes.
   *  
   *  Wert wird 
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */    
  private String myFN = "";

  
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  private String myKN = "";

  
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  private String myParentFN = "";

  
   /** \~german
   *  Holt den vollständig (rekursiv) aufgelösten  (z.B. XPath-Wert) des Locators.
   *  
   *  Beim Aufruf dieser Methode wird der Locator vollständig neu berechnet und der aktuelle Wert zurückgeliefert.
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
          return _locator.getLocator();
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
  public OKWLocatorBase getLOCATOR()
  {
          return _locator;
  }

  
  /** \~german
   *  Setzt den Locator für den aktuellen GUI-Adapter.
   *   
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */  
  public void setLocator( String fpsLocator, OKWLocatorBase... fpLocators )
  {
          _locator.setLocator( fpsLocator, fpLocators );
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

  public AnyWinBase( )
  {
      _locator = new OKWLocator( );
  }


    public AnyWinBase(String fpsLocator, OKWLocatorBase... fpLocators )
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
   
    
    /** \~german
     *  Methode ruft die Methode Logger.Instance.LogFunctionStartDebug(fps_FunctionName),
     *  und erweitert den gegebenen Methodenname in fps_FunctionName mit this.getClass().getName() um den Klassenbezeichner.
     *  
     *  @param fpsMethodName Name der Method  nicht "full quolified reference".
     *  
     *  \~english
     *  \todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  @param fpsMethodName
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     *  @param fpsMethodName
     */
    public void LogFunctionStartDebug(String fpsMethodName)
    {
    	myLogger.LogFunctionStartDebug(this.getClass().getName() + "." + fpsMethodName);
    }
    
    
    /** \~german
     *  Methode ruft die Methode Logger.Instance.LogFunctionStart(fps_FunctionName),
     *  und erweitert den gegebenen Methodenname in fps_FunctionName mit this.getClass().getName() um den Klassenbezeichner.
     *  
     *  @param fpsMethodName Name der Method  nicht "full quolified reference".
     *  
     *  \~english
     *  \todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  @param fpsMethodName
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     *  @param fpsMethodName
     */
    public void LogFunctionStart(String fpsMethodName)
    {
        myLogger.LogFunctionStart( this.getClass().getName() + "." + fpsMethodName );
    }

    
    /** \~german
     *  \brief
     *  Methode ruft die Methode Logger.Instance.LogFunctionStartDebug(string,string,string),
     *  erweitert den gegebenen Methodenname in fps_FunctionName mit this.getClass().getName() um den Klassenbezeichner.
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
    public void LogFunctionStartDebug( String fpsMethodName, String P1_Name, String P1_Value )
    {
    	myLogger.LogFunctionStartDebug(this.getClass().getName() + "." + fpsMethodName, P1_Name, P1_Value);
    }

    /** \~german
     *  \brief
     *  Methode ruft die Methode Logger.Instance.LogFunctionStart(string,string,string),
     *  erweitert den gegebenen Methodenname in fps_FunctionName mit this.getClass().getName() um den Klassenbezeichner.
     *  
     *  @param fpsMethodName Name der Method, aber ohne Paket Angabe.
     *  @param P1_Name Name/Bezeichnung des (ersten) Parameters.
     *  @param P1_Value Wert des ersten Parameters.
     * 
     *  \~english
     *  @todo TODO: LogFunctionStart(String fpsMethodName, String P1_Name, String P1_Value) Übersetzung ins Englische fehlt...
     * 
     *  @param fpsMethodName
     *  @param P1_Name Name/Bezeichnung des ersten Parameters.
     *  @param P1_Value Wert des ersten Parameters.
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    public void LogFunctionStart(String fpsMethodName, String P1_Name, String P1_Value)
    {
        myLogger.LogFunctionStart(this.getClass().getName() + "." + fpsMethodName, P1_Name, P1_Value);
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
    public void LogFunctionEndDebug()
    {
    	myLogger.LogFunctionEndDebug();
    }

    /** \~german
     *  Methode ruft die Methode Logger.Instance.LogFunctionEnd() auf.
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.01.18
     */
    public void LogFunctionEnd()
    {
        myLogger.LogFunctionEnd();
    }
    
    
    /** \~german
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
    public void LogFunctionEndDebug(String fpReturn)
    {
      if( fpReturn != null)
          myLogger.LogFunctionEndDebug(fpReturn);
      else
          myLogger.LogFunctionEndDebug();
    }


    /** \~german
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEnd(string) auf.
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
    public void LogFunctionEnd(String fpReturn)
    {
      if( fpReturn != null) 
          myLogger.LogFunctionEnd(fpReturn);
      else 
          myLogger.LogFunctionEnd();
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
    public void LogFunctionEndDebug(Boolean fpReturn)
    {
      if( fpReturn != null)
          myLogger.LogFunctionEndDebug(fpReturn);
      else
          myLogger.LogFunctionEndDebug();
    }

    /** \~german
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEnd(bool) auf.
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
    public void LogFunctionEnd(Boolean fpReturn)
    {
      if( fpReturn != null)
          myLogger.LogFunctionEnd(fpReturn);
      else
          myLogger.LogFunctionEnd();
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
    public void LogFunctionEndDebug(ArrayList<String> fpReturn)
    {
      if( fpReturn != null)
          myLogger.LogFunctionEndDebug(fpReturn);
      else
          myLogger.LogFunctionEndDebug();
    }

    /**
     *  \~german
     *  Diese Methode ruft die Methode Logger.Instance.LogFunctionEnd(ArrayList&lt;string&gt;) auf.
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
    public void LogFunctionEnd(ArrayList<String> fpReturn)
    {
      if( fpReturn != null)
          myLogger.LogFunctionEnd(fpReturn);
      else
          myLogger.LogFunctionEnd();
    }
    
    public void ResOpenList( String fps_Name )
    {
        myLogger.ResOpenList( fps_Name );
    }

    public void ResOpenListDebug( String fps_Name )
    {
        myLogger.ResOpenListDebug( fps_Name );
    }

    public void ResCloseList( )
    {
        myLogger.ResCloseList( );
    }

    public void ResCloseListDebug( )
    {
        myLogger.ResCloseListDebug( );
    }

    public void LogPrint( String fps_Message )
    {
        myLogger.LogPrint( fps_Message );
    }

    public void LogPrintDebug( String fps_Message )
    {
        myLogger.LogPrintDebug( fps_Message );
    }
    
    public void LogWarning( String fps_Message )
    {
        myLogger.LogWarning( fps_Message );
    }

    public void LogError( String fps_Message )
    {
        myLogger.LogError( fps_Message );
    }

    
    /** \~german
     *  Holt den funktionalen Name dws GUI-Objektes.
     * 
     *  Hinweis: Jeder GUI-Adapter kennt seinen eigenen funktionalen Namen.
     *  Dieser wird beim instanzieren der Frame-Objecte währen des Frame-Classen-Scans in der Methode FrameObjectDictionary_Sngltn.FrameScan()
     *  mitgeteilt.
     *  Wert wird 
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */  
    public String getFN( )
    {
      return this.myFN;
    }

    /** \~german
     *  Setzten des Objekt KN.
     *  
     *  @return KN des Objektes.
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2016.11.20
     */ 
    public String getKN( )
    {
      return this.myKN;
    }

    /** \~german
     *  Setzten des Parent-Objekt FN.
     *  
     *  @return FN des Parent-Objektes.
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2016.11.20
     */ 
    public String getParentFN( )
    {
      return this.myParentFN;
    }

    public void setFN(String fpsFN)
    {
      this.myFN =  fpsFN;
    }

    /** \~german
     *  Setzten des Keyname FN.
     *  
     *  @fpsParentFN KN des Objektes
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2016.11.20
     */    
    public void setKN(String fpsKN)
    {
      this.myKN =  fpsKN;
    }

    /** \~german
     *  Setzten des Parent-Objekt FN.
     *  
     *  @fpsParentFN FN des Parent-Objektes
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2016.11.20
     */    
    public void setParentFN(String fpsParentFN)
    {
      this.myParentFN =  fpsParentFN;
    }
}