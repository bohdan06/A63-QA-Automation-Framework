import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.PlaylistPage;
import pagefactory.SmartPlaylistPage;


public class PlaylistTests extends BaseTest {
    @Test
    public void createPlaylist() {
        String name = "Relax mix";
        String expectedMsg = "Created playlist \"Relax mix.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertEquals(homePage.getCreatedPlaylistMsg(), expectedMsg);

    }

    @Test
    public void createPlaylistWithTheSameName() {
        String name = "Relax mix";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertFalse(isNameFieldStillDisplayed());
    }

    public boolean isNameFieldStillDisplayed() {
        try {
            HomePage homePage = new HomePage(getDriver());
            homePage.nameField.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void createPlaylistWithOneCharacter() { // 1 character MIN
        String name = "A";
        String expectedMsg = "Created playlist \"A.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertEquals(homePage.getCreatedPlaylistMsg(), expectedMsg);

    }

    @Test
    public void createPlaylistWith277Characters() { // 256 characters MAX
        String name = "vbawkudhvbdshbcodswuyvcsdouhcbodsuygvosbcaOUVBObucoBOVBADOSVBASDOBASUWYGOEBVSADUBVHIUVYGSDOUBCHWUVBWIUYVDSOUVBWDUIVYBWDIUVYBDSWUVYBWDIVYWBDOVUSDYBVYOUGUWODVUHwdbivbwdshvcbdytcwuobciuysgvuhabdsuvbasuihbHUVBSUVBASBVDUBVbvudhbasvuhdbsvuadhbsv21eSBCWCYEIVUBWKUDHVCBUOVYBWRIUVYBWDHU";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertFalse(isNameFieldDisplayed());
    }

    public boolean isNameFieldDisplayed() {
        try {
            HomePage homePage = new HomePage(getDriver());
            homePage.nameField.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void createPlaylistWithEmptyName() {
        String name = "";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.plusButton().newPlaylistNameBtn().newPlaylistName(name);
        Assert.assertTrue(homePage.nameField.isDisplayed());

    }

    @Test
    public void deletePlaylist() {
        String expectedDeleteMsg = "Deleted playlist \"Relax mix.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.findPlaylist();
        playlistPage.deletePlaylist();
        if (!homePage.isDeleteMsg()) {
            playlistPage.clickOkMsg();
        }
        Assert.assertEquals(homePage.getDeletePlaylistMsg(), expectedDeleteMsg);

    }

    @Test
    public void createSmartPlaylistWithOneRule() {
        String playlistName = "Smart mix";
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName).firstRuleForSmartPlaylist(criteriaValue).saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.areSongsPresent());
    }

    @Test
    public void createSmartPlaylistWithMultipleRules() {
        String playlistName = "Multiple mix";
        String criteriaValue = "Lament";
        String criteriaValueForSecondRule = "a";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(criteriaValue)
                .addRuleButton()
                .secondRuleForSmartPlaylist(criteriaValueForSecondRule)
                .saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.areSongsPresent());

    }

    @Test
    public void createSmartPlaylistWithGroup() {
        String playlistName = "Group mix";
        String valueForRule = "Lament";
        String valueForGroup = "BossStatus";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(valueForRule)
                .groupForSmartPlaylist()
                .groupWithRuleForSmartPlaylist(valueForGroup)
                .saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.areSongsPresent());
    }

    @Test
    public void createSmartPlaylistWithNotMatchingRule() {
        String playlistName = "Random";
        String criteriaValue = "Random Rule FOR Playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(criteriaValue)
                .saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.isNoSongsMessageDisplayed());
    }

    @Test
    public void createSmartPlaylistWithSpecialCharsInName() {
        String playlistName = "Sm@rt Play!i$t"; //Playlist's name must have NO special characters
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(criteriaValue)
                .saveForNewSmartPlaylistBtn();
        Assert.assertFalse(isNameFieldForSmartPlaylistDisplayed());
    }

    public boolean isNameFieldForSmartPlaylistDisplayed() {
        try {
            HomePage homePage = new HomePage(getDriver());
            homePage.isNameFieldForSmartPlaylistDisplayed();
        } catch (Exception ignored) {

        }
        return false;
    }
    @Test
    public void createSmartPlaylistWith292CharsInName(){ //User shouldn't be able to create New Smart Playlist more than 256 chars
        String playlistName = "ciuhwdqihcbwoOAVASOBovbdoasvdsovbdsoahvsdoauvbdosvhsdovoudhvboudhvbeuodhvbeouvhbeouhvbddddddddheuvhoveeeeeeeeeeeeeeeeeeeeeeeeeeeevboeuvnjeoryuvodenjveuvbvjdnvenuvbeuvdhncjvnoeuvbeuodvnjcdnvuoebveuhvndkcljnvejvbejhdcknveuvebovuidncjvneouvecIUWBWIUBFWUHovbawvjnqwdeouvbcwdoicjnqwoducybqweoiwdnc";
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(criteriaValue)
                .saveForNewSmartPlaylistBtn();
        Assert.assertFalse(isNameFieldForSmartPlaylistStillDisplayed());
    }

    public boolean isNameFieldForSmartPlaylistStillDisplayed() {
        try {
            HomePage homePage = new HomePage(getDriver());
            homePage.isNameFieldForSmartPlaylistDisplayed();
        } catch (Exception ignored) {

        }
        return false;
    }
    @Test
    public void createSmartPlaylistWithEmptyName(){
        String playlistName = ""; //User shouldn't be able to create New Smart Playlist with empty name
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName)
                .firstRuleForSmartPlaylist(criteriaValue)
                .saveForNewSmartPlaylistBtn();
        Assert.assertTrue(homePage.isNameFieldForSmartPlaylistDisplayed());

    }
    @Test
    public void createSmartPlaylistWithOneCharInName(){
        String playlistName = "W"; //User should be able to create New Smart Playlist name with 1 character
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName).firstRuleForSmartPlaylist(criteriaValue).saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.areSongsPresent());
    }
    @Test
    public void createSmartPlaylistWith256CharsInName(){
        String playlistName = "ciuhwdqihcbwoOAVASOBovbdoasvdsovbdsoahvsdoauvbdosvhsdovoudhvboudhvbeuodhvbeouvhbeouhvbddddddddheuvhoveeeeeeeeeeeeeeeeeeeeeeeeeeeevboeuvnjeoryuvodenjveuvbvjdnvenuvbeuvdhncjvnoeuvbeuodvnjcdnvuoebveuhvndkcljnvejvbejhdcknveuvebovuidncjvneouvecIUWBWIUBFWUHovbaw"; //User should be able to create New Smart Playlist name with 256 characters
        String criteriaValue = "Lament";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.smartPlaylist(playlistName).firstRuleForSmartPlaylist(criteriaValue).saveForNewSmartPlaylistBtn();
        Assert.assertTrue(smartPlaylistPage.isSmartPlaylistCreated());
        Assert.assertTrue(smartPlaylistPage.areSongsPresent());
    }
    @Test
    public void deleteSmartPlaylist(){
        String expectedDeleteMsg = "Deleted playlist \"Group mix.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.findSmartPlaylist();
        smartPlaylistPage.deletePlaylistButton();
        if(!homePage.isDeleteMsg()){
            smartPlaylistPage.clickOkMsg();
        }
        Assert.assertEquals(homePage.getDeletePlaylistMsg(), expectedDeleteMsg);

    }





}
