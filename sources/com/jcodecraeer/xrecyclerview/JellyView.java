package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* loaded from: classes3.dex */
public class JellyView extends View implements BaseRefreshHeader {
    private int jellyHeight;
    private int minimumHeight;
    Paint paint;
    Path path;

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public void refreshComplete() {
    }

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public boolean releaseAction() {
        return false;
    }

    public JellyView(Context context) {
        super(context);
        this.minimumHeight = 0;
        this.jellyHeight = 0;
        init();
    }

    public JellyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minimumHeight = 0;
        this.jellyHeight = 0;
        init();
    }

    public JellyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minimumHeight = 0;
        this.jellyHeight = 0;
        init();
    }

    public JellyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.minimumHeight = 0;
        this.jellyHeight = 0;
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        this.path = new Path();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(getContext().getResources().getColor(17170459));
        this.paint.setAntiAlias(true);
    }

    public void setJellyColor(int i) {
        this.paint.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.path.reset();
        this.path.lineTo(0.0f, this.minimumHeight);
        this.path.quadTo(getMeasuredWidth() / 2, this.minimumHeight + this.jellyHeight, getMeasuredWidth(), this.minimumHeight);
        this.path.lineTo(getMeasuredWidth(), 0.0f);
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.minimumHeight = i;
    }

    public void setJellyHeight(int i) {
        this.jellyHeight = i;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return this.minimumHeight;
    }

    public int getJellyHeight() {
        return this.jellyHeight;
    }

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public void onMove(float f) {
        this.jellyHeight += (int) f;
        Log.i("jellyHeight", "delta = " + f);
        invalidate();
    }
}
