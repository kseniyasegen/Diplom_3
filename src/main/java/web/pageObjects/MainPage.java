package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    // локатор кнопки Логотипа
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement mainLogoButton;

    // локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement mainPersonalAreaButton;

    // локатор текста Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement mainMakeBurgerText;

    // локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement mainLoginButton;

    // локатор кнопки Конструктор
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo")
    private SelenideElement mainConstructorButton;

    // локатор кнопки Булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement mainBunsButton;

    // локатор названия булки Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement mainBunFluorescentText;

    // локатор кнопки Соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement mainSaucesButton;

    // локатор названия соуса Соус Spicy-X
    @FindBy(how = How.XPATH, using = "//p[text()='Соус Spicy-X']")
    private SelenideElement mainSauceSpicyxText;

    // локатор кнопки Начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement mainFillingsButton;

    // локатор названия начинки Мясо бессмертных моллюсков Protostomia
    @FindBy(how = How.XPATH, using = "//p[text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement mainFillingProtostomiaText;

    //МЕТОДЫ
    // клик на Логотип
    public void clickOnMainLogoButton() {
        mainLogoButton.shouldBe(enabled).click();
    }

    // клик на кнопку Личный кабинет
    public LoginPage clickOnMainPersonalAreaButton() {
        mainPersonalAreaButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

    // клик на кнопку Войти в аккаунт
    public LoginPage clickOnMainLoginButton() {
        mainLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }

    // клик на кнопку Конструктор
    public void clickOnMainConstructorButton() {
        mainConstructorButton.shouldBe(enabled).click();
    }

    // клик на кнопку Булки
    public void clickOnMainBunsButton() {
        mainBunsButton.shouldBe(enabled).click();
    }

    // клик на кнопку Соусы
    public void clickOnMainSaucesButton() {
        mainSaucesButton.shouldBe(enabled).click();
    }

    // клик на кнопку Начинки
    public void clickOnMainFillingsButton() {
        mainFillingsButton.shouldBe(enabled).click();
    }

    //получить текст "Соберите бургер"
    public String getTextMainMakeBurgerText() {
        return mainMakeBurgerText.getText();
    }

    //получить текст "Соус Spicy-X"
    public String getTextMainSauceSpicyxText() {
        return mainSauceSpicyxText.getText();
    }

    //получить текст "Мясо бессмертных моллюсков Protostomia"
    public String getTextMainFillingProtostomiaText() {
        return mainFillingProtostomiaText.getText();
    }

    //получить текст "Флюоресцентная булка R2-D3"
    public String getTextMainBunFluorescentText() {
        return mainBunFluorescentText.getText();
    }


}
