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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_VerifyTooltip_OKWVerifyingFailsException_Test {

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

    // Reset/init the Logger
    Logger_Sngltn.init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer vor jedem Test(fall) ausgeführt.
  // /
  @Before
  public void setUp() throws Exception {

  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer nach jedem Test(fall) ausgeführt.
  // /
  @After
  public void tearDown() throws Exception {
    EN.EndTest();
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
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "All_MethodsObj", "Tha one and only Value" );
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
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_SV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "All_MethodsObj", "The one andX only Value" );
  }
 
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : nichtvorhanden
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Ein Zeichen zu wenig im Sollwert.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_SV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "All_MethodsObj", "The one an only Value" );
  }

  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: Ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_MV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "AllMethods_MultipleValues", "1. Value${SEP}X. Value${SEP}3. Value" );
  }


  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Sollwert 1 x ${SEP}, Istwert 2 x ${SEP} 
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Unterschiedliche Block-Anzahl. Die ersten zwei Blöcke sind gleich.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_MV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "AllMethods_MultipleValues", "1. Value${SEP}2. Value" );
  }

  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Sollwert 3 x ${SEP}, Istwert 2 x ${SEP} 
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Unterschiedliche Block-Anzahl. Die ersten drei Blöcke sind gleich.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltip_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltip( "AllMethods_MultipleValues", "1. Value${SEP}2. Value${SEP}3. Value${SEP}4. Value" );
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
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_M01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "All_MethodsObj", "Tha one and only Value" );
//  EN.VerifyTooltipWCM( "All_MethodsObj", "Tha one and only Value" );
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
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "All_MethodsObj","Tha one and only Value" );
  }

  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : nichtvorhanden
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_SV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "All_MethodsObj","The oneX and only Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Sollwert hat einen ${SEP}, Istwert keinen ${SEP}
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Wert Nach ${SEP} Fehlt.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_SV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "All_MethodsObj", "The one and only Value${SEP}The one and only Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_MV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "AllMethods_MultipleValues", "?. Value${SEP}X. Value${SEP}?. Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_MV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "AllMethods_MultipleValues", "?. XValue${SEP}?. X Value${SEP}?. XValue" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "AllMethods_MultipleValues", "?. Value${SEP}?. Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipWCM_OKWVerifyingFailsException_MV04() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipWCM( "AllMethods_MultipleValues", "?. Value${SEP}?. Value${SEP}?. Value${SEP}?. Value" );
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
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "All_MethodsObj", "Tha one and only Value" );
  }

  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : nichtvorhanden
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_SV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "All_MethodsObj", "The oneX and only Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Sollwert hat einen ${SEP}, Istwert keinen ${SEP}
   *  2. Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  3. Abweichung: Wert Nach ${SEP} Fehlt.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_SV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "All_MethodsObj", "The one and only Value${SEP}The one and only Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_MV01() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}X. Value${SEP}.\\. Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_MV02() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "AllMethods_MultipleValues", ".\\. XValue${SEP}.\\. X Value${SEP}.\\. XValue" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}.\\. Value" );
  }
  
  /**
   * \~german
   *  \brief Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  1. Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  2. Anzahl der Zeichen : Soll/Ist gleich
   *  3. Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyTooltipREGX_OKWVerifyingFailsException_MV04() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyTooltipREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}.\\. Value${SEP}.\\. Value${SEP}.\\. Value" );
  }
}
