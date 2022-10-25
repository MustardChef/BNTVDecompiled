package com.phimhd;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bongngotv2.R;

/* loaded from: classes4.dex */
public class ServerMaintenanceActivity extends BaseActivity {
    @Override // com.phimhd.BaseActivity
    protected int initLayout() {
        return R.layout.server_activity;
    }

    @Override // com.phimhd.BaseActivity
    protected void initVariables() {
    }

    @Override // com.phimhd.BaseActivity
    protected void initViews() {
        findViewById(R.id.tvInfo).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.ServerMaintenanceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(Constants.URL_WEBSITE));
                ServerMaintenanceActivity.this.startActivity(intent);
            }
        });
    }
}
