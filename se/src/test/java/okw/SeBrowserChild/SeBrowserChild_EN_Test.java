package okw.SeBrowserChild;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SeBrowserChild_EN_Test
    {

	String cvOKWObject = "SeBrowserChild" + "";
    
	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
	
	protected static String ApplicationName;

    @Rule
    public TestName name = new TestName();

        /// \brief
        /// 
        /// 
        @Test
        public void TC_SeBrowserChild_URL_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );

            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "http://test.openkeyword.de/TextField/TextField.htm");

            //EN.SelectWindow("Eingabefelder");
            EN.VerifyValue("URL", "http://test.openkeyword.de/TextField/TextField.htm");
       }

        @Test
        public void Chrome_Start_Stop_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
        }

        /// \brief
        /// Prüfen ob URL-Implemnetierung im BrowserChild vorhanden.
        /// 
        @Test
        public void TC_BrowserChild_URL_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );

            EN.StartApp( ApplicationName );
            
            EN.TypeKey("URL", "http://test.openkeyword.de");

            // EN.SelectWindow("Chrome");
            EN.VerifyValue("URL", "http://test.openkeyword.de");
        }

        @After
        public void myAfter() throws Exception
        {
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }
    }