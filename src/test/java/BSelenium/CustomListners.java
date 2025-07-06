package BSelenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomListners implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;   // UI
    public ExtentTest test;        //
    String reportName;             //

    @Override
    public void onStart(ITestContext context) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date dt = new Date();
        String timestamp = df.format(dt);    // Generate time
        reportName = "Test-Report-" + timestamp + ".html";
       // String reportPath = System.getProperty("user.dir") + "/src/test/java/BSelenium/Logs_TS_Reports/" + reportName;
        String reportPath = System.getProperty("user.dir") + "/reports/" + reportName;
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Login");
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        String os = context.getCurrentXmlTest().getParameter("os");
        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Operating System", os);
        extent.setSystemInfo("Browser", browser);
        List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
        if (!groups.isEmpty()) {
            extent.setSystemInfo("Groups", groups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS,result.getName()+ "Successfully Executed");
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        test = extent.createTest(result.getTestClass().getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.FAIL,result.getName()+ "Failed");
//        test.log(Status.INFO,result.getThrowable().getMessage());
//
//        try {
//            String imgPath = new BaseClass().captureScreen(result.getName());
//            test.addScreenCaptureFromPath(imgPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test= extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+ "Skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

//        // Open the report automatically
//        File reportFile = new File(System.getProperty("user.dir") + "/reports/" + reportName);
//        try {
//            Desktop.getDesktop().browse(reportFile.toURI());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}

