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

 /*  <code> fpsL = "//div[@ID='myID']"</code> -> <code>return = "//div[@ID='myID']"</code>
  *  <code> fpsL = "4T!MyValue"</code> -> <code>return = "//*[@data-4Test='MyValue']"</code>
  *  <code> fpsL = "4TNA!MyValue"</code> -> <code>return = "//*[contains( @name, 'MyValue']"</code>
  *  <code> fpsL = "4TID!MyValue"</code> -> <code>return = "//*[contains( @ID, 'MyValue']"</code>
  *  <code> fpsL = "4TLA!MyValue"</code> -> <code>return = "//label[contains(text(),'MyValue')]/following-sibling::input"</code>
  *  <code> fpsL = "4TTX!MyValue"</code> -> <code>return = "//*[contains(text(),'MyValue')]"</code>
  */
@Tag("AllCoreHelperTests")
public class fourTestLocatorTest {
	private fourTestLocator myLocator = new fourTestLocator("");
	
     
    @Test
    public void tcNon4TestLocator() throws Exception
    {
    	assertEquals( "//div[@ID='myID']", myLocator.get4TestLocator( "//div[@ID='myID']" )  );
    }


    @Test
    public void tc_4T_Locator() throws Exception
    {
    	assertEquals( "//*[@data-harmony-id=\"MyLocator\"]", myLocator.get4TestLocator( "4T!MyLocator" )  );
    }

    
    @Test
    public void tc_4T_LocatorMitClass() throws Exception
    {
    	assertEquals( "//*[@data-harmony-id=\"MyLocator\"]", myLocator.get4TestLocator( "4T!myClass::MyLocator" )  );
        assertEquals( "myClass", myLocator.getGUIClass() );
        assertEquals( "//*[@data-harmony-id=\"MyLocator\"]", myLocator.getLocator() );
    }

    @Test
    public void tc_4T_SeperateLocator() throws Exception
    {
        assertEquals( 0, myLocator.seperateClassnameAndLocator( "myClass::MyLocator" ) );
    }

    @Test
    public void tc_4T_SeperateLocator_fehler() throws Exception
    {
        assertEquals( -1, myLocator.seperateClassnameAndLocator( "myClass::myClass::MyLocator" ) );
    }
    
    
    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TAI_Locator() throws Exception
    {
        assertEquals( "//*[@AutomationID='MyLocator']", myLocator.get4TestLocator( "4TAI!MyLocator" )  );
    }
    
    
    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TNA_Locator() throws Exception
    {
        	assertEquals( "//*[contains(@name,'MyLabelText')]", myLocator.get4TestLocator( "4TNA!MyLabelText" )  );
    }
  
    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TID_Locator() throws Exception
    {
        	assertEquals( "//*[contains(@id,'MyLabelText')]", myLocator.get4TestLocator( "4TID!MyLabelText" )  );
    }
    
    /**
     * Suche Label mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TLA_Locator() throws Exception
    {
    	assertEquals( "//label[contains(text(),'MyLabelText')]/following-sibling::input", myLocator.get4TestLocator( "4TLA!MyLabelText" )  );
    }
    

    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TTX_Locator() throws Exception
    {
    	assertEquals( "//*[contains(text(),'MyCaptionText')]", myLocator.get4TestLocator( "4TTX!MyCaptionText" )  );
    }
}

