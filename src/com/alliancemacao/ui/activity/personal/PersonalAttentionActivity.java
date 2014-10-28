package com.alliancemacao.ui.activity.personal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alliancemacao.ui.view.personalcenter.PersonalAttentionListCallBack;
import com.alliancemacao.ui.view.personalcenter.PersonalAttentionListViewAdapter;
import com.example.alliancemacao.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class PersonalAttentionActivity extends Activity
{
	  	private ListView listView;   
	    private PersonalAttentionListViewAdapter listViewAdapter; 
	    private List<Map<String, Object>> listItems;
	    
		private String[] goodsNames = {"中国康辉旅行社", "广州广之旅国际旅行社","中青旅", "山东嘉华国际旅行社", "中国旅行总社", "珠海远航国际旅行社"};   
	    private Integer[] imgeIn = {R.drawable.text_attcon_icon1,R.drawable.text_att_icon2,R.drawable.text_att_icon3,R.drawable.text_att_icon4,R.drawable.text_att_icon5,R.drawable.text_att_icon6};
	    private String[] logo = {"aaaaaaa", "bbbbbbbb","cccccc", "dddddddd", "eeeeeee", "fffffff"};   


	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_attention);
		initTitle();
		
		listView = (ListView) findViewById(R.id.personal_attention_listv);
		listItems = getListItems();   
        listViewAdapter = new PersonalAttentionListViewAdapter(this, listItems); //创建适配器   
        listView.setAdapter(listViewAdapter);
        listViewAdapter.initCallBack(new PersonalAttentionListCallBack() 
        {
			@Override
			public void onClickAttention(View view)
			{
				view.setBackground(PersonalAttentionActivity.this.getResources().getDrawable(R.drawable.had_attention_btn));
			}
		});
	}
	
	 private List<Map<String, Object>> getListItems() 
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
	 
		
		private void initTitle()
		{
			TextView title = (TextView) findViewById(R.id.main_title_text);
			title.setText("关注");
			
			Button leftBtn = (Button) findViewById(R.id.main_title_left);
			leftBtn.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
			leftBtn.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View arg0) 
				{
					PersonalAttentionActivity.this.finish();
				}
			});
		}
}
