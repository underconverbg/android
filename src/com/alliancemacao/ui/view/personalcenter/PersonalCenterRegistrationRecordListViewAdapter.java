package com.alliancemacao.ui.view.personalcenter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class PersonalCenterRegistrationRecordListViewAdapter extends BaseAdapter
{
	  private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   

	    public final class ListItemView
	    {          
	        public TextView registration_record_main;       
      

	 }     
	    
	    public PersonalCenterRegistrationRecordListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
			            convertView = listContainer.inflate(R.layout.item_personal_registration_record, null);   
			            //获取控件对象   
			           		            
			            listItemView.registration_record_main = (TextView) convertView.findViewById(R.id.registration_record_main_text);
			            
			            listItemView.registration_record_main.setText((String) listItems.get(position)   
			                    .get("registration_record_main"));   
			            
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
