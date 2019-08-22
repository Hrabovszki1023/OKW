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
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import okw.gui.OKWLocatorBase;


/**
 * @ingroup groupSeleniumChildGUIAdapter 
 *
 * \~german
 *  Diese Klasse representiert ein HTML-Textfeld, die mit Selenium angsteuert wird.
 *  
 *  # Unterstützter Tag
 *  Folgende Kombination aus Label/Input-Tags wird unterstützt:
 *  
 *  \code{.html}
 *  <label for="ID_Name">Name:</label>
 *  <input type="text" name="Name" id="ID_Name" title="Title Name" size="30" maxlength="30">
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |  |
 * | `DoubleClickOn( FN )`     | **JA**        |  |
 * | `SetFocus( FN )`          | **JA**        |  |
 * | `SetValue( FN, Val )`     | **JA**        | Sichtbarer Eigabewert des Textfeldes |
 * | `Select( FN, Val )`       | **NEIN**      | Im einem Textfeld ist kein Wert auswählbar -> throw OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN )`        | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN, Val )`   | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
 * | `TypeKey( FN, Val )`      | **NEIN**      | Sichtbarer Wert des Textfeldes wir vie Tastatur eingegeben |
 * 
 * ## Fensterbezogene Schlüsselwörter
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, Textfeld ist kein Fensterobjekt |
 * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, Textfeld ist kein Fensterobjekt |
 * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, Textfeld ist kein Fensterobjekt |
 * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, Textfeld ist kein Fensterobjekt |
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
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Der sichtbare Text eines Textfeldes entspricht sein _Wert_ -> In diesem GUI-Adapter sind VerifyCaption und VerifyValue identisch. |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** | Im Beispie. `Name:` |
 * | `VerifyMaxLength( FN, ExpVal )`                                                               | **JA** |  |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Title Name` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **JA** | Der sichtbare Text eines Textfeldes ist sein Wert |
 * 
 *  # Quellen/Links
 *  
 *  - [SELFHTML-Wiki input](https://wiki.selfhtml.org/wiki/Referenz:HTML/input)
 *  - [Issue #107](https://github.com/Hrabovszki1023/OKW/issues/107)
 *  - [Issue #121](https://github.com/Hrabovszki1023/OKW/issues/121)
 *  
 *  \~english
 *  
 *  \~
 * @author Zoltán Hrabovszki
 * @date 2016.09.05
 */
public class SeInputText extends SeAnyChildWindow
{

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
     */
    public SeInputText( String Locator, OKWLocatorBase... Locators )
    {
        super( Locator, Locators );
    }

    
    /** \~german
     *  Ermittelt den textuellen Inhalt der Überschrift eines Textfeldes.
     *  
     *  Im GUI-adapter SeInputText ist die Überschrift (Caption) gleich dem Wert des Textfeldes.
     *  Daher ruft `SeInputText::getCaption()` die Methode `SeInputText::getValue()` auf!
     *   
     *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2013-12-07
     */
    @Override
    public ArrayList<String> getCaption()
    {
        return getValue();
    }
    
    
   /** \~german
   *  Ermittelt den textuellen Inhalt des Labels.
   *  
   *  Es wird das Attribute "textContent" des mit "id" an das aktuelle Objekt angebunde "Laben" gelesen.
   *  
   *  @return Rückgabe des Label-Textes.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2018.12.27
   */
   public Integer getMaxLength()
   {
       Integer lviReturn = 0;

       try
       {
           this.LogFunctionStartDebug( "getMaxLength" );

           // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
           this.WaitForMe();

           
           // The Attribute "MaxLength" auslesen...
           
           String lvsMaxLength = this.Me().getAttribute( "maxlength" );

           if ( !okw.OKW_Helper.isStringNullOrEmpty( lvsMaxLength) )
           {
               lviReturn = Integer.parseInt( lvsMaxLength );
           }
       }
       finally
       {
           this.LogFunctionEndDebug( lviReturn.toString() );
       }

       return lviReturn;
   }
   
   
    /** \~german
     *  Liest den Placeholder des input-Tags aus.
     * 
     *  Es wird das Attribut "placeholder" ausgelesen.
     *  @return Wert des Attributs "placeholder"
     *  
     *  \~english
     *  Reads the current placeholder of the input-tag.
     *  
     *  It reads the attribute "placeholder".
     *  
     *  @return The value of the attribute "placeholder"
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2018.10.28
     */
    public ArrayList<String> getPlaceholder()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "getPlaceholder" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // The Attribute "placeholder" wird als Beschriftung angezeigt...
            String myAttribute = this.Me().getAttribute( "placeholder" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }    

    
    /** \~german
     *  Ermittelt den Wert des Textfeldes, welches dem sichtbaren .
     *  
     *  @return
     *  Gibt den Textuellen Inhaltes des TextFeldes zurück.
     *  Es korrespondieren je eine Zeile des GUI-Objektes mit jeweil einem Listen-Element.<br/>
     *  Ein Textfield besteht aus einerZeile: Daher wird der Wert des Textfield-s im ListenElement[0] zurückgegeben.
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014.06.2014
     */
    @Override
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "GetValue" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // Get Value from TextField and put this into the return List<string>
            String myValue = this.Me().getAttribute( "value" );

            if ( myValue != null )
            {
                lvLsReturn.add( this.Me().getAttribute( "value" ) );
            }

        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn.toString() );
        }

        return lvLsReturn;
    }

 
    /**
     *  \~german
     */
    @Override
    public void SetValue( ArrayList<String> Val )
    {

        try
        {
            this.LogFunctionStartDebug( "SetValue", "Val", Val.toString() );

            // Wenn GUI-Objekt nicht gefunden wird, mit OKWGUIObjectNotFoundException aussteigen
            this.WaitForMe();

            WebElement myMe = this.Me();
            myMe.clear();

            if ( Val.get( 0 ).equals( okw.OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ) )
            {
                myMe.clear();
            }
            else
            {
                myMe.sendKeys( Val.get( 0 ) );
            }
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

}