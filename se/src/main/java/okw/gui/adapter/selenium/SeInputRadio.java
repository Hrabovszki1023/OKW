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
package okw.gui.adapter.selenium;

import java.util.ArrayList;
import okw.OKW_Const_Sngltn;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWNotAllowedValueException;
import okw.gui.OKWLocatorBase;


/**
 * @ingroup groupSeleniumChildGUIAdapter 
 * 
 * \~german
 *  Diese Klasse representiert eine <input type="radio">-Tag, der mit Selenium angsteuert wird.
 *  
 *  @startuml
 *   class SeInputRadio [[java:okw.gui.adapter.selenium.SeInputRadio]] {
 *   ..Constructor..
 *   +SeInputRadio(String Locator, OKWLocator[] Locators)
 *   +SeInputRadio(String IframeID, String Locator, OKWLocator[] Locators)
 *   ..Getter/Setter..
 *   +ArrayList<String> getValue()
 *   +Boolean getIsSelected()
 *   +ArrayList<String> getCaption()
 *   +void SetValue(ArrayList<String> Values)
 *   +Boolean getHasFocus()
 *   .. Keyword API..
 *   +void SetFocus()
 *   +void TypeKey(ArrayList<String> fps_Values)
 *   }
 * class SeAnyChildWindow [[java:okw.gui.adapter.selenium.SeAnyChildWindow]] {
 *   }
 * SeAnyChildWindow <|-- SeInputRadio
 * @enduml
 * 
 *  # Unterstützter Tag
 *  Folgender HTML-Tag wird unterstützt:
 *  
 *  \code{.html}
 *  <input type="radio"
 *         id="id_Mastercard"
 *         name="Zahlmethode"
 *         value="Mastercard">
 *  <label for="id_Mastercard"> Mastercard</label><br>
 *  \endcode
 * 
 * # Unterstützte GUI-Schlüsselwörter
 *
 * ## Kindobjekt Aktionen
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `ClickOn( FN )`           | **JA**        |   |
 * | `DoubleClickOn( FN )`     | **NEIN**      | -> OKWFrameObjectMethodNotImplemented |
 * | `SetFocus( FN )`          | **NEIN**      | -> OKWFrameObjectMethodNotImplemented |
 * | `SetValue( FN, Val )`     | **JA**        | Erlaubter Wert: CHECKED ist möglich, UNCHECKED ist nicht möglich. |
 * | `Select( FN, Val )`       | **JA**        | -> OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN )`        | **NEIN**      | -> OKWFrameObjectMethodNotImplemented |
 * | `SelectMenu( FN, Val )`   | **NEIN**      | -> OKWFrameObjectMethodNotImplemented |
 * | `TypeKey( FN, Val )`      | **NEIN**      | -> OKWFrameObjectMethodNotImplemented |
 * 
 * ## Fensterbezogene Schlüsselwörter
 * 
 * | OpenKeyWord               | Implementiert | Beschreibung |
 * | ------------------------- | :-----------: | :----------- |
 * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
 * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
 * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
 * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, Checkbox ist kein Fensterobjekt |
 * 
 * ## Verifying, Memorizing, Logging Values
 * 
 * Group of keywords using the same GUI-Adapter Methods get*() <br/>
 * (e.g.: `VerifyExists( FN, ExpVal)`, `MemorizeExists( FN, MemKey)`,`LogExists( FN )` -> `getExists()` )
 * 
 * | OpenKeyWord | Implementiert | Beschreibung |
 * | ----------- | :-----------: | :----------- |
 * | `VerifyExists( FN, ExpVal)`,    <br>`MemorizeExists( FN, MemKey)`,    <br>`LogExists( FN )` | **JA** |  |
 * | `VerifyHasFocus( FN, ExpVal )`, <br>`MemorizeHasFocus( FN, MemKey)`,  <br>`LogHasFocus( FN )` | **NEIN** | -> UnsupportedOperationException |
 * | `VerifyIsActive( FN, ExpVal )`, <br>`MemorizeIsActive( FN, MemKey)`,  <br>`LogIsActive( FN )` | **JA** |  |
 * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Caption ist der sichtbare Text neben der Checkboc |
 * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )` | - **JA** | Zu Prüfen: Ist eine CheckBox mit einem Label verbindbar? |
 * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Wert des attributes `title` |
 * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )` | **JA** | Wenn gesetzt = `CHECKED` sonst `UNCHECKED` |
 * 
 *  # Quellen/Links
 *  
 *  - [SelfHTML: HTML/Formulare](https://wiki.selfhtml.org/wiki/HTML/Formulare)
 *  - [Issue #140](https://github.com/Hrabovszki1023/OKW/issues/140)
 *  - [Issue #112](https://github.com/Hrabovszki1023/OKW/issues/112) *  
 *  \~english
 *  
 *  \~
 *  @author Zoltan Hrabovszki
 *  \date 2013.04.11
 */
public class SeInputRadio extends SeAnyChildWindow
{

