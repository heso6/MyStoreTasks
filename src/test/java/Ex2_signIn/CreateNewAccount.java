package Ex2_signIn;

import ConfigurationBase.ConfigurationBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

        WebElement email = webDriver.findElement(By.cssSelector(".form-control[name='email']"));
        email.sendKeys(generateRandomText()+"@gmail.com");

        WebElement password = webDriver.findElement(By.cssSelector("[name='password']"));
        password.sendKeys("qwerty!");

        WebElement customerPrivacyCheckBox = webDriver.findElement(By.cssSelector("[name='customer_privacy']"));
        customerPrivacyCheckBox.click();

//        psgdpr checkBox
        webDriver.findElement(By.cssSelector("[name='psgdpr']")).click();

//        submitButton
        webDriver.findElement(By.cssSelector("[data-link-action='save-customer']")).click();

        String getAccountNameAndLastName = webDriver.findElement(By.cssSelector(".account .hidden-sm-down")).getText();
        Assert.assertEquals(getAccountNameAndLastName,"Bożydar" + " " + "Kowalski");

    }

    public String generateRandomText(){
        return RandomStringUtils.randomAlphabetic(6);
    }
}
