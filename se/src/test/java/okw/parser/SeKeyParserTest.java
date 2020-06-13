package okw.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.openqa.selenium.Keys;

public class SeKeyParserTest
{
    @Test
    public void test()
    {
        //SeKeyParser myParser = new SeKeyParser();
        
        String actual = SeKeyParser.ParseMe("#{SHIFT+CTRL+COMMAND+a}" );
        String expected = Keys.chord(Keys.SHIFT, Keys.CONTROL, Keys.COMMAND, "a");
        
        assertEquals( expected, actual );        
    }

    @Test
    public void test_mult_value()
    {
        //SeKeyParser myParser = new SeKeyParser();
        
        String actual = SeKeyParser.ParseMe("#{SHIFT+CTRL+COMMAND+abc}" );
        String expected = Keys.chord(Keys.SHIFT, Keys.CONTROL, Keys.COMMAND, "abc");
        
        assertEquals( expected, actual );        
    }

    
    @Test
    public void test_1()
    {
        //SeKeyParser myParser = new SeKeyParser();
        
        String actual = SeKeyParser.ParseMe("#{SHIFT+CTRL+COMMAND+DELETE}" );
        String expected = Keys.chord(Keys.SHIFT, Keys.CONTROL, Keys.COMMAND, Keys.DELETE);
        
        assertEquals( expected, actual );
        
    }
    
    @Test
    public void test_2()
    {
        //SeKeyParser myParser = new SeKeyParser();
        
        String actual = SeKeyParser.ParseMe("#{ALT+DELETE}" );
        String expected = Keys.chord(Keys.ALT, Keys.DELETE);
        
        assertEquals( expected, actual );
    }
}
