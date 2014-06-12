package com.example.thenewboston;

import java.util.Random;
import java.util.TooManyListenersException;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class TextPlay extends Activity implements View.OnClickListener {

	EditText etCommand;
	Button btResult;
	ToggleButton tbPassword;
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		etCommand = (EditText) findViewById(R.id.etCommand);
		btResult = (Button) findViewById(R.id.btResult);
		tbPassword = (ToggleButton) findViewById(R.id.tbPassword);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		tbPassword.setOnClickListener(this);
		btResult.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.tbPassword:
				// TODO Auto-generated method stub
				if(tbPassword.isChecked()){
					etCommand.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
				else{
					etCommand.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				break;
			case R.id.btResult:
				String text = etCommand.getText().toString();
				if(text.contentEquals("left")){
					tvResult.setGravity(Gravity.LEFT);
				} else if(text.contentEquals("center")){
					tvResult.setGravity(Gravity.CENTER);
				} else if(text.contentEquals("right")){
					tvResult.setGravity(Gravity.RIGHT);
				} else if(text.contentEquals("blue")){
					tvResult.setTextColor(Color.BLUE);
				} else if(text.contentEquals("WTF")){
					Random random = new Random();
					tvResult.setTextSize(random.nextInt(75));
					tvResult.setTextColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
					
					switch(random.nextInt(3)){
					case 1: 
						tvResult.setGravity(Gravity.LEFT);
						break;
					case 2: 
						tvResult.setGravity(Gravity.CENTER);
						break;
					case 3: 
						tvResult.setGravity(Gravity.RIGHT);
						break;
					}
				}
				break;
		}
	}
}
