/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

package okw.junit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;



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
 * \date 2019-08-06
 */
public class JUnitBase
{

    String ClassName = this.getClass().getSimpleName();
    
    public String TestName;

    @BeforeEach
    void init(TestInfo testInfo)
    {
        TestName = testInfo.getTestMethod().get().getName();
    }

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
     * \date 2019-08-06
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
