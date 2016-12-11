package okw.gui.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.*;
import okw.gui.AnyWinBase;
import okw.log.Logger_Sngltn;


    public class AllMethods_SingleValue extends AnyWinBase
    {

        protected String Locator;
        
        protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        //protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();
        
        
        ArrayList<String> myALValue = new ArrayList<String>();


        public AllMethods_SingleValue(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        
        public String getFN()
        {
            return "Rechner.All_MethodsObj";
        }
        
        public void ClickOn()
        {

          this.myLogger.LogFunctionStartDebug("ClickOn");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("ClickOn()");
            myClipboard.getValue().addAll(this.myALValue);
            
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void DoubleClickOn()
        {
          this.myLogger.LogFunctionStartDebug("ClickOn_Clicktype");
            
            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("DoubleClickOn()");
            
            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public boolean LogExists()
        {
          
            this.myLogger.LogFunctionStartDebug("LogExists");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogExists()");

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
            
            this.myLogger.LogFunctionEndDebug(lvbReturn);
            return lvbReturn;        }

        public boolean LogHasFocus()
        {
          this.myLogger.LogFunctionStartDebug("LogHasFocus");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

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
            
            this.myLogger.LogFunctionEndDebug(lvbReturn);
            return lvbReturn;
        }

        public boolean LogIsActive()
        {
            this.myLogger.LogFunctionStartDebug("LogIsActive");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

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
            
            this.myLogger.LogFunctionEndDebug(lvbReturn);
            return lvbReturn;
        }

        public ArrayList<String> LogSelected()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogSelected");
            lvLsReturn.add("Wert_1");
            lvLsReturn.add("Wert_2");
            lvLsReturn.add("Wert_3");

            myClipboard.Clear();
           String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogSelected()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogTablecellValue(String Coll, String Row)
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogTablecellValue");
            lvLsReturn.add(Coll);
            lvLsReturn.add(Row);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTablecellValue()");
            myClipboard.getValue().add(Coll);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogTooltip()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogTooltip");
            lvLsReturn.add("Tooltip Rückgabewert 1");
            lvLsReturn.add("Tooltip Rückgabewert 2");
            lvLsReturn.add("Tooltip Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTooltip()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogCaption()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogCaption");
            lvLsReturn.add("Caption Rückgabewert 1");
            lvLsReturn.add("Caption Rückgabewert 2");
            lvLsReturn.add("Caption Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogCaption()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogLabel()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogLabel");
            lvLsReturn.add("Label Rückgabewert 1");
            lvLsReturn.add("Label Rückgabewert 2");
            lvLsReturn.add("Label Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogLabel()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("LogValue");
            lvLsReturn.add("Return Value 1");
            lvLsReturn.add("Return Value 2");
            lvLsReturn.add("Return Value 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug(lvLsReturn);

            return lvLsReturn;
        }

        public boolean MemorizeExists()
        {
            this.myLogger.LogFunctionStartDebug("MemorizeExists");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeExists()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return true;
        }

        public boolean MemorizeHasFocus()
        {
            this.myLogger.LogFunctionStartDebug("MemorizeHasFocus");

            myClipboard.Clear();
           String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeHasFocus()");
            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();

            return true;
        }

        public boolean MemorizeIsActive()
        {
            this.myLogger.LogFunctionStartDebug("MemorizeIsActive");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeIsActive()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return true;
        }

        public ArrayList<String> MemorizeSelectedValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeSelectedValue");
            lvLsReturn.add("MemorizeSelectedValue_Return_1");
            lvLsReturn.add("MemorizeSelectedValue_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeSelectedValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeTablecellValue(String Col, String Row)
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeTablecellValue");
            lvLsReturn.add("MemorizeTablecellValue_1");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTablecellValue()");
            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeTooltip()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeTooltip");
            lvLsReturn.add("MemorizeTooltip_Return_1");
            lvLsReturn.add("MemorizeTooltip_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTooltip()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeCaption()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeCaption");
            lvLsReturn.add("MemorizeCaption_Return_1");
            lvLsReturn.add("MemorizeCaption_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeCaption()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeLabel()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeLabel");
            lvLsReturn.add("MemorizeLabel_Return_1");
            lvLsReturn.add("MemorizeLabel_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeLabel()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("MemorizeValue");
            lvLsReturn.add("MemorizeValue_Return_1");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public void Select(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("Select");

            try
            {
              // myALValue Löschen + setzen...
              this.myALValue.clear();
              this.myALValue.addAll( fpLs_Value );

              myClipboard.Clear();             
            	String lvs_ObjectName = getFN();

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
                this.myLogger.LogFunctionEndDebug();
            }

            return;
        }

        public void SelectMenu()
        {

          this.myLogger.LogFunctionStartDebug("SelectMenu");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu()");
            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectMenu_Value(ArrayList<String> fpLsValue)
        {
            this.myLogger.LogFunctionStartDebug("SelectMenu_Value");

            // myALValue Löschen + setzen...
            this.myALValue.clear();
            this.myALValue.addAll( fpLsValue );
            
            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu_Value()");

            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectTablecell(String COL, String ROW)
        {
            this.myLogger.LogFunctionStartDebug("SelectTablecell", "String COL", COL, "String ROW", ROW);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectTablecell()");
            
            myClipboard.getValue().add(COL);
            myClipboard.getValue().add(ROW);
            
            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectTablecell_Clicktype(String COL, String ROW, String fpsClickType)
        {
            this.myLogger.LogFunctionStartDebug("SelectTablecell", "String COL", COL, "String ROW", ROW, "String ClickType", fpsClickType);
            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectTablecellClicktype()");

            myClipboard.getValue().add(COL);
            myClipboard.getValue().add(ROW);
            myClipboard.getValue().add(fpsClickType);

            myClipboard.getValue().addAll(this.myALValue);
           
            
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SelectWindow()
        {
        }

/*        @Override
        public void Select_Clicktype(ArrayList<String> fpLs_Value, String fpsClicktype)
        {
            this.myLogger.LogFunctionStartDebug("Select_Clicktype");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("Select_Clicktype()");
            
            myClipboard.getValue().add(fpLs_Value.get(0));
            myClipboard.getValue().add(fpsClicktype);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }*/

        public void Select_TABLE(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("OKW_Select");
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("OKW_Select_TABLE()");
            myClipboard.Clear();
            myClipboard.getValue().add(fpLs_Value.get(0));
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SetFocus()
        {
            this.myLogger.LogFunctionStartDebug("SetFocus");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SetFocus()");
            myClipboard.getValue().addAll(this.myALValue);

            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

  public void SetValue( ArrayList<String> fpLs_Value )
  {
    this.myLogger.LogFunctionStartDebug( "SetValue" );

    try
    {
      // myALValue Löschen + setzen...
      this.myALValue.clear();
      this.myALValue.addAll( fpLs_Value );

      // Clipboard löschen und Werte setzen...
      myClipboard.Clear();
      String lvs_ObjectName = getFN();

      myClipboard.setObjectName( lvs_ObjectName );
      myClipboard.setMethod( "SetValue()" );

      myClipboard.getValue().addAll( myALValue );
    }
    finally
    {
      this.myLogger.LogFunctionEndDebug();
    }

    return;
  }

        public void TypeKey(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {

              // myALValue Löschen + setzen...
              this.myALValue.clear();
              this.myALValue.addAll( fpLs_Value );

              myClipboard.Clear();
                
                String lvs_ObjectName = getFN();

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
                this.myLogger.LogFunctionEndDebug();
            }
            
            return;
        }

        public void TypeKeyTablecell(String COL, String ROW, ArrayList<String> fpLsValues)
        {
            this.myLogger.LogFunctionStartDebug("TypeKeyTablecell", "String COL", COL, "String ROW", ROW);

            try
            {
                myClipboard.Clear();
                
                String lvs_ObjectName = getFN();

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
                this.myLogger.LogFunctionEndDebug();
            }
            
            return;
        }

        public void TypeKey_TABLE_ROW(int ROW, ArrayList<String> Values)
        {
        }


        public boolean VerifyExists() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStartDebug("VerifyExists");

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
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyExists()");
            myClipboard.getValue().addAll(this.myALValue);;

            this.myLogger.LogFunctionEndDebug(true);

            return lvbReturn;
        }


        public Boolean VerifyHasFocus()
        {
          Boolean lvbReturn = false;
          
          myLogger.LogFunctionStartDebug("VerifyHasFocus");

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
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyHasFocus()");

            myClipboard.getValue().addAll(this.myALValue);;

            this.myLogger.LogFunctionEndDebug();

            return lvbReturn;
        }


        public boolean VerifyIsActive() throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
          boolean lvbReturn = false;
          
            this.myLogger.LogFunctionStartDebug("VerifyIsActive");

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
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyIsActive()");
            myClipboard.getValue().addAll(this.myALValue);;
            
            this.myLogger.LogFunctionEndDebug();

            return lvbReturn;
        }


        public List<String> VerifySelectedValue(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifySelectedValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifySelectedValue()");
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyTablecellValue(String Col, String Row, ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyTablecellValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTablecellValue()");

            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyTooltip()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyTooltip");
            lvLsReturn.add("The one and only Value");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTooltip()");

            myClipboard.getValue().add("The one and only Value");

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyCaption()
       {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyCaption");
            lvLsReturn.addAll(this.myALValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyCaption()");

            myClipboard.getValue().addAll(this.myALValue);;

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }
        
        public List<String> VerifyLabel()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyLabel");
            
            
            lvLsReturn.addAll(this.myALValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyLabel()");

            myClipboard.getValue().addAll(this.myALValue);;

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyValue()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyValue");
            
            lvLsReturn.addAll(myALValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyValue()");

            myClipboard.getValue().addAll(myALValue);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }
    }