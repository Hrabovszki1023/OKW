/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.jupiter.api.Assertions.*;
import okw.log.*;

@RunWith( Parameterized.class )
@Tag("AllCoreHelperTests")
public class OKW_Helper_RemoveBeginQuotationsTest
{

    private String              ExpectedValue;
    private String              InputValue_1;

    /*
     *  \copydoc CurrentObject::Log()
     */
    public static Logger_Sngltn Log;

    @Parameters( name = "{index}: {0} = RemoveBeginEndQuotations[>>{1}<<] " )
    public static Collection<Object[]> data()
    {
        return Arrays.asList( new Object[][]
        {
                        { "", "\"\"" },
                        { "A", "\"A\"" },
                        { "ABC", "\"ABC\"" },
                        { "\"", "\"\"\"" },
                        { "A\"", "\"A\"\"" },
                        { "Fuchs \"liebt\" Hase", "Fuchs \"liebt\" Hase" },
                        { "Fuchs \"liebt\" Hase", "\"Fuchs \"liebt\" Hase\"" } } );
    }

    public OKW_Helper_RemoveBeginQuotationsTest( String ExpectedValue, String InputValue_1 )
    {

        this.ExpectedValue = ExpectedValue;

        this.InputValue_1 = InputValue_1;
    }

    //@BeforeAll
    public static void myTestFixtureSetUp()
    {
        Log = Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        //Log.AddLogger(new Log2Console());
        Log.setDebugMode( false );
    }

    @Test
    public void tcMatchStr()
    {
        String actual = "";
        String expected = ExpectedValue;

        actual = OKW_Helper.removeBeginEndQuotations( InputValue_1 );
        assertEquals( expected, actual );
    }
}
