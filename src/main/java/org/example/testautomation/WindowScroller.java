package org.example.testautomation;

import org.example.testautomation.service.JSExecutor;
import org.example.testautomation.service.WebDriverService;

public class WindowScroller {
    public static void main(String[] args) throws InterruptedException {
        WebDriverService webDriverService = new WebDriverService();
        webDriverService.init("https://rahulshettyacademy.com/AutomationPractice/");
        JSExecutor jsExecutor = new JSExecutor(webDriverService.getDriver());

        //webDriverService.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        //window.scrollBy(0, 500) this is javascript function to scroll scroll bar by 500px.
        //Set it according to your requirement
        jsExecutor.executeScript("window.scrollBy(0, 500)");
        //scroll scroller in 'Web Table Fixed header' table using javascript code
        jsExecutor.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        //added wait here to observe if scrolling is done or not, can be removed later
        Thread.sleep(2000);
        webDriverService.quite();
    }
}
