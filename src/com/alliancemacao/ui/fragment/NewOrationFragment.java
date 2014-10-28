package com.alliancemacao.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alliancemacao.R;

/**
 * 最新资讯首页
 * @author zhongzhenhua
 *
 */
public class NewOrationFragment extends Fragment
{
	Handler handler;

	ImageButton here_btn = null;
	ImageView advertisementImgView = null;
	
    private final static int RETURN_INFORMATION = 1;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{	
		View rootView =  inflater.inflate(R.layout.activity_new_oration, container, false);
			
		initTitle(rootView);
		initHandler();
		
		here_btn = (ImageButton) rootView.findViewById(R.id.here_btn);
	    advertisementImgView =  (ImageView) rootView.findViewById(R.id.home_advertisement_img);

		initHereBtn(rootView);
		
		return rootView;
	}
	
	private void initTitle(View view)
	{
		TextView title = (TextView) view.findViewById(R.id.main_title_text);
		title.setText("最新资讯");
	}

	
	//初始化here_btn
	private void initHereBtn(View view)
	{
		if(here_btn != null)
		{
			here_btn.setOnClickListener(new OnClickListener()
			{
				public void onClick(View arg0) 
				{
					   Message message = new Message();
                       message.what = NewOrationFragment.RETURN_INFORMATION;
                       handler.sendMessage(message);
				}
			});
		}	
	}
	
	//初始化handler
	private void initHandler()
	{
		handler = new Handler()
		{
			 public void handleMessage(Message msg)
              {
				 switch (msg.what)
	             {	
	             	case NewOrationFragment.RETURN_INFORMATION:
	             		FragmentManager fm =	NewOrationFragment.this.getActivity().getSupportFragmentManager();
						FragmentTransaction ft = fm.beginTransaction();
						ft.add(R.id.realtabcontent,new NewOration1Fragment(), "newOrationFragment");	
						ft.remove(NewOrationFragment.this);
						ft.commit();	
	             		break;
	             }
              }
		};
	}
}
