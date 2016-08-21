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
        public static void ClickOn(String FN) throws Exception
        {
            Log.LogKeyWordStart("Click on", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.ClickOn(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /**
         *  \copydoc IOKW_State::DoubleClickOn(String)
         */
        public static void DoubleClickOn(String FN) throws Exception
        {
            Log.LogKeyWordStart("DoubleClickOn", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.DoubleClickOn(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::EndTest()
        /// 
        /// \~english
        /// \copydoc IOKW_State::EndTest()
        /// 
        public static void EndTest() throws Exception
        {
            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.EndTest();
            }
            finally
            {
            	Log.LogTestcaseEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogCaption()
        /// 
        public static void LogCaption(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log Caption", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogCaption(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogExists()
        /// 
        public static void LogExists(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log exists", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogExists(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogHasFocus()
        /// 
        public static void LogHasFocus(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log has focus", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogHasFocus(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogIsActive()
        /// 
        public static void LogIsActive(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log is activ", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogIsActive(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogLabel()
        /// 
        public static void LogLabel(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log label", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogLabel(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogSelected()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogSelected()
        /// 
        public static void LogSelected(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log selected", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogSelected(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTablecellValue()
        /// 
        public static void LogTablecellValue(String FN, String fpsCol, String fpsRow) throws Exception
        {
            Log.LogKeyWordStart("Log tablecell value", FN, fpsCol, fpsRow);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogTablecellValue(FN, fpsCol, fpsRow);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogTooltip()
        /// 
        public static void LogTooltip(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log tooltip", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogTooltip(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::LogValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::LogValue()
        /// 
        public static void LogValue(String FN) throws Exception
        {
            Log.LogKeyWordStart("Log value", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.LogValue(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeCaption()
        /// 
        public static void MemorizeCaption(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize caption", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeCaption(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeExists()
        /// 
        public static void MemorizeExists(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize exists", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeExists(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeHasFocus()
        /// 
        public static void MemorizeHasFocus(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize has focus", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeHasFocus(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeIsActive()
        /// 
        public static void MemorizeIsActive(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize is activ", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeIsActive(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeLabel()
        /// 
        public static void MemorizeLabel(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize label", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeLabel(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeSelectedValue()
        /// 
        public static void MemorizeSelectedValue(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize selecte value", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeSelectedValue(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTablecellValue()
        /// 
        public static void MemorizeTablecellValue(String FN, String fpsCol, String fpsRow, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize tablecell value", FN, fpsCol, fpsRow, fpsKeyName);
            
            try{
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeTablecellValue(FN, fpsCol, fpsRow, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeTooltip()
        /// 
        public static void MemorizeTooltip(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize tooltip", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeTooltip(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::MemorizeValue()
        /// 
        public static void MemorizeValue(String FN, String fpsKeyName) throws Exception
        {
            Log.LogKeyWordStart("Memorize value", FN, fpsKeyName);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.MemorizeValue(FN, fpsKeyName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::Select(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(String)
        /// 
        public static void Select(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Select", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.Select(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::Select(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::Select(String)
        /// 
        public static void Select(String FN, String fpsValue, String fpsClickType) throws Exception
        {
            Log.LogKeyWordStart("Select", FN, fpsValue, fpsClickType);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.Select(FN, fpsValue, fpsClickType);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(String)
        /// 
        public static void SelectMenu(String FN) throws Exception
        {
            Log.LogKeyWordStart("Select menu", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SelectMenu(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SelectMenu(String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectMenu(String,String)
        /// 
        public static void SelectMenu(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Select menu", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SelectMenu(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(String,String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(String,String,String)
        /// 
        public static void SelectTablecell(String FN, String fpsCol, String fpsRow) throws Exception
        {
            Log.LogKeyWordStart("Select Tablecell", FN, fpsCol, fpsRow);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SelectTablecell(FN, fpsCol, fpsRow);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectTablecell(String,String,String,String)
        /// 
        public static void SelectTablecell(String FN, String fpsCol, String fpsRow, String fpsClickType) throws Exception
        {
            Log.LogKeyWordStart("Select Tablecell", FN, fpsCol, fpsRow, fpsClickType);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SelectTablecell(FN, fpsCol, fpsRow, fpsClickType);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SelectWindow()
        /// 
        public static void SelectWindow(String FN) throws Exception
        {
            Log.LogKeyWordStart("Select window", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SelectWindow(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /**
         *  \copydoc IOKW_State::Sequence(String,String,String)
         */
        public static void Sequence(String fpsObjectName, String fpsSequenceName, String SEQID) throws Exception
        {
            Log.LogSequenceStart("Sequence", fpsObjectName, fpsSequenceName, SEQID);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.Sequence(fpsObjectName, fpsSequenceName, SEQID);
            }
            finally
            {
            	Log.LogSequenceEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SetFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetFocus()
        /// 
        public static void SetFocus(String FN) throws Exception
        {
            Log.LogKeyWordStart("Set focus", FN);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SetFocus(FN);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::SetValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::SetValue()
        /// 
        public static void SetValue(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Set value", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.SetValue(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
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

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.StartApp(fpsApplicationName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
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

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.StopApp(fpsApplicationName);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKey()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKey()
        /// 
        public static void TypeKey(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey", FN, fpsValue);

            try
            {

            	myKernel.SetLanguage(Language);
            	myKernel.TypeKey(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyTablecell()
        /// 
        public static void TypeKeyTablecell(String FN, String fpsCol, String fpsRow, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey tablecell", FN, fpsCol, fpsRow, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.TypeKeyTablecell(FN, fpsCol, fpsRow, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        /// \~english
        /// \copydoc IOKW_State::TypeKeyWindow()
        /// 
        public static void TypeKeyWindow(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Typekey window", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.TypeKeyWindow(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        public static void VerifyCaption(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify caption", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyCaption(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }
 
        /// \~german
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        public static void VerifyCaptionREGX(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify caption REGX", FN, fpsValue);

            try
            {
              myKernel.SetLanguage(Language);
              myKernel.VerifyCaptionREGX(FN, fpsValue);
            }
            finally
            {
              Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyCaption()
        /// 
        public static void VerifyCaptionWCM(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify caption", FN, fpsValue);

            try
            {
              myKernel.SetLanguage(Language);
              myKernel.VerifyCaptionWCM(FN, fpsValue);
            }
            finally
            {
              Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyExists()
        /// 
        public static void VerifyExists(String FN, String fpsValue) throws Exception
        {
            Log.LogKeyWordStart("Verify exists", FN, fpsValue);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyExists(FN, fpsValue);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyHasFocus()
        /// 
        public static void VerifyHasFocus(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("Verify has focus", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyHasFocus(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyIsActive()
        /// 
        public static void VerifyIsActive(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("Verify is active", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyIsActive(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /**
         *  \copydoc IOKW_State::VerifyLabel()
         */
        public static void VerifyLabel(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("VerifyLabel", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyLabel(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /**
         *  \copydoc IOKW_State::VerifyLabelREGX()
         */
        public static void VerifyLabelREGX(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("VerifyLabelREGX", FN, ExpVal);

            try
            {
              myKernel.SetLanguage(Language);
              myKernel.VerifyLabelREGX(FN, ExpVal);
            }
            finally
            {
              Log.LogKeyWordEnd();
            }
        }
        /**
         *  \copydoc IOKW_State::VerifyLabelWCM()
         */
        public static void VerifyLabelWCM(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("VerifyLabelWCM", FN, ExpVal);

            try
            {
              myKernel.SetLanguage(Language);
              myKernel.VerifyLabelWCM(FN, ExpVal);
            }
            finally
            {
              Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifySelectedValue()
        /// 
        public static void VerifySelectedValue(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("Verify selected value", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifySelectedValue(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /// \~german
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        /// \~english
        /// \copydoc IOKW_State::VerifyTablecellValue()
        /// 
        public static void VerifyTablecellValue(String FN, String fpsCol, String fpsRow, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("Verify table cell value", FN, fpsCol, fpsRow, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyTablecellValue(FN, fpsCol, fpsRow, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }

        /**
         *  \copydoc IOKW_State::VerifyTooltip()
         */
        public static void VerifyTooltip(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("VerifyTooltip", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyTooltip(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }


        /**
        *
        *  \copydoc IOKW_State::VerifyTooltipWCM(String,String)
        */ 
       public static void VerifyTooltipWCM(String FN, String ExpVal) throws Exception
       {
           Log.LogKeyWordStart("VerifyTooltipWCM", FN, ExpVal);

           try
           {
            myKernel.SetLanguage(Language);
            myKernel.VerifyTooltipWCM(FN, ExpVal);
           }
           finally
           {
            Log.LogKeyWordEnd();
           }
       }

       /**
       *
       *  \copydoc IOKW_State::VerifyTooltipREGX(String,String)
       */ 
      public static void VerifyTooltipREGX(String FN, String ExpVal) throws Exception
      {
          Log.LogKeyWordStart("VerifyTooltipREGX", FN, ExpVal);

          try
          {
            myKernel.SetLanguage(Language);
            myKernel.VerifyTooltipREGX(FN, ExpVal);
          }
          finally
          {
            Log.LogKeyWordEnd();
          }
      }

        /**
         *
         *  \copydoc IOKW_State::VerifyValue(String,String)
         */ 
        public static void VerifyValue(String FN, String ExpVal) throws Exception
        {
            Log.LogKeyWordStart("Verify value", FN, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyValue(FN, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
        }


        /**
        *
        *  \copydoc IOKW_State::VerifyValueWCM(String,String)
        */ 
       public static void VerifyValueWCM(String FN, String ExpVal) throws Exception
       {
           Log.LogKeyWordStart("Verify value WCM", FN, ExpVal);

           try
           {
           	myKernel.SetLanguage(Language);
           	myKernel.VerifyValueWCM(FN, ExpVal);
           }
           finally
           {
           	Log.LogKeyWordEnd();
           }
       }

       /**
       *
       *  \copydoc IOKW_State::VerifyValueREGX(String,String)
       */ 
      public static void VerifyValueREGX(String FN, String ExpVal) throws Exception
      {
          Log.LogKeyWordStart("Verify value REGX", FN, ExpVal);

          try
          {
           myKernel.SetLanguage(Language);
           myKernel.VerifyValueREGX(FN, ExpVal);
          }
          finally
          {
           Log.LogKeyWordEnd();
          }
      }

      
		/**
		 *  \copydoc IOKW_State::VerifyFileExists(String,String)
		 */
		public static void VerifyFileExists(String fpsPathAndFileName, String ExpVal) throws Exception
		{
			Log.LogKeyWordStart("Verify file exists", fpsPathAndFileName, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyFileExists(fpsPathAndFileName, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
		}

		/**
		 *  \copydoc IOKW_State::VerifyDirectoyExists(String,String)
		 */
		public static void VerifyDirectoryExists(String fpsPath, String ExpVal) throws Exception
		{
			Log.LogKeyWordStart("Verify directory exists", fpsPath, ExpVal);

            try
            {
            	myKernel.SetLanguage(Language);
            	myKernel.VerifyDirectoryExists(fpsPath, ExpVal);
            }
            finally
            {
            	Log.LogKeyWordEnd();
            }
		}
	}
