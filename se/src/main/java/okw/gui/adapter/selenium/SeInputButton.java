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

package okw.gui.adapter.selenium;

import java.util.ArrayList;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.OKWLocator;


     /**  \~german
     *  SeInputButton ist die GUI-Adapter Klasse für html tags vom typ <input type='button'> 
     *  
     *  <a href="http://test.penkeyword.de/index.htm#input_type-button">InputButton Testseiten</a>
     *  \~english
     *  
     *  \~
     *  \sa https://github.com/Hrabovszki1023/OKW/wiki/SeInputButton
     *  \sa https://github.com/Hrabovszki1023/OKW/issues/108
     *  @author Zoltán Hrabovszki
     *  @date 2016.09.05
     */
    public class SeInputButton extends SeAnyChildWindow
    {
        /**
         *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2013.05.03
         */
        public SeInputButton(String Locator, OKWLocator... fpLocators)
        {
        	super(Locator, fpLocators);
        }


         /**  \~german
         *  \brief
         *  Ermittelt den textuellen Inhalt des Caption für Prüfewert.
         *  
         *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
         *  
         *  \return
         *  Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
         *  Interface schreibt ein Listen-Element als Rückgabewert vor.
         *  \return
         *  \~english
         *  \~
         *  \author Zoltán Hrabovszki
         *  \date 2013.12.07
         */
        @Override
        public ArrayList<String> VerifyCaption() throws InterruptedException
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
              this.LogFunctionStartDebug("VerifyCaption");
              
              // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
                lvLsReturn = this.getCaption( );
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }

         /**  \~german
         *  \brief
         *  Ermittelt den textuellen Inhalt der Beschriftung (Caption).
         *  
         *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
         *  
         *  \return
         *  Rückgabe des Textuellen Inhaltes der Tooltips.
         *  Interface schreibt ein Listen-Element als Rückgabewert vor.
         *  \return
         *  \~english
         *  \~
         *  \author Zoltán Hrabovszki
         *  \date 2013.12.07
         */
        @Override
        public ArrayList<String> LogCaption()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("LogCaption");

                lvLsReturn = this.getCaption();
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }

         /**  \~german
         *  \brief
         *  Ermittelt den textuellen Inhalt des Caption/Überschrift für das Schlüsselwort MerkeWert.
         *  
         *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
         *  
         *  \return
         *  Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
         *  Interface schreibt ein Listen-Element als Rückgabewert vor.
         *  \return
         *  \~english
         *  \~
         *  \author Zoltán Hrabovszki
         *  \date 2013.12.07
         */
        @Override
        public ArrayList<String> MemorizeCaption()
        {
            ArrayList<String> lvLsReturn = null;

            try
            {
                this.LogFunctionStartDebug("MemorizeCaption");

                lvLsReturn = this.getCaption();
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }
        
         /**  \~german
         *  Ermittelt den textuellen Inhalt der Caption/Überschrift des Objektes.
         *  
         *  @return
         *  Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
         *  \~english
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2013.12.07
         */
        @Override //TODO define Prototype in BaseClass!
        public ArrayList<String> getCaption()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            try
            {
                this.LogFunctionStartDebug("GetCaption");

                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "getCaption()");
                    throw new OKWGUIObjectNotFoundException(lvsLM);
                }
                
                // The Attribute "value" wird als Beschriftung angezeigt...
                lvLsReturn.add(this.Me().getAttribute("value"));
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }
            
            return lvLsReturn;
        }

  /** \~german
   *  Ein SeInputButton hat keinen Wert! -> OKWFrameObjectMethodNotImplemented
   *  Auslösen!
   * 
   *  @return
   *  \~english
   *  \brief
   *  A SeInputButton has no value! -> Trigger
   *  OKWFrameObjectMethodNotImplemented!
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.10.06
   */
  @Override
  public ArrayList<String> getValue()
  {
    // ArrayList<String> lvLsReturn = new ArrayList<String>();
    try
    {
      MyLogger.LogFunctionStartDebug( "GetValue" );

      String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "getValue()" );
      throw new OKWFrameObjectMethodNotImplemented( lvsLM );
    }
    finally
    {
      MyLogger.LogFunctionEndDebug();
    }
    // return lvLsReturn;
  }
}