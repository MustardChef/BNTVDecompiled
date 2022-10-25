package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import com.bongngotv2.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsPlayer$onCreatePreferences$7$2 */
/* loaded from: classes4.dex */
public final class SettingsPlayer$onCreatePreferences$7$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ int[] $prefValues;
    final /* synthetic */ SharedPreferences $settingsManager;
    final /* synthetic */ SettingsPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPlayer$onCreatePreferences$7$2(SharedPreferences sharedPreferences, SettingsPlayer settingsPlayer, int[] iArr) {
        super(1);
        this.$settingsManager = sharedPreferences;
        this.this$0 = settingsPlayer;
        this.$prefValues = iArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$settingsManager.edit().putInt(this.this$0.getString(R.string.video_buffer_disk_key), this.$prefValues[i]).apply();
    }
}
