import io.appium.java_client.AppiumBy;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PageHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PrivateTests extends TestHelper {
    @Test
    public void assertTests() {
        loginPreviewMode();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
    }

    @Test
    public void testLoginBase() throws InterruptedException {
        loginBaseAccount();
        Thread.sleep(5000);
    }

    @Test
    public void testLoginPremium() {
        loginPremiumAccount();
    }

    @Test
    public void testClickBook() throws InterruptedException {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        Thread.sleep(2000);
    }

    /*@Test
    public void bookmark() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().clickBookmarkIcon();
        assertCreateBookmarkPageDisplayed();
        bookmarkPage().createBookmark("Appium");
        audiobookPlayerPage().clickMoreActions();
        audiobookPlayerPage().clickBookmark();
        assertSavedBookmarkPageDisplayed();
        bookmarkPage().clickChange();
        bookmarkPage().clickRemoveBookmark();
        bookmarkPage().assertEmptyBookmark();
    }*/

    @Test
    public void testScrolling() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBookshelfTab();
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollForward()"));
        PageHelper.sleepInMilliseconds(2000);
    }

    @Test
    public void downloadViews() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        /*String maneter = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Maneter åldras baklänges\")))")).getText();
        explorePage().longPressElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Maneter åldras baklänges\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/cover_frame\"))))"));
        explorePage().clickSaveOffline();
        explorePage().navigateBackButton();
        explorePage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        Assert.assertTrue(bookshelfOfflinePage().assertBookDownloadedTitle(maneter).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText()));
        bookshelfOfflinePage().assertDownloaded();*/

        /*getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Upptäck aktuella ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/cover_frame\"))))))")).click();
        assertBookDetailViewDisplayed();
        String g = bookDetailViewPage().getBookTitle();
        bookDetailViewPage().clickDownloadIndicator();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        Assert.assertTrue(bookshelfOfflinePage().assertBookDownloadedTitle(g).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText()));
        PageHelper.sleepInMilliseconds(2000);*/

        /*explorePage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        assertBookshelfAllPageListLoaded();
        String anomali = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\")))")).getText();
        bookshelfAllPage().longPressElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/coverFrame\")))"));
        bookshelfAllPage().clickSaveOffline();
        bookshelfAllPage().navigateBackButton();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(anomali).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        PageHelper.sleepInMilliseconds(2000);*/

        /*explorePage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickFavoritesTab();
        assertBookshelfFavoritesPageSelected();
        assertBookshelfFavoritesPageListLoaded();
        String ludde = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(2).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\")))")).getText();
        bookshelfFavoritesPage().clickBookTitleDownloadIcon(ludde);
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(ludde).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        bookshelfOfflinePage().assertDownloaded();*/

        /*explorePage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickFavoritesTab();
        assertBookshelfFavoritesPageSelected();
        assertBookshelfFavoritesPageListLoaded();
        String superhero = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(3).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\")))")).getText();
        bookshelfFavoritesPage().clickBookTitleMoreActions(superhero);
        bookshelfFavoritesPage().clickSaveOffline();
        bookshelfFavoritesPage().navigateBackButton();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(superhero).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        bookshelfOfflinePage().assertDownloaded();*/

        explorePage().clickSubjectsTab();
        subjectsPage().clickChildrenAndYoungAdult();
        subjectsPage().scrollVerticallyOneViewDownwards();
        String musicMystery = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Musikmysteriet\")))))")).getText();
        subjectsPage().longPressElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Musikmysteriet\")))))"));
        subjectsPage().clickSaveOffline();
        subjectsPage().navigateBackButton();
        subjectsPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(musicMystery).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        bookshelfOfflinePage().assertDownloaded();
    }

    @Test
    public void testFlightMode() throws URISyntaxException, IOException {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickSearchTab();

        assertSearchPageDisplayed();
        searchPage().typeInSearchBox("Musikmysteriet");
        searchPage().clickTopHit();
        assertBookDetailViewDisplayed();
        String bookTitle = bookDetailViewPage().getBookTitle();
        bookDetailViewPage().clickDownloadIndicator();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(bookTitle).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        bookshelfOfflinePage().assertDownloaded();

        flightMode();

        bookshelfOfflinePage().clickBookTitle("Musikmysteriet");
        bookDetailViewPage().clickStartBook();
        //assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
    }

    /*@Test
    public void testFlightMode() throws IOException {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickSearchTab();

        assertSearchPageDisplayed();
        searchPage().typeInSearchBox("Musikmysteriet");
        searchPage().clickTopHit();
        assertBookDetailViewDisplayed();
        String bookTitle = bookDetailViewPage().getBookTitle();
        bookDetailViewPage().clickDownloadIndicator();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertBookDownloadedTitle(bookTitle).equals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/itemView\").index(1).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/textBookTitle\"))")).getText());
        bookshelfOfflinePage().assertDownloaded();
        String sessionID = getDriver().getSessionId().toString();
        //USE JAVA HTTP CLIENT INSTEAD!!! - curl cheat sheet: https://curl.github.io/curl-cheat-sheet/http-sheet.html - https://everything.curl.dev/http/cheatsheet
        //String command = "curl -u \"kevinzhang_vxoIiW:ndt4o19pDheTksDbu2z3\" -H \"Content-Type: application/json\" -d '{\"networkProfile\":\"airplane-mode\"}' -X PUT \"https://api-cloud.browserstack.com/app-automate/sessions/" + sessionID + "/update_network.json\"";
        String[] command = { "curl\s", "-u\s", username + ":" + accessKey, "\s-H\s", "Content-Type: application/json\s", "-d\s", "'{\"networkProfile\":\"airplane-mode\"}'\s", "-X\s", "PUT\s", "https://api-cloud.browserstack.com/app-automate/sessions/", sessionID + "/update_network.json" };
        //String[] command = { "curl ", "-u ", username + ":" + accessKey, " -H " , "Content-Type: application/json ", "-d ", "'{\"networkProfile\":\"airplane-mode\"}' ", "-X ", "PUT ", "https://api-cloud.browserstack.com/app-automate/sessions/", sessionID + "/update_network.json" };
        ProcessBuilder process = new ProcessBuilder(command);
        Process p;
        p = process.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        System.out.print(result);
    bookshelfOfflinePage().clickBookTitle("Musikmysteriet");
    assertAudiobookPlayerBookCoverDisplayed();
    audiobookPlayerPage().assertAudioBookPlayed();
    }*/

    @Test
    public void testDownloadWait() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        String bookTitle = bookDetailViewPage().getBookTitle();
        bookDetailViewPage().clickDownloadIndicator();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        bookshelfOfflinePage().assertDownloaded();
        Assert.assertEquals(bookTitle, bookshelfOfflinePage().assertBookDownloadedTitle(bookTitle));
    }

    @Test
    public void testDownloadIcon() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        assertBookshelfAllPageListLoaded();
        bookshelfAllPage().clickBookTitleDownloadIcon("419 timmar");
        bookshelfAllPage().clickOfflineTab();
        assertBookshelfOfflinePageSelected();
        bookshelfOfflinePage().assertDownloaded();
        PageHelper.sleepInMilliseconds(2000);
    }

    @Test
    public void testClickDownloadMoreActions() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        String bookTitle = bookDetailViewPage().getBookTitle();
        bookDetailViewPage().clickDownloadIndicator();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        bookshelfAllPage().clickOfflineTab();
        bookshelfAllPage().clickBookTitleMoreActions(bookTitle);
        bookshelfAllPage().clickShowMoreInfo();
        Assert.assertEquals(bookTitle, bookshelfOfflinePage().assertBookDownloadedTitle(bookTitle));
    }

    @Test
    public void testExploreBookAuthor() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        System.out.println(explorePage().getBookAuthor());
    }

    @Test
    public void testSearchBook() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickSearchTab();
        assertSearchPageDisplayed();
        searchPage().typeInSearchBox("Jag kan ha fel");
        System.out.println(searchPage().getTopHitAuthor());
    }

    @Test
    public void testGetBookTitleAndSearch() {
        loginPreviewMode();
        assertExplorePageDisplayed();
        //explorePage().scrollVerticallyOneViewDownwards();
        //String title = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Nyheter ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/txt_title\"))))))")).getText();
        //String author = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Nyheter ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().resourceId(\"com.bokus.play:id/txt_author\"))))))")).getText();
        String title = explorePage().getBookTitle();
        String author = explorePage().getBookAuthor();
        explorePage().clickSearchTab();
        assertSearchPageDisplayed();
        searchPage().typeInSearchBox(title);
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recyclerView\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(1))")).click();
        assertBookDetailViewDisplayed();
        Assert.assertEquals(bookDetailViewPage().getBookTitle(), title);
        Assert.assertEquals(bookDetailViewPage().getBookAuthor(), author);
    }

    @Test
    public void testPlayAudiobook() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
    }

    @Test
    public void testPlaybackSpeed() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().clickPlayOrPause();
        audiobookPlayerPage().clickPlaybackSpeedIcon();
        assertPlaybackSpeedDisplayed();
        playbackSpeedPage().clickOnePointFive();
        /*playbackSpeedPage().clickZeroPointSeven();
        playbackSpeedPage().clickZeroPointEight();
        playbackSpeedPage().clickZeroPointNine();
        playbackSpeedPage().clickOne();
        playbackSpeedPage().clickOnePointOne();
        playbackSpeedPage().clickOnePointTwo();
        playbackSpeedPage().clickOnePointThree();
        playbackSpeedPage().clickOnePointFive();
        playbackSpeedPage().clickOnePointSeven();
        playbackSpeedPage().clickTwo();*/
    }

    @Test
    public void testSleepTimer() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        //audiobookPlayerPage().clickPlayOrPause();
        audiobookPlayerPage().clickSleepTimerIcon();
        assertSleepTimerDisplayed();
        //sleepTimerPage().clickFortyFive();
        sleepTimerPage().assertOneMinuteSleepTimer();
        audiobookPlayerPage().assertEmptySleepTimer();
    }

    @Test
    public void testAudioBookAndEbookDisplayed() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        audiobookAndEbookIcon();
    }

    @Test
    public void audiobookOnly() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().assertAudiobookOnly();
    }

    @Test
    public void ebookOnly() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().assertEbookOnly("Smygstarta julstämningen", "Den överlevande");
        explorePage().clickElementByText("Den överlevande");
    }

    @Test
    public void testBookmark() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().clickBookmarkIcon();
        assertCreateBookmarkPageDisplayed();
        bookmarkPage().createBookmark("Appium");
        audiobookPlayerPage().clickMoreActions();
        audiobookPlayerPage().clickBookmark();
        assertSavedBookmarkPageDisplayed();
        bookmarkPage().clickChange();
        bookmarkPage().clickRemoveBookmark();
        bookmarkPage().assertEmptyBookmark();
    }

    private void audiobookAndEbookIcon() {
        /*if (driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().text(\"Upptäck aktuella ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/img_audio_book\").resourceId(\"com.bokus.play:id/txt_title\").text(\"Maneter åldras baklänges\"))))))")).isDisplayed()
        && driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(0).childSelector(new UiSelector().text(\"Upptäck aktuella ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/img_ebook\").resourceId(\"com.bokus.play:id/txt_title\").text(\"Maneter åldras baklänges\"))))))")).isDisplayed()) {
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Maneter åldras baklänges\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/cover_frame\"))")).click();
            System.out.println("Boken hittades");
        }*/if (getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(1).childSelector(new UiSelector().text(\"Topplistan ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/txt_title\").textContains(\"Löpa varg\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/img_audio_book\")))))))")).isDisplayed()
                && getDriver().findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(1).childSelector(new UiSelector().text(\"Topplistan ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.bokus.play:id/txt_title\").textContains(\"Löpa varg\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/img_ebook\")))))))")).size() == 0) {
            getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Löpa varg\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/cover_frame\"))")).click();
            System.out.println("Testing");
        }
        /*for (int i = 0; i < getDriver().findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Upptäck aktuella ljudböcker\").fromParent(new UiSelector().resourceId(\"com.bokus.play:id/recycler_view\").childSelector(new UiSelector().className(\"android.view.ViewGroup\")))))")).size(); i++) {
            System.out.println("Index: " + i);
        }*/
    }
}
