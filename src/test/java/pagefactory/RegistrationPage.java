package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    @FindBy(css = "p.labels input[type='email']")
    WebElement emailForRegistration;
    @FindBy(css = "p.labels input[type='submit']")
    WebElement submitButton;
    @FindBy(css = "div.messages")
    WebElement message;


    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public RegistrationPage emailField(String email){
        wait.until(ExpectedConditions.visibilityOf(emailForRegistration)).sendKeys(email);
        return this;
    }
    public RegistrationPage submitBtn(){
        wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
        return this;
    }
    public String GetConfirmationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(message)).getText();
    }

}
