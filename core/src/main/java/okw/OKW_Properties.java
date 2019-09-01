package okw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import java.util.regex.Pattern;
import okw.exceptions.OKWFileDoesNotExistsException;
import okw.log.Logger_Sngltn;

import org.apache.commons.lang3.StringUtils;

/**
 * \~german
 * Reihenfolge der Resourcen-"Beladung"
 * 
 * # Property Dateien aus den Resourcen laden -> Ziel: Default-Werte Key=Value aus *.jar-Datein laden.
 * # Config.properties vom Datei System -> Ziel: projketspezifisch Default-Werte Key=Value überschreiben.
 * # System.Properties Drüberladen. -> Ziel: Ausführungsspezifische Werte mit -DKey=Value überladen.
 * 
 * https://stackoverflow.com/questions/28262460/override-a-properties-file-contained-within-a-jar-library
 * 
 * \~english
 *
 *
 * \~
 * @author Zoltán Hrabovszki
 * @date 2018-03-08
 */
public class OKW_Properties extends Properties
{
    private static OKW_Properties Instance;
    
    String PropPath = "";
    String PropPathWin = "";
    
    /**
     *  \copydoc Logger_Sngltn::getInstance()
     */
    private static Logger_Sngltn Log = Logger_Sngltn.getInstance();
    

    /**
     * \~german
     * Liste der einzubindenen *.properties Dateien, die aus dem Resourcen Verzeichniss der Core.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */
    protected ArrayList<String> CoreProperties = new ArrayList<>();
    

    /**
     * \~german
     * Liste der einzubindenen *.properties Dateien, die aus den Resourcen Verzeichnissen.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */
    protected ArrayList<String> ResoursesProperties = new ArrayList<>();
    

    /**
     * \~german
     * Liste der einzubindenen *.properties-Dateien.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */
    protected ArrayList<String> FileProperties = new ArrayList<>();

    /**
     */
    private static final long serialVersionUID = -6936118958227023483L;

