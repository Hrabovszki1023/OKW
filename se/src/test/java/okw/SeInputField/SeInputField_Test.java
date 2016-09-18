package okw.SeInputField;

/*
 ==============================================================================
 Copyright © 2012, 2013, 2014, 2015, 2016 IT-Beratung Hrabovszki
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

import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Ignore
public class SeInputField_Test {

  OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  @After
  public void myAfter() throws Exception
  {
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // / \brief
  // / Prüft ob ein vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // /
  @Test
  public void tcLogExists() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogExists( "Name" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogExists", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogExists", "F");
      throw e;
    }
  }

  // / \brief
  // / Focus eines Textfeldes loggen.
  // /
  @Test
  public void tcLogHasFocus() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
      EN.LogHasFocus( "Name" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogHasFocus", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogHasFocus", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort LogLabel( FN ) eines SeInputText Prüfen.
  //
  @Test
  public void tcLogIsActive() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
      EN.LogIsActive( "Name" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogIsActive", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogIsActive", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort LogLabel( FN ) eines SeInputText Prüfen.
  //
  @Test
  public void tcLogLabel() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogLabel( "Name" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogLabel", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort LogLogToolTip( FN ) eines SeInputText Prüfen.
  //
  @Test
  public void tcLogToolTip() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogTooltip( "Name" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogToolTip", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogToolTip", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort LogLogValue( FN ) eines SeInputText Prüfen.
  //
  @Test
  public void tcLogValue() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.LogValue( "Name" );

      EN.TypeKey( "Name", "Zoltan" );
      EN.LogValue( "Name" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "LogValue", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort MemorizeExists( FN, MemKey ) eines SeInputText Prüfen.
  //
  @Test
  public void TC_MemorizeExists_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeExists( "Name", "SeTextField_MemorizeExists_1" );

      assertEquals(
          "YES",
          okw.OKW_Memorize_Sngltn.getInstance().Get(
              "SeTextField_MemorizeExists_1" ) );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeExists", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeExists", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort MemorizeHasFocus( FN, MemKey ) eines SeInputText Prüfen.
  //
  @Test
  public void tcMemorizeHasFocus() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeHasFocus( "Name", "SeTextField_MemorizeHasFocus" );

      assertEquals( "NO", myMem.Get( "SeTextField_MemorizeHasFocus" ) );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeHasFocus", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeHasFocus", "F");
      throw e;
    }
  }

  
  // \brief
  // Teste das Schlüsselwort MemorizeIsActive( FN, MemKey ) eines SeInputText Prüfen.
  //
  @Test
  public void tcMemorizeIsActive_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeIsActive( "Name", "SeTextField_MemorizeIsActive" );

      assertEquals( "YES", myMem.Get( "SeTextField_MemorizeIsActive" ) );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeIsActive", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeIsActive", "F");
      throw e;
    }
  }

  
  // \brief
  // Teste das Schlüsselwort MemorizeLabel( FN, MemKey ) eines SeInputText Prüfen.
  //
  @Test
  public void tcMemorizeLabel() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      // /
      EN.MemorizeLabel( "Name", "SeTextField_MemorizeLabel_1" );
      EN.MemorizeLabel( "Vorname", "SeTextField_MemorizeLabel_2" );

      assertEquals( "Name:", myMem.Get( "SeTextField_MemorizeLabel_1" ) );
      assertEquals( "Vorname:", myMem.Get( "SeTextField_MemorizeLabel_2" ) );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeLabel", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort MemorizeToolTip( FN, MemKey ) eines SeInputText Prüfen.
  //
  @Test
  public void tcMemorizeToolTip() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.MemorizeTooltip( "Name", "SeTextField_MemorizeTooltip" );

      assertEquals( "Den Namen eingeben",
      myMem.Get( "SeTextField_MemorizeTooltip" ) );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeToolTip", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeToolTip", "F");
      throw e;
    }
  }


  // \brief
  // Teste das Schlüsselwort MemorizeValue( FN, MemKey ) eines SeInputText Prüfen.
  // 
  @Test
  public void tcMemorizeValue() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeValue", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "MemorizeValue", "F");
      throw ex;
    }
  }

  
  // \brief
  // Teste das Schlüsselwort SetFocus( FN ) eines SeInputText Prüfen.
  // 
  @Test
  public void tcSetFocus_ReadableAndEnabled() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetFocus", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetFocus", "F");
      throw e;
    }
  }

  // \brief
  // Teste das Schlüsselwort SetFocus( FN ) eines readonly aber nicht disabled SeInputText prüfen.
  //
  // Attribut Einstellung hier:
  // * readonly ist eingeschatet
  // * disable ist abgeschaltet
  //
  @Test
  // @Ignore( "Frame for 'SeInputTextReadonly' not found" )
  public void tcSetFocus_ReadonlyAndEnabled() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetFocus", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetFocus", "F");
      throw e;
    }
  }

  // \brief
  // Testet das Schlüsselwort SetValue( FN ) eines SeInputText-es.
  //
  @Test
  public void tcSetValue() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetValue", "F");
      throw e;
    }
  }

  // \brief
  // Testet das Schlüsselwort SetValue( FN ) mit ${IGNORE} eines SeInputText-es.
  //
  @Test
  public void tcSetValue_IGNORE() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "SetValue", "F");
      throw e;
    }
  }

  // \brief
  // Testet das Schlüsselwort TypeKey( FN ) eines SeInputText-es.
  //
  @Test
  public void tcTypeKey() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "TypeKey", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "TypeKey", "F");
      throw ex;
    }
  }

  // \brief
  // Testet das Schlüsselwort TypeKey( FN ) mit ${IGNORE} eines SeInputText-es.
  //
  @Test
  public void tcTypeKey_IGNORE() throws Exception {
    try {
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

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "TypeKey", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "TypeKey", "F");
      throw ex;
    }
  }

  // \brief
  // Prüft ob ein tatsächlich _nicht_ vorhandenes Objekt _nicht_ existiert.
  // Erwartet wird das das objekt nicht existiert.
  //
  @Test
  public void tcVerifyExists_ExistsNoExpectedNo() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "NichtVorhanden", "NO" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "F");
      throw ex;
    }
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
  
      EN.VerifyExists( "NichtVorhanden", "YES" );
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
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "Name", "YES" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "F");
      throw e;
    }
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
  public void tcVerifyExists_IGNORE() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "NichtVorhanden", "${IGNORE}" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "F");
      throw ex;
    }
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test
  public void tcVerifyHasFocus() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "NO" );
      EN.SetFocus( "Name" );
      EN.VerifyHasFocus( "Name", "YES" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "F");
      throw ex;
    }
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyHasFocus_HasFocusYesExpectedNo_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "NO" );
      EN.SetFocus( "Name" );
      EN.VerifyHasFocus( "Name", "NO" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "F");
      throw ex;
    }
  }

  // \brief
  // Focus eines Textfeldes prüfen.
  //
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyHasFocus_HasFocusNoExpectedYes_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "Name", "YES" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "P");
    }
    catch (Exception ex) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "F");
      throw ex;
    }
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
  public void tcVerifyHasFocus_IGNORE() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyHasFocus( "NichtVorhanden", "${IGNORE}" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyHasFocus", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyIsActive für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyIsActive() throws Exception {
    try {
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
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyIsActive", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyIsActive", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabel() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabel( "Name", "Name:" );
      EN.VerifyLabel( "Vorname", "Vorname:" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabel( "Name", "Xxxx:" );


      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabelWCM() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelWCM( "Name", "Name?" );
      EN.VerifyLabelWCM( "Vorname", "Vorname?" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelWCM_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelWCM( "Name", "####:" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX für SeInputField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyLabelREGX() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelREGX( "Name", "Name\\W" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelREGX_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyLabelREGX( "Name", "Xxxx:" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyLabel", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltip() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyTooltip( "Name", "Den Namen eingeben" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "F");
      throw e;
    }
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
  public void tcVerifyTooltip_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyValue( "Name", "Soltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltipWCM() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.VerifyTooltipWCM( "Name", "??? Namen eingeben" );
  
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyTooltipWCM_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyValueWCM( "Name", "#oltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyTooltipREGX() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_inputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.VerifyTooltipREGX( "Name", "\\wen Namen eingeben" );
  
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyTooltip", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyTooltipREGX_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyValueREGX( "Name", "#oltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }
  
  
  // \~german
  // \brief
  // Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeInputText.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValue() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Zoltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
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
  // @Ignore("Setvalue error")
  public void tcVerifyValue_DELETE_EMPTY() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Zoltan" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValue( "Name", "${EMPTY}" );
  
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValue_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValue( "Name", "Soltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }


  // \~german
  // \brief
  // Test des Schlüsselwortes "VerifyValueWCM( FN, ExpValu ) für SeInputText.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValueWCM() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "??????" );
      EN.VerifyValueWCM( "Name", "Z????n" );
      
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
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
  // @Ignore("Setvalue error")
  public void tcVerifyValueWCM_DELETE_EMPTY() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "??????" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValueWCM( "Name", "${EMPTY}" );
  
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueWCM_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValueWCM( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueWCM( "Name", "#oltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  
  // \~german
  // \brief
  // Test des Schlüsselwortes "VerifyValueREGX( FN, ExpValu ) für SeInputText.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcVerifyValueREGX() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", ".oltan" );
      
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
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
  // @Ignore("Setvalue error")
  public void tcVerifyValueREGX_DELETE_EMPTY() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
  
      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );
  
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", "\\woltan" );
  
      EN.SetValue( "Name", "${DELETE}" );
      EN.VerifyValueREGX( "Name", "${EMPTY}" );
  
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  // \~german
  // \brief
  // Prüft, ob die Methode VerifyLabelREGX bei einer Soll/Ist Abweichung die Ausnahme 
  // OKWVerifyingFailsException für SeInputField auslöst.  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueREGX_OKWVerifyingFailsException() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
      EN.SelectWindow( "SeTextField" );

      // First off all teh Name-Field is Empty
      EN.VerifyValue( "Name", "${EMPTY}" );
      
      EN.SetValue( "Name", "Zoltan" );
      EN.VerifyValueREGX( "Name", "Soltan" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "P");
    }
    catch (Exception e) {
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyValue", "F");
      throw e;
    }
  }

  
  // / \brief
  // / Methoden, die nicht implementiert werden, in der ImplementationMatrix als
  // "Nicht Implementiert" registrienen.
  // /
  @Test
  @Ignore
  public void __NotImplemented_en() {
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "LogCaption", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "LogTablecellValue", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "MemorizeCaption", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "MemorizeTablecellValue", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "SelectMenu", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "SelectTablecell", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField", "StopApp",
    // "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "StartApp", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "VerifyCaption", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "VerifyTablecellValue", "N");
    // ImplementationMatrix.Instance.SetImplementation("SeTextField",
    // "SelectWindow", "N");
  }
}
