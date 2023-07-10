package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Logout {

  public void logoutTest(){
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

      WebElement loginButton = driver.findElement(By.tagName("button"));

      // WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
      loginButton.click();


      //clck Logout

      WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")) ;

      logoutButton.click();

      String successMessage= "You logged out of the secure area!" ;
      WebElement succesAlert = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
      succesAlert.getText();
      Assert.assertTrue(succesAlert.getText().contains(successMessage));

      //close browser
      driver.close();






  }

}
