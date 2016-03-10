package GroupBasedSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login {
	WebDriver driver;
	public Login(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Userid")
	WebElement UserName;
	
	@FindBy(id="Password")
	WebElement UserPassword;
	
	@FindBy(css="input[value='Sign-in']")
	WebElement LoginClick;
	
	public void setUserName(String username){
		UserName.sendKeys(username);
	}
	public void setPassword(String passwd){
		UserPassword.sendKeys(passwd);
	}
	public void click(){
		LoginClick.click();
	}
}
