package com.alliancemacao.ui.activity.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.activity.dynamic.DetailsOfDynamicActivity;
import com.alliancemacao.ui.activity.information.DetailsOfInformationActivity;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionDynamicListViewAdapter;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionInformationListViewAdapter;
import com.example.alliancemacao.R;

@SuppressLint("NewApi")
public class AboutOperator extends Activity
{
	 private ViewPager viewPager; 
	 private ViewPagerAdapter viewPageAdapter;
     private ArrayList<View> pageViews; 
     private Button button01; 
     private Button button02; 
     private Button button03; 
     Handler handler;

     private final static int PAGE_1 = 1;
     private final static int PAGE_2 = 2;
     private final static int PAGE_3 = 3;
     private final static int BTN_1 = 4;
     private final static int BTN_2 = 5;
     private final static int BTN_3 = 6;
     private final static int RETURN_TO_INFOR_DETAILS = 7;
     private final static int RETURN_TO_DYNAMIC_DETAILS = 8;
     private final static int TAKE_CALL = 9;


	View page01 = null;
	View page02 = null;
	View page03 = null;
	
	//商户介绍部分
	private LinearLayout telLinearLayout;
	
	//资讯部分
	private ListView informationListView;   
    private PersonalCollectionInformationListViewAdapter informationListViewAdapter; 
    private List<Map<String, Object>> informationItem;
     
 	//动态部分
 	private ListView dynamicListView;
    private PersonalCollectionDynamicListViewAdapter dynamicListViewAdapter; 
    private List<Map<String, Object>> dynamicListItem;
     
     
   //测试数据
   	 private Integer[] imgeIn = {R.drawable.text_picture_01,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02,R.drawable.text_picture_02};
   	 private String[] goodsNames = 
   		 {"台湾", "泰国",    
   	            "美国", "日本", "法国", "英国"};   
   	 private String[] optionNames =
   		 {"中旅湾", "夏旅",    
   	            "美国", "日本", "北旅", "猪旅"}; 
   	 
