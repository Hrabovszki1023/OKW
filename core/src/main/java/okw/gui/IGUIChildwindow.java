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
    ArrayList<String> getValue();
    
    void ClickOn( );
    void DoubleClickOn( );
    
    ArrayList<String> LogCaption( );
    boolean LogExists( );
    boolean LogHasFocus( );
    boolean LogIsActive( );
    ArrayList<String> LogLabel( );
    ArrayList<String> LogPlaceholder( );
    ArrayList<String> LogSelected( );
    ArrayList<String> LogTablecellValue( String COL, String ROW );
    ArrayList<String> LogTooltip( );
    ArrayList<String> LogValue( );
    
    ArrayList<String> MemorizeCaption( );
    boolean MemorizeExists( );
    boolean MemorizeHasFocus( );
    boolean MemorizeIsActive( );
    ArrayList<String> MemorizeLabel( );
    ArrayList<String> MemorizePlaceholder( );
    ArrayList<String> MemorizeSelectedValue( );
    ArrayList<String> MemorizeTablecellValue( String COL, String ROW );
    ArrayList<String> MemorizeTooltip( );
    ArrayList<String> MemorizeValue( );

    void Select( ArrayList<String> Val );
    void SelectMenu( ) throws Exception;
    void SelectMenu( ArrayList<String> Val );
    void SelectTablecell( String COL, String ROW );

    void SetFocus() throws Exception;
    void SetValue( ArrayList<String> Val );
    void TypeKey( ArrayList<String> Val );

    ArrayList<String> VerifyLabel();
    ArrayList<String> VerifyPlaceholder();
    ArrayList<String> VerifyCaption();
    ArrayList<String> VerifyTooltip();
    ArrayList<String> VerifyValue();
    ArrayList<String> VerifySelectedValue();
    ArrayList<String> VerifyTablecellValue(String COL, String ROW);

    Boolean VerifyExists();
    Boolean VerifyIsActive();
    Boolean VerifyHasFocus();
}