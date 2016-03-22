/*
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

package okw;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

/// \~german
/// \brief
/// Verwaltet zentral die Frame-Klassen: Instanziert Frame-Klassen zu Frame-Objekten
/// und liefert die Referenzen auf diese zurück.
/// 
/// \todo TODO: ZH Dokumentaion erweitern.
/// \~english
/// \brief
/// \todo TODO: JN Übersetzung/Review
/// 
/// \~
/// \author Zoltan Hrabovszki
/// \date 2014.10.10
/// 
public class FrameObjectDictionary_Sngltn
{

	// / \~german
	// / \brief
	// / Zentrale Liste, genauer Dictionary/Hash der aktuell benutzten
	// / Frame-Objekte.
	// /
	// / Der Zugriff erfolgt über die Methoden:
	// / - FrameObjectDictionary.GetObjectByName(String)
	// / - FrameObjectDictionary.GetObjectByName(String,String)
	// / - FrameObjectDictionary.Init()
	// /
	// / \note Feld ist Public
	// / \~english
	// / \brief
	// / \todo TODO: JN Übersetzung/Review
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// / \todo TODO: Bedingte Kompilierung einfügen für "Test" Feld muss Public
	// / sein, wenn unittets durchgeführt werden soll.
	public Map<String, Object> myFrameObjectDictionary = new HashMap<String, Object>();

	// / \copydoc CurrentObject::Log()
	private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

	// / \copydoc CurrentObject::LM()
	private static LogMessenger LM;

	// / \~german
	// / \brief
	// / Konstuktor der Klasse. Es wird die Methode FrameObjectDictionary.Init()
	// / aufgerufen.
	// /
	// / \~english
	// / \brief
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// /
	private FrameObjectDictionary_Sngltn()
	{
		Log.LogFunctionStartDebug( "FrameObjectDictionary.FrameObjectDictionary" );
		try
		{
			this.Init();
		}
		catch (Exception e)
		{
			OKW_HandleException.StopRunning( e, Instance.getClass() );
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}
	}

	private static FrameObjectDictionary_Sngltn Instance = null;

	public static FrameObjectDictionary_Sngltn getInstance()
			throws XPathExpressionException, JAXBException,
			ParserConfigurationException, SAXException, IOException
	{
		Log.LogFunctionStartDebug( "FrameObjectDictionary.getInstance" );

		// Lazy Initialization (If required then only)
		if ( Instance == null )
		{
			// Thread Safe. Might be costly operation in some case
			synchronized ( FrameObjectDictionary_Sngltn.class )
			{
				if ( Instance == null )
				{
					Instance = new FrameObjectDictionary_Sngltn();
				}
			}
		}

		Log.LogFunctionEnd( "FrameObjectDictionary.getInstance" );

		return Instance;
	}

	// / \~german
	// / \brief
	// / Die Methode liefert das Frame-Object des gegebenen Fensterobjektes
	// / zurück.
	// /
	// / Dabei kann das Objekt bereits erzeugt (instanziert) sein,
	// / in diesem Fall wird der Bezug aus der Dictionary
	// / OKW_FrameObjectDictionary.cv_FrameObjectDictionary
	// / geholt oder das Objekt wurde noch nicht erzeugt,
	// / dann wird eine Instanz angelegt und ein Bezug auf das Objekt
	// / gespeichert.
	// /
	// / \see Für das Kindobjekt existiert eine zweite Ausprägung dieser
	// Methode:
	// / FrameObjectDictionary.GetObjectByName(String,String)
	// /
	// / \param fpsParentObject Fachlicher Name des Fenster Objektes =
	// / Elternobjekt.
	// /
	// / \return Frame-Objekt-Referenz auf das Fenstre-Objekt.
	// /
	// / \~english
	// / \brief
	// / The method delivers the frame Object of the given window Object.
	// /
	// / Here the Object can already be instantiated,
	// / in this case the reference will be taken from the Dictionary
	// / OKW_FrameObjectDictionary.cv_FrameObjectDictionary
	// / or the Object is not yet instantiated,
	// / then an instance is to be laid and a reference to the Object is stored.
	// /
	// / \see For the child Object another markedness ist existing.:
	// / FrameObjectDictionary.GetObjectByName(String,String)
	// /
	// / \param fpsParentObject Fachlicher Name des Fenster Objektes =
	// / Elternobjekt
	// /
	// / \return \todo TODO: ZH Rückgabewert beschreiben
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	public Object GetParentObjectByName( String fpsParentObject )
			throws XPathExpressionException
	{
		Object lvo_Return = null;

		Log.LogFunctionStartDebug(
				"FrameObjectDictionary.GetParentObjectByName",
				"fpsFunctionalnameOfWindow", fpsParentObject );
		try
		{
			// Gibt es den Schlüssel im Dictinary? - D.h. Gibt es schon eine
			// Instanz des Objektes im Speicher?
			Log.LogPrintDebug( LM.GetMessage( "GetParentObjectByName", "M1",
					fpsParentObject ) );
			if ( myFrameObjectDictionary.containsKey( fpsParentObject ) )
			{
				// Ja, das Objekt existiert.
				Log.LogPrintDebug( LM
						.GetMessage( "GetParentObjectByName", "M2" ) );
				lvo_Return = myFrameObjectDictionary.get( fpsParentObject );
			}
			else
			{
				// Nein -> Frame zum Funtionalen NAme wurde nicht gefunden ->
				// Exception auslösen...
				// \todo TODO: Fehlermeldung einbauen...
				Log.LogPrintDebug( LM
						.GetMessage( "GetParentObjectByName", "M3" ) );

				String lvsMessage = LM.GetMessage( "GetParentObjectByName",
						"OKWFrameObjectParentNotFoundException",
						fpsParentObject );
				throw new OKWFrameObjectParentNotFoundException( lvsMessage );
			}
		}
		finally
		{
			Log.LogFunctionEndDebug( lvo_Return.toString() );
		}

		return lvo_Return;
	}

	// / \~german
	// / \brief
	// / Die Methode liefert das Objekt des gegebenen Kindobjekttests zurück.
	// /
	// / \see Für das Fensterobjekt existiert eine zweite Ausprägung dieser
	// / Methode.
	// / FrameObjectDictionary.GetObjectByName(String,String)
	// /
	// / \param fps_ParentObject Name des Fenster-Objektes = Elternobjekt.
	// / \param fps_ChildObject Name des Kindobjektes-Objektes.
	// /
	// / \return Frame-Objekt-Referenz auf das Kindobjekt.
	// /
	// / \~english
	// / \brief
	// / The method delivers the Object of the given ChildObjecttest.
	// /
	// / \see For the window Object another markedness is existing.
	// / FrameObjectDictionary.GetObjectByName(String,String)
	// /
	// / \param fps_ParentObject Name des Fenster-Objektes = Elternobjekt.
	// / \param fps_ChildObject Name des Kindobjektes-Objektes.
	// / \return \todo TODO: JN Rückgabewert übersetzen/review
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// / \todo TODO: Exception/Try/Except/Finaly einbauen
	public Object GetChildObjectByName( String fps_ParentObject,
			String fps_ChildObject ) throws XPathExpressionException
	{
		Object lvo_Return = null;
		String lvs_ObjectName = fps_ParentObject + "." + fps_ChildObject;

		Log.LogFunctionStartDebug(
				"FrameObjectDictionary.GetChildObjectByName",
				"fps_ParentObject", fps_ParentObject, "fps_ChildObject",
				fps_ChildObject );

		// Gibt es den Schlüssel im Dictinary?
		Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M1",
				fps_ChildObject, fps_ParentObject ) );
		try
		{
			if ( myFrameObjectDictionary.containsKey( lvs_ObjectName ) )
			{
				// Ja, das Objekt existiert.
				Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M2" ) );
				// Hole refarenc auf des Objekt im Dictionary
				lvo_Return = myFrameObjectDictionary.get( lvs_ObjectName );

			}
			else
			{
				// Nein -> Frame zum Funtionalen Name wurde nicht gefunden ->
				// Exception OKWFrameObjectChildNotFoundException auslösen...
				// \todo TODO: Fehlermeldung einbauen...
				Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M3" ) );

				String lvsMessage = LM.GetMessage( "GetChildObjectByName",
						"OKWFrameObjectChildNotFoundException", lvs_ObjectName );
				throw new OKWFrameObjectChildNotFoundException( lvsMessage );
			}
		}
		finally
		{
			Log.LogFunctionEndDebug( lvo_Return.toString() );
		}
		return lvo_Return;
	}

	// / \~german
	// / \brief
	// / Methode initialisiert diese Klasse.
	// /
	// / Es wird
	// / - LogMessender-Instanz erzeugt.
	// / - das FrameObjektDictionary wird gelöscht.
	// / - Es werden die Frame-Objekte geladen (instanziert)
	// /
	// / \~english
	// / \brief
	// / \todo TODO: JN Übersetzung/Review
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// /
	public void Init() throws ClassNotFoundException, InstantiationException,
			JAXBException, ParserConfigurationException, SAXException,
			IOException, XPathExpressionException
	{
		Log.LogFunctionStartDebug( "FrameObjectDictionary.Init" );

		try
		{
			LM = new LogMessenger( "FrameObjectDictionary" );

			Log.LogPrint( LM.GetMessage( "Init", "InitClear", this.getClass()
					.getName() ) );
			myFrameObjectDictionary.clear();

			// Alle Fenster Klassen mit Annotation ermitteln...
			ArrayList<Class<?>> lvOKWGuiClasses = GetListOfOKWGuiClasses();

			this.AddFrameInstancesToDictionary( lvOKWGuiClasses );
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}
	}

	// / \~german
	// / \brief
	// / Methode erstellt eine Liste aller OKWGUI-Rahmenklassen (Frame class),
	// / die in der aktuell ausgeführten Assambly
	// / definiert sind.
	// /
	// / \note __WICHTIG:__ Es werden Klassen in die Liste aufgenommen, die
	// / -# dem Namepsace OKW.Frames zugeordent sind
	// / -# und mit dem Annotiation OKWGUIAttribute "geschmückt" ist.
	// /
	// / \return
	// / Liefert die Liste der Klasse, die der Namespace OKW.Frames und mit dem
	// / Attribute OKWGUI vershen sind.
	// /
	// / \~english
	// / \brief
	// / \note __IMPORTANT:__ the class is forced to be exactly, as specified.
	// / Here is no 'frame prefix' added.
	// / \return
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// /
	public ArrayList<Class<?>> GetListOfOKWGuiClasses()
			throws ClassNotFoundException
	{
		String lvsNamespace = "okw.gui.frames";
		ArrayList<Class<?>> lvALReturn = new ArrayList<Class<?>>();

		ClassLoader classLoader = FrameObjectDictionary_Sngltn.class
				.getClassLoader();

		// 1. Hole Alle namen der Classen, die sich im Package "okw.frames"
		// befinden
		ArrayList<String> lvALClassNames = OKW_GetJavaClass
				.getClasses( lvsNamespace );

		try
		{
			// 2. Hole alle Klassen, die Annotoation "OKWGUI" haben.
			for ( String lvsClass : lvALClassNames )
			{
				Class<?> aClass = classLoader.loadClass( lvsClass );

				// Wenn die Klasse die Annotaion OKW_FN hat, dann in die
				// Rückgabe-Liste eintrage
				if ( aClass.isAnnotationPresent( OKW_FN.class ) )
				{
					lvALReturn.add( aClass );
				}
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return lvALReturn;
	}

	// / \~german
	// / \brief
	// / \return
	// / Liefert die Instanz der Klasse.
	// /
	// / \param fps_ParentClassName Name der Klasse
	// /
	// / \~english
	// / \brief

	// / \param fps_ParentClassName Name of the class
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2015.01.28
	// /
	private void AddFrameInstancesToDictionary(
			ArrayList<Class<?>> fpListOfOKWGuiTypes )
			throws InstantiationException, XPathExpressionException
	{
		Object lvTypeInstanceAsObject = null;

		Log.LogFunctionStartDebug( "FrameObjectDictionary.AddFrameInstancesToDictionary" );

		try
		{
			// Für jede Klasse...
			for ( Class<?> lvOKWGuiClass : fpListOfOKWGuiTypes )
			{
				lvTypeInstanceAsObject = CreateInstanceByType( lvOKWGuiClass );

				// Funktionalenname der Klasse aus der die Annotiation OKW_FN
				// auslesen wird.
				String lvsFunktionalname = this
						.GetFunktionlanameFromObjekt( lvTypeInstanceAsObject );

				// Wenn Attribute vorhanden (!=null) und nicht Leer dann ins
				// Dictionary einfügen.
				if ( lvsFunktionalname != null && !lvsFunktionalname.isEmpty() )
				{
					String lvsKey = lvsFunktionalname;

					Log.ResOpenList( "\n Window Frame: >>" + lvsKey + "<<" );
					Log.LogPrint( "     Technisches Objekt: >>"
							+ lvTypeInstanceAsObject.getClass().getName()
							+ "<<" );

					myFrameObjectDictionary.put( lvsFunktionalname,
							lvTypeInstanceAsObject );

					Log.LogPrint( LM.GetMessage( "CreateInstanceByObjectName",
							"InstanceWasCreated", lvTypeInstanceAsObject
									.getClass().getName() ) );

					// nun Rekursive die Kinder (=Felder) des Frames durchgehen
					// und ggf. einlesen.
					Scanfields( lvTypeInstanceAsObject, lvsFunktionalname );
				}
			}
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}

		return;
	}

	public void Scanfields( Object fpoWindowAsObject, String fpsWindowName )
	{

		try
		{
			// Get the FieldInfo of MyClass.

			Field[] lvFields = fpoWindowAsObject.getClass().getDeclaredFields();

			for ( Field lvField : lvFields )
			{

				String FieldName = lvField.getName();
				String FieldType = lvField.getType().getName();

				System.out.println( "\nScanne das Objekt: >>" + FieldName
						+ "<<" );
				System.out.println( "           Type  : >>" + FieldType + "<<" );

				if ( lvField.isAnnotationPresent( OKW_FN.class ) )
				{
					OKW_FN myFN = lvField.getAnnotation( OKW_FN.class );
					// Get the value from property.

					String lvsKey = fpsWindowName + "." + myFN.FN();

					Log.LogPrint( "\n   Child: >>" + lvsKey + "<<" );
					Log.LogPrint( "Technisches Objekt: >>" + FieldType + "<<" );

					myFrameObjectDictionary.put( lvsKey,
							lvField.get( fpoWindowAsObject ) );

					// Dann im Objekt weiter Scannen...
					Scanfields( lvField, fpsWindowName );
				}
				else
				{

					if ( FieldType.startsWith( "okw.gui." ) )
					{
						Scanfields( lvField.get( fpoWindowAsObject ),
								fpsWindowName );
					}
					else
					{
						System.out
								.println( " - kein element des Paketes >>okw.gui.<<" );
					}
				}
			}
		}
		catch (Exception e)
		{
			Log.LogException( e.getMessage() );
		}
	}

	// / \brief List das Attribute Funktionalname das übergeben Objektes aus.
	// /
	// / <param name="fpObject"></param>
	// / \return Wert aus Funtionalname
	private String GetFunktionlanameFromObjekt( Object fpObject )
	{
		String lvsReturn = "";

		if ( fpObject.getClass().isAnnotationPresent( OKW_FN.class ) )
		{
			lvsReturn = fpObject.getClass().getAnnotation( OKW_FN.class ).FN();
		}

		return lvsReturn;
	}

	// / \~german
	// / \brief
	// / Die Methode erzeugt eine Instanz der Rahmenklasse (frame class) mit dem
	// / in 'fps_ParentClassName' gegebenen Namen.
	// /
	// / \note __WICHTIG:__ Die Klasse muss zwingend so heißen, wie angegeben.
	// / Hier wird kein 'Frame Präfix' ergänzt.
	// /
	// / \return
	// / Liefert die Instanz der Klasse.
	// /
	// / \param fps_ParentClassName Name der Klasse
	// /
	// / \~english
	// / \brief
	// / The method generates an instance of the frame class with the name given
	// / in 'fps_ParentClassName'.
	// / \note __IMPORTANT:__ the class is forced to be exactly, as specified.
	// / Here is no 'frame prefix' added.
	// / \return
	// / Delivers the instance of the class
	// / \param fps_ParentClassName Name of the class
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014.10.10
	// /
	private Object CreateInstanceByType( Class<?> fpParentType )
			throws InstantiationException, XPathExpressionException
	{
		Object lvo_Obj = null;
		Boolean bOK = false;

		Log.LogFunctionStartDebug(
				"FrameObjectDictionary.CreateInstanceByObjectName",
				"fpParentClass", fpParentType.getName() );

		try
		{
			// lvo_Obj = Activator.CreateInstance(fpParentType, null);

			lvo_Obj = fpParentType.newInstance();

			Log.LogPrintDebug( LM.GetMessage( "CreateInstanceByObjectName",
					"InstanceWasCreated", lvo_Obj.getClass().getName() ) );
			bOK = true;
		}
		catch (IllegalAccessException e)
		{
			// EXCEPTION: Pürfen was hier genau passiert. Exception weitergeben
			throw new OKWFrameObjectParentNotFoundException( LM.GetMessage(
					"CreateInstanceByObjectName", "InstanceWasCreated",
					fpParentType.getName() ) );
		}
		finally
		{
			if ( bOK )
			{
				// Wir sind ohne Exception durchgekommen und wir nehmen an,
				// dass lvo_Obj != null
				// -> wir geben den Namen des Objektes zurück...
				Log.LogFunctionEndDebug( lvo_Obj.getClass().getName() );
			}
			else
			{
				// Irgend etwas ist faul wir rufen nur LogFunctionEndDebug
				// auf...
				Log.LogFunctionEndDebug();
			}
		}

		return lvo_Obj;
	}

	// / \~german
	// / \brief
	// / Erzeugt eine Instanz des OKW-Frame-Objekts.
	// /
	// / \return
	// / Die Instanz des OKW-Frame_Objekts.
	// /
	// / \param fps_ParentName Fachlicher Name des Eltern Fensters.
	// / \param fps_ChildName Fachlicher Name des Kind-Objektes im
	// Fenster-Objekt
	// / fps_ParentName.
	// /
	// / \~english
	// / \brief
	// / Generates an instance of the OKW-Frame-Object.
	// /
	// / \return
	// / The instance of OKW-Frame-Object.
	// /
	// / \param fps_ParentName name of parent window.
	// / \param fps_ChildName Name of child Object via fps_ParentObject given
	// / parent Object.
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014-10-10
	// / FIXME: Prüfen, ob diese Methoden namentlich ok sind. Wird das Eltern
	// / Obejkt angelegt?
	private Object CreateInstanceByObjectName( String fps_ParentObject,
			String fps_ChildObject ) throws XPathExpressionException
	{
		Log.LogFunctionStartDebug(
				"FrameObjectDictionary.CreateInstanceByObjectName",
				"fps_ParentObject", fps_ParentObject, "fps_ChildObject",
				fps_ChildObject );

		Object myParentObject = null;
		Object myChildObject = null;
		Boolean bOK = false;

		try
		{
			// PerentObject holen und ggf. als instanz anlegen
			myParentObject = this.GetParentObjectByName( fps_ParentObject );

			// Kindobjekt aufrufen...
			// aber nur wenn Paretobjekt gefunden worden ist.
			if ( myParentObject != null )
			{
				// FIXME: was ist wenn das myChildObject = null ist??Checken
				myChildObject = GetChildObjectByName( myParentObject,
						fps_ChildObject );
			}
			else
			{
				// \todo TODO: Log Schreiben..
				throw new OKWFrameObjectParentNotFoundException(
						"Frame Objekt des Fensters" );
			}

			bOK = true;

		}
		finally
		{
			if ( bOK )
			{
				// Wir sind ohne Exception durchgekommen und wir nehmen an,
				// dass lvo_Obj != null
				// -> wir geben den Namen des Objektes zurück...
				Log.LogFunctionEndDebug( myChildObject.getClass().getName() );
			}
			else
			{
				// Irgend etwas ist faul wir rufen nur LogFunctionEndDebug
				// auf...
				Log.LogFunctionEndDebug();
			}
		}

		return myChildObject;
	}

	// / \~german
	// / \brief
	// / Holt sich einen <b>öffentlichen</b> Feld Wert über den Namen
	// /
	// / \param fpo_ParentObject Frame des Fensters als Objekt.
	// / \param fps_ChildName Fachlicher Name des Kindobjektes, welches als
	// / Objekt zurückgegeben werden soll.
	// / \return Eigenschaftswert
	// /
	// / \~english
	// / Gets a <b>public</b> field value given its name
	// /
	// / \param fpo_ParentObject Object to inspect
	// / \param fps_ChildName Name of the field to retrieve the value from
	// / \return property value
	// /
	// /
	// / \~
	// / \author Zoltan Hrabovszki
	// / \date 2014-10-10
	private Object GetChildObjectByName( Object fpo_ParentObject,
			String fps_ChildName ) throws XPathExpressionException
	{
		Object lvo_Return = null;

		Log.LogFunctionStartDebug(
				"FrameObjectDictionary.GetChildObjectByName",
				"fpo_ParentObject", fpo_ParentObject.toString(),
				"fps_ChildName", fps_ChildName );

		try
		{
			Field fieldInfoObj = fpo_ParentObject.getClass().getField(
					fps_ChildName );

			// Existiert es das Kindobjekt >>{0:}<< im Objekt >>{1:}<<?
			Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M1",
					fps_ChildName, fpo_ParentObject.getClass().getName() ) );

			// Ja, das Objekt existiert.
			Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M2" ) );

			// Get the value from property.
			lvo_Return = fieldInfoObj;
		}
		catch (SecurityException e)
		{
			// \todo TODO: In Sprachabhängige datei Auslagern!
			Log.LogPrintDebug( "Frame Object must be declarec as Public!" );
			throw e;
		}
		catch (NoSuchFieldException e)
		{
			// Nein -> Exception auslösen und alles beenden!
			Log.LogPrintDebug( LM.GetMessage( "GetChildObjectByName", "M3" ) );

			throw new OKWFrameObjectChildNotFoundException( LM.GetMessage(
					"GetChildObjectByName", "ChildIsNotDefined_Exception",
					fps_ChildName, fpo_ParentObject.getClass().getName() ) );
		}
		finally
		{
			Log.LogFunctionEndDebug();
		}

		return lvo_Return;
	}

	public void PrintObjectDictionary()
	{

		Set<String> mySet = this.myFrameObjectDictionary.keySet();

		for ( String myKey : mySet )
		{
			System.out.println( "  Key: " + myKey );
			System.out.println( "Value: "
					+ myFrameObjectDictionary.get( myKey ).toString() );
			System.out
					.println( " Type: "
							+ myFrameObjectDictionary.get( myKey ).getClass()
									.getName() );
			System.out
					.println( "---------------------------------------------------------------------\n" );
		}

		return;

	}

}