package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class ProjectsPage {
    private String textInPageProjects = "Разработки и отраслевые решения";
    private SelenideElement textProjects = $(".chakra-text.css-1cj14b4");

    @Step("Вкладка 'Проекты' имеет текст 'Разработки и отраслевые решения'")
    public ProjectsPage textProjects () {
        textProjects.shouldHave(text(textInPageProjects));
        return this;
    }
}
