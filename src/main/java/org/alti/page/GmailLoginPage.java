package org.alti.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vdeshpande on 19-10-2016.
 */
public class GmailLoginPage  {

    public WebElement getBtnChooseAccount() {
        return btnChooseAccount;
    }

    public void setBtnChooseAccount(WebElement btnChooseAccount) {
        this.btnChooseAccount = btnChooseAccount;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(WebElement txtPassword) {
        this.txtPassword = txtPassword;
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(WebElement btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    @FindBy(id="choose-account-0")
     private WebElement btnChooseAccount;

    @FindBy(id="Passwd")
    private  WebElement txtPassword;

    @FindBy(id="signIn")
    private WebElement btnSubmit;

    public WebElement getVerifyUserName() {
        return verifyUserName;
    }

    public WebElement getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(WebElement txtUserName) {
        this.txtUserName = txtUserName;
    }

    public void setVerifyUserName(WebElement verifyUserName) {
        this.verifyUserName = verifyUserName;
    }

    @FindBy(id="email-display")
    private WebElement verifyUserName;

    public WebElement getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(WebElement btnNext) {
        this.btnNext = btnNext;
    }

    @FindBy(id="Email")
    private WebElement txtUserName;

    @FindBy(id="next")
    private WebElement btnNext;


}
