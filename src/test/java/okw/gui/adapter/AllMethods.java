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

        String Locator;
        
        Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();
        
        
        String myValue = "";


        public AllMethods(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        public void ClickOn()
        {
            this.myValue = "NO VALUE";
            this.myLogger.LogFunctionStartDebug("ClickOn");
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("ClickOn()");
            myClipboard.Clear();
            myClipboard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void ClickOn_Clicktype(String fpsClickType)
        {
            this.myLogger.LogFunctionStartDebug("ClickOn_Clicktype");
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("ClickOn_Clicktype()");
            myClipboard.Clear();
            myClipboard.getValue().add(fpsClickType);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public boolean LogExists()
        {
            this.myLogger.LogFunctionStart("LogExists");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogExists()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public boolean LogHasFocus()
        {
            this.myLogger.LogFunctionStart("LogHasFocus");

            String lvs_ObjectName = myCurrentObject.GetObjectName();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogHasFocus()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public boolean LogIsActive()
        {
            this.myLogger.LogFunctionStart("LogIsActive");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogIsActive()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(true);

            return true;
        }

        public List<String> LogSelected()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogSelected");
            lvLsReturn.add("Wert_1");
            lvLsReturn.add("Wert_2");
            lvLsReturn.add("Wert_3");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogSelected()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public List<String> LogTablecellValue(String Coll, String Row)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogTablecellValue");
            lvLsReturn.add(Coll);
            lvLsReturn.add(Row);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTablecellValue()");
            myClipboard.Clear();
            myClipboard.getValue().add(Coll);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public List<String> LogTooltip()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogTooltip");
            lvLsReturn.add("Tooltip Rückgabewert 1");
            lvLsReturn.add("Tooltip Rückgabewert 2");
            lvLsReturn.add("Tooltip Rückgabewert 3");

            String lvs_ObjectName = myCurrentObject.GetObjectName();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogTooltip()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public List<String> LogCaption()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogCaption");
            lvLsReturn.add("Caption Rückgabewert 1");
            lvLsReturn.add("Caption Rückgabewert 2");
            lvLsReturn.add("Caption Rückgabewert 3");

            String lvs_ObjectName = myCurrentObject.GetObjectName();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogCaption()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public List<String> LogLabel()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogLabel");
            lvLsReturn.add("Label Rückgabewert 1");
            lvLsReturn.add("Label Rückgabewert 2");
            lvLsReturn.add("Label Rückgabewert 3");

            String lvs_ObjectName = myCurrentObject.GetObjectName();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogLabel()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public List<String> LogValue()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("LogValue");
            lvLsReturn.add("Return Value 1");
            lvLsReturn.add("Return Value 2");
            lvLsReturn.add("Return Value 3");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("LogValue()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd(lvLsReturn);

            return lvLsReturn;
        }

        public boolean MemorizeExists()
        {
            this.myLogger.LogFunctionStart("MemorizeExists");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeExists()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public boolean MemorizeHasFocus()
        {
            this.myLogger.LogFunctionStart("MemorizeHasFocus");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeHasFocus()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public boolean MemorizeIsActive()
        {
            this.myLogger.LogFunctionStart("MemorizeIsActive");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeIsActive()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return true;
        }

        public List<String> MemorizeSelectedValue()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeSelectedValue");
            lvLsReturn.add("MemorizeSelectedValue_Return_1");
            lvLsReturn.add("MemorizeSelectedValue_Return_2");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeSelectedValue()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> MemorizeTablecellValue(String Col, String Row)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeTablecellValue");
            lvLsReturn.add("MemorizeTablecellValue_1");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTablecellValue()");
            myClipboard.Clear();
            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> MemorizeTooltip()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeTooltip");
            lvLsReturn.add("MemorizeTooltip_Return_1");
            lvLsReturn.add("MemorizeTooltip_Return_2");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeTooltip()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> MemorizeCaption()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeCaption");
            lvLsReturn.add("MemorizeCaption_Return_1");
            lvLsReturn.add("MemorizeCaption_Return_2");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeCaption()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> MemorizeLabel()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeLabel");
            lvLsReturn.add("MemorizeLabel_Return_1");
            lvLsReturn.add("MemorizeLabel_Return_2");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeLabel()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> MemorizeValue()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("MemorizeValue");
            lvLsReturn.add("MemorizeValue_Return_1");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("MemorizeValue()");
            myClipboard.Clear();
            myClipboard.getValue().add("NO VALUE");

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public void Select(List<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("Select");

            try
            {
                String lvs_ObjectName = myCurrentObject.GetObjectName();

                myClipboard.setObjectName(lvs_ObjectName);
                myClipboard.setMethod("Select()");

                // Eingabewerte auf den TestClipboard packen...
                myClipboard.Clear();
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
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu()");
            myClipboard.Clear();
            myClipboard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectMenu_Value(List<String> fpLsValue)
        {
            this.myLogger.LogFunctionStartDebug("SelectMenu_Value");
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectMenu_Value()");
            myClipboard.Clear();
            myClipboard.Clear();

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
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectTablecell()");
            myClipboard.Clear();
            myClipboard.getValue().add(COL);
            myClipboard.getValue().add(ROW);
            this.myLogger.LogFunctionEndDebug();
            return;
        }

        public void SelectTablecell_Clicktype(String COL, String ROW, String fpsClickType)
        {
            this.myLogger.LogFunctionStartDebug("SelectTablecell", "String COL", COL, "String ROW", ROW, "String ClickType", fpsClickType);
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SelectTablecellClicktype()");
            myClipboard.Clear();
            myClipboard.getValue().add(COL);
            myClipboard.getValue().add(ROW);
            myClipboard.getValue().add(fpsClickType);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SelectWindow()
        {
        }

        public void Select_Clicktype(List<String> fpLs_Value, String fpsClicktype)
        {
            this.myValue = fpLs_Value.get(0);
            this.myLogger.LogFunctionStartDebug("Select_Clicktype");
            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("Select_Clicktype()");
            myClipboard.Clear();
            myClipboard.getValue().add(fpLs_Value.get(0));
            myClipboard.getValue().add(fpsClicktype);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void Select_TABLE(List<String> fpLs_Value)
        {
            this.myValue = fpLs_Value.get(0);
            this.myLogger.LogFunctionStartDebug("OKW_Select");
            String lvs_ObjectName = myCurrentObject.GetObjectName();

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

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("SetFocus()");
            myClipboard.Clear();
            myClipboard.getValue().add(this.myValue);
            this.myLogger.LogFunctionEndDebug();
            
            return;
        }

        public void SetValue(List<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("SetValue");

            try
            {
                String lvs_ObjectName = myCurrentObject.GetObjectName();

                myClipboard.setObjectName(lvs_ObjectName);
                myClipboard.setMethod("SetValue()");

                // Eingabe werte auf den TestClipboard packen
                myClipboard.Clear();
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

        public void TypeKey(List<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {
                String lvs_ObjectName = myCurrentObject.GetObjectName();

                myClipboard.setObjectName(lvs_ObjectName);
                myClipboard.setMethod("TypeKey(List<String> fpLs_Value)");

                // Eingabe werte auf den TestClipboard packen
                myClipboard.Clear();
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

        public void TypeKeyTablecell(String COL, String ROW, List<String> fpLsValues)
        {
            this.myLogger.LogFunctionStartDebug("TypeKeyTablecell", "String COL", COL, "String ROW", ROW);

            try
            {
                String lvs_ObjectName = myCurrentObject.GetObjectName();

                myClipboard.setObjectName(lvs_ObjectName);
                myClipboard.setMethod("TypeKeyTablecell(String COL, String ROW, List<String> Values)");

                // Eingabe werte auf den TestClipboard packen
                myClipboard.Clear();

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

        public void TypeKey_TABLE_ROW(int ROW, List<String> Values)
        {
        }


        public boolean VerifyExists(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStart("VerifyExists", "fpbExpectedValue", fpbExpectedValue.toString());

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyExists()");
            myClipboard.Clear();
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEnd(fpbExpectedValue);

            return fpbExpectedValue;
        }


        public Boolean VerifyHasFocus(Boolean fpbExpectedValue)
        {
            myLogger.LogFunctionStart("VerifyHasFocus", "fpbExpectedValue", fpbExpectedValue.toString());

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyHasFocus()");
            myClipboard.Clear();
            myClipboard.getValue().add(fpbExpectedValue.toString());

            this.myLogger.LogFunctionEnd();

            return fpbExpectedValue;
        }

        public boolean VerifyIsActive(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyIsActive");

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyIsActive()");
            myClipboard.Clear();
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEnd();

            return fpbExpectedValue;
        }

        public List<String> VerifySelectedValue(List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifySelectedValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifySelectedValue()");
            myClipboard.Clear();
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyTablecellValue(String Col, String Row, List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyTablecellValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTablecellValue()");

            myClipboard.Clear();
            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyTooltip(List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyTooltip");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTooltip()");
            myClipboard.Clear();
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyCaption(List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyCaption");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyCaption()");
            myClipboard.Clear();
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyLabel(List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyLabel");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyLabel()");
            myClipboard.Clear();
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }

        public List<String> VerifyValue(List<String> fpLsExpectedValue)
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStart("VerifyValue");
            lvLsReturn.addAll(fpLsExpectedValue);

            String lvs_ObjectName = myCurrentObject.GetObjectName();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyValue()");
            myClipboard.Clear();
            myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEnd();

            return lvLsReturn;
        }
    }