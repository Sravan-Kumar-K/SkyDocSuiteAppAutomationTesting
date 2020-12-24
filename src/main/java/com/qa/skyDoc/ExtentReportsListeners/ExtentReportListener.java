package com.qa.skyDoc.ExtentReportsListeners;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	public static ExtentSparkReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	public static ExtentReports setUp() {
		// specify location of the report
		report = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extent_report/SkyDoc Automation Test Report2.html");
		report.config().setDocumentTitle("SkyDoc SuiteApp Automation Test Report"); // Tile of report
		report.config().setReportName("SkyDoc SuiteApp Automation Test Report"); // Name of the report
		report.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(report);
		return extent;
	}
	
	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable, String scenario) {
		switch (teststatus) {
		case "FAIL":
			extenttest.log(Status.FAIL, "TEST CASE FAILED IS " + scenario); // to add name in extent report
			extenttest.log(Status.FAIL, "TEST CASE FAILED IS " + throwable.fillInStackTrace());
//			if (driver != null) {
//				driver.quit();
//			}
			break;
		case "PASS":
			extenttest.log(Status.PASS, "Test Case PASSED IS " + scenario);
			break;
		default:
			break;
		}
	}

}