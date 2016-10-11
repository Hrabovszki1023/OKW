package okw.core;

import static org.junit.Assert.*;

import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import okw.*;
import okw.exceptions.*;
import okw.log.*;

/// \brief
/// This is a test class for FrameObjectDictionaryTest and is intended
/// to contain all FrameObjectDictionaryTest Unit Tests
/// 
public class FrameObjectDictionary_Test
{

  // / \brief
  // / This is a test class for FrameObjectDictionaryTest and is intended
  // / to contain all FrameObjectDictionaryTest Unit Tests
  // /
  static FrameObjectDictionary_Sngltn target; // = new

  // FrameObjectDictionary();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {

    Logger_Sngltn.getInstance();
    // Reset des Loggers: Alle geladenen Instanzen löschen
    Logger_Sngltn.Init();

    // Logger_Sngltn.getInstance().AddLogger(new Log2Console());
    Logger_Sngltn.getInstance().setDebugMode( true );

    // System.out.Printline( "OKW_XML: " +
    // Environment.GetEnvironmentVariable("OKW_Xml"));

    target = FrameObjectDictionary_Sngltn.getInstance();
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

  // / \brief
  // / A test for CreateInstanceByObjectName
  // /
  @Test
  public void GetObjectByName_Window()
  {
    Object actual = null;

    try
    {
      actual = target.GetParentObjectByName( "Rechner" );
    }
    catch (XPathExpressionException e)
    {
      fail( e.getMessage() );
    }

    // Does the "Rechner" exists?
    Boolean object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner" );
    assertEquals( true, object_Exists );

    // We get the <<right>> object?
    Object expected = target.myFrameObjectDictionary.get( "Rechner" );

    assertEquals( expected.toString(), actual.toString() );

    assertEquals( expected, actual );
  }

  // / \brief
  // / A test for CreateInstanceByObjectName
  // /
  @Test
  public void GetObjectByName_WindowAndChild()
  {
    Object actual = null;

    try
    {
      actual = target.GetChildObjectByName( "Rechner", "Taste_3" );
    }
    catch (XPathExpressionException | IllegalArgumentException | IllegalAccessException e)
    {
      fail( e.getMessage() );
    }

    // Does the "Rechner" exists?
    Boolean object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner" );
    assertEquals( true, object_Exists );

    // Child is Also there?
    object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner.Taste_3" );
    assertEquals( true, object_Exists );

    // We get the <<right>> object?
    Object expected = target.myFrameObjectDictionary.get( "Rechner.Taste_3" );

    assertEquals( expected.toString(), actual.toString() );
    assertEquals( expected, actual );
  }

  // / \~german
  // / \brief
  // / Prüft die Initialisierung der Klasse FrameObjectDictionary.
  // /
  // / Vorgehen: Klasse wird im ersten Schritt mit Frames geladen,
  // /
  // / \~german
  // / \brief
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014-09-28
  @Test
  public void InitTest()
  {

    // ------------------------------------------------------------------------------------
    //
    // Frame laden.
    try
    {
      target.GetChildObjectByName( "Rechner", "Taste_3" );
    }
    catch (XPathExpressionException | IllegalArgumentException | IllegalAccessException e)
    {

      fail( e.getMessage() );
    }

    // Prüfen ob die erwarteten Elemente Rechner, Taste_3 vorhanden sind.
    // Does the "Rechner" exists?
    Boolean object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner" );
    assertEquals( true, object_Exists );

    // Is the Child also there?
    object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner.Taste_3" );
    assertEquals( true, object_Exists );

    // ------------------------------------------------------------------------------------
    // Nach der Initialisiserung müssen die Objekte "Rechner" und Taste_3
    // erneut existieren.
    try
    {
      target.Init();
    }
    catch (Exception e)
    {

      fail( e.getMessage() );
    }

    object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner" );
    assertEquals( true, object_Exists );

    // Is the Child also there?
    object_Exists = target.myFrameObjectDictionary.containsKey( "Rechner.Taste_3" );
    assertEquals( true, object_Exists );
  }

