import RequestsPages.Posts;
import Utils.APIUtils;
import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.DataUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITest {
    static final String pageURL = "mainPage_URL";
    static final int CODE_200 = 200;

    @BeforeMethod
    public void setUp(){
        TestSetUp.setBrowserSettings(ConfigUtils.getURL(pageURL));
    }
    @Test
    public void TestGETPOSTMethods(){
        int responseCode = APIUtils.getResponseCode(ConfigUtils.getURL(pageURL), Posts.getPosts());
        Assert.assertEquals(CODE_200,responseCode,"The code is diffirent than expected");


    }

    @AfterMethod
    public void close(){
        BrowserUtils.getDriver().quit();
    }
}
