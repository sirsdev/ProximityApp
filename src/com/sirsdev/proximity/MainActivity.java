package com.sirsdev.proximity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mSensor;
	PowerManager pm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_layout);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	 protected void onResume() {
		  super.onResume();
		  try{
		  mSensorManager.registerListener(this, mSensor,
		    SensorManager.SENSOR_DELAY_NORMAL);
		  }
		  catch(Exception e){
				Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
				toast.show();
			}
	 }
	@Override
	public void onSensorChanged(SensorEvent event) {
		if(event.values[0]==0){
			//light up for 10 seconds.
			//testToast
			try{
			Toast toast = Toast.makeText(getApplicationContext(), "Near", Toast.LENGTH_SHORT);
			toast.show();
			//pm.wakeUp(SystemClock.uptimeMillis());
			//getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
			}
			catch(Exception e){
				Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
				toast.show();
			}
			
		}
		else{
			//light up for 10 seconds.
			try{
			Toast toast = Toast.makeText(getApplicationContext(), "Far", Toast.LENGTH_SHORT);
			toast.show();
			//pm.wakeUp(SystemClock.uptimeMillis());
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
			}
			catch(Exception e){
				Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}

}
