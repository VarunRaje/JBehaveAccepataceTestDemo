package org.alti.feature;

import org.alti.page.GmailLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vdeshpande on 19-10-2016.
 */
public class GmailLoginFeature {

    WebDriver driver;
    GmailLoginPage page;


    public GmailLoginFeature(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver();

       driver = new FirefoxDriver();
        page = PageFactory.initElements(driver, GmailLoginPage.class);

    }

    public void setUp(){
        driver.get("http://www.gmail.com");
        driver.manage().window().maximize();
    }

    public String getUserName(){
       return page.getVerifyUserName().getText();

    }

    public void setUserName(String userName){
        page.getTxtUserName().sendKeys(userName);
    }

    public void chooseAccount(){
        page.getBtnChooseAccount().click();
    }

    public void setPassword(String password){
        page.getTxtPassword().sendKeys(password);
    }

    public void ClickNext(){
        page.getBtnNext().click();
    }

    public void submit(){
        page.getBtnSubmit().click();
    }
}

