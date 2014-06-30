package com.example.thenewboston;

import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity implements OnClickListener{

	TabHost tabHost;
	TabSpec tab1, tab2, tab3; 
	Button addTab, startWatch, stopWatch;
	long start, stop;
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup();
		
		tab1 = tabHost.newTabSpec("tabSpec1");
		tab1.setContent(R.id.tab1);
		tab1.setIndicator("Watch");
		tab2 = tabHost.newTabSpec("tabSpec2");
		tab2.setContent(R.id.tab2);
		tab2.setIndicator("Tab 2");
		tab3 = tabHost.newTabSpec("tabSpec3");
		tab3.setContent(R.id.tab3);
		tab3.setIndicator("Add a tab");
		
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);
		
		//buttons
		addTab = (Button) findViewById(R.id.btAddTab);
		startWatch = (Button) findViewById(R.id.btStartWatch);
		stopWatch = (Button) findViewById(R.id.btStopWatch);
		addTab.setOnClickListener(this);
		startWatch.setOnClickListener(this);
		stopWatch.setOnClickListener(this);
		start = 0;
		
		//TextView
		tvResult = (TextView) findViewById(R.id.tvResult);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btAddTab:
			TabSpec newTabSpec = tabHost.newTabSpec("tabSpecNew");
			newTabSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					TextView textView = new TextView(Tabs.this);
					textView.setText("Created a tab");
					return textView;
				}
			});
			
			newTabSpec.setIndicator("New Tab");
			tabHost.addTab(newTabSpec);
			break;
		case R.id.btStartWatch:
			start = System.currentTimeMillis();
			break;
		case R.id.btStopWatch:
			if(start != 0){
				stop = System.currentTimeMillis();
				long spam = stop - start;
				tvResult.setText(Long.toString(spam));
			}
			
			break;
		default:
			break;
		}
	}

}
