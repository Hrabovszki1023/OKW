package okw.log.log2html;

public class LogTestcase extends LogBase
{

	LogTestcase(LogBase Parent, String fpsTestcaseName)
	{
		setParent(Parent);
		myID = AllCount;
				
		this.Info = "Testcase: " + fpsTestcaseName;
		
	}
	
	protected void SetFail()
	{
		TestcaseFail++;
	}

	protected void SetPass()
	{
		TestcasePass++;
	}
}
