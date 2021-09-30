package test;

import java.util.concurrent.TimeUnit;

import PageObjectModels.SauceDemoHomePage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestSauceDemo {

    String driverPath = "C:\\geckodriver.exe";

    WebDriver driver;

    SauceDemoHomePage objLogin;


    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    /**
     * This test case will login in https://www.saucedemo.com/
     * <p>
     * Verify login page title as guru99 bank
     * <p>
     * Login to application
     * <p>
     * Verify the home page using Dashboard message
     */

    @Test(dataProvider ="loginData")

    public void test_Home_Page_Login(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        //Create Login Page object
        objLogin = new SauceDemoHomePage(driver);

        //login to application
        objLogin.login2SauceDemo(username, password);

    }

@AfterTest
public void shut() {


}

    @DataProvider(name = "loginData")
    public Object [][] loginData() {
        String [][] logininfo = {
                                     {"standard_user","secret_sauce"},
                                     {"locked_out_user","secret_sauce"},
                                     {"problem_user","secret_sauce"},
                                     {"performance_glitch_user","secret_sauce"},

                                };
       return logininfo;
    }
}