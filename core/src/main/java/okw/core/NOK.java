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
				Log.LogFunctionStartDebug("BeginTest",
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
				Log.LogFunctionEndDebug();
			}
		}

		/// \~german
		/// \copydoc IOKW_State::ClickOn(String)
		/// \~english
		/// \copydoc IOKW_State::ClickOn(String)
		/// 
		public void ClickOn(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

	     /**
		  * \copydoc IOKW_State::ClickOn(string,string)
	      */
		public void ClickOn(String fpsFunctionalname, String fpsClickType)
		{
			Log.LogFunctionStartDebug("ClickOn", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsClickType", fpsClickType);
            
			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::EndTest()
		/// \~english
		/// \copydoc IOKW_State::EndTest()
		/// 
		public void EndTest()
		{
			// TODO: Aufräumen  Kill... usw aufrufen
			Log.LogFunctionStartDebug("EndTest");

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogCaption(String)
		/// \~english
		/// \copydoc IOKW_State::LogCaption(String)
		/// 
		public void LogCaption(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogCaption", "fpsFunctionalname", fpsFunctionalname);
            
			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogExists(String)
		/// \~english
		/// \copydoc IOKW_State::LogExists(String)
		/// 
		public void LogExists(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogExists",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogHasFocus(String)
		/// \~english
		/// \copydoc IOKW_State::LogHasFocus(String)
		/// 
		public void LogHasFocus(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogHasFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogIsActive(String)
		/// \~english
		/// \copydoc IOKW_State::LogIsActive(String)
		/// 
		public void LogIsActive(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogIsActive",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogLabel(String)
		/// \~english
		/// \copydoc IOKW_State::LogLabel(String)
		/// 
		public void LogLabel(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogLabel",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogSelected(String)
		/// \~english
		/// \copydoc IOKW_State::LogSelected(String)
		public void LogSelected(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogSelected",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTablecellValue(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::LogTablecellValue(String,String,String)
		/// 
		public void LogTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow)
		{
			Log.LogFunctionStartDebug("LogTablecellValue",
				"fpsCol", fpsCol,
				"fpsRow", fpsRow, 
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogTooltip(String)
		/// \~english
		/// \copydoc IOKW_State::LogTooltip(String)
		/// 
		public void LogTooltip(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogTooltip",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::LogValue(String)
		/// \~english
		/// \copydoc IOKW_State::LogValue(String)
		/// 
		public void LogValue(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("LogValue",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeCaption(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeCaption(String,String)
		/// 
		public void MemorizeCaption(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeExists(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeExists(String,String)
		public void MemorizeExists(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeHasFocus(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeHasFocus(String,String)
		/// 
		public void MemorizeHasFocus(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeIsActive(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeIsActive(String,String)
		/// 
		public void MemorizeIsActive(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// 
		public void MemorizeLabel(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeSelectedValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeSelectedValue(String,String)
		/// 
		public void MemorizeSelectedValue(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeSelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
		/// 
		public void MemorizeTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsMemKeyName", fpsMemKeyName);
			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeTooltip(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeTooltip(String,String)
		/// 
		public void MemorizeTooltip(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		/// 
		public void MemorizeValue(String fpsFunctionalname, String fpsMemKeyName)
		{
			Log.LogFunctionStartDebug("MemorizeValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsMemKeyName", fpsMemKeyName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(String,String)
		/// \~english
		/// \copydoc IOKW_State::Select(String,String)
		public void Select(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStartDebug("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::Select(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::Select(String,String,String)
		public void Select(String fpsFunctionalname, String fpsValue, String fpsClickType)
		{
			Log.LogFunctionStartDebug("Select",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue,
				"fpsClickType", fpsClickType);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(String)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(String)
		/// 
		public void SelectMenu(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("SelectMenu",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectMenu(String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectMenu(String,String)
		/// 
		public void SelectMenu(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStartDebug("SelectMenu", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(String,String,String)
		/// 
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow)
		{
			Log.LogFunctionStartDebug("SelectTablecell", 
				"fpsFunctionalname", fpsFunctionalname, 
				"fpsCol", fpsCol, 
				"fpsRow", fpsRow);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
		/// 
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsClickType)
		{
			Log.LogFunctionStartDebug(
				"SelectTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsClickType", fpsClickType);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::SelectWindow(String)
		/// \~english
		/// \copydoc IOKW_State::SelectWindow(String)
		/// 
		public void SelectWindow(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("SelectWindow",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::Sequence(String,String,String)
		/// \~english
		/// \copydoc IOKW_State::Sequence(String,String,String)
		public void Sequence(String fpsObjectName, String fpsSequenceName, String SEQ_ID)
		{
			Log.LogFunctionStartDebug("Sequence",
				"fpsObjectName", fpsObjectName,
				"fpsSequenceName", fpsSequenceName,
				"SEQ_ID", SEQ_ID);

			Log.LogFunctionEndDebug();
		}

    /**
    /// \copydoc IOKW_State::SetFocus(String)
    */
		public void SetFocus(String fpsFunctionalname)
		{
			Log.LogFunctionStartDebug("SetFocus",
				"fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
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

        /**
		 *  \copydoc IOKW_State::SetValue(String,String)
		 */ 
		public void SetValue(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStartDebug("SetValue", "fpsFunctionalname", fpsFunctionalname);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::StartApp(String)
		/// \~english
		/// \copydoc IOKW_State::StartApp(String)
		/// 
		public void StartApp(String fpsApplicationName)
		{
			Log.LogFunctionStartDebug("StartApp", 
				"fpsApplicationName", fpsApplicationName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::StopApp(String)
		/// \~english
		/// \copydoc IOKW_State::StopApp(String)
		/// 
		public void StopApp(String fpsApplicationName)
		{
			Log.LogFunctionStartDebug("StopApp",
				"fpsApplicationName", fpsApplicationName);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKey(String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKey(String,String)
		/// 
		public void TypeKey(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStartDebug("TypeKey", 
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
		/// 
		public void TypeKeyTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsValue)
		{
			Log.LogFunctionStartDebug("TypeKeyTablecell",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsColl", fpsCol,
				"fpsRow", fpsRow,
				"fpsValue", fpsValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::TypeKeyWindow(String,String)
		/// \~english
		/// \copydoc IOKW_State::TypeKeyWindow(String,String)
		public void TypeKeyWindow(String fpsFunctionalname, String fpsValue)
		{
			Log.LogFunctionStartDebug("TypeKeyWindow",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsValue", fpsValue);

			Log.LogFunctionEndDebug();
		}

		/**
		 *  \copydoc IOKW_State::VerifyCaption(String,String)
		 */
		public void VerifyCaption(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyCaption",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}
    /**
     *  \copydoc IOKW_State::VerifyCaption(String,String)
     */

		public void VerifyCaptionWCM(String fpsFunctionalname, String fpsExpectedValue)
    {
      Log.LogFunctionStartDebug("VerifyCaption",
        "fpsFunctionalname", fpsFunctionalname,
        "fpsExpectedValue", fpsExpectedValue);

      Log.LogFunctionEndDebug();
    }

    /**
     *  \copydoc IOKW_State::VerifyCaption(String,String)
     */
    public void VerifyCaptionREGX(String fpsFunctionalname, String fpsExpectedValue)
    {
      Log.LogFunctionStartDebug("VerifyCaption",
        "fpsFunctionalname", fpsFunctionalname,
        "fpsExpectedValue", fpsExpectedValue);

      Log.LogFunctionEndDebug();
    }

		/// \~german
		/// \copydoc IOKW_State::VerifyExists(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyExists(String,String)
		public void VerifyExists(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyExists",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyHasFocus(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyHasFocus(String,String)
		public void VerifyHasFocus(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyHasFocus",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyIsActive(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyIsActive(String,String)
		public void VerifyIsActive(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyIsActive",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyLabel(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyLabel(String,String)
		public void VerifyLabel(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyLabel",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifySelectedValue(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifySelectedValue(String,String)
		public void VerifySelectedValue(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifySelectedValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
		public void VerifyTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyTablecellValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyTooltip(String,String)
		/// \~english
		/// \copydoc IOKW_State::VerifyTooltip(String,String)
		public void VerifyTooltip(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyTooltip",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/**
		/// \copydoc IOKW_State::VerifyValue(String,String)
		*/
		public void VerifyValue(String fpsFunctionalname, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyValue",
				"fpsFunctionalname", fpsFunctionalname,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

    /**
    /// \copydoc IOKW_State::VerifyValueWCM(String,String)
    */
    public void VerifyValueWCM(String fpsFunctionalname, String fpsExpectedValue)
    {
      Log.LogFunctionStartDebug("VerifyValueWCM",
        "fpsFunctionalname", fpsFunctionalname,
        "fpsExpectedValue", fpsExpectedValue);

      Log.LogFunctionEndDebug();
    }

    /**
    /// \copydoc IOKW_State::VerifyValueREGX(String,String)
    */
    public void VerifyValueREGX(String fpsFunctionalname, String fpsExpectedValue)
    {
      Log.LogFunctionStartDebug("VerifyValue",
        "fpsFunctionalname",   fpsFunctionalname,
        "fpsExpectedValue",    fpsExpectedValue);

      Log.LogFunctionEndDebug();
    }

		/// \copydoc IOKW_State::FileDelete(String)
		public void FileDelete(String fpsPathAndFileName)
		{
			Log.LogFunctionStartDebug("FileDelete", "fpsPathAndFileName", fpsPathAndFileName);

			Log.LogFunctionEndDebug();
		}

		/// \copydoc IOKW_State::VerifyFileExists(String,String)
		public void VerifyFileExists(String fpsPathAndFileName, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyFileExists",
				"fpsPathAndFileName", fpsPathAndFileName,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}

		/// \copydoc IOKW_State::VerifyDirectoryExists(String,String)
		public void VerifyDirectoryExists(String fpsPath, String fpsExpectedValue)
		{
			Log.LogFunctionStartDebug("VerifyDirectoryExists",
				"fpsPath", fpsPath,
				"fpsExpectedValue", fpsExpectedValue);

			Log.LogFunctionEndDebug();
		}


		@Override
		public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName )
		{
      Log.LogFunctionStartDebug("CopyFile",
              "fpsSourcePathAndFileName", fpsSourcePathAndFileName,
              "fpsDestinationPathAndFileName", fpsDestinationPathAndFileName);

      Log.LogFunctionEndDebug();
		}
	}
