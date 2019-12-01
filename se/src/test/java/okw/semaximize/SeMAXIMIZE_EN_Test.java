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

package okw.semaximize;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* \~german
* Basisklasse für die MAXIMIZE Testfälle zur Ableitung von Browser-Testfällen
* 
*  - Firefox: okw.SeMAXIMIZE.SeMAXIMIZE_Firefox_Test
*  - Chrome: okw.SeMAXIMIZE.SeMAXIMIZE_Chrome_Test
*  - HTMLUnit: okw.SeMAXIMIZE.SeMAXIMIZE_HTMLUnit_Test
* 
*  @author Zoltan Hrabovszki
*  @date 2017-07-23
*/
@Ignore
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class SeMAXIMIZE_EN_Test {

  protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  
  /**
   * \~german
   * Testet das Schlüsselwort LogExists( FN ) eines SeMAXIMIZE Prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcLogExists() throws Exception {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.LogExists( "MAXIMIZE" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /**
   * \~german
   * Testet die Implementierung des Schlüsselworte ClickOn( FN ) in der Klasse SeMAXSIZE .
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  //@Test
  public void tcClickOn() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.ClickOn( "MAXIMIZE" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * \~german
   * Testet das Schlüsselwort LogHasFocus( FN ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test( expected = OKWFrameObjectMethodNotImplemented.class )
  public void tcLogHasFocus_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.LogHasFocus( "MAXIMIZE" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   * \~german
   *  Teste das Schlüsselwort LogIsActive( FN ) eines SeMAXIMIZE prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcLogIsActive() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.LogIsActive( "MAXIMIZE" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   * \~german
   *  Teste das Schlüsselwort LogLabel( FN ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test( expected = OKWFrameObjectMethodNotImplemented.class )
  public void tcLogLabel_OKWFrameObjectMethodNotImplemented() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.LogLabel( "MAXIMIZE" );
    
    EN.StopApp( ApplicationName );
    EN.EndTest();

  }

  /**
   * \~german
   * Testet das Schlüsselwort SetValue( FN ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcSetValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.SetValue( "MAXIMIZE", "Hrabovszki" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }


  /**
   * \~german
   * Testet das Schlüsselwort TypeKey( FN, Val ) eines SeMAXIMIZE Prüfen.
   * 
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcTypeKey_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "MAXIMIZE", "Hrabovszki" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }

  
  /**
   * \~german
   * Testet das Schlüsselwort LogTooltip( FN, Val ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcLogToolTip_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.LogTooltip( "MAXIMIZE" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }

 
  /**
   * \~german
   * Testet das Schlüsselwort LogTooltip( FN, Val ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcLogValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.LogValue( "MAXIMIZE" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }

  /**
   * \~german
   * Testet das Schlüsselwort MemorizeExists( FN, Val ) eines SeMAXIMIZE Prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test
  public void tcMemorizeExists_OKWFrameObjectMethodNotImplemented() throws Exception
  {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.MemorizeExists( "MAXIMIZE", "SeTextField_MemorizeExists_1" );

      assertEquals( "YES", myMem.get("SeTextField_MemorizeExists_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeHasFocus( FN, MemKey ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcMemorizeHasFocus_OKWFrameObjectMethodNotImplemented() throws Exception {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.MemorizeHasFocus( "MAXIMIZE", "SeTextField_MemorizeHasFocus" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  } 

  
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeIsActive( FN, MemKey ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcMemorizeIsActive() throws Exception {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.MemorizeIsActive( "MAXIMIZE", "SeMAXIMIZE_MemorizeIsActive" );

      assertEquals( "YES", myMem.get( "SeMAXIMIZE_MemorizeIsActive" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeLabel( FN, MemKey ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
   @Test (expected = OKWFrameObjectMethodNotImplemented.class)
   public void tcMemorizeLabel_OKWFrameObjectMethodNotImplemented() throws Exception
   {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.MemorizeLabel( "MAXIMIZE", "SeTextField_MemorizeLabel_1" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

   }

   
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeTooltip( FN, MemKey ) eines SeMAXIMIZE Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
   @Test (expected = OKWFrameObjectMethodNotImplemented.class)
   public void tcMemorizeToolTip_OKWFrameObjectMethodNotImplemented() throws Exception
   {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.MemorizeTooltip( "MAXIMIZE", "SeTextField_MemorizeTooltip" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }


  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeValue( FN, MemKey ) eines SeMAXIMIZE.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcMemorizeValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.MemorizeValue( "MAXIMIZE", "SeTextField_LogValue_2" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyCaption( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaption_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyCaption( "MAXIMIZE", "Abc" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   *  \~german
   *  Test des Schlüsselwortes "VerifyCaptionWCM( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaptionWCM_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyCaptionWCM( "MAXIMIZE", "${EMPTY}" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyCaptionREGX( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaptionREGX_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyCaptionREGX( "MAXIMIZE", "${EMPTY}" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();

  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyExists( FN, ExpVal ) für SeMAXIMIZE.
   * 
   *  Hier wird geprüft ob eine Soll/Ist-Abweichung die Ausnahme OKWVerifyingFailsException auslöst.
   *  
   *  @par Hinweis: MAXIMIZE existiert immer
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException()  throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      
      EN.VerifyExists( "MAXIMIZE", "NO" );
      
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * \~german
   * Prüft ob das MAXIMIZE existiert.
   * Erwartet wird, dass das Objekt existiert.
   * 
   * @par Hinweis: MAXIMIZE existiert immer
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */
  @Test
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyExists( "MAXIMIZE", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyHasFocus( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected= OKWFrameObjectMethodNotImplemented.class)
  public void tcVerifyHasFocus() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyHasFocus( "MAXIMIZE", "NO" );
      
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  

  /**
   * \~german
   *  Prüft, ob die Methode VerifyIsActive für MAXIMIZE implementiert ist.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-30
  */
  @Test
  public void tcVerifyIsActive() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyIsActive( "MAXIMIZE", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyLabel( FN, ExpVal ) für SeMAXIMIZE.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabel() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyLabel( "MAXIMIZE", "Name:" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyLabelWCM( FN, ExpVal ) für SeMAXIMIZE.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabelWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyLabelWCM( "MAXIMIZE", "Name?" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   *  \~german
   *  Test des Schlüsselwortes "VerifyLabelREGX( FN, ExpVal ) für SeMAXIMIZE.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabelREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyLabelREGX( "MAXIMIZE", "Name\\W" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltip( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltip() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyTooltip( "MAXIMIZE", "Den Namen eingeben" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltipWCM( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltipWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.VerifyTooltipWCM( "MAXIMIZE", "??? Namen eingeben" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
 }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltipREGX( FN, ExpVal ) für SeMAXIMIZE.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltipREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.VerifyTooltipREGX( "MAXIMIZE", "\\wen Namen eingeben" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyValue( "MAXIMIZE", "Zoltan" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
}
  
  
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyValueWCM( FN, ExpValu ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValueWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyValueWCM( "MAXIMIZE", "Abc" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
   
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyValueREGX( FN, ExpValu ) für SeMAXIMIZE.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test(expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValueREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.VerifyValueREGX( "MAXIMIZE", ".oltan" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
}
