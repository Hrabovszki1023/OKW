/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.core;

import okw.OKW_TestClipboard;
import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreTests")
public class EN_VerifyExists_OKWVerifyingFailsException_Test {

  protected static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  protected static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  public String TestName;

  @BeforeEach
  void init(TestInfo testInfo)
  {
      TestName = testInfo.getTestMethod().get().getName();
  }    

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

    // Reset/init the Logger
    Logger_Sngltn.init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

   
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : nichtvorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyExists_ExistsYESExpectedNO_OKWVerifyingFailsException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.SetValue( "All_MethodsObj", "YES" );
    EN.VerifyExists( "All_MethodsObj", "NO" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : nichtvorhanden
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Ein zusätzliches Zeichen im Sollwert.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExist_ExistsNOExpextedYES_OKWVerifyingFailsException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.SetValue( "All_MethodsObj", "NO" );
    EN.VerifyExists( "All_MethodsObj", "YES" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
}
