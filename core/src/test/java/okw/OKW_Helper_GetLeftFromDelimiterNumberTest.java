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

package okw;

import javax.xml.xpath.XPathExpressionException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import okw.log.*;

@Tag( "AllCoreHelperTests" )
public class OKW_Helper_GetLeftFromDelimiterNumberTest
{
    /**
     *  \copydoc CurrentObject::Log()
     */
    public static Logger_Sngltn Log;

    //@BeforeAll
    public static void myTestFixtureSetUp()
    {
        Log = Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        //Log.AddLogger(new Log2Console());
        Log.setDebugMode( false );
    }

    @ParameterizedTest
    @CsvSource( value = { "'AAAA',       'AAAAGGBBBBGGDDDD', 'GG', 1 ",
                    "'AAAAGGBBBB', 'AAAAGGBBBBGGDDDD', 'GG', 2 ",
                    "'AAAA',       'AAAACBBBB', 'C', 1 ",
                    "'AAAACBBBB',  'AAAACBBBBCDDDD', 'C', 2 ",
                    "'AAAA',       'AAAACBBBBCDDDD', 'C', 1 ",
                    "'AAA',             'AAA/BBB/CCC/DDD/EEE', '/', 1 ",
                    "'AAA/BBB',         'AAA/BBB/CCC/DDD/EEE', '/', 2 ",
                    "'AAA/BBB/CCC',     'AAA/BBB/CCC/DDD/EEE', '/', 3 ",
                    "'AAA/BBB/CCC/DDD', 'AAA/BBB/CCC/DDD/EEE', '/', 4 " } )
    public void tcMatchStr( String ExpectedValue, String InputSource, String InputDelimiter, int InputCount ) throws XPathExpressionException
    {
        String actual = "";
        actual = OKW_Helper.getLeftFromDelimiterNumber( InputSource, InputDelimiter, InputCount );

        assertEquals( ExpectedValue, actual );
    }
}
