package okw.gui.frames;
import java.util.ArrayList;
import java.util.List;

import okw.*;
import okw.log.*;
import okw.gui.adapter.*;

@OKW_FN(FN="CurrentObjectWindow")
public class frmCurrentObjectWindow extends Test_Window
{


	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	/// \brief
	/// Die Klasse frm_CurrentObjectWindow ist eine Test-Frame-Klasse. Diese Klasse dient als Unittest-Objekt.<br/>
	/// Dieser Klasse dient(e) als als Prototyp um zu zeigen/testen<br/>
	/// * wie Basis Klassen als GUI-Frame-Objekte verwendet werden
	/// * wie virtuelle Methoden der Basisklassen angepasst, sprich überschrieben, werden können.
	///
	/// Diese Klasse
	/// * wird für die Prüfung der GUI-Mthoden-Aufrufe verwendet.
	/// * ist virtuell und hat keine aktivität auf der Oberfläche.
	/// 
	/// 1. DE.WähleFenster("Rechner")
	/// 2. DE.GibEin("Taste_3")
	/// 3. DE.PrüfeWert("Anzeige", "3")
	/// 
	/// \author Zoltan Hrabovszki
	/// \date 2012.12.26
	/// \warning **Diese Frame-Klasse nicht ohne Grund verändern!**
	/// Sie ist basis für etliche OKW-Unittests. **ZH**
	/// \copyright CC-OPENKEYWORD


	    /// \brief
	    /// Instanz der Klasse __CurrentObjectAllMethodCallTypes erstellen...
	    /// 
	    /// \author Zoltan Hrabovszki
	    /// \date 2014.01.14
	    @OKW_FN(FN="CurrentObjectAllMethodCallTypes")
	    public AllMethods CurrentObjectAllMethodCallTypes = new AllMethods("Locator_CurrentObjectAllMethodCallTypes");


