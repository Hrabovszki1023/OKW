package okw.junit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.junit.Rule;
import org.junit.rules.TestName;


/**
 * \~german
 * OKW Basisklasse für OKW interne JUnit Test.
 * 
 * Stellt den Testfall-Namen in der Klassen variablen JUnitBase.name zur Verfügung.
 * 
 * Stellt Funktion/Methode JUnitBase.loadUTF8FileFromResource(String) zum Lasen einer Referenz-Datei aus "resources".
 * 
 * \~english
 * OKW base class for OKW internal JUnit test.
 * 
 * Provides the test case name in the variable JUnitBase.name classes.
 * 
 * Provides function/method JUnitBase.loadUTF8FileFromResource(String) for reading a reference file from resources.
 *
 * \~
 * @author Zoltán Hrabovszki
 * @date 2019-08-06
 */
public class JUnitBase
{

    String ClassName = this.getClass().getSimpleName();
    
    @Rule
    public TestName name = new TestName();

    /**
     * \~german
     * Lädt eine Resource Datei, die als Referenz datei in einem Assert verwendet werden kann.
     *
     * @param resorceFilename
     * @return Den Inhalt der Resource Datei als String 
     * \~english
     *
     *
     * @param resorceFilename
     * @return
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-08-06
     */
    public String loadUTF8FileFromResource( String resorceFilename )
    {

        StringBuilder myJSON = new StringBuilder();

        try
        {

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream( resorceFilename );
            InputStreamReader streamReader = new InputStreamReader( inputStream, StandardCharsets.UTF_8 );
            BufferedReader reader = new BufferedReader( streamReader );

            Boolean GreaterOne = false;

            for ( String line; ( line = reader.readLine() ) != null; )
            {
                if (GreaterOne) myJSON.append( "\n" ); 
                else GreaterOne = true;
                myJSON.append( line );
            }

        }
        catch (FileNotFoundException fnfe)
        {
            // process errors
        }
        catch (IOException ioe)
        {
            // process errors
        }
        return myJSON.toString();
    }
}
