package okw.SeRadioList;

import static org.junit.Assert.*;
import okw.core.EN;
import okw.exceptions.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SeRadioList_Test
{
  protected static String ApplicationName;

  @Rule
  public TestName         name = new TestName();

  @After
  public void myAfter() throws Exception
  {
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /**
   *  \~german
   *  Testziel: Prüft, ob ein einzelner Wert gewählt werden kann.
   *
   * \~
   * @author Zoltan Hrabovszki
   * @date 2014.12.03
   */
  @Test
  public void tcSelect_SingelValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "Visa" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.Select( "Pay Method", "Mastercard" );
    EN.VerifyValue( "Pay Method", "Mastercard" );

    EN.Select( "Pay Method", "Amarican Express" );
    EN.VerifyValue( "Pay Method", "Visa" );
  }
  
  
  /** \~german
   * Prüft die Methode EN.Select() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeRadioList 
   * übergeben wird.
   *
   *  \~english
   * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.Select(), if more than one value is passed to SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * @date 2014.12.03
   * 
   * @throws Exception Here is no Exception expected!
   */
  @Test( expected = OKWOnlySingleValueAllowedException.class )
  public void tcSelect_OKWOnlySingleValueAllowedException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "Visa${SEP}Mastercard" );

  }
  

  /** \~german
   *  \brief
   *  Testziel: Prüft die Methode SeSelect.Select,
   *  ob bereits ausgwählte Werte gelöscht werden können.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2014.12.03
   */
  @Test
  @Ignore
  public void tcSelect_MultipleValues_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeListBoxMultiSelect" );

    EN.Select( "Künstler", "Marianne Rosenberg" );
    EN.Select( "Künstler", "Heino" );

    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    EN.Select( "Künstler", "${DELETE}" );
    EN.VerifyValue( "Künstler", "${EMPTY}" );
  }

  /** \~german
   *  \brief Prüft die Methode SeRadioList.Select(),
   *  ob "${IGNORE}" keine Aktivität im Objekt aulösen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2014.12.03
   */
  @Test
  @Ignore
  public void tcSelect_MultipleValues_IGNORE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Visa" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Visa" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "${IGNORE}" );
    EN.VerifyValue( "Pay Method", "Visa" );

    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Amarican Express" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Amarican Express" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "" );
    EN.VerifyValue( "Pay Method", "Amarican Express" );
  }


  /** \~german
   *  \brief Prüft die Methode SeRadioList.Select(),
   *  ob "${IGNORE}" keine Aktivität im Objekt aulösen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2014.12.03
   */
  @Test
  @Ignore
  public void tcSelect_MultipleValues_EmptyString() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Visa" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Visa" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "${IGNORE}" );
    EN.VerifyValue( "Pay Method", "Visa" );

    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Amarican Express" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Amarican Express" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "" );
    EN.VerifyValue( "Pay Method", "Amarican Express" );
  }
  
  
  /** \~german
   * Prüft die Methode SetValue() der Klasse SeRadioList
   * ob _ein_ einzelner Wert ausgewählt wird.
   *
   *  \~english
   * Reviews the  Methode SetValue of the Class SeRadioList for singel value selection in SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * @date 2014.12.03
   * 
   * @throws Exception Here is no Exception expected!
   */
  @Test
  public void tcSetValue_SingelValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.SetValue( "Pay Method", "Visa" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.SetValue( "Pay Method", "Mastercard" );
    EN.VerifyValue( "Pay Method", "Mastercard" );

    EN.SetValue( "Pay Method", "Amarican Express" );
    EN.VerifyValue( "Pay Method", "Visa" );
  }
  
  
  /** \~german
   * Prüft die Methode EN.SetValue() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeRadioList 
   * übergeben wird.
   *
   *  \~english
   * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.SetValue(), if more than one value is passed to SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * @date 2014.12.03
   * 
   * @throws Exception The OKWOnlySingleValueAllowedException is expected!
   */
  @Test( expected = OKWOnlySingleValueAllowedException.class )
  public void tcSetValue_OKWOnlySingleValueAllowedException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.SetValue( "Pay Method", "Visa${SEP}Mastercard" );
  }

  
  // \~german
  // \brief Prüft die Methode SeSelect.SetValue,
  // ob "" und "${IGNORE}" keien Aktion am GUI-Objekt auslösen.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  @Ignore
  public void tcSetValue_SingelValue_IGNORE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.SetValue( "Künstler", "Marianne Rosenberg" );
    EN.VerifyValue( "Künstler", "Marianne Rosenberg" );

    EN.SetValue( "Künstler", "${IGNORE}" );
    EN.VerifyValue( "Künstler", "Marianne Rosenberg" );

    EN.SetValue( "Künstler", "" );
    EN.VerifyValue( "Künstler", "Marianne Rosenberg" );

    EN.SetValue( "Blumen", "Lilie" );
    EN.VerifyValue( "Blumen", "Lilie" );

    EN.SetValue( "Blumen", "${IGNORE}" );
    EN.VerifyValue( "Blumen", "Lilie" );

    EN.SetValue( "Blumen", "" );
    EN.VerifyValue( "Blumen", "Lilie" );
  }

  
  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _vorhanden_ ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test
  @Ignore
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyExists( "Künstler", "YES" );
    EN.VerifyExists( "Blumen", "YES" );

  }

  
  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist nichtvorhanden_. Erwartet wird, dass das Objekt _nicht
  // vorhanden_ ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test
  @Ignore
  public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyExists( "NichtVorhanden", "NO" );

  }

  
  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _nicht vorhanden_
  // ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );
    EN.VerifyExists( "Künstler", "NO" );
  }

  
  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist nicht vorhanden_. Erwartet wird, dass das Objekt _vorhanden_
  // ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyExists( "NichtVorhanden", "YES" );
  }

  // \~german
  // \brief
  // Prüft die Methode SeSelect.IsActive.
  //
  // Objekt _ist aktive_. Erwartet wird, dass das Objekt _aktive_ ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test
  @Ignore
  public void tcVerifyIsActive_IsActiveYesExpectedYes() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Künstler", "YES" );
    EN.VerifyIsActive( "Blumen", "YES" );
  }

  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist nicht aktive_. Erwartet wird, dass das Objekt _nicht aktive_
  // ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test
  @Ignore
  public void tcVerifyIsActive_IsActiveNoExpectedNo() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Fahrzeug", "NO" );

  }

  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist aktive_. Erwartet wird, dass das Objekt _nicht aktive_ ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyIsActive_IsActiveYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );
    EN.VerifyIsActive( "Künstler", "NO" );
  }

  // \~german
  // \brief
  // Prüft die Methode SeSelect.VerifyExists.
  //
  // Objekt _ist nicht aktive. Erwartet wird, dass das Objekt _aktive_ ist.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.20
  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyIsActive_IsActiveNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Fahrzeug", "YES" );
  }

  @Test
  @Ignore
  public void tcVerifyToolTip() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltip( "Künstler", "Wähle Interpret aus" );
    EN.VerifyTooltip( "Blumen", "Wähle eine Blume aus" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyToolTip_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltip( "Künstler", "Wähle Interpret" );
  }

  @Test
  @Ignore
  public void tcVerifyToolTipWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltipWCM( "Künstler", "Wähle Interpret aus" );
    EN.VerifyTooltipWCM( "Blumen", "Wähle eine Blume aus" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyToolTipWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltipWCM( "Künstler", "Wähle Interpret" );
  }

  @Test
  @Ignore
  public void tcVerifyToolTipREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltipREGX( "Künstler", "Wähle Interpret aus" );
    EN.VerifyTooltipREGX( "Blumen", "Wähle eine Blume aus" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyToolTipREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltipREGX( "Künstler", "Wähle Interpret" );
  }

  @Test
  @Ignore
  public void tcVerifyLabel() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabel( "Künstler", "Künstler" );
    EN.VerifyLabel( "Blumen", "Blumen" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyLabel_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyLabel( "Künstler", "Wähle Interpret" );
  }

  @Test @Ignore

  public void tcVerifyLabelWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabelWCM( "Künstler", "*ünstler" );
    EN.VerifyLabelWCM( "Blumen", "Blume?" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyLabelWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltipWCM( "Künstler", "Wähle Interpret" );
  }

  @Test @Ignore

  public void tcVerifyLabelREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabelREGX( "Künstler", ".ünstler" );
    EN.VerifyLabelREGX( "Blumen", ".lumen" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyLabelREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyLabelREGX( "Künstler", "Wähle Interpret" );
  }

  // / \brief
  // / Prüft die Methode SeLink.MemorizeToolTip.
  // /
  @Test @Ignore

  public void tcMemorizeToolTip() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.MemorizeTooltip( "Künstler", "SeListBox_MemorizeTooltip_1" );
    assertEquals( "Wähle Interpret aus", okw.OKW_Memorize_Sngltn.getInstance().Get( "SeListBox_MemorizeTooltip_1" ) );

    EN.MemorizeTooltip( "Blumen", "SeListBox_MemorizeTooltip_1" );
    assertEquals( "Wähle eine Blume aus", okw.OKW_Memorize_Sngltn.getInstance().Get( "SeListBox_MemorizeTooltip_1" ) );

  }

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  @Ignore
  public void tcLogToolTip_en() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.LogTooltip( "Künstler" );
    EN.LogTooltip( "Blumen" );
  }

  @Test
  @Ignore

  public void tcVerifyValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyValue( "Künstler", "${EMPTY}" );
    EN.VerifyValue( "Blumen", "Tulpe" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyValue_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValue( "Künstler", "Wähle Interpret" );
  }

  @Test @Ignore

  public void tcVerifyValueWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyValueWCM( "Künstler", "${EMPTY}" );
    EN.VerifyValueWCM( "Blumen", "?ulpe" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyValueWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValueWCM( "Künstler", "Wähle Interpret" );
  }

  @Test @Ignore

  public void tcVerifyValueREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyValueREGX( "Künstler", "${EMPTY}" );
    EN.VerifyValueREGX( "Blumen", ".ulpe" );
  }

  @Test( expected = OKWVerifyingFailsException.class )
  @Ignore
  public void tcVerifyValueREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValueREGX( "Künstler", "Wähle Interpret" );
  }

}
