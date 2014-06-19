package com.example.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurfaceOneClass extends Activity implements OnTouchListener {

	float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaleX, scaleY;
	MyGraphicSurfaceOneClass graphic;
	Bitmap test, plus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = dY = aniX = aniY = scaleX = scaleY = 0;
		test = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		test = test.createScaledBitmap(test, 70, 70, true);
		
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);
		plus = plus.createScaledBitmap(plus, 70, 70, true);
		
		super.onCreate(savedInstanceState);
		graphic = new MyGraphicSurfaceOneClass(this);
		graphic.setOnTouchListener(this);
		setContentView(graphic);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				sX = event.getX();
				sY = event.getY();
				break;
			case MotionEvent.ACTION_UP:
				fX = event.getX();
				fY = event.getY();
				dX = fX - sX;
				dY = fY - sY;
				scaleX = dX/30;
				scaleY = dY/30;
				break;
			default:
				break;
		}
		//return true if wish hold on for drag
		return true;
		//return false;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		graphic.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		graphic.pause();
	}
	
	public class MyGraphicSurfaceOneClass extends SurfaceView implements Runnable {
		
		Typeface font;
		SurfaceHolder holder;
		Thread ourThread = null;
		boolean isRunning = false;
		
		public MyGraphicSurfaceOneClass(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			holder = getHolder();
			font = Typeface.createFromAsset(context.getAssets(), "contrast.ttf");
		}
		
		public void resume(){
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}
		
		public void pause(){
			isRunning = false;
			while(true){
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning){
				if(!holder.getSurface().isValid()){
					continue;
				}
				
				Canvas canvas = holder.lockCanvas();
				canvas.drawARGB(100,  100,  100,  100);
				
				if(x!=0 && y!=0){
					canvas.drawBitmap(test, x - 35, y - 35, null);
				}
				if(sX!=0 && sX!=0){
					canvas.drawBitmap(plus, sX - 35, sY - 35, null);
				}
				if(fX!=0 && fY!=0){
					canvas.drawBitmap(test, x - 35 - aniX, y - 35 - aniY, null);
					canvas.drawBitmap(plus, fX - 35, fY - 35, null);
				}
				else {
					Paint paintText = new Paint();
					paintText.setARGB(200,  200,  200,  200);
					paintText.setTextSize(50);
					paintText.setTextAlign(Align.CENTER);
					paintText.setTypeface(font);
					
					canvas.drawText("Click thu xem", canvas.getWidth()/2, 200, paintText);
				}
				aniX = aniX + scaleX;
				aniY = aniY + scaleY;
				
				holder.unlockCanvasAndPost(canvas);
			}
			
		}
	}
}
