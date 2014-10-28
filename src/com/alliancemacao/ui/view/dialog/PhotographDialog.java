package com.alliancemacao.ui.view.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class PhotographDialog extends Dialog
{
    Context context;
    PhotographDialogCallBack myCallBack;
    Handler handler;

    LinearLayout album  = null;
    LinearLayout takePhoto = null;
    LinearLayout cancel = null;
    
    public static final int CHANGE_BG = 1;

	public PhotographDialog(Context context) 
	{
		super(context);
        this.context = context;

	}
		
    public PhotographDialog(Context context, int theme,PhotographDialogCallBack callBack)
    {
        super(context, theme);
        this.context = context;
        myCallBack = callBack;
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_photograph);
        
         album = (LinearLayout) findViewById(R.id.from_album_layout);
         takePhoto = (LinearLayout) findViewById(R.id.take_photo_layout);
         cancel = (LinearLayout) findViewById(R.id.share_cencel_layout);
        
        if (myCallBack != null)
        {
        	album.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	album.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));

                	myCallBack.takePhotoFromAlbum();
                }
        	});
        	
        	takePhoto.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	takePhoto.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));

                	myCallBack.takePhotoFromCamera();

                }
        	});
        	
        	cancel.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	cancel.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));
                	myCallBack.cancel();
                	dismiss();
                }
        	});
		}
    }

 
}
