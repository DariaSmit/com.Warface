package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;

public class ObjectPromo {


    public ObjectPromo openURL() {
        Selenide.open(baseUrl);
        return this;
    }

    public ObjectPromo clickPromoNewPower() {
        $("#mr_block_news > div.cont_layout.type_promo > div.aside > div:nth-child(1) > a:nth-child(1) > img").click();
        return this;
    }

    public ObjectPromo clickSeason() {
        $(new ByText("О сезоне")).click();
        return this;
    }

    public ObjectPromo clickGift() {
        $(".promo-btn__cont").click();
        $(".prize__info-wrap").shouldHave(Condition.text("Получи набор брони \"Авангард\" и набор оружия эксперта \"Отступник\" на 15 дней."));
        $(".prize__info-wrap").shouldHave(Condition.text("ЗАРЕГИСТРИРУЙСЯ"));
        $(".modal__close").click();
        return this;
    }

    public ObjectPromo clickMods() {
        $(new ByText("Моды")).click();
        $(".mods-content").shouldHave(Condition.text("Выполняй тематические контракты или используй в бою предмет с модами, чтобы получить специальную валюту (детали) для улучшения модов."));
        return this;
    }
    public ObjectPromo clickPvP () {
        $(new ByText("PvP-карты")).click();
        return this;
    }
    public ObjectPromo clickBattlePass() {
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
        return this;
    }
    public ObjectPromo clickTasks() {
        $(new ByText("Боевой пропуск")).click();
        return this;
    }
}

