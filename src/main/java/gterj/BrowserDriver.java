package gterj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by shrofs on 4/17/2016.
 */
public final class BrowserDriver {

    private BrowserDriver() {
    }

    public static WebDriver initialize(WebDriver driver, final String implicitWait, final String browser, final String baseURL) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "./browsers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitWait), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        return driver;
    }

    public static void destroy(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}
