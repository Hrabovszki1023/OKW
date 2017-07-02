/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

//import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;

public class OKW_FileHelperTest
{

    /**    @BeforeClass
    public static void myBeforeClass()
    {
        // TODO: Add Init code.
    }
    
    @AfterClass
    public static void myAfterClass()
    {
        // TODO: Add tear down code.
    }
    */

    @Test
    public void tcDosPath2UnixPath()
    {
        String lsDosPath = "\\abc\\abc\\file.ext";
        String lsUnixPath = "/abc/abc/file.ext";

        String CurrentFileSeparator = System.getProperty( "file.separator" );

        if ( "\\".equals( CurrentFileSeparator ) )
            assertEquals( lsDosPath, OKW_FileHelper.convertDirectorySeperator( lsUnixPath ) );
        else if ( "/".equals( CurrentFileSeparator ) )
            assertEquals( lsUnixPath, OKW_FileHelper.convertDirectorySeperator( lsDosPath ) );
        else
            fail( "DirectorySearatorChar ist weder UNIX noc DOS typisch: " + CurrentFileSeparator );
    }
}
