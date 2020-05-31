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

package okw.seback;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.core.OKWTestBase;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
public class SeBACK_EN_Test extends OKWTestBase{

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
  public void tcClickOn() throws Exception
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

  
  /**
   * \~german
   * Testet das Schlüsselwort LogExists( FN ) eines SeBACK Prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 

  @Test
  public void tcLogExists() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.LogExists( "BACK" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }


/**
   * \~german
   * Testet das Schlüsselwort LogHasFocus( FN ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // ( expected = OKWFrameObjectMethodNotImplemented.class )
  public void tcLogHasFocus_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.LogHasFocus( "BACK" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  /** 
   * \~german
   *  Teste das Schlüsselwort LogIsActive( FN ) eines SeBACK prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcLogIsActive() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.LogIsActive( "BACK" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * \~german
   * Testet das Schlüsselwort LogTooltip( FN, Val ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test //(expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcLogToolTip_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.LogTooltip( "BACK" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


/** 
   * \~german
   *  Teste das Schlüsselwort LogLabel( FN ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // ( expected = OKWFrameObjectMethodNotImplemented.class )
  public void tcLogLabel_OKWFrameObjectMethodNotImplemented() throws Exception
  {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );

    EN.LogLabel( "BACK" );
    
    Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
    {
        EN.EndTest();
    });
  }

  /**
   * \~german
   * Testet das Schlüsselwort LogTooltip( FN, Val ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcLogValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {

      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.LogValue( "BACK" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


/**
   * \~german
   * Testet das Schlüsselwort SetValue( FN ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcSetValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.SetValue( "BACK", "Hrabovszki" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   * Testet das Schlüsselwort TypeKey( FN, Val ) eines SeBACK Prüfen.
   * 
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcTypeKey_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "BACK", "Hrabovszki" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  
  /**
   * \~german
   * Testet das Schlüsselwort MemorizeExists( FN, Val ) eines SeBACK Prüfen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
 @Test
  public void tcMemorizeExists_OKWFrameObjectMethodNotImplemented() throws Exception
  {

      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.MemorizeExists( "BACK", "SeBACK_MemorizeExists_1" );

      assertEquals( "YES", myMem.get("SeBACK_MemorizeExists_1" ) );

      EN.StopApp( ApplicationName );
      
      EN.EndTest();
  }

  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeHasFocus( FN, MemKey ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
  public void tcMemorizeHasFocus_OKWFrameObjectMethodNotImplemented() throws Exception {

      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.MemorizeHasFocus( "BACK", "SeBACK_MemorizeHasFocus" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeIsActive( FN, MemKey ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test
  public void tcMemorizeIsActive() throws Exception {

      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.MemorizeIsActive( "BACK", "SeBACK_MemorizeIsActive" );

      assertEquals( "YES", myMem.get( "SeBACK_MemorizeIsActive" ) );

      EN.StopApp( ApplicationName );
      
      EN.EndTest();
  }

  
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeLabel( FN, MemKey ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
   @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
   public void tcMemorizeLabel_OKWFrameObjectMethodNotImplemented() throws Exception
   {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.MemorizeLabel( "BACK", "SeBACK_MemorizeLabel_1" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
   }

   
  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeTooltip( FN, MemKey ) eines SeBACK Prüfen.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
   @Test // (expected = OKWFrameObjectMethodNotImplemented.class)
   public void tcMemorizeToolTip_OKWFrameObjectMethodNotImplemented() throws Exception
   {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      EN.MemorizeTooltip( "BACK", "SeBACK_MemorizeTooltip" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /** 
   * \~german
   *  Teste das Schlüsselwort MemorizeValue( FN, MemKey ) eines SeBACK.
   * 
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcMemorizeValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.MemorizeValue( "BACK", "SeBACK_LogValue_2" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyCaption( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaption_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyCaption( "BACK", "Abc" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  /**
   *  \~german
   *  Test des Schlüsselwortes "VerifyCaptionWCM( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaptionWCM_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyCaptionWCM( "BACK", "${EMPTY}" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyCaptionREGX( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyCaptionREGX_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyCaptionREGX( "BACK", "${EMPTY}" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyExists( FN, ExpVal ) für SeBACK.
   * 
   *  Hier wird geprüft ob eine Soll/Ist-Abweichung die Ausnahme OKWVerifyingFailsException auslöst.
   *  
   *  @par Hinweis: BACK existiert immer
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException()  throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
      
      EN.VerifyExists( "BACK", "NO" );
      
      Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
      {
          EN.EndTest();
      });
  }

  /**
   * \~german
   * Prüft ob das BACK existiert.
   * Erwartet wird, dass das Objekt existiert.
   * 
   * @par Hinweis: BACK existiert immer
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */
  @Test
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyExists( "BACK", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyHasFocus( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected= OKWFrameObjectMethodNotImplemented.class)
  public void tcVerifyHasFocus() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyHasFocus( "BACK", "NO" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }
  

  /**
   * \~german
   *  Prüft, ob die Methode VerifyIsActive für BACK implementiert ist.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-30
  */
  @Test
  public void tcVerifyIsActive() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyIsActive( "BACK", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyLabel( FN, ExpVal ) für SeBACK.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabel_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyLabel( "BACK", "Name:" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  
  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyLabelWCM( FN, ExpVal ) für SeBACK.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabelWCM_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyLabelWCM( "BACK", "Name?" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }

  
  /**
   *  \~german
   *  Test des Schlüsselwortes "VerifyLabelREGX( FN, ExpVal ) für SeBACK.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyLabelREGX_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyLabelREGX( "BACK", "Name\\W" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltip( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltip_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyTooltip( "BACK", "Den Namen eingeben" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltipWCM( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltipWCM_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
  
      EN.VerifyTooltipWCM( "BACK", "??? Namen eingeben" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyTooltipREGX( FN, ExpVal ) für SeBACK.
   *  
   * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyTooltipREGX_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );
  
      EN.VerifyTooltipREGX( "BACK", "\\wen Namen eingeben" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  /**
   * \~german
   *  Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValue_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyValue( "BACK", "Zoltan" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }
  
  
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyValueWCM( FN, ExpValu ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyValueWCM( "BACK", "Abc" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
   }
  
   
  /**
   * \~german
   * Test des Schlüsselwortes "VerifyValueREGX( FN, ExpValu ) für SeBACK.
   *  
   *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2017-07-23
   */ 
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class )
  public void tcVerifyValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
  {
      EN.BeginTest( TestName );
      EN.StartApp( ApplicationName );

      EN.VerifyValueREGX( "BACK", ".oltan" );
      
      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }
}
