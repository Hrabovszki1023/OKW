/**
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
      www.OpenKeyWord.de
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
    along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

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

package okw.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.LogMessenger;
import okw.OKW;
import okw.OKW_Helper;
import okw.exceptions.*;
import okw.log.*;

/**
 * \~german \brief Diese Klasse verwaltet das aktuelle GUI-Objekt.
 * 
 * Jedes technische GUI-Objekt, wobei es unerheblich ist, wie tief diese
 * technisch ineinander verschachtelt sind, wird mit maximal zwei Angaben
 * referenziert: **Fenstername** und **Kindobjektname**
 * 
 * __Design-Pattern:__ Singleton - Highlander-Prinzip
 *
 * \~english \brief This class administrates the actual GUI-Object.
 * 
 * Each technical GUI-Object, irrelevant how deep they are nested into each
 * other technically, will be referenced with two informations: **WindowName**
 * und **ChildObjectName**
 * 
 * __Design-Pattern:__ Singleton - Highlander-Principle
 *
 * \~ \author Zoltan Hrabovszki \date 2012.11.01
 */
public class OKW_CurrentObject_Sngltn
{

  /**
   * \~german \brief Die Eigenschaft enthält den fachlichen Namen des aktuellen
   * Kindobjektes.
   *
   * Auf dieses Kindobjekt beziehen sich alle GUI Kind-Objekte, die unter
   * 'sNameChildObject' gegeben sind. \todo TODO: ZH: Weitergehende Beschreibung
   * Prüfen.
   *
   * \~english \brief The feature contains the professional name of the current
   * child Object.
   *
   * All GUI child Objects are relating to this ChildObject, given under
   * 'sNameChildObject'.
   *
   */
  protected String             cvsChildFN              = "";

  /**
   * \~german \brief Eigenschaft enthält den fachlichen Namen des aktuellen
   * Fensters. Auf dieses Fenster beziehen sich alle GUI Kind-Objekte, die mit
   * "cvsChildName" gegeben sind.
   *
   *
   * \~english \brief The feature contains the professional name of the current
   * window.<br/>
   * All GUI child Objects are relating to this window given mit "cvsChildName".
   */
  protected String             cvsWindowFN             = "";

  /**
   * \~german \brief Das Feld cvoObject enthält die Referenzierung auf das
   * aktuelle Objekt im OKW_FrameObjectDictionary "myFrameObjectDictionary".
   *
   *
   * \~english \brief The field cvoObject contains the reference of the current
   * Object in OKW_FrameObjectDictionary "myFrameObjectDictionary".
   */
  private Object               cvoObject               = null;

  /**
   * \~german \brief Vollständiger "funktionaler Name" des aktuellen Objektes
   * "WindowName.ChildObjectName" * "Login" ist ein FensterObjekt. *
   * "Login.User" als Referenz auf das Kindobjekt "User" des Fensters "Login"
   *
   *
   * \~english \brief Complete "functional name" of the current Object
   * "WindowName.ChildObjectName" * "Login" is a WindowObject * "Login.User" as
   * reference to the child Object "User" of the window "Login"
   */
  private String               cvsObjectFN             = "";

  /**
   * \~german \brief Vollständiger "technischer Name" des aktuellen Objektes
   * "WindowName.ChildObjectName" * "frm_Login" ist ein FensterObjekt. *
   * "Frm_Login.User" als Refernz auf das Kindobjekt "User" des fachlichen
   * Fensters "Login"
   *
   *
   * \~english \brief Full "technical name" of the current Object
   * "WindowsName.ChildObject.Name" * "frm_Login" is a WindowObject. *
   * "frm_Login.User" as reference to the child Object "User" of the
   * professional window "Login"
   */
  private String               cvsObjectName           = "";

  /**
   * \~german \brief Hält eine Referenz auf die Klasse LogMessenger für die
   * sprachabhängige Log-Ausgabe vor.
   *
   * Diese Variable wird im Konstruktor initialisiert.
   *
   * \remark Die Datei mit den Sprachabhängigen Log-Ausgaben zu dieser Klasse
   * ist: <tt>/XML/Log/CurrentObject.xml</tt>
   *
   *
   * \~english \brief \todo TODO: für JN review
   */
  private LogMessenger         LM                      = null;

  /**
   * \~german \brief Hält eine Referenz auf die Klasse Logger vor.
   *
   *
   * \~english \brief \todo TODO: Translation to english
   */
  private Logger_Sngltn        Log                     = Logger_Sngltn.getInstance();

  /**
   * \~german \brief Diese Übersicht enthält alle besuchten/ genutzten
   * "Frame Objects".
   *
   * Wichtig: Die "Frame Klasse" muss mit "using" einbezogen werden Arbeiten in
   * einer automatisierten Klasse: Es wird die richtige Klasse bei Eingabe des
   * Frame Objektes ausgegeben. Eigenschaft enthält die Referenzierung auf das
   * aktuelle Fenster- oder Kindobjekt.
   *
   *
   * \~english \brief This Dictionary holds all visited/used "Frame Objects".
   *
   * Important: The Frame-Class Must be included with "using" Works in an
   * automatized call: The right class is given after input of the frame Object
   * Function contains the reference to the current window or child Object
   */
  FrameObjectDictionary_Sngltn myFrameObjectDictionary = null;

  /**
   * \~german \brief Initialisiert eine neue Instanz der <see
   * cref="OKW.CurrentObject"/> Klasse Nicht öffentlicher Konstruktor: Verwenden
   * Sie <see cref="OKW.CurrentObject.Instance"/> um die Instanz dieser Klasse
   * zu erhalten
   *
   *
   * \~english \brief Initializes a new instance of the <see
   * cref="OKW.CurrentObject"/> class. No public constructor: Use the <see
   * cref="OKW.CurrentObject.Instance"/> to obtain the instance of this class
   *
   *
   * \~ \author Zoltan Hrabovszki \date 2012.12.02
   */
  private OKW_CurrentObject_Sngltn() throws JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException
  {
    Init();
  }

  /**
   * \~german \brief Gibt die Instanz für die einzige Instanz dieser Klasse
   * zurück.<br/>
   * __Hinweis:__ * Diese Klasse ist ein Singleton. - Highlander Prinzip: Es
   * kann nur eine Instanz von dieser Klasse geben! - Verwenden Sie diese
   * Eigenschaft um die Instanz dieser Klasse zu erhalten. - Es gibt keinen
   * öffentlichen Konstruktor für diese Methode!
   *
   *
   * \~english \brief Returns the Instance for the only Instance of this class.<br/>
   * __Remark:__ * This class is a Singleton. - Highlander Principle: There only
   * can be one instance of this class! - Use this function to obtain the
   * instance of this class. - There is no public constructor for this method!
   *
   * <value> The instance of CurrentObject. </value>
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.29
   */
  private static OKW_CurrentObject_Sngltn Instance;

