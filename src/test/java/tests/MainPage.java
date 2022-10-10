package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.ObjectMainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage extends testBase {
    ObjectMainPage mainPage = new ObjectMainPage();

    @Test
    @Description("Проверка главной стрнаницы")
    @DisplayName("Проверка текста заголовков")
    public void CheckMenu() {

        step("открыть главную страницу", () -> {
            mainPage.openURL();
        });
        step("Проверить  заголовки в шапке сайта", () -> {
            mainPage.headerСheck();
        });
        step("Проверить главные заголовки", () -> {
            mainPage.headerMainCheck();
        });
        step("Проверить переходы по заголовкам", () -> {
            mainPage.headerGo();
        });
    }

    @Test
    @Description("Проверка загрузки лаунчера игры")
    @DisplayName("Проверка загрузки")
    public void CheckLoadFile() {
        step("открыть главную страницу", () -> {
            mainPage.openURL();
        });
        step("Загрузка лаунчера игры", () -> {
            mainPage.LoadingLauncher();
        });
    }
}

