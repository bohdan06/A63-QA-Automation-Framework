

import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        Assert.assertTrue(homePage.getAvatarIcon().isDisplayed());

    }
    @Test
    public void loginInvalidEmailPassword() {
        String url = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("ivasiv@test.io").providePassword("vReT57X$ym").submitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
}
