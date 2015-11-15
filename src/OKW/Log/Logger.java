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

public class Logger {

	private Boolean cvbDebugMode = false;

	public Boolean getCvbDebugMode() {
		return cvbDebugMode;
	}

	public void setCvbDebugMode(Boolean cvbDebugMode) {
		this.cvbDebugMode = cvbDebugMode;
	}

	private List<ILogger> LoggerList = new ArrayList<ILogger>();

	private static Logger Instance = new Logger();

	public static Logger getInstance() {
		return Instance;
	}

	private Logger() {
	}

	/// \~german
	/// \brief Fügt einen ILogger der Logger-Liste Logger.LoggerList
	///
	/// \param fpLogger Logger, der
	/// \return
	///
	/// \~english
	/// \brief \todo TODO: Brief Description.
	///
	/// \todo TODO: Detailed Description
	///
	/// \param fpbTrueOrFalse
	/// \return
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	public void AddLogger(ILogger fpLogger) {
		this.LoggerList.add(fpLogger);
	}

	/// \~german
	/// \brief Initialisiert die Klasse.
	///
	/// - Löscht die Liste LoggerList
	/// - Schaltet den DebugMode aus.
	///
	/// \todo TODO: Ausführliche Beschreibung
	///
	/// \~english
	/// \brief \todo TODO: Brief Description.
	///
	/// \todo TODO: Detailed Description
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	public void Init() {
		this.LoggerList.clear();
		this.cvbDebugMode = false;
	}

