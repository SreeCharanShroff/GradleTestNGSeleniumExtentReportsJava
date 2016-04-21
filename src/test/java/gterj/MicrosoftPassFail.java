package gterj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by shrofs on 4/17/2016.
 */
public class MicrosoftPassFail {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"implicitWait", "browser", "baseURL"})
    public final void setUp(String implicitWait, String browser, String baseURL) {
        this.driver = BrowserDriver.initialize(driver, implicitWait, browser, baseURL);
    }

    @Test
    public final void testMicrosoftPass() {
        driver.findElement(By.xpath("//input[@title='Search Microsoft.com']")).sendKeys("SreeCharan Shroff");
        Assert.assertEquals(driver.getTitle(), "Microsoft – Official Home Page");
    }

    @Test(dependsOnMethods = "testMicrosoftPass")
    public final void testMicrosoftFail() {
        driver.findElement(By.xpath("//button[@title='Search')]")).click();
        Assert.assertEquals(driver.getTitle(), "Microsoft – Official Home Pages");
    }

    @AfterTest
    public final void cleanUp() {
        BrowserDriver.destroy(driver);
    }
}
