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
		//Nur Inkrementieren wenn dieser testfall noch nicht als Fail markiert wurde.
		if(!(this.bError || this.bException) )
		{
			TestcaseFail++;
		}
	}

	protected void SetPass()
	{
		TestcasePass++;
	}
}
