package com.alliancemacao.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.activity.information.InformationClassifyActivity;
import com.alliancemacao.ui.view.operators.OperatorHotWeekListViewAdapter;
import com.alliancemacao.ui.view.operators.OperatorTouristGroupListViewAdapter;
import com.example.alliancemacao.R;

@SuppressLint("NewApi")
public class OrationFragment extends Fragment 
{
    Handler handler;
	private ViewPager viewPager;
	private ViewPagerAdapter viewPageAdapter;
	private ArrayList<View> pageViews;
	private Button button01;
	private Button button02;
	private Button button03;
	private Button button04;

	private ListView oration_tourist_group_list;
	private ListView oration_free_line_list;
	private ListView oration_hot_week_list;
	private ListView oration_cruise_featured_list;
	
		private final static int PAGE_1 = 1;
	    private final static int PAGE_2 = 2;
	    private final static int PAGE_3 = 3;
	    private final static int PAGE_4 = 4;

	    private final static int BTN_1 = 5;
	    private final static int BTN_2 = 6;
	    private final static int BTN_3 = 7;
	    private final static int BTN_4 = 8;


	// 旅游团部分
	private OperatorTouristGroupListViewAdapter listViewTouristGroupAdapter;
	private List<Map<String, Object>> touristGrouplistItems;

	// 自由行部分
	private OperatorTouristGroupListViewAdapter listViewFreeLineAdapter;
	private List<Map<String, Object>> freeLinelistItems;
	
	// 本周热卖部分
	private OperatorHotWeekListViewAdapter listViewHotWeekAdapter;
	private List<Map<String, Object>> hotWeeklistItems;
	
	// 游轮精选部分
	private OperatorHotWeekListViewAdapter listViewCruiseFeaturedAdapter;
	private List<Map<String, Object>> cruiseFeaturedlistItems;

