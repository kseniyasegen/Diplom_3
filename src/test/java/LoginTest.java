import api.CommonFields;
import api.DeleteUser;
import api.RegisterUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pageObjects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class LoginTest {

    MainPage mainPage;
    RegisterUser registerUser = new RegisterUser();
    CommonFields commonFields = new CommonFields();
    DeleteUser deleteUser = new DeleteUser();

    @Before
    public void start() {
        //Выбор браузера yandexDriver или chromeDriver
        System.setProperty("webdriver.chrome.driver", CommonFields.yandexDriver);
        WebDriver driver = new ChromeDriver();
        setWebDriver(driver);

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void verifyThatUserWasAutorisedByClickingOnLoginButton() throws InterruptedException {
        //регистрация юзера через API
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        //авторизация юзера через web
        LoginPage loginPage = mainPage.clickOnMainLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage.setLoginFields(commonFields.email, commonFields.password);
        //проверка авторизации
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        //удаление юзера
        CommonFields.accessTokenAfterRegister = CommonFields.response.path("accessToken");
        deleteUser.deleteUser();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void verifyThatUserWasAutorisedByClickingOnPersonalAreaButton() throws InterruptedException {
        //регистрация юзера через API
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        //авторизация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        AutorisedMainPage autorisedMainPage = loginPage.setLoginFields(commonFields.email, commonFields.password);
        //проверка авторизации
        Assert.assertTrue(autorisedMainPage.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        //удаление юзера
        CommonFields.accessTokenAfterRegister = CommonFields.response.path("accessToken");
        deleteUser.deleteUser();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void verifyThatUserWasAutorisedByClickingOnLoginRegisterButton() throws InterruptedException {
        //регистрация юзера через API
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        //регистрация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        LoginPage loginPage1 = registerPage.clickOnRegisterLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage1.setLoginFields(commonFields.email, commonFields.password);
        //проверка авторизации
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        //удаление юзера
        CommonFields.accessTokenAfterRegister = CommonFields.response.path("accessToken");
        deleteUser.deleteUser();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void verifyThatUserWasAutorisedByClickingOnLoginForgotPasswordButton() throws InterruptedException {
        //регистрация юзера через API
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        //регистрация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickOnLoginForgotPasswordButton();
        LoginPage loginPage1 = forgotPasswordPage.clickOnForgotPasswordLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage1.setLoginFields(commonFields.email, commonFields.password);
        //проверка авторизации
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        //удаление юзера
        CommonFields.accessTokenAfterRegister = CommonFields.response.path("accessToken");
        deleteUser.deleteUser();
    }

    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }

}
