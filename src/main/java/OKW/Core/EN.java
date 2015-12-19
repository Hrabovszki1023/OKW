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

    using OKW.Log;

    /// \~german
    /// \brief
    /// OKW.EN ist die deutschsprachige Implementation der OKW-Schlüsselwörter.
    /// 
    /// Diese Klasse bildet ausschliesslich ein Mapping der
    /// englischsprachigen Schlüsselwörter auf die korrespondierende Core-Methoden.
    /// 
    /// Alle Schlüsselwort-Methoden dieser Klasse setzten zunächst die Spracheinstellung der Klasse OKW.Core auf "EN"
    /// Danach erfolgt der Aufruf der korrespondierenden Core-Methode.
    /// 
    /// UseCase
    /// -------
    /// 
    /// @startuml{OKW_UseCase_Keyword_de.png}
    /// :Fachtester: -right-> (Testfall in Schlüsselwortnotation) : erstellt
    /// @enduml
    /// 
    /// \section secLoginEN Beispiel: Login
    /// Das folgende Beispiel zeigt die Beschreibung eines Login-Vorganges in Schlüsslewort-Notation.
    /// 
    /// \code
    /// EN.SelectWindow("Login")
    /// EN.SetValue("Benutzer", "Zoltan")
    /// EN.SetValue("Passwort", "gEHeim")
    /// EN.ClickOn("Weiter")
    /// \endcode
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.05.03
    public static class EN
    {
        #region Fields

        private static string Language = "EN";
        private static Core myKernel = new Core();

        #endregion Fields

        #region Methods

        /// \~german
        /// \copydoc IOKW_State::BeginTest()
        /// 
        /// \~english
        /// \copydoc IOKW_State::BeginTest()
        /// 
        public static void BeginTest(string Testname)
        {
            Logger.Instance.LogKeyWordStart("Begin Test", Testname);

            myKernel.SetLanguage(Language);
            myKernel.BeginTest(Testname);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::ClickOn(string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::ClickOn(string)
        /// 
        public static void ClickOn(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Click on", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.ClickOn(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::ClickOn(string,string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::ClickOn(string,string)
        /// 
        public static void ClickOn(string fpsFunctionalName, string fpsClickType)
        {
            Logger.Instance.LogKeyWordStart("Click on", fpsFunctionalName, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.ClickOn(fpsFunctionalName, fpsClickType);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::EndTest()
        /// 
        /// \~english
        /// \copydoc IOKW_State::EndTest()
        /// 
        public static void EndTest()
        {
            Logger.Instance.LogKeyWordStart("End Test");

            myKernel.SetLanguage(Language);
            myKernel.EndTest();

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogCaption()
        /// 
        public static void LogCaption(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log Caption", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogCaption(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogExists()
        /// 
        public static void LogExists(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log exists", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogExists(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        public static void LogHasFocus(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log has focus", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogHasFocus(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        public static void LogIsActive(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log is activ", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogIsActive(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogLabel()
        /// 
        public static void LogLabel(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log label", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogLabel(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogSelected()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogSelected()
        /// 
        public static void LogSelected(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log selected", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogSelected(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        public static void LogTablecellValue(string fpsFunctionalName, string fpsCol, string fpsRow)
        {
            Logger.Instance.LogKeyWordStart("Log tablecell value", fpsFunctionalName, fpsCol, fpsRow);

            myKernel.SetLanguage(Language);
            myKernel.LogTablecellValue(fpsFunctionalName, fpsCol, fpsRow);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        public static void LogTooltip(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log tooltip", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogTooltip(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogValue()
        /// 
        public static void LogValue(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Log value", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogValue(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        public static void MemorizeCaption(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize caption", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeCaption(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        public static void MemorizeExists(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize exists", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeExists(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        public static void MemorizeHasFocus(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize has focus", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeHasFocus(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        public static void MemorizeIsActive(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize is activ", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeIsActive(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        public static void MemorizeLabel(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize label", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeLabel(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        public static void MemorizeSelectedValue(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize selecte value", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeSelectedValue(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        public static void MemorizeTablecellValue(string fpsFunctionalName, string fpsCol, string fpsRow, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize tablecell value", fpsFunctionalName, fpsCol, fpsRow, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeTablecellValue(fpsFunctionalName, fpsCol, fpsRow, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        public static void MemorizeTooltip(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize tooltip", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeTooltip(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        public static void MemorizeValue(string fpsFunctionalName, string fpsKeyName)
        {
            Logger.Instance.LogKeyWordStart("Memorize value", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeValue(fpsFunctionalName, fpsKeyName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Select(string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(string)
        /// 
        public static void Select(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Select", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.Select(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Select(string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(string)
        /// 
        public static void Select(string fpsFunctionalName, string fpsValue, string fpsClickType)
        {
            Logger.Instance.LogKeyWordStart("Select", fpsFunctionalName, fpsValue, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.Select(fpsFunctionalName, fpsValue, fpsClickType);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(string)
        /// 
        public static void SelectMenu(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Select menu", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SelectMenu(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(string,string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(string,string)
        /// 
        public static void SelectMenu(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Select menu", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.SelectMenu(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(string,string,string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(string,string,string)
        /// 
        public static void SelectTablecell(string fpsFunctionalName, string fpsCol, string fpsRow)
        {
            Logger.Instance.LogKeyWordStart("Select Tablecell", fpsFunctionalName, fpsCol, fpsRow);

            myKernel.SetLanguage(Language);
            myKernel.SelectTablecell(fpsFunctionalName, fpsCol, fpsRow);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
        /// 
        public static void SelectTablecell(string fpsFunctionalName, string fpsCol, string fpsRow, string fpsClickType)
        {
            Logger.Instance.LogKeyWordStart("Select Tablecell", fpsFunctionalName, fpsCol, fpsRow, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.SelectTablecell(fpsFunctionalName, fpsCol, fpsRow, fpsClickType);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        public static void SelectWindow(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Select window", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SelectWindow(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Sequence()
        /// 
        /// \~english
        /// \copydoc IOKW_State::Sequence()
        /// 
        public static void Sequence(string fpsObjectName, string fpsSequenceName, string SEQID)
        {
            Logger.Instance.LogKeyWordStart("Sequece", fpsObjectName, fpsSequenceName, SEQID);

            myKernel.SetLanguage(Language);
            myKernel.Sequence(fpsObjectName, fpsSequenceName, SEQID);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SetFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetFocus()
        /// 
        public static void SetFocus(string fpsFunctionalName)
        {
            Logger.Instance.LogKeyWordStart("Set focus", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SetFocus(fpsFunctionalName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SetValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetValue()
        /// 
        public static void SetValue(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Set value", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.SetValue(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::StartApp()
        /// 
        /// \~english
        /// \copydoc IOKW_State::StartApp()
        /// 
        public static void StartApp(string fpsApplicationName)
        {
            Logger.Instance.LogKeyWordStart("Start app", fpsApplicationName);

            myKernel.SetLanguage(Language);
            myKernel.StartApp(fpsApplicationName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::StopApp()
        /// 
        /// \~english
        /// \copydoc IOKW_State::StopApp()
        /// 
        public static void StopApp(string fpsApplicationName)
        {
            Logger.Instance.LogKeyWordStart("Stop app", fpsApplicationName);

            myKernel.SetLanguage(Language);
            myKernel.StopApp(fpsApplicationName);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKey()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKey()
        /// 
        public static void TypeKey(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Typekey", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.TypeKey(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        public static void TypeKeyTablecell(string fpsFunctionalName, string fpsCol, string fpsRow, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Typekey tablecell", fpsFunctionalName, fpsCol, fpsRow, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.TypeKeyTablecell(fpsFunctionalName, fpsCol, fpsRow, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        public static void TypeKeyWindow(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Typekey window", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.TypeKeyWindow(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        public static void VerifyCaption(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Verify caption", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyCaption(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        public static void VerifyExists(string fpsFunctionalName, string fpsValue)
        {
            Logger.Instance.LogKeyWordStart("Verify exists", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyExists(fpsFunctionalName, fpsValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        public static void VerifyHasFocus(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify has focus", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyHasFocus(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        public static void VerifyIsActive(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify is active", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyIsActive(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyLabel()
        /// 
        public static void VerifyLabel(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify label", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyLabel(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        public static void VerifySelectedValue(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify selected value", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifySelectedValue(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        public static void VerifyTablecellValue(string fpsFunctionalName, string fpsCol, string fpsRow, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify table cell value", fpsFunctionalName, fpsCol, fpsRow, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyTablecellValue(fpsFunctionalName, fpsCol, fpsRow, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyTooltip()
        /// 
        public static void VerifyTooltip(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify tooltip", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyTooltip(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyValue()
        /// 
        public static void VerifyValue(string fpsFunctionalName, string fpsExpectedValue)
        {
            Logger.Instance.LogKeyWordStart("Verify value", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyValue(fpsFunctionalName, fpsExpectedValue);

            Logger.Instance.LogKeyWordEnd();
        }

		/// \~german
		/// \copydoc IOKW_State::VerifyFileExists(string,string)
		/// 
		public static void VerifyFileExists(string fpsPathAndFileName, string fpsExpectedValue)
		{
			Logger.Instance.LogKeyWordStart("Verify file exists", fpsPathAndFileName, fpsExpectedValue);

			myKernel.SetLanguage(Language);
			myKernel.VerifyFileExists(fpsPathAndFileName, fpsExpectedValue);

			Logger.Instance.LogKeyWordEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyDirectoyExists(string,string)
		/// 
		public static void VerifyDirectoryExists(string fpsPath, string fpsExpectedValue)
		{
			Logger.Instance.LogKeyWordStart("Verify directory exists", fpsPath, fpsExpectedValue);

			myKernel.SetLanguage(Language);
			myKernel.VerifyDirectoryExists(fpsPath, fpsExpectedValue);

			Logger.Instance.LogKeyWordEnd();
		}

	 #endregion Methods
	}
}