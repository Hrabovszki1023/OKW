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
import okw.gui.OKWLocator;
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

        
        public String getFN()
        {
            return "Rechner.All_MethodsObj";
        }
        
        public ArrayList<String> VerifyBadge()
		{
		    this.myLogger.LogFunctionStartDebug("VerifyBadge");
		
		    // ${EMPTY} => ArrayList mit einem Wert und ""
		    ArrayList<String> lvLsReturn = new ArrayList<String>();
		    lvLsReturn.add( "" );
		
		    myClipboard.Clear();
		    String lvs_ObjectName = getFN();
		    myClipboard.setObjectName(lvs_ObjectName);
		    myClipboard.setMethod("VerifyBadge()");
		
		    myClipboard.getValue().clear();
		
		    this.myLogger.LogFunctionEndDebug();
		
		    return lvLsReturn;
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

        public ArrayList<String> VerifySelectedValue() //ArrayList<String> fpLsExpectedValue)
        {
            this.myLogger.LogFunctionStartDebug("VerifySelectedValue");
            
            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifySelectedValue()");
            //myClipboard.getValue().addAll(fpLsExpectedValue);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public List<String> VerifyTablecellValue(String Col, String Row, ArrayList<String> fpLsExpectedValue)
        {

            this.myLogger.LogFunctionStartDebug("VerifyTablecellValue");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTablecellValue()");

            myClipboard.getValue().add(Col);
            myClipboard.getValue().add(Row);

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> VerifyTooltip()
        {

            this.myLogger.LogFunctionStartDebug("VerifyTooltip");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyTooltip()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        
        public ArrayList<String> VerifyCaption()
        {

            this.myLogger.LogFunctionStartDebug("VerifyCaption");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );


            myClipboard.Clear();
            String lvs_ObjectName = getFN();

            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyCaption()");
            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> VerifyLabel()
        {
            this.myLogger.LogFunctionStartDebug("VerifyLabel");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyLabel()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> VerifyPlaceholder()
        {
            this.myLogger.LogFunctionStartDebug("VerifyPlaceholder");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyPlaceholder()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }

        public ArrayList<String> VerifyValue()
        {
            this.myLogger.LogFunctionStartDebug("VerifyValue");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyValue()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }
        
        public ArrayList<String> VerifyErrorMSG()
        {
            this.myLogger.LogFunctionStartDebug("VerifyErrorMSG");

            // ${EMPTY} => ArrayList mit einem Wert und ""
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            lvLsReturn.add( "" );

            myClipboard.Clear();
            String lvs_ObjectName = getFN();
            myClipboard.setObjectName(lvs_ObjectName);
            myClipboard.setMethod("VerifyErrorMSG()");

            myClipboard.getValue().clear();

            this.myLogger.LogFunctionEndDebug();

            return lvLsReturn;
        }
    }