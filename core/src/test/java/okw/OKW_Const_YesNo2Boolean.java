
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

@RunWith( Parameterized.class )
public class OKW_Const_YesNo2Boolean
{

    private Boolean ExpectedValue;

    private String  SelectLanguage;
    private String  InputValue_1;

    @Parameters( name = "{index} {1}: {0} = GetOKWConst4Internalname[>>{2}<<] " )
    public static Collection<Object[]> data()
    {
        return Arrays.asList( new Object[][]
        {
                        //Separatoren
                        { true, "de", "JA" },
                        { true, "en", "YES" },

                        { true, "de", "ja" },
                        { true, "en", "yes" },

                        { false, "de", "NEIN" },
                        { false, "en", "NO" },

                        { false, "de", "nein" },
                        { false, "en", "no" }, } );
    }

    public OKW_Const_YesNo2Boolean( Boolean ExpectedValue, String SelectLanguage, String InputValue_1 )
    {

        this.ExpectedValue = ExpectedValue;

        this.SelectLanguage = SelectLanguage;
        this.InputValue_1 = InputValue_1;
    }

    /// \copydoc CurrentObject::Log()
    public static Logger_Sngltn Log;

    //@BeforeClass
    public static void myTestFixtureSetUp()
    {
        Log = Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        //Log.AddLogger(new Log2Console());
        Log.setDebugMode( false );
    }

    @Test
    public void TC_MatchStr() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
        Boolean actual;
        Boolean expected = ExpectedValue;

        OKWLanguage.getInstance().setLanguage( SelectLanguage );
        actual = OKW_Const_Sngltn.getInstance().YesNo2Boolean( InputValue_1 );
        assertEquals( expected, actual );
    }
}