	    /// \brief
	    /// Konstruktor der Klasse frm_CurrentObjectWindow
	    /// Diese Klasse ist eine Testklasse und in OKW Unitets verwendet.
	    /// Dies Klasse führt keine GUI-Aktivitäten durch,
	    /// Das setzten des Wertes "Neuer Locator CurrentObjectWindow" nur für den Unittest relevant.<br/>
	    /// 
	    /// \author Zoltan Hrabovszki
	    /// \date 2014.01.30
	    public frmCurrentObjectWindow()
	    {
	    	super("Neuer Locator CurrentObjectWindow")
	        myLogger.LogPrintDebug("frm_Rechner.Constructor()");
	    }


	}
	    // Kindobjekt >>mit<< Anpassung
	    public class AllMethods
	    {

	    	Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	    	OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();
	    	OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
	    	
	        String Locator = "Locator not set";

	        public __CurrentObjectAllMethodCallTypes(String fps_Locator)
	        {
	        	myLogger.LogFunctionStartDebug(this.getClass().getSimpleName() + ".__CurrentObjectAllMethodCallTypes()", "fps_Locator", fps_Locator);
	        	myLogger.LogPrintDebug(this.Locator);
	            this.Locator = fps_Locator;
	            myLogger.LogFunctionEndDebug();
	        }


	        public Boolean CallMethodReturn_rB_pMN()
	        {
	        	myLogger.LogFunctionStart("CallMethodReturn_rB_pMN");
	        	myLogger.LogPrintDebug("Locator: " + this.Locator);

	            Boolean bReturn = true;

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rB_pMN");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add("NO VALUE");

	            myLogger.LogFunctionEnd();
	            return bReturn;
	        }

	        public Boolean CallMethodReturn_rB_pMN_pB(Boolean pB)
	        {
	        	myLogger.LogFunctionStart("CallMethodReturn_rB_pMN_pB", "String pB", pB.toString());
	        	myLogger.LogPrintDebug("Locator: " + this.Locator);

	            Boolean bReturn = pB;

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rB_pMN_pB");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add(OKW_Helper.Boolean2String(bReturn));

	            myLogger.LogFunctionEnd();
	            return bReturn;
	        }

	        public int CallMethodReturn_rI_pMN()
	        {

	            myLogger.LogFunctionStart("CallMethodReturn_rI_pMN");
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            int liReturn = 23101963;

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rI_pMN");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add("NO VALUE");

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

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rLS_pMN");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add("NO VALUE");

	            myLogger.LogFunctionEnd();
	            return LSReturn;
	        }

	        public List<String> CallMethodReturn_rLS_pMN_pLS(List<String> pLS)
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            List<String> LSReturn = pLS;

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rLS_pMN_pLS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(pLS.get(0));
	            myClipBoard.getValue().add(pLS.get(1));
	            myClipBoard.getValue().add(pLS.get(2));

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

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rLS_pMN_pS_pS");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add(Param1);
	            myClipBoard.getValue().add(Param2);

	            myLogger.LogFunctionEnd();
	            return LSReturn;
	        }

	        public List<String> CallMethodReturn_rLS_pMN_pS_pS_pLS(String Parameter1, String Parameter2, List<String> pLS)
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pS_pS_pLS", "List<String> pLS", pLS.toString());
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            List<String> LSReturn = new ArrayList<String>();
	            LSReturn.add(Parameter1);
	            LSReturn.add(Parameter2);
	            LSReturn.add(pLS.get(0));
	            LSReturn.add(pLS.get(1));
	            LSReturn.add(pLS.get(2));

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rLS_pMN_pS_pS_pLS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(Parameter1);
	            myClipBoard.getValue().add(Parameter2);
	            myClipBoard.getValue().add(pLS.get(0));
	            myClipBoard.getValue().add(pLS.get(1));
	            myClipBoard.getValue().add(pLS.get(2));

	            myLogger.LogFunctionEnd();
	            return LSReturn;
	        }

	        public String CallMethodReturn_rS_pMN()
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rS_pMN");
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            String lsReturn = "Wert 1";

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rS_pMN");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add("Wert 1");

	            myLogger.LogFunctionEnd();
	            return lsReturn;
	        }

	        public String CallMethodReturn_rS_pMN_pS(String pS)
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rS_pMN_pS");
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            String lsReturn = pS;

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethodReturn_rS_pMN_pS");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add(pS);

	            myLogger.LogFunctionEnd();
	            return lsReturn;
	        }

	        public void CallMethod_pMN()
	        {
	            
	            myLogger.LogFunctionStart("CallMethod_pMN");
	            myLogger.LogPrintDebug("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_MN");
	            myClipBoard.getValue().clear();
	            myClipBoard.getValue().add("NO VALUE");

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pLS(List<String> pLS)
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pLS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(pLS.get(0));
	            myClipBoard.getValue().add(pLS.get(1));
	            myClipBoard.getValue().add(pLS.get(2));

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pLS_pS(List<String> pLS, String sOption)
	        {
	            
	            myLogger.LogFunctionStart("CallMethodReturn_rLS_pMN_pLS", "List<String> pLS", pLS.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pLS_pS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(pLS.get(0));
	            myClipBoard.getValue().add(pLS.get(1));
	            myClipBoard.getValue().add(pLS.get(2));

	            myClipBoard.getValue().add(sOption);

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pS(String psParameter_1)
	        {
	            
	            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(psParameter_1);

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pS_pS(String psParameter_1, String psParameter_2)
	        {
	            
	            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1.toString(), "String psParameter_2", psParameter_2.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pS_pS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(psParameter_1);
	            myClipBoard.getValue().add(psParameter_2);

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pS_pS_pS(String psParameter_1, String psParameter_2, String psParameter_3)
	        {
	            
	            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS", "String psParameter_1", psParameter_1.toString(), "String psParameter_2", psParameter_2.toString(), "String psParameter_3", psParameter_3.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pS_pS_pS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(psParameter_1);
	            myClipBoard.getValue().add(psParameter_2);
	            myClipBoard.getValue().add(psParameter_3);

	            myLogger.LogFunctionEnd();
	            return;
	        }

	        public void CallMethod_pMN_pS_pS_pLS(String psParameter_1, String psParameter_2, List<String> fpLSValue)
	        {
	            
	            myLogger.LogFunctionStart("CallMethod_pMN_pS_pS_pLS", "String psParameter_1", psParameter_1.toString(), "String psParameter_2", psParameter_2.toString());
	            myLogger.LogPrint("Locator: " + this.Locator);

	            myClipBoard.setObjectName(myCurrentObject.GetObjectName());
	            myClipBoard.setMethod("CallMethod_pMN_pS_pS_pLS");
	            myClipBoard.getValue().clear();

	            myClipBoard.getValue().add(psParameter_1);
	            myClipBoard.getValue().add(psParameter_2);

	            myClipBoard.getValue().add(fpLSValue.get(0));
	            myClipBoard.getValue().add(fpLSValue.get(1));
	            myClipBoard.getValue().add(fpLSValue.get(2));

	            myLogger.LogFunctionEnd();
	            return;
	        }
	}