  public static OKW_CurrentObject_Sngltn getInstance() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
  {
    // Lazy Initialization (If required then only)
    if ( Instance == null )
    {
      // Thread Safe. Might be costly operation in some case
      synchronized ( OKW_CurrentObject_Sngltn.class )
      {
        if ( Instance == null )
        {
          Instance = new OKW_CurrentObject_Sngltn();
        }
      }
    }
    return Instance;
  }

  private static Integer CalculateLoopCount( Integer SleepForInMillis, Integer MaxWaitInSeconds )
  {
    Integer lviReturn = MaxWaitInSeconds * 1000 / SleepForInMillis;

    return lviReturn;
  }

  //
  // \~german
  // \brief Ruft eine Methode des Objektes FN via "late bound function call" auf.
  //
  // Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type  | 
  // | :----------------|:------|
  // | Parameter        | keine | 
  // | Rückgabewert     | kein  |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll.
  //
  // \~english \brief Calls a method of the current Object with
  // "late bound function call".
  //
  // The called method has the signature:
  //
  // | Parameter/Return | Type  |
  // | :----------------|:------| 
  // | Parameter        | none  | 
  // | Return           | none  |
  //
  // \param fpsMethod name of method to be called.
  //
  // \~
  // \author Zoltan Hrabovszki \date 2014.01.14
  //
  public void CallParentMethod( String FN, String fpsMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod );

    this.SetWindowName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;

    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( fpsMethod );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Dann 2. Versuch: Schauen wir in die Superklasse...

