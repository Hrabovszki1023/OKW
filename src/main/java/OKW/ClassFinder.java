package OKW;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Philippe Schweitzer dbi services Switzerland
 * http://blog.dbi-services.com/java-get-class-names-from-package-string-in-classpath/
 * 
 */
public class ClassFinder {

	public static void main(String[] args) throws ClassNotFoundException
	{
		ArrayList<Class<?>> classes = ClassFinder.getClassesFromPackage("OKW/Frames");
		System.out.println("START ClassList:");

		for (Class<?> c : classes) {
			System.out.println(c.toString());// + ” ” + c.getCanonicalName());
		}
		System.out.println("END ClassList:");
	}

	/**
     *
     * Attempts to list all the classes in the specified package as determined     *
     * by the context class loader…
     *
     * @param pckgname the package name to search
     * @return a list of classes that exist within that package
     * @throws ClassNotFoundException if something went wrong
     *
     */
    public static ArrayList<Class<?>> getClassesFromPackage(String fps_pckgname) throws ClassNotFoundException
    {
        ArrayList<Class<?>> lvAL_result = new ArrayList<Class<?>>();
        ArrayList<File> directories = new ArrayList<File>();
        HashMap<File, String> packageNames = null;

        try {
            ClassLoader cld = Thread.currentThread().getContextClassLoader();
            
            if (cld == null)
            {
                throw new ClassNotFoundException("Can’t get class loader.");
            }
            
            for (URL jarURL : ((URLClassLoader) Thread.currentThread().getContextClassLoader()).getURLs())
            {
                System.out.println("JAR: " + jarURL.getPath());
                getClassesInSamePackageFromJar(lvAL_result, fps_pckgname, jarURL.getPath());
                String path = fps_pckgname;
                Enumeration<URL> resources = cld.getResources(path);
                File directory = null;
                while (resources.hasMoreElements())
                {
                    String path2 = resources.nextElement().getPath();
                    directory = new File(URLDecoder.decode(path2, "UTF-8"));
                    directories.add(directory);
                }
                if (packageNames == null)
                {
                    packageNames = new HashMap<File, String>();
                }
                packageNames.put(directory, fps_pckgname);
            }
        }
        catch (NullPointerException x)
        {
            throw new ClassNotFoundException(fps_pckgname + " does not appear to be a valid package (Null pointer exception)");
        }
        catch (UnsupportedEncodingException encex)
        {
            throw new ClassNotFoundException(fps_pckgname + " does not appear to be a valid package (Unsupported encoding)");
        } 
        catch (IOException ioex) 
        {
            throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + fps_pckgname);
        }
        
        for (File directory : directories)
        {
            if (directory.exists()) 
            {
                String[] files = directory.list();
                
                for (String file : files) {
                    if (file.endsWith(".class")) {
                        try {
                      //      System.out.println(packageNames.get(directory).toString() + ‘.’ + file.substring(0, file.length() – 6));
                        	Class<?> lvcReult = Class.forName(packageNames.get(directory).toString() + "." + file.substring(0, file.length() - 6));
                        	lvAL_result.add(lvcReult);
                        }
                        catch (Throwable e) {
                        }
                    }
                }
            }
            else
            {
                throw new ClassNotFoundException(fps_pckgname + " (" + directory.getPath() + ") does not appear to be a valid package");
            }
        }
        return lvAL_result;
    }

	/**
     *
     * Returns the list of classes in the same directories as Classes in
     * classes.
     *
     * @param result
     * @param classes
     * @param jarPath
     *
     */
    private static void getClassesInSamePackageFromJar(ArrayList<Class<?>> result, String packageName, String jarPath)
    {
        JarFile jarFile = null;

        try
        {
            jarFile = new JarFile(jarPath);
            Enumeration<JarEntry> en = jarFile.entries();
            while (en.hasMoreElements())
            {
                JarEntry entry = en.nextElement();
                String entryName = entry.getName();
                packageName = packageName.replace(".", "/");
     
                if (entryName != null && entryName.endsWith(".class") && entryName.startsWith(packageName))
                {
                    try
                    {
                        Class<?> entryClass = Class.forName(entryName.substring(0, entryName.length() - 6).replace("/", "."));
                        
                        if (entryClass != null)
                        {
                            result.add(entryClass);
                        }
                    } 
                    catch (Throwable e) 
                    { 
                    	// do nothing, just continue processing classes
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                if (jarFile != null) {
                    jarFile.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
