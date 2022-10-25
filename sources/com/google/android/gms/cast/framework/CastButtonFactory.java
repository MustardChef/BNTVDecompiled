package com.google.android.gms.cast.framework;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.MediaRouteDialogFactory;
import androidx.mediarouter.media.MediaRouteSelector;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzjt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class CastButtonFactory {
    private static final Logger zza = new Logger("CastButtonFactory");
    private static final List<WeakReference<MenuItem>> zzb = new ArrayList();
    private static final List<WeakReference<MediaRouteButton>> zzc = new ArrayList();

    private CastButtonFactory() {
    }

    public static MenuItem setUpMediaRouteButton(Context context, Menu menu, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu);
        MenuItem findItem = menu.findItem(i);
        if (findItem == null) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu doesn't contain a menu item whose ID is %d.", Integer.valueOf(i)));
        }
        try {
            zzb(context, findItem, null);
            zzb.add(new WeakReference<>(findItem));
            com.google.android.gms.internal.cast.zzl.zzb(zzjt.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
            return findItem;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu item with ID %d doesn't have a MediaRouteActionProvider.", Integer.valueOf(i)));
        }
    }

    public static void zza(Context context) {
        for (WeakReference<MenuItem> weakReference : zzb) {
            MenuItem menuItem = weakReference.get();
            if (menuItem != null) {
                try {
                    zzb(context, menuItem, null);
                } catch (IllegalArgumentException e) {
                    zza.m362w("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", e);
                }
            }
        }
        for (WeakReference<MediaRouteButton> weakReference2 : zzc) {
            MediaRouteButton mediaRouteButton = weakReference2.get();
            if (mediaRouteButton != null) {
                zzc(context, mediaRouteButton, null);
            }
        }
    }

    private static void zzb(Context context, MenuItem menuItem, MediaRouteDialogFactory mediaRouteDialogFactory) throws IllegalArgumentException {
        MediaRouteSelector mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) MenuItemCompat.getActionProvider(menuItem);
        if (mediaRouteActionProvider == null) {
            throw new IllegalArgumentException();
        }
        CastContext zza2 = CastContext.zza(context);
        if (zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null) {
            return;
        }
        mediaRouteActionProvider.setRouteSelector(mergedSelector);
    }

    private static void zzc(Context context, MediaRouteButton mediaRouteButton, MediaRouteDialogFactory mediaRouteDialogFactory) {
        MediaRouteSelector mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastContext zza2 = CastContext.zza(context);
        if (zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null) {
            return;
        }
        mediaRouteButton.setRouteSelector(mergedSelector);
    }

    public static void setUpMediaRouteButton(Context context, MediaRouteButton mediaRouteButton) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (mediaRouteButton != null) {
            zzc(context, mediaRouteButton, null);
            zzc.add(new WeakReference<>(mediaRouteButton));
        }
        com.google.android.gms.internal.cast.zzl.zzb(zzjt.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
