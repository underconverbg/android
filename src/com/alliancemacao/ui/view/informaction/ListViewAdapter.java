package com.alliancemacao.ui.view.informaction;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class ListViewAdapter extends BaseAdapter
{
	Handler handler;

    private Context context;                        //运行上下文   
    private List<Map<String, Object>> listItems;   
    private LayoutInflater listContainer;           //视图容器   
    ListViewAdapterCallBack myCallBack;


    public final class ListItemView
    {              
        public ImageView infor_image;
        public TextView info_title;     
        public TextView go_off_text;   
        public TextView infor_price_text;
        public ImageView infor_agent_image;     
        public TextView infor_see_sum_text;
		public LinearLayout infor_main_layout;
		public ImageView zan_framge_img;
		public ImageView collect_framge_img;   
    }     
    
    public void initListViewAdapterCallBack(ListViewAdapterCallBack callBack)
    {
    	myCallBack = callBack;
    }
    
    
    public ListViewAdapter(Context context, List<Map<String, Object>> listItems)
    {   
        this.context = context;            
        listContainer = LayoutInflater.from(context);  
        this.listItems = listItems;   
    }   
    
    public int getCount() 
	{
        return listItems.size();   
	}
	@Override
	public Object getItem(int arg0)
	{
		return null;
	}
	@Override
	public long getItemId(int arg0)
	{
		return 0;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		        //自定义视图   
		        ListItemView  listItemView = null;   
		        if (convertView == null) {   
		            listItemView = new ListItemView();    
		            //获取list_item布局文件的视图   
		            convertView = listContainer.inflate(R.layout.view_information, null);   
		            //获取控件对象   
		            
		            listItemView.infor_image = (ImageView) convertView.findViewById(R.id.infor_image);
		            listItemView.info_title = (TextView)convertView.findViewById(R.id.info_title);    
		            listItemView.go_off_text = (TextView)convertView.findViewById(R.id.go_off_text);   
		            listItemView.infor_price_text = (TextView) convertView.findViewById(R.id.infor_price_text);
		            listItemView.infor_agent_image = (ImageView) convertView.findViewById(R.id.infor_agent_image);     
		            listItemView.infor_see_sum_text= (TextView) convertView.findViewById(R.id.infor_see_sum_text);   ;
		            listItemView.infor_main_layout= (LinearLayout) convertView.findViewById(R.id.infor_main_layout);   ;
		            listItemView.zan_framge_img= (ImageView) convertView.findViewById(R.id.zan_framge_img);   ;
		            listItemView.collect_framge_img= (ImageView) convertView.findViewById(R.id.collect_framge_img);   ;

		            
		            listItemView.infor_image.setBackgroundResource((Integer) listItems.get(   
		                    position).get("infor_image")); 
		            
		            listItemView.info_title.setText((String) listItems.get(position)   
		                    .get("info_title"));  
		            
		            listItemView.go_off_text.setText((String) listItems.get(position)   
		                    .get("go_off_text"));  
		            
		            listItemView.infor_price_text.setText((String) listItems.get(position)   
		                    .get("infor_price_text"));  
		            
		            listItemView.infor_agent_image.setBackgroundResource((Integer) listItems.get(   
		                    position).get("infor_agent_image")); 
		            
		            listItemView.infor_see_sum_text.setText((String) listItems.get(position)   
		                    .get("infor_see_sum_text")); 
		            
		            //设置控件集到convertView   
		            convertView.setTag(listItemView);   
		        }
		        else 
		        {   
		            listItemView = (ListItemView)convertView.getTag();   
		        }   
	           
	
		        listItemView.infor_image.setOnClickListener(new View.OnClickListener() {   
		            @Override  
		            public void onClick(View v) 
		            {   
		            	myCallBack.clickImage(position);
		            }   
		        });   		        		        	      
	              
		        
		        listItemView.infor_agent_image.setOnClickListener(new OnClickListener() {
		        	public void onClick(View v) 
		        	{
		            	myCallBack.clickOperators(position);
					}
				});
		        
		        
		        listItemView.infor_main_layout.setOnClickListener(new OnClickListener() {
		        	public void onClick(View v) 
		        	{
		            	myCallBack.clickMainInfo(position);
					}
				});
		        
		        listItemView.zan_framge_img.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View arg0)
					{
						myCallBack.clickZan(position);
					}
				});
		        
		        listItemView.collect_framge_img.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View arg0)
					{
						myCallBack.clickCollect(position);
					}
				});
		        
		        
		        return convertView;   
	}
	
	
}
