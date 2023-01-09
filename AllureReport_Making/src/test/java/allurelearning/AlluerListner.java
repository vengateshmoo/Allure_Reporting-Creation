package allurelearning;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import io.qameta.allure.Attachment;

public class AlluerListner implements ITestListener 
{

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();

	}

	@Attachment 
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value= "{0}",type="text/plain")
	public static String saveTextLog(String message) {
		return message;

	}
	public void onTestStart(ITestResult result) {
		System.out.println("i am in onTestSatrt method"+getTestMethodName(result));

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("i am in onTestSuccess method"+getTestMethodName(result));

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("I am onTestfailure method"+getTestMethodName(result)+"failed");
		Object testclass= result.getInstance();
		WebDriver driver = BaseClass.getDriver();
		//Allure Screenshot and SaveTestLog
		if(driver instanceof WebDriver) {
			System.out.println("Screen capture for the test case :"+getTestMethodName(result));
			saveFailureScreenShot(driver);

		}
		saveTextLog(getTestMethodName(result)+ " failure and screenshot taken!");


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("i am in onSkippedtest method"+getTestMethodName(result));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("i am in onTestFailureButWithInsuccessPercentage method"+getTestMethodName(result));
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("I am in onStart method "+ context.getName());
		context.setAttribute("WebDriver", BaseClass.getDriver());



	}

	public void onFinish(ITestContext context) {
		System.out.println("I am in onTestFinish method" + context.getName());

	}
}
