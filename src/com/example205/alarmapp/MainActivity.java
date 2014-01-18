package com.example205.alarmapp;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

//public class MainActivity extends Activity {
public class MainActivity extends Activity implements OnClickListener {
	
	MediaPlayer mMp;
	Button mStopButton;
	Button mExitButton;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		((Button)findViewById(R.id.StopButton)).setOnClickListener(this);
		((Button)findViewById(R.id.ExitBuuton)).setOnClickListener(this);	
		
		FindViews();
		
		mMp = MediaPlayer.create(this, R.raw.b);	
		mMp.start(); 		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v) {
		 int id = v.getId(); 
		 switch (id) {	 
	        case R.id.StopButton:
	        	Log.d(getString(R.string.app_name),"StopButtonがクリックされました");
	        	mStopButton.setEnabled(false);
	        	if (mMp.isPlaying()) {  
	        		//MediaPlayerの停止  
	        		mMp.stop();  
	        		try {  
	        			//MediaPlayerの準備  
	        			mMp.prepare();  
	        		} 
	        		catch (Exception e) {}  
	        	}
	            break;     
	        case R.id.ExitBuuton:
	        	Log.d(getString(R.string.app_name),"ExitBuutonがクリックされました");
	        	if (mMp.isPlaying()) {  
	        		//MediaPlayerの停止  
	        		mMp.stop();  
	        		try {  
	        			//MediaPlayerの準備  
	        			mMp.prepare();  
	        		} 
	        		catch (Exception e) {}  
	        	}
	        	this.finish();
	            break;          
		 }	
	}
	
	private void FindViews(){
		mStopButton = (Button)findViewById(R.id.StopButton);
		mExitButton = (Button)findViewById(R.id.ExitBuuton);
	}
	
}
