package com.example.thenewboston;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SharedPrefs extends Activity implements OnClickListener {

	Button btLoad, btSave;
	EditText etSave;
	TextView tvLoad;
	public static String fileName = "MySharedPreference";
	SharedPreferences sharedData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		Initialize();
		
		sharedData = getSharedPreferences(fileName, 0);
	}
	
	private void Initialize() {
		// TODO Auto-generated method stub
		btLoad = (Button) findViewById(R.id.btLoad);
		btSave = (Button) findViewById(R.id.btSave);
		etSave = (EditText) findViewById(R.id.etSave);
		tvLoad = (TextView) findViewById(R.id.tvLoad);
		btLoad.setOnClickListener(this);
		btSave.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btSave:
			String loadData = etSave.getText().toString();
			SharedPreferences.Editor editor = sharedData.edit();
			editor.putString("sharedString", loadData);
			editor.commit();
			break;
		case R.id.btLoad:
			//sharedData = getSharedPreferences(fileName, 0);
			String result = sharedData.getString("sharedString", "Could not get data");
			tvLoad.setText(result);
			break;
		default:
			break;
		}
	}
}
