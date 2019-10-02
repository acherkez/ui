package test.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(xpath = ".//input[@id='email']")
    public WebElement emailElement;

    @FindBy(xpath = ".//input[@id='password']")
    public WebElement passwordElement;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement submitButtonElement;

    @FindBy(xpath = ".//p[@id = 'email-error']")
    public WebElement emailErrorElement;

    @FindBy(xpath = ".//p[@id = 'password-error']")
    public WebElement passwordErrorElement;

    @FindBy(xpath = ".//div[@class = 'alert alert-danger']/h2")
    public WebElement errorMessageElement;

    @FindBy(xpath = ".//div[@class = 'alert alert-danger']/p")
    public WebElement hintUnderErrorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String email, String password) {
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        submitButtonElement.click();
    }
}
