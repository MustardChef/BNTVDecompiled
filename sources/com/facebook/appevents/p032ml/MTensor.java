package com.facebook.appevents.p032ml;

/* renamed from: com.facebook.appevents.ml.MTensor */
/* loaded from: classes.dex */
public class MTensor {
    private int capacity;
    private float[] data;
    private int[] shape;

    public MTensor(int[] iArr) {
        this.shape = iArr;
        int capacity = getCapacity(iArr);
        this.capacity = capacity;
        this.data = new float[capacity];
    }

    public float[] getData() {
        return this.data;
    }

    public int getShape(int i) {
        return this.shape[i];
    }

    public void reshape(int[] iArr) {
        this.shape = iArr;
        int capacity = getCapacity(iArr);
        float[] fArr = new float[capacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity));
        this.data = fArr;
        this.capacity = capacity;
    }

    public int getShapeSize() {
        return this.shape.length;
    }

    private static int getCapacity(int[] iArr) {
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        return i;
    }
}
