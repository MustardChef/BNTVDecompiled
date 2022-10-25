package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: id */
    private final String f9848id;
    private final String token;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstanceIdResultImpl(String str, String str2) {
        this.f9848id = str;
        this.token = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getId() {
        return this.f9848id;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getToken() {
        return this.token;
    }
}
