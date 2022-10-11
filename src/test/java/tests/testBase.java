package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import config.CredentialsConfig;
import helpers.AllureAttachments;
import helpers.DriverUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testBase {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);


        Configuration.baseUrl = System.getProperty("baseUrl", "https://ru.warface.com");
        Configuration.browser = System.getProperty("browser", "Chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + System.getProperty("remote", "selenoid.autotests.cloud/wd/hub");
    }
    @BeforeEach
    public void beforeEach() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
    }
}

