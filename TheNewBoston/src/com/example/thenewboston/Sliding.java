package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Sliding extends Activity implements OnCheckedChangeListener, OnClickListener {

	CheckBox cbSliable;
	Button button1, button2, button3, button4;
	
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
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		cbSliable.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			
			break;
		case R.id.button2:
					
			break;
		case R.id.button3:
			
			break;
		case R.id.button4:
			
			break;
		default:
			break;
		}
	}
	
}
