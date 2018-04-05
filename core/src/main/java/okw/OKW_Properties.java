package okw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

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
    /**
     * \~german
     * Liste der einzubindenen *.properties Dateien, die aus dem Resourcen Verzeichniss.
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
     * Eine .Properties-Datei aus dem Resource-Verzeichniss zur Liste 
     * OKW_Properties.ResoursesProperties hinzufügen.
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
    public Boolean addFile(String fpsFileName)
    {
        Boolean lvbReturn = true;

        if (this.FileProperties.add(fpsFileName))
        {
            updateProperties();
        }
        else
        {
            lvbReturn = false;
        }
        
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
    private Boolean loadFromResource(String fpsResource )
    {
        InputStream overwrites = OKW_Properties.class.getClassLoader().getResourceAsStream( fpsResource );
        Boolean lvbReturn = false;

        try
        {
            if (overwrites != null) 
            {
                this.load(overwrites);
                overwrites.close();
                lvbReturn = true;
            }
        }
        catch (IOException e)
        {
            lvbReturn = false;
        }

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
            propFile = new FileInputStream(new File(fpsPropertiesFile));
            this.load(propFile);
            propFile.close();
        }
        catch (IOException e)
        {
        }
        return lvbReturn;
    }

    /**
     * \~german
     * Löscht die Properties Listen
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
        this.ResoursesProperties.clear();
        this.FileProperties.clear();

        this.updateProperties();
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
        super.clear();

        for(String s : this.ResoursesProperties)
        {
              this.loadFromResource(s);
        }

        for(String s : this.FileProperties)
        {
              this.loadFromFile(s);
        }

        this.putAll(System.getProperties());
    }

    
    public void PrintProperties()
    {

        SortedMap<Object, Object> sortedSystemProperties = new TreeMap<Object, Object>(this);
        Set<Object> keySet = sortedSystemProperties.keySet();
        Iterator<Object> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            String propertyName = (String) iterator.next();
            String propertyValue = this.getProperty(propertyName);
            System.out.println(propertyName + ": " + propertyValue);
        }
    }
}