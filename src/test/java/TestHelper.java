import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Config;
import utilities.JSONConfigUtil;
import utilities.User;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class TestHelper {
    private AndroidDriver driver;
    protected String username = "kevinzhang_vxoIiW";
    protected String accessKey = "ndt4o19pDheTksDbu2z3";
    //protected String username = "siteadminbokus1";
    //protected String accessKey = "DHNNaP7DXCumsv3iEx7N";

    @BeforeMethod(alwaysRun = true)
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "Android");
        browserstackOptions.put("osVersion", "12.0");
        browserstackOptions.put("deviceName", "Google Pixel 6");
        browserstackOptions.put("realMobile", "true");
        browserstackOptions.put("appiumVersion", "1.22.0");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("app", "bs://ff64e6e45d62f23e4b77281cacf698b36613f721");
        capabilities.setCapability("bstack:options", browserstackOptions);*/

        //{"app_name":"7707c879-16a1-4cf9-a07e-6102c8b6795c.apk","app_version":"2.4.10-2112212240",
        //"app_url":"bs://142488e58a1af0c78be484dde3286a9d4edafb33","app_id":"142488e58a1af0c78be484dde3286a9d4edafb33",
        // "uploaded_at":"2021-12-22 12:18:38 UTC"}
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("appiumVersion", "1.22.0");
        //browserstackOptions.put("networkLogs", "true");
        browserstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Google Pixel 5");
        capabilities.setCapability("app", "bs://cb27c50dc4e653ac502dbae563b57fba5cfcadbf");

        //capabilities.setCapability("deviceName", "10.0.0.7:5555"); //OnePlus 6T
        //capabilities.setCapability("deviceName", "10.0.0.23:5555"); //Galaxy S10
        //capabilities.setCapability("deviceName", "sdk_gphone_x86");
        //capabilities.setCapability("deviceName", "OnePlus 6T");
        //capabilities.setCapability("deviceName", "Jing's S10");
        //capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "11.0");
        //capabilities.setCapability("appPackage", "com.bokus.play");
        //capabilities.setCapability("appActivity", ".app.WelcomeActivity");
        //capabilities.setCapability("app_url", "bs://ff64e6e45d62f23e4b77281cacf698b36613f721");
        //capabilities.setCapability("browserstack.debug", "true");
        driver = new AndroidDriver(new URL(
                "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    protected String getSessionID() {
        return driver.getSessionId().toString();
    }

    protected void flightMode() throws URISyntaxException, IOException {
        String sessionID = getSessionID();
        URI uri = new URI("https://" + username + ":" + accessKey
                + "@api-cloud.browserstack.com/app-automate/sessions/" + sessionID + "/update_network.json");
        HttpPut request = new HttpPut(uri);
        ArrayList<NameValuePair> nameValuePair = new ArrayList<>();
        nameValuePair.add((new BasicNameValuePair("networkProfile", "airplane-mode")));
        request.setEntity(new UrlEncodedFormEntity(nameValuePair));
        HttpClientBuilder.create().build().execute(request);
    }

    protected WelcomePage welcomePage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        return welcomePage;
    }
    protected void assertWelcomePageDisplayed() {
        if (!welcomePage().isDisplayed()) {
            return;
        }
    }

    protected LoginPage loginPage() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
    protected void assertLoginPageDisplayed() {
        if (!loginPage().isDisplayed()) {
            return;
        }
    }

    protected MagicLinkPage magicLinkPage() {
        MagicLinkPage magicLinkPage = new MagicLinkPage(driver);
        return magicLinkPage;
    }
    protected void assertMagicLinkPageDisplayed() {
        if (!magicLinkPage().magicLinkTitleDisplayed()) {
            return;
        }
    }
    protected void assertMagicLinkResultPageDisplayed() {
        if (!magicLinkPage().resultTitleDisplayed()) {
            return;
        }
    }

    protected ResetPasswordPage resetPasswordPage() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        return resetPasswordPage;
    }
    protected void assertResetPasswordPageDisplayed() {
        if (!resetPasswordPage().forgotPasswordTitleDisplayed()) {
            return;
        }
    }
    protected void assertResetPasswordResultPageDisplayed() {
        if (!resetPasswordPage().resultTitleDisplayed()) {
            return;
        }
    }

    protected ExplorePage explorePage() {
        ExplorePage explorePage = new ExplorePage(driver);
        return explorePage;
    }
    protected void assertExplorePageDisplayed() {
        if (!explorePage().exploreTitleDisplayed()) {
            return;
        }
    }

    protected BookshelfAllPage bookshelfAllPage() {
        BookshelfAllPage bookshelfAllPage = new BookshelfAllPage(driver);
        return bookshelfAllPage;
    }
    protected void assertBookshelfAllPageSelected() {
        if (!bookshelfAllPage().bookshelfAllTabSelected()) {
            return;
        }
    }
    protected void assertBookshelfAllPageListLoaded() {
        if (!bookshelfAllPage().waitForAllListLoaded()) {
            return;
        }
    }

    protected BookshelfFavoritesPage bookshelfFavoritesPage() {
        BookshelfFavoritesPage bookshelfFavoritesPage = new BookshelfFavoritesPage(driver);
        return bookshelfFavoritesPage;
    }
    protected void assertBookshelfFavoritesPageSelected() {
        if (!bookshelfFavoritesPage().assertBookshelfFavoritesPageSelected()) {
            return;
        }
    }
    protected void assertBookshelfFavoritesPageListLoaded() {
        if (!bookshelfFavoritesPage().waitForFavoritesListLoaded()) {
            return;
        }
    }

    protected BookshelfOfflinePage bookshelfOfflinePage() {
        BookshelfOfflinePage bookshelfOfflinePage = new BookshelfOfflinePage(driver);
        return bookshelfOfflinePage;
    }
    protected void assertBookshelfOfflinePageSelected() {
        if (!bookshelfOfflinePage().bookshelfOfflinePageSelected()) {
            return;
        }
    }

    protected BookshelfListsPage bookshelfListsPage() {
        BookshelfListsPage bookshelfListsPage = new BookshelfListsPage(driver);
        return bookshelfListsPage;
    }
    protected void assertBookshelfListsPageSelected() {
        if (!bookshelfListsPage().bookshelfListsPageSelected()) {
            return;
        }
    }
    protected void assertBookshelfListsPageLoaded() {
        if (!bookshelfListsPage().waitForListsLoaded()) {
            return;
        }
    }

    protected ProfilePageInPreviewMode profilePageInPreviewMode() {
        ProfilePageInPreviewMode profilePageInPreviewMode = new ProfilePageInPreviewMode(driver);
        return profilePageInPreviewMode;
    }

    protected void assertProfilePageInPreviewModeDisplayed() {
        if (!profilePageInPreviewMode().profileTitleDisplayed()) {
            return;
        }
    }

    protected ProfilePageLoggedIn profilePageLoggedIn() {
        ProfilePageLoggedIn profilePageLoggedIn = new ProfilePageLoggedIn(driver);
        return profilePageLoggedIn;
    }

    protected void assertProfilePageLoggedInDisplayed() {
        if (!profilePageLoggedIn().subscriptionContainerDisplayed()) {
            return;
        }
    }

    protected SearchPage searchPage() {
        SearchPage searchPage = new SearchPage(driver);
        return searchPage;
    }

    protected void assertSearchPageDisplayed() {
        if (!searchPage().searchBoxDisplayed()) {
            return;
        }
    }

    protected BookDetailViewPage bookDetailViewPage() {
        BookDetailViewPage bookDetailViewPage = new BookDetailViewPage(driver);
        return bookDetailViewPage;
    }

    protected void assertBookDetailViewDisplayed() {
        if (!bookDetailViewPage().bookDetailViewCoverImageDisplayed()) {
            return;
        }
    }
    protected void assertBookDetailViewPlayAudiobookButtonDisplayed() {
        /*if (!bookDetailViewPage().bookDetailViewStartBookDisplayed()) {
            return;
        }*/
        Assert.assertTrue(bookDetailViewPage().bookDetailViewStartBookDisplayed());
    }

    protected SubjectsPage subjectsPage() {
        SubjectsPage subjectsPage = new SubjectsPage(driver);
        return subjectsPage;
    }

    protected AudiobookPlayerPage audiobookPlayerPage() {
        AudiobookPlayerPage audiobookPlayerPage = new AudiobookPlayerPage(driver);
        return audiobookPlayerPage;
    }

    protected void assertAudiobookPlayerBookCoverDisplayed() {
        if (!audiobookPlayerPage().bookCoverDisplayed()) {
            return;
        }
    }

    protected BookmarkPage bookmarkPage() {
        BookmarkPage bookmarkPage = new BookmarkPage(driver);
        return bookmarkPage;
    }

    protected void assertCreateBookmarkPageDisplayed() {
        if (!bookmarkPage().createBookmarkTitleDisplayed()) {
            return;
        }
    }

    protected void assertSavedBookmarkPageDisplayed() {
        if (!bookmarkPage().savedBookmarkTitleDisplayed()) {
            return;
        }
    }

    protected PlaybackSpeedPage playbackSpeedPage() {
        PlaybackSpeedPage playbackSpeedPage = new PlaybackSpeedPage(driver);
        return playbackSpeedPage;
    }

    protected void assertPlaybackSpeedDisplayed() {
        if (!playbackSpeedPage().playbackSpeedSheetDisplayed()) {
            return;
        }
    }

    protected SleepTimerPage sleepTimerPage() {
        SleepTimerPage sleepTimerPage = new SleepTimerPage(driver);
        return sleepTimerPage;
    }

    protected void assertSleepTimerDisplayed() {
        if (!sleepTimerPage().sleepTimerTextDisplayed()) {
            return;
        }
    }

    protected void baseForLogin(String username) {
        assertWelcomePageDisplayed();
        welcomePage().clickLoginHereLink();
        assertLoginPageDisplayed();
        for (int i = 0; i < baseForUserArraySize_ProdEnvironment().user.length; i++) {
            User user = JSONConfigUtil.getUserFromProdEnvironment(i);
            if (user.getUsername().equals(username)) {
                loginPage().login(user.username, user.password);
                break;
            }
        }
    }

    protected void loginPreviewMode() {
        assertWelcomePageDisplayed();
        welcomePage().clickPreviewModeButton();
    }

    protected void loginBaseAccount() {
        baseForLogin("abjornatest@gmail.com");
    }

    protected void loginPremiumAccount() {
        baseForLogin("kevinzhang_96@yahoo.se");
    }

    protected static Config baseForUserArraySize_ProdEnvironment() {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigProd.json"), Config.class);
            return config;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() { driver.quit(); }
}
