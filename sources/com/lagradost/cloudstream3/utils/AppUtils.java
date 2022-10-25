package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import androidx.tvprovider.media.p009tv.WatchNextProgram;
import com.bongngotv2.R;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.wrappers.Wrappers;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD;
import com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.text.StringsKt;
import okhttp3.Cache;

/* compiled from: AppUtils.kt */
@Metadata(m108d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J4\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0018H\u0007J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J(\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u001e\u0010\"\u001a\u0002H#\"\u0006\b\u0000\u0010#\u0018\u00012\u0006\u0010$\u001a\u00020\u001fH\u0086\b¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0'2\u0006\u0010(\u001a\u00020)J\"\u0010*\u001a\u0004\u0018\u0001H#\"\u0006\b\u0000\u0010#\u0018\u00012\b\u0010$\u001a\u0004\u0018\u00010\u001fH\u0086\b¢\u0006\u0002\u0010%J\u001a\u0010+\u001a\u00020,*\u00020\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130.H\u0007J\u0018\u0010/\u001a\u00020,*\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u001fH\u0002J-\u00102\u001a\u00020\u001f*\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u001f2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0004\u0018\u00010\u001d*\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0007J\u0012\u00109\u001a\u00020\t*\u00020\u00112\u0006\u0010:\u001a\u00020\u001fJ\n\u0010;\u001a\u00020\t*\u00020\u0011J\n\u0010<\u001a\u00020\t*\u00020\u0011J\n\u0010=\u001a\u00020\t*\u00020\u0011J\f\u0010>\u001a\u00020,*\u0004\u0018\u000100J.\u0010?\u001a\u00020,*\u00020@2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001f2\b\b\u0002\u0010B\u001a\u0002052\b\b\u0002\u0010C\u001a\u000205J/\u0010D\u001a\u00020,*\u0004\u0018\u0001002\u0006\u0010\u0012\u001a\u00020E2\b\b\u0002\u0010B\u001a\u0002052\n\b\u0002\u0010C\u001a\u0004\u0018\u000105¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u00020,*\u00020\u00112\u0006\u0010(\u001a\u00020\u001fJ\u0014\u0010H\u001a\u00020,*\u0002002\b\u0010I\u001a\u0004\u0018\u00010\u0006J\n\u0010J\u001a\u00020\u001f*\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006K"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/AppUtils;", "", "()V", "currentAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "currentAudioFocusRequest", "Landroid/media/AudioFocusRequest;", "onAudioFocusEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "", "getOnAudioFocusEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "setOnAudioFocusEvent", "(Lcom/lagradost/cloudstream3/utils/Event;)V", "buildWatchNextProgramUri", "Landroidx/tvprovider/media/tv/WatchNextProgram;", "context", "Landroid/content/Context;", "card", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$ResumeWatchingResult;", "findFirstWatchNextProgram", "Lkotlin/Pair;", "", "predicate", "Lkotlin/Function1;", "Landroid/database/Cursor;", "getAudioListener", "getFocusRequest", "getVideoContentUri", "Landroid/net/Uri;", "videoFilePath", "", "getWatchNextProgramByVideoId", "id", "parseJson", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/String;)Ljava/lang/Object;", "splitQuery", "", "url", "Ljava/net/URL;", "tryParseJson", "addProgramsToContinueWatching", "", "data", "", "cacheClass", "Landroid/app/Activity;", "clazz", "getNameFull", "name", "episode", "", "season", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "getUri", "isAppInstalled", ShareConstants.MEDIA_URI, "isCastApiAvailable", "isConnectedToChromecast", "isUsingMobileData", "loadCache", "loadResult", "Landroidx/appcompat/app/AppCompatActivity;", "apiName", "startAction", "startValue", "loadSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Landroid/app/Activity;Lcom/lagradost/cloudstream3/SearchResponse;ILjava/lang/Integer;)V", "openBrowser", "requestLocalAudioFocus", "focusRequest", "toJson", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class AppUtils {
    private static AudioManager.OnAudioFocusChangeListener currentAudioFocusChangeListener;
    private static AudioFocusRequest currentAudioFocusRequest;
    public static final AppUtils INSTANCE = new AppUtils();
    private static Event<Boolean> onAudioFocusEvent = new Event<>();

    private AppUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchNextProgram buildWatchNextProgramUri(Context context, DataStoreHelper.ResumeWatchingResult resumeWatchingResult) {
        String name;
        Integer episode;
        TvType type = resumeWatchingResult.getType();
        boolean z = (type == null || MainAPIKt.isMovieType(type)) ? false : true;
        if (z) {
            name = getNameFull(context, resumeWatchingResult.getName(), resumeWatchingResult.getEpisode(), resumeWatchingResult.getSeason());
        } else {
            name = resumeWatchingResult.getName();
        }
        WatchNextProgram.Builder internalProviderId = ((WatchNextProgram.Builder) ((WatchNextProgram.Builder) ((WatchNextProgram.Builder) new WatchNextProgram.Builder().setEpisodeTitle(name)).setType(z ? 3 : 0).setWatchNextType(0).setTitle(name)).setPosterArtUri(Uri.parse(resumeWatchingResult.getPosterUrl()))).setIntentUri(Uri.parse(resumeWatchingResult.getUrl())).setInternalProviderId(resumeWatchingResult.getUrl());
        DataStoreHelper.PosDur watchPos = resumeWatchingResult.getWatchPos();
        if (watchPos != null) {
            internalProviderId.setDurationMillis((int) watchPos.getDuration());
            internalProviderId.setLastPlaybackPositionMillis((int) watchPos.getPosition());
        }
        if (z && (episode = resumeWatchingResult.getEpisode()) != null) {
            WatchNextProgram.Builder builder = (WatchNextProgram.Builder) internalProviderId.setEpisodeNumber(episode.intValue());
        }
        WatchNextProgram build = internalProviderId.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final Tuples<WatchNextProgram, Long> findFirstWatchNextProgram(Context context, Function1<? super Cursor, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Cursor query = context.getContentResolver().query(TvContractCompat.WatchNextPrograms.CONTENT_URI, WatchNextProgram.PROJECTION, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    while (!predicate.invoke(query).booleanValue()) {
                        if (!cursor2.moveToNext()) {
                            Unit unit = Unit.INSTANCE;
                            Closeable.closeFinally(cursor, null);
                        }
                    }
                    Tuples<WatchNextProgram, Long> m100to = TuplesKt.m100to(WatchNextProgram.fromCursor(query), Long.valueOf(query.getLong(0)));
                    Closeable.closeFinally(cursor, null);
                    return m100to;
                }
                Unit unit2 = Unit.INSTANCE;
                Closeable.closeFinally(cursor, null);
            } finally {
            }
        }
        return TuplesKt.m100to(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Tuples<WatchNextProgram, Long> getWatchNextProgramByVideoId(String str, Context context) {
        return findFirstWatchNextProgram(context, new AppUtils$getWatchNextProgramByVideoId$1(str));
    }

    public final void addProgramsToContinueWatching(Context context, List<DataStoreHelper.ResumeWatchingResult> data) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Coroutines.INSTANCE.ioSafe(new AppUtils$addProgramsToContinueWatching$1(data, context, null));
    }

    public final Uri getVideoContentUri(Context context, String videoFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoFilePath, "videoFilePath");
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{videoFilePath}, null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex("_id"));
            query.close();
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            return Uri.withAppendedPath(uri, "" + i);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", videoFilePath);
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public final void openBrowser(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.addFlags(268468224);
            ContextCompat.startActivity(context, intent, null);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final Map<String, String> splitQuery(URL url) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(url, "url");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String query = url.getQuery();
        Intrinsics.checkNotNullExpressionValue(query, "url.query");
        Object[] array = StringsKt.split$default((CharSequence) query, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "=", 0, false, 6, (Object) null);
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String decode = URLDecoder.decode(substring, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(pair.substring(0, idx), \"UTF-8\")");
            String substring2 = str.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String decode2 = URLDecoder.decode(substring2, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode2, "decode(pair.substring(idx + 1), \"UTF-8\")");
            linkedHashMap.put(decode, decode2);
        }
        return linkedHashMap;
    }

    public final String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof String) {
            return (String) obj;
        }
        String writeValueAsString = MainAPIKt.getMapper().writeValueAsString(obj);
        Intrinsics.checkNotNullExpressionValue(writeValueAsString, "mapper.writeValueAsString(this)");
        return writeValueAsString;
    }

    public final /* synthetic */ <T> T parseJson(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.needClassReification();
        return (T) MainAPIKt.getMapper().readValue(value, new TypeReference<T>() { // from class: com.lagradost.cloudstream3.utils.AppUtils$parseJson$$inlined$readValue$1
        });
    }

    public final String getNameFull(Context context, String str, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (num != null && num.intValue() == 0) {
            num = null;
        }
        if (num2 != null && num2.intValue() == 0) {
            num2 = null;
        }
        String string = context.getString(R.string.season);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.season)");
        String string2 = context.getString(R.string.episode);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.episode)");
        String string3 = context.getString(R.string.season_short);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.season_short)");
        String string4 = context.getString(R.string.episode_short);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.episode_short)");
        if (str == null) {
            if (num == null || num2 == null) {
                if (num2 == null) {
                    return string2 + ' ' + num;
                }
                return "";
            }
            return string + ' ' + num2 + " - " + string2 + ' ' + num;
        } else if (num == null || num2 == null) {
            if (num != null) {
                return string2 + ' ' + num + ". " + str;
            }
            return str;
        } else {
            return string3 + num2 + ':' + string4 + num + ' ' + str;
        }
    }

    public final void loadCache(Activity activity) {
        try {
            cacheClass(activity, JsUnpacker.Companion.load("android.net.NetworkCapabilities"));
        } catch (Exception unused) {
        }
    }

    public final void loadResult(final AppCompatActivity appCompatActivity, final String url, final String apiName, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        appCompatActivity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$AppUtils$iaite49wW099-TVuH9NG7uV6WcY
            @Override // java.lang.Runnable
            public final void run() {
                AppUtils.m8993loadResult$lambda3(AppCompatActivity.this, url, apiName, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadResult$lambda-3  reason: not valid java name */
    public static final void m8993loadResult$lambda3(AppCompatActivity this_loadResult, String url, String apiName, int i, int i2) {
        Intrinsics.checkNotNullParameter(this_loadResult, "$this_loadResult");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        AppCompatActivity appCompatActivity = this_loadResult;
        AppCompatActivity appCompatActivity2 = this_loadResult;
        UIHelper.INSTANCE.navigate(appCompatActivity, SettingsFragment.Companion.isTrueTvSettings(appCompatActivity2) ? R.id.global_to_navigation_results_tv : R.id.global_to_navigation_results, SettingsFragment.Companion.isTrueTvSettings(appCompatActivity2) ? ResultFragmentTV.Companion.newInstance(url, apiName, i, i2) : ResultFragmentPhimHD.Companion.newInstance(url, apiName, i, i2));
    }

    public static /* synthetic */ void loadSearchResult$default(AppUtils appUtils, Activity activity, SearchResponse searchResponse, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        appUtils.loadSearchResult(activity, searchResponse, i, num);
    }

    public final void loadSearchResult(final Activity activity, final SearchResponse card, final int i, final Integer num) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$AppUtils$1Wd-f5GFg-iaksaYAz8SUBjsUlM
                @Override // java.lang.Runnable
                public final void run() {
                    AppUtils.m8994loadSearchResult$lambda4(activity, card, i, num);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadSearchResult$lambda-4  reason: not valid java name */
    public static final void m8994loadSearchResult$lambda4(Activity activity, SearchResponse card, int i, Integer num) {
        Intrinsics.checkNotNullParameter(card, "$card");
        Activity activity2 = activity;
        UIHelper.INSTANCE.navigate(activity, SettingsFragment.Companion.isTrueTvSettings(activity2) ? R.id.global_to_navigation_results_tv : R.id.global_to_navigation_results, SettingsFragment.Companion.isTrueTvSettings(activity2) ? ResultFragmentTV.Companion.newInstance(card, i, num) : ResultFragmentPhimHD.Companion.newInstance(card, i, num));
    }

    public final void requestLocalAudioFocus(Activity activity, AudioFocusRequest audioFocusRequest) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 26 && audioFocusRequest != null) {
            Object systemService = activity.getSystemService("audio");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            ((AudioManager) systemService).requestAudioFocus(audioFocusRequest);
            return;
        }
        Object systemService2 = activity.getSystemService("audio");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        ((AudioManager) systemService2).requestAudioFocus(null, 3, 3);
    }

    public final Event<Boolean> getOnAudioFocusEvent() {
        return onAudioFocusEvent;
    }

    public final void setOnAudioFocusEvent(Event<Boolean> event) {
        Intrinsics.checkNotNullParameter(event, "<set-?>");
        onAudioFocusEvent = event;
    }

    private final AudioManager.OnAudioFocusChangeListener getAudioListener() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = currentAudioFocusChangeListener;
        if (onAudioFocusChangeListener != null) {
            return onAudioFocusChangeListener;
        }
        $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo __lambda_apputils_jqll3xbek0g6nrihno8hbrudteo = $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo.INSTANCE;
        currentAudioFocusChangeListener = __lambda_apputils_jqll3xbek0g6nrihno8hbrudteo;
        return __lambda_apputils_jqll3xbek0g6nrihno8hbrudteo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAudioListener$lambda-5  reason: not valid java name */
    public static final void m8990getAudioListener$lambda5(int i) {
        boolean z = true;
        onAudioFocusEvent.invoke(Boolean.valueOf((i == 1 || i == 2 || i == 4) ? false : false));
    }

    public final boolean isCastApiAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        boolean z = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context.getApplicationContext()) == 0;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                CastContext.getSharedInstance(applicationContext);
            }
            return z;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public final boolean isConnectedToChromecast(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return isCastApiAvailable(context) && CastContext.getSharedInstance(context).getCastState() == 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.net.Uri getUri(android.content.Context r13, android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.AppUtils.getUri(android.content.Context, android.net.Uri):android.net.Uri");
    }

    public final boolean isUsingMobileData(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network[] allNetworks = connectivityManager.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(allNetworks, "conManager.allNetworks");
        for (Network network : allNetworks) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                return true;
            }
        }
        return false;
    }

    private final void cacheClass(Activity activity, String str) {
        File cacheDir;
        if (str == null || activity == null || (cacheDir = activity.getCacheDir()) == null) {
            return;
        }
        new Cache(new File(cacheDir, FillerEpisodeCheck.INSTANCE.toClassDir(str)), 20971520L);
    }

    public final boolean isAppInstalled(Context context, String uri) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Wrappers.packageManager(context).getPackageInfo(uri, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final AudioFocusRequest getFocusRequest() {
        AudioFocusRequest audioFocusRequest;
        AudioFocusRequest audioFocusRequest2 = currentAudioFocusRequest;
        if (audioFocusRequest2 != null) {
            return audioFocusRequest2;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest.Builder builder = new AudioFocusRequest.Builder(1);
            AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
            builder2.setUsage(1);
            builder2.setContentType(3);
            builder.setAudioAttributes(builder2.build());
            builder.setAcceptsDelayedFocusGain(true);
            AudioManager.OnAudioFocusChangeListener audioListener = INSTANCE.getAudioListener();
            if (audioListener != null) {
                builder.setOnAudioFocusChangeListener(audioListener);
            }
            audioFocusRequest = builder.build();
        } else {
            audioFocusRequest = null;
        }
        currentAudioFocusRequest = audioFocusRequest;
        return audioFocusRequest;
    }

    public final /* synthetic */ <T> T tryParseJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            Intrinsics.needClassReification();
            return (T) MainAPIKt.getMapper().readValue(str, new TypeReference<T>() { // from class: com.lagradost.cloudstream3.utils.AppUtils$tryParseJson$$inlined$parseJson$1
            });
        } catch (Exception unused) {
            return null;
        }
    }
}
