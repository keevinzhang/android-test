import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Tests extends TestHelper {
    /*@Test
    public void testDownload() {
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
    }*/

    @Test
    public void testPlayDownloadedAudiobookOffline() throws URISyntaxException, IOException {
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
        bookshelfOfflinePage().assertBookDownloadedTitle(bookTitle).equals(bookshelfOfflinePage().getBookDownloadedTitle());
        bookshelfOfflinePage().assertDownloaded();

        flightMode();

        bookshelfOfflinePage().clickBookTitle("Musikmysteriet");
        bookDetailViewPage().clickStartBook();
        //assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
    }

    @Test
    public void testDownloadAndRemoveBook() {
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
        bookshelfOfflinePage().clickRemoveDownloadedBookIcon(bookTitle);
        bookshelfOfflinePage().assertNoBooksDownloaded();
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

    /*@Test
    public void testAudiobookPlayed() {
        loginPreviewMode();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
    }*/

    @Test
    public void testAudiobookPlayedAndListedInBookshelf() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickBook();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickStartBook();
        assertAudiobookPlayerBookCoverDisplayed();
        audiobookPlayerPage().assertAudioBookPlayed();
        String bookTitle = audiobookPlayerPage().getBookTitle();
        audiobookPlayerPage().navigateBackButton();
        assertBookDetailViewDisplayed();
        bookDetailViewPage().clickBookshelfTab();
        assertBookshelfAllPageSelected();
        Assert.assertEquals(bookTitle, bookshelfAllPage().getFirstBookTitle());
    }

    /*@Test
    public void testResetPassword() {
        assertWelcomePageDisplayed();
        welcomePage().clickLoginHereLink();
        assertLoginPageDisplayed();
        loginPage().clickResetPassword();
        assertResetPasswordPageDisplayed();
        for (int i = 0; i < baseForUserArraySize_ProdEnvironment().user.length; i++) {
            User user = JSONConfigUtil.getUserFromProdEnvironment(i);
            if (user.getUsername().equals("kevinzhang_96@yahoo.se")) {
                resetPasswordPage().resetPassword(user.username);
                assertResetPasswordResultPageDisplayed();
                break;
            }
        }
        PageHelper.sleepInMilliseconds(2000);
    }

    @Test
    public void testMagicLink() {
        assertWelcomePageDisplayed();
        welcomePage().clickLoginHereLink();
        assertLoginPageDisplayed();
        loginPage().clickMagicLink();
        assertMagicLinkPageDisplayed();
        for (int i = 0; i < baseForUserArraySize_ProdEnvironment().user.length; i++) {
            User user = JSONConfigUtil.getUserFromProdEnvironment(i);
            if (user.getUsername().equals("kevinzhang_96@yahoo.se")) {
                magicLinkPage().sendMagicLink(user.username);
                assertMagicLinkResultPageDisplayed();
                break;
            }
        }
        PageHelper.sleepInMilliseconds(2000);
    }*/

    @Test
    public void testLogOut() {
        loginPremiumAccount();
        assertExplorePageDisplayed();
        explorePage().clickProfileTab();
        assertProfilePageLoggedInDisplayed();
        profilePageLoggedIn().clickLogOut();
        assertWelcomePageDisplayed();
    }
}
