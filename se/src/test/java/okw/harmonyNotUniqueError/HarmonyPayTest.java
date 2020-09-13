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

package okw.harmonyNotUniqueError;

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
public class HarmonyPayTest extends OKWTestBase
{

	protected static Log2HTML myLog2HTML = null;

	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        //
        myLog2HTML = new Log2HTML( "target/HarmonyPayTest.html" );

        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(true);
	}


	@AfterAll
    public static void tearDownAfterClass() throws Exception
    {
      myLog2HTML.Result2HTML( "target/HarmonyPayTest.html" );
    }
  
  
  
  @Test
  public void tcExists() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( "Chrome" );
    EN.TypeKey( "URL", "https://checkout.stripe.com/pay/cs_test_y6BVUU7gntwzb7mLmbnozs8FKTtBMIUqsXbwCNiXiLWkaYDA4fVGD0da#fidkdWxOYHwnPyd1blpxYHZxWjFJX0ZPfUpocH13VkFyRlFMczF1M0FxcDU1RlVAfEthc0MnKSdobGF2Jz9%2BJ2JwbGEnPydgPTI2ZmRgZyg2PWZmKDE2YzQoZzQ0PShkNj0wN2BjNmM2ZjVhYzw8NTInKSdocGxhJz8nYTRkZzRjMGMoMzM2NCgxYDwwKD0yMjwoMWM1YDFkZGcyY2RnYGE3Z2RkJykndmxhJz8nPDJgZjxgNzwoNmExPSgxMGRkKD0wZjYoN2E3ZjVmZDBjYDBmZjdjZz00J3gpJ2dgcWR2Jz9eWCknd2BjYHd3YHdKd2xibGsnPydtcXF1dj8qKmhkdnFgdytyandudittZHdoamt8K2RmJ3gl" );

    EN.SelectWindow( "HarmonyPay" );
    EN.VerifyExists( "cardNumber", "YES" );
    EN.TypeKey("cardNumber", "123" );
    
    EN.VerifyValue("cardNumber", "123");
    
    EN.StopApp( "Chrome" );
    EN.EndTest();
  }

}