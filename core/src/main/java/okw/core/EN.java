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

/** \~german
 *  okw.core.EN ist die englische Implementation von OKW.
 *  
 *  Diese Klasse bildet ausschliesslich ein Mapping der
 *  englischsprachigen Schlüsselwörter auf die korrespondierende Core-Methoden.<br>
 *  
 *  Alle Schlüsselwort-Methoden dieser Klasse setzten zunächst die Spracheinstellung der Klasse OKW.Core auf "EN"
 *  Danach erfolgt der Aufruf der korrespondierenden Core-Methode.<br>
 *  
 *  UseCase
 *  -------
 *  
 *  @startuml{OKW_UseCase_Keyword_de.png}
 *  :Fachtester: -right-> (Testfall in Schlüsselwortnotation) : erstellt
 *  @enduml
 *  
 *  \section secLoginEN Beispiel: Login
 *  Das folgende Beispiel zeigt die Beschreibung eines Login-Vorganges in Schlüsslewort-Notation.
 *  
 *  \code
 *  EN.SelectWindow("Login")
 *  EN.SetValue("Benutzer", "Zoltan")
 *  EN.SetValue("Passwort", "gEHeim")
 *  EN.ClickOn("Weiter")
 *  \endcode
 *  \~
 *  @author Zoltán Hrabovszki
 *  @date 2013.05.03
 */
public class EN
{

    private static String        Language = "EN";
    private static Core          myKernel = new Core();

    public static void SetKernaleStateNOK()
    {
        myKernel.SetKernaleStateNOK( );
    }
    
    /**
     *  \copydoc IOKW_State::BeginTest(String)
     */
    public static void BeginTest( String Testname ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.BeginTest( Testname );
    }

    /**
     *  \copydoc IOKW_State::ClickOn(String)
     */
    public static void ClickOn( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.ClickOn( FN );
    }

    /**
     *  \copydoc IOKW_State::DoubleClickOn(String)
     */
    public static void DoubleClickOn( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.DoubleClickOn( FN );
    }

