package com.alliancemacao.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

import com.alliancemacao.ui.fragment.DynamicFragment;
import com.alliancemacao.ui.fragment.NewOrationFragment;
import com.alliancemacao.ui.fragment.OrationFragment;
import com.alliancemacao.ui.fragment.PersonalFragment;
import com.alliancemacao.ui.fragment.SearchFragment;
import com.alliancemacao.ui.util.DummyTabContent;
import com.example.alliancemacao.R;


public class HomeActivity extends FragmentActivity
{
	TabHost tabHost;
	TabWidget tabWidget; 
	LinearLayout bottom_layout;
	int CURRENT_TAB = 0;	//设置常量
	
	//最新咨讯
	NewOrationFragment newOrationFragment;
	
	//咨讯
	OrationFragment orationFragment;

	//咨讯
	DynamicFragment dynamicFragment;
		
	//咨讯
	SearchFragment searchFragment;
	
	//咨讯
	PersonalFragment personalFragment;
	
	android.support.v4.app.FragmentTransaction ft;

	LinearLayout tabIndicator1,tabIndicator2,tabIndicator3,tabIndicator4,tabIndicator5;

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
        
        findTabView();
        tabHost.setup();
        
        TabHost.OnTabChangeListener tabChangeListener = new OnTabChangeListener()
        {
			public void onTabChanged(String tabId) 
			{
				/**碎片管理*/
				android.support.v4.app.FragmentManager fm =  getSupportFragmentManager();
				newOrationFragment = (NewOrationFragment) fm.findFragmentByTag("newOrationFragment");
				orationFragment = (OrationFragment)fm.findFragmentByTag("orationFragment");
				dynamicFragment = (DynamicFragment)fm.findFragmentByTag("dynamicFragment");
				searchFragment = (SearchFragment)fm.findFragmentByTag("searchFragment");;
				personalFragment = (PersonalFragment)fm.findFragmentByTag("personalFragment");
				ft = fm.beginTransaction();
			

				/** 如果存在Detaches掉 */
				if(newOrationFragment!=null)
					ft.detach(newOrationFragment);
				
				/** 如果存在Detaches掉 */
				if(orationFragment!=null)
					ft.detach(orationFragment);
				
				if(dynamicFragment!=null)
					ft.detach(dynamicFragment);
				
				if(dynamicFragment!=null)
					ft.detach(dynamicFragment);
				
				if(searchFragment!=null)
					ft.detach(searchFragment);
				
				if(personalFragment!=null)
					ft.detach(personalFragment);
				
				
				if(tabId.equalsIgnoreCase("newOration"))
				{
					isTabNewOrationFragment();
					CURRENT_TAB = 1;
					
				}
				else if(tabId.equalsIgnoreCase("oration"))
				{	
					isTabOrationFragment();
					CURRENT_TAB = 2;
					
				}
				else if(tabId.equalsIgnoreCase("dynamic"))
				{	
					isTabDynamicFragment();
					CURRENT_TAB = 3;
					
				}
				else if(tabId.equalsIgnoreCase("search"))
				{	
					isTabSearchFragment();
					CURRENT_TAB = 4;
				}
				else if(tabId.equalsIgnoreCase("personal"))
				{	
					isTabPersonalFragment();
					CURRENT_TAB = 5;
				}
				else
				{
					Log.e("111", CURRENT_TAB+"");
					switch (CURRENT_TAB) 
					{
					case 1:
						isTabNewOrationFragment();
						break;
					case 2:
						isTabOrationFragment();
						break;
					case 3:
						isTabDynamicFragment();
						break;
					case 4:
						isTabSearchFragment();
						break;
					case 5:
						isTabPersonalFragment();
						break;
					default:
						isTabNewOrationFragment();
						break;
					}		
					
				}
					ft.commit();	
			}
        } ;
        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(tabChangeListener);
        initTab();
        tabHost.setCurrentTab(0);

    }

    private void initTab()
    {	
        TabHost.TabSpec tSpecHome = tabHost.newTabSpec("newOration");
        tSpecHome.setIndicator(tabIndicator1);        
        tSpecHome.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecHome);
        
        TabHost.TabSpec tSpecWall = tabHost.newTabSpec("oration");
        tSpecWall.setIndicator(tabIndicator2);        
        tSpecWall.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecWall);
        
        TabHost.TabSpec tSpecDynamic = tabHost.newTabSpec("dynamic");
        tSpecDynamic.setIndicator(tabIndicator3);        
        tSpecDynamic.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecDynamic);
        
        TabHost.TabSpec tSpecSearch = tabHost.newTabSpec("search");
        tSpecSearch.setIndicator(tabIndicator4);        
        tSpecSearch.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecSearch);
        
        TabHost.TabSpec tSpecPersonal = tabHost.newTabSpec("personal");
        tSpecPersonal.setIndicator(tabIndicator5);        
        tSpecPersonal.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecPersonal);
        
	}

	/**
     * 找到Tabhost布局
     */
	private void findTabView() 
	{
   	 	tabHost = (TabHost) findViewById(android.R.id.tabhost);
   	 	tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        LinearLayout layout = (LinearLayout)tabHost.getChildAt(0);
        TabWidget tw = (TabWidget)layout.getChildAt(1);

        
        tabIndicator1 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_indicator, tw, false);
        TextView tvTab1 = (TextView)tabIndicator1.getChildAt(2);
        ImageView ivTab1 = (ImageView)tabIndicator1.getChildAt(1);
        ivTab1.setBackgroundResource(R.drawable.selector_new_opertor);
        tvTab1.setText("最新咨讯");

        tabIndicator2 = (LinearLayout) LayoutInflater.from(this)
         		.inflate(R.layout.tab_indicator, tw, false);
         TextView tvTab2 = (TextView)tabIndicator2.getChildAt(2);
         ImageView ivTab2 = (ImageView)tabIndicator2.getChildAt(1);
         ivTab2.setBackgroundResource(R.drawable.selector_opertor);
         tvTab2.setText("咨讯");
         
         tabIndicator3 = (LinearLayout) LayoutInflater.from(this)
         		.inflate(R.layout.tab_indicator, tw, false);
         TextView tvTab3 = (TextView)tabIndicator3.getChildAt(2);
         ImageView ivTab3 = (ImageView)tabIndicator3.getChildAt(1);
         ivTab3.setBackgroundResource(R.drawable.selector_dynamic);
         tvTab3.setText("动态");
          
         tabIndicator4 = (LinearLayout) LayoutInflater.from(this)
         		.inflate(R.layout.tab_indicator, tw, false);
         TextView tvTab4 = (TextView)tabIndicator4.getChildAt(2);
         ImageView ivTab4 = (ImageView)tabIndicator4.getChildAt(1);
         ivTab4.setBackgroundResource(R.drawable.selector_search);
         tvTab4.setText("搜索");
         
         tabIndicator5 = (LinearLayout) LayoutInflater.from(this)
         		.inflate(R.layout.tab_indicator, tw, false);
         TextView tvTab5 = (TextView)tabIndicator5.getChildAt(2);
         ImageView ivTab5 = (ImageView)tabIndicator5.getChildAt(1);
         ivTab5.setBackgroundResource(R.drawable.selector_personal);
         tvTab5.setText("个人");	
	}
	
	
    //判断当前
    public void isTabNewOrationFragment(){
    	
    	if(newOrationFragment==null)
    	{		
			ft.add(R.id.realtabcontent,new NewOrationFragment(), "newOrationFragment");	
		}
    	else
    	{
			ft.attach(newOrationFragment);						
		}
    }
    
    public void isTabOrationFragment()
    {
    	
    	if(orationFragment==null)
    	{		
			ft.add(R.id.realtabcontent,new OrationFragment(), "orationFragment");						
		}
    	else
    	{
			ft.attach(orationFragment);						
		}
    }

    
    public void isTabDynamicFragment()
    {
    	
    	if(dynamicFragment==null)
    	{		
			ft.add(R.id.realtabcontent,new DynamicFragment(), "dynamicFragment");						
		}
    	else
    	{
			ft.attach(dynamicFragment);						
		}
    }

    public void isTabSearchFragment()
    {
    	
    	if(searchFragment==null)
    	{		
			ft.add(R.id.realtabcontent,new SearchFragment(), "searchFragment");						
		}
    	else
    	{
			ft.attach(searchFragment);						
		}
    }

    public void isTabPersonalFragment()
    {
    	
    	if(personalFragment==null)
    	{		
			ft.add(R.id.realtabcontent,new PersonalFragment(), "personalFragment");						
		}
    	else
    	{
			ft.attach(personalFragment);						
		}
    }
}
