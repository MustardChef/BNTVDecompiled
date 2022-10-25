package com.google.ads.interactivemedia.p034v3.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qd */
/* loaded from: classes2.dex */
final class C2993qd {

    /* renamed from: a */
    private final BufferedReader f8562a;

    /* renamed from: b */
    private final Queue f8563b;

    /* renamed from: c */
    private String f8564c;

    public C2993qd(Queue queue, BufferedReader bufferedReader) {
        this.f8563b = queue;
        this.f8562a = bufferedReader;
    }

    /* renamed from: a */
    public final String m1345a() throws IOException {
        if (m1344b()) {
            String str = this.f8564c;
            this.f8564c = null;
            return str;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    public final boolean m1344b() throws IOException {
        String trim;
        if (this.f8564c != null) {
            return true;
        }
        if (this.f8563b.isEmpty()) {
            do {
                String readLine = this.f8562a.readLine();
                this.f8564c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f8564c = trim;
            } while (trim.isEmpty());
            return true;
        }
        String str = (String) this.f8563b.poll();
        C2616ce.m2689d(str);
        this.f8564c = str;
        return true;
    }
}
