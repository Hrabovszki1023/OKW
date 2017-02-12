package okw;

public class OKW_TimeOut
{
  private Integer PollingTime;
  private Integer TimeOut;
  
  public Integer getPollingTime()
  {
    return PollingTime;
  }

  public void setPT( Integer pollingTime )
  {
    PollingTime = pollingTime;
  }

  public Integer getTimeOut()
  {
    return TimeOut;
  }

  public void setTO( Integer timeOut )
  {
    TimeOut = timeOut;
  }

  public Integer getMaxCount()
  {
    return TimeOut * 1000 / PollingTime;
  }
}
