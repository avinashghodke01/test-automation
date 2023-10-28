package org.example.testautomation.service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor {
    JavascriptExecutor jsExecutor = null;

    public JSExecutor(WebDriver driver){
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void executeScript(String script){
        this.jsExecutor.executeScript(script);
    }
}
