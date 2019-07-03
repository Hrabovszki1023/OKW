/*
    ==============================================================================
    Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.core;

import okw.log.Logger_Sngltn;
import okw.*;

/** \~german
 *  Hier Statediagram...
 *  @startuml{OKW_State.png}
 *  [*] --> OK : Execute Test
 *  OK --> NOK : OKW_Exception
 *  NOK --> OK: BeginTest
 *  OK --> OK: OKW-Keyword
 *  OK --> [*]
 *  NOK --> [*]
 *  @enduml
 *  
 *  @startuml{OKW_StateClass.png}
 *  class Core
 *  interface IOKW_State
 *  class OK
 *  class NOK
 *   
 *  Core o-- IOKW_State: CurrentState
 *  OK --> Core: core
 *  NOK --> Core: core
 *  IOKW_State <|.. OK
 *  IOKW_State <|.. NOK
 * @enduml
 * 
 *  # Quellen/Links
 * [State-Pattern](https://www.philipphauer.de/study/se/design-pattern/state.php)
 * 
 *  \~english
 *  
 *  \~
 *  @author Zoltán Hrabovszki
 *  @date 2014-01-09
 */
public class Core implements IOKW_State
{

    private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

    /** \~german
     * zeigt auf die Klasse des aktuellen Zustandes.
     *  \~english
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014-01-09
     */
    private IOKW_State           CurrentState;

    public void SetKernaleStateNOK( )
    {
        this.SetCurrentState( new NOK( this ) );
    }
    
    
    /**
     *  \copydoc LogMessenger
     */
    private static LogMessenger  LM;

    /** \~german
     * OKW-Konstuktor: Setzt den Default-Zustand auf OKW.OK.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014.01.09
     */
    public Core()
    {
        try
        {
            Init();

            this.SetCurrentState( new OK( this ) );
        }
        catch (Exception e)
        {
            OKW_HandleException.StopRunning( e, this.getClass() );
        }
    }

    @SuppressWarnings( "unused" )
    public static void Init()
    {
        try
        {
            // Init all Singelton...
            Logger_Sngltn Log = Logger_Sngltn.getInstance();

            OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();

            OKW_Const_Sngltn myOKW_Const = OKW_Const_Sngltn.getInstance();
            OKWLanguage CL = OKWLanguage.getInstance();
            OKW_Memorize_Sngltn myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();

            FrameObjectDictionary_Sngltn myFrameObjectDictionary = FrameObjectDictionary_Sngltn.getInstance();

            OKW_CurrentObject_Sngltn myCurrentObject = OKW_CurrentObject_Sngltn.getInstance();
            LM = new LogMessenger( "Core" );
        }
        catch (Exception e)
        {
            OKW_HandleException.StopRunning( e, Core.class );
        }
    }

    /** 
     * \copydoc IOKW_State::BeginTest(String)
     */
    public void BeginTest( String Testname ) throws Exception
    {
        Log.LogTestcaseStart( Testname );
        this.CurrentState.BeginTest( Testname );
    }

