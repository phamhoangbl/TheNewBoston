package com.example.thenewboston;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SoundStuff extends Activity implements OnClickListener{

	SoundPool sP;
	int explosion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		View v = new View(this);
		v.setOnClickListener(this);
		setContentView(v);
		sP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = sP.load(this, R.raw.click_sound, 0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		sP.play(explosion, 1 , 1, 0, 0, 1);
	}

}
