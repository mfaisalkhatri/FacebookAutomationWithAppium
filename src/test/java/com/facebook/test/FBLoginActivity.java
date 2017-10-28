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

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since 20-Oct-2017 8:33:49 PM
 */
public class FBLoginActivity extends AndroidActivity {

	/**
	 * @author wasiq.bhamla
	 * @since 20-Oct-2017 10:56:54 PM
	 * @param device
	 */
	public FBLoginActivity (final AndroidDevice device) {
		super (device);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DeviceElement prepare () {
		// TODO Auto-generated method stub
		final DeviceElement login = DeviceElement.create ("Login")
			.using (By.id ("com.facebook.katana:id/login_root"));
		DeviceElement.create ("UserName")
			.using (By.id ("com.facebook.katana:id/login_username"))
			.parent (login);
		DeviceElement.create ("Password")
			.using (By.id ("com.facebook.katana:id/login_password"))
			.parent (login);
		DeviceElement.create ("LgnBtn")
			.using (By.id ("com.facebook.katana:id/login_login"))
			.parent (login);
		return login;
	}

}
