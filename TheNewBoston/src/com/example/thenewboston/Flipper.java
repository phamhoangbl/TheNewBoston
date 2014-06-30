package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener {
	
	ViewFlipper flipper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		initialize();
	}

	private void initialize() {
		flipper = (ViewFlipper) findViewById(R.id.flipper);
		flipper.setOnClickListener(this);
		
		//
		flipper.setFlipInterval(1000);
		flipper.startFlipping();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		flipper.showNext();
	}
	
}
