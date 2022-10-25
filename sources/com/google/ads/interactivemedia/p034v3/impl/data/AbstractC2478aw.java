package com.google.ads.interactivemedia.p034v3.impl.data;

import android.view.View;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.aw */
/* loaded from: classes2.dex */
public abstract class AbstractC2478aw {
    public abstract AbstractC2479ax build();

    public abstract AbstractC2478aw height(int i);

    public abstract AbstractC2478aw left(int i);

    public AbstractC2478aw locationOnScreenOfView(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return left(iArr[0]).top(iArr[1]).height(view.getHeight()).width(view.getWidth());
    }

    public abstract AbstractC2478aw top(int i);

    public abstract AbstractC2478aw width(int i);
}
