package okw.gui.adapter.selenium;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import okw.OKW_Const_Sngltn;
import okw.gui.OKWLocatorBase;

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


/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapter 
 * 
 * \~german
 *  Diese Klasse representiert einen <select>-Tag, der mit Selenium angsteuert wird.
 *  
 *  @startuml
 *  class SeSelect [[java:okw.gui.adapter.selenium.SeSelect]] {
 *   ..Constructor..
 *  +SeSelect(String Locator, OKWLocator[] Locators)
 *   .. Keyword API..
 *   +void Select(ArrayList<String> fps_Values)
 *   +void SetValue(ArrayList<String> fpsValues)
 *   +ArrayList<String> getValue()
 * }
 * class SeAnyChildWindow [[java:okw.gui.adapter.selenium.SeAnyChildWindow]] {
 * }
 * SeAnyChildWindow <|-- SeSelect
 * @enduml
 * 
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <label for="ID_Select">Button Label:</label>
 *  <select name="Select" title="Select title" size="3">
 *     <option>First Value</option>
 *     <option>Second Value</option>
 *     <option>Third Value</option>
 *     <option>Forth Value</option>
 *     <option>Fifth Value</option>
 *  </select>
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |  |
 * | `DoubleClickOn( FN )`     | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented | 
 * | `SetFocus( FN )`          | **JA**        |  |
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
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **NEIN** | Was ist die Caption |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** |  |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Select title` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **JA** | Ausgewählte Wert |
 * 
 *  # Siehe auch:
 *  - okw.gui.adapter.selenium.SeButton - für button-tags 
 *  
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Formulare/Auswahllisten](https://wiki.selfhtml.org/wiki/HTML/Formulare/Auswahllisten)
 *  - [SelfHTML: Referenz:HTML/select](https://wiki.selfhtml.org/wiki/Referenz:HTML/select)
 *  - [Issue #106](https://github.com/Hrabovszki1023/OKW/issues/110)
 *  
 *  \~english
 *  
 *  \~
 * @author Zoltán Hrabovszki
 * \date 2016.09.05
 */
public class SeSelect extends SeAnyChildWindow
{

    /**
     *  @copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
     */
    public SeSelect( String Locator, OKWLocatorBase... Locators )
    {
        super( Locator, Locators );
    }

    /** \~german
     *  Methode wählt einen oder mehrere Werte in einer ListBox aus.
     *  
     *  Die Methode Select löscht bereits ausgewählte _nicht_.
     *  
     *  @param fps_Values Ein oder mehrere Werte, die ausgewählt werden sollen.
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013.04.11
     */
    @Override
    public void Select( ArrayList<String> fps_Values )
    {
        this.LogFunctionStartDebug( "Select", "fps_Values", fps_Values.toString() );

        try
        {
            this.SetFocus();

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

    /** \~german
     *  Methode setzt einen oder mehrere Werte in einer ListBox.
     *  
     *  Die Methode löscht zunächst  alle ausgewählten Werte in der Liste, wenn eine Mehrfachauswahl möglich ist
     *  ( Attribut _multiple_ ist gestzt.
     *  
     *  Danach werden die gegebenen Werte ausgewählt.
     *  
     *  Unterschied zu Select: Nach SetValue sind nur die gegebenen Werte ausgewählt.
     *  (Select wählt bereits ausgewählte werde einer Listbox nicht ab sonder ergeänzt diese um die gegebenen Werte.)
     *  
     *  @param fpsValues Werte, die in der Listbox ausgwählt werden sollen.
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013.04.11
     */
    @Override
    public void SetValue( ArrayList<String> fpsValues )
    {
        this.LogFunctionStartDebug( "SetValue", "fpsValues", fpsValues.toString() );

        try
        {
            // Waiting for the object. 
            // If it does not exist after TimeOut 
            // then the exception OKWGUIObjectNotFoundException is raised and terminated...
            SetFocus();
            
            Select SelectList = new Select( this.Me() );

            // Zunächst alle ausgwählten Werte der Listbox löschen, wenn eine mehrfachauswahl möglich ist...
            if ( WaitForInteractionReturnBoolean( () -> { return SelectList.isMultiple(); } ) )
            {
                WaitForInteraction(() -> { SelectList.deselectAll();});
            }
            else
            {
                if ( fpsValues.size() > 1 )
                    this.LogError( "This ListBox does not allow multiple selection." );
                // \todo TODO: Text in XML auslagern.
                // \todo TODO: Exception für NichtErlaubte Mehrfachauswahl setzen.

            }

            // Danach die gegebene Werte auswählen
            for ( String lvsValue : fpsValues )
            {
                WaitForInteraction(() -> { SelectList.selectByVisibleText( lvsValue );});
            }
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    /** \~german
     *  Holt die aktuell _ausgewählten_ Werte aus der ListBox.
     *  
     *  Die ausgewählten Werte werden in der Reihenfolge _oben nach unten_ inder Rückgabe-Liste abgelegt.
     *  Sind keine Werte ausgewählt, dann ist die Rückgabe-Liste leer.
     *  leer und List.Count = 0.
     *  @return Liste der ausgewählten Werte\return
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2014.12.04
     */
    @Override
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean lvbSelectionFound = false;

        try
        {
            this.LogFunctionStartDebug( "GetValue" );

            // Waiting for the object. 
            // If it does not exist after TimeOut 
            // then the exception OKWGUIObjectNotFoundException is raised and terminated...
            // ========================================
            // Remeljük hogy ez itt eleg lesz...
            this.WaitForMe();

            Select SelectList = new Select( this.Me() );

            for ( WebElement Option : SelectList.getAllSelectedOptions() )
            {
                lvLsReturn.add( Option.getAttribute( "textContent" ) );
                lvbSelectionFound = true;
            }
            
            if (!lvbSelectionFound) lvLsReturn.add("");
            
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }
}