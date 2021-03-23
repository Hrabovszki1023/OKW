/*
    ==============================================================================
    Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.OKWLanguage;
import okw.OKW_Ini_Sngltn;
import okw.OKW_Memorize_Sngltn;
import okw.log.*;

/** \~german
 *  Klasse NOK representiert den Core Zustand __NOK__ im Ausführungs-Modus.
 * 
 *  Testausführung mit GUI-Aktivität und es ist eine Exception ausgelöst worden.
 * 
 *  \~english
 *  \~
 *  @author Zoltán Hrabovszki
 *  \date 2013.03.02
 */
public class NOK implements IOKW_State
{

	private OKWLanguage   AL = OKWLanguage.getInstance();

	private Logger_Sngltn Log;

	private Core          _Kernel;

	/** \~german
	 *  Diese Klasser repräsentiert den Zustand "Not OK".
	 *  
	 *  Wenn ein Schlüsselwort eine Ausnahme auslöst, dann wechselt der Zustand von OK nach NOK.
	 *  Die Schlüsselwörter dieser Klassen führen, bis auf einge ausnahmen, kein GUI aktivitäten aus.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 02.03.2013
	 */
	public NOK( Core fp_OKW )
	{
		Log = Logger_Sngltn.getInstance();
		this._Kernel = fp_OKW;
	}

	/**
	 *  \copydoc IOKW_State::BeginTest(String)
	 */
	public void BeginTest( String fpsTestname )
	{
		try
		{
			// Alles Initialisieren
			OKW_Ini_Sngltn.getInstance().Init();

			OKW_CurrentObject_Sngltn.getInstance();
			OKW_CurrentObject_Sngltn.init();

			// Memorize TestCaseName
			OKW_Memorize_Sngltn.getInstance().set( "TCN", fpsTestname );

			Log.LogPrint( "NOK -> OK" );
			this._Kernel.SetCoreStateOK();
		}
		catch (XPathExpressionException | JAXBException | ParserConfigurationException | SAXException | IOException e)
		{
			throw new RuntimeException( e );
		}
	}

	/**
	 *  \copydoc IOKW_State::EndTest()
	 * @throws Exception 
	 */
	public void EndTest() throws Exception
	{
		Exception e = _Kernel.getNOK_Reason();

		throw e;
	}

	/**
	 *  \copydoc IOKW_State::ClickOn(String)
	 */
	public void ClickOn( String FN )
	{
	}

	/**
	 * \copydoc IOKW_State::DoubleClickOn(String)
	 */
	public void DoubleClickOn( String FN )
	{
	}

	/**
    /// \copydoc IOKW_State::HasValue(String,String)
	 */
	public Boolean HasValue( String CAT, String ExpVal )
	{
		return false;
	}
	
