package com.alliancemacao.ui.activity.personal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alliancemacao.ui.view.dialog.PhotographDialog;
import com.alliancemacao.ui.view.dialog.PhotographDialogCallBack;
import com.alliancemacao.ui.view.headphoto.CircularImage;
import com.example.alliancemacao.R;

public class PersonalInformationActivity extends Activity
{
	LinearLayout  ageBtn = null;
	LinearLayout  nikeNameBtn = null;
	CircularImage headImage = null;
	LinearLayout  modifyPwdBtn = null;
	LinearLayout pushSetBtn = null;

	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persional_infor);
		initTitle();
		
		nikeNameBtn = (LinearLayout)findViewById(R.id.personal_nikename_btn);
		ageBtn = (LinearLayout) findViewById(R.id.personal_age_btn);
		headImage = (CircularImage) findViewById(R.id.cover_user_photo);
		modifyPwdBtn = (LinearLayout) findViewById(R.id.modify_pwd_btn);
		pushSetBtn = (LinearLayout) findViewById(R.id.push_set_btn);
		
		nikeNameBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent initent = new Intent();
				initent.setClass(PersonalInformationActivity.this, PersonalNickNameActivity.class);
				startActivity(initent);				
			}
		});
		
		ageBtn.setOnClickListener(new OnClickListener() 
		{			
			public void onClick(View v)
			{
				Intent initent = new Intent();
				initent.setClass(PersonalInformationActivity.this, PersonalAgeActivity.class);
				startActivity(initent);
			}
		});
		
		headImage.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				  Dialog dialog1 = new PhotographDialog(PersonalInformationActivity.this,
						  R.style.DownLoadDocumentDialogRule,new PhotographDialogCallBack() {
							
							@Override
							public void takePhotoFromCamera() 
							{
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void takePhotoFromAlbum() 
							{
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void cancel()
							{
								// TODO Auto-generated method stub
								
							}
						});
			      dialog1.show();
				    
				  Window dialogWindow = dialog1.getWindow();
			      WindowManager.LayoutParams lp = dialogWindow.getAttributes();
			      dialogWindow.setGravity(Gravity.BOTTOM);	
		          WindowManager wm = PersonalInformationActivity.this.getWindowManager();
		          lp.width  = wm.getDefaultDisplay().getWidth();
		          dialogWindow.setAttributes(lp);	
		          
			}  
		});
		
		
		modifyPwdBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				Intent intent = new Intent();
				intent.setClass(PersonalInformationActivity.this, PersonalModifyPassWordActivity.class);
				startActivity(intent);
			}
		});
		
		
		pushSetBtn.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(PersonalInformationActivity.this, PersonalPushSetActivity.class);
				startActivity(intent);
			}
		});
		
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
