package org.login;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPreInstalledApp {
	
	public static <MobileElement> void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");	
		dc.setCapability("appPackage", "co.brainly");
		dc.setCapability("appActivity", "com.brainly.StartActivity");
		
		
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		
		AndroidDriver driver = new AndroidDriver(u,dc);  
	
	
	}

}
