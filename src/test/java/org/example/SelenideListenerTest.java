package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static org.openqa.selenium.By.linkText;

class SelenideListenerTest extends TestBase {

    @Test
    void issueSearchSelenidePassingTest() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).shouldBe(visible);
        attachment("Source", webdriver().driver().source());
    }

    @Test
    void issueSearchSelenideFailingTest() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("# " + ISSUE)).shouldBe(visible, Duration.ofSeconds(1));
    }
}
