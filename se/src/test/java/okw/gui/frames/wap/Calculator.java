/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 Zoltán Hrabovszki, IT-Beratung Hrabovszki
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

package okw.gui.frames.wap;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import okw.OKW;
import okw.gui.adapter.WinAppDriver.*;
import okw.gui.adapter.selenium.webdriver.SeDriver;

@OKW(FN = "Rechner")
public class Calculator extends WAPWindow {

	@OKW(FN = "Display")
	public WAPTextfield display = new WAPTextfield("//*[@AutomationId=\"CalculatorResults\"]", this.getLOCATOR());

	@OKW(FN = "1")
	public WAPButton n1 = new WAPButton("//*[@AutomationId=\"num1Button\"]", this.getLOCATOR());

	@OKW(FN = "2")
	public WAPButton n2 = new WAPButton("//*[@AutomationId=\"num2Button\"]", this.getLOCATOR());

	@OKW(FN = "3")
	public WAPButton n3 = new WAPButton("//*[@AutomationId=\"num3Button\"]", this.getLOCATOR());

	@OKW(FN = "4")
	public WAPButton n4 = new WAPButton("//*[@AutomationId=\"num4Button\"]", this.getLOCATOR());

	@OKW(FN = "5")
	public WAPButton n5 = new WAPButton("//*[@AutomationId=\"num5Button\"]", this.getLOCATOR());

	@OKW(FN = "6")
	public WAPButton n6 = new WAPButton("//*[@AutomationId=\"num6Button\"]", this.getLOCATOR());

	@OKW(FN = "7")
	public WAPButton n7 = new WAPButton("//*[@AutomationId=\"num7Button\"]", this.getLOCATOR());

	@OKW(FN = "8")
	public WAPButton n8 = new WAPButton("//*[@AutomationId=\"num8Button\"]", this.getLOCATOR());

	@OKW(FN = "9")
	public WAPButton n9 = new WAPButton("//*[@AutomationId=\"num9Button\"]", this.getLOCATOR());

	@OKW(FN = "0")
	public WAPButton n0 = new WAPButton("//*[@AutomationId=\"num0Button\"]", this.getLOCATOR());

	@OKW(FN = ",")
	public WAPButton punkt = new WAPButton("//*[@AutomationId=\"decimalSeparatorButton\"]]", this.getLOCATOR());

	@OKW(FN = "+")
	public WAPButton plus = new WAPButton("//*[@AutomationId=\"plusButton\"]", this.getLOCATOR());

	@OKW(FN = "-")
	public WAPButton minus = new WAPButton("//*[@AutomationId=\"minuButton\"]", this.getLOCATOR());

	@OKW(FN = "/")
	public WAPButton durch = new WAPButton("//*[@AutomationId=\"divideButton\"]", this.getLOCATOR());

	@OKW(FN = "*")
	public WAPButton mal = new WAPButton("//*[@AutomationId=\"multiplyButton\"]", this.getLOCATOR());

	@OKW(FN = "=")
	public WAPButton gleich = new WAPButton("//*[@AutomationId=\"equalButton\"]", this.getLOCATOR());

	@OKW(FN = "C")
	public WAPButton clear = new WAPButton("//*[@AutomationId=\"clearButton\"]", this.getLOCATOR());

	@OKW(FN = "sqrt")
	public WAPButton sqrt = new WAPButton("//*[@AutomationId=\"squareRootButton\"]", this.getLOCATOR());

	public Calculator() {

		// define Locator for Calculator Main-Window
		this.setLocator("//Window[@Name=\"Rechner\"]");

	}

	@Override
	public void StartApp() 
	{
	
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			// capabilities.setCapability("app", "C:/Windows/System32/notepad.exe");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("deviceName", "WindowsPC");

			//SeDriver.getInstance().driver = new WindowsDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			SeDriver.getInstance().driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			
			// SeDriver.getInstance().driver.manage().timeouts().implicitlyWait(2,
			// TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	

	@Override
	public void StopApp()
	{
		SeDriver.getInstance().driver.quit();
	}
	
}
