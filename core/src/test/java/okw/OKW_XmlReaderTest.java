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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.xml.sax.SAXException;

@Tag("AllCoreHelperTests")
public class OKW_XmlReaderTest
{
	@Test
	public void TC_getXMLFile()
	{
		try
		{

			OKW_XmlReader myXlReader = new OKW_XmlReader("/OKW_XmlReaderTestXML.xml");

			String Actuell = myXlReader.getXMLFile();

			assertEquals("Ein Wert wird erwartet:", "/OKW_XmlReaderTestXML.xml", Actuell);

		}
		catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
		{
			fail(e.getMessage());
		}
	}

	   @Test
	    public void TC_getXMLFil2e()
	    {
	        try
	        {

	            OKW_XmlReader myXlReader = new OKW_XmlReader("/xml/OKW_Ini.xml");

	            String Actuell = myXlReader.getXMLFile();

	            assertEquals("Ein Wert wird erwartet:", "/xml/OKW_Ini.xml", Actuell);

	        }
	        catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
	        {
	            fail(e.getMessage());
	        }
	    }

	
	 @Test
	  public void TC_getXMLFile_FileNotFoundException() throws JAXBException, ParserConfigurationException, SAXException, IOException
	  {
	      OKW_XmlReader myXlReader = new OKW_XmlReader("DoesNotExists.xml");

	      //Löst Ausname aus.
	      Assertions.assertThrows( FileNotFoundException.class, () ->
	      {
	          myXlReader.getXMLFile();
	      });
	  }

	// Test
	@Test
	public void TC_getTextContentAsList()
	{
		try
		{
			OKW_XmlReader myXlReader = new OKW_XmlReader("/OKW_XmlReaderTestXML.xml");

			ArrayList<String> Actuell = myXlReader.getTextContentAsList("//value");
			assertEquals("Ein Wert wird erwartet:", "Wert 1", Actuell.get(0));
			assertEquals("Ein Wert wird erwartet:", "Wert 2", Actuell.get(1));
			assertEquals("Ein Wert wird erwartet:", "Wert 3", Actuell.get(2));
		}
		catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
		{
			fail(e.getMessage());
		}
	}

	
	@Test
  public void TC_getTextContentAsList_Subfolder()
  {
    try
    {
      OKW_XmlReader myXlReader = new OKW_XmlReader("/SubFolder4Test/OKW_XmlReaderTestXML2.xml");

      ArrayList<String> Actuell = myXlReader.getTextContentAsList("//value");
      assertEquals("Ein Wert wird erwartet:", "Wert 1", Actuell.get(0));
      assertEquals("Ein Wert wird erwartet:", "Wert 2", Actuell.get(1));
      assertEquals("Ein Wert wird erwartet:", "Wert 3", Actuell.get(2));
    }
    catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
    {
      fail(e.getMessage());
    }
  }

	@Test
	public void TC_getTextContentSingleValue()
	{
		try
		{
			OKW_XmlReader myXlReader = new OKW_XmlReader("/OKW_XmlReaderTestXML.xml");

			String Actuell = myXlReader.getTextContentSingleValue("//value[1]");
			assertEquals("Ein Wert wird erwartet:", "Wert 1", Actuell);
			
			Actuell = myXlReader.getTextContentSingleValue("//value[2]");
			assertEquals("Ein Wert wird erwartet:", "Wert 2", Actuell);

			Actuell = myXlReader.getTextContentSingleValue("//value[3]");
			assertEquals("Ein Wert wird erwartet:", "Wert 3", Actuell);
		}
		catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
		{
			fail(e.getMessage());
		}
	}

	
  @Test
  public void TC_getTextContentSingleValue_Subfolder()
  {
    try
    {
      OKW_XmlReader myXlReader = new OKW_XmlReader("/SubFolder4Test/OKW_XmlReaderTestXML2.xml");

      String Actuell = myXlReader.getTextContentSingleValue("//value[1]");
      assertEquals("Ein Wert wird erwartet:", "Wert 1", Actuell);
      
      Actuell = myXlReader.getTextContentSingleValue("//value[2]");
      assertEquals("Ein Wert wird erwartet:", "Wert 2", Actuell);

      Actuell = myXlReader.getTextContentSingleValue("//value[3]");
      assertEquals("Ein Wert wird erwartet:", "Wert 3", Actuell);
    }
    catch (JAXBException | ParserConfigurationException | SAXException | IOException e)
    {
      fail(e.getMessage());
    }
  }	
	@BeforeAll
	public static void MyTestFixtureSetUp()
	{
		StringBuffer sbf = new StringBuffer();

		sbf.append("<root>\n");
		sbf.append("\t<level1>\n");
		sbf.append("\t<value>Wert 1</value>\n");
		sbf.append("\t<value>Wert 2</value>\n");
		sbf.append("\t<value>Wert 3</value>\n");
		sbf.append("\t</level1>\n");
		sbf.append("</root>\n");

		try
		{
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("OKW_XmlReaderTestXML.xml")));

			// write contents of StringBuffer to a file
			bwr.write(sbf.toString());

			// flush the stream
			bwr.flush();

			// close the stream
			bwr.close();
		}
		catch (IOException e)
		{
			fail(e.getMessage());
		}
	}

	@AfterAll
	public static void MyTestFixtureTearDown()
	{
		// TODO: Add tear down code.
	}
}
