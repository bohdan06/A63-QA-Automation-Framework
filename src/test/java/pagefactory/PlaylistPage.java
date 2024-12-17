package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {
    @FindBy(css = "button.del")
    WebElement deleteBtn;
    @FindBy(css = "button.ok")
    WebElement okBtn;

    public PlaylistPage (WebDriver givenDriver){super(givenDriver);}
    public PlaylistPage deletePlaylist() {
        // Wait for and click the delete button
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        return this;
    }
    public PlaylistPage clickOkMsg(){
        wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
        return this;
    }

}
