package okw.gui;

import okw.fourTestLocator;

public class OKWLocatorXPath extends OKWLocator
{
 
    public OKWLocatorXPath( )
    {
        super(  ) ;
    }
    
    public OKWLocatorXPath( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        super( fpsLocator, fpLocators ) ;
    }
    

    /** 
     * \~german
     *  Konstruktor der Klasse. iframeID wird auf den Wert "" (empty string) gesetzt.
     *  
     *  @note
     *  <code> fpsLocator = "//div[@ID='myID']"</code> -> <code>"//div[@ID='myID']"</code>
     *  <code> fpsLocator = "4T!MyValue"</code> -> <code>"//*[@data-4Test='MyValue']"</code>
     *  <code> fpsLocator = "4TNA!MyValue"</code> -> <code>"//*[contains( @name, 'MyValue']"</code>
     *  <code> fpsLocator = "4TID!MyValue"</code> -> <code>"//*[contains( @ID, 'MyValue']"</code>
     *  <code> fpsLocator = "4TLA!MyValue"</code> -> <code>"//label[contains(text(),'MyValue')]/following-sibling::input"</code>
     *  <code> fpsLocator = "4TTX!MyValue"</code> -> <code>"//*[contains(text(),'MyValue')]"</code>
     *  
     *  @param Locator definiert die Objekterkennungseigenschaft des Objektes. Dieser wird als XPATH angegeben
     *  @param Locators Locatoren z.B. von Elternobjekten, die zu einem gesamt Locator verkettet werden sollen.
     *  
     *  \~english
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2019.03.28
     */
     @Override
     public void setLocator( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        fourTestLocator fourTestLocator = new fourTestLocator( fpsLocator );


         String myLocator = fourTestLocator.getLocator();
         
         // Enthält xpath oder ein 4Test-Präfix?
         if ( fpsLocator.equals( myLocator ) )
         {
             // Ja es ist ein normaler XPath
             if ( fpLocators != null && fpLocators.length > 0 )
             {
                 super.setLocator( myLocator, fpLocators );
             }
             else
             {
                 super.setLocator( myLocator );
             }
         }
         else
         {
             if ( fpLocators != null && fpLocators.length > 0 )
             {
                 super.setLocator( "$L1$" + myLocator, fpLocators );
             }
             else
             {
                 super.setLocator( myLocator );
             }
         }
     }

}
