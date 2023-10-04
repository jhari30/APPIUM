package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DemoAppHomePagePom extends BaseClass {

	public DemoAppHomePagePom() {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
}

@AndroidFindBy(xpath=)
private WebElement preference;
