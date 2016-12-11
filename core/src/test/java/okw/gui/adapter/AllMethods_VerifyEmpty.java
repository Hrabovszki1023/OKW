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


    public class AllMethods_VerifyEmpty extends AnyWinBase
    {

        protected String Locator;
        
        protected Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
        //protected OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
        protected OKW_TestClipboard        myClipboard     = OKW_TestClipboard.getInstance();
        
        
        String myValue = "";


        public AllMethods_VerifyEmpty(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        
        public String getFN()
        {
            return "Rechner.All_MethodsObj";
        }
        
        public boolean VerifyExists(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStartDebug("VerifyExists", "fpbExpectedValue", fpbExpectedValue.toString());

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyExists()");
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEndDebug(fpbExpectedValue);

            return fpbExpectedValue;
        }


        public Boolean VerifyHasFocus(Boolean fpbExpectedValue)
        {
            myLogger.LogFunctionStartDebug("VerifyHasFocus", "fpbExpectedValue", fpbExpectedValue.toString());

            myClipboard.Clear();
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyHasFocus()");

            myClipboard.getValue().add(fpbExpectedValue.toString());

            this.myLogger.LogFunctionEndDebug();

            return fpbExpectedValue;
        }

        public boolean VerifyIsActive(Boolean fpbExpectedValue) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
        {
            this.myLogger.LogFunctionStartDebug("VerifyIsActive");

            myClipboard.Clear();   
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyIsActive()");
            myClipboard.getValue().add(OKW_Const_Sngltn.getInstance().Boolean2YesNo(fpbExpectedValue));

            this.myLogger.LogFunctionEndDebug();

            return fpbExpectedValue;
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

            this.myLogger.LogFunctionStartDebug("VerifyTablecellValue");

            List<String> lvLsReturn = new ArrayList<String>();
            // empty => Empty ArrayList

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTablecellValue()");

            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyTooltip()
        {

            this.myLogger.LogFunctionStartDebug("VerifyTooltip");

            List<String> lvLsReturn = new ArrayList<String>();
            // empty => Empty ArrayList

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTooltip()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyCaption()
        {

            this.myLogger.LogFunctionStartDebug("VerifyCaption");

            List<String> lvLsReturn = new ArrayList<String>();
            // empty => Empty ArrayList

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyCaption()");
            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }


        public List<String> VerifyLabel()
        {
            List<String> lvLsReturn = new ArrayList<String>();

            this.myLogger.LogFunctionStartDebug("VerifyLabel");
            // empty => Empty ArrayList

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyLabel()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }


        public List<String> VerifyValue()
        {
            this.myLogger.LogFunctionStartDebug("VerifyValue");

            List<String> lvLsReturn = new ArrayList<String>();
            // empty => Empty ArrayList

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyValue()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }
    }