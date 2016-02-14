package okw.log.log2html;

public class LogWarning extends LogBase
{

	public LogWarning(LogBase fpMyParent, String fpsMessage)
	{

		this.myParent = fpMyParent;
		this.myMainRow = null;

		this.myCSS_Class = "Warning";

		this.setWarning(true);

	}

}
