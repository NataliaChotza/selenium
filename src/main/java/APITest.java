import RequestsPages.Posts;
import Utils.APIUtils;
import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.DataUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITest {
    static final String pageURL = "mainPage_URL";

    @BeforeMethod
    public void setUp(){
        TestSetUp.setBrowserSettings(ConfigUtils.getURL(pageURL));
    }
    @Test
    public void TestGETPOSTMethods(){
        APIUtils.GET(ConfigUtils.getURL(pageURL), Posts.getPosts());

    }

    @AfterMethod
    public void close(){
        BrowserUtils.getDriver().quit();
    }
}
