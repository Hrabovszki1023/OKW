package okw.seselect;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class SeSelect_EN_Test
{
  protected static String ApplicationName;

  @Rule
  public TestName         name = new TestName();


  // \~german
  // \brief
  // Testziel: Prüft, ob ein einzelner Wert gewählt werden kann.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSelect_SingelValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );
    
    EN.Select( "Künstler", "Marianne Rosenberg" );
    EN.VerifyValue( "Künstler", "Marianne Rosenberg" );

    EN.Select( "Blumen", "Lilie" );
    EN.VerifyValue( "Blumen", "Lilie" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
  
  
  // \~german
  // \brief Testziel: Prüft, ob mehrere Werte gewählt werden können.
  //
  // Hinweis: Es ist kein Wert vor ausgewählt.
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSelect_MultipleValues() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/t/select_size-5_multiple.htm" );

    EN.SelectWindow( "SeListBoxMultiSelect" );

    EN.Select( "Künstler", "Heino${SEP}Marianne Rosenberg" );
    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  // \~german
  // \brief
  // Testziel: Prüft die Methode SeSelect.Select,
  // ob bereits ausgwählte Werte gelöscht werden können.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSelect_MultipleValues_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/select_size-5_multiple.htm" );

    EN.SelectWindow( "SeListBoxMultiSelect" );

    EN.Select( "Künstler", "Marianne Rosenberg" );
    EN.Select( "Künstler", "Heino" );

    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    EN.Select( "Künstler", "${DELETE}" );
    EN.VerifyValue( "Künstler", "${EMPTY}" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // \~german
  // \brief Prüft die Methode SeSelect.Select,
  // ob "" und "${IGNORE}" keine Aktivität im Objekt aulösen.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSelect_MultipleValues_IGNORE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/t/select_size-5_multiple.htm" );

    EN.SelectWindow( "SeListBoxMultiSelect" );

    // Mit Werten vorbelegen
    EN.Select( "Künstler", "Marianne Rosenberg" );
    EN.Select( "Künstler", "Heino" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Künstler", "${IGNORE}" );
    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    // "" ändert auch nichts an den eingestellten Werten
    EN.Select( "Künstler", "" );
    EN.VerifyValue( "Künstler", "Heino${SEP}Marianne Rosenberg" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // \~german
  // \brief Prüft die Methode SeSelect.SetValue,
  // ob _ein_ Wert in Singelselection ListBox auswählt.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSetValue_SingelValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.SetValue( "Künstler", "Marianne Rosenberg" );

    EN.VerifyValue( "Künstler", "Marianne Rosenberg" );

    EN.SetValue( "Blumen", "Lilie" );
    EN.VerifyValue( "Blumen", "Lilie" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}
  
  

  // \~german
  // \brief Prüft die Methode SeSelect.SetValue,
  // ob "" und "${IGNORE}" keien Aktion am GUI-Objekt auslösen.
  //
  // \~
  // \author Zoltan Hrabovszki
  // \date 2014.12.03
  @Test
  public void tcSetValue_SingelValue_IGNORE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

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

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyExists( "Künstler", "YES" );
    EN.VerifyExists( "Blumen", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyExists( "NichtVorhanden", "NO" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );
    EN.VerifyExists( "Künstler", "NO" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    
    
    EN.SelectWindow( "SeListBox" );
    EN.VerifyExists( "NichtVorhanden", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyIsActive_IsActiveYesExpectedYes() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Künstler", "YES" );
    EN.VerifyIsActive( "Blumen", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyIsActive_IsActiveNoExpectedNo() throws Exception
  {

    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Fahrzeug", "NO" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyIsActive_IsActiveYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );
    EN.VerifyIsActive( "Künstler", "NO" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
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
  public void tcVerifyIsActive_IsActiveNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyIsActive( "Fahrzeug", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tcVerifyToolTip() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltip( "Künstler", "Title: Artist" );
    EN.VerifyTooltip( "Blumen", "Titel: Flowers" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTip_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltip( "Künstler", "Title: Artis" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tcVerifyToolTipWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltipWCM( "Künstler", "Title: Artist" );
    EN.VerifyTooltipWCM( "Blumen", "Titel: Flowers" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTipWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltipWCM( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test
  public void tcVerifyToolTipREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyTooltipREGX( "Künstler", "Title: Artist" );
    EN.VerifyTooltipREGX( "Blumen", "Titel: Flowers" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTipREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Künstler aus"
    EN.VerifyTooltipREGX( "Künstler", "Title: Künstker" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tcVerifyLabel() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabel( "Künstler", "Artist:" );
    EN.VerifyLabel( "Blumen", "Flowers:" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabel_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyLabel( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test
  public void tcVerifyLabelWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabelWCM( "Künstler", "*rtist:" );
    EN.VerifyLabelWCM( "Blumen", "Flowers?" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyTooltipWCM( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test
  public void tcVerifyLabelREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyLabelREGX( "Künstler", "Artist:" );
    EN.VerifyLabelREGX( "Blumen", "Flowers:" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyLabelREGX( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  // / \brief
  // / Prüft die Methode SeLink.MemorizeToolTip.
  // /
  @Test
  public void tcMemorizeToolTip() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.MemorizeTooltip( "Künstler", "SeListBox_MemorizeTooltip_1" );
    assertEquals( "Title: Artist", okw.OKW_Memorize_Sngltn.getInstance().get( "SeListBox_MemorizeTooltip_1" ) );

    EN.MemorizeTooltip( "Blumen", "SeListBox_MemorizeTooltip_1" );
    assertEquals( "Titel: Flowers", okw.OKW_Memorize_Sngltn.getInstance().get( "SeListBox_MemorizeTooltip_1" ) );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void tcLogToolTip_en() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.LogTooltip( "Künstler" );
    EN.LogTooltip( "Blumen" );
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tcVerifyValue() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyValue( "Künstler", "${EMPTY}" );
    EN.VerifyValue( "Blumen", "Tulpe" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValue_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValue( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tcVerifyValueWCM() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );

    EN.SelectWindow( "SeListBox" );
    EN.VerifyValueWCM( "Künstler", "${EMPTY}" );
    EN.VerifyValueWCM( "Blumen", "?ulpe" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValueWCM( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}

  @Test
  public void tcVerifyValueREGX() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    EN.VerifyValueREGX( "Künstler", "${EMPTY}" );
    EN.VerifyValueREGX( "Blumen", ".ulpe" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
    EN.SelectWindow( "SeListBox" );

    // Actuall Value: "Wähle eine Blume aus"
    EN.VerifyValueREGX( "Künstler", "Wähle Interpret" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
}
