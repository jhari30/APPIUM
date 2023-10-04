package org.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ApidemoApkLongPressusingJavascript {

	public static AndroidDriver driver;

	
	public static <MobileElement> void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceVersion", "10");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		URL u = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(u, dc);

		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		views.click();

		WebElement expandableList = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandableList.click();

		WebElement customAdaptor = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
		customAdaptor.click();

//		LongPressOptions longPressOptions = new LongPressOptions();
//		TouchAction touchAction = new TouchAction(driver);
		

		WebElement peopleName = driver.findElement(By.xpath("//*[@text='People Names']"));
//		((JavascriptExecutor)driver)
//		.executeScript("mobile: touchAndHold", ImmutableMap.of("xpath",((MobileElement)peopleName)));


		String script = "mobile: touchAndHold";
        String elementId = ((RemoteWebElement) peopleName).getId();
        driver.executeScript(script, "{\"elementId\":\"" + elementId + "\", \"duration\": 1}");


		Thread.sleep(4000);

		driver.quit();
	}

}
