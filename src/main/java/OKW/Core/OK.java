/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
      www.OpenKeyWord.de
    ============================================================================== 

    This file is part of OpenKeyWord.

    OpenKeyWord is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenKeyWord is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

    Diese Datei ist Teil von OpenKeyWord.

    OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
    der GNU General Public License, wie von der Free Software Foundation,
    Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
    veröffentlichten Version, weiterverbreiten und/oder modifizieren.

    OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
    OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
    Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
    Siehe die GNU General Public License für weitere Details.

    Sie sollten eine Kopie der GNU General Public License zusammen mit 
    OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
*/

package OKW.Core;

import OKW.Log.*;
import OKW.ANTLR4;
import OKW.CurrentObject;
import OKW.LogMessenger;
import OKW.OKWLanguage;

/// \~german
/// \brief
/// Klasse OK representiert den Core Zustand OK.
/// 
/// Testausführung mit GUI-Aktivität und es ist keine Exception ausgelöst worden.
/// 
/// \~english
/// \~
/// \author Zoltán Hrabovszki
/// \date 2013.03.02
public class OK implements IOKW_State
{

	OKWLanguage						AL			= OKWLanguage.getInstance();

	/// \copydoc CurrentObject::Log()
	private static Logger			Log			= Logger.getInstance();

	/// \copydoc CurrentObject::LM()
	private static LogMessenger		LM			= new LogMessenger("OK");

	private static CurrentObject	CO			= CurrentObject.getInstance();

	OKW_Docu						MyOKWDocu	= OKW_Docu.Instance;

	Boolean							UNITTEST	= true;

	Core							_Kernel;

	/// \~german
	/// \brief
	/// Klasse representiert den Zustand "OK" des OKW-Kerns im Ausführungsmodus.
	///
	/// \~english
	/// \brief
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 09.01.2014
	public OK(Core fp_OKW)
	{
		this._Kernel = fp_OKW;
	}

	private Object GetType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/// \~german
	/// \copydoc IOKW_State::BeginTest()
	/// \~english
	/// \copydoc IOKW_State::BeginTest()
	///
	public void BeginTest( String fpsTestname )
	{
		Log.LogFunctionStart("BeginTest", "fpsTestname", fpsTestname);

		Log.LogFunctionEnd();
	}

