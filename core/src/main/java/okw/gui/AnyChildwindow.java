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
package okw.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW_TimeOut;
import okw.core.IOKW_FN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.*;

/** \brief
 * Description of AnyWin.
 */ 
public abstract class AnyChildwindow extends AnyWinBase implements IGUIChildwindow
{
	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	/** \~german
   *  Prüft die Existenz des aktuellen Objektes.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Mathode ist nur als Platzhalter implementiert.
   *  - Hier wird die Ausnahme OKWFrameObjectMethodNotImplemented ausgelöst.
   *  
   *  Hinweis zur Implementierung:
   *  - Implementierung durch Methodeüberschreibung in den GUI-Klassen.
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
    throw new OKWFrameObjectMethodNotImplemented("The method getExists() is not defined for you GUI-Object. Please define first the methode!");
  }

  
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  private String myKN = "";

  
  /** \~german
   *  Setzten des Keyname FN.
   *  
   *  @fpsParentFN KN des Objektes
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  public void setKN(String fpsKN)
  {
    this.myKN =  fpsKN;
  }

  
  /** \~german
   *  Setzten des Objekt KN.
   *  
   *  @return KN des Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */ 
  public String getKN( )
  {
    return this.myKN;
  }


  
  /** \~german
   *  FN - Funktionaler Name des aktuellen GUI-Objektes.
   *  
   *  Wert wird 
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */    
  private String myFN = "";
	
  public void setFN(String fpsFN)
  {
    this.myFN =  fpsFN;
  }

  
  /** \~german
   *  Holt den funktionalen Name dws GUI-Objektes.
   * 
   *  Hinweis: Jeder GUI-Adapter kennt seinen eigenen funktionalen Namen.
   *  Dieser wird beim instanzieren der Frame-Objecte währen des Frame-Classen-Scans in der Methode FrameObjectDictionary_Sngltn.FrameScan()
   *  mitgeteilt.
   *  Wert wird 
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2014.04.27
   */  
  public String getFN( )
  {
    return this.myFN;
  }

  
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  private String myParentFN = "";

  
  /** \~german
   *  Setzten des Parent-Objekt FN.
   *  
   *  @fpsParentFN FN des Parent-Objektes
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */    
  public void setParentFN(String fpsParentFN)
  {
    this.myParentFN =  fpsParentFN;
  }

  /** \~german
   *  Setzten des Parent-Objekt FN.
   *  
   *  @return FN des Parent-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.11.20
   */ 
  public String getParentFN( )
  {
    return this.myParentFN;
  }

  
    public AnyChildwindow()
    {
        this._locator = new OKWLocator("");
    }


    public AnyChildwindow(String fpsLocator, OKWLocator... fpLocators )
    {
        if ( fpLocators.length != 0 )
        {
            this._locator = new OKWLocator(fpsLocator, fpLocators);
        }
        else
        {
            this._locator = new OKWLocator(fpsLocator);
        }
    }
   
    
    /** \~german
     *  Ermittelt aus dem gegebenen Locator das DOM-Elelement, welches das Objekt representiert.
     *  
     *  @return true, wenn das Objekt vorhanden ist.
     *  \~
     *  @author Zoltán Hrabovszki
     * @throws InterruptedException 
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws JAXBException 
     * @throws XPathExpressionException 
     *  @date 2013.11.11
     */
    public Boolean WaitForMe() throws InterruptedException, XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
      Boolean lvbReturn = false;
    
      Integer Count = 0;
      OKW_TimeOut timeout = FrameObjectDictionary_Sngltn.getInstance().getTimeOutWaitForMe( this.getKN() );
      
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
          Thread.sleep( timeout.getPollingTime() );
        }
        Count++;
      }
      return lvbReturn;
    }
}