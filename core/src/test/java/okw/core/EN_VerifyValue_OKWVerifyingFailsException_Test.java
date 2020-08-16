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

package okw.core;

import okw.OKWTestBase;
import okw.OKW_TestClipboard;
import okw.exceptions.OKWVerifyingFailsException;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreTests")
public class EN_VerifyValue_OKWVerifyingFailsException_Test extends OKWTestBase
{

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();


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
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValue( "All_MethodsObj", "Tha one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  
   *  -# Trenner ${SEP} : nichtvorhanden.
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich.
   *  -# Abweichung: Ein zusätzliches Zeichen im Sollwert.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_SV02() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValue( "All_MethodsObj", "The one andX only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
 
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  
   *  -# Trenner ${SEP} : nichtvorhanden.
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich.
   *  -# Abweichung: Ein Zeichen zu wenig im Sollwert.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_SV03() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetValue(    "All_MethodsObj", "The one and only Value" );
    EN.VerifyValue( "All_MethodsObj", "The one an only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  
   *  -# Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: Ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_MV01() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetValue(               "All_MethodsObj", "1. Value${SEP}2. Value${SEP}3. Value" );
    EN.VerifyValue( "AllMethods_MultipleValues", "1. Value${SEP}X. Value${SEP}3. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }


  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Sollwert 1 x ${SEP}, Istwert 2 x ${SEP} 
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Im Sollwert ein Block weniger. Die ersten zwei Blöcke sind gleich.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_MV02() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue(               "All_MethodsObj", "1. Value${SEP}2. Value${SEP}3. Value" );
    EN.VerifyValue( "AllMethods_MultipleValues", "1. Value${SEP}2. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Sollwert 3 x ${SEP}, Istwert 2 x ${SEP} 
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Unterschiedliche Block-Anzahl. Die ersten drei Blöcke sind gleich.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValue_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValue( "AllMethods_MultipleValues", "1. Value${SEP}2. Value${SEP}3. Value${SEP}4. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_M01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetValue(       "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueWCM( "All_MethodsObj", "Tha one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: Ein zusätzliches Zeichen im Soll.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetValue(       "All_MethodsObj", "The one andX only Value" );
    EN.VerifyValueWCM( "All_MethodsObj","The one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_SV02() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueWCM( "All_MethodsObj","The oneX and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Sollwert hat einen ${SEP}, Istwert keinen ${SEP}
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Wert Nach ${SEP} Fehlt.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_SV03() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueWCM( "All_MethodsObj", "The one and only Value${SEP}The one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_MV01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueWCM( "AllMethods_MultipleValues", "?. Value${SEP}X. Value${SEP}?. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_MV02() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueWCM( "AllMethods_MultipleValues", "?. XValue${SEP}?. X Value${SEP}?. XValue" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueWCM( "AllMethods_MultipleValues", "?. Value${SEP}?. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueWCM_OKWVerifyingFailsException_MV04() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueWCM( "AllMethods_MultipleValues", "?. Value${SEP}?. Value${SEP}?. Value${SEP}?. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_SV01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueREGX( "All_MethodsObj", "Tha one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : nichtvorhanden
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Ein Zeichen ist anders.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_SV02() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueREGX( "All_MethodsObj", "The oneX and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Sollwert hat einen ${SEP}, Istwert keinen ${SEP}
   *  -# Anzahl der Zeichen : Soll/Ist unterschiedlich
   *  -# Abweichung: Wert Nach ${SEP} Fehlt.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_SV03() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.SetValue( "All_MethodsObj", "The one and only Value" );
    EN.VerifyValueREGX( "All_MethodsObj", "The one and only Value${SEP}The one and only Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_MV01() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}X. Value${SEP}.\\. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_MV02() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueREGX( "AllMethods_MultipleValues", ".\\. XValue${SEP}.\\. X Value${SEP}.\\. XValue" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_MV03() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}.\\. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  /**
   * \~german
   *  Prüft, ob die Ausnahme OKWVerifyingFailsException bei einem Soll/Ist-Vergleich ausgelöst wird.
   *  
   *  Bedingung:
   *  -# Trenner ${SEP} : Soll-Wert ein ${SEP} Vorhanden / Ist-Wert zwei ${SEP} Vorhanden
   *  -# Anzahl der Zeichen : Soll/Ist gleich
   *  -# Abweichung: ein Wert im zweiten Block verschieden.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyValueREGX_OKWVerifyingFailsException_MV04() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValueREGX( "AllMethods_MultipleValues", ".\\. Value${SEP}.\\. Value${SEP}.\\. Value${SEP}.\\. Value" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

	/**
	 * \~german \brief Test auf das fehlerwerfen von VerifyBadge.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyBadge_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyBadge("All_MethodsObj", "The one an only Value");
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}

	/**
	 * \~german \brief Test auf das fehlerwerfen von VerifyBadge.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyBadgeWCM_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyBadgeWCM("All_MethodsObj", "The one an only Value");
	      
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}

	/**
	 * \~german \brief Test auf das fehlerwerfen von VerifyBadge.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyBadgeREGX_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyBadgeREGX("All_MethodsObj", "The one an only Value");
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}
  
	/**
	 * \~german \brief Test auf das fehlerwerfen von VerifyErrorMSG.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyErrorMSG_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyErrorMSG("All_MethodsObj", "The one an only Value");
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}
	/**
	 * \~german \brief Test auf das fehlerwerfen von VerifyErrorMSG_WCM.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyErrorMSG_WCM_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyErrorMSG_WCM("All_MethodsObj", "The one an only Value");
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}
	/**
	 * \~german 
	 * Test auf Ausnahmeauslösen: VerifyErrorMSG_REGX.
	 * 
	 * Bedingung: 1. Value unterscheidet sich von der Vorgabe
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.04.04
	 */
	@Test // ( expected = OKWVerifyingFailsException.class)
	public void TC_VerifyErrorMSG_REGX_OKWVerifyingFailsException_SV01() throws Exception {
		EN.BeginTest(TestName);

		EN.SelectWindow("Rechner");
		
	    EN.SetValue( "All_MethodsObj", "The one and only Value" );
		EN.VerifyErrorMSG_REGX("All_MethodsObj", "The one an only Value");
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
	}
}
