import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework22Test extends BaseTest {
    @Test
    public void renamePlaylistName() {
        String newPlaylistName = "Changed Playlist";
        String updatedRenameMsg = "Updated playlist \"Changed Playlist.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.doubleClickOnPlaylist();
        homePage.enterNewNameForPlaylist(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedRenameMsg);
    }
}