	/**
	 *  \copydoc IOKW_State::LogCaption(String)
	 */
	public void LogCaption( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogExists(String)
	 */
	public void LogExists( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogHasFocus(String)
	 */
	public void LogHasFocus( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogIsActive(String)
	 */
	public void LogIsActive( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogLabel(String)
	 */
	public void LogLabel( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogPlaceholder(String)
	 */
	public void LogPlaceholder( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogSelected(String)
	 */
	public void LogSelected( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogTablecellValue(String,String,String)
	 */
	public void LogTablecellValue( String FN, String COL, String ROW )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogTooltip(String)
	 */
	public void LogTooltip( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::LogValue(String)
	 */
	public void LogValue( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeCaption(String,String)
	 */
	public void MemorizeCaption( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeExists(String,String)
	 */
	public void MemorizeExists( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeHasFocus(String,String)
	 */
	public void MemorizeHasFocus( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeIsActive(String,String)
	 */
	public void MemorizeIsActive( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeLabel(String,String)
	 */
	public void MemorizeLabel( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizePlaceholder(String,String)
	 */
	public void MemorizePlaceholder( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeSelectedValue(String,String)
	 */
	public void MemorizeSelectedValue( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String)
	 */
	public void MemorizeTablecellValue( String FN, String COL, String ROW, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeTooltip(String,String)
	 */
	public void MemorizeTooltip( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::MemorizeLabel(String,String)
	 */
	public void MemorizeValue( String FN, String fpsMemKeyName )
	{
	}

	/**
	 *  \copydoc IOKW_State::Select(String,String)
	 */
	public void Select( String FN, String fpsValue )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectMenu(String)
	 */
	public void SelectMenu( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectMenu(String,String)
	 */
	public void SelectMenu( String FN, String fpsValue )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectTablecell(String,String,String)
	 */
	public void SelectTablecell( String FN, String COL, String ROW )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectWindow(String)
	 */
	public void SelectWindow( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectContext(String)
	 */
	public void SelectContext( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::SelectChild(String)
	 */
	public void SelectChild( String FN )
	{
	}

	/**
	 *  \copydoc IOKW_State::Sequence(String,String,String)
	 */
	public void Sequence( String FN, String SeqName, String SEQ_ID )
	{
	}

	/**
	 *  \copydoc IOKW_State::SetFocus(String)
	 */
	public void SetFocus( String FN )
	{
	}

	/** \~german
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 02.03.2013
	 */ 
	public void setLanguage( String Language )
	{
		this.AL.setLanguage( Language );
	}

	/**
	 *  \copydoc IOKW_State::SetValue(String,String)
	 */
	public void SetValue( String FN, String Val )
	{
	}

	/**
	 *  \copydoc IOKW_State::SetVar(String,String)
	 */
	public void SetVar( String VN, String Val )
	{
	}

	/**
	 *  \copydoc IOKW_State::StartApp(String)
	 */
	public void StartApp( String fpsApplicationName )
	{
	}

	/**
	 *  \copydoc IOKW_State::StopApp(String)
	 */
	public void StopApp( String fpsApplicationName )
	{
	}

	/**
	 *  \copydoc IOKW_State::TypeKey(String,String)
	 */
	public void TypeKey( String FN, String fpsValue )
	{
	}

	/**
	 *  \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
	 */
	public void TypeKeyTablecell( String FN, String COL, String ROW, String fpsValue )
	{
	}

	/**
	 *  \copydoc IOKW_State::TypeKeyWindow(String,String)
	 */
	public void TypeKeyWindow( String FN, String fpsValue )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public void VerifyBadge ( String BN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyBadgeWCM(String,String)
	 */
	public void VerifyBadgeWCM( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyBadgeREGX(String,String)
	 */
	public void VerifyBadgeREGX( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyCaption(String,String)
	 */
	public void VerifyCaption( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyCaptionWCM(String,String)
	 */
	public void VerifyCaptionWCM( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyCaptionREGX(String,String)
	 */
	public void VerifyCaptionREGX( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyExists(String,String)
	 */
	public void VerifyExists( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyHasFocus(String,String)
	 */
	public void VerifyHasFocus( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyIsActive(String,String)
	 */
	public void VerifyIsActive( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyValue(String,String)
	 */
	public void VerifyLabel( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyLabelWCM(String,String)
	 */
	public void VerifyLabelWCM( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyLabelREGX(String,String)
	 */
	public void VerifyLabelREGX( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyPlaceholder(String,String)
	 */
	public void VerifyPlaceholder( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyPlaceholderWCM(String,String)
	 */
	public void VerifyPlaceholderWCM( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyMaxLength(String,String)
	 */
	public void VerifyMaxLength( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyPlaceholderREGX(String,String)
	 */
	public void VerifyPlaceholderREGX( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifySelectedValue(String,String)
	 */
	public void VerifySelectedValue( String FN, String ExpVal )
	{
	}
	/**
	 *  \copydoc IOKW_State::VerifySelectedValueWCM(String,String)
	 */

	public void VerifySelectedValueWCM( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifySelectedValueREGX(String,String)
	 */
	public void VerifySelectedValueREGX( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
	 */
	public void VerifyTablecellValue( String FN, String COL, String ROW, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyTablecellValueWCM(String,String,String,String)
	 */
	public void VerifyTablecellValueWCM( String FN, String COL, String ROW, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyTablecellValueREGX(String,String,String,String)
	 */
	public void VerifyTablecellValueREGX( String FN, String COL, String ROW, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyTooltip(String,String)
	 */
	public void VerifyTooltip( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyTooltipWCM(String,String)
	 */
	public void VerifyTooltipWCM( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyTooltipREGX(String,String)
	 */
	public void VerifyTooltipREGX( String FN, String ExpVal )
	{
	}

	/**
    /// \copydoc IOKW_State::VerifyValue(String,String)
	 */
	public void VerifyValue( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyValueWCM(String,String)
	 */
	public void VerifyValueWCM( String FN, String ExpVal )
	{
	}

	/**
	 * \copydoc IOKW_State::VerifyValueREGX(String,String)
	 */
	public void VerifyValueREGX( String FN, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::FileCreate(String)
	 */
	public void FileCreate( String PATH )
	{
	}

	/**
	 *  \copydoc IOKW_State::FileDelete(String)
	 */
	public void FileDelete( String fpsPathAndFileName )
	{
	}

	/**
	 *  \copydoc IOKW_State::FilesDelete(String, String)
	 */
	public void FilesDelete( String fpsDirPath, String fpsFileMatch )
	{
	}

	/**
	 *  \copydoc IOKW_State::DirectoryDelete(String)
	 */
	public void DirectoryDelete( String PATH )
	{
	}

	/**
	 *  \copydoc IOKW_State::DirectoryCreate(String)
	 */
	public void DirectoryCreate( String PATH )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyFileExists(String,String)
	 */
	public void VerifyFileExists( String fpsPathAndFileName, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyIsFile(String,String)
	 */
	public void VerifyIsFile( String fpsPathAndFileName, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyIsDirectory(String,String)
	 */
	public void VerifyIsDirectory( String fpsPathAndFileName, String ExpVal )
	{
	}

	/**
	 *  \copydoc IOKW_State::VerifyDirectoryExists(String,String)
	 */
	public void VerifyDirectoryExists( String fpsPath, String ExpVal )
	{



	}

	/**
	 *  \copydoc IOKW_State::CopyFile(String,String)
	 */
	public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName )
	{

	}

	/**
	 * \copydoc IOKW_State::VerifyMinLength(String,String)
	 */
	public void VerifyMinLength( String FN, String ExpVal )
	{

	}


	/**
	 * \copydoc IOKW_State::VerifyErrorMSG(String,String)
	 */
	public void VerifyErrorMSG( String FN, String ExpVal )
	{

	}

	/**
	 * \copydoc IOKW_State::VerifyErrorMSG_WCM(String,String)
	 */
	public void VerifyErrorMSG_WCM( String FN, String ExpVal )
	{



	}

	/**
	 * \copydoc IOKW_State::VerifyErrorMSG_REGX(String,String)
	 */
	public void VerifyErrorMSG_REGX( String FN, String ExpVal )
	{



	}


}
