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
package okw.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW;
import okw.OKW_TimeOut;
import okw.core.IOKW_FN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;


/** \brief
 * @todo TODO: Description of AnyWin.
 */ 
public abstract class AnyChildwindow extends AnyWinBase implements IGUIChildwindow, IOKW_FN
{
	
  /** \~german
   *  Prüft die Existenz des aktuellen Objektes.
   *  
   *  - Methode kann hier nicht implementiert werden.
   *  - Methoden ist nur als Platzhalter implementiert.
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

  public Boolean getHasFocus()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getHasFocus() is not defined for you GUI-Object. Please define first the methode!");
  }

  public Boolean getIsActive()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getIsActive() is not defined for you GUI-Object. Please define first the methode!");
  }
  
  public ArrayList<String> getCaption()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getCaption() is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> getTooltip()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getTooltip() is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> getPlaceholder()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getPlaceholder() is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> getLabel()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getLabel() is not defined for you GUI-Object. Please define first the methode!");
  }

  public Integer getMaxLength()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getMaxLength() is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> getValue()
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method getValue() is not defined for you GUI-Object. Please define first the methode!");
  }

  public void ClickOn( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method ClickOn() is not defined for you GUI-Object. Please define first the methode!");
  }

  public void DoubleClickOn( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public void DoubleClickOn( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogCaption( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogCaption( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public boolean LogExists( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean LogExists( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public boolean LogHasFocus( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean LogHasFocus( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }
  
  public boolean LogIsActive( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean LogIsActive( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogLabel( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogLabel( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogPlaceholder( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogPlace( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogSelected( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogSelected( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogTablecellValue( String COL, String ROW )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> ( String COL, String ROW ) throws Exception' throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> LogTooltip( )
{
  // TODO: /todo Meldung in xml-Auslagern
  throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogTooltip( ) throws Exception' throws Exception' is not defined for you GUI-Object. Please define first the methode!");
}

public ArrayList<String> LogValue( )
{
  // TODO: /todo Meldung in xml-Auslagern
  throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> LogValue( ) throws Exception' throws Exception' is not defined for you GUI-Object. Please define first the methode!");
}

public ArrayList<String> MemorizeCaption( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeCaption( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public boolean MemorizeExists( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean MemorizeExists( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }
  
  public boolean MemorizeHasFocus( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean MemorizeHasFocus( ) throws Exception' throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }
  
  public boolean MemorizeIsActive( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public boolean MemorizeIsActive( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizeLabel( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeLabel( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizePlaceholder( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizePlaceholder( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizeSelectedValue( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeSelectedValue( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizeTablecellValue( String COL, String ROW )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeTablecellValue( String COL, String ROW ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizeTooltip( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeTooltip( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public ArrayList<String> MemorizeValue( )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> MemorizeValue( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

  public void Select( ArrayList<String> fpLsParameter )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method Select() is not defined for you GUI-Object. Please define first the methode!");
  }

  public void SelectMenu(  ) throws Exception
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method SelectMenu() is not defined for you GUI-Object. Please define first the methode!");
  }

  public void SelectMenu( ArrayList<String> Val )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method SelectMenu() is not defined for you GUI-Object. Please define first the methode!");
  }

    public void SelectTablecell( String COL, String ROW )
  {
    // TODO: /todo Meldung in xml-Auslagern
    throw new OKWFrameObjectMethodNotImplemented("The method 'public void SelectTablecell( String COL, String ROW ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
  }

    public void SetFocus( ) throws Exception
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void SetFocus( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public void SetValue(ArrayList<String> Val )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void SetValue( ArrayList<String> Val ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public void TypeKey(ArrayList<String> Val )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void TypeKey( ArrayList<String> Val ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public void TypeKeyTablecell( String COL, String ROW, ArrayList<String> Val )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void TypeKeyTablecell( String COL, String ROW, ArrayList<String> Val ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }
    
    public ArrayList<String> VerifyLabel( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyLabel( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifyBadge( )
	{
	  // TODO: /todo Meldung in xml-Auslagern
	  throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyBadge( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
	}

	public ArrayList<String> VerifyBadgeWCM( )
	{
	  // TODO: /todo Meldung in xml-Auslagern
	  throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyBadgeWCM( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
	}

	public ArrayList<String> VerifyBadgeREGX( )
	{
	  // TODO: /todo Meldung in xml-Auslagern
	  throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyBadgeREGX( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
	}

	public ArrayList<String> VerifyPlaceholder( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyPlaceholder( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public Integer VerifyMaxLength( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyMaxLength( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifyCaption( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyCaption( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifyTooltip( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> VerifyTooltip( )' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifyValue( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> VerifyValue( )' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifyTablecellValue( String COL, String ROW )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> VerifyTablecellValue( )' is not defined for you GUI-Object. Please define first the methode!");
    }

    public ArrayList<String> VerifySelectedValue( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public ArrayList<String> VerifySelectedValue( )' is not defined for you GUI-Object. Please define first the methode!");
    }
    
    public Boolean VerifyExists( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public Boolean VerifyExists( )' is not defined for you GUI-Object. Please define first the methode!");
    }

    public Boolean VerifyIsActive()
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public Boolean VerifyIsActive()' is not defined for you GUI-Object. Please define first the methode!");
    }

    public Boolean VerifyHasFocus( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public Boolean VerifyHasFocus( )' is not defined for you GUI-Object. Please define first the methode!");
    }
    
    public Integer VerifyMinLength( )
    {
      // TODO: /todo Meldung in xml-Auslagern
      throw new OKWFrameObjectMethodNotImplemented("The method 'public void VerifyMinLength( ) throws Exception' is not defined for you GUI-Object. Please define first the methode!");
    }


    /**
     *  Wir benötigt damit in den abgeleitetetn Klassen
     *  'Implicit super constructor AnyChildwindow() is undefined. Must explicitly invoke another constructor'
     */
    public AnyChildwindow( )
    {
        super();
    }
    
    
    public AnyChildwindow( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        //this.setLocator( fpsLocator, fpLocators );
        super (fpsLocator, fpLocators );
    }
   

    /** \~german
     *  Methode wartet auf die Existenz des aktuellen Objectes.
     *  
     *  Wichtig: Methode löst keine Exception aus, wenn das Objekt nicht erscheint!
     *  
     *  @return true, wenn das Objekt vorhanden ist, sonst false.
     *  \~
     * @throws InterruptedException 
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws JAXBException 
     * @throws XPathExpressionException 
     * 
     *  @author Zoltán Hrabovszki
     *  @date 2013.11.11
     */
    public Boolean WaitForMe()
    {
        // Variables
        Boolean lvbReturn = false;
        Integer Count = 0;

        try
        {
            OKW myOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );

            // TimeOut-Werte Ermitteln
            OKW_TimeOut timeout = new OKW_TimeOut( myOKW.WaitForMe_TO(), myOKW.WaitForMe_PT() );

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
        catch (Exception e)
        {
            // TODO: handle exception
            throw new RuntimeException(e);
        }

        return lvbReturn;
    }

}