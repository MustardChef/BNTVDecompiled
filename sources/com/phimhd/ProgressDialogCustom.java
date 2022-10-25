package com.phimhd;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bongngotv2.R;

/* loaded from: classes4.dex */
public class ProgressDialogCustom extends ProgressDialog {
    Context context;
    private Dialog mProgressDialog;
    private TextView tvMess;

    public ProgressDialogCustom(Context context, String str, boolean z) {
        super(context);
        this.context = context;
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.mProgressDialog = progressDialog;
        progressDialog.setCancelable(z);
    }

    public ProgressDialogCustom(Context context) {
        super(context);
        this.context = context;
        LayoutInflater from = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        this.mProgressDialog = dialog;
        dialog.getWindow().requestFeature(1);
        View inflate = from.inflate(R.layout.dialog_loading, (ViewGroup) null, false);
        this.mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mProgressDialog.setContentView(inflate);
        this.mProgressDialog.setCancelable(false);
    }

    public void showDialog() {
        try {
            Dialog dialog = this.mProgressDialog;
            if (dialog != null) {
                dialog.show();
                new Handler().postDelayed(new Runnable() { // from class: com.phimhd.-$$Lambda$ProgressDialogCustom$eGqn8FACWAlRWpsLs6D4hSG2urg
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProgressDialogCustom.this.lambda$showDialog$0$ProgressDialogCustom();
                    }
                }, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void lambda$showDialog$0$ProgressDialogCustom() {
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
    }

    public void hideDialog() {
        try {
            Dialog dialog = this.mProgressDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.mProgressDialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
