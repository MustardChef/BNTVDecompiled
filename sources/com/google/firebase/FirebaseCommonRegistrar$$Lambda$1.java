package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseCommonRegistrar$$Lambda$1 implements LibraryVersionComponent.VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$1 instance = new FirebaseCommonRegistrar$$Lambda$1();

    private FirebaseCommonRegistrar$$Lambda$1() {
    }

    public static LibraryVersionComponent.VersionExtractor lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        return ((Context) obj).getApplicationInfo();
    }
}
