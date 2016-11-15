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

import okw.log.*;

/// \brief
/// Description of AnyWin.
/// 
public abstract class AnyWinBase
{
	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	private OKWLocator _locator;

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


    /** \~german
     *  Locator enthält die Objekterkennungseigenschaft.
     *  
     *  \~english
     *  \brief
     *  \todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2014.04.27
     */
    public String getLocator()
    {
            return this._locator.getLocator();
    }

    
    public OKWLocator getLOCATOR()
    {
            return this._locator;
    }

    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionStartDebug(string,string,string),
    /// und erweitert den gegebenen Methodenname in fps_FunctionName mit this.GetType().FullName um den Klassenbezeichner.
    /// 
    /// \param fpsMethodName Name der Method ohne Volle referenz.
    /// \param P1_Name Bezechnung des(ersten) Parameters.
    /// \param P1_Value Wert des Ersten Parameters.
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \param fpsMethodName
    /// \param P1_Name Bezechnung des(ersten) Parameters.
    /// \param P1_Value Wert des Ersten Parameters.
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.27/ jnic_2014_11_26
    protected void LogFunctionStartDebug(String fpsMethodName, String P1_Name, String P1_Value)
    {
    	myLogger.LogFunctionStartDebug(this.getClass().getName() + "." + fpsMethodName, P1_Name, P1_Value);
    }

    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug() auf.
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.01.18
    protected void LogFunctionEndDebug()
    {
    	myLogger.LogFunctionEndDebug();
    }

    
    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(string) auf.
    /// 
    /// \param fpsReturn Zu loggender Rückgabewert.
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \param fpsReturn
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.01.18
    protected void LogFunctionEndDebug(String fpsReturn)
    {
    	myLogger.LogFunctionEndDebug(fpsReturn);
    }

    
    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(bool) auf.
    /// 
    /// \param fpbReturn Zu loggender Rückgabewert.
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.01.18
    protected void LogFunctionEndDebug(Boolean fpbReturn)
    {
    	myLogger.LogFunctionEndDebug(fpbReturn);
    }

    /// \~german
    /// \brief
    /// Diese Methode ruft die Methode Logger.Instance.LogFunctionEndDebug(List&gt;string&lt;) auf.
    /// 
    /// \param fpLsReturn Zu loggender Rückgabewert.
    /// 
    /// \~english
    /// \brief
    /// \todo TODO:  Übersetzung ins Englische fehlt...
    /// 
    /// \param fpLsReturn
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.01.18
    protected void LogFunctionEndDebug(ArrayList<String> fpLsReturn)
    {
    	myLogger.LogFunctionEndDebug(fpLsReturn);
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
}