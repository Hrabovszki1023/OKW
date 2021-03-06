/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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


	public String getCAT()
	{        	
		String lvsReturn = "CurrentObjectWindow.CurrentObjectAllMethodCallTypes";

		return lvsReturn;
	}

	/*
        public __CurrentObjectAllMethodCallTypes(String fps_Locator)
        {

        	myLogger.LogPrintDebug(this.Locator);
            Locator = fps_Locator;

        }
	 */

	public Boolean CallMethodReturn_rB_pMN()
	{

		myLogger.LogPrintDebug("Locator: " + this.Locator);

		Boolean bReturn = true;

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rB_pMN");
		myClipboard.getValue().clear();
		myClipboard.getValue().add("NO VALUE");


		return bReturn;
	}


	public Boolean CallMethodReturn_rB_pMN_pB(Boolean pB)
	{

		myLogger.LogPrintDebug("Locator: " + this.Locator);

		Boolean bReturn = pB;

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rB_pMN_pB");
		myClipboard.getValue().clear();
		myClipboard.getValue().add(OKW_Helper.Boolean2String(bReturn));


		return bReturn;
	}


	public int CallMethodReturn_rI_pMN()
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		int liReturn = 23101963;

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rI_pMN");
		myClipboard.getValue().clear();
		myClipboard.getValue().add("NO VALUE");


		return liReturn;
	}

	public List<String> CallMethodReturn_rLS_pMN()
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		List<String> LSReturn = new ArrayList<String>();
		LSReturn.add("Wert 1");
		LSReturn.add("Wert 2");
		LSReturn.add("Wert 3");

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rLS_pMN");
		myClipboard.getValue().clear();
		myClipboard.getValue().add("NO VALUE");


		return LSReturn;
	}


	public List<String> CallMethodReturn_rLS_pMN_pLS(ArrayList<String> pLS)
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		List<String> LSReturn = pLS;

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rLS_pMN_pLS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(pLS.get(0));
		myClipboard.getValue().add(pLS.get(1));
		myClipboard.getValue().add(pLS.get(2));


		return LSReturn;
	}

	public List<String> CallMethodReturn_rLS_pMN_pS_pS(String Param1, String Param2)
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		List<String> LSReturn = new ArrayList<String>();
		LSReturn.add(Param1);
		LSReturn.add(Param2);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rLS_pMN_pS_pS");
		myClipboard.getValue().clear();
		myClipboard.getValue().add(Param1);
		myClipboard.getValue().add(Param2);


		return LSReturn;
	}

	public List<String> CallMethodReturn_rLS_pMN_pS_pS_pLS(String Parameter1, String Parameter2, ArrayList<String> pLS)
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		List<String> LSReturn = new ArrayList<String>();
		LSReturn.add(Parameter1);
		LSReturn.add(Parameter2);
		LSReturn.add(pLS.get(0));
		LSReturn.add(pLS.get(1));
		LSReturn.add(pLS.get(2));

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rLS_pMN_pS_pS_pLS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(Parameter1);
		myClipboard.getValue().add(Parameter2);
		myClipboard.getValue().add(pLS.get(0));
		myClipboard.getValue().add(pLS.get(1));
		myClipboard.getValue().add(pLS.get(2));


		return LSReturn;
	}


	public String CallMethodReturn_rS_pMN()
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		String lsReturn = "Wert 1";

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rS_pMN");
		myClipboard.getValue().clear();
		myClipboard.getValue().add("Wert 1");


		return lsReturn;
	}


	public String CallMethodReturn_rS_pMN_pS(String pS)
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		String lsReturn = pS;

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethodReturn_rS_pMN_pS");
		myClipboard.getValue().clear();
		myClipboard.getValue().add(pS);


		return lsReturn;
	}


	public void CallMethod_pMN()
	{


		myLogger.LogPrintDebug("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_MN");
		myClipboard.getValue().clear();
		myClipboard.getValue().add("NO VALUE");


	}


	public void CallMethod_pMN_pLS(ArrayList<String> pLS)
	{


		myLogger.LogPrint("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pLS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(pLS.get(0));
		myClipboard.getValue().add(pLS.get(1));
		myClipboard.getValue().add(pLS.get(2));


	}


	public void CallMethod_pMN_pLS_pS(ArrayList<String> pLS, String sOption)
	{


		myLogger.LogPrint("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pLS_pS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(pLS.get(0));
		myClipboard.getValue().add(pLS.get(1));
		myClipboard.getValue().add(pLS.get(2));

		myClipboard.getValue().add(sOption);


	}


	public void CallMethod_pMN_pS(String psParameter_1)
	{


		myLogger.LogPrint("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(psParameter_1);


	}

	public void CallMethod_pMN_pS_pS(String psParameter_1, String psParameter_2)
	{


		myLogger.LogPrint("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pS_pS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(psParameter_1);
		myClipboard.getValue().add(psParameter_2);


	}


	public void CallMethod_pMN_pS_pS_pS(String psParameter_1, String psParameter_2, String psParameter_3)
	{


		myLogger.LogPrint("Locator: " + this.Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pS_pS_pS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(psParameter_1);
		myClipboard.getValue().add(psParameter_2);
		myClipboard.getValue().add(psParameter_3);


	}


	public void CallMethod_pMN_pS_pS_pLS(String psParameter_1, String psParameter_2, ArrayList<String> fpLSValue)
	{


		myLogger.LogPrint("Locator: " + Locator);

		myClipboard.setObjectName(getCAT());
		myClipboard.setMethod("CallMethod_pMN_pS_pS_pLS");
		myClipboard.getValue().clear();

		myClipboard.getValue().add(psParameter_1);
		myClipboard.getValue().add(psParameter_2);

		myClipboard.getValue().add(fpLSValue.get(0));
		myClipboard.getValue().add(fpLSValue.get(1));
		myClipboard.getValue().add(fpLSValue.get(2));


	}

}