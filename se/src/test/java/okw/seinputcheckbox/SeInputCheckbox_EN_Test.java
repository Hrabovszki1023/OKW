	/*
	    ==============================================================================
	      Author: Zoltán Hrabovszki <zh@openkeyword.de>

	      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
	      www.OpenKeyWord.de
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
package okw.seinputcheckbox;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWVerifyingFailsException;
import okw.exceptions.OKWNotAllowedValueException;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeInputCheckbox_EN_Test extends OKWTestBase
{
	protected String cvsObjektName = "SeCheckBox";

	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
	
	protected static String ApplicationName;
	


	@Test
    public void tcClickOn() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                // Set start condition: Set All Checkboxes to "CHECKED" 
                EN.SelectWindow("SeCheckBox");
                EN.SetValue("Salami", "CHECKED");
                EN.SetValue("Pilze", "CHECKED");
                EN.SetValue("Sardellen", "CHECKED");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.ClickOn("Salami");
                EN.ClickOn("Pilze");
                EN.ClickOn("Sardellen");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");

                EN.StopApp( ApplicationName );
                EN.EndTest();
           }

	@Test
	public void tcLogExists() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogExists("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
         
        }

        @Test
        public void tcLogHasFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogHasFocus("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
         }


        @Test
        public void tcLogIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogIsActive("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }
        

        @Test
        public void tcVerifyIsActive_ActualYesExpectedYes() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Pilze", "YES");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }


        @Test
        public void tcVerifyIsActive_ActualNoExpectedNo() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Disabled", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }


        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyIsActive_ActuelYesExpectedNO_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Pilze", "NO");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyIsActive_ActuelNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Disabled", "YES");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test
        public void tcMemorizeIsActive() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");

                EN.MemorizeIsActive("Salami", "SeCheckBox_MemorizeIsActive_Salami");

                assertEquals("YES", myMM.get("SeCheckBox_MemorizeIsActive_Salami"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test
        public void tcLogTooltip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogTooltip("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /// \brief
        /// Logget ob ein vorhandenes objekt existiert.
        /// 
        @Test
        public void tcMemorizeExists() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeExists("Salami", "SeCheckBox_MemorizeExists_1");

                assertEquals("YES", myMM.get("SeCheckBox_MemorizeExists_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \brief
        @Test
        public void tcMemorizeHasFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");

                EN.MemorizeHasFocus("Salami", "SeCheckBox_MemorizeHasFocus_Salami");
                EN.MemorizeHasFocus("Pilze", "SeCheckBox_MemorizeHasFocus_Pilze");

                assertEquals("NO", myMM.get("SeCheckBox_MemorizeHasFocus_Salami"));
                assertEquals("YES", myMM.get("SeCheckBox_MemorizeHasFocus_Pilze"));

                EN.SetFocus("Salami");

                EN.MemorizeHasFocus("Salami", "SeCheckBox_MemorizeHasFocus_Salami");
                EN.MemorizeHasFocus("Pilze", "SeCheckBox_MemorizeHasFocus_Pilze");

                assertEquals("YES", myMM.get("SeCheckBox_MemorizeHasFocus_Salami"));
                assertEquals("NO", myMM.get("SeCheckBox_MemorizeHasFocus_Pilze"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /// \brief
        /// Speichert ob ein vorhandenes objekt existiert.
        @Test
        public void tcMemorizeTooltip() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeTooltip("Salami", "SeCheckBox_MemorizeTooltip_1");

                assertEquals("title: Salami", myMM.get("SeCheckBox_MemorizeTooltip_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        /// \brief
        /// Speichert ob ein vorhandenes objekt existiert.
        @Test
        public void tcMemorizeValue() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeValue("Salami", "SeCheckBox_MemorizeValue_1");

                assertEquals("UNCHECKED", myMM.get("SeCheckBox_MemorizeValue_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        /** 
         *  Speichert ob ein vorhandenes objekt existiert.
         */  
        @Test
        public void tcLogValue() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogValue("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test
        public void tcSetValue() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "CHECKED");
                EN.SetValue("Pilze", "CHECKED");
                EN.SetValue("Sardellen", "CHECKED");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.SetValue("Salami", "UnChecked");
                EN.SetValue("Pilze", "UnChecked");
                EN.SetValue("Sardellen", "UnChecked");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");

                EN.SetValue("Salami", "Checked");
                EN.SetValue("Pilze", "Checked");
                EN.SetValue("Sardellen", "Checked");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.SetValue("Salami", "UnChecked");
                EN.SetValue("Pilze", "UnChecked");
                EN.SetValue("Sardellen", "UnChecked");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test //( expected = OKWNotAllowedValueException.class )
        public void tcSetValue_OKWNotAllowedValueException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "Zoli");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        @Test
        public void tcSelect() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.Select("Salami", "CHECKED");
                EN.Select("Pilze", "CHECKED");
                EN.Select("Sardellen", "CHECKED");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.Select("Salami", "UnChecked");
                EN.Select("Pilze", "UnChecked");
                EN.Select("Sardellen", "UnChecked");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");

                EN.Select("Salami", "Checked");
                EN.Select("Pilze", "Checked");
                EN.Select("Sardellen", "Checked");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.Select("Salami", "UnChecked");
                EN.Select("Pilze", "UnChecked");
                EN.Select("Sardellen", "UnChecked");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");

                EN.StopApp( ApplicationName );
                
                EN.EndTest();
        }


        
        @Test // ( expected = OKWNotAllowedValueException.class )
        public void tcSelect_OKWNotAllowedValueException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.Select("Salami", "Zoli");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        /// \brief
        /// Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
        /// 
        @Test
        public void tcSetFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                EN.VerifyHasFocus("Pilze", "NO");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Salami", "NO");
                EN.VerifyHasFocus("Pilze", "YES");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test
        public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("NotExists", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("NotExists", "YES");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test
        public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("Salami", "YES");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("Salami", "NO");
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \brief
        // Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
        // 
        @Test
        public void tcVerifyHasFocus() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Pilze", "YES");
                EN.VerifyHasFocus("Salami", "NO");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                EN.VerifyHasFocus("Pilze", "NO");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        // \brief
        // 
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyHasFocus_ActualYesExpectedNo_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Salami", "NO");
                EN.VerifyHasFocus("Pilze", "NO");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        // \brief
        // 
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyHasFocus_ActualNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                
                // Expected Exception...
                EN.VerifyHasFocus("Pilze", "YES");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test
        public void tcVerifyTooltip() throws Exception
        {
            try
            {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltip("Salami", "title: Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "F");
                throw e;
            }
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltip_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltip("Salami", "XXXTitle: Salami");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test
        public void tcVerifyTooltipWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipWCM("Salami", "title: Salami");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltipWCM_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipWCM("Salami", "#itle: Salami");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test
        public void tcVerifyTooltipREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipREGX("Salami", "title: Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltipREGX_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipREGX("Salami", "\\Witle: Salami");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test
        public void tcVerifyLabel() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabel("Salami", "Salami");

        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabel("Salami", "Sulami");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }


        @Test
        public void tcVerifyLabelWCM() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelWCM("Salami", "?alami");

                EN.EndTest();
         }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabelWCM_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelWCM("Salami", "?ulami");

                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }
       
        
        @Test
        public void tcVerifyLabelREGX() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelREGX("Salami", "Salami");


                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabelREGX_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelREGX("Salami", ".ulami");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test
        public void tcVerifyValue() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "CHECKED");
                EN.SetValue("Pilze", "CHECKED");
                EN.SetValue("Sardellen", "CHECKED");

                EN.VerifyValue("Salami", "CHECKED");
                EN.VerifyValue("Pilze", "CHECKED");
                EN.VerifyValue("Sardellen", "CHECKED");

                EN.SetValue("Salami", "UNCHECKED");
                EN.SetValue("Pilze", "UNCHECKED");
                EN.SetValue("Sardellen", "UNCHECKED");

                EN.VerifyValue("Salami", "UNCHECKED");
                EN.VerifyValue("Pilze", "UNCHECKED");
                EN.VerifyValue("Sardellen", "UNCHECKED");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test
        public void tcMemorizeLabel() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeLabel("Salami", "SeCheckBox_MemorizeLabel_1");

                assertEquals("Salami", myMM.get("SeCheckBox_MemorizeLabel_1"));

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        @Test
        public void tcLogLabel() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogLabel("Salami");

                EN.StopApp( ApplicationName );
                EN.EndTest();
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyValue_ActuelCHECKED_ExpectedUNCHECKED_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "CHECKED");
                EN.VerifyValue("Salami", "UNCHECKED");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcVerifyValue_ActuelUNCHECKED_ExpectedCHECKED_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "UNCHECKED");
                EN.VerifyValue("Salami", "CHECKED");

                EN.StopApp( ApplicationName );
                
                Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcClickOn_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.ClickOn( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcSelect_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.Select( "NotExists", "abc");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcTypeKey_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.TypeKey( "NotExists", "abc");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcSetValue_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue( "NotExists", "abc");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcSetFocus_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeCaption_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeCaption( "NotExists", "MemorizeCaption");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeHasFocus_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeHasFocus( "NotExists", "MemorizeHasFocus");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
       }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeIsActive_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeIsActive( "NotExists", "MemorizeIsActive");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeLabel_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeLabel( "NotExists", "MemorizeLabel");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeTooltip_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeTooltip( "NotExists", "MemorizeTooltip");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcMemorizeValue_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.MemorizeValue( "NotExists", "MemorizeVale");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogCaption_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogCaption( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogHasFocus_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogHasFocus( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogIsActive_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogIsActive( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogLabel_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogLabel( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogTooltip_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogTooltip( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcLogValue_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogValue( "NotExists");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyCaption_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyCaption( "NotExists", "aa");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyHasFocus_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyHasFocus( "NotExists", "YES");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyIsActive_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive( "NotExists", "YES" );
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyLabel_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyLabel( "NotExists", "aa" );
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
        
        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyTooltip_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyTooltip( "NotExists", "aa");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }

        
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcVerifyValue_OKWGUIObjectNotFoundException() throws Exception
        {
                EN.BeginTest( TestName );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyValue( "NotExists", "aa");
                
                Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
                {
                    EN.EndTest();
                });
        }
}