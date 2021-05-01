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

package okw.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import okw.OKW_Const_Sngltn;

/**
 *  \~german
 *  @class
 *  Zentrale Logger-Klasse stellt Logger-Methoden innerhalb von OKW zur Verfügung.
 *  
 *  \~english
 *  Central Log-Classes offers the Logging-Methodes.
 */
public class Logger_Sngltn implements ILogger
{

    private static Boolean            cvbDebugMode = false;
    private static ArrayList<ILogger> LoggerList;

    private static Logger_Sngltn      Instance;

    
    public Boolean getDebugMode()
    {
        return cvbDebugMode;
    }

    public void setDebugMode( Boolean fpbDebugMode )
    {
        cvbDebugMode = fpbDebugMode;

        for ( ILogger myLogger : LoggerList )
        {
            myLogger.setDebugMode( cvbDebugMode );
        }

    }
    
    
    /**
     *  \~german
     *  Zentrale Logger-Klasse stellt Logger-Methoden innerhalb von OKW zur Verfügung.
     *  
     *  \~english
     *  Central Log-Classes offers the Logging-Methodes.
     */

    public static Logger_Sngltn getInstance()
    {
        // Lazy Initialization (If required then only)

        if ( Instance == null )
        {
            // Thread Safe. Might be costly operation in some case
            synchronized ( OKW_Const_Sngltn.class )
            {
                if ( Instance == null )
                {
                    Instance = new Logger_Sngltn();
                    init();
                }
            }
        }
        return Instance;

    }

    public static void init()
    {
        LoggerList.clear();
        LoggerList.add( new Log2Console() );

        Instance.setDebugMode( false );
    }

