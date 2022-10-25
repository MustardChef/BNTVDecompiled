package com.blankj.utilcode.util;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SPUtils {
    private SharedPreferences.Editor editor;

    /* renamed from: sp */
    private SharedPreferences f2723sp;

    public SPUtils(String str) {
        SharedPreferences sharedPreferences = Utils.getContext().getSharedPreferences(str, 0);
        this.f2723sp = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.editor = edit;
        edit.apply();
    }

    public void clear() {
        this.editor.clear().apply();
    }

    public boolean contains(String str) {
        return this.f2723sp.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.f2723sp.getAll();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f2723sp.getBoolean(str, z);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public float getFloat(String str, float f) {
        return this.f2723sp.getFloat(str, f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public int getInt(String str, int i) {
        return this.f2723sp.getInt(str, i);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public long getLong(String str, long j) {
        return this.f2723sp.getLong(str, j);
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        return this.f2723sp.getString(str, str2);
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, null);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f2723sp.getStringSet(str, set);
    }

    public void put(String str, float f) {
        this.editor.putFloat(str, f).apply();
    }

    public void put(String str, int i) {
        this.editor.putInt(str, i).apply();
    }

    public void put(String str, long j) {
        this.editor.putLong(str, j).apply();
    }

    public void put(String str, String str2) {
        this.editor.putString(str, str2).apply();
    }

    public void put(String str, Set<String> set) {
        this.editor.putStringSet(str, set).apply();
    }

    public void put(String str, boolean z) {
        this.editor.putBoolean(str, z).apply();
    }

    public void remove(String str) {
        this.editor.remove(str).apply();
    }
}
