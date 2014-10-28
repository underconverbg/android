package com.alliancemacao.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.activity.information.DetailsOfInformationActivity;
import com.alliancemacao.ui.activity.operator.AboutOperator;
import com.alliancemacao.ui.view.informaction.ListViewAdapter;
import com.alliancemacao.ui.view.informaction.ListViewAdapterCallBack;
import com.example.alliancemacao.R;

/**
 * 广告页跳转进来
 * @author zhongzhenhua
 *
 */
public class NewOration1Fragment extends NewOrationFragment
{	
	protected static final int RETURN_DETAILSOFINFORMATION = 0;
	protected static final int RETURN_ABOUTOPERATOR = 1;
	//主要listView
    private ListView listView;   
    private ListViewAdapter listViewAdapter; 
    private List<Map<String, Object>> listItems;
    
    private String[] goodsNames = {"台湾", "泰国","美国", "日本", "法国", "英国"};   
    private Integer[] imgeIn = {R.drawable.text_picture_01,R.drawable.text_picture_02};
    private Integer[] logo = {R.drawable.left_logo_gzl,R.drawable.left_logo_zgkg};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		final View view =  inflater.inflate(R.layout.activity_new_oration_1, container, false);
		
		initTitle(view);
		initHandler(view);
		
		listView =  (ListView) view.findViewById(R.id.information_list);
		listItems = getListItems();   
        listViewAdapter = new ListViewAdapter(view.getContext(), listItems); //创建适配器   
      
        listViewAdapter.initListViewAdapterCallBack(new ListViewAdapterCallBack() 
        {
			
			@Override
			public void clickZan(int index)
			{
				
			}
			
			@Override
			public void clickOperators(int index) 
			{
				Message message = new Message();
                message.what = NewOration1Fragment.RETURN_ABOUTOPERATOR;
                handler.sendMessage(message);
			}
			
			@Override
			public void clickImage(int index)
			{
				
			}
			
			@Override
			public void clickCollect(int index)
			{
				
			}
			
			@Override
			public void clickAttention(int index) 
			{
				
			}

			@Override
			public void clickMainInfo(int index)
			{
				Message message = new Message();
                message.what = NewOration1Fragment.RETURN_DETAILSOFINFORMATION;
                handler.sendMessage(message);
			}
		});	
      
        listView.setAdapter(listViewAdapter);

		return view;	
	}
	
	 private List<Map<String, Object>> getListItems() 
	 {   
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < 2; i++) 
	        {   
	            Map<String, Object> map = new HashMap<String, Object>();    
	            map.put("infor_image",imgeIn[i]);     
	            map.put("info_title",goodsNames[i]);     
	            map.put("go_off_text","2013.11.24");   
	            map.put("infor_price_text",i+"");
	            map.put("infor_agent_image","");   
	            map.put("infor_agent_image",logo[i]);     
	            map.put("infor_see_sum_text",i+""); 
	            listItems.add(map);   
	        }      
	        return listItems;   
	    }   
	 
		
		private void initTitle(View view)
		{
			TextView title = (TextView) view.findViewById(R.id.main_title_text);
			title.setText("资讯");
		}
	
		//初始化handler
		private void initHandler(final View view)
		{
			handler = new Handler()
			{
				 public void handleMessage(Message msg)
	              {
					 switch (msg.what)
		             {	
		             	case NewOration1Fragment.RETURN_DETAILSOFINFORMATION:
		             		Intent intent = new Intent();  
		 	                intent.setClass(view.getContext(), DetailsOfInformationActivity.class);  
		 	                startActivity(intent); 
		             		break;
		             	
		             	case NewOration1Fragment.RETURN_ABOUTOPERATOR:
		             		Intent intent2 = new Intent();
		    				intent2.setClass(view.getContext(), AboutOperator.class);
		    				startActivity(intent2);
		             		break;	
		             }
	              }
			};
		}
}	

