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
    public class Core : IOKW_State
    {
        #region Fields

        // zeigt auf die Klasse des aktuellen Zustandes
        private IOKW_State CurrentState;

        #endregion Fields

        #region Constructors

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
            this.SetCurrentState(new OK(this));
        }

        #endregion Constructors

        #region Methods

		/// \copydoc IOKW_State::BeginTest(string)
		public void BeginTest(string Testname)
        {
            this.CurrentState.BeginTest(Testname);
        }

		/// \copydoc IOKW_State::ClickOn(string)
		public void ClickOn(string fpsFunctionalname)
        {
            this.CurrentState.ClickOn(fpsFunctionalname);
        }

		/// \copydoc IOKW_State::ClickOn(string,string)
		public void ClickOn(string fpsFunctionalname, string fpsClickType)
        {
            this.CurrentState.ClickOn(fpsFunctionalname, fpsClickType);
        }

		/// \copydoc IOKW_State::EndTest()
		public void EndTest()
		{
			this.CurrentState.EndTest();
		}

		/// \copydoc IOKW_State::LogExists(string)
		public void LogExists(string fpsFunctionalname)
		{
			this.CurrentState.LogExists(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogHasFocus(string)
		public void LogHasFocus(string fpsFunctionalname)
		{
			this.CurrentState.LogHasFocus(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogIsActive(string)
		public void LogIsActive(string fpsFunctionalname)
        {
            this.CurrentState.LogIsActive(fpsFunctionalname);
        }

		/// \copydoc IOKW_State::LogSelected(string)
		public void LogSelected(string fpsFunctionalname)
		{
			this.CurrentState.LogSelected(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
		public void LogTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow)
        {
            this.CurrentState.LogTablecellValue(fpsFunctionalname, fpsCol, fpsRow);
        }

		/// \copydoc IOKW_State::LogTooltip(string)
		public void LogTooltip(string fpsFunctionalname)
		{
			this.CurrentState.LogTooltip(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogCaption(string)
		public void LogCaption(string fpsFunctionalname)
		{
			this.CurrentState.LogCaption(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogLabel(string)
		public void LogLabel(string fpsFunctionalname)
		{
			this.CurrentState.LogLabel(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::LogValue(string)
		public void LogValue(string fpsFunctionalname)
		{
			this.CurrentState.LogValue(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::MemorizeExists(string,string)
		public void MemorizeExists(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeExists(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
		public void MemorizeHasFocus(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeHasFocus(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeIsActive(string,string)
		public void MemorizeIsActive(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeIsActive(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
		public void MemorizeSelectedValue(string fpsFunctionalname, string fpsValue)
		{
		this.CurrentState.MemorizeSelectedValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
		public void MemorizeTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsKeyName)
		{
			this.CurrentState.MemorizeTablecellValue(fpsFunctionalname, fpsCol, fpsRow, fpsKeyName);
		}

		/// \copydoc IOKW_State::MemorizeTooltip(string,string)
		public void MemorizeTooltip(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeTooltip(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeLabel(string,string)
		public void MemorizeLabel(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeLabel(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeCaption(string,string)
		public void MemorizeCaption(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeCaption(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::MemorizeValue(string,string)
		public void MemorizeValue(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.MemorizeValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::Select(string,string)
		public void Select(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.Select(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::Select(string,string,string)
		public void Select(string fpsFunctionalname, string fpsValue, string fpsClickType)
		{
			this.CurrentState.Select(fpsFunctionalname, fpsValue, fpsClickType);
		}

		/// \copydoc IOKW_State::SelectMenu(string,string)
		public void SelectMenu(String fpsFunctionalname)
		{
			this.CurrentState.SelectMenu(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::SelectMenu(string,string)
		public void SelectMenu(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.SelectMenu(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::SelectTablecell(string,string,string)
		public void SelectTablecell(string fpsFunctionalname, string fpsCol, string fpsRow)
		{
			this.CurrentState.SelectTablecell(fpsFunctionalname, fpsCol, fpsRow);
		}

		/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
		public void SelectTablecell(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsClickType)
		{
			this.CurrentState.SelectTablecell(fpsFunctionalname, fpsCol, fpsRow, fpsClickType);
		}

		/// \copydoc IOKW_State::SelectWindow(string)
		public void SelectWindow(string fpsFunctionalname)
		{
			this.CurrentState.SelectWindow(fpsFunctionalname);
		}

		/// \copydoc IOKW_State::Sequence(string,string,string)
		public void Sequence(string fpsFunctionalname, string fpsSequenName, string SEQID)
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

		/// \copydoc IOKW_State::SetFocus(string)
		public void SetFocus(string fpsFunctionalname)
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
        public void SetLanguage(string Language)
        {
            this.CurrentState.SetLanguage(Language);
        }

		/// \copydoc IOKW_State::SetValue(string,string)
		public void SetValue(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.SetValue(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::StartApp(string)
		public void StartApp(string fpsApplikationName)
		{
			this.CurrentState.StartApp(fpsApplikationName);
		}

		/// \copydoc IOKW_State::StopApp(string)
		public void StopApp(string fpsApplicationName)
		{
			this.CurrentState.StopApp(fpsApplicationName);
		}

		/// \copydoc IOKW_State::TypeKey(string,string)
		public void TypeKey(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.TypeKey(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
		public void TypeKeyTablecell(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsValue)
		{
			this.CurrentState.TypeKeyTablecell(fpsFunctionalname, fpsCol, fpsRow, fpsValue);
		}

		/// \copydoc IOKW_State::TypeKeyWindow(string,string)
		public void TypeKeyWindow(string fpsFunctionalname, string fpsValue)
		{
			this.CurrentState.TypeKeyWindow(fpsFunctionalname, fpsValue);
		}

		/// \copydoc IOKW_State::VerifyExists(string,string)
		public void VerifyExists(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyExists(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyHasFocus(string,string)
		public void VerifyHasFocus(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyHasFocus(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyIsActive(string,string)
		public void VerifyIsActive(string fpsFunctionalname, string fpsExpectedValue)
		{
		this.CurrentState.VerifyIsActive(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifySelectedValue(string,string)
		public void VerifySelectedValue(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifySelectedValue(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
		public void VerifyTablecellValue(string fpsFunctionalname, string fpsCol, string fpsRow, string fpsExpectedValue)
		{
			this.CurrentState.VerifyTablecellValue(fpsFunctionalname, fpsCol, fpsRow, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyTooltip(string,string)
		public void VerifyTooltip(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyTooltip(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyCaption(string,string)
		public void VerifyCaption(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyCaption(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyLabel(string,string)
		public void VerifyLabel(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyLabel(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyValue(string,string)
		public void VerifyValue(string fpsFunctionalname, string fpsExpectedValue)
		{
			this.CurrentState.VerifyValue(fpsFunctionalname, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::FileDelete(string)
		public void FileDelete(string fpsPathAndFileName)
		{
			this.CurrentState.FileDelete(fpsPathAndFileName);
		}

		/// \copydoc IOKW_State::VerifyFileExists(string,string)
		public void VerifyFileExists(string fpsPathAndFileName, string fpsExpectedValue)
		{
			this.CurrentState.VerifyFileExists(fpsPathAndFileName, fpsExpectedValue);
		}

		/// \copydoc IOKW_State::VerifyDirectoryExists(string,string)
		public void VerifyDirectoryExists(string fpsPathAndFileName, string fpsExpectedValue)
		{
			this.CurrentState.VerifyDirectoryExists(fpsPathAndFileName, fpsExpectedValue);
		}

		#endregion Methods
	}
}