package okw.gui.adapter.selenium;

import okw.gui.OKWLocatorBase;

public class SeAriaRadio extends SeRadio
{
	public SeAriaRadio( String Locator, OKWLocatorBase... Locators )
	{
		super(Locator, Locators);
	}

	@Override
	public Boolean getIsSelected() {
		Boolean lvbReturn = false;

		try
		{
			LogFunctionStartDebug("getIsSelected");

			lvbReturn = this.WaitForInteractionReturnBoolean( () -> { return this.Me().getAttribute("aria-checked").equalsIgnoreCase("true"); } );

		}
		finally
		{
			LogFunctionEndDebug(lvbReturn);
		}
		return lvbReturn;
	}
}
