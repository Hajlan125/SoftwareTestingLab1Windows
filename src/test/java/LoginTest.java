import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MailPage mailPage;
    public static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mailPage = new MailPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String user = profilePage.getUserName();
        assertEquals(ConfProperties.getProperty("login"),user);

        profilePage.enterMail();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @AfterEach
    public void tearDown() {
//        profilePage.entryMenu();
//        profilePage.userLogout();
        mailPage.entryUserMenu();
        mailPage.usrLogout();
        driver.quit();
    }
}