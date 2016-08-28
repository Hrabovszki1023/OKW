package okw.SeListBox;

import static org.junit.Assert.*;
import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeListBox_EN_Test
{
  protected static String ApplicationName;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
  }

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

  /// \~german
  /// \brief
  /// Testziel: Prüft, ob ein einzelner Wert gewählt werden kann.
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_Select_SingelValue_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");

          EN.SelectWindow("SeListBox");

          EN.Select("Künstler", "Marianne Rosenberg");

          EN.VerifyValue("Künstler", "Marianne Rosenberg");

          EN.Select("Blumen", "Lilie");
          EN.VerifyValue("Blumen", "Lilie");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  /// \~german
  /// \brief
  /// Testziel: Prüft, ob mehrere Werte gewählt werden können.
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_Select_MultipleValues_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select_multiple.htm");

          EN.SelectWindow("SeListBoxMultiSelect");

          //EN.Select("Künstler", "Marianne Rosenberg");
          EN.Select("Künstler", "Heino${SEP}Marianne Rosenberg");

          EN.VerifyValue("Künstler", "Heino${SEP}Marianne Rosenberg");


          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  /// \~german
  /// \brief
  /// Testziel: Prüft die Methode SeSelectBox.Select,
  /// ob mehrere Werte gelöscht werden können.
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_SelectAndVerify_MultipleValues_DELETE_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select_multiple.htm");

          EN.SelectWindow("SeListBoxMultiSelect");

          EN.Select("Künstler", "Marianne Rosenberg");
          EN.Select("Künstler", "Heino");

          EN.VerifyValue("Künstler", "Heino${SEP}Marianne Rosenberg");

          EN.Select("Künstler", "${DELETE}");
          EN.VerifyValue("Künstler", "${EMPTY}");


          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  /// \~german
  /// \brief
  /// Testziel: Prüft die Methode SeSelectBox.Select, 
  /// ob "" und "${IGNORE}" keine Aktivität im Objekt .
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_Select_MultipleValues_IGNORE_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select_multiple.htm");

          EN.SelectWindow("SeListBoxMultiSelect");

          // Mit Werten vorbelegen
          EN.Select("Künstler", "Marianne Rosenberg");
          EN.Select("Künstler", "Heino");

          // Werte sind im Objekt?
          EN.VerifyValue("Künstler", "Heino${SEP}Marianne Rosenberg");

          // IGNORE ändert nichts an den eingestellten Werten
          EN.Select("Künstler", "${IGNORE}");
          EN.VerifyValue("Künstler", "Heino${SEP}Marianne Rosenberg");

          // "" ändert auch nichts an den eingestellten Werten
          EN.Select("Künstler", "");
          EN.VerifyValue("Künstler", "Heino${SEP}Marianne Rosenberg");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "Select", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  
  /// \~german
  /// \brief
  /// Testziel: Prüft die Methode SelistBox.SetValue, 
  /// ob _ein_ Wert in Singelselection ListBox auswählt.
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_SetValue_SingelValue_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");

          EN.SelectWindow("SeListBox");

          EN.SetValue("Künstler", "Marianne Rosenberg");

          EN.VerifyValue("Künstler", "Marianne Rosenberg");

          EN.SetValue("Blumen", "Lilie");
          EN.VerifyValue("Blumen", "Lilie");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SetValue", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SeValue", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  
  /// \~german
  /// \brief
  /// Testziel: Prüft die Methode SelistBox.SetValue, 
  /// ob _ein_ Wert in Singelselection ListBox auswählt.
  ///
  /// \~
  /// \author Zoltan Hrabovszki
  /// \date 2014.12.03
  @Test
  public void TC_SetValue_SingelValue_IGNORE_EN() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");

          EN.SelectWindow("SeListBox");

          EN.SetValue("Künstler", "Marianne Rosenberg");
          EN.VerifyValue("Künstler", "Marianne Rosenberg");

          EN.SetValue("Künstler", "${IGNORE}");
          EN.VerifyValue("Künstler", "Marianne Rosenberg");

          EN.SetValue("Künstler", "");
          EN.VerifyValue("Künstler", "Marianne Rosenberg");

          EN.SetValue("Blumen", "Lilie");
          EN.VerifyValue("Blumen", "Lilie");

          EN.SetValue("Blumen", "${IGNORE}");
          EN.VerifyValue("Blumen", "Lilie");

          EN.SetValue("Blumen", "");
          EN.VerifyValue("Blumen", "Lilie");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SetValue", "P");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "SeValue", "F");
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyValue", "F");
          throw e;
      }
  }

  
  
  /// \brief
  /// Prüft die Methode SeListBox.VerifyExists.
  /// 
  /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _vorhanden_ ist.
  /// 
  @Test
  public void TC_VerifyExists_YES() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");

          EN.SelectWindow("SeListBox");

          EN.VerifyExists("Künstler", "YES");
          EN.VerifyExists("Blumen", "YES");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");
          throw e;
      }
  }


  /// \brief
  /// Prüft die Methode SeListBox.VerifyExists.
  /// 
  /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _nicht_ vorhanden ist.
  /// 
  @Test
  public void TC_VerifyExists_NO() throws Exception
  {
      try
      {

          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");

          EN.SelectWindow("SeListBox");

          EN.VerifyExists("NichtVorhanden", "NO");

          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "P");
      }
      catch ( Exception e )
      {
          //ImplementationMatrix.Instance.SetImplementation(cvOKWObject, "VerifyExists", "F");
          throw e;
      }
  }

  /// \brief
  /// Prüft die Methode SeListBox.VerifyExists.
  /// 
  /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _nicht_ vorhanden ist.
  /// -> Exception muss ausgelöst werden.
  /// 
  @Test( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyExists_NO_YesObject() throws Exception
  {
      EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");
      EN.SelectWindow("SeListBox");
      EN.VerifyExists("Künstler", "NO");
  }

  /// \brief
  /// Prüft die Methode SeLink.VerifyExists.
  /// 
  /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _vorhanden_ ist.
  /// 
  @Test( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyExists_YES_NoObject() throws Exception
  {
      EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");
      EN.SelectWindow("SeListBox");

      EN.VerifyExists("NichtVorhanden", "YES");
  }

  @Test
  public void TC_VerifyToolTip() throws Exception
  {
          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");
          EN.SelectWindow("SeListBox");

          EN.VerifyTooltip("Künstler", "Wähle Interpret aus");
          EN.VerifyTooltip("Blumen", "Wähle eine Blume aus");
  }
  
  /// \brief
  /// Prüft die Methode SeLink.MemorizeToolTip.
  /// 
  @Test
  public void TC_MemorizeToolTip() throws Exception
  {
          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");
          EN.SelectWindow("SeListBox");

          EN.MemorizeTooltip("Künstler", "SeListBox_MemorizeTooltip_1");
          assertEquals( "Wähle Interpret aus", okw.OKW_Memorize_Sngltn.getInstance().Get("SeListBox_MemorizeTooltip_1"));

          EN.MemorizeTooltip("Blumen", "SeListBox_MemorizeTooltip_1");
          assertEquals("Wähle eine Blume aus", okw.OKW_Memorize_Sngltn.getInstance().Get("SeListBox_MemorizeTooltip_1"));

  }

  /// \brief
  /// Tooltip eines Textfeldes Prüfen.
  /// 
  @Test
  public void TC_LogToolTip_en() throws Exception
  {
          EN.TypeKey("URL", "file:///C:/GIT/okw/OKW/html/test.openkeyword.de/Select/Select.htm");
          EN.SelectWindow("SeListBox");

          EN.LogTooltip("Künstler");
          EN.LogTooltip("Blumen");
  }

  

}
