package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Customer_Login_Page {

    WebDriver driver;
    int[] res = new int[2];

    public Customer_Login_Page(WebDriver driver){
        this.driver = driver;
    }

    public void customer_login() throws InterruptedException {

        //Selecting user
        Select op = new Select(driver.findElement(By.id("userSelect")));
        op.selectByIndex(6);
        Thread.sleep(1000);
        //To click on submit after selection
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
    }
    //to check the current balance
    public int check_balance(){
        WebElement webElement = driver.findElement(By.xpath("//strong[2]"));
        int bal = Integer.parseInt(webElement.getText());

        return bal;
    }
    //customer selecting deposit
    public void customer_deposit(String amt) throws InterruptedException {
        driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
        Thread.sleep(1000);
         //Specified amount given as input
        driver.findElement(By.xpath("//input")).sendKeys(amt);
        Thread.sleep(1000);
        //To select submit after amount entered
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

    }
   // customer withdraw the  amount
    public void customer_withdraw(String withdraw) throws InterruptedException {

        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        Thread.sleep(1000);
        //Specified amount given as input for withdrawal
        driver.findElement(By.xpath("//input")).sendKeys(withdraw);
        Thread.sleep(1000);
        //To select submit after amount entered
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
    }

}
