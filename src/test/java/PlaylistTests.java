import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.PlaylistPage;


public class PlaylistTests extends BaseTest {
    @Test
    public void createPlaylist()  {
        String name = "Playlist1";
        String expectedMsg = "Created playlist \"Playlist1.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertEquals(homePage.getCreatedPlaylistMsg(),expectedMsg);

    }
    @Test
    public void deletePlaylist()  {
        String expectedDeleteMsg = "Deleted playlist \"Playlist1.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.findPlaylist();
        playlistPage.deletePlaylist();
        if(!homePage.isDeleteMsg()){
            playlistPage.clickOkMsg();
        }
        Assert.assertEquals(homePage.getDeletePlaylistMsg(), expectedDeleteMsg);

    }


}
