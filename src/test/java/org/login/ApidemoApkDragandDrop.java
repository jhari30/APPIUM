package org.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ApidemoApkDragandDrop {

	public static AndroidDriver driver;

	public static <MobileElement> void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceVersion", "10");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		URL u = new URL("http://0.0.0.0:4723/wd/hub"); //throws MalformedURLException

		driver = new AndroidDriver(u, dc);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		views.click();

		WebElement dragandDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
		dragandDrop.click();

		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

		Thread.sleep(4000);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(ElementOption.element(source)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(target)).release().perform();
		
		

		driver.quit();
	}

}
