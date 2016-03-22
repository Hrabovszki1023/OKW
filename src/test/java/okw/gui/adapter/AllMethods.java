package okw.gui.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.*;
import okw.log.Logger_Sngltn;


    public class AllMethods // : IOKW_SimpleDataObj
    {

        protected String Locator;
        
        protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        //protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();
        
        
        String myValue = "";


        public AllMethods(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        
        public String getFN()
        {
            return "Rechner.All_MethodsObj";
        }
        
        public void ClickOn()
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("ClickOn");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("ClickOn()");
            myClipboard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void ClickOn_Clicktype(String fpsClickType)
        {
            this.myLogger.LogFunctionStartDebug("ClickOn_Clicktype");
            
            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("ClickOn_Clicktype()");
            
            myClipboard.getValue().add( fpsClickType );

            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public boolean LogExists()
        {
            this.myLogger.LogFunctionStart("LogExists");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogExists()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public boolean LogHasFocus()
        {
            this.myLogger.LogFunctionStart("LogHasFocus");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogHasFocus()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public boolean LogIsActive()
        {
            this.myLogger.LogFunctionStart("LogIsActive");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogIsActive()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public ArrayList<String> LogSelected()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogSelected");
            lvLsReturn.add("Wert_1");
            lvLsReturn.add("Wert_2");
            lvLsReturn.add("Wert_3");

            myClipboard.Clear();
           String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogSelected()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogTablecellValue(String Coll, String Row)
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogTablecellValue");
            lvLsReturn.add(Coll);
            lvLsReturn.add(Row);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTablecellValue()");
            myClipboard.getValue().add(Coll);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogTooltip()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogTooltip");
            lvLsReturn.add("Tooltip Rückgabewert 1");
            lvLsReturn.add("Tooltip Rückgabewert 2");
            lvLsReturn.add("Tooltip Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTooltip()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogCaption()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogCaption");
            lvLsReturn.add("Caption Rückgabewert 1");
            lvLsReturn.add("Caption Rückgabewert 2");
            lvLsReturn.add("Caption Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogCaption()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogLabel()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogLabel");
            lvLsReturn.add("Label Rückgabewert 1");
            lvLsReturn.add("Label Rückgabewert 2");
            lvLsReturn.add("Label Rückgabewert 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogLabel()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public ArrayList<String> LogValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogValue");
            lvLsReturn.add("Return Value 1");
            lvLsReturn.add("Return Value 2");
            lvLsReturn.add("Return Value 3");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public boolean MemorizeExists()
        {
            this.myLogger.LogFunctionStart("MemorizeExists");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeExists()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public boolean MemorizeHasFocus()
        {
            this.myLogger.LogFunctionStart("MemorizeHasFocus");

            myClipboard.Clear();
           String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeHasFocus()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public boolean MemorizeIsActive()
        {
            this.myLogger.LogFunctionStart("MemorizeIsActive");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeIsActive()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public ArrayList<String> MemorizeSelectedValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeSelectedValue");
            lvLsReturn.add("MemorizeSelectedValue_Return_1");
            lvLsReturn.add("MemorizeSelectedValue_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeSelectedValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeTablecellValue(String Col, String Row)
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeTablecellValue");
            lvLsReturn.add("MemorizeTablecellValue_1");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTablecellValue()");
            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeTooltip()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeTooltip");
            lvLsReturn.add("MemorizeTooltip_Return_1");
            lvLsReturn.add("MemorizeTooltip_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTooltip()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeCaption()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeCaption");
            lvLsReturn.add("MemorizeCaption_Return_1");
            lvLsReturn.add("MemorizeCaption_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeCaption()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeLabel()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeLabel");
            lvLsReturn.add("MemorizeLabel_Return_1");
            lvLsReturn.add("MemorizeLabel_Return_2");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeLabel()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public ArrayList<String> MemorizeValue()
        {
        	ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeValue");
            lvLsReturn.add("MemorizeValue_Return_1");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeValue()");
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public void Select(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("Select");

            try
            {
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
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("SelectMenu");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu()");
            myClipboard.getValue().add(this.myValue);

            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectMenu_Value(ArrayList<String> fpLsValue)
        {
            this.myLogger.LogFunctionStartDebug("SelectMenu_Value");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu_Value()");

            for (String lsValue : fpLsValue)
            {
                myClipboard.getValue().add(lsValue);
            }

            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectTablecell(String COL, String ROW)
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("SelectTablecell", "String COL", COL, "String ROW", ROW);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectTablecell()");
            myClipboard.getValue().add(COL);
            myClipboard.getValue().add(ROW);

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
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SelectWindow()
        {
        }

        public void Select_Clicktype(ArrayList<String> fpLs_Value, String fpsClicktype)
        {
            this.myValue = fpLs_Value.get(0);
            this.myLogger.LogFunctionStartDebug("Select_Clicktype");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("Select_Clicktype()");
            myClipboard.getValue().add(fpLs_Value.get(0));
            myClipboard.getValue().add(fpsClicktype);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void Select_TABLE(ArrayList<String> fpLs_Value)
        {
            this.myValue = fpLs_Value.get(0);
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
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("SetFocus");

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SetFocus()");
            myClipboard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SetValue(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("SetValue");

            try
            {
                myClipboard.Clear();
                String lvs_ObjectName = getFN();

                myClipboard.setObjectName(lvs_ObjectName);
                myClipboard.setMethod("SetValue()");

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

        public void TypeKey(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {
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


        public boolean VerifyExists(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStart("VerifyExists", "fpbExpectedValue", fpbExpectedValue.toString());

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyExists()");
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEnd(fpbExpectedValue);

            return fpbExpectedValue;
        }


        public Boolean VerifyHasFocus(Boolean fpbExpectedValue)
        {
            myLogger.LogFunctionStart("VerifyHasFocus", "fpbExpectedValue", fpbExpectedValue.toString());

            myClipboard.Clear();
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyHasFocus()");

            myClipboard.getValue().add(fpbExpectedValue.toString());

            this.myLogger.LogFunctionEnd();

            return fpbExpectedValue;
        }

        public boolean VerifyIsActive(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStart("VerifyIsActive");

            myClipboard.Clear();   
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyIsActive()");
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEnd();

            return fpbExpectedValue;
        }

        public List<String> VerifySelectedValue(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifySelectedValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifySelectedValue()");
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyTablecellValue(String Col, String Row, ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyTablecellValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTablecellValue()");

            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyTooltip(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyTooltip");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTooltip()");
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyCaption(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyCaption");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyCaption()");
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyLabel(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyLabel");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyLabel()");
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyValue(ArrayList<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyValue()");

            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }
    }