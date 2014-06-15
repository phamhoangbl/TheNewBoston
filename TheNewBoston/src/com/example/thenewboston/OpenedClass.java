package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class OpenedClass extends Activity implements View.OnClickListener, OnCheckedChangeListener {
	
	TextView tvQuestion, tvText;
	Button returnData;
	RadioGroup selectionList;
	String setData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		intialize();
//Comment it in this if Start Activity, Comment it out this if Start Activity For Result
//		Bundle basket = getIntent().getExtras();
//		String bread = basket.getString("key");
//		tvQuestion.setText(bread);
	}

	private void intialize() {
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		tvText = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnwser);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent result = new Intent();
		Bundle backball = new Bundle();
		backball.putString("anwser", setData);
		result.putExtras(backball);
		setResult(RESULT_OK, result);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.rbCrazy:
			setData = "Probably right";
			break;
		case R.id.rbSexy:
			setData = "Definitely right";	
			break;
		case R.id.rbAboth:
			setData = "Spot on!";
			break;
		}
		tvText.setText(setData);
	}

	
	
}
