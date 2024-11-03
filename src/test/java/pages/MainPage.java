package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private String about = "О нас",
            services = "Услуги",
            projects = "Проекты",
            work = "Работа в Aston",
            radio = "ASTON Подкаст",
            application = "Оставить заявку";

    private SelenideElement aboutButton = $("[href = '/about-us']"),
            servicesButton = $("#menu-button-\\:Rajkd9bqH1\\:"),
            projectsButton = $("[href = '/our-projects']"),
            workButton = $("#menu-button-\\:Rcjkd9bqH1\\:"),
            radioButton = $("#header nav.chakra-stack.css-1rd9ubv > div:nth-child(7) > a"),
            applicationButton = $(".chakra-button.css-1xv700h"),
            finTechButton =  $("[href = '/services/financial-services']");


    @Step("Меню сайта имеет раздел 'О нас'")
    public MainPage pageHaveAbout() {
        aboutButton.shouldHave(text(about));
        return this;
    }

    @Step("Меню сайта имеет раздел 'Услуги'")
    public MainPage pageHaveServices() {
        servicesButton.shouldHave(text(services));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Проекты'")
    public MainPage pageHaveProjects() {
        projectsButton.shouldHave(text(projects));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Работа в Aston'")
    public MainPage pageHaveWork() {
        workButton.shouldHave(text(work));
        return this;
    }
    @Step("Меню сайта имеет раздел 'ASTON Подкаст'")
    public MainPage pageHaveRadio() {
        radioButton.shouldHave(text(radio));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Оставить заявку'")
    public MainPage pageHaveApplication() {
        applicationButton.shouldHave(text(application));
        return this;
    }

    @Step("Нажатие на 'О нас'")
    public MainPage tapAbout () {
        aboutButton.click();
        return this;
    }

    @Step("Нажатие на 'Услуги'")
    public MainPage tapServices () {
        servicesButton.click();
        return this;
    }
    @Step("Выбор вкладки 'ФинТех'")
    public MainPage choseFinTech () {
        finTechButton.click();
        return this;
    }

    @Step("Нажатие на 'Проекты'")
    public MainPage choseProjects () {
        projectsButton.click();
        return this;
    }

    @Step("Нажатие на 'Работа в Aston'")
    public MainPage choseWork () {
        workButton.click();
        return this;
    }
}
