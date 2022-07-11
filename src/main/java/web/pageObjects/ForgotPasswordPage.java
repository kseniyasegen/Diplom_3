package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    // локатор поля email
    @FindBy(how = How.XPATH, using = "//div[@class='input__container' and contains(text(),'Email')]")
    private SelenideElement forgotPasswordEmailField;

    // локатор кнопки Восстановить
    @FindBy(how = How.XPATH, using = "//button[text()='Восстановить']")
    private SelenideElement forgotPasswordRecoverButton;

    // локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement forgotPasswordLoginButton;

    //МЕТОДЫ
    //ввод имени в поле forgotPasswordEmailField
    public void setForgotPasswordEmailField(String a) {
        forgotPasswordEmailField.setValue(a);
    }

    // клик на кнопку Восстановить
    public LoginPage clickOnForgotPasswordRecoverButton() {
        forgotPasswordRecoverButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

    // клик на кнопку Войти
    public LoginPage clickOnForgotPasswordLoginButton() {
        forgotPasswordLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

    // заполнение формы восстановления и клик на Восстановить
    public ForgotPasswordPage setForgotPasswordFields(String a) {
        setForgotPasswordEmailField(a);
        clickOnForgotPasswordRecoverButton();
        return page(ForgotPasswordPage.class);
    }
}
