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

package okw.gui.adapter.selenium;

import java.util.ArrayList;

import org.openqa.selenium.support.ui.Select;
import okw.OKW_Const_Sngltn;
import org.apache.commons.lang3.StringUtils;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.gui.OKWLocator;
import okw.gui.OKWLocatorBase;

/**
 * @ingroup groupSeleniumChildGUIAdapter 
 * 
 * \~german
 *  Diese Klasse representiert einen <input type="button">-Tag, der mit Selenium angsteuert wird.
 *  
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <label for="ID_Button_1">Button Label:</label>
 *  <input type="button"
 *         id="ID_Button_1"
 *         name="Button 1"
 *         title="Button title"
 *         value="Button 1">Button Caption<\button>
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |  |
 * | `DoubleClickOn( FN )`     | **NEIN**      | Ein Doppel-Klick ist auf ein Button nicht möglich -> throw OKWFrameObjectMethodNotImplemented | 
 * | `SetFocus( FN )`          | **JA**        |  |
 * | `SetValue( FN, Val )`     | **NEIN**      | Button hat keinen änderbaren Wert. -> throw OKWFrameObjectMethodNotImplemented |
 * | `Select( FN, Val )`       | **NEIN**      | Button hat keinen änderbaren Wert. -> throw OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN )`        | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN, Val )`   | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `TypeKey( FN, Val )`      | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * 
 * ## Fensterbezogene Schlüsselwörter
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, Button ist kein Fensterobjekt |
 * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, Button ist kein Fensterobjekt |
 * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, Button ist kein Fensterobjekt |
 * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, Button ist kein Fensterobjekt |
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
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Caption ist der sichtbare Text des Buttons. Im Beispiel: `Button Caption` |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** |  |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Button title` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **NEIN** | Was ist der Wert eines Buttons? -> throw OKWFrameObjectMethodNotImplemented |
 * 
 *  # Siehe auch:
 *  - okw.gui.adapter.selenium.SeButton - für button-tags 
 *  
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Formulare/Button](https://wiki.selfhtml.org/wiki/HTML/Formulare/Button)
 *  - [SelfHTML: HTML/Formulare/input/button](https://wiki.selfhtml.org/wiki/HTML/Formulare/input/button#type_.3D_.22button.22)
 *  - [SelfHTML: input oder button für submit-Elemente?](https://blog.selfhtml.org/2015/02/09/input-oder-button-fuer-submit-elemente/)
 *  - [Issue #106](https://github.com/Hrabovszki1023/OKW/issues/108)
 *  - [Issue #120](https://github.com/Hrabovszki1023/OKW/issues/116)
 *  
 *  \~english
 *  
 *  \~
 * @author Zoltán Hrabovszki
 * @date 2016.09.05
 */
public class SeInputButton extends SeAnyChildWindow
{

    /**
     * \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...) \~
     * 
     * @author Zoltán Hrabovszki
     * @date 2013.05.03
     */
    public SeInputButton( String Locator, OKWLocatorBase... Locators )
    {
        super( Locator, Locators );
    }


    /**
     * \~german Ermittelt den textuellen Inhalt der Caption/Überschrift des
     * Objektes.
     * 
     * @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
     * \~english
     * \~
     * @author Zoltán Hrabovszki
     * @throws Exception
     * @date 2013.12.07
     */
    @Override // TODO define Prototype in BaseClass!
    public ArrayList<String> getCaption()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        try
        {
            this.LogFunctionStartDebug( "GetCaption" );

            // Warten auf das Objekt. Wenn es nicht existiert mit Exception
            // beenden...
            this.WaitForMe();
            
            // The Attribute "value" wird als Beschriftung angezeigt...
            String myAttribute = this.Me().getAttribute( "value" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**
     * \~german Ein SeInputButton hat keinen Wert! ->
     * OKWFrameObjectMethodNotImplemented Auslösen!
     * 
     * @return
     * 
     * \~english A SeInputButton has no value! -> Trigger
     *         OKWFrameObjectMethodNotImplemented! \~
     * @author Zoltán Hrabovszki
     * @date 2016.10.06
     */
    @Override
    public ArrayList<String> getValue()
    {
        // ArrayList<String> lvLsReturn = new ArrayList<String>();
        try
        {
            LogFunctionStartDebug( "GetValue" );

            String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "getValue()" );
            throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
            LogFunctionEndDebug();
        }
        // return lvLsReturn;
    }
    

    /** \~german
     *  Methode wählt einen oder mehrere Werte in einer ListBox aus.
     *  
     *  Die Methode Select löscht bereits ausgewählte _nicht_.
     *  
     *  @param fps_Values Ein oder mehrere Werte, die ausgewählt werden sollen.
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.04.11
     */
    //@Override
    public void __Select( ArrayList<String> fps_Values )
    {
        this.LogFunctionStartDebug( "Select", "fps_Values", fps_Values.toString() );

        try
        {
            // Waiting for the object. 
            // If it does not exist after TimeOut 
            // then the exception OKWGUIObjectNotFoundException is raised and terminated...
            this.WaitForMe();

            //org.openqa.selenium.support.ui.Select
            Select SelectList = new Select( this.Me() );

            for ( String lvsValue : fps_Values )
            {
                if ( lvsValue.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ) )
                {
                    SelectList.deselectAll();
                }
                else
                {
                    SelectList.selectByVisibleText( lvsValue );
                }
            }
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

}