package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NegativeLogin {

    public void negativeTest(){

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
        passwordInput.sendKeys("incorect");
        //click Login

        WebElement loginButton = driver.findElement(By.tagName("button"));   //doar daca este un sg buton , daca sunt mai multe aplica pe primul butoon

        // WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        // verificare
        WebElement errorAlert= driver.findElement(By.id("flash"));
        Assert.assertTrue(errorAlert.getText().contains("Your password is invalid!"));

    }
}
