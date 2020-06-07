
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


import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

import okw.log.*;

@Tag("AllCoreHelperTests")
public class OKW_Const_GetConst4Internalname
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
        Log.setDebugMode(false);
    }

    @ParameterizedTest
    @CsvSource( value = {
    "'HSEP',     'de',   'HSEP'",
    "'HSEP',     'en',   'HSEP'",
    
    "'SEP',      'de',   'SEP'",
    "'SEP',      'en',   'SEP'",
    
    "'VSEP',      'de',   'VSEP'",
    "'VSEP',      'en',   'VSEP'",

    "'${',       'de',   'LEFTBRACE'",
    "'}',        'en',   'RIGHTBRACE'",
    
    // Werte
    "'JA',            'de', 'YES'",
    "'YES',           'en', 'YES'",
    
    "'NEIN',          'de',   'NO'",
    "'NO',            'en',   'NO'",
    
    "'ABGEWÄHLT',     'de', 'UNCHECKED'",
    "'UNCHECKED',     'en', 'UNCHECKED'",
    
    "'ANGEWÄHLT',     'de', 'CHECKED'",
    "'CHECKED',       'en', 'CHECKED'",
    
    // Befehle
    "'LÖSCHEN',    'de', 'DELETE'",
    "'DELETE',     'en', 'DELETE'",

    "'IGNORIEREN', 'de', 'IGNORE'",
    "'IGNORE',     'en', 'IGNORE'",

    "'LEER',       'de', 'EMPTY'",
    "'EMPTY',      'en', 'EMPTY'"}, delimiter = ',' )
    public void TC_MatchStr(
                        String ExpectedValue,
                        String SelectLanguage,
                        String InputValue_1
                    ) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
        String actual = "";
        String expected = ExpectedValue;
        
		OKWLanguage.getInstance().setLanguage(SelectLanguage);
        actual = OKW_Const_Sngltn.getInstance().GetConst4Internalname( InputValue_1);
        assertEquals(expected, actual);
    }
}
