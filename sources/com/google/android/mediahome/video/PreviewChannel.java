package com.google.android.mediahome.video;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URISyntaxException;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
public class PreviewChannel {
    ContentValues values;

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        ContentValues values;

        public Builder() {
            this.values = new ContentValues();
        }

        public PreviewChannel build() {
            if (TextUtils.isEmpty(this.values.getAsString("display_name"))) {
                throw new IllegalStateException("Need channel name. Use method setDisplayName(String) to set it.");
            }
            if (TextUtils.isEmpty(this.values.getAsString("app_link_intent_uri"))) {
                throw new IllegalStateException("Need app link intent uri for channel. Use method setAppLinkIntent or setAppLinkIntentUri to set it.");
            }
            return new PreviewChannel(this);
        }

        public Builder setAppLinkIconUri(Uri uri) {
            this.values.put("app_link_icon_uri", uri == null ? null : uri.toString());
            return this;
        }

        public Builder setAppLinkIntent(Intent intent) {
            setAppLinkIntentUri(Uri.parse(intent.toUri(1)));
            return this;
        }

        public Builder setAppLinkIntentUri(Uri uri) {
            this.values.put("app_link_intent_uri", uri == null ? null : uri.toString());
            return this;
        }

        public Builder setAppLinkText(String str) {
            this.values.put("app_link_text", str);
            return this;
        }

        public Builder setDescription(String str) {
            if (str == null) {
                this.values.remove("description");
            } else {
                this.values.put("description", str);
            }
            return this;
        }

        public Builder setDisplayName(String str) {
            this.values.put("display_name", str);
            return this;
        }

