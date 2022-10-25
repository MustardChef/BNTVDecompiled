package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, m107d2 = {"thread", "Ljava/lang/Thread;", TtmlNode.START, "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.concurrent.ThreadsKt */
/* loaded from: classes4.dex */
public final class Thread {
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.concurrent.ThreadsKt$thread$thread$1] */
    public static final java.lang.Thread thread(boolean z, boolean z2, ClassLoader classLoader, String str, int i, final Functions<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ?? r0 = new java.lang.Thread() { // from class: kotlin.concurrent.ThreadsKt$thread$thread$1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                block.invoke();
            }
        };
        if (z2) {
            r0.setDaemon(true);
        }
        if (i > 0) {
            r0.setPriority(i);
        }
        if (str != null) {
            r0.setName(str);
        }
        if (classLoader != null) {
            r0.setContextClassLoader(classLoader);
        }
        if (z) {
            r0.start();
        }
        return (java.lang.Thread) r0;
    }

    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Functions<? extends T> functions) {
        Intrinsics.checkNotNullParameter(threadLocal, "<this>");
        Intrinsics.checkNotNullParameter(functions, "default");
        T t = threadLocal.get();
        if (t == null) {
            T invoke = functions.invoke();
            threadLocal.set(invoke);
            return invoke;
        }
        return t;
    }
}
