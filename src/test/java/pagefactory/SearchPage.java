package pagefactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy (xpath = "//section[@id='songResultsWrapper'] //tr[@class='song-item'][1]")
    WebElement firstSong;
    @FindBy (css = "button.btn-add-to")
    WebElement addToButton;
    @FindBy (xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Relax mix')]")
    WebElement playlist;
    @FindBy (css = "div.success.show")
    WebElement notification;

    public SearchPage (WebDriver givenDriver){super(givenDriver);}

    public SearchPage clickViewAllBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn)).click();
        return this;
    }
    public SearchPage selectSong(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSong)).click();
        return this;
    }
    public SearchPage clickAddToButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToButton)).click();
        return this;
    }
    public SearchPage choosePlaylist(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", playlist);
        wait.until(ExpectedConditions.elementToBeClickable(playlist)).click();
        return this;
    }
    public String getAddToPlaylistSuccessMsg()  {
        return wait.until(ExpectedConditions.visibilityOf(notification)).getText();
    }

}
