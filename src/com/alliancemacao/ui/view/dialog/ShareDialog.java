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
public class ShareDialog extends Dialog
{
    Context context;
    ShareDialogCallBack myCallBack;
    Handler handler;

    LinearLayout shareFaceBook  = null;
    LinearLayout shareWhatsApp = null;
    LinearLayout shareWechat = null;
    LinearLayout cancel = null;
    
    public static final int CHANGE_BG = 1;

	public ShareDialog(Context context) 
	{
		super(context);
        this.context = context;

	}
		
    public ShareDialog(Context context, int theme,ShareDialogCallBack callBack)
    {
        super(context, theme);
        this.context = context;
        myCallBack = callBack;
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_share);
        
         shareFaceBook = (LinearLayout) findViewById(R.id.share_face_book_layout);
         shareWhatsApp = (LinearLayout) findViewById(R.id.share_what_app_layout);
         shareWechat = (LinearLayout) findViewById(R.id.share_whechat_layout);
         cancel = (LinearLayout) findViewById(R.id.share_cencel_layout);
        
        if (myCallBack != null)
        {
        	shareFaceBook.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	shareFaceBook.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));

                	myCallBack.shareToFackBook();
                }
        	});
        	
        	shareWhatsApp.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	shareWhatsApp.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));

                	myCallBack.shareToWhatsApp();

                }
        	});
        	
        	shareWechat.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	shareWechat.setBackground(context.getResources().getDrawable(R.color.lightGrayColor));
               
                	myCallBack.shareToWeChat();

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
