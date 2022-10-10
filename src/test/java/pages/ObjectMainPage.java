package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;

public class ObjectMainPage {

    public ObjectMainPage openURL() {
        Selenide.open(baseUrl);
        return this;
    }

    public ObjectMainPage headerСheck () {
        $(".user_links").shouldHave(Condition.text("Мои предметы"));
        $(".user_links").shouldHave(Condition.text("Активировать ПИН-код"));
        $(".user_links").shouldHave(Condition.text("Помощь"));
        return this;
    }
    public ObjectMainPage headerMainCheck () {
        $("#block-menu-primary-links").shouldHave(Condition.text("Новости"));
        $("#block-menu-primary-links").shouldHave(Condition.text("Об игре"));
        $("#block-menu-primary-links").shouldHave(Condition.text("eSports"));
        $("#block-menu-primary-links").shouldHave(Condition.text("Общение"));
        $("#block-menu-primary-links").shouldHave(Condition.text("Wiki"));
        $("#block-menu-primary-links").shouldHave(Condition.text("Пополнить счет"));
        return this;
    }
    public ObjectMainPage headerGo () {
        $("#block-menu-primary-links #menu69df1f85b0abbce850b5feb29bddcb2a > a").click();
        $("#block-menu-primary-links #menuacf664b247822ae00651a97d44f5f4c0 > a").click();
        $("#block-menu-primary-links #menu3e5d53ad868231660799b4c559ea5211 > a").click();
        $("#block-menu-primary-links #menud54b7ba27571a2f00b38ed9273b974f2 > a").click();
        Selenide.back();
        $("#block-menu-primary-links #menu3f37694eebbafa5705a6b637fadc169c > a").click();
        Selenide.back();
        $("#block-menu-primary-links #menu0f7ef45a6478ef6aa87af9eb9952f101 > a").click();
        return this;
    }
    public ObjectMainPage LoadingLauncher () {
        $(".js-download").click();
        return this;
    }
}
