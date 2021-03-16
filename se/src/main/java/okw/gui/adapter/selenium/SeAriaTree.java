package okw.gui.adapter.selenium;

import java.util.ArrayList;

import org.openqa.selenium.StaleElementReferenceException;

import okw.OKW;
import okw.OKW_Helper;
import okw.exceptions.OKWSeAriaTreeElementNotFound;
import okw.gui.OKWLocatorBase;
import okw.log.Logger_Sngltn;

public class SeAriaTree extends SeAnyChildWindow
{

	@OKW ( FN="SeAriaTree_Node",
			VerifyLabel_PT=500, VerifyLabel_TO=5,
			VerifyIsActive_PT=500, VerifyIsActive_TO=1,
			VerifyValue_PT=500, VerifyValue_TO=5,
			VerifyTooltip_PT=500, VerifyTooltip_TO=5,
			VerifyCaption_PT=500, VerifyCaption_TO=5,
			VerifyExists_PT=500, VerifyExists_TO=5,
			VerifyHasFocus_PT=500, VerifyHasFocus_TO=5
			)
	public SeAnyChildWindow myNodeGUIElement = new SeAnyChildWindow( this.getLocator());

	protected static Logger_Sngltn Log = Logger_Sngltn.getInstance();

	protected Integer aria_level = 0;



	/**
	 *  @copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
	 */
	public SeAriaTree( String Locator, OKWLocatorBase... Locators )
	{
		super( Locator, Locators );
	}

	/** \~german
	 *  Methode wählt einen oder mehrer eKnoten eines AriaTrees aus.
	 *  
	 *  @param fpsValues Werte, die in der Listbox ausgwählt werden sollen.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2021.03.10
	 */
	@Override
	public void SetValue( ArrayList<String> fpsValues )
	{

		for ( String lvsValue : fpsValues )
		{
			ArrayList<String> sPath = OKW_Helper.splitString(lvsValue, "/");

			RuntimeException rException = null;

			Integer PathElementCount = sPath.size();
			Boolean Retry = false;

			Boolean pathIsSelected = false;

			do {
				try
				{
					Retry = false;
					this.aria_level = 0;
					pathIsSelected = SelectNode( sPath );
				}
				catch ( StaleElementReferenceException e)
				{
					Log.LogPrint( "> Retry: StaleElementReferenceException" );
					rException = e;
					Retry = true;
					PathElementCount--;
				}
				catch ( OKWSeAriaTreeElementNotFound e)
				{
					Log.LogPrint( "> Retry: OKWSeAriaTreeElementNotFound" );
					rException = e;
					Retry = true;
					PathElementCount--;
				}
				catch ( Exception e)
				{
					Log.LogPrint( "> Retry: Unexpected exception:" );
					Log.LogPrint(e.getMessage());
					Log.LogPrint(e.getStackTrace().toString());
					throw e;
				}

			} while ( Retry & PathElementCount > 0 );

			if ( !pathIsSelected & rException != null) throw rException;

		}
	}


	// xpath mit /ancestor
	// (//*[@role='tree'])[1] 
	// //*[@role='treeitem' and @aria-level='2']//*[text()="Felhasználó karbantartása"]
	// /ancestor::*[@role='treeitem' and @aria-level='2'] 

	protected Boolean SelectNode( ArrayList<String> sPath )
	{
		ArrayList<String> mysPath = new ArrayList<String>();
		mysPath.addAll(sPath);

		String myPathElement = mysPath.remove(0);

		Boolean nodeElementIsSelected = false;

		aria_level++;

		String myIntend = OKW_Helper.repeatString("-", this.aria_level );

		Log.LogPrint( myIntend + "> SelectNode: : " + myPathElement );

		String treeNodeLocator1 = this.getLocator()
				+  "//*[@role='treeitem' and @aria-level='" + aria_level + "' and normalize-space(text()) = '" + myPathElement + "']";

		String treeNodeLocator2 = this.getLocator()
				+  "//*[@role='treeitem' and @aria-level='" + aria_level + "']//*[normalize-space(text()) = '" + myPathElement + "']"
				+  "/ancestor::*[@role='treeitem' and @aria-level='" + aria_level + "'] ";

		String treeNodeLocator = "(" + treeNodeLocator1 + " | " + treeNodeLocator2 + ")";

		// Setzte den Lokator auf den neu berechneten Wert 
		myNodeGUIElement.setLocator(treeNodeLocator);

		// Ist unser Node Element vorhanden?
		// Boolean myNodeExist = myNodeGUIElement.VerifyExists();

		//if( myNodeExist )
		//{
			// Wenn der Knoten geschlossen oder ein Blatt-Knoten ist, dann wird geklickt
			// aria-expanded="false" bzw. null wenn ein Blatt element

			String aria_expanded = 	myNodeGUIElement.getAttribute( "aria-expanded" ).get(0);

			if ( "false".equals( aria_expanded ) )
			{
				myNodeGUIElement.ClickOn();

				Log.LogPrint( myIntend + "> ClickOn" );
				nodeElementIsSelected = SelectNode( mysPath );
			}
			else if ( "true".equals( aria_expanded ) )
			{
				Log.LogPrint( myIntend + "> Bereits geöffnet" );
				nodeElementIsSelected = SelectNode( mysPath );
			}
			else if ( OKW_Helper.isStringNullOrEmpty( aria_expanded ) )
			{
				myNodeGUIElement.ClickOn();
				Log.LogPrint( myIntend + "> clickOn" );

				nodeElementIsSelected = true;

				if ( mysPath.size() > 0 )
				{
					nodeElementIsSelected = SelectNode( mysPath );
				}
				else Log.LogPrint( myIntend + "> Leaf" );

			}
			else
			{
				Log.LogError( myIntend + ">  Undefinde/Unexpected Valueof aria-expanded: " + aria_expanded );
				// Exception
				nodeElementIsSelected = false;
			}
		//}

		this.aria_level--;

		if ( ! nodeElementIsSelected )
		{
			throw new OKWSeAriaTreeElementNotFound( "TreeElement not found: " + myPathElement );
		}

		return nodeElementIsSelected;
	}
}
