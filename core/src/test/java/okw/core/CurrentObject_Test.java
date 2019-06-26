/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.junit.*;

import okw.*;
import okw.exceptions.*;
import okw.log.*;

public class CurrentObject_Test {


	        static OKW_CurrentObject_Sngltn CO = null;
	        
	    	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	    	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();
	        
	        Core myKernel= new Core();

	        /// \brief
	        /// Ziel des TestFixturesetup: Startbedingung für alle Testfälle herstellen.
	        /// Der Aufruf erfolgt genau einmal vor allen Testfällen.
	        /// 
	        /// Folgende Aktivitäten werden durchgeführt:
	        /// * Log2NUnit in den Logger laden.
	        /// * Debug-Modus des Logger -s abschalten.
	        /// * Logmessanger Spracheinstellung auf DE setzen.
	        /// 
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	        @BeforeClass
	        public static void TestFixtureSetUp()
	        {
	            try
	            {
	                // Reset des Loggers: Alle geladenen Instanzen löschen
	            	Logger_Sngltn.init();
	                
	                // Debug-Modus des Logger -s abschalten.
	            	myLogger.setDebugMode(true);

	                // Logmessenger Spracheinstellung auf "de" setzen.
	                OKWLanguage.getInstance().setLanguage("en");
	                
	                CO = OKW_CurrentObject_Sngltn.getInstance();
	            }
	            catch (Exception e)
	            {
	                // TODO: Prüfen ob Exception hier so OK Ist...
	            	myLogger.LogPrint("SystemException e");
	            }
	        }

	       @After
	        public void MyTearDown()
	        {
	    	   myLogger.LogFunctionEnd();
	        }

