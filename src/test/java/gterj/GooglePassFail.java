package gterj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by shrofs on 4/17/2016.
 */
public class GooglePassFail {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"implicitWait", "browser", "baseURL"})
    public void setUp(String implicitWait, String browser, String baseURL) {
        this.driver = BrowserDriver.initialize(driver, implicitWait, browser, baseURL);
    }

    @Test
    public void testGooglePass() {
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("SreeCharan Shroff");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(dependsOnMethods = "testGooglePass")
    public void testGoogleFail() {
        driver.findElement(By.xpath("//*[@name='btnG']")).click();
        Assert.assertEquals(driver.getTitle(), "Gogle");
    }

    @AfterTest
    public void cleanUp() {
        BrowserDriver.destroy(driver);
    }
}