package okw.gui;
 
import java.util.ArrayList;
 
public interface IGUIChildwindow 
{
        ArrayList<String> getCaption() throws Exception;
        Boolean getExists();
        Boolean getHasFocus() throws Exception;
        Boolean getIsActive() throws Exception;
        ArrayList<String> getLabel() throws Exception;
        ArrayList<String> getTooltip() throws Exception;
        ArrayList<String> getValue() throws Exception;       
}