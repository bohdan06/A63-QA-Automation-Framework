package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmartPlaylistPage extends BasePage {
    @FindBy(xpath = "//li[@class='playlist playlist smart'][1]")
    WebElement smartPlaylist;
    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap playlist'] //table[@class='items']")
    WebElement songList;
    @FindBy(xpath = "//div[@class='text' and contains(text(), \"No songs match the playlist's\")]")
    WebElement noSongsMsg;
    @FindBy(css = "button.del")
    WebElement deleteBtn;
    @FindBy(css = "button.ok")
    WebElement okBtn;
    public SmartPlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean isSmartPlaylistCreated(){
        return smartPlaylist.isDisplayed();
    }
    public boolean areSongsPresent(){
        return songList != null && !songList.getText().isEmpty();
    }
    public boolean isNoSongsMessageDisplayed(){
        return noSongsMsg.isDisplayed();
    }
    public SmartPlaylistPage deletePlaylistButton(){
    // Wait for and click the delete button
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        return this;
    }
    public SmartPlaylistPage clickOkMsg(){
    wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
    return this;
}
}
