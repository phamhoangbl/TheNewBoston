package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int counter;
	Button bAdd, bSub;
	TextView tvDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		counter =0;
		bAdd = (Button) findViewById(R.id.bAdd);
		bSub = (Button) findViewById(R.id.bSub);
		
		tvDisplay = (TextView) findViewById(R.id.tvDisplay);
		bAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter++;
				tvDisplay.setText("Your total is " + counter);
			}
		});
		
		bSub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter--;
				tvDisplay.setText("Your total is " + counter);
			}
		});
	}
}
