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
package okw.sebrowserchild;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
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