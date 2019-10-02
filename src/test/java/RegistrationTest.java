package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    WebDriver driver;

    @DataProvider(name = "inputValues")
    public Object[][] inputValues() {
        return new Object[][]{
                {"", "", "", "", "Будь ласка, вкажіть ім’я.", "Будь ласка, вкажіть прізвище.", "Будь ласка, введіть вашу ел. пошту.", "Будь ласка, введіть ваш пароль."},
                {"12", "12", "12", "12", "Введено неприпустимі символи.", "Введено неприпустимі символи.", "Будь ласка, виправте помилку в ел. пошті.", "Будь ласка, введіть пароль зі щонайменше 4 символами."},
        };
    }


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resourses/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "inputValues")
    public void test(String name, String surname, String email, String password, String expectedNameMessage, String expectedSurnmeMessage, String expectedEmailMessage, String expectedPasswordMessage) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.work.ua/jobseeker/register/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, surname, email, password);

        Assert.assertEquals(registrationPage.firstNameErrorElement.getText(), expectedNameMessage);
        Assert.assertEquals(registrationPage.lastNameErrorElement.getText(), expectedSurnmeMessage);
        Assert.assertEquals(registrationPage.emailErrorElement.getText(), expectedEmailMessage);
        Assert.assertEquals(registrationPage.passwordErrorElement.getText(), expectedPasswordMessage);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
