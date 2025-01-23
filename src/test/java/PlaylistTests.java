import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.PlaylistPage;


public class PlaylistTests extends BaseTest {
    @Test
    public void createPlaylist()  {
        String name = "Relax mix";
        String expectedMsg = "Created playlist \"Relax mix.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertEquals(homePage.getCreatedPlaylistMsg(),expectedMsg);

    }
    @Test
    public void createPlaylistWithTheSameName()  {
        String name = "Relax mix";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertTrue(homePage.nameField.isDisplayed());

    }
    @Test
    public void createPlaylistWithOneCharacter()  { // 1 character MIN
        String name = "A";
        String expectedMsg = "Created playlist \"A.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertEquals(homePage.getCreatedPlaylistMsg(),expectedMsg);

    }
    @Test
    public void createPlaylistWith277Characters()  { // 256 characters MAX
        String name = "vbawkudhvbdshbcodswuyvcsdouhcbodsuygvosbcaOUVBObucoBOVBADOSVBASDOBASUWYGOEBVSADUBVHIUVYGSDOUBCHWUVBWIUYVDSOUVBWDUIVYBWDIUVYBDSWUVYBWDIVYWBDOVUSDYBVYOUGUWODVUHwdbivbwdshvcbdytcwuobciuysgvuhabdsuvbasuihbHUVBSUVBASBVDUBVbvudhbasvuhdbsvuadhbsv21eSBCWCYEIVUBWKUDHVCBUOVYBWRIUVYBWDHU";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertTrue(homePage.nameField.isDisplayed());

    }
    @Test
    public void createPlaylistWithEmptyName()  {
        String name = "";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertTrue(homePage.nameField.isDisplayed());

    }



    @Test
    public void deletePlaylist()  {
        String expectedDeleteMsg = "Deleted playlist \"Relax mix.\"";
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