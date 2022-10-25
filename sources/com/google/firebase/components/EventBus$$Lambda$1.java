package com.google.firebase.components;

import com.google.firebase.events.Event;
import java.util.Map;

/* loaded from: classes3.dex */
final /* synthetic */ class EventBus$$Lambda$1 implements Runnable {
    private final Map.Entry arg$1;
    private final Event arg$2;

    private EventBus$$Lambda$1(Map.Entry entry, Event event) {
        this.arg$1 = entry;
        this.arg$2 = event;
    }

    public static Runnable lambdaFactory$(Map.Entry entry, Event event) {
        return new EventBus$$Lambda$1(entry, event);
    }

    @Override // java.lang.Runnable
    public void run() {
        EventBus.lambda$publish$0(this.arg$1, this.arg$2);
    }
}
