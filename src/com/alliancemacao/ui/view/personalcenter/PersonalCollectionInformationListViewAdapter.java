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

public class PersonalCollectionInformationListViewAdapter extends BaseAdapter
{
	  private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   

	    public final class ListItemView
	    {              
	        public ImageView personOperatorInforImg;       
	        public TextView personOperatorInforIntroductionText;  
	        public TextView personOperatorInforOperatorText;       
	        public TextView personOperatorInforPriceText; 
	    }     
	    
	    public PersonalCollectionInformationListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
			        if (convertView == null) 
			        {   
			            listItemView = new ListItemView();    
			            //获取list_item布局文件的视图   
			            convertView = listContainer.inflate(R.layout.item_operator_infor, null);   
			            //获取控件对象   
			          			 
			            listItemView.personOperatorInforImg = (ImageView) convertView.findViewById(R.id.operator_infor_img);
			            listItemView.personOperatorInforIntroductionText = (TextView) convertView.findViewById(R.id.operator_infor_introduction_text);
			            listItemView.personOperatorInforOperatorText = (TextView) convertView.findViewById(R.id.operator_infor_operator_text);
			            listItemView.personOperatorInforPriceText = (TextView) convertView.findViewById(R.id.operator_infor_price_text);
			            
			            listItemView.personOperatorInforImg.setBackgroundResource((Integer) listItems.get(   
			                    position).get("operator_infor_img")); 
			            
			            listItemView.personOperatorInforIntroductionText.setText((String) listItems.get(position)   
			                    .get("operator_infor_introduction_text"));   
			            
						listItemView.personOperatorInforOperatorText.setText((String) listItems.get(position)   
								.get("operator_infor_operator_text"));   
						
						listItemView.personOperatorInforPriceText.setText((String) listItems.get(position)   
								.get("operator_infor_price_text"));  
						
			            //设置控件集到convertView   
			            convertView.setTag(listItemView);   
			        }
			        else 
			        {   
			            listItemView = (ListItemView)convertView.getTag();   
			        }       
			        
			        //TODO
			        //预备回调
			        
			        return convertView;   
		}
}
