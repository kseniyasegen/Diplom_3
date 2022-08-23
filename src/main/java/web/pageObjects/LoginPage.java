package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //локатор текста Вход
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement loginLoginText;

    // локатор поля email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement loginEmailField;

    // локатор поля пароль
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement loginPasswordField;

    // локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginLoginButton;

    // локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement loginRegisterButton;

    // локатор кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement loginForgotPasswordButton;

    // локатор кнопки Логотипа
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement loginLogoButton;

    // локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement loginConstructorButton;

    //МЕТОДЫ
    //ввод email в поле loginEmailField
    public void setLoginEmailField(String a) {
        loginEmailField.setValue(a);
    }

    //ввод пароля в поле loginPasswordField
    public void setLoginPasswordField(String a) {
        loginPasswordField.setValue(a);
    }

    // клик на кнопку Войти
    public void clickOnLoginLoginButton() {
        loginLoginButton.shouldBe(enabled).click();
    }

    // клик на кнопку Зарегистрироваться
    public RegisterPage clickOnLoginRegisterButton() {
        loginRegisterButton.shouldBe(enabled).click();
        return page(RegisterPage.class);
    }

    // клик на кнопку Восстановить пароль
    public ForgotPasswordPage clickOnLoginForgotPasswordButton() {
        loginForgotPasswordButton.shouldBe(enabled).click();
        return page(ForgotPasswordPage.class);
    }

    // заполнение формы авторизации и клик на Войти
    public AutorisedMainPage setLoginFields(String a, String b) {
        setLoginEmailField(a);
        setLoginPasswordField(b);
        clickOnLoginLoginButton();
        return page(AutorisedMainPage.class);
    }

    public String getTextLoginLoginButton() {
        return loginLoginButton.getText();
    }

    public String getTextloginLoginText() {
        return loginLoginText.getText();
    }

    // клик на Логотип
    public MainPage clickOnLogoButton() {
        loginLogoButton.shouldBe(enabled).click();
        return page(MainPage.class);
    }

    // клик на кнопку Конструктор
    public MainPage clickOnLoginConstructorButton() {
        loginConstructorButton.shouldBe(enabled).click();
        return page(MainPage.class);
    }

}
