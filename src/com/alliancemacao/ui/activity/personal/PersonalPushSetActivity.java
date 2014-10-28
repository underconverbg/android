package com.alliancemacao.ui.activity.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class PersonalPushSetActivity extends Activity
{
	Button setTimeBtn  = null;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pust_set);
		initTitle();
		setTimeBtn = (Button) findViewById(R.id.personal_put_set_time_btn);
		
		setTimeBtn.setOnClickListener(new OnClickListener() 
		{			
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(PersonalPushSetActivity.this, PersonalNoSoundActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
	private void initTitle()
	{
		TextView title = (TextView) findViewById(R.id.main_title_text);
		title.setText("个人信息");
	}
}
