package okw.gui.adapter.selenium;

import java.util.ArrayList;

import okw.OKW_Const_Sngltn;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.OKWLocator;

public class SeInputRadio extends SeSimpleDataObjBase
{

  public SeInputRadio( String Locator, OKWLocator... fpLocators )
  {
    super(Locator, fpLocators);// TODO Auto-generated constructor stub
  }

  /** Ermittelt den aktuellen Wert des RadioButtons.
   * 
   * Mögliche Werte sind sprachabhängig CHECKED/UNCHECKED
   * 
   * @return Liefert im ersten Wert des ArrayList&lt;String&gt; sprachabhängig CHECKED/UNCHECKED zurück.
   * @author Zoltan Hrabovszki
   * @date 2013.04.11
   */
  @Override
  public ArrayList<String> getValue()
  {
      ArrayList<String> lvls_Return = new ArrayList<String>();
      Boolean bOK = false;
      try
      {
          this.LogFunctionStartDebug("getValue");

          // Wenn das Objekt nicht existiert mit Exception beenden...
          if (!this.getExists())
          {
              String lvsLM = LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetValue()");
              throw new OKWGUIObjectNotFoundException(lvsLM);
          }

          if (this.IsSelected())
          {
              String lvsValue = OKW_Const_Sngltn.getInstance().GetConst4Internalname("CHECKED");
              lvls_Return.add(lvsValue);
          }
          else
          {
              String lvsValue = OKW_Const_Sngltn.getInstance().GetConst4Internalname("UNCHECKED");
              lvls_Return.add(lvsValue);
          }

          bOK = true;
      }
      finally
      {
          if (bOK)
          {
              this.LogFunctionEndDebug();
          }
          else
          {
              this.LogFunctionEndDebug(lvls_Return);
          }
      }

      return lvls_Return;
  }
  
  /**
   *  Method liefert den aktuellen Zustand des RadioButtons,
   *  ausgewählt oder nicht.
   *  
   *  @return Wenn Ausgewählt: true, sonst false
   *  @author Zoltan Hrabovszki
   *  @date 2013.04.11
   */
  public Boolean IsSelected()
  {
      Boolean bOK = false;
      Boolean lvbReturn = false;
      
      this.LogFunctionStartDebug("IsSelected");

      try
      {
          // Hole Zusand: Häckchen oder kein Häckchen, das ist hier die Frage?
          lvbReturn = this.Me().isSelected();
          bOK = true;
      }
      finally
      {
          if (bOK)
          {
              this.LogFunctionEndDebug(lvbReturn);
          }
          else
          {
              this.LogFunctionEndDebug( );
          }
      }
      return lvbReturn;
  }
}
