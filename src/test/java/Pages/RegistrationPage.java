package test.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public WebDriver driver;

    @FindBy(xpath = ".//input[@id='first_name']")
    public WebElement nameElement;

    @FindBy(xpath = ".//input[@id='last_name']")
    public WebElement surnameElement;

    @FindBy(xpath = ".//input[@id='email']")
    public WebElement emailElement;

    @FindBy(xpath = ".//input[@id='password']")
    public WebElement passwordElement;

    @FindBy(xpath = ".//input[@class='btn btn-default btn-block']")
    public WebElement registrationButtonElement;

    @FindBy(xpath = ".//p[@id='first_name-error']")
    public WebElement firstNameErrorElement;

    @FindBy(xpath = ".//p[@id='last_name-error']")
    public WebElement lastNameErrorElement;

    @FindBy(xpath = ".//p[@id='email-error']")
    public WebElement emailErrorElement;

    @FindBy(xpath = ".//p[@id='password-error']")
    public WebElement passwordErrorElement;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void registration(String name, String surname, String email, String password) {
        nameElement.sendKeys(name);
        surnameElement.sendKeys(surname);
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        registrationButtonElement.click();
    }
}
