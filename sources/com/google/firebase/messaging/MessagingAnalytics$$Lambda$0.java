package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes3.dex */
final /* synthetic */ class MessagingAnalytics$$Lambda$0 implements Transformer {
    static final Transformer $instance = new MessagingAnalytics$$Lambda$0();

    private MessagingAnalytics$$Lambda$0() {
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
