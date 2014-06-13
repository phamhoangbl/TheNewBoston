package com.example.thenewboston;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Camera extends Activity implements View.OnClickListener {
	ImageView iv;
	ImageButton ib;
	Button b;
	final static int cameraData = 0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		Initialize();
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
	}
	
	private void Initialize()
	{
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		b = (Button) findViewById(R.id.bSetWall);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.ibTakePic:
				Intent pic = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(pic, cameraData);
				break;
			case R.id.bSetWall:
				try {
					getApplicationContext().setWallpaper(bmp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle extra = data.getExtras();
			bmp = (Bitmap) extra.get("data");
			iv.setImageBitmap(bmp);
		}
	}
}