        Builder setId(long j) {
            this.values.put("_id", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderData(byte[] bArr) {
            this.values.put("internal_provider_data", bArr);
            return this;
        }

        public Builder setInternalProviderFlag1(long j) {
            this.values.put("internal_provider_flag1", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag2(long j) {
            this.values.put("internal_provider_flag2", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag3(long j) {
            this.values.put("internal_provider_flag3", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag4(long j) {
            this.values.put("internal_provider_flag4", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderId(String str) {
            this.values.put("internal_provider_id", str);
            return this;
        }

        Builder setPackageName(String str) {
            this.values.put("package_name", str);
            return this;
        }

        public Builder(PreviewChannel previewChannel) {
            this.values = new ContentValues(previewChannel.values);
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    static class Columns {
        static final String[] PROJECTION = {"_id", "package_name", "display_name", "description", "app_link_icon_uri", "app_link_intent_uri", "app_link_text", "internal_provider_id", "internal_provider_data", "internal_provider_flag1", "internal_provider_flag2", "internal_provider_flag3", "internal_provider_flag4"};

        private Columns() {
        }
    }

    PreviewChannel(Builder builder) {
        this.values = builder.values;
    }

    public static PreviewChannel fromCursor(Cursor cursor) {
        Builder builder = new Builder();
        int columnIndex = cursor.getColumnIndex("_id");
        if (columnIndex >= 0 && !cursor.isNull(columnIndex)) {
            builder.setId(cursor.getLong(columnIndex));
        }
        int columnIndex2 = cursor.getColumnIndex("package_name");
        if (columnIndex2 >= 0 && !cursor.isNull(columnIndex2)) {
            builder.setPackageName(cursor.getString(columnIndex2));
        }
        int columnIndex3 = cursor.getColumnIndex("display_name");
        if (columnIndex3 >= 0 && !cursor.isNull(columnIndex3)) {
            builder.setDisplayName(cursor.getString(columnIndex3));
        }
        int columnIndex4 = cursor.getColumnIndex("description");
        if (columnIndex4 >= 0 && !cursor.isNull(columnIndex4)) {
            builder.setDescription(cursor.getString(columnIndex4));
        }
        int columnIndex5 = cursor.getColumnIndex("app_link_icon_uri");
        if (columnIndex5 >= 0 && !cursor.isNull(columnIndex5)) {
            builder.setAppLinkIconUri(Uri.parse(cursor.getString(columnIndex5)));
        }
        int columnIndex6 = cursor.getColumnIndex("app_link_text");
        if (columnIndex6 >= 0 && !cursor.isNull(columnIndex6)) {
            builder.setAppLinkText(cursor.getString(columnIndex6));
        }
        int columnIndex7 = cursor.getColumnIndex("app_link_intent_uri");
        if (columnIndex7 >= 0 && !cursor.isNull(columnIndex7)) {
            builder.setAppLinkIntentUri(Uri.parse(cursor.getString(columnIndex7)));
        }
        int columnIndex8 = cursor.getColumnIndex("internal_provider_id");
        if (columnIndex8 >= 0 && !cursor.isNull(columnIndex8)) {
            builder.setInternalProviderId(cursor.getString(columnIndex8));
        }
        int columnIndex9 = cursor.getColumnIndex("internal_provider_data");
        if (columnIndex9 >= 0 && !cursor.isNull(columnIndex9)) {
            builder.setInternalProviderData(cursor.getBlob(columnIndex9));
        }
        int columnIndex10 = cursor.getColumnIndex("internal_provider_flag1");
        if (columnIndex10 >= 0 && !cursor.isNull(columnIndex10)) {
            builder.setInternalProviderFlag1(cursor.getLong(columnIndex10));
        }
        int columnIndex11 = cursor.getColumnIndex("internal_provider_flag2");
        if (columnIndex11 >= 0 && !cursor.isNull(columnIndex11)) {
            builder.setInternalProviderFlag2(cursor.getLong(columnIndex11));
        }
        int columnIndex12 = cursor.getColumnIndex("internal_provider_flag3");
        if (columnIndex12 >= 0 && !cursor.isNull(columnIndex12)) {
            builder.setInternalProviderFlag3(cursor.getLong(columnIndex12));
        }
        int columnIndex13 = cursor.getColumnIndex("internal_provider_flag4");
        if (columnIndex13 >= 0 && !cursor.isNull(columnIndex13)) {
            builder.setInternalProviderFlag4(cursor.getLong(columnIndex13));
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreviewChannel) {
            return this.values.equals(((PreviewChannel) obj).values);
        }
        return false;
    }

    public Uri getAppLinkIconUri() {
        String asString = this.values.getAsString("app_link_icon_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public Intent getAppLinkIntent() throws URISyntaxException {
        String asString = this.values.getAsString("app_link_intent_uri");
        if (asString == null) {
            return null;
        }
        return Intent.parseUri(asString, 1);
    }

    public Uri getAppLinkIntentUri() {
        String asString = this.values.getAsString("app_link_intent_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public String getAppLinkText() {
        return this.values.getAsString("app_link_text");
    }

    public String getDescription() {
        return this.values.getAsString("description");
    }

    public String getDisplayName() {
        return this.values.getAsString("display_name");
    }

    public long getId() {
        Long asLong = this.values.getAsLong("_id");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public byte[] getInternalProviderDataByteArray() {
        return this.values.getAsByteArray("internal_provider_data");
    }

    public Long getInternalProviderFlag1() {
        return this.values.getAsLong("internal_provider_flag1");
    }

    public Long getInternalProviderFlag2() {
        return this.values.getAsLong("internal_provider_flag2");
    }

    public Long getInternalProviderFlag3() {
        return this.values.getAsLong("internal_provider_flag3");
    }

    public Long getInternalProviderFlag4() {
        return this.values.getAsLong("internal_provider_flag4");
    }

    public String getInternalProviderId() {
        return this.values.getAsString("internal_provider_id");
    }

    public String getPackageName() {
        return this.values.getAsString("package_name");
    }

    public boolean hasAnyUpdatedValues(PreviewChannel previewChannel) {
        for (String str : previewChannel.values.keySet()) {
            if (!PreviewChannel$$ExternalSyntheticBackport0.m328m(previewChannel.values.get(str), this.values.get(str))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public ContentValues toContentValues() {
        return new ContentValues(this.values);
    }

    public String toString() {
        String valueOf = String.valueOf(this.values);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
        sb.append("Channel{");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
