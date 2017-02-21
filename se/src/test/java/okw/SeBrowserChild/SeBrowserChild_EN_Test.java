package okw.SeBrowserChild;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.*;

import org.junit.*;

import org.junit.rules.TestName;

public class SeBrowserChild_EN_Test
    {

	String cvOKWObject = "SeBrowserChild" + "";
    
	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
	
	protected static String ApplicationName;

    @Rule
    public TestName name = new TestName();

        /** \brief
         * 
         */ 
        @Test
        public void tcSeBrowserChild_URL_VerifyValue() throws Exception
        {
            EN.BeginTest( name.getMethodName() );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

            EN.SelectWindow( "SeTextField" );
            EN.VerifyValue("URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm");
            
            EN.StopApp( ApplicationName );
            EN.EndTest();
       }


        /**
         *  Prüfen ob URL-Implemnetierung im BrowserChild vorhanden.
         */ 
        @Test( expected = OKWVerifyingFailsException.class )
        public void tcBrowserChild_URL_OKWVerifyingFailsException() throws Exception
        {
          EN.BeginTest( name.getMethodName() );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

          EN.SelectWindow( "SeTextField" );
          EN.VerifyValue("URL", "Falscher Wert");
        }

        
        /**
         *  Prüft ob bei nicht vorhandenem Browserchild die Exception "" ausgelöst wird.
         */ 
        @Test( expected = OKWGUIObjectNotFoundException.class )
        public void tcBrowserChild_SelectWindowL_OKWGUIObjectNotFoundException() throws Exception
        {
          EN.BeginTest( name.getMethodName() );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

          EN.SelectWindow( "SeInputTextDisabled" );
        
        }
    }