package androidx.tvprovider.media.p009tv;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.tv.TvContract;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;

/* renamed from: androidx.tvprovider.media.tv.PreviewChannel */
/* loaded from: classes.dex */
public class PreviewChannel {
    private static final long INVALID_CHANNEL_ID = -1;
    private static final int IS_BROWSABLE = 1;
    private static final String TAG = "PreviewChannel";
    private boolean mLogoChanged;
    private volatile boolean mLogoFetched;
    private volatile Bitmap mLogoImage;
    private Uri mLogoUri;
    ContentValues mValues;

    PreviewChannel(Builder builder) {
        this.mValues = builder.mValues;
        this.mLogoImage = builder.mLogoBitmap;
        this.mLogoUri = builder.mLogoUri;
        this.mLogoChanged = (this.mLogoImage == null && this.mLogoUri == null) ? false : true;
    }

    public static PreviewChannel fromCursor(Cursor cursor) {
        Builder builder = new Builder();
        builder.setId(cursor.getInt(0));
        builder.setPackageName(cursor.getString(1));
        builder.setType(cursor.getString(2));
        builder.setDisplayName(cursor.getString(3));
        builder.setDescription(cursor.getString(4));
        builder.setAppLinkIntentUri(Uri.parse(cursor.getString(5)));
        builder.setInternalProviderId(cursor.getString(6));
        builder.setInternalProviderData(cursor.getBlob(7));
        builder.setInternalProviderFlag1(cursor.getLong(8));
        builder.setInternalProviderFlag2(cursor.getLong(9));
        builder.setInternalProviderFlag3(cursor.getLong(10));
        builder.setInternalProviderFlag4(cursor.getLong(11));
        return builder.build();
    }