   	 private String[] priceNames = 
   		 {"1111", "2222",    
   	            "3333", "4444", "55555", "6666"}; 
   	 
   	 
     
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_operator);
		initTitle();

    	pageViews = new ArrayList<View>();
	    LayoutInflater mInflater = getLayoutInflater();

		 page01 = mInflater.inflate(R.layout.view_operator_introduce_list,
				null);
		 page02 = mInflater.inflate(R.layout.view_operator_information_list, null);
		 page03 = mInflater.inflate(R.layout.view_operator_dynamic, null);
		
		pageViews.add(page01);
		pageViews.add(page02);
		pageViews.add(page03);

		viewPageAdapter = new ViewPagerAdapter(pageViews);
		viewPager = (ViewPager) findViewById(R.id.about_operator_viewpage);
		viewPager.setAdapter(new ViewPagerAdapter(pageViews));
		viewPager.setAdapter(viewPageAdapter);	
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			public void onPageSelected(int arg0)
			{
				if (arg0 == 0)
				{
					   Message message = new Message();
                       message.what = AboutOperator.PAGE_1;
                       handler.sendMessage(message);
				}
				else if (arg0 == 1)
				{
					   Message message = new Message();
                       message.what = AboutOperator.PAGE_2;
                       handler.sendMessage(message);
				}
				else if (arg0 == 2)
				{
					   Message message = new Message();
                       message.what = AboutOperator.PAGE_3;
                       handler.sendMessage(message);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) 
			{

			}
			
			@Override
			public void onPageScrollStateChanged(int arg0)
			{
			}
		});
		
		initIntroduce(page01);
		initControlButton(viewPager);	
		initInformationList();
		initDynamicList();
    	
    }
    
    class ViewPagerAdapter extends PagerAdapter {
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

	
	private void initInformationList()
	{
		informationItem = getInformationListItems();   
		informationListView = (ListView) page02.findViewById(R.id.operator_information_list);
		informationListViewAdapter = new PersonalCollectionInformationListViewAdapter(this, informationItem); //创建适配器   
		informationListView.setAdapter(informationListViewAdapter);
		
		informationListView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				  Message message = new Message();
                  message.what = AboutOperator.RETURN_TO_INFOR_DETAILS;
                  handler.sendMessage(message);
			}	
		});

	}
	
	 private List<Map<String, Object>> getInformationListItems() 
	 {   
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < imgeIn.length; i++) 
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
	
	private void initDynamicList()
	{
		dynamicListItem = getDynamicListItem();   
		dynamicListView = (ListView) page03.findViewById(R.id.operator_dynamic_list);
		dynamicListViewAdapter = new PersonalCollectionDynamicListViewAdapter(this, dynamicListItem); //创建适配器   
		dynamicListView.setAdapter(dynamicListViewAdapter);
		
		dynamicListView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				  Message message = new Message();
                  message.what = AboutOperator.RETURN_TO_DYNAMIC_DETAILS;
                  handler.sendMessage(message);
			}	
		});

	}
	
	 private List<Map<String, Object>> getDynamicListItem() 
	 {
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < imgeIn.length; i++) 
	        {   	
	            Map<String, Object> map = new HashMap<String, Object>(); 	
	            map.put("operator_dynamic_img",imgeIn[i]);     
	            map.put("operator_dynamic_introduction",goodsNames[i]);     
	            map.put("operator_dynamic_operators",optionNames[i]);   
	            listItems.add(map);   
	        }      
	        return listItems; 
		}
	 
		@SuppressLint("NewApi")
		private void initTitle()
		{
			TextView title = (TextView) this.findViewById(R.id.main_title_text);
			title.setText("商户详情");
			
			Button leftBtn = (Button) findViewById(R.id.main_title_left);
			leftBtn.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
			leftBtn.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View arg0) 
				{
					AboutOperator.this.finish();
				}
			});
		} 
		
		private void initControlButton(final ViewPager viewPager)
		{
			button01 = (Button) findViewById(R.id.about_operator_bt1);
			button02 = (Button) findViewById(R.id.about_operator_bt2);
			button03 = (Button) findViewById(R.id.about_operator_bt3);
			
			handler = new Handler()
			{
				 public void handleMessage(Message msg)
	              {
					 switch (msg.what)
		             {	
		             	case AboutOperator.PAGE_1:
		             		usBtnChangeI(0);
		             		break;	
		                 
		               	case AboutOperator.PAGE_2:
		             		usBtnChangeII(0);
			                 break;	
			                 
		            	case AboutOperator.PAGE_3:
							viewPager.setCurrentItem(2);
		             		usBtnChangeIII(0);
			                 break;	
			                 
		            	case AboutOperator.BTN_1:
		             		usBtnChangeI(1);
		             		break;	
		                 
		               	case AboutOperator.BTN_2:
		             		usBtnChangeII(1);
			                 break;	
			                 
		            	case AboutOperator.BTN_3:
		             		usBtnChangeIII(1);
			                 break;	
			                 
		            	case AboutOperator.RETURN_TO_INFOR_DETAILS:
		            		Intent intent = new Intent();
		    				intent.setClass(AboutOperator.this,DetailsOfInformationActivity.class);
		    				startActivity(intent);
		            		break;
		            	
		            	case AboutOperator.RETURN_TO_DYNAMIC_DETAILS:
		            		Intent intent2 = new Intent();
		            		intent2.setClass(AboutOperator.this,DetailsOfDynamicActivity.class);
		    				startActivity(intent2);
		            		break;
		            
		            	case AboutOperator.TAKE_CALL:
		            		TextView telView = (TextView) findViewById(R.id.operator_tel_text);
		            	    Intent intent3 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+telView.getText().toString())); 
		            	    intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		            	    startActivity(intent3);
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
                       message.what = AboutOperator.BTN_1;
                       handler.sendMessage(message);
				}
			});
			
			button02.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					Message message = new Message();
                    message.what = AboutOperator.BTN_2;
                    handler.sendMessage(message);  				
                 }
			});
			
			button03.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					   Message message = new Message();
                       message.what = AboutOperator.BTN_3;
                       handler.sendMessage(message);				
                 }
			});
		}
		
		public void usBtnChangeI(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(0);
			}
			button01.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_green));
     		button02.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button03.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
		}
		public void usBtnChangeII(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(1);
			}
			button01.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button02.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_green));
     		button03.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
		}
		public void usBtnChangeIII(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(2);
			}
			button01.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button02.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button03.setBackground(AboutOperator.this.getResources().getDrawable(R.drawable.usbutton_green));
		}
		
		private void initIntroduce(View view)
		{
			telLinearLayout = (LinearLayout) view.findViewById(R.id.operator_tel_layout);
			telLinearLayout.setOnClickListener(new OnClickListener() 
			{
				
				@Override
				public void onClick(View v)
				{
					   Message message = new Message();
                       message.what = AboutOperator.TAKE_CALL;
                       handler.sendMessage(message);					
				}
			});
		}
}

