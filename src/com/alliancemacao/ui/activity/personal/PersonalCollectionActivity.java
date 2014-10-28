package com.alliancemacao.ui.activity.personal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.activity.dynamic.DetailsOfDynamicActivity;
import com.alliancemacao.ui.activity.information.DetailsOfInformationActivity;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionDynamicListViewAdapter;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionInformationListViewAdapter;
import com.example.alliancemacao.R;

@SuppressLint("NewApi")
public class PersonalCollectionActivity extends Activity {
	
	private ViewPager viewPager;
	private ViewPagerAdapter viewPageAdapter;
	private ArrayList<View> pageViews;
	private Button button01;
	private Button button02;
    Handler handler;
    View page01 = null;
    View page02 = null;

	//handle指令
	private final static int PAGE_1 = 1;
	private final static int PAGE_2 = 2;
 	private final static int BTN_1 = 3;
    private final static int BTN_2 = 4;
    private final static int RETURN_TO_INFOR_DETAILS = 5;
	private final static int RETURN_TO_DYNAMIC_DETAILS = 6;
	
	//资讯部分
	private ListView informationListView;   
    private PersonalCollectionInformationListViewAdapter informationListViewAdapter; 
    private List<Map<String, Object>> informationItem;
	
	//动态部分
	private ListView dynamicListView;
    private PersonalCollectionDynamicListViewAdapter dynamicListViewAdapter; 
    private List<Map<String, Object>> dynamicListItem;
	
	//测试数据
	 private Integer[] imgeIn = {R.drawable.text_picture_01,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02};
	 private String[] goodsNames = {"台湾", "泰国",    
	            "美国", "日本", "法国", "英国"};   
	 private String[] optionNames = {"中旅湾", "夏旅",    
	            "美国", "日本", "北旅", "猪旅"}; 
	 