    public long getId() {
        Long asLong = this.mValues.getAsLong("_id");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public String getPackageName() {
        return this.mValues.getAsString("package_name");
    }

    public String getType() {
        return this.mValues.getAsString("type");
    }

    public CharSequence getDisplayName() {
        return this.mValues.getAsString("display_name");
    }

    public CharSequence getDescription() {
        return this.mValues.getAsString("description");
    }

    public Uri getAppLinkIntentUri() {
        String asString = this.mValues.getAsString("app_link_intent_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public Intent getAppLinkIntent() throws URISyntaxException {
        String asString = this.mValues.getAsString("app_link_intent_uri");
        if (asString == null) {
            return null;
        }
        return Intent.parseUri(asString.toString(), 1);
    }

    public Bitmap getLogo(Context context) {
        if (!this.mLogoFetched && this.mLogoImage == null) {
            try {
                this.mLogoImage = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(TvContract.buildChannelLogoUri(getId())));
            } catch (SQLiteException | FileNotFoundException e) {
                Log.e(TAG, "Logo for preview channel (ID:" + getId() + ") not found.", e);
            }
            this.mLogoFetched = true;
        }
        return this.mLogoImage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLogoChanged() {
        return this.mLogoChanged;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri getLogoUri() {
        return this.mLogoUri;
    }

    public byte[] getInternalProviderDataByteArray() {
        return this.mValues.getAsByteArray("internal_provider_data");
    }

    public Long getInternalProviderFlag1() {
        return this.mValues.getAsLong("internal_provider_flag1");
    }

    public Long getInternalProviderFlag2() {
        return this.mValues.getAsLong("internal_provider_flag2");
    }

    public Long getInternalProviderFlag3() {
        return this.mValues.getAsLong("internal_provider_flag3");
    }

    public Long getInternalProviderFlag4() {
        return this.mValues.getAsLong("internal_provider_flag4");
    }

    public String getInternalProviderId() {
        return this.mValues.getAsString("internal_provider_id");
    }

    public boolean isBrowsable() {
        Integer asInteger = this.mValues.getAsInteger("browsable");
        return asInteger != null && asInteger.intValue() == 1;
    }

    public int hashCode() {
        return this.mValues.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreviewChannel) {
            return this.mValues.equals(((PreviewChannel) obj).mValues);
        }
        return false;
    }

    public boolean hasAnyUpdatedValues(PreviewChannel previewChannel) {
        for (String str : previewChannel.mValues.keySet()) {
            if (!Objects.deepEquals(previewChannel.mValues.get(str), this.mValues.get(str))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Channel{" + this.mValues.toString() + "}";
    }

    public ContentValues toContentValues() {
        return new ContentValues(this.mValues);
    }

    /* renamed from: androidx.tvprovider.media.tv.PreviewChannel$Columns */
    /* loaded from: classes.dex */
    public static class Columns {
        public static final int COL_APP_LINK_INTENT_URI = 5;
        public static final int COL_DESCRIPTION = 4;
        public static final int COL_DISPLAY_NAME = 3;
        public static final int COL_ID = 0;
        public static final int COL_INTERNAL_PROVIDER_DATA = 7;
        public static final int COL_INTERNAL_PROVIDER_FLAG1 = 8;
        public static final int COL_INTERNAL_PROVIDER_FLAG2 = 9;
        public static final int COL_INTERNAL_PROVIDER_FLAG3 = 10;
        public static final int COL_INTERNAL_PROVIDER_FLAG4 = 11;
        public static final int COL_INTERNAL_PROVIDER_ID = 6;
        public static final int COL_PACKAGE_NAME = 1;
        public static final int COL_TYPE = 2;
        public static final String[] PROJECTION = {"_id", "package_name", "type", "display_name", "description", "app_link_intent_uri", "internal_provider_id", "internal_provider_data", "internal_provider_flag1", "internal_provider_flag2", "internal_provider_flag3", "internal_provider_flag4"};

        private Columns() {
        }
    }

    /* renamed from: androidx.tvprovider.media.tv.PreviewChannel$Builder */
    /* loaded from: classes.dex */
    public static final class Builder {
        Bitmap mLogoBitmap;
        Uri mLogoUri;
        ContentValues mValues;

        public Builder() {
            this.mValues = new ContentValues();
        }

        public Builder(PreviewChannel previewChannel) {
            this.mValues = new ContentValues(previewChannel.mValues);
        }

        Builder setId(long j) {
            this.mValues.put("_id", Long.valueOf(j));
            return this;
        }

        Builder setPackageName(String str) {
            this.mValues.put("package_name", str);
            return this;
        }

        Builder setType(String str) {
            this.mValues.put("type", str);
            return this;
        }

        public Builder setDisplayName(CharSequence charSequence) {
            this.mValues.put("display_name", charSequence.toString());
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mValues.put("description", charSequence.toString());
            return this;
        }

        public Builder setAppLinkIntent(Intent intent) {
            return setAppLinkIntentUri(Uri.parse(intent.toUri(1)));
        }

        public Builder setAppLinkIntentUri(Uri uri) {
            this.mValues.put("app_link_intent_uri", uri == null ? null : uri.toString());
            return this;
        }

        public Builder setInternalProviderId(String str) {
            this.mValues.put("internal_provider_id", str);
            return this;
        }

        public Builder setInternalProviderData(byte[] bArr) {
            this.mValues.put("internal_provider_data", bArr);
            return this;
        }

        public Builder setInternalProviderFlag1(long j) {
            this.mValues.put("internal_provider_flag1", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag2(long j) {
            this.mValues.put("internal_provider_flag2", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag3(long j) {
            this.mValues.put("internal_provider_flag3", Long.valueOf(j));
            return this;
        }

        public Builder setInternalProviderFlag4(long j) {
            this.mValues.put("internal_provider_flag4", Long.valueOf(j));
            return this;
        }

        public Builder setLogo(Bitmap bitmap) {
            this.mLogoBitmap = bitmap;
            this.mLogoUri = null;
            return this;
        }

        public Builder setLogo(Uri uri) {
            this.mLogoUri = uri;
            this.mLogoBitmap = null;
            return this;
        }

        public PreviewChannel build() {
            setType(TvContractCompat.Channels.TYPE_PREVIEW);
            if (TextUtils.isEmpty(this.mValues.getAsString("display_name"))) {
                throw new IllegalStateException("Need channel name. Use method setDisplayName(String) to set it.");
            }
            if (TextUtils.isEmpty(this.mValues.getAsString("app_link_intent_uri"))) {
                throw new IllegalStateException("Need app link intent uri for channel. Use method setAppLinkIntent or setAppLinkIntentUri to set it.");
            }
            return new PreviewChannel(this);
        }
    }
}
