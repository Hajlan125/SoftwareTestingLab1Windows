import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'PageHeader-right')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")
    private WebElement userLogin;

    @FindBy(xpath = "//*[contains(@class, 'PageNavigation-link PageNavigation-link_row PageNavigation-link_active')]")
    private WebElement myServices;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_mail')]")
    private WebElement mailBtn;


    public String getUserName() {
        String userName = userLogin.getText();
        return userName;
    }

    public void enterMail() {
        userMenu.click();
        mailBtn.click();
    }

    public void enterMyServices(){
        myServices.click();
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}