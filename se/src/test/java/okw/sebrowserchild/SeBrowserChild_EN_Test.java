package okw.sebrowserchild;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.core.OKWTestBase;
import okw.exceptions.*;

import org.junit.jupiter.api.*;

public class SeBrowserChild_EN_Test  extends OKWTestBase
    {

	String cvOKWObject = "SeBrowserChild" + "";
    
	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
	
	protected static String ApplicationName;
	
        /**
         * 
         */ 
        @Test
        public void tcSeBrowserChild_URL_VerifyValue() throws Exception
        {
            EN.BeginTest( TestName );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypePassword.htm" );

            EN.SelectWindow( "InputTypePassword" );
            EN.VerifyValue("URL", "http://test.openkeyword.de/InputText/InputTypePassword.htm");
            
            EN.StopApp( ApplicationName );
            EN.EndTest();
       }


        /**
         *  Prüfen ob URL-Implemnetierung im BrowserChild vorhanden.
         */ 
        @Test // ( expected = OKWVerifyingFailsException.class )
        public void tcBrowserChild_URL_OKWVerifyingFailsException() throws Exception
        {
          EN.BeginTest( TestName );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypePassword.htm" );

          EN.SelectWindow( "InputTypePassword" );
          EN.VerifyValue("URL", "Falscher Wert");
          
          Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
          {
              EN.EndTest();
          });
        }

        
        /**
         *  Prüft ob bei nicht vorhandenem Browserchild die Exception "" ausgelöst wird.
         */ 
        @Test // ( expected = OKWGUIObjectNotFoundException.class )
        public void tcBrowserChild_SelectWindowL_OKWGUIObjectNotFoundException() throws Exception
        {
          EN.BeginTest( TestName );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypePassword.htm" );

          EN.SelectWindow( "InputTypeTextDisabled" );
          
          Assertions.assertThrows( OKWGUIObjectNotFoundException.class, () ->
          {
              EN.EndTest();
          });
        }
        
        
        /**
         *  Prüft ob bei nicht vorhandenem Browserchild die Exception "" ausgelöst wird.
         */ 
        @Test
        public void tcBrowserChild_BACK() throws Exception
        {
          EN.BeginTest( TestName );

          EN.StartApp( ApplicationName );
          EN.SetValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

          EN.SetValue( "URL", "http://test.openkeyword.de/Link/a.htm" );
          EN.VerifyValue( "URL", "http://test.openkeyword.de/Link/a.htm" );

          EN.ClickOn( "BACK" );
          EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          
          EN.StopApp( ApplicationName );
          EN.EndTest();

        }

    }