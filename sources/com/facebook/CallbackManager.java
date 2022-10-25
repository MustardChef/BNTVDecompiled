package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* loaded from: classes.dex */
public interface CallbackManager {
    boolean onActivityResult(int i, int i2, Intent intent);

    /* loaded from: classes.dex */
    public static class Factory {
        public static CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }
}
