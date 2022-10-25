package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alk */
/* loaded from: classes2.dex */
public final /* synthetic */ class alk implements Continuation {

    /* renamed from: a */
    public final /* synthetic */ alo f4382a;

    /* renamed from: b */
    private final /* synthetic */ int f4383b;

    public /* synthetic */ alk(alo aloVar, int i) {
        this.f4383b = i;
        this.f4382a = aloVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        int i = this.f4383b;
        if (i != 0) {
            if (i == 1) {
                List<Task> list = (List) task.getResult();
                ArrayList arrayList = new ArrayList(list.size());
                for (Task task2 : list) {
                    if (task2.isSuccessful()) {
                        arrayList.add(task2.getResult());
                    }
                }
                return arrayList;
            } else if (i == 2) {
                final alo aloVar = this.f4382a;
                List<alj> list2 = (List) task.getResult();
                ArrayList arrayList2 = new ArrayList(list2.size());
                for (final alj aljVar : list2) {
                    Task m5034c = aljVar.m5034c();
                    m5034c.addOnFailureListener(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.aln
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            if (r3 != 0) {
                                aloVar.m5027d(aljVar, exc);
                            } else {
                                aloVar.m5026e(aljVar, exc);
                            }
                        }
                    });
                    arrayList2.add(m5034c);
                }
                return arrayList2;
            } else if (i == 3) {
                r7.f4391c.trySetResult(this.f4382a.f4389a);
                return null;
            } else {
                final alo aloVar2 = this.f4382a;
                List<alj> list3 = (List) task.getResult();
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (final alj aljVar2 : list3) {
                    arrayList3.add(aljVar2.m5035b().addOnFailureListener(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.aln
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            if (r3 != 0) {
                                aloVar2.m5027d(aljVar2, exc);
                            } else {
                                aloVar2.m5026e(aljVar2, exc);
                            }
                        }
                    }));
                }
                return arrayList3;
            }
        }
        return alo.m5030a(this.f4382a, task);
    }
}
