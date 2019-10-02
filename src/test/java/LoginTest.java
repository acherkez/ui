package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resourses/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "inputValues")
    public Object[][] inputValues() {
        return new Object[][]{
                {"", "", "Будь ласка, введіть вашу ел. пошту.", "Будь ласка, введіть ваш пароль."},
                {"12qwas@", "qw", "Будь ласка, виправте помилку в ел. пошті.", ""},
        };
    }

    @Test(dataProvider = "inputValues")
    public void test(String email, String password, String expectedEmailMessage, String expectedPasswordMessage) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get(" https://www.work.ua/jobseeker/login/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertEquals(loginPage.emailErrorElement.getText(), expectedEmailMessage);
        Assert.assertEquals(loginPage.passwordErrorElement.getText(), expectedPasswordMessage);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
