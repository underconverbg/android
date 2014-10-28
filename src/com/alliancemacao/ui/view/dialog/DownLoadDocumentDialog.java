package com.alliancemacao.ui.view.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.alliancemacao.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class DownLoadDocumentDialog extends Dialog
{
    Context context;
    DownLoadDocumentDialogCallBack myCallBack;
    
    LinearLayout tourPrice = null;
    LinearLayout travelStandard = null;
    LinearLayout specialAgreement = null;
    LinearLayout cancel = null;


	public DownLoadDocumentDialog(Context context) 
	{
		super(context);
        this.context = context;

	}
	
    public DownLoadDocumentDialog(Context context, int theme,DownLoadDocumentDialogCallBack callBack)
    {
        super(context, theme);
        this.context = context;
        myCallBack = callBack;
    }
 

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_download_document);
        
        tourPrice = (LinearLayout) findViewById(R.id.tourprice_layout);
        travelStandard = (LinearLayout) findViewById(R.id.downlaod_dialog_travel_standard_layout);
        specialAgreement = (LinearLayout) findViewById(R.id.downlaod_dialog_special_agreement_layout);
        cancel = (LinearLayout) findViewById(R.id.download_dialog_cencel_layout);
        
        if(myCallBack != null)
        {
        	tourPrice.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {

                	myCallBack.onClickTourPrice();
                }
        	});
        	
        	travelStandard.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {

                	myCallBack.onClickTravelStandard();

                }
        	});
        	
        	specialAgreement.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	myCallBack.onClickSpecialAgreement();
                }
        	});
        	
        	cancel.setOnClickListener(new View.OnClickListener() 
        	{
                public void onClick(View v)
                {
                	myCallBack.onClickCancel();
                	DownLoadDocumentDialog.this.dismiss();
                }
        	});
        }
        
    }

}
