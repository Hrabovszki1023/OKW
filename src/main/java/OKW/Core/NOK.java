#region Header

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

#endregion Header

namespace OKW
{
	using System;
	using System.Collections.Generic;

	using OKW.Log;

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
	public class NOK : IOKW_State
	{
		#region Fields

		OKWLanguage AL = OKWLanguage.Instance;
		OKW_Docu MyOKWDocu = OKW_Docu.Instance;
		Core _Kernel;

		#endregion Fields

		#region Constructors

		/// \~german
		/// \~english
		/// \~
		/// \author Zoltán Hrabovszki
		/// \date 02.03.2013
		public NOK(Core fp_OKW)
		{
			this._Kernel = fp_OKW;
		}

		#endregion Constructors

		#region Methods

		/// \~german
		/// \copydoc IOKW_State::BeginTest()
		/// \~english
		/// \copydoc IOKW_State::BeginTest()
		/// 
		public void BeginTest(string fpsTestname)
		{
			// TODO: Prüfen ob hier ein catchbloch bnötigt wird
			try {
				Logger.Instance.LogFunctionStart("BeginTest",
					"fpsTestname", fpsTestname);

				// Alles Initialisieren
				OKW_Ini.Instance.Init();
				CurrentObject.Instance.Init();

				Logger.Instance.LogPrint("NOK -> OK");
				this._Kernel.SetCurrentState(new OK(this._Kernel));
			} finally {
				// Gute Frage was alles hier hingehört...
				Logger.Instance.LogFunctionEnd();
			}
		}