	// 临时数据
	private String[] goodsNames = { "台湾", "泰国", "美国", "日本", "法国", "英国" };
	private Integer[] imgeIn = { R.drawable.text_picture_01,
			R.drawable.text_picture_02 ,
			R.drawable.text_picture_02,
			R.drawable.text_picture_02,
			R.drawable.text_picture_02};
	private Integer[] logo = { R.drawable.left_logo_gzl,
			R.drawable.left_logo_zgkg,R.drawable.left_logo_zgkg,R.drawable.left_logo_zgkg,R.drawable.left_logo_zgkg };

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_oration_main,
				container, false);
		initBar(rootView);

		pageViews = new ArrayList<View>();
		final View page01 = inflater.inflate(R.layout.view_oration_tourist_group,
				null);
		View page02 = inflater.inflate(R.layout.view_oration_free_line, null);
		View page03 = inflater.inflate(R.layout.view_oration_this_week, null);
		View page04 = inflater.inflate(R.layout.view_oration_cruise_ship, null);

		pageViews.add(page01);
		pageViews.add(page02);
		pageViews.add(page03);
		pageViews.add(page04);

		viewPageAdapter = new ViewPagerAdapter(pageViews);
		viewPager = (ViewPager) rootView.findViewById(R.id.oration_view_page);
		viewPager.setAdapter(new ViewPagerAdapter(pageViews));
		viewPager.setAdapter(viewPageAdapter);
		
		button01 = (Button) rootView.findViewById(R.id.tour_group_btn);
		button02 = (Button) rootView.findViewById(R.id.free_line_btn);
		button03 = (Button) rootView.findViewById(R.id.hot_week_btn);
		button04 = (Button) rootView.findViewById(R.id.cruise_ship_btn);

		initHandler(rootView, viewPager);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			public void onPageSelected(int arg0)
			{
				if (arg0 == 0)
				{
					   Message message = new Message();
                       message.what = OrationFragment.PAGE_1;
                       handler.sendMessage(message);
				}
				else if (arg0 == 1)
				{
					   Message message = new Message();
                       message.what = OrationFragment.PAGE_2;
                       handler.sendMessage(message);
				}
				else if (arg0 == 2)
				{
					   Message message = new Message();
                       message.what = OrationFragment.PAGE_3;
                       handler.sendMessage(message);
				}
				else if (arg0 == 3)
				{
					   Message message = new Message();
                       message.what = OrationFragment.PAGE_4;
                       handler.sendMessage(message);
				}
			}
			
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				
			}
			
			public void onPageScrollStateChanged(int arg0)
			{
				
			}
		});

		// 旅行团
		oration_tourist_group_list = (ListView) page01.findViewById(R.id.oration_tourist_group_listv);
		touristGrouplistItems = getTourisGroupDataSource();
		listViewTouristGroupAdapter = new OperatorTouristGroupListViewAdapter(rootView.getContext(), touristGrouplistItems); // 创建适配器

		oration_tourist_group_list
				.setOnItemClickListener(new OnItemClickListener() 
				{
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) 
					{
							Intent intent = new Intent();
							intent.setClass(page01.getContext(), InformationClassifyActivity.class);
							startActivity(intent);
					}
				});
		oration_tourist_group_list.setAdapter(listViewTouristGroupAdapter);

		//自由行
		oration_free_line_list = (ListView) page02.findViewById(R.id.oration_free_line_listv);
		freeLinelistItems = getFreeLineDataSource();
		listViewFreeLineAdapter= new OperatorTouristGroupListViewAdapter(rootView.getContext(), freeLinelistItems); // 创建适配器

		oration_free_line_list
				.setOnItemClickListener(new OnItemClickListener() 
				{
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

					}
				});
		oration_free_line_list.setAdapter(listViewFreeLineAdapter);
		
		
		//本周热卖
		oration_hot_week_list = (ListView) page03.findViewById(R.id.oration_hot_week_listv);
		hotWeeklistItems = getHotWeekDataSource();
		listViewHotWeekAdapter= new OperatorHotWeekListViewAdapter(rootView.getContext(), hotWeeklistItems); // 创建适配器

		oration_hot_week_list
				.setOnItemClickListener(new OnItemClickListener() 
				{
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

					}
				});
		oration_hot_week_list.setAdapter(listViewHotWeekAdapter);

		//本周热卖
		oration_cruise_featured_list = (ListView) page04
				.findViewById(R.id.oration_cruise_listv);
		cruiseFeaturedlistItems = getCruiseeFaturedDataSource();
		listViewCruiseFeaturedAdapter = new OperatorHotWeekListViewAdapter(rootView.getContext(), cruiseFeaturedlistItems); // 创建适配器

		oration_cruise_featured_list
				.setOnItemClickListener(new OnItemClickListener() 
				{
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

					}
				});
		oration_cruise_featured_list.setAdapter(listViewCruiseFeaturedAdapter);
		viewPager = (ViewPager) rootView
				.findViewById(R.id.oration_view_page);
		return rootView;
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

	@SuppressLint("ResourceAsColor")
	private void initBar(View rootView)
	{
		TextView title = (TextView) rootView.findViewById(R.id.main_title_text);
		title.setText("资讯");
	}


	private List<Map<String, Object>> getTourisGroupDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 2; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("area_img", imgeIn[i]);
			map.put("area_tv", goodsNames[i]);
			map.put("introduction_tv", "aaaaaaaaaa");
			listItems.add(map);
		}
		return listItems;
	}

	private List<Map<String, Object>> getFreeLineDataSource()
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 5; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("area_img", imgeIn[i]);
			map.put("area_tv", goodsNames[i]);
			map.put("introduction_tv", "aaaaaaaaaa");
			listItems.add(map);
		}
		return listItems;
	}
	
	
	private List<Map<String, Object>> getHotWeekDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 5; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("hot_week_list_info_image", imgeIn[i]);
			map.put("hot_week_list_infotitle_text", goodsNames[i]);
			map.put("hot_week_go_off_text", "aaaaaaaaaa");
			map.put("hot_week_infor_price_text", "11111111");
			map.put("infor_see_sum_text", "11111");
			map.put("hot_week_infor_agent_image", logo[i]);
			
			listItems.add(map);
		}
		return listItems;
	}
	
	private List<Map<String, Object>> getCruiseeFaturedDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 5; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("hot_week_list_info_image", imgeIn[i]);
			map.put("hot_week_list_infotitle_text", goodsNames[i]);
			map.put("hot_week_go_off_text", "aaaaaaaaaa");
			map.put("hot_week_infor_price_text", "11111111");
			map.put("infor_see_sum_text", "11111");
			map.put("hot_week_infor_agent_image", logo[i]);
			
			listItems.add(map);
		}
		return listItems;
	}
	
	private void initHandler(View view,final ViewPager viewPager)
	{

		handler = new Handler()
		{
			 public void handleMessage(Message msg)
              {
				 switch (msg.what)
	             {	
	             	case OrationFragment.PAGE_1:
	             		usBtnChangeI(0);
	             		break;	
	                 
	               	case OrationFragment.PAGE_2:
	             		usBtnChangeII(0);
		                 break;	
		                 
	            	case OrationFragment.PAGE_3:
						viewPager.setCurrentItem(2);
	             		usBtnChangeIII(0);
		                 break;	
		                 
	            	case OrationFragment.PAGE_4:
						viewPager.setCurrentItem(3);
	             		usBtnChangeIV(0);
		                 break;	     
		                 
	            	case OrationFragment.BTN_1:
	             		usBtnChangeI(1);
	             		break;	
	                 
	               	case OrationFragment.BTN_2:
	             		usBtnChangeII(1);
		                 break;	
		                 
	            	case OrationFragment.BTN_3:
	             		usBtnChangeIII(1);
		                 break;	
		            
	            	case OrationFragment.BTN_4:
	             		usBtnChangeIV(1);
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
                   message.what = OrationFragment.BTN_1;
                   handler.sendMessage(message);
			}
		});
		
		button02.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Message message = new Message();
                message.what = OrationFragment.BTN_2;
                handler.sendMessage(message);  				
             }
		});
		
		button03.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				   Message message = new Message();
                   message.what = OrationFragment.BTN_3;
                   handler.sendMessage(message);				
             }
		});
		
		button04.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				   Message message = new Message();
                   message.what = OrationFragment.BTN_4;
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
		button01.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button02.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button03.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button04.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));

	}
	public void usBtnChangeII(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(1);
		}
		button01.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button03.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button04.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
	}
	public void usBtnChangeIII(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(2);
		}
		button01.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button03.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button04.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
	}
	
	public void usBtnChangeIV(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(3);
		}
		button01.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button03.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button04.setBackground(OrationFragment.this.getResources().getDrawable(R.drawable.usbutton_green));

	}
}
