package com.example.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyGraphicSurface extends SurfaceView implements Runnable {

	float x, y;
	Typeface font;
	SurfaceHolder holder;
	Thread ourThread = null;
	boolean isRunning = false;
	
	public MyGraphicSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		holder = getHolder();
		font = Typeface.createFromAsset(context.getAssets(), "contrast.ttf");
	}
	
	public void SetXY(float a, float b){
		x = a;
		y = b;
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
				Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
				Bitmap scaleBitmap = test.createScaledBitmap(test, 70, 70, true);
				canvas.drawBitmap(scaleBitmap, x - 35, y - 35, null);
			}
			else {
				Paint paintText = new Paint();
				paintText.setARGB(200,  200,  200,  200);
				paintText.setTextSize(50);
				paintText.setTextAlign(Align.CENTER);
				paintText.setTypeface(font);
				
				canvas.drawText("Click thu xem", canvas.getWidth()/2, 200, paintText);
			}
			holder.unlockCanvasAndPost(canvas);
		}
		
	}
}
