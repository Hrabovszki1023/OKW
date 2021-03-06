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

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.*;
import okw.gui.AnyChildwindow;
import okw.gui.OKWLocator;
import okw.log.Logger_Sngltn;


public class AllMethods_MultipleValues extends AnyChildwindow
{

	protected String Locator;

	protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	//protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
	protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();


	private String myValue = "";


	public AllMethods_MultipleValues( String fpsLocator, OKWLocator... fpLocators )
	{
		super( fpsLocator, fpLocators );
	}



	public void ClickOn()
	{
		this.myValue = "NO VALUE";


		myClipboard.Clear();
		String lvs_CAT = this.getKN();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("ClickOn()");
		myClipboard.getValue().add(this.myValue);

	}

	public void ClickOn_Clicktype(String fpsClickType)
	{


		myClipboard.Clear();
		String lvs_CAT = this.getKN();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("ClickOn_Clicktype()");

		myClipboard.getValue().add( fpsClickType );


	}

	public boolean LogExists()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogExists()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public boolean LogHasFocus()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogHasFocus()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public boolean LogIsActive()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogIsActive()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public ArrayList<String> LogSelected()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Wert_1");
		lvLsReturn.add("Wert_2");
		lvLsReturn.add("Wert_3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogSelected()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> LogTablecellValue(String Coll, String Row)
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add(Coll);
		lvLsReturn.add(Row);

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogTablecellValue()");
		myClipboard.getValue().add(Coll);
		myClipboard.getValue().add(Row);



		return lvLsReturn;
	}

	public ArrayList<String> LogTooltip()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Tooltip Rückgabewert 1");
		lvLsReturn.add("Tooltip Rückgabewert 2");
		lvLsReturn.add("Tooltip Rückgabewert 3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogTooltip()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> LogCaption()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Caption Rückgabewert 1");
		lvLsReturn.add("Caption Rückgabewert 2");
		lvLsReturn.add("Caption Rückgabewert 3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogCaption()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> LogLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Label Rückgabewert 1");
		lvLsReturn.add("Label Rückgabewert 2");
		lvLsReturn.add("Label Rückgabewert 3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogLabel()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}


	public ArrayList<String> LogPlaceholder()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Placeholder Rückgabewert 1");
		lvLsReturn.add("Placeholder Rückgabewert 2");
		lvLsReturn.add("Placeholder Rückgabewert 3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogPlaceholder()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}


	public ArrayList<String> LogValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Return Value 1");
		lvLsReturn.add("Return Value 2");
		lvLsReturn.add("Return Value 3");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("LogValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public boolean MemorizeExists()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeExists()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public boolean MemorizeHasFocus()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeHasFocus()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public boolean MemorizeIsActive()
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeIsActive()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public ArrayList<String> MemorizeSelectedValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeSelectedValue_Return_1");
		lvLsReturn.add("MemorizeSelectedValue_Return_2");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeSelectedValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeTablecellValue(String Col, String Row)
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeTablecellValue_1");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeTablecellValue()");
		myClipboard.getValue().add(Col);
		myClipboard.getValue().add(Row);



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeTooltip()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeTooltip_Return_1");
		lvLsReturn.add("MemorizeTooltip_Return_2");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeTooltip()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeCaption()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeCaption_Return_1");
		lvLsReturn.add("MemorizeCaption_Return_2");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeCaption()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeLabel_Return_1");
		lvLsReturn.add("MemorizeLabel_Return_2");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeLabel()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizePlaceholder()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizePlaceholder_Return_1");
		lvLsReturn.add("MemorizePlaceholder_Return_2");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizePlaceholder()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeValue_Return_1");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("MemorizeValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public void Select(ArrayList<String> fpLs_Value)
	{


		try
		{
			myClipboard.Clear();             
			String lvs_CAT = getCAT();

			myClipboard.setObjectName(lvs_CAT);
			myClipboard.setMethod("Select()");

			// Eingabewerte auf den TestClipboard packen...

			for (String lsValue : fpLs_Value)
			{
				myClipboard.getValue().add(lsValue);
			}
		}
		finally
		{

		}
	}

	public void SelectMenu()
	{
		this.myValue = "NO VALUE";


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("SelectMenu()");
		myClipboard.getValue().add(this.myValue);


	}

	public void SelectMenu(ArrayList<String> fpLsValue)
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("SelectMenu(ArrayList<String>)");

		for (String lsValue : fpLsValue)
		{
			myClipboard.getValue().add(lsValue);
		}


	}

	public void SelectTablecell(String COL, String ROW)
	{
		this.myValue = "NO VALUE";


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("SelectTablecell()");
		myClipboard.getValue().add(COL);
		myClipboard.getValue().add(ROW);


	}

	public void SelectTablecell_Clicktype(String COL, String ROW, String fpsClickType)
	{

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("SelectTablecellClicktype()");

		myClipboard.getValue().add(COL);
		myClipboard.getValue().add(ROW);
		myClipboard.getValue().add(fpsClickType);

	}

	public void SelectWindow()
	{
	}

	public void Select_Clicktype(ArrayList<String> fpLs_Value, String fpsClicktype)
	{
		this.myValue = fpLs_Value.get(0);


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("Select_Clicktype()");
		myClipboard.getValue().add(fpLs_Value.get(0));
		myClipboard.getValue().add(fpsClicktype);

	}

	public void Select_TABLE(ArrayList<String> fpLs_Value)
	{
		this.myValue = fpLs_Value.get(0);

		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("OKW_Select_TABLE()");
		myClipboard.Clear();
		myClipboard.getValue().add(fpLs_Value.get(0));

	}

	public void SetFocus()
	{
		this.myValue = "NO VALUE";


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("SetFocus()");
		myClipboard.getValue().add(this.myValue);

	}

	public void SetValue(ArrayList<String> fpLs_Value)
	{


		try
		{
			myClipboard.Clear();
			String lvs_CAT = getCAT();

			myClipboard.setObjectName(lvs_CAT);
			myClipboard.setMethod("SetValue()");

			// Eingabe werte auf den TestClipboard packen
			for (String lsValue : fpLs_Value)
			{
				myClipboard.getValue().add(lsValue);
			}
		}
		finally
		{

		}
	}


	public void TypeKey(ArrayList<String> fpLs_Value)
	{


		try
		{
			myClipboard.Clear();

			String lvs_CAT = getCAT();

			myClipboard.setObjectName(lvs_CAT);
			myClipboard.setMethod("TypeKey(List<String> fpLs_Value)");

			// Eingabe werte auf den TestClipboard packen
			for (String lsValue : fpLs_Value)
			{
				myClipboard.getValue().add(lsValue);
			}
		}
		finally
		{

		}
	}

	public void TypeKeyTablecell(String COL, String ROW, ArrayList<String> fpLsValues)
	{


		try
		{
			myClipboard.Clear();

			String lvs_CAT = getCAT();

			myClipboard.setObjectName(lvs_CAT);
			myClipboard.setMethod("TypeKeyTablecell(String COL, String ROW, List<String> Values)");

			// Eingabe werte auf den TestClipboard packen

			myClipboard.getValue().add(COL);
			myClipboard.getValue().add(ROW);

			for (String lsValue : fpLsValues)
			{
				myClipboard.getValue().add(lsValue);
			}
		}
		finally
		{

		}
	}

	public boolean VerifyExists(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
	{


		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyExists()");
		myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));



		return fpbExpectedValue;
	}


