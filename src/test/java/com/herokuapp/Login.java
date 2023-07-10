package com.herokuapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;

   @Test
public class Login {

    public void loginTest() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();

        //enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        //enterpassword
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        //click Login

        WebElement loginButton = driver.findElement(By.tagName("button"));   //doar daca este un sg buton , daca sunt mai multe aplica pe primul butoon

        // WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
  // verificare
        String secureUrl= "https://the-internet.herokuapp.com/secure" ;
        Assert.assertEquals(secureUrl,driver.getCurrentUrl());

        String successMessage= "You logged into a secure area!" ;
        WebElement succesAlert = driver.findElement(By.id("flash"));
        succesAlert.getText();
        Assert.assertTrue(succesAlert.getText().contains(successMessage));


        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        //close browser
        driver.close();




    }

}
