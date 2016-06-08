package okw.SeTextfield;

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

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Ignore
public class SeTextField_EN_Test {

  OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Rule
  public TestName         name  = new TestName();

  @After
  public void myAfter() throws Exception {
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // / \brief
  // / Prüft ob ein vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // /
  @Test
  public void TC_LogExists_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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
  public void TC_LogHasFocus_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \brief
  // / Logt, ob das Textfeld aktiv ist.
  // /
  @Test
  public void TC_LogIsActive_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void TC_LogLabel_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void TC_LogToolTip_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  public void TC_LogValue_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Prüft ob ein vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // /
  @Test
  public void TC_MemorizeExists_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Focus eines Textfeldes merken.
  // /
  @Test
  public void TC_MemorizeHasFocus_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Merkt sich, ob das Textfeld kctiv ist.
  // /
  @Test
  public void TC_MemorizeIsActive_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void TC_MemorizeLabel_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void TC_MemorizeToolTip_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  public void TC_MemorizeValue_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  public void TC_SetFocus_NoAttributeReadonly_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
  // /
  @Test
  @Ignore( "Frame for 'SeInputTextReadonly' not found" )
  public void TC_SetFocus_WithAttributeReadonly_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL",
          "http://test.openkeyword.de/TextField/TextField_readonly.htm" );

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

  @Test
  public void TC_SetValue_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  @Ignore( "SetValue Error" )
  public void TC_SetValue_IGNORE_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  public void tc_TypeKey_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  @Test
  public void tc_TypeKey_ignore_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Prüft ob ein _nicht_ vorhandenes Objekt _nicht_ existiert.
  // / Erwartet wird das das objekt nicht existiert.
  // /
  @Test
  public void tc_VerifyExists_No_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Prüft ob ein vorhandenes Objekt nicht existiert.
  // / Hier wird wird geprüft auf das default timout exception getriggert wird.
  // / TODO Zeitmessung einbauen
  // /
  @Test
  @Ignore
  public void tc_VerifyExists_NO_YesObject_en() {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

      EN.SelectWindow( "SeTextField" );
      EN.VerifyExists( "Name", "NO" );

      // Hier darf die Ausführung nich vorbei kommen: Exception wurde nicht
      // ausgelöst.
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "F");
      okw.log.Logger_Sngltn.getInstance().LogError(
          "Erwartete Exception wurde NICHT ausgelöst! - Fehler!" );
      fail( "Erwartete Exception wurde NICHT ausgelöst! - Fehler!" );
    }
    catch (Exception e) {
      // TODO Exception Prüfen: Wurde die richtige exception ausgelöst?
      okw.log.Logger_Sngltn.getInstance().LogPrint(
          "Erwartetet Exception wurde ausgelöst! - OK!" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "P");
    }
  }

  // / \brief
  // / Prüft ob ein vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // /
  @Test
  public void TC_VerifyExists_YES_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brife
  // / Prüft, ob die OKW-Konstante ${IGNORE} implementiert ist.
  // /
  // / Nicht existierendes Object wird als GUI-Objekt Referenziert.
  // / Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
  // nicht ausgeführt wird.
  // / D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
  // worden.
  // /
  @Test
  public void tc_VerifyExists_IGNORE_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

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

  // / \brief
  // / Prüft ob ein nicht vorhandenes objekt existiert.
  // / Erwartet wird, dass das Objekt existiert.
  // / Es wird geprüft auf das default timout exception getriggert wird.
  // / TODO zeitmessung einbauen
  // /
  @Test
  @Ignore
  public void tc_VerifyExists_YES_NoObject_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );

      EN.SelectWindow( "SeTextField" );

      EN.VerifyExists( "NichtVorhanden", "YES" );

      fail( "Exception ist nicht ausgelöst worden" );

      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "F");
    }
    catch (Exception ex) {
      okw.log.Logger_Sngltn.getInstance().LogPrint(
          "Erwartetet Exception wurde ausgelöst! - OK!" );
      // ImplementationMatrix.Instance.SetImplementation("SeTextField",
      // "VerifyExists", "P");
    }
  }

  // / \brief
  // / Focus eines Textfeldes prüfen.
  // /
  @Test
  public void TC_VerifyHasFocus_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \~german
  // / \brief
  // / Prüft, ob die OKW-Konstante ${IGNORE} für SeTextField implementiert ist.
  // /
  // / Nicht existierendes Object wird als GUI-Objekt Referenziert.
  // / Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
  // nicht ausgeführt wird.
  // / D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
  // worden.
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  public void TC_VerifyHasFocus_IGNORE_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \~german
  // / \brief
  // / Prüft, ob die Methode VerifyIsActive für SeTextField implementiert ist.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  @Ignore( "frame notfound" )
  public void TC_VerifyIsActive_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL",
          "http://test.openkeyword.de/TextField/TextField_disabled.htm" );
      EN.SelectWindow( "SeInputTextDisabled" );

      EN.VerifyIsActive( "Preis", "NO" );
      EN.VerifyIsActive( "MwSt", "NO" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
      EN.SelectWindow( "SeTextField" );

      EN.VerifyIsActive( "Name", "YES" );
      EN.VerifyIsActive( "Vorname", "YES" );

      // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
      EN.TypeKey( "URL",
          "http://test.openkeyword.de/TextField/TextField_readonly.htm" );
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

  // / \~german
  // / \brief
  // / Prüft, ob die Methode VerifyLabel für SeTextField implementiert ist.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  public void TC_VerifyLabel_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \~german
  // / \brief
  // / Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  public void TC_VerifyTooltip_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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

  // / \~german
  // / \brief
  // / Prüft, ob die Methode VerifyValue für SeTextField implementiert ist.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  public void TC_VerifyValue_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
      EN.SelectWindow( "SeTextField" );

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

  // / \~german
  // / \brief
  // / Prüft, ob die Methode VerifyValue die OKW-Konstanten ${DELETE} und
  // ${EMPTY} für
  // / SeTextField implementiert ist.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.12.03
  @Test
  // @Ignore("Setvalue error")
  public void TC_VerifyValue_DELETE_EMPTY_en() throws Exception {
    try {
      EN.BeginTest( name.getMethodName() );
      EN.StartApp( ApplicationName );

      EN.TypeKey( "URL", "http://test.openkeyword.de/TextField/TextField.htm" );
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
