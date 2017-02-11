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


import java.util.ArrayList;
import java.util.List;

import okw.OKW_TestClipboard;
import okw.gui.AnyChildwindow;
import okw.log.*;

    // : IOKW_SimpleDataObj
    public class Test_TextField extends AnyChildwindow
    {

        String Locator;
        
        Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

        String myValue = "";

        public Test_TextField(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        public String getFN()
        {
            // return Test_PushButton.class.getAnnotation(OKW_FN.class).FN();
            return "Test_Textfield";
        }

        public void ClickOn()
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("ClickOn");
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("ClickOn()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void ClickOn_DOUBLECLICK()
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("ClickOn_DOUBLECLICK");
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("ClickOn_DOUBLECLICK()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public List<String> GetValue()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".GetValue");
            lvLsReturn.add(this.myValue);

            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("OKW_GetValue()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(this.myValue);

            myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> GetValue_TOOLTIP()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".GetValue_TOOLTIP");
            lvLsReturn.add(this.myValue);

            String lvs_ObjectName = getFN();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("OKW_GetValue_TOOLTIP()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add("TOOLTIP: " + this.myValue);

            myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public void Set_Focus()
        {
            this.myValue = "";
            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".Set_Focus");
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("Set_Focus()");
            myClipBoard.getValue().clear();
            myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void TypeKey(List<String> fpLs_Value)
        {
            this.myValue = fpLs_Value.get(0);
            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".TypeKey");
            
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("OKW_TypeKey(List<String> fpLs_Value)");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add(fpLs_Value.get(0));
            
            myLogger.LogFunctionEndDebug();

            return;
        }


        /**
         *  \brief
         *  Testmethode liefert als Ergebnis fplsExpectedValue, also den erwarteten Wert, zurück.
         *           *  
         *  \return
         *  Rückgabe fplsExpectedValue.
         *  
         *  \author Zoltan Hrabovszki
         *  \date 2016.06.14
         */
        public ArrayList<String> VerifyValue(ArrayList<String> fplsExpectedValue) throws InterruptedException
        {

          this.myValue = fplsExpectedValue.get(0);
          myLogger.LogFunctionStartDebug(this.getClass().getName() + ".VerifyValue");
          
          String lvs_ObjectName = getFN();

          myClipBoard.setObjectName(lvs_ObjectName);
          myClipBoard.setMethod("VerifyValue(ArrayList<String> fplsExpectedValue)");
          myClipBoard.getValue().clear();
          myClipBoard.getValue().add(fplsExpectedValue.get(0));
          
          myLogger.LogFunctionEndDebug();

          return fplsExpectedValue;
        }

    }