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

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.gui.OKWLocatorBase;

/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapter 
 *
 * \~german
 * Diese Klasse representiert einen <img>-Tag, der mit Selenium angsteuert wird.
 * 
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <label for="ID_Image_1">Image Label:</label>
 *  <img src="img.png"
 *         id="ID_Button_1"
 *         title="Image title"
 *         alt="Image Caption">
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |  |
 * | `DoubleClickOn( FN )`     | **NEIN**      | Ein Doppel-Klick ist auf ein Image nicht möglich -> throw OKWFrameObjectMethodNotImplemented | 
 * | `SetFocus( FN )`          | **NEIN**      | Image kann nicht focusiert werden.  -> throw OKWFrameObjectMethodNotImplemented |
 * | `SetValue( FN, Val )`     | **NEIN**      | Image hat keinen änderbaren Wert. -> throw OKWFrameObjectMethodNotImplemented |
 * | `Select( FN, Val )`       | **NEIN**      | Image hat keinen änderbaren Wert. -> throw OKWFrameObjectMethodNotImplemented |
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
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Caption ist das Attribute-'alt' Text des Buttons. Im Beispiel: `Image Caption` |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** |  |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Button title` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **JA** | Der Wert eines Image ist das attribute 'src'. |
 * 
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Multimedia und Grafiken/Grafiken](https://wiki.selfhtml.org/wiki/HTML/Multimedia_und_Grafiken/Grafiken)
 *  
 *  \~english
 * \~
 * @author Zoltán Hrabovszki
 * @date 2016.09.05
 */
public class SeImage extends SeAnyChildWindow
{

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
     */
    public SeImage( String Locator, OKWLocatorBase... Locators )
    {
        super( Locator, Locators );
    }
    
    
    /**
     *  Der Wert eines img ist der Wert des Attributtes `src`.
     * 
     *  @return
     *  @author Zoltán Hrabovszki
     *  @date 2017-06-18
     */
    @Override
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "getValue" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // Get Value from TextField and put this into the return ArrayList<String>
            lvLsReturn.add( this.Me().getAttribute( "src" ) );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /** \~german
     *  Ermittelt den textuellen Inhalt der \ref refCaption. Für ein img-Tags ist die \ref refCaption das Attribut "alt".
     *   
     *  @return Rückgabe des Textuellen Inhaltes der \ref refCaption.
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2017-06-18
     */
   public ArrayList<String> getCaption()
   {
       ArrayList<String> lvLsReturn = new ArrayList<String>();

       try
       {
           this.LogFunctionStartDebug( "GetCaption" );

           // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
           this.WaitForMe();

           // The Attribute "value" wird als Beschriftung angezeigt...
           lvLsReturn.add( this.Me().getAttribute( "alt" ) );
       }
       finally
       {
           this.LogFunctionEndDebug( lvLsReturn );
       }
       return lvLsReturn;
   }
   
   
   public void SetFocus( ) throws Exception
   {
     // TODO: /todo Meldung in xml-Auslagern
     throw new OKWFrameObjectMethodNotImplemented("The method 'public void SetFocus( ) throws Exception' is not defined for your GUI-Object. Please define first the methode!");
   }
   
   
   public void TypeKey(ArrayList<String> Val )
   {
     // TODO: /todo Meldung in xml-Auslagern
     throw new OKWFrameObjectMethodNotImplemented("The method 'public void TypeKey( ArrayList<String> Val ) throws Exception' is not defined for your GUI-Object. Please define first the methode!");
   }
}