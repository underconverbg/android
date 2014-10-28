package com.alliancemacao.ui.view.dynamic;

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

public class DynamicStrategyListViewAdapter extends BaseAdapter
{
    private Context context;                        //运行上下文   
    private List<Map<String, Object>> listItems;   
    private LayoutInflater listContainer;           //视图容器   

    public final class ListItemView
    {              
        public ImageView inforImage;     
        public TextView stragtegyText;     
        public ImageView agentImage;   
 }     
    
    public DynamicStrategyListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
		            convertView = listContainer.inflate(R.layout.item_dynamic_stragtegy, null);   
		            //获取控件对象   
		            
		            listItemView.inforImage = (ImageView) convertView.findViewById(R.id.dynamic_stragtergy_infor_image);
		            listItemView.stragtegyText = (TextView)convertView.findViewById(R.id.stragtegy_text);    
		            listItemView.agentImage = (ImageView)convertView.findViewById(R.id.dynamic_agent_image);   
		            
		              
		            listItemView.inforImage.setBackgroundResource((Integer) listItems.get(   
		                    position).get("infor_image")); 
		            
		            listItemView.stragtegyText.setText((String) listItems.get(position)   
		                    .get("stragtegy_text"));  
		            
		            listItemView.agentImage.setBackgroundResource((Integer) listItems.get(   
		                    position).get("agent_image")); 
		            
		           
		            
		            //设置控件集到convertView   
		            convertView.setTag(listItemView);   
		        }
		        else 
		        {   
		            listItemView = (ListItemView)convertView.getTag();   
		        }   
	           
	
//		        listItemView.detail.setOnClickListener(new View.OnClickListener() {   
//		            @Override  
//		            public void onClick(View v) {   
//		                //显示物品详情   
//		                showDetailInfo(selectID);   
//		            }   
//		        });   
		   
		           
		        return convertView;   
	}
}
