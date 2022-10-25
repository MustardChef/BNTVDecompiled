package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseCommonRegistrar$$Lambda$5 implements LibraryVersionComponent.VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$5 instance = new FirebaseCommonRegistrar$$Lambda$5();

    private FirebaseCommonRegistrar$$Lambda$5() {
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$2((Context) obj);
    }
}
