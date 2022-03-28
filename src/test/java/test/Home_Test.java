package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Home_Page;

public class Home_Test{

    public WebDriver driver;
    Home_Page home;
    String url  = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    // to open the browser
    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\darshb\\Downloads\\selenium\\selenium 4.1.2\\chromdriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    //to navigate to customer login
    @Test(priority = 1)
    public void navigate_login() throws InterruptedException {
        home = new Home_Page(driver);
        home.login();
        Thread.sleep(1000);
        //Return to home page
        home.home_page();
        Thread.sleep(1000);
    }
    // to navigate to manager login
    @Test(priority = 2)
    public void navigate_manager_login() throws InterruptedException {
        home = new Home_Page(driver);
        home.manager_login();
        Thread.sleep(1000);
        //Return to home page
        home.home_page();
        Thread.sleep(1000);
    }

}

