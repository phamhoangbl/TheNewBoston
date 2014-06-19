package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;

public class GFXSurface extends Activity {

	MyGraphicSurface graphic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		graphic = new MyGraphicSurface(this);
		setContentView(graphic);
	}
}
