package okw.SeInputCheckbox;

import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


public class SeInputCheckbox_Test
{
	protected String cvsObjektName = "SeCheckBox";

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

	@Test
    public void tcClickOn() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
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

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "ClickOn", "P");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "ClickOn", "F");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "F");
                throw e;
            }
        }

	@Test
	public void tcLogExists() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.LogExists("Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogExists", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogExists", "F");
                throw e;
            }
        }

        @Test
        public void tcLogHasFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogHasFocus("Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogHasFocus", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogHasFocus", "F");
                throw e;
            }
        }


        @Test
        public void tcLogIsActive() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogIsActive("Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogHasFocus", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogHasFocus", "F");
                throw e;
            }
        }
        
        
        // \brief
        @Test
        public void tcVerifyIsActive_ActualYesExpectedYes() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Pilze", "YES");
        }

        // \brief
        @Test
        public void tcVerifyIsActive_ActualNoExpectedNo() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Disabled", "NO");
        }
        
        // \brief
        // 
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyIsActive_ActuelYesExpectedNO_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Pilze", "NO");
        }

        // \brief
        // 
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyIsActive_ActuelNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyIsActive("Disabled", "YES");
        }

        // \brief
        @Test
        public void tcMemorizeIsActive() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");

                EN.MemorizeIsActive("Salami", "SeCheckBox_MemorizeIsActive_Salami");

                assertEquals("YES", myMM.Get("SeCheckBox_MemorizeIsActive_Salami"));
        }

        
        @Test
        public void tcLogTooltip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogTooltip("Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogTooltip", "F");
                throw e;
            }
        }

        /// \brief
        /// Logget ob ein vorhandenes objekt existiert.
        /// 
        @Test
        public void tcMemorizeExists() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeExists("Salami", "SeCheckBox_MemorizeExists_1");

                assertEquals("YES", myMM.Get("SeCheckBox_MemorizeExists_1"));
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeExists", "P");
            }
            catch (Exception e)
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeExists", "F");
                throw e;
            }
        }

        // \brief
        @Test
        public void tcMemorizeHasFocus() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");

                EN.MemorizeHasFocus("Salami", "SeCheckBox_MemorizeHasFocus_Salami");
                EN.MemorizeHasFocus("Pilze", "SeCheckBox_MemorizeHasFocus_Pilze");

                assertEquals("NO", myMM.Get("SeCheckBox_MemorizeHasFocus_Salami"));
                assertEquals("YES", myMM.Get("SeCheckBox_MemorizeHasFocus_Pilze"));

                EN.SetFocus("Salami");

                EN.MemorizeHasFocus("Salami", "SeCheckBox_MemorizeHasFocus_Salami");
                EN.MemorizeHasFocus("Pilze", "SeCheckBox_MemorizeHasFocus_Pilze");

                assertEquals("YES", myMM.Get("SeCheckBox_MemorizeHasFocus_Salami"));
                assertEquals("NO", myMM.Get("SeCheckBox_MemorizeHasFocus_Pilze"));
                
        }

        /// \brief
        /// Speichert ob ein vorhandenes objekt existiert.
        @Test
        public void tcMemorizeTooltip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeTooltip("Salami", "SeCheckBox_MemorizeTooltip_1");

                assertEquals("title: Salami", myMM.Get("SeCheckBox_MemorizeTooltip_1"));
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeTooltip", "P");
            }
            catch (Exception e)
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeTooltip", "F");
                throw e;
            }
        }

        /// \brief
        /// Speichert ob ein vorhandenes objekt existiert.
        @Test
        public void tcMemorizeValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeValue("Salami", "SeCheckBox_MemorizeValue_1");

                assertEquals("UNCHECKED", myMM.Get("SeCheckBox_MemorizeValue_1"));
        }

        
        /// \brief
        /// Speichert ob ein vorhandenes objekt existiert.
        @Test
        public void tcLogValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogValue("Salami");

        }

        @Test
        public void tcSetValue() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
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

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "Select", "P");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "Select", "F");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "F");
                throw e;
            }
        }

        
        @Test
        public void tcSelect() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
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

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "Select", "P");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "Select", "F");
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyValue", "F");
                throw e;
            }
        }

        /// \brief
        /// Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
        /// 
        @Test
        public void tcSetFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                EN.VerifyHasFocus("Pilze", "NO");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Salami", "NO");
                EN.VerifyHasFocus("Pilze", "YES");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "SetFocus", "P");
            }
            catch (Exception e)
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "SetFocus", "F");
                throw e;
            }
        }

        @Test
        public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("NotExists", "NO");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "F");
                throw e;
            }
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("NotExists", "YES");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "F");
                throw e;
            }
        }

        @Test
        public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("Salami", "YES");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "F");
                throw e;
            }
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.VerifyExists("Salami", "NO");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyExists", "F");
                throw e;
            }
        }

        // \brief
        // Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
        // 
        @Test
        public void tcVerifyHasFocus() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Pilze", "YES");
                EN.VerifyHasFocus("Salami", "NO");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                EN.VerifyHasFocus("Pilze", "NO");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyHasFocus", "P");
            }
            catch (Exception e)
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyHasFocus", "F");
                throw e;
            }
        }

        // \brief
        // 
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyHasFocus_ActualYesExpectedNo_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Pilze");
                EN.VerifyHasFocus("Salami", "NO");
                EN.VerifyHasFocus("Pilze", "NO");
        }

        // \brief
        // 
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyHasFocus_ActualNoExpectedYes_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetFocus("Salami");
                EN.VerifyHasFocus("Salami", "YES");
                
                // Expected Exception...
                EN.VerifyHasFocus("Pilze", "YES");
        }
        
        @Test
        public void tcVerifyTooltip() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
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

        
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltip_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltip("Salami", "XXXTitle: Salami");
        }

        @Test
        public void tcVerifyTooltipWCM() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipWCM("Salami", "title: Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "F");
                throw e;
            }
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltipWCM_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipWCM("Salami", "#itle: Salami");
        }
        
        
        @Test
        public void tcVerifyTooltipREGX() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipREGX("Salami", "title: Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "F");
                throw e;
            }
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyTooltipREGX_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyTooltipREGX("Salami", "\\Witle: Salami");
        }

        @Test
        public void tcVerifyLabel() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabel("Salami", "Salami");

        }
        
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabel("Salami", "Sulami");
        }


        @Test
        public void tcVerifyLabelWCM() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelWCM("Salami", "?alami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "F");
                throw e;
            }
        }

        
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabelWCM_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelWCM("Salami", "?ulami");
        }
       
        
        @Test
        public void tcVerifyLabelREGX() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelREGX("Salami", "Salami");

                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "P");
            }
            catch ( Exception e )
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTooltip", "F");
                throw e;
            }
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyLabelREGX_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.VerifyLabelREGX("Salami", ".ulami");
        }

        @Test
        public void tcVerifyValue() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
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
        }

        @Test
        public void tcMemorizeLabel() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.MemorizeLabel("Salami", "SeCheckBox_MemorizeLabel_1");

                assertEquals("Salami", myMM.Get("SeCheckBox_MemorizeLabel_1"));
        }

        @Test
        public void tcLogLabel() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.LogLabel("Salami");
        }

        
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyValue_ActuelCHECKED_ExpectedUNCHECKED_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "CHECKED");
                EN.VerifyValue("Salami", "UNCHECKED");
        }

        @Test( expected = OKWVerifyingFailsException.class )
        public void tcVerifyValue_ActuelUNCHECKED_ExpectedCHECKED_OKWVerifyingFailsException() throws Exception
        {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/InputCheckbox/Input_type-checkbox.htm");

                EN.SelectWindow("SeCheckBox");

                EN.SetValue("Salami", "UNCHECKED");
                EN.VerifyValue("Salami", "CHECKED");
        }

}