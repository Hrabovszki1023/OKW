package okw;

public class fourTestLocator
{
	public fourTestLocator( String fspL )
    {
        super();
        this.get4TestLocator( fspL );
    }

    private String cvsGUIClass = null;
	private String cvsLocator = null;

	
    /**
     * Erzeugt einen locator aus dem gegebene Wert, wenn fspL mit "4T!", "4T:" oder "4T?" anfängt, sonst wird fspL unver�ndert zur�ckgegeben.
     * 
     * @note
     *  <code> fpsL = "//div[@ID='myID']"</code> -> <code>return = "//div[@ID='myID']"</code>
     *  <code> fpsL = "4T!MyValue"</code> -> <code>return = "//*[@data-4Test='MyValue']"</code>
     *  <code> fpsL = "4TNA!MyValue"</code> -> <code>return = "//*[contains( @name, 'MyValue']"</code>
     *  <code> fpsL = "4TID!MyValue"</code> -> <code>return = "//*[contains( @ID, 'MyValue']"</code>
     *  <code> fpsL = "4TLA!MyValue"</code> -> <code>return = "//label[contains(text(),'MyValue')]/following-sibling::input"</code>
     *  <code> fpsL = "4TTX!MyValue"</code> -> <code>return = "//*[contains(text(),'MyValue')]"</code>
     *  
     * @param fspL Locator Parameter
     * @return Erzeugter data-4Test Locator oder unver�nderter fpsL-Wert.
     */
    public String get4TestLocator( String fspL )
    {
    	String lvsReturn = fspL;
    	String LogMessage = "";
    	
    	if ( fspL.startsWith("4T!") )
    	{
    		// Find object with data-4test attribute
    		LogMessage = "Generate '@data-4test' Locator";
    		seperateClassnameAndLocator( fspL.replaceFirst("4T!", "" ) );
    		lvsReturn = "//*[@data-4test='" +  this.cvsLocator + "']";
    	}
    	else if ( fspL.startsWith("4TNA!") )
    	{
    		// Find object with label than contains text
    		LogMessage = "Generate '@name' Locator";
    		seperateClassnameAndLocator( fspL.replaceFirst("4TNA!", "" ) );
    		lvsReturn = "//*[contains(@name,'" + this.cvsLocator + "')]";
    	}
    	else if ( fspL.startsWith("4TID!") )
    	{
    		// Find object with label than contains text
    		LogMessage = "Generate '@id' Locator";
    		seperateClassnameAndLocator( fspL.replaceFirst("4TID!", "" ) );
    		lvsReturn = "//*[contains(@id,'" + this.cvsLocator + "')]";
    	}
    	else if ( fspL.startsWith("4TLA!") )
    	{
    		// Find object with label than contains text
    		LogMessage = "Generate 'label' Locator";
    		seperateClassnameAndLocator( fspL.replaceFirst("4TLA!", "" ) );
    		lvsReturn = "//label[contains(text(),'" + this.cvsLocator + "')]/following-sibling::input";
    	}
    	else if ( fspL.startsWith("4TTX!") )
    	{
    		// Find object with label than contains text
    		LogMessage = "Generate 'Contains Text' Locator";
    		seperateClassnameAndLocator( fspL.replaceFirst("4TTX!", "" ) );
    		lvsReturn = "//*[contains(text(),'" + this.cvsLocator + "')]";
    	}

    	// System.out.println(LogMessage);
    	// System.out.println( " - '" + fspL + "' -> '" + lvsReturn + "'");
    	
    	this.cvsLocator = lvsReturn;
    	
    	return lvsReturn;
    }

    /**
     * Trennt den Klassenbezeichner vom Locator ab.
     * 
     * "Myclass::myLocator"
     * "MyLocator" 
     * 
     * @param fpsLocator
     * @return
     */
	public int seperateClassnameAndLocator( String fpsLocator )
	{
		int iReturn = 0;
		
		String[] MySplit = fpsLocator.split("::");
		
		if ( MySplit.length == 1 )
		{
			cvsLocator = MySplit[0];
		}
		
		else if ( MySplit.length == 2 )
		{
			cvsGUIClass= MySplit[0];
			cvsLocator = MySplit[1];
		}
		else
		{
			iReturn = -1;
		}
	
		return iReturn;
	}

	public String getGUIClass() {
		return cvsGUIClass;
	}

	public String getLocator()
	{
		return cvsLocator;
	}
}

