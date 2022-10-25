package org.acra.config;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastConfiguration.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m107d2 = {"Lorg/acra/config/ToastConfiguration;", "Ljava/io/Serializable;", "Lorg/acra/config/Configuration;", "arg0", "Lorg/acra/config/ToastConfigurationBuilder;", "(Lorg/acra/config/ToastConfigurationBuilder;)V", "enabled", "", "getEnabled", "()Z", SessionDescription.ATTR_LENGTH, "", "getLength", "()I", "text", "", "getText", "()Ljava/lang/String;", "acra-toast_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ToastConfiguration implements Serializable, Configuration {
    private final boolean enabled;
    private final int length;
    private final String text;

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getText() {
        return this.text;
    }

    public final int getLength() {
        return this.length;
    }

    public ToastConfiguration(ToastConfigurationBuilder arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        this.enabled = arg0.getEnabled();
        this.text = arg0.getText();
        this.length = arg0.getLength();
    }

    @Override // org.acra.config.Configuration
    public boolean enabled() {
        return this.enabled;
    }
}
