package okw.gui.adapter.selenium;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.*;

import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.*;
import okw.log.Logger_Sngltn;
import okw.LogMessenger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class SeAnyWin extends AnyWinBase implements IGUI
{

	protected Integer SleepForMillis =  1000; 
	protected Integer MaxWaitMilis   = 30000;     
	
    // Logger Instance holen
    protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();
    
    protected OKW_WaitForValue MyWaitForValue = new OKW_WaitForValue(this);

    protected LogMessenger LM = new LogMessenger("GUI");

    public SeAnyWin(String Locator, OKWLocator... fpLocators)
    {
    	super(Locator, fpLocators);
    }


    /// \~german
    /// \brief
    /// Klickt auf das aktuelle Objekt.
    /// 
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public void ClickOn()
    {
        try
        {
            this.LogFunctionStartDebug("ClickOn");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.ClickOn()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            this.Me().click();
        }
        finally
        {
            this.LogFunctionEndDebug();
        }

        return;
    }

    /// \~german
    /// \brief
    /// Prüft die Existenz des Aktuellen Objektes.
    /// 
    /// \returntrue, falls das Objekt vorhanden ist, sonst false\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public Boolean getExists()
    {
        this.MyLogger.LogFunctionStartDebug("getExists");
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.Me();
            lvbReturn = true;
            bOK = true;
        }
        catch (OKWGUIObjectNotFoundException e)
        {
            this.MyLogger.LogPrintDebug("NoSuchElementException");
            lvbReturn = false;
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }
        
        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Prüft, ob das aktuellen Objekt aktiv ist.
    /// 
    /// \returntrue, falls das Objekt aktive ist, sonst false\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.19
    public Boolean getIsActive()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;
        String lvDisabled = "";

        try
        {
            this.MyLogger.LogFunctionStartDebug("getIsActive");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.GetIsActive()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            lvDisabled = this.Me().getAttribute("disabled");

            if (lvDisabled == null || lvDisabled != "true")
            {
                lvbReturn = true;
            }
            else
            {
                lvbReturn = false;
            }

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean LogExists()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("LogExists");

            lvbReturn = this.getExists();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt, ob das aktuelle Objket Aktiv ist.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean LogIsActive()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("LogIsActive");

            lvbReturn = this.getIsActive();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt aus dem gegebenen Locator das DOM-Elelement, welches das Objekt representiert.
    /// 
    /// \returnRefernz auf das gefunde DOM-Element\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public WebElement Me()
    {
        this.MyLogger.LogFunctionStartDebug("Me");
        WebElement me = null;

        List<WebElement> meme = null;
        //// OKWIni.Instance.TimeOutExists;

        try
        {
            //me = SeDriver.Instance.driver.FindElement(By.XPath(this.Locator));
            meme = SeDriver.getInstance().driver.findElements(By.xpath(this.getLocator()));
            
            if (meme.size() == 0)
            {
                String lvsPrintMe = "GUI-Objekt wurde nicht gefunden: Locator: >>" + this.getLocator() + "<<";
                
                this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );
                this.MyLogger.LogPrint( lvsPrintMe );
                this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );

                throw new OKWGUIObjectNotFoundException( lvsPrintMe );
            }
            else if (meme.size() > 1)
            {
                String lvsPrintMe = "Locator ist nicht eindeutig, es wurden mehrer GUI-Objekt gefunden:\n Locator: >>" + this.getLocator() + "<<";
                
                this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );
                this.MyLogger.LogPrint( lvsPrintMe );
                this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );

                throw new OKWGUIObjectNotFoundException( lvsPrintMe );
            }
            else
            {
                me = meme.get(0);
            }
        }
        finally
        {
            if (me != null)
            {
                this.MyLogger.LogFunctionEndDebug(me.toString());
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return me;
    }

    /// \~german
    /// \brief
    /// Ermittelt ob das Atuelle Objekt existiert, für das Schlüsselwort MerkeVorhanden.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeExist-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean MemorizeExists()
    {
        Boolean bOK = false;
        Boolean lvbReturn = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("MemorizeExists");

            lvbReturn = this.getExists();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt für das Schlüsselwort MerkeIstAktive, ob das aktuelle Objekt aktiv ist.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeIstAktive-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return true, falls das aktuelle Objekt aktiv ist, sonst false/// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.19
    public Boolean MemorizeIsActive()
    {
        Boolean bOK = false;
        Boolean lvbReturn = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("MemorizeIsActive");

            lvbReturn = this.getIsActive();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Prüft die nicht Existenz des aktuellen Objektes.
    /// __Anmerkung:__ Falls ein Objekt zunächst noch vorhand ist und dann aber verschwindet,
    /// dann es sinnvoll sein eine gewisse Zeit(Timeout) zu prüfen, ob das Objekt existiert,
    /// Erst wenn diese Zeit verstrichen ist, wird gemeldet, das das Objekt nicht vorhanden ist.
    /// Diese Funktion ist der gegenspieler zu __Exists.
    /// 
    /// \returntrue, falls das Objekt NICHT vorhanden ist. Sonst false\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public Boolean NotExists()
    {
        this.MyLogger.LogFunctionStartDebug("Exists");
        Boolean lvb_Return = false;
        Boolean bOK = false;

        try
        {
            this.Me();
            lvb_Return = true;
            bOK = true;
        }
        catch (NoSuchElementException e)
        {
            this.MyLogger.LogPrint("NoSuchElementException");
            lvb_Return = true;
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvb_Return);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvb_Return;
    }

    /// \~german
    /// \brief
    /// Setzt den Focus auf das Objekt.
    /// __Anmerkung:__ Kleiner Trick: Selenium kennt keine öffentliche c#-Methode
    /// für das setzen des Fokus. So weit ich es verstanden habe, wird intern jedoch
    /// methode SetFocus verwendt, wenn <tt>SendKeys</tt> aufgerufen wird.
    /// Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
    /// 
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public void SetFocus()
    {
        this.LogFunctionStartDebug("SetFocus");

        try
        {
            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SetFocus()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }
            
            this.Me().sendKeys("");
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
        
        return;
    }

    /// \~german
    /// \brief
    /// Tastatur Eingabe an das Objekt
    /// 
    /// \param fps_Values'>
    /// Werte, die via Tastatur eingegeben werden sollen.
    /// 
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.04.11
    public void TypeKey(ArrayList<String> fps_Values)
    {
        try
        {
            this.LogFunctionStartDebug("TypeKey", "fps_Values", fps_Values.toString());

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.TypeKey()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            // We are using a local-Variable to prevent multiple call of Me() in foreach-loop
            WebElement lv_WebElement = this.Me();

            // Loop through all List-Values with foreach...
            for (String lvsValue : fps_Values)
            {
                Logger_Sngltn.getInstance().LogPrintDebug(">>" + lvsValue + "<<");
                lv_WebElement.sendKeys(lvsValue);
            }
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
        
        return;
    }

    /// \~german
    /// \brief
    /// Ermittelt/Prüft, ob das aktuelle Objekt existiert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \param fpbExpectedValue Erwarteter Wert.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// 
    /// \param fpbExpectedValue Erwarteter Wert.
    /// 
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean VerifyExists(Boolean fpbExpectedValue) throws InterruptedException
    {
        this.MyLogger.LogFunctionStartDebug("VerifyExists", "fpbExpectedValue", fpbExpectedValue.toString());

        Boolean lvbReturn = true;
        Boolean bOK = false;

        try
        {
            // Nun mit dem erwarteten Sollwert und GetExists ggf. auf den erwartetetn Wert warten.
            lvbReturn = this.MyWaitForValue.getExists( fpbExpectedValue, SleepForMillis, MaxWaitMilis );

            if (fpbExpectedValue == true && lvbReturn != fpbExpectedValue )
            {
                this.MyLogger.LogPrint( String.format( "Locator: >>{0}<<", this.getLocator()) );
            }
            
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt/Prüft, ob das aktuelle Objekt aktiv ist.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeIstAktive-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \returntrue, falls das Objekt aktiv ist sonst false\return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean VerifyIsActive(Boolean fpbExpectedValue) throws InterruptedException
    {
        this.MyLogger.LogFunctionStartDebug("VerifyIsActive", "fpbExpectedValue", fpbExpectedValue.toString());

        Boolean lvbReturn = true;
        Boolean bOK = false;

        try
        {

            // Nun mit dem erwarteten Sollwert und GetIsActive ggf. auf den erwarteten Wert warten.
            lvbReturn = this.MyWaitForValue.getIsActive( fpbExpectedValue, SleepForMillis, MaxWaitMilis );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips für Prüfewert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> VerifyTooltip(ArrayList<String> fplsExpectedValue) throws InterruptedException
    {
        MyLogger.LogFunctionStartDebug("VerifyTooltip", "fplsExpectedValue", fplsExpectedValue.get(0));

        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
            lvLsReturn = MyWaitForValue.getTooltip( fplsExpectedValue, SleepForMillis, MaxWaitMilis );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des Labels für Prüfewert.
    /// 
    /// \remark Sollte der Erwartetet Wert zunächt nicht mit dem aktuellen Wert nicht übereinstimmen,
    /// dann wird gewartet bis entweder der erwartete Wert sich im GUI objekt einstellt
    /// oder der TimeOut erreicht wird.<br/>
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \param fplsExpectedValue'>Erwarteter Wert, auf den ggf. bis zum TimeOut gewartet wird.
    /// \return
    /// Rückgabe des Textuellen Inhaltes des Labels.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> VerifyLabel(ArrayList<String> fplsExpectedValue) throws InterruptedException
    {
        MyLogger.LogFunctionStartDebug("VerifyLabel", "fplsExpectedValue", fplsExpectedValue.get(0));

        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
            lvLsReturn = MyWaitForValue.getLabel( fplsExpectedValue, SleepForMillis, MaxWaitMilis );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    
    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> getTooltip()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;
        try
        {
            MyLogger.LogFunctionStartDebug("GetTooltip");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetTooltip()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }
            
            // The Attribute "Title" is shown as Tooltip...
            lvLsReturn.add(this.Me().getAttribute("title"));
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }
        
        return lvLsReturn;
    }

    
    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des Labels.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Labels.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.06.17
    public ArrayList<String> getLabel()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;
        try
        {
            MyLogger.LogFunctionStartDebug("GetLabel");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetLabel()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }
            
            // 1. Schritt: Attribute "id" is shown as Tooltip...
            String lvsID = this.Me().getAttribute("id");
            
            // 2.schritt nun Tag Label mit for= "${lvsID}" finden.
            WebElement label = SeDriver.getInstance().driver.findElement(By.xpath( "//label[@for='" + lvsID + "']" ));
            lvLsReturn.add(label.getAttribute("textContent"));
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }
        
        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Logt den textuellen Inhalt des ToolTips.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> LogTooltip()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("LogTooltip");

            lvLsReturn = this.getTooltip();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Logt den textuellen Inhalt des Labels eines Objektes.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> LogLabel()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("LogLabel");

            lvLsReturn = this.getLabel();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> MemorizeTooltip()
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = null;

        try
        {
            MyLogger.LogFunctionStartDebug("MemorizeTooltip");

            lvLsReturn = this.getTooltip();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des Labels für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> MemorizeLabel()
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = null;

        try
        {
            MyLogger.LogFunctionStartDebug("MemorizeLabel");

            lvLsReturn = this.getLabel();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Methode liefert den aktuellen Zustand Wert des Focus.
    /// Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
    /// 
    /// \return\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public Boolean getHasFocus()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.LogFunctionStartDebug("getHasFocus");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "getHasFocus()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            WebElement currentElement = SeDriver.getInstance().driver.switchTo().activeElement();

            lvbReturn = currentElement.equals(this.Me());
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \brief
    /// Ermittelt für LoggeWert, ob das aktuelle Objekt den Fokus hat.
    /// 
    /// Diese Methode ist der Einstiegspunkt für Loggewert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// true falls Objekt den Fokus hat, sonst false
    /// \return
    /// \author Zoltan Hrabovszki
    /// \date 2013.04.11
    public Boolean LogHasFocus()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.LogFunctionStartDebug("LogHasFocus");

            lvbReturn = this.getHasFocus();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt ob das Objekt den Fokus besitz und liefert diesen für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    ///  true falls Objekt den Fokus hat, sonst false
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean MemorizeHasFocus()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.LogFunctionStartDebug("MemorizeHasFocus");

            lvbReturn = this.getHasFocus();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips.
    /// 
    /// Diese Methode ist der Einstiegspunkt für Prüfewert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    ///  true falls Objekt den Fokus hat, sonst false.
    /// \return
    /// \author Zoltan Hrabovszki
    /// \date 2013.04.11
    public Boolean VerifyHasFocus(Boolean fpbExpectedValue) throws InterruptedException
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("VerifyHasFocus", "fpbExpectedValue", fpbExpectedValue.toString());

            // Nun mit dem erwarteten Sollwert und GetHasFocus ggf. auf den Wert Warten.
            lvbReturn = MyWaitForValue.getHasFocus( fpbExpectedValue, SleepForMillis, MaxWaitMilis );
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips für Prüfewert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> VerifyCaption(ArrayList<String> fplsExpectedValue) throws InterruptedException
    {
        MyLogger.LogFunctionStartDebug("VerifyCaption", "fplsExpectedValue", fplsExpectedValue.get(0));

        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {

            // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
            lvLsReturn = MyWaitForValue.getCaption( fplsExpectedValue, SleepForMillis, MaxWaitMilis );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt der Beschriftung (Caption).
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> LogCaption()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("LogCaption");

            lvLsReturn = this.getCaption();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des Caption/Überschrift für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> MemorizeCaption()
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = null;

        try
        {
            MyLogger.LogFunctionStartDebug("MemorizeCaption");

            lvLsReturn = this.getCaption();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }
    
    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt der Caption/Überschrift des Objektes.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> getCaption()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;
        try
        {
            MyLogger.LogFunctionStartDebug("GetCaption");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }
            
            // The Attribute "value" wird als Beschriftung angezeigt...
            lvLsReturn.add(this.Me().getAttribute("textContent"));
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }
        
        return lvLsReturn;
    }
    
    /// \brief
    /// Holt den aktuellen Text aus einem HTML-Tag.
    /// 
    /// Standardmäßig wird "innerText" ausgelesen.
    /// 
    /// \return
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            this.LogFunctionStartDebug("getValue");

            // Get Value from TextField and put this into the return ArrayList<String>
            lvLsReturn.add(this.Me().getAttribute("textContent"));
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.LogFunctionEndDebug(lvLsReturn.toString());
            }
            else
            {
                this.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /**
     *  \brief
     *  Ermittelt den Wert des Objktes für das Schlüsselwort Loggewert.
     *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen
     *  durch Methoden überschreibung.
     *  \return
     *  Rückgabe des Textuellen Inhaltes der markierten Textes.
     *  \return
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.14
     */
    public ArrayList<String> LogValue()
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            MyLogger.LogFunctionStartDebug("LogValue");
            lvLsReturn = this.getValue();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den Wert, im Allgemeinen den textuellen Inhalt eines Objektes
    /// für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes des aktuellen Objektes.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.14
    public ArrayList<String> MemorizeValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("Memorize");
            lvLsReturn = this.getValue();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \brief
    /// Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der markierten Textes.
    /// Es wird immer der aktuelle Wert des Objektes zurückgeliefert.
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.14
    @Deprecated
    public ArrayList<String> VerifyValue(ArrayList<String> fplsExpectedValue) throws InterruptedException
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("Memorize", "fplsExpectedValue", fplsExpectedValue.get(0));

            // Nun mit dem erwarteten Sollwert und GetValue ggf. auf den Wert Warten.
            lvLsReturn = MyWaitForValue.getValue( fplsExpectedValue, SleepForMillis, MaxWaitMilis );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \brief
    /// Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der markierten Textes.
    /// Es wird (immer) der aktuelle Wert des Objektes zurückgeliefert.
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.14
    public ArrayList<String> VerifyValue( ) throws InterruptedException
    {
        ArrayList<String> lvLsReturn = null;
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("VerifyValue");

            // get the Actual Value.
            lvLsReturn = this.getValue(  );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

}
