package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.*;
import android.widget.*;

public class SimpleBrowser extends Activity implements OnClickListener {

	WebView webView;
	Button btGo, btBack, btForward, btRefesh, btClearHistory; 
	EditText etUrlAddress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		initialize();
	}

	private void initialize() {
		btGo = (Button) findViewById(R.id.btGo);
		btBack = (Button) findViewById(R.id.btBack);
		btForward = (Button) findViewById(R.id.btForward);
		btRefesh = (Button) findViewById(R.id.btRefesh);
		btClearHistory = (Button) findViewById(R.id.btClearHistory);
		etUrlAddress = (EditText) findViewById(R.id.etUrlAddress);
		
		btGo.setOnClickListener(this);
		btBack.setOnClickListener(this);
		btForward.setOnClickListener(this);
		btRefesh.setOnClickListener(this);
		btClearHistory.setOnClickListener(this);
		webView = (WebView) findViewById(R.id.wvBrowser);
		//WebView settings
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		
		//call directly the URL 
		webView.setWebViewClient(new CustomViewClient());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btGo:
			String address = etUrlAddress.getText().toString();
			webView.loadUrl(address);
			break;
		case R.id.btBack:
			if(webView.canGoBack()){
				webView.goBack();
			}
			break;
		case R.id.btForward:
			if(webView.canGoForward()){
				webView.goForward();
			}
			break;
		case R.id.btRefesh:
			webView.reload();
			break;
		case R.id.btClearHistory:
			webView.clearHistory();
			break;
		default:
			break;
		}
	}
	
	
}
