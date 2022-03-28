package test;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class Run_All_Test extends Customer_Login_Test{
    // To Run all the test
    @Test(priority = 9)
    public void run_all_tests(){
        driver.close();
    }
}














