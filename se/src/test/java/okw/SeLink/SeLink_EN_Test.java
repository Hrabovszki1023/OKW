package okw.SeLink;

import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Ignore
public class SeLink_EN_Test
{
    String cvOKWObject = "SeLink" + "";
    
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
	        public void TC_ClickOn() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.ClickOn("Google");
	                EN.VerifyValue("URL", "https://www.google.de/?gws_rd=ssl");


	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");
	                EN.ClickOn("Yahoo");
	                EN.VerifyValue("URL", "https://de.yahoo.com/");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "ClickOn", "P");
	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "ClickOn", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_LogCaption() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.LogCaption("Google");
	                EN.LogCaption("Yahoo");

	                // TODO ZH, 2014.06 Logging Prüfen

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogCaption", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogCaption", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_LogValue() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");

	                EN.LogValue("Google");
	                EN.LogValue("Yahoo");

	                // TODO ZH, 2014.06 Logging Prüfen

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogValue", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogValue", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Prüft ob ein vorhandenes objekt existiert.
	        /// Erwartet wird, dass das Objekt existiert.
	        /// 
	        @Test
	        public void TC_LogExists_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");

	                EN.LogExists("Google");
	                EN.LogExists("Yahoo");

	                // TODO ZH, 2014.06 Logging Prüfen
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogExists", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogExists", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Focus eines Textfeldes loggen.
	        /// 
	        @Test
	        public void TC_LogHasFocus_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");

	                EN.LogHasFocus("Google");
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogHasFocus", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogHasFocus", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Tooltip eines Textfeldes Prüfen.
	        /// 
	        @Test
	        public void TC_LogToolTip_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");

	                EN.LogTooltip("Google");
	                EN.LogTooltip("Yahoo");

	                // TODO ZH, 2014.06 Logging Prüfen
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogToolTip", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogToolTip", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_MemorizeCaption() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeCaption("Google", "SeLink_MemorizeCaption_1");
	                assertEquals("Google...", myMM.Get("SeLink_MemorizeCaption_1"));

	                EN.MemorizeCaption("Yahoo", "SeLink_MemorizeCaption_1");
	                assertEquals("Yahoo...", myMM.Get("SeLink_MemorizeCaption_1"));

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeCaption", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeCaption", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_MemorizeValue() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeValue("Google", "SeLink_MemorizeValue_1");
	                
	                String actuel = myMM.Get("SeLink_MemorizeValue_1");
	                assertEquals("http://www.google.de/", actuel);

	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeValue("Yahoo", "SeLink_MemorizeValue_1");
	                assertEquals("http://www.yahoo.de/", myMM.Get("SeLink_MemorizeValue_1"));

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeValue", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeValue", "F");
	                throw e;
	            }
	        }


	        /// \brief
	        /// Prüft die Methode SeLink.MemorizeToolTip.
	        /// 
	        @Test
	        public void TC_MemorizeExists_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeExists("Google", "SeLink_MemorizeExists_1");
	                assertEquals("YES", myMM.Get("SeLink_MemorizeExists_1"));

	                EN.MemorizeExists("Yahoo", "SeLink_MemorizeExists_1");
	                assertEquals("YES", myMM.Get("SeLink_MemorizeExists_1"));

	                EN.MemorizeExists("LinkNotExists", "SeLink_MemorizeExists_1");
	                assertEquals("NO", myMM.Get("SeLink_MemorizeExists_1"));

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeExists", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeExists", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Prüft die Methode SeLink.MemorizeFocus.
	        /// 
	        @Test
	        public void TC_MemorizeHasFocus_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeHasFocus("Yahoo", "SeLink_MemorizeHasFocus");
	                assertEquals("NO", myMM.Get("SeLink_MemorizeHasFocus"));
	                
	                
	                EN.SetFocus("Yahoo");
	                EN.MemorizeHasFocus("Yahoo", "SeLink_MemorizeHasFocus");
	                assertEquals("YES", myMM.Get("SeLink_MemorizeHasFocus"));
	                
	                
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeHasFocus", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeHasFocus", "F");
	                throw e;
	            }
	        }


	        /// \brief
	        /// Prüft die Methode SeLink.MemorizeToolTip.
	        /// 
	        @Test
	        public void TC_MemorizeToolTip_en() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.MemorizeTooltip("Google", "SeLink_MemorizeTooltip_1");
	                assertEquals( "Title: Google", myMM.Get("SeLink_MemorizeTooltip_1"));

	                EN.MemorizeTooltip("Yahoo", "SeLink_MemorizeTooltip_1");
	                assertEquals("Title: Yahoo", myMM.Get("SeLink_MemorizeTooltip_1"));

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeToolTip", "P");
	            }
	            catch (Exception e)
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeToolTip", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_SetFocus_VerifyHasFocus() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.SetFocus("Google");

	                EN.VerifyHasFocus( "Google", "YES" );
	                EN.VerifyHasFocus( "Yahoo", "NO" );

	                EN.SetFocus("Yahoo");

	                EN.VerifyHasFocus( "Yahoo", "YES" );
	                EN.VerifyHasFocus( "Google", "NO" );

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyHasFocus", "P");
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SetFocus", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyHasFocus", "F");
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SetFocus", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_VerifyCaption() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.VerifyCaption("Google", "Google...");
	                EN.VerifyCaption("Yahoo", "Yahoo...");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyCaption", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyCaption", "F");
	                throw e;
	            }
	        }

	        @Test
	        public void TC_VerifyValue() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.VerifyValue("Google", "http://www.google.de");
	                EN.VerifyValue("Yahoo", "http://www.yahoo.de");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");

	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Prüft die Methode SeLink.MemorizeToolTip.
	        /// 
	        /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _nicht_ vorhanden ist.
	        /// 
	        @Test
	        public void TC_VerifyExists_NO() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.VerifyExists("LinkNotExists", "NO");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Prüft die Methode SeLink.VerifyExists.
	        /// 
	        /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _nicht_ vorhanden ist.
	        /// -> Exception muss ausgelöst werden.
	        /// 
	        @Test
	        @Ignore
	        public void TC_VerifyExists_NO_YesObject() throws Exception
	        {

	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
		            EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");
		            
		            EN.SelectWindow("SeLink");
	                EN.VerifyExists("Google", "NO");
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");

	                fail("Exception ist nicht ausgelöst worden");
	            }
	            catch(Exception e) // \todo TODO: Exception Prüfen. Wurde die Richtige exception ausgelöst?
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
	                //Assert.Pass("Exception wurde ausgelöst worden");
	            }
	        }

	        /// \brief
	        /// Prüft die Methode SeLink.VerifyExists.
	        /// 
	        /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _vorhanden_ ist.
	        /// 
	        @Test
	        
	        public void TC_VerifyExists_YES() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");
	                
	                EN.SelectWindow("SeLink");
	                EN.VerifyExists("Google", "YES");
	                EN.VerifyExists("Yahoo", "YES");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");
	                throw e;
	            }
	        }

	        /// \brief
	        /// Prüft die Methode SeLink.VerifyExists.
	        /// 
	        /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _vorhanden_ ist.
	        /// 
	        @Test
	        @Ignore
	        public void TC_VerifyExists_YES_NoObject() throws Exception
	        {

	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");
	                
	                EN.SelectWindow("SeLink");
	            	EN.VerifyExists("LinkNotExists", "YES");
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");

	                fail("Exception ist nicht ausgelöst worden");
	            }
	            catch(Exception e) // \todo TODO: Exception Prüfen. Wurde die Richtige exception ausgelöst?
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
	                //Assert.Pass("Exception wurde ausgelöst worden");
	            }
	        }

	        @Test
	        public void TC_VerifyToolTip() throws Exception
	        {
	            try
	            {
	                EN.BeginTest( name.getMethodName() );

	                EN.StartApp( ApplicationName );
	                EN.TypeKey("URL", "http://test.openkeyword.de/Link/Link.htm");

	                EN.SelectWindow("SeLink");
	                EN.VerifyTooltip("Google", "Title: Google");
	                EN.VerifyTooltip("Yahoo", "Title: Yahoo");

	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyTooltip", "P");
	            }
	            catch ( Exception e )
	            {
	                //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyTooltip", "P");
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
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogLabel", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "LogTablecellValue", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeLabel", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "MemorizeTablecellValue", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SelectMenu", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SelectTablecell", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "StopApp", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "StartApp", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyLabel", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyTablecellValue", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SelectWindow", "N");
	            //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SetValue", "N");

	        }
	        */
}
