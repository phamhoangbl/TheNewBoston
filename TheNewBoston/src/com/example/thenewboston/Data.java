package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Data extends Activity implements View.OnClickListener {
	EditText sendET;
	Button saBT, safrBT;
	TextView gotTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}
	
	private void initialize() {
		sendET = (EditText) findViewById(R.id.etSend);
		saBT = (Button) findViewById(R.id.bSA);
		safrBT = (Button) findViewById(R.id.bSAFR);
		gotTv = (TextView) findViewById(R.id.tvGot);
		saBT.setOnClickListener(this);
		safrBT.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent b = new Intent(Data.this, OpenedClass.class);
			startActivityForResult(b, 0);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			String result = data.getExtras().getString("anwser");
			gotTv.setText(result);
		}
	}
	
}
