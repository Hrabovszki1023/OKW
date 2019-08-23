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
 along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.

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

package browser;

import okw.core.EN;
import okw.log.log2html.Log2HTML;

import org.junit.*;
import org.junit.rules.TestName;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Ignore
public class FrmBrowserBase_Test {

  //OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();
	protected static Log2HTML myLog2HTML = null;

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  
  /**
   * Testet das Schlüsselwort TypeKey( FN, Val ) der Klasse SeURL.
   */ 
  @Test
  public void tcURL_TypeKey() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.SelectWindow(ApplicationName);
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * Testet das Schlüsselwort SetValue( FN ) der Klasse SeURL.
   */ 
  @Test
  public void tcURL_SetValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.SelectWindow(ApplicationName);
      EN.SetValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Testet das Schlüsselwort VerifyValueWCM( FN ) für das Virtuelle-GUI-Adapter URL Prüfen.
   */ 
  @Test
  public void tcURL_VerifyValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.SelectWindow(ApplicationName);
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.VerifyValueWCM( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.*" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * Testet das Schlüsselwort VerifyValueWCM( FN ) für das Virtuelle-GUI-Adapter URL Prüfen.
   */ 
  @Test
  public void tcURL_VerifyValueWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.SelectWindow(ApplicationName);
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.VerifyValueWCM( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.*" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Testet das Schlüsselwort VerifyValueWCM( FN ) für das Virtuelle-GUI-Adapter URL Prüfen.
   */ 
  @Test
  public void tcMAXIMIZE() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.SelectWindow(ApplicationName);
      EN.ClickOn( "MAXIMIZE" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  /**
   * Testet das Schlüsselwort StartApp( AppName ). OKWChromedriverPath ist **nicht** gesetzt.
   */ 
  @Test
  public void tcURL_StartApp_ohne_OKWChromedriverPath() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  /**
   * Testet das Schlüsselwort StartApp( AppName ). OKWChromedriverPath ist nicht gesetzt.
   */ 
  @Test
  public void tcURL_StartApp_mit_OKWChromedriverPath() throws Exception
  {
      
      String os_name = System.getProperty( "os.name" );

      switch ( os_name )
      {
          case "Mac OS X":
              System.setProperty( "OKWChromedriverPath", "/Applications/chromedriver" );
              okw.OKW_Properties.getInstance().setProperty( "OKWChromedriverPath", "/Applications/chromedriver" );
              break;
          case "Linux":
              System.setProperty( "OKWChromedriverPath", "/Applications/chromedriver" );
              okw.OKW_Properties.getInstance().setProperty( "OKWChromedriverPath", "/Applications/chromedriver" );
              break;
          default:
             break;
      }
      
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
}
