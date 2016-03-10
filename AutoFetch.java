package GroupBasedSettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AutoFetch {
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[1]/ul/li[3]/a")
	WebElement AutoFetchButton;
	
	@FindBy(name="GroupName")
	WebElement openGroupListButton;
	
	@FindBy(xpath="//select[@name='GroupName']/option")
	List<WebElement> groupList;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/select/option[2]")
	WebElement Group1;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/select/option[3]")
	WebElement Group2;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[2]/ul/li[2]/a")
	WebElement Group1Menu;
	
	@FindBy(name="chkMain")
	WebElement CheckMain;
	
	@FindBy(name="lstPageName")
	WebElement PageListButton;
	
	@FindBy(xpath="//select[@name='lstPageName']/option[2]")
	WebElement allPages;
	
	@FindBy(xpath="//select[@name='lstPageName']/option[3]")
	WebElement Page1;
	
	@FindBy(xpath="//select[@name='lstPageName']/option[4]")
	WebElement Page2;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement AddButton;
	
	@FindBy(css="input[value='OK']")
	WebElement OkButton;
	
	@FindBy(css="input[value='Save']")
	WebElement SaveButton;
	
	@FindBy(name="Delete")
	WebElement deleteButton;
	
	@FindBy(name="txtIncludeDomain")
	WebElement includeDomainTextBox;
	
	@FindBy(name="txtExcludeDomain")
	WebElement excludeDomainTextBox;
	
	@FindBy(name="txtIncludeUrl")
	WebElement includeURLTextBox;
	
	@FindBy(name="txtExcludeUrl")
	WebElement excludeURLTextBox;
	
	public AutoFetch(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AutoFetchButton.click();
	}
	
	public void addGroupG1(){
		try{
		openGroupListButton.click();
		Group1.click();
		}catch(Exception e){
			Group1Menu.click();
		}
		Group1Menu.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	public void Page1DisableAutoFetch(){
		CheckMain.click();
		try{	
			Thread.sleep(3000);
	         }
	         catch(Exception e){
	        	 e.printStackTrace();
	         }
		PageListButton.click();
         try{	
		Thread.sleep(3000);
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
		Page1.click();
		try{	
			Thread.sleep(10000);
	         }
	         catch(Exception e){
	        	 e.printStackTrace();
	         }
		AddButton.click();
		OkButton.click();
		SaveButton.click();
	}
	
	public void Page2DisableAutoFetch(){
		CheckMain.click();
		PageListButton.click();
		Page2.click();
		
		AddButton.click();
		OkButton.click();
		SaveButton.click();
	}
	
	public void deleteAllInSelected(){
		CheckMain.click();
		deleteButton.click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		OkButton.click();
		SaveButton.click();
	}

	public void IncludeDomain(String domainName){
		includeDomainTextBox.sendKeys(domainName);
	}
	
	public void ExcludeDomain(String domainName){
		excludeDomainTextBox.sendKeys(domainName);
	}
	
	public void IncludeURL(String URL){
		includeURLTextBox.sendKeys(URL);
	}
	
	public void ExcludeURL(String URL){
		excludeURLTextBox.sendKeys(URL);
	}
	
	public void OK_Save(){
		OkButton.click();
		SaveButton.click();
	}

	public void Perform(){
		this.addGroupG1();                //Adds G1 to the menu or selects G1 from menu if already present
	//	this.deleteAllInSelected();       // delete previously added keywords
	//	this.Page1DisableAutoFetch();     //Disable AutoFetch for Page1
		this.Page2DisableAutoFetch(); 
		System.out.println("Page1 disable done");
		
		this.IncludeDomain("www.google.com");  //Adds Include & Exclude domain & URL
		this.ExcludeDomain("www.yahoo.com");
		this.IncludeURL("*.jsp");
		this.ExcludeURL("*.js");
		this.OK_Save();					  //Clicks on OK and Save button
	}
}
