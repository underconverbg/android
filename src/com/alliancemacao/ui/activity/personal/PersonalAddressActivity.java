package com.alliancemacao.ui.activity.personal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class PersonalAddressActivity extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_address);
		initTitle();
	}
	
	private void initTitle()
	{
		TextView title = (TextView) findViewById(R.id.main_title_text);
		title.setText("个人信息");
		Button button = (Button)findViewById(R.id.main_title_left);
		button.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0)
			{
		        finish();
			}
		});		
	}
}
