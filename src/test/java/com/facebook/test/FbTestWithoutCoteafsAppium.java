package com.facebook.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class FbTestWithoutCoteafsAppium {

	private static AndroidDriver <MobileElement> driver;
	
	
	@Test
	public void Test1 () throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dcap = new DesiredCapabilities ();
		dcap.setCapability("deviceName", "Note2");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("platformVersion", "4.4.2");
		dcap.setCapability("appPackage", "com.facebook.katana");
		dcap.setCapability("appActivity", "com.facebook.katana.LoginActivity");
		
		driver = new AndroidDriver <>(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		MobileElement lgn = driver.findElement(By.id("com.facebook.katana:id/login_username"));
		
		TouchAction tact = new TouchAction(driver);
		
		tact.tap(lgn).perform();
		lgn.clear();
		lgn.sendKeys("faisal.khatri@ymail.com");
		
		MobileElement pwd = driver.findElement(By.id("com.facebook.katana:id/login_password"));
		
		tact.tap(pwd).perform();
		pwd.clear();
		pwd.sendKeys("mh047268");
		
		MobileElement lgnBtn = driver.findElement(By.id("com.facebook.katana:id/login_login"));
		tact.tap(lgnBtn).waitAction(Duration.ofSeconds(3)).perform();
		
		MobileElement pwdchk = driver.findElement(By.id("com.facebook.katana:id/save_password_checkbox"));
		pwdchk.click();
		
		
		MobileElement cont = driver.findElement(By.id("com.facebook.katana:id/dbl_continue"));
		tact.tap(cont).perform();
	
		MobileElement okBtn = driver.findElement(By.id("android:id/button1"));
		tact.tap(okBtn).perform();
		
		
		MobileElement status1 = driver.findElement(By.id("android:id/list"));
		MobileElement stat1 = status1.findElements(By.className("android.view.View")).get(6);
		
		tact.tap(stat1).perform();
		
		MobileElement status2 = driver.findElement(By.id("com.facebook.katana:id/composer_status_text"));
		
		tact.tap(status2).perform();
		status2.sendKeys("This is an automated test posted using appium. #appium #fk");
		
		
		MobileElement postbtn = driver.findElement(By.id("com.facebook.katana:id/primary_named_button"));
		tact.tap(postbtn).waitAction(Duration.ofSeconds(5)).perform();
		
		
		/*MobileElement statschk = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
				+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout"
				+ "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]"
				+ "/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout"
				+ "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View"
				+ "/android.support.v7.widget.RecyclerView/android.view.View[5]"));
		
		String fstatus = statschk.getText();
		System.out.println(fstatus);
		*/
		driver.quit();
		
	}
	
	
}
