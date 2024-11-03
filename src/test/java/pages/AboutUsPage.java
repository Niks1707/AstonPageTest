package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AboutUsPage {
    private String textInPageAbout = "Высокие стандарты, изящные решения";
    private SelenideElement textAbout = $(".chakra-stack.css-1thp0ii");


    @Step("Вкладка 'О нас' имеет текст 'Высокие стандарты, изящные решения'")
    public AboutUsPage textAbout () {
        textAbout.shouldHave(text(textInPageAbout));
        return this;
    }

}
