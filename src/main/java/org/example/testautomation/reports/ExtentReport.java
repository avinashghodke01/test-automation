package org.example.testautomation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport {
    public static ExtentReports getReportobject(){
        String reportPath = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-report"+File.separator+"index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Automation Results");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
