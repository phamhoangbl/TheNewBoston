package com.example.thenewboston;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyGraphicSurface extends SurfaceView implements Runnable {

	SurfaceHolder holder;
	Thread ourThread = null;
	
	public MyGraphicSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		holder = getHolder();
		ourThread = new Thread(this);
		ourThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
