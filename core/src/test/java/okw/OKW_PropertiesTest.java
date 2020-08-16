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

package okw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import okw.exceptions.OKWFileDoesNotExistsException;

@Tag("AllCoreHelperTests")
public class OKW_PropertiesTest
{

    protected OKW_Properties myProperties = OKW_Properties.getInstance();

    @Test
    public final void tc_clear()
    {
        myProperties.init();
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test2", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test2", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test2", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test2", myProperties.get( "Wert4" ) );
        assertEquals( "Wert 5 aus properties_Test2", myProperties.get( "Wert5" ) );
        //assertEquals( "okw.AllTests", myProperties.get( "TESTCASE" ) );

        myProperties.PrintProperties();

        myProperties.clear();
        assertEquals( null, myProperties.get( "Wert0" ) );
        assertEquals( null, myProperties.get( "Wert1" ) );
        assertEquals( null, myProperties.get( "Wert2" ) );
        assertEquals( null, myProperties.get( "Wert3" ) );
        assertEquals( null, myProperties.get( "Wert4" ) );
        assertEquals( null, myProperties.get( "Wert5" ) );
        assertEquals( null, myProperties.get( "TESTCASE" ) );
        
    }


    @Test
    public final void tc_loadFromResourceTest()
    {
        myProperties.init();
        
        //core.test.overwrite=Value from core.properties
        assertEquals( "Value from core.properties", myProperties.get( "core.test.overwrite" ) );

        //core.test.property=core.test.property
        assertEquals( "core.test.property", myProperties.get( "core.test.property" ) );

                        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test2", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test2", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test2", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test2", myProperties.get( "Wert4" ) );
        assertEquals( "Wert 5 aus properties_Test2", myProperties.get( "Wert5" ) );
    }

    
    @Test
    public final void tc_loadFromResource_OVERLOAD_Test()
    {
        myProperties.clear();
        myProperties.addResource( "okw/default/properties/OKW_PropertiesTest/properties_Test1.properties" );
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );
        assertEquals( null, myProperties.get( "Wert5" ) );
        
        myProperties.addResource( "okw/default/properties/OKW_PropertiesTest/properties_Test2.properties" );
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test2", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test2", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test2", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test2", myProperties.get( "Wert4" ) );
        assertEquals( "Wert 5 aus properties_Test2", myProperties.get( "Wert5" ) );
        assertEquals( null, myProperties.get( "Wert6" ) );
    }

    
    @Test
    public final void tc_LoadSystemEnviromentVar_Overload() throws FileNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {

        myProperties.clear();
        myProperties.init();

        Method mymethod = OKW_Properties.class.getDeclaredMethod( "loadSystemEnviromentVars");
        mymethod.setAccessible(true);
        
        mymethod.invoke( myProperties);
        mymethod.invoke( myProperties);
    }


    @Test
    public final void tc_LoadSystemProperties_Overload() throws FileNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {

        myProperties.clear();
        myProperties.init();

        Method mymethod = OKW_Properties.class.getDeclaredMethod( "loadSystemProperties");
        mymethod.setAccessible(true);
        
        mymethod.invoke( myProperties);
        mymethod.invoke( myProperties);
    }

    @Test
    public final void tc_getPropertiesForKeysStartswith() throws IOException
    {
        myProperties.clear();
        myProperties.addResource( "okw/default/properties/OKW_PropertiesTest/properties_Test1.properties" );
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );

        ArrayList<String> testPropertiesExpected = new ArrayList<String>();
        Collections.sort( testPropertiesExpected );
        
        testPropertiesExpected.add( "Wert 0 aus properties_Test1");
        testPropertiesExpected.add( "Wert 1 aus properties_Test1");
        testPropertiesExpected.add( "Wert 2 aus properties_Test1");
        testPropertiesExpected.add( "Wert 3 aus properties_Test1");
        testPropertiesExpected.add( "Wert 4 aus properties_Test1");
        
        ArrayList<String> testProperties = myProperties.getPropertiesForKeysStartswith( "Wert" );
        Collections.sort(testProperties);
        
        assertEquals( testPropertiesExpected, testProperties );
    }

    
    @Test
    public final void tc_getKeysStartswith() throws IOException
    {
        myProperties.clear();
        myProperties.addResource( "okw/default/properties/OKW_PropertiesTest/properties_Test1.properties" );
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );

        ArrayList<String> testPropertiesExpected = new ArrayList<String>();
        Collections.sort( testPropertiesExpected );
        
        testPropertiesExpected.add( "Wert0");
        testPropertiesExpected.add( "Wert1");
        testPropertiesExpected.add( "Wert2");
        testPropertiesExpected.add( "Wert3");
        testPropertiesExpected.add( "Wert4");
        
        ArrayList<String> testProperties = myProperties.getKeysStartswith( "Wert" );
        Collections.sort(testProperties);
        
        assertEquals( testPropertiesExpected, testProperties );
    }
    
    
    @Test
    public final void tc_addPropertiesFile_OKWFileDoesNotExistsException() throws IOException
    {
        okw.OKW_FileHelper.deleteFile( "testPropertiesExpected.properties" );
        
        Assertions.assertThrows( OKWFileDoesNotExistsException.class, () ->
        {
            myProperties.addPropertiesFile( "testPropertiesExpected.properties" );
        }); 
        
    }
    
    
    @Test
    public final void tc_addPropertiesFile() throws IOException
    {
        // Create Precondition:
        // delete destination file
        okw.OKW_FileHelper.deleteFile( "testPropertiesExpected.properties" );
        
        Properties newProperties = new Properties(); 

        newProperties.setProperty( "Wert 0", "Wert 0 aus testPropertiesExpected.properties" );
        newProperties.setProperty( "Wert 1", "Wert 1 aus testPropertiesExpected.properties" );
        newProperties.setProperty( "Wert 2", "Wert 2 aus testPropertiesExpected.properties" );
        newProperties.setProperty( "Wert 3", "Wert 3 aus testPropertiesExpected.properties" );
        newProperties.setProperty( "Wert 4", "Wert 4 aus testPropertiesExpected.properties" );
        
        // Write new destination file
        newProperties.store( new FileOutputStream("testPropertiesExpected.properties"), null );
        
        
        // Testcase
        myProperties.init();
        myProperties.addPropertiesFile( "testPropertiesExpected.properties" );
        
        assertEquals( "Wert 0 aus testPropertiesExpected.properties", myProperties.get( "Wert 0" ) );
        assertEquals( "Wert 1 aus testPropertiesExpected.properties", myProperties.get( "Wert 1" ) );
        assertEquals( "Wert 2 aus testPropertiesExpected.properties", myProperties.get( "Wert 2" ) );
        assertEquals( "Wert 3 aus testPropertiesExpected.properties", myProperties.get( "Wert 3" ) );
        assertEquals( "Wert 4 aus testPropertiesExpected.properties", myProperties.get( "Wert 4" ) );
    }

    
    @Test
    public final void tc_getProperty2Boolean() throws IOException
    {
        //assertEquals(  false, myProperties.getProperty2Boolean( "core.AbortOnVerifyFail", "false" ) );
        //assertEquals(  false, myProperties.getProperty2Boolean( "propertyDoesNotExist", "false" ) );
        assertEquals(  true,  myProperties.getProperty2Boolean( "core.propertyDoesNotExist", "true" ) );
    }

    
    @Test
    public final void tc_getProperty_CombindValues() throws IOException
    {
        //assertEquals(  "Wert 1", myProperties.getProperty( "Value_1" ) );
        //assertEquals(  "Wert 2", myProperties.getProperty( "Value_2" ) );
        
        assertEquals(  "Wert 1", myProperties.getProperty( "CombineValues.One_Value" ) );
        assertEquals(  "Wert 1; Wert 2", myProperties.getProperty( "CombineValues.Two_Values" ) );
    }


    @Test
    public final void tc_getProperty_With_Paramaters() throws IOException
    {
        /*
        # Properties mit Parametern
        ParamaterValues.One_Param = P1: $P1$
        ParamaterValues.Two_Params_1 = P1: $P1$; P2: $P2$
        ParamaterValues.Two_Params_2 = P2: $P2$; P1: $P1$
        */
        
        assertEquals(  "P1: Param1", myProperties.getProperty( "ParamaterValues.One_Param", null, "Param1" ) );
        assertEquals(  "P1: Param1; P2: Param2", myProperties.getProperty( "ParamaterValues.Two_Params_1", null, "Param1", "Param2" ) );
        assertEquals(  "P2: Param2; P1: Param1", myProperties.getProperty( "ParamaterValues.Two_Params_2", null, "Param1", "Param2" ) );
    }


    @Test
    public final void tc_getProperty_With_Paramaters_Param_NotExist_1P() throws IOException
    {
        assertEquals( "", myProperties.getProperty( "ParamaterValues.One_Param_Notexists", null, "Param1" ) );
    }


    @Test
    public final void tc_getProperty_With_Paramaters_Param_NotExist_2P() throws IOException
    {
        
        assertEquals( "", myProperties.getProperty( "ParamaterValues.Two_Params_1_Notexists", null, "Param1", "Param2" ) );
    }

    
    @Test
    public final void tc_getProperty_With_ParamatersAndDefaultValues() throws IOException
    {
        /*
        # Properties mit Parametern
        ParamaterValues.One_Param = P1: $P1$
        ParamaterValues.Two_Params_1 = P1: $P1$; P2: $P2$
        ParamaterValues.Two_Params_2 = P2: $P2$; P1: $P1$
        */
        
        assertEquals(  "P1: Param1", myProperties.getProperty( "ParamaterValues.One_Param", "With DefaultValue P1: %P1%", "Param1" ) );
        assertEquals(  "P1: Param1; P2: Param2", myProperties.getProperty( "ParamaterValues.Two_Params_1", "With DefaultValue P1: %P1%; P2: %P2%", "Param1", "Param2" ) );

        assertEquals(  "With DefaultValue P1: Param1", myProperties.getProperty( "ParamaterValues.One_Param_NotExist", "With DefaultValue P1: %P1%", "Param1" ) );
        assertEquals(  "With DefaultValue P1: Param1; P2: Param2", myProperties.getProperty( "ParamaterValues.Two_Params_1_NotExist", "With DefaultValue P1: %P1%; P2: %P2%", "Param1", "Param2" ) );

    }


    @Test
    public final void tc_getProperty_With_ParamatersAndDefaultValuesPropertiesNotExist() throws IOException
    {
        /*
        # Properties mit Parametern
        ParamaterValues.One_Param = P1: $P1$
        ParamaterValues.Two_Params_1 = P1: $P1$; P2: $P2$
        ParamaterValues.Two_Params_2 = P2: $P2$; P1: $P1$
        */
        
        assertEquals(  "With DefaultValue P1: Param1", myProperties.getProperty( "ParamaterValues.One_Param_NotExist", "With DefaultValue P1: %P1%", "Param1" ) );
        assertEquals(  "With DefaultValue P1: Param1; P2: Param2", myProperties.getProperty( "ParamaterValues.Two_Params_1_NotExist", "With DefaultValue P1: %P1%; P2: %P2%", "Param1", "Param2" ) );

    }
    
    @Test
    public final void tc_PrintPropertiesSources() throws IOException
    {
        myProperties.PrintPropertiesSources();
    }

}
