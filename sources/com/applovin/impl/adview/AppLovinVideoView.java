package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;
import com.applovin.impl.sdk.C1662k;

/* loaded from: classes.dex */
public class AppLovinVideoView extends VideoView {
    public AppLovinVideoView(Context context, C1662k c1662k) {
        super(context, null, 0);
    }

    public void setVideoSize(int i, int i2) {
        getHolder().setFixedSize(i, i2);
        requestLayout();
        invalidate();
    }
}
