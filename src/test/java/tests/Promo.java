package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import sun.jvm.hotspot.utilities.Assert;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class Promo extends testBase{

    @Test
    public void Promo() {
        Configuration.holdBrowserOpen = true;

        step("открыть главную страницу", ()-> {
            Selenide.open(baseUrl);
        });

        step("Нажать Promo 'Новая Сила'",()->{
            $("#mr_block_news > div.cont_layout.type_promo > div.aside > div:nth-child(1) > a:nth-child(2)").click();
        });
        step("Нажать на заголовок 'О сезоне'",()->{
            $(new ByText("О сезоне")).click();
        });
        step("Нажать на кнопку 'Получить подарки'", ()->{
            $(".promo-btn__cont").click();
            $(".prize__info-wrap").shouldHave(Condition.text("Получи набор брони \"Авангард\" и набор оружия эксперта \"Отступник\" на 15 дней."));
            $(".prize__info-wrap").shouldHave(Condition.text("ЗАРЕГИСТРИРУЙСЯ"));
            $(".modal__close").click();
        });
        step("Нажать на заголовок 'Моды'", ()->{
            $(new ByText("Моды")).click();
            $(".mods-content").shouldHave(Condition.text("Выполняй тематические контракты или используй в бою предмет с модами, чтобы получить специальную валюту (детали) для улучшения модов."));
        });
        step("Нажать на заголовок 'PvP-карты'", ()->{
            $(new ByText("PvP-карты")).click();
        });
        step("Нажать на заголовок 'Боевой пропуск'", ()->{
            $(new ByText("Боевой пропуск")).click();
            $(new ByText("Снаряжение")).click();
            $(new ByText("Снаряжение")).scrollIntoView(true);
            $(".bp-card__name").shouldHave(Condition.text("Набор снаряжения \"Графит\" для штурмовика"));

            $(new ByText("Снаряжение")).scrollIntoView(false);
            $(new ByText("Брелоки")).click();
            $(new ByText("Снаряжение")).scrollIntoView(true);
            $(".bp-card__name").shouldHave(Condition.text("Брелок \"Реактор A\""));

            $(new ByText("Снаряжение")).scrollIntoView(false);
            $(new ByText("Достижения")).click();
            $(new ByText("Снаряжение")).scrollIntoView(true);
            $(".bp-card__name").shouldHave(Condition.text("Нашивка \"Система охлаждения\" "));
        });
        step("Нажать на заголовок 'Задания агентов'",()->{
            $(new ByText("Боевой пропуск")).click();
        });


    }

    }