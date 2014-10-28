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

public class OperatorInforListViewAdapter extends BaseAdapter
{
    private Context context;                        //运行上下文   
    private List<Map<String, Object>> listItems;   
    private LayoutInflater listContainer;           //视图容器   

    public final class ListItemView
    {              
        public ImageView tourist_list_area_img;     
        public TextView tourist_list_area_tv;     
        public TextView tourist_list_area_introduction_tv;
        public ImageView tourist_list_right_btn;   
 }     
    
    public OperatorInforListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
		            convertView = listContainer.inflate(R.layout.item_oration_tourist_group_infor, null);   
		            //获取控件对象   
		           		            
		            listItemView.tourist_list_area_img = (ImageView) convertView.findViewById(R.id.tourist_list_area_img);
		            listItemView.tourist_list_area_tv = (TextView)convertView.findViewById(R.id.tourist_list_area_tv);    
		            listItemView.tourist_list_area_introduction_tv = (TextView) convertView.findViewById(R.id.tourist_list_area_introduction_tv);
		            listItemView.tourist_list_right_btn= (ImageView) convertView.findViewById(R.id.tourist_list_right_btn);   ;
		              
		            listItemView.tourist_list_area_img.setBackgroundResource((Integer) listItems.get(   
		                    position).get("area_img")); 
		            
		            listItemView.tourist_list_area_tv.setText((String) listItems.get(position)   
		                    .get("area_tv"));  		         
		            
		            listItemView.tourist_list_area_introduction_tv.setText((String) listItems.get(position)   
		                    .get("introduction_tv"));  
		           
//		            listItemView.tourist_list_right_btn.setBackgroundResource((Integer) listItems.get(   
//		                    position).get("right_btn"));
		            
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

