package okw.setypekeyscharsequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.openqa.selenium.Keys;

import okw.gui.adapter.selenium.SeTypeKeysCharSequence;

@Tag("SeTypeKeysCharSequenceTest")
public class SeTypeKeysCharSequenceTest
{
    @Test
    public void test_setALT()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT( );
        myCharKeys.setText( "a" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord(Keys.ALT, "a");
        
        assertEquals( expected, actual );
    }

    @Test
    public void test_setCOMMAND()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setCOMMAND( );
        myCharKeys.setText( "b" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord(Keys.COMMAND, "b");
        
        assertEquals( expected, actual );
    }

    @Test
    public void test_setCTRL()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setCTRL(  );
        myCharKeys.setText( "c" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord(Keys.CONTROL, "c");
        
        assertEquals( expected, actual );
    }

    @Test
    public void test_setSHIFT()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setSHIFT( );
        myCharKeys.setText( "d" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord(Keys.SHIFT, "d");
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_setALT_CTRL()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT( );
        myCharKeys.setCTRL( );
        myCharKeys.setText( "e" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.CONTROL, "e");
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_setALT_CTRL_SHIFT()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT(  );
        myCharKeys.setCTRL( );
        myCharKeys.setSHIFT( );
        myCharKeys.setText( "ef" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.CONTROL, Keys.SHIFT, "ef");
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_setALT_CTRL_COMMAND()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT(  );
        myCharKeys.setCOMMAND(  );
        myCharKeys.setCTRL(  );
        myCharKeys.setText( "e" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.COMMAND, Keys.CONTROL, "e");
        
        assertEquals( expected, actual );
    }
    
    
    @Test
    public void test_ALT_CTRL_SHIFT_COMMAND()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT();
        myCharKeys.setCOMMAND();
        myCharKeys.setCTRL();
        myCharKeys.setSHIFT();
        
        myCharKeys.setText( "hijk" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.COMMAND, Keys.CONTROL, Keys.SHIFT, "hijk");
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_reset_ALT_CTRL_SHIFT_COMMAND()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT();
        myCharKeys.setCOMMAND();
        myCharKeys.setCTRL();
        myCharKeys.setSHIFT();
        
        myCharKeys.setText( "hijk" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.COMMAND, Keys.CONTROL, Keys.SHIFT, "hijk");

        assertEquals( expected, actual );
        
        myCharKeys.reset();
 
        myCharKeys.setCOMMAND();
        myCharKeys.setCTRL();
        myCharKeys.setSHIFT();
        myCharKeys.setALT();
        
        myCharKeys.setText( "hijk" );
        
        actual = myCharKeys.getCharSequenze();
        expected = Keys.chord( Keys.COMMAND, Keys.CONTROL, Keys.SHIFT, Keys.ALT, "hijk");
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_KeyValue()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setKeyvalue( "DELETE" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.DELETE );
        
        assertEquals( expected, actual );
    }
    
    @Test
    public void test_ALT_CTRL_SHIFT_COMMAND_KeyValue()
    {
        SeTypeKeysCharSequence myCharKeys = new SeTypeKeysCharSequence();
        
        myCharKeys.setALT();
        myCharKeys.setCOMMAND();
        myCharKeys.setCTRL();
        myCharKeys.setSHIFT();
        
        myCharKeys.setKeyvalue( "ARROW_DOWN" );
        
        String actual = myCharKeys.getCharSequenze();
        String expected = Keys.chord( Keys.ALT, Keys.COMMAND, Keys.CONTROL, Keys.SHIFT, Keys.ARROW_DOWN);

        assertEquals( expected, actual );
       
    }
}
