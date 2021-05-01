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

public class LogBaseLeaf extends LogBase
{
    // Statistics of a Node
    
  protected Integer ErrorCount = 0;
  protected Integer ExceptionCount = 0;    
  protected Integer WarningCount = 0;
  protected Integer PassedCount = 0;
  protected Integer PrintCount = 0;
  
    public LogBaseLeaf( )
    {
    }
    
    
    public LogBaseLeaf( LogBase Parent )
	{
		setParent(Parent);
		myID = AllCount;
	}
    
    protected Boolean bWarning = false;
    
    protected void setWarning()
    {
        if (!bWarning)
        {
            bWarning = true;
        
        
            if (myParent != null)
            {
                myParent.setWarning();
            }
        }
    }

    protected Boolean getWarning()
    {
        return bWarning;
    }
    
    
    protected Boolean bException = false;

    protected void setException()
    {
        if (!bException)
        {
            //SetFail();
            bException = true;
        
            if (myParent != null)
            {
                myParent.setException();
            }
        }
    }


    protected Boolean getException()
    {
        return bException;
    }


    protected Boolean bError = false;
    
    protected void setError()
    {
        if (!bError)
        {           
            // SetFail();
            bError = true;

            if (myParent != null)
            {
                myParent.setError();
            }
        }
    }

    protected Boolean getError()
    {
        return bError;
    }
    
    
    public void reset()
    {
        AllCount = 0;
        myID = 0;

        // Global Statistics
        ErrorCount     = 0;
        ExceptionCount = 0;
        WarningCount   = 0;
        PassedCount    = 0;
        PrintCount     = 0;
    }

    
    // Node Statistics
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        bError = true;

        if ( myParent != null )
        {
            myParent.ErrorCount();
        }
    }
  
    @Override
    protected void ExceptionCount()
    {
        ExceptionCount++;
        this.bException = true;

        if ( myParent != null )
        {
            myParent.ExceptionCount();
        }
    }
  
    @Override
    protected void WarningCount()
    {
        WarningCount++;
        this.bWarning = true;

        if ( myParent != null )
        {
            myParent.WarningCount();
        }
    }

    @Override
    protected void PassedCount()
    {
        PassedCount++;

        if ( myParent != null )
        {
            myParent.PassedCount();
        }
    }

    @Override
    protected void PrintCount()
    {
        PrintCount++;

        if ( myParent != null )
        {
            myParent.PrintCount();
        }
    }
    
    @Override
    protected void TestcaseCount()
    {
    }

    @Override
    protected void TestcaseFail()
    {
    }
    
    @Override
    protected void TestcasePass()
    {
    }

    @Override
    protected void FunctionCount()
    {
    }

    @Override
    protected void FunctionFail()
    {
    }

    @Override
    protected void FunctionPass()
    {
    }
    
    @Override
    protected void KeyWordCount()
    {
    }

    @Override
    protected void KeyWordFail()
    {
    }

    @Override
    protected void KeyWordPass()
    {
    }
    
    @Override
    protected void SequenceCount()
    {
    }

    @Override
    protected void SequenceFail()
    {
    }

    @Override
    protected void SequencePass()
    {
    }
    

    @Override
    protected void StepCount()
    {
    }
    
    @Override
    protected void StepFail()
    {
    }
    
    @Override
    protected void StepPass()
    {
    }
    
    // LocalACCall
    @Override
    protected void LocalACCallCount()
    {
    }
    
    @Override
    protected void LocalACCallFail()
    {
    }
    
    @Override
    protected void LocalACCallPass()
    {
    }
    
    // RemoteACCall
    @Override
    protected void RemoteACCallCount()
    {
    }
    
    @Override
    protected void RemoteACCallFail()
    {
    }
    
    @Override
    protected void RemoteACCallPass()
    {
    }
}
