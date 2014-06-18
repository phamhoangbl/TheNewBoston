package com.example.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyGraphic extends View {

	Bitmap ball;
	int changeY = 0;
	int changeX = 0;
	public MyGraphic(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//scale bitmap
		Bitmap scaleBitmap = ball.createScaledBitmap(ball, 70, 70, true);
		
		canvas.drawColor(Color.CYAN);
		//canvas.drawBitmap(scaleBitmap, canvas.getWidth()/2, changeY, null);
		canvas.drawBitmap(scaleBitmap, changeX, changeY, null);
		canvas.drawBitmap(scaleBitmap, changeY, changeX, null);
		
		if(changeY < canvas.getHeight()){
			changeY += 50;
			changeX += 25;
		}		
		else{
			changeY = 0;
			changeX = 0;
		}
		
		//draw Rect
		Rect rect = new Rect();
		rect.set(0, 400, canvas.getWidth(), 550);
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		canvas.drawRect(rect, paint);
		
		invalidate();
	}
}
