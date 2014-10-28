package com.alliancemacao.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.alliancemacao.ui.activity.search.SearchResultActivity;
import com.alliancemacao.ui.view.search.SearchMainListViewAdapter;
import com.example.alliancemacao.R;

public class SearchFragment  extends Fragment
{
	public final static int SEARCH_EDIT_READY = 1;
	public final static int SEARCH_DISMISS = 2;

	 private ListView listView;   
	    private SearchMainListViewAdapter listViewAdapter; 
	    private List<Map<String, Object>> listItems;
	    
	    private String[] goodsNames = {"台湾", "泰国","美国", "日本", "法国", "英国"};   
	    private Integer[] imgeIn = {R.drawable.text_picture_01,R.drawable.text_picture_02};
	    private Integer[] logo = {R.drawable.left_logo_gzl,R.drawable.left_logo_zgkg};
	    
	
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		final View rootView = inflater.inflate(R.layout.activity_search_main, container, false);
		initTitle(rootView);

		listView =  (ListView) rootView.findViewById(R.id.search_information_list);
		
		listItems = getListItems();  
        listViewAdapter = new SearchMainListViewAdapter(rootView.getContext(), listItems); //创建适配器   		
		
        listView.setAdapter(listViewAdapter);

		return rootView;
	}
	
	 private List<Map<String, Object>> getListItems() 
	 {   
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < 2; i++) 
	        {   
	            Map<String, Object> map = new HashMap<String, Object>();    

	            map.put("add_title",i+"");    
	            
	            map.put("infor_image_i",imgeIn[i]);  
	            map.put("infor_image_ii",imgeIn[i]);     

	            map.put("introduction_i",goodsNames[i]); 
	            map.put("introduction_ii",goodsNames[i]);     

	            map.put("operator_i","2013.11.24"); 
	            map.put("operator_ii","2013.11.24"); 

	            map.put("price_i","20000"); 
	            map.put("price_ii","20000"); 

	            listItems.add(map);   
	        }      
	        return listItems;   
	 }   
	 
	
	private void initTitle(View rootView)
	{
		EditText searchEditText = (EditText) rootView.findViewById(R.id.search_title_edit_text);
		final Button searchCancel  = (Button) rootView.findViewById(R.id.search_title_cancel_btn);
		final ImageButton searchImgBtn  = (ImageButton) rootView.findViewById(R.id.search_img_btn);

		
		
		final Handler seacHandler = new Handler()
		{
			public void handleMessage(Message msg) 
			{
	            switch (msg.what)
	            {
	            	case SEARCH_EDIT_READY:
	            		searchCancel.setVisibility(View.VISIBLE);
					break;
	            	case SEARCH_DISMISS:
	            		searchCancel.setVisibility(View.INVISIBLE);
					break;
	            }
	            super.handleMessage(msg);
			}
		};
		
		searchEditText.setOnFocusChangeListener(new OnFocusChangeListener() 
		{
			
			@Override
			public void onFocusChange(View arg0, boolean arg1)
			{
				 Message message = new Message();
	             message.what = SEARCH_EDIT_READY;
	             seacHandler.sendMessage(message);
			}
		});
		
		searchImgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
//				 Message message = new Message();
//	             message.what = SEARCH_EDIT_READY;
//	             seacHandler.sendMessage(message);	
				Intent intent = new Intent();
				intent.setClass(arg0.getContext(), SearchResultActivity.class);
				startActivity(intent);
			}
		});
		
		searchCancel.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0)
			{
				 Message message = new Message();
	             message.what = SEARCH_DISMISS;
	             seacHandler.sendMessage(message);
			}
		});
	}
}
