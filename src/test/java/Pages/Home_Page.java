package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Home_Page {

    WebDriver driver;
    By customer_login_btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    By bank_manager_login_btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    By home_btn = By.xpath("/html/body/div/div/div[1]/button[1]");
    String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";


    public Home_Page(WebDriver driver){
        this.driver = driver;
    }
     //To open the Home page
    public void open_page() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    //TO CLICK ON  CUSTOMER LOGIN
    public void login() throws InterruptedException {
        WebElement element1 = driver.findElement(customer_login_btn);
        element1.click();
        Thread.sleep(1000);
    }
   //TO CLICK ON MANAGER LOGIN
    public void manager_login() throws InterruptedException {
        WebElement element2  = driver.findElement(bank_manager_login_btn);
        element2.click();
        Thread.sleep(1000);
    }
    //TO NAVIGATE TO THE HOME BUTTON IN CLICK
    public void home_page() throws InterruptedException {
        WebElement element3 = driver.findElement(home_btn);
        element3.click();
        Thread.sleep(1000);
    }
}
