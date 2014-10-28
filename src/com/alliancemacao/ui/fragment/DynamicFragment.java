package com.alliancemacao.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.view.dynamic.DynamicStrategyListViewAdapter;
import com.example.alliancemacao.R;

@SuppressLint({ "ResourceAsColor", "NewApi" })
public class DynamicFragment extends Fragment 
{
    Handler handler;

	private ViewPager viewPager;
	private ViewPagerAdapter viewPageAdapter;
	
	private Button button01;
	private Button button02;
	private Button button03;
	
	private ArrayList<View> pageViews;
	private ListView dynamic_information_list;
	private ListView dynamic_travels_list;
	private ListView dynamic_favourable_list;

	private DynamicStrategyListViewAdapter strategyListViewAdapter;
	private DynamicStrategyListViewAdapter travelsListViewAdapter;
	private DynamicStrategyListViewAdapter favourableListViewAdapter;

	private List<Map<String, Object>> listStrategy;
	private List<Map<String, Object>> listTravels;
	private List<Map<String, Object>> listFavourable;

    private final static int PAGE_1 = 1;
    private final static int PAGE_2 = 2;
    private final static int PAGE_3 = 3;
    private final static int BTN_1 = 4;
    private final static int BTN_2 = 5;
    private final static int BTN_3 = 6;

	// 临时数据
	private String[] goodsNames = { "台湾", "泰国", "美国", "日本", "法国", "英国" };
	private Integer[] imgeIn = { R.drawable.text_picture_01,
			R.drawable.text_picture_02 };
	private Integer[] logo = { R.drawable.left_logo_gzl,
			R.drawable.left_logo_zgkg };

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_dynamic_main,
				container, false);
		initBar(rootView);

		View page01 = inflater.inflate(R.layout.view_dynamic_strategy, null);
		View page02 = inflater.inflate(R.layout.view_dynamic_travels, null);
		View page03 = inflater.inflate(R.layout.view_dynamic_favourable, null);

		pageViews = new ArrayList<View>();
		pageViews.add(page01);
		pageViews.add(page02);
		pageViews.add(page03);
		viewPageAdapter = new ViewPagerAdapter(pageViews);

		
		viewPager = (ViewPager) rootView.findViewById(R.id.dynamic_view_page);
		viewPager.setAdapter(viewPageAdapter);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			public void onPageSelected(int arg0)
			{
				if (arg0 == 0)
				{
					   Message message = new Message();
                       message.what = DynamicFragment.PAGE_1;
                       handler.sendMessage(message);
				}
				else if (arg0 == 1)
				{
					   Message message = new Message();
                       message.what = DynamicFragment.PAGE_2;
                       handler.sendMessage(message);
				}
				else if (arg0 == 2)
				{
					   Message message = new Message();
                       message.what = DynamicFragment.PAGE_3;
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
		
		initControlButton(rootView,viewPager);

		// 攻略
		dynamic_information_list = (ListView) page01
				.findViewById(R.id.dynamic_strategy_list);

		listStrategy = getStragtegyListItems();

		strategyListViewAdapter = new DynamicStrategyListViewAdapter(
				rootView.getContext(), listStrategy); // 创建适配器

		dynamic_information_list
				.setOnItemClickListener(new OnItemClickListener() 
				{
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// Intent intent = new Intent();
						// intent.setClass(view.getContext(),
						// NewOration2Fragment.class);
						// startActivity(intent);
					}

				});
		dynamic_information_list.setAdapter(strategyListViewAdapter);

		// 游记
		dynamic_travels_list = (ListView) page02
				.findViewById(R.id.dynamic_travels_list);

		listTravels = getStragtegyListItems();

		travelsListViewAdapter = new DynamicStrategyListViewAdapter(
				rootView.getContext(), listTravels); // 创建适配器

		dynamic_travels_list.setAdapter(travelsListViewAdapter);

		// 优惠
		dynamic_favourable_list = (ListView) page03
				.findViewById(R.id.dynamic_favourable_list);

		listFavourable = getFavourableListItems();

		favourableListViewAdapter = new DynamicStrategyListViewAdapter(
				rootView.getContext(), listFavourable); // 创建适配器

		dynamic_favourable_list.setAdapter(favourableListViewAdapter);

		return rootView;
	}

	class ViewPagerAdapter extends PagerAdapter {
		List<View> viewLists;

		public ViewPagerAdapter(List<View> lists)
		{
			viewLists = lists;
		}

		@Override
		public int getCount()
		{
			return viewLists.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) 
		{
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


	private void initBar(View rootView)
	{
		TextView title = (TextView) rootView.findViewById(R.id.main_title_text);
		title.setText("动态");
	}

	// 攻略List
	private List<Map<String, Object>> getStragtegyListItems() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 2; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("infor_image", imgeIn[i]);
			map.put("stragtegy_text", goodsNames[i]);
			map.put("agent_image", logo[i]);
			listItems.add(map);
		}
		return listItems;
	}

	// 游记
	private List<Map<String, Object>> getTravelsListItems()
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 2; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("infor_image", imgeIn[i]);
			map.put("stragtegy_text", goodsNames[i]);
			map.put("agent_image", logo[i]);
			listItems.add(map);
		}
		return listItems;
	}

	// 优惠
	private List<Map<String, Object>> getFavourableListItems() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 2; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("infor_image", imgeIn[i]);
			map.put("stragtegy_text", goodsNames[i]);
			map.put("agent_image", logo[i]);
			listItems.add(map);
		}
		return listItems;
	}
	
	public void usBtnChangeI(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(0);
		}
		button01.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button02.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button03.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
	}
	public void usBtnChangeII(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(1);
		}
		button01.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
 		button03.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
	}
	public void usBtnChangeIII(int stat)
	{
		if(stat == 1)
		{
			viewPager.setCurrentItem(2);
		}
		button01.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button02.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_white));
 		button03.setBackground(DynamicFragment.this.getResources().getDrawable(R.drawable.usbutton_green));
	}
	
	
	private void initControlButton(View view,final ViewPager viewPager)
	{
		button01 = (Button) view.findViewById(R.id.dynamic_strategy_btn);
		button02 = (Button) view.findViewById(R.id.dynamic_travels_btn);
		button03 = (Button) view.findViewById(R.id.dynamic_favourable_btn);
		
		handler = new Handler()
		{
			 public void handleMessage(Message msg)
              {
				 switch (msg.what)
	             {	
	             	case DynamicFragment.PAGE_1:
	             		usBtnChangeI(0);
	             		break;	
	                 
	               	case DynamicFragment.PAGE_2:
	             		usBtnChangeII(0);
		                 break;	
		                 
	            	case DynamicFragment.PAGE_3:
						viewPager.setCurrentItem(2);
	             		usBtnChangeIII(0);
		                 break;	
		                 
	            	case DynamicFragment.BTN_1:
	             		usBtnChangeI(1);
	             		break;	
	                 
	               	case DynamicFragment.BTN_2:
	             		usBtnChangeII(1);
		                 break;	
		                 
	            	case DynamicFragment.BTN_3:
	             		usBtnChangeIII(1);
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
                   message.what = DynamicFragment.BTN_1;
                   handler.sendMessage(message);
			}
		});
		
		button02.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Message message = new Message();
                message.what = DynamicFragment.BTN_2;
                handler.sendMessage(message);  				
             }
		});
		
		button03.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				   Message message = new Message();
                   message.what = DynamicFragment.BTN_3;
                   handler.sendMessage(message);				
             }
		});
		
	}
}
