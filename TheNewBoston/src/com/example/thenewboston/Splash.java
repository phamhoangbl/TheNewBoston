package com.example.thenewboston;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {

	MediaPlayer splashSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//splash music
		splashSong = MediaPlayer.create(Splash.this, R.raw.splash_sound);
		SharedPreferences currentPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean enableMusicFlash = currentPrefs.getBoolean("musicFlashCheckbox", true);
		if (enableMusicFlash) {
			splashSong.start();
		}
		
		Thread timer = new Thread(){
			@Override
			public void run(){
				try{
					sleep(500);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					//Intent main = new Intent(getApplicationContext(), MainActivity.class);
					Intent main = new Intent("com.example.thenewboston.Menu");
					startActivity(main);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashSong.release();
//		AlertDialog alertDialog = new AlertDialog.Builder(Splash.this).create();
//		alertDialog.setTitle("On Pause");
//		alertDialog.setMessage("Pause for test crile life");
	}
	
}
