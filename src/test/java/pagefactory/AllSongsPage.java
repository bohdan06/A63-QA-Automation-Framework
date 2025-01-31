package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    @FindBy(xpath = "//td[@class='title' and contains(text(), 'M33 Project - Emotional Soundtrack')][1]")
    WebElement m33Song;
    @FindBy(css = "button.btn-add-to")
    WebElement addToBtn;
    @FindBy(xpath = "// section[@class='existing-playlists']//li[contains(text(), 'Relax mix')][1]")
    WebElement playlist;
    @FindBy(css = "div.success.show")
    WebElement addedMsg;
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage selectM33Song(){
        wait.until(ExpectedConditions.visibilityOf(m33Song)).click();
        return this;
    }
    public AllSongsPage addSongToPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(addToBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(playlist)).click();
        return this;

    }
    public String getAddedMsg(){
        return wait.until(ExpectedConditions.visibilityOf(addedMsg)).getText();
    }

}
