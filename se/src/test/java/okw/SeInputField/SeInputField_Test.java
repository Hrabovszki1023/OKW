/*
 ==============================================================================
 Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

package okw.SeInputField;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.TestName;

@Ignore
public class SeInputField_Test {

  OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  
  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tcLogExists() throws Exception {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

    EN.SelectWindow( "SeTextField" );
    EN.LogExists( "Name" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /**
   * Testet das Schlüsselwort ClickOn( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tcClickOn() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.ClickOn( "Name" );
      EN.VerifyHasFocus( "Name", "YES" );
      EN.VerifyHasFocus( "Vorname", "NO" );

      EN.ClickOn( "Vorname" );
      EN.VerifyHasFocus( "Name", "NO" );
      EN.VerifyHasFocus( "Vorname", "YES" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   * Testet das Schlüsselwort LogHasFocus( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tcLogHasFocus() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
      EN.LogHasFocus( "Name" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort LogIsActive( FN ) eines SeInputText Prüfen.
   */
  @Test
  public void tcLogIsActive() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
      EN.LogIsActive( "Name" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort LogLabel( FN ) eines SeInputText Prüfen.
   */
  @Test
  public void tcLogLabel() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

    EN.SelectWindow( "SeTextField" );
    EN.LogLabel( "Name" );
    
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort LogTooltip( FN ) eines SeInputText Prüfen.
   */
  @Test
  public void tcLogToolTip() throws Exception
  {
  
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogTooltip( "Name" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort LogValue( FN ) eines SeInputText Prüfen.
   */
  @Test
  public void tcLogValue() throws Exception
  {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogValue( "Name" );

      EN.TypeKey( "Name", "Zoltan" );
      EN.LogValue( "Name" );
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort MemorizeExists( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void TC_MemorizeExists_en() throws Exception
  {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeExists( "Name", "SeTextField_MemorizeExists_1" );

      assertEquals( "YES", OKW_Memorize_Sngltn.getInstance().Get("SeTextField_MemorizeExists_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort MemorizeHasFocus( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void tcMemorizeHasFocus() throws Exception {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeHasFocus( "Name", "SeTextField_MemorizeHasFocus" );

      assertEquals( "NO", myMem.Get( "SeTextField_MemorizeHasFocus" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** 
   *  Teste das Schlüsselwort MemorizeIsActive( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void tcMemorizeIsActive_en() throws Exception {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeIsActive( "Name", "SeTextField_MemorizeIsActive" );

      assertEquals( "YES", myMem.Get( "SeTextField_MemorizeIsActive" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** 
   *  Teste das Schlüsselwort MemorizeLabel( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void tcMemorizeLabel() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      // /
      EN.MemorizeLabel( "Name", "SeTextField_MemorizeLabel_1" );
      EN.MemorizeLabel( "Vorname", "SeTextField_MemorizeLabel_2" );

      assertEquals( "Name:", myMem.Get( "SeTextField_MemorizeLabel_1" ) );
      assertEquals( "Vorname:", myMem.Get( "SeTextField_MemorizeLabel_2" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort MemorizeTooltip( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void tcMemorizeToolTip() throws Exception {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeTooltip( "Name", "SeTextField_MemorizeTooltip" );

      assertEquals( "Den Namen eingeben", myMem.Get( "SeTextField_MemorizeTooltip" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  /** 
   *  Teste das Schlüsselwort MemorizeValue( FN, MemKey ) eines SeInputText Prüfen.
   */
  @Test
  public void tcMemorizeValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      // // test.openkeyword.de/select.htm
      // // EN.TypeKey("URL", "http://test.openkeyword.de/eingabe.htm");
      EN.MemorizeValue( "Name", "SeTextField_LogValue_1" );
      EN.TypeKey( "Name", "Zoltan" );
      EN.MemorizeValue( "Name", "SeTextField_LogValue_2" );

      assertEquals( "", myMem.Get( "SeTextField_LogValue_1" ) );
      assertEquals( "Zoltan", myMem.Get( "SeTextField_LogValue_2" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \brief
  // Teste das Schlüsselwort SetFocus( FN ) eines SeInputText Prüfen.
  // 
  @Test
  public void tcSetFocus_ReadableAndEnabled() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.SetFocus( "Name" );
      EN.VerifyHasFocus( "Name", "YES" );
      EN.VerifyHasFocus( "Vorname", "NO" );

      EN.SetFocus( "Vorname" );
      EN.VerifyHasFocus( "Name", "NO" );
      EN.VerifyHasFocus( "Vorname", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Teste das Schlüsselwort SetFocus( FN ) eines readonly aber nicht disabled SeInputText prüfen.
  //
  // Attribut Einstellung hier:
  // * readonly ist eingeschatet
  // * disable ist abgeschaltet
  //
  @Test
  public void tcSetFocus_ReadonlyAndEnabled() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/inputText/input_type-text_readonly.htm" );

      EN.SelectWindow( "SeInputTextReadonly" );

      EN.SetFocus( "Preis" );
      EN.VerifyHasFocus( "Preis", "YES" );
      EN.VerifyHasFocus( "MwSt", "NO" );

      EN.SetFocus( "MwSt" );
      EN.VerifyHasFocus( "Preis", "NO" );
      EN.VerifyHasFocus( "MwSt", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Testet das Schlüsselwort SetValue( FN ) eines SeInputText-es.
  //
  @Test
  public void tcSetValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyValue( "Name", "" );

      EN.SetValue( "Name", "Hrabovszki" );
      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.SetValue( "Vorname", "Zoltan" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      // Neuen Wert Setzen, der alte Wert wird überschrieben
      EN.SetValue( "Name", "Becker" );
      EN.VerifyValue( "Name", "Becker" );
      EN.SetValue( "Vorname", "Manu" );
      EN.VerifyValue( "Vorname", "Manu" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Testet das Schlüsselwort SetValue( FN ) mit ${IGNORE} eines SeInputText-es.
  //
  @Test
  public void tcSetValue_IGNORE() throws Exception
  { 
     EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyValue( "Name", "" );

      EN.SetValue( "Name", "Hrabovszki" );
      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.SetValue( "Vorname", "Zoltan" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      // Neuen Wert Setzen, der alte Wert wird überschrieben
      EN.SetValue( "Name", "${IGNORE}" );
      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.SetValue( "Vorname", "${IGNORE}" );
      EN.VerifyValue( "Vorname", "Zoltan" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Testet das Schlüsselwort TypeKey( FN ) eines SeInputText-es.
  //
  @Test
  public void tcTypeKey() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyValue( "Name", "" );
      EN.VerifyValue( "Vorname", "" );

      EN.TypeKey( "Name", "Hrabovszki" );
      EN.VerifyValue( "Name", "Hrabovszki" );

      EN.TypeKey( "Vorname", "Zoltan" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   *  Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeInputText.
   *
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2014.12.03
   */
  @Test
  public void tcVerifyCaption() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      // First off all teh Name-Field is Empty
      EN.VerifyCaption( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyCaption( "Name", "Zoltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \brief
  // Testet das Schlüsselwort TypeKey( FN ) mit ${IGNORE} eines SeInputText-es.
  //
  @Test
  public void tcTypeKey_IGNORE() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );

      EN.VerifyValue( "Name", "" );
      EN.VerifyValue( "Vorname", "" );

      EN.TypeKey( "Name", "Hrabovszki" );
      EN.TypeKey( "Vorname", "Zoltan" );

      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      EN.TypeKey( "Name", "${IGNORE}" );
      EN.TypeKey( "Vorname", "${IGNORE}" );

      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      EN.TypeKey( "Name", "" );
      EN.TypeKey( "Vorname", "" );

      EN.VerifyValue( "Name", "Hrabovszki" );
      EN.VerifyValue( "Vorname", "Zoltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Prüft ob ein tatsächlich _nicht_ vorhandenes Objekt _nicht_ existiert.
  // Erwartet wird das das objekt nicht existiert.
  //
  @Test
  public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "NotExists", "NO" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Prüft ob ein nicht vorhandenes objekt existiert.
  // Erwartet wird, dass das Objekt existiert.
  // Es wird geprüft auf das default timout exception getriggert wird.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
  
      EN.SelectWindow( "SeTextField" );
  
      EN.VerifyExists( "NotExists", "YES" );
  }

  // \brief
  // Prüft ob ein vorhandenes Objekt nicht existiert.
  // Hier wird wird geprüft auf das default timout exception getriggert wird.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException()  throws Exception
  {

      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "Name", "NO" );
  }

  // / \brief
  // / Prüft ob ein vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // /
  @Test
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "Name", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brife
  // Prüft, ob die OKW-Konstante ${IGNORE} implementiert ist.
  //
  // Nicht existierendes Object wird als GUI-Objekt Referenziert.
  // Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
  // nicht ausgeführt wird.
  // D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
  // worden.
  //
  @Test
  public void tcVerifyExists_IGNORE() throws Exception
  {
      EN.BeginTest( name.getMethodName() );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "NichtVorhanden", "${IGNORE}" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test
  public void tcVerifyHasFocus() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "NO" );
      EN.SetFocus( "Name" );
      EN.VerifyHasFocus( "Name", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyHasFocus_HasFocusYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "NO" );
      EN.SetFocus( "Name" );
      EN.VerifyHasFocus( "Name", "NO" );
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyHasFocus_HasFocusNoExpectedYes_OKWVerifyingFailsException() throws Exception {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "YES" );
  }

  
  // \~german
  // \brief
  // Prüft, ob die OKW-Konstante ${IGNORE} für SeTextField implementiert ist.
  //
  // Nicht existierendes Object wird als GUI-Objekt Referenziert.
  // Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
  // nicht ausgeführt wird.
  // D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
  // worden.
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyHasFocus_IGNORE() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "NichtVorhanden", "${IGNORE}" );
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyIsActive für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyIsActive() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL","http://test.openkeyword.de/InputText/input_type-text_disabled.htm" );
      EN.SelectWindow( "SeInputTextDisabled" );

      EN.VerifyIsActive( "Preis", "NO" );
      EN.VerifyIsActive( "MwSt", "NO" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyIsActive( "Name", "YES" );
      EN.VerifyIsActive( "Vorname", "YES" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL",
          "http://test.openkeyword.de/InputText/input_type-text_readonly.htm" );
      EN.SelectWindow( "SeInputTextReadonly" );

      EN.VerifyIsActive( "Preis", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabel() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabel( "Name", "Name:" );
      EN.VerifyLabel( "Vorname", "Vorname:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabel( "Name", "Xxxx:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabelWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelWCM( "Name", "Name?" );
      EN.VerifyLabelWCM( "Vorname", "Vorname?" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelWCM_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelWCM( "Name", "####:" );
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabelREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelREGX( "Name", "Name\\W" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelREGX_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelREGX( "Name", "Xxxx:" );
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltip() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyTooltip( "Name", "Den Namen eingeben" );

      EN.StopApp( ApplicationName );
      EN.EndTest();

  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltip bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyTooltip_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
      

      EN.VerifyTooltip( "Name", "Den Namen..." );

  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltipWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.VerifyTooltipWCM( "Name", "??? Namen eingeben" );
  
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyTooltipWCM_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyTooltipWCM( "Name", "#oltan" );
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltipREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_inputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.VerifyTooltipREGX( "Name", "\\wen Namen eingeben" );
  
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyTooltipREGX_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyTooltipREGX( "Name", "#oltan" );
  }
  
  
  // \~german
  // \brief
  // Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeInputText.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValue() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Zoltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyValue die OKW-Konstanten ${DELETE} und ${EMPTY} für
  // SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValue_DELETE_EMPTY() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Zoltan" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValue( "Name", "${EMPTY}" );
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValue_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Soltan" );

  }


  /** \~german
   * Test des Schlüsselwortes "VerifyValueWCM( FN, ExpValu ) für SeInputText.
   *
   * \~
   * @author Zoltan Hrabovszki
   * @date 2014.12.03
   */
  @Test
  public void tcVerifyValueWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "??????" );
      EN.VerifyValueWCM( "Name", "Z????n" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
      
  }
  
  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyValue die OKW-Konstanten ${DELETE} und ${EMPTY} für
  // SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValueWCM_DELETE_EMPTY() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "??????" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValueWCM( "Name", "${EMPTY}" );
  
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueWCM_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValueWCM( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "#oltan" );
  }

  
  // \~german
  // \brief
  // Test des Schlüsselwortes "VerifyValueREGX( FN, ExpValu ) für SeInputText.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValueREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", ".oltan" );
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  
  // \~german
  // \brief
  // Testet VerifyValueREGX auf die OKW-Konstanten ${DELETE} und ${EMPTY} für
  // SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValueREGX_DELETE_EMPTY() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", "\\woltan" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValueREGX( "Name", "${EMPTY}" );
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueREGX_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", "Soltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcClickOn_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.ClickOn( "NotExists");
  }

  /**
   * 
   * @throws Exception
   */
  @Test( expected = OKWFrameObjectMethodNotImplemented.class )
  public void tcSelect_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.Select( "NotExists", "abc");
  }

  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcTypeKey_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.TypeKey( "NotExists", "abc");
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcSetValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.SetValue( "NotExists", "abc");
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcSetFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.SetFocus( "NotExists");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeCaption( "NotExists", "MemorizeCaption");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeHasFocus( "NotExists", "MemorizeHasFocus");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeIsActive( "NotExists", "MemorizeIsActive");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeLabel( "NotExists", "MemorizeLabel");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeTooltip( "NotExists", "MemorizeTooltip");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.MemorizeValue( "NotExists", "MemorizeVale");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogCaption( "NotExists");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogHasFocus( "NotExists");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogIsActive( "NotExists");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogLabel( "NotExists");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogTooltip( "NotExists");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.LogValue( "NotExists");
  }
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyCaption( "NotExists", "aa");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyHasFocus( "NotExists", "YES");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyIsActive( "NotExists", "YES" );
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyLabel( "NotExists", "aa" );
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyTooltip( "NotExists", "aa");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
          EN.SelectWindow( "SeTextField" );

          EN.VerifyValue( "NotExists", "aa");
  }

}
