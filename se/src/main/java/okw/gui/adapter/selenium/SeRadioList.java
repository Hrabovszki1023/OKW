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

package okw.gui.adapter.selenium;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW_Const_Sngltn;
import okw.core.Core;
import okw.core.OKW_CurrentObject_Sngltn;
import okw.gui.OKWLocator;


/** \brief
 *  TODO: Description of SeRadioList.
 */
public class SeRadioList extends SeAnyChildWindow
{

    // Instance of OKW_CurrentObject
    OKW_CurrentObject_Sngltn     CO               = null;

    // Instance of OKW_CurrentObject
    FrameObjectDictionary_Sngltn FOD              = null;

    /**
     *  Holds the FNs of all RadionButton ChildObjects of this RadioList.<br/>
     *  See Constructor for initialsation.
     */
    ArrayList<String>            myRadioButtonFNs = null;

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
     */
    public SeRadioList( String Locator, OKWLocator... Locators )
    {
        super( Locator, Locators );

        try
        {
            CO = OKW_CurrentObject_Sngltn.getInstance();
            FOD = FrameObjectDictionary_Sngltn.getInstance();
        }
        catch (Exception e)
        {
            System.exit( 0 );
        }
    }

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,String,OKWLocator)
     *  
     *  @date 2017.02.17
     */
    public SeRadioList( String IframeID, String Locator, OKWLocator... Locators )
    {
        super( IframeID, Locator, Locators );

        try
        {
            CO = OKW_CurrentObject_Sngltn.getInstance();
            FOD = FrameObjectDictionary_Sngltn.getInstance();
        }
        catch (Exception e)
        {
            System.exit( 0 );
        }
    }

    @Override
    public void SetValue( ArrayList<String> Val )
    {

        try
        {

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            if ( Val.size() == 1 )
            {

                String DELETE = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" );

                if ( Val.get( 0 ).equals( DELETE ) )
                {
                    // \todo TODO: Ausnahme Meldung in LM_SeRadioList anlegen.
                    throw new okw.exceptions.OKWNotAllowedValueException( "SeRadioList: This Value is Not Alowed here: " + Val.get( 0 ) );
                }

                else
                {
                    // Get my FN
                    String myFN = this.getFN();

                    // Radiolist enthällt nur einen wert
                    String myChildFN = myFN + "." + Val.get( 0 );

                    Core myCore = new Core();
                    myCore.ClickOn( myChildFN );

                    // Set the Current Radiobutton-object back to the
                    // RadioList..
                    CO.setChildName( myFN );
                }
            }
            else
            {
                // \todo TODO: Ausnahme Meldung in LM_SeRadioList anlegen.
                throw new okw.exceptions.OKWOnlySingleValueAllowedException( "SeRadioList: Only single value is allowed!" );
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            throw new RuntimeException( e );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }

    }

    @Override
    /**
     * 
     */
    public void Select( ArrayList<String> Val )
    {
        try
        {
            this.LogFunctionStartDebug( "Select" );
            this.SetValue( Val );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    /**
     *  Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
     *  
     *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
     *  
     *  @return Rückgabe des Textuellen Inhaltes der markierten Textes.
     *  Es wird (immer) der aktuelle Wert des Objektes zurückgeliefert.
     *  @author Zoltan Hrabovszki
     * @throws Exception 
     *  @date 2013.12.14
     */
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        ArrayList<String> myRadioButtonKeys = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "getValue" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            String isChecked = OKW_Const_Sngltn.getInstance().GetConst4Internalname( "CHECKED" );

            // 1. Get the List of RadioButtons
            myRadioButtonKeys = OKW_CurrentObject_Sngltn.getInstance().getAllChildFNsOfParent( this.getParentFN() + "." + this.getFN() + "." );

            for ( String lvsRadioButtonFN : myRadioButtonKeys )
            {

                ArrayList<String> Actuel = ( ( SeInputRadio ) FOD.getParentObjectByName( lvsRadioButtonFN ) ).getValue();

                if ( isChecked.equals( Actuel.get( 0 ) ) )
                {

                    String CurrentValue = okw.OKW_Helper.getRightFromDelimiterNumber( lvsRadioButtonFN, this.getFN() + ".", 1 );
                    lvLsReturn.add( CurrentValue );

                    break;
                }
            }
            if ( 0 == lvLsReturn.size() )
            {
                lvLsReturn.add( "" );
            }
            
        }
        catch (XPathExpressionException | JAXBException | ParserConfigurationException | SAXException | IOException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn.toString() );
        }

        return lvLsReturn;
    }

    /** \~german
     *  Ermittelt den textuellen Inhalt des Labels.
     *  
     *  Beim RadioList ist das Label die "Legende"
     *  @return  Rückgabe des Textuellen Inhaltes der Labels.
     *
     *  \~english
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2016.12.20
     */
    @Override
    public ArrayList<String> getLabel()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;
        try
        {
            MyLogger.LogFunctionStartDebug( "GetLabel" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // 2.schritt nun den Tag-label finden und den Textinhalt ermitteln.
            WebElement label = SeDriver.getInstance().driver.findElement( By.xpath( this.getLocator() + "//legend" ) );
            lvLsReturn.add( label.getAttribute( "textContent" ) );
            bOK = true;
        }
        finally
        {
            if ( bOK )
            {
                MyLogger.LogFunctionEndDebug( lvLsReturn );
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }
}