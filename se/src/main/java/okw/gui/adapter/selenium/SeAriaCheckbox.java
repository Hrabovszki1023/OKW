package okw.gui.adapter.selenium;

import okw.gui.OKWLocatorBase;

public class SeAriaCheckbox extends SeCheckbox
{
	public SeAriaCheckbox( String Locator, OKWLocatorBase... Locators ) {
		super(Locator, Locators);
	}

	@Override
	public Boolean getIsSelected()
	{
		Boolean lvbReturn = false;

		lvbReturn = this.WaitForInteractionReturnBoolean( () -> { return this.Me().getAttribute("aria-checked").equalsIgnoreCase("true"); } );

		return lvbReturn;
	}
}
