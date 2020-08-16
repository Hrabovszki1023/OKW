	/*
	    ==============================================================================
	      Author: Zoltán Hrabovszki <zh@openkeyword.de>

	      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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
   * Anzahl der berechneten Zyklen.
   * @return
   */
  public Integer getMaxCount()
  {
    return TO * 1000 / PT;
  }
  
  public String toString()
  {
      return "PT: " + PT.toString() + "ms, TO: " + TO.toString() + "s";
  }
}
