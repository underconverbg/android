package com.alliancemacao.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.activity.personal.PersonalAttentionActivity;
import com.alliancemacao.ui.activity.personal.PersonalCollectionActivity;
import com.alliancemacao.ui.activity.personal.PersonalInformationActivity;
import com.alliancemacao.ui.activity.personal.PersonalRegistrationDetails;
import com.alliancemacao.ui.view.personalcenter.PersonalCenterRegistrationRecordListViewAdapter;
import com.example.alliancemacao.R;

public class PersonalFragment extends Fragment{
	
	//收藏按钮
	private Button collectionBtn;
	
	//关注按钮
	private Button attentionBtn;
	
	private LinearLayout registrationRecordLayout;

	
    private ListView registrationListv;   
    private PersonalCenterRegistrationRecordListViewAdapter registrationListAdapter; 
    private List<Map<String, Object>> registrationListItem;

    private String[] goodsNames = {"台湾", "泰国",    
            "美国", "日本", "法国", "英国"};   
	
    
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		final View view =  inflater.inflate(R.layout.activity_personal_main, container, false);
		initTitle(view);
		
		collectionBtn = (Button) view.findViewById(R.id.personal_collection_btn);
		attentionBtn = (Button) view.findViewById(R.id.personal_attention_btn);
		
		registrationRecordLayout = (LinearLayout) view.findViewById(R.id.registration_record_layout);
		
		collectionBtn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(view.getContext(), PersonalCollectionActivity.class);
				startActivity(intent);
			}
		});
		
		attentionBtn.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(view.getContext(), PersonalAttentionActivity.class);
				startActivity(intent);
			}
		});
		
		registrationRecordLayout.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				Intent intent = new Intent();
				intent.setClass(view.getContext(), PersonalRegistrationDetails.class);
				startActivity(intent);
			}
		});
		
		registrationListv =  (ListView) view.findViewById(R.id.person_center_registration_listv);
		registrationListItem = getRegitrationListItemItems();   
		registrationListAdapter = new PersonalCenterRegistrationRecordListViewAdapter(view.getContext(), registrationListItem); //创建适配器   
	
		registrationListv.setOnItemClickListener(new OnItemClickListener()
        {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3)
			{
					Intent intent = new Intent();
					intent.setClass(view.getContext(), PersonalRegistrationDetails.class);
					startActivity(intent);
				}
			});
		
		registrationListv.setAdapter(registrationListAdapter);

		return view;

	}
	
	private List<Map<String, Object>> getRegitrationListItemItems() 
	{
		   List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < 2; i++) 
	        {   
	            Map<String, Object> map = new HashMap<String, Object>();    
	            map.put("registration_record_main",goodsNames[i]);     
	            listItems.add(map);   
	        }      
	        return listItems; 
	}

	@SuppressLint("NewApi")
	private void initTitle(final View view)
	{
		TextView title = (TextView) view.findViewById(R.id.main_title_text);
		title.setText("个人中心");
		
		Button rightBtn = (Button) view.findViewById(R.id.main_title_right);
		rightBtn.setBackground(view.getResources().getDrawable(R.drawable.set_gear));
		rightBtn.setOnClickListener(new OnClickListener()
		{	
			public void onClick(View arg0) 
			{
				Intent intent = new Intent();
				intent.setClass(view.getContext(), PersonalInformationActivity.class);
				startActivity(intent);
			}
		});
	}
}
