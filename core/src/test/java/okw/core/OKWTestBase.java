package okw.core;

import org.junit.jupiter.api.*;

public class OKWTestBase
{
    public String TestName;

    @BeforeEach
    void init(TestInfo testInfo)
    {
        TestName = testInfo.getTestMethod().get().getName();
    }
    public OKWTestBase()
    {
        // TODO Auto-generated constructor stub
    }

}
