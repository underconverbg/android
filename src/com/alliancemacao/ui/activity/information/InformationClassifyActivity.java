package com.alliancemacao.ui.activity.information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.alliancemacao.ui.activity.operator.AboutOperator;
import com.alliancemacao.ui.view.informaction.ListViewAdapter;
import com.alliancemacao.ui.view.informaction.ListViewAdapterCallBack;
import com.alliancemacao.ui.view.operators.ClassifyAdapter;
import com.example.alliancemacao.R;

/**
 * 
 * @author zhongzhenhua
 * 带分类导航资讯页面
 */
public class InformationClassifyActivity extends Activity implements OnClickListener, 
OnCheckedChangeListener 
{
	 private Button mbutton01; 
     private Button mbutton02; 
     private Button mbutton03; 
     private Button mbutton04; 
     
     private ListView listView;   
     private ListViewAdapter listViewAdapter; 
     private List<Map<String, Object>> listItems;
     
     private PopupWindow travelModelPopupWindow; 
     private PopupWindow startingPopupWindow; 
     private PopupWindow destinationPopupWindow; 
     private PopupWindow travelTimePopupWindow; 

  
    ClassifyAdapter travelModelAdapter = null;   
    ClassifyAdapter startingAdapter = null;  
    ClassifyAdapter destinationCountyAdapter = null; 
    ClassifyAdapter destinationContinentAdapter = null;   
    ClassifyAdapter travelTimeAdapter = null;   

    
	private List<Map<String, Object>> startingItem;

	private List<Map<String, Object>> destinationContinentItems;
	private List<Map<String, Object>> destinationCountryItems;

	private List<Map<String, Object>> travelTimeItem;
	private List<Map<String, Object>> travelModeItem;

	
	private String[] travelModes = new String[]{"飞机","火车","汽车","步行"};

	private String[] continents = new String[] {"北京","上海","天津","广东"};//,"重庆","黑龙江","江苏","山东","浙江","香港","澳门"};

	private String[] travelTimes = new String[]{"1一个月内","1－3个月内","6个月内","3-6个月内","复活节","圣诞节","农历新年"};

	private String[] countries = new String[]{ "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
        "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云县",
        "延庆县" };

    private String[] goodsNames = {"台湾", "泰国",    
            "美国", "日本", "法国", "英国"};   
    
    private Integer[] imgeIn = {R.drawable.text_picture_01,R.drawable.text_picture_02};
    private Integer[] logo = {R.drawable.left_logo_gzl,R.drawable.left_logo_zgkg};
	
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information_class);
		
		 	mbutton01 = (Button) findViewById(R.id.travel_mode_btn); 
	        mbutton02 = (Button) findViewById(R.id.starting_btn); 
	        mbutton03 = (Button) findViewById(R.id.destination_btn); 
	        mbutton04 = (Button) findViewById(R.id.travel_time_btn); 
	 
	        mbutton01.setOnClickListener(this); 
	        mbutton02.setOnClickListener(this); 
	        mbutton03.setOnClickListener(this); 
	        mbutton04.setOnClickListener(this); 
	        
	        initTitle();
	        initMainListView();
	}

	
	//初始化出发地popuptWindow
	private void initStartingPopuptWindow() 
	{ 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View popupWindow = layoutInflater.inflate(R.layout.popup_window_alone, null); 
        ListView main = (ListView) popupWindow.findViewById(R.id.tip_listv);
 
        startingItem = getStartingSource();
        startingAdapter = new ClassifyAdapter(this, startingItem); // 创建适配器

        main.setAdapter(startingAdapter);

        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); 
        int mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); 
     
        startingPopupWindow = new PopupWindow(popupWindow, mScreenWidth, (int) (mScreenHeight *0.5)); 
        int mPopupWindowWidth =  startingPopupWindow.getWidth(); 
        int mPopupWindowHeight = startingPopupWindow.getHeight(); 
    }
	
	//初始化目的地
	private void initDestinationPopuptWindow() 
	{ 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View popupWindow = layoutInflater.inflate(R.layout.popup_window_double, null); 
        ListView main = (ListView) popupWindow.findViewById(R.id.tip1_listv);
        ListView main2 = (ListView) popupWindow.findViewById(R.id.tip2_listv);

        destinationContinentItems = getContinentDataSource();
        destinationCountryItems = getCountriesDataSource();

        destinationContinentAdapter = new ClassifyAdapter(this, destinationContinentItems); // 创建适配器
        destinationCountyAdapter = new ClassifyAdapter(this, destinationCountryItems); // 创建适配器

        main.setAdapter(destinationContinentAdapter);
        main2.setAdapter(destinationCountyAdapter);
        
        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); 
        int mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); 
     
        destinationPopupWindow = new PopupWindow(popupWindow, mScreenWidth, (int) (mScreenHeight *0.5)); 
        
        int mPopupWindowWidth = destinationPopupWindow.getWidth(); 
        int mPopupWindowHeight = destinationPopupWindow.getHeight(); 
    }
	
	
	//获取国家信息
	private List<Map<String, Object>> getCountriesDataSource()
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < countries.length; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("main", countries[i]);
		
			listItems.add(map);
		}
		return listItems;
	}

	//获取洲的信息
	private List<Map<String, Object>> getContinentDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < continents.length; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("main", continents[i]);
		
			listItems.add(map);
		}
		return listItems;
	}


	private void initTravelTimePopuptWindow() 
	{ 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View popupWindow = layoutInflater.inflate(R.layout.popup_window_alone, null); 
        ListView main = (ListView) popupWindow.findViewById(R.id.tip_listv);
 
        travelTimeItem = getTravelModeDataSource();
        travelTimeAdapter = new ClassifyAdapter(this, travelTimeItem); // 创建适配器
        main.setAdapter(travelTimeAdapter);

        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); 
        int mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); 
     
        travelTimePopupWindow = new PopupWindow(popupWindow, mScreenWidth, (int) (mScreenHeight *0.5)); 
        int mPopupWindowWidth = travelTimePopupWindow.getWidth(); 
        int mPopupWindowHeight = travelTimePopupWindow.getHeight(); 
    }

	
	private void initTravelModePopuptWindow() 
	{ 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View popupWindow = layoutInflater.inflate(R.layout.popup_window_alone, null); 
        ListView main = (ListView) popupWindow.findViewById(R.id.tip_listv);
 
        travelModeItem = getTravelModeDataSource();
        travelModelAdapter = new ClassifyAdapter(this, travelModeItem); // 创建适配器

        main.setAdapter(travelModelAdapter);

        
        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); 
        int mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); 
     
        travelModelPopupWindow = new PopupWindow(popupWindow, mScreenWidth, (int) (mScreenHeight *0.5)); 
        int mPopupWindowWidth = travelModelPopupWindow.getWidth(); 
        int mPopupWindowHeight = travelModelPopupWindow.getHeight(); 
    }


	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
	{
		
	}


	@Override
	public void onClick(View view) 
	{
        switch (view.getId()) 
        { 
	        case R.id.travel_mode_btn: 
	        	if (travelTimePopupWindow != null)
	        	{
		        	travelTimePopupWindow.dismiss();
		        	 travelTimePopupWindow = null;
				}
	        	if (destinationPopupWindow != null)
	        	{
	        		destinationPopupWindow.dismiss();
	        		destinationPopupWindow = null;
				}
	        	if (startingPopupWindow != null)
	        	{
	        		startingPopupWindow.dismiss();
	        		startingPopupWindow = null;
				}
	        	 
	        	 if (null != travelModelPopupWindow) 
	             { 
	        		 travelModelPopupWindow.dismiss(); 
	        		 travelModelPopupWindow = null;
	                 return; 
	             }
	        	 else
	        	 {
	        		 initTravelModePopuptWindow();
	        		 travelModelPopupWindow.showAsDropDown(view); 
	        	 }
	            break; 
	        
	        case R.id.travel_time_btn: 
	        	
	        	if (travelModelPopupWindow != null)
	        	{
	        		travelModelPopupWindow.dismiss();
	        		travelModelPopupWindow = null;
				}
	        	if (destinationPopupWindow != null)
	        	{
	        		destinationPopupWindow.dismiss();
	        		destinationPopupWindow = null;
				}
	        	if (startingPopupWindow != null)
	        	{
	        		startingPopupWindow.dismiss();
	        		startingPopupWindow = null;
				}
	       
	        	 
	        	if (null != travelTimePopupWindow) 
	             { 
	        		travelTimePopupWindow.dismiss(); 
	        		travelTimePopupWindow = null;
	                 return; 
	             }
	        	 else
	        	 {
	        		 initTravelTimePopuptWindow();
	        		 travelTimePopupWindow.showAsDropDown(view); 

	        	 }
	        	break; 
	            
	        case R.id.destination_btn: 
	    
	        	if (travelModelPopupWindow != null)
	        	{
	        		travelModelPopupWindow.dismiss();
	        		travelModelPopupWindow = null;
				}
	        	if (travelTimePopupWindow != null)
	        	{
	        		travelTimePopupWindow.dismiss();
	        		travelTimePopupWindow = null;
				}
	        	if (startingPopupWindow != null)
	        	{
	        		startingPopupWindow.dismiss();
	        		startingPopupWindow = null;
				}
	        	
	        	if (null != destinationPopupWindow) 
	             { 
	        		destinationPopupWindow.dismiss();
	        		destinationPopupWindow = null;
	                 return; 
	             }
	        	 else
	        	 {
	        		 initDestinationPopuptWindow();
	        		 destinationPopupWindow.showAsDropDown(view); 

	        	 }	
	        	break; 
	            
	        case R.id.starting_btn:
	        	if (travelModelPopupWindow != null)
	        	{
	        		travelModelPopupWindow.dismiss();
	        		travelModelPopupWindow = null;
				}
	        	if (travelTimePopupWindow != null)
	        	{
	        		travelTimePopupWindow.dismiss();
	        		travelTimePopupWindow = null;
				}
	        	if (destinationPopupWindow != null)
	        	{
	        		destinationPopupWindow.dismiss();
	        		destinationPopupWindow = null;
				}
	        	
	        	if (null != startingPopupWindow) 
	             { 
	        		startingPopupWindow.dismiss(); 
	        		startingPopupWindow = null;

	                 return; 
	             }
	        	 else
	        	 {
	        		 initStartingPopuptWindow();
	        		 startingPopupWindow.showAsDropDown(view); 

	        	 }	
	        	break;     
        }
	} 
	
	


	
	private List<Map<String, Object>> getStartingSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < continents.length; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("main", continents[i]);
		
			listItems.add(map);
		}
		return listItems;
	}
	
	private List<Map<String, Object>> getTravelModeDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < travelModes.length; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("main", travelModes[i]);
			listItems.add(map);
		}
		return listItems;
	}
	
	private List<Map<String, Object>> getTravelTimeDataSource() 
	{
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < travelTimes.length; i++) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("main", travelTimes[i]);
			listItems.add(map);
		}
		return listItems;
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

	 private void initTitle()
	{
			TextView title = (TextView) findViewById(R.id.main_title_text);
			title.setText("资讯");
	}
	 
	 private void initMainListView()
	 {
		 listView =  (ListView) findViewById(R.id.classify_information_list);
		 listItems = getListItems();   
         listViewAdapter = new ListViewAdapter(this, listItems); //创建适配器   
	      
         listViewAdapter.initListViewAdapterCallBack(new ListViewAdapterCallBack() 
         {
				
				@Override
				public void clickZan(int index)
				{
					
				}
				
				@Override
				public void clickOperators(int index) 
				{
					Intent intent = new Intent();
					intent.setClass(InformationClassifyActivity.this, AboutOperator.class);
					startActivity(intent);
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
					 Intent intent = new Intent();  
		             intent.setClass(InformationClassifyActivity.this, DetailsOfInformationActivity.class);  
		              startActivity(intent); 					
				}
			});
	        
	        
//	        listView.setOnItemClickListener(new OnItemClickListener()
//	        {
//				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//						long arg3)
//				{
//					 
//				}
//	        	
//			});
			
	      
	        listView.setAdapter(listViewAdapter);
	 }
}

