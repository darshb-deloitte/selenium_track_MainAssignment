package test;


import org.checkerframework.checker.fenum.qual.SwingTitleJustification;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Pages.Home_Page;
import Pages.Manager_Login_Page;

import java.io.IOException;

public class Manager_Login_Test extends Home_Test{

    Manager_Login_Page manager_page;
    String customer_first_name = "Darshika ";
    String customer_last_name = "B";
    String postal = "560092";


    @Test(priority = 3)
    public void add_customer() throws InterruptedException {
        manager_page = new Manager_Login_Page(driver);
        home.manager_login();
        manager_page.add_customer(customer_first_name,customer_last_name,postal);
    }

    @Test(priority = 4)
    public void open_account() throws InterruptedException {
        manager_page = new Manager_Login_Page(driver);
        manager_page.open_account();

        Thread.sleep(1000);
    }


}