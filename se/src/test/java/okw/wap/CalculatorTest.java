package okw.wap;

import org.junit.*;

import okw.core.EN;

public class CalculatorTest {


    @Test
    public void Addition() throws Exception
    {
    	EN.BeginTest("Combination");
    	EN.StartApp("Rechner");
    	
    	EN.ClickOn( "1" );
    	EN.ClickOn( "+" );
    	EN.ClickOn( "7" );
    	EN.ClickOn( "=" );

        EN.VerifyValueWCM( "Display", "*8." );    	
    	EN.StopApp("Rechner");
    	
    	EN.EndTest();

    }

    @Test
    public void Combination() throws Exception
    {
    	EN.BeginTest("Combination");
    	EN.StartApp("Rechner");
    	
    	EN.ClickOn( "7" );
    	EN.ClickOn( "*" );
    	EN.ClickOn( "1" );
    	EN.ClickOn( "+" );
    	EN.ClickOn( "1" );
    	EN.ClickOn( "=" );
    	EN.ClickOn( "/" );
    	EN.ClickOn( "8" );
    	EN.ClickOn( "=" );
    	
    	EN.VerifyValueWCM( "Display", "*1." );

    	EN.StopApp("Rechner");
    	EN.EndTest();

    }

    @Test
    public void Division() throws Exception
    {
    	EN.BeginTest("Combination");
    	EN.StartApp("Rechner");
    	
    	EN.ClickOn( "8" );
    	EN.ClickOn( "8" );

    	EN.ClickOn( "/" );
    	
    	EN.ClickOn( "1" );
    	EN.ClickOn( "1" );
    	
    	EN.ClickOn( "=" );

    	EN.VerifyValueWCM( "Display", "*8." );
    	
    	EN.StopApp("Rechner");
    	EN.EndTest();

    }

    @Test
    public void Multiplication() throws Exception
    {
    	EN.BeginTest("Combination");
    	EN.StartApp("Rechner");
    	
    	EN.ClickOn( "3" );
    	EN.ClickOn( "3" );
    	
    	EN.ClickOn( "*" );
        
    	EN.ClickOn( "3" );
    	
    	EN.ClickOn( "=" );
 
    	EN.VerifyValueWCM( "Display", "*99." );
    	
    	EN.StopApp("Rechner");
    	
    	EN.EndTest();


    }

    /*@Test
    public void ListofObjects()
    {
        List<WebElement> myResult = CalculatorSession.findElementByXPath("//Window[@Name=\"Rechner\"]//*").findElements( By.xpath("//*") );
        
        for ( Iterator iterator = myResult.iterator(); iterator.hasNext(); )
        	  System.out.println( ((WebElement)iterator.next()).getAttribute("AutomationId") );
        
    }
    */
}



