package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseMessagingRegistrar$$Lambda$1 implements Transformer {
    static final Transformer $instance = new FirebaseMessagingRegistrar$$Lambda$1();

    private FirebaseMessagingRegistrar$$Lambda$1() {
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