	public Boolean VerifyHasFocus(Boolean fpbExpectedValue)
	{


		myClipboard.Clear();

		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyHasFocus()");

		myClipboard.getValue().add(fpbExpectedValue.toString());



		return fpbExpectedValue;
	}

	public boolean VerifyIsActive(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
	{


		myClipboard.Clear();   
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyIsActive()");
		myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));



		return fpbExpectedValue;
	}

	public ArrayList<String> VerifySelectedValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");


		myClipboard.Clear();

		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifySelectedValue()");
		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyTablecellValue(String Col, String Row)
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");

		myClipboard.Clear();
		String lvs_CAT = getCAT();

		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyTablecellValue()");

		myClipboard.getValue().add(Col);
		myClipboard.getValue().add(Row);
		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyTooltip()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyTooltip()");

		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyCaption()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyCaption()");

		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyLabel()");

		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyPlaceholder()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Placeholder");
		lvLsReturn.add("2. Placeholder");
		lvLsReturn.add("3. Placeholder");

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyPlaceholder()");

		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}

	public Integer VerifyMaxLength()
	{
		Integer lviReturn;


		lviReturn = 10;

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyPlaceholder()");

		myClipboard.getValue().add(lviReturn.toString());



		return lviReturn;
	}

	public ArrayList<String> VerifyValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("1. Value");
		lvLsReturn.add("2. Value");
		lvLsReturn.add("3. Value");

		myClipboard.Clear();
		String lvs_CAT = getKN();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyValue()");

		myClipboard.getValue().addAll(lvLsReturn);



		return lvLsReturn;
	}
	public Integer VerifyMinLength()
	{
		Integer lviReturn;


		lviReturn = 10;

		myClipboard.Clear();
		String lvs_CAT = getCAT();
		myClipboard.setObjectName(lvs_CAT);
		myClipboard.setMethod("VerifyPlaceholder()");

		myClipboard.getValue().add(lviReturn.toString());



		return lviReturn;
	}

}