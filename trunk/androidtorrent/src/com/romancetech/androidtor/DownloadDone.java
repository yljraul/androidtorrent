package com.romancetech.androidtor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DownloadDone extends Activity {
	
	
	
	
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.tabs);
    	generateScreen(4);
    	
	
	}
	
	
	
	 private void generateScreen(int tabNum) {
	    	LinearLayout ll = (LinearLayout) findViewById(R.id.content);
	    	if (tabNum == 1) {
	    		//switch intent to search
	    		Intent i = new Intent();
	    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.Search");
	            startActivity(i);
	    		
	    	} else if (tabNum == 2) {
	    		Intent i = new Intent();
	    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.Browser");
	            startActivity(i);
	    	} else if (tabNum == 3) {
	    		Intent i = new Intent();
	    		i.setClassName("com.romancetech.androidtor", "com.romancetech.androidtor.GetDownload");
	            startActivity(i);
	        }else if (tabNum == 4) {
	        	View vv = View.inflate(DownloadDone.this, R.layout.done, null);
	    		ll.addView(vv, new LinearLayout.LayoutParams(ll.getLayoutParams().width, ll.getLayoutParams().height));
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
	    		LinearLayout ll = (LinearLayout) findViewById(R.id.box_1);
	    		switch (v.getId()) {
	    			case R.id.tab1:
	    				//switch intent?
	    				//System.out.println("tab1");
	    				//ll.removeAllViews();
	    				generateScreen(1);
	    				break;


	    			case R.id.tab2:
	    				//System.out.println("tab2");
	    				//ll.removeAllViews();
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
