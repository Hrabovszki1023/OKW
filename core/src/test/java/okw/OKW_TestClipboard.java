	/*
	    ==============================================================================
	      Author: Zoltán Hrabovszki <zh@openkeyword.de>

	      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

import java.util.ArrayList;

public class OKW_TestClipboard {

	    /// \brief
	    /// Singelton Object. Sue for Unittest Assertion.
	    /// 
	
	        private static OKW_TestClipboard instanz = new OKW_TestClipboard();

	        /// \brief
	        /// Diese Liste aus String-s ist für die Überprüfung des Log-ings gedacht.
	        /// Die Klasse Log2Clipboard ist der Gegenspieler.
	        /// Dieser Schreibt in diese Klassen-Variable und im Unittest kann dann gegen den Erwarteten wert Geprüft werden
	        /// 
	        private static ArrayList<String> cvLs_LogValue = new ArrayList<String>();
	        private static ArrayList<String> cvLs_Value = new ArrayList<String>();

	        private String cvs_Method;
	        private String cvs_ObjectName;

	        private OKW_TestClipboard()
	        {
	        }

	        public static OKW_TestClipboard getInstance()
	        {
	                return instanz;
	        }

	        /// \brief
	        /// Getter/Setter der Eigenschaft LogValue.
	        /// Gets the log value. Get holt die Eigenschaft LogValue als List String heraus.
	        /// D.h. es können mehrere Werte in die eigenschaft hinein geschrieben werden.
	        /// Anschliessend könennen alle geschriebenen werte als Liste mit der Getter Methode ausgelesen werden und gegen einen sollwert geprüft werden
	        /// 
	        /// <value>
	        /// The log value.
	        /// </value>
	        public ArrayList<String> getLogValue()
	        {
	        	return cvLs_LogValue;
	        }

	        public String getMethod()
	        {
	                return this.cvs_Method;
	        }
	            
	        public void setMethod( String value)
	        {
	                this.cvs_Method = value;
	        }

	        public String getObjectName()
	        {
	                return this.cvs_ObjectName;
            }
	            
	        public void setObjectName(String  value)
	        {
	                this.cvs_ObjectName = value;
	        }

	        
	        public ArrayList<String> getValue()
	        {
	            return cvLs_Value;
	        }
	        
	        public void setValue(ArrayList<String> value)
	        {
	            cvLs_Value = value;
	        }


	        /// \brief
	        /// Resets all ClipBoard-Memmber to empty String = ""  .
	        /// 
	        public void Clear()
	        {
	            this.cvs_ObjectName = "";
	            this.cvs_Method = "";

	            cvLs_Value.clear();
	            cvLs_LogValue.clear();
	        }

	        
	        public void LogValueAdd(String fps_Value)
	        {
	            cvLs_LogValue.add(fps_Value);
	        }
	}
