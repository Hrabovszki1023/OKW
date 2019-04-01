package okw.gui;

public abstract class OKWLocatorBase
{
    public OKWLocatorBase( )
    {
    }

    public OKWLocatorBase( String fpsLocator, OKWLocatorBase... fpLocators )
    {
      setLocator( fpsLocator, fpLocators );
    }

    abstract void setLocator( String fpsLocator, OKWLocatorBase... fpLocators );
    abstract String getLocator();
}