    private Logger_Sngltn()
    {
            LoggerList = new ArrayList<ILogger>();
    }

    
    /**
     * \~german
     * Logt den Versions-Text beim Start eines Skriptes.
     * 
     * Die Information wird aus der Resourcen-Datei "okw/version.txt" gelesen
     * und mit Logger_Sngltn geloggt.
     *
     * \~english
     * Logs the version text when starting a script.
     * 
     * The information is read from the resource file "okw/version.txt"
     * and logged with Logger_Sngltn.
     * 
     * \~
     * @author Zoltán Hrabovszki
     * \date 2019-11-17, 2020-08-17
     */
    public void LogVersionTxt()
    {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream( "okw/version.txt" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        try
        {
			while ((line = reader.readLine()) != null)
			{
				this.LogPrint("-" + line );
			}
			reader.close();
			
		}
        catch (IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    /** \~german
     *  \brief Fügt einen ILogger der Logger-Liste Logger.LoggerList
     * 
     *  \param fpLogger Logger, der
     *  \return
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     * 
     *  \todo TODO: Detailed Description
     * 
     *  \param fpbTrueOrFalse
     *  \return
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.01
     */
    public void addLogger( ILogger fpLogger )
    {
        LoggerList.add( fpLogger );
    }

    /**
     *  \~german
     *  \brief Initialisi.
     * 
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     * 
     *  \todo TODO: Detailed Description
     * 
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2015.05.01
     */
    public void reset()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.reset();
        }
    }

    /**
     *  \brief
     *  LogError Function:
     *  Logs an error message to the results file.
     * 
     *  \param fps_Message
     */
    public void LogError( String fps_Message )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogError( fps_Message );
        }
    }


    /**
     *  LogError Logs an error message with Expected and Actual to the results file.
     * 
     *  \param fps_Message
     *  \param fps_Expected 
     *  \param fps_Actual 
     *  
     */
    public void LogError( String fps_Message, String fps_Expected, String fps_Actual)
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogError( fps_Message, fps_Expected, fps_Actual );
        }
    }
    
    
    /**
     *  LogException Function:
     *  Logs a Script Exception to the results file.
     * 
     *  \param fps_Message
     */
    public void LogException( String fps_Message )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogException( fps_Message );
        }
    }

    public void LogKeyWordEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogKeyWordEnd();
        }
    }
    
    
    public void LogStepStart( String categoryName, String categoryType, 
                    String choiceValue, String featureName,
                    String localCategoryName, String sourceExcerpt,
                    String type  )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogStepStart( categoryName, categoryType, choiceValue, featureName, localCategoryName, sourceExcerpt, type  );
        }
    }    
    
    public void LogStepEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogStepEnd();
        }
    }

    
    public void LogLocalACCallStart( String Gherkin, String Type )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogLocalACCallStart(  Gherkin, Type );
        }
    }    
    
    public void LogLocalACCallEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogLocalACCallEnd();
        }
    }
    
    
    public void LogRemoteACCallStart( String Gherkin, String Type )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogRemoteACCallStart(  Gherkin, Type );
        }
    }    
    
    public void LogRemoteACCallEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogRemoteACCallEnd();
        }
    }
    
    
    public void LogSequenceEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogSequenceEnd();
        }
    }


    public void LogTestcaseEnd()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogTestcaseEnd();
        }
    }

    /**
     *  \~german
     *  \brief Ausgabe eines Schlüsselwortes
     * 
     *  \todo TODO: Ausführliche Beschreibung
     * 
     *  \param Parameterbezeichner \todo TODO: Beschreibung
     *  \return
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     * 
     *  \todo TODO: Detailed Description
     * 
     *  \param fpbTrueOrFalse
     *  \return
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.01
     */
    public void LogKeyWordStart( String fpsKeyWordName, String... fpsParameter )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogKeyWordStart( fpsKeyWordName, fpsParameter );
        }
    }

    public void LogSequenceStart( String fpsKeyWordName, String fpsWinowFN, String fpsSequenceName, String... fpsParameter )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogSequenceStart( fpsKeyWordName, fpsWinowFN, fpsSequenceName, fpsParameter );
        }
    }

    /**
     *  \~german
     *  \brief Ausgabe des Testfalls
     * 
     *  \todo TODO: Ausführliche Beschreibung
     * 
     *  \param Parameterbezeichner \todo TODO: Beschreibung
     *  \return
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     * 
     *  \todo TODO: Detailed Description
     * 
     *  \param fpbTrueOrFalse
     *  \return
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.01
     */
    public void LogTestcaseStart( String fps_TestcaseName )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogTestcaseStart( fps_TestcaseName );
        }
    }

    /** 
     *  \brief LogPass: Logs an passes-message to the result.
     *
     *  \param fps_Message
     */
    public void LogPass( String fps_Message )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogPass( fps_Message );
        }
    }

    /**
     *  \brief
     *  LogPrint Function:
     *  Prints the values of expressions to the results file.
     * 
     *  \param fps_Message
     */
    public void LogPrint( String fps_Message )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogPrint( fps_Message );
        }
    }

    /**
     *  \~german
     *  \brief Loggt eine Nachricht
     * 
     *  Die Nachricht fpsMessage wird im Ergebniss ausgegeben.
     * 
     *  \param fpsMessage Nachricht, die Ausgegeben werden soll.
     * 
     *  \~english
     *  \brief \todo TODO: Brief sescription.
     * 
     *  \todo TODO: Detailed Description
     * 
     *  \param fpsMessage
     *  \return
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.01
     *  \brief
     *  Prints the message fps_Messageof expressions to the results file, if
     *  cvb_DebugMode
     * 
     *  \param fps_Message Message to Print
     */
    public void LogPrintDebug( String fpsMessage )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogPrintDebug( fpsMessage );
        }
    }

    
    /**
     *  \brief
     *  LogWarning Function:
     *  Logs a warning to the results file.
     * 
     *  \param fps_Message
     */
    public void LogWarning( String fps_Message )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogWarning( fps_Message );
        }
    }


    
    /**
     *  \brief
     *  LogWarning Function:
     *  Logs a warning to the results file.
     * 
     *  \param fps_Message
     */
    public void LogSourceLocation( String Start, String End, String featureName, String sourceType )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.LogSourceLocation( Start, End, featureName, sourceType );
        }
    }

    
    /**
     *  \brief
     *  Closes a hierarchical level in the results file that was opened with
     *  ResOpenList.
     *  Use ResOpenList to start a new hierarchical level.
     *  The Print commands that follow it are indented until you close the level
     *  with ResCloseList.
     *  When you view the results file, the item sName is initially collapsed,
     *  indicated by the [+] icon next to it.
     *  You can expand sName to reveal the indented items under it.
     * 
     */
    public void ResCloseList()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.ResCloseList();
        }
    }

    /**
     *  \brief
     *  Closes a hierarchical level in the results file that was opened with
     *  ResOpenList.
     *  Use ResOpenList to start a new hierarchical level.
     *  The Print commands that follow it are indented until you close the level
     *  with ResCloseList.
     *  When you view the results file, the item sName is initially collapsed,
     *  indicated by the [+] icon next to it.
     *  You can expand sName to reveal the indented items under it.
     * 
     */
    public void ResCloseListDebug()
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.ResCloseListDebug();
        }
    }

    /**
     *  \brief
     *  Creates a new hierarchical level in the results file.
     *  Use ResOpenList to start a new hierarchical level.
     *  The Print commands that follow it are indented until you close the level
     *  with ResCloseList.
     *  When you view the results file, the item sName is initially collapsed,
     *  indicated by the [+] icon next to it.
     *  You can expand sName to reveal the indented items under it.
     * 
     *  \param fps_Name
     */
    public void ResOpenList( String fps_Name )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.ResOpenList( fps_Name );
        }
    }

    /**
     *  \~german
     *  \brief Erzeugt eine hierachische Log-Ebene in der Ergenbniss-Ausgabe.
     * 
     *  \todo TODO: Ausführliche Beschreibung erstellen.
     * 
     *  \param fpsListCaption Überschrift der Log-Ebene.
     * 
     *  \~english
     *  \brief
     *  Creates a new hierarchical level in the results file.
     * 
     *  Use ResOpenList to start a new hierarchical level.
     *  The Print commands that follow it are indented until you close the level
     *  with ResCloseList.
     *  When you view the results file, the item sName is initially collapsed,
     *  indicated by the [+] icon next to it.
     *  You can expand sName to reveal the indented items under it.
     * 
     *  \param fpsListCaption Caption of the resultlist.
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.01
     */
    public void ResOpenListDebug( String fpsListCaption )
    {
        for ( ILogger myLogger : LoggerList )
        {
            myLogger.ResOpenListDebug( fpsListCaption );
        }
    }
}