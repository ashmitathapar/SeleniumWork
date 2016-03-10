package GroupBasedSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://10.10.30.18:8001/netstorm/admin/login.jsp");
		
		//login
		Login login=new Login(driver);
		login.setUserName("netstorm");
		login.setPassword("netstorm");
		login.click();
		
		//scenario
		OpenScenario scenario=new OpenScenario(driver);
		scenario.openScenarioPage();
		
		//switch to Scenario Settings
		for (String child: driver.getWindowHandles()){
			driver.switchTo().window(child);
			driver.manage().window().maximize();
		}
		//Open GroupBased Settings
		OpenGroupBased groupsettings=new OpenGroupBased(driver);
		groupsettings.GoToGroup();
		
		//Open Auto Fetch Settings
	//	AutoFetch autoFetch=new AutoFetch(driver);
	//	autoFetch.Perform();
		
		//Open HTTPSettings
		HTTPSettings http=new HTTPSettings(driver);
		http.Perform();
		
		//Open General Settings
		General general=new General(driver);
		general.Perform();
	}
}
