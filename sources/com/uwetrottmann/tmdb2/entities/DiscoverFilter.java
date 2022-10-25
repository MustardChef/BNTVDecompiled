package com.uwetrottmann.tmdb2.entities;

import com.uwetrottmann.tmdb2.enumerations.ReleaseType;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
public class DiscoverFilter {
    @Nonnull
    private final Integer[] items;
    @Nonnull
    private final Separator separator;

    /* loaded from: classes4.dex */
    public enum Separator {
        AND(","),
        OR("|");
        
        private final String symbol;

        Separator(String str) {
            this.symbol = str;
        }
    }

    public DiscoverFilter(@Nonnull Integer... numArr) {
        this(Separator.AND, numArr);
    }

    public DiscoverFilter(@Nonnull Separator separator, @Nonnull Integer... numArr) {
        this.separator = separator;
        this.items = numArr;
    }

    public DiscoverFilter(@Nonnull Separator separator, @Nonnull ReleaseType... releaseTypeArr) {
        this.separator = separator;
        this.items = new Integer[releaseTypeArr.length];
        for (int i = 0; i < releaseTypeArr.length; i++) {
            ReleaseType releaseType = releaseTypeArr[i];
            if (releaseType != null) {
                this.items[i] = Integer.valueOf(releaseType.f10086id);
            }
        }
    }

    public String toString() {
        Integer[] numArr;
        Integer[] numArr2;
        if (this.separator == null || (numArr = this.items) == null || numArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : this.items) {
            if (num != null) {
                if (sb.length() > 0) {
                    sb.append(this.separator.symbol);
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
