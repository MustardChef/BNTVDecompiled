package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.p034v3.api.esp.EspAdapter;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2492bj;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2493bk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alo */
/* loaded from: classes2.dex */
public final class alo {

    /* renamed from: a */
    private final List f4389a = new ArrayList(0);

    /* renamed from: b */
    private final TaskCompletionSource f4390b = new TaskCompletionSource();

    /* renamed from: c */
    private final TaskCompletionSource f4391c = new TaskCompletionSource();

    /* renamed from: d */
    private final Context f4392d;

    /* renamed from: e */
    private final ExecutorService f4393e;

    /* renamed from: f */
    private final alv f4394f;

    /* renamed from: g */
    private Integer f4395g;

    public alo(Context context, ExecutorService executorService, alv alvVar) {
        this.f4392d = context;
        this.f4393e = executorService;
        this.f4394f = alvVar;
    }

    /* renamed from: a */
    public static /* synthetic */ Task m5030a(alo aloVar, Task task) {
        final List list = (List) task.getResult();
        return Tasks.whenAllComplete(list).continueWith(aloVar.f4393e, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.all
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return list;
            }
        });
    }

    /* renamed from: i */
    private final void m5022i(EnumC2493bk enumC2493bk, Exception exc) {
        this.f4394f.m5015b(EnumC2492bj.NATIVE_ESP, enumC2493bk, exc);
    }

    /* renamed from: j */
    private final void m5021j(alj aljVar) {
        this.f4389a.remove(aljVar);
    }

    /* renamed from: k */
    private static final Exception m5020k(alj aljVar, Exception exc) {
        String m5032e = aljVar.m5032e();
        String m5031f = aljVar.m5031f();
        StringBuilder sb = new StringBuilder(String.valueOf(m5032e).length() + 27 + String.valueOf(m5031f).length());
        sb.append("Exception with EspAdapter ");
        sb.append(m5032e);
        sb.append(":");
        sb.append(m5031f);
        return new Exception(sb.toString(), exc);
    }

    /* renamed from: b */
    public final List m5029b() {
        Task addOnFailureListener;
        try {
            Task continueWith = this.f4391c.getTask().continueWith(this.f4393e, new alk(this, 4)).continueWithTask(this.f4393e, new alk(this, 0)).continueWith(this.f4393e, new alk(this, 1));
            Integer num = this.f4395g;
            if (num != null) {
                addOnFailureListener = Tasks.withTimeout(continueWith, num.intValue(), TimeUnit.MILLISECONDS).addOnFailureListener(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.alm
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        alo.this.m5028c(exc);
                    }
                });
            } else {
                addOnFailureListener = Tasks.forResult(null);
            }
            return (List) Tasks.await(addOnFailureListener);
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void m5028c(Exception exc) {
        m5022i(EnumC2493bk.COLLECT_SIGNALS, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void m5027d(alj aljVar, Exception exc) {
        m5021j(aljVar);
        m5022i(EnumC2493bk.COLLECT_SIGNALS, m5020k(aljVar, exc));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void m5026e(alj aljVar, Exception exc) {
        m5021j(aljVar);
        m5022i(EnumC2493bk.INIT, m5020k(aljVar, exc));
    }

    /* renamed from: g */
    public final void m5024g() {
        this.f4390b.getTask().continueWith(this.f4393e, new alk(this, 2)).continueWithTask(this.f4393e, new alk(this, 0)).continueWith(this.f4393e, new alk(this, 1)).continueWith(this.f4393e, new alk(this, 3));
        this.f4391c.getTask();
    }

    /* renamed from: h */
    public final void m5023h(List list, Integer num) {
        if (num.intValue() == 0) {
            this.f4390b.trySetException(new Exception("No adapters to load"));
            this.f4390b.getTask();
            return;
        }
        this.f4395g = num;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            alj aljVar = null;
            try {
                Class<?> cls = Class.forName(str, false, getClass().getClassLoader());
                Class<?>[] interfaces = cls.getInterfaces();
                String name = EspAdapter.class.getName();
                int length = interfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (interfaces[i].getName().equals(name)) {
                        aljVar = new alj((EspAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), str, this.f4392d);
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
            if (aljVar != null) {
                try {
                    this.f4389a.add(aljVar);
                } catch (Exception e) {
                    EnumC2493bk enumC2493bk = EnumC2493bk.LOAD_ADAPTER;
                    String valueOf = String.valueOf(str);
                    m5022i(enumC2493bk, new Exception(valueOf.length() != 0 ? "Exception with EspAdapter ".concat(valueOf) : new String("Exception with EspAdapter "), e));
                }
            }
        }
        this.f4390b.trySetResult(this.f4389a);
        this.f4390b.getTask();
    }
}
