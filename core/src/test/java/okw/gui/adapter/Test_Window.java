package okw.gui.adapter;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.OKW_TestClipboard;
import okw.log.Logger_Sngltn;

    public class Test_Window
    {

        /// \brief
        /// Hier eventuell virtuelle Eigenschaft einfügen
        /// 
        public String Locator;

    	Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
    	OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

        public Test_Window()
        {
            this.Locator = "Locator Unset";
        }

        public Test_Window(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        public String getFN()
        {
        	String lvsReturn = "";
        	
            try
			{
            	lvsReturn = okw.core.OKW_CurrentObject_Sngltn.getInstance().GetObjectFN() ;
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
        
        public void SelectWindow()
        {
            this.myLogger.LogFunctionStartDebug("SelectWindow");
            
            String lvs_ObjectName = getFN();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("SelectWindow()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            
            myLogger.LogFunctionEndDebug();
            return;
        }

        public void StartApp()
        {
            this.myLogger.LogFunctionStartDebug("StartApp");
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("StartApp()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void StopApp()
        {
            this.myLogger.LogFunctionStartDebug("StopApp");
            String lvs_ObjectName = getFN();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("StopApp()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void TypeKey(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {
                String lvs_ObjectName = getFN();

                myClipBoard.setObjectName(lvs_ObjectName);
                myClipBoard.setMethod("TypeKey(List<String> fpLs_Value)");

                // Eingabe werte auf den TestClipboard packen
                myClipBoard.getValue().clear();;
                
                for (String lsValue : fpLs_Value)
                {
                   myClipBoard.getValue().add(lsValue);
                }
            }
            finally
            {
                this.myLogger.LogFunctionEndDebug();
            }
            
            return;
        }
}