package TestEnvSetup;

import BaseSetup.Makemytrip_SingletonBaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class TestSetup {

    @BeforeClass
    public void envSetup() throws IOException
    {
        Makemytrip_SingletonBaseClass.webDriverInstanceSetup();
    }

    @AfterClass
    public void envDestroy()
    {
        Makemytrip_SingletonBaseClass.webDriverInstanceTearDown();
    }
}
