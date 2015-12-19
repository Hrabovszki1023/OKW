package OKW.Log.Log2HTML;

import java.util.ArrayList;

public abstract class LogBase
{

	LogBase				myParent		= null;

	ArrayList<LogBase>	myChildren		= null;	// new ArrayList<LogBase>();

	String				myIndention	= "";

	String getIndention()
	{
		return myIndention;
	}

	// Print Data
	// Fist Row: MainRow of the Intend Block
	String				myMainRow		= "";
	String				myParamList		= "";

	String				myMessage		= "";

	String				myCSS_Class		= null;

	private Boolean		hasWarning		= false;
	private Boolean		hasError		= false;
	private Boolean		hasException	= false;

	Boolean getWarning()
	{
		return hasWarning;
	}

	void setWarning( Boolean warning )
	{
		hasWarning = warning;

		// Warnung an Parent melden
		if (myParent != null) myParent.setWarning(warning);

	}

	Boolean getError()
	{
		return hasError;
	}

	void setError( Boolean error )
	{
		hasError = error;

		// Error an Parent melden
		if (myParent != null) myParent.setError(error);
	}

	Boolean getException()
	{
		return hasException;
	}

	void setException( Boolean exception )
	{
		hasException = exception;

		// Error an Parent melden
		if (myParent != null) myParent.setException(exception);
	}

	protected String getCSS_Class()
	{
		String lvsReturn = "";

		if (myCSS_Class != null && !myCSS_Class.isEmpty())
		{
			lvsReturn = "class='" + myCSS_Class + "'";
		}

		return lvsReturn;
	}

	public Integer getLevel()
	{

		Integer lviReturn = 0;

		if (myParent == null)
		{
			lviReturn++;
		}
		else
		{
			lviReturn = myParent.getLevel();
			lviReturn++;
		}

		return lviReturn;
	}

	public Integer getLevel( Integer Level )
	{

		Integer lviReturn = 0;

		if (myParent != null)
		{
			myParent.getLevel(Level);
		}
		else
		{
			lviReturn++;
		}

		return lviReturn;
	}

	public String getHTML()
	{
		String lvsReturn = "";
		
		String lvsDIV_Begin = String.format("%s<div %s>\n", this.getIndention(), this.getCSS_Class());
		String lvsDIV_Content = String.format("%s%s", this.getIndention(), this.getContent());
		
		String lvsDIV_Children = "";
		
		for ( LogBase lvChild : this.myChildren )
		{
			lvsDIV_Children = lvsDIV_Children + lvChild.getHTML();
		}
		
		String lvsDIV_End = String.format("%s</div>\n", this.getIndention());

		return lvsReturn;
	}
}
