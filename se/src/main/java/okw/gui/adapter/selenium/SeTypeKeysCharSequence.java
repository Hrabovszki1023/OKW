package okw.gui.adapter.selenium;

import java.util.*;

import org.openqa.selenium.Keys;

public class SeTypeKeysCharSequence
{

    /**
     * @param isALT the isALT to set
     */
    public void setALT( )
    {
        value.add( Keys.ALT );
    }


    /**
     * @param isCTRL the isCTRL to set
     */
    public void setCTRL( )
    {
        value.add( Keys.CONTROL );
    }


    /**
     */
    public void setSHIFT( )
    {
        value.add( Keys.SHIFT );
    }

    public void setCOMMAND( )
    {
        value.add( Keys.COMMAND );
    }


    private String charSequence = new String();
    
    ArrayList<CharSequence> value = new ArrayList<CharSequence>();

    public SeTypeKeysCharSequence()
    {
        reset();
    }

    public void reset()
    {
        value.clear();
        
        return;
    }
    
    public void setText( String Text )
    {
        value.add( Text );
    }

    public String getCharSequenze()
    {
        charSequence = Keys.chord( value );
        return charSequence;
    }


    public void setKeyvalue( String lvsReturn )
    {
            value.add( Keys.valueOf( lvsReturn ) );
            return;
    }
}
