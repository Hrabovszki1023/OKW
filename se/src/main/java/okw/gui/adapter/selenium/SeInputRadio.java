package okw.gui.adapter.selenium;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import okw.OKW_Const_Sngltn;
import okw.core.Core;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWNotAllowedValueException;
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

  /** \~german
   *  \brief
   *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
   *   
   *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2013.12.07
   */
  @Override
  public ArrayList<String> getCaption()
  {
      try
      {
          this.LogFunctionStartDebug("getCaption");
          // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
    	  throw new OKWFrameObjectMethodNotImplemented("Radiobutton/SeInputRadion has no Caption! - See Label...");
      }
      finally
      {      
          this.LogFunctionEndDebug( );
      }
  }

  /**
   * \~german
   *  Ein SeInputButton IstkeinMenüobject! -> OKWFrameObjectMethodNotImplemented
   *  Auslösen!
   *
   * \~english
   *  A SeInputButton has no value! -> Trigger
   *  OKWFrameObjectMethodNotImplemented!
   * \~
   * @author Zoltán Hrabovszki
   * @date 2016.10.06
   */
  @Override
  public void SetValue( ArrayList<String> Values ) throws XPathExpressionException, Exception
  {

    try
    {
      MyLogger.LogFunctionStartDebug( "SetValue" );
      
      String Value = Values.get(0);
      String myCHECKED = OKW_Const_Sngltn.getInstance().GetConst4Internalname("CHECKED");
      String myUNCHECKED = OKW_Const_Sngltn.getInstance().GetConst4Internalname("UNCHECKED");

      // Wenn das Objekt nicht existiert mit Exception beenden...
      if (!this.getExists())
      {
          String lvsLM = LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetValue()");
          throw new OKWGUIObjectNotFoundException(lvsLM);
      }

      if ( Value.equals(myCHECKED) )
      {
          Core myCore = new Core();
          myCore.ClickOn( this.GetFN() ); // 
      }
      else if ( Value.equals(myUNCHECKED) )
      {
          throw new OKWNotAllowedValueException("RadioButton is not UNCHECKE-able!");
      }
      else
      {
          String lvsLM = LM.GetMessage("Common", "OKWNotAllowedValueException", Value);
          throw new OKWNotAllowedValueException(lvsLM);
      }
    }
    finally
    {
      MyLogger.LogFunctionEndDebug();
    }
  }


  /** \~german
   *  Methode liefert den aktuellen Zustand Wert des Focus.
   *  
   *  @see http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2016.12.20
   */
  @Override
  public Boolean getHasFocus()
  {
	      try
	      {
	          this.LogFunctionStartDebug("getHasFocus");
	          // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
	    	  throw new OKWFrameObjectMethodNotImplemented("The Radiobutton/SeInputRadion don´t has a focos, The RadioList has the focus.");
	      }
	      finally
	      {      
	          this.LogFunctionEndDebug( );
	      }
	  }
  
  /** \~german
   *  Diese Implemnetierung geht davon aus das ein RadioButten 
   *  selbst keinen Focus besitzen kann sondern die RadiList, die dieser angehört.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2013.11.11
   */
  @Override
  public void SetFocus()
  {
      try
      {
          this.LogFunctionStartDebug("SetFocus");
          // String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
    	  throw new OKWFrameObjectMethodNotImplemented("The Radiobutton/SeInputRadion itself can not have a focus, the RadioList has the focus. Please use VerifyHasFosus with the RadioList!");
      }
      finally
      {      
          this.LogFunctionEndDebug( );
      }
  }
}
