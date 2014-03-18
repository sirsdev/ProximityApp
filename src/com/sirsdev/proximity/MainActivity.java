package com.sirsdev.proximity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton toggle;
	Intent intent;
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_layout);
		toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		context = getBaseContext();
		intent = new Intent(MainActivity.this,ProximityService.class);
		toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					MainActivity.this.startService(intent);
				}
				else
				{
					MainActivity.this.stopService(intent);
				}
			}
		});
	}
	
	 protected void onResume() {
		  super.onResume();
	 }

}
