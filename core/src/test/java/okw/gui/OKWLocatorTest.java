/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

import org.junit.Test;

/** \~german
 *  Prüft die Verküpfungen von Locatoren
 *  
 *  Locatoren können nicht, einfach oder Mehrfach mit einander verbunden sein
 *  
 *  \~english
 *  \brief \todo TODO: Brief Description.
 * 
 *  \todo TODO: Detailed Description
 *  
 * \~
 *  \author Zoltán Hrabovszki
 *  \date 2015.07.12
 */
public class OKWLocatorTest
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
        OKWLocator L1 = new OKWLocator( "L1" );
        OKWLocator L2 = new OKWLocator( "L2" );
        OKWLocator Locator = new OKWLocator( "L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", L1, L2 );

        assertEquals( "L1", L1.getLocator() );
        assertEquals( "L2", L2.getLocator() );
        assertEquals( "L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator() );
    }

    @Test
    public void TC_Kombiniert_2in1_ReverseOrder()
    {
        OKWLocator L1 = new OKWLocator( ">Locator1<" );
        OKWLocator L2 = new OKWLocator( ">Locator2<" );
        OKWLocator Locator_Summe = new OKWLocator( "Locator2=$L2$//Locator1=$L1$", L1, L2 );

        assertEquals( "Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator() );
    }

    @Test
    public void TC_Kombiniert_2in1()
    {
        OKWLocator L1 = new OKWLocator( ">Locator1<" );
        OKWLocator L2 = new OKWLocator( ">Locator2<" );
        OKWLocator Locator_Summe = new OKWLocator( "Locator1=$L1$//Locator2=$L2$", L1, L2 );

        assertEquals( "Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator() );
    }

    @Test
    public void TC_setL2in1_Multiple()
    {
        OKWLocator L1 = new OKWLocator( "L1" );
        OKWLocator L2 = new OKWLocator( "L2" );
        OKWLocator Locator = new OKWLocator( "Empty" );

        Locator.setLocator( "L2=$L2$, L1=$L1$, L2=$L2$, L1=$L1$", L1, L2 );
        assertEquals( "L2=L2, L1=L1, L2=L2, L1=L1", Locator.getLocator() );
    }

    @Test
    public void TC_setL2in1_ReverseOrder()
    {
        OKWLocator L1 = new OKWLocator( ">Locator1<" );
        OKWLocator L2 = new OKWLocator( ">Locator2<" );
        OKWLocator Locator_Summe = new OKWLocator( "Locator2=$L2$//Locator1=$L1$" );

        Locator_Summe.setLocator( "Locator2=$L2$//Locator1=$L1$", L1, L2 );
        assertEquals( "Locator2=>Locator2<//Locator1=>Locator1<", Locator_Summe.getLocator() );
    }

    @Test
    public void TC_setL2in1()
    {
        OKWLocator L1 = new OKWLocator( ">Locator1<" );
        OKWLocator L2 = new OKWLocator( ">Locator2<" );
        OKWLocator Locator_Summe = new OKWLocator( "Empty" );

        Locator_Summe.setLocator( "Locator1=$L1$//Locator2=$L2$", L1, L2 );
        assertEquals( "Locator1=>Locator1<//Locator2=>Locator2<", Locator_Summe.getLocator() );
    }

    @Test
    public void TC_Window()
    {
        OKWLocator L1 = new OKWLocator( ">Locator1<" );
        assertEquals( ">Locator1<", L1.getLocator() );
    }

    @Test
    public void TC_Window_setLocator()
    {
        OKWLocator L1 = new OKWLocator( "" );
        L1.setLocator( ">Locator1<" );

        assertEquals( ">Locator1<", L1.getLocator() );
    }

    @Test
    public void TC_Window_Child()
    {
        OKWLocator Window = new OKWLocator( "Window" );
        OKWLocator Child = new OKWLocator( "$L1$.Child", Window );

        assertEquals( "Window.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
    }

    /**
     * \~german
     * Prüft die Methode CopyLocator( Source )
     * Hier wird geprüft ob beide Komponenten, also _locator und _Locators
     * Copiert werden
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-28
     */
    @Test
    public void TC_Copy__1Locators()
    {
        OKWLocator Window = new OKWLocator( "Window" );
        OKWLocator Child = new OKWLocator( "$L1$.Child", Window );

        
        assertEquals( "Window.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
        
        OKWLocator Child_2 = new OKWLocator(  );
        Child_2.copyLocator( Child );
        
        assertEquals( "Window.Child", Child_2.getLocator() );
        assertEquals( "Window.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
    }

    
    /**
     * \~german
     * Prüft die Methode CopyLocator( Source )
     * Hier wird geprüft ob nur _locator copiert wird.
     * _Locators ist in der Quelle nicht gesetzt
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-28
     */
    @Test
    public void TC_Copy_0Locators()
    {
        OKWLocator Window = new OKWLocator( "Window" );
        OKWLocator Child = new OKWLocator( "kein Window gegeben.Child" );

        
        assertEquals( "kein Window gegeben.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
        
        OKWLocator Child_2 = new OKWLocator(  );
        Child_2.copyLocator( Child );
        
        assertEquals( "kein Window gegeben.Child", Child_2.getLocator() );
        assertEquals( "kein Window gegeben.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
    }
    
    /**
     * \~german
     * Prüft die Methode CopyLocator( Source )
     * Hier wird geprüft ob locator und mehrere (zwei) _Locators copiert werden.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-28
     */
    @Test
    public void TC_Copy_With_2Locators()
    {
        OKWLocator Window = new OKWLocator( "Window" );
        OKWLocator SubDialog = new OKWLocator( "SubDialog" );
        OKWLocator Child = new OKWLocator( "$L1$.$L2$.Child", Window, SubDialog );

        assertEquals( "Window.SubDialog.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
        
        OKWLocator Child_2 = new OKWLocator(  );
        Child_2.copyLocator( Child );
        
        assertEquals( "Window.SubDialog.Child", Child_2.getLocator() );
        assertEquals( "Window.SubDialog.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
    }

    /**
     * \~german
     * Prüft, ob dynamische Locatoren möglich sind
     *
     * Dynamischer Locator bedeutet, dass der Locator zur Laufzeig geändert bzw. angepasst werden
     * kann. So kann z.B. ein angezeiter Wert für die Objekterkennung harangezogen werden.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-28
     */
    @Test
    public void TC_DynamicLocators()
    {
        OKWLocator Window = new OKWLocator( "Window" );
        OKWLocator Dynamic = new OKWLocator( "FirstValue" );
        OKWLocator Child = new OKWLocator( "$L1$.$L2$.Child", Window, Dynamic );

        
        assertEquals( "Window.FirstValue.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
        
        OKWLocator Child_2 = new OKWLocator(  );
        Child_2.copyLocator( Child );
        
        assertEquals( "Window.FirstValue.Child", Child_2.getLocator() );
        assertEquals( "Window.FirstValue.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
        
        // As next step, we updates the Dynamic Part of locator
        Dynamic.setLocator( "SecondValue" );
        // So both Locator-s Child and Child_2 are updateted.
        assertEquals( "Window.SecondValue.Child", Child_2.getLocator() );
        assertEquals( "Window.SecondValue.Child", Child.getLocator() );
        assertEquals( "Window", Window.getLocator() );
    }

    
}
