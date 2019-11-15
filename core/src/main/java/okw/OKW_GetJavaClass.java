package okw;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.OKWFrameObjectParentNotFoundException;
import okw.gui.AnyChildwindow;
import okw.gui.OKWLocator;
import okw.log.Logger_Sngltn;

public class OKW_GetJavaClass
{
    /**
     *  \copydoc Logger_Sngltn::getInstance()
     */
    private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

    /**
     *  \copybrief LogMessenger
     */
    private static LogMessenger  LM = new LogMessenger( "FrameObjectDictionary" );
    
    /**
     * \~german
     * Methode sucht die Klasse fpsClassName im Namensraum "okw.gui.adapter".
     * 
     * Es wird der Vollqualifizerte Namen der Klasse zurück gegeben.
     * Wird die gegebene Klasse nicht gefunden, dann wir "" zurückgegeben.
     * 
     * Der Namansraum, in dem gesucht wird, kann mit dem Property "okw.gui.adapter" geändert werden.
     *
     * @param fpsClassName Name der Klasse die gesucht werden soll.
     * 
     * @return vollqualifizierte Name der Klasse.
     * 
     * \~english
     * Method searches for the class fpsClassName in the namespace fpsNameSpace.
     * 
     * The fully qualified name of the class is returned.
     * If the given class is not found, "" is returned.
     * 
     * The namespace in which the search is executed can be changed with the property "okw.gui.adapter".
     *
     * @param fpsClassName Name of the class to be searched for.
     * @return fully qualified name of the class.
     * \~
     * @author Zoltán Hrabovszki
     * @date 02.11.2019
     */
    public static String findClassGuiAdapter( String fpsClassName )
    {
        String OKW_GuiAdapteNameSpace = OKW_Properties.getInstance().getProperty( "okw.gui.adapter", "okw.gui.adapter" );
        return findClass( fpsClassName, OKW_GuiAdapteNameSpace );
    }

    
    /**
     * \~german
     * Methode sucht die Klasse fpsClassName im Namensraum fpsNameSpace.
     * 
     * Es wird der Vollqualifizerte Namen der Klasse zurück gegeben.
     * Wird die gegebene Klasse nicht gefunden, dann wir "" zurückgegeben.
     *
     * @param fpsClassName Name der Klasse die gesucht werden soll.
     * @param fpsNameSpace Name-Space, in dem die Klasse gesucht werden soll.
     * 
     * @return vollqualifizierte Name der Klasse
     * 
     * \~english
     * Method searches for the class fpsClassName in the namespace fpsNameSpace.
     * 
     * The fully qualified name of the class is returned.
     * If the given class is not found, "" is returned.
     *
     * @param fpsClassName Name of the class to be searched for.
     * @param fpsNameSpace Name space in which the class is to be searched.
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 02.11.2019
     */
    public static String findClass( String fpsClassName, String fpsNameSpace )
    {
        String returnGUIAdapter = "";

        try
        {
            ArrayList<String> allAdapter = getClasses( fpsNameSpace );

            for ( String Adapter : allAdapter )
            {
                if ( Adapter.matches( ".*" + fpsClassName ) )
                {
                    returnGUIAdapter = Adapter;
                    break;
                }
            }
        }
        catch (XPathExpressionException | IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {

        }

        return returnGUIAdapter;
    }
    
    
    public static ArrayList<String> getClasses( String fpsPackage ) throws IOException, XPathExpressionException
    {
        ArrayList<String> lvAsReturn = new ArrayList<String>();

        Log.ResOpenList( "ClassPathes..." );
        // 1. Hole alle Klassen die das Packet fpsPackeg enthalten...
        ArrayList<String> lvClassPathes = getClassPaths( fpsPackage );
        Log.ResCloseList( );
        
        // Durchsuchen wir alle Pfade...
        for ( String lvClassPath : lvClassPathes )
        {
        	// Decode URI (e.g. spaces and international characters in file names)
        	lvClassPath = URLDecoder.decode( lvClassPath, Charset.defaultCharset().name());

            if ( lvClassPath.startsWith( "file:" ) )
            {
                // Hier handelt es sch um eine *.jar Datei
                // "file:/some/path/myfile.jar!/okw/gui/frames"

                lvClassPath = okw.OKW_Helper.getRightFromDelimiterNumber( lvClassPath, "file:", 1 );

                // nun rechts von "!" abschneiden incl. "!" weg!
                // Ergebniss: "/some/path/myfile.jar"
                lvClassPath = okw.OKW_Helper.getLeftFromDelimiterNumber( lvClassPath, "!", 1 );
                
            }

            File file = new File( lvClassPath );

            if ( file.exists() )
            {
                // 2. Ist ein die URL eine *.jar Datei?
                if ( lvClassPath.endsWith( "jar" ) )
                {
                    // Dann "okw.gui.frames.*" Klassen des Paketes ermitteln...
                    lvAsReturn.addAll( getClassesFromJar( lvClassPath, fpsPackage ) );
                }
                else if ( Files.isDirectory( Paths.get( file.toURI() ), LinkOption.NOFOLLOW_LINKS ) )
                {
                    // Dann "okw.gui.frames.*" Klassen des gegebenen Pfades ermitteln...
                    lvAsReturn.addAll( getClassesFromDirectory( file.getAbsolutePath(), fpsPackage ) );
                }
            }
        }

        return lvAsReturn;
    }

    /**
     * \~german
     * Ermittel alle Pfade aus classpath, die das Paket packegeName im aktuellen threads enthalten.
     * 
     * @param packageName Name des P
     *                  
     * @return
     *       Liste der Klassen-Pfade () im gegebenem package
     * @throws IOException
     */
    static public ArrayList<String> getClassPaths( String packageName ) throws IOException
    {
        ArrayList<String> ReturnList = new ArrayList<String>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = packageName.replace( '.', '/' );

        Enumeration<URL> resources = classLoader.getResources( path );

        while ( resources.hasMoreElements() )
        {
            URL resource = resources.nextElement();

            String replacedURL = resource.getPath();

            /* replacedURL = replacedURL.replaceFirst( "/", "" ); */

            Log.LogPrint( "'" + replacedURL + "'" );
            ReturnList.add( replacedURL );
        }

        return ReturnList;
    }

    /**
     * Recursive method used to find all classes in a given directory and
     * subdirs.
     *
     * @param directory
     *            The base directory
     * @param packageName
     *            The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static ArrayList<String> getClassesFromDirectory( String fpsdirectory, String packageName )
    {
        ArrayList<String> classes = new ArrayList<String>();

        File directory = new File( fpsdirectory );

        if ( directory.exists() )
        {

            File[] files = directory.listFiles();

            for ( File file : files )
            {
                if ( file.isDirectory() )
                {
                    // assert !file.getName().contains( "." );
                    classes.addAll( getClassesFromDirectory( file.getPath(), packageName + "." + file.getName() ) );
                }
                else if ( file.getName().endsWith( ".class" ) )
                {
                    // System.out.println( ">>Class: " + file.getName() );
                    classes.add( packageName + '.' + file.getName().substring( 0, file.getName().length() - 6 ) );
                }
            }
        }
        return classes;
    }

    /**
     *
     * Returns the list of classes in the same directories as Classes in
     * classes.
     *
     * @param result
     * @param classes
     * @param jarPath
     * @throws IOException 
     *
     */
    private static ArrayList<String> getClassesFromJar( String jarPath, String packageName ) throws IOException
    {
        JarFile jarFile = null;
        ArrayList<String> lvAL_Return = new ArrayList<String>();

        try
        {
            jarFile = new JarFile( jarPath );
            Enumeration<JarEntry> en = jarFile.entries();
            while ( en.hasMoreElements() )
            {
                JarEntry entry = en.nextElement();
                String entryName = entry.getName();
                packageName = packageName.replace( ".", "/" );

                if ( entryName != null && entryName.endsWith( ".class" ) && entryName.startsWith( packageName ) )
                {
                    try
                    {
                        Class<?> entryClass = Class.forName( entryName.substring( 0, entryName.length() - 6 ).replace( "/", "." ) );

                        if ( entryClass != null )
                        {
                            lvAL_Return.add( entryClass.getName() );
                        }
                    }
                    catch (Throwable e)
                    {
                        // do nothing, just continue processing classes
                    }
                }
            }
        }
        finally
        {
            if ( jarFile != null )
            {
                jarFile.close();
            }
        }

        return lvAL_Return;
    }

    public static Class<?> loadClass( String fpsClass )
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass = null;
        
        try
        {
            aClass = classLoader.loadClass( fpsClass );
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return aClass;
    }

    /**
     * \~german
     * Die Methode erzeugt eine Instanz der Rahmenklasse (frame class) mit dem
     * in 'fps_ParentClassName' gegebenen Namen.
     *
     * \note __WICHTIG:__ Die Klasse muss zwingend so heißen, wie angegeben.
     * Hier wird kein 'Frame Präfix' ergänzt.
     *   
     * \param fps_ParentClassName Name der Klasse
     *   
     * \return Liefert die Instanz der Klasse.
     *   
     * \~english
     *    The method generates an instance of the frame class with the name given
     *    in 'fps_ParentClassName'.
     *    
     *    \note __IMPORTANT:__ the class is forced to be exactly, as specified.
     *    Here is no 'frame prefix' added.
     *    \return
     *    Delivers the instance of the class
     *    \param fps_ParentClassName Name of the class
     *   
     *    \~
     *    \author Zoltan Hrabovszki
     *    \date 2014.10.10
     */
    public static Object createInstanceByType( Class<?> fpParentType ) throws InstantiationException, XPathExpressionException
    {
      Object lvo_Obj = null;
      Boolean bOK = false;

      Log.LogFunctionStartDebug( "FrameObjectDictionary.CreateInstanceByObjectName", "fpParentClass", fpParentType.getName() );

      try
      {
        // lvo_Obj = Activator.CreateInstance(fpParentType, null);

        lvo_Obj = fpParentType.newInstance();

        Log.LogPrintDebug( LM.GetMessage( "CreateInstanceByObjectName", "InstanceWasCreated", lvo_Obj.getClass().getName() ) );
        bOK = true;
      }
      catch (IllegalAccessException e)
      {
        // EXCEPTION: Pürfen was hier genau passiert. Exception weitergeben
        throw new OKWFrameObjectParentNotFoundException( LM.GetMessage( "CreateInstanceByObjectName", "InstanceWasCreated", fpParentType.getName() ) );
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
    
   
    /** \~german
     *  Methode erstellt eine Liste aller Klassen eines Namesraumes,
     *  die in der aktuell ausgeführten Assambly definiert sind.
     * 
     *  \note __WICHTIG:__ Es werden alle Klassen in die Liste aufgenommen, die
     *  -# dem gegebene Namepsace zugeordent sind.
     * 
     *  \parameter fpsNamespace Namesraum, die nach Klassen durchsucht werden soll.
     * 
     *  \return
     *  Liefert die Liste der Klasse, die der Namespace OKW.Frames und mit dem
     *  Attribute OKWGUI vershen sind.
     * 
     *  \~english

     *  \note __IMPORTANT:__ the class is forced to be exactly, as specified.
     *  Here is no 'frame prefix' added.
     *  \return
     * 
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2014.10.10
     * @throws XPathExpressionException 
     */
    public static ArrayList<Class<?>> getListOfClasses( String fpsNamespace ) throws ClassNotFoundException, IOException, XPathExpressionException
    {
      // String lvsNamespace = "okw.gui.frames";
      ArrayList<Class<?>> lvALReturn = new ArrayList<Class<?>>();

      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

      // 1. Hole alle Klassen, die sich im Package "okw.gui.frames" befinden
      ArrayList<String> lvALClassNames = OKW_GetJavaClass.getClasses( fpsNamespace );

      try
      {
        for ( String lvsClass : lvALClassNames )
        {
          Class<?> aClass = classLoader.loadClass( lvsClass );
          lvALReturn.add( aClass );
        }
      }
      catch (ClassNotFoundException e)
      {
        e.printStackTrace();
      }

      return lvALReturn;
    }
}