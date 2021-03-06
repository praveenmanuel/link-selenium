package com.nhsn.testcases;

import com.nhsn.BaseClass;
import com.nhsn.pages.HomePage;
import com.nhsn.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC02_MedicationAdministration_Test extends BaseClass {
    LoginPage lPage;
    HomePage hPage;
    JavascriptExecutor jse ;
    @Test
    public void generateCovidReport() throws InterruptedException {
        lPage = new LoginPage(driver);
        hPage = new HomePage(driver);
        jse = (JavascriptExecutor)driver;
        try
        {
            lPage.loginToNHSNLinkApp("praveen_manuel", "Welcome@123");
            hPage.generateReport("NHSN Medication Administration");
        }
        catch(Exception e)
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Error in the Test case\"}}");
            System.out.println(e.getMessage());
            Assert.fail("Error in the Test");
        }
    }
}
