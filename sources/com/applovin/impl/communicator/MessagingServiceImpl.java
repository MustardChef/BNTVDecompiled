package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {

    /* renamed from: a */
    private final Context f772a;

    /* renamed from: c */
    private final Queue<CommunicatorMessageImpl> f774c = new LinkedList();

    /* renamed from: d */
    private final Object f775d = new Object();

    /* renamed from: b */
    private final ScheduledThreadPoolExecutor f773b = m7858a();

    public MessagingServiceImpl(Context context) {
        this.f772a = context;
    }

    /* renamed from: a */
    private Queue<CommunicatorMessageImpl> m7855a(String str) {
        LinkedList linkedList;
        synchronized (this.f775d) {
            linkedList = new LinkedList();
            for (CommunicatorMessageImpl communicatorMessageImpl : this.f774c) {
                if (communicatorMessageImpl.m7859a() && communicatorMessageImpl.getTopic().equals(str)) {
                    linkedList.add(communicatorMessageImpl);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m7858a() {
        return new ScheduledThreadPoolExecutor(4, new ThreadFactory() { // from class: com.applovin.impl.communicator.MessagingServiceImpl.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    /* renamed from: a */
    private void m7857a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f773b.execute(new Runnable() { // from class: com.applovin.impl.communicator.MessagingServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f772a).sendBroadcastSync(communicatorMessageImpl, null);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl communicatorMessageImpl : m7855a(str)) {
            m7857a(communicatorMessageImpl);
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorMessagingService
    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        m7857a(appLovinCommunicatorMessage);
        synchronized (this.f775d) {
            this.f774c.add(appLovinCommunicatorMessage);
        }
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}
