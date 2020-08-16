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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

// FIXME: Testfalle laufen nicht. -> beheben!
@Tag("AllCoreHelperTests")
public class OKW_Properties_SetDOptionsTest {

    protected OKW_Properties myProperties = OKW_Properties.getInstance();

    @Test
    public final void clear_Test() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");
        myProperties.PrintProperties();

        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
        assertEquals( "Oracle Corporation", myProperties.get("java.vendor"));

        myProperties.clear();   
        assertEquals( null, myProperties.get("Wert0"));
        assertEquals( null, myProperties.get("Wert1"));
        assertEquals( "NEWVALUE", myProperties.get("Wert2"));
        assertEquals( null, myProperties.get("Wert3"));
        assertEquals( null, myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
        assertEquals( "Oracle Corporation", myProperties.get("java.vendor"));
    }

    @Test
    public final void loadFromResourceTest() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");

        myProperties.PrintProperties();

        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
    }

    @Test
    public final void loadFromResource_OVERLOAD_Test() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");
        myProperties.PrintProperties();
        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));

        myProperties.addResource("OKW_PropertiesTest/properties_Test2.properties");
        myProperties.PrintProperties();
        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));

        assertEquals("Wert 1 aus properties_Test2", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test2", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test2", myProperties.get("Wert4"));
        assertEquals("Wert 5 aus properties_Test2", myProperties.get("Wert5"));
        assertEquals( null, myProperties.get("Wert6"));
    }
}
