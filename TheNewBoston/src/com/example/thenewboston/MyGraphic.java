package com.example.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;
import android.view.View;

public class MyGraphic extends View {

	Bitmap ball;

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
		canvas.drawBitmap(scaleBitmap, canvas.getWidth()/2, 0, null);
	}

	
}
