/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

import javax.xml.xpath.XPathExpressionException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import okw.log.*;

@RunWith(Parameterized.class)
public class OKW_Helper_GetLeftFromDelimiterNumberTest
    {
    
    private String ExpectedValue;
    
    private String InputSource;
    private String InputDelimiter;
    private int    InputCount;
    
    /**
     *  \copydoc CurrentObject::Log()
     */
    public static Logger_Sngltn Log;

    @Parameters( name = "{index}: {0} = GetRigthFromDelimiterNumber[\"{1}\", \"{2}\", \"{3}\"] " )
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ "AAAA",       "AAAAGGBBBBGGDDDD", "GG", 1 },
        		{ "AAAAGGBBBB", "AAAAGGBBBBGGDDDD", "GG", 2},

        		{ "AAAA",       "AAAACBBBB", "C", 1},

        		{ "AAAACBBBB",  "AAAACBBBBCDDDD", "C", 2},
        		{ "AAAA",       "AAAACBBBBCDDDD", "C", 1 },

        		{ "AAA",             "AAA/BBB/CCC/DDD/EEE", "/", 1 },
        		{ "AAA/BBB",         "AAA/BBB/CCC/DDD/EEE", "/", 2 },
        		{ "AAA/BBB/CCC",    "AAA/BBB/CCC/DDD/EEE", "/", 3 },
        		{ "AAA/BBB/CCC/DDD", "AAA/BBB/CCC/DDD/EEE", "/", 4 }
           });
    }

    public OKW_Helper_GetLeftFromDelimiterNumberTest(String ExpectedValue, String InputSource, String InputDelimiter, int InputCount) {
    	
    	   this.ExpectedValue  = ExpectedValue;
    	    
    	   this.InputSource    = InputSource;
    	   this.InputDelimiter = InputDelimiter;
    	   this.InputCount     = InputCount;
    	   }
    

		//@BeforeClass
        public static void myTestFixtureSetUp()
        {
			Log = Logger_Sngltn.getInstance();
            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.init();

            //Log.AddLogger(new Log2Console());
            Log.setDebugMode(false);
        }

        @Test
        public void tcMatchStr() throws XPathExpressionException
        {
            String actual = "";
            String expected = ExpectedValue;

            actual = OKW_Helper.getLeftFromDelimiterNumber( InputSource, InputDelimiter, InputCount);
            assertEquals(expected, actual);
        }
}




