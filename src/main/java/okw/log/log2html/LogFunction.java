package okw.log.log2html;

public class LogFunction extends LogBase
{

	public LogFunction(LogBase fpMyParent, String fpsFunktionName)
	{
		this.myParent = fpMyParent;

		this.myMainRow = fpsFunktionName;
		this.myMessage = null;
	}
}
