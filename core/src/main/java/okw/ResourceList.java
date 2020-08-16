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

package okw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import okw.log.Logger_Sngltn;

/**
 * list resources available from the classpath @ *
 */
public class ResourceList
{

    /**
     *  \copydoc Logger_Sngltn::getInstance()
     */
    private static Logger_Sngltn Log = Logger_Sngltn.getInstance();
	
	/**
	 * for all elements of java.class.path get a Collection of resources Pattern
	 * pattern = Pattern.compile(".*"); gets all resources
	 * 
	 * @param pattern
	 *            the pattern to match
	 * @return the resources in the order they are found
	 */
	public static Collection<String> getResources(final Pattern pattern)
	{
		final ArrayList<String> retval = new ArrayList<String>();
		
		final String classPath = System.getProperty("java.class.path", ".");
		
		final String[] classPathElements = classPath.split(System.getProperty("path.separator"));
		
		Log.ResOpenListDebug( "Class Path..." ); 
		
		for (final String element : classPathElements)
		{
			Log.LogPrintDebug( element );
			retval.addAll(getResources(element, pattern));
		}
		
		Log.ResCloseListDebug();
		
		return retval;
	}

	private static Collection<String> getResources(final String element, final Pattern pattern)
	{
		final ArrayList<String> retval = new ArrayList<String>();
		final File file = new File(element);
		
		if (file.isDirectory())
		{
			retval.addAll(getResourcesFromDirectory(file, pattern));
		}
		else
		{
			retval.addAll(getResourcesFromJarFile(file, pattern));
		}
		return retval;
	}

	private static Collection<String> getResourcesFromJarFile(final File file, final Pattern pattern) {
		final ArrayList<String> retval = new ArrayList<String>();
		ZipFile zf;
		try {
			zf = new ZipFile(file);
		} catch (final ZipException e) {
			throw new Error(e);
		} catch (final IOException e) {
			throw new Error(e);
		}
		
		final Enumeration<?> e = zf.entries();
		while (e.hasMoreElements()) {
			final ZipEntry ze = (ZipEntry) e.nextElement();
			final String fileName = ze.getName();
			final boolean accept = pattern.matcher(fileName).matches();
			if (accept) {
				retval.add(fileName);
			}
		}
		try {
			zf.close();
		} catch (final IOException e1) {
			throw new Error(e1);
		}
		return retval;
	}

	private static Collection<String> getResourcesFromDirectory(final File directory, final Pattern pattern) {
		final ArrayList<String> retval = new ArrayList<String>();
		final File[] fileList = directory.listFiles();
		for (final File file : fileList) {
			if (file.isDirectory()) {
				retval.addAll(getResourcesFromDirectory(file, pattern));
			} else {
				try {
					final String fileName = file.getCanonicalPath();
					final boolean accept = pattern.matcher(fileName).matches();
					if (accept) {
						retval.add(fileName);
					}
				} catch (final IOException e) {
					throw new Error(e);
				}
			}
		}
		return retval;
	}

	/**
	 * list the resources that match args[0]
	 * 
	 * @param args
	 *            args[0] is the pattern to match, or list all resources if there
	 *            are no args
	 */
	public static void main(final String[] args) {
		Pattern pattern;
		if (args.length < 1) {
			pattern = Pattern.compile(".*");
		} else {
			pattern = Pattern.compile(args[0]);
		}
		final Collection<String> list = ResourceList.getResources(pattern);
		for (final String name : list) {
			System.out.println(name);
		}
	}
}
