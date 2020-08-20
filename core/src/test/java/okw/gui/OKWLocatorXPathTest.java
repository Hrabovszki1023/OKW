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

package okw.gui;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/** \~german
 *   Prüft die Verküpfungen von Locatoren
 *  
 *  Locatoren können nicht, einfach oder Mehrfach
 *  
 *  \~english
 *  \brief \todo TODO: Brief Description.
 *  
 *  \todo TODO: Detailed Description
 *  
 *  \~
 *  \author Zoltán Hrabovszki
 *  \date 2015.07.12
 */
public class OKWLocatorXPathTest
{
	
    /** \~german
     *  Mehrfach Verschachtelung: 2 Locatoren an zweistellen in einen dritten Locator einfügen. (einfach Verschachtelt)
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     *  
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.07.12
     */
	@Test
    public void TC_Kombiniert_2in1_Multiple()
    {
	    OKWLocatorXPath Locator_1 = new OKWLocatorXPath("L1");
	    OKWLocatorXPath Locator_2 = new OKWLocatorXPath("L2");
	    OKWLocatorXPath Locator = new OKWLocatorXPath("L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", Locator_1, Locator_2);
        
          assertEquals("L1", Locator_1.getLocator());
          assertEquals("L2", Locator_2.getLocator());		  
		  assertEquals("L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator());
    }
    
	@Test
    public void TC_Kombiniert_2in1_ReverseOrder()
    {
	    OKWLocatorXPath Locator_1 = new OKWLocatorXPath(">Locator1<");
	    OKWLocatorXPath Locator_2 = new OKWLocatorXPath(">Locator2<");
	    OKWLocatorXPath Locator_Summe = new OKWLocatorXPath("Locator2=$L2$//Locator1=$L1$", Locator_1, Locator_2);
        
		assertEquals("Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator());
    }
    
	@Test
    public void TC_Kombiniert_2in1()
    {
	    OKWLocatorXPath Locator_1 = new OKWLocatorXPath(">Locator1<");
	    OKWLocatorXPath Locator_2 = new OKWLocatorXPath(">Locator2<");
	    OKWLocatorXPath Locator_Summe = new OKWLocatorXPath("Locator1=$L1$//Locator2=$L2$", Locator_1, Locator_2);
        
		assertEquals("Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator());
    }

    @Test
    public void TC_setLocator_2in1_Multiple()
    {
        OKWLocatorXPath Locator_1 = new OKWLocatorXPath("L1");
        OKWLocatorXPath Locator_2 = new OKWLocatorXPath("L2");
        OKWLocatorXPath Locator = new OKWLocatorXPath("Empty");
        
          Locator.setLocator( "L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", Locator_1, Locator_2);
          assertEquals("L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator());
    }
    
    @Test
    public void TC_setLocator_2in1_ReverseOrder()
    {
        OKWLocatorXPath Locator_1 = new OKWLocatorXPath(">Locator1<");
        OKWLocatorXPath Locator_2 = new OKWLocatorXPath(">Locator2<");
        OKWLocatorXPath Locator_Summe = new OKWLocatorXPath("Locator2=$L2$//Locator1=$L1$");
        
        Locator_Summe.setLocator( "Locator2=$L2$//Locator1=$L1$", Locator_1, Locator_2);
        assertEquals("Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator());
    }
    
    @Test
    public void TC_setLocator_2in1()
    {
        OKWLocatorXPath Locator_1 = new OKWLocatorXPath(">Locator1<");
        OKWLocatorXPath Locator_2 = new OKWLocatorXPath(">Locator2<");
        OKWLocatorXPath Locator_Summe = new OKWLocatorXPath("Empty");

        Locator_Summe.setLocator( "Locator1=$L1$//Locator2=$L2$", Locator_1, Locator_2 );
        assertEquals("Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator());
    }

	
	@Test
    public void TC_Window()
    {
	    OKWLocatorXPath Locator_1 = new OKWLocatorXPath(">Locator1<");
		assertEquals(">Locator1<", Locator_1.getLocator());
    }

	@Test
	public void TC_Window_setLocator()
	{
	    OKWLocatorXPath Locator_1 = new OKWLocatorXPath("");
        Locator_1.setLocator( ">Locator1<");
	        
	    assertEquals(">Locator1<", Locator_1.getLocator());
	}

    @Test
    public void TC_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("$L1$.Child", Window);
        
		assertEquals("Window.Child", Child.getLocator());
		assertEquals("Window", Window.getLocator());
    }

    @Test
    public void TC_4T_Single()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
    }

    @Test
    public void TC_4T_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("4T!Child", Window);
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
        assertEquals("//*[@data-harmony-id='Window']//*[@data-harmony-id='Child']", Child.getLocator());
    }


    @Test
    public void TC_4TNA_Single()
    {
        OKWLocatorXPath Child = new OKWLocatorXPath("4TNA!Child");
        
        assertEquals("//*[contains(@name,'Child')]", Child.getLocator());
    }

    @Test
    public void TC_4TNA_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("4TNA!Child", Window);
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
        assertEquals("//*[@data-harmony-id='Window']//*[contains(@name,'Child')]", Child.getLocator());
    }

    @Test
    public void TC_4TID_Single()
    {
        OKWLocatorXPath Child = new OKWLocatorXPath("4TID!Child");
        
        assertEquals("//*[contains(@id,'Child')]", Child.getLocator());
    }

    @Test
    public void TC_4TID_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("4TID!Child", Window);
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
        assertEquals("//*[@data-harmony-id='Window']//*[contains(@id,'Child')]", Child.getLocator());
    }

    @Test
    public void TC_4TLA_Single()
    {
        OKWLocatorXPath Child = new OKWLocatorXPath("4TLA!Child");
        
        assertEquals("//label[contains(text(),'Child')]/following-sibling::input", Child.getLocator());
    }

    @Test
    public void TC_4TLA_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("4TLA!Child", Window);
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
        assertEquals("//*[@data-harmony-id='Window']//label[contains(text(),'Child')]/following-sibling::input", Child.getLocator());
    }
    

    @Test
    public void TC_4TTX_Single()
    {
        OKWLocatorXPath Child = new OKWLocatorXPath("4TTX!Child");
        
        assertEquals("//*[contains(text(),'Child')]", Child.getLocator());
    }

    @Test
    public void TC_4TTX_Window_Child()
    {
        OKWLocatorXPath Window = new OKWLocatorXPath("4T!Window");
        OKWLocatorXPath Child  = new OKWLocatorXPath("4TTX!Child", Window);
        
        assertEquals("//*[@data-harmony-id='Window']", Window.getLocator());
        assertEquals("//*[@data-harmony-id='Window']//*[contains(text(),'Child')]", Child.getLocator());
    }
}


