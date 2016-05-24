package okw.SeCheckBox;

import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


public class SeCheckBox_EN_Test
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
    public void TC_ClickOn_EN() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

                EN.SelectWindow("SeCheckBox");
                EN.Select("Salami", "CHECKED");
                EN.Select("Pilze", "CHECKED");
                EN.Select("Sardellen", "CHECKED");

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
	public void TC_LogExists_EN() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
        public void TC_LogHasFocus_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
        public void TC_LogTooltip_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
        public void TC_MemorizeExists_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        /// \brief
        /// Logget ob ein vorhandenes objekt existiert.
        /// 
        @Test
        public void TC_MemorizeHasFocus_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
                
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeHasFocus", "P");
            }
            catch (Exception e)
            {
                // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeHasFocus", "F");
                throw e;
            }
        }

        /// \brief
        /// Logget ob ein vorhandenes objekt existiert.
        /// 
        @Test
        public void TC_MemorizeTooltip_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        @Test
        public void TC_Select_EN() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
        public void TC_SetFocus_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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
        public void TC_VerifyExists_NO_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        @Test
        public void TC_VerifyExists_YES_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        /// \brief
        /// Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
        /// 
        @Test
        public void TC_VerifyHasFocus_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        @Test
        public void TC_VerifyTooltip_en() throws Exception
        {
            try
            {
                EN.BeginTest( name.getMethodName() );
                EN.StartApp( ApplicationName );
                EN.TypeKey("URL", "http://test.openkeyword.de/Checkbox/Checkbox.htm");

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

        /*
        /// \brief
        /// Liste der NICHT implementierten Methoden.
        /// 
        @Test
        public void __NotImplemented_en()
        {
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "LogTablecellValue", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "MemorizeTablecellValue", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "SelectMenu", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "SelectTablecell", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "StopApp", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "StartApp", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "VerifyTablecellValue", "N");
            // ImplementationMatrix.Instance.SetImplementation(cvsObjektName, "SelectWindow", "N");
        }
        */
}