package selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static final DesiredCapabilities driverCapabilities = new DesiredCapabilities();

    {
        driverCapabilities.setCapability("platform", Platform.WINDOWS);
    }

    public static WebDriver getDriver(final String browserName) {
        driverCapabilities.setCapability("browser", browserName);

        switch (browserName.toUpperCase()) {
            case "CHROME":
                return new RemoteWebDriver(driverCapabilities);
            case "LOCAL":
                System.setProperty("webdriver.chrome.driver", "D:\\Temp\\chromedriver_win32\\chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new UnsupportedOperationException("Browser " + browserName + " isn't supported");
        }
    }
}
