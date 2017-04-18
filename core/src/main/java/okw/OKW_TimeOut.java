package okw;

public class OKW_TimeOut
{
  private Integer PT;
  private Integer TO;
  
  public OKW_TimeOut( Integer fpsTO, Integer fpsPT )
  {
      setPT( fpsPT );
      setTO( fpsTO );
  }
    
  /**
   * Wartezeit zwischen zwei Pollings in [ms]
   * @return
   */
  public Integer getPT()
  {
    return PT;
  }

  public void setPT( Integer pollingTime )
  {
    PT = pollingTime;
  }

  /**
   * Timeout Zeit in [s]. - Maximale zeit die gewarete werden soll.
   * @return
   */
  public Integer getTO()
  {
    return TO;
  }

  public void setTO( Integer timeOut )
  {
    TO = timeOut;
  }

  /**
   * Anzahl der berechnetten Zyklen.
   * @return
   */
  public Integer getMaxCount()
  {
    return TO * 1000 / PT;
  }
}
