/*
 ==============================================================================
 Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

package okw.seinputfield;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Disabled
public class SeInputField_EN_Test2 extends OKWTestBase
{

  protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  /**
   * SeTextField -> InputTypeText
   * InputTypeText.htm -> InputTypeText.htm
   * Vorame -> First Name
   * Name -> Last Name
   */
  
  
  /**
   * Testet das Schlüsselwort ClickOn( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tcClickOn() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.ClickOn( "Last Name" );
      EN.VerifyHasFocus( "Last Name", "YES" );
      EN.VerifyHasFocus( "First Name", "NO" );

      EN.ClickOn( "First Name" );
      EN.VerifyHasFocus( "Last Name", "NO" );
      EN.VerifyHasFocus( "First Name", "YES" );
      
      EN.SetValue( "Last Name", "Müller");
      
      EN.HasValue( "Last Name", "Müller" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

}
