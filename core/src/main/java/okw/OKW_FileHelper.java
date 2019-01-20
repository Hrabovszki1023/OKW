/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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
package okw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

/** \~german
 *  OKW_FileHelper enthält FilfsMethoden für die Handhabung von Dateien und Verzechnissen..
 *  
 *  \~english
 *  \~
 *  @author Zoltan Hrabovszki
 *  @date 2013-12-30
 */
public class OKW_FileHelper
{
	/**
     * \~german
	 *  Instanz der Zentralen Loggerklasse.
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2017-07-06
	 */
	private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

	/// \copydoc OKW_CurrentObject_Sngltn::LM()
	// private static LogMessenger LM = new LogMessenger("OKW_FileHelper");

	/**
	 * \~german
	 *  Erzeug ein leeres Verzechniss mit dem angegebenen Pfad.
	 * 
	 *  Endbedingung: Nachdem Aufruf existiert ein leeres Verzeichniss mit dem gegebenen Pfad.
	 *  
	 *  -# Existiert das Verzeichniss nicht, dann wird ein (leeres) Verzeichniss angelegt.
	 *  -# Existiert das Verzeichniss, dann wird dieser rekursiv gelöscht und neu angelegt.
	 *  
	 *  @param fpsPath Pfad des Verzeichnisses, das Angelegt werden soll.
	 *  
	 *  @return true wenn ein leeres Verzeichniss erfolgreich angelegt worden ist, sonst false.
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @date 2013-12-30
	 */
	public static Boolean createEmptyDirectory( String fpsPath )
	{

		String lvsPath = "";
		Boolean lvbReturn = false;

		try
		{
			// lvsPath = MyParser.ParseMe(fpsPath);
			Log.LogFunctionStart("DirectoryCreateEmpty", "String", fpsPath);

			File myDirectory = new File(fpsPath);

			// Determine whether the directory exists.
			if (myDirectory.exists() & myDirectory.isDirectory())
			{
				deleteDirectory(lvsPath);
			}
			else if (myDirectory.exists() & myDirectory.isFile())
			{
				deleteFile(lvsPath);
			}

			// Try to create the directory.
			myDirectory.mkdirs();

			lvbReturn = true;

		}
		catch (Exception e)
		{
			Log.LogPrint("The process failed:");
		}
		finally
		{
			Log.LogFunctionEnd(lvbReturn);
		}
		return lvbReturn;
	}

