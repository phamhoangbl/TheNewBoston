package com.example.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	private String[] _classes = { "MainActivity", "TextPlay", "Email", "Camera", "Data", "Example 1"};  
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
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1 , _classes));
	}
	
}