    /**
     *   \copydoc IOKW_State::ClickOn(String)
     */
    public void ClickOn( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "ClickOn", "KeyWordName" ), FN );
            this.CurrentState.ClickOn( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::DoubleClickOn(String)
     */
    public void DoubleClickOn( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "DoubleClickOn", "KeyWordName" ), FN );
            this.CurrentState.DoubleClickOn( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::EndTest()
     */
    public void EndTest() throws Exception
    {
        try
        {
            // Keine Schlüsselwort-Ausgabe! Das ist richtig! Hier wird _Test_ Geschlossen
            this.CurrentState.EndTest();
        }
        finally
        {
            Log.LogTestcaseEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogExists(String)
     */
    public void LogExists( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogExists", "KeyWordName" ), FN );
            this.CurrentState.LogExists( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogHasFocus(String)
     */
    public void LogHasFocus( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogHasFocus", "KeyWordName" ), FN );
            this.CurrentState.LogHasFocus( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogIsActive(String)
     */
    public void LogIsActive( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogIsActive", "KeyWordName" ), FN );
            this.CurrentState.LogIsActive( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogSelected(String)
     */
    public void LogSelected( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogSelected", "KeyWordName" ), FN );
            this.CurrentState.LogSelected( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogTablecellValue(String,String,String)
     */
    public void LogTablecellValue( String FN, String COL, String ROW ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogTablecellValue", "KeyWordName" ), FN, COL, ROW );
            this.CurrentState.LogTablecellValue( FN, COL, ROW );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogTooltip(String)
     */
    public void LogTooltip( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogTooltip", "KeyWordName" ), FN );
            this.CurrentState.LogTooltip( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogCaption(String)
     */
    public void LogCaption( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogCaption", "KeyWordName" ), FN );
            this.CurrentState.LogCaption( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogLabel(String)
     */
    public void LogLabel( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogLabel", "KeyWordName" ), FN );
            this.CurrentState.LogLabel( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogPlaceholder(String)
     */
    public void LogPlaceholder( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogPlaceholder", "KeyWordName" ), FN );
            this.CurrentState.LogPlaceholder( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::LogValue(String)
     */
    public void LogValue( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "LogValue", "KeyWordName" ), FN );
            this.CurrentState.LogValue( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeExists(String,String)
     */
    public void MemorizeExists( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeExists", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeExists( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeHasFocus(String,String)
     */
    public void MemorizeHasFocus( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeHasFocus", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeHasFocus( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeIsActive(String,String)
     */
    public void MemorizeIsActive( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeIsActive", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeIsActive( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeSelectedValue(String,String)
     */
    public void MemorizeSelectedValue( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeSelectedValue", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeSelectedValue( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
     */
    public void MemorizeTablecellValue( String FN, String COL, String ROW, String fpsKeyName ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeTablecellValue", "KeyWordName" ), FN, COL, ROW, fpsKeyName );
            this.CurrentState.MemorizeTablecellValue( FN, COL, ROW, fpsKeyName );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeTooltip(String,String)
     */
    public void MemorizeTooltip( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeTooltip", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeTooltip( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeLabel(String,String)
     */
    public void MemorizeLabel( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeLabel", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeLabel( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizePlaceholder(String,String)
     */
    public void MemorizePlaceholder( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizePlaceholder", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizePlaceholder( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeCaption(String,String)
     */
    public void MemorizeCaption( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeCaption", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeCaption( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeValue(String,String)
     */
    public void MemorizeValue( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "MemorizeValue", "KeyWordName" ), FN, Val );
            this.CurrentState.MemorizeValue( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::Select(String,String)
     */
    public void Select( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "Select", "KeyWordName" ), FN, Val );
            this.CurrentState.Select( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectMenu(String)
     */
    public void SelectMenu( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SelectMenu", "KeyWordName" ), FN );
            this.CurrentState.SelectMenu( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectMenu(String,String)
     */
    public void SelectMenu( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SelectMenu", "KeyWordName" ), FN, Val );
            this.CurrentState.SelectMenu( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectTablecell(String,String,String)
     */
    public void SelectTablecell( String FN, String COL, String ROW ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SelectTablecell", "KeyWordName" ), FN, COL, ROW );
            this.CurrentState.SelectTablecell( FN, COL, ROW );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::SelectWindow(String)
     */
    public void SelectWindow( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SelectWindow", "KeyWordName" ), FN );
            this.CurrentState.SelectWindow( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::SelectChild(String)
     */
    public void SelectChild( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SelectChild", "KeyWordName" ), FN );
            this.CurrentState.SelectChild( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    
    /**
     * \copydoc IOKW_State::Sequence(String,String,String)
     */
    public void Sequence( String FN, String fpsSequenName, String SEQID ) throws Exception
    {
        try
        {
            Log.LogSequenceStart( LM.GetMessage( "Sequence", "KeyWordName" ), FN, fpsSequenName, SEQID);
            this.CurrentState.Sequence( FN, fpsSequenName, SEQID );
        }
        finally
        {
            Log.LogSequenceEnd();
        }
    }

    /**
     * \~german 
     * Setter zum Setzen des aktuellen Zustandes.
     * 
     * \~english 
     * 
     * \~ 
     * @author Zoltán Hrabovszki
     * @date 2014.01.09
     */
    public void SetCurrentState( IOKW_State fp_CurrentState )
    {
        this.CurrentState = fp_CurrentState;
    }

    /**
     * \copydoc IOKW_State::SetFocus(String)
     */
    public void SetFocus( String FN ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SetFocus", "KeyWordName" ), FN );
            this.CurrentState.SetFocus( FN );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \~german
     *  Setzt die Sprache auf den gegebenen wert Language.
     *
     *  \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014.01.09
     */
    public void setLanguage( String Language )
    {
        this.CurrentState.setLanguage( Language );
    }

    /**
     * \copydoc IOKW_State::SetValue(String,String)
     */
    public void SetValue( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "SetValue", "KeyWordName" ), FN, Val );
            this.CurrentState.SetValue( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::StartApp(String)
     */
    public void StartApp( String fpsApplicationName ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "StartApp", "KeyWordName" ), fpsApplicationName );
            this.CurrentState.StartApp( fpsApplicationName );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::StopApp(String)
     */
    public void StopApp( String fpsApplicationName ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "StopApp", "KeyWordName" ), fpsApplicationName );
            this.CurrentState.StopApp( fpsApplicationName );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKey(String,String)
     */
    public void TypeKey( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "TypeKey", "KeyWordName" ), FN, Val );
            this.CurrentState.TypeKey( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
     */
    public void TypeKeyTablecell( String FN, String COL, String ROW, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "TypeKeyTablecell", "KeyWordName" ), FN, COL, ROW, Val );
            this.CurrentState.TypeKeyTablecell( FN, COL, ROW, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKeyWindow(String,String)
     */
    public void TypeKeyWindow( String FN, String Val ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "TypeKeyWindow", "KeyWordName" ), FN, Val );
            this.CurrentState.TypeKeyWindow( FN, Val );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
	 *  \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public void VerifyBadge( String BN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyBadge", "KeyWordName" ), BN, ExpVal );
	        this.CurrentState.VerifyBadge( BN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
	 *  \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public void VerifyBadgeWCM( String BN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyBadgeWCM", "KeyWordName" ), BN, ExpVal );
	        this.CurrentState.VerifyBadgeWCM( BN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
	 *  \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public void VerifyBadgeREGX( String BN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyBadgeREGX", "KeyWordName" ), BN, ExpVal );
	        this.CurrentState.VerifyBadgeREGX( BN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
	 * \copydoc IOKW_State::VerifyCaption(String,String)
	 */
	public void VerifyCaption( String FN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyCaption", "KeyWordName" ), FN, ExpVal );
	        this.CurrentState.VerifyCaption( FN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
	 * \copydoc IOKW_State::VerifyCaptionWCM(String,String)
	 */
	public void VerifyCaptionWCM( String FN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyCaptionWCM", "KeyWordName" ), FN, ExpVal );
	        this.CurrentState.VerifyCaptionWCM( FN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
	 * \copydoc IOKW_State::VerifyCaptionREGX(String,String)
	 */
	public void VerifyCaptionREGX( String FN, String ExpVal ) throws Exception
	{
	    try
	    {
	        Log.LogKeyWordStart( LM.GetMessage( "VerifyCaptionREGX", "KeyWordName" ), FN, ExpVal );
	        this.CurrentState.VerifyCaptionREGX( FN, ExpVal );
	    }
	    finally
	    {
	        Log.LogKeyWordEnd();
	    }
	}

	/**
     *  \copydoc IOKW_State::VerifyExists(String,String)
     */
    public void VerifyExists( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyExists", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyExists( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyHasFocus(String,String)
     */
    public void VerifyHasFocus( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyHasFocus", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyHasFocus( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyIsActive(String,String)
     */
    public void VerifyIsActive( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyIsActive", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyIsActive( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValue(String,String)
     */
    public void VerifySelectedValue( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifySelectedValue", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifySelectedValue( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValueWCM(String,String)
     */
    public void VerifySelectedValueWCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifySelectedValueWCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifySelectedValueWCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValue(String,String)
     */
    public void VerifySelectedValueREGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifySelectedValueREGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifySelectedValueREGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
     */
    public void VerifyTablecellValue( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTablecellValue", "KeyWordName" ), FN, COL, ROW, ExpVal );
            this.CurrentState.VerifyTablecellValue( FN, COL, ROW, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValueWCM(String,String,String,String)
     */
    public void VerifyTablecellValueWCM( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTablecellValue", "KeyWordName" ), FN, COL, ROW, ExpVal );
            this.CurrentState.VerifyTablecellValueWCM( FN, COL, ROW, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValueREGX(String,String,String,String)
     */
    public void VerifyTablecellValueREGX( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTablecellValue", "KeyWordName" ), FN, COL, ROW, ExpVal );
            this.CurrentState.VerifyTablecellValueREGX( FN, COL, ROW, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTooltip(String,String)
     */
    public void VerifyTooltip( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTooltip", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyTooltip( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTooltipREGX(String,String)
     */
    public void VerifyTooltipREGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTooltipREGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyTooltipREGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyTooltipWCM(String,String)
     */
    public void VerifyTooltipWCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyTooltipWCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyTooltipWCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }


    /**
     *  \copydoc IOKW_State::VerifyLabel(String,String)
     */
    public void VerifyLabel( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyLabel", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyLabel( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyLabelWCM(String,String)
     */
    public void VerifyLabelWCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyLabelWCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyLabelWCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }


    /**
     * \copydoc IOKW_State::VerifyMaxLength(String,String)
     */
    public void VerifyMaxLength( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyMaxLength", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyMaxLength( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    
    /**
     * \copydoc IOKW_State::VerifyLabelREGX(String,String)
     */
    public void VerifyLabelREGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyLabelREGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyLabelREGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyPlaceholder(String,String)
     */
    public void VerifyPlaceholder( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyPlaceholder", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyPlaceholder( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyPlaceholderWCM(String,String)
     */
    public void VerifyPlaceholderWCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyPlaceholderWCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyPlaceholderWCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyPlaceholderREGX(String,String)
     */
    public void VerifyPlaceholderREGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyPlaceholderREGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyPlaceholderREGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }
    
    
    /**
     *  \copydoc IOKW_State::VerifyValue(String,String)
     */
    public void VerifyValue( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyValue", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyValue( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyValueREGX(String,String)
     */
    public void VerifyValueREGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyValueREGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyValueREGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyValueWCM(String,String)
     */
    public void VerifyValueWCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyValueWCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyValueWCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::FileDelete(String)
     */
    public void FileDelete( String fpsPathAndFileName ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "FileDelete", "KeyWordName" ), fpsPathAndFileName );
            this.CurrentState.FileDelete( fpsPathAndFileName );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyFileExists(String,String)
     */
    public void VerifyFileExists( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyFileExists", "KeyWordName" ), fpsPathAndFileName, ExpVal );
            this.CurrentState.VerifyFileExists( fpsPathAndFileName, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyDirectoryExists(String,String)
     */
    public void VerifyDirectoryExists( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyDirectoryExists", "KeyWordName" ), fpsPathAndFileName, ExpVal );
            this.CurrentState.VerifyDirectoryExists( fpsPathAndFileName, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     *  \copydoc IOKW_State::CopyFile(String,String)
     */
    public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "FileCopy", "KeyWordName" ), fpsSourcePathAndFileName, fpsDestinationPathAndFileName );
            this.CurrentState.CopyFile( fpsSourcePathAndFileName, fpsDestinationPathAndFileName );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }
    
    /**
     * \copydoc IOKW_State::VerifyMinLength(String,String)
     */
    public void VerifyMinLength( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyMinLength", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyMinLength( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }
    
    /**
     *  \copydoc IOKW_State::VerifyErrorMSG(String,String)
     */
    public void VerifyErrorMSG( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyErrorMSG", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyErrorMSG( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyErrorMSG_WCM(String,String)
     */
    public void VerifyErrorMSG_WCM( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyErrorMSG_WCM", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyErrorMSG_WCM( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }
    /**
     * \copydoc IOKW_State::VerifyErrorMSG_REGX(String,String)
     */
    public void VerifyErrorMSG_REGX( String FN, String ExpVal ) throws Exception
    {
        try
        {
            Log.LogKeyWordStart( LM.GetMessage( "VerifyErrorMSG_REGX", "KeyWordName" ), FN, ExpVal );
            this.CurrentState.VerifyErrorMSG_REGX( FN, ExpVal );
        }
        finally
        {
            Log.LogKeyWordEnd();
        }
    }

}
