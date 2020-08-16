package okw.seinputbutton;
/*
==============================================================================
Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

     /**
     * \~
     * @ingroup groupSeleniumChildGUIAdapterTests
     * \~german
     * Basisklasse für Test des GUI-Adapters SeInputButton.
     * 
     * SeInputButton_Chrome_Test, SeInputButton_FireFox_Test usw. werden von diese Klasse abgeleitet.
     * \~
     * \author Zoltán Hrabovszki
     * \date 2015.02.28
     * 
     * @author zoltan
     *
     */
    @Disabled("Ignoring the whole fixture")

    public class SeInputButton_EN_Test extends OKWTestBase
    {
    	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;
    	
        // \~german
        // \brief
        // Test des Schlüsselwortes ClickOn für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_ClickOn() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.ClickOn("Text_1");
                EN.VerifyValue("Display", "Ich bin Button 1 - ganz normal");

                EN.ClickOn("Text_2");
                EN.VerifyValue("Display", "Ich bin Button 2 - ganz normal");

                EN.StopApp( ApplicationName );
                EN.EndTest();
         }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogCaption für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_LogCaption() throws Exception
        {
                EN.BeginTest( TestName );

                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogCaption("Text_1");
                EN.LogCaption("Text_2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogExists für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_LogExists() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogExists("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogHasFocus für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_LogHasFocus() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogHasFocus("Text_1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogHasFocus", "P");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_LogToolTip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogTooltip("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_LogValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogValue("Text_1");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes LogIsaCTIVE für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_LogIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogIsActive("Text_1");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeCaption() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.MemorizeCaption("Text_1", "SePushButton_MemorizeCaption_1" );
                assertEquals("Button 1", myMM.get("SePushButton_MemorizeCaption_1"));

                EN.MemorizeCaption("Text_2", "SePushButton_MemorizeCaption_2");
                assertEquals("Button 2", myMM.get("SePushButton_MemorizeCaption_2"));

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeLabel() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");
                
                EN.SelectWindow("InputButton not Active");

                EN.MemorizeLabel("Text_1", "SeInputButton_MemorizeLabel_1" );
                assertEquals("Label für Button1:", myMM.get("SeInputButton_MemorizeLabel_1"));

                EN.MemorizeLabel("Text_2", "SeInputButton_MemorizeLabel_2");
                assertEquals("Label für Button2:", myMM.get("SeInputButton_MemorizeLabel_2"));


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeExists für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeExists() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeExists("Text_1", "SePushButton_MemorizeExists_1");

                assertEquals("YES", myMM.get("SePushButton_MemorizeExists_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeHasFocus für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeHasFocus() throws Exception
        {
               EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeHasFocus("Text_1", "SePushButton_MemorizeHasFocus");

                assertEquals("NO", myMM.get("SePushButton_MemorizeHasFocus"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeIsActive für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeIsActive("Text_1", "SePushButton_MemorizeIsActive");

                assertEquals("YES", myMM.get("SePushButton_MemorizeIsActive"));

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }


        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeTooltip für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_MemorizeTooltip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
               
                EN.SelectWindow("InputButton");
                EN.MemorizeTooltip("Text_1", "SePushButton_MemorizeTooltip_1");
                EN.MemorizeTooltip("Text_2", "SePushButton_MemorizeTooltip_2");

                assertEquals("Button 1 Tooltip/title", myMM.get("SePushButton_MemorizeTooltip_1"));
                assertEquals("Button 2 Tooltip/title", myMM.get("SePushButton_MemorizeTooltip_2"));


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes MemorizeValue für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_MemorizeValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeValue("Text_1", "SePushButton_MemorizeTooltip_1");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        // \~german
        // \brief
        // Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28

        @Test
        public void tc_SetFocus_VerifyHasFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.SetFocus("Text_1");

                EN.VerifyHasFocus( "Text_1", "YES" );
                EN.VerifyHasFocus( "Text_2", "NO" );

                EN.SetFocus("Text_2");

                EN.VerifyHasFocus( "Text_2", "YES" );
                EN.VerifyHasFocus( "Text_1", "NO" );

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes SelectMenu( FN ) für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SelectMenu("Text_1");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes SelectMenu( FN, Val ) für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SelectMenu2_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SelectMenu("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }


        // \~german
        // \brief
        // Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SetValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SetValue("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes Select( FN, Val ) für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_Select_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.Select("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyCaption für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyCaption() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaption("Text_1", "Button 1");
                EN.VerifyCaption("Text_2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyCaptionWCM für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyCaptionWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaptionWCM("Text_1", "?utton #");
                EN.VerifyCaptionWCM("Text_2", "?utton #");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyCaptionREGX für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyCaptionREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaptionREGX("Text_1", "Button 1");
                EN.VerifyCaptionREGX("Text_2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputButton.
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyExists_ExsistsNOExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("Does Not Exists", "NO");
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputButton.
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tc_VerifyExists_ExistsNOExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("Does Not Exists", "YES");
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputButton.
        // 
        // Prüfung: Sollwert Nein  Istwert Ja.
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test //( expected = OKWVerifyingFailsException.class )
        public void tc_VerifyExists_ExistsYESExpectedNO() throws Exception
        {
            EN.BeginTest( TestName );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
            
            EN.SelectWindow("InputButton");
            EN.VerifyExists("Text_1", "NO");
            
            Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
            {
                EN.EndTest();
            });
        }

  // \~german
  // \brief
  // Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputButton.
  //
  // Prüfung: Sollwert Ja. Istwert Ja.
  // \~
  // \author Zoltán Hrabovszki
  // \date 2015.02.28
  @Test
  public void tc_VerifyExists_ExistsYESExpectedYES() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputButton/input_type-button.htm" );

    EN.SelectWindow( "InputButton" );
    EN.VerifyExists( "Text_1", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputButton.
        // 
        // Button 1 ist active (_nicht_ "disabled")
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyIsActive_ActiveYESExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

            	// Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton");

                EN.VerifyIsActive("Text_1", "YES");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputButton.
        // 
        // Button 1 ist active (_nicht_ "disabled")
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWVerifyingFailsException.class)
        public void tc_VerifyIsActive_ActiveYESExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton");

                EN.VerifyIsActive("Text_1", "NO");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputButton.
        // 
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyIsActive_ActiveNOExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyIsActive("Text_2", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputButton.
        // 
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWVerifyingFailsException.class)
        public void tc_VerifyIsActive_ActiveNOExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyIsActive("Text_2", "YES");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeInputButton.
        // 
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyLabel() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabel("Text_1", "Label für Button1:");
                EN.VerifyLabel("Text_2", "Label für Button2:");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeInputButton.
        // 
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyLabelWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabelWCM("Text_1", "Label für Button#:");
                EN.VerifyLabelWCM("Text_2", "Label für Button#:");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeInputButton.
        // 
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyLabelREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabelREGX("Text_1", "Label für Button1:");
                EN.VerifyLabelREGX("Text_2", "Label für Button2:");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyToolTip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltip("Text_1", "Button 1 Tooltip/title");
                EN.VerifyTooltip("Text_2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
 
        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyToolTipWCM für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyToolTipWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltipWCM("Text_1", "?utton # Tooltip/title");
                EN.VerifyTooltipWCM("Text_2", "?utton # Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test
        public void tc_VerifyToolTipREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltipREGX("Text_1", "Button 1 Tooltip/title");
                EN.VerifyTooltipREGX("Text_2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyValue für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValue("Text_1", "Button 1 Tooltip/title");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyValueWCM für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValueWCM("Text_1", "?utton # Tooltip/title");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }


        // \~german
        // \brief
        // Test des Schlüsselwortes VerifyValueTEGX für den GUI-Adapter SeInputButton.
        // 
        // \~
        // \author Zoltán Hrabovszki
        // \date 2015.02.28
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValueREGX("Text_1", "Button 1 Tooltip/title");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }
    }

