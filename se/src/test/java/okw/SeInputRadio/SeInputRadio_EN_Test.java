package okw.SeInputRadio;
/*
==============================================================================
Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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
import okw.exceptions.OKWNotAllowedValueException;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

     /**
     * \~
     * @ingroup groupSeleniumChildGUIAdapterTests
     * 
     *\~german
     * \brief
     * Basisklasse für Test des GUI-Adapters SeInputRadio.
     * 
     * SeInputRadio_Chrome_Test, SeInputRadio_FireFox_Test usw. werden von diese Klasse abgeleitet.
     * \~
     * @author Zoltán Hrabovszki
     * @date 2016.12.11
     */
    @Ignore("Ignoring the whole fixture")
    public class SeInputRadio_EN_Test
    {
    	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;
    	
        @Rule
        public TestName name = new TestName();
    	

        /** \~german
         * \brief
         * Test des Schlüsselwortes ClickOn() für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
         */
        @Test
        public void tc_ClickOn() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.ClickOn("Visa");
                EN.VerifyValue("Visa", "CHECKED");
                EN.VerifyValue("American Express", "UNCHECKED");
                EN.VerifyValue("Mastercard", "UNCHECKED");
                
                EN.ClickOn("American Express");
                EN.VerifyValue("Visa", "UNCHECKED");
                EN.VerifyValue("American Express", "CHECKED");
                EN.VerifyValue("Mastercard", "UNCHECKED");

                EN.ClickOn("Mastercard");
                EN.VerifyValue("Visa", "UNCHECKED");
                EN.VerifyValue("American Express", "UNCHECKED");
                EN.VerifyValue("Mastercard", "CHECKED");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes DoubleClickOn() für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
         */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_DoubleClickOn_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.DoubleClickOn( "Visa");
        }
        
        /** \~german
        * \brief
        * Test des Schlüsselwortes LogCaption für den GUI-Adapter SeInputRadio.
        *
        * Ein SeRadioButton hat keine Caption -> OKWFrameObjectMethodNotImplemented
        * 
        * \~
        * @author Zoltán Hrabovszki
        * @date 2016.12.11
        */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_LogCaption() throws Exception
        {
           EN.BeginTest( name.getMethodName() );

           EN.StartApp( ApplicationName );
           EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
           EN.SelectWindow("SeInputRadioTestFrame");
           EN.LogCaption("Visa");

           EN.StopApp( ApplicationName );
           EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes LogExists für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_LogExists() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");
            EN.LogExists("Visa");
            
            EN.StopApp( ApplicationName );
            EN.EndTest();

        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes LogHasFocus für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=UnsupportedOperationException.class)
        public void tc_LogHasFocus_UnsupportedOperationException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                EN.LogHasFocus("Visa");
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_LogToolTip() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.LogTooltip("Visa");
                EN.LogTooltip("Inactive");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes LogTooltip für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_LogValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SetValue("Visa", "CHECKED");
                EN.LogValue("Visa");
                EN.LogValue("Inactive");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes LogIsActive für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_LogIsActive() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.LogIsActive("Visa");
                EN.LogIsActive("Inactive");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeCaption für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_MemorizeCaption() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.MemorizeCaption("Visa", "SeInputRadio_MemorizeCaption_1" );

                EN.StopApp( ApplicationName );
                EN.EndTest();

        }

        /** \~german
         * Test des Schlüsselwortes MemorizeLabel für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_MemorizeLabel() throws Exception
        {
                    EN.BeginTest( name.getMethodName() );
                    EN.StartApp( ApplicationName );
                    EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                             
                    EN.SelectWindow("SeInputRadioTestFrame");

                    EN.MemorizeLabel("Visa", "SeInputRadio_MemorizeLabel_1");
                    assertEquals("Visa", myMM.get("SeInputRadio_MemorizeLabel_1"));
                    
                    EN.MemorizeLabel("American Express", "SeInputRadio_MemorizeLabel_2");
                    assertEquals("American Express", myMM.get("SeInputRadio_MemorizeLabel_2"));
                    
                    EN.MemorizeLabel("Mastercard", "SeInputRadio_MemorizeLabel_3");
                    assertEquals("Mastercard", myMM.get("SeInputRadio_MemorizeLabel_3"));
                    
                    EN.StopApp( ApplicationName );
                    EN.EndTest();

        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeExists für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_MemorizeExists() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                
                EN.MemorizeExists("Visa", "SeInputRadio_MemorizeExists_1");

                assertEquals("YES", myMM.get("SeInputRadio_MemorizeExists_1"));
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeHasFocus für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=UnsupportedOperationException.class)
        public void tc_MemorizeHasFocus_UnsupportedOperationException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                EN.MemorizeHasFocus("Visa", "SeInputRadio_MemorizeHasFocus");
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeIsActive für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_MemorizeIsActive() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.MemorizeIsActive("Visa", "SeInputRadio_MemorizeIsActive_Visa");
                EN.MemorizeIsActive("Inactive", "SeInputRadio_MemorizeIsActive_Inactive");
                
                
                assertEquals("NO", myMM.get("SeInputRadio_MemorizeIsActive_Inactive"));
                
                EN.StopApp( ApplicationName );
                EN.EndTest();

        }


        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeTooltip für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_MemorizeTooltip() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.MemorizeTooltip("Visa", "SeInputRadio_MemorizeTooltip_Visa");
                EN.MemorizeTooltip("Inactive", "SeInputRadio_MemorizeTooltip_Inactive");

                assertEquals("title-Visa", myMM.get("SeInputRadio_MemorizeTooltip_Visa"));
                assertEquals("title-Disabled", myMM.get("SeInputRadio_MemorizeTooltip_Inactive"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes MemorizeValue für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_MemorizeValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SetValue("Visa", "CHECKED");
                
                EN.MemorizeValue("Visa", "SeInputRadio_MemorizeValue_Visa");
                EN.MemorizeValue("American Express", "SeInputRadio_MemorizeValue_AmericanExpress");
                
                assertEquals("CHECKED", myMM.get("SeInputRadio_MemorizeValue_Visa"));
                assertEquals("UNCHECKED", myMM.get("SeInputRadio_MemorizeValue_AmericanExpress"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
		*/
        @Test(expected=UnsupportedOperationException.class)
        public void tc_VerifyHasFocus_UnsupportedOperationException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                
                EN.VerifyHasFocus( "Visa", "YES" );
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes SetFocus und VerifyHasFocus für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
		*/
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SetFocus_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                
                EN.SetFocus( "Visa" );
        }
        
        
        /** \~german
         * \brief
         * Test des Schlüsselwortes SelectMenu( FN ) für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SelectMenu("Visa");
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes SelectMenu( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_SelectMenu2_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SelectMenu("Visa", "What ever...");
        }


        /** \~german
         * \brief
         * Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_SetValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SetValue("Visa", "CHECKED");
                EN.VerifyValue("Visa", "CHECKED");
                EN.VerifyValue("American Express", "UNCHECKED");
                EN.VerifyValue("Mastercard", "UNCHECKED");

                EN.SetValue("Mastercard", "CHECKED");
                EN.VerifyValue("Visa", "UNCHECKED");
                EN.VerifyValue("American Express", "UNCHECKED");
                EN.VerifyValue("Mastercard", "CHECKED");

                EN.SetValue("American Express", "CHECKED");
                EN.VerifyValue("Visa", "UNCHECKED");
                EN.VerifyValue("American Express", "CHECKED");
                EN.VerifyValue("Mastercard", "UNCHECKED");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * UNCHECKED is not allowed and causes an OKWNotAllowedValueException
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWNotAllowedValueException.class)
        public void tc_SetValue_OKWNotAllowedValueException_UNCHECKED() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SetValue("Visa", "UNCHECKED");
        }
 
        /** \~german
         * \brief
         * Test des Schlüsselwortes SetValue( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * Only CHECKED is allowed and all other values causes an OKWNotAllowedValueException
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWNotAllowedValueException.class)
        public void tc_SetValue_OKWNotAllowedValueException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.SetValue("Visa", "Ajhdttg");
        }
        
        /** \~german
         * \brief
         * Test des Schlüsselwortes Select( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * Ein SeRadioButton hat keine Caption -> OKWFrameObjectMethodNotImplemented
         *         
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_Select_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.Select("Visa", "CHECKED");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
}

        /** \~german
         * \brief
         * Test des Schlüsselwortes TypeKey( FN, Val ) für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=UnsupportedOperationException.class)
        public void tc_TypeKey_OKWFrameObjectMethodNotImplemented() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.TypeKey( "Visa", "What ever...");
        }
        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyCaption für den GUI-Adapter SeInputRadio.
         * 
        * Ein SeRadioButton hat keine Caption -> OKWFrameObjectMethodNotImplemented
        * 
        * \~
        * @author Zoltán Hrabovszki
        * @date 2016.12.11
        */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyCaption() throws Exception
        {
                EN.BeginTest( name.getMethodName() );

                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
                EN.SelectWindow("SeInputRadioTestFrame");
                
                EN.VerifyCaption("Visa", "ABC");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyCaptionWCM für den GUI-Adapter SeInputRadio.
         * 
         * Ein SeRadioButton hat keine Caption -> OKWFrameObjectMethodNotImplemented
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
         */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyCaptionWCM() throws Exception
        {
            EN.BeginTest( name.getMethodName() );

            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                 
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyCaptionWCM("Visa", "?ABC#");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyCaptionREGX für den GUI-Adapter SeInputRadio.
         * 
         * Ein SeRadioButton hat keine Caption -> OKWFrameObjectMethodNotImplemented
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
         */
        @Test (expected=OKWFrameObjectMethodNotImplemented.class)
        public void tc_VerifyCaptionREGX() throws Exception
        {
            EN.BeginTest( name.getMethodName() );

            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
            EN.SelectWindow("SeInputRadioTestFrame");
                
            EN.VerifyCaptionREGX("Visa", "ABC");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputRadio.
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyExists_ExsistsNOExpectedNO() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                EN.VerifyExists("Does Not Exists", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputRadio.
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test( expected = OKWVerifyingFailsException.class )
        public void tc_VerifyExists_ExistsNOExpectedYES() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");
                EN.VerifyExists("Does Not Exists", "YES");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputRadio.
         * 
         * Prüfung: Sollwert = "Nein"  Istwert = Ja.
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test( expected = OKWVerifyingFailsException.class )
        public void tc_VerifyExists_ExistsYESExpectedNO() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
            
            EN.SelectWindow("SeInputRadioTestFrame");
            EN.VerifyExists("Visa", "NO");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

  /** \~german
  // \brief
  // Test des Schlüsselwortes VerifyExists für den GUI-Adapter SeInputRadio.
  //
  // Prüfung: Sollwert Ja. Istwert Ja.
  // \~
  // @author Zoltán Hrabovszki
  // @date 2016.12.11
  */
  @Test
  public void tc_VerifyExists_ExistsYESExpectedYES() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
    
    EN.SelectWindow("SeInputRadioTestFrame");
    EN.VerifyExists( "Visa", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputRadio.
         * 
         * Button 1 ist active (_nicht_ "disabled")
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyIsActive_ActiveYESExpectedYES() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyIsActive("Visa", "YES");
                
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputRadio.
         * 
         * RadioButton Visa ist active (_nicht_ "disabled")
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWVerifyingFailsException.class)
        public void tc_VerifyIsActive_ActiveYESExpectedNO() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyIsActive("Visa", "NO");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }
        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputRadio.
         * 
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyIsActive_ActiveNOExpectedNO() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyIsActive("Inactive", "NO");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyIsActive für den GUI-Adapter SeInputRadio.
         * 
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test(expected=OKWVerifyingFailsException.class)
        public void tc_VerifyIsActive_ActiveNOExpectedYES() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyIsActive("Inactive", "YES");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        /** \~german
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeInputRadio.
         * 
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyLabel() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyLabel("Visa", "Visa");
            EN.VerifyLabel("American Express", "American Express");
            EN.VerifyLabel("Mastercard", "Mastercard");               

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        /** \~german
         * Test des Schlüsselwortes VerifyLabel für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.16
        */
        @Test
        public void tc_VerifyLabelWCM() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyLabelWCM("Visa", "Vis*");
            EN.VerifyLabelWCM("American Express", "American Express");
            EN.VerifyLabelWCM("Mastercard", "Mastercard");               

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyLabelREGX für den GUI-Adapter SeInputRadio.
         * 
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyLabelREGX() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                     
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyLabelREGX("Visa", "Vis.");
            EN.VerifyLabelREGX("American Express", "American Express");
            EN.VerifyLabelREGX("Mastercard", "Mastercard");               

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyToolTip() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
            
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyTooltip("Visa", "title-Visa");
            EN.VerifyTooltip("American Express", "title-American Express");
            EN.VerifyTooltip("Mastercard", "title-Mastercard");
            
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }
 
        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyToolTipWCM für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyToolTipWCM() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
                
                EN.SelectWindow("SeInputRadioTestFrame");

                EN.VerifyTooltipWCM("Visa", "title?Visa");
                EN.VerifyTooltipWCM("American Express", "title?American Express");
                EN.VerifyTooltipWCM("Mastercard", "title?Mastercard");
                
                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyToolTip für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyToolTipREGX() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
            
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.VerifyTooltipREGX("Visa", "title.Visa");
            EN.VerifyTooltipREGX("American Express", "title.American Express");
            EN.VerifyTooltipREGX("Mastercard", "title.Mastercard");
            
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyValue für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyValue() throws Exception
        {
        	tc_ClickOn();
        }

        
        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyValueWCM für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyValueWCM() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
            
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.ClickOn("Visa");
            EN.VerifyValueWCM("Visa", "CH*");
            EN.VerifyValueWCM("American Express", "UNCH*");
            EN.VerifyValueWCM("Mastercard", "UNCH*");
            
            EN.ClickOn("American Express");
            EN.VerifyValueWCM("Visa", "UNCH*");
            EN.VerifyValueWCM("American Express", "CH*");
            EN.VerifyValueWCM("Mastercard", "UNCH*");

            EN.ClickOn("Mastercard");
            EN.VerifyValueWCM("Visa", "UNCH*");
            EN.VerifyValueWCM("American Express", "UNCH*");
            EN.VerifyValueWCM("Mastercard", "CH*");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }


        /** \~german
         * \brief
         * Test des Schlüsselwortes VerifyValueREGX für den GUI-Adapter SeInputRadio.
         * 
         * \~
         * @author Zoltán Hrabovszki
         * @date 2016.12.11
        */
        @Test
        public void tc_VerifyValueREGX() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm");
            
            EN.SelectWindow("SeInputRadioTestFrame");

            EN.ClickOn("Visa");
            EN.VerifyValueWCM("Visa", "CH.+");
            EN.VerifyValueWCM("American Express", "UNCH.+");
            EN.VerifyValueWCM("Mastercard", "UNCH.+");
            
            EN.ClickOn("American Express");
            EN.VerifyValueWCM("Visa", "UNCH.+");
            EN.VerifyValueWCM("American Express", "CH.+");
            EN.VerifyValueWCM("Mastercard", "UNCH.+");

            EN.ClickOn("Mastercard");
            EN.VerifyValueWCM("Visa", "UNCH.+");
            EN.VerifyValueWCM("American Express", "UNCH.+");
            EN.VerifyValueWCM("Mastercard", "CH.+");

            EN.StopApp( ApplicationName );
            EN.EndTest();
        }
    }
