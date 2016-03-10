package GroupBasedSettings;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenScenario {

	/**
	 * @param args
	 */
	private WebDriver driver;
	
	@FindBy(xpath="//a[text()='Test Design']")
	WebElement testDesign;
	
	@FindBy(xpath="/html/body/form/table[1]/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/div/div/ul/li[3]/div/div[1]/ul/li[1]/a")
	WebElement scenariomgmt;
	
	@FindBy(xpath="//a[contains(.,' AshmitaScenario')]")
	WebElement scenarioByName;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr[5]/td[2]/a/b")
	WebElement global;
	
	public OpenScenario(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void openScenarioPage() throws InterruptedException{
		Actions scenarioAction=new Actions(driver);
		Thread.sleep(1000);
		scenarioAction.moveToElement(testDesign).build().perform();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(scenariomgmt));
		scenariomgmt.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		scenarioByName.click();
	}

}
