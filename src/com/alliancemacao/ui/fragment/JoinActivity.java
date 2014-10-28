package com.alliancemacao.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.alliancemacao.R;



@SuppressLint("NewApi")
public class JoinActivity extends Activity
{
	private static final int FINISH = 0;
	
    Handler handler;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join);
	    initHandler();
	    initTitle();
	}
	
	private void initTitle()
	{
		TextView title = (TextView) findViewById(R.id.main_title_text);
		Button button = (Button)findViewById(R.id.main_title_left);
		title.setText("参加");
		button.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				  Message message = new Message();
                  message.what = JoinActivity.FINISH;
                  handler.sendMessage(message);
			}
		});
	}
	
	private void initHandler()
	{
		handler = new Handler()
		{
			 public void handleMessage(Message msg)
              {
				 switch (msg.what)
	             {
	            	case JoinActivity.FINISH:
	            		JoinActivity.this.finish();
	            		break;
	             }
	             super.handleMessage(msg);
              }
		};
	}
	
}
