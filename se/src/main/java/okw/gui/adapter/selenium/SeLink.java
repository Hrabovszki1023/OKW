package okw.gui.adapter.selenium;

import java.io.IOException;

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

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.OKWLocator;

    /// \brief
    /// TODO: Describe SeLink!
    /// 
    public class SeLink extends SeAnyChildWindow
    {

      /**
       *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
       */
        public SeLink(String Locator, OKWLocator... Locators)
        {
        	super(Locator, Locators);
        }

        
        /**
         *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,String,OKWLocator)
         *  
         *  @date 2017.02.17
         */
         public SeLink(String IframeID, String Locator, OKWLocator... Locators)
         {
           super(IframeID, Locator, Locators);
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
            throw new UnsupportedOperationException("Link cannot be Active");
        }
        
        @Override
        public Boolean LogIsActive()
        {
            throw new UnsupportedOperationException("Link cannot be Active");
        }

        @Override
        public Boolean MemorizeIsActive()
        {
            throw new UnsupportedOperationException("Link cannot be Active");
        }

        @Override
        public Boolean VerifyIsActive()
        {
            throw new UnsupportedOperationException("Link cannot be Active");
        }

        /** \brief
         *  OpenKeyWord implemntiert den href-Attribute als "Value" eines HTML-Linkes.
         * 
         *  \return
         */
        @Override
        public ArrayList<String> getValue() throws Exception
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("getValue");

                // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
                this.WaitForMe();
                
                // The Attribute "value" wird als Beschriftung angezeigt...
                lvLsReturn.add(this.Me().getAttribute("href"));
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }
            
            return lvLsReturn;
        }
}