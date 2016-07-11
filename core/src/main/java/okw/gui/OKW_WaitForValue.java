package okw.gui;

import java.util.ArrayList;

public class OKW_WaitForValue
{
  IGUI myObject;

  private static Integer CalculateLoopCount( Integer SleepForMillis,
      Integer MaxWaitMilis )
  {
    Integer lviReturn = MaxWaitMilis / SleepForMillis;

    return lviReturn;
  }

  public OKW_WaitForValue( IGUI GUIObject )
  {
    myObject = GUIObject;
  }

  
  public ArrayList<String> getCaption( ArrayList<String> Expected,
      Integer SleepForMillis, Integer MaxWaitMilis )
      throws InterruptedException
  {
    ArrayList<String> ALReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      ALReturn = myObject.getCaption();

      if ( Expected.equals( ALReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }
      Count++;
    }

    return ALReturn;
  }

  public ArrayList<String> getValue( ArrayList<String> Expected,
                                               Integer SleepForMillis,
                                               Integer MaxWaitMilis
                                   ) throws InterruptedException
  {
    ArrayList<String> ALReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      ALReturn = myObject.getValue();

      if ( Expected.equals( ALReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return ALReturn;
  }

  public Boolean getExists( Boolean Expected, Integer SleepForMillis,
      Integer MaxWaitMilis ) throws InterruptedException
  {
    Boolean bReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      bReturn = myObject.getExists();

      if ( Expected.equals( bReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return bReturn;
  }

  public Boolean getIsActive( Boolean Expected, Integer SleepForMillis,
      Integer MaxWaitMilis ) throws InterruptedException
  {
    Boolean bReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      bReturn = myObject.getIsActive();

      if ( Expected.equals( bReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return bReturn;
  }

  
  public Boolean getHasActive( Boolean Expected, Integer SleepForMillis,
      Integer MaxWaitMilis ) throws InterruptedException
  {
    Boolean bReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      bReturn = myObject.getHasFocus();

      if ( Expected.equals( bReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return bReturn;
  }

  
  public Boolean getHasFocus( Boolean Expected, Integer SleepForMillis,
      Integer MaxWaitMilis ) throws InterruptedException
  {
    Boolean bReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      bReturn = myObject.getHasFocus();

      if ( Expected.equals( bReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return bReturn;
  }

  public ArrayList<String> getLabel( ArrayList<String> Expected,
      Integer SleepForMillis, Integer MaxWaitMilis )
      throws InterruptedException
  {
    ArrayList<String> ALReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      ALReturn = myObject.getLabel();

      if ( Expected.equals( ALReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return ALReturn;
  }

  public ArrayList<String> getTooltip( ArrayList<String> Expected,
      Integer SleepForMillis, Integer MaxWaitMilis )
      throws InterruptedException
  {
    ArrayList<String> ALReturn = null;

    Integer MaxCount = CalculateLoopCount( SleepForMillis, MaxWaitMilis );

    Integer Count = 0;

    while ( Count <= MaxCount )
    {
      ALReturn = myObject.getTooltip();

      if ( Expected.equals( ALReturn ) )
      {
        break;
      }
      else
      {
        Thread.sleep( SleepForMillis );
      }

      Count++;
    }

    return ALReturn;
  }

}