package com.alliancemacao.ui.view.headphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

public class MemberTop extends LinearLayout
{

	public MemberTop(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.view_member_top, this);
	}
	
}