    /**
     *  \copydoc IOKW_State::EndTest()
     */
    public static void EndTest() throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.EndTest();
    }

    /**
     *  \copydoc IOKW_State::LogCaption(String)
     */
    public static void LogCaption( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogCaption( FN );
    }

    /**
     *  \copydoc IOKW_State::LogExists(String)
     */
    public static void LogExists( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogExists( FN );
    }

    /**
     *  \copydoc IOKW_State::LogHasFocus(String)
     */
    public static void LogHasFocus( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogHasFocus( FN );
    }

    /**
     *  \copydoc IOKW_State::LogIsActive(String)
     */
    public static void LogIsActive( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogIsActive( FN );
    }

    /**
     *  \copydoc IOKW_State::LogLabel(String)
     */
    public static void LogLabel( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogLabel( FN );
    }

    /**
     *  \copydoc IOKW_State::LogPlaceholder(String)
     */
    public static void LogPlaceholder( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogPlaceholder( FN );
    }

    /**
     *  \copydoc IOKW_State::LogSelected(String)
     */
    public static void LogSelected( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogSelected( FN );
    }

    /**
     *  \copydoc IOKW_State::LogTablecellValue(String,String,String)
     */
    public static void LogTablecellValue( String FN, String COL, String ROW ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogTablecellValue( FN, COL, ROW );
    }

    /**
     *  \copydoc IOKW_State::LogTooltip(String)
     */
    public static void LogTooltip( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogTooltip( FN );
    }

    /**
     *  \copydoc IOKW_State::LogValue(String)
     */
    public static void LogValue( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.LogValue( FN );
    }

    /**
     *  \copydoc IOKW_State::MemorizeCaption(String,String)
     */
    public static void MemorizeCaption( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeCaption( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeExists(String,String)
     */
    public static void MemorizeExists( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeExists( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeHasFocus(String,String)
     */
    public static void MemorizeHasFocus( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeHasFocus( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeIsActive(String,String)
     */
    public static void MemorizeIsActive( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeIsActive( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeLabel(String,String)
     */
    public static void MemorizeLabel( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeLabel( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeLabel(String,String)
     */
    public static void MemorizePlaceholder( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizePlaceholder( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeSelectedValue(String,String)
     */
    public static void MemorizeSelectedValue( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeSelectedValue( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
     */
    public static void MemorizeTablecellValue( String FN, String COL, String ROW, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeTablecellValue( FN, COL, ROW, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeTooltip(String,String)
     */
    public static void MemorizeTooltip( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeTooltip( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::MemorizeValue(String,String)
     */
    public static void MemorizeValue( String FN, String fpsKeyName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.MemorizeValue( FN, fpsKeyName );
    }

    /**
     *  \copydoc IOKW_State::Select(String,String)
     */
    public static void Select( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.Select( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::SelectMenu(String)
     */
    public static void SelectMenu( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SelectMenu( FN );
    }

    /**
     *  \copydoc IOKW_State::SelectMenu(String,String)
     */
    public static void SelectMenu( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SelectMenu( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::SelectTablecell(String,String,String)
     */
    public static void SelectTablecell( String FN, String COL, String ROW ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SelectTablecell( FN, COL, ROW );
    }

    /**
     *  \copydoc IOKW_State::SelectWindow(String)
     */
    public static void SelectWindow( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SelectWindow( FN );
    }

    /**
     *  \copydoc IOKW_State::SelectChild(String)
     */
    public static void SelectChild( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SelectChild( FN );
    }

    /**
     *  \copydoc IOKW_State::Sequence(String,String,String)
     */
    public static void Sequence( String fpsObjectName, String fpsSequenceName, String SEQID ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.Sequence( fpsObjectName, fpsSequenceName, SEQID );
    }

    /**
     *  \copydoc IOKW_State::SetFocus(String)
     */
    public static void SetFocus( String FN ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SetFocus( FN );
    }

    /**
     *  \copydoc IOKW_State::SetValue(String,String)
     */
    public static void SetValue( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.SetValue( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::StartApp(String)
     */
    public static void StartApp( String fpsApplicationName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.StartApp( fpsApplicationName );
    }

    /**
     *  \copydoc IOKW_State::StopApp(String)
     */
    public static void StopApp( String fpsApplicationName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.StopApp( fpsApplicationName );
    }

    /**
     *  \copydoc IOKW_State::TypeKey(String,String)
     */
    public static void TypeKey( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.TypeKey( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
     */
    public static void TypeKeyTablecell( String FN, String COL, String ROW, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.TypeKeyTablecell( FN, COL, ROW, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::TypeKeyWindow(String,String)
     */
    public static void TypeKeyWindow( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.TypeKeyWindow( FN, fpsValue );
    }

    /**
	 *  \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public static void VerifyBadge ( String BN, String ExpVal )throws Exception
	{
	    myKernel.setLanguage( Language );
	    myKernel.VerifyBadge( BN, ExpVal );
	}

	/**
	 *  \copydoc IOKW_State::VerifyBadgeWCM(String,String)
	 */
	public static void VerifyBadgeWCM ( String BN, String ExpVal )throws Exception
	{
	    myKernel.setLanguage( Language );
	    myKernel.VerifyBadgeWCM( BN, ExpVal );
	}

	/**
	 *  \copydoc IOKW_State::VerifyBadgeREGX(String,String)
	 */
	public static void VerifyBadgeREGX ( String BN, String ExpVal )throws Exception
	{
	    myKernel.setLanguage( Language );
	    myKernel.VerifyBadgeREGX( BN, ExpVal );
	}

	/**
     *  \copydoc IOKW_State::VerifyCaption(String,String)
     */
    public static void VerifyCaption( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyCaption( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::VerifyCaption(String,String)
     */
    public static void VerifyCaptionREGX( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyCaptionREGX( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::VerifyCaption(String,String)
     */
    public static void VerifyCaptionWCM( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyCaptionWCM( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::VerifyExists(String,String)
     */
    public static void VerifyExists( String FN, String fpsValue ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyExists( FN, fpsValue );
    }

    /**
     *  \copydoc IOKW_State::VerifyHasFocus(String,String)
     */
    public static void VerifyHasFocus( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyHasFocus( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyIsActive(String,String)
     */
    public static void VerifyIsActive( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyIsActive( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyLabel(String,String)
     */
    public static void VerifyLabel( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyLabel( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyLabelREGX(String,String)
     */
    public static void VerifyLabelREGX( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyLabelREGX( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyLabelWCM(String,String)
     */
    public static void VerifyLabelWCM( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyLabelWCM( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyMaxLength(String,String)
     */
    public static void VerifyMaxLength( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyMaxLength( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyPlaceholder(String,String)
     */
    public static void VerifyPlaceholder( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyPlaceholder( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyPlaceholderREGX(String,String)
     */
    public static void VerifyPlaceholderREGX( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyPlaceholderREGX( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyPlaceholderWCM(String,String)
     */
    public static void VerifyPlaceholderWCM( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyPlaceholderWCM( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValue(String,String)
     */
    public static void VerifySelectedValue( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifySelectedValue( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValueREGX(String,String)
     */
    public static void VerifySelectedValueREGX( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifySelectedValueREGX( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValueWCM(String,String)
     */
    public static void VerifySelectedValueWCM( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifySelectedValueWCM( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
     */
    public static void VerifyTablecellValue( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTablecellValue( FN, COL, ROW, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValueREGX(String,String,String,String)
     */
    public static void VerifyTablecellValueREGX( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTablecellValueREGX( FN, COL, ROW, ExpVal );
    }
    
    /**
     *  \copydoc IOKW_State::VerifyTablecellValueWCM(String,String,String,String)
     */
    public static void VerifyTablecellValueWCM( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTablecellValueWCM( FN, COL, ROW, ExpVal );
    }
    
    /**
     *  \copydoc IOKW_State::VerifyTooltip(String,String)
     */
    public static void VerifyTooltip( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTooltip( FN, ExpVal );
    }

    /**
    *  \copydoc IOKW_State::VerifyTooltipWCM(String,String)
    */
    public static void VerifyTooltipWCM( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTooltipWCM( FN, ExpVal );
    }

    /**
    *  \copydoc IOKW_State::VerifyTooltipREGX(String,String)
    */
    public static void VerifyTooltipREGX( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyTooltipREGX( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyValue(String,String)
     */
    public static void VerifyValue( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyValue( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyValueWCM(String,String)
     */
    public static void VerifyValueWCM( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyValueWCM( FN, ExpVal );
    }

    /**
    *  \copydoc IOKW_State::VerifyValueREGX(String,String)
    */
    public static void VerifyValueREGX( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyValueREGX( FN, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::FileDelete(String)
     */
    public static void FileDelete( String fpsPathAndFileName ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.FileDelete( fpsPathAndFileName ); 
    }
    
    
    /**
     *  \copydoc IOKW_State::VerifyFileExists(String,String)
     */
    public static void VerifyFileExists( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyFileExists( fpsPathAndFileName, ExpVal );
    }

    /**
     *  \copydoc IOKW_State::VerifyDirectoryExists(String,String)
     */
    public static void VerifyDirectoryExists( String fpsPath, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyDirectoryExists( fpsPath, ExpVal );
    }
    
    /**
     *  \copydoc IOKW_State::VerifyMinLength(String,String)
     */
    public static void VerifyMinLength( String FN, String ExpVal ) throws Exception
    {
        myKernel.setLanguage( Language );
        myKernel.VerifyMinLength( FN, ExpVal );
    }
    
}
