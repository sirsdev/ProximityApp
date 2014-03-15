package com.sirsdev.proximity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ProximityService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    //TODO do something useful
	    return Service.START_NOT_STICKY;
	  }

}
