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

package OKW.Log;

import java.util.*;

/// \brief
/// Debug Logs are not a part of Interface. This methods are implemented in Logger.cs
/// a Log*Debug function calls after checking the log-conditions(debug=true) the Log*-Funktion(without "Debug")
/// void LogPrintDebug();
///
/// FunktionLogs...
/// void LogFunctionStartDebug(string fps_FunctionName);
/// void LogFunctionStartDebug(string fps_FunctionName, string P1_Name, string P1_Value);
/// void LogFunctionStartDebug(string fps_FunctionName, string P1_Name, string P1_Value, string P2_Name, string P2_Value);
/// void LogFunctionStartDebug(string fps_FunctionName, string P1_Name, string P1_Value, string P2_Name, string P2_Value, string P3_Name, string P3_Value);
/// void LogFunctionStartDebug(string fps_FunctionName, string P1_Name, string P1_Value, string P2_Name, string P2_Value, string P3_Name, string P3_Value, string P4_Name, string P4_Value);
/// void LogFunctionEndDebug();
/// void LogFunctionEndDebug(string fps_Return);
/// 

public interface ILogger
{

    // KeyWord Logging...
    void LogKeyWordStart(String fps_KeyWordName, String... fpsParameter);

    void LogKeyWordEnd();

    /// \brief
    /// LogError Function:
    /// Logs an error message to the results file.
    /// 
    /// \param fps_Message 
    void LogError(String fps_Message);

    /// \brief
    /// LogWarning Function:
    /// Logs a warning to the results file.
    /// 
    /// \param fps_Message 
    void LogWarning(String fps_Message);

    void LogVerify(String fps_Actual, String fps_Expected);

    /// \brief
    /// LogException Function:
    /// Logs a Script Exception to the results file.
    /// 
    /// \param fps_Message 
    void LogException(String fps_Message);

    // FunktionLogs...
    void LogFunctionStart(String fps_FunctionName, String... fpsParameter);
    void LogFunctionStartDebug(String fps_FunctionName, String... fpsParameter);

    void LogFunctionEnd();
    void LogFunctionEndDebug();

    void LogFunctionEnd(Boolean fpb_Return);
    void LogFunctionEndDebug(Boolean fpb_Return);

    void LogFunctionEnd(String fps_Return);
    void LogFunctionEndDebug(String fps_Return);

    void LogFunctionEnd(List<String> fps_Return);    
    void LogFunctionEndDebug(List<String> fps_Return);
    
    /// \brief
    /// LogPrint Function:
    /// Prints the values of expressions to the results file.
    /// 
    /// \param fps_Message 
    void LogPrint(String fps_Message);
    void LogPrintDebug(String fps_Message);
    
    void ResOpenList(String fps_Name);
    void ResOpenListDebug(String fps_Name); 
    
    /// \brief
    /// Closes the outline level.
    /// 
    void ResCloseList();
    void ResCloseListDebug();
}