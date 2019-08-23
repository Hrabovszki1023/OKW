package okw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import okw.exceptions.OKWMessageNotFoundException;

public class OKW_XmlReader // extends ClassLoader 
{

	private Document				myXMLDocument;
	private DocumentBuilderFactory	mydbFactory;
	private DocumentBuilder			mydBuilder;
	private XPath					myXPath;

	private String					myXMLFile;

	public String getXMLFile()
	{
		return myXMLFile.toString();
	}

	
	public OKW_XmlReader(String fpsXMLFile) throws JAXBException, ParserConfigurationException, SAXException, IOException
	{
		//myXMLFile = Paths.get( fpsXMLFile );
		myXMLFile = fpsXMLFile;
		Init();
	}
	
	/** \~german
	 *  Initialisiert die Klasse:
	 * 
	 *  * LM- Dateinamen als ermitteln
	 * 
	 *  \~english
	 *  This constructor has no Parameter and uses the default values for the
	 *  config-file and Actual/default language(=EN)
	 * 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2013_12_22
	 */
	private void Init() throws JAXBException, ParserConfigurationException, SAXException, IOException
	{
		    InputStream is = OKW_XmlReader.class.getResourceAsStream( myXMLFile.toString() );
		  
			if ( is == null )
			{
				System.out.println(
						"============================================================================================================");
				System.out.println("OKW Exception: File not found! -> '" + myXMLFile.toString() + "'");
				System.out.println(
						"============================================================================================================");

				throw new FileNotFoundException("File not found! The File was: '" + this.myXMLFile.toString() + "'");
			}
			else
			{
				this.mydbFactory = DocumentBuilderFactory.newInstance();
				this.mydBuilder = mydbFactory.newDocumentBuilder();
				this.myXMLDocument = mydBuilder.parse(is);
				this.myXPath = XPathFactory.newInstance().newXPath();
			}
	}

	/// \~german
	/// \brief Lies den TextContent eines Tag.
	///
	/// \param fpsXPathExpression XPath des Tags, welches gelesen werden soll
	///
	/// \exception OKWMessageNotFoundException Wird ausgelöst wenn nicht genau ein Wert gefunden wird.
	///
	/// \~english
	/// \brief
	///
	/// \param ClassName Name of the Class.
	///
	/// \return Rreturns the Message for the given language or default language
	/// if given languae does not exist<br/>
	/// _"Message Not Found!"_ will be returnd, if a doesn´s exist.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2016_02_07
	public String getTextContentSingleValue( String fpsXPathExpression )
	{
		String lvsReturn = "Message Not Found!";

		try
		{

			NodeList myNodeList = (NodeList) myXPath.compile(fpsXPathExpression).evaluate(this.myXMLDocument,
					XPathConstants.NODESET);

			
			if (myNodeList.getLength() == 1)
			{
				Node myNode = myNodeList.item(0);
				lvsReturn = myNode.getTextContent();
			}
			else
			{
				throw new OKWMessageNotFoundException("TextContent not Found!: " + fpsXPathExpression );
			}
		}
		catch (OKWMessageNotFoundException | XPathExpressionException e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Interne Kernfunktion holt die Log-Meldung mit Platzhaltern aus der
	/// XML-Datei.
	/// "ClassName", "MethodName" and "TextKey" and Actual language from
	/// ini-file.
	///
	/// \param ClassName Name of the Class.
	/// \param MethodName Name of the Method.
	/// \param TextKey Key for the Text-Message.
	///
	/// \~english
	/// \brief
	/// \exception OKWMessageNotFoundException if a Message ist not found or if
	/// more then one Message is found for the Given Parmeter.
	///
	/// \param ClassName Name of the Class.
	/// \param MethodName Name of the Method.
	/// \param TextKey Key for the Text-Message.
	///
	/// \return Rreturns the Message for the given language or default language
	/// if given languae does not exist<br/>
	/// _"Message Not Found!"_ will be returnd, if a doesn´s exist.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013_12_22
	public ArrayList<String> getTextContentAsList( String fpsXPathExpression )
	{

		ArrayList<String> lvALReturn = new ArrayList<String>();
	
		try
		{

			NodeList myNodeList = (NodeList) myXPath.compile(fpsXPathExpression).evaluate(this.myXMLDocument,
					XPathConstants.NODESET);

			int lviCount = myNodeList.getLength();
					
			if (lviCount >= 1)
			{
				for( int i = 0; i < lviCount; i++ )
				{
					Node myNode = myNodeList.item(i);
					lvALReturn.add( myNode.getTextContent() );
				}
			}
			else
			{
				throw new OKWMessageNotFoundException("TextContent not Found!");
			}
		}
		
		catch (OKWMessageNotFoundException | XPathExpressionException e)
		{
			OKW_HandleException.StopRunning(e, this.getClass());
		}

		return lvALReturn;
	}

}
