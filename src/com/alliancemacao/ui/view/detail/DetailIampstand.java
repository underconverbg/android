package com.alliancemacao.ui.view.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

public class DetailIampstand extends LinearLayout
{

	public DetailIampstand(Context context, AttributeSet attrs)
	{
		super(context);
		   LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	        inflater.inflate(R.layout.view_detail_lam, this);  
	}
}
