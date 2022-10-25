package com.lagradost.cloudstream3.services;

import com.blankj.utilcode.util.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
public abstract class CallBackBase<T> implements Callback<T> {
    private Call<T> call;

    public abstract void onRequestFailure(Call<T> call, Throwable th);

    public abstract void onRequestSuccess(Call<T> call, Response<T> response);

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        onRequestSuccess(call, response);
    }

    void enqueueAgain() {
        this.call.enqueue(this);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable th) {
        LogUtils.m6083a(call.request().toString() + "\n" + th.getMessage());
        onRequestFailure(call, th);
    }
}
