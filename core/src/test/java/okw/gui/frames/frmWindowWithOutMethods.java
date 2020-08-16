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

package okw.gui.frames;

import okw.*;
import okw.core.IOKW_FN;


/// \brief
/// Test-Frame-Klasse: Diese Klasse dient als Unittest-Objekt.<br/>
/// Dieser Klasse dient(e) als als TestFenster um zu zeigen/testen<br/>
///
/// * das die Exception OKWFrameObjectParentNotFoundException ausgelöst wird, 
///   wenn eine Frame-Klasse die OKW-Schlüsselwort-Methode ncht zuvrfügung hält.
/// 
/// \author Zoltan Hrabovszki
/// \date 2016.05.06
/// \warning **Diese Frame-Klasse nicht ohne Grund verändern!**
/// Sie ist basis für etliche OKW-Unittests. **ZH**
/// \copyright CC-OPENKEYWORD

@OKW(FN="WindowWithoutMethods")
public class frmWindowWithOutMethods extends okw.gui.AnyWindow implements IOKW_FN
{
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */    
  private String myKN = "";

  
  /** \~german
   *  Setzten des Keyname FN.
   *  
   *  @fpsParentFN KN des Objektes
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */    
  public void setKN(String fpsKN)
  {
    this.myKN =  fpsKN;
  }

  
  /** \~german
   *  Setzten des Objekt KN.
   *  
   *  @return KN des Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */ 
  public String getKN( )
  {
    return this.myKN;
  }
  
  /** \~german
   *  FN - Funktionaler Name des aktuellen GUI-Objektes.
   *  
   *  Wert wird 
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2014.04.27
   */    
  private String myFN = "";
  
  public void setFN(String fpsFN)
  {
    this.myFN =  fpsFN;
  }

  
  /** \~german
   *  Holt den funktionalen Name dws GUI-Objektes.
   * 
   *  Hinweis: Jeder GUI-Adapter kennt seinen eigenen funktionalen Namen.
   *  Dieser wird beim instanzieren der Frame-Objecte währen des Frame-Classen-Scans in der Methode FrameObjectDictionary_Sngltn.FrameScan()
   *  mitgeteilt.
   *  Wert wird 
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2014.04.27
   */  
  public String getFN( )
  {
    return this.myFN;
  }

  
  /** \~german
   *  Parent-Objekt FN des aktuellen GUI-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */    
  private String myParentFN = "";

  
  /** \~german
   *  Setzten des Parent-Objekt FN.
   *  
   *  @fpsParentFN FN des Parent-Objektes
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */    
  public void setParentFN(String fpsParentFN)
  {
    this.myParentFN =  fpsParentFN;
  }

  /** \~german
   *  Setzten des Parent-Objekt FN.
   *  
   *  @return FN des Parent-Objektes.
   *  
   *  \~english
   *  \brief
   *  @todo TODO:  Übersetzung ins Englische fehlt...
   *  
   *  \~
   *  @author Zoltán Hrabovszki
   *  \date 2016.11.20
   */ 
  public String getParentFN( )
  {
    return this.myParentFN;
  }


}
