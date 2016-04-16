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

import okw.log.*;

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
    public class EN
    {

        private static String Language = "EN";
        private static Core myKernel = new Core();

        private static Logger_Sngltn Log = Logger_Sngltn.getInstance();
        
        
        /// \~german
        /// \copydoc IOKW_State::BeginTest()
        /// 
        /// \~english
        /// \copydoc IOKW_State::BeginTest()
        /// 
        public static void BeginTest(String Testname) throws Exception
        {
            Log.LogTestcaseStart( Testname );

            myKernel.SetLanguage(Language);
            myKernel.BeginTest(Testname);

        }

        /// \~german
        /// \copydoc IOKW_State::ClickOn(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::ClickOn(String)
        /// 
        public static void ClickOn(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Click on", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.ClickOn(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::ClickOn(String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::ClickOn(String,String)
        /// 
        public static void ClickOn(String fpsFunctionalName, String fpsClickType) throws Exception
        {
            Log.LogKeyWordStart("Click on", fpsFunctionalName, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.ClickOn(fpsFunctionalName, fpsClickType);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::EndTest()
        /// 
        /// \~english
        /// \copydoc IOKW_State::EndTest()
        /// 
        public static void EndTest() throws Exception
        {

            myKernel.SetLanguage(Language);
            myKernel.EndTest();

            Log.LogTestcaseEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogCaption()
        /// 
        public static void LogCaption(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log Caption", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogCaption(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogExists()
        /// 
        public static void LogExists(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log exists", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogExists(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        public static void LogHasFocus(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log has focus", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogHasFocus(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        public static void LogIsActive(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log is activ", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogIsActive(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogLabel()
        /// 
        public static void LogLabel(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log label", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogLabel(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogSelected()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogSelected()
        /// 
        public static void LogSelected(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log selected", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogSelected(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        public static void LogTablecellValue(String fpsFunctionalName, String fpsCol, String fpsRow) throws Exception
        {
            Log.LogKeyWordStart("Log tablecell value", fpsFunctionalName, fpsCol, fpsRow);

            myKernel.SetLanguage(Language);
            myKernel.LogTablecellValue(fpsFunctionalName, fpsCol, fpsRow);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        public static void LogTooltip(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log tooltip", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogTooltip(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::LogValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogValue()
        /// 
        public static void LogValue(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Log value", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.LogValue(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        public static void MemorizeCaption(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize caption", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeCaption(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        public static void MemorizeExists(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize exists", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeExists(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        public static void MemorizeHasFocus(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize has focus", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeHasFocus(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        public static void MemorizeIsActive(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize is activ", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeIsActive(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        public static void MemorizeLabel(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize label", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeLabel(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        public static void MemorizeSelectedValue(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize selecte value", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeSelectedValue(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        public static void MemorizeTablecellValue(String fpsFunctionalName, String fpsCol, String fpsRow, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize tablecell value", fpsFunctionalName, fpsCol, fpsRow, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeTablecellValue(fpsFunctionalName, fpsCol, fpsRow, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        public static void MemorizeTooltip(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize tooltip", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeTooltip(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        public static void MemorizeValue(String fpsFunctionalName, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize value", fpsFunctionalName, fpsKeyName);

            myKernel.SetLanguage(Language);
            myKernel.MemorizeValue(fpsFunctionalName, fpsKeyName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Select(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(String)
        /// 
        public static void Select(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Select", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.Select(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Select(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(String)
        /// 
        public static void Select(String fpsFunctionalName, String fpsValue, String fpsClickType) throws Exception
        {
            Log.LogKeyWordStart("Select", fpsFunctionalName, fpsValue, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.Select(fpsFunctionalName, fpsValue, fpsClickType);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(String)
        /// 
        public static void SelectMenu(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Select menu", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SelectMenu(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(String,String)
        /// 
        public static void SelectMenu(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Select menu", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.SelectMenu(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(String,String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(String,String,String)
        /// 
        public static void SelectTablecell(String fpsFunctionalName, String fpsCol, String fpsRow) throws Exception
        {
            Log.LogKeyWordStart("Select Tablecell", fpsFunctionalName, fpsCol, fpsRow);

            myKernel.SetLanguage(Language);
            myKernel.SelectTablecell(fpsFunctionalName, fpsCol, fpsRow);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
        /// 
        public static void SelectTablecell(String fpsFunctionalName, String fpsCol, String fpsRow, String fpsClickType) throws Exception
        {
            Log.LogKeyWordStart("Select Tablecell", fpsFunctionalName, fpsCol, fpsRow, fpsClickType);

            myKernel.SetLanguage(Language);
            myKernel.SelectTablecell(fpsFunctionalName, fpsCol, fpsRow, fpsClickType);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        public static void SelectWindow(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Select window", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SelectWindow(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::Sequence()
        /// 
        /// \~english
        /// \copydoc IOKW_State::Sequence()
        /// 
        public static void Sequence(String fpsObjectName, String fpsSequenceName, String SEQID) throws Exception
        {
            Log.LogSequenceStart("Sequece", fpsObjectName, fpsSequenceName, SEQID);

            myKernel.SetLanguage(Language);
            myKernel.Sequence(fpsObjectName, fpsSequenceName, SEQID);

            Log.LogSequenceEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SetFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetFocus()
        /// 
        public static void SetFocus(String fpsFunctionalName) throws Exception
        {
            Log.LogKeyWordStart("Set focus", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.SetFocus(fpsFunctionalName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::SetValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetValue()
        /// 
        public static void SetValue(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Set value", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.SetValue(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::StartApp()
        /// 
        /// \~english
        /// \copydoc IOKW_State::StartApp()
        /// 
        public static void StartApp(String fpsApplicationName) throws Exception
        {
            Log.LogKeyWordStart("Start app", fpsApplicationName);

            myKernel.SetLanguage(Language);
            myKernel.StartApp(fpsApplicationName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::StopApp()
        /// 
        /// \~english
        /// \copydoc IOKW_State::StopApp()
        /// 
        public static void StopApp(String fpsApplicationName) throws Exception
        {
            Log.LogKeyWordStart("Stop app", fpsApplicationName);

            myKernel.SetLanguage(Language);
            myKernel.StopApp(fpsApplicationName);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKey()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKey()
        /// 
        public static void TypeKey(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey", fpsFunctionalName);

            myKernel.SetLanguage(Language);
            myKernel.TypeKey(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        public static void TypeKeyTablecell(String fpsFunctionalName, String fpsCol, String fpsRow, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey tablecell", fpsFunctionalName, fpsCol, fpsRow, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.TypeKeyTablecell(fpsFunctionalName, fpsCol, fpsRow, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        public static void TypeKeyWindow(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey window", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.TypeKeyWindow(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        public static void VerifyCaption(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify caption", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyCaption(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        public static void VerifyExists(String fpsFunctionalName, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify exists", fpsFunctionalName, fpsValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyExists(fpsFunctionalName, fpsValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        public static void VerifyHasFocus(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify has focus", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyHasFocus(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        public static void VerifyIsActive(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify is active", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyIsActive(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyLabel()
        /// 
        public static void VerifyLabel(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify label", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyLabel(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        public static void VerifySelectedValue(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify selected value", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifySelectedValue(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        public static void VerifyTablecellValue(String fpsFunctionalName, String fpsCol, String fpsRow, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify table cell value", fpsFunctionalName, fpsCol, fpsRow, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyTablecellValue(fpsFunctionalName, fpsCol, fpsRow, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyTooltip()
        /// 
        public static void VerifyTooltip(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify tooltip", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyTooltip(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyValue()
        /// 
        public static void VerifyValue(String fpsFunctionalName, String fpsExpectedValue) throws Exception
        {
            Log.LogKeyWordStart("Verify value", fpsFunctionalName, fpsExpectedValue);

            myKernel.SetLanguage(Language);
            myKernel.VerifyValue(fpsFunctionalName, fpsExpectedValue);

            Log.LogKeyWordEnd();
        }

		/// \~german
		/// \copydoc IOKW_State::VerifyFileExists(String,String)
		/// 
		public static void VerifyFileExists(String fpsPathAndFileName, String fpsExpectedValue) throws Exception
		{
			Log.LogKeyWordStart("Verify file exists", fpsPathAndFileName, fpsExpectedValue);

			myKernel.SetLanguage(Language);
			myKernel.VerifyFileExists(fpsPathAndFileName, fpsExpectedValue);

			Log.LogKeyWordEnd();
		}

		/// \~german
		/// \copydoc IOKW_State::VerifyDirectoyExists(String,String)
		/// 
		public static void VerifyDirectoryExists(String fpsPath, String fpsExpectedValue) throws Exception
		{
			Log.LogKeyWordStart("Verify directory exists", fpsPath, fpsExpectedValue);

			myKernel.SetLanguage(Language);
			myKernel.VerifyDirectoryExists(fpsPath, fpsExpectedValue);

			Log.LogKeyWordEnd();
		}
	}
