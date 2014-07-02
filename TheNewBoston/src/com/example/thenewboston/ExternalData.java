package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.*;

public class ExternalData extends Activity {

	TextView tvCanWrite, tvCanRead;
	String state;
	boolean canR, canW;
	Spinner spinner1;
	String[] paths = {"Music", "Picture", "DownLoad"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		initialize();
		
		state = Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			tvCanWrite.setText("true");
			tvCanRead.setText("true");
			canW = canR = true;
		}
		else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			tvCanWrite.setText("falseeee");
			tvCanRead.setText("true");
			canW = false;
			canR = true;
		}
		else {
			tvCanWrite.setText("falseeee");
			tvCanRead.setText("falseeee");
			canW = canR = false;
		}
	}

	private void initialize() {
		// TODO Auto-generated method stub
		tvCanWrite = (TextView) findViewById(R.id.tvCanWrite);
		tvCanRead = (TextView) findViewById(R.id.tvCanRead);
		tvCanWrite.setText("false");
		tvCanRead.setText("false");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setAdapter(adapter);
	}
	
	
}
