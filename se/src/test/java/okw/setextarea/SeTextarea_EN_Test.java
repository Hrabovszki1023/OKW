/*
 ==============================================================================
 Copyright © 2012 - 2019, 2016 IT-Beratung Hrabovszki
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
 along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.

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

package okw.setextarea;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWVerifyingFailsException;

import okw.core.OKWTestBase;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Disabled
public class SeTextarea_EN_Test extends OKWTestBase
{

    protected OKW_Memorize_Sngltn myMem = OKW_Memorize_Sngltn.getInstance();
    protected static String     ApplicationName;

    /**
     *  Prüft ob ein vorhandenes objekt existiert.
     *  Erwartet wird, dass das Objekt existiert.
     */
    @Test
    public void tcLogExists() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.LogExists( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     * Teste das Schlüsselwort ClickOn( FN ) eines SeInputText Prüfen.
     */ 
    @Test
    public void tcClickOn() throws Exception
    {
        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.ClickOn( "Textarea 1" );
        EN.VerifyHasFocus( "Textarea 1", "YES" );
        EN.VerifyHasFocus( "Textarea 2", "NO" );

        EN.ClickOn( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 1", "NO" );
        EN.VerifyHasFocus( "Textarea 2", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // / \brief
    // / Focus eines Textfeldes loggen.
    // /
    @Test
    public void tcLogHasFocus() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );
        EN.LogHasFocus( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort LogLabel( FN ) eines SeInputText Prüfen.
     * @throws Exception
     */
    @Test
    public void tcLogIsActive() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );
        EN.LogIsActive( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort LogLabel( FN ) eines SeInputText Prüfen.
     */
    @Test
    public void tcLogLabel() throws Exception
    {
        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.LogLabel( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort LogLogToolTip( FN ) eines SeInputText Prüfen.
     */
    @Test
    public void tcLogToolTip() throws Exception
    {
        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.LogTooltip( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort LogLogValue( FN ) eines SeInputText Prüfen.
     */
    @Test
    public void tcLogValue() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.LogValue( "Textarea 1" );

        EN.TypeKey( "Textarea 1", "Zoltan" );
        EN.LogValue( "Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     * Teste das Schlüsselwort MemorizeExists( FN, MemKey ) eines SeInputText Prüfen.
     */
    @Test
    public void tcMemorizeExists_en() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.MemorizeExists( "Textarea 1", "SeTextarea_MemorizeExists_1" );

        assertEquals( "YES", myMem.get( "SeTextarea_MemorizeExists_1" ) );
        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort MemorizeHasFocus( FN, MemKey ) eines SeInputText Prüfen.
     */
    @Test
    public void tcMemorizeHasFocus() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.MemorizeHasFocus( "Textarea 1", "SeTextarea_MemorizeHasFocus" );

        assertEquals( "NO", myMem.get( "SeTextarea_MemorizeHasFocus" ) );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort MemorizeIsActive( FN, MemKey ) eines SeInputText Prüfen.
     */
    @Test
    public void tcMemorizeIsActive_en() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.MemorizeIsActive( "Textarea 1", "SeTextarea_MemorizeIsActive" );

        assertEquals( "YES", myMem.get( "SeTextarea_MemorizeIsActive" ) );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     *  Teste das Schlüsselwort MemorizeLabel( FN, MemKey ) eines SeInputText Prüfen.
     */
    @Test
    public void tcMemorizeLabel() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        // /
        EN.MemorizeLabel( "Textarea 1", "SeTextarea_MemorizeLabel_1" );
        EN.MemorizeLabel( "Textarea 2", "SeTextarea_MemorizeLabel_2" );

        assertEquals( "Textarea 1:", myMem.get( "SeTextarea_MemorizeLabel_1" ) );
        assertEquals( "Textarea 2:", myMem.get( "SeTextarea_MemorizeLabel_2" ) );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     * Testet das Schlüsselwort MemorizeToolTip( FN, MemKey ) eines SeInputText Prüfen.
     *
     */
    @Test
    public void tcMemorizeToolTip() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.MemorizeTooltip( "Textarea 1", "SeTextarea_MemorizeTooltip" );

        assertEquals( "Title: Textarea 1", myMem.get( "SeTextarea_MemorizeTooltip" ) );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Teste das Schlüsselwort MemorizeValue( FN, MemKey ) eines SeInputText Prüfen.
    // 
    @Test
    public void tcMemorizeValue() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.MemorizeValue( "Textarea 1", "SeTextarea_LogValue_1" );
        EN.TypeKey( "Textarea 1", "Zoltan" );
        EN.MemorizeValue( "Textarea 1", "SeTextarea_LogValue_2" );

        assertEquals( "", myMem.get( "SeTextarea_LogValue_1" ) );
        assertEquals( "Zoltan", myMem.get( "SeTextarea_LogValue_2" ) );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Teste das Schlüsselwort SetFocus( FN ) eines SeInputText Prüfen.
    // 
    @Test
    public void tcSetFocus_ReadableAndEnabled() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.SetFocus( "Textarea 1" );
        EN.VerifyHasFocus( "Textarea 1", "YES" );
        EN.VerifyHasFocus( "Textarea 2", "NO" );

        EN.SetFocus( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 1", "NO" );
        EN.VerifyHasFocus( "Textarea 2", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Teste das Schlüsselwort SetFocus( FN ) eines readonly aber nicht disabled SeInputText prüfen.
    //
    // Attribut Einstellung hier:
    // * readonly ist eingeschatet
    // * disable ist abgeschaltet
    //
    @Test
    // @Disabled( "Frame for 'SeInputTextReadonly' not found" )
    public void tcSetFocus_ReadonlyAndEnabled() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea_readonly.htm" );

        EN.SelectWindow( "SeTextarea Readonly" );

        EN.SetFocus( "Textarea 1" );
        EN.VerifyHasFocus( "Textarea 1", "YES" );
        EN.VerifyHasFocus( "Textarea 2", "NO" );

        EN.SetFocus( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 1", "NO" );
        EN.VerifyHasFocus( "Textarea 2", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Testet das Schlüsselwort SetValue( FN ) eines SeInputText-es.
    //
    @Test
    public void tcSetValue() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyValue( "Textarea 1", "" );
        EN.VerifyValue( "Textarea 2", "" );

        EN.SetValue( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.SetValue( "Textarea 2", "Zoltan" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        // Neuen Wert Setzen, der alte Wert wird vollständig überschrieben
        EN.SetValue( "Textarea 1", "Becker" );
        EN.VerifyValue( "Textarea 1", "Becker" );
        EN.SetValue( "Textarea 2", "Manu" );
        EN.VerifyValue( "Textarea 2", "Manu" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Testet das Schlüsselwort SetValue( FN ) mit ${IGNORE} eines SeInputText-es.
    //
    @Test
    public void tcSetValue_IGNORE() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyValue( "Textarea 1", "" );

        EN.SetValue( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.SetValue( "Textarea 2", "Zoltan" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        // Neuen Wert Setzen, der alte Wert wird überschrieben
        EN.SetValue( "Textarea 1", "${IGNORE}" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.SetValue( "Textarea 2", "${IGNORE}" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Testet das Schlüsselwort TypeKey( FN ) eines SeInputText-es.
    //
    @Test
    public void tcTypeKey() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyValue( "Textarea 1", "" );

        EN.TypeKey( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki" );

        // Text wird hinten agehängt 
        EN.TypeKey( "Textarea 1", " Zoltan" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki Zoltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Testet das Schlüsselwort TypeKey( FN ) eines SeInputText-es.
    //
    @Test
    public void tc_TypeKey_Delete() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyValue( "Textarea 1", "" );

        EN.TypeKey( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 1", "Hrabovszki" );

        // Text wird hinten agehängt 
        EN.TypeKey( "Textarea 1", "${DELETE}${SEP}Zoltan" );
        EN.VerifyValue( "Textarea 1", "Zoltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }
    
    // \brief
    // Testet das Schlüsselwort TypeKey( FN ) mit ${IGNORE} eines SeInputText-es.
    //
    @Test
    public void tcTypeKey_IGNORE() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );

        EN.VerifyValue( "Textarea 1", "" );
        EN.VerifyValue( "Textarea 2", "" );

        EN.TypeKey( "Textarea 1", "Hrabovszki" );
        EN.TypeKey( "Textarea 2", "Zoltan" );

        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        EN.TypeKey( "Textarea 1", "${IGNORE}" );
        EN.TypeKey( "Textarea 2", "${IGNORE}" );

        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        EN.TypeKey( "Textarea 1", "" );
        EN.TypeKey( "Textarea 2", "" );

        EN.VerifyValue( "Textarea 1", "Hrabovszki" );
        EN.VerifyValue( "Textarea 2", "Zoltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Prüft ob ein tatsächlich _nicht_ vorhandenes Objekt _nicht_ existiert.
    // Erwartet wird das das objekt nicht existiert.
    //
    @Test
    public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyExists( "ObjectNotExists", "NO" );
    }

    // \brief
    // Prüft ob ein nicht vorhandenes objekt existiert.
    // Erwartet wird, dass das Objekt existiert.
    // Es wird geprüft auf das default timout exception getriggert wird.
    //
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
    {
        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );

        EN.VerifyExists( "ObjectNotExists", "YES" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });
    }

    /** Prüft ob ein vorhandenes Objekt nicht existiert.
     *  Hier wird wird geprüft auf das default timout exception getriggert wird.
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyExists( "Textarea 1", "NO" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // / \brief
    // / Prüft ob ein vorhandenes objekt existiert.
    // / Erwartet wird, dass das Objekt existiert.
    // /
    @Test
    public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyExists( "Textarea 1", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brife
    // Prüft, ob die OKW-Konstante ${IGNORE} implementiert ist.
    //
    // Nicht existierendes Object wird als GUI-Objekt Referenziert.
    // Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
    // nicht ausgeführt wird.
    // D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
    // worden.
    //
    @Test
    public void tcVerifyExists_IGNORE() throws Exception
    {

        EN.BeginTest( TestName );

        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );

        EN.SelectWindow( "SeTextarea" );
        EN.VerifyExists( "ObjectNotExists", "${IGNORE}" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Focus eines Textfeldes prüfen.
    //
    @Test
    public void tcVerifyHasFocus() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyHasFocus( "Textarea 2", "NO" );
        EN.SetFocus( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 2", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \brief
    // Focus eines Textfeldes prüfen.
    //
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyHasFocus_HasFocusYesExpectedNo_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyHasFocus( "Textarea 2", "NO" );
        EN.SetFocus( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 2", "NO" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // \brief
    // Focus eines Textfeldes prüfen.
    //
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyHasFocus_HasFocusNoExpectedYes_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.SetFocus( "Textarea 2" );
        EN.VerifyHasFocus( "Textarea 1", "YES" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // \~german
    // \brief
    // Prüft, ob die OKW-Konstante ${IGNORE} für SeTextField implementiert ist.
    //
    // Nicht existierendes Object wird als GUI-Objekt Referenziert.
    // Mit IGNORE darf keine Exception ausgelöst werden, weil das Schlüsselwort
    // nicht ausgeführt wird.
    // D.h. sollte eine Exception ausgelöstwerden, dann ist hier nicht ignoriert
    // worden.
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test
    public void tcVerifyHasFocus_IGNORE() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyHasFocus( "NichtVorhanden", "${IGNORE}" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     * Prüft, ob die Methode VerifyIsActive für SeTextField implementiert ist.
     *
     * \~
     * \author Zoltan Hrabovszki
     * \date 2014.12.03
     */
    @Test
    public void tcVerifyIsActive() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea_disabled.htm" );
        EN.SelectWindow( "SeTextarea Disabled" );

        EN.VerifyIsActive( "Textarea 1", "NO" );
        //EN.VerifyIsActive( "Textarea 2", "NO" );

        // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyIsActive( "Textarea 1", "YES" );
        EN.VerifyIsActive( "Textarea 2", "YES" );

        // Objekt auf "nicht aktiv"(attribut disabled gesetzt) prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea_readonly.htm" );
        EN.SelectWindow( "SeTextarea Readonly" );

        EN.VerifyIsActive( "Textarea 1", "YES" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    
    
    /**
     * \~german
     * Prüft, ob die Methode VerifyMaxValue für SeTextarea implementiert ist.
     *
     * \~english
     * Verifies whether the VerifyMaxValue method is implemented for SeTextarea.
     * 
     * \~
     * \author Zoltan Hrabovszki
     * \date 2019.01.19
     */
    @Test
    public void tcVerifyMaxLength() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        // Objekt ist "aktiv" prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyMaxLength( "Textarea MaxLength 40", "40" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    
    /** \~german
     * Prüft, ob die Methode VerifyMaxValue für eine Abweichung eine OKWVerifyingFailsException - Ausnahme auslöst.
     *
     * \~english
     * Verifies whether the VerifyMaxValue method throws an OKWVerifyingFailsException for a deviation.
     * \~
     * \author Zoltan Hrabovszki
     * \date 2019.01.19
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyMaxLength_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        // Objekt ist "aktiv" prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyMaxLength( "Textarea MaxLength 40", "41" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }
    
    
    /**
     * \~german
     * Prüft, ob die Methode VerifyMaxValue für SeTextarea implementiert ist.
     *
     * \~english
     * Verifies whether the VerifyMaxValue method is implemented for SeTextarea.
     * 
     * \~
     * \author Zoltan Hrabovszki
     * \date 2019.01.19
     */
    @Test
    public void tcVerifyMinLength() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        // Objekt ist "aktiv" prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyMinLength( "Textarea 2", "0" );
        EN.VerifyMinLength( "Textarea MaxLength 40", "1" );
        
        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    
    /** \~german
     * Prüft, ob die Methode VerifyMinValue für eine Abweichung eine OKWVerifyingFailsException - Ausnahme auslöst.
     *
     * \~english
     * Verifies whether the VerifyMinValue method throws an OKWVerifyingFailsException for a deviation.
     * \~
     * \author Zoltan Hrabovszki
     * \date 2019.01.19
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyMinLength_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        // Objekt ist "aktiv" prüfen
        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyMinLength( "Textarea 2", "1" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    
    /**
     * \~german
     * Prüft, ob die Methode VerifyLabel für SeTextarea implementiert ist.
     *
     * \~english
     * Verifies whether the VerifyLabel method is implemented for SeTextarea.
     * \~
     * \author Zoltan Hrabovszki
     * \date 2014.12.03
     */
    @Test
    public void tcVerifyLabel() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabel( "Textarea 1", "Textarea 1:" );
        EN.VerifyLabel( "Textarea 2", "Textarea 2:" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
    // OKWVerifyingFailsException für SeTextarea auslöst.  //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyLabel_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabel( "Textarea 1", "Xxxx:" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyLabelWCM für SeTextarea implementiert ist.
    //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test
    public void tcVerifyLabelWCM() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabelWCM( "Textarea 1", "Textarea 1?" );
        EN.VerifyLabelWCM( "Textarea 2", "Textarea 2?" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
    // OKWVerifyingFailsException für SeTextarea auslöst.  //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyLabelWCM_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabelWCM( "Textarea 1", "####:" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyLabelREGX für SeTextarea implementiert ist.
    //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test
    public void tcVerifyLabelREGX() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabelREGX( "Textarea 1", "Textarea 1\\W" );

        EN.StopApp( ApplicationName );
        
        EN.EndTest();
    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyLabelREGX bei einer Soll/Ist Abweichung die Ausnahme 
    // OKWVerifyingFailsException für SeTextarea auslöst.  //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyLabelREGX_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyLabelREGX( "Textarea 1", "Label Textarea\\w" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
    //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test
    public void tcVerifyTooltip() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltip( "Textarea 1", "Title: Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyTooltip bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.
     *
     *  \~english
     * \~
     * @author Zoltan Hrabovszki
     * @date 2014.12.03
    @Test( expected = OKWVerifyingFailsException.class )
    public void tcVerifyTooltip_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltip( "Textarea 1", "Soltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /**
     * \~german
     * Prüft, ob die Methode VerifyTooltipWCM für SeTextField implementiert ist.
     *
     * \~
     * \author Zoltan Hrabovszki
     * \date 2014.12.03
     */
    @Test
    public void tcVerifyTooltipWCM() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltipWCM( "Textarea 1", "Title: Textarea #" );

        EN.StopApp( ApplicationName );
        
        EN.EndTest();
     }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
    // OKWVerifyingFailsException für SeTextarea auslöst.  //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyTooltipWCM_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltipWCM( "Textarea 1", "#oltan" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });
    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyToolTip für SeTextField implementiert ist.
    //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test
    public void tcVerifyTooltipREGX() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltipREGX( "Textarea 1", "\\witle: Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    // \~german
    // \brief
    // Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
    // OKWVerifyingFailsException für SeTextarea auslöst.  //
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.12.03
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyTooltipREGX_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyTooltipREGX( "Textarea 1", "\\Witle Textarea 1" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    /** \~german
     *  Prüft, ob die Methode VerifyPlaceholder für SeTextField implementiert ist.
     *
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2014.12.03
     */
    @Test
    public void tcVerifyPlaceholder() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholder( "Textarea 1", "Placeholder: Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyPlaceholder bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.
     *
     *  \~english
     * \~
     * @author Zoltan Hrabovszki
     * @date 2014.12.03
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyPlaceholder_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholder( "Textarea 1", "Placeholder: wrong" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    /**
     * \~german
     * Prüft, ob die Methode VerifyPlaceholderWCM für SeTextField implementiert ist.
     *
     * \~
     * \author Zoltan Hrabovszki
     * \date 2014.12.03
     */
    @Test
    public void tcVerifyPlaceholderWCM() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholderWCM( "Textarea 1", "Placeholder: Textarea 1" );

        EN.StopApp( ApplicationName );
        
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyTooltipWCM bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.  //
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2014.12.03
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyPlaceholderWCM_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholderWCM( "Textarea 1", "Placeholder: error" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    /** \~german
     *  Prüft, ob die Methode VerifyPlaceholder für SeTextarea implementiert ist.
     *
     * \~
     * @author Zoltan Hrabovszki
     * @date 2014-12-03
     */
    @Test
    public void tcVerifyPlaceholderREGX() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholderREGX( "Textarea 1", "Placeholder: Textarea 1" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    
    /** \~german
     *  Prüft, ob die Methode VerifyPlaceholderWCM bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.  //
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyPlaceholderREGX_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.VerifyPlaceholderREGX( "Textarea 1", "Placeholder: error" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }
    
    
    /** \~german
     *  Test des Schlüsselwortes "VerifyValue( FN, ExpVal ) für SeInputText.
     *
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test
    public void tcVerifyValue() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValue( "Textarea 1", "Zoltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyValue die OKW-Konstanten ${DELETE} und ${EMPTY} für
     *  SeTextField implementiert ist.
     * 
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test
    public void tcVerifyValue_DELETE_EMPTY() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValue( "Textarea 1", "Zoltan" );

        EN.SetValue( "Textarea 1", "${DELETE}" );
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyLabel bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.  //
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyValue_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValue( "Textarea 1", "Soltan" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    /** \~german
     *  Test des Schlüsselwortes "VerifyValueWCM( FN, ExpValu ) für SeInputText.
     * 
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test
    public void tcVerifyValueWCM() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueWCM( "Textarea 1", "??????" );
        EN.VerifyValueWCM( "Textarea 1", "Z????n" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyValue die OKW-Konstanten ${DELETE} und ${EMPTY} für
     *  SeTextField implementiert ist.
     * 
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2014.12.03
     */
    @Test
    public void tcVerifyValueWCM_DELETE_EMPTY() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueWCM( "Textarea 1", "??????" );

        EN.SetValue( "Textarea 1", "${DELETE}" );
        EN.VerifyValueWCM( "Textarea 1", "${EMPTY}" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  \brief
     *  Prüft, ob die Methode VerifyLabelWCM bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.  //
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyValueWCM_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValueWCM( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueWCM( "Textarea 1", "#oltan" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }

    /** \~german
     *  Test des Schlüsselwortes "VerifyValueREGX( FN, ExpValu ) für SeInputText.
     * 
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test
    public void tcVerifyValueREGX() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueREGX( "Textarea 1", ".oltan" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Testet VerifyValueREGX auf die OKW-Konstanten ${DELETE} und ${EMPTY} für
     *  SeTextarea implementiert ist.
     * 
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014-12-03
     */
    @Test
    public void tcVerifyValueREGX_DELETE_EMPTY() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueREGX( "Textarea 1", "\\woltan" );

        EN.SetValue( "Textarea 1", "${DELETE}" );
        EN.VerifyValueREGX( "Textarea 1", "${EMPTY}" );

        EN.StopApp( ApplicationName );
        EN.EndTest();
    }

    /** \~german
     *  Prüft, ob die Methode VerifyValueREGX bei einer Soll/Ist Abweichung die Ausnahme 
     *  OKWVerifyingFailsException für SeTextarea auslöst.  //
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2014.12.03
     * @throws Exception
     */
    @Test // ( expected = OKWVerifyingFailsException.class )
    public void tcVerifyValueREGX_OKWVerifyingFailsException() throws Exception
    {

        EN.BeginTest( TestName );
        EN.StartApp( ApplicationName );

        EN.TypeKey( "URL", "http://test.openkeyword.de/Textarea/textarea.htm" );
        EN.SelectWindow( "SeTextarea" );

        // First off all teh Name-Field is Empty
        EN.VerifyValue( "Textarea 1", "${EMPTY}" );

        EN.SetValue( "Textarea 1", "Zoltan" );
        EN.VerifyValueREGX( "Textarea 1", "Soltan" );

        EN.StopApp( ApplicationName );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });

    }
}
