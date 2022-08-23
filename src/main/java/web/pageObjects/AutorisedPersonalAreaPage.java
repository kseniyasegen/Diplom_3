package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class AutorisedPersonalAreaPage {

    // локатор кнопки Выход
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement autorisedPersonalAreaExitButton;

    //МЕТОДЫ
    // клик на кнопку Выход
    public LoginPage clickOnAutorisedPersonalAreaExitButton() {
        autorisedPersonalAreaExitButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

}
