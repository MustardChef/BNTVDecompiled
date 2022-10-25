package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class HeartBeatInfoStorage {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy z");
    private static final String GLOBAL = "fire-global";
    private static final int HEART_BEAT_COUNT_LIMIT = 200;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static final String STORAGE_PREFERENCES_NAME = "FirebaseAppHeartBeatStorage";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences heartBeatSharedPreferences;
    private final SharedPreferences sharedPreferences;

    private HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        this.heartBeatSharedPreferences = context.getSharedPreferences(STORAGE_PREFERENCES_NAME, 0);
    }

    HeartBeatInfoStorage(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences;
        this.heartBeatSharedPreferences = sharedPreferences2;
    }

    int getHeartBeatCount() {
        return (int) this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized HeartBeatInfoStorage getInstance(Context context) {
        HeartBeatInfoStorage heartBeatInfoStorage;
        synchronized (HeartBeatInfoStorage.class) {
            if (instance == null) {
                instance = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = instance;
        }
        return heartBeatInfoStorage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void storeHeartBeatInformation(String str, long j) {
        long j2 = this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        this.heartBeatSharedPreferences.edit().putString(String.valueOf(j), str).apply();
        long j3 = j2 + 1;
        this.sharedPreferences.edit().putLong(HEART_BEAT_COUNT_TAG, j3).apply();
        if (j3 > 200) {
            cleanUpStoredHeartBeats();
        }
    }

    private synchronized void cleanUpStoredHeartBeats() {
        long j = this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.heartBeatSharedPreferences.getAll().entrySet()) {
            arrayList.add(Long.valueOf(Long.parseLong(entry.getKey())));
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.heartBeatSharedPreferences.edit().remove(String.valueOf((Long) it.next())).apply();
            j--;
            this.sharedPreferences.edit().putLong(HEART_BEAT_COUNT_TAG, j).apply();
            if (j <= 100) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getLastGlobalHeartBeat() {
        return this.sharedPreferences.getLong(GLOBAL, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateGlobalHeartBeat(long j) {
        this.sharedPreferences.edit().putLong(GLOBAL, j).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<SdkHeartBeatResult> getStoredHeartBeats(boolean z) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.heartBeatSharedPreferences.getAll().entrySet()) {
            arrayList.add(SdkHeartBeatResult.create((String) entry.getValue(), Long.parseLong(entry.getKey())));
        }
        Collections.sort(arrayList);
        if (z) {
            clearStoredHeartBeats();
        }
        return arrayList;
    }

    synchronized void clearStoredHeartBeats() {
        this.heartBeatSharedPreferences.edit().clear().apply();
        this.sharedPreferences.edit().remove(HEART_BEAT_COUNT_TAG).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameDateUtc(long j, long j2) {
        Date date = new Date(j);
        Date date2 = new Date(j2);
        SimpleDateFormat simpleDateFormat = FORMATTER;
        return !simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean shouldSendSdkHeartBeat(String str, long j) {
        if (this.sharedPreferences.contains(str)) {
            if (isSameDateUtc(this.sharedPreferences.getLong(str, -1L), j)) {
                this.sharedPreferences.edit().putLong(str, j).apply();
                return true;
            }
            return false;
        }
        this.sharedPreferences.edit().putLong(str, j).apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat(GLOBAL, j);
    }
}
