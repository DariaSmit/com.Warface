package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

import pages.ObjectPromo;


public class Promo extends testBase {
    ObjectPromo objectPage = new ObjectPromo();

    @Description("Проверка страинцы ПРОМО нового сезона")
    @DisplayName("Проверка страницы")
    @Test
    public void Promo() {
        Configuration.holdBrowserOpen = true;

        step("открыть главную страницу", () -> {
            objectPage.openURL();
        });
        step("Нажать Promo 'Новая Сила'", () -> {
            objectPage.clickPromoNewPower();
        });
        step("Нажать на заголовок 'О сезоне'", () -> {
            objectPage.clickSeason();
        });
        step("Нажать на кнопку 'Получить подарки'", () -> {
            objectPage.clickGift();
        });
        step("Нажать на заголовок 'Моды'", () -> {
            objectPage.clickMods();
        });
        step("Нажать на заголовок 'PvP-карты'", () -> {
            objectPage.clickPvP();
        });
        step("Нажать на заголовок 'Боевой пропуск'", () -> {
            objectPage.clickBattlePass();
        });
        step("Нажать на заголовок 'Задания агентов'", () -> {
            objectPage.clickTasks();
        });


    }

}