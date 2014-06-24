package com.example.thenewboston;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Sliding extends Activity implements OnCheckedChangeListener, OnClickListener, OnDrawerOpenListener {

	CheckBox cbSliable;
	Button button1, button2, button3, button4;
	SlidingDrawer sliding;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		initialize();
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		cbSliable = (CheckBox) findViewById(R.id.cbSliable);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		sliding = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
		sliding.setOnDrawerOpenListener(this);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		cbSliable.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.isChecked()){
			sliding.lock();
		}
		else{
			sliding.unlock();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			sliding.open();
			break;
		case R.id.button2:
					
			break;
		case R.id.button3:
			sliding.toggle();
			break;
		case R.id.button4:
			sliding.close();
			break;
		default:
			break;
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer media = MediaPlayer.create(this, R.raw.long_click_sound);
		media.start();
	}
	
}
