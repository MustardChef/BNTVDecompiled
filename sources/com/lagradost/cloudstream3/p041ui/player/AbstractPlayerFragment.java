package com.lagradost.cloudstream3.p041ui.player;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media.session.MediaButtonReceiver;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.p036ui.PlayerView;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import com.lagradost.cloudstream3.p041ui.subtitles.SubtitlesFragment;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Standard;
import kotlin.Tuples;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Debug;

/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m108d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\b\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020+H\u0016J\b\u00103\u001a\u00020+H\u0016J\u0006\u00104\u001a\u00020+J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020+H\u0016J\b\u0010>\u001a\u00020+H\u0016J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020+H\u0016J\u0010\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u001fH\u0002J\u001a\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<H\u0017J\u001c\u0010G\u001a\u00020+2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0IH\u0016J\u0014\u0010J\u001a\u00020+2\n\u0010K\u001a\u00060Lj\u0002`MH\u0016J\u001c\u0010N\u001a\u00020+2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0IH\u0016J\u0012\u0010Q\u001a\u00020+2\b\u0010\u0002\u001a\u0004\u0018\u00010RH\u0002J\b\u0010S\u001a\u00020+H\u0016J\b\u0010T\u001a\u00020+H\u0002J\u0016\u0010U\u001a\u00020+2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0006J\u0016\u0010U\u001a\u00020+2\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u0006J\b\u0010X\u001a\u00020+H\u0016J\u001c\u0010Y\u001a\u00020+2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020[0IH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006\\"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/AbstractPlayerFragment;", "Landroidx/fragment/app/Fragment;", "player", "Lcom/lagradost/cloudstream3/ui/player/IPlayer;", "(Lcom/lagradost/cloudstream3/ui/player/IPlayer;)V", "hasPipModeSupport", "", "getHasPipModeSupport", "()Z", "setHasPipModeSupport", "(Z)V", "isBuffering", "setBuffering", TtmlNode.TAG_LAYOUT, "", "getLayout", "()I", "setLayout", "(I)V", "mMediaSessionCompat", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionConnector", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "pipReceiver", "Landroid/content/BroadcastReceiver;", "getPlayer", "()Lcom/lagradost/cloudstream3/ui/player/IPlayer;", "resizeMode", "getResizeMode", "setResizeMode", "subStyle", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "getSubStyle", "()Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "setSubStyle", "(Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;)V", "subView", "Lcom/google/android/exoplayer2/ui/SubtitleView;", "getSubView", "()Lcom/google/android/exoplayer2/ui/SubtitleView;", "setSubView", "(Lcom/google/android/exoplayer2/ui/SubtitleView;)V", "embeddedSubtitlesFetched", "", "subtitles", "", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "exitedPipMode", "keepScreenOn", Debug.DEBUG_PROPERTY_VALUE_ON, "nextEpisode", "nextMirror", "nextResize", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "onResume", "onStop", "onSubStyleChanged", "style", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "playerDimensionsLoaded", "widthHeight", "Lkotlin/Pair;", "playerError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "playerPositionChanged", "posDur", "", "playerUpdated", "", "prevEpisode", "requestAudioFocus", "resize", "Lcom/lagradost/cloudstream3/ui/player/PlayerResize;", "showToast", "subtitlesChanged", "updateIsPlaying", "playing", "Lcom/lagradost/cloudstream3/ui/player/CSPlayerLoading;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment */
/* loaded from: classes3.dex */
public abstract class AbstractPlayerFragment extends Fragment {
    public Map<Integer, View> _$_findViewCache;
    private boolean hasPipModeSupport;
    private boolean isBuffering;
    private int layout;
    private MediaSessionCompat mMediaSessionCompat;
    private MediaSessionConnector mediaSessionConnector;
    private BroadcastReceiver pipReceiver;
    private final IPlayer player;
    private int resizeMode;
    private SaveCaptionStyle subStyle;
    private SubtitleView subView;

    /* compiled from: AbstractPlayerFragment.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$WhenMappings */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerResize.values().length];
            iArr[PlayerResize.Fill.ordinal()] = 1;
            iArr[PlayerResize.Fit.ordinal()] = 2;
            iArr[PlayerResize.Zoom.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractPlayerFragment() {
        this(null, 1, null);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public AbstractPlayerFragment(IPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this._$_findViewCache = new LinkedHashMap();
        this.player = player;
        this.isBuffering = true;
        this.hasPipModeSupport = true;
        this.layout = R.layout.fragment_player;
    }

    public /* synthetic */ AbstractPlayerFragment(CS3IPlayer cS3IPlayer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CS3IPlayer() : cS3IPlayer);
    }

    public final IPlayer getPlayer() {
        return this.player;
    }

    public final int getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(int i) {
        this.resizeMode = i;
    }

    public final SaveCaptionStyle getSubStyle() {
        return this.subStyle;
    }

    public final void setSubStyle(SaveCaptionStyle saveCaptionStyle) {
        this.subStyle = saveCaptionStyle;
    }

    public final SubtitleView getSubView() {
        return this.subView;
    }

    public final void setSubView(SubtitleView subtitleView) {
        this.subView = subtitleView;
    }

    public final boolean isBuffering() {
        return this.isBuffering;
    }

    public final void setBuffering(boolean z) {
        this.isBuffering = z;
    }

    protected boolean getHasPipModeSupport() {
        return this.hasPipModeSupport;
    }

    protected void setHasPipModeSupport(boolean z) {
        this.hasPipModeSupport = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLayout() {
        return this.layout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setLayout(int i) {
        this.layout = i;
    }

    public void nextEpisode() {
        throw new Standard(null, 1, null);
    }

    public void prevEpisode() {
        throw new Standard(null, 1, null);
    }

    public void playerPositionChanged(Tuples<Long, Long> posDur) {
        Intrinsics.checkNotNullParameter(posDur, "posDur");
        throw new Standard(null, 1, null);
    }

    public void playerDimensionsLoaded(Tuples<Integer, Integer> widthHeight) {
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        throw new Standard(null, 1, null);
    }

    public void subtitlesChanged() {
        throw new Standard(null, 1, null);
    }

    public void embeddedSubtitlesFetched(List<SubtitleData> subtitles) {
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        throw new Standard(null, 1, null);
    }

    public void exitedPipMode() {
        throw new Standard(null, 1, null);
    }

    private final void keepScreenOn(boolean z) {
        Window window;
        Window window2;
        if (z) {
            FragmentActivity activity = getActivity();
            if (activity == null || (window2 = activity.getWindow()) == null) {
                return;
            }
            window2.addFlags(128);
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (window = activity2.getWindow()) == null) {
            return;
        }
        window.clearFlags(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIsPlaying(Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading> tuples) {
        boolean z;
        ImageView imageView;
        FragmentActivity activity;
        CSPlayerLoading component1 = tuples.component1();
        CSPlayerLoading component2 = tuples.component2();
        boolean z2 = false;
        boolean z3 = CSPlayerLoading.IsPlaying == component2;
        keepScreenOn(!(CSPlayerLoading.IsPaused == component2));
        boolean z4 = CSPlayerLoading.IsBuffering == component2;
        this.isBuffering = z4;
        if (z4) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_pause_play_holder_holder);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_buffering);
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } else {
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_pause_play_holder_holder);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_buffering);
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            int i = R.drawable.netflix_pause;
            if (component1 != component2) {
                ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
                if (imageView2 != null) {
                    imageView2.setImageResource(z3 ? R.drawable.play_to_pause : R.drawable.pause_to_play);
                }
                ImageView imageView3 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
                Drawable drawable = imageView3 != null ? imageView3.getDrawable() : null;
                if (Build.VERSION.SDK_INT <= 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    z = false;
                } else {
                    ((AnimatedImageDrawable) drawable).start();
                    z = true;
                }
                if (drawable instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) drawable).start();
                    z = true;
                }
                if (drawable instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) drawable).start();
                    z = true;
                }
                if (!z && (imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play)) != null) {
                    if (!z3) {
                        i = R.drawable.netflix_play;
                    }
                    imageView.setImageResource(i);
                }
            } else {
                ImageView imageView4 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
                if (imageView4 != null) {
                    if (!z3) {
                        i = R.drawable.netflix_play;
                    }
                    imageView4.setImageResource(i);
                }
            }
        }
        CommonActivity commonActivity = CommonActivity.INSTANCE;
        if (z3 && getHasPipModeSupport()) {
            z2 = true;
        }
        commonActivity.setCanEnterPipMode(z2);
        if (Build.VERSION.SDK_INT < 26 || !CommonActivity.INSTANCE.isInPIPMode() || (activity = getActivity()) == null) {
            return;
        }
        PlayerPipHelper.Companion.updatePIPModeActions(activity, z3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        FragmentActivity activity;
        try {
            CommonActivity.INSTANCE.setInPIPMode(z);
            if (z) {
                FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
                if (frameLayout != null) {
                    frameLayout.setAlpha(0.0f);
                }
                this.pipReceiver = new BroadcastReceiver() { // from class: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onPictureInPictureModeChanged$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (Intrinsics.areEqual(IPlayerKt.ACTION_MEDIA_CONTROL, intent.getAction())) {
                            AbstractPlayerFragment.this.getPlayer().handleEvent(CSPlayerEvent.values()[intent.getIntExtra(IPlayerKt.EXTRA_CONTROL_TYPE, 0)]);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IPlayerKt.ACTION_MEDIA_CONTROL);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.registerReceiver(this.pipReceiver, intentFilter);
                }
                CSPlayerLoading cSPlayerLoading = this.player.getIsPlaying() ? CSPlayerLoading.IsPlaying : CSPlayerLoading.IsPaused;
                updateIsPlaying(new Tuples<>(cSPlayerLoading, cSPlayerLoading));
                return;
            }
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
            if (frameLayout2 != null) {
                frameLayout2.setAlpha(1.0f);
            }
            exitedPipMode();
            BroadcastReceiver broadcastReceiver = this.pipReceiver;
            if (broadcastReceiver != null && (activity = getActivity()) != null) {
                activity.unregisterReceiver(broadcastReceiver);
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                UIHelper.INSTANCE.hideSystemUI(activity3);
            }
            View view = getView();
            if (view != null) {
                UIHelper.INSTANCE.hideKeyboard(view);
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public void nextMirror() {
        throw new Standard(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAudioFocus() {
        FragmentActivity activity;
        if (Build.VERSION.SDK_INT < 26 || (activity = getActivity()) == null) {
            return;
        }
        AppUtils.INSTANCE.requestLocalAudioFocus(activity, AppUtils.INSTANCE.getFocusRequest());
    }

    public void playerError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        exception.printStackTrace();
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (exception instanceof PlaybackException) {
            String message = exception.getMessage();
            if (message == null) {
                message = "";
            }
            PlaybackException playbackException = (PlaybackException) exception;
            String errorCodeName = playbackException.getErrorCodeName();
            Intrinsics.checkNotNullExpressionValue(errorCodeName, "exception.errorCodeName");
            int i = playbackException.errorCode;
            if (i != 17 && i != 19) {
                if (i != 1001 && i != 1003) {
                    if (i != 3003) {
                        if (i != 5002) {
                            if (i != 2000) {
                                if (i != 2001) {
                                    switch (i) {
                                        case 2003:
                                        case 2004:
                                            break;
                                        case 2005:
                                        case 2006:
                                            break;
                                        default:
                                            switch (i) {
                                                case PlaybackException.ERROR_CODE_DECODER_INIT_FAILED /* 4001 */:
                                                case PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED /* 4002 */:
                                                case PlaybackException.ERROR_CODE_DECODING_FAILED /* 4003 */:
                                                    break;
                                                default:
                                                    CommonActivity.INSTANCE.showToast((Activity) getActivity(), context.getString(R.string.unexpected_error) + '\n' + errorCodeName + " (" + i + ")\n" + message, (Integer) 0);
                                                    return;
                                            }
                                    }
                                }
                            }
                        }
                    }
                    CommonActivity.INSTANCE.showToast((Activity) getActivity(), context.getString(R.string.source_error) + '\n' + errorCodeName + " (" + i + ")\n" + message, (Integer) 0);
                    nextMirror();
                    return;
                }
                CommonActivity.INSTANCE.showToast((Activity) getActivity(), context.getString(R.string.remote_error) + '\n' + errorCodeName + " (" + i + ")\n" + message, (Integer) 0);
                nextMirror();
                return;
            }
            CommonActivity.INSTANCE.showToast((Activity) getActivity(), context.getString(R.string.render_error) + '\n' + errorCodeName + " (" + i + ")\n" + message, (Integer) 0);
            nextMirror();
        } else if (exception instanceof InvalidFileException) {
            CommonActivity.INSTANCE.showToast((Activity) getActivity(), context.getString(R.string.source_error) + '\n' + exception.getMessage(), (Integer) 0);
            nextMirror();
        } else {
            CommonActivity.INSTANCE.showToast((Activity) getActivity(), exception.getMessage(), (Integer) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSubStyleChanged(SaveCaptionStyle saveCaptionStyle) {
        IPlayer iPlayer = this.player;
        if (iPlayer instanceof CS3IPlayer) {
            iPlayer.updateSubtitleStyle(saveCaptionStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playerUpdated(Object obj) {
        if (obj instanceof ExoPlayer) {
            Context context = getContext();
            if (context != null) {
                MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "Player", new ComponentName(context, MediaButtonReceiver.class), null);
                new MediaSessionConnector(mediaSessionCompat).setPlayer((Player) obj);
                mediaSessionCompat.setActive(true);
                this.mMediaSessionCompat = mediaSessionCompat;
            }
            PlayerView playerView = (PlayerView) _$_findCachedViewById(C4761R.C4764id.player_view);
            if (playerView != null) {
                playerView.setPlayer((Player) obj);
            }
            PlayerView playerView2 = (PlayerView) _$_findCachedViewById(C4761R.C4764id.player_view);
            if (playerView2 != null) {
                playerView2.performClick();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
        ((MainActivity) activity).releaseCountdownAds();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        CommonActivity.INSTANCE.setPlayerEventListener(null);
        CommonActivity.INSTANCE.setKeyEventListener(null);
        CommonActivity.INSTANCE.setCanEnterPipMode(false);
        SubtitlesFragment.Companion.getApplyStyleEvent().minusAssign(new AbstractPlayerFragment$onDestroy$1(this));
        keepScreenOn(false);
        super.onDestroy();
    }

    public final void nextResize() {
        int length = (this.resizeMode + 1) % PlayerResize.values().length;
        this.resizeMode = length;
        resize(length, true);
    }

    public final void resize(int i, boolean z) {
        resize(PlayerResize.values()[i], z);
    }

    public final void resize(PlayerResize resize, boolean z) {
        Intrinsics.checkNotNullParameter(resize, "resize");
        AcraApplication.Companion.setKey(IPlayerKt.RESIZE_MODE_KEY, Integer.valueOf(resize.ordinal()));
        int i = WhenMappings.$EnumSwitchMapping$0[resize.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 0;
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = 4;
            }
        }
        PlayerView playerView = (PlayerView) _$_findCachedViewById(C4761R.C4764id.player_view);
        if (playerView != null) {
            playerView.setResizeMode(i2);
        }
        if (z) {
            CommonActivity.INSTANCE.showToast(getActivity(), resize.getNameRes(), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.player.onStop();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Context context = getContext();
        if (context != null) {
            this.player.onResume(context);
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(this.layout, viewGroup, false);
    }
}
