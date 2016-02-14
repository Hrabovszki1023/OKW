/*
    ==============================================================================
    Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

package okw.core;

import okw.OKW_CurrentObject_Sngltn;
import okw.OKWLanguage;
import okw.OKW_Ini_Sngltn;
import okw.log.*;

	/// \~german
	/// \brief
	/// Klasse NOK representiert den Core Zustand __NOK__ im Ausführungs-Modus.
	/// 
	/// Testausführung mit GUI-Aktivität und es ist eine Exception ausgelöst worden.
	/// 
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.03.02
	public class NOK implements IOKW_State
	{

		OKWLanguage AL = OKWLanguage.getInstance();
		// OKW_Docu MyOKWDocu = OKW_Docu.getInstance();

		Logger_Sngltn Log;
		
		Core _Kernel;


		/// \~german
		/// \~english
		/// \~
		/// \author Zoltán Hrabovszki
		/// \date 02.03.2013
		public NOK(Core fp_OKW)
		{
			Log = Logger_Sngltn.getInstance();
			this._Kernel = fp_OKW;
		}


		/// \~german
		/// \copydoc IOKW_State::BeginTest()
		/// \~english
		/// \copydoc IOKW_State::BeginTest()
		/// 
		public void BeginTest(String fpsTestname)
		{
			// TODO: Prüfen ob hier ein catchbloch bnötigt wird
			try
			{
				Log.LogFunctionStart("BeginTest",
					"fpsTestname", fpsTestname);

				// Alles Initialisieren
				OKW_Ini_Sngltn.getInstance().Init();
				OKW_CurrentObject_Sngltn.getInstance().Init();

				Log.LogPrint("NOK -> OK");
				this._Kernel.SetCurrentState(new OK(this._Kernel));
			}
			catch (Exception e)
			{
				// this.HandleException(e);
			}
			finally
			{
				// Gute Frage was alles hier hingehört...
				Log.LogFunctionEnd();
			}
		}

		/// \~german
		/// \copydoc IOKW_State::ClickOn(String)
		/// \~english
		/// \copydoc IOKW_State::ClickOn(String)
		/// 
		public void ClickOn(String fpsFunctionalname)
		{
			Log.LogFunctionStart("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::ClickOn(String,String)
		/// \~english
		/// \copydoc IOKW_State::ClickOn(String,String)
		/// 
		public void ClickOn(String fpsFunctionalname, String fpsClickType)
		{
			Log.LogFunctionStart("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsClickType", fpsClickType);
            
			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::EndTest()
		/// \~english
		/// \copydoc IOKW_State::EndTest()
		/// 
		public void EndTest()
		{
			// TODO: Aufräumen  Kill... usw aufrufen
			Log.LogFunctionStart("EndTest");

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogCaption(String)
		/// \~english
		/// \copydoc IOKW_State::LogCaption(String)
		/// 
		public void LogCaption(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogCaption", "fpsFunctionalname", fpsFunctionalname);
            
			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogExists(String)
		/// \~english
		/// \copydoc IOKW_State::LogExists(String)
		/// 
		public void LogExists(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogExists",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogHasFocus(String)
		/// \~english
		/// \copydoc IOKW_State::LogHasFocus(String)
		/// 
		public void LogHasFocus(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogHasFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogIsActive(String)
		/// \~english
		/// \copydoc IOKW_State::LogIsActive(String)
		/// 
		public void LogIsActive(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogIsActive",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogLabel(String)
		/// \~english
		/// \copydoc IOKW_State::LogLabel(String)
		/// 
		public void LogLabel(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogLabel",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogSelected(String)
		/// \~english
		/// \copydoc IOKW_State::LogSelected(String)
		public void LogSelected(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogSelected",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTablecellValue(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::LogTablecellValue(String,String,String)
		/// 
		public void LogTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow)
		{
			Log.LogFunctionStart("LogTablecellValue",
				"fpsCol", fpsCol,
				"fpsRow", fpsRow, 
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTooltip(String)
		/// \~english
		/// \copydoc IOKW_State::LogTooltip(String)
		/// 
		public void LogTooltip(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogTooltip",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogValue(String)
		/// \~english
		/// \copydoc IOKW_State::LogValue(String)
		/// 
		public void LogValue(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogValue",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeCaption(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeCaption(String,String)
		/// 
		public void MemorizeCaption(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeExists(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeExists(String,String)
		public void MemorizeExists(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeHasFocus(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeHasFocus(String,String)
		/// 
		public void MemorizeHasFocus(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeIsActive(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeIsActive(String,String)
		/// 
		public void MemorizeIsActive(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// 
		public void MemorizeLabel(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeSelectedValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeSelectedValue(String,String)
		/// 
		public void MemorizeSelectedValue(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeSelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
		/// 
		public void MemorizeTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsMemKeyName", fpsMemKeyName);
			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTooltip(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTooltip(String,String)
		/// 
		public void MemorizeTooltip(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// 
		public void MemorizeValue(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStart("MemorizeValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(String,String)
		/// \~english
		/// \copydoc IOKW_State::Select(String,String)
		public void Select(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStart("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::Select(String,String,String)
		public void Select(String fpsFunctionalname, String fpsValue, String fpsClickType)
		{
			Log.LogFunctionStart("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue,
				"fpsClickType", fpsClickType);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(String)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(String)
		/// 
		public void SelectMenu(String fpsFunctionalname)
		{
			Log.LogFunctionStart("SelectMenu",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(String,String)
		/// 
		public void SelectMenu(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStart("SelectMenu", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(String,String,String)
		/// 
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow)
		{
			Log.LogFunctionStart("SelectTablecell", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsCol", fpsCol, 
				"fpsRow", fpsRow);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
		/// 
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsClickType)
		{
			Log.LogFunctionStart(
				"SelectTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsClickType", fpsClickType);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectWindow(String)
		/// \~english
		/// \copydoc IOKW_State::SelectWindow(String)
		/// 
		public void SelectWindow(String fpsFunctionalname)
		{
			Log.LogFunctionStart("SelectWindow",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Sequence(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::Sequence(String,String,String)
		public void Sequence(String fpsObjectName, String fpsSequenceName, String SEQ_ID)
		{
			Log.LogFunctionStart("Sequence",
				"fpsObjectName", fpsObjectName,
				"fpsSequenceName", fpsSequenceName,
				"SEQ_ID", SEQ_ID);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SetFocus(String)
		/// \~english
		/// \copydoc IOKW_State::SetFocus(String)
		/// 
		public void SetFocus(String fpsFunctionalname)
		{
			Log.LogFunctionStart("SetFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \~english
		/// \~
		/// \author Zoltán Hrabovszki
		/// \date 02.03.2013
		/// 
		public void SetLanguage(String Language)
		{
			this.AL.setLanguage(Language);
		}

		/// \~german
		/// \copydoc IOKW_State::SetValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::SetValue(String,String)
		/// 
		public void SetValue(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStart("SetValue", 
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::StartApp(String)
		/// \~english
		/// \copydoc IOKW_State::StartApp(String)
		/// 
		public void StartApp(String fpsApplikationName)
		{
			Log.LogFunctionStart("StartApp", 
				"fps_ApplikationName", fpsApplikationName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::StopApp(String)
		/// \~english
		/// \copydoc IOKW_State::StopApp(String)
		/// 
		public void StopApp(String fpsApplikationName)
		{
			Log.LogFunctionStart("StopApp",
				"fps_ApplikationName", fpsApplikationName);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKey(String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKey(String,String)
		/// 
		public void TypeKey(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStart("TypeKey", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
		/// 
		public void TypeKeyTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsValue)
		{
			Log.LogFunctionStart("TypeKeyTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsColl", fpsCol,
				"fpsRow", fpsRow,
				"fpsValue", fpsValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyWindow(String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyWindow(String,String)
		public void TypeKeyWindow(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStart("TypeKeyWindow",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyCaption(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyCaption(String,String)
		public void VerifyCaption(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyExists(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyExists(String,String)
		public void VerifyExists(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyHasFocus(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyHasFocus(String,String)
		public void VerifyHasFocus(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyIsActive(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyIsActive(String,String)
		public void VerifyIsActive(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyLabel(String,String)
		public void VerifyLabel(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifySelectedValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifySelectedValue(String,String)
		public void VerifySelectedValue(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifySelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
		public void VerifyTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTooltip(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyTooltip(String,String)
		public void VerifyTooltip(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyValue(String,String)
		public void VerifyValue(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}


		/// \copydoc IOKW_State::FileDelete(String)
		public void FileDelete(String fpsPathAndFileName)
		{
			Log.LogFunctionStart("FileDelete", "fpsPathAndFileName", fpsPathAndFileName);

			Log.LogFunctionEnd();
		}

		/// \copydoc IOKW_State::VerifyFileExists(String,String)
		public void VerifyFileExists(String fpsPathAndFileName, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyFileExists",
				"fpsPathAndFileName", fpsPathAndFileName,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}

		/// \copydoc IOKW_State::VerifyDirectoryExists(String,String)
		public void VerifyDirectoryExists(String fpsPath, String fpsExpectedValue)
		{
			Log.LogFunctionStart("VerifyDirectoryExists",
				"fpsPath", fpsPath,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEnd();
		}


		@Override
		public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName )
		{
			// TODO Auto-generated method stub
			
		}
	}