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

package okw.seinputfield;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.TestName;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Ignore
public class SeInputField_EN_Test {

  protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  /**
   * SeTextField -> InputTypeText
   * InputTypeText.htm -> InputTypeText.htm
   * Vorame -> First Name
   * Name -> Last Name
   */
  
  
  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tcLogExists() throws Exception {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

    EN.SelectWindow( "InputTypeText" );
    EN.LogExists( "Last Name" );
  
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.ClickOn( "Last Name" );
      EN.VerifyHasFocus( "Last Name", "YES" );
      EN.VerifyHasFocus( "First Name", "NO" );

      EN.ClickOn( "First Name" );
      EN.VerifyHasFocus( "Last Name", "NO" );
      EN.VerifyHasFocus( "First Name", "YES" );
      
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
      EN.LogHasFocus( "Last Name" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
      EN.LogIsActive( "Last Name" );

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
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

    EN.SelectWindow( "InputTypeText" );
    EN.LogLabel( "Last Name" );
    
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /** 
   *  Teste das Schlüsselwort LogPlaceholder( FN ) eines SeInputText Prüfen.
   */
  @Test
  public void tcLogPlaceholder() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

    EN.SelectWindow( "InputTypeText" );
    EN.LogPlaceholder( "Last Name" );
    
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.LogTooltip( "Last Name" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.LogValue( "Last Name" );

      EN.TypeKey( "Last Name", "Zoltan" );
      EN.LogValue( "Last Name" );
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.MemorizeExists( "Last Name", "InputTypeText_MemorizeExists_1" );

      assertEquals( "YES", OKW_Memorize_Sngltn.getInstance().get("InputTypeText_MemorizeExists_1" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.MemorizeHasFocus( "Last Name", "InputTypeText_MemorizeHasFocus" );

      assertEquals( "NO", myMem.get( "InputTypeText_MemorizeHasFocus" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.MemorizeIsActive( "Last Name", "InputTypeText_MemorizeIsActive" );

      assertEquals( "YES", myMem.get( "InputTypeText_MemorizeIsActive" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      // /
      EN.MemorizeLabel( "Last Name", "InputTypeText_MemorizeLabel_1" );
      EN.MemorizeLabel( "First Name", "InputTypeText_MemorizeLabel_2" );

      assertEquals( "Last Name:", myMem.get( "InputTypeText_MemorizeLabel_1" ) );
      assertEquals( "First Name:", myMem.get( "InputTypeText_MemorizeLabel_2" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** 
   *  Testet ob das Schlüsselwort MemorizePlaceholder( FN, MemKey ) der Klasse SeInputText implementiert ist.
   */
  @Test
  public void tcMemorizePlaceholder() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      // /
      EN.MemorizePlaceholder( "Last Name", "InputTypeText_MemorizeLabel_1" );
      EN.MemorizePlaceholder( "First Name", "InputTypeText_MemorizeLabel_2" );

      assertEquals( "Placeholder: Last Name", myMem.get( "InputTypeText_MemorizeLabel_1" ) );
      assertEquals( "Placeholder: First Name", myMem.get( "InputTypeText_MemorizeLabel_2" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.MemorizeTooltip( "Last Name", "InputTypeText_MemorizeTooltip" );

      assertEquals( "Title: Last Name", myMem.get( "InputTypeText_MemorizeTooltip" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      // // test.openkeyword.de/select.htm
      // // EN.TypeKey("URL", "http://test.openkeyword.de/eingabe.htm");
      EN.MemorizeValue( "Last Name", "InputTypeText_LogValue_1" );
      EN.SetValue( "Last Name", "Zoltan" );
      EN.MemorizeValue( "Last Name", "InputTypeText_LogValue_2" );

      assertEquals( "Jackson", myMem.get( "InputTypeText_LogValue_1" ) );
      assertEquals( "Zoltan", myMem.get( "InputTypeText_LogValue_2" ) );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.SetFocus( "Last Name" );
      EN.VerifyHasFocus( "Last Name", "YES" );
      EN.VerifyHasFocus( "First Name", "NO" );

      EN.SetFocus( "First Name" );
      EN.VerifyHasFocus( "Last Name", "NO" );
      EN.VerifyHasFocus( "First Name", "YES" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.VerifyValue( "Last Name", "" );

      EN.SetValue( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.SetValue( "First Name", "Zoltan" );
      EN.VerifyValue( "First Name", "Zoltan" );

      // Neuen Wert Setzen, der alte Wert wird überschrieben
      EN.SetValue( "Last Name", "Becker" );
      EN.VerifyValue( "Last Name", "Becker" );
      EN.SetValue( "First Name", "Manu" );
      EN.VerifyValue( "First Name", "Manu" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.VerifyValue( "Last Name", "" );

      EN.SetValue( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.SetValue( "First Name", "Zoltan" );
      EN.VerifyValue( "First Name", "Zoltan" );

      // Neuen Wert Setzen, der alte Wert wird überschrieben
      EN.SetValue( "Last Name", "${IGNORE}" );
      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.SetValue( "First Name", "${IGNORE}" );
      EN.VerifyValue( "First Name", "Zoltan" );
      
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      
      EN.SetValue( "Last Name", "${DELETE}" );
      EN.SetValue( "First Name", "${DELETE}" );
      
      EN.VerifyValue( "Last Name", "${EMPTY}" );
      EN.VerifyValue( "First Name", "${EMPTY}" );

      EN.TypeKey( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "Last Name", "Hrabovszki" );

      EN.TypeKey( "First Name", "Zoltan" );
      EN.VerifyValue( "First Name", "Zoltan" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // Make the field empty
      EN.SetValue( "Last Name", "${DELETE}" );
      
      // First off all teh Name-Field is Empty
      EN.VerifyCaption( "Last Name", "${EMPTY}" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyCaption( "Last Name", "Zoltan" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      
      EN.SelectWindow( "InputTypeText" );
      
      EN.SetValue( "Last Name", "${DELETE}" );
      EN.SetValue( "First Name", "${DELETE}" );

      EN.VerifyValue( "Last Name", "" );
      EN.VerifyValue( "First Name", "" );

      EN.TypeKey( "Last Name", "Hrabovszki" );
      EN.TypeKey( "First Name", "Zoltan" );

      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "First Name", "Zoltan" );

      EN.TypeKey( "Last Name", "${IGNORE}" );
      EN.TypeKey( "First Name", "${IGNORE}" );

      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "First Name", "Zoltan" );

      EN.TypeKey( "Last Name", "" );
      EN.TypeKey( "First Name", "" );

      EN.VerifyValue( "Last Name", "Hrabovszki" );
      EN.VerifyValue( "First Name", "Zoltan" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.VerifyExists( "DoesNotExist", "NO" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
  
      EN.SelectWindow( "InputTypeText" );
  
      EN.VerifyExists( "DoesNotExist", "YES" );
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.VerifyExists( "Last Name", "NO" );
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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
      EN.VerifyExists( "Last Name", "YES" );

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
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );

      EN.SelectWindow( "InputTypeText" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyHasFocus( "Last Name", "NO" );
      EN.SetFocus( "Last Name" );
      EN.VerifyHasFocus( "Last Name", "YES" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyHasFocus( "Last Name", "NO" );
      EN.SetFocus( "Last Name" );
      EN.VerifyHasFocus( "Last Name", "NO" );
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyHasFocus_HasFocusNoExpectedYes_OKWVerifyingFailsException() throws Exception {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyHasFocus( "Last Name", "YES" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyHasFocus( "NichtVorhanden", "${IGNORE}" );
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /** \~german
   *  Prüft, ob die Methode VerifyIsActive für SeTextField implementiert ist.
   * 
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2014.12.03
   */
  @Test
  public void tcVerifyIsActive() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL","http://test.openkeyword.de/InputText/InputTypeTextDisabled.htm" );
      EN.SelectWindow( "InputTypeTextDisabled" );

      EN.VerifyIsActive( "Preis", "NO" );
      EN.VerifyIsActive( "MwSt", "NO" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyIsActive( "Last Name", "YES" );
      EN.VerifyIsActive( "First Name", "YES" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL",
          "http://test.openkeyword.de/InputText/input_type-text_readonly.htm" );
      EN.SelectWindow( "SeInputTextReadonly" );

      EN.VerifyIsActive( "Preis", "YES" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   *  Testet ob das Schlüsselwort VerifyLabel( FN, ExpVal ) der Klasse SeInputText implementiert ist.
   *
   * \~
   * \~english
   * Tests whether the keyword VerifyLabel( FN, ExpVal ) of the class SeInputText is implemented.
   * 
   * \author Zoltan Hrabovszki
   * \date 2014.12.03
   */
  @Test
  public void tcVerifyLabel() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabel( "Last Name", "Last Name:" );
      EN.VerifyLabel( "First Name", "First Name:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme OKWVerifyingFailsException für SeInputField auslöst.  //
   * \~
   * \author Zoltan Hrabovszki
   * \date 2014.12.03
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabel( "Last Name", "Xxxx:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyLabelWCM für SeInputField implementiert ist.
   *
   * \~
   * \author Zoltan Hrabovszki
   * \date 2014.12.03
   */
  @Test
  public void tcVerifyLabelWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabelWCM( "Last Name", "Last Name?" );
      EN.VerifyLabelWCM( "First Name", "First Name?" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabelWCM( "Last Name", "####:" );
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyMaxLength für SeInputField implementiert ist.
   *
   * \~english
   * Verifies whether the EN.VerifyMaxLength(String, String) method is implemented for okw.gui.adapter.SeInputField.
   * 
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.12.28
   */
  @Test
  public void tcVerifyMaxLength() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyMaxLength( "Last Name", "40" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyMaxLength bei einer Soll/Ist Abweichung die Ausnahme 
   * OKWVerifyingFailsException für SeInputField auslöst.
   * 
   * \~german
   * Checks whether the VerifyMaxLength() method throws the OKWVerifyingFailsException
   * exception for a SeInputField if there is a target/actual deviation.
   * 
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.12.28
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyMaxLength_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyMaxLength( "Last Name", "25" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabelREGX( "Last Name", "Last Name\\W" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabelREGX( "Last Name", "Xxxx:" );
  }

  
  /** \~german
   *  Testet ob das Schlüsselwort VerifyPlaceholder( FN, ExpVal ) der Klasse SeInputText implementiert ist.
   *
   * \~
   * \~english
   * Tests whether the keyword VerifyPlaceholder( FN, ExpVal ) of the class SeInputText is implemented.
   * 
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test
  public void tcVerifyPlaceholder() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyPlaceholder( "Last Name", "Placeholder: Last Name" );
      EN.VerifyPlaceholder( "First Name", "Placeholder: First Name" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyPlaceholder bei einer Soll/Ist Abweichung die Ausnahme OKWVerifyingFailsException für SeInputField auslöst.  //
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyPlaceholder_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyLabel( "Last Name", "Placeholder: Last Nam" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyPlaceholderWCM für SeInputField implementiert ist.
   *
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test
  public void tc_VerifyPlaceholderWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyPlaceholderWCM( "Last Name", "Placeholder: Last Nam?" );
      EN.VerifyPlaceholderWCM( "First Name", "Placeholder: First Nam?" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyPlaceholderWCM bei einer Soll/Ist Abweichung die Ausnahme 
   * OKWVerifyingFailsException für SeInputField auslöst.  //
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyPlaceholderWCM_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyPlaceholderWCM( "Last Name", "####:" );
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyPlaceholderREGX für SeInputField implementiert ist.
   *
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test
  public void tcVerifyPlaceholderREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyPlaceholderREGX( "Last Name", "Placeholder: Last Nam\\w" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyPlaceholderREGX bei einer Soll/Ist Abweichung die Ausnahme 
   * OKWVerifyingFailsException für SeInputField auslöst.  //
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018-10-18
   */
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyPlaceholderREGX_OKWVerifyingFailsException() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyPlaceholderREGX( "Last Name", "Placeholder: Xxxx" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyTooltip( "Last Name", "Title: Last Name" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
      
      EN.VerifyTooltip( "Last Name", "Den Namen..." );
  }

  
  /** \~german
   * Prüft, ob die Methode VerifyTooltipWCM für InputTypeText implementiert ist.
   *
   * \~
   * \author Zoltan Hrabovszki
   * \date 2014.12.03
   */
  @Test
  public void tcVerifyTooltipWCM() throws Exception
  {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
  
      EN.VerifyTooltipWCM( "Last Name", "?????: Last Name" );
  
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyTooltipWCM( "Last Name", "#oltan" );
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
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
  
      // Test-Objekt
      EN.VerifyTooltipREGX( "Last Name", "\\witle: Last Name" );
  
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.VerifyTooltipREGX( "Last Name", "#oltan" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      EN.SetValue( "Last Name", "${DELETE}" );
      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Last Name", "${EMPTY}" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValue( "Last Name", "Zoltan" );

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
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
  
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValue( "Last Name", "Zoltan" );
  
      EN.SetValue( "Last Name", "${DELETE}" );
      EN.VerifyValue( "Last Name", "${EMPTY}" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Last Name", "${EMPTY}" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValue( "Last Name", "Soltan" );

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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Last Name", "Jackson" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueWCM( "Last Name", "??????" );
      EN.VerifyValueWCM( "Last Name", "Z????n" );

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
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
  
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueWCM( "Last Name", "??????" );
  
      EN.SetValue( "Last Name", "${DELETE}" );
      EN.VerifyValueWCM( "Last Name", "${EMPTY}" );
  
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // First off all teh Name-Field is Empty
      EN.VerifyValueWCM( "Last Name", "${EMPTY}" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueWCM( "Last Name", "#oltan" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Last Name", "Jackson" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueREGX( "Last Name", ".oltan" );
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
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );
  
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueREGX( "Last Name", "\\woltan" );
  
      EN.SetValue( "Last Name", "${DELETE}" );
      EN.VerifyValueREGX( "Last Name", "${EMPTY}" );
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

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
      EN.SelectWindow( "InputTypeText" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Last Name", "${EMPTY}" );
      
      EN.SetValue( "Last Name", "Zoltan" );
      EN.VerifyValueREGX( "Last Name", "Soltan" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcClickOn_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.ClickOn( "DoesNotExist");
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
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.Select( "DoesNotExist", "abc");
  }

  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcTypeKey_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.TypeKey( "DoesNotExist", "abc");
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcSetValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.SetValue( "DoesNotExist", "abc");
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcSetFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.SetFocus( "DoesNotExist");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeCaption( "DoesNotExist", "MemorizeCaption");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeHasFocus( "DoesNotExist", "MemorizeHasFocus");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeIsActive( "DoesNotExist", "MemorizeIsActive");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeLabel( "DoesNotExist", "MemorizeLabel");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizePlaceholder_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizePlaceholder( "DoesNotExist", "MemorizePlaceholder");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeTooltip( "DoesNotExist", "MemorizeTooltip");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcMemorizeValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.MemorizeValue( "DoesNotExist", "MemorizeVale");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogCaption( "DoesNotExist");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogHasFocus( "DoesNotExist");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogIsActive( "DoesNotExist");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogLabel( "DoesNotExist");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogPlaceholder_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogPlaceholder( "DoesNotExist");
  }
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogTooltip( "DoesNotExist");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcLogValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.LogValue( "DoesNotExist");
  }
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyCaption_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyCaption( "DoesNotExist", "aa");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyHasFocus_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyHasFocus( "DoesNotExist", "YES");
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyIsActive_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyIsActive( "DoesNotExist", "YES" );
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyLabel_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyLabel( "DoesNotExist", "aa" );
  }
  
  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyTooltip_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyTooltip( "DoesNotExist", "aa");
  }

  
  @Test( expected = OKWGUIObjectNotFoundException.class )
  public void tcVerifyValue_OKWGUIObjectNotFoundException() throws Exception
  {
          EN.BeginTest( name.getMethodName() );
          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/InputTypeText.htm" );
          EN.SelectWindow( "InputTypeText" );

          EN.VerifyValue( "DoesNotExist", "aa");
  }

}
