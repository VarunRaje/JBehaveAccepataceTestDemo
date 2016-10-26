package org.alti.steps;

import junit.framework.Assert;
import org.alti.feature.GmailLoginFeature;
import org.alti.page.GmailLoginPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vdeshpande on 19-09-2016.
 */
public class GmailLoginStepsDef  {

    GmailLoginFeature gmail = new GmailLoginFeature();

    @Given("User Launches the Gmail site")
    public void UserLaunchesTheGmailSite(){
        gmail.setUp();
        System.out.println("site is launched");
    }

    @Then("click on next button")
    public void clickOnNextButtoon() throws InterruptedException {
        gmail.ClickNext();
        Thread.sleep(3000);
    }

    @Then("Enters username as $element")
    public void EntersUserNameAs(String userName){
        System.out.println(userName);
        gmail.setUserName(userName);
    }

    @Then("Verify the username is $element")
    public void VerifyTheUsernameIs(String userName){
        Assert.assertEquals(userName,gmail.getUserName());
        System.out.println("Username verified");
    }

    @Then("click on username")
    public void clickOnUserName(){
        gmail.chooseAccount();
        System.out.println("Clciked on Username ");

    }

    @Then("Enter the password $element")
    public void EnterPassword(String password){
        gmail.setPassword(password);
        System.out.println("Password Entered");

    }

    @Then("Click the login Button")
    public void ClickTheLoginButton(){
        gmail.submit();
        System.out.println("Login BUtton is clicked");
    }
}
