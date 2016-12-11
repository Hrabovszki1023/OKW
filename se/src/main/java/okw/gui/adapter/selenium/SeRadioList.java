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

package okw.gui.adapter.selenium;

import java.util.ArrayList;

import okw.FrameObjectDictionary_Sngltn;
import okw.OKW_Const_Sngltn;
import okw.core.Core;
import okw.core.OKW_CurrentObject_Sngltn;
import okw.gui.OKWLocator;


    /** \brief
     *  TODO: Description of SeRadioList.
     */ 
    public class SeRadioList extends SeSimpleDataObjBase // : IOKW_ListDataObj
    {
      
      // Instance of OKW_CurrentObject
        OKW_CurrentObject_Sngltn CO = OKW_CurrentObject_Sngltn.getInstance();

        // Instance of OKW_CurrentObject
        FrameObjectDictionary_Sngltn FOD = FrameObjectDictionary_Sngltn.getInstance();
        
        /**
         *  Holds the FNs of all RadionButton ChildObjects of this RadioList.<br/>
         *  See Constructor for initialsation.
         */
        ArrayList<String> myRadioButtonFNs = null;
        
        /// TODO: Konstuktor Beschreiben
        /// \brief
        /// 
        /// 
        /// @param Locator definiert die Objekterkennungseigenschaft des Objektes und wird als XPATH angegeben.
        public SeRadioList(String Locator, OKWLocator... fpLocators) throws Exception
        {
        	super(Locator, fpLocators);
     
        	
        }
        
  @Override
  public void SetValue( ArrayList<String> Val ) throws Exception
  {

    if ( Val.size() == 1 )
    {
      // Get my FN
      String myFN = CO.GetChildFN();

      // Radiolist enthällt nur einen wert
      String myChildFN = myFN + "." + Val.get( 0 );

      Core myCore = new Core();
      myCore.ClickOn( myChildFN );

      // Set the Current Radiobutton-object back to the RadioList..
      CO.SetChildName( myFN );
    }
    else
    {
      // \todo TODO: Ausnahme Meldung in LM_SeRadioList anlegen.
      throw new okw.exceptions.OKWOnlySingleValueAllowedException( "SeRadioList: Only single value is allowed!" );
    }
  }
  
  
  @Override
  /**
   * 
   */
  public void Select( ArrayList<String> Val ) throws Exception
  {
      this.SetValue( Val );
  }

  
/*  @Override
  public ArrayList<String> VerifyValue( ArrayList<String> Val )
  {
      this.SetValue( Val );
      
      return Val;
  }
  */
  
  /**
   *  Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
   *  
   *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
   *  
   *  @return Rückgabe des Textuellen Inhaltes der markierten Textes.
   *  Es wird (immer) der aktuelle Wert des Objektes zurückgeliefert.
   *  @author Zoltan Hrabovszki
   *  @date 2013.12.14
   */
  public ArrayList<String> getValue( ) throws Exception
  {
      ArrayList<String> lvLsReturn = new ArrayList<String>();
      
      ArrayList<String> myRadioButtonKeys = new ArrayList<String>();
      Boolean bOK = false;

    try
    {
      this.LogFunctionStartDebug( "getValue" );

      String isChecked = OKW_Const_Sngltn.getInstance().GetConst4Internalname( "CHECKED" );

      // 1. Get the List of
      myRadioButtonKeys = OKW_CurrentObject_Sngltn.getInstance().GetAllChildFNsOfParent( this.GetParentFN() + "." + this.GetFN() + "." );

      for ( String lvsRadioButtonFN : myRadioButtonKeys )
      {
        if ( isChecked.equals( ( ( SeInputRadio ) FOD.GetParentObjectByName( lvsRadioButtonFN ) ).getValue() ) )
        {
          lvLsReturn.add( lvsRadioButtonFN );
          break;
        }
      }
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
}