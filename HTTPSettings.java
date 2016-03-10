package GroupBasedSettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTTPSettings {
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[1]/ul/li[4]/a")
	WebElement HTTPButton;
	
	@FindBy(name="GroupName")
	WebElement openGroupListButton;
	
	@FindBy(xpath="//select[@name='GroupName']/option")
	List<WebElement> groupList;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/select/option[2]")
	WebElement Group1;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/select/option[3]")
	WebElement Group2;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/a")
	WebElement GroupMenu;
	
	@FindBy(name="chkDisAllHead")
	WebElement useHeaderAllBox;
		
	@FindBy (name="chkDisAccHead")
	WebElement useHeaderAcceptBox;
	
	@FindBy(name="chkDisAccEncHead")
	WebElement useHeaderAcceptEnBox;
	
	@FindBy(name="chkDisUAHead")
	WebElement useHeaderUABox;
	
	@FindBy(name="chkDisKAHead")
	WebElement useHeaderKABox;
	
	@FindBy(name="chkDisConnHead")
	WebElement useHeaderConnBox;
	
	@FindBy(name="chkDisHostHead")
	WebElement useHeaderHostBox;
	
	@FindBy(css="input[value='OK']")
	WebElement OkButton;
	
	@FindBy(css="input[value='Save']")
	WebElement SaveButton;
	
	public HTTPSettings(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HTTPButton.click();
	}
	
	public void OK_Save(){
		OkButton.click();
		SaveButton.click();
	}
	
	public void addGroupG1(){
		try{
		openGroupListButton.click();
		Group1.click();
		}catch(Exception e){
			GroupMenu.click();
		}
		GroupMenu.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
/*	public void addGroupG2(){
		try{
		openGroupListButton.click();
		Group2.click();
		}catch(Exception e){
			GroupMenu.click();
		}
		GroupMenu.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	*/
	public void UseHeaderAll(){
		useHeaderAllBox.click();
	}
	
	public void UseHeaderAccept(){
		useHeaderAcceptBox.click();
	}
	
	public void UserHeaderAcceptEn(){
		useHeaderAcceptEnBox.click();
	}
	
	public void UserHeaderUA(){
		useHeaderUABox.click();
	}
	
	public void UserHeaderKA(){
		useHeaderKABox.click();
	}
	
	public void UserHeaderConn(){
		useHeaderConnBox.click();
	}
	
	public void UserHeaderHost(){
		useHeaderHostBox.click();
	}
	
	public void Perform(){
		this.addGroupG1();
		this.UseHeaderAll();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	this.UseHeaderAccept();
	//	this.UserHeaderAcceptEn();
	//	this.UserHeaderUA();
	//	this.UserHeaderKA();
	//	this.UserHeaderConn();
	//	this.UserHeaderHost();
		this.OK_Save();
		System.out.println("Saved");
	}
}
