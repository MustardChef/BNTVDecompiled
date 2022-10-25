package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

/* loaded from: classes4.dex */
public class BrightnessFilterTransformation extends GPUFilterTransformation {

    /* renamed from: ID */
    private static final String f10619ID = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";
    private static final int VERSION = 1;
    private float brightness;

    public BrightnessFilterTransformation() {
        this(0.0f);
    }

    public BrightnessFilterTransformation(float f) {
        super(new GPUImageBrightnessFilter());
        this.brightness = f;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(this.brightness);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.brightness + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof BrightnessFilterTransformation) && ((BrightnessFilterTransformation) obj).brightness == this.brightness;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1311211954) + ((int) ((this.brightness + 1.0f) * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((f10619ID + this.brightness).getBytes(CHARSET));
    }
}
