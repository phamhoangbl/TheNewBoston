package com.example.thenewboston;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskInternalData  extends Activity implements OnClickListener{

	Button btLoad, btSave;
	EditText etSave;
	TextView tvLoad;
	FileOutputStream fos;
	String FILENAME = "InternalString";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		Initialize();
	}

	private void Initialize() {
		// TODO Auto-generated method stub
		btLoad = (Button) findViewById(R.id.btLoad);
		btSave = (Button) findViewById(R.id.btSave);
		etSave = (EditText) findViewById(R.id.etSave);
		tvLoad = (TextView) findViewById(R.id.tvLoad);
		btLoad.setOnClickListener(this);
		btSave.setOnClickListener(this);
		
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btSave:
			String data = etSave.getText().toString();
			/*File f = new File(FILENAME);
			try {
				fos = new FileOutputStream(f);
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case R.id.btLoad:
			new LoadSomeStuff().execute(FILENAME);
			break;
		default:
			break;
		}
	}
	
	//Async task 
	public class LoadSomeStuff extends AsyncTask<String, Integer, String>{


		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			tvLoad.setText(result);
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String collected = null;
			FileInputStream fis = null;
			try {
				//params[0] = FILENAME
				 fis = openFileInput(params[0]);
				try {
					byte[] dataArray = new byte[fis.available()];
					while(fis.read(dataArray)!= -1){
						collected = new String(dataArray);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					fis.close();
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		
	}
}