	/** \~german
	 *  Löschent rekursiv alle Dateien und Unterverzeichnisse und das gegebenen
	 *  Verzeichniss selbst.
	 * 
	 *  Endbedingung: Verzeichniss exsitiert einschliesslich aller Dateien und
	 *  Unterverueichnisse nachdem Aufruf nicht mehr.
	 *  
	 *  -# Existiert das Verzeichniss nicht, dann ist die Endbedingung bereits erfüllt. 
	 *     Es wird keine weitere Aktion durchgeführt. Methode wird ohne Fehler beenden.
	 *  -# Existiert das Verzeichniss, dann wird dieser rekursiv mit dem gesamten Inhalt gelöscht.
	 *  
	 *  \param fpsPath
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @date 2013-12-30
	 */  
	public static void deleteDirectory( String fpsPath )
	{
		String lvsPath = fpsPath;
		Boolean lvbReturn = false;

		Log.LogFunctionStartDebug("OKW_Helper.DirectoryDelete", "fpsPaFiNa", fpsPath);

		try
		{

			// \todo TODO: ANTLR-Paser einschalten
			// lvsPaFiNa = MyParser.ParseMe(lvsPaFiNa);

			File myPath = new File(lvsPath);

			if (myPath.exists())
			{
				for (File f : myPath.listFiles())
				{
					if (f.isDirectory())
					{
					    deleteDirectory(f.getPath());
						f.delete();
					}
					else
					{
						f.delete();
					}
				}
				myPath.delete();
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}
	}

	/// \~german
	/// \brief
	/// Prüft, ob die gegebene _fpsPaFiNa_ Datei existiert.
	///
	/// \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der
	/// zulöschenden Datei.
	/// \returntrue, fall datei existiert, sonst false. \return
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static Boolean directoryExists( String fpsPaFiNa )
	{
		Boolean lvbReturn = false;

		Log.LogFunctionStartDebug("OKW_FileHelper.DirectoryExists", "fpsPaFiNa", fpsPaFiNa);

		try
		{
			// \todo TODO: ANTLR-Paser einschalten
			// lvsPaFiNa = MyParser.ParseMe(lvsPaFiNa);

			File myFile = new File(fpsPaFiNa);

			// Existiert "fpsPaFiNa"?
			if (myFile.exists())
			{
				// Ist ein Verzeichniss?
				if (myFile.isDirectory())
				{
					lvbReturn = true;
				}
				// Ist es eine Datei?
				else if (myFile.isFile())
				{
					throw (new OKWFileDoesNotExistsException("This is not a directory! Given path is a directory!"));
				}
				// Dann Existiert "fpsPaFiNa" nicht!
				else
				{
					lvbReturn = false;
				}
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	public static void copyDirectory( String fpsSourceFolder, String fpsDestinationFolder )
	{
		// Source directory which you want to copy to new location
		File sourceFolder = new File(fpsSourceFolder);

		// Target directory where files should be copied
		File destinationFolder = new File(fpsDestinationFolder);

		copyDirectory(sourceFolder, destinationFolder);

	}

	private static boolean copyDirectory( File fpSourceFolder, File fpDestinationFolder )
	{

		Boolean lvbReturn = false;

		try
		{
			// \todo TODO: ANTLR-Paser einschalten
			// lvsPaNaSource = MyParser.ParseMe(fpsPaNaSource);
			// lvsPaNaDestination = MyParser.ParseMe(fpsPaNaDestination);

			Log.LogFunctionStartDebug("OKW_FileHelper.DirectoryMove", "fpSourceFolder", fpSourceFolder.getPath(), "fpDestinationFolder", fpDestinationFolder.getPath());

			// Check if sourceFolder is a directory or file
			// If sourceFolder is file; then copy the file directly to new
			// location
			if (fpSourceFolder.isDirectory())
			{
				// Verify if destinationFolder is already present; If not then
				// create it
				if (!fpDestinationFolder.exists())
				{
					fpDestinationFolder.mkdir();
					System.out.println("Directory created :: " + fpDestinationFolder);
				}

				// Get all files from source directory
				String files[] = fpSourceFolder.list();

				// Iterate over all files and copy them to destinationFolder one
				// by one
				for (String file : files)
				{
					File srcFile = new File(fpSourceFolder, file);
					File destFile = new File(fpDestinationFolder, file);

					// Recursive function call
					copyDirectory(srcFile, destFile);
				}
			}
			else
			{
				// Copy the file content from one place to another
				Files.copy(fpSourceFolder.toPath(), fpDestinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("File copied :: " + fpDestinationFolder);
			}
		}
		catch (IOException e)
		{
			Log.LogPrintDebug(e.getMessage());
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Verzeichniss verschieben löschen des gegebenen Verzeichnisses..
	///
	/// \param fpsPaNaSource Pfad des Quell-Verzeichnisses.
	/// \param fpsPaNaDestination Pfad des Ziel-Verzeichnisses.
	///
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static boolean moveDirectory( String fpsPaNaSource, String fpsPaNaDestination )
			throws IOException, FileNotFoundException
	{
		Boolean lvbReturn = false;

		String lvsPaNaSource = fpsPaNaSource;
		String lvsPaNaDestination = fpsPaNaDestination;

		try
		{
			// \todo TODO: ANTLR-Paser einschalten
			// lvsPaNaSource = MyParser.ParseMe(fpsPaNaSource);
			// lvsPaNaDestination = MyParser.ParseMe(fpsPaNaDestination);

			Log.LogFunctionStartDebug("OKW_FileHelper.DirectoryMove", "fpsPaNaSource", fpsPaNaSource, "fpsPaNaDestination", fpsPaNaDestination);

			if (directoryExists(lvsPaNaSource))
			{
				// Löschen des ZIEL-verzeichnissen wenn vorhanden
			    deleteDirectory(lvsPaNaDestination);

				// Copy with subfolders
				copy(lvsPaNaSource, lvsPaNaDestination, true);

				// Delete Source
				deleteDirectory(lvsPaNaSource);

				lvbReturn = true;
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	public static void copy( String fpsSource, String fpsDestination, Boolean copySubDirs )
			throws IOException, FileNotFoundException
	{
		Path lvSourcePath = Paths.get(fpsSource);
		Path lvDestinationPath = Paths.get(fpsDestination);

		if (Files.notExists(lvSourcePath))
		{
			throw new FileNotFoundException("Source directory does not exist or could not be found: " + fpsSource);
		}

		else
		{

			Files.copy(lvSourcePath, lvDestinationPath);
		}
	}

	/// \~german
	/// \brief Löscht alle Dateien im gegebenen Verzeichniss Rekursive. Die
	/// Verzeichnisstruktur bleibt erhalten.
	///
	/// \todo TO
	///
	/// \param fpsPaFiNa Pfad und Name der Datei. Wildcards * und ? sind
	/// erlaubt.
	/// \return
	///
	/// \~english
	/// \brief \todo TODO: Brief Description.
	///
	/// \todo TODO: Detailed Description
	///
	/// \param
	/// \return
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2015.08.22
	public static void deleteFiles( String fpsPaFiNa )
	{

		if (directoryExists(fpsPaFiNa))
		{
			File myDir = new File(fpsPaFiNa);
			File[] listOfFiles = myDir.listFiles();

			for (File myFileToDelete : listOfFiles)
			{
				if (!myFileToDelete.isDirectory())
				{
				    myFileToDelete.delete();
				}
			}
		}
	}

	/// \~german
	/// \brief
	/// Löscht die gegebene Datei _fpsPaFiNa_. Verzeichnisse werden nicht
	/// gelöscht.
	///
	/// __Anmerkung:__ Existiert die Datei, dann wird diese gelöscht,
	/// falls die Datei nicht existiert, dann passiert schlicht nichts weiter.
	/// D.h. es wird auch kein Fehler oder eine Exception ausgelöst.
	///
	/// Ist die vermeintliche Datei in Wahrheit ein Verzeichniss, dann wird eine
	/// OKWFileDoesNotExistsException ausgelöst.
	///
	/// \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der
	/// zulöschenden Datei.
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static Boolean deleteFile( String fpsPaFiNa )
	{
		Boolean lvbReturn = false;

		Log.LogFunctionStartDebug("OKW_FileHelper.FileDelete", "fpsPaFiNa", fpsPaFiNa);

		if (fileExists(fpsPaFiNa))
		{
			try
			{
				File myFile = new File(fpsPaFiNa);

				lvbReturn = myFile.delete();
			}
			finally
			{
				Log.LogFunctionEndDebug();
			}
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief Prüft, ob die gegebene _fpsPaFiNa_ Datei existiert.
	///
	///
	/// \param fpsPaFiNa PathAndFileName: Vollständiger Pfad der Datein, die auf
	/// Existenz Geprüft werden soll.
	/// \return true, falls die Datei _fpsPaFiNa_ existiert, sonst false.
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static Boolean fileExists( String fpsPaFiNa )
	{

		Boolean lvbReturn = false;

		Log.LogFunctionStartDebug("OKW_FileHelper.FileExist", "fpsPaFiNa", fpsPaFiNa);

		try
		{
			File myFile = new File(fpsPaFiNa);

			// Existiert "fpsPaFiNa"?
			if (myFile.exists())
			{
				// Ist es eine Datei?
				if (myFile.isFile())
				{
					lvbReturn = true;
				}
				// Ist ein Verzeichniss?
				else if (myFile.isDirectory())
				{
					throw (new OKWFileDoesNotExistsException("This is not a file! Given path is a directory!"));
				}
				// Dann Existiert "fpsPaFiNa" nicht!
				else
				{
					lvbReturn = false;
				}
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn.toString());
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Verschiebt die gegeben Quell-Datei zu einer neuen Ziel-Datei.
	///
	/// \param fpsPaFiNaSource PathAndFileName: Angabe des vollständigen Pfades
	/// der zulöschenden Datei.
	/// \param fpsPaFiNaDestination Angabe des vollständigen Pfades der
	/// zulöschenden Datei.
	/// \~english
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static void move( String fpsPaFiNaSource, String fpsPaFiNaDestination )
			throws IOException, FileNotFoundException
	{

		Log.LogFunctionStartDebug("OKW_FileHelper.Move", "fpsPaFiNaSource", fpsPaFiNaSource, "fpsPaFiNaDestination",
				fpsPaFiNaDestination);
		try
		{
			if (fileExists(fpsPaFiNaSource))
			{

				deleteFile(fpsPaFiNaDestination);
				copy(fpsPaFiNaSource, fpsPaFiNaDestination, true);
				deleteFile(fpsPaFiNaSource);

			}
			else
			{
				// \todo TODO: Log in xml-datei auslagern
				Log.LogFunctionEnd();
				throw new OKWFileDoesNotExistsException("file doesnot exists...");
			}
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \brief
	/// Legt eine Leere Datei an.
	///
	/// \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der an
	/// zu legenden Datei.
	/// \~english
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static boolean createFile( String fpsPaFiNa ) throws IOException
	{

		Boolean lvbReturn = false;

		Path newFilePath = Paths.get(fpsPaFiNa);
		try
		{

			if (!Files.exists(newFilePath))
			{
				Files.createFile(newFilePath);
			}
		}
		finally
		{
			Log.LogFunctionEnd(lvbReturn);
		}

		return lvbReturn;

	}

	/** \~german
	 *  \brief
	 *  Diese Methode prüft, ob das angegebene Vrzeicniss leer ist.
	 *  D.h. das Verzeichniss enthält
	 *  * keine Dateien und
	 *  * keine Unterverzeichnisse
	 * 
	 *  \eception OKW.Exceptions.OKWDirectoryDoesNotExistsException wird
	 *  ausgelöst,
	 *  wenn de gegeben Pfad nicht auf ein existierendesVerzeichiss zeigt.
	 *  \param Folder Das zu prüfende Verzeichniss.
	 *  \~english
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @date 2013.12.30
	 */
	public static Boolean isDirectoryEmpty( String fpsPath )
	{

		Boolean lvbReturn = false;
		Log.LogFunctionStart("OKW_FileHelper.IsDirectoryEmpty", "fpaFolder", fpsPath);
		try
		{
			if (directoryExists(fpsPath))
			{
				lvbReturn = Paths.get(fpsPath).toFile().listFiles().length == 0;
			}
			else
			{
				// \todo TODO: Meldung in LM_OKW_FileHelper.xml auslagern...
				throw new OKWDirectoryDoesNotExistsException("Directory Doesnt Exists...");
			}
		}
		finally
		{
			Log.LogFunctionEnd(lvbReturn);
		}

		return false;
	}

	/// \~german
	/// \brief
	/// Konvertiert selbständig
	///
	/// Je nach Betriebssystem wird wie folgt konvertiert:
	///
	/// * Auf einem Windows/DOS System werden Unix-Pfad-Trenner "/" nach "\"
	/// konvertiert.
	/// * Auf einem OSX, Linux (Unix-Artige) Systemen wir der DOS-Pfad Trenne
	/// "\" nach "/" konvertiert.
	///
	/// \param Pfad, der zu konvertieren ist.
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.30
	public static String convertDirectorySeperator( String fpsPath )
	{
		String lvsReturn = fpsPath;

		Log.LogFunctionStartDebug("OKW_FileHelper.ConvertDirectorySeperator", "fpsPath", fpsPath);

		try
		{
			String myFileSeparator =System.getProperty("file.separator");
			
			if ("/".equals( myFileSeparator))
			{
				lvsReturn = fpsPath.replace("\\", "/");
			}
			else if ("\\".equals( myFileSeparator))
			{
				lvsReturn = fpsPath.replace("/", "\\");
			}
			else
				throw (new OKWDirectorySeperatorNotImplementedException("Error: Unknown file.separator: -" + myFileSeparator + "-"));

			lvsReturn  = lvsReturn.replace( "\\C:", "C:");
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
	}
}
