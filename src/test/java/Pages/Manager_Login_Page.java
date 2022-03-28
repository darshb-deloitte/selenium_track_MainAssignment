package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Manager_Login_Page {

    WebDriver driver;
    By add_customer_btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    By open_account_btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    By customer_btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");

    public Manager_Login_Page(WebDriver driver){
        this.driver = driver;
    }
   //To add  account for the customer
    public void add_customer(String customer_first, String customer_last, String postal_code) throws InterruptedException {
        WebElement add_btn = driver.findElement(add_customer_btn);
        add_btn.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys(customer_first);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys(customer_last);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys(postal_code);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    // to open an account for  the customer
    public void open_account() throws InterruptedException {
        WebElement open_acc_btn = driver.findElement(open_account_btn);
        open_acc_btn.click();
        Thread.sleep(1000);

        Select user = new Select(driver.findElement(By.id("userSelect")));
        user.selectByIndex(6);

        //selecting currency
        Select cur = new Select(driver.findElement(By.id("currency")));
        cur.selectByIndex(3);
        //click on process
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //to accept
        driver.switchTo().alert().accept();
        Thread.sleep(1000);


    }

    public void view_customer(){
        WebElement view_customer_btn = driver.findElement(customer_btn);
        view_customer_btn.click();
    }
}
