package com.sirsdev.proximity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.Toast;

public class ProximityService extends Service implements SensorEventListener{
	private SensorManager mSensorManager;
	private Sensor mSensor;
	PowerManager pm;
	@Override
	public void onCreate() {		
	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
	Toast toast = Toast.makeText(getBaseContext(), "Servicestarted", Toast.LENGTH_SHORT);
	toast.show();
	  try{
	  mSensorManager.registerListener(this, mSensor,
	  SensorManager.SENSOR_DELAY_NORMAL);
	  }
	  catch(Exception e){
			Toast toast2 = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
			toast2.show();
		}
		super.onCreate();
	}
	@Override
	public void onDestroy() {		
		Toast toast = Toast.makeText(getBaseContext(), "Service Stopperd", Toast.LENGTH_SHORT);
		toast.show();
		super.onDestroy();
	}
	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}
	
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
		    return Service.START_NOT_STICKY;
	  }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
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
			//getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
			}
			catch(Exception e){
				Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}

}


