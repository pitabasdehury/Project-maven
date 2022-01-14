package ExtentReports_Basic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        // Step 1 - Make the object of ExtentReports (internal class responsible for generation of Extent Report). It is Subject
        ExtentReports extentReports = new ExtentReports();

//STEP 2 - Make the object of ExtentSparkReporter (observer) - attached to Subject (ExtentReports)
        ExtentSparkReporter spark = new ExtentSparkReporter("Screenshots\\Spark.html");
        spark.config().setReportName("Extent Report generation Testing");
        spark.config().setDocumentTitle("Extent Reports");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("utf-8");

// STEP 3 - we need to attach a Reporter (used to format reports)
        extentReports.attachReporter(spark);

// STEP 4 - we need to create the Test Case and add the test info
        ExtentTest test = extentReports.createTest("Login Test");
        test.log(Status.INFO, "Starting Login Test Case");
        test.log(Status.INFO, "Opening Browser");
        test.log(Status.INFO, "Validating presence of signin link");
        test.log(Status.INFO, "Entering Credentials");
        test.log(Status.PASS, "Login Test Case PASS");

// STEP 5 - flush() --> instructs ExtentReports to write the test info in a certain destination
        extentReports.flush();

    }
}
