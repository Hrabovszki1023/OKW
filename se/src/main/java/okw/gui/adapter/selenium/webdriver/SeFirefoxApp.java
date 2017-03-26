package okw.gui.adapter.selenium.webdriver;

/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;

import okw.gui.AnyWindow;
import okw.gui.adapter.selenium.*;
import okw.log.*;


    /**
     *  \brief
     *  OKW Selenium FireFox BrowserWindow Klasse
     */ 
    public class SeFirefoxApp extends AnyWindow
    {
        protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();


        public SeFirefoxApp()
        {
        	MyLogger.LogFunctionStartDebug("SeFirefoxApp()");

        	MyLogger.LogFunctionEndDebug();
        }


        public void Init()
        {
        	MyLogger.LogFunctionStartDebug("Init()");

            //// this.URL.mydriver = this.driver;

        	MyLogger.LogFunctionEndDebug();
        }

        @Override
        public void SelectWindow()
        {
        }

        
        @SuppressWarnings("unchecked")
		public void StartApp()
        {
        	MyLogger.LogFunctionStartDebug("StartApp");

        	try
        	{
       	    
        	    String OKWGeckodriverPath = System.getenv("OKWGeckodriverPath");
        	    
        	    if (OKWGeckodriverPath != null)
        	    {
            		System.setProperty("webdriver.gecko.driver", OKWGeckodriverPath);
                }
        	    else
                {
        	    	MyLogger.LogWarning("Enviroment Variable 'OKWGeckodriverPath' is not set!");
            		
        	    	Properties systemProperties = System.getProperties();
        	    	Enumeration<?> enuProp = systemProperties.propertyNames();
        	    	
        	    	List list= Collections.list(enuProp); // create list from enumeration 
        	    	Collections.sort(list);
        	    	enuProp = Collections.enumeration(list);
        	    	
        	     
        	    	MyLogger.ResOpenList("System.getProperties()... ");
        	    		
        	    	while (enuProp.hasMoreElements())
        	    	{
        	    		String propertyName = (String) enuProp.nextElement();
        	    		String propertyValue = systemProperties.getProperty(propertyName);
        	    		MyLogger.LogPrint(propertyName + ": " + propertyValue);
        	    	}
        	    	
        	    	MyLogger.ResCloseList();
        	    	
        	    	switch (System.getProperty("os.name") )
        	    	{
        	    		case "Mac OS X":
                	    	System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
        	    		case "Linux":
                	    	System.setProperty("webdriver.gecko.driver", "/home/travis/build/Hrabovszki1023/OKW/geckodriver");
        	    		default:
        	    			MyLogger.LogError("Unknown Operating System" + System.getProperty("os.name"));
        	    	}		
                }
        	        
        		SeDriver.getInstance().driver = new FirefoxDriver();
        		this.Init();
        	}
        	finally
        	{
                MyLogger.LogFunctionEndDebug();				
			}
        }

        
        public void StopApp()
        {
        	MyLogger.LogFunctionStartDebug("StopApp");

            SeDriver.getInstance().driver.quit();

            MyLogger.LogFunctionEndDebug();
        }

        public void TypeKey(ArrayList<String> fps_Values)
        {
        }

    }