package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseCommonRegistrar$$Lambda$6 implements LibraryVersionComponent.VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$6 instance = new FirebaseCommonRegistrar$$Lambda$6();

    private FirebaseCommonRegistrar$$Lambda$6() {
    }

    public static LibraryVersionComponent.VersionExtractor lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        return r1.getPackageManager().getInstallerPackageName(((Context) obj).getPackageName());
    }
}
