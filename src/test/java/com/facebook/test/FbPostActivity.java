package com.facebook.test;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

public class FbPostActivity extends AndroidActivity {

	public FbPostActivity (final AndroidDevice device) {
		super (device);

	}

	// 9602369*
	@Override
	protected DeviceElement prepare () {
		// TODO Auto-generated method stub
		final DeviceElement mPage = DeviceElement.create ("MainPage")
				.using (By.id ("android:id/windowContentFrame"));

		DeviceElement.create ("Continue")
		.using (By.id ("com.facebook.katana:id/dbl_continue"))
		.parent (mPage);

		final DeviceElement status = DeviceElement.create ("Stat1")
				.using (By.id ("android:id/list"))
				.parent (mPage);
		DeviceElement.create ("FinalStatus")
		.using (By.className ("android.view.View"))
		.index (6)
		.parent (status);

		DeviceElement.create ("PostStatus")
		.using (By.id ("com.facebook.katana:id/composer_status_text"))
		.parent (mPage);

		DeviceElement.create ("PostBtn")
		.using (By.id ("com.facebook.katana:id/primary_named_button"))
		.parent (mPage);



		return mPage;
	}

}
