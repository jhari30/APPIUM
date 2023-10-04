package org.login;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;

public class ApidemoApkSendKeys {

	public static <MobileElement> void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceVersion", "10");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		URL u = new URL("http://0.0.0.0:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(u, dc);

		WebElement preference = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]"));
		preference.click();

		WebElement preferencedependencies = driver
				.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferencedependencies.click();
		
		Thread.sleep(5000);

		WebElement wificheckbox = driver.findElement(By.id("android:id/checkbox"));
		WebElement wifisettings = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[2]"));

		try {
			if (wifisettings.isDisplayed()) {
				wifisettings.click();
				WebElement send_keyswifi = driver.findElement(By.id("android:id/edit"));
				send_keyswifi.sendKeys("hariahran");

				WebElement okbutton = driver.findElement(By.id("android:id/button1"));
				okbutton.click();

			}

		} catch (Exception e) {
			wificheckbox.click();
			Thread.sleep(3000);

			wifisettings.click();
			WebElement send_keyswifi = driver.findElement(By.id("android:id/edit"));
			send_keyswifi.sendKeys("hariahran");

			WebElement okbutton = driver.findElement(By.id("android:id/button1"));
			okbutton.click();

		}

		driver.close();
		}

}
