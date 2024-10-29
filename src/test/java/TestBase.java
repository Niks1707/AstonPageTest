import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void setUp() {

        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = "https://astondevs.ru";
        Configuration.timeout = 10000;
        Configuration.remote = "https://" + System.getProperty("login") + "@" + System.getProperty("remote");
        Configuration.browser = System.getProperty("browserName","chrome");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browserVersion = System.getProperty("browserVersion");

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void openPage() {
        open("https://astondevs.ru/");
        SelenideElement confirmButton = $$(".chakra-button.css-6e5x8g").findBy(text("Подтверждаю"));
        confirmButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
            Attach.screenshotAs("Last Screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            Selenide.closeWebDriver();
    }
}
//public class TestBase {
//
//    @BeforeAll
//    static void setUp()  {
//        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadStrategy = "eager";
//    }
//
//    @BeforeEach
//    void openPage() {
//        open("https://astondevs.ru/");
//        SelenideElement confirmButton = $$(".chakra-button.css-6e5x8g").findBy(text("Подтверждаю"));
//        confirmButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }
//
//    @AfterEach
//    void  closeAll(){
//        Selenide.closeWebDriver();
//    }
//}
