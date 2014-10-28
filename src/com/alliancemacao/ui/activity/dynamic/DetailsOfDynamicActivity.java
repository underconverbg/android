package com.alliancemacao.ui.activity.dynamic;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
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

import com.alliancemacao.ui.view.dialog.DownLoadDocumentDialog;
import com.alliancemacao.ui.view.dialog.DownLoadDocumentDialogCallBack;
import com.alliancemacao.ui.view.dialog.ShareDialog;
import com.alliancemacao.ui.view.dialog.ShareDialogCallBack;
import com.example.alliancemacao.R;


@SuppressLint("HandlerLeak")
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class DetailsOfDynamicActivity extends Activity  
{
	private final static int FINISH = 1;
	protected static final int DOWNLOADDOCUMENT = 2;
	protected static final int SHARE = 3;
	protected static final int ZAN = 4;
	protected static final int COLLECTION = 0;

	private WebView detaileView;
	
	private ImageButton zanBtn;
	private ImageButton shareBtn;
	private ImageButton collectionBtn;
	private ImageButton downLoadBtn;

    Handler handler;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_details);
		initTitle();
		initHandler();
		initWebView();
		
		zanBtn = (ImageButton) findViewById(R.id.details_dynamic_zan_btn);
		zanBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				 Message message = new Message();
                 message.what = DetailsOfDynamicActivity.ZAN;
                 handler.sendMessage(message);
			}
		});
		
		collectionBtn = (ImageButton) findViewById(R.id.details_collection_btn);
		collectionBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				 Message message = new Message();
                 message.what = DetailsOfDynamicActivity.COLLECTION;
                 handler.sendMessage(message);
			}
		});
		
		shareBtn = (ImageButton) findViewById(R.id.details_dynamic_share_btn);
		shareBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				 Message message = new Message();
                 message.what = DetailsOfDynamicActivity.SHARE;
                 handler.sendMessage(message);
			}
		});
		
		
		downLoadBtn = (ImageButton) findViewById(R.id.details_dynamic_load_file_btn);
		downLoadBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) 
			{
				 Message message = new Message();
                 message.what = DetailsOfDynamicActivity.DOWNLOADDOCUMENT;
                 handler.sendMessage(message);
			}
		});
		
	}

	
	private void initWebView()
	{
		detaileView = (WebView) findViewById(R.id.detailed_dynamic_view); 
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
                  message.what = DetailsOfDynamicActivity.FINISH;
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
				 	case DetailsOfDynamicActivity.FINISH:
				 		DetailsOfDynamicActivity.this.finish();
	             		break;
	             
				 	case DetailsOfDynamicActivity.SHARE:
				 		  Dialog dialog1 = new ShareDialog(DetailsOfDynamicActivity.this,
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
				          WindowManager wm = DetailsOfDynamicActivity.this.getWindowManager();
				          lp.width  = wm.getDefaultDisplay().getWidth();
				          dialogWindow.setAttributes(lp);		             		
				          break;
	             		
				 	case DetailsOfDynamicActivity.DOWNLOADDOCUMENT:
				 		  Dialog dialog2 = new DownLoadDocumentDialog(DetailsOfDynamicActivity.this,
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
				          WindowManager wm2 = DetailsOfDynamicActivity.this.getWindowManager();
				          lp2.width  = wm2.getDefaultDisplay().getWidth();
				          dialogWindow2.setAttributes(lp2);	             	
				          break;
				          				    
	             }
	         }
		};
	}
}