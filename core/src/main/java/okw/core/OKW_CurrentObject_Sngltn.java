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
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.LogMessenger;
import okw.OKW_Helper;
import okw.exceptions.*;
import okw.log.*;

/**
 * \~german Diese Klasse verwaltet das aktuelle GUI-Objekt.
 * 
 * Jedes technische GUI-Objekt, wobei es unerheblich ist, wie tief diese
 * technisch ineinander verschachtelt sind, wird mit maximal zwei Angaben
 * referenziert: **Fenstername** und **Kindobjektname**
 * 
 * __Design-Pattern:__ Singleton - Highlander-Prinzip
 *
 * \~english
 *  This class administrates the actual GUI-Object.
 * 
 * Each technical GUI-Object, irrelevant how deep they are nested into each
 * other technically, will be referenced with two informations: **WindowName**
 * und **ChildObjectName**
 * 
 * __Design-Pattern:__ Singleton - Highlander-Principle
 *
 * \~
 * \author Zoltan Hrabovszki \date 2012.11.01
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
    protected static String             cvsChildFN              = "";

    /**
     * \~german \brief Eigenschaft enthält den fachlichen Namen des aktuellen
     * Fensters. Auf dieses Fenster beziehen sich alle GUI Kind-Objekte, die mit
     * "cvsChildName" gegeben sind.
     *
     *
     * \~english \brief The feature contains the professional name of the current
     * window.<br>
     * All GUI child Objects are relating to this window given mit "cvsChildName".
     */
    protected static String             cvsWindowFN             = "";

    /**
     * \~german \brief Das Feld cvoObject enthält die Referenzierung auf das
     * aktuelle Objekt im OKW_FrameObjectDictionary "myFrameObjectDictionary".
     *
     *
     * \~english \brief The field cvoObject contains the reference of the current
     * Object in OKW_FrameObjectDictionary "myFrameObjectDictionary".
     */
    private static Object               cvoObject               = null;

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
    private static String               cvsFullObjectFN         = "";

    /**
     * \~german
     * \brief Vollständiger "technischer Name" des aktuellen Objektes
     * "WindowName.ChildObjectName" * "frm_Login" ist ein FensterObjekt. *
     * "Frm_Login.User" als Refernz auf das Kindobjekt "User" des fachlichen
     * Fensters "Login"
     *
     *
     * \~english
     * \brief Full "technical name" of the current Object
     * "WindowsName.ChildObject.Name" * "frm_Login" is a WindowObject. *
     * "frm_Login.User" as reference to the child Object "User" of the
     * professional window "Login"
     */
    private static String               cvsObjectName           = "";

    /**
     * \~german
     * Hält eine Referenz auf die Klasse LogMessenger für die sprachabhängige Log-Ausgabe vor.
     *
     * Diese Variable wird im Konstruktor initialisiert.
     *
     * \remark Die Datei mit den Sprachabhängigen Log-Ausgaben zu dieser Klasse
     * ist: <tt>/XML/Log/CurrentObject.xml</tt>
     *
     *
     * \~english
     * \todo TODO: für JN review
     */
    private static LogMessenger         LM                      = null;

    /**
     * \~german
     * \brief Hält eine Referenz auf die Klasse Logger vor.
     *
     *
     * \~english
     * \brief \todo TODO: Translation to english
     */
    private Logger_Sngltn               Log                     = Logger_Sngltn.getInstance();

    /**
     * \~german
     * \brief Diese Übersicht enthält alle besuchten/ genutzten
     * "Frame Objects".
     *
     * Wichtig: Die "Frame Klasse" muss mit "using" einbezogen werden Arbeiten in
     * einer automatisierten Klasse: Es wird die richtige Klasse bei Eingabe des
     * Frame Objektes ausgegeben. Eigenschaft enthält die Referenzierung auf das
     * aktuelle Fenster- oder Kindobjekt.
     *
     *
     * \~english
     * \brief This Dictionary holds all visited/used "Frame Objects".
     *
     * Important: The Frame-Class Must be included with "using" Works in an
     * automatized call: The right class is given after input of the frame Object
     * Function contains the reference to the current window or child Object
     */
    private static FrameObjectDictionary_Sngltn myFrameObjectDictionary = null;

    /**
     * \~german
     * Gibt die Instanz für die einzige Instanz dieser Klasse zurück.
     * 
     * __Hinweis:__ * Diese Klasse ist ein Singleton. - Highlander Prinzip: Es
     * kann nur eine Instanz von dieser Klasse geben! - Verwenden Sie diese
     * Eigenschaft um die Instanz dieser Klasse zu erhalten. - Es gibt keinen
     * öffentlichen Konstruktor für diese Methode!
     *
     *
     * \~english
     * Returns the Instance for the only Instance of this class.
     * 
     * __Remark:__ * This class is a Singleton. - Highlander Principle: There only
     * can be one instance of this class! - Use this function to obtain the
     * instance of this class. - There is no public constructor for this method!
     *
     * <value> The instance of CurrentObject. </value>
     *
     * \~ 
     * @author Zoltan Hrabovszki
     * @date 2012.11.29
     */
    private static OKW_CurrentObject_Sngltn Instance;

    /**
     * \~german \brief Initialisiert eine neue Instanz der <see
     * cref="OKW.CurrentObject"/> Klasse Nicht öffentlicher Konstruktor: Verwenden
     * Sie <see cref="OKW.CurrentObject.Instance"/> um die Instanz dieser Klasse
     * zu erhalten
     *
     *
     * \~english 
     * \brief Initializes a new instance of the <see
     * cref="OKW.CurrentObject"/> class. No public constructor: Use the <see
     * cref="OKW.CurrentObject.Instance"/> to obtain the instance of this class
     *
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.12.02
     */
    private OKW_CurrentObject_Sngltn()
    {

    }

    
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
                    init();
                }
            }
        }
        return Instance;
    }

    public ArrayList<String> getAllChildFNsOfParent( String FN )
    {
        return myFrameObjectDictionary.getAllChildKeysOfParent( FN );
    }


    /**
     * \~german
     * Liefert die Referenz zum aktuellen Frame-Object. Referenz ist im Feld cvoObject abgelegt.
     *
     * @return Die Referenz auf das auf das aktuelle GUI-Object.
     *
     * \~english 
     * Returns the reference to the current Frame-Object. Reference is stored in the field cvoObject.
     *
     * @return Reference to the current GUI-Object.
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public Object getCurrentObject()
    {
        Object lvoReturn = new Object();
        
        Log.LogFunctionStartDebug( "CurrentObject.GetCurrentObject" );
 
        lvoReturn = cvoObject;
        
        Log.LogFunctionEndDebug( cvoObject.getClass().getName() );
        return lvoReturn;
    }

    /**
     * \~german 
     * Ermittelt den ObjektNamen des aktuellen Objektes.
     *
     * @return Liefert den Objektnamen in der Form "WindowName.ChildName" oder "WindowName".
     *
     * \~english
     * Detecting the ObejctName of the current Object
     *
     * @return Gives the ObjectName in the form "WindowName.ChildName" or "WindowName".
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public String getObjectFN()
    {
        // Varaibles
        String lvsReturn = null;
        
        // Action
        Log.LogFunctionStartDebug( "CurrentObject.GetObjectName" );
        try
        {
            lvsReturn = cvsFullObjectFN;
        }
        finally
        {
                Log.LogFunctionEndDebug( lvsReturn );
        }
        return lvsReturn;
    }

    /**
     * \~german
     * Ermittelt den FN des des aktuellen Fenster-Objektes.
     *
     * @return Liefert den Objektnamen in der Form "WindowName" oder "WindowName".
     *
     * \~english
     * Detecting the ObejctName of the current Object
     *
     * @return Gives the ObjectName in the form "WindowName.ChildName" or "WindowName".
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public String getWindowFN()
    {
        // Variables
        String lvsReturn = null;
        
        // Action
        Log.LogFunctionStartDebug( "CurrentObject.GetWindowFN" );
        try
        {
            lvsReturn = cvsWindowFN;
        }
        finally
        {
            Log.LogFunctionEndDebug( lvsReturn );
        }
        return lvsReturn;
    }

    /**
     * \~german
     * Ermittelt den FN des des aktuellen Kind-Objektes.
     *
     * @return Liefert den Objektnamen in der Form "ChildName".
     *
     * \~english
     * @ Detecting the ObejctName of the current Object
     *
     * @return Gives the ObjectName in the form "WindowName.ChildName" or "WindowName".
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public String getChildFN()
    {
        // Varaibles
        String lvsReturn = null;
        
        //Action
        Log.LogFunctionStartDebug( "CurrentObject.GetChildFN" );
        try
        {
            lvsReturn = cvsChildFN;
        }
        finally
        {
           Log.LogFunctionEndDebug( lvsReturn );
        }
        return lvsReturn;
    }

    /**
     * \~german
     * Führt die Initialisierung der Klasse durch: Es werden alle Felder der Klasse auf einen definierten Anfangszustand zurükgesetzt;
     *
     * \~english
     * Running the initializing of the class: There are all fields of the class set to a defined initial state.
     *
     * \~
     * @author Zoltan Hrabovszki 
     * @date 2012.12.15
     */
    public static void init() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
            LM = new LogMessenger( "OKW_CurrentObject" );
            cvoObject = null;
            cvsWindowFN = "";
            cvsChildFN = "";
            cvsObjectName = "";
            myFrameObjectDictionary = null;
            myFrameObjectDictionary = FrameObjectDictionary_Sngltn.getInstance();
    }

    /**
     * \~german
     * Methode gibt alle wichtigen Informationen zum aktuellen Objekt aus.
     * 
     * Diese soll im Fehler- oder Ausnahmefall bei der Fehlersuche
     * durch Ausgabe der aktuellen Objektdaten helfen. <br>
     * Diese Daten werden ausgegeben: * Window Name: cvsWindowName * Name des
     * Kindes: cvsChildName * Objektklasse: cvoObject.getClass().Name *
     * Voller Name des Objektes: cvsObjectName
     *
     * \note Methode wird während der Ausnahmebehandlung aufgerufen.
     *
     * \~english
     * Method returns all the important information about the current Object.
     * 
     * This should help in error or exception when debugging by
     * outputting the current data Object.
     * 
     * These data will be returned: * Window Name: cvsWindowName * Name of Child:
     * cvsChildName * Class of Object: cvoObject.getClass().Name * Fullname
     * of Object: cvsObjectName
     *
     * \note Method is called during exception handling.
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public void LogObjectData()
    {
        Log.LogFunctionStartDebug( "CurrentObject.LogObjectData" );
        
        try
        {
            Log.ResOpenList( "Object Data:" );
            Log.LogPrint( LM.GetMessage( "LogObjectData", "WindowName", cvsWindowFN ) );
            Log.LogPrint( LM.GetMessage( "LogObjectData", "ChildWindowName", cvsChildFN ) );
            if (cvoObject == null)
                Log.LogPrint( LM.GetMessage( "LogObjectData", "Class of Object", "null - There is no Frame-Object" ) );
            else
               Log.LogPrint( LM.GetMessage( "LogObjectData", "Class of Object", cvoObject.getClass().getSimpleName() ) );
            Log.LogPrint( LM.GetMessage( "LogObjectData", "FullNameOfObject", cvsObjectName ) );
        }
/*        catch (Exception e)
        {
            Log.LogPrint( e.getMessage() );
        }*/
        finally
        {
            Log.ResCloseList();
        }
        
        Log.LogFunctionEndDebug();
    }

    /**
     * \~german
     * Das aktuelle Objekt wird auf das Fenster zurückgesetzt. Kindobjekt wird gelöscht.
     *
     * @return Liefert die Objektreferenz des Fensters zurück.
     *
     * \~english
     * The current Object will be set back to the window. Child Object will be deleted.
     *
     * @return Returns the Object reference of the window.
     *
     * \~ \author Zoltan Hrabovszki \date 2012.11.01
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public Object resetToWindow() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
    {
        Log.LogFunctionStartDebug( "CurrentObject.ResetToWindow" );
        Log.LogPrintDebug( LM.GetMessage( "ResetToWindow", "ResetToWindowDebug" ) );
 
        cvsChildFN = "";
        updateObject();
        
        Log.LogFunctionEndDebug( cvoObject.getClass().getName() );
        return cvoObject;
    }

    
    /**
       * \~german
       * Setzt das Kindobjekt.
       *
       * @return Liefert die Objektreferenz auf das aktuelle Objekt cvoObject
       * aus dem Rückgabewert.
       * @param fpsChildName Fachlicher Name des
       * Kind-Objektes.
       *
       * \note Wichtig! Das Fenster-Objekt muss bereits gesetzt sein!<br>
       * Ist dies nicht der Fall, wird eine OKW.OKWFrameObjectWindowNotSetException Exception
       * ausgelöst
       *
       * \~english
       * Setting the Child Object.
       *
       * @param fpsChildName Funktional name of the Child Object.
       * @return Returns the Object reference to the current Object cvoObject with the return. 
       *
       * \note Notice! The Windows Object must be set!<br>
       * If not, a OKW.OKW_Kernel_Exception Exception will be triggered.
       *
       * \~
       * @author Zoltan Hrabovszki
       * @date 2012.11.01
       * @throws IllegalAccessException 
       * @throws IllegalArgumentException 
       */
    public Object setChildName( String fpsChildName ) throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
    {
        Boolean bOK = false;
        
        Log.LogFunctionStartDebug( "CurrentObject.SetChildName", "String fpsChildName", fpsChildName );
        Log.LogPrintDebug( LM.GetMessage( "SetChildName", "GivenWindownameDebug" ) );
        try
        {
            if ( !OKW_Helper.isStringNullOrEmpty( cvsWindowFN ) )
            {
                if( "SELECTEDCHILD".equals( fpsChildName ) )
                {
                    Log.LogPrint( LM.GetMessage( "SetChildName", "SetChildwindowNameDebug", cvsWindowFN, cvsChildFN ) );                    
                }
                else
                {
                    cvsChildFN = fpsChildName;
                    Log.LogPrintDebug( LM.GetMessage( "SetChildName", "SetChildwindowNameDebug", cvsWindowFN, cvsChildFN ) );
                    updateObject();
                    bOK = true;
                }
            }
            else
            {
                // Fenster Objekt wurde nicht gesetzt, Exception auslösen...
                String ErrorText = LM.GetMessage( "SetChildName", "OKWFrameObjectWindowNotSetException" );
                throw new OKWFrameObjectWindowNotSetException( ErrorText );
            }
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( cvoObject.getClass().getName() );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return cvoObject;
    }


    /**
     * \~german
     * Hier wird der Kontext auf ein Fenster gesetzt. * Der
     * Bezeichner des letzten Kindobjektes wird gelöscht. * Frame-Klasse mit
     * "fpsWindowName" wird ggf. instanziert oder aus dem
     *
     * @param fpsWindowName Name des Fenster, welches den Kontext erhält.
     * @return Liefert die Objektreferenz, auf das hier gesetzte Fenster zurück.
     *
     * \~english
     * Here the context is set to a window. * The identifier of
     * the last child Object is deleted. * Frame class with "fpsWindowName" will
     * be instantiate optionally or from the
     *
     * @param fpsWindowName Name of the window, which contains the context.
     * @return Returns the Object reference back to the her set window.
     *
     * \~ 
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public Object setWindowName( String fpsWindowName ) throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
    {
        Object lvoReturn = new Object();
        Boolean bOK = false;
        Log.LogFunctionStartDebug( "CurrentObject.SetWindowName", "String fpsWindowName", fpsWindowName );
        try
        {
            cvsWindowFN = fpsWindowName;
            cvsChildFN = "";
            updateObject();
            lvoReturn = cvoObject;
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
                Log.LogFunctionEndDebug( );
            }
        }
        return lvoReturn;
    }
    
    /**
     * \~german
     * Methode aktualisert zwei Werte:
     * - OKW.CurrentObject.cvsObjectName wird aktualisiert und
     * - OKW.CurrentObject.myFrameObjectDictionary erhält eine Objekt-Referenz auf
     * das zugehörige Frame-Objekt.
     *
     * \note Diese Methode wird von OKW.CurrentObject.SetWindowName und
     * OKW.CurrentObject.SetChildName aufgerufen. Diese Method sorgt dafür, dass
     * die in SetWindowName und SetChildName gegebenen Werte das entsprechende
     * FrameObjekt instanziert.
     *
     * \~english
     * Method updates two values:
     *  - OKW.CurrentObject.cvsObjectName is updated and
     *  - OKW.CurrentObject.myFrameObjectDictionary is receiving an Object reference
     * to the corresponding frame Object.
     *
     * \note This method is called by OKW.CurrentObject.SetWindowName and
     * OKW.CurrentObject.SetChildName. This method takes care, that the values
     * given in SetWindowName and SetChildName will be instantiated in the
     * corresponding frame Object.
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private void updateObject() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
    {
        Log.LogFunctionStartDebug( "CurrentObject.updateObject" );
        try
        {
            if ( "".equals( cvsChildFN ) )
            {
                // -> 2. Get the Window-Object...
                cvoObject = myFrameObjectDictionary.getParentObjectByName( cvsWindowFN );
                cvsObjectName = cvoObject.getClass().getName();
                cvsFullObjectFN = cvsWindowFN;

            }
            else
            {
                // < 1. Set the cvsObjectName for a child-Object.
                cvsFullObjectFN = cvsWindowFN + "." + cvsChildFN;

                // < 2. Now get the Object-Instance...
                cvoObject = null;
                cvoObject = myFrameObjectDictionary.getChildObjectByName( cvsWindowFN, cvsChildFN );

                // < 3. Set tecnicalname of Object-Instance...
                cvsObjectName = cvoObject.getClass().getName();
            }
        }
        finally
        {
            Log.LogFunctionEndDebug( );
        }
    }


    /*
     * \~german
     * Ruft eine Methode, gegeben in fpsMethodName, des aktuellen Objektes via "late bound function call" auf. 
     *
     * @param FN Funktionaler Name des GUI-Objektes.
     * @param fpsMethodName der Methode, die aufgerufen werden soll.
     * @param fpsParameter_1 1. Parameter als Type-String.
     *
     * \~english
     * Calls a method of the current Object with "late bound function call".
     *
     * @param FN Functional name of the GUI-Object.
     * @param fpsMethodName of method to be called.
     * @param fpsParameter_1 1st
     * parameter as type-String.
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2012.11.01
     */
    public void Sequence( String FN, String fpsMethodName, String fpsParameter_1 ) throws Exception
    {
        Log.LogFunctionStartDebug( "Sequence", "String fpsMethodName", fpsMethodName, "String fps_Parameter_1", fpsParameter_1 );

        setWindowName( FN );

        Class<?>[] paramTypes =
        { String.class };
        Class<?> myFrame_Class = cvoObject.getClass();

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
    }
}
