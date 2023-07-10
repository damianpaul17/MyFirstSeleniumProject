package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class GoogleTest {

    @Test
    public void googleTest(){

        // instantiem driverul
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");      //trebuie pus calea din resources cu COPYPATH

        WebDriver driver =new ChromeDriver();

        //deschidem google.com
        String url ="https://www.google.com/";
        driver.get(url);

        //maximizare pagina (full screen)
        driver.manage().window().maximize();

        //verificam pagina

        Assert.assertEquals(url,driver.getCurrentUrl());

//inchidem pagina
        driver.close();
                    }
    }


