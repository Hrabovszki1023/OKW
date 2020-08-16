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


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.junit.JUnitBase;

@Tag("Log2HTML")
public class LogException_Test extends JUnitBase
{

    String ClassName = this.getClass().getSimpleName();
    
	@BeforeEach
	public void setUp() throws Exception
	{
	    okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
	}

    @Test
    public void tc_LogFunction_1_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FunctionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEnd();        

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_2_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEnd( true );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_3_LogException_Test()
    {   
        ArrayList<String> lsReturn = new ArrayList<String>();
        
        lsReturn.add( "Sting 1" );
        lsReturn.add( "Sting 2" );
        lsReturn.add( "Sting 3" );
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEnd( lsReturn );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_4_LogException_Test()
    {   
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEnd( "Return String" );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    
    @Test
    public void tc_LogTestcaseStart_LogException_Normal_Test()
    {   
        Log2HTML myLog = new Log2HTML( "Log2HTML - " + TestName );
                        
        myLog.LogTestcaseStart( TestName );
             myLog.LogException( "LogException");
        myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    
    @Test
    public void tc_LogFunctionDebug_1_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEndDebug();        
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_LogFunctionDebug_2_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEndDebug( true );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_LogFunctionDebug_3_LogException_Test()
    {   
        ArrayList<String> lsReturn = new ArrayList<String>();
        
        lsReturn.add( "Sting 1" );
        lsReturn.add( "Sting 2" );
        lsReturn.add( "Sting 3" );
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEndDebug( lsReturn );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunctionDebug_4_LogException_Test()
    {   
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogException( "LogException");
        myLog.LogFunctionEndDebug( "Return String" );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogLocalACCallStart_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogLocalACCallStart( "my source excerpt", "my Local AC Type" );;
             myLog.LogException( "LogException");
        myLog.LogLocalACCallEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogRemoteACCallStart_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogRemoteACCallStart( "sourceExcerpt", "my remote AC type" );
             myLog.LogException( "LogException");
        myLog.LogRemoteACCallEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogSequence_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogSequenceStart( "Sequence", "Window", "SequenzName", "SeqID" );
             myLog.LogException( "LogException");
        myLog.LogSequenceEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogStep_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
        
        myLog.LogTestcaseStart( "TestCase = " + TestName );
        
        myLog.LogStepStart( "mycategoryName", "mycategoryType", "mychoiceValue", "myfeatureName", "mylocalCategoryName", "mysourceExcerpt", "TestStep" );
             myLog.LogException( "LogException");
        myLog.LogStepEnd( );
    
        myLog.LogTestcaseEnd();
        
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogKeyWordStart_LogException_Normal_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
            myLog.LogException( "LogException");
            myLog.LogKeyWordEnd();
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_ResultList_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.ResOpenList( "fps_ListHeader" );
             myLog.LogException( "LogException");
        myLog.ResCloseList( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }
    

    @Test
    public void tc_ResultListDebug_LogException_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.ResOpenListDebug( "fps_ListHeader" );
             myLog.LogException( "LogException");
        myLog.ResCloseListDebug( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }
}
