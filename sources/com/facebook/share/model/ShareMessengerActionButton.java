package com.facebook.share.model;

import android.os.Parcel;

@Deprecated
/* loaded from: classes2.dex */
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareMessengerActionButton(Builder builder) {
        this.title = builder.title;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }

    public String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        private String title;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            return readFrom((Builder<M, B>) ((ShareMessengerActionButton) shareModel));
        }

        public B setTitle(String str) {
            this.title = str;
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }
}