		/// \~german
		/// \copydoc IOKW_State::ClickOn(string)
		/// \~english
		/// \copydoc IOKW_State::ClickOn(string)
		/// 
		public void ClickOn(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::ClickOn(string,string)
		/// \~english
		/// \copydoc IOKW_State::ClickOn(string,string)
		/// 
		public void ClickOn(string fpsFunctionalname, string fpsClickType)
		{
			Logger.Instance.LogFunctionStart("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsClickType", fpsClickType);
            
			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::EndTest()
		/// \~english
		/// \copydoc IOKW_State::EndTest()
		/// 
		public void EndTest()
		{
			// TODO: Aufräumen  Kill... usw aufrufen
			Logger.Instance.LogFunctionStart("EndTest");

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogCaption(string)
		/// \~english
		/// \copydoc IOKW_State::LogCaption(string)
		/// 
		public void LogCaption(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogCaption",
				"fpsFunctionalname", fpsFunctionalname);
            
			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogExists(string)
		/// \~english
		/// \copydoc IOKW_State::LogExists(string)
		/// 
		public void LogExists(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogExists",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogHasFocus(string)
		/// \~english
		/// \copydoc IOKW_State::LogHasFocus(string)
		/// 
		public void LogHasFocus(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogHasFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogIsActive(string)
		/// \~english
		/// \copydoc IOKW_State::LogIsActive(string)
		/// 
		public void LogIsActive(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogIsActive",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogLabel(string)
		/// \~english
		/// \copydoc IOKW_State::LogLabel(string)
		/// 
		public void LogLabel(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogLabel",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogSelected(string)
		/// \~english
		/// \copydoc IOKW_State::LogSelected(string)
		public void LogSelected(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogSelected",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
		/// \~english
		/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
		/// 
		public void LogTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow)
		{
			Logger.Instance.LogFunctionStart("LogTablecellValue",
				"fpsCol", fpsCol,
				"fpsRow", fpsRow, 
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTooltip(string)
		/// \~english
		/// \copydoc IOKW_State::LogTooltip(string)
		/// 
		public void LogTooltip(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogTooltip",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::LogValue(string)
		/// \~english
		/// \copydoc IOKW_State::LogValue(string)
		/// 
		public void LogValue(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("LogValue",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeCaption(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeCaption(string,string)
		/// 
		public void MemorizeCaption(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeExists(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeExists(string,string)
		public void MemorizeExists(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
		/// 
		public void MemorizeHasFocus(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeIsActive(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeIsActive(string,string)
		/// 
		public void MemorizeIsActive(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(string,string)
		/// 
		public void MemorizeLabel(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
		/// 
		public void MemorizeSelectedValue(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeSelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
		/// 
		public void MemorizeTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsMemKeyName", fpsMemKeyName);
			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTooltip(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTooltip(string,string)
		/// 
		public void MemorizeTooltip(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(string,string)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(string,string)
		/// 
		public void MemorizeValue(string fpsFunctionalname, string fpsMemKeyName)
		{
			Logger.Instance.LogFunctionStart("MemorizeValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(string,string)
		/// \~english
		/// \copydoc IOKW_State::Select(string,string)
		public void Select(string fpsFunctionalname, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(string,string,string)
		/// \~english
		/// \copydoc IOKW_State::Select(string,string,string)
		public void Select(string fpsFunctionalname, string fpsValue, string fpsClickType)
		{
			Logger.Instance.LogFunctionStart("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue,
				"fpsClickType", fpsClickType);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(string)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(string)
		/// 
		public void SelectMenu(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("SelectMenu",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(string,string)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(string,string)
		/// 
		public void SelectMenu(string fpsFunctionalname, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("SelectMenu", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(string,string,string)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(string,string,string)
		/// 
		public void SelectTablecell(string fpsFunctionalname, string fpsCol, string fpsRow)
		{
			Logger.Instance.LogFunctionStart("SelectTablecell", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsCol", fpsCol, 
				"fpsRow", fpsRow);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
		/// 
		public void SelectTablecell(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsClickType)
		{
			Logger.Instance.LogFunctionStart(
				"SelectTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsClickType", fpsClickType);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectWindow(string)
		/// \~english
		/// \copydoc IOKW_State::SelectWindow(string)
		/// 
		public void SelectWindow(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("SelectWindow",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::Sequence(string,string,string)
		/// \~english
		/// \copydoc IOKW_State::Sequence(string,string,string)
		public void Sequence(string fpsObjectName, string fpsSequenceName, string SEQ_ID)
		{
			Logger.Instance.LogFunctionStart("Sequence",
				"fpsObjectName", fpsObjectName,
				"fpsSequenceName", fpsSequenceName,
				"SEQ_ID", SEQ_ID);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::SetFocus(string)
		/// \~english
		/// \copydoc IOKW_State::SetFocus(string)
		/// 
		public void SetFocus(string fpsFunctionalname)
		{
			Logger.Instance.LogFunctionStart("SetFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \~english
		/// \~
		/// \author Zoltán Hrabovszki
		/// \date 02.03.2013
		/// 
		public void SetLanguage(string Language)
		{
			this.AL.Language = Language;
		}

		/// \~german
		/// \copydoc IOKW_State::SetValue(string,string)
		/// \~english
		/// \copydoc IOKW_State::SetValue(string,string)
		/// 
		public void SetValue(string fpsFunctionalname, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("SetValue", 
				"fpsFunctionalname", fpsFunctionalname);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::StartApp(string)
		/// \~english
		/// \copydoc IOKW_State::StartApp(string)
		/// 
		public void StartApp(string fpsApplikationName)
		{
			Logger.Instance.LogFunctionStart("StartApp", 
				"fps_ApplikationName", fpsApplikationName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::StopApp(string)
		/// \~english
		/// \copydoc IOKW_State::StopApp(string)
		/// 
		public void StopApp(string fpsApplikationName)
		{
			Logger.Instance.LogFunctionStart("StopApp",
				"fps_ApplikationName", fpsApplikationName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKey(string,string)
		/// \~english
		/// \copydoc IOKW_State::TypeKey(string,string)
		/// 
		public void TypeKey(string fpsFunctionalname, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("TypeKey", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
		/// 
		public void TypeKeyTablecell(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("TypeKeyTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsColl", fpsCol,
				"fpsRow", fpsRow,
				"fpsValue", fpsValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyWindow(string,string)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyWindow(string,string)
		public void TypeKeyWindow(string fpsFunctionalname, string fpsValue)
		{
			Logger.Instance.LogFunctionStart("TypeKeyWindow",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyCaption(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyCaption(string,string)
		public void VerifyCaption(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyExists(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyExists(string,string)
		public void VerifyExists(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyHasFocus(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyHasFocus(string,string)
		public void VerifyHasFocus(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyIsActive(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyIsActive(string,string)
		public void VerifyIsActive(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyLabel(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyLabel(string,string)
		public void VerifyLabel(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifySelectedValue(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifySelectedValue(string,string)
		public void VerifySelectedValue(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifySelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
		public void VerifyTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTooltip(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyTooltip(string,string)
		public void VerifyTooltip(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyValue(string,string)
		/// \~english
		/// \copydoc IOKW_State::VerifyValue(string,string)
		public void VerifyValue(string fpsFunctionalname, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		#region File_Methods

		/// \copydoc IOKW_State::FileDelete(string)
		public void FileDelete(string fpsPathAndFileName)
		{
			Logger.Instance.LogFunctionStart("FileDelete", "fpsPathAndFileName", fpsPathAndFileName);

			Logger.Instance.LogFunctionEnd();
		}

		/// \copydoc IOKW_State::VerifyFileExists(string,string)
		public void VerifyFileExists(string fpsPathAndFileName, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyFileExists",
				"fpsPathAndFileName", fpsPathAndFileName,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}

		/// \copydoc IOKW_State::VerifyDirectoryExists(string,string)
		public void VerifyDirectoryExists(string fpsPath, string fpsExpectedValue)
		{
			Logger.Instance.LogFunctionStart("VerifyDirectoryExists",
				"fpsPath", fpsPath,
				"fpsExpectedValue", fpsExpectedValue);

			Logger.Instance.LogFunctionEnd();
		}
		#endregion File_Methods
		#endregion Methods
	}
}