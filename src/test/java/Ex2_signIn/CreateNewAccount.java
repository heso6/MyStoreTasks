package Ex2_signIn;

import ConfigurationBase.ConfigurationBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewAccount extends ConfigurationBase {
    @Test
    public void shouldCreateNewAccount() {
        webDriver.get("http://146.59.32.4/index.php");

        WebElement signInButton = webDriver.findElement(By.cssSelector(".user-info .hidden-sm-down"));
        signInButton.click();

        WebElement noAccountButton = webDriver.findElement(By.cssSelector("a[data-link-action='display-register-form']"));
        noAccountButton.click();

        WebElement firstName = webDriver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("Bożydar");

        WebElement lastName = webDriver.findElement(By.cssSelector("[name='lastname']"));
        lastName.sendKeys("Kowalski");
    }
}
