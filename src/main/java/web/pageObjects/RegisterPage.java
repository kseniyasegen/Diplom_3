package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    // локатор поля имя
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement registerNameField;

    // локатор поля email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement registerEmailField;

    // локатор поля пароль
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement registerPasswordField;

    // локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerRegisterButton;

    // локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement registerLoginButton;

    // локатор текста Некорректный пароль
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement invalidPasswordText;

    //МЕТОДЫ
    //ввод имени в поле registerNameField
    public void setRegisterNameField(String a) {
        registerNameField.setValue(a);
    }

    //ввод email в поле registerEmailField
    public void setRegisterEmailField(String a) {
        registerEmailField.setValue(a);
    }

    //ввод пароля в поле registerPasswordField
    public void setRegisterPasswordField(String a) {
        registerPasswordField.setValue(a);
    }

    // клик на кнопку Зарегистрироваться
    public void clickOnRegisterRegisterButton() {
        registerRegisterButton.scrollTo();
        registerRegisterButton.shouldBe(enabled).click();
    }

    // клик на кнопку Войти
    public LoginPage clickOnRegisterLoginButton() {
        registerLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

    // заполнение формы регистрации и клик на Зарегистрироваться
    public LoginPage setRegisterFieldsAndClickRegisterButton(String a, String b, String c) {
        setRegisterNameField(a);
        setRegisterEmailField(b);
        setRegisterPasswordField(c);
        clickOnRegisterRegisterButton();
        return page(LoginPage.class);
    }

    //получить текст "Некорректный пароль"
    public String getTextInvalidPasswordText() {
        return invalidPasswordText.getText();
    }


}
