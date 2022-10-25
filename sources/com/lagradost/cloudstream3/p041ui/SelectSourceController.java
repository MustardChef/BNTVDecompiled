package com.lagradost.cloudstream3.p041ui;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.MediaQueue;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.api.PendingResult;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import com.lagradost.cloudstream3.p041ui.subtitles.ChromecastSubtitlesFragment;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveChromeCaptionStyle;
import com.lagradost.cloudstream3.utils.CastHelper;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/SelectSourceController;", "Lcom/google/android/gms/cast/framework/media/uicontroller/UIController;", ViewHierarchyConstants.VIEW_KEY, "Landroid/widget/ImageView;", "activity", "Lcom/lagradost/cloudstream3/ui/ControllerActivity;", "(Landroid/widget/ImageView;Lcom/lagradost/cloudstream3/ui/ControllerActivity;)V", "getActivity", "()Lcom/lagradost/cloudstream3/ui/ControllerActivity;", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "getView", "()Landroid/widget/ImageView;", "getCurrentMetaData", "Lcom/lagradost/cloudstream3/ui/MetadataHolder;", "onMediaStatusUpdated", "", "onSessionConnected", "castSession", "Lcom/google/android/gms/cast/framework/CastSession;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController */
/* loaded from: classes.dex */
public final class SelectSourceController extends UIController {
    private final ControllerActivity activity;
    private boolean isLoadingMore;
    private final JsonMapper mapper;
    private final ImageView view;

    public final ControllerActivity getActivity() {
        return this.activity;
    }

    public final ImageView getView() {
        return this.view;
    }

