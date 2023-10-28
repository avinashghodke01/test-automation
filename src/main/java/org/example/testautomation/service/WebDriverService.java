package org.example.testautomation.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverService {
    private WebDriver driver = null;

    public void init(String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver = driver;
        driver.get(url);
        //javascript function 'document.readyState' returns 'complete' when page is fully loaded
        //wait till page load is complete using js function. Should work but require testing and verification
        //duration is maximum amount of time it should wait
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement findById(String id) {
        return this.driver.findElement(By.id(id));
    }

    public WebElement findByName(String name) {
        return this.driver.findElement(By.name(name));
    }

    public WebElement findBycssSelector(String selector) {
        return this.driver.findElement(By.cssSelector(selector));
    }

    public void quite() {
        this.driver.quit();
    }
}