           @Test
           public void tc_setWindowName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
                CO.setWindowName( "CurrentObjectWindow" );
                assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
                assertEquals( "", CO.getChildFN ( ) );
                
           }
	       
           @Test (expected = OKWFrameObjectParentNotFoundException.class )
           public void tc_setWindowName_Doesnot_exists() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
                CO.setWindowName( "Uschi" );
           }
	       
	       
           @Test
           public void tc_setChildName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
                CO.setWindowName( "CurrentObjectWindow" );
                assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
                assertEquals( "CurrentObjectWindow", CO.getObjectFN() );

                CO.setChildName( "CurrentObjectAllMethodCallTypes" );
                assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
                assertEquals( "CurrentObjectAllMethodCallTypes", CO.getChildFN() );
                assertEquals( "CurrentObjectWindow.CurrentObjectAllMethodCallTypes", CO.getObjectFN() );
           }
           
           @Test
           public void tc_setChildName_SELECTEDCHILD() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
                CO.setWindowName( "CurrentObjectWindow" );
                CO.setChildName( "CurrentObjectAllMethodCallTypes" );
                CO.setChildName( "SELECTEDCHILD" );

                assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
                assertEquals( "CurrentObjectAllMethodCallTypes", CO.getChildFN() );
                assertEquals( "CurrentObjectWindow.CurrentObjectAllMethodCallTypes", CO.getObjectFN() );
                assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
                assertEquals( "CurrentObjectAllMethodCallTypes", CO.getChildFN() );
                assertEquals( "CurrentObjectWindow.CurrentObjectAllMethodCallTypes", CO.getObjectFN() );
           }
           
           @Test (expected = OKWFrameObjectChildNotFoundException.class )
           public void tc_setChildName_OKWFrameObjectChildNotFoundException() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
               CO.setChildName( "MakeException" );
           }
	       
           
           @Test
           public void tc_getChildName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
               CO.setChildName( "CurrentObjectAllMethodCallTypes" );
               assertEquals( "CurrentObjectAllMethodCallTypes", CO.getChildFN() );
           }	


           @Test
           public void tc_LogObjectDataParent() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               CO.LogObjectData();
           }
           

           @Test
           public void tc_LogObjectDataChild() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               CO.setChildName( "CurrentObjectAllMethodCallTypes" );
               CO.LogObjectData();
           }


           @Test
           public void tc_getCurrentObject_Parent() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               Object myObject = CO.getCurrentObject();
               
               assertEquals( "okw.gui.frames.frmCurrentObjectWindow", myObject.getClass().getName());
           }
           

           @Test
           public void tc_getCurrentObject_Child() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               CO.setWindowName( "CurrentObjectWindow" );
               CO.setChildName( "CurrentObjectAllMethodCallTypes" );
               Object myObject = CO.getCurrentObject();
               assertEquals( "okw.gui.adapter.CurrentChildObject_Allmethods", myObject.getClass().getName());
           }

           @Test
           public void tc_ResetToWindow_Child() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
           {
               // Vorbereitung CO auf child setzten
               CO.setWindowName( "CurrentObjectWindow" );
               CO.setChildName( "CurrentObjectAllMethodCallTypes" );
               Object myObject = CO.getCurrentObject();
               assertEquals( "okw.gui.adapter.CurrentChildObject_Allmethods", myObject.getClass().getName());
               assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
               assertEquals( "CurrentObjectAllMethodCallTypes", CO.getChildFN() );
               
               // Test: Nach dem resetToWindow ist das CurrentObjekt das Fenster
               myObject = CO.resetToWindow();
               assertEquals( "okw.gui.frames.frmCurrentObjectWindow", CO.getCurrentObject().getClass().getName());
               assertEquals( "okw.gui.frames.frmCurrentObjectWindow", myObject.getClass().getName());
               assertEquals( "CurrentObjectWindow", CO.getWindowFN() );
               assertEquals( "", CO.getChildFN() );
           }           

           @Test
           public void tc_getAllChildFNsOfParent() 
           {
               ArrayList<String> myChilds = CO.getAllChildFNsOfParent("CurrentObjectWindow" );

               assertEquals( 3 , myChilds.size() );
               assertEquals( true, myChilds.contains( "CurrentObjectWindow") );
               assertEquals( true, myChilds.contains( "CurrentObjectWindow.CurrentObjectAllMethodCallTypes") );
               assertEquals( true, myChilds.contains( "CurrentObjectWindow.AllMethod 2") );
           }   
           

           @Test
           public void tc_Sequence() throws Exception 
           {
               
               CO.Sequence( "Rechner", "TestSequence_1", "TestID" );
               
               assertEquals( "Rechner", CO.getWindowFN() );
               assertEquals( "", CO.getChildFN() );
               
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("TestID", myClipBoard.getValue().get(0));
               assertEquals("Rechner", myClipBoard.getObjectName());
               assertEquals("TestSequence_1()", myClipBoard.getMethod());
           }  
           

           @Test (expected=OKWFrameObjectMethodNotFoundException.class)
           public void tc_Sequence_OKWFrameObjectMethodNotFoundException() throws Exception 
           {
               CO.Sequence( "Rechner", "TestSequence_Nichtvorhanden", "TestID" );
           }  

           
           
           /**
            *  Testziel: Prüft den Aufruf der Methode ClickOn( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_ClickOn_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());

               this.myKernel.SetValue("AllMethod 2", "NO VALUE");
               this.myKernel.ClickOn("AllMethod 2");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("ClickOn()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode DoubleClickOn( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_DoubleClickOn_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());

               this.myKernel.SetValue("AllMethod 2", "NO VALUE");
               this.myKernel.DoubleClickOn("AllMethod 2");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("DoubleClickOn()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogCaption( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogCaption_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogCaption("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogCaption()", myClipBoard.getMethod());
           }

        /**
            *  Testziel: Prüft den Aufruf der Methode LogExists( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogExists_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());

               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogExists("AllMethod 2");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("YES", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogExists()", myClipBoard.getMethod());
           }

           /**
            *  Testziel: Prüft den Aufruf der Methode LogExists( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogHasFocus_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());

               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogHasFocus("AllMethod 2");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("YES", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogHasFocus()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogExists( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogIsActive_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());

               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogIsActive("AllMethod 2");

               // Check the Name, Called Method and Value of Actuel object
               assertEquals("YES", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogIsActive()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogLabel( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogLabel_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogLabel("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogLabel()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogPlaceholder( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogPlaceholder_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogPlaceholder("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogPlaceholder()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogCaption( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogSelected_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogSelected("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogSelected()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogTablecellValue( "FN", COL, ROW ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogTablecellValue_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogTablecellValue("AllMethod 2", "myCOL", "myROW");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("myCOL", myClipBoard.getValue().get(0));
               assertEquals("myROW", myClipBoard.getValue().get(1));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogTablecellValue()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogTooltip( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogTooltip_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogTooltip("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogTooltip()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode LogTooltip( "FN" ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_LogValue_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.LogValue("AllMethod 2");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("LogValue()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeCaption( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeCaption_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               //this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizeCaption("AllMethod 2", "tc_MemorizeCaption_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeCaption()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeExists( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeExists_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizeExists("AllMethod 2", "tc_MemorizeExists_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeExists()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeHasFocus( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeHasFocus_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.MemorizeHasFocus("AllMethod 2", "tc_MemorizeHasFocus_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeHasFocus()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeIsActive( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeIsActive_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.MemorizeIsActive("AllMethod 2", "tc_MemorizeIsActive_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeIsActive()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeValue( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeValue_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.MemorizeValue("AllMethod 2", "tc_MemorizeValue_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeValue()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeLabel( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeLabel_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               //this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizeLabel("AllMethod 2", "tc_MemorizeLabel_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeLabel()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizePlaceholder( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizePlaceholder_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               //this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizePlaceholder("AllMethod 2", "tc_MemorizePlaceholder_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizePlaceholder()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeSelectedValue( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeSelectedValue_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               //this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizeSelectedValue("AllMethod 2", "tc_MemorizeSelectedValue_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeSelectedValue()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeSelectedValue( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeTablecellValueValue_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               //this.myKernel.SetValue("AllMethod 2", "YES");
               this.myKernel.MemorizeTablecellValue("AllMethod 2", "myCOL", "myROW", "tc_MemorizeTablecellValueValue_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("myCOL", myClipBoard.getValue().get(0));
               assertEquals("myROW", myClipBoard.getValue().get(1));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeTablecellValue()", myClipBoard.getMethod());
           }

           
           /**
            *  Testziel: Prüft den Aufruf der Methode MemorizeTooltip( FN, MemKey ) im ChildObject
            * @throws Exception
            */
           @Test
           public void tc_MemorizeTooltip_ChildObject() throws Exception
           {
               // Testscript in Schlüsselwort-Notation
               this.myKernel.SelectWindow("CurrentObjectWindow");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
               assertEquals("SelectWindow()", myClipBoard.getMethod());
        
               this.myKernel.MemorizeTooltip("AllMethod 2", "tc_MemorizeTooltip_ChildObject");
        
               // Check the Name, Called Method and Value of Actuel object
               assertEquals("NO VALUE", myClipBoard.getValue().get(0));
               assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
               assertEquals("MemorizeTooltip()", myClipBoard.getMethod());
           }

           
           /// \brief
	        /// OKW.Select unit-test for the Keyword >>Select: "WindowName#WINDOW"<<
	        /// 
	    	@Test
	        public void TC_SelectWindowName_WINDOW() throws Exception
	        {
	            // Testscript in Schlüsselwort notation
	            this.myKernel.SelectWindow("Rechner");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            //assertEquals("Rechner", myClipBoard.getObjectName());
	            assertEquals("SelectWindow()", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Ts the c_ select_ child object_ with out_ value.
	        /// 
	    	@Test
	        public void TC_Select_ChildObject_WithOut_Value() throws Exception
	        {
	            // Testscript in Schlüsselwort-Notation
	            this.myKernel.SelectWindow("Rechner");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            assertEquals("Rechner", myClipBoard.getObjectName());
	            assertEquals("SelectWindow()", myClipBoard.getMethod());

	            this.myKernel.ClickOn("Taste_3");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            //assertEquals("Rechner.Taste_3", myClipBoard.getObjectName());
	            assertEquals("ClickOn()", myClipBoard.getMethod());
	        }

            /**
             *  Testziel: Prüft den Aufruf der Methode Select( "FN", "One Value" ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_Select_ChildObject_WithOneValue() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.Select("AllMethod 2", "One Value");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("One Value", myClipBoard.getValue().get(0));
                //assertEquals("Rechner.Taste_3", myClipBoard.getObjectName());
                assertEquals("Select()", myClipBoard.getMethod());
            }

            
            /**
             *  Testziel: Prüft den Aufruf der Methode SelectMenu( "FN" ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_SelectMenu_ChildObject() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.SetValue("AllMethod 2", "NO VALUE");
                this.myKernel.SelectMenu("AllMethod 2");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("SelectMenu()", myClipBoard.getMethod());
            }
            
            
            /**
             *  Testziel: Prüft den Aufruf der Methode SelectMenu( FN ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_SelectMenu_WithOneValue() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.SetValue("AllMethod 2", "NO VALUE");
                this.myKernel.SelectMenu("AllMethod 2", "One Value");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("One Value", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("SelectMenu(ArrayList<String>)", myClipBoard.getMethod());
            }
            
            
            /**
             *  Testziel: Prüft den Aufruf der Methode SetValue( FN, Val ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_SetValue_WithOneValue() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.SetValue("AllMethod 2", "my Value");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("my Value", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("SetValue()", myClipBoard.getMethod());
            }
            
            
            /**
             *  Testziel: Prüft den Aufruf der Methode TypeKey( FN, Val ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_TypeKey_WithOneValue() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.TypeKey("AllMethod 2", "my Value");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("my Value", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod());
            }

            
            /**
             *  Testziel: Prüft den Aufruf der Methode SelectTablecell( FN, COL, ROW ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_SelectTablecelle() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.SetValue("AllMethod 2", "NO VALUE");
                this.myKernel.SelectTablecell("AllMethod 2", "Column", "Row");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("Column", myClipBoard.getValue().get(0));
                assertEquals("Row",    myClipBoard.getValue().get(1));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("SelectTablecell(String COL, String ROW)", myClipBoard.getMethod());
            }

            
            /**
             *  Testziel: Prüft den Aufruf der Methode SetFocus( "FN" ) im ChildObject
             * @throws Exception
             */
            @Test
            public void tc_SetFocus_ChildObject_WithOneValue() throws Exception
            {
                // Testscript in Schlüsselwort-Notation
                this.myKernel.SelectWindow("CurrentObjectWindow");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                this.myKernel.SetValue("AllMethod 2", "NO VALUE");
                this.myKernel.SetFocus("AllMethod 2");

                // Check the Name, Called Method and Value of Actuel object
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("CurrentObjectWindow.AllMethod 2", myClipBoard.getObjectName());
                assertEquals("SetFocus()", myClipBoard.getMethod());
            }


	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetChildName(*).
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_ChildName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetChildName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.setWindowName("Rechner");
	            
	            // Setzen wir den Namen des Kindobjektes
	            CO.setChildName("Taste_3");
	            
	            // Nun müssen "Rechner" In Windowname finden.
	            //assertEquals("Rechner.Taste_3", CO.GetObjectName());
	        }

	        /// \brief
	        /// Testziel: Prüfen, ob OKW_Kernel_Exception in der Methode CurrentObject.SetChildName() ausglöst wird.<br/>
	        /// Auslöse Grund ist, wenn ein Kindobjekt angesprochen wird, ohne das voher ein Fenster-Objekt ausgewählt worden ist.<br/>
	        /// 
	        /// \remark Folgende Reaktionen sind denkbar:
	        /// 1. OKW_Kernel_Exception wird ausgelöst: KernelException wird true gesetzt.
	        /// 2. Es wird eine anderere beliebige Ausnahme(Exception) ausgelöst: KernelException wird false gesetzt.
	        /// 3. Es wird keine  Ausnahme ausgelöst: KernelException bleibt false gesetzt.
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetChildName_OKWFrameObjectWindowNotSetException()
	        {
	            try
	            {
	                OKW_CurrentObject_Sngltn.init();
	                // Exception wird ausgelöst wenn ein Fenster Objekt nicht gesetzt ist.
	                // Der Namen des Fensters wurde hier daher bewusst weggelasssen:
	                CO.setChildName("Taste_3");

	                // Folgende Zeile darf nicht ausgeführt werden. ... Hier wir auf exception geprüft
	                fail();
	            }
	            catch (OKWFrameObjectWindowNotSetException e)
	            {
	                System.out.println(e.getMessage());
	                assertEquals("No Window is defined! Please select a Window first!", e.getMessage());
	            }
	            catch (Exception e)
	            {
	                fail("Es wurde ein nicht erwarteter Exception ausgelöst: " + e.getMessage());
	            }
	        }

	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetWindowName(*).
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_WindowName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetWindowName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.setWindowName("Rechner");

	            // Nun müssen "frm_Rechner" In Windowname finden.
	            assertEquals("Rechner", CO.getObjectFN());
	        }

	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetWindowName(*).
	        /// Speziel wird hier geprüft, ob das Kindpbjekt name gelöscht wird, wenn erneut ein Fenstername gesetzt wird.
	        /// 
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_WindowName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetWindowName_AfterChildWasSetted() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.setWindowName("Rechner");

	            // Setzen wir den Namen des Kindobjektes
	            CO.setChildName("Taste_3");

	            // Nun müssen "Rechner" In Windowname finden.
	            // assertEquals("Rechner.Taste_3", CO.GetObjectName());

	            // Nun müssen "frm_Rechner" In Windowname finden.
	            CO.setWindowName("Rechner");
	            // assertEquals("Rechner", CO.GetObjectName());
	        }
	}

