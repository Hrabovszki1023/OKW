package okw.gui.adapter.selenium.material8;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import okw.gui.OKWLocatorBase;
import okw.gui.adapter.selenium.SeInputCheckbox;



public class mat_checkbox extends SeInputCheckbox {

	public mat_checkbox(String Locator, OKWLocatorBase... Locators)
	{
		super(Locator, Locators);
		// TODO Auto-generated constructor stub
	}

    
    /**
     *  \~
     *  @author Zoltan Hrabovszki
     * @date 2020-02-15
     */
    public Boolean getIsSelected()
    {
        Boolean lvbReturn = false;
        
        try
        {
            LogFunctionStartDebug("getIsSelected");

            // Hole Zusand: "Häkschen" oder kein "Häkschen", das ist hier die Frage...
            // Wir suchen <input>-tag. Davon gib es nur ein tag innerhalb von mat-checkbox.
            
            WebElement myCheckbox = this.Me().findElement(By.xpath( "//input" ));
            lvbReturn = myCheckbox.isSelected();
            
            lvbReturn = this.Me().getAttribute("class").contains("mat-checkbox-checked");
            
        }
        finally
        {
            LogFunctionEndDebug(lvbReturn);
        }
        return lvbReturn;
    }

    
    
    /** \~german
     *  Das ist die angepasste mat_chekcbox GUI-Adapter Methode, die durch das Schlüsselwort \ref refClickOn aufgerufen wird.
     *  
     *  Diese Methode:
     *  
     *  -# Wartet zunächst bis das Objekt existiert.
     *  -# Klickt dann auf das aktuelle Objekt.
     *  
     *  \note Diese methode ist an mat-checkbox angepasst: Das eigentliche <input type='checkbox'> Checkbox ist verdeckt und
     *  durch die Angular Material Klasse <mat-checkbox> animiert. Das Klicken wir nicht direkt auf dem <input type='checkbox'> augeführt.
     *  
     *  Daher muss die Methode ClickOn() angepasst werden: Wir Klicken nun auf das Label im mat-checkbox.
     *   
     *  
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2020-02-16
     */
    public void ClickOn()
    {
        try
        {
            this.LogFunctionStartDebug( "ClickOn" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // Wir suchen den <label>-tag innerhalb von mat-checkbox .
            WebElement myClickElement = this.Me().findElement(By.xpath( "//div[@class='mat-checkbox-inner-container']" ));
            myClickElement.click();

        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

}
