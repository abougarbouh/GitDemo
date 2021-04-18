package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReportObject(){
        String path =System.getProperty("user.dir")+"\\reports\\index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        String css = ".r-img {width: 100%;}";
       // reporter.config().setCss(css);
        reporter.config().setReportName("Web automation result");
        reporter.config().setDocumentTitle("Test Result");


        //ExtentReoprt
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","ahmed abougarbouh");
        return extent;

    }
}
