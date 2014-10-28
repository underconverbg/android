package com.example.alliancemacao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.alliancemacao.ui.view.CustomDialog;

public class RegisterActivity extends Activity 
{
	Button registerBtn = null;
	private CustomDialog.Builder ibuilder;

	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		
	}

}
