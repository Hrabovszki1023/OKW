package okw;

import static org.junit.Assert.*;

import org.junit.Test;

import okw.fourTestLocator;

 /*  <code> fpsL = "//div[@ID='myID']"</code> -> <code>return = "//div[@ID='myID']"</code>
  *  <code> fpsL = "4T!MyValue"</code> -> <code>return = "//*[@data-4Test='MyValue']"</code>
  *  <code> fpsL = "4TNA!MyValue"</code> -> <code>return = "//*[contains( @name, 'MyValue']"</code>
  *  <code> fpsL = "4TID!MyValue"</code> -> <code>return = "//*[contains( @ID, 'MyValue']"</code>
  *  <code> fpsL = "4TLA!MyValue"</code> -> <code>return = "//label[contains(text(),'MyValue')]/following-sibling::input"</code>
  *  <code> fpsL = "4TTX!MyValue"</code> -> <code>return = "//*[contains(text(),'MyValue')]"</code>
  */
public class fourTestLocatorTest {
	private fourTestLocator myLocator = new fourTestLocator("");
	
     
    @Test
    public void tcNon4TestLocator() throws Exception
    {
    	assertEquals( "//div[@ID='myID']", myLocator.get4TestLocator( "//div[@ID='myID']" )  );
    }


    @Test
    public void tc_4T_Locator() throws Exception
    {
    	assertEquals( "//*[@data-4test='MyLocator']", myLocator.get4TestLocator( "4T!MyLocator" )  );
    }

    
    @Test
    public void tc_4T_LocatorMitClass() throws Exception
    {
    	assertEquals( "//*[@data-4test='MyLocator']", myLocator.get4TestLocator( "4T!myClass::MyLocator" )  );
        assertEquals( "myClass", myLocator.getGUIClass() );
        assertEquals( "//*[@data-4test='MyLocator']", myLocator.getLocator() );
    }

    @Test
    public void tc_4T_SeperateLocator() throws Exception
    {
        assertEquals( 0, myLocator.seperateClassnameAndLocator( "myClass::MyLocator" ) );
    }

    @Test
    public void tc_4T_SeperateLocator_fehler() throws Exception
    {
        assertEquals( -1, myLocator.seperateClassnameAndLocator( "myClass::myClass::MyLocator" ) );
    }

    
    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TNA_Locator() throws Exception
    {
        	assertEquals( "//*[contains(@name,'MyLabelText')]", myLocator.get4TestLocator( "4TNA!MyLabelText" )  );
    }
  
    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TID_Locator() throws Exception
    {
        	assertEquals( "//*[contains(@id,'MyLabelText')]", myLocator.get4TestLocator( "4TID!MyLabelText" )  );
    }
    
    /**
     * Suche Label mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TLA_Locator() throws Exception
    {
    	assertEquals( "//label[contains(text(),'MyLabelText')]/following-sibling::input", myLocator.get4TestLocator( "4TLA!MyLabelText" )  );
    }
    

    /**
     * Suche Element mit Text und hole textfeld dazu
     * @throws Exception
     */
    @Test
    public void tc_4TTX_Locator() throws Exception
    {
    	assertEquals( "//*[contains(text(),'MyCaptionText')]", myLocator.get4TestLocator( "4TTX!MyCaptionText" )  );
    }
}

