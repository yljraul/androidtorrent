package com.romancetech.androidtor;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.romancetech.*;
public class unChoke extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 5000;
	private static GetDownload MAIN_ACTIVITY;

	
	
	public static void setMainActivity(GetDownload activity) {
		  MAIN_ACTIVITY = activity;
		}

	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void onCreate() {
		  super.onCreate();
		  // init the service here
		  _startService();
	  
		}
	@Override
	public void onDestroy() {
		  super.onDestroy();

		  _shutdownService();

		  
		}

	private void _startService() {
		  timer.scheduleAtFixedRate(
		      new TimerTask() {
		        public void run() {
		          _unchoke();
		        }
		      },
		      0,
		      UPDATE_INTERVAL);
		  Log.v("AndroidTor","Timer started");
		}

	protected void _unchoke() {
		// TODO Auto-generated method stub
		Log.v("AndroidTor","Unchoking");
		//.unchokePeers();
		
	}


	private void _shutdownService() {
		  if (timer != null) timer.cancel();
		  Log.v("AndroidTor", "Timer stopped!!!");
		}

	
	
}
