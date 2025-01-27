import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.RegistrationPage;

import java.time.Duration;

public class AccountCreationTests extends BaseTest {
    @Test
    public void validEmail() {
        String email = "bohdan.ivasiv@testpro.io";
        String expectedMessage = "We've sent a confirmation link to the email. Please continue by clicking on it";
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        loginPage.registrationOrPassword();
        registrationPage.emailField(email).submitBtn();
        Assert.assertEquals(registrationPage.GetConfirmationMessage(), expectedMessage);

    }
    @Test
    public void invalidEmail() {
        String email = "bohdan.ivasivtestpro.io";
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        loginPage.registrationOrPassword();
        registrationPage.emailField(email).submitBtn();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.labels input[type='email']")));
        Assert.assertTrue(emailField.isDisplayed(), "Please include an '@' in the email address.");

    }
    @Test
    public void emailWithoutDotAndDomain() {
        String email = "bohdanivasiv";
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        loginPage.registrationOrPassword();
        registrationPage.emailField(email).submitBtn();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.labels input[type='email']")));
        Assert.assertTrue(emailField.isDisplayed(), "Please include an '@', dot and  @testpro.io domain in the email address.");

    }
    @Test
    public void emailWithPlusSymbol() {
        String email = "bohdan.ivasiv+@testpro.io";
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        loginPage.registrationOrPassword();
        registrationPage.emailField(email).submitBtn();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.messages")));
        Assert.assertFalse(message.isDisplayed());

    }
    @Test
    public void emailWithPlusOneSymbols() {
        String email = "bohdan.ivasiv+1@testpro.io";
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        loginPage.registrationOrPassword();
        registrationPage.emailField(email).submitBtn();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.messages")));
        Assert.assertFalse(message.isDisplayed());

    }





}
