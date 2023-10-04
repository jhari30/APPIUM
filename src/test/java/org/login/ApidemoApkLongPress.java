package org.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ApidemoApkLongPress {

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

		WebElement peopleName = driver.findElement(By.xpath("//*[@text='People Names']"));

		TouchAction touchAction = new TouchAction(driver);

		touchAction.longPress(ElementOption.element(peopleName))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();

		Thread.sleep(4000);

		driver.quit();
	}

}
