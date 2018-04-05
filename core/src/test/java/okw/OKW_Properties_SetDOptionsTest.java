package okw;

import static org.junit.Assert.*;
import org.junit.Test;

public class OKW_Properties_SetDOptionsTest {

    OKW_Properties myProperties = new OKW_Properties();

    @Test
    public final void clear_Test() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");
        myProperties.PrintProperties();

        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
        assertEquals( "Oracle Corporation", myProperties.get("java.vendor"));

        myProperties.clear();   
        assertEquals( null, myProperties.get("Wert0"));
        assertEquals( null, myProperties.get("Wert1"));
        assertEquals( "NEWVALUE", myProperties.get("Wert2"));
        assertEquals( null, myProperties.get("Wert3"));
        assertEquals( null, myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
        assertEquals( "Oracle Corporation", myProperties.get("java.vendor"));
    }

    @Test
    public final void loadFromResourceTest() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");

        myProperties.PrintProperties();

        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));
    }

    @Test
    public final void loadFromResource_OVERLOAD_Test() {
        myProperties.clear();
        myProperties.addResource("OKW_PropertiesTest/properties_Test1.properties");
        myProperties.PrintProperties();
        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));
        assertEquals("Wert 1 aus properties_Test1", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test1", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test1", myProperties.get("Wert4"));
        assertEquals( null, myProperties.get("Wert5"));

        myProperties.addResource("OKW_PropertiesTest/properties_Test2.properties");
        myProperties.PrintProperties();
        assertEquals("Wert 0 aus properties_Test1", myProperties.get("Wert0"));

        assertEquals("Wert 1 aus properties_Test2", myProperties.get("Wert1"));
        assertEquals("NEWVALUE", myProperties.get("Wert2"));
        assertEquals("Wert 3 aus properties_Test2", myProperties.get("Wert3"));
        assertEquals("Wert 4 aus properties_Test2", myProperties.get("Wert4"));
        assertEquals("Wert 5 aus properties_Test2", myProperties.get("Wert5"));
        assertEquals( null, myProperties.get("Wert6"));
    }
}
