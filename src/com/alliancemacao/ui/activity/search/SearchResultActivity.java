package com.alliancemacao.ui.activity.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.alliancemacao.ui.view.ViewPagerAdapter;
import com.alliancemacao.ui.view.personalcenter.PersonalAttentionListCallBack;
import com.alliancemacao.ui.view.personalcenter.PersonalAttentionListViewAdapter;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionDynamicListViewAdapter;
import com.alliancemacao.ui.view.personalcenter.PersonalCollectionInformationListViewAdapter;
import com.example.alliancemacao.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class SearchResultActivity extends Activity
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
     

 	 View page01 = null;
 	 View page02 = null;
 	 View page03 = null;

 	//资讯部分
 	 private ListView informationListView;   
     private PersonalCollectionInformationListViewAdapter informationListViewAdapter; 
     private List<Map<String, Object>> informationItem;
      
  	//动态部分
  	 private ListView dynamicListView;
     private PersonalCollectionDynamicListViewAdapter dynamicListViewAdapter; 
     private List<Map<String, Object>> dynamicListItem;
 	 
  	
  	//商户介绍部分
  	private ListView operatorsListView;
    private PersonalAttentionListViewAdapter operatorsAdapter; 
    private List<Map<String, Object>> operatorsListItem;
    
    //模拟数据
    
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

 	private String[] khs = {"中国康辉旅行社", "广州广之旅国际旅行社","中青旅", "山东嘉华国际旅行社", "中国旅行总社", "珠海远航国际旅行社"};   
    private Integer[] imgg = {R.drawable.text_attcon_icon1,R.drawable.text_att_icon2,R.drawable.text_att_icon3,R.drawable.text_att_icon4,R.drawable.text_att_icon5,R.drawable.text_att_icon6};
    private String[] logo = {"aaaaaaa", "bbbbbbbb","cccccc", "dddddddd", "eeeeeee", "fffffff"};   
  	
	 public void onCreate(Bundle savedInstanceState)
	 {
	    	super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_search_result);
			
			button01 = (Button) findViewById(R.id.about_operator_bt1);
			button02 = (Button) findViewById(R.id.about_operator_bt2);
			button03 = (Button) findViewById(R.id.about_operator_bt3);
			
			viewPager = initPageView();
			initHandler();
			initControlButton(viewPager);
			initInformationList();
			initDynamicList();
			initAttentions();
	 }
	 
	 	private void initControlButton(ViewPager viewPager2) 
	 	{
	 		button01.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					   Message message = new Message();
                       message.what = SearchResultActivity.BTN_1;
                       handler.sendMessage(message);
				}
			});
			
			button02.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					Message message = new Message();
                    message.what = SearchResultActivity.BTN_2;
                    handler.sendMessage(message);  				
                 }
			});
			
			button03.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					   Message message = new Message();
                       message.what = SearchResultActivity.BTN_3;
                       handler.sendMessage(message);				
                 }
			});		
	 	}

		private ViewPager initPageView()
	 	{
	 		 pageViews = new ArrayList<View>();
		    LayoutInflater mInflater = getLayoutInflater();

			 page01 = mInflater.inflate(R.layout.view_search_information_list,
					null);
			 page02 = mInflater.inflate(R.layout.view_search_introduce_list, null);
			 page03 = mInflater.inflate(R.layout.view_search_operators_list, null);
			
			pageViews.add(page01);
			pageViews.add(page02);
			pageViews.add(page03);
			
			viewPageAdapter = new ViewPagerAdapter(pageViews);
			viewPager = (ViewPager) findViewById(R.id.search_result_viewpage);
			viewPager.setAdapter(new ViewPagerAdapter(pageViews));
			viewPager.setAdapter(viewPageAdapter);	
			
			viewPager.setOnPageChangeListener(new OnPageChangeListener()
			{
				public void onPageSelected(int arg0)
				{
					if (arg0 == 0)
					{
						   Message message = new Message();
	                       message.what = SearchResultActivity.PAGE_1;
	                       handler.sendMessage(message);
					}
					else if (arg0 == 1)
					{
						   Message message = new Message();
	                       message.what = SearchResultActivity.PAGE_2;
	                       handler.sendMessage(message);
					}
					else if (arg0 == 2)
					{
						   Message message = new Message();
	                       message.what = SearchResultActivity.PAGE_3;
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
			return viewPager;		
	 	}
	 
		private void initHandler()
		{	
			handler = new Handler()
			{
				 public void handleMessage(Message msg)
	              {
					 switch (msg.what)
		             {	
		             	case SearchResultActivity.PAGE_1:
		             		usBtnChangeI(0);
		             		break;	
		                 
		               	case SearchResultActivity.PAGE_2:
		             		usBtnChangeII(0);
			                 break;	
			                 
		            	case SearchResultActivity.PAGE_3:
							viewPager.setCurrentItem(2);
		             		usBtnChangeIII(0);
			                 break;	
			                 
		            	case SearchResultActivity.BTN_1:
		             		usBtnChangeI(1);
		             		break;	
		                 
		               	case SearchResultActivity.BTN_2:
		             		usBtnChangeII(1);
			                 break;	
			                 
		            	case SearchResultActivity.BTN_3:
		             		usBtnChangeIII(1);
			                 break;				              

		             }
		             super.handleMessage(msg);
	              }
			};
		}
			
		public void usBtnChangeI(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(0);
			}
			button01.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_green));
     		button02.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button03.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
		}
		public void usBtnChangeII(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(1);
			}
			button01.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button02.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_green));
     		button03.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
		}
		public void usBtnChangeIII(int stat)
		{
			if(stat == 1)
			{
				viewPager.setCurrentItem(2);
			}
			button01.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button02.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_white));
     		button03.setBackground(SearchResultActivity.this.getResources().getDrawable(R.drawable.usbutton_green));
		}
			
		private void initInformationList()
		{
			informationItem = getInformationListItems();   
			informationListView = (ListView) page01.findViewById(R.id.search_information_list);
			informationListViewAdapter = new PersonalCollectionInformationListViewAdapter(this, informationItem); //创建适配器   
			informationListView.setAdapter(informationListViewAdapter);
			
			informationListView.setOnItemClickListener(new OnItemClickListener() 
			{
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) 
				{
					  Message message = new Message();
//	                  message.what = AboutOperator.RETURN_TO_INFOR_DETAILS;
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
				dynamicListView = (ListView) page02.findViewById(R.id.search_introduce_list);
				dynamicListViewAdapter = new PersonalCollectionDynamicListViewAdapter(this, dynamicListItem); //创建适配器   
				dynamicListView.setAdapter(dynamicListViewAdapter);
				
				dynamicListView.setOnItemClickListener(new OnItemClickListener() 
				{
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) 
					{
						  Message message = new Message();
//		                  message.what = AboutOperator.RETURN_TO_DYNAMIC_DETAILS;
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
		 
		 private void initAttentions()
			{
			 	operatorsListView = (ListView) page03.findViewById(R.id.search_operator_list);
				operatorsListItem = getAttebtuibListItems();   
		        operatorsAdapter = new PersonalAttentionListViewAdapter(this, operatorsListItem); //创建适配器   
		        operatorsListView.setAdapter(operatorsAdapter);
		        operatorsAdapter.initCallBack(new PersonalAttentionListCallBack() 
		        {
					@Override
					public void onClickAttention(View view)
					{
					}
				});		
			}
			
		 private List<Map<String, Object>> getAttebtuibListItems() 
		 {   
		        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
		        for(int i = 0; i < imgeIn.length; i++) 
		        {   
		            Map<String, Object> map = new HashMap<String, Object>();    
		            map.put("atten_operators_icon",imgeIn[i]);     
		            map.put("atten_operators_name_text",goodsNames[i]);       
		            map.put("atten_operators_introduction_text",logo[i]); 
		            listItems.add(map);   
		        }      
		        return listItems;   
		  }   
}
