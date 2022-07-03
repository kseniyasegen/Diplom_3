import api.CommonFields;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pageObjects.LoginPage;
import web.pageObjects.MainPage;
import web.pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class RegisterTest {

    MainPage mainPage;
    CommonFields commonFields = new CommonFields();

    @Before
    public void start() {
        //Раскомментить браузер, в котором необходим прогон

        //Google Chrome
        //System.setProperty("webdriver.chrome.driver","/Users/kseniya/IdeaProjects/Diplom_3/chromedriver");
        //WebDriver driver = new ChromeDriver();
        // setWebDriver(driver);

        //Yandex Browser
        System.setProperty("webdriver.chrome.driver", "/Users/kseniya/IdeaProjects/Diplom_3/yandexdriver");
        WebDriver driver = new ChromeDriver();
        setWebDriver(driver);

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @Test
    @DisplayName("проверка успешной регистрации")
    public void verifyThatUserWasAutorisedByClickingOnLoginRegisterButton() throws InterruptedException {
        //регистрация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        registerPage.setRegisterFieldsAndClickRegisterButton(commonFields.name, commonFields.email, commonFields.password);
        //проверка авторизации зарегистрированного юзера
        Assert.assertTrue(loginPage.getTextloginLoginText().contains("Вход"));
    }

    @Test
    @DisplayName("проверка ошибки для некорректного пароля")
    public void verifyThatUserNotAutorisedWithInvalidPassword() throws InterruptedException {
        //регистрация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        registerPage.setRegisterFieldsAndClickRegisterButton(commonFields.name, commonFields.email, commonFields.invalidPassword);
        //проверка авторизации зарегистрированного юзера
        Assert.assertTrue(registerPage.getTextInvalidPasswordText().contains("Некорректный пароль"));
    }

    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }


}
