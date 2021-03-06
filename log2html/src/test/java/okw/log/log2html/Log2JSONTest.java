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

package okw.log.log2html;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.junit.JUnitBase;

@Tag("Log2HTML")
public class Log2JSONTest extends JUnitBase
{
    @BeforeEach
    public void setUp() throws Exception
    {
        okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
    }
    
	   @Test
	    public void TC_LogPrint_Simple_Test()
	    {   
	        Log2HTML myLog = new Log2HTML( TestName );
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Simple_Test" );
	            myLog.LogPrint( "LogPrint 1" );
	            myLog.LogPrint( "LogPrint 2" );
	            myLog.LogPrint( "LogPrint 3" );
	        myLog.LogTestcaseEnd();

	        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );	        

	        assertEquals( Expected, Current );
	    }

	@Test
	public void TC_LogPrint_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterer Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogPrintDebug_Test()
	{	
		Log2HTML myLog = new Log2HTML( TestName );
	    myLog.setDebugMode( true );
				
		myLog.LogTestcaseStart( "TC_LogPrintDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrintDebug( "Print im Schlüsselwort");
				myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_ResultList_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_ResultListPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenList( "ResultOpenList..." );
					myLog.LogPrint( "Print im Schlüsselwort");
					myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.ResCloseList();
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_ResultListDebug_Test( )
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		myLog.setDebugMode( true );
				
		myLog.LogTestcaseStart( "TC_ResultListDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenListDebug( "ResultOpenListDebug" );
					myLog.LogPrintDebug( "Print im Schlüsselwort");
					myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.LogError( "Error" );
					myLog.LogPass( "Pass" );
					myLog.ResCloseListDebug();
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_LogException_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogException_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogException( "Exception");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogError_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogError_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogError("Error");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_LogWarning_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogWarning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogWarning( "Warnung");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	   @Test
	    public void TC_LogVerify_Test()
	    {   
	        Log2HTML myLog = new Log2HTML(TestName);
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Test" );
	            myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
	            
	            //myLog.LogV
	            
	                myLog.LogKeyWordEnd();
	            myLog.LogPrint( "Print auf einer Ebene höher...");
	        myLog.LogTestcaseEnd();

            String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
            String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

            assertEquals( Expected, Current );
	    }

	
	@Test
	public void TC_LogSequence_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogSequenceStart( "Sequence", "Facebook", "Login", "Zoltan", "!?GhoKklA");
			myLog.LogKeyWordStart( "Typekey", "Name", "Zoltan" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "Password", "!?GhoKklA" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Click", "OK" );
				myLog.LogKeyWordEnd();
			
			myLog.LogSequenceEnd();

		myLog.LogSequenceStart( "Sequence", "Facebook", "Update user properties", "Germany", "Hamburg", "male", "brown");
			myLog.LogKeyWordStart( "Typekey", "Country", "Germany" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "city", "Hamburg" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "Gender", "male" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "eye color", "male" );
				myLog.LogKeyWordEnd();
			
			myLog.LogSequenceEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogKeyWord_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	
	@Test
	public void TC_Reset_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_Reset_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();
			
//		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
//			myLog.LogPrint("Das ist ein LogPrint...");
//			myLog.LogKeyWordEnd();
	myLog.LogTestcaseEnd();	
		

		myLog.LogTestcaseStart( "This Test" );			
        myLog.LogTestcaseEnd(); 

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
    @Test
    public void TC_LogLocalACCall_Test() {

        Log2HTML myLog = new Log2HTML(TestName);

        myLog.LogTestcaseStart( "TC_LogPrecondition_Test" );
        
        myLog.LogLocalACCallStart( "WHEN myPrecondion IS Test", "I" );
            myLog.LogSourceLocation( "10", "15", "myFeature", "mySourceType" );
        
            myLog.LogKeyWordStart( "Typekey", "Name", "Zoltan" );
                myLog.LogKeyWordEnd();
            myLog.LogKeyWordStart( "Typekey", "Password", "!?GhoKklA" );
                myLog.LogKeyWordEnd();
            
            myLog.LogLocalACCallEnd();
            
        myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
    }
}
