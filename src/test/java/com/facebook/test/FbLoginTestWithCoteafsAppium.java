/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 20-Oct-2017 11:24:47 PM
 */
public class FbLoginTestWithCoteafsAppium {

	protected AndroidDevice	device;
	protected AppiumServer	server;

	@BeforeSuite (alwaysRun = true)
	public void setupSuite () {
		this.server = new AppiumServer ("android");
		this.server.start ();

		this.device = new AndroidDevice (this.server, "android");
		this.device.start ();
	}

	@AfterSuite (alwaysRun = true)
	public void teardownTestSuite () {
		if (this.server != null && this.device != null) {
			this.device.stop ();
			this.server.stop ();
		}
	}

	@Test
	public void test1 () {

		final FBLoginActivity login = new FBLoginActivity (this.device);
		login.onElement ("UserName")
		.enterText ("faisal.khatri@ymail.com");

		login.onDevice().captureScreenshot();
		login.onElement ("Password")
		.enterText ("mh047268");

		login.onDevice().captureScreenshot();
		login.onElement ("LgnBtn")
		.tap ();

		final FbPostActivity fbp = new FbPostActivity (this.device);
		fbp.onElement ("Continue")
		.tap ();

		fbp.onElement ("FinalStatus")
		.tap ();

		fbp.onElement ("PostStatus")
		.enterText ("Testing the latest changes in coteafs - appium. #appium #fk");

		fbp.onElement("PostBtn").tap ();

		fbp.onDevice ().captureScreenshot ();



	}
}
