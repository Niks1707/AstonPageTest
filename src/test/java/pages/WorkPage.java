package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkPage {
    private SelenideElement
            jodButton = $("[href = 'https://career.astondevs.ru/vacancy']"),
            searchElement = $(".chakra-stack.css-k2yrf0 input[placeholder='Найди свою вакансию']"),
            vacanciesButton = $("[href = 'vacancy/500003707']"),
            requirementsList = $(".css-6smh3q"),
            tapButton = $(".chakra-stack.css-1trjysb button[type='submit']"),
            formColor = $(".chakra-text.css-1ulhys5");



    @Step("Выбор вкладки 'Вакансии'")
    public WorkPage choseVacancies () {
        jodButton.click();
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
    public WorkPage findVacancies () {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://career.astondevs.ru/vacancy");
        searchElement.scrollTo().setValue("QA Automation Engineer (Java)").pressEnter();
        return this;
    }

    @Step("Выбор первой вакансии 'QA Automation Engineer (Java)'")
    public WorkPage choseFirstVacancies() {
        vacanciesButton.click();
        return this;
    }

    @Step("Вкладка вакансии имеет требования для работы")
    public WorkPage jobRequirements () {
        requirementsList.shouldHave(text("опыт работы QA Automation Engineer (Java) от 3-х лет;"));
        return this;
    }

    @Step("Открыть страницу вакансии")
    public WorkPage openVacancies () {
        open(" https://career.astondevs.ru/vacancy/500003707");
        return this;
    }

    @Step("Отправить пустую форму")
    public WorkPage sendEmptyForm () {
        tapButton.click();
        return this;
    }
    @Step ("Теск под формой окрашен в красный цвет")
    public WorkPage emptyFormColorCheck (){
        formColor.shouldHave(cssValue("color", "rgba(215, 66, 66, 1)"));
        return this;
    }
}
