package Ex1_fillUpForm;

import ConfigurationBase.ConfigurationBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormPage extends ConfigurationBase {

    @Test
    public void shouldFillUpTheForm() {
        webDriver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");

        WebElement firstName = webDriver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("Janek");

        WebElement lastName = webDriver.findElement(By.cssSelector("[name='lastname']"));
        lastName.sendKeys("Kowalski");

        WebElement email = webDriver.findElement(By.cssSelector(".form-control[name='email']"));
        email.sendKeys("jaaaaneek@gmail.com");

        WebElement password = webDriver.findElement(By.cssSelector("[name='password']"));
        password.sendKeys("qwerty!");

        WebElement customerPrivacyCheckBox = webDriver.findElement(By.cssSelector("[name='customer_privacy']"));
        customerPrivacyCheckBox.click();

//        psgdpr checkBox
        webDriver.findElement(By.cssSelector("[name='psgdpr']")).click();

//        submitButton
        webDriver.findElement(By.cssSelector("[data-link-action='save-customer']")).click();

        String getAccountNameAndLastName = webDriver.findElement(By.cssSelector(".account .hidden-sm-down")).getText();
        Assert.assertEquals(getAccountNameAndLastName,"Janek" + " " + "Kowalski");


    }

}
