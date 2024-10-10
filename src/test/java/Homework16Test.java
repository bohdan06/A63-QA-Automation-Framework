import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation() {
        navigateToPage();
        WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("a[href='registration']"))));
        registrationButton.click();
        WebElement registrationLink = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[type=email]"))));
        Assert.assertTrue(registrationLink.isDisplayed());

    }
}