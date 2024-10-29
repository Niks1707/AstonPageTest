package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebStep {

    public String about = "О нас",
            services = "Услуги",
            projects = "Проекты",
            work = "Работа в Aston",
            radio = "ASTON Подкаст",
            application = "Оставить заявку",
            textInPageAbout = "Высокие стандарты, изящные решения",
            textInPageFinTech = "Разработка финансового ПО",
            textInPageProjects = "Разработки и отраслевые решения";

    private SelenideElement aboutButton = $("[href = '/about-us']"),
            servicesButton = $("#menu-button-\\:Rajkd9bqH1\\:"),
            projectsButton = $("[href = '/our-projects']"),
            workButton = $("#menu-button-\\:Rcjkd9bqH1\\:"),
            radioButton = $("[href = '/radio']"),
            applicationButton = $(".chakra-button.css-1xv700h"),
            textAbout = $(".chakra-stack.css-1thp0ii"),
            finTechButton =  $("[href = '/services/financial-services']"),
            textFinTech = $(".chakra-text.css-xudeyq"),
            textProjects = $(".chakra-text.css-1cj14b4"),
            jodButton = $("[href = 'https://career.astondevs.ru/vacancy']"),
            searchElement = $(".chakra-stack.css-k2yrf0 input[placeholder='Найди свою вакансию']"),
            vacanciesButton = $("[href = 'vacancy/500003707']"),
            requirementsList = $(".css-6smh3q"),
            tapButton = $(".chakra-stack.css-1trjysb button[type='submit']"),
            formColor = $(".chakra-text.css-1ulhys5");

    @Step("Меню сайта имеет раздел 'О нас'")
    public WebStep pageHaveAbout() {
        aboutButton.shouldHave(text(about));
        return this;
    }

    @Step("Меню сайта имеет раздел 'Услуги'")
    public WebStep pageHaveServices() {
        servicesButton.shouldHave(text(services));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Проекты'")
    public WebStep pageHaveProjects() {
        projectsButton.shouldHave(text(projects));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Работа в Aston'")
    public WebStep pageHaveWork() {
        workButton.shouldHave(text(work));
        return this;
    }
    @Step("Меню сайта имеет раздел 'ASTON Подкаст'")
    public WebStep pageHaveRadio() {
        radioButton.shouldHave(text(radio));
        return this;
    }
    @Step("Меню сайта имеет раздел 'Оставить заявку'")
    public WebStep pageHaveApplication() {
        applicationButton.shouldHave(text(application));
        return this;
    }

    @Step("Нажатие на 'О нас'")
    public WebStep tapAbout () {
        aboutButton.click();
        return this;
    }

    @Step("Вкладка 'О нас' имеет текст 'Высокие стандарты, изящные решения'")
    public WebStep textAbout () {
        textAbout.shouldHave(text(textInPageAbout));
        return this;
    }

    @Step("Нажатие на 'Услуги'")
    public WebStep tapServices () {
        servicesButton.click();
        return this;
    }
    @Step("Выбор вкладки 'ФинТех'")
    public WebStep choseFinTech () {
        finTechButton.click();
        return this;
    }

    @Step("Вкладка 'ФинТех' имеет текст 'Разработка финансового ПО'")
    public WebStep textFinTech () {
        textFinTech.shouldHave(text(textInPageFinTech));
        return this;
    }
    @Step("Нажатие на 'Проекты'")
    public WebStep choseProjects () {
        projectsButton.click();
        return this;
    }

    @Step("Вкладка 'Проекты' имеет текст 'Разработки и отраслевые решения'")
    public WebStep textProjects () {
        textProjects.shouldHave(text(textInPageProjects));
        return this;
    }

    @Step("Нажатие на 'Работа в Aston'")
    public WebStep choseWork () {
        workButton.click();
        return this;
    }

    @Step("Выбор вкладки 'Вакансии'")
    public WebStep choseVacancies () {
        jodButton.click();
        //sleep(2000);
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    @Step("Поиск вакансии 'QA Automation Engineer (Java)'")
    public WebStep findVacancies () {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://career.astondevs.ru/vacancy");
        searchElement.scrollTo().setValue("QA Automation Engineer (Java)").pressEnter();
        return this;
    }

    @Step("Выбор первой вакансии 'QA Automation Engineer (Java)'")
    public WebStep choseFirstVacancies() {
        vacanciesButton.click();
        return this;
    }

    @Step("Вкладка вакансии имеет требования для работы")
    public WebStep jobRequirements () {
        requirementsList.shouldHave(text("опыт работы QA Automation Engineer (Java) от 3-х лет;"));
        return this;
    }

    @Step("Открыть страницу вакансии")
    public WebStep openVacancies () {
        open(" https://career.astondevs.ru/vacancy/500003707");
        return this;
    }

    @Step("Отправить пустую форму")
    public WebStep sendEmptyForm () {
        tapButton.click();
        return this;
    }
    @Step ("Теск под формой окрашен в красный цвет")
    public WebStep emptyFormColorCheck (){
        formColor.shouldHave(cssValue("color", "rgba(215, 66, 66, 1)"));
        return this;
    }
}
