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

package okw.log.log2html;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class LogTimer {

	public LogTimer()
	{
		if ( "true".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test" )) )
		{
			Testmode = true;
		}
		else
		{
			Testmode = false;
		}        	
	}

	static Boolean Testmode = false;

	private long TimerBegin;
	private long TimerEnd;

	private Instant lvStartTime;
	private Instant lvEndTime;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MMM-dd HH:mm:ss.SSS")
			.withLocale( Locale.GERMANY )
			.withZone( ZoneId.systemDefault() );


	public void startTimer()
	{
		TimerBegin = System.nanoTime();
		lvStartTime = Instant.now();
	}

	public void stopTimer()
	{
		TimerEnd = System.nanoTime();
		lvEndTime = Instant.now();
	}

	public long getNanos()
	{
		long lvlReturn = TimerEnd - TimerBegin;

		return lvlReturn;              
	}

	public long getMillis()
	{
		long lvlReturn = TimerEnd - TimerBegin;

		lvlReturn = TimeUnit.MILLISECONDS.convert(lvlReturn, TimeUnit.NANOSECONDS);

		return lvlReturn;
	}

	
	public String getSeconds(String fpsFormat)
	{
		String output = "#?.???";

		if ( Testmode ) 
		{ 
			output = "#?.???";
		}
		else
		{
			final double seconds = ((double)getNanos() / 1000000000);

			DecimalFormat myFormatter = new DecimalFormat(fpsFormat);
			output = myFormatter.format(seconds);
		}
		return output;
	}


	public String getMilliSeconds(String fpsFormat)
	{
		String output = "#?????????";

		if ( Testmode ) 
		{ 
			output = "#?????????";
		}
		else
		{
			final double seconds = ((double)getNanos() / 1000000);
			
			DecimalFormat myFormatter = new DecimalFormat(fpsFormat);
			output = myFormatter.format(seconds);
		}
		
		return output;
	}


	public String getStartTime()
	{
		String lvsReturn = "????-???-?? ??:??:??.???";
		
		
		if ( Testmode ) 
		{ 
			lvsReturn = "????-???-?? ??:??:??.???";
		}
		else
		{
			lvsReturn = formatter.format( lvStartTime );
		}
		
		return lvsReturn;
	}

	public Long getStartTimeMillis()
	{
		long lvlReturn = TimerBegin;

		lvlReturn = TimeUnit.MILLISECONDS.convert(lvlReturn, TimeUnit.NANOSECONDS);

		return lvlReturn;
	}

	public String getEndTime()
	{
		String lvsReturn = "????-???-?? ??:??:??.???";
		
		if ( Testmode ) 
		{ 
			lvsReturn = "????-???-?? ??:??:??.???";
		}
		else
		{
			lvsReturn = formatter.format( lvEndTime );
		}
		
		return lvsReturn;
	}

	public Long getEndTimeMillis()
	{
		long lvlReturn = TimerEnd;

		lvlReturn = TimeUnit.MILLISECONDS.convert(lvlReturn, TimeUnit.NANOSECONDS);

		return lvlReturn;
	}

}
