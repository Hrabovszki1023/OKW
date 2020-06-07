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

import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import okw.log.Logger_Sngltn;

import static org.junit.jupiter.api.Assertions.*;


@Tag("AllCoreHelperTests")
public class OKW_Helper_GetRightFromDelimiterNumberTest
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
            @CsvSource( value = { "'BBBB', 'AAAACBBBB', 'C,  1 ",
        		" 'BBBBCDDDD',       'AAAACBBBBCDDDD',      'C',  1 ",
        		
        		" 'BBBBGGDDDD',      'AAAAGGBBBBGGDDDD',    'GG', 1 ",
        		" 'DDDD',            'AAAAGGBBBBGGDDDD',    'GG', 2 ",

        		" 'BBB/CCC/DDD/EEE', 'AAA/BBB/CCC/DDD/EEE', '/', 1 ",
        		" 'CCC/DDD/EEE',     'AAA/BBB/CCC/DDD/EEE', '/', 2 ",
        		" 'DDD/EEE',         'AAA/BBB/CCC/DDD/EEE', '/', 3 ",
        		" 'EEE',             'AAA/BBB/CCC/DDD/EEE', '/', 4 " })
        public void tcMatchStr( String ExpectedValue, String InputSource, String InputDelimiter, int InputCount) throws XPathExpressionException
        {
            String actual = "";
            String expected = ExpectedValue;

            actual = OKW_Helper.getRightFromDelimiterNumber( InputSource, InputDelimiter, InputCount);
            assertEquals(expected, actual);
        }
}




