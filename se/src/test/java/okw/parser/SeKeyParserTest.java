package okw.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.*;

import org.openqa.selenium.Keys;

public class SeKeyParserTest
{

    @BeforeAll
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception
    {
    }

    @BeforeEach
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

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
