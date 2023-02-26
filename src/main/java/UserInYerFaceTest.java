
import Forms.CookiesForm;
import Forms.HelpForm;
import Forms.LoginForm;
import Forms.Timer;
import Helper.FormFiller;
import Pages.*;
import Utils.StringUtils;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Enum.Domain;

public class UserInYerFaceTest {
    private static MainPage mainPage;
    private static final String EXPECTED_TIME = "00:00:00";
    @BeforeMethod
    public void setUp() {
        TestSetUp.setBrowserSettings();
        mainPage = new MainPage( "main page");
    }

    @Test
    public void NavigationTest() {
        Assert.assertTrue(mainPage.isPageOpen(), "The main page is not open");
        AqualityServices.getBrowser().waitForPageToLoad();
        mainPage.clickLink();

        AqualityServices.getBrowser().waitForPageToLoad();
        LoginPage loginPage = new LoginPage( "Login Page");
        Assert.assertEquals(loginPage.getPageIndicator(BasePageInterface.pageIndicator, "login"), loginPage.getLoginPageIndicator(), "The page indicator is not 1");

        LoginForm loginForm = new LoginForm("login form");
        StringUtils.generateRandomEmail();
        StringUtils.generateRandomPassword(StringUtils.getEmail());

        FormFiller.setPassword(StringUtils.getPassword(),loginForm.getPasswordField());
        FormFiller.setEmail(StringUtils.getEmail(),loginForm.getEmailField());
        FormFiller.setDomain(Domain.getRandomDomain(),loginForm.getDomainField());
        FormFiller.setDropDownValue(loginForm.getDropDownValues());

        loginForm.uncheckTermsCond();
        loginForm.clickNextButton();
        AqualityServices.getBrowser().waitForPageToLoad();

        PicturePage picturePage = new PicturePage( "picture page");
        Assert.assertEquals(picturePage.getPageIndicator(BasePageInterface.pageIndicator, "picture page"), picturePage.getPicturePageIndicator(), "The page indicator is not 2");

        picturePage.chooseRandomCheckbox();
        picturePage.uploadImage();
        picturePage.clickNextButton();

        AqualityServices.getBrowser().waitForPageToLoad();

        FormPage formPage = new FormPage("form page");
        Assert.assertEquals(formPage.getPageIndicator(BasePageInterface.pageIndicator, "form page"), formPage.getFormPageIndicator(), "The page indicator is not 3");

    }

    @Test
    public void HideFormTest() {
        Assert.assertTrue(mainPage.isPageOpen(), "The main page is not open");
        AqualityServices.getBrowser().waitForPageToLoad();
        mainPage.clickLink();

        HelpForm hideForm = new HelpForm("help form");
        hideForm.closeHelpForm();
        Assert.assertTrue(hideForm.isHelpFormClosed(), "The hide form is not closed");
    }

    @Test
    public void AcceptCookiesTest() {
        Assert.assertTrue(mainPage.isPageOpen(), "The main page is not open");
        mainPage.clickLink();
        AqualityServices.getBrowser().waitForPageToLoad();

        CookiesForm cookiesForm = new CookiesForm("cookies form");
        cookiesForm.acceptCookies();
        Assert.assertFalse(cookiesForm.isCookiesClosed(), "Cookies form is open");

    }

    @Test
    public void TimerValidationTest() {
        Assert.assertTrue(mainPage.isPageOpen(), "The main page is not open");
        mainPage.clickLink();
        AqualityServices.getBrowser().waitForPageToLoad();

        Timer timer = new Timer("Timer");
        Assert.assertEquals(timer.getTimer(), EXPECTED_TIME, "The timer is diffirent than expected");
    }

    @AfterMethod
    public void clean() {
        AqualityServices.getBrowser().quit();
    }

}
