package org.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class BaseClass {

	public static AndroidDriver driver;

	public static void Launchapp(String deviceName,String platformName, String platformVersion, String appPackage, String appActivity ) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("platformName", platformName);
		dc.setCapability("platformVersion", platformVersion);
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);

		URL u = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(u, dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void enterText(WebElement element,String text) {
		element.sendKeys(text);
		
	}
	
	public static void scrollOperation(String scrollElementtext) {
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"'+scrollElementtext+'\"));"));
	}
	
	public static void buttonCick(WebElement element) {
		element.click();
	}
	
	public static void longPress(WebElement element) {
		
		TouchAction touchAction = new TouchAction(driver);

		touchAction.longPress(ElementOption.element(element))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();

	}
	
	public static void dragAndDrop (WebElement source,WebElement target) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(ElementOption.element(source)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(target)).release().perform();
		
		
	}
	
	public static void quitDriver() {
		driver.quit();
	}
	
	
	
	
	
}
