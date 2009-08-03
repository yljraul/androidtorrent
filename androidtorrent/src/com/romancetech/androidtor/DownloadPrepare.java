package com.romancetech.androidtor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadPrepare extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		//need to override the saved instance so they come back here untill the download is done.
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main2);
	    
	    
	   //get torrent file from intent
    	Bundle extras = getIntent().getExtras();
		String thetorrent = extras.getString("torrent");
	    
	    
	    
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.toast_layout,
		                               (ViewGroup) findViewById(R.id.toast_layout_root));

		ImageView image = (ImageView) layout.findViewById(R.id.image);
		image.setImageResource(R.drawable.icon);
		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText("Creating files!");

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		int LENGTH_LONG=999999999;
		toast.setDuration(LENGTH_LONG);
		toast.setView(layout);
		toast.show();

		
		
		Intent i = new Intent();
		i.putExtra("torrent", thetorrent);
	
		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.GetDownload");
        startActivity(i);
		
		
	}
}
