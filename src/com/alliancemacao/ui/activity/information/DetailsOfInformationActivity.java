package com.alliancemacao.ui.activity.information;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alliancemacao.ui.fragment.JoinActivity;
import com.alliancemacao.ui.view.dialog.DownLoadDocumentDialog;
import com.alliancemacao.ui.view.dialog.DownLoadDocumentDialogCallBack;
import com.alliancemacao.ui.view.dialog.ShareDialog;
import com.alliancemacao.ui.view.dialog.ShareDialogCallBack;
import com.example.alliancemacao.R;

@SuppressLint("NewApi")
public class DetailsOfInformationActivity extends Activity
{
	
	private final static int FINISH = 1;
	private final static int SHARE = 2;
	private final static int DOWNLOADDOCUMENT = 3;
	protected static final int COLLECTION = 0;


	
	private WebView detaileView;
	
	private ImageButton zanBtn;
	private ImageButton share_btn;
	private ImageButton downfile_btn;
	private ImageButton join_btn;
    Handler handler;

	

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_oration_2);
		initTitle();
		initHandler();
		initWebView();
		share_btn = (ImageButton) findViewById(R.id.dynamic_share_btn);
		
		share_btn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				 Message message = new Message();
                 message.what = DetailsOfInformationActivity.SHARE;
                 handler.sendMessage(message);
			}
		});
		
		downfile_btn = (ImageButton) findViewById(R.id.downfile_btn);
		
		downfile_btn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0)
			{
				 Message message = new Message();
                 message.what = DetailsOfInformationActivity.DOWNLOADDOCUMENT;
                 handler.sendMessage(message);
			} 
		});
		
		join_btn = (ImageButton) findViewById(R.id.join_btn);
		
		join_btn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View view) 
			{
			 	Intent intent  = new Intent();
    		 	intent.setClass(view.getContext(), JoinActivity.class);
    		 	startActivity(intent);			
    		}
		});
	}

	
	private void initWebView()
	{
		detaileView = (WebView) findViewById(R.id.detailed_infor_view); 
		detaileView.getSettings().setJavaScriptEnabled(true); 
		detaileView.loadUrl("http://www.baidu.com/"); 
        detaileView.setWebViewClient(new WebViewClient()
        {
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url)
        	{
        		view.loadUrl(url);
				return true;
        	}
        	
        });
	}

	private void initTitle()
	{
		TextView title = (TextView) findViewById(R.id.main_title_text);
		Button button = (Button)findViewById(R.id.main_title_left);
		title.setText("详情");
		button.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				  Message message = new Message();
                  message.what = DetailsOfInformationActivity.FINISH;
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
				 	case DetailsOfInformationActivity.FINISH:
				 		DetailsOfInformationActivity.this.finish();
	             		break;
	             
				 	case DetailsOfInformationActivity.SHARE:
				 		  Dialog dialog1 = new ShareDialog(DetailsOfInformationActivity.this,
			                        R.style.DownLoadDocumentDialogRule,new ShareDialogCallBack() 
				 		  {
				 			  			public void shareToWhatsApp()
				 			  			{
				 			  				
										}
										
										public void shareToWeChat() 
										{
										
										}
										
										public void shareToFackBook()
										{
										
										}
										
										public void cancel() 
										{
										
										}
									});
					      dialog1.show();
						    
						  Window dialogWindow = dialog1.getWindow();
					      WindowManager.LayoutParams lp = dialogWindow.getAttributes();
					      dialogWindow.setGravity(Gravity.BOTTOM);	
				          WindowManager wm = DetailsOfInformationActivity.this.getWindowManager();
				          lp.width  = wm.getDefaultDisplay().getWidth();
				          dialogWindow.setAttributes(lp);		             		
				          break;
	             		
				 	case DetailsOfInformationActivity.DOWNLOADDOCUMENT:
				 		  Dialog dialog2 = new DownLoadDocumentDialog(DetailsOfInformationActivity.this,
			                        R.style.DownLoadDocumentDialogRule,new DownLoadDocumentDialogCallBack() {
										
										public void onClickTravelStandard() 
										{
											
										}
										
										public void onClickTourPrice()
										{
											
										}
										
										public void onClickSpecialAgreement() 
										{
											
										}
										
										public void onClickCancel() 
										{
											
										}
									});
					      dialog2.show();
						    
						  Window dialogWindow2 = dialog2.getWindow();
					      WindowManager.LayoutParams lp2 = dialogWindow2.getAttributes();
					      dialogWindow2.setGravity(Gravity.BOTTOM);	
				          WindowManager wm2 = DetailsOfInformationActivity.this.getWindowManager();
				          lp2.width  = wm2.getDefaultDisplay().getWidth();
				          dialogWindow2.setAttributes(lp2);	             	
				          break;
				          				    
	             }
	         }
		};
	}
}
