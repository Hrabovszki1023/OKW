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
     * Erzeugt einen locator aus dem gegebenen Wert, wenn fspL mit "4T!", "4T:" oder "4T?" anfängt, sonst wird fspL unverändert zuräckgegeben.
     * 
     * @note
     *  1. <code> fpsL = "//div[@ID='myID']"</code> -> <code>return = "//div[@ID='myID']"</code> - ohne "4T*!"- Präfix wird die XPath.Angabe unverändert durchgelassen
     *  2. <code> fpsL = "4T!MyValue"</code> -> <code>return = "//*[@data-4Test='MyValue']"</code> - Locator mit dem Attribute "data-4Test" wird erzeugt.
     *  3. <code> fpsL = "4TNA!MyValue"</code> -> <code>return = "//*[contains( @name, 'MyValue']"</code>  - Locator mit dem Attribute "name" wird erzeugt.
     *  4. <code> fpsL = "4TAI!MyValue"</code> -> <code>return = "//*[contains( @AutomationID, 'MyValue']"</code> - Locator mit dem Attribute "AutomationID" wird erzeugt.
     *  5. <code> fpsL = "4TID!MyValue"</code> -> <code>return = "//*[contains( @ID, 'MyValue']"</code> - Locator mit dem Attribute "ID" wird erzeugt.
     *  6. <code> fpsL = "4TLA!MyValue"</code> -> <code>return = "//label[contains(text(),'MyValue')]/following-sibling::input"</code>
     *  7. <code> fpsL = "4TTX!MyValue"</code> -> <code>return = "//*[contains(text(),'MyValue')]"</code> - Locator Tag mit dem gegebene Text wird erzeugt.
     *  
     * @param fspL Locator Parameter
     * @return Erzeugter data-4Test Locator oder unveränderter fpsL-Wert.
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
        else if ( fspL.startsWith("4TAI!") )
        {
            // Find object with label than contains text
            LogMessage = "Generate '@AutomationID' Locator";
            seperateClassnameAndLocator( fspL.replaceFirst("4TAI!", "" ) );
            lvsReturn = "//*[@AutomationID='" +  this.cvsLocator + "']";
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

