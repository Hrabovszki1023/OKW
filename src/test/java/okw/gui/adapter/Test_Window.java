package okw.gui.adapter;

import java.util.List;

import okw.OKW_CurrentObject_Sngltn;
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
    	OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();

        public Test_Window()
        {
            this.Locator = "Locator Unset";
        }

        public Test_Window(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        public void SelectWindow()
        {
            this.myLogger.LogFunctionStartDebug("SelectWindow");
            
            String lvs_ObjectName = myCurrentObject.GetObjectName();
            
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
            String lvs_ObjectName = myCurrentObject.GetObjectName();

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
            String lvs_ObjectName = myCurrentObject.GetObjectName();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("StopApp()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void TypeKey(List<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {
                String lvs_ObjectName = myCurrentObject.GetObjectName();

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