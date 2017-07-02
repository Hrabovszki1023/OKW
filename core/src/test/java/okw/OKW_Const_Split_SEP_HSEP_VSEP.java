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
public class OKW_Const_Split_SEP_HSEP_VSEP
    {
    
    
    private ArrayList<String> ExpectedValue;
    
    private String Language;
    private String SEPType;
    private String InputValue_1;
    
    /// \copydoc CurrentObject::Log()
    public static Logger_Sngltn Log;


    @Parameters( name = "{index}: Language={1}, \"{0}\" = Split{2}(\"{3}\") " )
    public static Collection<Object[]> data()
    {
        return Arrays.asList( new Object[][]
        {

                        // ------------------------------------------------------------------------------------------------------------------------
                        // - SEP
                        // ------------------------------------------------------------------------------------------------------------------------

                        { new ArrayList<String>( Arrays.asList( "" ) ), "de", "SEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "de", "SEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "de", "SEP", "Wert1${SEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "de", "SEP", "Wert1${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "de", "SEP", "${SEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "de", "SEP", "${SEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "de", "SEP", "Wert1${SEP}Wert2${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "de", "SEP", "Wert1${SEP}Wert2${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "de", "SEP", "Wert1${SEP}${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "de", "SEP", "${SEP}Wert2${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "de", "SEP", "${SEP}Wert2${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "de", "SEP", "${SEP}${SEP}" },

                        { new ArrayList<String>( Arrays.asList( "" ) ), "en", "SEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "en", "SEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "en", "SEP", "Wert1${SEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "en", "SEP", "Wert1${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "en", "SEP", "${SEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "en", "SEP", "${SEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "en", "SEP", "Wert1${SEP}Wert2${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "en", "SEP", "Wert1${SEP}Wert2${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "en", "SEP", "Wert1${SEP}${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "en", "SEP", "${SEP}Wert2${SEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "en", "SEP", "${SEP}Wert2${SEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "en", "SEP", "${SEP}${SEP}" },

                        // ------------------------------------------------------------------------------------------------------------------------
                        // - HSEP
                        // ------------------------------------------------------------------------------------------------------------------------

                        { new ArrayList<String>( Arrays.asList( "" ) ), "de", "HSEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "de", "HSEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "de", "HSEP", "Wert1${HSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "de", "HSEP", "Wert1${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "de", "HSEP", "${HSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "de", "HSEP", "${HSEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "de", "HSEP", "Wert1${HSEP}Wert2${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "de", "HSEP", "Wert1${HSEP}Wert2${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "de", "HSEP", "Wert1${HSEP}${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "de", "HSEP", "${HSEP}Wert2${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "de", "HSEP", "${HSEP}Wert2${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "de", "HSEP", "${HSEP}${HSEP}" },

                        { new ArrayList<String>( Arrays.asList( "" ) ), "en", "HSEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "en", "HSEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "en", "HSEP", "Wert1${HSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "en", "HSEP", "Wert1${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "en", "HSEP", "${HSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "en", "HSEP", "${HSEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "en", "HSEP", "Wert1${HSEP}Wert2${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "en", "HSEP", "Wert1${HSEP}Wert2${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "en", "HSEP", "Wert1${HSEP}${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "en", "HSEP", "${HSEP}Wert2${HSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "en", "HSEP", "${HSEP}Wert2${HSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "en", "HSEP", "${HSEP}${HSEP}" },

                        // ------------------------------------------------------------------------------------------------------------------------
                        // - VSEP
                        // ------------------------------------------------------------------------------------------------------------------------

                        { new ArrayList<String>( Arrays.asList( "" ) ), "de", "VSEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "de", "VSEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "de", "VSEP", "Wert1${VSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "de", "VSEP", "Wert1${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "de", "VSEP", "${VSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "de", "VSEP", "${VSEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "de", "VSEP", "Wert1${VSEP}Wert2${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "de", "VSEP", "Wert1${VSEP}Wert2${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "de", "VSEP", "Wert1${VSEP}${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "de", "VSEP", "${VSEP}Wert2${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "de", "VSEP", "${VSEP}Wert2${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "de", "VSEP", "${VSEP}${VSEP}" },

                        { new ArrayList<String>( Arrays.asList( "" ) ), "en", "VSEP", "" },

                        { new ArrayList<String>( Arrays.asList( "WERT" ) ), "en", "VSEP", "WERT" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2" ) ), "en", "VSEP", "Wert1${VSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "" ) ), "en", "VSEP", "Wert1${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2" ) ), "en", "VSEP", "${VSEP}Wert2" },
                        { new ArrayList<String>( Arrays.asList( "", "" ) ), "en", "VSEP", "${VSEP}" },

                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "Wert3" ) ), "en", "VSEP", "Wert1${VSEP}Wert2${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "Wert2", "" ) ), "en", "VSEP", "Wert1${VSEP}Wert2${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "Wert1", "", "Wert3" ) ), "en", "VSEP", "Wert1${VSEP}${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "Wert3" ) ), "en", "VSEP", "${VSEP}Wert2${VSEP}Wert3" },
                        { new ArrayList<String>( Arrays.asList( "", "Wert2", "" ) ), "en", "VSEP", "${VSEP}Wert2${VSEP}" },
                        { new ArrayList<String>( Arrays.asList( "", "", "" ) ), "en", "VSEP", "${VSEP}${VSEP}" },

        } );
    }

    public OKW_Const_Split_SEP_HSEP_VSEP(ArrayList<String> ExpectedValue, String Language, String SEPType, String InputValue_1) {
    	
    	   this.ExpectedValue = ExpectedValue;

    	   this.Language = Language;
    	   this.SEPType = SEPType;
    	   this.InputValue_1 = InputValue_1;
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
        public void tcMatchStr() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
        	ArrayList<String> actual = null ;
            ArrayList<String> expected = ExpectedValue;

			OKWLanguage.getInstance().setLanguage(Language);
            
            if ( "SEP".equals( SEPType) )
            {
            	actual = OKW_Const_Sngltn.getInstance().SplitSEP(InputValue_1);	
            }
            else if ( "HSEP".equals( SEPType) )
            {
            	actual = OKW_Const_Sngltn.getInstance().SplitHSEP(InputValue_1);	
            }
            else if ( "VSEP".equals( SEPType ) )
            {
            	actual = OKW_Const_Sngltn.getInstance().SplitVSEP(InputValue_1);	
            }
            else
            {
            	fail("Wrong SEP-Type: >>" + SEPType + "<<");
            }
            
            assertEquals(expected, actual);
        }
}
