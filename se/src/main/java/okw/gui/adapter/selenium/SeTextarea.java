/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015, 2016 IT-Beratung Hrabovszki
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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import okw.OKW_Const_Sngltn;
import okw.gui.OKWLocator;


    /**  IOKW_SimpleDataObj
     *  \~german
     *  Diese Klasse implmenetiert die Methoden der IOKW_SimpleDataObj für ein Texfeld<br/>.
     *  GUI-Automatisierungswerkzeug: Selenium.<br/>
     *  Die meisten Methoden werden aus der abtrakten Klasse SeSimpleDataObjekt geerbt.
     *  
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014.06.2014
     */
    public class SeTextarea extends SeAnyChildWindow
    {

      /**
       *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
       */         
       public SeTextarea(String Locator, OKWLocator... fpLocators)
        {
        	super(Locator, fpLocators);
        }


        /** \~german
         *  \brief
         *  Ermittelt den textuellen Inhalt eines Textfeldes.<br/>.
         *  GUI-Automatisierungswerkzeug: Selenium.<br/>
         *  
         *  \return
         *  Gibt den Textuellen Inhaltes eines DOM-TextField-s zurück.
         *  Es korrespondieren je eine Zeile des GUI-Objektes mit jeweil einem Listen-Element.<br/>
         *  Ein Textfield besteht aus einerZeile: Daher wird der Wert des Textfield-s im ListenElement[0] abgelegt.
         *  Zurückgegeben.
         *  \return
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014.06.2014
         * @throws Exception 
         */
        //@Override
        public ArrayList<String> igetValue() throws Exception
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("getValue");

                // Get Value from TextField and put this into the return List<string>
                // lvLsReturn.add(this.Me().getAttribute("value"));
                String myText = this.Me().getText();
                
                if ( !myText.isEmpty() )
                {
                lvLsReturn.add(myText);
                }
            }
            finally
            {
                    this.LogFunctionEndDebug(lvLsReturn.toString());
            }

            return lvLsReturn;
        }
        
        public void setAttribute( WebElement elem, String value )
        {
        	JavascriptExecutor js = (JavascriptExecutor) SeDriver.getInstance().driver; 

            String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";

            js.executeScript(scriptSetAttrValue, elem, "value", value);

        }


        /** \~german
         *  \brief
         *  Ermittelt den textuellen Inhalt eines Textfeldes.<br/>.
         *  GUI-Automatisierungswerkzeug: Selenium.<br/>
         *  
         *  \return
         *  Gibt den Textuellen Inhaltes eines DOM-TextField-s zurück.
         *  Es korrespondieren je eine Zeile des GUI-Objektes mit jeweil einem Listen-Element.<br/>
         *  Ein Textfield besteht aus einerZeile: Daher wird der Wert des Textfield-s im ListenElement[0] abgelegt.
         *  Zurückgegeben.
         *  \return
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014.06.2014
         * @throws Exception 
         */
        @Override
        public ArrayList<String> getValue() throws Exception
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("GetValue");

                // Get Value from TextField and put this into the return List<string>
                String myValue = this.Me().getAttribute("value");
                
                if(!myValue.isEmpty())
                {
                  lvLsReturn.add(this.Me().getAttribute("value"));
                }
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn.toString());
            }

            return lvLsReturn;
        }
        
        
  // / \~german
  public void SetValue( ArrayList<String> Values ) throws Exception
  {
    this.LogFunctionStartDebug( "SetValue", "Val", Values.toString() );

    try
    {

      WebElement myMe = this.Me();
      myMe.clear();
      
      for (String Value : Values) {
        if (Value.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ))
        {
          myMe.clear();
        }
        else
        {
          myMe.sendKeys( Value );
        }
      }
    }
    finally
    {
      this.LogFunctionEndDebug();
    }

    return;
  }

}