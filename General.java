package GroupBasedSettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class General {
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[1]/ul/li[6]/a")
	WebElement GeneralButton;
	
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
	
	@FindBy(name="chkRBU")
	WebElement checkRBUBox;
	
	@FindBy(name="chkRBUSnapShot")
	WebElement checkRBUSnapBox;
	
	@FindBy(name="chkRBUEndSession")
	WebElement checkRBUEndSessionBox;
	
	@FindBy(name="chkRBUAutoParam")
	WebElement checkAutoParamBox;
	
	@FindBy(name="lstEnableBrowser")
	WebElement browserListButton;
	
	@FindBy(xpath="//select[@name='lstEnableBrowser']/option")
	List<WebElement> BrowserList;
	
	@FindBy(name="chkRBUCache")
	WebElement cacheSettingBox;
	
	@FindBy(name="chkRBUCacheMode")
	WebElement cacheModeBox;

	@FindBy(name="txtRBUPageTimeOut")
	WebElement PageTimeOutTxBox;

	@FindBy(name="chkRBUClipMode")
	WebElement ClipModeBox;
	
	@FindBy(name="txtRBUClipFrequency")
	WebElement ClipFreqTxBox;
	
	@FindBy(name="txtRBUClipQuality")
	WebElement ClipQualityTxBox;
	
	@FindBy(css="input[value='OK']")
	WebElement OkButton;
	
	@FindBy(css="input[value='Save']")
	WebElement SaveButton;
	
	public General(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		GeneralButton.click();
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
	
	public void enableRB(){
		if(checkRBUBox.isSelected()==false){
			checkRBUBox.click();
		}
	}

	public void enableSnapshot(){
		checkRBUSnapBox.click();
	}
	
	public void enableEndSession(){
		checkRBUEndSessionBox.click();
	}
	
	public void enableAutoParam(){
		checkAutoParamBox.click();
		browserListButton.click();
		BrowserList.get(1).click();
	}
	
	public void cacheSettings(){
		cacheSettingBox.click();
	}
	
	public void cacheMode(){
		cacheModeBox.click();
	}
	
	public void PageTimeOut(String time){
		PageTimeOutTxBox.sendKeys(time);
	}
	
	public void enableClipMode(){
		ClipModeBox.click();
	}
	
	public void SetClipFreq(String freqTime){
		PageTimeOutTxBox.sendKeys(freqTime);
	}
	
	public void SetClipQuality(String percent){
		ClipQualityTxBox.sendKeys(percent);
	}
	
	public void Perform(){
		this.addGroupG1();
		this.enableRB();
		this.enableSnapshot();
		this.enableEndSession();
		this.enableAutoParam();
		this.cacheSettings();
		this.cacheMode();
		this.PageTimeOut("1500");
		this.enableClipMode();
		this.SetClipFreq("100");
		this.SetClipQuality("100");
		this.OK_Save();
	}
		
}
