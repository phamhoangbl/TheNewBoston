package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;

public class SimpleBrowser extends Activity {

	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		initialize();
	}

	private void initialize() {
		webView = (WebView) findViewById(R.id.wvBrowser);
		webView.loadUrl("http://www.google.com");
	}
	
}
