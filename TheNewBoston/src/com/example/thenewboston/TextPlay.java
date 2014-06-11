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

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		final EditText etCommand = (EditText) findViewById(R.id.etCommand);
		Button btResult = (Button) findViewById(R.id.btResult);
		final ToggleButton tbPassword = (ToggleButton) findViewById(R.id.tbPassword);
		final TextView tvResult = (TextView) findViewById(R.id.tvResult);
		
		tbPassword.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tbPassword.isChecked()){
					etCommand.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
				else{
					etCommand.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		
		btResult.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
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
				}
			}
		});
	}
	
}
