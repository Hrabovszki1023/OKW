package okw;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.junit.Test;

import okw.exceptions.OKWFileDoesNotExistsException;

public class OKW_PropertiesTest
{

    protected OKW_Properties myProperties = OKW_Properties.getInstance();

    @Test
    public final void tc_clear()
    {
        myProperties.init();
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );
        assertEquals( "Wert 5 aus properties_Test2", myProperties.get( "Wert5" ) );
        assertEquals( "Oracle Corporation", myProperties.get( "java.vendor" ) );

        myProperties.PrintProperties();

        myProperties.clear();
        assertEquals( null, myProperties.get( "Wert0" ) );
        assertEquals( null, myProperties.get( "Wert1" ) );
        assertEquals( null, myProperties.get( "Wert2" ) );
        assertEquals( null, myProperties.get( "Wert3" ) );
        assertEquals( null, myProperties.get( "Wert4" ) );
        assertEquals( null, myProperties.get( "Wert5" ) );
        assertEquals( null, myProperties.get( "java.vendor" ) );
        
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
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );
        assertEquals( "Wert 5 aus properties_Test2", myProperties.get( "Wert5" ) );
    }

    
    @Test
    public final void tc_loadFromResource_OVERLOAD_Test()
    {
        myProperties.clear();
        myProperties.addResource( "OKW_PropertiesTest/properties_Test1.properties" );
        
        assertEquals( "Wert 0 aus properties_Test1", myProperties.get( "Wert0" ) );
        assertEquals( "Wert 1 aus properties_Test1", myProperties.get( "Wert1" ) );
        assertEquals( "Wert 2 aus properties_Test1", myProperties.get( "Wert2" ) );
        assertEquals( "Wert 3 aus properties_Test1", myProperties.get( "Wert3" ) );
        assertEquals( "Wert 4 aus properties_Test1", myProperties.get( "Wert4" ) );
        assertEquals( null, myProperties.get( "Wert5" ) );
        
        myProperties.addResource( "OKW_PropertiesTest/properties_Test2.properties" );
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

        Method mymethod = OKW_Properties.class.getDeclaredMethod( "loadSystemEnviromentVars", null);
        mymethod.setAccessible(true);
        
        mymethod.invoke( myProperties, null);
        mymethod.invoke( myProperties, null);
    }


    @Test
    public final void tc_LoadSystemProperties_Overload() throws FileNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {

        myProperties.clear();
        myProperties.init();

        Method mymethod = OKW_Properties.class.getDeclaredMethod( "loadSystemProperties", null);
        mymethod.setAccessible(true);
        
        mymethod.invoke( myProperties, null);
        mymethod.invoke( myProperties, null);
    }

    @Test
    public final void tc_getPropertiesForKeysStartswith() throws IOException
    {
        myProperties.clear();
        myProperties.addResource( "OKW_PropertiesTest/properties_Test1.properties" );
        
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
        myProperties.addResource( "OKW_PropertiesTest/properties_Test1.properties" );
        
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
    
    
    @Test ( expected=OKWFileDoesNotExistsException.class )
    public final void tc_addPropertiesFile_OKWFileDoesNotExistsException() throws IOException
    {
        okw.OKW_FileHelper.deleteFile( "testPropertiesExpected.properties" );
        myProperties.addPropertiesFile( "testPropertiesExpected.properties" );
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
}