	/// \brief
	/// LogError Function:
	/// Logs an error message to the results file.
	///
	/// \param fps_Message
	public void LogError(String fps_Message) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogError(fps_Message);
		}
	}

	/// \brief
	/// LogException Function:
	/// Logs a Script Exception to the results file.
	///
	/// \param fps_Message
	public void LogException(String fps_Message) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogException(fps_Message);
		}
	}

	public void LogFunctionEnd(String fps_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEnd(fps_Return);
		}
	}

	public void LogFunctionEnd(Boolean fpb_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEnd(fpb_Return);
		}
	}

	public void LogFunctionEnd(List<String> fpls_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEnd(fpls_Return);
		}
	}

	public void LogFunctionEnd() {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEnd();
		}
	}

	public void LogFunctionEndDebug() {

		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEndDebug();
		}
	}

	public void LogFunctionEndDebug(String fps_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEndDebug(fps_Return);
		}
	}

	public void LogFunctionEndDebug(List<String> fps_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEndDebug(fps_Return);
		}
	}

	public void LogFunctionEndDebug(Boolean fpb_Return) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionEndDebug(fpb_Return);
		}
	}

	public void LogFunctionStart(String fps_FunctionName, String... fpsParameter) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionStart(fps_FunctionName, fpsParameter);
		}
	}

	public void LogFunctionStartDebug(String fps_FunctionName, String... fpsParameter) {

		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogFunctionStartDebug(fps_FunctionName, fpsParameter);
		}
	}

	public void LogKeyWordEnd() {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogKeyWordEnd();
		}
	}

	/// \~german
	/// \brief Ausgabe eines Schlüsselwortes
	///
	/// \todo TODO: Ausführliche Beschreibung
	///
	/// \param Parameterbezeichner \todo TODO: Beschreibung
	/// \return
	///
	/// \~english
	/// \brief \todo TODO: Brief Description.
	///
	/// \todo TODO: Detailed Description
	///
	/// \param fpbTrueOrFalse
	/// \return
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	public void LogKeyWordStart(String fpsKeyWordName, String... fpsParameter) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogKeyWordStart(fpsKeyWordName, fpsParameter);
		}
	}

	/// \brief
	/// LogPrint Function:
	/// Prints the values of expressions to the results file.
	///
	/// \param fps_Message
	public void LogPrint(String fps_Message) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogPrint(fps_Message);
		}
	}

	/// \~german
	/// \brief Loggt eine Nachricht
	///
	/// Die Nachricht fpsMessage wird im Ergebniss ausgegeben.
	///
	/// \param fpsMessage Nachricht, die Ausgegeben werden soll.
	///
	/// \~english
	/// \brief \todo TODO: Brief sescription.
	///
	/// \todo TODO: Detailed Description
	///
	/// \param fpsMessage
	/// \return
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	/// \brief
	/// Prints the message fps_Messageof expressions to the results file, if
	/// cvb_DebugMode
	///
	/// \param fps_Message Message to Print
	public void LogPrintDebug(String fpsMessage) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogPrintDebug(fpsMessage);
		}
	}

	/// \~german
	/// \brief Logt Soll-Ist Vergeleich.
	///
	/// \todo TODO: Ausführliche Beschreibung erstellen
	///
	/// \param fpsActual Ist-Wert, welche geprüft werden soll.
	/// \param fpsExpected Erwarteter Soll-Wert, gegen den geprüft wird.
	/// \return
	///
	/// \~english
	/// \brief \todo TODO: Brief Description.
	///
	/// \todo TODO: Detailed Description
	///
	/// \param fpbTrueOrFalse
	/// \return
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	public void LogVerify(String fpsActual, String fpsExpected) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogVerify(fpsActual, fpsExpected);
		}
	}

	/// \brief
	/// LogWarning Function:
	/// Logs a warning to the results file.
	///
	/// \param fps_Message
	public void LogWarning(String fps_Message) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.LogWarning(fps_Message);
		}
	}

	/// \brief
	/// Closes a hierarchical level in the results file that was opened with
	/// ResOpenList.
	/// Use ResOpenList to start a new hierarchical level.
	/// The Print commands that follow it are indented until you close the level
	/// with ResCloseList.
	/// When you view the results file, the item sName is initially collapsed,
	/// indicated by the [+] icon next to it.
	/// You can expand sName to reveal the indented items under it.
	///
	public void ResCloseList() {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.ResCloseList();
		}
	}

	/// \brief
	/// Closes a hierarchical level in the results file that was opened with
	/// ResOpenList.
	/// Use ResOpenList to start a new hierarchical level.
	/// The Print commands that follow it are indented until you close the level
	/// with ResCloseList.
	/// When you view the results file, the item sName is initially collapsed,
	/// indicated by the [+] icon next to it.
	/// You can expand sName to reveal the indented items under it.
	///
	public void ResCloseListDebug() {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.ResCloseListDebug();
		}
	}

	/// \brief
	/// Creates a new hierarchical level in the results file.
	/// Use ResOpenList to start a new hierarchical level.
	/// The Print commands that follow it are indented until you close the level
	/// with ResCloseList.
	/// When you view the results file, the item sName is initially collapsed,
	/// indicated by the [+] icon next to it.
	/// You can expand sName to reveal the indented items under it.
	///
	/// \param fps_Name
	public void ResOpenList(String fps_Name) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.ResOpenList(fps_Name);
		}
	}

	/// \~german
	/// \brief Erzeugt eine hierachische Log-Ebene in der Ergenbniss-Ausgabe.
	///
	/// \todo TODO: Ausführliche Beschreibung erstellen.
	///
	/// \param fpsListCaption Überschrift der Log-Ebene.
	///
	/// \~english
	/// \brief
	/// Creates a new hierarchical level in the results file.
	///
	/// Use ResOpenList to start a new hierarchical level.
	/// The Print commands that follow it are indented until you close the level
	/// with ResCloseList.
	/// When you view the results file, the item sName is initially collapsed,
	/// indicated by the [+] icon next to it.
	/// You can expand sName to reveal the indented items under it.
	///
	/// \param fpsListCaption Caption of the resultlist.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.05.01
	public void ResOpenListDebug(String fpsListCaption) {
		for (ILogger myLogger : this.LoggerList) {
			myLogger.ResOpenListDebug(fpsListCaption);
		}
	}
}