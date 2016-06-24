package okw.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
@RunWith(Parameterized.class)
public class Matcher_RegexMatcherTest {
 
        @Parameters(name = "{index}: WildCardMatch(\"{0}\", \"{1}\" ) = >{2}<")
        public static Collection<Object[]> data() {
                return Arrays.asList(new Object[][] {
                                { "false", "[f|F]alse", true },
                                { "false", "^[f|F]alse", true },
                                { "Aalse", "^[f|F]alse", false },
                                { "False", "[f|F]alse", true } });
        }
 
        private String fString1;
        private String fString2;
 
        private boolean fexpected;
 
        // parameters pass via this constructor
        public Matcher_RegexMatcherTest(String String1, String String2,
                        boolean expected) {
 
                fString1 = String1;
                fString2 = String2;
 
                fexpected = expected;
        }
 
        @Test
        public void tc_LevenshteinDistance_1() {
 
                assertEquals(fexpected, Matcher.RegexMatch(fString1, fString2));
 
        }
 
}