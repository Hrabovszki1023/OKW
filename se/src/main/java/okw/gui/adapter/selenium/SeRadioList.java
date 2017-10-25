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
import okw.gui.adapter.selenium.webdriver.SeDriver;


/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapter 
 * 
 * \~german
 *  Diese Klasse representiert einen <select>-Tag, der mit Selenium angsteuert wird.
 *  
 *  SeRadioList selbst ist ein komplexer GUI-Adapter, der als Kontainer für SeRadioButtons dient.
 *  Im Absatz *Verwendung*, wird beschrieben, wie ein funktionierender RadioList im GUI-Frame aufgebaut wird.
 *  
 *  
 * @startuml
 * class SeRadioList [[java:okw.gui.adapter.selenium.SeRadioList]] {
 *     ~OKW_CurrentObject_Sngltn CO
 *     ~FrameObjectDictionary_Sngltn FOD
 *     ~ArrayList<String> myRadioButtonFNs
 *   ..Constructor..
 *     +SeRadioList(String Locator, OKWLocator[] Locators)
 *     +SeRadioList(String IframeID, String Locator, OKWLocator[] Locators)
 *   .. Getter/Setter..
 *     +ArrayList<String> getValue()
 *     +ArrayList<String> getLabel()
 *   .. Keyword API..
 *     +void SetValue(ArrayList<String> Val)
 *     +void Select(ArrayList<String> Val)
 * }
 * class SeAnyChildWindow [[java:okw.gui.adapter.selenium.SeAnyChildWindow]] {
 * }
 * SeAnyChildWindow <|-- SeRadioList
 * @enduml
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <fieldset>
 *    <input type="radio" id="mc" name="Paymethode" value="Mastercard">
 *    <label for="mc"> Mastercard</label><br> 
 *    <input type="radio" id="vi" name="Paymethode" value="Visa">
 *    <label for="vi"> Visa</label><br> 
 *    <input type="radio" id="ae" name="Paymethode" value="AmericanExpress">
 *    <label for="ae"> American Express</label> 
 *  </fieldset>
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **NEIN**        | -> throw OKWFrameObjectMethodNotImplemented |
 * | `DoubleClickOn( FN )`     | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented | 
 * | `SetFocus( FN )`          | **NEIN**        | -> throw OKWFrameObjectMethodNotImplemented |
 * | `SetValue( FN, Val )`     | **JA**        | Entspricht Select( FN, Val ) |
 * | `Select( FN, Val )`       | **JA**        | Select( "FN Select", "First Value${SEP}Third Value${SEP}Fifth Value" ) |
 * | `SelectMenu( FN )`        | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN, Val )`   | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `TypeKey( FN, Val )`      | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * 
 * ## Fensterbezogene Schlüsselwörter
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, SeSelect ist kein Fensterobjekt |
 * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, SeSelect ist kein Fensterobjekt |
 * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, SeSelect ist kein Fensterobjekt |
 * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, SeSelect ist kein Fensterobjekt |
 * 
 * ## Verifying, Memorizing, Logging Values
 * 
 * Group of keywords using the same GUI-Adapter Methods get*() <br/>
 * (e.g.: `VerifyExists( FN, ExpVal)`, `MemorizeExists( FN, MemKey)`,`LogExists( FN )` -> `getExists()` )
 * 
 * | OpenKeyWord | Implementiert | Beschreibung |
 * | ----------- | :-----------: | :----------- |
 * | `VerifyExists( FN, ExpVal)`,    <br>`MemorizeExists( FN, MemKey)`,    <br>`LogExists( FN )`   | **JA** |  |
 * | `VerifyHasFocus( FN, ExpVal )`, <br>`MemorizeHasFocus( FN, MemKey)`,  <br>`LogHasFocus( FN )` | **JA** |  |
 * | `VerifyIsActive( FN, ExpVal )`, <br>`MemorizeIsActive( FN, MemKey)`,  <br>`LogIsActive( FN )` | **JA** |  |
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **NEIN** | Was ist die Caption der RadioList? |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** |  |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Select title` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **JA** | Ausgewählte Wert |
 * 
 * # Verwendung
 * Hier wird nun gezeigt, wie ein SeRadioList zu einer funtionierenden Einheit
 * 
 * - aus einer SeRadioList als Kontainer-Klasse und
 * - aus mehreren SeInputRadio -s als Elemente der RadioList
 * 
 * aufgebaut wird.
 *  
 * Als Beispiel verwenden wir die SeRadioList Implementation aus dem TestFrame okw.gui.frames.SeRadioList.frmSeRadioList für den Test der SeRadioList,
 * die in OKW Verwendet wird.
 * 
 * 
 * Bei diesem Beispiel handelt es sich um die Auswahl der Zahlungsmethode (Pay Method) als Radio-Liste. Die Möglichen Optionen sind:
 * 
 * - Visa
 * - American Express
 * - Mastercard
 *  
 * ## Der FN der SeRadioList
 * Wie jeder GUI-Adapter erhält auch ein GUI-Adapter vom Type SeRadiolist einen @ref refFN.
 * Hier ist kein Unterschied zu anderen GUI-Adapter. Der \ref refFN ist im Beispiel "Pay Method"
 * 
 * \par Hinweis:
 * Die Klasse ```PayMethod``` ist der GUI-Kontainer, diese erweitert (extends) die Klasse SeRadioList. Das kommt im weiter unten.
 * 
 * 
 * ## Der FN der SeRadioList
 * 
 * \code{.java}
 * @OKW( FN = "Pay Method" )
 * public PayMethod   mySeRadioList = new PayMethod( "//fieldset[@title='fieldset-title']", this.getLOCATOR() );
 * \endcode
 * 
 * 
 * ## SeRadioList Kontainer Klasse definieren
 * In diesem Schritt werden die "Knöpfe" der Radio-Liste definiert und jeweils ein \ref refFN zugeordnet.
 * 
 * \par Hinweis:
 * Damit SeRadioList funktioniert, müssen die \ref refFN -s der Knöpfe jeweil mit dem \ref refFN der SeRadioList + "." beginnen!<br>
 * Also in diesem Beispiel: ```"Pay Method."``` - Wichtig: ```"."``` nicht vergessen.<br><br>
 * In unserem Beispiel ist der \ref refFN für die Option "American Express" = ```"Pay Method.American Express"```<br><br>
 * Die Annotaion als gnazes: @OKW( FN = "Pay Method.American Express" )
 * 
 * Das Ganze sieht dann wie folg aus:
 * 
 * \code{.java}
 *    public class PayMethod extends SeRadioList
 *  {
 *
 *      public PayMethod( String Locator, OKWLocator... fpLocators )
 *      {
 *          super( Locator, fpLocators );
 *      }
 *
 *      @OKW( FN = "Pay Method.Visa" )
 *      public SeInputRadio myVisa            = new SeInputRadio( "%1$s//input[@id='id_visa']", this.getLOCATOR() );
 *
 *      @OKW( FN = "Pay Method.American Express" )
 *      public SeInputRadio myAmericanExpress = new SeInputRadio( "%1$s//input[@id='id_american_express']", this.getLOCATOR() );
 *
 *      @OKW( FN = "Pay Method.Mastercard" )
 *      public SeInputRadio myMastercard      = new SeInputRadio( "%1$s//input[@id='id_mastercard']", this.getLOCATOR() );
 *
 *  };
 * \endcode
 * 
 *  # Siehe auch:
 *  - okw.gui.adapter.selenium.SeInputRadio - für <input type="radionbutton">-Tags.
 *  
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Formulare/input/Radio-Buttons und Checkboxen](https://wiki.selfhtml.org/wiki/HTML/Formulare/input/Radio-Buttons_und_Checkboxen)
 *  - [SelfHTML: Referenz:HTML/select](https://wiki.selfhtml.org/wiki/Referenz:HTML/select)
 *  - [Issue #139](https://github.com/Hrabovszki1023/OKW/issues/139)
 *  
 *  \~english
 *  
 *  \~
 * @author Zoltán Hrabovszki
 * @date 2017.07.02
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
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
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
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,String,OKWLocator...)
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