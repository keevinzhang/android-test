import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utilities.PageHelper;

public class BookDetailViewPage extends PageHelper {
    By coverImage = By.id("img_cover");
    By moreActions = By.id("toolbar_btn_more");
    By favorite = By.id("lottie_favorite");
    By download = By.id("downloadIndicator");
    By bookTitle = By.id("txt_title");
    By bookAuthor = By.id("txt_title_author");
    By startBook = By.id("btn_play");
    String otherFormat = ".*id/btn_other";
    String description = ".*id/txt_description";
    String author = ".*id/btn_athour";
    String narrator = ".*id/btn_narrator";
    String series = ".*id/btn_series";

    public BookDetailViewPage(AndroidDriver driver) { super(driver); }

    public boolean bookDetailViewCoverImageDisplayed() { return waitForElementToAppear(coverImage).isDisplayed(); }

    public boolean bookDetailViewStartBookDisplayed() { return waitForElementToAppear(startBook).isDisplayed(); }

    public boolean bookDetailViewBookTitleDisplayed(String title) {
        return waitForElementToAppear(bookTitle).getText().contains(title);
    }

    public String getBookTitle() { return driver.findElement(bookTitle).getText(); }

    public String getBookAuthor() { return driver.findElement(bookAuthor).getText(); }

    public void clickMoreActions() { waitForElementToAppear(moreActions).click(); }

    public void clickFavorite() { waitForElementToAppear(favorite).click(); }

    public void clickDownloadIndicator() { waitForElementToAppear(download).click(); }

    public void clickStartBook() { waitForElementToAppear(startBook).click(); }

    public void clickOtherFormat() { scrollToId(otherFormat).click(); }

    public void clickDescription() { scrollToId(description).click(); }

    public void clickAuthor() { scrollToId(author).click(); }

    public void clickNarrator() { scrollToId(narrator).click(); }

    public void clickSeries() { scrollToId(series).click(); }
}
