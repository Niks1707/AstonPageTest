import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.WebStep;

@DisplayName("Тестирвоание сайта комапании Aston ")
@Tag("Test")
public class AstonPageTest extends TestBase {
    WebStep webSteps = new WebStep();

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/")
    @DisplayName("Проверка названия меню на странице компании Aston")
    void menuPageTest() {
        webSteps.pageHaveAbout()
                .pageHaveServices()
                .pageHaveProjects()
                .pageHaveWork()
                .pageHaveRadio()
                .pageHaveApplication();
    }

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/about-us")
    @DisplayName("Проверка вкладки меню 'О нас'")
    void aboutPageTest() {
        webSteps.tapAbout()
                .textAbout();
    }

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/services/financial-services")
    @DisplayName("Проверка вкладки меню 'Услуги'")
    void servicesPageTest() {
        webSteps.tapServices()
                .choseFinTech()
                .textFinTech();
    }

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/our-projects")
    @DisplayName("Проверка вкладки меню 'Проекты'")
    void projectsPageTest() {
        webSteps.choseProjects()
                .textProjects();
    }

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://career.astondevs.ru/vacancy")
    @DisplayName("Проверка вкладки меню 'Работа в Aston'")
    void workPageTest() {
        webSteps.choseWork()
                .choseVacancies()
                .findVacancies()
                .choseFirstVacancies()
                .jobRequirements();
    }

    @Test
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://career.astondevs.ru/vacancy/500003707")
    @DisplayName("Проверка отправки пустой формы")
    void emptyFormTest() {
        webSteps.choseWork()
                .choseVacancies()
                .findVacancies()
                .choseFirstVacancies()
                .jobRequirements()
                .sendEmptyForm()
                .emptyFormColorCheck();

    }


}
