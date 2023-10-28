package org.example.testautomation;

import org.apache.commons.io.FileUtils;
import org.example.testautomation.service.JSExecutor;
import org.example.testautomation.service.WebDriverService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Tests {
    private static final Logger LOG = LoggerFactory.getLogger(Tests.class);

    /**
     * Uncomment below method if not running via testng and still want to generate report
     */
    /*@AfterTest
    public void afterTests() {
        extentReports.flush();
    }

    ExtentReports extentReports;

    @BeforeTest
    public void extentReportConfig() {
        String reportPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "test-report" + File.separator + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Automation Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        //also need to add below line at start of test case
        //extentReports.createTest(result.getMethod().getMethodName());
    }*/
    @Test
    public void testWindowScroller() throws InterruptedException {
        LOG.info("****** starting window scroller test ******");
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
        LOG.info("testWindowScroller execution completed");
    }

    @Test
    public void testScreenCapture() throws IOException {
        WebDriverService webDriverService = new WebDriverService();
        webDriverService.init("http://github.com");
        WebDriver driver = webDriverService.getDriver();

        //change file name and path accordingly
        String outputFileName = "/home/avinash/temp/screenshot.png";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File DestFile = new File(outputFileName);
        FileUtils.copyFile(file, DestFile);

        webDriverService.quite();
    }

    @Test
    public void testFakeFailTest() {
        Assert.assertEquals("Test string to compare", "Invalid string value");
    }
}
