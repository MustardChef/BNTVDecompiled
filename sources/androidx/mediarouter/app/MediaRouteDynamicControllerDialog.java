package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.p002v4.media.MediaDescriptionCompat;
import android.support.p002v4.media.MediaMetadataCompat;
import android.support.p002v4.media.session.MediaControllerCompat;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.util.ObjectsCompat;
import androidx.mediarouter.C0554R;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class MediaRouteDynamicControllerDialog extends AppCompatDialog {
    private static final int BLUR_RADIUS = 10;
    private static final int COLOR_WHITE_ON_DARK_BACKGROUND = -1;
    private static final int CONNECTION_TIMEOUT_MS = 30000;
    private static final int MIN_UNMUTED_VOLUME = 1;
    private static final int MSG_UPDATE_ROUTES_VIEW = 1;
    private static final int MSG_UPDATE_ROUTE_VOLUME_BY_USER = 2;
    private static final int MUTED_VOLUME = 0;
    private static final int UPDATE_ROUTES_VIEW_DELAY_MS = 300;
    private static final int UPDATE_VOLUME_DELAY_MS = 500;
    RecyclerAdapter mAdapter;
    int mArtIconBackgroundColor;
    Bitmap mArtIconBitmap;
    boolean mArtIconIsLoaded;
    Bitmap mArtIconLoadedBitmap;
    Uri mArtIconUri;
    ImageView mArtView;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ImageButton mCloseButton;
    Context mContext;
    MediaControllerCallback mControllerCallback;
    private boolean mCreated;
    MediaDescriptionCompat mDescription;
    FetchArtTask mFetchArtTask;
    final List<MediaRouter.RouteInfo> mGroupableRoutes;
    final Handler mHandler;
    boolean mIsAnimatingVolumeSliderLayout;
    boolean mIsSelectingRoute;
    private long mLastUpdateTime;
    MediaControllerCompat mMediaController;
    final List<MediaRouter.RouteInfo> mMemberRoutes;
    private ImageView mMetadataBackground;
    private View mMetadataBlackScrim;
    RecyclerView mRecyclerView;
    MediaRouter.RouteInfo mRouteForVolumeUpdatingByUser;
    final MediaRouter mRouter;
    MediaRouter.RouteInfo mSelectedRoute;
    private MediaRouteSelector mSelector;
    private Button mStopCastingButton;
    private TextView mSubtitleView;
    private String mTitlePlaceholder;
    private TextView mTitleView;
    final List<MediaRouter.RouteInfo> mTransferableRoutes;
    final List<MediaRouter.RouteInfo> mUngroupableRoutes;
    Map<String, Integer> mUnmutedVolumeMap;
    private boolean mUpdateMetadataViewsDeferred;
    private boolean mUpdateRoutesViewDeferred;
    VolumeChangeListener mVolumeChangeListener;
    Map<String, MediaRouteVolumeSliderHolder> mVolumeSliderHolderMap;
    private static final String TAG = "MediaRouteCtrlDialog";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);

    public MediaRouteDynamicControllerDialog(Context context) {
        this(context, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaRouteDynamicControllerDialog(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.MediaRouterThemeHelper.createThemedDialogContext(r2, r3, r0)
            int r3 = androidx.mediarouter.app.MediaRouterThemeHelper.createThemedDialogStyle(r2)
            r1.<init>(r2, r3)
            androidx.mediarouter.media.MediaRouteSelector r2 = androidx.mediarouter.media.MediaRouteSelector.EMPTY
            r1.mSelector = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.mMemberRoutes = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.mGroupableRoutes = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.mTransferableRoutes = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.mUngroupableRoutes = r2
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$1 r2 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$1
            r2.<init>()
            r1.mHandler = r2
            android.content.Context r2 = r1.getContext()
            r1.mContext = r2
            androidx.mediarouter.media.MediaRouter r2 = androidx.mediarouter.media.MediaRouter.getInstance(r2)
            r1.mRouter = r2
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaRouterCallback r3 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaRouterCallback
            r3.<init>()
            r1.mCallback = r3
            androidx.mediarouter.media.MediaRouter$RouteInfo r3 = r2.getSelectedRoute()
            r1.mSelectedRoute = r3
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaControllerCallback r3 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaControllerCallback
            r3.<init>()
            r1.mControllerCallback = r3
            android.support.v4.media.session.MediaSessionCompat$Token r2 = r2.getMediaSessionToken()
            r1.setMediaSession(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.<init>(android.content.Context, int):void");
    }

    private void setMediaSession(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.mControllerCallback);
            this.mMediaController = null;
        }
        if (token != null && this.mAttachedToWindow) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.mContext, token);
            this.mMediaController = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(this.mControllerCallback);
            MediaMetadataCompat metadata = this.mMediaController.getMetadata();
            this.mDescription = metadata != null ? metadata.getDescription() : null;
            reloadIconIfNeeded();
            updateMetadataViews();
        }
    }

    public MediaSessionCompat.Token getMediaSession() {
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat == null) {
            return null;
        }
        return mediaControllerCompat.getSessionToken();
    }

    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.mSelector.equals(mediaRouteSelector)) {
            return;
        }
        this.mSelector = mediaRouteSelector;
        if (this.mAttachedToWindow) {
            this.mRouter.removeCallback(this.mCallback);
            this.mRouter.addCallback(mediaRouteSelector, this.mCallback, 1);
            updateRoutes();
        }
    }

    public void onFilterRoutes(List<MediaRouter.RouteInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!onFilterRoute(list.get(size))) {
                list.remove(size);
            }
        }
    }

    public boolean onFilterRoute(MediaRouter.RouteInfo routeInfo) {
        return !routeInfo.isDefaultOrBluetooth() && routeInfo.isEnabled() && routeInfo.matchesSelector(this.mSelector) && this.mSelectedRoute != routeInfo;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0554R.C0559layout.mr_cast_dialog);
        MediaRouterThemeHelper.setDialogBackgroundColor(this.mContext, this);
        ImageButton imageButton = (ImageButton) findViewById(C0554R.C0557id.mr_cast_close_button);
        this.mCloseButton = imageButton;
        imageButton.setColorFilter(-1);
        this.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaRouteDynamicControllerDialog.this.dismiss();
            }
        });
        Button button = (Button) findViewById(C0554R.C0557id.mr_cast_stop_button);
        this.mStopCastingButton = button;
        button.setTextColor(-1);
        this.mStopCastingButton.setOnClickListener(new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaRouteDynamicControllerDialog.this.mSelectedRoute.isSelected()) {
                    MediaRouteDynamicControllerDialog.this.mRouter.unselect(2);
                }
                MediaRouteDynamicControllerDialog.this.dismiss();
            }
        });
        this.mAdapter = new RecyclerAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(C0554R.C0557id.mr_cast_list);
        this.mRecyclerView = recyclerView;
        recyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mVolumeChangeListener = new VolumeChangeListener();
        this.mVolumeSliderHolderMap = new HashMap();
        this.mUnmutedVolumeMap = new HashMap();
        this.mMetadataBackground = (ImageView) findViewById(C0554R.C0557id.mr_cast_meta_background);
        this.mMetadataBlackScrim = findViewById(C0554R.C0557id.mr_cast_meta_black_scrim);
        this.mArtView = (ImageView) findViewById(C0554R.C0557id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(C0554R.C0557id.mr_cast_meta_title);
        this.mTitleView = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(C0554R.C0557id.mr_cast_meta_subtitle);
        this.mSubtitleView = textView2;
        textView2.setTextColor(-1);
        this.mTitlePlaceholder = this.mContext.getResources().getString(C0554R.string.mr_cast_dialog_title_view_placeholder);
        this.mCreated = true;
        updateLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.getDialogWidthForDynamicGroup(this.mContext), MediaRouteDialogHelper.getDialogHeight(this.mContext));
        this.mArtIconBitmap = null;
        this.mArtIconUri = null;
        reloadIconIfNeeded();
        updateMetadataViews();
        updateRoutesView();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
        updateRoutes();
        setMediaSession(this.mRouter.getMediaSessionToken());
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mRouter.removeCallback(this.mCallback);
        this.mHandler.removeCallbacksAndMessages(null);
        setMediaSession(null);
    }

    static boolean isBitmapRecycled(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    void reloadIconIfNeeded() {
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.mDescription;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        FetchArtTask fetchArtTask = this.mFetchArtTask;
        Bitmap iconBitmap2 = fetchArtTask == null ? this.mArtIconBitmap : fetchArtTask.getIconBitmap();
        FetchArtTask fetchArtTask2 = this.mFetchArtTask;
        Uri iconUri2 = fetchArtTask2 == null ? this.mArtIconUri : fetchArtTask2.getIconUri();
        if (iconBitmap2 != iconBitmap || (iconBitmap2 == null && !ObjectsCompat.equals(iconUri2, iconUri))) {
            FetchArtTask fetchArtTask3 = this.mFetchArtTask;
            if (fetchArtTask3 != null) {
                fetchArtTask3.cancel(true);
            }
            FetchArtTask fetchArtTask4 = new FetchArtTask();
            this.mFetchArtTask = fetchArtTask4;
            fetchArtTask4.execute(new Void[0]);
        }
    }

    void clearLoadedBitmap() {
        this.mArtIconIsLoaded = false;
        this.mArtIconLoadedBitmap = null;
        this.mArtIconBackgroundColor = 0;
    }

    private boolean shouldDeferUpdateViews() {
        if (this.mRouteForVolumeUpdatingByUser != null || this.mIsSelectingRoute || this.mIsAnimatingVolumeSliderLayout) {
            return true;
        }
        return !this.mCreated;
    }

    void updateViewsIfNeeded() {
        if (this.mUpdateRoutesViewDeferred) {
            updateRoutesView();
        }
        if (this.mUpdateMetadataViewsDeferred) {
            updateMetadataViews();
        }
    }

    void updateMetadataViews() {
        if (shouldDeferUpdateViews()) {
            this.mUpdateMetadataViewsDeferred = true;
            return;
        }
        this.mUpdateMetadataViewsDeferred = false;
        if (!this.mSelectedRoute.isSelected() || this.mSelectedRoute.isDefaultOrBluetooth()) {
            dismiss();
        }
        if (this.mArtIconIsLoaded && !isBitmapRecycled(this.mArtIconLoadedBitmap) && this.mArtIconLoadedBitmap != null) {
            this.mArtView.setVisibility(0);
            this.mArtView.setImageBitmap(this.mArtIconLoadedBitmap);
            this.mArtView.setBackgroundColor(this.mArtIconBackgroundColor);
            this.mMetadataBlackScrim.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 17) {
                this.mMetadataBackground.setImageBitmap(blurBitmap(this.mArtIconLoadedBitmap, 10.0f, this.mContext));
            } else {
                this.mMetadataBackground.setImageBitmap(Bitmap.createBitmap(this.mArtIconLoadedBitmap));
            }
        } else {
            if (isBitmapRecycled(this.mArtIconLoadedBitmap)) {
                Log.w(TAG, "Can't set artwork image with recycled bitmap: " + this.mArtIconLoadedBitmap);
            }
            this.mArtView.setVisibility(8);
            this.mMetadataBlackScrim.setVisibility(8);
            this.mMetadataBackground.setImageBitmap(null);
        }
        clearLoadedBitmap();
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        CharSequence title = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getTitle();
        boolean z = !TextUtils.isEmpty(title);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.mDescription;
        CharSequence subtitle = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getSubtitle() : null;
        boolean isEmpty = true ^ TextUtils.isEmpty(subtitle);
        if (z) {
            this.mTitleView.setText(title);
        } else {
            this.mTitleView.setText(this.mTitlePlaceholder);
        }
        if (isEmpty) {
            this.mSubtitleView.setText(subtitle);
            this.mSubtitleView.setVisibility(0);
            return;
        }
        this.mSubtitleView.setVisibility(8);
    }

    static void setLayoutHeight(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class VolumeChangeListener implements SeekBar.OnSeekBarChangeListener {
        VolumeChangeListener() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (MediaRouteDynamicControllerDialog.this.mRouteForVolumeUpdatingByUser != null) {
                MediaRouteDynamicControllerDialog.this.mHandler.removeMessages(2);
            }
            MediaRouteDynamicControllerDialog.this.mRouteForVolumeUpdatingByUser = (MediaRouter.RouteInfo) seekBar.getTag();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaRouteDynamicControllerDialog.this.mHandler.sendEmptyMessageDelayed(2, 500L);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) seekBar.getTag();
                MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder = MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.get(routeInfo.getId());
                if (mediaRouteVolumeSliderHolder != null) {
                    mediaRouteVolumeSliderHolder.setMute(i == 0);
                }
                routeInfo.requestSetVolume(i);
            }
        }
    }

    List<MediaRouter.RouteInfo> getCurrentGroupableRoutes() {
        ArrayList arrayList = new ArrayList();
        for (MediaRouter.RouteInfo routeInfo : this.mSelectedRoute.getProvider().getRoutes()) {
            MediaRouter.RouteInfo.DynamicGroupState dynamicGroupState = this.mSelectedRoute.getDynamicGroupState(routeInfo);
            if (dynamicGroupState != null && dynamicGroupState.isGroupable()) {
                arrayList.add(routeInfo);
            }
        }
        return arrayList;
    }

    void updateRoutesView() {
        if (this.mAttachedToWindow) {
            if (SystemClock.uptimeMillis() - this.mLastUpdateTime >= 300) {
                if (shouldDeferUpdateViews()) {
                    this.mUpdateRoutesViewDeferred = true;
                    return;
                }
                this.mUpdateRoutesViewDeferred = false;
                if (!this.mSelectedRoute.isSelected() || this.mSelectedRoute.isDefaultOrBluetooth()) {
                    dismiss();
                }
                this.mLastUpdateTime = SystemClock.uptimeMillis();
                this.mAdapter.notifyAdapterDataSetChanged();
                return;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageAtTime(1, this.mLastUpdateTime + 300);
        }
    }

    void updateRoutes() {
        this.mMemberRoutes.clear();
        this.mGroupableRoutes.clear();
        this.mTransferableRoutes.clear();
        this.mMemberRoutes.addAll(this.mSelectedRoute.getMemberRoutes());
        for (MediaRouter.RouteInfo routeInfo : this.mSelectedRoute.getProvider().getRoutes()) {
            MediaRouter.RouteInfo.DynamicGroupState dynamicGroupState = this.mSelectedRoute.getDynamicGroupState(routeInfo);
            if (dynamicGroupState != null) {
                if (dynamicGroupState.isGroupable()) {
                    this.mGroupableRoutes.add(routeInfo);
                }
                if (dynamicGroupState.isTransferable()) {
                    this.mTransferableRoutes.add(routeInfo);
                }
            }
        }
        onFilterRoutes(this.mGroupableRoutes);
        onFilterRoutes(this.mTransferableRoutes);
        Collections.sort(this.mMemberRoutes, RouteComparator.sInstance);
        Collections.sort(this.mGroupableRoutes, RouteComparator.sInstance);
        Collections.sort(this.mTransferableRoutes, RouteComparator.sInstance);
        this.mAdapter.updateItems();
    }

    private static Bitmap blurBitmap(Bitmap bitmap, float f, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius(f);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        createTyped.copyTo(copy);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        create.destroy();
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class MediaRouteVolumeSliderHolder extends RecyclerView.ViewHolder {
        final ImageButton mMuteButton;
        MediaRouter.RouteInfo mRoute;
        final MediaRouteVolumeSlider mVolumeSlider;

        MediaRouteVolumeSliderHolder(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            super(view);
            this.mMuteButton = imageButton;
            this.mVolumeSlider = mediaRouteVolumeSlider;
            imageButton.setImageDrawable(MediaRouterThemeHelper.getMuteButtonDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext));
            MediaRouterThemeHelper.setVolumeSliderColor(MediaRouteDynamicControllerDialog.this.mContext, mediaRouteVolumeSlider);
        }

        void bindRouteVolumeSliderHolder(MediaRouter.RouteInfo routeInfo) {
            this.mRoute = routeInfo;
            int volume = routeInfo.getVolume();
            this.mMuteButton.setActivated(volume == 0);
            this.mMuteButton.setOnClickListener(new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.MediaRouteVolumeSliderHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MediaRouteDynamicControllerDialog.this.mRouteForVolumeUpdatingByUser != null) {
                        MediaRouteDynamicControllerDialog.this.mHandler.removeMessages(2);
                    }
                    MediaRouteDynamicControllerDialog.this.mRouteForVolumeUpdatingByUser = MediaRouteVolumeSliderHolder.this.mRoute;
                    boolean z = !view.isActivated();
                    int unmutedVolume = z ? 0 : MediaRouteVolumeSliderHolder.this.getUnmutedVolume();
                    MediaRouteVolumeSliderHolder.this.setMute(z);
                    MediaRouteVolumeSliderHolder.this.mVolumeSlider.setProgress(unmutedVolume);
                    MediaRouteVolumeSliderHolder.this.mRoute.requestSetVolume(unmutedVolume);
                    MediaRouteDynamicControllerDialog.this.mHandler.sendEmptyMessageDelayed(2, 500L);
                }
            });
            this.mVolumeSlider.setTag(this.mRoute);
            this.mVolumeSlider.setMax(routeInfo.getVolumeMax());
            this.mVolumeSlider.setProgress(volume);
            this.mVolumeSlider.setOnSeekBarChangeListener(MediaRouteDynamicControllerDialog.this.mVolumeChangeListener);
        }

        void updateVolume() {
            int volume = this.mRoute.getVolume();
            setMute(volume == 0);
            this.mVolumeSlider.setProgress(volume);
        }

        void setMute(boolean z) {
            if (this.mMuteButton.isActivated() == z) {
                return;
            }
            this.mMuteButton.setActivated(z);
            if (z) {
                MediaRouteDynamicControllerDialog.this.mUnmutedVolumeMap.put(this.mRoute.getId(), Integer.valueOf(this.mVolumeSlider.getProgress()));
            } else {
                MediaRouteDynamicControllerDialog.this.mUnmutedVolumeMap.remove(this.mRoute.getId());
            }
        }

        int getUnmutedVolume() {
            Integer num = MediaRouteDynamicControllerDialog.this.mUnmutedVolumeMap.get(this.mRoute.getId());
            if (num == null) {
                return 1;
            }
            return Math.max(1, num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int ITEM_TYPE_GROUP = 4;
        private static final int ITEM_TYPE_GROUP_VOLUME = 1;
        private static final int ITEM_TYPE_HEADER = 2;
        private static final int ITEM_TYPE_ROUTE = 3;
        private final Drawable mDefaultIcon;
        private Item mGroupVolumeItem;
        private final LayoutInflater mInflater;
        private final int mLayoutAnimationDurationMs;
        private final Drawable mSpeakerGroupIcon;
        private final Drawable mSpeakerIcon;
        private final Drawable mTvIcon;
        private final ArrayList<Item> mItems = new ArrayList<>();
        private final Interpolator mAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();

        RecyclerAdapter() {
            this.mInflater = LayoutInflater.from(MediaRouteDynamicControllerDialog.this.mContext);
            this.mDefaultIcon = MediaRouterThemeHelper.getDefaultDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext);
            this.mTvIcon = MediaRouterThemeHelper.getTvDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext);
            this.mSpeakerIcon = MediaRouterThemeHelper.getSpeakerDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext);
            this.mSpeakerGroupIcon = MediaRouterThemeHelper.getSpeakerGroupDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext);
            this.mLayoutAnimationDurationMs = MediaRouteDynamicControllerDialog.this.mContext.getResources().getInteger(C0554R.integer.mr_cast_volume_slider_layout_animation_duration_ms);
            updateItems();
        }

        boolean isGroupVolumeNeeded() {
            return MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes().size() > 1;
        }

        void animateLayoutHeight(final View view, final int i) {
            final int i2 = view.getLayoutParams().height;
            Animation animation = new Animation() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.RecyclerAdapter.1
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    int i3 = i;
                    int i4 = i2;
                    MediaRouteDynamicControllerDialog.setLayoutHeight(view, i4 + ((int) ((i3 - i4) * f)));
                }
            };
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.RecyclerAdapter.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    MediaRouteDynamicControllerDialog.this.mIsAnimatingVolumeSliderLayout = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    MediaRouteDynamicControllerDialog.this.mIsAnimatingVolumeSliderLayout = false;
                    MediaRouteDynamicControllerDialog.this.updateViewsIfNeeded();
                }
            });
            animation.setDuration(this.mLayoutAnimationDurationMs);
            animation.setInterpolator(this.mAccelerateDecelerateInterpolator);
            view.startAnimation(animation);
        }

        void mayUpdateGroupVolume(MediaRouter.RouteInfo routeInfo, boolean z) {
            List<MediaRouter.RouteInfo> memberRoutes = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes();
            int max = Math.max(1, memberRoutes.size());
            if (routeInfo.isGroup()) {
                for (MediaRouter.RouteInfo routeInfo2 : routeInfo.getMemberRoutes()) {
                    if (memberRoutes.contains(routeInfo2) != z) {
                        max += z ? 1 : -1;
                    }
                }
            } else {
                max += z ? 1 : -1;
            }
            boolean isGroupVolumeNeeded = isGroupVolumeNeeded();
            boolean z2 = max >= 2;
            if (isGroupVolumeNeeded != z2) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = MediaRouteDynamicControllerDialog.this.mRecyclerView.findViewHolderForAdapterPosition(0);
                if (findViewHolderForAdapterPosition instanceof GroupVolumeViewHolder) {
                    GroupVolumeViewHolder groupVolumeViewHolder = (GroupVolumeViewHolder) findViewHolderForAdapterPosition;
                    animateLayoutHeight(groupVolumeViewHolder.itemView, z2 ? groupVolumeViewHolder.getExpandedHeight() : 0);
                }
            }
        }

        void updateItems() {
            this.mItems.clear();
            this.mGroupVolumeItem = new Item(MediaRouteDynamicControllerDialog.this.mSelectedRoute, 1);
            if (!MediaRouteDynamicControllerDialog.this.mMemberRoutes.isEmpty()) {
                for (MediaRouter.RouteInfo routeInfo : MediaRouteDynamicControllerDialog.this.mMemberRoutes) {
                    this.mItems.add(new Item(routeInfo, 3));
                }
            } else {
                this.mItems.add(new Item(MediaRouteDynamicControllerDialog.this.mSelectedRoute, 3));
            }
            boolean z = false;
            if (!MediaRouteDynamicControllerDialog.this.mGroupableRoutes.isEmpty()) {
                boolean z2 = false;
                for (MediaRouter.RouteInfo routeInfo2 : MediaRouteDynamicControllerDialog.this.mGroupableRoutes) {
                    if (!MediaRouteDynamicControllerDialog.this.mMemberRoutes.contains(routeInfo2)) {
                        if (!z2) {
                            MediaRouteProvider.DynamicGroupRouteController dynamicGroupController = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getDynamicGroupController();
                            String groupableSelectionTitle = dynamicGroupController != null ? dynamicGroupController.getGroupableSelectionTitle() : null;
                            if (TextUtils.isEmpty(groupableSelectionTitle)) {
                                groupableSelectionTitle = MediaRouteDynamicControllerDialog.this.mContext.getString(C0554R.string.mr_dialog_groupable_header);
                            }
                            this.mItems.add(new Item(groupableSelectionTitle, 2));
                            z2 = true;
                        }
                        this.mItems.add(new Item(routeInfo2, 3));
                    }
                }
            }
            if (!MediaRouteDynamicControllerDialog.this.mTransferableRoutes.isEmpty()) {
                for (MediaRouter.RouteInfo routeInfo3 : MediaRouteDynamicControllerDialog.this.mTransferableRoutes) {
                    if (MediaRouteDynamicControllerDialog.this.mSelectedRoute != routeInfo3) {
                        if (!z) {
                            MediaRouteProvider.DynamicGroupRouteController dynamicGroupController2 = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getDynamicGroupController();
                            String transferableSectionTitle = dynamicGroupController2 != null ? dynamicGroupController2.getTransferableSectionTitle() : null;
                            if (TextUtils.isEmpty(transferableSectionTitle)) {
                                transferableSectionTitle = MediaRouteDynamicControllerDialog.this.mContext.getString(C0554R.string.mr_dialog_transferable_header);
                            }
                            this.mItems.add(new Item(transferableSectionTitle, 2));
                            z = true;
                        }
                        this.mItems.add(new Item(routeInfo3, 4));
                    }
                }
            }
            notifyAdapterDataSetChanged();
        }

        void notifyAdapterDataSetChanged() {
            MediaRouteDynamicControllerDialog.this.mUngroupableRoutes.clear();
            MediaRouteDynamicControllerDialog.this.mUngroupableRoutes.addAll(MediaRouteDialogHelper.getItemsRemoved(MediaRouteDynamicControllerDialog.this.mGroupableRoutes, MediaRouteDynamicControllerDialog.this.getCurrentGroupableRoutes()));
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return new GroupViewHolder(this.mInflater.inflate(C0554R.C0559layout.mr_cast_group_item, viewGroup, false));
                        }
                        Log.w(MediaRouteDynamicControllerDialog.TAG, "Cannot create ViewHolder because of wrong view type");
                        return null;
                    }
                    return new RouteViewHolder(this.mInflater.inflate(C0554R.C0559layout.mr_cast_route_item, viewGroup, false));
                }
                return new HeaderViewHolder(this.mInflater.inflate(C0554R.C0559layout.mr_cast_header_item, viewGroup, false));
            }
            return new GroupVolumeViewHolder(this.mInflater.inflate(C0554R.C0559layout.mr_cast_group_volume_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            Item item = getItem(i);
            if (itemViewType == 1) {
                MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.put(((MediaRouter.RouteInfo) item.getData()).getId(), (MediaRouteVolumeSliderHolder) viewHolder);
                ((GroupVolumeViewHolder) viewHolder).bindGroupVolumeViewHolder(item);
            } else if (itemViewType == 2) {
                ((HeaderViewHolder) viewHolder).bindHeaderViewHolder(item);
            } else if (itemViewType == 3) {
                MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.put(((MediaRouter.RouteInfo) item.getData()).getId(), (MediaRouteVolumeSliderHolder) viewHolder);
                ((RouteViewHolder) viewHolder).bindRouteViewHolder(item);
            } else if (itemViewType == 4) {
                ((GroupViewHolder) viewHolder).bindGroupViewHolder(item);
            } else {
                Log.w(MediaRouteDynamicControllerDialog.TAG, "Cannot bind item to ViewHolder because of wrong view type");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            super.onViewRecycled(viewHolder);
            MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.values().remove(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mItems.size() + 1;
        }

        Drawable getIconDrawable(MediaRouter.RouteInfo routeInfo) {
            Uri iconUri = routeInfo.getIconUri();
            if (iconUri != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(MediaRouteDynamicControllerDialog.this.mContext.getContentResolver().openInputStream(iconUri), null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e) {
                    Log.w(MediaRouteDynamicControllerDialog.TAG, "Failed to load " + iconUri, e);
                }
            }
            return getDefaultIconDrawable(routeInfo);
        }

        private Drawable getDefaultIconDrawable(MediaRouter.RouteInfo routeInfo) {
            int deviceType = routeInfo.getDeviceType();
            if (deviceType != 1) {
                if (deviceType == 2) {
                    return this.mSpeakerIcon;
                }
                if (routeInfo.isGroup()) {
                    return this.mSpeakerGroupIcon;
                }
                return this.mDefaultIcon;
            }
            return this.mTvIcon;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return getItem(i).getType();
        }

        public Item getItem(int i) {
            if (i == 0) {
                return this.mGroupVolumeItem;
            }
            return this.mItems.get(i - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class Item {
            private final Object mData;
            private final int mType;

            Item(Object obj, int i) {
                this.mData = obj;
                this.mType = i;
            }

            public Object getData() {
                return this.mData;
            }

            public int getType() {
                return this.mType;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class GroupVolumeViewHolder extends MediaRouteVolumeSliderHolder {
            private final int mExpandedHeight;
            private final TextView mTextView;

            GroupVolumeViewHolder(View view) {
                super(view, (ImageButton) view.findViewById(C0554R.C0557id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(C0554R.C0557id.mr_cast_volume_slider));
                this.mTextView = (TextView) view.findViewById(C0554R.C0557id.mr_group_volume_route_name);
                Resources resources = MediaRouteDynamicControllerDialog.this.mContext.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(C0554R.dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
                this.mExpandedHeight = (int) typedValue.getDimension(displayMetrics);
            }

            void bindGroupVolumeViewHolder(Item item) {
                MediaRouteDynamicControllerDialog.setLayoutHeight(this.itemView, RecyclerAdapter.this.isGroupVolumeNeeded() ? this.mExpandedHeight : 0);
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.getData();
                super.bindRouteVolumeSliderHolder(routeInfo);
                this.mTextView.setText(routeInfo.getName());
            }

            int getExpandedHeight() {
                return this.mExpandedHeight;
            }
        }

        /* loaded from: classes.dex */
        private class HeaderViewHolder extends RecyclerView.ViewHolder {
            private final TextView mTextView;

            HeaderViewHolder(View view) {
                super(view);
                this.mTextView = (TextView) view.findViewById(C0554R.C0557id.mr_cast_header_name);
            }

            void bindHeaderViewHolder(Item item) {
                this.mTextView.setText(item.getData().toString());
            }
        }

        /* loaded from: classes.dex */
        private class RouteViewHolder extends MediaRouteVolumeSliderHolder {
            final CheckBox mCheckBox;
            final int mCollapsedLayoutHeight;
            final float mDisabledAlpha;
            final int mExpandedLayoutHeight;
            final ImageView mImageView;
            final View mItemView;
            final ProgressBar mProgressBar;
            final TextView mTextView;
            final View.OnClickListener mViewClickListener;
            final RelativeLayout mVolumeSliderLayout;

            RouteViewHolder(View view) {
                super(view, (ImageButton) view.findViewById(C0554R.C0557id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(C0554R.C0557id.mr_cast_volume_slider));
                this.mViewClickListener = new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.RecyclerAdapter.RouteViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RouteViewHolder routeViewHolder = RouteViewHolder.this;
                        boolean z = !routeViewHolder.isSelected(routeViewHolder.mRoute);
                        boolean isGroup = RouteViewHolder.this.mRoute.isGroup();
                        if (z) {
                            MediaRouteDynamicControllerDialog.this.mRouter.addMemberToDynamicGroup(RouteViewHolder.this.mRoute);
                        } else {
                            MediaRouteDynamicControllerDialog.this.mRouter.removeMemberFromDynamicGroup(RouteViewHolder.this.mRoute);
                        }
                        RouteViewHolder.this.showSelectingProgress(z, !isGroup);
                        if (isGroup) {
                            List<MediaRouter.RouteInfo> memberRoutes = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes();
                            for (MediaRouter.RouteInfo routeInfo : RouteViewHolder.this.mRoute.getMemberRoutes()) {
                                if (memberRoutes.contains(routeInfo) != z) {
                                    MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder = MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.get(routeInfo.getId());
                                    if (mediaRouteVolumeSliderHolder instanceof RouteViewHolder) {
                                        ((RouteViewHolder) mediaRouteVolumeSliderHolder).showSelectingProgress(z, true);
                                    }
                                }
                            }
                        }
                        RecyclerAdapter.this.mayUpdateGroupVolume(RouteViewHolder.this.mRoute, z);
                    }
                };
                this.mItemView = view;
                this.mImageView = (ImageView) view.findViewById(C0554R.C0557id.mr_cast_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(C0554R.C0557id.mr_cast_route_progress_bar);
                this.mProgressBar = progressBar;
                this.mTextView = (TextView) view.findViewById(C0554R.C0557id.mr_cast_route_name);
                this.mVolumeSliderLayout = (RelativeLayout) view.findViewById(C0554R.C0557id.mr_cast_volume_layout);
                CheckBox checkBox = (CheckBox) view.findViewById(C0554R.C0557id.mr_cast_checkbox);
                this.mCheckBox = checkBox;
                checkBox.setButtonDrawable(MediaRouterThemeHelper.getCheckBoxDrawableIcon(MediaRouteDynamicControllerDialog.this.mContext));
                MediaRouterThemeHelper.setIndeterminateProgressBarColor(MediaRouteDynamicControllerDialog.this.mContext, progressBar);
                this.mDisabledAlpha = MediaRouterThemeHelper.getDisabledAlpha(MediaRouteDynamicControllerDialog.this.mContext);
                Resources resources = MediaRouteDynamicControllerDialog.this.mContext.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(C0554R.dimen.mr_dynamic_dialog_row_height, typedValue, true);
                this.mExpandedLayoutHeight = (int) typedValue.getDimension(displayMetrics);
                this.mCollapsedLayoutHeight = 0;
            }

            boolean isSelected(MediaRouter.RouteInfo routeInfo) {
                if (routeInfo.isSelected()) {
                    return true;
                }
                MediaRouter.RouteInfo.DynamicGroupState dynamicGroupState = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getDynamicGroupState(routeInfo);
                return dynamicGroupState != null && dynamicGroupState.getSelectionState() == 3;
            }

            private boolean isEnabled(MediaRouter.RouteInfo routeInfo) {
                if (MediaRouteDynamicControllerDialog.this.mUngroupableRoutes.contains(routeInfo)) {
                    return false;
                }
                if (!isSelected(routeInfo) || MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes().size() >= 2) {
                    if (isSelected(routeInfo)) {
                        MediaRouter.RouteInfo.DynamicGroupState dynamicGroupState = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getDynamicGroupState(routeInfo);
                        return dynamicGroupState != null && dynamicGroupState.isUnselectable();
                    }
                    return true;
                }
                return false;
            }

            void bindRouteViewHolder(Item item) {
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.getData();
                if (routeInfo == MediaRouteDynamicControllerDialog.this.mSelectedRoute && routeInfo.getMemberRoutes().size() > 0) {
                    Iterator<MediaRouter.RouteInfo> it = routeInfo.getMemberRoutes().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MediaRouter.RouteInfo next = it.next();
                        if (!MediaRouteDynamicControllerDialog.this.mGroupableRoutes.contains(next)) {
                            routeInfo = next;
                            break;
                        }
                    }
                }
                bindRouteVolumeSliderHolder(routeInfo);
                this.mImageView.setImageDrawable(RecyclerAdapter.this.getIconDrawable(routeInfo));
                this.mTextView.setText(routeInfo.getName());
                boolean z = false;
                this.mCheckBox.setVisibility(0);
                boolean isSelected = isSelected(routeInfo);
                boolean isEnabled = isEnabled(routeInfo);
                this.mCheckBox.setChecked(isSelected);
                this.mProgressBar.setVisibility(4);
                this.mImageView.setVisibility(0);
                this.mItemView.setEnabled(isEnabled);
                this.mCheckBox.setEnabled(isEnabled);
                this.mMuteButton.setEnabled(isEnabled || isSelected);
                this.mVolumeSlider.setEnabled((isEnabled || isSelected) ? true : true);
                this.mItemView.setOnClickListener(this.mViewClickListener);
                this.mCheckBox.setOnClickListener(this.mViewClickListener);
                MediaRouteDynamicControllerDialog.setLayoutHeight(this.mVolumeSliderLayout, (!isSelected || this.mRoute.isGroup()) ? this.mCollapsedLayoutHeight : this.mExpandedLayoutHeight);
                float f = 1.0f;
                this.mItemView.setAlpha((isEnabled || isSelected) ? 1.0f : this.mDisabledAlpha);
                CheckBox checkBox = this.mCheckBox;
                if (!isEnabled && isSelected) {
                    f = this.mDisabledAlpha;
                }
                checkBox.setAlpha(f);
            }

            void showSelectingProgress(boolean z, boolean z2) {
                this.mCheckBox.setEnabled(false);
                this.mItemView.setEnabled(false);
                this.mCheckBox.setChecked(z);
                if (z) {
                    this.mImageView.setVisibility(4);
                    this.mProgressBar.setVisibility(0);
                }
                if (z2) {
                    RecyclerAdapter.this.animateLayoutHeight(this.mVolumeSliderLayout, z ? this.mExpandedLayoutHeight : this.mCollapsedLayoutHeight);
                }
            }
        }

        /* loaded from: classes.dex */
        private class GroupViewHolder extends RecyclerView.ViewHolder {
            final float mDisabledAlpha;
            final ImageView mImageView;
            final View mItemView;
            final ProgressBar mProgressBar;
            MediaRouter.RouteInfo mRoute;
            final TextView mTextView;

            GroupViewHolder(View view) {
                super(view);
                this.mItemView = view;
                this.mImageView = (ImageView) view.findViewById(C0554R.C0557id.mr_cast_group_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(C0554R.C0557id.mr_cast_group_progress_bar);
                this.mProgressBar = progressBar;
                this.mTextView = (TextView) view.findViewById(C0554R.C0557id.mr_cast_group_name);
                this.mDisabledAlpha = MediaRouterThemeHelper.getDisabledAlpha(MediaRouteDynamicControllerDialog.this.mContext);
                MediaRouterThemeHelper.setIndeterminateProgressBarColor(MediaRouteDynamicControllerDialog.this.mContext, progressBar);
            }

            private boolean isEnabled(MediaRouter.RouteInfo routeInfo) {
                List<MediaRouter.RouteInfo> memberRoutes = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes();
                return (memberRoutes.size() == 1 && memberRoutes.get(0) == routeInfo) ? false : true;
            }

            void bindGroupViewHolder(Item item) {
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.getData();
                this.mRoute = routeInfo;
                this.mImageView.setVisibility(0);
                this.mProgressBar.setVisibility(4);
                this.mItemView.setAlpha(isEnabled(routeInfo) ? 1.0f : this.mDisabledAlpha);
                this.mItemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.RecyclerAdapter.GroupViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MediaRouteDynamicControllerDialog.this.mRouter.transferToRoute(GroupViewHolder.this.mRoute);
                        GroupViewHolder.this.mImageView.setVisibility(4);
                        GroupViewHolder.this.mProgressBar.setVisibility(0);
                    }
                });
                this.mImageView.setImageDrawable(RecyclerAdapter.this.getIconDrawable(routeInfo));
                this.mTextView.setText(routeInfo.getName());
            }
        }
    }

    /* loaded from: classes.dex */
    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.updateRoutesView();
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.updateRoutesView();
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.mSelectedRoute = routeInfo;
            MediaRouteDynamicControllerDialog.this.mIsSelectingRoute = false;
            MediaRouteDynamicControllerDialog.this.updateViewsIfNeeded();
            MediaRouteDynamicControllerDialog.this.updateRoutes();
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.updateRoutesView();
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            boolean z;
            MediaRouter.RouteInfo.DynamicGroupState dynamicGroupState;
            if (routeInfo == MediaRouteDynamicControllerDialog.this.mSelectedRoute && routeInfo.getDynamicGroupController() != null) {
                for (MediaRouter.RouteInfo routeInfo2 : routeInfo.getProvider().getRoutes()) {
                    if (!MediaRouteDynamicControllerDialog.this.mSelectedRoute.getMemberRoutes().contains(routeInfo2) && (dynamicGroupState = MediaRouteDynamicControllerDialog.this.mSelectedRoute.getDynamicGroupState(routeInfo2)) != null && dynamicGroupState.isGroupable() && !MediaRouteDynamicControllerDialog.this.mGroupableRoutes.contains(routeInfo2)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                MediaRouteDynamicControllerDialog.this.updateViewsIfNeeded();
                MediaRouteDynamicControllerDialog.this.updateRoutes();
                return;
            }
            MediaRouteDynamicControllerDialog.this.updateRoutesView();
        }

        @Override // androidx.mediarouter.media.MediaRouter.Callback
        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder;
            int volume = routeInfo.getVolume();
            if (MediaRouteDynamicControllerDialog.DEBUG) {
                Log.d(MediaRouteDynamicControllerDialog.TAG, "onRouteVolumeChanged(), route.getVolume:" + volume);
            }
            if (MediaRouteDynamicControllerDialog.this.mRouteForVolumeUpdatingByUser == routeInfo || (mediaRouteVolumeSliderHolder = MediaRouteDynamicControllerDialog.this.mVolumeSliderHolderMap.get(routeInfo.getId())) == null) {
                return;
            }
            mediaRouteVolumeSliderHolder.updateVolume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MediaControllerCallback extends MediaControllerCompat.Callback {
        MediaControllerCallback() {
        }

        @Override // android.support.p002v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            if (MediaRouteDynamicControllerDialog.this.mMediaController != null) {
                MediaRouteDynamicControllerDialog.this.mMediaController.unregisterCallback(MediaRouteDynamicControllerDialog.this.mControllerCallback);
                MediaRouteDynamicControllerDialog.this.mMediaController = null;
            }
        }

        @Override // android.support.p002v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaRouteDynamicControllerDialog.this.mDescription = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
            MediaRouteDynamicControllerDialog.this.reloadIconIfNeeded();
            MediaRouteDynamicControllerDialog.this.updateMetadataViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FetchArtTask extends AsyncTask<Void, Void, Bitmap> {
        private int mBackgroundColor;
        private final Bitmap mIconBitmap;
        private final Uri mIconUri;

        FetchArtTask() {
            Bitmap iconBitmap = MediaRouteDynamicControllerDialog.this.mDescription == null ? null : MediaRouteDynamicControllerDialog.this.mDescription.getIconBitmap();
            if (MediaRouteDynamicControllerDialog.isBitmapRecycled(iconBitmap)) {
                Log.w(MediaRouteDynamicControllerDialog.TAG, "Can't fetch the given art bitmap because it's already recycled.");
                iconBitmap = null;
            }
            this.mIconBitmap = iconBitmap;
            this.mIconUri = MediaRouteDynamicControllerDialog.this.mDescription != null ? MediaRouteDynamicControllerDialog.this.mDescription.getIconUri() : null;
        }

        Bitmap getIconBitmap() {
            return this.mIconBitmap;
        }

        Uri getIconUri() {
            return this.mIconUri;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            MediaRouteDynamicControllerDialog.this.clearLoadedBitmap();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r9) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.FetchArtTask.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            MediaRouteDynamicControllerDialog.this.mFetchArtTask = null;
            if (ObjectsCompat.equals(MediaRouteDynamicControllerDialog.this.mArtIconBitmap, this.mIconBitmap) && ObjectsCompat.equals(MediaRouteDynamicControllerDialog.this.mArtIconUri, this.mIconUri)) {
                return;
            }
            MediaRouteDynamicControllerDialog.this.mArtIconBitmap = this.mIconBitmap;
            MediaRouteDynamicControllerDialog.this.mArtIconLoadedBitmap = bitmap;
            MediaRouteDynamicControllerDialog.this.mArtIconUri = this.mIconUri;
            MediaRouteDynamicControllerDialog.this.mArtIconBackgroundColor = this.mBackgroundColor;
            MediaRouteDynamicControllerDialog.this.mArtIconIsLoaded = true;
            MediaRouteDynamicControllerDialog.this.updateMetadataViews();
        }

        private InputStream openInputStreamByScheme(Uri uri) throws IOException {
            InputStream openInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                openInputStream = MediaRouteDynamicControllerDialog.this.mContext.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                openConnection.setConnectTimeout(MediaRouteDynamicControllerDialog.CONNECTION_TIMEOUT_MS);
                openConnection.setReadTimeout(MediaRouteDynamicControllerDialog.CONNECTION_TIMEOUT_MS);
                openInputStream = openConnection.getInputStream();
            }
            if (openInputStream == null) {
                return null;
            }
            return new BufferedInputStream(openInputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {
        static final RouteComparator sInstance = new RouteComparator();

        RouteComparator() {
        }

        @Override // java.util.Comparator
        public int compare(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
            return routeInfo.getName().compareToIgnoreCase(routeInfo2.getName());
        }
    }
}
