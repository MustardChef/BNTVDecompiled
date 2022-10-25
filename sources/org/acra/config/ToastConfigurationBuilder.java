package org.acra.config;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.annotation.AcraToast;

/* compiled from: ToastConfigurationBuilder.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, m107d2 = {"Lorg/acra/config/ToastConfigurationBuilder;", "Lorg/acra/config/ConfigurationBuilder;", "arg0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", SessionDescription.ATTR_LENGTH, "", "getLength", "()I", "setLength", "(I)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lorg/acra/config/ToastConfiguration;", "withEnabled", "withLength", "withResText", "resText", "withText", "acra-toast_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ToastConfigurationBuilder implements ConfigurationBuilder {
    private Context context;
    private boolean enabled;
    private int length;
    private String text;

    public ToastConfigurationBuilder(Context arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        AcraToast acraToast = (AcraToast) arg0.getClass().getAnnotation(AcraToast.class);
        this.context = arg0;
        boolean z = false;
        this.enabled = acraToast != null;
        Integer valueOf = acraToast == null ? null : Integer.valueOf(acraToast.resText());
        Integer num = (valueOf == null || valueOf.intValue() != 0) ? true : true ? valueOf : null;
        String str = "";
        if (num != null) {
            String string = getContext().getString(num.intValue());
            if (string != null) {
                str = string;
            }
        }
        this.text = str;
        this.length = acraToast != null ? Integer.valueOf(acraToast.length()).intValue() : 1;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final int getLength() {
        return this.length;
    }

    public final void setLength(int i) {
        this.length = i;
    }

    public final ToastConfigurationBuilder withEnabled(boolean z) {
        ToastConfigurationBuilder toastConfigurationBuilder = this;
        toastConfigurationBuilder.setEnabled(z);
        return toastConfigurationBuilder;
    }

    public final ToastConfigurationBuilder withText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ToastConfigurationBuilder toastConfigurationBuilder = this;
        toastConfigurationBuilder.setText(text);
        return toastConfigurationBuilder;
    }

    public final ToastConfigurationBuilder withResText(int i) {
        String string = this.context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resText)");
        this.text = string;
        return this;
    }

    public final ToastConfigurationBuilder withLength(int i) {
        ToastConfigurationBuilder toastConfigurationBuilder = this;
        toastConfigurationBuilder.setLength(i);
        return toastConfigurationBuilder;
    }

    @Override // org.acra.config.ConfigurationBuilder
    public ToastConfiguration build() throws ACRAConfigurationException {
        if (this.enabled && this.text == null) {
            throw new ACRAConfigurationException("text has to be set");
        }
        return new ToastConfiguration(this);
    }
}
