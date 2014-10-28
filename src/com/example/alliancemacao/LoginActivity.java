package com.example.alliancemacao;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	TextView titleView = null;
	Button registerBtn = null;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		titleView = (TextView) findViewById(R.id.main_title_text);
		titleView.setText("登录");
		
		registerBtn = (Button) findViewById(R.id.register_btn);
		registerBtn.setOnClickListener(new OnClickListener() 
		{	
			@Override
			public void onClick(View v) 
			{
                Intent intent = new Intent();  
                intent.setClass(LoginActivity.this, RegisterActivity.class);  
                startActivity(intent);
			}
		});
	}


	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_login,
					container, false);
			return rootView;
		}
	}

}
