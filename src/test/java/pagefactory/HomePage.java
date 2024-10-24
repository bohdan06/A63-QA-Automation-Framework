package pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {
    @FindBy (xpath = "//section[@id = 'playlists'] //a[contains(text(), 'Playlist23')][1]")
    WebElement playlistName;
    @FindBy(css = "div.success.show")
    WebElement deleteMsg;
    public HomePage(WebDriver giverDriver){
        super(giverDriver);
    }
    public HomePage findPlaylist(){
        playlistName.click();
        return this;
    }
    public String getDeletePlaylistMsg(){
        return deleteMsg.getText();
    }


}
