package com.alliancemacao.ui.activity.personal;

import com.example.alliancemacao.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class PersonalRegistrationDetails extends Activity
{
	TextView name ;
	TextView tel ;
	TextView amount ;
	TextView time ;
	TextView memo ;
	TextView state ;
	Button cancelOrderBtn;


	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration_details);
		name =(TextView) findViewById(R.id.registration_details_name);
		tel =(TextView) findViewById(R.id.registration_details_tel);
		amount =(TextView) findViewById(R.id.registration_details_amount);
		time =(TextView) findViewById(R.id.registration_details_time);
		memo =(TextView) findViewById(R.id.registration_details_memo);
		state =(TextView) findViewById(R.id.registration_details_state);
		cancelOrderBtn = (Button) findViewById(R.id.registration_detail_cancel_order_btn);
		initTitle();
	}
	
	private void initTitle()
	{
		TextView title = (TextView) findViewById(R.id.main_title_text);
		title.setText("报名详情");
		Button button = (Button)findViewById(R.id.main_title_left);
		button.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
		button.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0)
			{
		        finish();
			}
		});
	}
}
