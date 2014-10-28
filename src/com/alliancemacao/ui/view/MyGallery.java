package com.alliancemacao.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

@SuppressWarnings("deprecation")
public class MyGallery extends Gallery {

	public MyGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyGallery(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		boolean b = false;
		switch (arg0.getAction()) {
		case MotionEvent.ACTION_DOWN:
			b = false;
			break;
		case MotionEvent.ACTION_MOVE:
			b = true;
			break;
		case MotionEvent.ACTION_UP:
			b = false;
			break;
		}
		if (b)
			return true;
		return super.onTouchEvent(arg0);
	}
}
