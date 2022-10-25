package androidx.mediarouter.media;

import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes.dex */
public class MediaRouterParams {
    public static final int DIALOG_TYPE_DEFAULT = 1;
    public static final int DIALOG_TYPE_DYNAMIC_GROUP = 2;
    public static final String EXTRAS_KEY_TEST_PRIVATE_UI = "androidx.mediarouter.media.MediaRouterParams.TEST_PRIVATE_UI";
    final int mDialogType;
    final Bundle mExtras;
    final boolean mOutputSwitcherEnabled;
    final boolean mTransferToLocalEnabled;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DialogType {
    }

    MediaRouterParams(Builder builder) {
        this.mDialogType = builder.mDialogType;
        this.mOutputSwitcherEnabled = builder.mOutputSwitcherEnabled;
        this.mTransferToLocalEnabled = builder.mTransferToLocalEnabled;
        Bundle bundle = builder.mExtras;
        this.mExtras = bundle == null ? Bundle.EMPTY : new Bundle(bundle);
    }

    public int getDialogType() {
        return this.mDialogType;
    }

    public boolean isOutputSwitcherEnabled() {
        return this.mOutputSwitcherEnabled;
    }

    public boolean isTransferToLocalEnabled() {
        return this.mTransferToLocalEnabled;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        int mDialogType;
        Bundle mExtras;
        boolean mOutputSwitcherEnabled;
        boolean mTransferToLocalEnabled;

        public Builder() {
            this.mDialogType = 1;
        }

        public Builder(MediaRouterParams mediaRouterParams) {
            this.mDialogType = 1;
            Objects.requireNonNull(mediaRouterParams, "params should not be null!");
            this.mDialogType = mediaRouterParams.mDialogType;
            this.mOutputSwitcherEnabled = mediaRouterParams.mOutputSwitcherEnabled;
            this.mTransferToLocalEnabled = mediaRouterParams.mTransferToLocalEnabled;
            this.mExtras = mediaRouterParams.mExtras == null ? null : new Bundle(mediaRouterParams.mExtras);
        }

        public Builder setDialogType(int i) {
            this.mDialogType = i;
            return this;
        }

        public Builder setOutputSwitcherEnabled(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mOutputSwitcherEnabled = z;
            }
            return this;
        }

        public Builder setTransferToLocalEnabled(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mTransferToLocalEnabled = z;
            }
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle == null ? null : new Bundle(bundle);
            return this;
        }

        public MediaRouterParams build() {
            return new MediaRouterParams(this);
        }
    }
}
