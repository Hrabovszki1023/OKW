package okw.gui;

public abstract class OKWLocatorBase
{
    public OKWLocatorBase( )
    {
    }

/*    public OKWLocatorBase( String fpsLocator, OKWLocatorBase... fpLocators )
    {
      setLocator( fpsLocator, fpLocators );
    }
    */

    /**
     * \~german
     *  Setzt die Locator-Referenz Werte der Quelle auf das aktuelle Objekt.
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~english
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-27
     */
    abstract void setLocator( String fpsLocator, OKWLocatorBase... fpLocators );

    /**
     * \~german
     * Setzt die Locator-Referenz Werte der Quelle auf das aktuelle Objekt.
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~english
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-27
     */
    abstract void setLocators( OKWLocatorBase... fpLocators );
    
    /**
     * \~german
     *  Kopiert/Überträgt alle Locatoren-Werte der Quelle auf das aktuelle Objekt.
     *  
     *  Es werden/sollen sowohl der einzelne String Locator als auch die eingebetteten
     *  Referenzen darauf übertragen.
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~english
     *
     * @param fpLOCATOR Quelle, dessen Werte in das aktuelle Objekt copiert werden soll.
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-06-27
     */
    abstract void copyLocator( OKWLocatorBase fpLOCATOR );
    
    abstract String getLocator();

    abstract String getlocator();
    abstract OKWLocatorBase[] getLocators();
}
