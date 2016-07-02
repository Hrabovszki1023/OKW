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

import okw.FrameObjectDictionary_Sngltn;
import okw.log.Logger_Sngltn;
import okw.*;

/// \~german
    /// \brief
    /// Hier Statediagram...
    /// @startuml{OKW_State.png}
    /// [*] --> OK : Execute Test
    /// OK --> NOK : OKW_Exception
    /// NOK --> OK: BeginTest
    /// OK --> OK: OKW-Keyword
    /// OK --> [*]
    /// NOK --> [*]
    ///
    /// [*] --> OK_TRY : Try Test
    /// OK_TRY --> NOK_TRY : OKW_Exception
    /// NOK_TRY --> OK_TRY: BeginTest
    /// OK_TRY --> OK_TRY: OKW-Keyword
    /// OK_TRY --> [*]
    /// NOK_TRY --> [*]
    /// @enduml
    /// 
    ///
    /// @startuml{Overview.png}
    /// frame "Core"{
    ///   component [OK] as OK
    /// }
    ///  
    /// frame "TestToolAdapter"{
    ///  
    ///   frame "Selenium"{
    /// 
    ///    [SeAnyWin]
    ///    [SeBrowserChild]
    ///    [SeFireFox]
    ///    [SeTextFieled]
    /// 
    ///   }
    /// 
    ///   frame "AutoIt"{
    /// 
    ///    [AUITextfield]
    ///    [AUIWindow]
    ///   } 
    /// }
    /// @enduml
    /// 
    /// \~english
    /// \brief
    /// 
    /// 
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 09.01.2014
    public class Core implements IOKW_State
    {

        // zeigt auf die Klasse des aktuellen Zustandes
        private IOKW_State CurrentState;

        /// \~german
        /// \brief
        /// OKW-Konstuktor: Setzt den Default-Zustand auf OKW.OK.
        /// 
        /// 
        /// \~english
        /// \brief
        /// 
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 09.01.2014
        public Core()
        {
        	try
        	{
        		Init();
        		
        		this.SetCurrentState(new OK(this));
        	}
        	catch (Exception e)
        	{
        		OKW_HandleException.StopRunning(e, this.getClass());
        	}
        }

        @SuppressWarnings("unused")
		public static void Init()
        {
        	try{
		
        		// Init all Singelton...
        		Logger_Sngltn Log        = Logger_Sngltn.getInstance();

        		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
        		
        		OKW_Const_Sngltn myOKW_Const = OKW_Const_Sngltn.getInstance();
        		OKWLanguage CL = OKWLanguage.getInstance();
        		OKW_Memorize_Sngltn myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();
		
        		FrameObjectDictionary_Sngltn myFrameObjectDictionary = FrameObjectDictionary_Sngltn.getInstance();
		
        		OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
		
        	}
        	catch (Exception e)
        	{
        		OKW_HandleException.StopRunning(e, Core.class);
        	}
	}
        
		/// \copydoc IOKW_State::BeginTest(String)
		public void BeginTest(String Testname) throws Exception
        {
            this.CurrentState.BeginTest(Testname);
        }

		/// \copydoc IOKW_State::ClickOn(String)
		public void ClickOn(String fpsFunctionalname) throws Exception
        {
            this.CurrentState.ClickOn(fpsFunctionalname);
        }

	     /**
		  * \copydoc IOKW_State::ClickOn(string,string)
	      */
		public void ClickOn(String fpsFunctionalname, String fpsClickType) throws Exception
        {
            this.CurrentState.ClickOn(fpsFunctionalname, fpsClickType);
        }

		/// \copydoc IOKW_State::EndTest()
		public void EndTest() throws Exception
		{
			this.CurrentState.EndTest();
		}

		/// \copydoc IOKW_State::LogExists(String)
		public void LogExists(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogExists(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogHasFocus(String)
		public void LogHasFocus(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogHasFocus(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogIsActive(String)
		public void LogIsActive(String fpsFunctionalname) throws Exception
        {
            this.CurrentState.LogIsActive(fpsFunctionalname);
        }

		/// \copydoc IOKW_State::LogSelected(String)
		public void LogSelected(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogSelected(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogTablecellValue(String,String,String)
		public void LogTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow) throws Exception
        {
            this.CurrentState.LogTablecellValue(fpsFunctionalname, fpsCol, fpsRow);
        }

		/// \copydoc IOKW_State::LogTooltip(String)
		public void LogTooltip(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogTooltip(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogCaption(String)
		public void LogCaption(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogCaption(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogLabel(String)
		public void LogLabel(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogLabel(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogValue(String)
		public void LogValue(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.LogValue(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::MemorizeExists(String,String)
		public void MemorizeExists(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeExists(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeHasFocus(String,String)
		public void MemorizeHasFocus(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeHasFocus(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeIsActive(String,String)
		public void MemorizeIsActive(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeIsActive(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeSelectedValue(String,String)
		public void MemorizeSelectedValue(String fpsFunctionalname, String fpsValue) throws Exception
		{
		this.CurrentState.MemorizeSelectedValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
		public void MemorizeTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsKeyName) throws Exception
		{
			this.CurrentState.MemorizeTablecellValue(fpsFunctionalname, fpsCol, fpsRow, fpsKeyName);
		}

		/// \copydoc IOKW_State::MemorizeTooltip(String,String)
		public void MemorizeTooltip(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeTooltip(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeLabel(String,String)
		public void MemorizeLabel(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeLabel(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeCaption(String,String)
		public void MemorizeCaption(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeCaption(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeValue(String,String)
		public void MemorizeValue(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.MemorizeValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::Select(String,String)
		public void Select(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.Select(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::Select(String,String,String)
		public void Select(String fpsFunctionalname, String fpsValue, String fpsClickType) throws Exception
		{
			this.CurrentState.Select(fpsFunctionalname, fpsValue, fpsClickType);
		}

		/// \copydoc IOKW_State::SelectMenu(String,String)
		public void SelectMenu(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.SelectMenu(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::SelectMenu(String,String)
		public void SelectMenu(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.SelectMenu(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::SelectTablecell(String,String,String)
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow) throws Exception
		{
			this.CurrentState.SelectTablecell(fpsFunctionalname, fpsCol, fpsRow);
		}

		/// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
		public void SelectTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsClickType) throws Exception
		{
			this.CurrentState.SelectTablecell(fpsFunctionalname, fpsCol, fpsRow, fpsClickType);
		}

		/// \copydoc IOKW_State::SelectWindow(String)
		public void SelectWindow(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.SelectWindow(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::Sequence(String,String,String)
		public void Sequence(String fpsFunctionalname, String fpsSequenName, String SEQID) throws Exception
		{
			this.CurrentState.Sequence(fpsFunctionalname, fpsSequenName, SEQID);
		}

        /// \~german
        /// \brief
        /// Setter zum Setzen des aktuellen Zustandes.
        /// 
        /// \~english
        /// \brief
        /// 
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 09.01.2014
        public void SetCurrentState(IOKW_State fp_CurrentState)
        {
            this.CurrentState = fp_CurrentState;
        }

		/**
    \copydoc IOKW_State::SetFocus(String)
		*/
		public void SetFocus(String fpsFunctionalname) throws Exception
		{
			this.CurrentState.SetFocus(fpsFunctionalname);
		}

        /// \~german
        /// \brief
        /// Setzt die aktuelle Sprache.
        /// 
        /// \~english
        /// \brief
        /// 
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 09.01.2014
        public void SetLanguage(String Language)
        {
            this.CurrentState.SetLanguage(Language);
        }

		/// \copydoc IOKW_State::SetValue(String,String)
		public void SetValue(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.SetValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::StartApp(String)
		public void StartApp(String fpsApplicationName) throws Exception
		{
			this.CurrentState.StartApp(fpsApplicationName);
		}

		/// \copydoc IOKW_State::StopApp(String)
		public void StopApp(String fpsApplicationName) throws Exception
		{
			this.CurrentState.StopApp(fpsApplicationName);
		}

		/// \copydoc IOKW_State::TypeKey(String,String)
		public void TypeKey(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.TypeKey(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
		public void TypeKeyTablecell(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsValue) throws Exception
		{
			this.CurrentState.TypeKeyTablecell(fpsFunctionalname, fpsCol, fpsRow, fpsValue);
		}

		/// \copydoc IOKW_State::TypeKeyWindow(String,String)
		public void TypeKeyWindow(String fpsFunctionalname, String fpsValue) throws Exception
		{
			this.CurrentState.TypeKeyWindow(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::VerifyExists(String,String)
		public void VerifyExists(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyExists(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyHasFocus(String,String)
		public void VerifyHasFocus(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyHasFocus(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyIsActive(String,String)
		public void VerifyIsActive(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
		this.CurrentState.VerifyIsActive(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifySelectedValue(String,String)
		public void VerifySelectedValue(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifySelectedValue(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
		public void VerifyTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyTablecellValue(fpsFunctionalname, fpsCol, fpsRow, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyTooltip(String,String)
		public void VerifyTooltip(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyTooltip(fpsFunctionalname, fpsExpectedValue);
		}

		/**
		 *  \copydoc IOKW_State::VerifyCaption(String,String)
		 */  
		public void VerifyCaption(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyCaption(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyLabel(String,String)
		public void VerifyLabel(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyLabel(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyValue(String,String)
		public void VerifyValue(String fpsFunctionalname, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyValue(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::FileDelete(String)
		public void FileDelete(String fpsPathAndFileName) throws Exception
		{
			this.CurrentState.FileDelete(fpsPathAndFileName);
		}

		/// \copydoc IOKW_State::VerifyFileExists(String,String)
		public void VerifyFileExists(String fpsPathAndFileName, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyFileExists(fpsPathAndFileName, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyDirectoryExists(String,String)
		public void VerifyDirectoryExists(String fpsPathAndFileName, String fpsExpectedValue) throws Exception
		{
			this.CurrentState.VerifyDirectoryExists(fpsPathAndFileName, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::CopyFile(String,String)
		public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName ) throws Exception
		{
			this.CurrentState.CopyFile(fpsSourcePathAndFileName, fpsDestinationPathAndFileName);
		}
}