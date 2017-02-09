package okw.gui;
 
import java.util.ArrayList;
 
public interface IGUIChildwindow 
{
        ArrayList<String> getCaption();
        Boolean getExists();
        Boolean getHasFocus();
        Boolean getIsActive();
        ArrayList<String> getLabel();
        ArrayList<String> getTooltip();
        ArrayList<String> getValue() throws Exception;       
}