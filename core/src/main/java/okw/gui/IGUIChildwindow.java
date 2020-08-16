/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
      www.OpenKeyWord.de
    ============================================================================== 

    This file is part of OpenKeyWord.

    OpenKeyWord is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenKeyWord is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

    Diese Datei ist Teil von OpenKeyWord.

    OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
    der GNU General Public License, wie von der Free Software Foundation,
    Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
    veröffentlichten Version, weiterverbreiten und/oder modifizieren.

    OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
    OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
    Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
    Siehe die GNU General Public License für weitere Details.

    Sie sollten eine Kopie der GNU General Public License zusammen mit 
    OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
*/

package okw.gui;

import java.util.ArrayList;

public interface IGUIChildwindow 
{    
    ArrayList<String> getCaption();
    Boolean getExists();
    Boolean getHasFocus();
    Boolean getIsActive();
    ArrayList<String> getLabel();
    ArrayList<String> getPlaceholder();
    ArrayList<String> getTooltip();
    ArrayList<String> getValue();
    
    Integer getMaxLength();
    
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

    void TypeKeyTablecell( String COL, String ROW, ArrayList<String> Val );
    
    ArrayList<String> VerifyLabel();
    ArrayList<String> VerifyBadge();
    ArrayList<String> VerifyBadgeWCM();
    ArrayList<String> VerifyBadgeREGX();
    ArrayList<String> VerifyPlaceholder();
    ArrayList<String> VerifyCaption();
    ArrayList<String> VerifyTooltip();
    ArrayList<String> VerifyValue();
    ArrayList<String> VerifySelectedValue();
    ArrayList<String> VerifyTablecellValue(String COL, String ROW);
    ArrayList<String> VerifyErrorMSG();
    
    Boolean VerifyExists();
    Boolean VerifyIsActive();
    Boolean VerifyHasFocus();

    Integer VerifyMaxLength();
    Integer VerifyMinLength();
}