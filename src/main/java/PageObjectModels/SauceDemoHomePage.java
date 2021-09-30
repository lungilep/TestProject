package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoHomePage {


    WebDriver driver;

    By userName = By.id("user-name");

    By password = By.id("password");

    By login = By.name("login-button");

    public SauceDemoHomePage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

        driver.findElement(login).click();

    }

    //Get the title of Login Page



    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void login2SauceDemo(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();
    }

}