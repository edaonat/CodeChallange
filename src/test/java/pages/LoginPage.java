package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//h1[text()='Log in to Trello']")
    public WebElement loginToTrello;
    @FindBy(xpath="//input[@id='user']")
    public WebElement emailTextBox;
    @FindBy(xpath="//input[@id='password']")
    public WebElement passwordTextBox;
    @FindBy(xpath="//input[@id='login']")
    public WebElement continueButton;
    @FindBy(xpath="//p[@id='error-message']")
    public WebElement noAccountThisUsername;
    @FindBy(xpath="//button[@id='login-submit']")
    public WebElement loginButton;
    @FindBy(xpath="//*[@class='error-message']")
    public WebElement errorMessage;



}
