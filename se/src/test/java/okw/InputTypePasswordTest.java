package okw;

import okw.core.EN;
import okw.log.ILogger;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;
import okw.gui.adapter.selenium.webdriver.SeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.LinkedList;

public class InputTypePasswordTest {
    
    private static Log2HTML myLog2HTML = null;
    
    private static List<ILogger> loggers = new LinkedList<ILogger>();
    public static void addLogger(ILogger logger) {
        loggers.add(logger);
    }
    
    private static String logFileName = "target/InputTypePassword_Chrome_Test.html";
    public static void setLogFileName(String fn) {
        logFileName = fn;
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();
        
        myLog2HTML = new Log2HTML(logFileName);
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
        for (ILogger logger : loggers) {
            Logger_Sngltn.getInstance().addLogger(logger);
        }
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        myLog2HTML.Result2HTML();
    }
    
    private static int currentStep = -1;
    public static int getCurrentStep() {
        return currentStep;
    }
    
    private static void step(int i) throws InterruptedException {
        currentStep = i;
        if (Thread.interrupted()) throw new InterruptedException();
    }
    
    /**
     * 1
     */
    @Test
    public void test() throws Exception {
        EN.BeginTest( "test" );
        
        step(0);
        // URL(I) = "http://test.openkeyword.de/InputText/input_type-password.htm"
        
        if (System.getProperty("okw.app.Chrome.started") == null) {
            EN.StartApp("Chrome");
        } else {
            try {
                SeDriver.getInstance().driver.navigate().to("data:,");
                EN.SelectWindow("Chrome");
            } catch (WebDriverException e) {
                EN.StartApp("Chrome");
            }
        }
        System.setProperty("okw.app.Chrome.started", "true");
        EN.SetValue("URL", "http://test.openkeyword.de/InputText/InputTypePassword.htm");
        step(1);
        // User(I) = Zoltan
        EN.SelectWindow("InputTypePassword");
        EN.SetValue("User", "Zoltan");
        step(2);
        // Password(I) = Geheim
        EN.SetValue("Password", "Geheim");
        step(3);
        // User(O) = #label "User:"
        EN.VerifyLabel("User", "User:");
        step(4);
        // User(O) = #tooltip "Title: User"
        EN.VerifyTooltip("User", "Title: User");
        step(5);
        // Password(O) = #label "Password:"
        EN.VerifyLabel("Password", "Password:");
        step(6);
        // Password(O) = #tooltip "Title: Password"
        EN.VerifyTooltip("Password", "Title: Password");
        step(7);
        // DoesNotExist(O) = #not-present
        EN.VerifyExists("DoesNotExist", "NO");
        step(8);
        EN.StopApp( "Chrome" );
        EN.EndTest();
    }
}