    public SelectSourceController(ImageView view, ControllerActivity activity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.view = view;
        this.activity = activity;
        JsonMapper build = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder().addModule(Kotl…ROPERTIES, false).build()");
        this.mapper = build;
        view.setImageResource(R.drawable.ic_baseline_playlist_play_24);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.-$$Lambda$SelectSourceController$sE9IYbhHbbbT_OKFo6K9CMCZ4RA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectSourceController.m8605_init_$lambda11(SelectSourceController.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-11  reason: not valid java name */
    public static final void m8605_init_$lambda11(final SelectSourceController this$0, View view) {
        final ArrayList arrayList;
        int i;
        MediaStatus mediaStatus;
        String contentId;
        MediaQueueItem currentItem;
        MediaInfo media;
        int i2;
        MediaQueueItem currentItem2;
        MediaInfo media2;
        MediaInfo mediaInfo;
        List<MediaTrack> mediaTracks;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final MetadataHolder currentMetaData = this$0.getCurrentMetaData();
        if (currentMetaData != null) {
            List<ExtractorLink> currentLinks = currentMetaData.getCurrentLinks();
            if (!currentLinks.isEmpty()) {
                RemoteMediaClient remoteMediaClient = this$0.getRemoteMediaClient();
                if ((remoteMediaClient != null ? remoteMediaClient.getCurrentItem() : null) != null) {
                    RemoteMediaClient remoteMediaClient2 = this$0.getRemoteMediaClient();
                    int i3 = 0;
                    if (remoteMediaClient2 == null || (mediaInfo = remoteMediaClient2.getMediaInfo()) == null || (mediaTracks = mediaInfo.getMediaTracks()) == null) {
                        arrayList = new ArrayList();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : mediaTracks) {
                            if (((MediaTrack) obj).getType() == 1) {
                                arrayList2.add(obj);
                            }
                        }
                        arrayList = arrayList2;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this$0.view.getContext(), R.style.AlertDialogCustomBlack);
                    builder.setView(R.layout.sort_bottom_sheet);
                    final AlertDialog create = builder.create();
                    Intrinsics.checkNotNullExpressionValue(create, "bottomSheetDialogBuilder.create()");
                    create.show();
                    View findViewById = create.findViewById(R.id.sort_providers);
                    Intrinsics.checkNotNull(findViewById);
                    ListView listView = (ListView) findViewById;
                    View findViewById2 = create.findViewById(R.id.sort_subtitles);
                    Intrinsics.checkNotNull(findViewById2);
                    ListView listView2 = (ListView) findViewById2;
                    if (arrayList.isEmpty()) {
                        LinearLayout linearLayout = (LinearLayout) create.findViewById(R.id.sort_subtitles_holder);
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(this$0.view.getContext(), R.layout.sort_bottom_single_choice);
                        arrayAdapter.add(this$0.view.getContext().getString(R.string.no_subtitles));
                        ArrayList<MediaTrack> arrayList3 = arrayList;
                        ArrayList arrayList4 = new ArrayList();
                        for (MediaTrack mediaTrack : arrayList3) {
                            String name = mediaTrack.getName();
                            if (name != null) {
                                arrayList4.add(name);
                            }
                        }
                        arrayAdapter.addAll(arrayList4);
                        listView2.setChoiceMode(1);
                        listView2.setAdapter((ListAdapter) arrayAdapter);
                        RemoteMediaClient remoteMediaClient3 = this$0.getRemoteMediaClient();
                        long[] activeTrackIds = (remoteMediaClient3 == null || (mediaStatus = remoteMediaClient3.getMediaStatus()) == null) ? null : mediaStatus.getActiveTrackIds();
                        if (activeTrackIds == null) {
                            i = 0;
                        } else {
                            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                            for (MediaTrack mediaTrack2 : arrayList3) {
                                arrayList5.add(Long.valueOf(mediaTrack2.getId()));
                            }
                            Iterator it = arrayList5.iterator();
                            int i4 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i4 = -1;
                                    break;
                                } else if (ArraysKt.contains(activeTrackIds, ((Number) it.next()).longValue())) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            i = i4 + 1;
                        }
                        listView2.setSelection(i);
                        listView2.setItemChecked(i, true);
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.ui.-$$Lambda$SelectSourceController$ky1oEWBWZYppctt5Bzs8jtsNZRc
                            @Override // android.widget.AdapterView.OnItemClickListener
                            public final void onItemClick(AdapterView adapterView, View view2, int i5, long j) {
                                SelectSourceController.m8609lambda11$lambda7(SelectSourceController.this, arrayList, create, adapterView, view2, i5, j);
                            }
                        });
                    }
                    RemoteMediaClient remoteMediaClient4 = this$0.getRemoteMediaClient();
                    if (remoteMediaClient4 == null || (currentItem2 = remoteMediaClient4.getCurrentItem()) == null || (media2 = currentItem2.getMedia()) == null || (contentId = media2.getContentUrl()) == null) {
                        RemoteMediaClient remoteMediaClient5 = this$0.getRemoteMediaClient();
                        contentId = (remoteMediaClient5 == null || (currentItem = remoteMediaClient5.getCurrentItem()) == null || (media = currentItem.getMedia()) == null) ? null : media.getContentId();
                    }
                    List<ExtractorLink> list = currentLinks;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ExtractorLink extractorLink : list) {
                        arrayList6.add(extractorLink.getName() + ' ' + Qualities.Companion.getStringByInt(Integer.valueOf(extractorLink.getQuality())));
                    }
                    Object[] array = arrayList6.toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    Iterator<ExtractorLink> it2 = currentLinks.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (Intrinsics.areEqual(it2.next().getUrl(), contentId)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    ArrayAdapter arrayAdapter2 = new ArrayAdapter(this$0.view.getContext(), R.layout.sort_bottom_single_choice);
                    arrayAdapter2.addAll(ArraysKt.toMutableList(strArr));
                    listView.setChoiceMode(1);
                    listView.setAdapter((ListAdapter) arrayAdapter2);
                    listView.setSelection(i2);
                    listView.setItemChecked(i2, true);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.ui.-$$Lambda$SelectSourceController$Ysh7PEP6Cg95l3_0U833pSp58ck
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i5, long j) {
                            SelectSourceController.m8607lambda11$lambda10(MetadataHolder.this, create, this$0, adapterView, view2, i5, j);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-7  reason: not valid java name */
    public static final void m8609lambda11$lambda7(SelectSourceController this$0, List subTracks, AlertDialog bottomSheetDialog, AdapterView adapterView, View view, int i, long j) {
        PendingResult<RemoteMediaClient.MediaChannelResult> activeMediaTracks;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subTracks, "$subTracks");
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        if (i == 0) {
            RemoteMediaClient remoteMediaClient = this$0.getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.setActiveMediaTracks(new long[0]);
            }
        } else {
            SaveChromeCaptionStyle currentSavedStyle = ChromecastSubtitlesFragment.Companion.getCurrentSavedStyle();
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            Integer fontGenericFamily = currentSavedStyle.getFontGenericFamily();
            if (fontGenericFamily != null) {
                textTrackStyle.setFontGenericFamily(fontGenericFamily.intValue());
            }
            textTrackStyle.setWindowColor(currentSavedStyle.getWindowColor());
            textTrackStyle.setBackgroundColor(currentSavedStyle.getBackgroundColor());
            textTrackStyle.setEdgeColor(currentSavedStyle.getEdgeColor());
            textTrackStyle.setEdgeType(currentSavedStyle.getEdgeType());
            textTrackStyle.setForegroundColor(currentSavedStyle.getForegroundColor());
            textTrackStyle.setFontScale(currentSavedStyle.getFontScale());
            RemoteMediaClient remoteMediaClient2 = this$0.getRemoteMediaClient();
            if (remoteMediaClient2 != null) {
                remoteMediaClient2.setTextTrackStyle(textTrackStyle);
            }
            RemoteMediaClient remoteMediaClient3 = this$0.getRemoteMediaClient();
            if (remoteMediaClient3 != null && (activeMediaTracks = remoteMediaClient3.setActiveMediaTracks(new long[]{((MediaTrack) subTracks.get(i - 1)).getId()})) != null) {
                activeMediaTracks.setResultCallback($$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg.INSTANCE);
            }
        }
        UIHelper.INSTANCE.dismissSafe(bottomSheetDialog, this$0.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-7$lambda-6  reason: not valid java name */
    public static final void m8610lambda11$lambda7$lambda6(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        if (mediaChannelResult.getStatus().isSuccess()) {
            return;
        }
        Log.e("CHROMECAST", "Failed with status code:" + mediaChannelResult.getStatus().getStatusCode() + " > " + mediaChannelResult.getStatus().getStatusMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-10  reason: not valid java name */
    public static final void m8607lambda11$lambda10(MetadataHolder metadataHolder, AlertDialog bottomSheetDialog, SelectSourceController this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m8608lambda11$lambda10$loadMirror(metadataHolder, metadataHolder.getEpisodes().get(metadataHolder.getCurrentEpisodeIndex()), this$0, i);
        UIHelper.INSTANCE.dismissSafe(bottomSheetDialog, this$0.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-10$loadMirror  reason: not valid java name */
    public static final void m8608lambda11$lambda10$loadMirror(MetadataHolder metadataHolder, ResultEpisode resultEpisode, SelectSourceController selectSourceController, int i) {
        Integer num;
        MediaQueue mediaQueue;
        int[] itemIds;
        MediaInfo mediaInfo;
        if (metadataHolder.getCurrentLinks().size() <= i) {
            return;
        }
        CastHelper castHelper = CastHelper.INSTANCE;
        RemoteMediaClient remoteMediaClient = selectSourceController.getRemoteMediaClient();
        MediaInfo mediaInfo2 = castHelper.getMediaInfo(resultEpisode, metadataHolder, i, (remoteMediaClient == null || (mediaInfo = remoteMediaClient.getMediaInfo()) == null) ? null : mediaInfo.getCustomData(), metadataHolder.getCurrentSubtitles());
        RemoteMediaClient remoteMediaClient2 = selectSourceController.getRemoteMediaClient();
        long approximateStreamPosition = remoteMediaClient2 != null ? remoteMediaClient2.getApproximateStreamPosition() : 0L;
        try {
            RemoteMediaClient remoteMediaClient3 = selectSourceController.getRemoteMediaClient();
            Integer itemIndex = remoteMediaClient3 != null ? ControllerActivityKt.getItemIndex(remoteMediaClient3) : null;
            RemoteMediaClient remoteMediaClient4 = selectSourceController.getRemoteMediaClient();
            if (remoteMediaClient4 == null || (mediaQueue = remoteMediaClient4.getMediaQueue()) == null || (itemIds = mediaQueue.getItemIds()) == null) {
                num = null;
            } else {
                num = Integer.valueOf(itemIds[itemIndex != null ? itemIndex.intValue() + 1 : 0]);
            }
            if (itemIndex == null && num != null) {
                CastHelper castHelper2 = CastHelper.INSTANCE;
                RemoteMediaClient remoteMediaClient5 = selectSourceController.getRemoteMediaClient();
                castHelper2.awaitLinks(remoteMediaClient5 != null ? remoteMediaClient5.queueInsertAndPlayItem(new MediaQueueItem.Builder(mediaInfo2).build(), num.intValue(), approximateStreamPosition, new JSONObject()) : null, new SelectSourceController$1$3$loadMirror$1(i, metadataHolder, resultEpisode, selectSourceController));
                return;
            }
            CastHelper castHelper3 = CastHelper.INSTANCE;
            RemoteMediaClient remoteMediaClient6 = selectSourceController.getRemoteMediaClient();
            castHelper3.awaitLinks(remoteMediaClient6 != null ? remoteMediaClient6.load(mediaInfo2, true, approximateStreamPosition) : null, new SelectSourceController$1$3$loadMirror$2(i, metadataHolder, resultEpisode, selectSourceController));
        } catch (Exception unused) {
            CastHelper castHelper4 = CastHelper.INSTANCE;
            RemoteMediaClient remoteMediaClient7 = selectSourceController.getRemoteMediaClient();
            castHelper4.awaitLinks(remoteMediaClient7 != null ? remoteMediaClient7.load(mediaInfo2, true, approximateStreamPosition) : null, new SelectSourceController$1$3$loadMirror$3(i, metadataHolder, resultEpisode, selectSourceController));
        }
    }

    private final MetadataHolder getCurrentMetaData() {
        MediaInfo mediaInfo;
        JSONObject customData;
        try {
            RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
            String jSONObject = (remoteMediaClient == null || (mediaInfo = remoteMediaClient.getMediaInfo()) == null || (customData = mediaInfo.getCustomData()) == null) ? null : customData.toString();
            if (jSONObject != null) {
                Object readValue = DataStore.INSTANCE.getMapper().readValue(jSONObject, MetadataHolder.class);
                Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                return (MetadataHolder) readValue;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    public final void setLoadingMore(boolean z) {
        this.isLoadingMore = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        r0 = com.lagradost.cloudstream3.p041ui.ControllerActivityKt.getItemIndex(r0);
     */
    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMediaStatusUpdated() {
        /*
            r14 = this;
            super.onMediaStatusUpdated()
            com.lagradost.cloudstream3.ui.MetadataHolder r2 = r14.getCurrentMetaData()
            android.widget.ImageView r0 = r14.view
            r1 = 0
            if (r2 == 0) goto L17
            java.util.List r3 = r2.getCurrentLinks()
            if (r3 == 0) goto L17
            int r3 = r3.size()
            goto L18
        L17:
            r3 = 0
        L18:
            r4 = 1
            if (r3 <= r4) goto L1c
            goto L1d
        L1c:
            r1 = 4
        L1d:
            r0.setVisibility(r1)
            if (r2 == 0) goto Lce
            java.util.List r0 = r2.getEpisodes()     // Catch: java.lang.Exception -> Lc8
            int r0 = r0.size()     // Catch: java.lang.Exception -> Lc8
            int r1 = r2.getCurrentEpisodeIndex()     // Catch: java.lang.Exception -> Lc8
            int r1 = r1 + r4
            if (r0 <= r1) goto Lce
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r14.getRemoteMediaClient()     // Catch: java.lang.Exception -> Lc8
            if (r0 == 0) goto Lc7
            java.lang.Integer r0 = com.lagradost.cloudstream3.p041ui.ControllerActivityKt.access$getItemIndex(r0)     // Catch: java.lang.Exception -> Lc8
            if (r0 == 0) goto Lc7
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> Lc8
            com.google.android.gms.cast.framework.media.RemoteMediaClient r1 = r14.getRemoteMediaClient()     // Catch: java.lang.Exception -> Lc8
            r3 = 0
            if (r1 == 0) goto L57
            com.google.android.gms.cast.framework.media.MediaQueue r1 = r1.getMediaQueue()     // Catch: java.lang.Exception -> Lc8
            if (r1 == 0) goto L57
            int r1 = r1.getItemCount()     // Catch: java.lang.Exception -> Lc8
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lc8
            goto L58
        L57:
            r1 = r3
        L58:
            int r5 = r2.getCurrentEpisodeIndex()     // Catch: java.lang.Exception -> Lc8
            int r5 = r5 + r4
            java.util.List r6 = r2.getEpisodes()     // Catch: java.lang.Exception -> Lc8
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Exception -> Lc8
            com.lagradost.cloudstream3.ui.result.ResultEpisode r6 = (com.lagradost.cloudstream3.p041ui.result.ResultEpisode) r6     // Catch: java.lang.Exception -> Lc8
            com.google.android.gms.cast.framework.media.RemoteMediaClient r7 = r14.getRemoteMediaClient()     // Catch: java.lang.Exception -> L9f
            if (r7 == 0) goto L76
            long r7 = r7.getStreamDuration()     // Catch: java.lang.Exception -> L9f
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> L9f
            goto L77
        L76:
            r7 = r3
        L77:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r8 = r14.getRemoteMediaClient()     // Catch: java.lang.Exception -> L9f
            if (r8 == 0) goto L85
            long r8 = r8.getApproximateStreamPosition()     // Catch: java.lang.Exception -> L9f
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L9f
        L85:
            if (r7 == 0) goto La5
            if (r3 == 0) goto La5
            com.lagradost.cloudstream3.utils.DataStoreHelper r8 = com.lagradost.cloudstream3.utils.DataStoreHelper.INSTANCE     // Catch: java.lang.Exception -> L9f
            int r9 = r6.getId()     // Catch: java.lang.Exception -> L9f
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L9f
            long r10 = r3.longValue()     // Catch: java.lang.Exception -> L9f
            long r12 = r7.longValue()     // Catch: java.lang.Exception -> L9f
            r8.setViewPos(r9, r10, r12)     // Catch: java.lang.Exception -> L9f
            goto La5
        L9f:
            r3 = move-exception
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Exception -> Lc8
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r3)     // Catch: java.lang.Exception -> Lc8
        La5:
            if (r1 == 0) goto Lce
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> Lc8
            int r1 = r1 - r0
            if (r1 != r4) goto Lce
            boolean r0 = r14.isLoadingMore     // Catch: java.lang.Exception -> Lc8
            if (r0 != 0) goto Lce
            r14.isLoadingMore = r4     // Catch: java.lang.Exception -> Lc8
            com.lagradost.cloudstream3.utils.Coroutines r7 = com.lagradost.cloudstream3.utils.Coroutines.INSTANCE     // Catch: java.lang.Exception -> Lc8
            com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1 r8 = new com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1     // Catch: java.lang.Exception -> Lc8
            r9 = 0
            r0 = r8
            r1 = r6
            r3 = r5
            r4 = r14
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lc8
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Exception -> Lc8
            r7.ioSafe(r8)     // Catch: java.lang.Exception -> Lc8
            goto Lce
        Lc7:
            return
        Lc8:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out
            r1.println(r0)
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.SelectSourceController.onMediaStatusUpdated():void");
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public void onSessionConnected(CastSession castSession) {
        Intrinsics.checkNotNullParameter(castSession, "castSession");
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.queueSetRepeatMode(0, new JSONObject());
        }
    }
}
