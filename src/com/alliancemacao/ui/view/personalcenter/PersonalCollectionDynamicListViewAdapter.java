package com.alliancemacao.ui.view.personalcenter;

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

public class PersonalCollectionDynamicListViewAdapter extends BaseAdapter
{
	  private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   

	    public final class ListItemView
	    {          
	        public ImageView personOperatorCollImg;       
	        public TextView personOperatorCollIntroductionText;  
	        public TextView personOperatorCollOperatorText;       
	    }     
	    
	    public PersonalCollectionDynamicListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
			            convertView = listContainer.inflate(R.layout.item_operator_dynamic, null);   
			            //获取控件对象   
			           		            
			            listItemView.personOperatorCollImg =  (ImageView) convertView.findViewById(R.id.operator_dynamic_img); 
			            listItemView.personOperatorCollImg.setBackgroundResource((Integer) listItems.get(   
			                    position).get("operator_dynamic_img")); 
			            
			            listItemView.personOperatorCollIntroductionText = (TextView) convertView.findViewById(R.id.operator_dynamic_operators);
			            listItemView.personOperatorCollIntroductionText.setText((String) listItems.get(position)   
			                    .get("operator_dynamic_operators"));
			            
			            listItemView.personOperatorCollOperatorText = (TextView) convertView.findViewById(R.id.operator_dynamic_introduction);			            
			            listItemView.personOperatorCollOperatorText.setText((String) listItems.get(position)   
			                    .get("operator_dynamic_introduction"));
			            
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