  // / \~german
  // / \brief
  // / Prüft ob eine OKWFrameObjectWindowNotFoundException ausgelöst wird,
  // wenn das Fensterobjekt nicht existiert.
  // /
  // / Bedingung für das auslösen:
  // / -# Das Fenster-Objekt _existiert nicht_.
  // /
  // / Das Kind-Objekt wird als parameter nicht angegeben.
  // /
  // /
  // / \~german
  // / \brief
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014-09-28
  @Test
  public void TC_CreatInstanceByObjectName_OKWFrameObjectWindowNotFoundException_1()
  {
    try
    {
      target.GetParentObjectByName( "RechnerNotExists" );
      fail();

    }
    catch (OKWFrameObjectParentNotFoundException e)
    {
      Logger_Sngltn.getInstance().LogPrint( "OKWFrameObjectParentNotFoundException wurde ausgelöst, das ist für diesen Test OK!" );
    }
    catch (Exception e)
    {
      Logger_Sngltn.getInstance().LogPrint( "Exception: " + e.getClass().getName() );
      Logger_Sngltn.getInstance().LogPrint( "Nachricht: " + e.getMessage() );
      fail( "Falsche Exception: " + e.getMessage() );
    }
  }

  // / \~german
  // / \brief
  // / Prüft ob eine OKWFrameObjectWindowNotFoundException ausgelöst wird,
  // wenn das Fensterobjekt nicht existiert.
  // /
  // / Bedingung für das auslösen:
  // / -# Das Fenster-Objekt _existiert nicht_.
  // / -# Das Kind-Objekt _existiert_ dann auch _nicht_.
  // /
  // / Das Kind-Objekt wird als parameter nicht angegeben.
  // /
  // /
  // / \~german
  // / \brief
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014-09-28
  @Test
  public void TC_CreatInstanceByObjectName__OKWFrameObjectWindowNotFoundException()
  {

    try
    {
      target.GetChildObjectByName( "RechnerNotExists", "Taste_3" );
      fail();

    }
    catch (OKWFrameObjectChildNotFoundException e)
    {
      Logger_Sngltn.getInstance().LogPrint( "OKWFrameObjectChildNotFoundException wurde ausgelöst, das ist für diesen Test OK!" );
    }
    catch (Exception e)
    {
      Logger_Sngltn.getInstance().LogPrint( "Exception: " + e.getClass().getName() );
      Logger_Sngltn.getInstance().LogPrint( "Nachricht: " + e.getMessage() );
      fail( "Falsche Exception: " + e.getMessage() );
    }
  }

  // / \~german
  // / \brief
  // / Prüft ob eine OKWFrameObjectChildNotFoundException ausgelöst wird
  // /
  // / Bedingung für das auslösen:
  // / -# Das Fenster-Objekt _existiert_.
  // / -# Das Kind-Objekt _existiert nicht_.
  // /
  // /
  // /
  // / \~german
  // / \brief
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014-09-28
  @Test
  public void TC_CreatInstanceByObjectName_OKWFrameObjectChildNotFoundException()
  {

    try
    {
      target.GetChildObjectByName( "Rechner", "TasteNotExists" );
      fail();
    }
    catch (OKWFrameObjectChildNotFoundException e)
    {
      Logger_Sngltn.getInstance().LogPrint( "OKWFrameObjectChildNotFoundException wurde ausgelöst, das ist für diesen Test OK!" );
    }
    catch (Exception e)
    {
      Logger_Sngltn.getInstance().LogPrint( "Exception: " + e.getClass().getName() );
      Logger_Sngltn.getInstance().LogPrint( "Nachricht: " + e.getMessage() );
      fail( "Falsche Exception: " + e.getMessage() );
    }
  }
}
