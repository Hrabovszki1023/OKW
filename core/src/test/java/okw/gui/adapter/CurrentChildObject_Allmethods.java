package okw.gui.adapter;

import java.util.ArrayList;
import java.util.List;

import okw.*;
import okw.gui.AnyChildwindow;
import okw.gui.OKWLocator;
import okw.log.Logger_Sngltn;


    public class CurrentChildObject_Allmethods extends AnyChildwindow // : IOKW_SimpleDataObj
    {

        protected String Locator;
        
        protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        //protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();
        
        
        String myValue = "";


        public CurrentChildObject_Allmethods( String fpsLocator, OKWLocator... fpLocators )
        {
            super( fpsLocator, fpLocators );
        }

        
        public String getFN()
        {        	
        	String lvsReturn = "CurrentObjectWindow.CurrentObjectAllMethodCallTypes";
        	
        	return lvsReturn;
        }

        /*
        public __CurrentObjectAllMethodCallTypes(String fps_Locator)
        {
        	myLogger.LogFunctionStartDebug(this.getClass().getSimpleName() + ".__CurrentObjectAllMethodCallTypes()", "fps_Locator", fps_Locator);
        	myLogger.LogPrintDebug(this.Locator);
            Locator = fps_Locator;
            myLogger.LogFunctionEndDebug();
        }
*/

		public Boolean CallMethodReturn_rB_pMN()
        {
        	myLogger.LogFunctionStart("CallMethodReturn_rB_pMN");
        	myLogger.LogPrintDebug("Locator: " + this.Locator);

            Boolean bReturn = true;

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rB_pMN");
            myClipboard.getValue().clear();
            myClipboard.getValue().add("NO VALUE");

            myLogger.LogFunctionEnd();
            return bReturn;
        }


		public Boolean CallMethodReturn_rB_pMN_pB(Boolean pB)
        {
        	myLogger.LogFunctionStart("CallMethodReturn_rB_pMN_pB", "String pB", pB.toString());
        	myLogger.LogPrintDebug("Locator: " + this.Locator);

            Boolean bReturn = pB;

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rB_pMN_pB");
            myClipboard.getValue().clear();
            myClipboard.getValue().add(OKW_Helper.Boolean2String(bReturn));

            myLogger.LogFunctionEnd();
            return bReturn;
        }


		public int CallMethodReturn_rI_pMN()
        {

            myLogger.LogFunctionStart("CallMethodReturn_rI_pMN");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            int liReturn = 23101963;

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rI_pMN");
            myClipboard.getValue().clear();
            myClipboard.getValue().add("NO VALUE");

            myLogger.LogFunctionEnd();
            return liReturn;
        }

		public List<String> CallMethodReturn_rLS_pMN()
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            List<String> LSReturn = new ArrayList<String>();
            LSReturn.add("Wert 1");
            LSReturn.add("Wert 2");
            LSReturn.add("Wert 3");

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rLS_pMN");
            myClipboard.getValue().clear();
            myClipboard.getValue().add("NO VALUE");

            myLogger.LogFunctionEnd();
            return LSReturn;
        }


		public List<String> CallMethodReturn_rLS_pMN_pLS(ArrayList<String> pLS)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            List<String> LSReturn = pLS;

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rLS_pMN_pLS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(pLS.get(0));
            myClipboard.getValue().add(pLS.get(1));
            myClipboard.getValue().add(pLS.get(2));

            myLogger.LogFunctionEnd();
            return LSReturn;
        }

		public List<String> CallMethodReturn_rLS_pMN_pS_pS(String Param1, String Param2)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pS_pS");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            List<String> LSReturn = new ArrayList<String>();
            LSReturn.add(Param1);
            LSReturn.add(Param2);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rLS_pMN_pS_pS");
            myClipboard.getValue().clear();
            myClipboard.getValue().add(Param1);
            myClipboard.getValue().add(Param2);

            myLogger.LogFunctionEnd();
            return LSReturn;
        }

		public List<String> CallMethodReturn_rLS_pMN_pS_pS_pLS(String Parameter1, String Parameter2, ArrayList<String> pLS)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pS_pS_pLS", "List<String> pLS", pLS.toString());
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            List<String> LSReturn = new ArrayList<String>();
            LSReturn.add(Parameter1);
            LSReturn.add(Parameter2);
            LSReturn.add(pLS.get(0));
            LSReturn.add(pLS.get(1));
            LSReturn.add(pLS.get(2));

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rLS_pMN_pS_pS_pLS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(Parameter1);
            myClipboard.getValue().add(Parameter2);
            myClipboard.getValue().add(pLS.get(0));
            myClipboard.getValue().add(pLS.get(1));
            myClipboard.getValue().add(pLS.get(2));

            myLogger.LogFunctionEnd();
            return LSReturn;
        }


		public String CallMethodReturn_rS_pMN()
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rS_pMN");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            String lsReturn = "Wert 1";

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rS_pMN");
            myClipboard.getValue().clear();
            myClipboard.getValue().add("Wert 1");

            myLogger.LogFunctionEnd();
            return lsReturn;
        }


		public String CallMethodReturn_rS_pMN_pS(String pS)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rS_pMN_pS");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            String lsReturn = pS;

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethodReturn_rS_pMN_pS");
            myClipboard.getValue().clear();
            myClipboard.getValue().add(pS);

            myLogger.LogFunctionEnd();
            return lsReturn;
        }

 
        public void CallMethod_pMN()
        {
            
            myLogger.LogFunctionStart("CallMethod_pMN");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_MN");
            myClipboard.getValue().clear();
            myClipboard.getValue().add("NO VALUE");

            myLogger.LogFunctionEnd();
        }


		public void CallMethod_pMN_pLS(ArrayList<String> pLS)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
            myLogger.LogPrint("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pLS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(pLS.get(0));
            myClipboard.getValue().add(pLS.get(1));
            myClipboard.getValue().add(pLS.get(2));

            myLogger.LogFunctionEnd();
        }


		public void CallMethod_pMN_pLS_pS(ArrayList<String> pLS, String sOption)
        {
            
            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
            myLogger.LogPrint("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pLS_pS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(pLS.get(0));
            myClipboard.getValue().add(pLS.get(1));
            myClipboard.getValue().add(pLS.get(2));

            myClipboard.getValue().add(sOption);

            myLogger.LogFunctionEnd();
        }


		public void CallMethod_pMN_pS(String psParameter_1)
        {
            
            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1 );
            myLogger.LogPrint("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(psParameter_1);

            myLogger.LogFunctionEnd();
        }

        public void CallMethod_pMN_pS_pS(String psParameter_1, String psParameter_2)
        {
            
            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1, "String psParameter_2", psParameter_2);
            myLogger.LogPrint("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pS_pS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(psParameter_1);
            myClipboard.getValue().add(psParameter_2);

            myLogger.LogFunctionEnd();
        }


		public void CallMethod_pMN_pS_pS_pS(String psParameter_1, String psParameter_2, String psParameter_3)
        {
            
            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1, "String psParameter_2", psParameter_2, "String psParameter_3", psParameter_3);
            myLogger.LogPrint("Locator: " + this.Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pS_pS_pS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(psParameter_1);
            myClipboard.getValue().add(psParameter_2);
            myClipboard.getValue().add(psParameter_3);

            myLogger.LogFunctionEnd();
        }


		public void CallMethod_pMN_pS_pS_pLS(String psParameter_1, String psParameter_2, ArrayList<String> fpLSValue)
        {
            
            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS_pLS", "String psParameter_1", psParameter_1, "String psParameter_2", psParameter_2);
            myLogger.LogPrint("Locator: " + Locator);

            myClipboard.setObjectName(getFN());
            myClipboard.setMethod("CallMethod_pMN_pS_pS_pLS");
            myClipboard.getValue().clear();

            myClipboard.getValue().add(psParameter_1);
            myClipboard.getValue().add(psParameter_2);

            myClipboard.getValue().add(fpLSValue.get(0));
            myClipboard.getValue().add(fpLSValue.get(1));
            myClipboard.getValue().add(fpLSValue.get(2));

            myLogger.LogFunctionEnd();
        }

    }