package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnnotationStepsTest extends TestBase {

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("werechess")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing Link", url = "https://testing.github.com")
    @DisplayName("Поиск Issue для неавторизованного пользователя")
    void annotatedStepsTest() {
        TestBase.openMainPage();
        TestBase.searchForRepository(REPOSITORY);
        TestBase.clickOnRepositoryLink(REPOSITORY);
        TestBase.openIssuesTab();
        TestBase.shouldSeeIssueWithNumber(ISSUE);
        TestBase.takeScreenshot();
    }
}
