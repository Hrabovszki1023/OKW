package okw.SePushButton;
/*
==============================================================================
Copyright © 2012, 2013, 2014, 2015, 2016 IT-Beratung Hrabovszki
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


import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

    /// \~german
    /// \brief
    /// Basisklasse für Test des GUI-Adapters SePushButton.
    /// 
    /// SePushButton_Chrome_Test, SePushButton_FireFox_Test usw. werden von diese Klasse abgeleitet.
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.02.28
    @Ignore("Ignoring the whole fixture")
    public class SePushButton_EN_Test
    {
    	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;
    	
        @Rule
        public TestName name = new TestName();
    	
        @After
        public void myAfter() throws Exception
        {
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }
        
        /// \~german
        /// \brief
        /// Test des Schlüsselwortes ClickOn für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_ClickOn() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");

                EN.ClickOn("Text_1");
                EN.VerifyValue("Anzeige", "Ich bin Button 1 - ganz normal");

                EN.ClickOn("Text_2");
                EN.VerifyValue("Anzeige", "Ich bin Button 2 - ganz normal");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "ClickOn", "P");

            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "ClickOn", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes LogCaption für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_LogCaption() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );

                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");

                EN.SelectWindow("InputButton");
                EN.LogCaption("Text_1");
                EN.LogCaption("Text_2");

                // TODO ZH, 2014.06 Logging Prüfen

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogCaption", "P");

            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogCaption", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes LogExists für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_LogExists() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogExists("Text_1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogExists", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogExists", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes LogHasFocus für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_LogHasFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogHasFocus("Text_1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogHasFocus", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogHasFocus", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes LogTooltip für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_LogToolTip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogTooltip("Text_1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogToolTip", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogToolTip", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes LogIsaCTIVE für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_LogIsActive() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogIsActive("Text_1");

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogIsActive", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogIsActive", "F");
                throw e;
            }
        }

        
        /// \~german
        /// \brief
        /// Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_MemorizeCaption() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");

                EN.MemorizeCaption("Text_1", "SePushButton_MemorizeCaption_1" );
                assertEquals("Button 1", myMM.Get("SePushButton_MemorizeCaption_1"));

                EN.MemorizeCaption("Text_2", "SePushButton_MemorizeCaption_2");
                assertEquals("Button 2", myMM.Get("SePushButton_MemorizeCaption_2"));

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeCaption", "P");
            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeCaption", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes MemorizeExists für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_MemorizeExists() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeExists("Text_1", "SePushButton_MemorizeExists_1");

                assertEquals("YES", myMM.Get("SePushButton_MemorizeExists_1"));
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeExists", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeExists", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes MemorizeHasFocus für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_MemorizeHasFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeHasFocus("Text_1", "SePushButton_MemorizeHasFocus");

                assertEquals("NO", myMM.Get("SePushButton_MemorizeHasFocus"));
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeHasFocus", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeHasFocus", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes MemorizeIsActive für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_MemorizeIsActive() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeIsActive("Text_1", "SePushButton_MemorizeIsActive");

                assertEquals("YES", myMM.Get("SePushButton_MemorizeIsActive"));
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeIsActive", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeIsActive", "F");
                throw e;
            }
        }


        /// \~german
        /// \brief
        /// Test des Schlüsselwortes MemorizeTooltip für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_MemorizeTooltip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeTooltip("Text_1", "SePushButton_MemorizeTooltip_1");
                EN.MemorizeTooltip("Text_2", "SePushButton_MemorizeTooltip_2");

                assertEquals("Button 1 Tooltip/title", myMM.Get("SePushButton_MemorizeTooltip_1"));
                assertEquals("Button 2 Tooltip/title", myMM.Get("SePushButton_MemorizeTooltip_2"));

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeToolTip", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeToolTip", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28

        @Test
        public void TC_SetFocus_VerifyHasFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.SetFocus("Text_1");

                EN.VerifyHasFocus( "Text_1", "YES" );
                EN.VerifyHasFocus( "Text_2", "NO" );

                EN.SetFocus("Text_2");

                EN.VerifyHasFocus( "Text_2", "YES" );
                EN.VerifyHasFocus( "Text_1", "NO" );

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyHasFocus", "P");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SetFocus", "P");

            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyHasFocus", "F");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SetFocus", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyCaption für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_VerifyCaption() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaption("Text_1", "Button 1");
                EN.VerifyCaption("Text_2", "Button 2");

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyCaption", "P");

            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyCaption", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyExists für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_VerifyExists_NO() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("NichtVorhanden", "NO");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyExists für den GUI-Adapter SePushButton.
        /// 
        /// Prüfung: Sollwert Nein  Istwert Ja.
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        /// TODO Zeitmessung einbauen
        /// 
        @Test
        public void TC_VerifyExists_NO_YesObject() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
            
            EN.SelectWindow("InputButton");
            
            try
            {
                EN.VerifyExists("Test_1", "NO");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "F");

                fail("Exception ist nicht ausgelöst worden");
            }
            catch( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "P");
                //Assert.Pass("Exception wurde ausgelöst worden");
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyExists für den GUI-Adapter SePushButton.
        /// 
        /// Prüfung: Sollwert Ja.  Istwert Ja.
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        /// TODO Zeitmessung einbauen
        /// 
        @Test
        public void TC_VerifyExists_YES() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("Text_1", "YES");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyExists für den GUI-Adapter SePushButton.
        /// 
        /// Prüfung: Sollwert Ja.  Istwert Nein.
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        /// TODO Zeitmessung einbauen
        @Test
        public void TC_VerifyExists_YES_NoObject() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");

            EN.SelectWindow("InputButton");

            try
            {
                EN.VerifyExists("NichtVorhanden", "YES");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "F");

                fail("Exception ist nicht ausgelöst worden");
            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyExists", "P");
                //Assert.Pass("Exception wurde ausgelöst worden");
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_VerifyIsActive() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");

            	// Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton");

                EN.VerifyIsActive("Text_1", "YES");
                EN.VerifyIsActive("Text_2", "NO");
                
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyIsActive", "P");
            }
            catch (Exception e)
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyIsActive", "F");
                throw e;
            }
        }

        /// \~german
        /// \brief
        /// Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SePushButton.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void TC_VerifyToolTip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/PushButton/PushButton.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltip("Text_1", "Button 1 Tooltip/title");
                EN.VerifyTooltip("Text_2", "Button 2 Tooltip/title");

                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyTooltip", "P");
                throw e;
            }
        }

        /*
        /// \~german
        /// \brief
        /// Kein Test! Methoden werden im Inplementaion Matrix als nicht implementiert eingetragen.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.02.28
        @Test
        public void __NotImplemented_en()
        {
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogLabel", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogTablecellValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeLabel", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "MemorizeTablecellValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SelectMenu", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SelectTablecell", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "StopApp", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "StartApp", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyLabel", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "VerifyTablecellValue", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SelectWindow", "N");
            //ImplementationMatrix.Instance.SetImplementation("SePushButton", "SetValue", "N");

        }
        */
    }

