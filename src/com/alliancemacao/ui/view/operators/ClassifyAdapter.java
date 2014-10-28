package com.alliancemacao.ui.view.operators;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alliancemacao.ui.view.informaction.ListViewAdapterCallBack;
import com.example.alliancemacao.R;

public class ClassifyAdapter extends BaseAdapter
{
	 private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   
	    ListViewAdapterCallBack myCallBack;


	    public final class ListItemView
	    {              
	        public TextView mainTextView;      
	    }     
	    
	    public void initListViewAdapterCallBack(ListViewAdapterCallBack callBack)
	    {
	    	myCallBack = callBack;
	    }
	    
	    
	    public ClassifyAdapter(Context context, List<Map<String, Object>> listItems)
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
			            convertView = listContainer.inflate(R.layout.item_classify_alone, null);   
			            //获取控件对象   
			            
			            listItemView.mainTextView = (TextView)convertView.findViewById(R.id.contentTextView);    			          
			     			            
			            listItemView.mainTextView.setText((String) listItems.get(position)   
			                    .get("main")); 
			            
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
