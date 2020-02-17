package okw.gui.adapter.selenium.material8;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import okw.gui.OKWLocatorBase;
import okw.gui.adapter.selenium.SeButton;

public class mat_button extends SeButton {

	public mat_button(String Locator, OKWLocatorBase... Locators)
	{
		super(Locator, Locators);

	}

	@Override
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
            WebElement myClickElement = this.Me().findElement(By.xpath( "//span[@class='mat-button-wrapper']" ));

            myClickElement.click();
            
            this.getCaption();
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }
	
	@Override
    /** \~german
     *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
     *   
     *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2020-02-16
     */
   public ArrayList<String> getCaption()
   {
       ArrayList<String> lvLsReturn = new ArrayList<String>();

       try
       {
           this.LogFunctionStartDebug( "getCaption" );

           // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
           this.WaitForMe();

           // The Attribute "textContent" wird als Beschriftung angezeigt...
           // Wir suchen den <label>-tag innerhalb von mat-checkbox .
           WebElement myElement = this.Me().findElement(By.xpath( "//span[@class='mat-button-wrapper']" ));
           
           String myCaption = myElement.getAttribute( "textContent" );;

           myCaption = StringUtils.normalizeSpace( myCaption );
           
           lvLsReturn.add( myCaption );
       }
       finally
       {
           this.LogFunctionEndDebug( lvLsReturn );
       }
       return lvLsReturn;
   }
}
