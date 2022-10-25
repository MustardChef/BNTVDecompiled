package com.uwetrottmann.tmdb2.entities;

import com.uwetrottmann.tmdb2.enumerations.AppendToResponseItem;

/* loaded from: classes4.dex */
public class AppendToResponse {
    private final AppendToResponseItem[] items;

    public AppendToResponse(AppendToResponseItem... appendToResponseItemArr) {
        this.items = appendToResponseItemArr;
    }

    public String toString() {
        AppendToResponseItem[] appendToResponseItemArr = this.items;
        if (appendToResponseItemArr == null || appendToResponseItemArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            AppendToResponseItem[] appendToResponseItemArr2 = this.items;
            if (i < appendToResponseItemArr2.length) {
                sb.append(appendToResponseItemArr2[i]);
                if (i < this.items.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                return sb.toString();
            }
        }
    }
}
