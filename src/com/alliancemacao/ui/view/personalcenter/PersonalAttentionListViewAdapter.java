package com.alliancemacao.ui.view.personalcenter;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alliancemacao.R;

@SuppressLint("CutPasteId")
public class PersonalAttentionListViewAdapter extends BaseAdapter
{
	  	private Context context;                        //运行上下文   
	    private List<Map<String, Object>> listItems;   
	    private LayoutInflater listContainer;           //视图容器   
	    private PersonalAttentionListCallBack myCallBack;
	    private Button attentBtn;
	    
	    public final class ListItemView
	    {              
	        public ImageView attenOperatorsIcon;       
	        public TextView attenOperatorsNameText;  
	        public Button attenOperatorsBtn;       
	        public TextView attenOperatorsIntroductionText; 
	    }     
	    
	    public void initCallBack(PersonalAttentionListCallBack callBack)
	    {
	    	myCallBack =callBack;
	    }
	    
	    public PersonalAttentionListViewAdapter(Context context, List<Map<String, Object>> listItems)
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
			            convertView = listContainer.inflate(R.layout.item_attention, null);   
			            //获取控件对象   
			          			 
			            listItemView.attenOperatorsIcon = (ImageView) convertView.findViewById(R.id.atten_operators_icon);
			            listItemView.attenOperatorsNameText = (TextView) convertView.findViewById(R.id.atten_operators_name_text);
			            listItemView.attenOperatorsBtn = (Button) convertView.findViewById(R.id.atten_operators_btn);
			            listItemView.attenOperatorsIntroductionText = (TextView) convertView.findViewById(R.id.atten_operators_introduction_text);
			            
			            if( listItems.get(position).get("atten_operators_icon")!=null)
			            {
			            	listItemView.attenOperatorsIcon.setBackgroundResource((Integer) listItems.get(   
			                    position).get("atten_operators_icon")); 
			            }
			            
			            if( listItems.get(position).get("atten_operators_name_text")!=null)
			            {
			            	listItemView.attenOperatorsNameText.setText((String) listItems.get(position)   
			                    .get("atten_operators_name_text"));   
			            }
			            
			            if( listItems.get(position).get("atten_operators_btn")!=null)
			            {
			            	listItemView.attenOperatorsBtn.setBackgroundResource((Integer) listItems.get(   
			                    position).get("atten_operators_btn")); 
			            }
			            
			            if( listItems.get(position).get("atten_operators_introduction_text")!=null)
			            {
			            	listItemView.attenOperatorsIntroductionText.setText((String) listItems.get(position)   
								.get("atten_operators_introduction_text"));  
			            }
			               
			            
			            //设置控件集到convertView   
			            convertView.setTag(listItemView);   
			        }
			        else 
			        {   
			            listItemView = (ListItemView)convertView.getTag();   
			        }    
			       
		            attentBtn = (Button) convertView.findViewById(R.id.atten_operators_btn);
	        		
			        attentBtn.setOnClickListener(new OnClickListener()
			        {
						public void onClick(View view)
						{
							myCallBack.onClickAttention(view);
						}
					});
			        
			        return convertView;   
		}
}
