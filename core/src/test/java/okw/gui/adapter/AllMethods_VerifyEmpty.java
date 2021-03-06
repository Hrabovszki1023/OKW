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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.*;
import okw.gui.AnyChildwindow;
import okw.gui.OKWLocatorBase;
import okw.log.Logger_Sngltn;


public class AllMethods_VerifyEmpty extends AnyChildwindow
{

	protected String Locator;

	protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	//protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
	protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();


	String myValue = "";


	public AllMethods_VerifyEmpty( String fpsLocator, OKWLocatorBase... fpLocators )
	{
		super( fpsLocator, fpLocators );
	}


	public String getCAT()
	{
		return "Rechner.All_MethodsObj";
	}

	public ArrayList<String> VerifyBadge()
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyBadge()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}


	public boolean VerifyExists(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
	{


		myClipboard.Clear();
		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyExists()");
		myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));



		return fpbExpectedValue;
	}


	public Boolean VerifyHasFocus(Boolean fpbExpectedValue)
	{


		myClipboard.Clear();

		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyHasFocus()");

		myClipboard.getValue().add(fpbExpectedValue.toString());



		return fpbExpectedValue;
	}

	public boolean VerifyIsActive(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
	{


		myClipboard.Clear();   
		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyIsActive()");
		myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));



		return fpbExpectedValue;
	}

	public ArrayList<String> VerifySelectedValue() //ArrayList<String> fpLsExpectedValue)
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();

		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifySelectedValue()");
		//myClipboard.getValue().addAll(fpLsExpectedValue);



		return lvLsReturn;
	}

	public List<String> VerifyTablecellValue(String Col, String Row, ArrayList<String> fpLsExpectedValue)
	{



		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyTablecellValue()");

		myClipboard.getValue().add(Col);
		myClipboard.getValue().add(Row);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyTooltip()
	{



		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyTooltip()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}


	public ArrayList<String> VerifyCaption()
	{



		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );


		myClipboard.Clear();
		String lvs_ObjectName = getCAT();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyCaption()");
		myClipboard.getValue().clear();



		return lvLsReturn;
	}

	public ArrayList<String> VerifyLabel()
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyLabel()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}

	public ArrayList<String> VerifyPlaceholder()
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyPlaceholder()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}

	public ArrayList<String> VerifyValue()
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyValue()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}

	public ArrayList<String> VerifyErrorMSG()
	{


		// ${EMPTY} => ArrayList mit einem Wert und ""
		ArrayList<String> lvLsReturn = new ArrayList<String>();
		lvLsReturn.add( "" );

		myClipboard.Clear();
		String lvs_ObjectName = getCAT();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyErrorMSG()");

		myClipboard.getValue().clear();



		return lvLsReturn;
	}
}