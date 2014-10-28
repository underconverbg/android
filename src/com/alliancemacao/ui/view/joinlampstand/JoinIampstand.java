package com.alliancemacao.ui.view.joinlampstand;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

public class JoinIampstand  extends LinearLayout
{

	public JoinIampstand(Context context, AttributeSet attrs)
	{
		super(context);
		   LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	        inflater.inflate(R.layout.view_join_lam, this);  
	}

}
