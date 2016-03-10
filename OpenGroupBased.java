package GroupBasedSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenGroupBased {
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr[7]/td[2]/a/b")
	WebElement groupBasedSettingsButton;
	
	public OpenGroupBased(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void GoToGroup(){
		driver.switchTo().frame("scenario_Left_Frame");
		groupBasedSettingsButton.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("scenario_Right_Frame");
	}
	
}
