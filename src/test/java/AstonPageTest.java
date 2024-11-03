import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

@DisplayName("Тестирование сайта компании Aston ")
@Tag("Test")
@Owner(value = "Genkel Veronika")
public class AstonPageTest extends TestBase {
    MainPage maiePage = new MainPage();
    FinTechPage finTechPage = new FinTechPage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    ProjectsPage projectsPage = new ProjectsPage();
    WorkPage workPage = new WorkPage();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/")
    @DisplayName("Проверка названия меню на странице компании Aston")
    void menuPageTest() {
        maiePage.pageHaveAbout()
                .pageHaveServices()
                .pageHaveProjects()
                .pageHaveWork()
                .pageHaveRadio()
                .pageHaveApplication();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/about-us")
    @DisplayName("Проверка вкладки меню 'О нас'")
    void aboutPageTest() {
        maiePage.tapAbout();
        aboutUsPage.textAbout();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/services/financial-services")
    @DisplayName("Проверка вкладки меню 'Услуги'")
    void servicesPageTest() {
        maiePage.tapServices()
                .choseFinTech();
        finTechPage.textFinTech();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://astondevs.ru/our-projects")
    @DisplayName("Проверка вкладки меню 'Проекты'")
    void projectsPageTest() {
        maiePage.choseProjects();
        projectsPage.textProjects();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://career.astondevs.ru/vacancy")
    @DisplayName("Проверка вкладки меню 'Работа в Aston'")
    void workPageTest() {
        maiePage.choseWork();
        workPage.choseVacancies()
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
        maiePage.choseWork();
        workPage.choseVacancies()
                .findVacancies()
                .choseFirstVacancies()
                .jobRequirements()
                .sendEmptyForm()
                .emptyFormColorCheck();

    }


}