	 private String[] priceNames = {"1111", "2222",    
	            "3333", "4444", "55555", "6666"};  
	 
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_conllection);
	    LayoutInflater mInflater = getLayoutInflater();
	    initTitle();
	    
	     page01 = mInflater.inflate(R.layout.view_personal_collection,null);
		 page02 = mInflater.inflate(R.layout.view_personal_dynamic, null);
		
		pageViews = new ArrayList<View>();
		pageViews.add(page01);
		pageViews.add(page02);
		
		viewPageAdapter = new ViewPagerAdapter(pageViews);
		viewPager = (ViewPager)findViewById(R.id.personal_center_collection_view_page);
		viewPager.setAdapter(new ViewPagerAdapter(pageViews));
		viewPager.setAdapter(viewPageAdapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			public void onPageSelected(int arg0)
			{
				if (arg0 == 0)
				{
					   Message message = new Message();
                       message.what = PersonalCollectionActivity.PAGE_1;
                       handler.sendMessage(message);
				}
				else if (arg0 == 1)
				{
					   Message message = new Message();
                       message.what = PersonalCollectionActivity.PAGE_2;
                       handler.sendMessage(message);
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
		});
		
	    initControlButton(viewPager);
	    initInformationList();
	    initDynamicList();
		
		
	
	}
	
	private void initInformationList()
	{
		informationItem = getInformationListItems();   
		informationListView = (ListView) page01.findViewById(R.id.view_personal_collection_listv);
		informationListViewAdapter = new PersonalCollectionInformationListViewAdapter(this, informationItem); //创建适配器   
		informationListView.setAdapter(informationListViewAdapter);
		
		informationListView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				  Message message = new Message();
                  message.what = PersonalCollectionActivity.RETURN_TO_INFOR_DETAILS;
                  handler.sendMessage(message);
			}	
		});

	}

	private void initDynamicList()
	{
		dynamicListItem = getDynamicListItem();   
		dynamicListView = (ListView) page02.findViewById(R.id.view_personal_dynamic_listv);
		dynamicListViewAdapter = new PersonalCollectionDynamicListViewAdapter(this, dynamicListItem); //创建适配器   
		dynamicListView.setAdapter(dynamicListViewAdapter);

		
		dynamicListView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				  Message message = new Message();
                  message.what = PersonalCollectionActivity.RETURN_TO_DYNAMIC_DETAILS;
                  handler.sendMessage(message);
			}	
		});

	}
	

	class ViewPagerAdapter extends PagerAdapter
	{
		List<View> viewLists;

		public ViewPagerAdapter(List<View> lists) {
			viewLists = lists;
		}

		@Override
		public int getCount() { // 获得size
			// TODO Auto-generated method stub
			return viewLists.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View view, int position, Object object) // 销毁Item
		{
			((ViewPager) view).removeView(viewLists.get(position));
		}

		@Override
		public Object instantiateItem(View view, int position) // 实例化Item
		{
			((ViewPager) view).addView(viewLists.get(position), 0);

			return viewLists.get(position);
		}

	}
	
	
	 private List<Map<String, Object>> getInformationListItems() 
	 {   
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < 2; i++) 
	        {   
	            Map<String, Object> map = new HashMap<String, Object>(); 	
	            map.put("operator_infor_img",imgeIn[i]);     
	            map.put("operator_infor_introduction_text",goodsNames[i]);     
	            map.put("operator_infor_operator_text",optionNames[i]);   
	            map.put("operator_infor_price_text",priceNames[i]);
	            listItems.add(map);   
	        }      
	        return listItems;   
	    }   
	 
	 private List<Map<String, Object>> getDynamicListItem() 
	 {
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < 2; i++) 
	        {   	
	            Map<String, Object> map = new HashMap<String, Object>(); 	
	            map.put("operator_dynamic_img",imgeIn[i]);     
	            map.put("operator_dynamic_introduction",goodsNames[i]);     
	            map.put("operator_dynamic_operators",optionNames[i]);   
	            listItems.add(map);   
	        }      
	        return listItems; 
		}
	 
	private void initTitle()
	{
		TextView title = (TextView) this.findViewById(R.id.main_title_text);
		title.setText("收藏");
	}
	
	//控制按钮
	private void initControlButton(final ViewPager viewPager)
	{
		button01 = (Button) findViewById(R.id.dynamic_personal_strategy_btn);
		button02 = (Button) findViewById(R.id.dynamic_personal_dynamic_btn);
		
		handler = new Handler()
		{
			 public void handleMessage(Message msg)
              {
				 switch (msg.what)
	             {	
	             	case PersonalCollectionActivity.PAGE_1:
	             		usBtnChangeI(0);
	             		break;	
	                 
	               	case PersonalCollectionActivity.PAGE_2:
	             		usBtnChangeII(0);
		                 break;	
		                 
		                 
	            	case PersonalCollectionActivity.BTN_1:
	             		usBtnChangeI(1);
	             		break;	
	                 
	               	case PersonalCollectionActivity.BTN_2:
	             		usBtnChangeII(1);
		                 break;			              
		                 
	            	case PersonalCollectionActivity.RETURN_TO_INFOR_DETAILS:
	            		Intent intent = new Intent();
	    				intent.setClass(PersonalCollectionActivity.this,DetailsOfInformationActivity.class);
	    				startActivity(intent);
	            		break;
	            	
	            	case PersonalCollectionActivity.RETURN_TO_DYNAMIC_DETAILS:
	            		Intent intent2 = new Intent();
	            		intent2.setClass(PersonalCollectionActivity.this,DetailsOfDynamicActivity.class);
	    				startActivity(intent2);
	            		break;

	             }
	             super.handleMessage(msg);
              }
		};
		
		button01.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				   Message message = new Message();
                   message.what = PersonalCollectionActivity.BTN_1;
                   handler.sendMessage(message);
			}
		});
		
		button02.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Message message = new Message();
                message.what = PersonalCollectionActivity.BTN_2;
                handler.sendMessage(message);  				
             }
		});
	
	}
	
	private void usBtnChangeI(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(0);
		}
		button01.setBackground(PersonalCollectionActivity.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button02.setBackground(PersonalCollectionActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
	}
	
	private void usBtnChangeII(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(1);
		}
		button01.setBackground(PersonalCollectionActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(PersonalCollectionActivity.this.getResources().getDrawable(R.drawable.usbutton_green));
	}
}
