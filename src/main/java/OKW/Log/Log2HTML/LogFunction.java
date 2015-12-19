package OKW.Log.Log2HTML;

public class LogFunction extends LogBase
{

	public LogFunction(LogBase fpMyParent, String fpsFunktionName)
	{
		this.myParent = fpMyParent;

		this.myMainRow = fpsFunktionName;
		this.myMessage = null;
	}
}
