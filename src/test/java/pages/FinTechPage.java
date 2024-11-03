package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FinTechPage {
    private String textInPageFinTech = "Разработка финансового ПО";
    private SelenideElement textFinTech = $(".chakra-text.css-xudeyq");


    @Step("Вкладка 'ФинТех' имеет текст 'Разработка финансового ПО'")
    public FinTechPage textFinTech () {
        textFinTech.shouldHave(text(textInPageFinTech));
        return this;
    }
}
