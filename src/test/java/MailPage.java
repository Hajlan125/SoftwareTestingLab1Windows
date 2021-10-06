import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement incomingBtn;

    @FindBy(xpath = "//*[contains(@class, 'legouser legouser_fetch-accounts_yes legouser_hidden_yes i-bem')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link count-me legouser__menu-item legouser__menu-item_action_exit legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement userLogout;

    public void usrLogout() {
        userLogout.click();
    }

    public void entryUserMenu(){
        userMenu.click();
    }

    public String getIncomingText() {
        return incomingBtn.getText();
    }
    public void incomingBtnClick() {
        incomingBtn.click();
    }
}
