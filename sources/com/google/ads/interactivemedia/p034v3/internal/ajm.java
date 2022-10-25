package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.CompanionData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajm */
/* loaded from: classes2.dex */
public final class ajm extends ImageView implements View.OnClickListener {

    /* renamed from: a */
    private final CompanionData f4237a;

    /* renamed from: b */
    private final ajx f4238b;

    /* renamed from: c */
    private final String f4239c;

    /* renamed from: d */
    private final List f4240d;

    /* renamed from: e */
    private final alw f4241e;

    public ajm(Context context, ajx ajxVar, CompanionData companionData, Task task, String str, List list, alw alwVar) {
        super(context);
        this.f4238b = ajxVar;
        this.f4237a = companionData;
        this.f4239c = str;
        this.f4240d = list;
        this.f4241e = alwVar;
        setOnClickListener(this);
        task.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.internal.ajl
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                ajm ajmVar = ajm.this;
                if (task2.isSuccessful()) {
                    ajmVar.setImageBitmap((Bitmap) task2.getResult());
                } else {
                    C2525p.m5990b("Image companion error", task2.getException());
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        for (CompanionAdSlot.ClickListener clickListener : this.f4240d) {
            clickListener.onCompanionAdClick();
        }
        this.f4241e.m5011a(this.f4237a.clickThroughUrl());
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ajx ajxVar = this.f4238b;
        String companionId = this.f4237a.companionId();
        String str = this.f4239c;
        if (atm.m4619c(companionId) || atm.m4619c(str)) {
            return;
        }
        HashMap m4394r = axd.m4394r(1);
        m4394r.put("companionId", companionId);
        ajxVar.mo5122o(new ajq(ajo.displayContainer, ajp.companionView, str, m4394r));
    }
}
