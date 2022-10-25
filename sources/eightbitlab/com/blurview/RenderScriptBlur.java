package eightbitlab.com.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes4.dex */
public final class RenderScriptBlur implements BlurAlgorithm {
    private final ScriptIntrinsicBlur blurScript;
    private Allocation outAllocation;
    private final RenderScript renderScript;
    private int lastBitmapWidth = -1;
    private int lastBitmapHeight = -1;

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public boolean canModifyBitmap() {
        return true;
    }

    public RenderScriptBlur(Context context) {
        RenderScript create = RenderScript.create(context);
        this.renderScript = create;
        this.blurScript = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    private boolean canReuseAllocation(Bitmap bitmap) {
        return bitmap.getHeight() == this.lastBitmapHeight && bitmap.getWidth() == this.lastBitmapWidth;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final Bitmap blur(Bitmap bitmap, float f) {
        Allocation createFromBitmap = Allocation.createFromBitmap(this.renderScript, bitmap);
        if (!canReuseAllocation(bitmap)) {
            Allocation allocation = this.outAllocation;
            if (allocation != null) {
                allocation.destroy();
            }
            this.outAllocation = Allocation.createTyped(this.renderScript, createFromBitmap.getType());
            this.lastBitmapWidth = bitmap.getWidth();
            this.lastBitmapHeight = bitmap.getHeight();
        }
        this.blurScript.setRadius(f);
        this.blurScript.setInput(createFromBitmap);
        this.blurScript.forEach(this.outAllocation);
        this.outAllocation.copyTo(bitmap);
        createFromBitmap.destroy();
        return bitmap;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void destroy() {
        this.blurScript.destroy();
        this.renderScript.destroy();
        Allocation allocation = this.outAllocation;
        if (allocation != null) {
            allocation.destroy();
        }
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public Bitmap.Config getSupportedBitmapConfig() {
        return Bitmap.Config.ARGB_8888;
    }
}
