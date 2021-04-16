package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.attachScreenshot;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void attachScreens() {
        attachScreenshot("Last screenshot");
    }
}
