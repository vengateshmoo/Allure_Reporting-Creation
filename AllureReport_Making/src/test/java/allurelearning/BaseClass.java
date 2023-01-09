package allurelearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public  static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();

	public static WebDriver initializedriver() {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		// TODO Auto-generated method stub
		return tdriver.get();
	}


}
