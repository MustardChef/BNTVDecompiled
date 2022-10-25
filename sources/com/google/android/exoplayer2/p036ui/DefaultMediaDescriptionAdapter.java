package com.google.android.exoplayer2.p036ui;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p036ui.PlayerNotificationManager;

/* renamed from: com.google.android.exoplayer2.ui.DefaultMediaDescriptionAdapter */
/* loaded from: classes2.dex */
public final class DefaultMediaDescriptionAdapter implements PlayerNotificationManager.MediaDescriptionAdapter {
    private final PendingIntent pendingIntent;

    @Override // com.google.android.exoplayer2.p036ui.PlayerNotificationManager.MediaDescriptionAdapter
    public /* synthetic */ CharSequence getCurrentSubText(Player player) {
        return PlayerNotificationManager.MediaDescriptionAdapter.CC.$default$getCurrentSubText(this, player);
    }

    public DefaultMediaDescriptionAdapter(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    @Override // com.google.android.exoplayer2.p036ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence getCurrentContentTitle(Player player) {
        CharSequence charSequence = player.getMediaMetadata().displayTitle;
        if (TextUtils.isEmpty(charSequence)) {
            CharSequence charSequence2 = player.getMediaMetadata().title;
            return charSequence2 != null ? charSequence2 : "";
        }
        return charSequence;
    }

    @Override // com.google.android.exoplayer2.p036ui.PlayerNotificationManager.MediaDescriptionAdapter
    public PendingIntent createCurrentContentIntent(Player player) {
        return this.pendingIntent;
    }

    @Override // com.google.android.exoplayer2.p036ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence getCurrentContentText(Player player) {
        CharSequence charSequence = player.getMediaMetadata().artist;
        return !TextUtils.isEmpty(charSequence) ? charSequence : player.getMediaMetadata().albumArtist;
    }

    @Override // com.google.android.exoplayer2.p036ui.PlayerNotificationManager.MediaDescriptionAdapter
    public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback bitmapCallback) {
        byte[] bArr = player.getMediaMetadata().artworkData;
        if (bArr == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
