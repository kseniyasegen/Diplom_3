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

public class MainTest {

    RegisterUser registerUser = new RegisterUser();
    MainPage mainPage;
    CommonFields commonFields = new CommonFields();
    DeleteUser deleteUser = new DeleteUser();

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
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    public void verifyClickingOnMainPersonalAreaButton() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        //проверка наличия на экране кнопки Войти
        Assert.assertTrue(loginPage.getTextLoginLoginButton().contains("Войти"));
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» в Конструктор из Личного кабинета")
    public void verifyClickingOnLoginConstructorButtonFromPersonalArea() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        MainPage mainPage1 = loginPage.clickOnLoginConstructorButton();
        //проверка наличия на экране кнопки Войти
        Assert.assertTrue(mainPage1.getTextMainMakeBurgerText().contains("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверка перехода по клику на Логотип в Конструктор из Личного кабинета")
    public void verifyClickingOnLogoButtonFromPersonalArea() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        MainPage mainPage1 = loginPage.clickOnLogoButton();
        //проверка наличия на экране кнопки Войти
        Assert.assertTrue(mainPage1.getTextMainMakeBurgerText().contains("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void verifyThatUserWasAutorisedByClickingOnPersonalAreaButton() throws InterruptedException {
        //регистрация юзера через API
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        //авторизация юзера через web
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        AutorisedMainPage autorisedMainPage1 = loginPage.setLoginFields(commonFields.email, commonFields.password);
        AutorisedPersonalAreaPage autorisedPersonalAreaPage = autorisedMainPage1.clickOnAutorisedMainPersonalAreaButton();
        LoginPage loginPage1 = autorisedPersonalAreaPage.clickOnAutorisedPersonalAreaExitButton();
        //проверка выхода
        Assert.assertTrue(loginPage1.getTextloginLoginText().contains("Вход"));
        //удаление юзера
        CommonFields.accessTokenAfterRegister = CommonFields.response.path("accessToken");
        deleteUser.deleteUser();
    }

    @Test
    @DisplayName("Клик на раздел 'Соусы' открывает список соусов")
    public void verifyThatClickOnMainSaucesButtonOpenListOfCouces() throws InterruptedException {
        mainPage.clickOnMainSaucesButton();
        //проверка наличия на экране соуса Соус Spicy-X
        Assert.assertTrue(mainPage.getTextMainSauceSpicyxText().contains("Соус Spicy-X"));
    }

    @Test
    @DisplayName("Клик на раздел 'Начинки' открывает список начинок")
    public void verifyThatСlickOnMainFillingsButtonOpenListOfFillings() throws InterruptedException {
        mainPage.clickOnMainFillingsButton();
        //проверка наличия на экране соуса Соус Spicy-X
        Assert.assertTrue(mainPage.getTextMainFillingProtostomiaText().contains("Мясо бессмертных моллюсков Protostomia"));
    }

    @Test
    @DisplayName("Клик на раздел 'Булки' открывает список булок")
    public void verifyThatClickOnMainBunsButtonOpenListOfBuns() throws InterruptedException {
        mainPage.clickOnMainFillingsButton();
        mainPage.clickOnMainBunsButton();
        //проверка наличия на экране булки Флюоресцентная булка R2-D3
        Assert.assertTrue(mainPage.getTextMainBunFluorescentText().contains("Флюоресцентная булка R2-D3"));
    }

    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }

}
