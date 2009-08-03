package com.romancetech.androidtor;




import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.TabActivity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;


public class andtor extends Activity {
	
	private String[] args;
	private List<String> items = null;
	private List<String> cargs = new ArrayList<String>();
	private TextView text;
	private boolean myBoolean;
    /** Called when the activity is first created. */
	
	
	
	
	
	
	
   
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	

    	//if this is from the listener thing
    	Bundle extras = getIntent().getExtras();
    	Uri	torrent=getIntent().getData();
    	if(torrent!=null){
    		String thetorrent=torrent.toString();
    		thetorrent=thetorrent.replace("file://","");
    		//start new intent for downloading
    		Intent i = new Intent();
    		i.putExtra("torrent", thetorrent);
    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.GetDownload");
            startActivity(i);
    		
    	}else{
    		setContentView(R.layout.tabs);
    		generateScreen(2);
    		
    		
    	}
        
        
    }

    
    
    
    /* generateScreen(int tabNo) is a method which will append the view for pressed tab to tab_holder. It take an Integer, which is the tab number. By default I want to show tab1, that’s why generateScreen(1)is called in onCreate. */

    private void generateScreen(int tabNum) {
    	LinearLayout ll = (LinearLayout) findViewById(R.id.content);
    	if (tabNum == 1) {
    		Intent i = new Intent();
    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.Search");
            startActivity(i);
    	} else if (tabNum == 2) {
    		//browse
    		Intent i = new Intent();
    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.Browser");
            startActivity(i);
    	} else if (tabNum == 3){
    		//switch to download intent
    		Intent i = new Intent();
    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.GetDownload");
            startActivity(i);
    		
        }
    	setListeners();
    }


    private void setListeners() {
	    TextView tab1 = (TextView) findViewById(R.id.tab1);
	    tab1.setOnClickListener(onClickListener);
	    TextView tab2 = (TextView) findViewById(R.id.tab2);
	    tab2.setOnClickListener(onClickListener);
	    TextView tab3 = (TextView) findViewById(R.id.tab3);
	    tab3.setOnClickListener(onClickListener);
    }


    private OnClickListener onClickListener = new OnClickListener() {
    	public void onClick(final View v) {
    		LinearLayout ll = (LinearLayout) findViewById(R.id.content);
    		switch (v.getId()) {
    			case R.id.tab1:
    				
    				//System.out.println("tab1");
    				ll.removeAllViews();
    				generateScreen(1);
    				break;


    			case R.id.tab2:
    				//System.out.println("tab2");
    				ll.removeAllViews();
    				generateScreen(2);
    				break;


    			case R.id.tab3:
    				//System.out.println("tab3");
    				generateScreen(3);
    				break;
    		    }
    	}


    };


     
   
}

