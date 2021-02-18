/*
 ==============================================================================
 Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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
 along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.

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

package okw.harmony;

import okw.OKWTestBase;
import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class ScrollIntoViewTest extends OKWTestBase
{

	protected static Log2HTML myLog2HTML = null;

	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        //
        myLog2HTML = new Log2HTML( "target/harmony/ScrollIntoViewTest.html" );

        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(true);
	}


	@AfterAll
    public static void tearDownAfterClass() throws Exception
    {
      myLog2HTML.Result2HTML( "target/harmony/ScrollIntoViewTest.html" );
    }
  
  
  
  @Test
  public void tcExists() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( "Chrome" );
    EN.TypeKey( "URL", "https://master.works.harmony.ac" );

    EN.SelectWindow( "Harmony Login" );
    EN.SetValue("Email", "zh@openkeyword.de" );
    EN.SetValue("Password", "!Hannaveronika12" );
    EN.ClickOn("Log In");
    
    EN.SelectWindow( "Harmony Main" );
    EN.ClickOn("My own projects");
    
    EN.SetValue( "Projekt 1 new user email", "Projekt_1@efg.com");
    EN.SetValue( "Projekt 2 new user email", "Projekt_2@efg.com");
    EN.SetValue( "Projekt 3 new user email", "Projekt_3@efg.com");
    EN.SetValue( "Projekt 4 new user email", "Projekt_4@efg.com");
    
    EN.StopApp( "Chrome" );
    EN.EndTest();
  }

  //@Test
  public void tc_2() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( "Chrome" );
    EN.TypeKey( "URL", "https://master.works.harmony.ac" );

    EN.SelectWindow( "Harmony Login" );
    EN.SetValue("Email", "zh@openkeyword.de" );
    EN.SetValue("Password", "!Hannaveronika12" );
    EN.ClickOn("Log In");
    
    EN.SelectWindow( "Harmony Main" );
    EN.ClickOn("Organization users");
    
    EN.ClickOn( "checkbbox" );
    
    EN.SetValue( "checkbbox", "UNCHECKED" );
    EN.SetValue( "checkbbox", "CHECKED" );
    EN.SetValue( "checkbbox", "UNCHECKED" );
    EN.SetValue( "checkbbox", "CHECKED" );

    
    // EN.StopApp( "Chrome" );
    EN.EndTest();
  }

  
}
