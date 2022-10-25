package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxProgress() {
        return this.batchMax;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addProgress(long j) {
        if (this.currentRequestProgress == null) {
            RequestProgress requestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.currentRequestProgress = requestProgress;
            this.progressMap.put(this.currentRequest, requestProgress);
        }
        this.currentRequestProgress.addToMax(j);
        this.batchMax = (int) (this.batchMax + j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        addProgress(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        addProgress(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        addProgress(1L);
    }
}
