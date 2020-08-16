package okw.sebutton;
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

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

    /**
     * \~
     * @ingroup groupSeleniumChildGUIAdapterTests
     * 
     * \~german
     * Basisklasse für Tests des GUI-Adapters SeButton.
     * 
     * - okw.SeButton.SeButton_Chrome_Test, 
     * - okw.SeButton.SeButton_FireFox_Test
     * - okw.SeButton.SeButten_HTMLUnitDriver_Test
     * werden von diese Klasse abgeleitet.
     * 
     * \~
     * \author Zoltán Hrabovszki
     * \date 2017-06-18
     * 
     * @author Zoltan Hrabovszki
     */
    @Disabled("Ignoring the whole fixture")
    public class SeButton_EN_Test extends OKWTestBase
    {
    	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;

    	/** \~german
         *
         * Test des Schlüsselwortes ClickOn für den GUI-Adapter SeButton.
         * 
         * \~
         * \author Zoltán Hrabovszki
        * \date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
        @Test
        public void tcClickOn() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.ClickOn("Button 1");
                EN.VerifyValue("Display", "Ich bin Button 1 - ganz normal");
                EN.ClickOn("Button 2");
                EN.VerifyValue("Display", "Ich bin Button 2 - ganz normal");

                EN.StopApp( ApplicationName );
                EN.EndTest();
         }

        /** \~german
         *
         * Test des Schlüsselwortes LogCaption für den GUI-Adapter SeButton.
         * 
         * \~
        * \date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
        @Test
        public void tcLogCaption() throws Exception
        {
                EN.BeginTest( TestName );

                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogCaption("Button 1");
                EN.LogCaption("Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /**
         *  \~german
         *  
         * Test des Schlüsselwortes LogExists für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogExists() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogExists("Button 1");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         *
         * Test des Schlüsselwortes LogHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogHasFocus() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogHasFocus("Button 1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogHasFocus", "P");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         *
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogToolTip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogTooltip("Button 1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        public void tcLogValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogValue("Button 1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes LogIsaCTIVE für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.LogIsActive("Button 1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeCaption() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.MemorizeCaption("Button 1", "SePushButton_MemorizeCaption_1" );
                assertEquals("Button 1", myMM.get("SePushButton_MemorizeCaption_1"));

                EN.MemorizeCaption("Button 2", "SePushButton_MemorizeCaption_2");
                assertEquals("Button 2", myMM.get("SePushButton_MemorizeCaption_2"));

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeLabel() throws Exception
        {

                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");
                
                EN.SelectWindow("Button not Active");

                EN.MemorizeLabel("Button 1", "SeButton_MemorizeLabel_1" );
                assertEquals("Label für Button1:", myMM.get("SeButton_MemorizeLabel_1"));

                EN.MemorizeLabel("Button 2", "SeButton_MemorizeLabel_2");
                assertEquals("Label für Button2:", myMM.get("SeButton_MemorizeLabel_2"));


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes MemorizeExists für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeExists() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.MemorizeExists("Button 1", "SePushButton_MemorizeExists_1");

                assertEquals("YES", myMM.get("SePushButton_MemorizeExists_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeHasFocus() throws Exception
        {
               EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.MemorizeHasFocus("Button 1", "SePushButton_MemorizeHasFocus");

                assertEquals("NO", myMM.get("SePushButton_MemorizeHasFocus"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeIsActive für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.MemorizeIsActive("Button 1", "SePushButton_MemorizeIsActive");

                assertEquals("YES", myMM.get("SePushButton_MemorizeIsActive"));

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }


        /** \~german
         *
         * Test des Schlüsselwortes MemorizeTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeTooltip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
               
                EN.SelectWindow("Button");
                EN.MemorizeTooltip("Button 1", "SePushButton_MemorizeTooltip_1");
                EN.MemorizeTooltip("Button 2", "SePushButton_MemorizeTooltip_2");

                assertEquals("Button 1 Tooltip/title", myMM.get("SePushButton_MemorizeTooltip_1"));
                assertEquals("Button 2 Tooltip/title", myMM.get("SePushButton_MemorizeTooltip_2"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeValue für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        public void tcMemorizeValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.MemorizeValue("Button 1", "SeButton_MemorizeTooltip_1");

                EN.TypeKey( "Display", "${SeButton_MemorizeTooltip_1}" );
                EN.VerifyValue( "Display", "${SeButton_MemorizeTooltip_1}" );
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcSetFocus_VerifyHasFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                
                EN.SetFocus("Button 1");

                EN.VerifyHasFocus( "Button 1", "YES" );
                EN.VerifyHasFocus( "Button 2", "NO" );

                EN.SetFocus("Button 2");

                EN.VerifyHasFocus( "Button 2", "YES" );
                EN.VerifyHasFocus( "Button 1", "NO" );

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes SelectMenu( FN ) für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.SelectMenu("Button 1");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        /** \~german
         *
         * Test des Schlüsselwortes SelectMenu( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu2_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.SelectMenu("Button 1", "What ever...");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }


        /** \~german
         *
         * Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSetValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.SetValue("Button 1", "What ever...");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        /** \~german
         *
         * Test des Schlüsselwortes Select( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelect_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");

                EN.Select("Button 1", "What ever...");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaption() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                
                EN.VerifyCaption("Button 1", "Button 1");
                EN.VerifyCaption("Button 2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaptionWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaptionWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                
                EN.VerifyCaptionWCM("Button 1", "?utton #");
                EN.VerifyCaptionWCM("Button 2", "?utton #");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaptionREGX für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaptionREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                // EN.VerifyValue("URL", "http://test.openkeyword.de/button/button.htm");
                 
                EN.SelectWindow("Button");
                
                EN.VerifyCaptionREGX("Button 1", "Button 1");
                EN.VerifyCaptionREGX("Button 2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyExists_ExsistsNOExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.VerifyExists("Does Not Exists", "NO");
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsNOExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
                
                EN.SelectWindow("Button");
                EN.VerifyExists("Does Not Exists", "YES");
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * 
         * Prüfung: Sollwert Nein  Istwert Ja.
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsYESExpectedNO() throws Exception
        {
            EN.BeginTest( TestName );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");
            
            EN.SelectWindow("Button");
            EN.VerifyExists("Button 1", "NO");
            Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
            {
                EN.EndTest();
            });
        }

  /** \~german
   *
   * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
   *
   * Prüfung: Sollwert Ja. Istwert Ja.
   * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
  @Test
  public void tcVerifyExists_ExistsYESExpectedYES() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/button/button.htm" );

    EN.SelectWindow( "Button" );
    EN.VerifyExists( "Button 1", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * Button 1 ist active (_nicht_ "disabled")
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyIsActive_ActiveYESExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

            	// Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button");

                EN.VerifyIsActive("Button 1", "YES");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * Button 1 ist active (_nicht_ "disabled")
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWVerifyingFailsException.class)
        public void tcVerifyIsActive_ActiveYESExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

               // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button");

                EN.VerifyIsActive("Button 1", "NO");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyIsActive_ActiveNOExpectedNO() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button not Active");

                EN.VerifyIsActive("Button 2", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test //(expected=OKWVerifyingFailsException.class)
        public void tcVerifyIsActive_ActiveNOExpectedYES() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button not Active");

                EN.VerifyIsActive("Button 2", "YES");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabel() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button not Active");

                EN.VerifyLabel("Button 1", "Label für Button1:");
                EN.VerifyLabel("Button 2", "Label für Button2:");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabelWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button not Active");

                EN.VerifyLabelWCM("Button 1", "Label für Button#:");
                EN.VerifyLabelWCM("Button 2", "Label für Button#:");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabelREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("Button not Active");

                EN.VerifyLabelREGX( "Button 1", "Label für Button1:");
                EN.VerifyLabelREGX( "Button 2", "Label für Button2:");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
        *
        * Schlüsselwortes VerifyPlaceholder für SeButton sollte OKWFrameObjectMethodNotImplemented auslösen
        * 
        * \~
        * \date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
       @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
       public void tcVerifyPlaceholder() throws Exception
       {
               EN.BeginTest( TestName );
               EN.StartApp( ApplicationName );
               EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

             // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
               EN.SelectWindow("Button not Active");

               EN.VerifyPlaceholder("Button 1", "Label für Button1: ");
               Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
               {
                   EN.EndTest();
               });
       }

       /** \~german
        *
        * Schlüsselwortes VerifyPlaceholderWCM für SeButton sollte OKWFrameObjectMethodNotImplemented auslösen
        * 
        * \~
        * \date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
       @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
       public void tcVerifyPlaceholderWCM() throws Exception
       {
               EN.BeginTest( TestName );
               EN.StartApp( ApplicationName );
               EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

             // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
               EN.SelectWindow("Button not Active");

               EN.VerifyPlaceholderWCM("Button 1", "Label für Button#: ");
               Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
               {
                   EN.EndTest();
               });
       }

       /** \~german
        *
        * Schlüsselwortes VerifyPlaceholderREGX für SeButton sollte OKWFrameObjectMethodNotImplemented auslösen
        * 
        * 
        * \~
        * \date 2018-10-28
        * 
        * @author Zoltan Hrabovszki
        */
       @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
       public void tcVerifyPlaceholderREGX() throws Exception
       {
               EN.BeginTest( TestName );
               EN.StartApp( ApplicationName );
               EN.TypeKey("URL", "http://test.openkeyword.de/button/button_disabled.htm");

             // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
               EN.SelectWindow("Button not Active");

               EN.VerifyPlaceholderREGX("Button 1", "Label für Button1: ");
               Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
               {
                   EN.EndTest();
               });
       }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyTooltip("Button 1", "Button 1 Tooltip/title");
                EN.VerifyTooltip("Button 2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
 
        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTipWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTipWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyTooltipWCM("Button 1", "?utton # Tooltip/title");
                EN.VerifyTooltipWCM("Button 2", "?utton # Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTipREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyTooltipREGX("Button 1", "Button 1 Tooltip/title");
                EN.VerifyTooltipREGX("Button 2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyValue für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyValue("Button 1", "Button 1 value");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyValueWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyValueWCM("Button 1", "?utton # value");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }


        /** \~german
         *
         * Test des Schlüsselwortes VerifyValueREGX für den GUI-Adapter SeButton.
         * 
         * \~
         * \date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/button/button.htm");

                EN.SelectWindow("Button");

                EN.VerifyValueREGX("Button 1", "Button 1 value");

                EN.StopApp( ApplicationName );
                Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
                {
                    EN.EndTest();
                });
        }
    }

