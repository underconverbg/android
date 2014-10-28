package com.alliancemacao.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.alliancemacao.R;

/**
 * 欢迎页面
 * @author zhongzhenhua
 *
 */
public class WelComeAtivity extends Activity  
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wel_come_ativity);
		initApp();
	}

	
	//初始化app工作
	private void initApp()
	{
		new Thread(new Runnable() 
		{
			public void run() 
			{
				try
				{
					Thread.sleep(3000);
					Intent intent = new Intent();  
	                intent.setClass(WelComeAtivity.this, HomeActivity.class);  
	                startActivity(intent);  
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
}
