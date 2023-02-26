import browser.BrowserFactory;
import lombok.extern.java.Log;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import utilities.*;

import static org.testng.Assert.*;

public class Demoqa {

    WebDriver driver;
    private final String MAINPAGECONTENT="//div[contains(@class,'home-body')]";
    private final String WEBTABLECONTENT ="//div[contains(@class,'web-tables-wrapper')]";
    private final String ALERTPAGECONTENT = "//div[contains(@id,'javascriptAlertsWrapper')]";
    private final String NESTEDFRAMEPAGECONTENT="//iframe[contains(@src,'/sampleiframe')]";
    private final String FRAMESPAGECONTENT = "//iframe[contains(@src,'/sample')]";
    private final String SAMPLEPAGECONTENT = "//h1[contains(@id,'sampleHeading')]";
    private final String BROWSERWINDOWCONTENT = "//div[contains(@id,'browserWindows')]";
    private final String LINKSPAGECONTENT = "//div[contains(@id,'linkWrapper')]";

    private final String FIRSTPAGEURL = "URL_mainPage";
    int ID2 = 2;
    int ID1 = 1;
    int ID0 =0;


    private final String BROWSER ="Chrome";
    @BeforeMethod
    public void setUp(String browser){
        driver = BrowserFactory.setBrowserDriver(BROWSER);
        BrowserFactory.setCurrentURL(ConfigUtils.getURL(FIRSTPAGEURL));

        WaitsUtils.waitForVisibilityOfElement(MAINPAGECONTENT);
    }
    @Test
    public void tablesTest(){
        MainPage.clickElementsButton();
        ElementsPage.clickWebTablesButton();

        WaitsUtils.waitForVisibilityOfElement(WEBTABLECONTENT);

        assertTrue(WebTablesFormPage.isWebTableFormVisible(),"The web table form is not visible");
        WebTablesFormPage.clickAddButton();

        WaitsUtils.waitForVisibilityOfElement(RegistrationFormPage.registrationForm);

        RegistrationFormPage.sendKeyFirstNameInput();
        RegistrationFormPage.sendKeyLastNameInput();
        RegistrationFormPage.sendKeyEmailInput();
        RegistrationFormPage.sendKeyAgeInput();
        RegistrationFormPage.sendKeySalaryInput();
        RegistrationFormPage.sendKeyDepartmentInput();
        RegistrationFormPage.clickSubmitButton();


        assertEquals(WebTablesFormPage.getTable(),TestDataUtils.getUserData(RegistrationFormPage.USER).values().stream().sorted().toList(),"Data are not equal");

        WebTablesFormPage.clickDeleteButton();
        assertNotEquals(WebTablesFormPage.getTable(),TestDataUtils.getUserData(RegistrationFormPage.USER).values().stream().sorted().toList(),"Data are equal");


    }

    @Test
    public void alertsTest(){

        MainPage.clickAlertFrameWindowButton();
        AlertsPage.clickAlertButton();

        WaitsUtils.waitForVisibilityOfElement(ALERTPAGECONTENT);
        AlertsFormPage.clickAlertButton();

        WaitsUtils.waitForAlert();
        assertEquals(AlertsFormPage.getAlert().getAlertText(),"You clicked a button","The message is not correct");

        AlertsFormPage.getAlert().clickOkButton();

        assertTrue(AlertsFormPage.isAlertClose(),"Alert is still open" );


        AlertsFormPage.clickConfirmButton();
        WaitsUtils.waitForAlert();

        AlertsFormPage.moveToAlert();
        assertEquals(AlertsFormPage.getAlert().getAlertText(),"Do you confirm action?","The message is not correct");
        AlertsFormPage.getAlert().clickOkButton();
        assertTrue(AlertsFormPage.isAlertClose(),"Alert is still open" );

        assertEquals(AlertsFormPage.getConfirmSpanText(),"You selected Ok","The message is not as expected");

        AlertsFormPage.clickPromptButton();
        WaitsUtils.waitForAlert();

    assertEquals(AlertsFormPage.getAlert().getAlertText(),"Please enter your name","The message is not correct");
        AlertsFormPage.sendTextToAlert();

        AlertsFormPage.getAlert().clickOkButton();

        assertEquals(AlertsFormPage.getAlert().getAlertText(), StringUtils.getLastRandomString());
        assertTrue(AlertsFormPage.isAlertClose(),"Alert is still open" );
        assertEquals(AlertsFormPage.getPromptSpanText(),StringUtils.getLastRandomString(),"The text is not the same");



    }
    @DataProvider(name="dataTest")
    public Object[][] dataTest(){
        return new Object[][]{
                {"Parent frame","Child Iframe"}
        };
    }
    @Test(dataProvider = "dataTest")
    public void IFrameTest(String parentframeText,String childFrameText){
        MainPage.clickAlertFrameWindowButton();

        AlertsPage.clickNestedFramesButton();
        WaitsUtils.waitForVisibilityOfElement(NESTEDFRAMEPAGECONTENT);

        String[]pc=NestedFramesPage.getParentChildFrametext();
        assertEquals(pc[ID0],parentframeText,"Text doesn't match in parent frame");
        assertEquals(pc[ID1],childFrameText,"Text doesn't match in child frame");

        NestedFramesPage.clickFramesButton();
        WaitsUtils.waitForVisibilityOfElement(FRAMESPAGECONTENT);

        assertEquals(FramePage.getIFrameContent(ID1),FramePage.getIFrameContent(ID1),"Messages are not the same");


    }
    @Test
    public void handlesTest(){

        MainPage.clickAlertFrameWindowButton();
        AlertsPage.clickBrowserWindowLi();

        WaitsUtils.waitForVisibilityOfElement(BROWSERWINDOWCONTENT);

        BrowserWindowPage.clickNewTabButton();
        WaitsUtils.waitForNewPageToOpen();
        assertEquals(BrowserFactory.getDriver().getWindowHandles().size(),ID2,"The page is not open in new tab");

        SamplePage.moveToPage(ID1);
        WaitsUtils.waitForVisibilityOfElement(SAMPLEPAGECONTENT);
        SamplePage.closePage(ID1);

        assertEquals(BrowserFactory.getDriver().getWindowHandles().size(),ID1,"The page is not open in new tab");
        BrowserWindowPage.moveToPage(ID0);

        WaitsUtils.waitForVisibilityOfElement(BROWSERWINDOWCONTENT);

        BrowserWindowPage.clickElementsButton();
        BrowserWindowPage.clickLinksButton();
        WaitsUtils.waitForVisibilityOfElement(LINKSPAGECONTENT);

        LinksPage.clickHomeLink();
        WaitsUtils.waitForNewPageToOpen();
        assertEquals(BrowserFactory.getDriver().getWindowHandles().size(),ID2,"The page is not open in new tab");

        MainPage.moveToPage(ID1);
        WaitsUtils.waitForVisibilityOfElement(MAINPAGECONTENT);

        LinksPage.moveToPage(ID0);
        WaitsUtils.waitForVisibilityOfElement(LINKSPAGECONTENT);

    }


    @AfterMethod
    public void closeConnection(){
        LoggerUtils.info("Closed connection");
        driver.quit();
    }
}