      try
      {
        myMethod = myFrame_Class.getSuperclass().getDeclaredMethod( fpsMethod );
        myMethod.invoke( cvoObject );
      }
      catch (NoSuchMethodException | SecurityException e1)
      {
        // Existiert die Methode des Objektes?
        // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
        // aussteigen...
        String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
        throw new OKWFrameObjectMethodNotFoundException( errorText );
      }
      catch (Exception e2)
      {
        String myMessage = e2.getMessage();
        System.out.println( myMessage );
      }

    }
    catch (Exception e)
    {
      String myMessage = e.getMessage();
      System.out.println( myMessage );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }
  
  
  //
  // \~german
  // \brief Ruft eine Methode des Objektes FN via
  // "late bound function call" auf.
  //
  // Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type  | 
  // | :----------------|:------|
  // | Parameter        | keine | 
  // | Rückgabewert     | kein  |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll.
  //
  // \~english \brief Calls a method of the current Object with
  // "late bound function call".
  //
  // The called method has the signature:
  //
  // | Parameter/Return | Type  |
  // | :----------------|:------| 
  // | Parameter        | none  | 
  // | Return           | none  |
  //
  // \param fpsMethod name of method to be called.
  //
  // \~
  // \author Zoltan Hrabovszki \date 2014.01.14
  //
  public void CallMethod( String FN, String fpsMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;

    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( fpsMethod );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Dann 2. Versuch: Schauen wir in die Superklasse...

      try
      {
        myMethod = myFrame_Class.getSuperclass().getDeclaredMethod( fpsMethod );
        myMethod.invoke( cvoObject );
      }
      catch (NoSuchMethodException | SecurityException e1)
      {
        // Existiert die Methode des Objektes?
        // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
        // aussteigen...
        String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
        throw new OKWFrameObjectMethodNotFoundException( errorText );
      }
      catch (Exception e2)
      {
        String myMessage = e2.getMessage();
        System.out.println( myMessage );
      }

    }
    catch (Exception e)
    {
      String myMessage = e.getMessage();
      System.out.println( myMessage );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:------| | Parameter |
   * keine | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:------| | Parameter | none
   * | | Return | none |
   *
   * \param fpsMethod name of method to be called.
   *
   * \~ \author Zoltan Hrabovszki \date 2014.01.14
   */
  public void ClickON( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String FN", FN );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;

    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( "ClickON" );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Dann 2. Versuch: Schauen wir in die Superklasse...

      try
      {
        myMethod = myFrame_Class.getSuperclass().getDeclaredMethod( "ClickON" );
        myMethod.invoke( cvoObject );
      }
      catch (NoSuchMethodException | SecurityException e1)
      {
        // Existiert die Methode des Objektes?
        // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
        // aussteigen...
        String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "ClickON" );
        throw new OKWFrameObjectMethodNotFoundException( errorText );
      }
      catch (Exception e2)
      {
        String myMessage = e2.getMessage();
        System.out.println( myMessage );
      }

    }
    catch (Exception e)
    {
      String myMessage = e.getMessage();
      System.out.println( myMessage );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  //
  // \~german \brief Ruft eine Methode des aktuellen Objektes via "late bound function call" auf.
  //
  // Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type | 
  // | :----------------|:-------------|
  // | Parameter        | List &lt; String &gt; |
  // | Rückgabewert     | kein |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll. 
  // \param fpLsParameter 1. Parameter als List-String.
  //
  // \~english
  // \brief Calls a method of the current Object with
  // "late bound function call".
  //
  // The called method has the signature:
  //
  // | Parameter/Return | Type                 |
  // | :----------------|:---------------------|
  // | Parameter        | List&lt; String &gt; |
  // | Return           | none |
  //
  // \param fpsMethod name of method to be called.
  // \param fpLsParameter 1st parameter as list-String.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2016.10.13
  public void CallParentMethod( String FN, String fpsMethod, ArrayList<String> fpLsParameter ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "ArrayList<String> fplsParameter", fpLsParameter.toString() );

    Class<?>[] paramTypes = { ArrayList.class };

    this.SetWindowName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpLsParameter );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }

    return;
  }
  
  /*
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | List &lt; String &gt; | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpLsParameter 1. Parameter als List-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | List&lt; String &gt; | | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpLsParameter 1st
   * parameter as list-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2014.01.14
   */
  public void CallMethod( String FN, String fpsMethod, ArrayList<String> fpLsParameter ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "ArrayList<String> fplsParameter", fpLsParameter.toString() );

    Class<?>[] paramTypes = { ArrayList.class };

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpLsParameter );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }

    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | List&lt; String&gt; | | 2. Parameter | String | | Rückgabewert
   * | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpLsParameter_1 1. Parameter als List-String. \param fpsParameter_2 2.
   * Parameter als List-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The calles Object has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | List&lt; String &gt; | | 2nd Parameter | String | | Return |
   * none |
   *
   * \param fpsMethod name of method to be called. \param fpLsParameter_1 1st
   * parameter as list-String. \param fpsParameter_2 2nd parameter as
   * list-String. \~ \author Zoltan Hrabovszki \date 2014.01.14
   */
  public void CallMethod( String FN, String fpsMethod, ArrayList<String> fpLsParameter_1, String fpsParameter_2 ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "ArrayList<String> fpLsParameter_1", fpLsParameter_1.toString(),
            "String fpsParameter_2", fpsParameter_2 );

    Class<?>[] paramTypes = { ArrayList.class, String.class };

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpLsParameter_1, fpsParameter_2 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }

    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als Type-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpsParameter_1 1st
   * parameter as type-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public void CallMethod( String FN, String fpsMethod, String fpsParameter_1 ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "String fps_Parameter_1", fpsParameter_1 );

    Class<?>[] paramTypes = { String.class };

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getDeclaredMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpsParameter_1 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | 2. Parameter | String | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als Type-String. \param fpsParameter_2 2.
   * Parameter als Type-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | 2nd Parameter | String | | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpsParameter_1 1st
   * parameter as type-String. \param fpsParameter_2 2nd parameter as
   * type-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @Deprecated
  public void CallMethod( String FN, String fpsMethod, String fpsParameter_1, String fpsParameter_2 ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "String fps_Parameter_1", fpsParameter_1, "String fps_Parameter_2", fpsParameter_2 );

    Class<?>[] paramTypes = { String.class, String.class };

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpsParameter_1, fpsParameter_2 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | 2. Parameter | String | | 3. Parameter | String | |
   * Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als Type-String. \param fpsParameter_2 2.
   * Parameter als Type-String. \param fpsParameter_3 3. Parameter als
   * Type-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | 2nd Parameter | String | | 3rd Parameter | String |
   * | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpsParameter_1 1st
   * paramarameter as type-String. \param fpsParameter_2 2nd parameter as
   * type-String. \param fpsParameter_3 3rd parameter as type-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @Deprecated
  public void CallMethod( String FN, String fpsMethod, String fpsParameter_1, String fpsParameter_2, String fpsParameter_3 ) throws IllegalAccessException,
          IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "String fpsParameter_1", fpsParameter_1, "String fpsParameter_2", fpsParameter_2,
            "String fpsParameter_3", fpsParameter_3 );

    Class<?>[] paramTypes = { String.class, String.class, String.class };
    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpsParameter_1, fpsParameter_2, fpsParameter_3 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }

    return;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | 2. Parameter | String | | 3. Parameter |
   * List&lt;String&gt; | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als Type-String. \param fpsParameter_2 2.
   * Parameter als Type-String. \param fpLsValue 3. Parameter als
   * Type-List&lt;String&gt;.
   *
   * \~english \brief Calls the method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | 2nd Parameter | String | | 3rd Parameter |
   * List&lt;String&gt; | | Return | none |
   *
   * \param fpsMethod name of the method to be called. \param fpsParameter_1 1st
   * parameter as type-String. \param fpsParameter_2 2nd parameter as
   * type-String. \param fpLsValue 3rd parameter as type-List&lt;String&gt;.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public void CallMethod( String FN, String fpsMethod, String fpsParameter_1, String fpsParameter_2, ArrayList<String> fpLsValue ) throws IllegalAccessException,
          IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "CallMethod", "String fpsMethod", fpsMethod, "String fpsParameter_1", fpsParameter_1, "String fpsParameter_2", fpsParameter_2,
            "String fpsLValue", fpLsValue.toString() );

    Class<?>[] paramTypes = { String.class, String.class, ArrayList.class };

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      myMethod.invoke( cvoObject, fpsParameter_1, fpsParameter_2, fpLsValue );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }


  // \~german \brief Ruft eine Methode des aktuellen Objektes via
  // "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Rückgabewert | Boolean |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll. \return
  // Rückgabewert ist vom Typ Boolean.
  //
  // \~english \brief Calls a method of the current Object
  // "late bound function call". The called method has the signature:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Return | Boolean |
  //
  // \param fpsMethod Name of the method to be called. \return Result is a
  // Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  //
  public Boolean LogExists( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "LogExists", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "LogExists", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "LogExist" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }

  // \~german
  // \brief  Ruft die Methode MemorizeExists(FN) des aktuellen GUI-Objektes via
  // "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ Boolean.
  //
  // \~english 
  // \brief Calls the method MemorizeExists(FN) of the current GUI-Object
  // "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  public Boolean MemorizeExists( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "MemorizeExists", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "MemorizeExists", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "MemorizeExists" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }


  // \~german
  // \brief  Ruft die Methode MemorizeHasFocus(FN) des aktuellen GUI-Objektes via "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ Boolean.
  //
  // \~english 
  // \brief Calls the method MemorizeHasFocus(FN) of the current GUI-Object "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a Boolean type.
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  public Boolean MemorizeHasFocus( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "MemorizeExists", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "MemorizeExists", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "MemorizeExists" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }


  // \~german
  // \brief  Ruft die Methode MemorizeIsActive(FN) des aktuellen GUI-Objektes via "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ Boolean.
  //
  // \~english 
  // \brief Calls the method MemorizeIsActive(FN) of the current GUI-Object "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a Boolean type.
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  public Boolean MemorizeIsActive( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "MemorizeIsActive", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "MemorizeIsActive", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "MemorizeIsActive" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }

  
  // \~german \brief Ruft eine Methode des aktuellen Objektes via
  // "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Rückgabewert | Boolean |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll. \return
  // Rückgabewert ist vom Typ Boolean.
  //
  // \~english \brief Calls a method of the current Object
  // "late bound function call". The called method has the signature:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Return | Boolean |
  //
  // \param fpsMethod Name of the method to be called. \return Result is a
  // Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  //
  public Boolean LogHasFocus( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "LogHasFocus", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "LogHasFocus", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "LogHasFocus" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }
  
  
  // \~german \brief Ruft eine Methode des aktuellen Objektes via
  // "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Rückgabewert | Boolean |
  //
  // \param fpsMethod Name der Methode, die aufgerufen werden soll. \return
  // Rückgabewert ist vom Typ Boolean.
  //
  // \~english \brief Calls a method of the current Object
  // "late bound function call". The called method has the signature:
  //
  // | Parameter/Return | Type | | :----------------|:-------------| | Parameter
  // | keine | | Return | Boolean |
  //
  // \param fpsMethod Name of the method to be called. \return Result is a
  // Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  //
  public Boolean LogIsActive( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "LogIsActive", "String", FN );

    Class<?>[] paramTypes = {};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "LogIsActive", paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "LogIsActive" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }
  
  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | 2. Parameter | Boolean | | Rückgabewert | Boolean |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpbParameter_1 2. Parameter als Type-Boolean. \return Rückgabewert ist vom
   * Typ Boolean.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | 2nd Parameter | Boolean | | Return | Boolean |
   *
   * \param fpsMethod Name of the method to be called. \param fpbParameter_1 2nd
   * parameter as a Boolean type. \return Return is a Boolean type.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @Deprecated
  public Boolean CallMethodReturn_BooleanPb( String fpsMethod, Boolean fpbParameter_1 ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Boolean lvbReturn = false;

    Log.LogFunctionStartDebug( "CallMethodReturn_BooleanPb", "String fpsMethod", fpsMethod, "Boolean fpsParameter_1", fpbParameter_1.toString() );

    Class<?>[] paramTypes =
    { Boolean.class };

    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvbReturn = ( Boolean ) myMethod.invoke( cvoObject, fpbParameter_1 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug( lvbReturn );
    }
    return lvbReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyExists des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  public Boolean VerifyExists( String FN, Boolean fpbExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyExists_PT = 1000;
    Integer VerifyExists_TO = 30;

    Boolean lvbReturn = false;
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyExists", "String", "FN", "Boolean fpbExpectedValues", fpbExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyExists" );

      VerifyExists_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyExists_PT();
      VerifyExists_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyExists_TO();

      Log.LogPrintDebug("VerifyExists_PT: " + VerifyExists_PT.toString() );
      Log.LogPrintDebug("VerifyExists_TO: " + VerifyExists_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyExists_PT, VerifyExists_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );

        if ( fpbExpectedValues.equals( lvbReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyExists_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyExists()" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvbReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvbReturn;
  }

  
  /**
   * \~german \brief Ruft eine Methode VerifyHasFocus des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  public Boolean VerifyHasFocus( String FN, Boolean fpbExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyHasFocus_PT = 1000;
    Integer VerifyHasFocus_TO = 30;

    Boolean lvbReturn = false;
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyHasFocus", "String", "FN", "Boolean fpbExpectedValues", fpbExpectedValues.toString() );
    
    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyHasFocus" );

      VerifyHasFocus_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyHasFocus_PT();
      VerifyHasFocus_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyHasFocus_TO();

      Log.LogPrintDebug("VerifyExists_PT: " + VerifyHasFocus_PT.toString() );
      Log.LogPrintDebug("VerifyExists_TO: " + VerifyHasFocus_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyHasFocus_PT, VerifyHasFocus_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );

        if ( fpbExpectedValues.equals( lvbReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyHasFocus_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyHasFocus()" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvbReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvbReturn;
  }

  
  public Boolean VerifyIsActive( String FN, Boolean fpbExpectedValues ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyIsActive_PT = 1000;
    Integer VerifyIsActive_TO = 30;

    Boolean lvbReturn = false;
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyIsActive", "String", "FN", "Boolean fpbExpectedValues", fpbExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyIsActive" );

      VerifyIsActive_PT = ( ( Field ) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN ) ).getAnnotation( OKW.class ).VerifyIsActive_PT();
      VerifyIsActive_TO = ( ( Field ) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN ) ).getAnnotation( OKW.class ).VerifyIsActive_TO();

      Log.LogPrintDebug( "VerifyExists_PT: " + VerifyIsActive_PT.toString() );
      Log.LogPrintDebug( "VerifyExists_TO: " + VerifyIsActive_TO.toString() );

      MaxCount = CalculateLoopCount( VerifyIsActive_PT, VerifyIsActive_TO );
      Count = 0;

      Log.LogPrintDebug( "MaxCount: " + MaxCount.toString() );

      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug( "  Count: " + Count.toString() );
        lvbReturn = ( Boolean ) myMethod.invoke( cvoObject );

        if ( fpbExpectedValues.equals( lvbReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyIsActive_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyIsActive()" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvbReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvbReturn;
  }

  
  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | keine | | Rückgabewert | int |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \return
   * Rückgabewert ist vom Typ int.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | none | | Return | int |
   *
   * \param fpsMethod Name of the method to be called. \return Return is an int
   * type.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @Deprecated
  public int CallMethodReturn_Int( String fpsMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Integer lviReturn = 0;
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CallMethodReturn_Int", "String fpsMethod", fpsMethod );

    Class<?>[] paramTypes =
    {};

    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lviReturn = ( Integer ) myMethod.invoke( cvoObject );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lviReturn.toString() );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lviReturn;

  }

  // \~german
  // \brief  Ruft die Methode LogCaption(FN) des aktuellen GUI-Objektes via
  // "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ List&lt;String&gt;.
  //
  // \~english 
  // \brief Calls the method LogCaption(FN) of the current GUI-Object
  // "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a List&lt;String&gt; type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> CallMethodReturn_ListString( String FN, String fpsMethodName ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;
    Log.LogFunctionStartDebug( fpsMethodName, "String", FN );

    Class<?>[] paramTypes ={};

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethodName, paramTypes );
      lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethodName );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }
  
  
  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | 2. Parameter | String | | Rückgabewert |
   * List&lt;String&gt; |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParam1 1. Parameter als Type-String. \param fpsParam2 2. Parameter als
   * Type-String. \return List&lt;String&gt;.
   *
   * \~english \brief Calls a method of the current Object
   * "late bound function call". The calles method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | 2nd Parameter | String | | Return |
   * List&lt;String&gt; |
   *
   *
   * \param fpsMethod Name of the method to be called \param fpsParam1 1st
   * paramarameter as type-String. \param fpsParam2 2nd parameter as
   * type-String. \return List&lt;String&gt; .
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  @Deprecated
  public ArrayList<String> CallMethodReturn_ListString( String fpsMethod, String fpsParam_1, String fpsParam_2 ) throws IllegalAccessException,
          IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "CallMethodReturn_ListString", "String fpsMethod", fpsMethod, "String fpsParam_1", fpsParam_1, "String fpsParam_2", fpsParam_2 );

    Class<?>[] paramTypes =
    { String.class, String.class };
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject, fpsParam_1, fpsParam_2 );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "latebound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpLsParameter_1 1. Parameter als List&lt;String&gt;. \return
   * List&lt;String&gt; .
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1st
   * Parameter | List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   * \param fpsMethod Name of the method to be called \param fpLsParameter_1 1st
   * parameter as list&lt;String&gt;. \return List&lt;String&gt; .
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  @Deprecated
  public ArrayList<String> CallMethodReturn_ListString( String fpsMethod, ArrayList<String> fpLsParameter_1 ) throws IllegalAccessException,
          IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "CallMethodWithReturn", "String fpsMethod", fpsMethod, "ArrayList<String> fpLsParameter_1", fpLsParameter_1.toString() );

    Class<?>[] paramTypes =
    { ArrayList.class };
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject, fpLsParameter_1 );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | String | | 2. Parameter | String | | 3. Parameter |
   * List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als String. \param fpsParameter_2 2. Parameter
   * als String. \param fpLsParameter_3 3. Parameter als List&lt;String&gt;.
   * \return List&lt;String&gt; .
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1st
   * Parameter | String | | 2nd Parameter | String | | 3rd Parameter |
   * List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   * \param fpsMethod Name of the method to be called \param fpsParameter_1 1st
   * parameter as String. \param fpsParameter_2 2nd parameter as String. \param
   * fpLsParameter_3 3rd parameter as list&lt;String&gt;. \return
   * List&lt;String&gt; .
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  @Deprecated
  public ArrayList<String> CallMethodReturn_ListString( String fpsMethod, String fpsParameter_1, String fpsParameter_2, ArrayList<String> fpLsParameter_3 )
          throws Exception, SecurityException
  {
    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "CallMethodReturn_ListString", "String fpsMethod", fpsMethod, "String fpsParam1", fpsParameter_1, "String fpsParameter_2",
            fpsParameter_2, "ArrayList<String> fpLsParameter_3", fpLsParameter_3.toString() );

    Class<?>[] paramTypes =
    { String.class, String.class, ArrayList.class };
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject, fpsParameter_1, fpsParameter_2, fpLsParameter_3 );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = this.LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| |
   * Parameter | keine | | Rückgabewert | String |
   *
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \return
   * String.
   *
   * \~english \brief Calls a method of the current Object
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| |
   * Parameter | none | | Return | String |
   *
   *
   * \param fpsMethod Name of the method to be called. \return String.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  @Deprecated
  public String CallMethodReturn_String( String fpsMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    String lvsReturn = "";
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "CallMethodWithReturn", "String fpsMethod", fpsMethod );

    Class<?>[] paramTypes =
    {};
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvsReturn = ( String ) myMethod.invoke( cvoObject );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | String | | Rückgabewert | String |
   *
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als String. \return String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1st
   * Parameter | String | | Return | String |
   *
   *
   * \param fpsMethod Name of the method to be called. \param fpsParameter_1 1st
   * parameter as String. \return String.
   *
   * \~ \author Zoltan Hrabovszki \date 2013.05.17
   */
  @Deprecated
  public String CallMethodReturn_String( String fpsMethod, String fpsParameter_1 ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    String lvsReturn = "";
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "CallMethodWithReturn", "String fpsMethod", fpsMethod, "String fpsParameter_1", fpsParameter_1 );

    Class<?>[] paramTypes =
    { String.class };
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( fpsMethod, paramTypes );
      lvsReturn = ( String ) myMethod.invoke( cvoObject, fpsParameter_1 );
      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethod );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvsReturn;
  }

  // \~german
  // \brief  Ruft die Methode ClickOn( ) des aktuellen GUI-Objektes via
  // "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ Boolean.
  //
  // \~english 
  // \brief Calls the method ClickOn( ) of the current GUI-Object
  // "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  public void ClickOn( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "ClickOn", "String", FN );
  
    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;
  
    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( "ClickOn" );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Dann 2. Versuch: Schauen wir in die Superklasse...
  
      try
      {
        myMethod = myFrame_Class.getSuperclass().getDeclaredMethod( "ClickOn" );
        myMethod.invoke( cvoObject );
      }
      catch (NoSuchMethodException | SecurityException e1)
      {
        // Existiert die Methode des Objektes?
        // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
        // aussteigen...
        String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "ClickOn" );
        throw new OKWFrameObjectMethodNotFoundException( errorText );
      }
      catch (Exception e2)
      {
        String myMessage = e2.getMessage();
        System.out.println( myMessage );
      }
  
    }
    catch (Exception e)
    {
      String myMessage = e.getMessage();
      System.out.println( myMessage );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  
  // \~german
  // \brief  Ruft die Methode ClickOn( ) des aktuellen GUI-Objektes via
  // "late bound function call" auf.
  //
  // \param FN  Funktionlare Name des GUI-Objektes
  // \return Rückgabewert ist vom Typ Boolean.
  //
  // \~english 
  // \brief Calls the method ClickOn( ) of the current GUI-Object
  // "late bound function call".
  //
  // \param fpsMethod Name of the method to be called.
  // \return Result is a Boolean type.
  //
  // \~ 
  // \author Zoltan Hrabovszki
  // \date 2012.11.01
  public void DoubleClickOn( String FN ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "DoubleClickOn" );
  
    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;
  
    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( "DoubleClickOn" );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Dann 2. Versuch: Schauen wir in die Superklasse...
  
      try
      {
        myMethod = myFrame_Class.getSuperclass().getDeclaredMethod( "DoubleClickOn" );
        myMethod.invoke( cvoObject );
      }
      catch (NoSuchMethodException | SecurityException e1)
      {
        // Existiert die Methode des Objektes?
        // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
        // aussteigen...
        String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "DoubleClickOn" );
        throw new OKWFrameObjectMethodNotFoundException( errorText );
      }
      catch (Exception e2)
      {
        String myMessage = e2.getMessage();
        System.out.println( myMessage );
      }
  
    }
    catch (Exception e)
    {
      String myMessage = e.getMessage();
      System.out.println( myMessage );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  
  
  /**
   * \~german \brief Liefert die Referenz zum aktuellen Frame-Object. Referenz
   * ist im Feld cvoObject abgelegt.
   *
   * \return Die Referenz auf das auf das aktuelle GUI-Object.
   *
   * \~english \brief Gives the reference to the current Frame-Object. Reference
   * is stored in the field cvoObject.
   *
   * \return Reference to the current GUI-Object.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public Object GetCurrentObject()
  {
    Object lvoReturn = new Object();
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CurrentObject.GetCurrentObject" );
    try
    {
      lvoReturn = this.cvoObject;
      bOK = true;
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( this.cvoObject.getClass().getName() );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvoReturn;
  }

  /**
   * \~german \brief Ermittelt den ObjektNamen des aktuellen Objektes.
   *
   * \return Liefert den Objektnamen in der Form "WindowName.ChildName" oder
   * "WindowName".
   *
   * \~english \brief Detecting the ObejctName of the current Object
   *
   * \return Gives the ObjectName in the form "WindowName.ChildName" or
   * "WindowName".
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public String GetObjectFN()
  {
    String lvsReturn = "";
    ;
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CurrentObject.GetObjectName" );
    try
    {
      lvsReturn = this.cvsObjectFN;
      bOK = true;
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvsReturn;
  }

  /**
   * \~german \brief Führt die Initialisierung der Klasse durch: Es werden alle
   * Felder der Klasse auf einen definierten Anfangszustand zurükgesetzt;
   *
   *
   * \~english \brief Running the initializing of the class: There are all
   * fields of the class set to a defined initial state.
   *
   *
   * \~ \author Zoltan Hrabovszki \date 2012.12.15
   */
  public void Init() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
  {
    Log.LogFunctionStartDebug( "CurrentObject.Init" );
    try
    {
      this.LM = new LogMessenger( "OKW_CurrentObject" );
      this.cvoObject = null;
      this.cvsWindowFN = "";
      this.cvsObjectName = "";
      this.myFrameObjectDictionary = null;
      this.myFrameObjectDictionary = FrameObjectDictionary_Sngltn.getInstance();
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  
  /**
   * \~german \brief Methode gibt alle wichtigen Informationen zum aktuellen
   * Objekt aus. Diese soll im Fehler- oder Ausnahmefall bei der Fehlersuche
   * durch Ausgabe der aktuellen Objektdaten helfen. <br/>
   * Diese Daten werden ausgegeben: * Window Name: cvsWindowName * Name des
   * Kindes: cvsChildName * Objektklasse: this.cvoObject.getClass().Name *
   * Voller Name des Objektes: cvsObjectName
   *
   * \note Methode wird während der Ausnahmebehandlung aufgerufen.
   *
   * \~english \brief Method returns all the important information about the
   * current Object. This should help in error or exception when debugging by
   * outputting the current data Object.<br/>
   * These data will be returned: * Window Name: cvsWindowName * Name of Child:
   * cvsChildName * Class of Object: this.cvoObject.getClass().Name * Fullname
   * of Object: cvsObjectName
   *
   * \note Method is called during exception handling.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public void LogObjectData()
  {
    Log.LogFunctionStartDebug( "CurrentObject.LogObjectData" );
    try
    {
      Log.ResOpenList( "Object Data:" );
      Log.LogPrint( this.LM.GetMessage( "LogObjectData", "WindowName", this.cvsWindowFN ) );
      Log.LogPrint( this.LM.GetMessage( "LogObjectData", "ChildWindowName", this.cvsChildFN ) );
      Log.LogPrint( this.LM.GetMessage( "LogObjectData", "Class of Object", this.cvoObject.getClass().getSimpleName() ) );
      Log.LogPrint( this.LM.GetMessage( "LogObjectData", "FullNameOfObject", this.cvsObjectName ) );
    }
    catch (Exception e)
    {
      Log.LogPrint( e.getMessage() );
    }
    finally
    {
      Log.ResCloseList();
    }
    Log.LogFunctionEndDebug();
  }

  
  /**
   * \~german \brief Setzt das Kindobjekt.
   *
   * \return Liefert die Objektreferenz auf das aktuelle Objekt this.cvoObject
   * aus dem Rückgabewert. \param fpsChildName Fachlicher Name des
   * Kind-Objektes.
   *
   * \note Wichtig! Das Fenster-Objekt muss gesetzt sein!<br/>
   * Ist dies nicht der Fall, wird eine OKW.OKW_Kernel_Exception Exception
   * ausgelöst
   *
   * \~english \brief Setting the Child Object.
   *
   * \return Returns the Object reference to the current Object this.cvoObject
   * with the return. \param fpsChildName Professional name of the Child Object
   *
   * \note Notice! The Windows Object must be set!<br/>
   * If not, a OKW.OKW_Kernel_Exception Exception will be triggered.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   */
  public Object SetChildName( String fpsChildName ) throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
  {
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CurrentObject.SetChildName", "String fpsChildName", fpsChildName );
    Log.LogPrintDebug( LM.GetMessage( "SetChildName", "GivenWindownameDebug" ) );
    try
    {
      if ( !OKW_Helper.StringIsNullOrEmpty( this.cvsWindowFN ) )
      {
        Log.LogPrintDebug( LM.GetMessage( "SetChildName", "SetChildwindowNameDebug", this.cvsWindowFN, this.cvsChildFN ) );
        this.cvsChildFN = fpsChildName;
        this.UpdateObject();
        bOK = true;
      }
      else
      {
        // Fenster Objekt wurde nicht gesetzt, Exception auslösen...
        String ErrorText = this.LM.GetMessage( "SetChildName", "OKWFrameObjectWindowNotSetException" );
        throw new OKWFrameObjectWindowNotSetException( ErrorText );
      }
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( this.cvoObject.getClass().getName() );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return this.cvoObject;
  }

  //
  // \~german
  // \brief Ruft eine Methode SetValue des aktuellen Objektes via
  // "Latebound Function Call" auf.<br/>
  // Die aufgerufene Methode hat die Signatur:<br/>
  //
  // | Parameter/Return | Type | | :----------------|:-------------------| | 1.
  // Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
  //
  // @param fpLsParameter_1
  //          Parameter als List&lt;String&gt;.
  // @return ArrayList&lt;String&gt; .
  //
  //         
  // \~english
  // \brief Calls a method of the current Object with
  //         "late bound function call". The called method has the signature:
  //
  //         | Parameter/Return | Type | |
  //         :----------------|:-------------------| | 1st Parameter |
  //         List&lt;String&gt; | | Return | List&lt;String&gt; |
  //
  //
  //         param fpLsParameter_1 parameter as list&lt;String&gt;.
  // @return List&lt;String&gt; .
  //         
  // \~
  // @author Zoltan Hrabovszki
  // @throws InterruptedException
  // @date 2012.11.01
  //
  public void SetValue( ArrayList<String> fpALExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Log.LogFunctionStartDebug( "SetValue", "ArrayList<String> fpALExpectedValues", fpALExpectedValues.toString() );

    Class<?>[] paramTypes = { ArrayList.class };
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "SetValue", paramTypes );

      myMethod.invoke( cvoObject, fpALExpectedValues );

    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "SetValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
        Log.LogFunctionEndDebug();
    }
    return;
  }

  
  
  /**
   * \~german \brief Hier wird der Kontext auf ein Fenster gesetzt. * Der
   * Bezeichner des letzten Kindobjektes wird gelöscht. * Frame-Klasse mit
   * "fpsWindowName" wird ggf. instanziert oder aus dem
   *
   * \param fpsWindowName Name des Fenster, welches den Kontext erhält. \return
   * Liefert die Objektreferenz, auf das hier gesetzte Fenster zurück.
   *
   * \~english \brief Here the context is set to a window. * The identifier of
   * the last child Object is deleted. * Frame class with "fpsWindowName" will
   * be instantiate optionally or from the
   *
   * \param fpsWindowName Name of the window, which contains the context.
   * \return Returns the Object reference back to the her set window.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   */
  public Object SetWindowName( String fpsWindowName ) throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
  {
    Object lvoReturn = new Object();
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CurrentObject.SetWindowName", "String fpsWindowName", fpsWindowName );
    try
    {
      this.cvsWindowFN = fpsWindowName;
      this.cvsChildFN = "";
      this.UpdateObject();
      lvoReturn = this.cvoObject;
      bOK = true;
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvoReturn.toString() );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvoReturn;
  }

  /**
   * \~german \brief Das aktuelle Objekt wird auf das Fenster zurückgesetzt.
   * Kindobjekt wird gelöscht.
   *
   * \return Liefert die Objektreferenz des Fensters zurück.
   *
   * \~english \brief The current Object will be set back to the window. Child
   * Object will be deleted.
   *
   * \return Returns the Object reference of the window.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   */
  @SuppressWarnings( "unused" )
  private Object ResetToWindow() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
  {
    Boolean bOK = false;
    Log.LogFunctionStartDebug( "CurrentObject.ResetToWindow" );
    Log.LogPrintDebug( LM.GetMessage( "ResetToWindow", "ResetToWindowDebug" ) );
    try
    {
      this.cvsChildFN = "";
      this.UpdateObject();
      bOK = true;
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( this.cvoObject.getClass().getName() );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return this.cvoObject;
  }

  /**
   * \~german \brief Methode aktualisert zwei Werte: *
   * OKW.CurrentObject.cvsObjectName wird aktualisiert und *
   * OKW.CurrentObject.myFrameObjectDictionary erhält eine Objekt-Referenz auf
   * das zugehörige Frame-Objekt.
   *
   * \note Diese Methode wird von OKW.CurrentObject.SetWindowName und
   * OKW.CurrentObject.SetChildName aufgerufen. Diese Method sorgt dafür, dass
   * die in SetWindowName und SetChildName gegebenen Werte das entsprechende
   * FrameObjekt instanziert.
   *
   * \~english \brief Method updates two values: *
   * OKW.CurrentObject.cvsObjectName is updated and *
   * OKW.CurrentObject.myFrameObjectDictionary is receiving an Object reference
   * to the corresponding frame Object.
   *
   * \note This method is called by OKW.CurrentObject.SetWindowName and
   * OKW.CurrentObject.SetChildName. This method takes care, that the values
   * given in SetWindowName and SetChildName will be instantiated in the
   * corresponding frame Object.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   */
  private void UpdateObject() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
  {
    Log.LogFunctionStartDebug( "CurrentObject.UpdateObject" );
    try
    {
      if ( this.cvsChildFN == "" )
      {
        // -> 2. Get the Window-Object...
        this.cvoObject = myFrameObjectDictionary.GetParentObjectByName( this.cvsWindowFN );
        this.cvsObjectName = this.cvoObject.getClass().getName();
        this.cvsObjectFN = this.cvsWindowFN;

      }
      else
      {
        // < 1. Set the cvsObjectName for a child-Object.
        this.cvsObjectFN = this.cvsWindowFN + "." + this.cvsChildFN;

        // < 2. Now get the Object-Instance...
        this.cvoObject = null;
        this.cvoObject = myFrameObjectDictionary.GetChildObjectByName( this.cvsWindowFN, this.cvsChildFN );

        // < 3. Set tecnicalname of Object-Instance...
        this.cvsObjectName = this.cvoObject.getClass().getName();
      }
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }
  /**
   * \~german \brief Ruft eine Methode VerifyLabel des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyLabel( String FN, ArrayList<String> fpALExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyLabel_PT = 1000;
    Integer VerifyLabel_TO = 30;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyLabel", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyLabel" );

      VerifyLabel_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_PT();
      VerifyLabel_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_TO();

      Log.LogPrintDebug("VerifyValue_PT: " + VerifyLabel_PT.toString() );
      Log.LogPrintDebug("VerifyValue_TO: " + VerifyLabel_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyLabel_PT, VerifyLabel_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( fpALExpectedValues.equals( lvLsReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyLabel_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyLabel" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyLabel des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyLabelREGX( String FN,  ArrayList<String> fpALExpectedREGXs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyLabel_PT;
    Integer VerifyLabel_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyValueREGX", "String", "FN", "ArrayList<String> fpALExpectedREGXs", fpALExpectedREGXs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyLabel" );

      VerifyLabel_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_PT();
      VerifyLabel_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_TO();

      MaxCount = CalculateLoopCount( VerifyLabel_PT, VerifyLabel_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.RegexMatch( lvLsReturn, fpALExpectedREGXs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyLabel_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyLabel" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyLabel des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   * \~english 
   * \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyLabelWCM( String FN, ArrayList<String> fpALExpectedWCMs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyLabel_PT;
    Integer VerifyLabel_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyLabelWCM", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedWCMs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyLabel" );

      VerifyLabel_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_PT();
      VerifyLabel_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyLabel_TO();

      MaxCount = CalculateLoopCount( VerifyLabel_PT, VerifyLabel_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCMs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyLabel_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyLabel" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyValue des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyValue( String FN, ArrayList<String> fpALExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT = 1000;
    Integer VerifyValue_TO = 30;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyValue", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyValue" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_TO();

      Log.LogPrintDebug("VerifyValue_PT: " + VerifyValue_PT.toString() );
      Log.LogPrintDebug("VerifyValue_TO: " + VerifyValue_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( fpALExpectedValues.equals( lvLsReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyValue des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyValueREGX( String FN, ArrayList<String> fpALExpectedREGXs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT;
    Integer VerifyValue_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyValueREGX", "String", "FN", "ArrayList<String> fpALExpectedREGXs", fpALExpectedREGXs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyValue" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_TO();

      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.RegexMatch( lvLsReturn, fpALExpectedREGXs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyValue des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   * \~english 
   * \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyValueWCM( String FN, ArrayList<String> fpALExpectedWCMs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT;
    Integer VerifyValue_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyValueWCM", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedWCMs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyValue" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyValue_TO();

      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCMs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf. Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1.
   * Parameter | String | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpsParameter_1 1. Parameter als Type-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call". The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | 1st
   * Parameter | String | | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpsParameter_1 1st
   * parameter as type-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2012.11.01
   */
  public void Sequence( String fpsMethodName, String fpsParameter_1 ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          XPathExpressionException
  {
    Log.LogFunctionStartDebug( "Sequence", "String fpsMethodName", fpsMethodName, "String fps_Parameter_1", fpsParameter_1 );

    Class<?>[] paramTypes = { String.class };

    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getDeclaredMethod( fpsMethodName, paramTypes );
      myMethod.invoke( cvoObject, fpsParameter_1 );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", fpsMethodName );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

  
  /**
   * \~german \brief Ruft eine Methode VerifyCaption des aktuellen Objektes via
   * "Latebound Function Call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyCaption( String FN, ArrayList<String> fpALExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT = 1000;
    Integer VerifyValue_TO = 30;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyCaption", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyCaption" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_TO();

      Log.LogPrintDebug("VerifyValue_PT: " + VerifyValue_PT.toString() );
      Log.LogPrintDebug("VerifyValue_TO: " + VerifyValue_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( fpALExpectedValues.equals( lvLsReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyCaption des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyCaptionREGX( String FN, ArrayList<String> fpALExpectedREGXs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT;
    Integer VerifyValue_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyCaptionREGX", "String", "FN", "ArrayList<String> fpALExpectedREGXs", fpALExpectedREGXs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyCaption" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_TO();

      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.RegexMatch( lvLsReturn, fpALExpectedREGXs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyCaptionWCM des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   * \~english 
   * \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyCaptionWCM( String FN, ArrayList<String> fpALExpectedWCMs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyValue_PT;
    Integer VerifyValue_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyCaptionWCM", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedWCMs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyCaption" );

      VerifyValue_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_PT();
      VerifyValue_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyCaption_TO();

      MaxCount = CalculateLoopCount( VerifyValue_PT, VerifyValue_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCMs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyValue_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }
  /**
   * \~german \brief Ruft eine Methode VerifyCaption des aktuellen Objektes via
   * "Latebound Function Call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyTooltip( String FN, ArrayList<String> fpALExpectedValues ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyTooltip_PT = 1000;
    Integer VerifyTooltip_TO = 30;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyTooltip", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedValues.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyTooltip" );

      VerifyTooltip_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_PT();
      VerifyTooltip_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_TO();

      Log.LogPrintDebug("VerifyTooltip_PT: " + VerifyTooltip_PT.toString() );
      Log.LogPrintDebug("VerifyTooltip_TO: " + VerifyTooltip_TO.toString() );
      
      MaxCount = CalculateLoopCount( VerifyTooltip_PT, VerifyTooltip_TO );
      Count = 0;
      
      Log.LogPrintDebug("MaxCount: " + MaxCount.toString() );
      
      while ( Count <= MaxCount )
      {
        Log.LogPrintDebug("  Count: " + Count.toString() );
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( fpALExpectedValues.equals( lvLsReturn ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyTooltip_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyCaption des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   *         \~english \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyTooltipREGX( String FN, ArrayList<String> fpALExpectedREGXs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyTooltip_PT;
    Integer VerifyTooltip_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyTooltipREGX", "String", "FN", "ArrayList<String> fpALExpectedREGXs", fpALExpectedREGXs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyTooltip" );

      VerifyTooltip_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_PT();
      VerifyTooltip_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_TO();

      MaxCount = CalculateLoopCount( VerifyTooltip_PT, VerifyTooltip_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.RegexMatch( lvLsReturn, fpALExpectedREGXs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyTooltip_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }

  /**
   * \~german \brief Ruft eine Methode VerifyTooltipWCM des aktuellen Objektes via
   * "latebound function call" auf.<br/>
   * Die aufgerufene Methode hat die Signatur:<br/>
   *
   * | Parameter/Return | Type | | :----------------|:-------------------| | 1.
   * Parameter | List&lt;String&gt; | | Rückgabewert | List&lt;String&gt; |
   *
   * @param fpLsParameter_1
   *          Parameter als List&lt;String&gt;.
   * @return ArrayList&lt;String&gt; .
   *
   * \~english 
   * \brief Calls a method of the current Object with
   *         "late bound function call". The called method has the signature:
   *
   *         | Parameter/Return | Type | |
   *         :----------------|:-------------------| | 1st Parameter |
   *         List&lt;String&gt; | | Return | List&lt;String&gt; |
   *
   *
   *         param fpLsParameter_1 parameter as list&lt;String&gt;.
   * @return List&lt;String&gt; .
   *
   *         \~
   * @author Zoltan Hrabovszki
   * @throws InterruptedException
   * @date 2012.11.01
   */
  @SuppressWarnings( "unchecked" )
  public ArrayList<String> VerifyTooltipWCM( String FN, ArrayList<String> fpALExpectedWCMs ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException, InterruptedException
  {

    Integer MaxCount = 0;
    Integer Count = 0;
    Integer VerifyTooltip_PT;
    Integer VerifyTooltip_TO;

    ArrayList<String> lvLsReturn = new ArrayList<String>();
    Boolean bOK = false;

    Log.LogFunctionStartDebug( "VerifyTooltipWCM", "String", "FN", "ArrayList<String> fpALExpectedValues", fpALExpectedWCMs.toString() );

    this.SetChildName( FN );
    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "VerifyTooltip" );

      VerifyTooltip_PT = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_PT();
      VerifyTooltip_TO = ((Field) this.myFrameObjectDictionary.myFrameObjectDictionary.get( cvsObjectFN )).getAnnotation(OKW.class).VerifyTooltip_TO();

      MaxCount = CalculateLoopCount( VerifyTooltip_PT, VerifyTooltip_TO );
      Count = 0;

      while ( Count <= MaxCount )
      {
        lvLsReturn = ( ArrayList<String> ) myMethod.invoke( cvoObject );

        if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCMs ) )
        {
          break;
        }
        else
        {
          Thread.sleep( VerifyTooltip_PT );
        }

        Count++;
      }

      bOK = true;
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "VerifyValue" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      if ( bOK )
      {
        Log.LogFunctionEndDebug( lvLsReturn );
      }
      else
      {
        Log.LogFunctionEndDebug();
      }
    }
    return lvLsReturn;
  }
  
  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | List &lt; String &gt; | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll. \param
   * fpLsParameter 1. Parameter als List-String.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:-------------| | Parameter
   * | List&lt; String &gt; | | Return | none |
   *
   * \param fpsMethod name of method to be called. \param fpLsParameter 1st
   * parameter as list-String.
   *
   * \~ \author Zoltan Hrabovszki \date 2014.01.14
   */
  public void Select( ArrayList<String> fpLsParameter ) throws IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "Select", "ArrayList<String> fplsParameter", fpLsParameter.toString() );

    Class<?>[] paramTypes = { ArrayList.class };

    Class<?> myFrame_Class = this.cvoObject.getClass();

    try
    {
      Method myMethod = myFrame_Class.getMethod( "Select", paramTypes );
      myMethod.invoke( cvoObject, fpLsParameter );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "Select" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }

    return;
  }


  /**
   * \~german \brief Ruft eine Methode des aktuellen Objektes via
   * "late bound function call" auf.
   *
   * Die aufgerufene Methode hat die Signatur:
   *
   * | Parameter/Return | Type | | :----------------|:------| | Parameter |
   * keine | | Rückgabewert | kein |
   *
   * \param fpsMethod Name der Methode, die aufgerufen werden soll.
   *
   * \~english \brief Calls a method of the current Object with
   * "late bound function call".
   *
   * The called method has the signature:
   *
   * | Parameter/Return | Type | | :----------------|:------| | Parameter | none
   * | | Return | none |
   *
   * \param fpsMethod name of method to be called.
   *
   * \~ \author Zoltan Hrabovszki \date 2014.01.14
   */
  public void SelectMenu() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, XPathExpressionException
  {
    Log.LogFunctionStartDebug( "SelectMenu" );

    Class<?> myFrame_Class = this.cvoObject.getClass();
    Method myMethod = null;

    // Schenwir
    try
    {
      myMethod = myFrame_Class.getMethod( "SelectMenu" );
      myMethod.invoke( cvoObject );
    }
    catch (NoSuchMethodException e)
    {
      // Existiert die Methode des Objektes?
      // Nein: -> Mit einem OKWFrameObjectMethodNotFoundException
      // aussteigen...
      String errorText = LM.GetMessage( "CallMethod", "MethodNotDefined", "SelectMenu" );
      throw new OKWFrameObjectMethodNotFoundException( errorText );
    }
    finally
    {
      Log.LogFunctionEndDebug();
    }
    return;
  }

}
