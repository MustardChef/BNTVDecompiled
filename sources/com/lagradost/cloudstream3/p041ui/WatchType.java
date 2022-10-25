package com.lagradost.cloudstream3.p041ui;

import com.bongngotv2.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WatchType.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/WatchType;", "", "internalId", "", "stringRes", "iconRes", "(Ljava/lang/String;IIII)V", "getIconRes", "()I", "getInternalId", "getStringRes", "WATCHING", "COMPLETED", "ONHOLD", "DROPPED", "PLANTOWATCH", "NONE", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.WatchType */
/* loaded from: classes.dex */
public enum WatchType {
    WATCHING(0, R.string.type_watching, R.drawable.ic_baseline_remove_red_eye_24),
    COMPLETED(1, R.string.type_completed, R.drawable.ic_baseline_check_24),
    ONHOLD(2, R.string.type_on_hold, R.drawable.ic_baseline_pause_24),
    DROPPED(3, R.string.type_dropped, R.drawable.ic_baseline_close_24),
    PLANTOWATCH(4, R.string.type_plan_to_watch, R.drawable.ic_baseline_close_24),
    NONE(5, R.string.type_none, R.drawable.ic_baseline_remove_red_eye_24);
    
    public static final Companion Companion = new Companion(null);
    private final int iconRes;
    private final int internalId;
    private final int stringRes;

    WatchType(int i, int i2, int i3) {
        this.internalId = i;
        this.stringRes = i2;
        this.iconRes = i3;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getInternalId() {
        return this.internalId;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    /* compiled from: WatchType.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/WatchType$Companion;", "", "()V", "fromInternalId", "Lcom/lagradost/cloudstream3/ui/WatchType;", "id", "", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/ui/WatchType;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.WatchType$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WatchType fromInternalId(Integer num) {
            WatchType watchType;
            WatchType[] values = WatchType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    watchType = null;
                    break;
                }
                watchType = values[i];
                if (num != null && watchType.getInternalId() == num.intValue()) {
                    break;
                }
                i++;
            }
            return watchType == null ? WatchType.NONE : watchType;
        }
    }
}