	/// \~german
	/// \copydoc IOKW_State::ClickOn(string)
	/// \~english
	/// \copydoc IOKW_State::ClickOn(string)
	///
	public void ClickOn( String fpsFunctionalname )
	{
		Log.LogFunctionStart("ClickOn", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("ClickOn");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::ClickOn(string,string)
	/// \~english
	/// \copydoc IOKW_State::ClickOn(string,string)
	///
	public void ClickOn( String fpsFunctionalname, String fpsClickType )
	{
		Log.LogFunctionStart("ClickOn", "fpsFunctionalname", fpsFunctionalname, "fpsClickType", fpsClickType);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("ClickOn_Clicktype", fpsClickType);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::EndTest()
	/// \~english
	/// \copydoc IOKW_State::EndTest()
	///
	public void EndTest()
	{
		Log.LogFunctionStart("EndTest");

		Log.LogFunctionEnd();
	}

	/// \~german
	/// \copydoc IOKW_State::LogCaption(string)
	/// \~english
	/// \copydoc IOKW_State::LogCaption(string)
	///
	public void LogCaption( String fpsFunctionalname )
	{
		Log.LogFunctionStart("LogCaption", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<String> ActualValues = CO.CallMethodReturn_ListString("LogCaption");

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogExists(string)
	/// \~english
	/// \copydoc IOKW_State::LogExists(string)
	///
	public void LogExists( String fpsFunctionalname )
	{
		Log.LogFunctionStart("LogExists", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			Boolean lvbActual = CO.CallMethodReturn_Boolean("LogExists");
			String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

			String lvsLM = this.LM.GetMessage("LogExists", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogHasFocus(string)
	/// \~english
	/// \copydoc IOKW_State::LogHasFocus(string)
	///
	public void LogHasFocus( String fpsFunctionalname )
	{
		Log.LogFunctionStart("LogHasFocus", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			bool lvbActual = CO.CallMethodReturn_Boolean("LogHasFocus");
			String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

			String lvsLM = this.LM.GetMessage("LogIsActive", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogIsActive(string)
	/// \~english
	/// \copydoc IOKW_State::LogIsActive(string)
	///
	public void LogIsActive( String fpsFunctionalname )
	{
		Log.LogFunctionStart("LogIsActive", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			bool lvbActual = CO.CallMethodReturn_Boolean("LogIsActive");

			String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

			String lvsLM = this.LM.GetMessage("LogIsActive", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogLabel(string)
	/// \~english
	/// \copydoc IOKW_State::LogLabel(string)
	///
	public void LogLabel(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogLabel",
				"fpsFunctionalname", fpsFunctionalname);

			try {
				CO.SetChildName(fpsFunctionalname);
				List<string> ActualValues = CO.CallMethodReturn_ListString("LogLabel");

				Log.ResOpenList("Log... ");

				foreach (String Value in ActualValues) {
					Log.LogPrint(">>" + Value + "<<");
				}

				Log.ResCloseList();
			} catch (Exception e) {
				this.HandleException(e);
			} finally {
				Log.LogFunctionEnd();
			}
		}

	/// \~german
	/// \copydoc IOKW_State::LogSelected(string)
	/// \~english
	/// \copydoc IOKW_State::LogSelected(string)
	///
	public void LogSelected(String fpsFunctionalname)
		{
			Log.LogFunctionStart(
				"LogSelected",
				"fpsFunctionalname",
				fpsFunctionalname);

			try {
				CO.SetChildName(fpsFunctionalname);
				List<string> actualValues = CO.CallMethodReturn_ListString("LogSelected");

				String lvsLM = this.LM.GetMessage("LogSelected", "LogValue");

				Log.LogPrint(lvsLM);

				Log.ResOpenList(lvsLM);

				foreach (String Value in actualValues) {
					Log.LogPrint("'" + Value + "'");
				}

				Log.ResCloseList();
			} catch (Exception e) {
				this.HandleException(e);
			} finally {
				Log.LogFunctionEnd();
			}
		}

	/// \~german
	/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
	///
	public void LogTablecellValue(String fpsFunctionalname, String fpsCol, String fpsRow)
		{
			Log.LogFunctionStart(
				"LogTablecellValue",
				"fpsCol", fpsCol,
				"fpsRow", fpsRow,
				"fpsFunctionalname", fpsFunctionalname);

			try {
				CO.SetChildName(fpsFunctionalname);
				List<string> ActualValues = CO.CallMethodReturn_ListString("LogTablecellValue", fpsCol, fpsRow);

				Log.ResOpenList("Log... ");

				foreach (String Value in ActualValues) {
					Log.LogPrint(">>" + Value + "<<");
				}

				Log.ResCloseList();
			} catch (Exception e) {
				this.HandleException(e);
			} finally {
				Log.LogFunctionEnd();
			}
		}

	/// \~german
	/// \copydoc IOKW_State::LogTooltip(string)
	/// \~english
	/// \copydoc IOKW_State::LogTooltip(string)
	///
	public void LogTooltip(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogTooltip",
				"fpsFunctionalname", fpsFunctionalname);

			try {
				CO.SetChildName(fpsFunctionalname);
				List<string> ActualValues = CO.CallMethodReturn_ListString("LogTooltip");

				Log.ResOpenList("Log... ");

				foreach (String Value in ActualValues) {
					Log.LogPrint(">>" + Value + "<<");
				}

				Log.ResCloseList();
			} catch (Exception e) {
				this.HandleException(e);
			} finally {
				Log.LogFunctionEnd();
			}
		}

	/// \~german
	/// \copydoc IOKW_State::LogValue(string)
	/// \~english
	/// \copydoc IOKW_State::LogValue(string)
	///
	public void LogValue(String fpsFunctionalname)
		{
			Log.LogFunctionStart("LogValue",
				"fpsFunctionalname", fpsFunctionalname);

			try {
				CO.SetChildName(fpsFunctionalname);
				List<string> ActualValues = CO.CallMethodReturn_ListString("LogValue");

				Log.ResOpenList("Log... ");

				foreach (String Value in ActualValues) {
					Log.LogPrint(">>" + Value + "<<");
				}

				Log.ResCloseList();
			} catch (Exception e) {
				this.HandleException(e);
			} finally {
				Log.LogFunctionEnd();
			}
		}

	/// \~german
	/// \copydoc IOKW_State::MemorizeCaption(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeCaption(string,string)
	///
	public void MemorizeCaption( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeCaption", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeCaption");

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeExists(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeExists(string,string)
	///
	public void MemorizeExists( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeExists", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fps_MemKeyName == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fps_MemKeyName == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(this.LM.GetMessage("MemorizeExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				CO.SetChildName(fpsFunctionalname);
				bool lvbActual = CO.CallMethodReturn_Boolean("MemorizeExists");

				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				OKW_Memorize.Instance.Set(fps_MemKeyName, lvsActual);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
	///
	public void MemorizeHasFocus( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeHasFocus", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fps_MemKeyName == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fps_MemKeyName == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(this.LM.GetMessage("MemorizeHasFocus", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				CO.SetChildName(fpsFunctionalname);
				bool lvbActual = CO.CallMethodReturn_Boolean("MemorizeHasFocus");

				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				OKW_Memorize.Instance.Set(fps_MemKeyName, lvsActual);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeIsActive(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeIsActive(string,string)
	///
	public void MemorizeIsActive( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeIsActive", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			bool lvbActual = CO.CallMethodReturn_Boolean("MemorizeIsActive");

			String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsActual);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	///
	public void MemorizeLabel( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeLabel", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeLabel");

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
	///
	public void MemorizeSelectedValue( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeSelectedValue", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeSelectedValue");

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
	///
	public void MemorizeTablecellValue( String fpsFunctionalname, String fpsCol, String fpsRow, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeTablecellValue", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol,
				"fpsRow", fpsRow, "fps_MemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeTablecellValue", fpsCol, fpsRow);

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeTooltip(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeTooltip(string,string)
	///
	public void MemorizeTooltip( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeTooltip", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeTooltip");

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	///
	public void MemorizeValue( String fpsFunctionalname, String fps_MemKeyName )
	{
		Log.LogFunctionStart("MemorizeValue", "fpsFunctionalname", fpsFunctionalname, "fpsMemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			List<string> ActualValues = CO.CallMethodReturn_ListString("MemorizeValue");

			String lvsToMemorize = OKW_Const.Instance.ConcatSEP(ActualValues);

			OKW_Memorize.Instance.Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::Select(string,string)
	/// \~english
	/// \copydoc IOKW_State::Select(string,string)
	///
	public void Select( String fpsFunctionalname, String fpsValue )
	{
		Log.LogFunctionStart("Select", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				// Sonst Methode des Objektes aufrufen....
				List<string> lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("Select", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}

		return;
	}

	/// \~german
	/// \copydoc IOKW_State::Select(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::Select(string,string,string)
	///
	public void Select( String fpsFunctionalname, String fpsValue, String fpsClickType )
	{
		Log.LogFunctionStart("Select", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue, "fpsClickType",
				fpsClickType);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				List<string> lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);

				// TODO: Select - Sprachabhängigkeit von KlickType einbauen...
				CO.CallMethod("Select_Clicktype", lvlsValue, fpsClickType);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectMenu(string)
	/// \~english
	/// \copydoc IOKW_State::SelectMenu(string)
	///
	public void SelectMenu( String fpsFunctionalname )
	{
		Log.LogFunctionStart("SelectMenu", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectMenu");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectMenu(string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectMenu(string,string)
	///
	public void SelectMenu( String fpsFunctionalname, String fpsValue )
	{
		Log.LogFunctionStart("SelectMenu", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		List<string> lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectMenu_Value", lvlsValue);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectTablecell(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectTablecell(string,string,string)
	///
	public void SelectTablecell( String fpsFunctionalname, String fpsCol, String fpsRow )
	{
		Log.LogFunctionStart("SelectTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow);

		//// List<string> lvls_Cell = LogMessenger.Instance.SplitSEP(fpsCell);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectTablecell", fpsCol, fpsRow);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
	///
	public void SelectTablecell( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsClickType )
	{
		Log.LogFunctionStart("SelectTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow, "fpsClickType", fpsClickType);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectTablecell_Clicktype", fpsCol, fpsRow, fpsClickType);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectWindow(string)
	/// \~english
	/// \copydoc IOKW_State::SelectWindow(string)
	///
	public void SelectWindow( String fpsFunctionalname )
	{
		Log.LogFunctionStart("SelectWindow", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetWindowName(fpsFunctionalname);
			CO.CallMethod("SelectWindow");
		}
		finally
		{
			Log.LogFunctionEnd();
		}

		return;
	}

	/// \~german
	/// \copydoc IOKW_State::Sequence(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::Sequence(string,string,string)
	///
	public void Sequence( String fpsObjectName, String fpsSequenceName, String SEQ_ID )
	{
		Log.LogFunctionStart("Sequence", "fpsObjectName", fpsObjectName, "fpsSequenceName", fpsSequenceName, "SEQ_ID",
				SEQ_ID);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (SEQ_ID == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || SEQ_ID == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				CO.SetWindowName(fpsObjectName);
				CO.CallMethod(fpsSequenceName, SEQ_ID);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SetFocus(string)
	/// \~english
	/// \copydoc IOKW_State::SetFocus(string)
	///
	public void SetFocus( String fpsFunctionalname )
	{
		Log.LogFunctionStart("SetFocus", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SetFocus");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 02.03.2013
	public void SetLanguage( String Language )
	{
		this.AL.Language = Language;
	}

	/// \~german
	/// \copydoc IOKW_State::SetValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::SetValue(string,string)
	///
	public void SetValue( String fpsFunctionalname, String fpsValue )
	{
		Log.LogFunctionStart("SetValue", "fpsFunctionalname", fpsFunctionalname);

		List<string> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("SetValue", "Ignore"));
			}
			else
			{
				lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("SetValue", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::StartApp(string)
	/// \~english
	/// \copydoc IOKW_State::StartApp(string)
	///
	public void StartApp( String fps_ApplikationName )
	{
		Log.LogFunctionStart("StartApp", "fps_ApplikationName", fps_ApplikationName);

		try
		{
			CO.SetWindowName(fps_ApplikationName);
			CO.CallMethod("StartApp");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::StopApp(string)
	/// \~english
	/// \copydoc IOKW_State::StopApp(string)
	///
	public void StopApp( String fps_ApplikationName )
	{
		Log.LogFunctionStart("StopApp", "fps_ApplikationName", fps_ApplikationName);

		try
		{
			CO.SetWindowName(fps_ApplikationName);
			CO.CallMethod("StopApp");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKey(string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKey(string,string)
	///
	public void TypeKey( String fpsFunctionalname, String fpsValue )
	{
		Log.LogFunctionStart("TypeKey", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		List<string> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("TypeKey", "Ignore"));
			}
			else
			{
				lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("TypeKey", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
	///
	public void TypeKeyTablecell( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsValue )
	{
		Log.LogFunctionStart("TypeKeyTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsColl", fpsCol, "fpsRow",
				fpsRow, "fpsValue", fpsValue);

		List<string> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("TypeKeyTablecell", "Ignore"));
			}
			else
			{
				// Werte in fpsValue separieren
				lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);

				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("TypeKeyTablecell", fpsCol, fpsRow, lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKeyWindow(string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKeyWindow(string,string)
	///
	public void TypeKeyWindow( String fpsFunctionalname, String fpsValue )
	{
		Log.LogFunctionStart("TypeKeyWindow", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE") || fpsValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("TypeKeyWindow", "Ignore"));
			}
			else
			{
				List<string> lvlsValue = OKW_Const.Instance.SplitSEP(fpsValue);
				lvlsValue = MyParser.ParseMe(lvlsValue);

				CO.SetWindowName(fpsFunctionalname);
				CO.CallMethod("TypeKey", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyCaption(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyCaption(string,string)
	///
	public void VerifyCaption( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyCaption", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyCaption", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifyCaption", lvlsExpected);

				// Verify:
				// 1. are the length of the lists equal?
				Log.LogPrint(this.LM.GetMessage("VerifyCaption", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifyCaption", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyExists(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyExists(string,string)
	///
	public void VerifyExists( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyExists", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Hier sind nur drei werte erlaubt: YES/NO/IGNORE

			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("NO"))
			{
				// Sprachabhängiges YES/NO nach bool transformieren
				bool lvsbExpectedValue = OKW_Const.Instance.YesNo2Boolean(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				bool lvbActual = CO.CallMethodReturn_BooleanPb("VerifyExists", lvsbExpectedValue);

				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(this.LM.GetMessage("VerifyExists", "VerifyValue"));

				// LANGUAGE: Prüfen: Sprachabhängigen string-vergleich
				// durchführen...
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da keinanderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = this.LM.GetMessage("VerifyExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyHasFocus(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyHasFocus(string,string)
	///
	public void VerifyHasFocus( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyHasFocus", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyHasFocus", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("NO"))
			{
				// Sprachabhängiges YES/NO nach bool transformieren
				bool lvsbExpectedValue = OKW_Const.Instance.YesNo2Boolean(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				bool lvbActual = CO.CallMethodReturn_BooleanPb("VerifyHasFocus", lvsbExpectedValue);

				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(this.LM.GetMessage("VerifyHasFocus", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);

				// \todo LANGUAGE: Püfen aws dieser eintrag soll:
				// Sprachabhängigen string-vergleich durchführen...
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da keinanderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = this.LM.GetMessage("VerifyExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyIsActive(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyIsActive(string,string)
	///
	public void VerifyIsActive( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyIsActive", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyIsActive", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("NO"))
			{
				CO.SetChildName(fpsFunctionalname);

				// Erwarteten Wert(YES/NO, Sprachabhänging) nach bool wandelen
				bool lvbExpectedValue = OKW_Const.Instance.YesNo2Boolean(fpsExpectedValue);

				// Aktuellen Wert holen...
				bool lvbActual = CO.CallMethodReturn_BooleanPb("VerifyIsActive", lvbExpectedValue);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(this.LM.GetMessage("VerifyIsActive", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = this.LM.GetMessage("VerifyExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyLabel(string,string)
	///
	public void VerifyLabel( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyLabel", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyLabel", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifyLabel", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(this.LM.GetMessage("VerifyLabel", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifyLabel", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifySelectedValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifySelectedValue(string,string)
	///
	public void VerifySelectedValue( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifySelectedValue", "fpsFunctionalname", fpsFunctionalname, "fpsExpected",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifySelectedValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifySelectedValue", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(this.LM.GetMessage("VerifySelectedValue", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifySelectedValue", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
	///
	public void VerifyTablecellValue( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyTablecellValue", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyTablecellValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifyTablecellValue", fpsCol, fpsRow,
						lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(this.LM.GetMessage("VerifyTablecellValue", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifyTablecellValue", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyTooltip(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyTooltip(string,string)
	///
	public void VerifyTooltip( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyTooltip", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyTooltip", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifyTooltip", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(this.LM.GetMessage("VerifyTooltip", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifyTooltip", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyValue(string,string)
	///
	public void VerifyValue( String fpsFunctionalname, String fpsExpectedValue )
	{
		Log.LogFunctionStart("VerifyValue", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(this.LM.GetMessage("VerifyValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				List<string> lvlsExpected = OKW_Const.Instance.SplitSEP(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				List<string> Actual = CO.CallMethodReturn_ListString("VerifyValue", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(this.LM.GetMessage("VerifyValue", "VerifyListCount"));
				Log.LogVerify(Actual.Count.ToString(), lvlsExpected.Count.ToString());

				Log.LogPrint(this.LM.GetMessage("VerifyValue", "VerifyValues"));

				for (int i = 0; i < Actual.Count; i++)
				{
					Log.LogVerify(Actual[i], lvlsExpected[i]);
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \brief
	/// Zentrale Exception-Behandlung.
	///
	/// Methode führt folge Aktivitäten aus:
	/// -# Exception wird als Log ausgegeben.
	/// -# Daten des aktuellen Objektes werden für eine Fehler-Analyse
	/// ausgegeben (CO.LogObjectData()).
	/// -# Wechselt den Zustand auf NOK.
	/// -# Wenn OKW in NUNIT/UNIT aufgerufen wird (this.UNITTEST = true sein)
	/// dann wird an das Unittest-Framework die Exception weitergereicht.
	///
	/// \param e Exception aus der OK-Schlüsselwort-Methode
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 02.03.2013
	private void HandleException( Exception e )
	{
		Log.LogPrint("==========================================================================");
		Log.LogException(String.format("%s", e.getMessage()));
		Log.LogPrint("--------");

		// Das ist nicht schön aber Notwendig. LogObjektData ist
		if (!e.GetType().IsAssignableFrom(typeof(OKWFrameObjectParentNotFoundException)))
		{
			CO.LogObjectData();
		}

		Log.LogPrint("--------");
		Log.LogPrint(" Stack:");
		Log.LogException(string.Format("{0}", e.StackTrace));

		Log.LogPrint("-------");
		Log.LogPrint(" Source:");
		Log.LogException(string.Format("{0}", e.Source));

		Log.LogPrint("-------");
		Log.LogPrint(" TargetSite:");
		Log.LogException(string.Format("{0}", e.TargetSite));

		Log.LogPrint("==========================================================================");

		// Change State to NOK
		this._Kernel.SetCurrentState(new NOK(this._Kernel));

		if (this.UNITTEST)
		{
			throw e;
		}
	}

	/// \copydoc IOKW_State::FileDelete(string)
	public void FileDelete( String fpsPathAndFileName )
	{
		String lvsPathAndFileName = "";

		Log.LogFunctionStart("FileDelete", "fpsPathAndFileName", fpsPathAndFileName);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsPathAndFileName == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsPathAndFileName == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(this.LM.GetMessage("FileDelete", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				// 1. Parsen der Pfad-Eingabe
				lvsPathAndFileName = MyParser.ParseMe(fpsPathAndFileName);
				// 2. Konvertieren des Pfad separators.
				lvsPathAndFileName = OKW_FileHelper.ConvertDirectorySeperator(lvsPathAndFileName);

				String lsvLog = this.LM.GetMessage("FileDelete", "ResolvedPath", lvsPathAndFileName);
				Log.LogPrint(lsvLog);

				// Basis-Funktion aufrufen...
				OKW_FileHelper.FilesDelete(lvsPathAndFileName);
			}
		}
		catch (Exception e)
		{
			HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \copydoc IOKW_State::VerifyFileExists(string,string)
	public void VerifyFileExists( String fpsPathAndFileName, String fpsExpectedValue )
	{
		String lvsPathAndFileName = "";

		Log.LogFunctionStart("VerifyFileExist", "fpsPathAndFileName", fpsPathAndFileName, "fpsExpectedValue",
				fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(this.LM.GetMessage("VerifyFileExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("NO"))
			{
				// Aktuellen Wert holen...

				// 1. Parsen der Pfad-Eingabe
				lvsPathAndFileName = MyParser.ParseMe(fpsPathAndFileName);
				// 2. Konvertieren des Pfad separators.
				lvsPathAndFileName = OKW_FileHelper.ConvertDirectorySeperator(lvsPathAndFileName);

				String lsvLog = this.LM.GetMessage("VerifyFileExists", "ResolvedPath", lvsPathAndFileName);
				Log.LogPrint(lsvLog);

				// Basis-Funkton aufrufen...
				bool lvbActual = OKW_FileHelper.FileExist(lvsPathAndFileName);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(this.LM.GetMessage("VerifyIsActive", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyFileExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \copydoc IOKW_State::VerifyDirectoryExists(string,string)
	public void VerifyDirectoryExists( String fpsPath, String fpsExpectedValue )
	{
		String lvsPath = "";

		Log.LogFunctionStart("VerifyDirectoryExists", "fpsPath", fpsPath, "fpsExpectedValue", fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const.Instance.GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == String.Empty)
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(this.LM.GetMessage("VerifyDirectoryExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const.Instance.GetConst4Internalname("NO"))
			{
				// Aktuellen Wert holen...

				// 1. Parsen der Pfad-Eingabe
				lvsPath = MyParser.ParseMe(fpsPath);
				// 2. Konvertieren des Pfad separators.
				lvsPath = OKW_FileHelper.ConvertDirectorySeperator(lvsPath);

				String lsvLog = this.LM.GetMessage("VerifyDirectoryExists", "ResolvedPath", lvsPath);
				Log.LogPrint(lsvLog);

				// Basis-Funkton aufrufen...
				bool lvbActual = OKW_FileHelper.DirectoryExist(lvsPath);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const.Instance.Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(this.LM.GetMessage("VerifyDirectoryExists", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyDirectoryExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

}}