package com.alliancemacao.ui.view.search;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alliancemacao.R;

public class SearchMainListViewAdapter extends BaseAdapter
{
    private Context context;                        //运行上下文   
    private List<Map<String, Object>> listItems;   
    private LayoutInflater listContainer;           //视图容器   
    SearchMainListViewAdapterCallBack myCallBack;


    public final class ListItemView
    {              
        public TextView addTitle;
		public ImageButton rightBtn;   
		public ImageView inforImageI;
		public ImageView inforImageII;
		public TextView introductionI;
		public TextView introductionII;
		public TextView operatorI;
		public TextView operatorII;
		public TextView priceII;
		public TextView priceI;
    }     
    
    public void initListViewAdapterCallBack(SearchMainListViewAdapterCallBack callBack)
    {
    	myCallBack = callBack;
    }
    
    
    public SearchMainListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
		            convertView = listContainer.inflate(R.layout.item_search_infor, null);   
		            //获取控件对象   
		            
		            listItemView.addTitle = (TextView) convertView.findViewById(R.id.search_add_title);
		            listItemView.rightBtn = (ImageButton) convertView.findViewById(R.id.search_return_right_btn);
		            
		            listItemView.inforImageI = (ImageView) convertView.findViewById(R.id.search_img_i);
		            listItemView.inforImageII = (ImageView) convertView.findViewById(R.id.search_img_ii);

		            listItemView.introductionI = (TextView) convertView.findViewById(R.id.search_infor_introduction_text_i);
		            listItemView.introductionII = (TextView) convertView.findViewById(R.id.search_infor_introduction_text_ii);
		            
		            listItemView.operatorI = (TextView)convertView.findViewById(R.id.search_infor_operator_text_i);    
		            listItemView.operatorII = (TextView)convertView.findViewById(R.id.search_infor_operator_text_ii);   
		            
		            
		            listItemView.priceI = (TextView)convertView.findViewById(R.id.search_infor_price_text_i);    
		            listItemView.priceII = (TextView)convertView.findViewById(R.id.search_infor_price_text_ii);  
		              
		            listItemView.addTitle.setText((CharSequence) listItems.get(position).get("add_title"));	            
//		            listItemView.rightBtn.setBackgroundResource((Integer) listItems.get(position)   
//		                    .get("right_btn"));  
		            
		            listItemView.inforImageI.setBackgroundResource((Integer) listItems.get(position)   
		                    .get("infor_image_i"));      
		            listItemView.inforImageII.setBackgroundResource((Integer) listItems.get(position)   
		                    .get("infor_image_ii"));  
		            
		            listItemView.introductionI.setText((CharSequence) listItems.get(position)   
		                    .get("introduction_i"));      
		            listItemView.introductionII.setText((CharSequence) listItems.get(position)   
		                    .get("introduction_ii"));  
		                    
		            listItemView.operatorI.setText((CharSequence) listItems.get(position)   
		                    .get("operator_i"));      
		            listItemView.operatorII.setText((CharSequence) listItems.get(position)   
		                    .get("operator_ii"));  
		            
		            listItemView.priceI.setText((CharSequence) listItems.get(position)   
		                    .get("price_i"));      
		            listItemView.priceII.setText((CharSequence) listItems.get(position)   
		                    .get("price_ii"));  
		            
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
