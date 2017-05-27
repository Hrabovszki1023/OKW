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
package okw.gui.adapter;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.OKW_TestClipboard;
import okw.gui.AnyChildwindow;
import okw.log.*;

    // TODO Implemetierung einschalten : IOKW_LinkObj
    public class Test_PushButton extends AnyChildwindow
    {
        /// \brief
        /// Hier eventuell virtuelle Eigenschaft einfügen
        /// 
        String Locator;
        
        Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        //OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

        String myValue = "";
        
        public String getFN()
        {
            String lvsReturn = "";
            
            try
			{
				lvsReturn = okw.core.OKW_CurrentObject_Sngltn.getInstance().getObjectFN();
			}
			catch (
					XPathExpressionException | JAXBException
					| ParserConfigurationException | SAXException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return lvsReturn;
        }
        
        /// \~german
        /// \brief GUI-TestObjekt für ein Pushbotton
        /// 
        /// Objekt enthält keine Aktionen ist ein Mock für einen Pushbutten dar.
        /// 
        /// \param fpsLocator Locator des Objektes. Hier wird 
        ///
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        /// 
        /// \param fpsLocator  \todo TODO: Parameter Description
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.01
        public Test_PushButton(String fpsLocator)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey", "fpsLocator", fpsLocator);
            this.Locator = fpsLocator;

            this.myLogger.LogFunctionEndDebug();
        }

        /// \~german
        /// \brief Simuliert die Methode ClickOn()
        /// 
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.01
        public void ClickOn()
        {
            this.myValue = "NO VALUE";
            
            //String lvs_ObjectName = myCurrentObject.GetObjectName();
            String lvs_ObjectName = getFN();
            
            this.myLogger.LogFunctionStartDebug("ClickOn");


            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("ClickOn()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(this.myValue);
            
            this.myLogger.LogFunctionEndDebug();
        }

        /// \~german
        /// \brief Simuliert ClickOn_DOUBLECLICK()
        /// 
        /// \~english
        /// \brief \todo TODO: Brief Description.
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.01
        public void ClickOn_DOUBLECLICK()
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("ClickOn_DOUBLECLICK");
            
            String lvs_ObjectName = getFN();;

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("ClickOn_DOUBLECLICK()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(this.myValue);
            
            this.myLogger.LogFunctionEndDebug();
        }

        /// \~german
        /// \brief Simuliert die Tastatur Eingabe.
        /// 
        /// \param fpLsValue Werte die als Tastatureingabe 
        /// \return
        ///
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        /// 
        /// \param fpbTrueOrFalse 
        /// \return
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.01
        public void TypeKey(List<String> fpLsValue)
        {
            this.myValue = fpLsValue.get(0);
            myLogger.LogFunctionStartDebug("TypeKey");
            
            String lvs_ObjectName = getFN();;

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("TypeKey()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(fpLsValue.get(0));
            
            myLogger.LogFunctionEndDebug();
        }

}