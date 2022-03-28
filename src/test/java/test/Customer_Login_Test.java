package test;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.fenum.qual.SwingTitleJustification;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.Customer_Login_Page;
import Pages.Home_Page;
import Pages.Manager_Login_Page;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Customer_Login_Test extends Manager_Login_Test{

    Customer_Login_Page customer_page;

   //To login
    @Test(priority = 5)
    public void login_to_acc() throws InterruptedException, IOException {
        customer_page = new Customer_Login_Page(driver);
        home.home_page();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        home.login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        customer_page.customer_login();
        //to take screenshot of succesfully login
        File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenL.png"));
        System.out.println("Pass");
    }
   //To Deposit
    @Test(priority = 6)
    public void verify_deposit() throws InterruptedException, IOException {
        customer_page = new Customer_Login_Page(driver);
        int before_bal = customer_page.check_balance();

        String amt = "5000";

        customer_page.customer_deposit(amt);

        int after_bal = customer_page.check_balance();

        if((after_bal-before_bal) == Integer.parseInt(amt)){
            File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenD.png"));
            System.out.println("Pass");
        }

        Thread.sleep(2000);
    }
    //to verify the withdrawal amount
    @Test(priority = 7)
    public void verify_withdraw() throws InterruptedException, IOException{
        customer_page = new Customer_Login_Page(driver);

        String withdraw = "5000";

        int before_bal = customer_page.check_balance();

        customer_page.customer_withdraw(withdraw);

        int after_bal = customer_page.check_balance();

        if((after_bal) == (before_bal - Integer.parseInt(withdraw))){
            File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenW.png"));
            System.out.println("Pass");
        }

        Thread.sleep(2000);
    }
    //to verify withdrawal amount if it is above limit
    @Test(priority = 8)
    public void verify_withdraw_abv_lmt() throws InterruptedException, IOException {
        customer_page = new Customer_Login_Page(driver);
        int bal = customer_page.check_balance();

        int amt = bal + 10;
        String withdraw = String.valueOf(amt);

        customer_page.customer_withdraw(withdraw);

        Thread.sleep(1000);
        //verify message displayed on the above condition and take a screenshot on the failed transaction

        WebElement verify = driver.findElement(By.xpath("//span[@ng-show='message']"));
        String verifyMessage = verify.getText();

        System.out.println(verifyMessage);
        if(verifyMessage.equals("Transaction Failed. You can not withdraw amount more than the balance."))
        {
            File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));
            System.out.println("Pass");
        }
    }
}
