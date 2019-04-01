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

package okw.gui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/// \~german
/// \brief Prüft die Verküpfungen von Locatoren
/// 
/// Locatoren können nicht, einfach oder Mehrfach
/// 
/// \~english
/// \brief \todo TODO: Brief Description.
/// 
/// \todo TODO: Detailed Description
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2015.07.12
public class OKWLocatorTest
{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	
    /* \~german
     * \brief Mehrfach Verschachtelung: 2 Locatoren an zweistellen in einen dritten Locator einfügen. (einfach Verschachtelt)
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
		  OKWLocator Locator_1 = new OKWLocator("L1");
		  OKWLocator Locator_2 = new OKWLocator("L2");
		  OKWLocator Locator = new OKWLocator("L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", Locator_1, Locator_2);
        
          assertEquals("L1", Locator_1.getLocator());
          assertEquals("L2", Locator_2.getLocator());		  
		  assertEquals("L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator());
    }
    
	@Test
    public void TC_Kombiniert_2in1_ReverseOrder()
    {
		OKWLocator Locator_1 = new OKWLocator(">Locator1<");
		OKWLocator Locator_2 = new OKWLocator(">Locator2<");
		OKWLocator Locator_Summe = new OKWLocator("Locator2=$L2$//Locator1=$L1$", Locator_1, Locator_2);
        
		assertEquals("Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator());
    }
    
	@Test
    public void TC_Kombiniert_2in1()
    {
		OKWLocator Locator_1 = new OKWLocator(">Locator1<");
		OKWLocator Locator_2 = new OKWLocator(">Locator2<");
		OKWLocator Locator_Summe = new OKWLocator("Locator1=$L1$//Locator2=$L2$", Locator_1, Locator_2);
        
		assertEquals("Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator());
    }

    @Test
    public void TC_setLocator_2in1_Multiple()
    {
          OKWLocator Locator_1 = new OKWLocator("L1");
          OKWLocator Locator_2 = new OKWLocator("L2");
          OKWLocator Locator = new OKWLocator("Empty");
        
          Locator.setLocator( "L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", Locator_1, Locator_2);
          assertEquals("L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator());
    }
    
    @Test
    public void TC_setLocator_2in1_ReverseOrder()
    {
        OKWLocator Locator_1 = new OKWLocator(">Locator1<");
        OKWLocator Locator_2 = new OKWLocator(">Locator2<");
        OKWLocator Locator_Summe = new OKWLocator("Locator2=$L2$//Locator1=$L1$");
        
        Locator_Summe.setLocator( "Locator2=$L2$//Locator1=$L1$", Locator_1, Locator_2);
        assertEquals("Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator());
    }
    
    @Test
    public void TC_setLocator_2in1()
    {
        OKWLocator Locator_1 = new OKWLocator(">Locator1<");
        OKWLocator Locator_2 = new OKWLocator(">Locator2<");
        OKWLocator Locator_Summe = new OKWLocator("Empty");

        Locator_Summe.setLocator( "Locator1=$L1$//Locator2=$L2$", Locator_1, Locator_2 );
        assertEquals("Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator());
    }

	
	@Test
    public void TC_Window()
    {
		OKWLocator Locator_1 = new OKWLocator(">Locator1<");
		assertEquals(">Locator1<", Locator_1.getLocator());
    }

	   @Test
	    public void TC_Window_setLocator()
	    {
	        OKWLocator Locator_1 = new OKWLocator("");
            Locator_1.setLocator( ">Locator1<");
	        
	        assertEquals(">Locator1<", Locator_1.getLocator());
	    }

	@Test
    public void TC_Window_Child()
    {
		OKWLocator Window = new OKWLocator("Window");
		OKWLocator Child  = new OKWLocator("$L1$.Child", Window);
        
		assertEquals("Window.Child", Child.getLocator());
		assertEquals("Window", Window.getLocator());
    }
}


