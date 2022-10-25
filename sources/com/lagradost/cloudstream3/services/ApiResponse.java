package com.lagradost.cloudstream3.services;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class ApiResponse<T> {
    @SerializedName(alternate = {"errorId"}, value = "code")
    int code;
    @SerializedName("Count")
    int count;
    @SerializedName("data")
    T data;
    @SerializedName(alternate = {"content"}, value = "message")
    String message;
    @SerializedName("predictions")
    T place;
    @SerializedName("results")
    T placeNearBy;
    @SerializedName("routes")
    T routes;
    @SerializedName("success")
    boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public T getRoutes() {
        return this.routes;
    }

    public void setRoutes(T t) {
        this.routes = t;
    }

    public T getPlaceNearBy() {
        return this.placeNearBy;
    }

    public void setPlaceNearBy(T t) {
        this.placeNearBy = t;
    }

    public ApiResponse() {
    }

    public ApiResponse(String str, boolean z) {
        this.message = str;
        this.success = z;
    }

    public ApiResponse(T t, String str, boolean z) {
        this.data = t;
        this.message = str;
        this.success = z;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public int getCount() {
        return this.count;
    }

    public T getPlace() {
        return this.place;
    }

    public void setPlace(T t) {
        this.place = t;
    }

    public void setCount(int i) {
        this.count = i;
    }
}
