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
package okw.gui;

import java.util.ArrayList;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW;
import okw.OKW_TimeOut;
import okw.core.IOKW_FN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;

/** 
 * Description of AnyWin.
 */ 
public class AnyWindow extends AnyWinBase implements IGUIWindow, IOKW_FN
{

    public AnyWindow( )
    {
        super();
    }

    
  public AnyWindow( String fpsLocator, OKWLocator... fpLocators )
	{
       this.setLocator( fpsLocator, fpLocators );
	}


/** \~german
   *  Prüft die Existenz des aktuellen Objektes.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Hier wird die Ausnahme OKWFrameObjectMethodNotImplemented ausgelöst.
   *  
   *  Hinweis zur Implementierung:
   *  - Implementierung durcg Methoden überschreiung in den GUI-Klassen.
   *  - Ist eine elementare Funktion, muss Werkzeugspezifisch (für Selenium, AutoIt, SilkTets usw.) defiert sein/werden.
   *  - Warten nicht auf die Existenz eines Objektes!
   *  - Es wird nur ein eiziges mal die Existenz geprüft.
   *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist!
   *  
   *  @return true, falls das eindeutig Objekt gefunden worden ist ist, sonst false.
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2017.01.31
   */  
  public Boolean getExists()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method Boolean getExists() is not definden for the current GUI-Object. Please define first this method in your GUI-Class!");
  }

  /** \~german
   *  Ermittelt die Caption/Überschrift des aktuellen Objektes.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Hier wird die Ausnahme OKWFrameObjectMethodNotImplemented ausgelöst.
   *  
   *  Hinweis zur Implementierung:
   *  - Implementierung durcg Methoden überschreiung in den GUI-Klassen.
   *  - Ist eine elementare Funktion, muss Werkzeugspezifisch (für Selenium, AutoIt, SilkTets usw.) defiert sein/werden.
   *  - Warten nicht auf die Existenz eines Objektes!
   *  - Es wird nur ein eiziges mal die Existenz geprüft.
   *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist!
   *  
   *  @return true, falls das eindeutig Objekt gefunden worden ist ist, sonst false.
   *  \~
   *  @author Zoltán Hrabovszki
   * @throws Exception 
   *  @date 2017.01.31
   */  
  public ArrayList<String> getCaption()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method ArrayList<String> getCaption() is not definden for you GUI-Object. Please define first the methode!");
  }  


  /** \~german
   *  Ermittelt ob das aktuelle Objekt aktiv ist.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Hier wird die Ausnahme OKWFrameObjectMethodNotImplemented ausgelöst.
   *  
   *  Hinweis zur Implementierung:
   *  - Implementierung durcg Methoden überschreiung in den GUI-Klassen.
   *  - Ist eine elementare Funktion, muss Werkzeugspezifisch (für Selenium, AutoIt, SilkTets usw.) defiert sein/werden.
   *  - Warten nicht auf die Existenz eines Objektes!
   *  - Es wird nur ein eiziges mal die Existenz geprüft.
   *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist!
   *  
   *  @return true, falls das eindeutig aktiv ist, sonst false.
   *  \~
   *  @author Zoltán Hrabovszki
   *  @throws Exception 
   *  @date 2017.01.31
   */  
  public Boolean getIsActive()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method Boolean getIsActive() is not definden for this GUI-Object. Please define first this methode!");
  }  


  public void TypeKeyWindow(ArrayList<String> Val)
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method void TypekeyWindow(ArrayList<String> Val) is not definden for this GUI-Object. Please define first this methode!");
  }


  public void SelectWindow()
    {
	    // TODO: /todo Meldung in xml-Auslagern
	    throw new OKWFrameObjectMethodNotImplemented("The method void SelectWindow() is not definden for this GUI-Object. Please define first this methode!");
    }


  public void StartApp()
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method void void StartApp() is not definden for this GUI-Object. Please define first this methode!");
  }


  public void StopApp()
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method void StopApp() is not definden for this GUI-Object. Please define first this methode!");
  }

  
  public Boolean VerifyWindowExists()
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method Boolean VerifyWindowExists() is not definden for this GUI-Object. Please define first this methode!");
  }

  
  public Boolean VerifyIsWindowActive()
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method Boolean VerifyIsWindowActive() is not definden for this GUI-Object. Please define first this methode!");
  }


  public ArrayList<String> VerifyWindowCaption()
  {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method ArrayList<String> VerifyWindowCaption() is not definden for this GUI-Object. Please define first this methode!");
  }


  /** \~german
	 *  Methode, wartet auf das aktuelle GUI-Object bis es erscheint oder der eingestellte TimeOut erreicht ist.
	 *  
	 *  Time Out kann mit der Annotation OKW und Attributen
	 *  
	 *  -# WaitForMe_PT - Polling Time [ms] - (default 1000). <br>
     *  -# WaitForMe_TO - TimeOut [s]  - (default 30).
	 *  
	 *  Wichtig: Die methode liefert lediglich false zurück, d.h. es wir keine Ausnahme ausgelöst,
	 *  wenn das Object nicht gefunden wird.
	 *  
	 *  @return true, wenn das Objekt vorhanden ist. sonst false. 
	 *  \~
	 * @throws RuntimeException 
     * @author Zoltán Hrabovszki
 	 * @date 2017.01.31
	 */
	public Boolean WaitForMe()
	{
	  Boolean lvbReturn = false;
	
	  Integer Count = 0;

	  try{
	  OKW MyOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );
	
	  // TimeOut-Werte Ermitteln
	  OKW_TimeOut timeout = new OKW_TimeOut( MyOKW.WaitForMe_TO(),MyOKW.WaitForMe_PT());
	  	  
	  Count = 0;
	
	  while ( Count <= timeout.getMaxCount() )
	  {
	    if ( this.getExists() )
	    {
	      lvbReturn = true;
	      break;
	    }
	    else
	    {
	      Thread.sleep( timeout.getPT() );
	    }
	    Count++;
	  }
	  }
	  catch(Exception e)
	  {
	      throw new RuntimeException( e );
	  }
	  return lvbReturn;
	}
}