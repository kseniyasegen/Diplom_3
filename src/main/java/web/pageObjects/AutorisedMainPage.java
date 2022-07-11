package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class AutorisedMainPage {

    // локатор кнопки Оформить заказ (после авторизации)
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement autorisedMainMakeOrderButton;

    // локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement autorisedMainPersonalAreaButton;

    //МЕТОДЫ
    //получить текст "Оформить заказ"
    public String getTextAutorisedMainMakeOrderButton() {
        return autorisedMainMakeOrderButton.getText();
    }

    // клик на кнопку Личный кабинет
    public AutorisedPersonalAreaPage clickOnAutorisedMainPersonalAreaButton() {
        autorisedMainPersonalAreaButton.shouldBe(enabled).click();
        return page(AutorisedPersonalAreaPage.class);
    }


}
