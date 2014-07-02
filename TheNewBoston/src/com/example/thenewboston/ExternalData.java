package com.example.thenewboston;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener {

	TextView tvCanWrite, tvCanRead;
	String state;
	boolean canR, canW;
	Spinner spinner1;
	String[] paths = {"Music", "Picture", "DownLoad"};
	File path = null;
	EditText etSaveAs;
	Button btSave, btConfirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		initialize();
		
		state = Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			tvCanWrite.setText("true");
			tvCanRead.setText("true");
			canW = canR = true;
		}
		else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			tvCanWrite.setText("falseeee");
			tvCanRead.setText("true");
			canW = false;
			canR = true;
		}
		else {
			tvCanWrite.setText("falseeee");
			tvCanRead.setText("falseeee");
			canW = canR = false;
		}
	}

	private void initialize() {
		// TODO Auto-generated method stub
		tvCanWrite = (TextView) findViewById(R.id.tvCanWrite);
		tvCanRead = (TextView) findViewById(R.id.tvCanRead);
		tvCanWrite.setText("false");
		tvCanRead.setText("false");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setAdapter(adapter);
		spinner1.setOnItemSelectedListener(this);
		
		btConfirm = (Button) findViewById(R.id.btConfirm);
		btSave = (Button) findViewById(R.id.btSave);
		etSaveAs = (EditText) findViewById(R.id.etSaveAs);
		btConfirm.setOnClickListener(this);
		btSave.setOnClickListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = spinner1.getSelectedItemPosition();
		switch (pos) {
		case 0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btSave:
			String fileName = etSaveAs.getText().toString();
			File file = new File(path, fileName);
			if(canR == canW == true){
				
				//create parents if missing them.
				path.mkdirs();
				
				try {
					
				InputStream is = getResources().openRawResource(R.drawable.ball);
				OutputStream os = new FileOutputStream(file);
				byte[] data = new byte[is.available()];
				is.read(data);
				os.write(data);
				is.close();
				os.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Toast t = Toast.makeText(ExternalData.this, "File has been created", Toast.LENGTH_LONG);
				t.show();
			}
			
			break;
		case R.id.btConfirm:
			btSave.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
	}
	
	
}
