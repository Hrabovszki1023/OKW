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

package okw.iframe;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* \~german
* Basisklasse für die BACK Testfälle zur Ableitung von Browser-Testfällen
* 
*  - Firefox: okw.SeBACK.SeBACK_Firefox_Test
*  - Chrome: okw.SeBACK.SeBACK_Chrome_Test
*  - HTMLUnit: okw.SeBACK.SeBACK_HTMLUnit_Test
* 
*  @author Zoltan Hrabovszki
*  @date 2017-07-23
*/
@Disabled
public class IFrame_EN_Test extends OKWTestBase
{

  protected static Log2HTML myLog2HTML = null;

  protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  /**
   * \~german
   * Testet die Implementierung des Schlüsselwortes ClickOn( FN ) für Klasse SeBACK .
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcFind_iFrameWithID() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      
      EN.SetValue( "URL", "http://test.openkeyword.de/iframe/iframeWithID.htm" );
      EN.VerifyValue( "URL", "http://test.openkeyword.de/iframe/iframeWithID.htm" );

      EN.SelectWindow( "IFrameWithID" );
      EN.VerifyExists( "Button 1", "YES" );
      EN.VerifyExists( "Button 2", "YES" );
      
      EN.VerifyExists( "User", "YES" );
      EN.VerifyExists( "Password", "YES" );
      
      EN.VerifyCaption( "Button 1", "Button 1" );
      EN.VerifyCaption( "Button 2", "Button 2" );

      EN.VerifyTooltip( "User", "Title: User" );
      EN.VerifyTooltip( "Password", "Title: Password" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  /**
   * \~german
   * Testet die Implementierung des Schlüsselwortes ClickOn( FN ) für Klasse SeBACK .
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcFind_iFrameWithName() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      
      EN.SetValue( "URL", "http://test.openkeyword.de/iframe/iframeWithName.htm" );
      EN.VerifyValue( "URL", "http://test.openkeyword.de/iframe/iframeWithName.htm" );

      EN.SelectWindow( "IFrameWithName" );
      EN.VerifyExists( "Button 1", "YES" );
      EN.VerifyExists( "Button 2", "YES" );
      
      EN.VerifyExists( "User", "YES" );
      EN.VerifyExists( "Password", "YES" );
      
      EN.VerifyCaption( "Button 1", "Button 1" );
      EN.VerifyCaption( "Button 2", "Button 2" );

      EN.VerifyTooltip( "User", "Title: User" );
      EN.VerifyTooltip( "Password", "Title: Password" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * \~german
   * Testet die Implementierung des Schlüsselwortes ClickOn( FN ) für Klasse SeBACK .
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcFind_iFrameWithID_WindowEmbeded() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      
      EN.SetValue( "URL", "http://test.openkeyword.de/iframe/iframeWithID.htm" );
      EN.VerifyValue( "URL", "http://test.openkeyword.de/iframe/iframeWithID.htm" );

      EN.SelectWindow( "Button" );
      EN.VerifyExists( "Button 1", "YES" );
      EN.VerifyExists( "Button 2", "YES" );
      
      EN.VerifyCaption( "Button 1", "Button 1" );
      EN.VerifyCaption( "Button 2", "Button 2" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

}
