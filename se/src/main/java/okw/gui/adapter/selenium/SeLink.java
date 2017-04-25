package okw.gui.adapter.selenium;

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

import java.util.ArrayList;
import okw.gui.OKWLocator;

/**
 * \~german
 *  Diese Klasse representiert einen HTML-Link, die mit Selenium angsteuert wird.
 *  
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <a href="./Path/WebSite.htm">Link Caption</a>
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |  |
 * | `DoubleClickOn( FN )`     | **NEIN**      | Ein Doppel-Klick ist auf ein Link nicht möglich|
 * | `SetFocus( FN )`          | **NEIN**      | Fokus kann nicht auf ein Link gestezt werden. - Oder doch? Dann aber wie? |
 * | `SetValue( FN, Val )`     | **NEIN**      | Link hat keinen änderbaren Wert. |
 * | `Select( FN, Val )`       | **NEIN**      | Link hat keinen änderbaren Wert. |
 * | `SelectMenu( FN )`        | **NEIN**      | Denkbar, jedoch noch nicht unterstützt |
 * | `SelectMenu( FN, Val )`   | **NEIN**      | Kein Wert  |
 * | `TypeKey( FN, Val )`      | **NEIN**      | Link hat keinen änderbaren Wert. Shortcut nicht bekannt. |
 * 
 * ## Fensterbezogene Schlüsselwörter
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, Link ist kein Fensterobjekt |
 * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, Link ist kein Fensterobjekt |
 * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, Link ist kein Fensterobjekt |
 * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, Link ist kein Fensterobjekt |
 * 
 * ## Verifying, Memorizing, Logging Values
 * 
 * Group of keywords using the same GUI-Adapter Methods get*() <br/>
 * (e.g.: `VerifyExists( FN, ExpVal)`, `MemorizeExists( FN, MemKey)`,`LogExists( FN )` -> `getExists()` )
 * 
 * | OpenKeyWord | Implementiert | Beschreibung |
 * | ----------- | :-----------: | :----------- |
 * | `VerifyExists( FN, ExpVal)`,    <br>`MemorizeExists( FN, MemKey)`,    <br>`LogExists( FN )`   | **JA** |  |
 * | `VerifyHasFocus( FN, ExpVal )`, <br>`MemorizeHasFocus( FN, MemKey)`,  <br>`LogHasFocus( FN )` | **NEIN** |  |
 * | `VerifyIsActive( FN, ExpVal )`, <br>`MemorizeIsActive( FN, MemKey)`,  <br>`LogIsActive( FN )` | **NEIN** |  |
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Caption ist der sichtbare Text des Links, im Beispiel `Link Caption` |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )` | - **JA** | Zu Prüfen: Ist eine Link mit einem Label verbindbar? |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip Wird das Attribute `title` verwendet |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )` | **JA** | Als Wert wird das Attribute `href` verwendet. |
 * 
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Textauszeichnung/a](https://wiki.selfhtml.org/wiki/HTML/Textauszeichnung/a)
 *  - [Issue #106](https://github.com/Hrabovszki1023/OKW/issues/106)
 *  - [Issue #120](https://github.com/Hrabovszki1023/OKW/issues/120)
 *  
 *  \~english
 *  
 *  \~
 *  @author Zoltan Hrabovszki
 *  @date 2013.04.11
 */
public class SeLink extends SeAnyChildWindow
{

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
     */
    public SeLink( String Locator, OKWLocator... Locators )
    {
        super( Locator, Locators );
    }

    /**
     *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,String,OKWLocator)
     *  
     *  @date 2017.02.17
     */
    public SeLink( String IframeID, String Locator, OKWLocator... Locators )
    {
        super( IframeID, Locator, Locators );
    }

    /* @Override
     public void SetFocus()
     {
     	super.SetFocus();
     }*/

    /** \~german
     *  \brief
     *  Ein Standard HTML-Link kann nicht aktiv/inaktiv oder enable/disables sein.
     *  
     *  Methode muss ggf. Projektspezifisch implementiert werden.
     *  
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2014.11.26
     */
    @Override
    public Boolean getIsActive()
    {
        throw new UnsupportedOperationException( "Link cannot be Active" );
    }

    @Override
    public boolean LogIsActive()
    {
        throw new UnsupportedOperationException( "Link cannot be Active" );
    }

    @Override
    public boolean MemorizeIsActive()
    {
        throw new UnsupportedOperationException( "Link cannot be Active" );
    }

    @Override
    public Boolean VerifyIsActive()
    {
        throw new UnsupportedOperationException( "Link cannot be Active" );
    }

    /** \brief
     *  OpenKeyWord implemntiert den href-Attribute als "Value" eines HTML-Linkes.
     * 
     *  \return
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

            // The Attribute "value" wird als Beschriftung angezeigt...
            lvLsReturn.add( this.Me().getAttribute( "href" ) );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }
}