package okw.SeButton;
/*
==============================================================================
Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

    /** \~german
     * Basisklasse für Tests des GUI-Adapters SeButton.
     * 
     * - okw.SeButton.SeButton_Chrome_Test, 
     * - okw.SeButton.SeButton_FireFox_Test
     * - okw.SeButton.SeButten_HTMLUnitDriver_Test
     * werden von diese Klasse abgeleitet.
     * 
     * \~
     * \author Zoltán Hrabovszki
     * @date 2017-06-18
     * 
     * @author Zoltan Hrabovszki
     */
    @Ignore("Ignoring the whole fixture")
    public class SeButton_Test
    {
    	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;
    	
        @Rule
        public TestName name = new TestName();
    	

        
        /** \~german
         *
         * Test des Schlüsselwortes ClickOn für den GUI-Adapter SeButton.
         * 
         * \~
         * \author Zoltán Hrabovszki
        * @date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
        @Test
        public void tcClickOn() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Button/button.htm");
                
                EN.SelectWindow("InputButton");

                EN.ClickOn("Text_1");
                EN.VerifyValue("Display", "Ich bin Button 1 - ganz normal");

                EN.ClickOn("Text_2");
                EN.VerifyValue("Display", "Ich bin Button 2 - ganz normal");

                EN.StopApp( ApplicationName );
                EN.EndTest();
         }

        /** \~german
         *
         * Test des Schlüsselwortes LogCaption für den GUI-Adapter SeButton.
         * 
         * \~
        * @date 2017-06-18
        * 
        * @author Zoltan Hrabovszki
        */
        @Test
        public void tcLogCaption() throws Exception
        {
                EN.BeginTest( name.getMethodName() );

                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogCaption("Text_1");
                EN.LogCaption("Text_2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /**
         *  \~german
         *  
         * Test des Schlüsselwortes LogExists für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogExists() throws Exception
        {

                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogExists("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         *
         * Test des Schlüsselwortes LogHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogHasFocus() throws Exception
        {

                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogHasFocus("Text_1");
                //ImplementationMatrix.Instance.SetImplementation("SePushButton", "LogHasFocus", "P");

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         *
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogToolTip() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogTooltip("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcLogValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogValue("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes LogIsaCTIVE für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcLogIsActive() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.LogIsActive("Text_1");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeCaption() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
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

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeLabel() throws Exception
        {

                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");
                
                EN.SelectWindow("InputButton not Active");

                EN.MemorizeLabel("Text_1", "SeButton_MemorizeLabel_1" );
                assertEquals("Label für Button1: ", myMM.get("SeButton_MemorizeLabel_1"));

                EN.MemorizeLabel("Text_2", "SeButton_MemorizeLabel_2");
                assertEquals("Label für Button2: ", myMM.get("SeButton_MemorizeLabel_2"));


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes MemorizeExists für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeExists() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeExists("Text_1", "SePushButton_MemorizeExists_1");

                assertEquals("YES", myMM.get("SePushButton_MemorizeExists_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeHasFocus() throws Exception
        {
               EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeHasFocus("Text_1", "SePushButton_MemorizeHasFocus");

                assertEquals("NO", myMM.get("SePushButton_MemorizeHasFocus"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeIsActive für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeIsActive() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeIsActive("Text_1", "SePushButton_MemorizeIsActive");

                assertEquals("YES", myMM.get("SePushButton_MemorizeIsActive"));

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }


        /** \~german
         *
         * Test des Schlüsselwortes MemorizeTooltip für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcMemorizeTooltip() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
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

        /** \~german
         *
         * Test des Schlüsselwortes MemorizeValue für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcMemorizeValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.MemorizeValue("Text_1", "SePushButton_MemorizeTooltip_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcSetFocus_VerifyHasFocus() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
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

        /** \~german
         *
         * Test des Schlüsselwortes SelectMenu( FN ) für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SelectMenu("Text_1");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes SelectMenu( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu2_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SelectMenu("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }


        /** \~german
         *
         * Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSetValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.SetValue("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes Select( FN, Val ) für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcSelect_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");

                EN.Select("Text_1", "What ever...");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaption für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaption() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaption("Text_1", "Button 1");
                EN.VerifyCaption("Text_2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaptionWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaptionWCM() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaptionWCM("Text_1", "?utton #");
                EN.VerifyCaptionWCM("Text_2", "?utton #");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyCaptionREGX für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyCaptionREGX() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                
                EN.VerifyCaptionREGX("Text_1", "Button 1");
                EN.VerifyCaptionREGX("Text_2", "Button 2");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyExists_ExsistsNOExpectedNO() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("Does Not Exists", "NO");
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsNOExpectedYES() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
                
                EN.SelectWindow("InputButton");
                EN.VerifyExists("Does Not Exists", "YES");
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
         * 
         * Prüfung: Sollwert Nein  Istwert Ja.
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsYESExpectedNO() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");
            
            EN.SelectWindow("InputButton");
            EN.VerifyExists("Text_1", "NO");
        }

  /** \~german
   *
   * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeButton.
   *
   * Prüfung: Sollwert Ja. Istwert Ja.
   * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
  @Test
  public void tcVerifyExists_ExistsYESExpectedYES() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputButton/input_type-button.htm" );

    EN.SelectWindow( "InputButton" );
    EN.VerifyExists( "Text_1", "YES" );

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
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyIsActive_ActiveYESExpectedYES() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

            	// Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton");

                EN.VerifyIsActive("Text_1", "YES");
                
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
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWVerifyingFailsException.class)
        public void tcVerifyIsActive_ActiveYESExpectedNO() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

               // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton");

                EN.VerifyIsActive("Text_1", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyIsActive_ActiveNOExpectedNO() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyIsActive("Text_2", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWVerifyingFailsException.class)
        public void tcVerifyIsActive_ActiveNOExpectedYES() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyIsActive("Text_2", "YES");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabel() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabel("Text_1", "Label für Button1: ");
                EN.VerifyLabel("Text_2", "Label für Button2: ");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabelWCM() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabelWCM("Text_1", "Label für Button#: ");
                EN.VerifyLabelWCM("Text_2", "Label für Button#: ");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeButton.
         * 
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyLabelREGX() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button_disabled.htm");

              // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
                EN.SelectWindow("InputButton not Active");

                EN.VerifyLabelREGX("Text_1", "Label für Button1: ");
                EN.VerifyLabelREGX("Text_2", "Label für Button2: ");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTip() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltip("Text_1", "Button 1 Tooltip/title");
                EN.VerifyTooltip("Text_2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
 
        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTipWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTipWCM() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltipWCM("Text_1", "?utton # Tooltip/title");
                EN.VerifyTooltipWCM("Text_2", "?utton # Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         *
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test
        public void tcVerifyToolTipREGX() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyTooltipREGX("Text_1", "Button 1 Tooltip/title");
                EN.VerifyTooltipREGX("Text_2", "Button 2 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyValue für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValue_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValue("Text_1", "Button 1 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         *
         * Test des Schlüsselwortes VerifyValueWCM für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValueWCM("Text_1", "?utton # Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }


        /** \~german
         *
         * Test des Schlüsselwortes VerifyValueTEGX für den GUI-Adapter SeButton.
         * 
         * \~
         * @date 2017-06-18
         * 
         * @author Zoltan Hrabovszki
         */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tcVerifyValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputButton/input_type-button.htm");

                EN.SelectWindow("InputButton");

                EN.VerifyValueREGX("Text_1", "Button 1 Tooltip/title");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
    }

