package helpers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import com.codeborne.selenide.Configuration;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverSettings {
        public static void configure() {
            Configuration.browser = Project.config.browser();
            Configuration.browserVersion = Project.config.browserVersion();
            Configuration.browserSize = Project.config.browserSize();
//        Configuration.baseUrl = App.config.webUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--lang=en-en");

            if (Project.isWebMobile()) { // for chrome only
                Map<String, Object> mobileDevice = new HashMap<>();
                mobileDevice.put("deviceName", Project.config.browserMobileView());
                chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
            }

            if (Project.isRemoteWebDriver()) {
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                Configuration.remote = Project.config.remoteUrl();
            }

            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            Configuration.browserCapabilities = capabilities;
        }
}
