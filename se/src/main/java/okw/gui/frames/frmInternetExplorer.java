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

package okw.gui.frames;

import java.util.ArrayList;

import okw.gui.adapter.selenium.SeBrowserWindow;

/**
* @ingroup groupSeleniumDriverFrames
* 
* Diese Klasse representiert den HTMLUnit-Driver, der mit Selenium angsteuert wird.
* Bildet HTMLUnit-Driver als Applikationsframe ab.
* 
* @section Verwendung
* 
* #Funktionaler Name
* FN="HTMLUnit"
*  
* # Unterstützte GUI-Schlüsselwörter
*
* ## Kindobjekt Aktionen
* 
* HTMLUnit represeniert ein Fenster/Elterobjekt, Daher sind keine Kind-Objekt Aktionen 
* 
* | OpenKeyWord               | Implementiert | Beschreibung |
* | ------------------------- | :-----------: | :----------- |
* | `ClickOn( FN )`           | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `DoubleClickOn( FN )`     | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented | 
* | `SetFocus( FN )`          | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `SetValue( FN, Val )`     | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `Select( FN, Val )`       | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `SelectMenu( FN )`        | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `SelectMenu( FN, Val )`   | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* | `TypeKey( FN, Val )`      | **NEIN**      | -> throw OKWFrameObjectMethodNotImplemented |
* 
* ## Fensterbezogene Schlüsselwörter
* 
* | OpenKeyWord                   | Implementiert | Beschreibung |
* | ----------------------------- | :-----------: | :----------- |
* | `StarApp( AN )`               | **JA**        | Erzeugt eine HTMLUnit-Driver Instanz für die Selenium GUI-Adapter |
* | `StopApp( AN )`               | **JA**        | Beendet die HTMLUnit-Driver Instanz welches vorher mit StartApp(String) erzeugt wurde |
* | `SelectWindow( FN )`          | **JA**        |  |
* | `Sequence( FN, SQN, SEQ_ID )` | **JA**        |  |
* 
* ## Verifying, Memorizing, Logging Values
* 
* Schlüsselwort Gruppen, die jeweils auf der selben GUI-Adapter Methods get*() aufsetzen<br/>
* (z.B.: `VerifyExists( FN, ExpVal)`, `MemorizeExists( FN, MemKey)`,`LogExists( FN )` -> `getExists()` )
* 
* | OpenKeyWord | Implementiert | Beschreibung |
* | ----------- | :-----------: | :----------- |
* | `VerifyExists( FN, ExpVal)`,    <br>`MemorizeExists( FN, MemKey)`,    <br>`LogExists( FN )`   | **NEIN** |  |
* | `VerifyHasFocus( FN, ExpVal )`, <br>`MemorizeHasFocus( FN, MemKey)`,  <br>`LogHasFocus( FN )` | **NEIN** |  |
* | `VerifyIsActive( FN, ExpVal )`, <br>`MemorizeIsActive( FN, MemKey)`,  <br>`LogIsActive( FN )` | **NEIN** |  |
* | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Als \ref refCaption wird das Attribute `textContent` verwendet.. Im Beispiel: `Button Caption` |
* | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )`     | **JA** |  |
* | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Als Tooltip wird das Attribute `title` verwendet.  Im Beispiel: `Button title` |
* | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )`     | **JA** | Als Tooltip wird das Attribute `value` verwendet. |
* 
 * 
 * \~english
 * \todo TODO: Brief Description.
 * 
 *  \todo TODO: Detailed Description
 * 
 * \~
 * @author Zoltán Hrabovszki
 * @date 2015-05-12
 * @author zoltan
 */
//@OKW (FN="InternetExplorer")
public class frmInternetExplorer extends SeBrowserWindow
{

    /** \~german
     * Konstruktor der Klasse, aktuell keine MethodenAufrufe.
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     *  
     *  \todo TODO: Detailed Description
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.05.12
     */
    public void SelectWindow()
    {
    }

    /** \~german
     *  Erzeugt eine Instanz des Selenium HTMLUnit-Drivers.
     *  
     * 
     *  \~english
     *  \brief \todo TODO: Brief Description.
     *  
     *  \todo TODO: Detailed Description
     *  
     * 
     *  \~
     *  \author Zoltán Hrabovszki
     *  \date 2015.05.12
     */
    public void StartApp()
    {
        LogFunctionStartDebug("StartApp");
        
        //SeDriver.getInstance().setDriver( fpDriver );
        // this.Init();

        LogFunctionEndDebug();
    }

    
    /** \~german
     *  HTMLUnit-Driver Beenden. 
     * 
     *  Beendet den HTMLUnit-Driver mit der Methode Quit()
     *  
     *  \~english
     *  Terminates the HTML-Unit Driver
     *  
     *  \todo TODO: Detailed Description
     *
     * \~
     * \author Zoltán Hrabovszki
     * \date 2015.05.12
     */
    public void StopApp()
    {
        LogFunctionStartDebug("StopApp");

        //SeDriver.getInstance().driver.quit();

        LogFunctionEndDebug();
    }

    public void TypeKey(ArrayList<String> fps_Values)
    {
    }
}