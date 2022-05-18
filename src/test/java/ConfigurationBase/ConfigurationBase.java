package ConfigurationBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ConfigurationBase {

    public WebDriver webDriver;

    @BeforeTest
    public void configSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @AfterTest
    public void cleanUp() {
        webDriver.quit();
    }
}