    /**
     * \~german
     * Holt die einzige Instanz dieser Klasse.<br>
     * <value> Die Instanz dieser Klasse. </value>
     *
     * Lazy Initialization (If required then only)
     *
     * \~english
     * Gets the only instance of this class.<br>
     * <value> The instance of this class. </value>
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2013.12.22
     */
    public static OKW_Properties getInstance()
    //throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
        // Lazy Initialization (If required then only)
        if ( Instance == null )
        {
            // Thread Safe. Might be costly operation in some case
            synchronized ( OKW_Properties.class )
            {
                if ( Instance == null )
                {
                    Instance = new OKW_Properties();
                }
            }
        }
        return Instance;
    }
    
    
    private OKW_Properties()
    {
        super();
        init();
    }
    
    /**
     * \~german
     * Löscht alle Properties-Listen
     *
     * @param fpsResource *.properties-Datei die geladen werden soll.
     * @return
     * \~english
     *
     *
     * @param ? 
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */         
    public void clear()
    {
        super.clear();
        this.CoreProperties.clear();
        this.ResoursesProperties.clear();
        this.FileProperties.clear();
    }

    /**
     * \~german
     * Initialisiert diese Klasse:
     *  1. Es werden die Core Properties aus Core geladen.
     *  2. Properties aus dem aktuellen Projekt laden
     *  3. siehe updateProperties()
     *
     * \~english
     *  Initializes this class:
     *  1. the Core Properties are loaded from Core.
     *  2. load properties from the current project
     *  3. see updateProperties()
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-05-07
     */
    public void init()
    {
    	String Sep = System.getProperty( "file.separator" );
    	
    	// Zurücksetzen...
        this.clear();
        
        Log.ResOpenList( "Find Properties..." );
        
        // =========================================
        // !. JAR - */okw/default/*/*.properties Dateien einlesen
        // =========================================
        //
        // -----------------------------------------        
        // okw-Dafault-Properties
        //
        Log.ResOpenList( "Find OKW Core Properties..." );
		
		String PropPattern = ".*okw.default.properties.*\\.properties";
		String PropPath = "okw" + Sep + "default" + Sep + "properties" + Sep;
		String PropPathWin = "okw/default/properties/";
		
        ArrayList<String> someProperties = getPropertyFiles( PropPattern, PropPath, PropPathWin);
        this.CoreProperties.addAll( someProperties );
        
        Log.ResCloseList();

        // =========================================
        // project specific properties 
        // =========================================
        // 
        Log.ResOpenList( "Find Project Properties..." );
        
        PropPattern = ".*okw.properties.*\\.properties";
        PropPath = "okw" + Sep + "properties" + Sep;
        PropPathWin = "okw/properties/";
        
        ArrayList<String> some3Properties = getPropertyFiles( PropPattern, PropPath, PropPathWin);
        this.ResoursesProperties.addAll( some3Properties );
        
        Log.ResCloseList();

        Log.ResCloseList();
        
        // =========================================
        // Read system properties and environment Vars...
        // and Update Properties-list
        // =========================================
        this.updateProperties();

        //PrintPropertiesSources();
    }
    
    /**
     * \~german
     * Es werden die Properties aus dem reasource Verzeichniss geladen. 
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */    
    protected ArrayList<String> getPropertyFiles( String Patternstring, String PropPath, String PropPathWin )
    {
        String loadResoure = "";
        ArrayList<String> myReturn = new ArrayList<String>();
        
        Pattern pattern = Pattern.compile( Patternstring );
        ArrayList<String> myList = (ArrayList<String>) ResourceList.getResources(pattern);
        
        
        for ( String element : myList)
        {
            Log.ResOpenList( element );
            
            if ( StringUtils.startsWith( element, PropPath) )
            {
                loadResoure = element;
            }
            else if ( StringUtils.startsWith( element, PropPathWin) )
            {
                loadResoure = element;
            }
            else
            {
                loadResoure =  PropPath + StringUtils.splitByWholeSeparator( element, PropPath )[1];
            }
            
            Log.LogPrint( "--> " + loadResoure );
            myReturn.add( loadResoure );

            Log.ResCloseList();
        }
        
        return myReturn;
    }
    
       
    /**
     * \~german
     * Aktualisert/Lädt die Properties in der unter OKW_Properties beschriebene Weise. 
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */
    public void updateProperties()
    {
        // 1. Löschen des HProperty Hashs...
    	super.clear();
    
        // 2. Laden der Core_Properties
        
        Log.ResOpenList( "Update Properties..." );
        Log.ResOpenList( "Load OKW Core Properties..." );
        for( String s : this.CoreProperties )
        {
              loadFromResource(s);
        }        
        Log.ResCloseList();
        
        
        // Laden/Überladen projektspezifiescher Properties aus resourcen
        Log.ResOpenList( "Load Project Properties..." );
        for( String s : this.ResoursesProperties )
        {
              loadFromResource(s);
        }
        Log.ResCloseList();
    

        Log.ResOpenList( "Load File Properties..." );
        for( String s : this.FileProperties )
        {
              this.loadFromFile(s);
        }
        Log.ResCloseList();
        
        
        // =========================================
        // run specific properties
        // =========================================
        Log.ResOpenList( "Load System Enviroment Vars..." );       
        loadSystemEnviromentVars();
        Log.ResCloseList();
        
        Log.ResOpenList( "Load System Propertie..." );
        loadSystemProperties();
        Log.ResCloseList();
        
        Log.ResCloseList(); // "Update Properties..." 
    }


    /**
     * \~german
     * Eine .Properties-Datei aus dem Resource-Verzeichniss zur Liste 
     * OKW_Properties.ResoursesProperties hinzufügen.
     * 
     * Die zugefügte Property Dateien werden mit updateProperties() geladen bzw. neugeladen.
     *
     * @param fpsFileName 
     * @return
     * \~english
     *
     *
     * @param ? 
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */    
    public Boolean addResource(String fpsResourceName)
    {
        Boolean lvbReturn = true;

        lvbReturn = this.ResoursesProperties.add(fpsResourceName);

        updateProperties();

        return lvbReturn;
    }
    
    
    /**
     * \~german
     * Eine *.Properties-Datei zur Liste OKW_Properties.FileProperties hinzufügen.
     * 
     * Die hinzugefügten Dateien updateProperties
     *
     * @param fpsFileName 
     * @return
     * \~english
     *
     *
     * @param ? 
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */
    public void addPropertiesFile(String fpsFileName)
    {
        this.FileProperties.add(fpsFileName);
        updateProperties();
        return;
    }
    
	/**
	 * \~german Erstellt eine Liste der "*.properties"-Dateien des aktuellen
	 * Projektes
	 * 
	 * Ist eine rekursive Methode
	 *
	 * @param ?
	 * @return \~english
	 *
	 *
	 * @param ?
	 * @return \~
	 * @author Zoltán Hrabovszki
	 * @date 2019-05-07
	 */
	private ArrayList<String> getPropertiesFilesFromResources(String folder) {

		Log.LogFunctionStartDebug("OKW_Properties.getPropertiesFilesFromResources", "folder", folder);

		Log.ResOpenList( "Scan folder: " + folder );

		ArrayList<String> Return = new ArrayList<String>();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(folder);
		String path = "";

		try {
			path = URLDecoder.decode(url.getPath(), Charset.defaultCharset().name() );

			String urlResourceFolder = path.replaceAll(folder, "");

			File[] FoldersAndFiles = new File(path).listFiles();

			for (File FolderOrFile : FoldersAndFiles) {
				// Wenn es sich um ein Verzeichniss handelt
				if (FolderOrFile.isDirectory())
				{
					// System.out.println( "Folder:" + FolderOrFile.getPath() );
					String Folder = FolderOrFile.getPath().replaceAll(urlResourceFolder, "");
					Return.addAll(getPropertiesFilesFromResources(Folder));
				}
				else if (FolderOrFile.isFile())
				{
					// Nur Aufnahmen wenn mit .properies endet
					if (FolderOrFile.getName().endsWith((".properties")))
					{
						// Log.LogPrint( "Property-File: " + FolderOrFile.getPath());
						
						Log.LogPrint( folder + "/" + FolderOrFile.getName().replaceAll(urlResourceFolder, "") );
						Return.add( folder + "/" + FolderOrFile.getName().replaceAll(urlResourceFolder, ""));
					}
				}
			}

		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			Log.ResCloseList();
			Log.LogFunctionEndDebug();
		}
		return Return;
	}
    
    
    
    /**
     * \~german
     * Lädt die Liste OKW_Properties.ResoursesProperties hinzufügen.
     * 
     * Diese Methode liest lediglich die *.properties 
     *
     * @param fpsResource *.properties-Datei die geladen werden soll.
     * @return
     * \~english
     *
     *
     * @param ? 
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */    
    private Boolean loadFromResource(String fpsResource )
    {
        InputStream overwrites = Thread.currentThread().getContextClassLoader().getResourceAsStream( fpsResource );
                
        Boolean lvbReturn = false;
        
        String myLogPrint = "Load Resource: " + fpsResource;

        try
        {
            if (overwrites != null) 
            {
                this.load(overwrites);
                overwrites.close();
                lvbReturn = true;
                myLogPrint = myLogPrint + " - OK";
            }
            else
            {
            	myLogPrint = myLogPrint + " - not found!";
            }
        }
        catch (IOException e)
        {
            lvbReturn = false;
            myLogPrint = myLogPrint + " - failed!";
        }

        Log.LogPrint( myLogPrint );
        return lvbReturn;
    }
    
    
    /**
     * \~german
     * Lädt die Liste OKW_Properties.ResoursesProperties hinzufügen.
     *
     * @param fpsResource *.properties-Datei die geladen werden soll.
     * @return
     * \~english
     *
     *
     * @param ? 
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2018-03-08
     */      
    private Boolean loadFromFile(String fpsPropertiesFile)
    {
        FileInputStream propFile;
        Boolean lvbReturn = false;

        try
        {
            File myFile = new File(fpsPropertiesFile);
            
            if ( myFile.exists() )
            {
                propFile = new FileInputStream( new File(fpsPropertiesFile) );
                this.load(propFile);
                propFile.close();
                lvbReturn = true;
            }
            else
            {
                lvbReturn = false;
                throw new OKWFileDoesNotExistsException( "File: " + fpsPropertiesFile + " does not exists." );
            }
        }
        catch ( Exception e)
        {
            throw new OKWFileDoesNotExistsException( "File: " + fpsPropertiesFile + " does not exists.", e );
        }
        return lvbReturn;
    }

    // =================================================================================
    // Listing the currently defined environment variables and system properties in Java
    // =================================================================================
    // https://www.javamex.com/tutorials/misc-system/environment-variables-listing.shtml
    // https://www.baeldung.com/java-system-get-property-vs-system-getenv
    private void loadSystemEnviromentVars()
    {
          Map<String, String> env = System.getenv();
    
          Log.ResOpenList( "System Enviroment Vars..." );
          
          for (String key : env.keySet())
          {
              String value = env.get(key);
              if (this.containsKey(key))
              {
                 Log.LogPrint( "Überschreibe: " + key + ": '" + this.get(key) + "'");
                 Log.LogPrint( "         mit: " + key + ": '" + value + "'");
              }
              else
              {
                 Log.LogPrint( "    Schreibe: " + key + ": '" + value + "'");
              }
              this.setProperty(key, value);
          }
          
          Log.ResCloseList();
    }


    // https://www.baeldung.com/java-system-get-property-vs-system-getenv
    private void loadSystemProperties()
    {
          Properties mySystemProperties = System.getProperties();

          Set<String> keys = mySystemProperties.stringPropertyNames();

          Log.ResOpenList( "System Properties..." );

          for ( String key : keys )
          {
              String value = (String) mySystemProperties.get(key);
              
              if ( this.containsKey( key ) )
              {
                 Log.LogPrint( "Überschreibe: " + key + ": '" + this.get(key) + "'" );
                 Log.LogPrint( "         mit: " + key + ": '" + value + "'" );
              }
              else
              {
                 Log.LogPrint( "    Schreibe: " + key + ": '" + value + "'" );
              }
              
              this.setProperty(key, value);
          }
          
          Log.ResCloseList();
    }


    public void PrintProperties()
    {

        Log.ResOpenList( "List of Properties..." );

        SortedMap<Object, Object> sortedSystemProperties = new TreeMap<Object, Object>(this);
        Set<Object> keySet = sortedSystemProperties.keySet();
        Iterator<Object> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            String propertyName = (String) iterator.next();
            String propertyValue = this.getProperty(propertyName);
            Log.LogPrint( propertyName + ": " + propertyValue );
        }
        
        Log.ResCloseList();
    }


    /**
     * \~german
     * Druckt die Gefundenen Propertie Quellen
     *
     * \~english
     *
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-05-07
     */ 
    public void PrintPropertiesSources()
    {

        Iterator<String> iterator = null;
        Log.ResOpenList( "Properties Sources..." );
        
        // =============================================
        // Core sources
        // =============================================
        Log.ResOpenList( "Core sources..." );
        iterator = CoreProperties.iterator();

        while ( iterator.hasNext())
        {
            String  mySource = iterator.next();
            Log.LogPrint( mySource );
        }
        
        Log.ResCloseList();
        
        // =============================================
        // Project specific sources
        // =============================================

        Log.ResOpenList( "Project specific sources..." );
        iterator = ResoursesProperties.iterator();

        while ( iterator.hasNext())
        {
            String  mySource = iterator.next();
            Log.LogPrint( mySource );
        }
        Log.ResCloseList();

        // =============================================
        // File sources
        // =============================================

        Log.ResOpenList( "File sources..." );
        iterator = FileProperties.iterator();

        while ( iterator.hasNext())
        {
            String  mySource = iterator.next();
            Log.LogPrint( mySource );
        }
        Log.ResCloseList();

        
        Log.ResCloseList();

    }


    /**
     * \~german
     * Ermittelt alle Properties die mit dem gegebenen String Anfangen
     * 
     * Beispiel:
     * keysStartswith( "frmSeChrome.options" ) holt alle Properties wie
     *  - frmSeChrome.option.disable-logging=disable-logging
     *  - frmSeChrome.option.version=version
     *  - frmSeChrome.option.ignore-certificate-errors=ignore-certificate-errors
     * 
     * \~english
     *
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-05-07
     */
    public ArrayList<String> getKeysStartswith( String Startwitth ) throws IOException
    {
        ArrayList<String> Return = new ArrayList<String>();

        Set<String> keys = this.stringPropertyNames();

        for ( String key : keys )
        {
            if ( key.startsWith( Startwitth ) )
            {
                Return.add( key );
            }
        }
        return Return;
    }
    
    
    /**
     * \~german
     * Ermittelt alle Properties der keys, die mit dem gegebenen String Startwitth Anfangen.
     * 
     * Beispiel:
     * keysStartswith( "frmSeChrome.options" ) holt alle Properties wie
     *  - frmSeChrome.option.disable-logging=disable-logging
     *  - frmSeChrome.option.version=version
     *  - frmSeChrome.option.ignore-certificate-errors=ignore-certificate-errors
     * 
     * @Startwith Zeichen, mit den die keys Anfangen müssen. im Beispiel "frmSeChrome.options"
     * @return ArrayList der Werte. Im Beispiel [ "disable-logging","version","ignore-certificate-errors"]
     * 
     * \~english
     *
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-05-07
     */
    public ArrayList<String> getPropertiesForKeysStartswith( String Startwith ) throws IOException
    {
        ArrayList<String> Return = new ArrayList<String>();

        Set<String> keys = this.stringPropertyNames();

        for ( String key : keys )
        {
            if ( key.startsWith( Startwith ) )
            {
                Return.add( this.getProperty( key ) );
            }
        }
        return Return;
    }
}