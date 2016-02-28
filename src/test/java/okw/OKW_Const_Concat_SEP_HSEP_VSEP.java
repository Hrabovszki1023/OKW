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


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import static org.junit.Assert.*;
import okw.log.*;

@RunWith(Parameterized.class)
public class OKW_Const_Concat_SEP_HSEP_VSEP
    {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		
           		// ------------------------------------------------------------------------------------------------------------------------
        		// - SEP
        		// ------------------------------------------------------------------------------------------------------------------------
        		
        		{ "",                             "de", "SEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "de", "SEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${SEP}Wert2",             "de", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${SEP}",                  "de", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${SEP}Wert2",                  "de", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${SEP}",                       "de", "SEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${SEP}Wert2${SEP}Wert3",  "de", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${SEP}Wert2${SEP}",       "de", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${SEP}${SEP}Wert3",       "de", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${SEP}Wert2${SEP}Wert3",       "de", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${SEP}Wert2${SEP}",            "de", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${SEP}${SEP}",                 "de", "SEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },

        		
        		{ "",                             "en", "SEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "en", "SEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${SEP}Wert2",             "en", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${SEP}",                  "en", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${SEP}Wert2",                  "en", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${SEP}",                       "en", "SEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${SEP}Wert2${SEP}Wert3",  "en", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${SEP}Wert2${SEP}",       "en", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${SEP}${SEP}Wert3",       "en", "SEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${SEP}Wert2${SEP}Wert3",       "en", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${SEP}Wert2${SEP}",            "en", "SEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${SEP}${SEP}",                 "en", "SEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },       	

           		// ------------------------------------------------------------------------------------------------------------------------
        		// - VSEP
        		// ------------------------------------------------------------------------------------------------------------------------
        		
        		{ "",                             "de", "VSEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "de", "VSEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${VSEP}Wert2",             "de", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${VSEP}",                  "de", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${VSEP}Wert2",                  "de", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${VSEP}",                       "de", "VSEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${VSEP}Wert2${VSEP}Wert3",  "de", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${VSEP}Wert2${VSEP}",       "de", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${VSEP}${VSEP}Wert3",       "de", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${VSEP}Wert2${VSEP}Wert3",       "de", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${VSEP}Wert2${VSEP}",            "de", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${VSEP}${VSEP}",                 "de", "VSEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },

        		
        		{ "",                             "en", "VSEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "en", "VSEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${VSEP}Wert2",             "en", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${VSEP}",                  "en", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${VSEP}Wert2",                  "en", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${VSEP}",                       "en", "VSEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${VSEP}Wert2${VSEP}Wert3",  "en", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${VSEP}Wert2${VSEP}",       "en", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${VSEP}${VSEP}Wert3",       "en", "VSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${VSEP}Wert2${VSEP}Wert3",       "en", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${VSEP}Wert2${VSEP}",            "en", "VSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${VSEP}${VSEP}",                 "en", "VSEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },       	
        
           		// ------------------------------------------------------------------------------------------------------------------------
        		// - HSEP
        		// ------------------------------------------------------------------------------------------------------------------------
        		
        		{ "",                             "de", "HSEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "de", "HSEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${HSEP}Wert2",             "de", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${HSEP}",                  "de", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${HSEP}Wert2",                  "de", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${HSEP}",                       "de", "HSEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${HSEP}Wert2${HSEP}Wert3",  "de", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${HSEP}Wert2${HSEP}",       "de", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${HSEP}${HSEP}Wert3",       "de", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${HSEP}Wert2${HSEP}Wert3",       "de", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${HSEP}Wert2${HSEP}",            "de", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${HSEP}${HSEP}",                 "de", "HSEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },

        		
        		{ "",                             "en", "HSEP",  new ArrayList<String>(Arrays.asList( "" )) },
        		{ "WERT",                         "en", "HSEP",  new ArrayList<String>(Arrays.asList( "WERT" )) },
        		
        		{ "Wert1${HSEP}Wert2",             "en", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2" )) },
        		{ "Wert1${HSEP}",                  "en", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "" )) },
        		{ "${HSEP}Wert2",                  "en", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2" )) },
        		{ "${HSEP}",                       "en", "HSEP",  new ArrayList<String>(Arrays.asList( "", "" )) },
        		
        		{ "Wert1${HSEP}Wert2${HSEP}Wert3",  "en", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "Wert3" )) },
        		{ "Wert1${HSEP}Wert2${HSEP}",       "en", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "Wert2", "" )) },
        		{ "Wert1${HSEP}${HSEP}Wert3",       "en", "HSEP",  new ArrayList<String>(Arrays.asList( "Wert1", "", "Wert3" )) },
        		{ "${HSEP}Wert2${HSEP}Wert3",       "en", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "Wert3" )) },

        		{ "${HSEP}Wert2${HSEP}",            "en", "HSEP",  new ArrayList<String>(Arrays.asList( "", "Wert2", "" )) },
        		{ "${HSEP}${HSEP}",                 "en", "HSEP",  new ArrayList<String>(Arrays.asList( "", "", "" )) },       	       
        });
    }
    
    private String ExpectedValue;
    
    private String Language;
    private String SEPType;
    private ArrayList<String> InputValue_1;

    public OKW_Const_Concat_SEP_HSEP_VSEP(String ExpectedValue, String Language, String SEPType, ArrayList<String> InputValue_1) {
    	
    	   this.ExpectedValue = ExpectedValue;

    	   this.Language = Language;
    	   this.SEPType = SEPType;
    	   this.InputValue_1 = InputValue_1;
    	   }
    
	/// \copydoc CurrentObject::Log()
	public static Logger_Sngltn Log;

		//@BeforeClass
        public static void myTestFixtureSetUp()
        {
			Log = Logger_Sngltn.getInstance();
            // Reset des Loggers: Alle geladenen Instanzen löschen
            Log.Init();

            //Log.AddLogger(new Log2Console());
            Log.setDebugMode(false);
        }

        @Test
        public void TC_MatchStr() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
        	String actual = null ;
            String expected = ExpectedValue;

			OKWLanguage.getInstance().setLanguage(Language);
            
            if (SEPType.equals("SEP"))
            {
            	actual = OKW_Const_Sngltn.getInstance().ConcatSEP(InputValue_1);	
            }
            else if (SEPType.equals("HSEP"))
            {
            	actual = OKW_Const_Sngltn.getInstance().ConcatHSEP(InputValue_1);	
            }
            else if (SEPType.equals("VSEP"))
            {
            	actual = OKW_Const_Sngltn.getInstance().ConcatVSEP(InputValue_1);	
            }
            else
            {
            	fail("Wrong SEP-Type: >>" + SEPType + "<<");
            }
            
            assertEquals(expected, actual);
        }
}
