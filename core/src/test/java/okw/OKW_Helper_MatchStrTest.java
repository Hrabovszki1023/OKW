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

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import okw.log.*;

@Tag("AllCoreHelperTests")
public class OKW_Helper_MatchStrTest
    {
    
    // \copydoc CurrentObject::Log()
    public static Logger_Sngltn Log;
    

    
		//@BeforeAll
        public static void myTestFixtureSetUp()
        {
			Log = Logger_Sngltn.getInstance();
            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.init();

            //Log.AddLogger(new Log2Console());
            Log.setDebugMode(false);
        }

        @ParameterizedTest
        @CsvSource( value = {     
                        " false, 'Hase',         'hase' ",
                        " false, 'Fux*Bär',      'Fux, hase, bär' ",
                        " false, 'Fux, hase*',   'Fux, Hase, Bär' ",
                        " false, '*Hase, bär',   'Fux, Hase, Bär' ",
                        " false, 'Fux*Hase*Bär', 'Fux, hase, bär' ",
                        
                        " true, 'Hase',         'Hase' ",
                        " true, 'Hase*',        'Hase' ",
                        " true, '*Hase',        'Hase' ",
                        " true, '*Hase*',       'Hase' ",
                        
                        " true, 'Fux, Hase*',   'Fux, Hase, Bär' ",
                        " true, 'Fux*Bär',      'Fux, Hase, Bär' ",
                        
                        " false, '*Hase*',     'Fux, hASE, bär' ",
                        " false, '*Hase, bär', 'Fux, Hase, Bär' "
        })
        public void tcMatchStr(Boolean ExpectedValue, String InputValue_1, String InputValue_2)
        {
            Boolean actual = false;
            Boolean expected = ExpectedValue;

            actual = OKW_Helper.matchString( InputValue_1, InputValue_2);
            assertEquals(expected, actual);
        }
}
