package com.example.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	private String[] _classes = { "MainActivity", "TextPlay", "Email", "Camera", "Data", "GFX", "GFXSurface"};  
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String menuSelected = _classes[position];
		try {
			Class menuClass = Class.forName("com.example.thenewboston." + menuSelected);
			Intent menuItemIntent = new Intent(Menu.this, menuClass);
			startActivity(menuItemIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1 , _classes));
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.aboutUs:
			Intent about = new Intent("com.example.thenewboston.AboutUs");
			startActivity(about);
			break;
		case R.id.refference:
			Intent prefs = new Intent("com.example.thenewboston.Prefs");
			startActivity(prefs);
			break;
		case R.id.exist:
			finish();
			break;
		}
		return false;
	}
	
	
}
