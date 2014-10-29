package com.alliancemacao.ui.activity.operator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.alliancemacao.R;

public class OperatorAddressActivity extends Activity
{
	 public MapView mMapView = null;
	 public BaiduMap mbaiduMap =null;
	 public LocationClient mLocationClient = null;
	 public BDLocationListener myListener = new MyLocationListener();

	 public void onCreate(Bundle savedInstanceState)
	 {
	    	super.onCreate(savedInstanceState);
	        //在使用SDK各组件之前初始化context信息，传入ApplicationContext  
	        //注意该方法要再setContentView方法之前实现
	        SDKInitializer.initialize(getApplicationContext());  
			setContentView(R.layout.activity_map);
			initTitle();
	        mMapView = (MapView) findViewById(R.id.bmapView);
	        
	        LatLng myLng = new LatLng(22,113);
            setMap(myLng);
            
	        mbaiduMap =  mMapView.getMap();
	        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
	        mLocationClient.registerLocationListener( myListener );    //注册监听函数
	        mLocationClient.start();
	 }	
	 
	 

	
	    
	@SuppressLint("NewApi")
	private void initTitle()
	{
			TextView title = (TextView) this.findViewById(R.id.main_title_text);
			title.setText("商户详情");
			
			Button leftBtn = (Button) findViewById(R.id.main_title_left);
			leftBtn.setBackground(getResources().getDrawable(R.drawable.title_left_btn));
			leftBtn.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View arg0) 
				{
					OperatorAddressActivity.this.finish();
				}
			});
	} 
	
	
	public class MyLocationListener implements BDLocationListener 
	{
		@Override
		public void onReceiveLocation(BDLocation location)
		{
			if (location == null)
		            return ;
			StringBuffer sb = new StringBuffer(256);
			sb.append("time : ");
			sb.append(location.getTime());
			sb.append("\nerror code : ");
			sb.append(location.getLocType());
			sb.append("\nlatitude : ");
			sb.append(location.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(location.getLongitude());
			sb.append("\nradius : ");
			sb.append(location.getRadius());
			if (location.getLocType() == BDLocation.TypeGpsLocation)
			{
				sb.append("\nspeed : ");
				sb.append(location.getSpeed());
				sb.append("\nsatellite : ");
				sb.append(location.getSatelliteNumber());
			}
			else if (location.getLocType() == BDLocation.TypeNetWorkLocation)
			{
				sb.append("\naddr : ");
				sb.append(location.getAddrStr());
			} 
            Log.e("定位结果：",sb.toString());
            
            LatLng point = new LatLng(location.getLatitude(), location.getLongitude());  
          //构建Marker图标  
            BitmapDescriptor bitmap = BitmapDescriptorFactory  
              .fromResource(R.drawable.ic_launcher);  
            OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);   
            mMapView.getMap().addOverlay(option);
            
            MyLocationData locData = new MyLocationData.Builder().accuracy(location.getRadius()).direction(100).latitude(location.getLatitude())  
            .longitude(location.getLongitude()).build();  
            
            mMapView.getMap().setMyLocationData(locData);  
            
            LatLng myLng = new LatLng(location.getLatitude(),location.getLongitude());
            setMap(myLng);
           
            mMapView.getMap().setMyLocationEnabled(false);
          
		}
	}
	
	
	 protected void onDestroy() 
	 {  
	        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
	        super.onDestroy();  
	        mMapView.onDestroy();  
	 } 
	 
	    @Override  
	 protected void onResume()
	 {  
	        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理  
	    	super.onResume();  
	        mMapView.onResume();  
	 }
	    
	 @Override  
	 protected void onPause() 
	 {  
	        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理  
	        super.onPause();  
	        mMapView.onPause();  
	 }  
	 

	 private void setMap(LatLng mLatLng)
	 {
         
         MapStatus mMapStatus = new MapStatus.Builder()
         .target(mLatLng)
         .zoom(18)
         .build();
         //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化

         MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
         //改变地图状态
         mMapView.getMap().setMapStatus(mMapStatusUpdate); 
	 }
}


