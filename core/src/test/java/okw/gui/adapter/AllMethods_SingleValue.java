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

import javax.xml.xpath.XPathExpressionException;

import okw.*;
import okw.gui.AnyChildwindow;
import okw.gui.OKWLocator;
import okw.log.Logger_Sngltn;


public class AllMethods_SingleValue extends AnyChildwindow
{

	protected String Locator;

	protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	//protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
	protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();


	private ArrayList<String> myALValue = new ArrayList<String>();


	public AllMethods_SingleValue( String fpsLocator, OKWLocator... fpLocators )
	{
		super( fpsLocator, fpLocators );
	}

	/**
        public String getCAT()
        {
            return "Rechner.All_MethodsObj";
        }
	 */

	public void ClickOn()
	{



		myClipboard.Clear();
		String lvs_ObjectName = this.getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("ClickOn()");
		myClipboard.getValue().addAll(this.myALValue);


	}


	public void DoubleClickOn()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("DoubleClickOn()");
		myClipboard.getValue().addAll(this.myALValue);


	}


	public boolean LogExists()
	{



		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName( lvs_ObjectName );
		myClipboard.setMethod( "LogExists()" );

		myClipboard.getValue().addAll( this.myALValue );

		Boolean lvbReturn = false;

		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean( this.myALValue.get( 0 ) );
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lvbReturn;
	}


	public boolean LogHasFocus()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("LogHasFocus()");
		myClipboard.getValue().addAll(this.myALValue);

		Boolean lvbReturn = false;  

		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean(this.myALValue.get( 0 ));
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lvbReturn;
	}

	public boolean LogIsActive()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("LogIsActive()");
		myClipboard.getValue().addAll(this.myALValue);

		Boolean lvbReturn = false;  

		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean(this.myALValue.get( 0 ));
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lvbReturn;
	}

	public ArrayList<String> LogSelected()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("Wert_1");
		lvLsReturn.add("Wert_2");
		lvLsReturn.add("Wert_3");

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("LogValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public boolean MemorizeExists()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("MemorizeExists()");
		myClipboard.getValue().add("NO VALUE");



		return true;
	}

	public boolean MemorizeHasFocus()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("MemorizeHasFocus()");
		myClipboard.getValue().addAll(this.myALValue);



		return true;
	}

	public boolean MemorizeIsActive()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("MemorizeSelectedValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeTablecellValue(String Col, String Row)
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeTablecellValue_1");

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
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
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("MemorizePlaceholder()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public ArrayList<String> MemorizeValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.add("MemorizeValue_Return_1");

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("MemorizeValue()");
		myClipboard.getValue().add("NO VALUE");



		return lvLsReturn;
	}

	public void Select(ArrayList<String> fpLs_Value)
	{


		try
		{
			// myALValue Löschen + setzen...
			this.myALValue.clear();
			this.myALValue.addAll( fpLs_Value );

			myClipboard.Clear();             
			String lvs_ObjectName = getKN();

			myClipboard.setObjectName(lvs_ObjectName);
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



		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("SelectMenu()");
		myClipboard.getValue().addAll(this.myALValue);


	}

	public void SelectMenu(ArrayList<String> fpLsValue)
	{


		// myALValue Löschen + setzen...
		this.myALValue.clear();
		this.myALValue.addAll( fpLsValue );

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("SelectMenu(ArrayList<String>)");

		myClipboard.getValue().addAll(this.myALValue);


	}

	public void SelectTablecell(String COL, String ROW)
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("SelectTablecell(String COL, String ROW)");

		myClipboard.getValue().add(COL);
		myClipboard.getValue().add(ROW);

		myClipboard.getValue().addAll(this.myALValue);


	}

	public void SelectTablecell_Clicktype(String COL, String ROW, String fpsClickType)
	{

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("SelectTablecellClicktype()");

		myClipboard.getValue().add(COL);
		myClipboard.getValue().add(ROW);
		myClipboard.getValue().add(fpsClickType);

		myClipboard.getValue().addAll(this.myALValue);



	}


	/*        @Override
        public void Select_Clicktype(ArrayList<String> fpLs_Value, String fpsClicktype)
        {


            myClipboard.Clear();
            String lvs_ObjectName = getKN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("Select_Clicktype()");

            myClipboard.getValue().add(fpLs_Value.get(0));
            myClipboard.getValue().add(fpsClicktype);

        }*/

	public void Select_TABLE(ArrayList<String> fpLs_Value)
	{

		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("OKW_Select_TABLE()");
		myClipboard.Clear();
		myClipboard.getValue().add(fpLs_Value.get(0));

	}

	public void SetFocus()
	{


		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("SetFocus()");
		myClipboard.getValue().addAll(this.myALValue);


	}

	public void SetValue( ArrayList<String> fpLs_Value )
	{


		try
		{
			// myALValue Löschen + setzen...
			this.myALValue.clear();

			if (fpLs_Value.get( 0 ).equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ))
			{
				this.myALValue.add("");
			}
			else
			{          
				this.myALValue.addAll( fpLs_Value );
			}

			// Clipboard löschen und Werte setzen...
			myClipboard.Clear();
			String lvs_ObjectName = getKN();

			myClipboard.setObjectName( lvs_ObjectName );
			myClipboard.setMethod( "SetValue()" );

			myClipboard.getValue().addAll( myALValue );
		}
		finally
		{

		}
	}

	public void TypeKey(ArrayList<String> fpLs_Value)
	{


		try
		{

			// myALValue Löschen + setzen...
			this.myALValue.clear();
			this.myALValue.addAll( fpLs_Value );

			myClipboard.Clear();

			String lvs_ObjectName = getKN();

			myClipboard.setObjectName(lvs_ObjectName);
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

			String lvs_ObjectName = getKN();

			myClipboard.setObjectName(lvs_ObjectName);
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


	public ArrayList<String> VerifyBadge()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyBadge()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lvLsReturn;
	}

	public Boolean VerifyExists()
	{


		boolean lvbReturn = false;

		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean( this.myALValue.get( 0 ));
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyExists()");
		myClipboard.getValue().addAll(this.myALValue);;



		return lvbReturn;
	}


	public Boolean VerifyHasFocus()
	{
		Boolean lvbReturn = false;



		myClipboard.Clear();

		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean( this.myALValue.get( 0 ));
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyHasFocus()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lvbReturn;
	}


	public Boolean VerifyIsActive()
	{
		boolean lvbReturn = false;



		try
		{
			lvbReturn = okw.OKW_Const_Sngltn.getInstance().YesNo2Boolean( this.myALValue.get( 0 ));
		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myClipboard.Clear();   
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyIsActive()");
		myClipboard.getValue().addAll(this.myALValue);



		return lvbReturn;
	}


	public ArrayList<String> VerifySelectedValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();

		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifySelectedValue()");
		myClipboard.getValue().addAll(this.myALValue);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyTablecellValue(String Col, String Row)
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();

		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyTablecellValue()");

		myClipboard.getValue().addAll(this.myALValue);
		myClipboard.getValue().add(Col);
		myClipboard.getValue().add(Row);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyTooltip()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyTooltip()");

		myClipboard.getValue().addAll(this.myALValue);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyCaption()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyCaption()");

		myClipboard.getValue().addAll(this.myALValue);



		return lvLsReturn;
	}

	public ArrayList<String> VerifyLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyLabel()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lvLsReturn;
	}

	public Integer VerifyMaxLength()
	{
		Integer lviReturn = 0;



		lviReturn = Integer.valueOf( this.myALValue.get( 0 ) );

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyMaxLength()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lviReturn;
	}

	public ArrayList<String> VerifyPlaceholder()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyPlaceholder()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lvLsReturn;
	}

	public ArrayList<String> VerifyValue()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyValue()");

		myClipboard.getValue().addAll(myALValue);



		return lvLsReturn;
	}

	public Integer VerifyMinLength()
	{
		Integer lviReturn = 0;



		lviReturn = Integer.valueOf( this.myALValue.get( 0 ) );

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyMinLength()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lviReturn;
	}


	public ArrayList<String> VerifyErrorMSG()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();



		lvLsReturn.addAll(this.myALValue);

		myClipboard.Clear();
		String lvs_ObjectName = getKN();
		myClipboard.setObjectName(lvs_ObjectName);
		myClipboard.setMethod("VerifyErrorMSG()");

		myClipboard.getValue().addAll(this.myALValue);;



		return lvLsReturn;
	}
}