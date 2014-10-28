package com.alliancemacao.ui.view.operators;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class OperatorHotWeekListViewAdapter  extends BaseAdapter{
	  private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   

	    public final class ListItemView
	    {              
	        public ImageView hot_week_list_info_image;     
	        public TextView hot_week_list_infotitle_text;     
	        public TextView hot_week_go_off_text;
	        public TextView hot_week_infor_price_text;
	        public ImageView hot_week_infor_agent_image;   
	        public TextView infor_see_sum_text;
	 }     
	    
	    public OperatorHotWeekListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
		public View getView(int position, View convertView, ViewGroup parent)
		{
			        //自定义视图   
			        ListItemView  listItemView = null;   
			        if (convertView == null) {   
			            listItemView = new ListItemView();    
			            //获取list_item布局文件的视图   
			            convertView = listContainer.inflate(R.layout.item_oration_hot_week, null);   
			            //获取控件对象   		           		           
		
			            listItemView.hot_week_list_info_image = (ImageView) convertView.findViewById(R.id.infor_image);
			            listItemView.hot_week_list_infotitle_text = (TextView)convertView.findViewById(R.id.info_title);    
			            listItemView.hot_week_go_off_text = (TextView) convertView.findViewById(R.id.go_off_text);
			            listItemView.hot_week_infor_price_text= (TextView) convertView.findViewById(R.id.infor_price_text);   ;
			            listItemView.hot_week_infor_agent_image = (ImageView) convertView.findViewById(R.id.infor_agent_image);
			            listItemView.infor_see_sum_text= (TextView) convertView.findViewById(R.id.infor_see_sum_text);   ;

			            
			            listItemView.hot_week_list_info_image.setBackgroundResource((Integer) listItems.get(   
			                    position).get("hot_week_list_info_image")); 
			            
			            listItemView.hot_week_list_infotitle_text.setText((String) listItems.get(position)   
			                    .get("hot_week_list_infotitle_text"));  
			            
			            listItemView.hot_week_go_off_text.setText((String) listItems.get(position)   
			                    .get("hot_week_go_off_text")); 
			            
			            listItemView.hot_week_infor_price_text.setText((String) listItems.get(position)   
			                    .get("hot_week_infor_price_text")); 
			            
			            listItemView.hot_week_infor_agent_image.setBackgroundResource((Integer) listItems.get(   
			                    position).get("hot_week_infor_agent_image")); 
			           
			            listItemView.infor_see_sum_text.setText((String) listItems.get(position)   
			                    .get("infor_see_sum_text")); 
			            
			            //设置控件集到convertView   
			            convertView.setTag(listItemView);   
			        }
			        else 
			        {   
			            listItemView = (ListItemView)convertView.getTag();   
			        }       
			        return convertView;   
		}
}
