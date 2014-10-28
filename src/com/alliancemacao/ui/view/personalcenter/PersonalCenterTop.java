package com.alliancemacao.ui.view.personalcenter;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

public class PersonalCenterTop extends LinearLayout
{

	public PersonalCenterTop(Context context,AttributeSet attributeSet)
	{
		super(context, attributeSet);
		LayoutInflater.from(context).inflate(R.layout.view_personal_center_top, this);

	}
	
}
