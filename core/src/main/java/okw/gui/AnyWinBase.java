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

import java.util.ArrayList;

import okw.core.IOKW_FN;
import okw.log.*;

/// \brief
/// Description of AnyWin.
/// 
public abstract class AnyWinBase implements IOKW_FN
{
	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	private OKWLocator _locator;
	
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
	
  public void SetFN(String fpsFN)
  {
    this.myFN =  fpsFN;
  }

  public String GetFN( )
  {
    return this.myFN;
  }

  
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
  public void SetParentFN(String fpsParentFN)
  {
    this.myParentFN =  fpsParentFN;
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
  public String GetParentFN( )
  {
    return this.myParentFN;
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
    protected void LogFunctionEndDebug(String fpsReturn)
    {
    	myLogger.LogFunctionEndDebug(fpsReturn);
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
    protected void LogFunctionEndDebug(Boolean fpbReturn)
    {
    	myLogger.LogFunctionEndDebug(fpbReturn);
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
    protected void LogFunctionEndDebug(ArrayList<String> fpLsReturn)
    {
    	myLogger.LogFunctionEndDebug(fpLsReturn);
    }
}