  /**
   *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
   *  
   *  \date 2013.04.11
   */         
  public SeInputRadio( String Locator, OKWLocatorBase... Locators )
  {
      super(Locator, Locators);
  }

   
  /** Ermittelt den aktuellen Wert des RadioButtons.
   * 
   * Mögliche Werte sind sprachabhängig CHECKED/UNCHECKED
   * 
   * @return Liefert im ersten Wert des ArrayList&lt;String&gt; sprachabhängig CHECKED/UNCHECKED zurück.
   * @author Zoltan Hrabovszki
   * @throws Exception 
   * \date 2013.04.11
   */
  @Override
  public ArrayList<String> getValue()
  {
      ArrayList<String> lvls_Return = new ArrayList<String>();
      try
      {
          LogFunctionStartDebug("getValue");

          // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
          this.WaitForMe();

          if (this.getIsSelected())
          {
              String lvsValue = OKW_Const_Sngltn.getInstance().GetConst4Internalname("CHECKED");
              lvls_Return.add(lvsValue);
          }
          else
          {
              String lvsValue = OKW_Const_Sngltn.getInstance().GetConst4Internalname("UNCHECKED");
              lvls_Return.add(lvsValue);
          }
      }
      finally
      {
          LogFunctionEndDebug(lvls_Return);
      }
      
      return lvls_Return;
  }


    /**
     *  Method liefert den aktuellen Zustand des RadioButtons,
     *  ausgewählt oder nicht.
     *  
     *  @return Wenn Ausgewählt: true, sonst false
     *  @author Zoltan Hrabovszki
     *  @throws Exception 
     *  \date 2013.04.11
     */
    public Boolean getIsSelected()
    {
        Boolean lvbReturn = false;

        LogFunctionStartDebug( "IsSelected" );

        try
        {
            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // Hole Zusand: Häckchen oder kein Häckchen, das ist hier die Frage?
            lvbReturn = this.Me().isSelected();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }
        return lvbReturn;
    }

  /** \~german
   *  \brief
   *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
   *   
   *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2013.12.07
   */
  @Override
  public ArrayList<String> getCaption()
  {
      try
      {
         this.LogFunctionStartDebug("getCaption");
         // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
    	   throw new OKWFrameObjectMethodNotImplemented("Radiobutton/SeInputRadion has no Caption! - See Label...");
      }
      finally
      {      
          this.LogFunctionEndDebug( );
      }
  }

  /**
   * \~german
   *  Ein SeInputButton IstkeinMenüobject! -> OKWFrameObjectMethodNotImplemented
   *  auslösen!
   *
   * \~english
   *  A SeInputButton has no value! -> Trigger
   *  OKWFrameObjectMethodNotImplemented!
   * \~
   * @author Zoltán Hrabovszki
   * \date 2016.10.06
   */
  @Override
  public void SetValue( ArrayList<String> Values )
  {

    try
    {
      this.LogFunctionStartDebug( "SetValue" );
      
      // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
      this.WaitForMe();
      
      String Value = Values.get(0);
      String myCHECKED = OKW_Const_Sngltn.getInstance().GetConst4Internalname("CHECKED");
      String myUNCHECKED = OKW_Const_Sngltn.getInstance().GetConst4Internalname("UNCHECKED");

      if ( Value.equals(myCHECKED) )
      {
          //Core myCore = new Core();
          //myCore.ClickOn( this.getCAT() );
          this.ClickOn();
      }
      else if ( Value.equals(myUNCHECKED) )
      {
          throw new OKWNotAllowedValueException("RadioButton is not UNCHECKE-able!");
      }
      else
      {
          String lvsLM = LM.GetMessage("Common", "OKWNotAllowedValueException", Value);
          throw new OKWNotAllowedValueException(lvsLM);
      }
    }
    finally
    {
      this.LogFunctionEndDebug();
    }
  }


  /** \~german
   *  Methode liefert den aktuellen Zustand Wert des Focus.
   *  
   *  @see http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.12.20
   */
  @Override
  public Boolean getHasFocus()
  {
	      try
	      {
	          this.LogFunctionStartDebug("getHasFocus");
	          // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
	    	  throw new UnsupportedOperationException("The Radiobutton/SeInputRadion can´t have a focus. The RadioList has the focus.");
	      }
	      finally
	      {      
	          this.LogFunctionEndDebug( );
	      }
	  }

  
  /** \~german
   *  Diese Implemnetierung geht davon aus das ein RadioButten 
   *  selbst keinen Focus besitzen kann sondern die RadiList, die dieser angehört.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2013.11.11
   */
  @Override
  public void SetFocus()
  {
      try
      {
          this.LogFunctionStartDebug("SetFocus");
          // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
    	  throw new OKWFrameObjectMethodNotImplemented("The Radiobutton/SeInputRadion itself can not have a focus, the RadioList has the focus. Please use VerifyHasFosus with the RadioList!");
      }
      finally
      {      
          this.LogFunctionEndDebug( );
      }
  }
  
  /** \~german
   *  Tastatur Eingabe an das Objekt
   *  
   *  @param fps_Values Werte, die via Tastatur eingegeben werden sollen.
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2013-04-11
   */
  public void TypeKey(ArrayList<String> fps_Values)
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new UnsupportedOperationException("Typekey is unsuported.");
  }
}
