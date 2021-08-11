/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2020, 2016 IT-Beratung Hrabovszki
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

/**
 * Debug Logs are not a part of Interface. This methods are implemented in Logger.cs
 * a Log*Debug function calls after checking the log-conditions(debug=true) the Log*-Funktion(without "Debug")
 * void LogPrintDebug();
 * \~
 * @author Zoltan Hrabovszki
 * \date 2016-10-23
 */


public interface ILogger
{

	  /**
	   * Method resets .
	   * 
	   * \~
	   * @author Zoltan Hrabovszki
	   * \date 2016-10-23
	   */
   void reset();

   
  /**
     *  LogError: Logs an error message to the result.  @todo TODO: Add description.
     *  
     *  @param fps_Message Error message text.
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    //void LogVerifyError(String Message);

    /**
     *  LogError: Logs an error message to the result.  @todo TODO: Add description.
     *  
     *  @param fps_Message Error message text.
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2021-08-04
     */
    void LogVerifyError(String Expected, String Actual);

    // void LogProvisoryError(String Message, int RemainingTimeMs);

    /**
     *  LogPass: Logs an error message to the result. @todo TODO: Add description.
     *  
     *  @param Message Pass message
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogPass(String Message);


    /**
    *  LogWarning: Logs an error message to the result.  @todo TODO: Add description.
    *  
    *  @param Message Warning message.
    * \~
    * @author Zoltan Hrabovszki
    * \date 2016-10-23
    */
    void LogWarning(String Message);


    /**
     *  LogException: Logs an exception to the results.
     *  
     * @todo TODO: Add description to LogFunctionStart.
     * 
     *  @param Message
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogException(String Message);


    /**
     *  LogSourceLocation: Logs location of Source in Harmony.
     *  
     *  This is a special log for [Harmony](https://cloud.4test.io/).
     *  Holds the Referenz to the Source in Harmony to create a Hyperlink from
     *  Report to the source of Teststep.
     *  
     *  This log is only used for Harmoy.
     *  
     *  @param Start of the Source
     *  @param End of the Source 
     *  @param featureName the name of feature like "Main Menu"
     *  @param sourceType The Type of the "ac"
     * \~
     * @author Zoltán Hrabovszki
     * \date 2019-08-03
     */
    void LogSourceLocation( String Start, String End, String featureName, String sourceType );
    
    
    /**
     * LogPrint: Prints the given message to the results.
     *  
     * @param Message Message to print.
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogPrint(String Message);


    /**
     *  LogPrintDebug: @todo TODO: Add description to LogPrintDebug.
     * 
     *  @param Message
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void LogPrintDebug(String Message);


/**
   * LogTestcaseStart: @todo TODO: Add description to LogTestcaseStart
   *  
   * @param fpsTestcaseName
   * \~
   * @author Zoltan Hrabovszki
   * \date 2016-10-23
   */
   void LogTestcaseStart(String fpsTestcaseName);

   /**
    * LogTestcaseEnd: @todo TODO: Add description to LogTestcaseEnd
    *  
    * \~
    * @author Zoltan Hrabovszki
    * \date 2016-10-23
    */
    void LogTestcaseEnd();
	
    /**
     * LogKeyWordStart: @todo TODO: Add description to LogKeyWordStart
     *
     *  @param KeyWordName
     *  @param Params
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogKeyWordStart(String KeyWordName, String... Params);

    /**
     * LogKeyWordEnd: @todo TODO: Add description to LogKeyWordEnd
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogKeyWordEnd();

    
    /**
     *  LogStepStart: Log Begin of (Test) Step.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     *  @param Gherkin  Gherkin expression.
     *
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogStepStart( String categoryName, String categoryType, 
                       String choiceValue, String featureName,
                       String localCategoryName, String sourceExcerpt,
                       String type );

    /**
     * LogStepEnd: Log End of (Test) Step.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogStepEnd();

    
    /**
     *  LogLocalACCallStart: Start of a local AC call.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     *  @param Gherkin  Gherkin expression.
     *
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogLocalACCallStart( String sourceExcerpt, String Type );


    /**
     *  LogLocalACCallEnd: End of a local AC call.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogLocalACCallEnd();

    
    /**
     *  LogRemoteACCallStart: Start of a remote AC call.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     *  @param Gherkin  Gherkin expression.
     *
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogRemoteACCallStart( String sourceExcerpt, String Type );


    /**
     * LogRemoteACCallEnd: End of a remote AC call.
     *  
     *  This log is for [Harmony](https://cloud.4test.io/).
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2019-07-25
     */
    void LogRemoteACCallEnd();
    
    
    
    
    
    /**
     *  LogSequenceStart: Begin of a Sequence. This log is used by the Sequence-keyword.
     *  
     *  @param KeyWordName In this case "Sequence" - language depended Log e.g. "Sequenz" in german.
     *  @param FN Funktionalname of the Window. 
     *  @param SEQName Name of the Sequence of the given Window.
     *  @param Params Optional Parameter of the Sequence
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogSequenceStart(String KeyWordName, String FN, String SEQName, String... Params);


    /**
     * LogSequenceEnd: @todo TODO: Add description to LogSequenceEnd.
     *  
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */
    void LogSequenceEnd();
    
    /**
     *  LogFunctionStartDebug: Opens a debug outline level with the .
     *  @todo TODO: Add description to LogFunctionStartDebug.
     * 
     *  @param LevelHeader
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void ResOpenList(String ListHeader);

    
    /**
     *  \~german
     *  Öffnet eine neue debug Ergenis-Ebene mit der gegebenen Überschrift.
     *  
     *  @param ListHeader Überschrift neu zuöffnenden Liste
     *  
     *  \~english
     *  Opens a new result list leven with the geven header.
     *  
     *  @param ListHeader
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void ResOpenListDebug(String ListHeader); 
    

    /**
     *  ResCloseList: Closes the outline level.
     *  @todo TODO: Add description to ResCloseList.
     * 
     *  @param fps_Message
     *  @param fpsParameter
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void ResCloseList();

    
    /**
     *  ResCloseListDebug: @todo TODO: Add description to ResCloseListDebug.
     * 
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void ResCloseListDebug();

    
    /**
     *  setDebugMode: @todo TODO: Add description to setDebugMode.
     * 
     *  @param fpbDebugMode If true the DebugMode ist on. Else if false the DebugMode is off. 
     * \~
     * @author Zoltan Hrabovszki
     * \date 2016-10-23
     */    
    void setDebugMode( Boolean fpbDebugMode );

}
