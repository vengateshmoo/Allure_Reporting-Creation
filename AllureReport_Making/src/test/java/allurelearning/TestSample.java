package allurelearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AlluerListner.class})
public class TestSample extends BaseClass {

//	public 	WebDriver driver;

	@BeforeSuite
	public void launchbrowser() {
		BaseClass bs=new BaseClass();
		bs.initializedriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	@Test(priority = 1,description ="Verify Logo presence on Home Page" )
	@Description("Verify the logo on home pages.......")
	@Epic("Ep001")
	@Feature("Feature:Logo")
	@Story("StoryName: Logo Present")
	@Step("Verifi logo present")
	@Severity(SeverityLevel.MINOR)
	public void openGoogle() {
		boolean dispalystatus=	driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(dispalystatus, true);
		System.out.println("My Dispaly Status message is:"+dispalystatus);
	}


	@Test(priority = 2, description ="verify the log in process")
	@Description("Verify the loginprocess on Login pages.......")
	@Epic("Ep002")
	@Feature("Feature:Log In")
	@Story("StoryName: Log In Process")
	@Step("Verifi log in page")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("ervengatesh1@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Moorthi@100");
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Assert.assertEquals(driver.getTitle(),"nopCommerce demo store");
	}
    
	@Test(priority = 3,description ="To check the Skipped Test Cases" )
	@Description("Verify the Skip on Registraction pages.......")
	@Epic("Ep003")
	@Feature("Feature:Skip Test Case")
	@Story("StoryName:Skkiping TestCase")
	@Step("Verifi Skipping TestCase in Registration Page")
	@Severity(SeverityLevel.NORMAL)
	public void registraction() {
    throw new SkipException("skipping this Test case");
	}
	@AfterSuite
	public void qiutBrowser() {
	driver.quit();
	}

}
