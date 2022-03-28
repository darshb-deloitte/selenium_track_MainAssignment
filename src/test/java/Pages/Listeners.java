package Pages;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.Customer_Login_Test;
import test.Home_Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Listeners extends Customer_Login_Test implements ITestListener {

    @Override
    public void onTestStart(ITestResult Result) {

        ITestListener.super.onTestStart(Result);
    }
    @Override
    public void onTestSuccess(ITestResult Result) {

        driver.close();
    }
    @Override
    public void onTestFailure(ITestResult Result) {
        if (!Result.isSuccess()) {
            File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ITestListener.super.onTestFailure(Result);
    }
    @Override
    public void onTestSkipped(ITestResult Result) {
        ITestListener.super.onTestSkipped(Result);
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult Result)
    {
        ITestListener.super.onTestFailedWithTimeout( Result);
    }
    @Override
    public void onStart(ITestContext context)
    {
        ITestListener.super.onStart(context);
    }
    @Override
    public void onFinish(ITestContext context)
    {
        ITestListener.super.onFinish(context);
    }

}
