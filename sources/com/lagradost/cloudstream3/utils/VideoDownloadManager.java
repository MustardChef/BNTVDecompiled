package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import androidx.preference.PreferenceManager;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.anggrayudi.storage.file.MimeType;
import com.bongngotv2.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.p043io.Closeable;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilCommonKt;

/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001:\u0018\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0002J\u0081\u0001\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010C\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010I\u001a\u0004\u0018\u00010\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020Q0P2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010TJC\u0010U\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\u0006\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010X\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u0002022\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0004H\u0002J\u0016\u0010^\u001a\u0002022\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0004J/\u0010_\u001a\u0004\u0018\u00010\u00042\u0006\u0010C\u001a\u00020D2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020Q0P¢\u0006\u0002\u0010`J\u000e\u0010a\u001a\u00020Q2\u0006\u0010C\u001a\u00020DJT\u0010b\u001a\u00020Q2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010J\u001a\u00020K2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020e0d2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020Q0PJ8\u0010f\u001a\u00020Q2\u0006\u0010C\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010J\u001a\u00020K2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dJ:\u0010g\u001a\u00020Q2\u0006\u0010C\u001a\u00020D2\u0006\u0010h\u001a\u00020(2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020Q0P2\b\b\u0002\u0010i\u001a\u000202J\u0016\u0010j\u001a\u00020Q2\u0006\u0010C\u001a\u00020D2\u0006\u0010h\u001a\u00020(JW\u0010k\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\u0006\u0010l\u001a\u00020e2\u0006\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u00042\b\u0010m\u001a\u0004\u0018\u00010\u00042\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Q0oH\u0002¢\u0006\u0002\u0010qJX\u0010r\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010l\u001a\u00020e2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020Q0P2\b\b\u0002\u0010s\u001a\u000202H\u0002J[\u0010t\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\u0006\u0010l\u001a\u00020u2\u0006\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010s\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u00042\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Q0o¢\u0006\u0002\u0010vJ\u0018\u0010w\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0002J\b\u0010x\u001a\u0004\u0018\u00010BJ\u001a\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0004H\u0002J\u0018\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0004J\u0018\u0010|\u001a\u0004\u0018\u00010(2\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0004J\u000e\u0010}\u001a\u00020,2\u0006\u0010]\u001a\u00020\u0004J\u0016\u0010~\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u007f\u001a\u00020KJ7\u0010~\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0003\u0010\u0083\u0001J7\u0010\u0084\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0085\u00010\u001f\u0018\u00010d2\u0006\u0010C\u001a\u00020D2\u0007\u0010\u0086\u0001\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u000bJ\u0013\u0010\u0087\u0001\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000bH\u0003J\u000f\u0010\u0088\u0001\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000bJ\t\u0010\u0089\u0001\u001a\u00020QH\u0002J2\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0006\u0010C\u001a\u00020D2\u0006\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010s\u001a\u000202J\u001a\u0010\u008c\u0001\u001a\u00020Q2\u0006\u0010C\u001a\u00020D2\u0007\u0010\u008d\u0001\u001a\u00020\u000bH\u0002J\r\u0010\u008e\u0001\u001a\u00020Q*\u00020DH\u0002J\u001b\u0010\u008f\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010B\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001f*\u00020DJ#\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0085\u0001*\u00030\u0091\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020\u000bH\u0003J,\u0010\u0093\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0085\u00010\u001f\u0018\u00010d*\u00030\u0091\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u000bH\u0003J \u0010\u0094\u0001\u001a\u0004\u0018\u00010$*\u00030\u0091\u00012\b\u0010\u0095\u0001\u001a\u00030\u0085\u0001H\u0007¢\u0006\u0003\u0010\u0096\u0001J\u000b\u0010\u0097\u0001\u001a\u00020\u0004*\u00020uJ\u0018\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0016*\u00020D2\u0007\u0010\u0099\u0001\u001a\u00020\u000bH\u0002J%\u0010\u009a\u0001\u001a\u0004\u0018\u00010B*\u00020B2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u000b2\t\b\u0002\u0010\u009c\u0001\u001a\u000202H\u0002J\r\u0010\u009d\u0001\u001a\u000202*\u0004\u0018\u00010BJ\u000b\u0010\u009e\u0001\u001a\u00020$*\u00020BR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 0\u001f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR)\u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R#\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u001f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006«\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager;", "", "()V", "ERROR_CONNECTION_ERROR", "", "ERROR_CONTENT_RESOLVER_NOT_FOUND", "ERROR_CREATE_FILE", "ERROR_DELETING_FILE", "ERROR_TOO_SMALL_CONNECTION", "ERROR_UNKNOWN", "KEY_DOWNLOAD_INFO", "", "KEY_RESUME_PACKAGES", "KEY_RESUME_QUEUE_PACKAGES", "SUCCESS_DOWNLOAD_DONE", "SUCCESS_STOPPED", "SUCCESS_STREAM", "USER_AGENT", "WORK_KEY_INFO", "WORK_KEY_PACKAGE", "cachedBitmaps", "Ljava/util/HashMap;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "currentDownloads", "", "downloadDeleteEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "getDownloadDeleteEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "downloadEvent", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadActionType;", "getDownloadEvent", "downloadProgressEvent", "Lkotlin/Triple;", "", "getDownloadProgressEvent", "downloadQueue", "Ljava/util/LinkedList;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;", "getDownloadQueue", "()Ljava/util/LinkedList;", "downloadStatus", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "getDownloadStatus", "()Ljava/util/HashMap;", "downloadStatusEvent", "getDownloadStatusEvent", "hasCreatedNotChanel", "", "imgDone", "imgDownloading", "imgError", "imgPaused", "imgStopped", "maxConcurrentDownloads", "getMaxConcurrentDownloads", "()I", "setMaxConcurrentDownloads", "(I)V", "pressToPauseIcon", "pressToResumeIcon", "pressToStopIcon", "reservedChars", "basePathToFile", "Lcom/hippo/unifile/UniFile;", "context", "Landroid/content/Context;", "path", "createNotification", "Landroid/app/Notification;", "source", "linkName", "ep", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", ServerProtocol.DIALOG_PARAM_STATE, "progress", "total", "notificationCallback", "Lkotlin/Function2;", "", "hlsProgress", "hlsTotal", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;JJLkotlin/jvm/functions/Function2;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "name", "folder", ShareConstants.MEDIA_EXTENSION, "parentId", "basePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/hippo/unifile/UniFile;)I", "deleteFile", "id", "deleteFileAndUpdateSettings", "downloadCheck", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)Ljava/lang/Integer;", "downloadCheckUsingWorker", "downloadEpisode", "links", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "downloadEpisodeUsingWorker", "downloadFromResume", "pkg", "setKey", "downloadFromResumeUsingWorker", "downloadHLS", "link", "startIndex", "createNotificationCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$CreateNotificationMetadata;", "(Landroid/content/Context;Lcom/lagradost/cloudstream3/utils/ExtractorLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)I", "downloadSingleEpisode", "tryResume", "downloadThing", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$IDownloadableMinimum;", "(Landroid/content/Context;Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$IDownloadableMinimum;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function1;)I", "getDisplayName", "getDownloadDir", "getDownloadFileInfo", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadedFileInfoResult;", "getDownloadFileInfoAndUpdateSettings", "getDownloadResumePackage", "getDownloadState", "getFileName", TtmlNode.TAG_METADATA, "epName", "episode", "season", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "getFolder", "Landroid/net/Uri;", "relativePath", "getRelativePath", "sanitizeFilename", "saveQueue", "setupStream", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$StreamData;", "startWork", SDKConstants.PARAM_KEY, "createNotificationChannel", "getBasePath", "getExistingDownloadUriOrNullQ", "Landroid/content/ContentResolver;", "displayName", "getExistingFolderStartName", "getFileLength", "fileUri", "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/Long;", "getId", "getImageBitmapFromUrl", "url", "gotoDir", "directoryName", "createMissingDirectories", "isDownloadDir", "size", "CreateNotificationMetadata", "DownloadActionType", "DownloadEpisodeMetadata", "DownloadInfo", "DownloadItem", "DownloadQueueResumePackage", "DownloadResumePackage", "DownloadType", "DownloadedFileInfo", "DownloadedFileInfoResult", "IDownloadableMinimum", "StreamData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class VideoDownloadManager {
    private static final int ERROR_CONNECTION_ERROR = -6;
    private static final int ERROR_CONTENT_RESOLVER_NOT_FOUND = -9;
    private static final int ERROR_CREATE_FILE = -2;
    private static final int ERROR_DELETING_FILE = 3;
    private static final int ERROR_TOO_SMALL_CONNECTION = -4;
    private static final int ERROR_UNKNOWN = -10;
    public static final String KEY_DOWNLOAD_INFO = "download_info";
    private static final String KEY_RESUME_PACKAGES = "download_resume";
    private static final String KEY_RESUME_QUEUE_PACKAGES = "download_q_resume";
    private static final int SUCCESS_DOWNLOAD_DONE = 1;
    private static final int SUCCESS_STOPPED = 2;
    private static final int SUCCESS_STREAM = 3;
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    public static final String WORK_KEY_INFO = "work_key_info";
    public static final String WORK_KEY_PACKAGE = "work_key_package";
    private static boolean hasCreatedNotChanel = false;
    public static final int imgDone = 2131231725;
    public static final int imgDownloading = 2131231727;
    public static final int imgError = 2131231726;
    public static final int imgPaused = 2131231728;
    public static final int imgStopped = 2131231726;
    public static final int pressToPauseIcon = 2131231312;
    public static final int pressToResumeIcon = 2131231314;
    public static final int pressToStopIcon = 2131231218;
    private static final String reservedChars = "|\\?*<\":>+[]/'";
    public static final VideoDownloadManager INSTANCE = new VideoDownloadManager();
    private static int maxConcurrentDownloads = 3;
    private static List<Integer> currentDownloads = new ArrayList();
    private static final HashMap<Integer, DownloadType> downloadStatus = new HashMap<>();
    private static final Event<Tuples<Integer, DownloadType>> downloadStatusEvent = new Event<>();
    private static final Event<Integer> downloadDeleteEvent = new Event<>();
    private static final Event<Tuples<Integer, DownloadActionType>> downloadEvent = new Event<>();
    private static final Event<Triple<Integer, Long, Long>> downloadProgressEvent = new Event<>();
    private static final LinkedList<DownloadResumePackage> downloadQueue = new LinkedList<>();
    private static final HashMap<String, Bitmap> cachedBitmaps = new HashMap<>();

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadActionType;", "", "(Ljava/lang/String;I)V", "Pause", "Resume", "Stop", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public enum DownloadActionType {
        Pause,
        Resume,
        Stop
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "", "(Ljava/lang/String;I)V", "IsPaused", "IsDownloading", "IsDone", "IsFailed", "IsStopped", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public enum DownloadType {
        IsPaused,
        IsDownloading,
        IsDone,
        IsFailed,
        IsStopped
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$IDownloadableMinimum;", "", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "referer", "getReferer", "()Ljava/lang/String;", "url", "getUrl", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public interface IDownloadableMinimum {
        Map<String, String> getHeaders();

        String getReferer();

        String getUrl();
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DownloadType.values().length];
            iArr[DownloadType.IsDone.ordinal()] = 1;
            iArr[DownloadType.IsDownloading.ordinal()] = 2;
            iArr[DownloadType.IsPaused.ordinal()] = 3;
            iArr[DownloadType.IsFailed.ordinal()] = 4;
            iArr[DownloadType.IsStopped.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DownloadActionType.values().length];
            iArr2[DownloadActionType.Resume.ordinal()] = 1;
            iArr2[DownloadActionType.Pause.ordinal()] = 2;
            iArr2[DownloadActionType.Stop.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private VideoDownloadManager() {
    }

    public final int getMaxConcurrentDownloads() {
        return maxConcurrentDownloads;
    }

    public final void setMaxConcurrentDownloads(int i) {
        maxConcurrentDownloads = i;
    }

    public final int getId(IDownloadableMinimum iDownloadableMinimum) {
        Intrinsics.checkNotNullParameter(iDownloadableMinimum, "<this>");
        return iDownloadableMinimum.getUrl().hashCode();
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003Jj\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "", "id", "", "mainName", "", "sourceApiName", "poster", "name", "season", "episode", "type", "Lcom/lagradost/cloudstream3/TvType;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;)V", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getMainName", "()Ljava/lang/String;", "getName", "getPoster", "getSeason", "getSourceApiName", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;)Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadEpisodeMetadata {
        private final Integer episode;

        /* renamed from: id */
        private final int f10035id;
        private final String mainName;
        private final String name;
        private final String poster;
        private final Integer season;
        private final String sourceApiName;
        private final TvType type;

        public final int component1() {
            return this.f10035id;
        }

        public final String component2() {
            return this.mainName;
        }

        public final String component3() {
            return this.sourceApiName;
        }

        public final String component4() {
            return this.poster;
        }

        public final String component5() {
            return this.name;
        }

        public final Integer component6() {
            return this.season;
        }

        public final Integer component7() {
            return this.episode;
        }

        public final TvType component8() {
            return this.type;
        }

        public final DownloadEpisodeMetadata copy(@JsonProperty("id") int i, @JsonProperty("mainName") String mainName, @JsonProperty("sourceApiName") String str, @JsonProperty("poster") String str2, @JsonProperty("name") String str3, @JsonProperty("season") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("type") TvType tvType) {
            Intrinsics.checkNotNullParameter(mainName, "mainName");
            return new DownloadEpisodeMetadata(i, mainName, str, str2, str3, num, num2, tvType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadEpisodeMetadata) {
                DownloadEpisodeMetadata downloadEpisodeMetadata = (DownloadEpisodeMetadata) obj;
                return this.f10035id == downloadEpisodeMetadata.f10035id && Intrinsics.areEqual(this.mainName, downloadEpisodeMetadata.mainName) && Intrinsics.areEqual(this.sourceApiName, downloadEpisodeMetadata.sourceApiName) && Intrinsics.areEqual(this.poster, downloadEpisodeMetadata.poster) && Intrinsics.areEqual(this.name, downloadEpisodeMetadata.name) && Intrinsics.areEqual(this.season, downloadEpisodeMetadata.season) && Intrinsics.areEqual(this.episode, downloadEpisodeMetadata.episode) && this.type == downloadEpisodeMetadata.type;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f10035id * 31) + this.mainName.hashCode()) * 31;
            String str = this.sourceApiName;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.poster;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.name;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.season;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.episode;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            TvType tvType = this.type;
            return hashCode6 + (tvType != null ? tvType.hashCode() : 0);
        }

        public String toString() {
            return "DownloadEpisodeMetadata(id=" + this.f10035id + ", mainName=" + this.mainName + ", sourceApiName=" + this.sourceApiName + ", poster=" + this.poster + ", name=" + this.name + ", season=" + this.season + ", episode=" + this.episode + ", type=" + this.type + ')';
        }

        public DownloadEpisodeMetadata(@JsonProperty("id") int i, @JsonProperty("mainName") String mainName, @JsonProperty("sourceApiName") String str, @JsonProperty("poster") String str2, @JsonProperty("name") String str3, @JsonProperty("season") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("type") TvType tvType) {
            Intrinsics.checkNotNullParameter(mainName, "mainName");
            this.f10035id = i;
            this.mainName = mainName;
            this.sourceApiName = str;
            this.poster = str2;
            this.name = str3;
            this.season = num;
            this.episode = num2;
            this.type = tvType;
        }

        public final int getId() {
            return this.f10035id;
        }

        public final String getMainName() {
            return this.mainName;
        }

        public final String getSourceApiName() {
            return this.sourceApiName;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final TvType getType() {
            return this.type;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadItem;", "", "source", "", "folder", "ep", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "links", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;Ljava/util/List;)V", "getEp", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "getFolder", "()Ljava/lang/String;", "getLinks", "()Ljava/util/List;", "getSource", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadItem {

        /* renamed from: ep */
        private final DownloadEpisodeMetadata f10037ep;
        private final String folder;
        private final List<ExtractorLink> links;
        private final String source;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DownloadItem copy$default(DownloadItem downloadItem, String str, String str2, DownloadEpisodeMetadata downloadEpisodeMetadata, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadItem.source;
            }
            if ((i & 2) != 0) {
                str2 = downloadItem.folder;
            }
            if ((i & 4) != 0) {
                downloadEpisodeMetadata = downloadItem.f10037ep;
            }
            if ((i & 8) != 0) {
                list = downloadItem.links;
            }
            return downloadItem.copy(str, str2, downloadEpisodeMetadata, list);
        }

        public final String component1() {
            return this.source;
        }

        public final String component2() {
            return this.folder;
        }

        public final DownloadEpisodeMetadata component3() {
            return this.f10037ep;
        }

        public final List<ExtractorLink> component4() {
            return this.links;
        }

        public final DownloadItem copy(@JsonProperty("source") String str, @JsonProperty("folder") String str2, @JsonProperty("ep") DownloadEpisodeMetadata ep, @JsonProperty("links") List<? extends ExtractorLink> links) {
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(links, "links");
            return new DownloadItem(str, str2, ep, links);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadItem) {
                DownloadItem downloadItem = (DownloadItem) obj;
                return Intrinsics.areEqual(this.source, downloadItem.source) && Intrinsics.areEqual(this.folder, downloadItem.folder) && Intrinsics.areEqual(this.f10037ep, downloadItem.f10037ep) && Intrinsics.areEqual(this.links, downloadItem.links);
            }
            return false;
        }

        public int hashCode() {
            String str = this.source;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.folder;
            return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f10037ep.hashCode()) * 31) + this.links.hashCode();
        }

        public String toString() {
            return "DownloadItem(source=" + this.source + ", folder=" + this.folder + ", ep=" + this.f10037ep + ", links=" + this.links + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DownloadItem(@JsonProperty("source") String str, @JsonProperty("folder") String str2, @JsonProperty("ep") DownloadEpisodeMetadata ep, @JsonProperty("links") List<? extends ExtractorLink> links) {
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(links, "links");
            this.source = str;
            this.folder = str2;
            this.f10037ep = ep;
            this.links = links;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getFolder() {
            return this.folder;
        }

        public final DownloadEpisodeMetadata getEp() {
            return this.f10037ep;
        }

        public final List<ExtractorLink> getLinks() {
            return this.links;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;", "", "item", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadItem;", "linkIndex", "", "(Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadItem;Ljava/lang/Integer;)V", "getItem", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadItem;", "getLinkIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadItem;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadResumePackage {
        private final DownloadItem item;
        private final Integer linkIndex;

        public static /* synthetic */ DownloadResumePackage copy$default(DownloadResumePackage downloadResumePackage, DownloadItem downloadItem, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                downloadItem = downloadResumePackage.item;
            }
            if ((i & 2) != 0) {
                num = downloadResumePackage.linkIndex;
            }
            return downloadResumePackage.copy(downloadItem, num);
        }

        public final DownloadItem component1() {
            return this.item;
        }

        public final Integer component2() {
            return this.linkIndex;
        }

        public final DownloadResumePackage copy(@JsonProperty("item") DownloadItem item, @JsonProperty("linkIndex") Integer num) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new DownloadResumePackage(item, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadResumePackage) {
                DownloadResumePackage downloadResumePackage = (DownloadResumePackage) obj;
                return Intrinsics.areEqual(this.item, downloadResumePackage.item) && Intrinsics.areEqual(this.linkIndex, downloadResumePackage.linkIndex);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.item.hashCode() * 31;
            Integer num = this.linkIndex;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "DownloadResumePackage(item=" + this.item + ", linkIndex=" + this.linkIndex + ')';
        }

        public DownloadResumePackage(@JsonProperty("item") DownloadItem item, @JsonProperty("linkIndex") Integer num) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            this.linkIndex = num;
        }

        public final DownloadItem getItem() {
            return this.item;
        }

        public final Integer getLinkIndex() {
            return this.linkIndex;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadedFileInfo;", "", "totalBytes", "", "relativePath", "", "displayName", "extraInfo", "basePath", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBasePath", "()Ljava/lang/String;", "getDisplayName", "getExtraInfo", "getRelativePath", "getTotalBytes", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadedFileInfo {
        private final String basePath;
        private final String displayName;
        private final String extraInfo;
        private final String relativePath;
        private final long totalBytes;

        public static /* synthetic */ DownloadedFileInfo copy$default(DownloadedFileInfo downloadedFileInfo, long j, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                j = downloadedFileInfo.totalBytes;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = downloadedFileInfo.relativePath;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = downloadedFileInfo.displayName;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = downloadedFileInfo.extraInfo;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = downloadedFileInfo.basePath;
            }
            return downloadedFileInfo.copy(j2, str5, str6, str7, str4);
        }

        public final long component1() {
            return this.totalBytes;
        }

        public final String component2() {
            return this.relativePath;
        }

        public final String component3() {
            return this.displayName;
        }

        public final String component4() {
            return this.extraInfo;
        }

        public final String component5() {
            return this.basePath;
        }

        public final DownloadedFileInfo copy(@JsonProperty("totalBytes") long j, @JsonProperty("relativePath") String relativePath, @JsonProperty("displayName") String displayName, @JsonProperty("extraInfo") String str, @JsonProperty("basePath") String str2) {
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new DownloadedFileInfo(j, relativePath, displayName, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadedFileInfo) {
                DownloadedFileInfo downloadedFileInfo = (DownloadedFileInfo) obj;
                return this.totalBytes == downloadedFileInfo.totalBytes && Intrinsics.areEqual(this.relativePath, downloadedFileInfo.relativePath) && Intrinsics.areEqual(this.displayName, downloadedFileInfo.displayName) && Intrinsics.areEqual(this.extraInfo, downloadedFileInfo.extraInfo) && Intrinsics.areEqual(this.basePath, downloadedFileInfo.basePath);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.totalBytes) * 31) + this.relativePath.hashCode()) * 31) + this.displayName.hashCode()) * 31;
            String str = this.extraInfo;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.basePath;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DownloadedFileInfo(totalBytes=" + this.totalBytes + ", relativePath=" + this.relativePath + ", displayName=" + this.displayName + ", extraInfo=" + this.extraInfo + ", basePath=" + this.basePath + ')';
        }

        public DownloadedFileInfo(@JsonProperty("totalBytes") long j, @JsonProperty("relativePath") String relativePath, @JsonProperty("displayName") String displayName, @JsonProperty("extraInfo") String str, @JsonProperty("basePath") String str2) {
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            this.totalBytes = j;
            this.relativePath = relativePath;
            this.displayName = displayName;
            this.extraInfo = str;
            this.basePath = str2;
        }

        public /* synthetic */ DownloadedFileInfo(long j, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final String getRelativePath() {
            return this.relativePath;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getExtraInfo() {
            return this.extraInfo;
        }

        public final String getBasePath() {
            return this.basePath;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadedFileInfoResult;", "", "fileLength", "", "totalBytes", "path", "Landroid/net/Uri;", "(JJLandroid/net/Uri;)V", "getFileLength", "()J", "getPath", "()Landroid/net/Uri;", "getTotalBytes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadedFileInfoResult {
        private final long fileLength;
        private final Uri path;
        private final long totalBytes;

        public static /* synthetic */ DownloadedFileInfoResult copy$default(DownloadedFileInfoResult downloadedFileInfoResult, long j, long j2, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                j = downloadedFileInfoResult.fileLength;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = downloadedFileInfoResult.totalBytes;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                uri = downloadedFileInfoResult.path;
            }
            return downloadedFileInfoResult.copy(j3, j4, uri);
        }

        public final long component1() {
            return this.fileLength;
        }

        public final long component2() {
            return this.totalBytes;
        }

        public final Uri component3() {
            return this.path;
        }

        public final DownloadedFileInfoResult copy(@JsonProperty("fileLength") long j, @JsonProperty("totalBytes") long j2, @JsonProperty("path") Uri path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new DownloadedFileInfoResult(j, j2, path);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadedFileInfoResult) {
                DownloadedFileInfoResult downloadedFileInfoResult = (DownloadedFileInfoResult) obj;
                return this.fileLength == downloadedFileInfoResult.fileLength && this.totalBytes == downloadedFileInfoResult.totalBytes && Intrinsics.areEqual(this.path, downloadedFileInfoResult.path);
            }
            return false;
        }

        public int hashCode() {
            return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.fileLength) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.totalBytes)) * 31) + this.path.hashCode();
        }

        public String toString() {
            return "DownloadedFileInfoResult(fileLength=" + this.fileLength + ", totalBytes=" + this.totalBytes + ", path=" + this.path + ')';
        }

        public DownloadedFileInfoResult(@JsonProperty("fileLength") long j, @JsonProperty("totalBytes") long j2, @JsonProperty("path") Uri path) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.fileLength = j;
            this.totalBytes = j2;
            this.path = path;
        }

        public final long getFileLength() {
            return this.fileLength;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final Uri getPath() {
            return this.path;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadQueueResumePackage;", "", FirebaseAnalytics.Param.INDEX, "", "pkg", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;", "(ILcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;)V", "getIndex", "()I", "getPkg", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadResumePackage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadQueueResumePackage {
        private final int index;
        private final DownloadResumePackage pkg;

        public static /* synthetic */ DownloadQueueResumePackage copy$default(DownloadQueueResumePackage downloadQueueResumePackage, int i, DownloadResumePackage downloadResumePackage, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = downloadQueueResumePackage.index;
            }
            if ((i2 & 2) != 0) {
                downloadResumePackage = downloadQueueResumePackage.pkg;
            }
            return downloadQueueResumePackage.copy(i, downloadResumePackage);
        }

        public final int component1() {
            return this.index;
        }

        public final DownloadResumePackage component2() {
            return this.pkg;
        }

        public final DownloadQueueResumePackage copy(@JsonProperty("index") int i, @JsonProperty("pkg") DownloadResumePackage pkg) {
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new DownloadQueueResumePackage(i, pkg);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadQueueResumePackage) {
                DownloadQueueResumePackage downloadQueueResumePackage = (DownloadQueueResumePackage) obj;
                return this.index == downloadQueueResumePackage.index && Intrinsics.areEqual(this.pkg, downloadQueueResumePackage.pkg);
            }
            return false;
        }

        public int hashCode() {
            return (this.index * 31) + this.pkg.hashCode();
        }

        public String toString() {
            return "DownloadQueueResumePackage(index=" + this.index + ", pkg=" + this.pkg + ')';
        }

        public DownloadQueueResumePackage(@JsonProperty("index") int i, @JsonProperty("pkg") DownloadResumePackage pkg) {
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            this.index = i;
            this.pkg = pkg;
        }

        public final int getIndex() {
            return this.index;
        }

        public final DownloadResumePackage getPkg() {
            return this.pkg;
        }
    }

    public final HashMap<Integer, DownloadType> getDownloadStatus() {
        return downloadStatus;
    }

    public final Event<Tuples<Integer, DownloadType>> getDownloadStatusEvent() {
        return downloadStatusEvent;
    }

    public final Event<Integer> getDownloadDeleteEvent() {
        return downloadDeleteEvent;
    }

    public final Event<Tuples<Integer, DownloadActionType>> getDownloadEvent() {
        return downloadEvent;
    }

    public final Event<Triple<Integer, Long, Long>> getDownloadProgressEvent() {
        return downloadProgressEvent;
    }

    public final LinkedList<DownloadResumePackage> getDownloadQueue() {
        return downloadQueue;
    }

    private final void createNotificationChannel(Context context) {
        hasCreatedNotChanel = true;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(VideoDownloadManagerKt.DOWNLOAD_CHANNEL_ID, VideoDownloadManagerKt.DOWNLOAD_CHANNEL_NAME, 3);
            notificationChannel.setDescription(VideoDownloadManagerKt.DOWNLOAD_CHANNEL_DESCRIPT);
            Object systemService = context.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        }
    }

    public final DownloadType getDownloadState(int i) {
        try {
            DownloadType downloadType = downloadStatus.get(Integer.valueOf(i));
            if (downloadType == null) {
                downloadType = DownloadType.IsDone;
            }
            Intrinsics.checkNotNullExpressionValue(downloadType, "{\n            downloadSt…loadType.IsDone\n        }");
            return downloadType;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return DownloadType.IsDone;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getImageBitmapFromUrl(Context context, String str) {
        try {
            HashMap<String, Bitmap> hashMap = cachedBitmaps;
            if (hashMap.containsKey(str)) {
                return hashMap.get(str);
            }
            Bitmap bitmap = GlideApp.with(context).asBitmap().load(str).into(720, 720).get();
            if (bitmap != null) {
                hashMap.put(str, bitmap);
            }
            return null;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x037c A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03cb A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x043e A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0453 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0461 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0476 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x052d A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017e A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0203 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022b A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x027f A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0297 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x030e A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0317 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0334 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:12:0x0072, B:80:0x027b, B:82:0x027f, B:87:0x0299, B:89:0x030a, B:91:0x030e, B:94:0x0313, B:96:0x0317, B:106:0x03b5, B:121:0x043a, B:123:0x043e, B:170:0x0529, B:172:0x052d, B:173:0x0530, B:125:0x0442, B:127:0x0448, B:129:0x0453, B:130:0x045d, B:132:0x0461, B:133:0x046b, B:134:0x0470, B:136:0x0476, B:147:0x04a6, B:158:0x04ed, B:164:0x04fe, B:169:0x051e, B:165:0x0506, B:166:0x050b, B:167:0x050c, B:168:0x0515, B:154:0x04e0, B:155:0x04e5, B:143:0x049b, B:144:0x04a0, B:97:0x0334, B:99:0x0338, B:100:0x0354, B:101:0x0370, B:105:0x038d, B:104:0x037c, B:88:0x02ce, B:22:0x00a1, B:33:0x00ed, B:34:0x00f2, B:39:0x0102, B:41:0x0111, B:43:0x011c, B:45:0x013d, B:47:0x0155, B:49:0x015b, B:51:0x015f, B:56:0x0178, B:58:0x017e, B:60:0x019a, B:62:0x01a0, B:64:0x01a6, B:72:0x0219, B:74:0x022b, B:76:0x0231, B:107:0x03cb, B:109:0x03cf, B:112:0x03d4, B:114:0x03d8, B:116:0x03f5, B:118:0x03f9, B:119:0x0415, B:120:0x0430, B:65:0x01da, B:67:0x01e0, B:68:0x0203, B:71:0x020f, B:55:0x0168, B:46:0x014a), top: B:177:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createNotification(android.content.Context r21, java.lang.String r22, java.lang.String r23, com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadEpisodeMetadata r24, com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadType r25, long r26, long r28, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super android.app.Notification, kotlin.Unit> r30, java.lang.Long r31, java.lang.Long r32, kotlin.coroutines.Continuation<? super android.app.Notification> r33) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.createNotification(android.content.Context, java.lang.String, java.lang.String, com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadEpisodeMetadata, com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadType, long, long, kotlin.jvm.functions.Function2, java.lang.Long, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String sanitizeFilename(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = name;
        for (int i = 0; i < 13; i++) {
            str = StringsKt.replace$default(str, reservedChars.charAt(i), ' ', false, 4, (Object) null);
        }
        return StringsKt.trim(StringsKt.replace$default(str, "  ", " ", false, 4, (Object) null), ' ');
    }

    private final List<Tuples<String, Uri>> getExistingFolderStartName(ContentResolver contentResolver, String str) {
        try {
            Cursor query = contentResolver.query(MediaStore.Downloads.getContentUri("external_primary"), new String[]{"_id", "_display_name"}, "relative_path='" + str + '\'', null, null);
            ArrayList arrayList = new ArrayList();
            Cursor cursor = query;
            Cursor cursor2 = cursor;
            if (cursor2 != null && cursor2.getCount() >= 1) {
                cursor2.moveToFirst();
                while (true) {
                    long j = cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"));
                    String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name"));
                    Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Downloads.EXTERNAL_CONTENT_URI, j);
                    Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(\n        …                        )");
                    arrayList.add(new Tuples(string, withAppendedId));
                    if (cursor2.isLast()) {
                        break;
                    }
                    cursor2.moveToNext();
                }
            }
            Unit unit = Unit.INSTANCE;
            Closeable.closeFinally(cursor, null);
            return arrayList;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return null;
        }
    }

    public final List<Tuples<String, Uri>> getFolder(Context context, String relativePath, String str) {
        UniFile[] listFiles;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        UniFile basePathToFile = basePathToFile(context, str);
        UniFile gotoDir = basePathToFile != null ? gotoDir(basePathToFile, relativePath, false) : null;
        if (Build.VERSION.SDK_INT >= 29 && isDownloadDir(basePathToFile)) {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                return getExistingFolderStartName(contentResolver, relativePath);
            }
            return null;
        }
        boolean z = true;
        if (!((gotoDir == null || !gotoDir.isDirectory()) ? false : false) || (listFiles = gotoDir.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (UniFile uniFile : listFiles) {
            String name = uniFile.getName();
            if (name == null) {
                name = "";
            }
            arrayList.add(new Tuples(name, uniFile.getUri()));
        }
        return arrayList;
    }

    private final Uri getExistingDownloadUriOrNullQ(ContentResolver contentResolver, String str, String str2) {
        try {
            Cursor query = contentResolver.query(MediaStore.Downloads.getContentUri("external_primary"), new String[]{"_id"}, "relative_path='" + str + "' AND _display_name='" + str2 + '\'', null, null);
            Cursor cursor = query;
            if (cursor != null && cursor.getCount() >= 1) {
                cursor.moveToFirst();
                Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Downloads.EXTERNAL_CONTENT_URI, cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
                Closeable.closeFinally(query, null);
                return withAppendedId;
            }
            Unit unit = Unit.INSTANCE;
            Closeable.closeFinally(query, null);
            return null;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return null;
        }
    }

    public final Long getFileLength(ContentResolver contentResolver, Uri fileUri) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(fileUri, "r");
            ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor;
            Long valueOf = Long.valueOf(parcelFileDescriptor != null ? parcelFileDescriptor.getStatSize() : 0L);
            Closeable.closeFinally(openFileDescriptor, null);
            return valueOf;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return null;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$CreateNotificationMetadata;", "", "type", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "bytesDownloaded", "", "bytesTotal", "hlsProgress", "hlsTotal", "(Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;JJLjava/lang/Long;Ljava/lang/Long;)V", "getBytesDownloaded", "()J", "getBytesTotal", "getHlsProgress", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHlsTotal", "getType", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;JJLjava/lang/Long;Ljava/lang/Long;)Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$CreateNotificationMetadata;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class CreateNotificationMetadata {
        private final long bytesDownloaded;
        private final long bytesTotal;
        private final Long hlsProgress;
        private final Long hlsTotal;
        private final DownloadType type;

        public static /* synthetic */ CreateNotificationMetadata copy$default(CreateNotificationMetadata createNotificationMetadata, DownloadType downloadType, long j, long j2, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                downloadType = createNotificationMetadata.type;
            }
            if ((i & 2) != 0) {
                j = createNotificationMetadata.bytesDownloaded;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                j2 = createNotificationMetadata.bytesTotal;
            }
            long j4 = j2;
            if ((i & 8) != 0) {
                l = createNotificationMetadata.hlsProgress;
            }
            Long l3 = l;
            if ((i & 16) != 0) {
                l2 = createNotificationMetadata.hlsTotal;
            }
            return createNotificationMetadata.copy(downloadType, j3, j4, l3, l2);
        }

        public final DownloadType component1() {
            return this.type;
        }

        public final long component2() {
            return this.bytesDownloaded;
        }

        public final long component3() {
            return this.bytesTotal;
        }

        public final Long component4() {
            return this.hlsProgress;
        }

        public final Long component5() {
            return this.hlsTotal;
        }

        public final CreateNotificationMetadata copy(DownloadType type, long j, long j2, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new CreateNotificationMetadata(type, j, j2, l, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CreateNotificationMetadata) {
                CreateNotificationMetadata createNotificationMetadata = (CreateNotificationMetadata) obj;
                return this.type == createNotificationMetadata.type && this.bytesDownloaded == createNotificationMetadata.bytesDownloaded && this.bytesTotal == createNotificationMetadata.bytesTotal && Intrinsics.areEqual(this.hlsProgress, createNotificationMetadata.hlsProgress) && Intrinsics.areEqual(this.hlsTotal, createNotificationMetadata.hlsTotal);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.type.hashCode() * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.bytesDownloaded)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.bytesTotal)) * 31;
            Long l = this.hlsProgress;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.hlsTotal;
            return hashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            return "CreateNotificationMetadata(type=" + this.type + ", bytesDownloaded=" + this.bytesDownloaded + ", bytesTotal=" + this.bytesTotal + ", hlsProgress=" + this.hlsProgress + ", hlsTotal=" + this.hlsTotal + ')';
        }

        public CreateNotificationMetadata(DownloadType type, long j, long j2, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.bytesDownloaded = j;
            this.bytesTotal = j2;
            this.hlsProgress = l;
            this.hlsTotal = l2;
        }

        public /* synthetic */ CreateNotificationMetadata(DownloadType downloadType, long j, long j2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(downloadType, j, j2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
        }

        public final DownloadType getType() {
            return this.type;
        }

        public final long getBytesDownloaded() {
            return this.bytesDownloaded;
        }

        public final long getBytesTotal() {
            return this.bytesTotal;
        }

        public final Long getHlsProgress() {
            return this.hlsProgress;
        }

        public final Long getHlsTotal() {
            return this.hlsTotal;
        }
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$StreamData;", "", "errorCode", "", "resume", "", "fileLength", "", "fileStream", "Ljava/io/OutputStream;", "(ILjava/lang/Boolean;Ljava/lang/Long;Ljava/io/OutputStream;)V", "getErrorCode", "()I", "getFileLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileStream", "()Ljava/io/OutputStream;", "getResume", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Boolean;Ljava/lang/Long;Ljava/io/OutputStream;)Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$StreamData;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class StreamData {
        private final int errorCode;
        private final Long fileLength;
        private final OutputStream fileStream;
        private final Boolean resume;

        public static /* synthetic */ StreamData copy$default(StreamData streamData, int i, Boolean bool, Long l, OutputStream outputStream, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = streamData.errorCode;
            }
            if ((i2 & 2) != 0) {
                bool = streamData.resume;
            }
            if ((i2 & 4) != 0) {
                l = streamData.fileLength;
            }
            if ((i2 & 8) != 0) {
                outputStream = streamData.fileStream;
            }
            return streamData.copy(i, bool, l, outputStream);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final Boolean component2() {
            return this.resume;
        }

        public final Long component3() {
            return this.fileLength;
        }

        public final OutputStream component4() {
            return this.fileStream;
        }

        public final StreamData copy(int i, Boolean bool, Long l, OutputStream outputStream) {
            return new StreamData(i, bool, l, outputStream);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StreamData) {
                StreamData streamData = (StreamData) obj;
                return this.errorCode == streamData.errorCode && Intrinsics.areEqual(this.resume, streamData.resume) && Intrinsics.areEqual(this.fileLength, streamData.fileLength) && Intrinsics.areEqual(this.fileStream, streamData.fileStream);
            }
            return false;
        }

        public int hashCode() {
            int i = this.errorCode * 31;
            Boolean bool = this.resume;
            int hashCode = (i + (bool == null ? 0 : bool.hashCode())) * 31;
            Long l = this.fileLength;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            OutputStream outputStream = this.fileStream;
            return hashCode2 + (outputStream != null ? outputStream.hashCode() : 0);
        }

        public String toString() {
            return "StreamData(errorCode=" + this.errorCode + ", resume=" + this.resume + ", fileLength=" + this.fileLength + ", fileStream=" + this.fileStream + ')';
        }

        public StreamData(int i, Boolean bool, Long l, OutputStream outputStream) {
            this.errorCode = i;
            this.resume = bool;
            this.fileLength = l;
            this.fileStream = outputStream;
        }

        public /* synthetic */ StreamData(int i, Boolean bool, Long l, OutputStream outputStream, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? null : outputStream);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final Boolean getResume() {
            return this.resume;
        }

        public final Long getFileLength() {
            return this.fileLength;
        }

        public final OutputStream getFileStream() {
            return this.fileStream;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.lagradost.cloudstream3.utils.VideoDownloadManager.StreamData setupStream(android.content.Context r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.setupStream(android.content.Context, java.lang.String, java.lang.String, java.lang.String, boolean):com.lagradost.cloudstream3.utils.VideoDownloadManager$StreamData");
    }

    public final int downloadThing(Context context, IDownloadableMinimum link, String name, String str, String extension, boolean z, Integer num, Function1<? super CreateNotificationMetadata, Unit> createNotificationCallback) {
        long j;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(createNotificationCallback, "createNotificationCallback");
        if (StringsKt.startsWith$default(link.getUrl(), "magnet", false, 2, (Object) null) || StringsKt.endsWith$default(link.getUrl(), ".torrent", false, 2, (Object) null)) {
            return ERROR_UNKNOWN;
        }
        Tuples<UniFile, String> basePath = getBasePath(context);
        String displayName = getDisplayName(name, extension);
        String relativePath = (Build.VERSION.SDK_INT < 29 || !isDownloadDir(basePath.getFirst())) ? str : getRelativePath(str);
        StreamData streamData = setupStream(context, name, relativePath, extension, z);
        if (streamData.getErrorCode() != 3) {
            return streamData.getErrorCode();
        }
        Boolean resume = streamData.getResume();
        Intrinsics.checkNotNull(resume);
        boolean booleanValue = resume.booleanValue();
        OutputStream fileStream = streamData.getFileStream();
        Intrinsics.checkNotNull(fileStream);
        Long fileLength = streamData.getFileLength();
        Intrinsics.checkNotNull(fileLength);
        long longValue = fileLength.longValue();
        URLConnection openConnection = new URL(StringsKt.replace$default(link.getUrl(), " ", "%20", false, 4, (Object) null)).openConnection();
        Intrinsics.checkNotNullExpressionValue(openConnection, "URL(link.url.replace(\" \", \"%20\")).openConnection()");
        openConnection.setConnectTimeout(10000);
        openConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        openConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        if (link.getReferer().length() > 0) {
            openConnection.setRequestProperty("referer", link.getReferer());
        }
        openConnection.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"91\", \" Not;A Brand\";v=\"99\"");
        openConnection.setRequestProperty("sec-ch-ua-mobile", "?0");
        openConnection.setRequestProperty("accept", MimeType.UNKNOWN);
        openConnection.setRequestProperty("sec-fetch-user", "?1");
        openConnection.setRequestProperty("sec-fetch-mode", "navigate");
        openConnection.setRequestProperty("sec-fetch-dest", "video");
        Iterator<T> it = link.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (booleanValue) {
            openConnection.setRequestProperty("Range", "bytes=" + longValue + '-');
        }
        if (!booleanValue) {
            longValue = 0;
        }
        openConnection.connect();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                j = openConnection.getContentLengthLong();
            } else {
                String headerField = openConnection.getHeaderField("content-length");
                Intrinsics.checkNotNullExpressionValue(headerField, "connection.getHeaderField(\"content-length\")");
                Long longOrNull = StringsKt.toLongOrNull(headerField);
                j = longOrNull != null ? longOrNull.longValue() : openConnection.getContentLength();
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            j = 0;
        }
        long j2 = j + longValue;
        if (!Intrinsics.areEqual(extension, "mp4") || j2 >= 5000000) {
            if (num != null) {
                AcraApplication.Companion.setKey(KEY_DOWNLOAD_INFO, String.valueOf(num.intValue()), new DownloadedFileInfo(j2, relativePath == null ? "" : relativePath, displayName, null, basePath.getSecond(), 8, null));
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            byte[] bArr = new byte[1024];
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = longValue;
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef5 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef6 = new Ref.BooleanRef();
            VideoDownloadManager$downloadThing$downloadEventListener$1 videoDownloadManager$downloadThing$downloadEventListener$1 = new VideoDownloadManager$downloadThing$downloadEventListener$1(num, booleanRef3, booleanRef4, booleanRef5, booleanRef6, createNotificationCallback, longRef, j2);
            if (num != null) {
                downloadEvent.plusAssign(videoDownloadManager$downloadThing$downloadEventListener$1);
            }
            Job main = Coroutines.INSTANCE.main(new VideoDownloadManager$downloadThing$notificationCoroutine$1(booleanRef3, booleanRef5, booleanRef4, booleanRef6, num, createNotificationCallback, longRef, j2, null));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    longRef.element += read;
                    while (booleanRef3.element) {
                        Thread.sleep(100L);
                        if (booleanRef4.element) {
                            break;
                        }
                    }
                    if (booleanRef4.element) {
                        break;
                    }
                    fileStream.write(bArr, 0, read);
                } catch (Exception e2) {
                    ArchComponentExt.logError(e2);
                    booleanRef6.element = true;
                    booleanRef = booleanRef3;
                    booleanRef2 = booleanRef6;
                    downloadThing$updateNotification(booleanRef5, booleanRef4, booleanRef6, booleanRef3, num, createNotificationCallback, longRef, j2);
                }
            }
            booleanRef2 = booleanRef6;
            booleanRef = booleanRef3;
            fileStream.close();
            bufferedInputStream.close();
            Job.DefaultImpls.cancel$default(main, (CancellationException) null, 1, (Object) null);
            if (num != null) {
                try {
                    downloadEvent.minusAssign(videoDownloadManager$downloadThing$downloadEventListener$1);
                } catch (Exception e3) {
                    ArchComponentExt.logError(e3);
                }
            }
            if (num != null) {
                try {
                    downloadStatus.remove(Integer.valueOf(num.intValue()));
                } catch (Exception unused) {
                }
            }
            if (booleanRef2.element) {
                if (num != null) {
                    downloadProgressEvent.invoke(new Triple<>(Integer.valueOf(num.intValue()), 0L, 0L));
                }
                return -6;
            } else if (booleanRef4.element) {
                if (num != null) {
                    downloadProgressEvent.invoke(new Triple<>(Integer.valueOf(num.intValue()), 0L, 0L));
                }
                return downloadThing$deleteFile(context, name, relativePath, extension, num, basePath);
            } else {
                if (num != null) {
                    downloadProgressEvent.invoke(new Triple<>(Integer.valueOf(num.intValue()), Long.valueOf(longRef.element), Long.valueOf(j2)));
                }
                booleanRef5.element = true;
                downloadThing$updateNotification(booleanRef5, booleanRef4, booleanRef2, booleanRef, num, createNotificationCallback, longRef, j2);
                return 1;
            }
        }
        return -4;
    }

    private static final int downloadThing$deleteFile(Context context, String str, String str2, String str3, Integer num, Tuples<? extends UniFile, String> tuples) {
        return INSTANCE.delete(context, str, str2, str3, num, tuples.getFirst());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadThing$updateNotification(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, Integer num, Function1<? super CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j) {
        DownloadType downloadType;
        if (booleanRef.element) {
            downloadType = DownloadType.IsDone;
        } else if (booleanRef2.element) {
            downloadType = DownloadType.IsStopped;
        } else if (booleanRef3.element) {
            downloadType = DownloadType.IsFailed;
        } else {
            downloadType = booleanRef4.element ? DownloadType.IsPaused : DownloadType.IsDownloading;
        }
        DownloadType downloadType2 = downloadType;
        if (num != null) {
            int intValue = num.intValue();
            try {
                downloadStatus.put(Integer.valueOf(intValue), downloadType2);
                downloadStatusEvent.invoke(new Tuples<>(Integer.valueOf(intValue), downloadType2));
                downloadProgressEvent.invoke(new Triple<>(Integer.valueOf(intValue), Long.valueOf(longRef.element), Long.valueOf(j)));
            } catch (Exception unused) {
            }
        }
        function1.invoke(new CreateNotificationMetadata(downloadType2, longRef.element, j, null, null, 24, null));
    }

    static /* synthetic */ UniFile gotoDir$default(VideoDownloadManager videoDownloadManager, UniFile uniFile, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return videoDownloadManager.gotoDir(uniFile, str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[Catch: Exception -> 0x00e9, TryCatch #0 {Exception -> 0x00e9, blocks: (B:3:0x0001, B:6:0x000b, B:8:0x0013, B:14:0x001f, B:16:0x0025, B:18:0x002b, B:19:0x0033, B:21:0x0039, B:23:0x004f, B:25:0x0058, B:28:0x006d, B:35:0x007b, B:36:0x0081, B:38:0x0087, B:41:0x0096, B:43:0x009f, B:51:0x00ae, B:60:0x00c1, B:65:0x00cb, B:66:0x00d3, B:68:0x00d9, B:69:0x00de, B:71:0x00e4), top: B:76:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.hippo.unifile.UniFile gotoDir(com.hippo.unifile.UniFile r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.gotoDir(com.hippo.unifile.UniFile, java.lang.String, boolean):com.hippo.unifile.UniFile");
    }

    private final String getDisplayName(String str, String str2) {
        return str + '.' + str2;
    }

    public final UniFile getDownloadDir() {
        return UniFile.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + Environment.DIRECTORY_DOWNLOADS));
    }

    @Deprecated(message = "TODO fix UniFile to work with download directory.")
    private final String getRelativePath(String str) {
        return StringsKt.replace$default(Environment.DIRECTORY_DOWNLOADS + JsonPointer.SEPARATOR + str + JsonPointer.SEPARATOR, (char) JsonPointer.SEPARATOR, File.separatorChar, false, 4, (Object) null);
    }

    private final UniFile basePathToFile(Context context, String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return getDownloadDir();
        }
        if (!StringsKt.startsWith$default(str, "content://", false, 2, (Object) null)) {
            return UniFile.fromFile(new File(str));
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
        return UniFile.fromUri(context, parse);
    }

    public final Tuples<UniFile, String> getBasePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(R.string.download_path_key), null);
        return TuplesKt.m100to(basePathToFile(context, string), string);
    }

    public final boolean isDownloadDir(UniFile uniFile) {
        if (uniFile != null) {
            String filePath = uniFile.getFilePath();
            UniFile downloadDir = getDownloadDir();
            if (Intrinsics.areEqual(filePath, downloadDir != null ? downloadDir.getFilePath() : null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
        if ((r2.length == 0) == true) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int delete(android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, com.hippo.unifile.UniFile r19) {
        /*
            r13 = this;
            r8 = r13
            r0 = r17
            r9 = r18
            r10 = r15
            r11 = r19
            java.lang.String r12 = r13.getDisplayName(r15, r0)
            java.lang.String r1 = "mp4"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L37
            java.lang.String r5 = "vtt"
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r1.delete(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L31
            java.lang.String r5 = "srt"
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r1.delete(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L31
            goto L37
        L31:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r0)
        L37:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            r7 = 0
            if (r0 < r1) goto L61
            boolean r0 = r13.isDownloadDir(r11)
            if (r0 == 0) goto L61
            r3 = r16
            java.lang.String r0 = r13.getRelativePath(r3)
            android.content.ContentResolver r1 = r14.getContentResolver()
            java.lang.String r2 = "context.contentResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.net.Uri r0 = r13.getExistingDownloadUriOrNullQ(r1, r0, r12)
            if (r0 == 0) goto Lb5
            android.content.ContentResolver r1 = r14.getContentResolver()
            r1.delete(r0, r7, r7)
            goto Lb5
        L61:
            r3 = r16
            if (r11 == 0) goto L72
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r13
            r2 = r19
            r3 = r16
            com.hippo.unifile.UniFile r0 = gotoDir$default(r1, r2, r3, r4, r5, r6)
            goto L73
        L72:
            r0 = r7
        L73:
            if (r0 == 0) goto L7a
            com.hippo.unifile.UniFile r1 = r0.findFile(r12)
            goto L7b
        L7a:
            r1 = r7
        L7b:
            if (r1 == 0) goto L85
            boolean r1 = r1.delete()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)
        L85:
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)
            if (r2 != 0) goto L92
            r0 = 3
            return r0
        L92:
            com.hippo.unifile.UniFile[] r2 = r0.listFiles()
            r3 = 0
            if (r2 == 0) goto La2
            int r2 = r2.length
            if (r2 != 0) goto L9e
            r2 = 1
            goto L9f
        L9e:
            r2 = 0
        L9f:
            if (r2 != r1) goto La2
            goto La3
        La2:
            r1 = 0
        La3:
            if (r1 == 0) goto La8
            r0.delete()
        La8:
            if (r9 == 0) goto Lb5
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            r0.intValue()
            com.lagradost.cloudstream3.utils.Event<java.lang.Integer> r0 = com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadDeleteEvent
            r0.invoke(r9)
        Lb5:
            r0 = 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.delete(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, com.hippo.unifile.UniFile):int");
    }

    private final int downloadHLS(Context context, ExtractorLink extractorLink, String str, String str2, Integer num, Integer num2, Function1<? super CreateNotificationMetadata, Unit> function1) {
        M3u8Helper m3u8Helper = new M3u8Helper();
        downloadHLS$logcatPrint("initialised the HLS downloader.");
        M3u8Helper.M3u8Stream m3u8Stream = new M3u8Helper.M3u8Stream(extractorLink.getUrl(), Integer.valueOf(extractorLink.getQuality()), MapsKt.mapOf(TuplesKt.m100to("referer", extractorLink.getReferer())));
        int intValue = num2 != null ? num2.intValue() : 0;
        Tuples<UniFile, String> basePath = getBasePath(context);
        String relativePath = (Build.VERSION.SDK_INT < 29 || !isDownloadDir(basePath.getFirst())) ? str2 : getRelativePath(str2);
        StreamData streamData = setupStream(context, str, relativePath, "mp4", intValue > 0);
        if (streamData.getErrorCode() != 3) {
            return streamData.getErrorCode();
        }
        Boolean resume = streamData.getResume();
        Intrinsics.checkNotNull(resume);
        if (!resume.booleanValue()) {
            intValue = 0;
        }
        Long fileLength = streamData.getFileLength();
        Intrinsics.checkNotNull(fileLength);
        long longValue = fileLength.longValue();
        Iterator<M3u8Helper.HlsDownloadData> hlsYield = m3u8Helper.hlsYield(CollectionsKt.listOf(m3u8Stream), intValue);
        String displayName = getDisplayName(str, "mp4");
        OutputStream fileStream = streamData.getFileStream();
        Intrinsics.checkNotNull(fileStream);
        M3u8Helper.HlsDownloadData next = hlsYield.next();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = next.getBytes().length + longValue;
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = intValue + 1;
        long totalTs = next.getTotalTs();
        Ref.BooleanRef booleanRef4 = booleanRef2;
        long j = totalTs;
        downloadHLS$updateInfo(num, longRef, totalTs, longRef2, relativePath, displayName, basePath);
        Job main = Coroutines.INSTANCE.main(new VideoDownloadManager$downloadHLS$notificationCoroutine$1(booleanRef, booleanRef4, booleanRef3, num, function1, longRef, j, longRef2, null));
        VideoDownloadManager$downloadHLS$downloadEventListener$1 videoDownloadManager$downloadHLS$downloadEventListener$1 = new VideoDownloadManager$downloadHLS$downloadEventListener$1(num, booleanRef4, booleanRef3, booleanRef, function1, longRef, j, longRef2);
        Integer downloadHLS$stopIfError = downloadHLS$stopIfError(booleanRef4, fileStream, context, str, relativePath, "mp4", num, basePath, booleanRef, booleanRef3, function1, longRef, j, longRef2, next);
        if (downloadHLS$stopIfError != null) {
            downloadHLS$closeAll(num, videoDownloadManager$downloadHLS$downloadEventListener$1, main);
            return downloadHLS$stopIfError.intValue();
        }
        if (num != null) {
            downloadEvent.plusAssign(videoDownloadManager$downloadHLS$downloadEventListener$1);
        }
        fileStream.write(next.getBytes());
        while (hlsYield.hasNext()) {
            M3u8Helper.HlsDownloadData next2 = hlsYield.next();
            while (booleanRef3.element) {
                Ref.BooleanRef booleanRef5 = booleanRef4;
                if (booleanRef5.element) {
                    downloadHLS$onFailed(fileStream, context, str, relativePath, "mp4", num, basePath, booleanRef, booleanRef5, booleanRef3, function1, longRef, j, longRef2, videoDownloadManager$downloadHLS$downloadEventListener$1, main);
                    return 2;
                }
                Thread.sleep(100L);
                booleanRef4 = booleanRef5;
            }
            Ref.BooleanRef booleanRef6 = booleanRef4;
            if (booleanRef6.element) {
                downloadHLS$onFailed(fileStream, context, str, relativePath, "mp4", num, basePath, booleanRef, booleanRef6, booleanRef3, function1, longRef, j, longRef2, videoDownloadManager$downloadHLS$downloadEventListener$1, main);
                return 2;
            }
            Integer downloadHLS$stopIfError2 = downloadHLS$stopIfError(booleanRef6, fileStream, context, str, relativePath, "mp4", num, basePath, booleanRef, booleanRef3, function1, longRef, j, longRef2, next2);
            if (downloadHLS$stopIfError2 != null) {
                downloadHLS$closeAll(num, videoDownloadManager$downloadHLS$downloadEventListener$1, main);
                return downloadHLS$stopIfError2.intValue();
            }
            fileStream.write(next2.getBytes());
            longRef2.element = next2.getCurrentIndex();
            longRef.element += next2.getBytes().length;
            StringBuilder sb = new StringBuilder();
            sb.append("Download progress ");
            long j2 = j;
            sb.append(MathKt.roundToInt((((float) longRef2.element) / ((float) j2)) * 100));
            sb.append('%');
            downloadHLS$logcatPrint(sb.toString());
            downloadHLS$updateInfo(num, longRef, j2, longRef2, relativePath, displayName, basePath);
            j = j2;
            booleanRef4 = booleanRef6;
        }
        long j3 = j;
        booleanRef.element = true;
        fileStream.close();
        m9025downloadHLS$updateNotification22(booleanRef, booleanRef4, booleanRef3, num, function1, longRef, j3, longRef2);
        downloadHLS$closeAll(num, videoDownloadManager$downloadHLS$downloadEventListener$1, main);
        downloadHLS$updateInfo(num, longRef, j3, longRef2, relativePath, displayName, basePath);
        return 1;
    }

    /* renamed from: downloadHLS$deleteFile-19  reason: not valid java name */
    private static final int m9024downloadHLS$deleteFile19(Context context, String str, String str2, String str3, Integer num, Tuples<? extends UniFile, String> tuples) {
        return INSTANCE.delete(context, str, str2, str3, num, tuples.getFirst());
    }

    private static final void downloadHLS$updateInfo(Integer num, Ref.LongRef longRef, long j, Ref.LongRef longRef2, String str, String str2, Tuples<? extends UniFile, String> tuples) {
        if (num != null) {
            AcraApplication.Companion.setKey(KEY_DOWNLOAD_INFO, String.valueOf(num.intValue()), new DownloadedFileInfo(((float) longRef.element) * (((float) j) / ((float) longRef2.element)), str == null ? "" : str, str2, String.valueOf(longRef2.element), tuples.getSecond()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadHLS$updateNotification-22  reason: not valid java name */
    public static final void m9025downloadHLS$updateNotification22(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Integer num, Function1<? super CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j, Ref.LongRef longRef2) {
        DownloadType downloadType;
        if (booleanRef.element) {
            downloadType = DownloadType.IsDone;
        } else if (booleanRef2.element) {
            downloadType = DownloadType.IsFailed;
        } else {
            downloadType = booleanRef3.element ? DownloadType.IsPaused : DownloadType.IsDownloading;
        }
        DownloadType downloadType2 = downloadType;
        if (num != null) {
            int intValue = num.intValue();
            try {
                downloadStatus.put(Integer.valueOf(intValue), downloadType2);
                downloadStatusEvent.invoke(new Tuples<>(Integer.valueOf(intValue), downloadType2));
                downloadProgressEvent.invoke(new Triple<>(Integer.valueOf(intValue), Long.valueOf(longRef.element), Long.valueOf(((float) longRef.element) * (((float) j) / ((float) longRef2.element)))));
            } catch (Exception unused) {
            }
        }
        function1.invoke(new CreateNotificationMetadata(downloadType2, longRef.element, ((float) longRef.element) * (((float) j) / ((float) longRef2.element)), Long.valueOf(longRef2.element), Long.valueOf(j)));
    }

    private static final Integer downloadHLS$stopIfError(Ref.BooleanRef booleanRef, OutputStream outputStream, Context context, String str, String str2, String str3, Integer num, Tuples<? extends UniFile, String> tuples, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Function1<? super CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j, Ref.LongRef longRef2, M3u8Helper.HlsDownloadData hlsDownloadData) {
        int i;
        if (!hlsDownloadData.getErrored()) {
            if (!(hlsDownloadData.getBytes().length == 0)) {
                return null;
            }
        }
        if (!hlsDownloadData.getErrored()) {
            downloadHLS$logcatPrint("Error: No stream was found.");
            i = ERROR_UNKNOWN;
        } else {
            downloadHLS$logcatPrint("Error: Failed to fetch data.");
            i = -6;
        }
        booleanRef.element = true;
        outputStream.close();
        m9024downloadHLS$deleteFile19(context, str, str2, str3, num, tuples);
        m9025downloadHLS$updateNotification22(booleanRef2, booleanRef, booleanRef3, num, function1, longRef, j, longRef2);
        return Integer.valueOf(i);
    }

    private static final void downloadHLS$closeAll(Integer num, Function1<? super Tuples<Integer, ? extends DownloadActionType>, Unit> function1, Job job) {
        if (num != null) {
            try {
                downloadEvent.minusAssign(function1);
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }
        if (num != null) {
            try {
                downloadStatus.remove(Integer.valueOf(num.intValue()));
            } catch (Exception e2) {
                ArchComponentExt.logError(e2);
            }
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }

    private static final void downloadHLS$onFailed(OutputStream outputStream, Context context, String str, String str2, String str3, Integer num, Tuples<? extends UniFile, String> tuples, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Function1<? super CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j, Ref.LongRef longRef2, Function1<? super Tuples<Integer, ? extends DownloadActionType>, Unit> function12, Job job) {
        outputStream.close();
        m9024downloadHLS$deleteFile19(context, str, str2, str3, num, tuples);
        m9025downloadHLS$updateNotification22(booleanRef, booleanRef2, booleanRef3, num, function1, longRef, j, longRef2);
        downloadHLS$closeAll(num, function12, job);
    }

    public final String getFileName(Context context, DownloadEpisodeMetadata metadata) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return getFileName(context, metadata.getName(), metadata.getEpisode(), metadata.getSeason());
    }

    private final String getFileName(Context context, String str, Integer num, Integer num2) {
        if (str == null) {
            if (num2 != null) {
                str = context.getString(R.string.season) + ' ' + num2 + ' ' + context.getString(R.string.episode) + ' ' + num;
            } else {
                str = context.getString(R.string.episode) + ' ' + num;
            }
        } else if (num != null) {
            if (num2 != null) {
                str = context.getString(R.string.season) + ' ' + num2 + ' ' + context.getString(R.string.episode) + ' ' + num + " - " + str;
            } else {
                str = context.getString(R.string.episode) + ' ' + num + " - " + str;
            }
        }
        return sanitizeFilename(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int downloadSingleEpisode(android.content.Context r18, java.lang.String r19, java.lang.String r20, com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadEpisodeMetadata r21, com.lagradost.cloudstream3.utils.ExtractorLink r22, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super android.app.Notification, kotlin.Unit> r23, boolean r24) {
        /*
            r17 = this;
            r6 = r18
            r9 = r17
            r7 = r21
            java.lang.String r8 = r9.getFileName(r6, r7)
            com.lagradost.cloudstream3.utils.Coroutines r0 = com.lagradost.cloudstream3.utils.Coroutines.INSTANCE
            com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$extractorJob$1 r1 = new com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$extractorJob$1
            r10 = 0
            r11 = r22
            r1.<init>(r11, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlinx.coroutines.Job r12 = r0.ioSafe(r1)
            boolean r0 = r22.isM3u8()
            r13 = 1
            if (r0 != 0) goto L68
            java.net.URI r0 = new java.net.URI
            java.lang.String r1 = r22.getUrl()
            r0.<init>(r1)
            java.lang.String r0 = r0.getPath()
            java.lang.String r1 = "URI(link.url).path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r2 = 2
            java.lang.String r3 = ".m3u8"
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r0, r3, r1, r2, r10)
            if (r0 == 0) goto L3e
            goto L68
        L3e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$3 r14 = new com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$3
            r0 = r14
            r1 = r18
            r2 = r22
            r3 = r8
            r4 = r20
            r5 = r24
            r6 = r21
            r7 = r19
            r8 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Functions) r14
            java.lang.Object r0 = com.lagradost.cloudstream3.mvvm.ArchComponentExt.normalSafeApiCall(r14)
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r12, r10, r13, r10)
            if (r0 == 0) goto L65
            int r0 = r0.intValue()
            goto L67
        L65:
            r0 = -10
        L67:
            return r0
        L68:
            if (r24 == 0) goto Lae
            com.lagradost.cloudstream3.utils.DataStore r0 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            int r1 = r21.getId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "download_info"
            java.lang.String r1 = r0.getFolderName(r2, r1)
            android.content.SharedPreferences r2 = r0.getSharedPrefs(r6)     // Catch: java.lang.Exception -> L9a
            java.lang.String r1 = r2.getString(r1, r10)     // Catch: java.lang.Exception -> L9a
            if (r1 != 0) goto L85
            goto L9a
        L85:
            java.lang.String r2 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> L9a
            com.fasterxml.jackson.databind.json.JsonMapper r0 = r0.getMapper()     // Catch: java.lang.Exception -> L9a
            java.lang.Class<com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo> r2 = com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo.class
            java.lang.Object r0 = r0.readValue(r1, r2)     // Catch: java.lang.Exception -> L9a
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L9a
            goto L9b
        L9a:
            r0 = r10
        L9b:
            if (r0 != 0) goto L9e
            r0 = r10
        L9e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo r0 = (com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo) r0
            if (r0 == 0) goto Lae
            java.lang.String r0 = r0.getExtraInfo()
            if (r0 == 0) goto Lae
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            r14 = r0
            goto Laf
        Lae:
            r14 = r10
        Laf:
            int r0 = r21.getId()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r0)
            com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$1 r16 = new com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$1
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r22
            r4 = r21
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r7 = r16
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0 = r17
            r2 = r22
            r3 = r8
            r4 = r20
            r5 = r15
            r6 = r14
            int r0 = r0.downloadHLS(r1, r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r12, r10, r13, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadSingleEpisode(android.content.Context, java.lang.String, java.lang.String, com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadEpisodeMetadata, com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.jvm.functions.Function2, boolean):int");
    }

    public final Integer downloadCheck(Context context, Function2<? super Integer, ? super Notification, Unit> notificationCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationCallback, "notificationCallback");
        if (currentDownloads.size() < maxConcurrentDownloads) {
            LinkedList<DownloadResumePackage> linkedList = downloadQueue;
            if (linkedList.size() > 0) {
                DownloadResumePackage removeFirst = linkedList.removeFirst();
                DownloadItem item = removeFirst.getItem();
                int id = item.getEp().getId();
                if (currentDownloads.contains(Integer.valueOf(id))) {
                    downloadEvent.invoke(new Tuples<>(Integer.valueOf(id), DownloadActionType.Resume));
                    return Integer.valueOf(id);
                }
                currentDownloads.add(Integer.valueOf(id));
                Coroutines.INSTANCE.main(new VideoDownloadManager$downloadCheck$1(removeFirst, item, id, context, notificationCallback, null));
                return null;
            }
            return null;
        }
        return null;
    }

    public final DownloadedFileInfoResult getDownloadFileInfoAndUpdateSettings(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        DownloadedFileInfoResult downloadFileInfo = getDownloadFileInfo(context, i);
        if (downloadFileInfo == null) {
            DataStore.INSTANCE.removeKey(context, KEY_DOWNLOAD_INFO, String.valueOf(i));
        }
        return downloadFileInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[Catch: Exception -> 0x00b6, TryCatch #1 {Exception -> 0x00b6, blocks: (B:3:0x0001, B:10:0x002e, B:13:0x0033, B:15:0x0041, B:17:0x0047, B:20:0x004e, B:23:0x005d, B:25:0x0063, B:28:0x006e, B:33:0x007d, B:35:0x0087, B:39:0x0094, B:44:0x009e), top: B:52:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfoResult getDownloadFileInfo(android.content.Context r10, int r11) {
        /*
            r9 = this;
            r0 = 0
            com.lagradost.cloudstream3.utils.DataStore r1 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE     // Catch: java.lang.Exception -> Lb6
            java.lang.String r2 = "download_info"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Exception -> Lb6
            java.lang.String r11 = r1.getFolderName(r2, r11)     // Catch: java.lang.Exception -> Lb6
            android.content.SharedPreferences r2 = r1.getSharedPrefs(r10)     // Catch: java.lang.Exception -> L2d
            java.lang.String r11 = r2.getString(r11, r0)     // Catch: java.lang.Exception -> L2d
            if (r11 != 0) goto L18
            goto L2d
        L18:
            java.lang.String r2 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch: java.lang.Exception -> L2d
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r1.getMapper()     // Catch: java.lang.Exception -> L2d
            java.lang.Class<com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo> r2 = com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo.class
            java.lang.Object r11 = r1.readValue(r11, r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2d:
            r11 = r0
        L2e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo r11 = (com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo) r11     // Catch: java.lang.Exception -> Lb6
            if (r11 != 0) goto L33
            return r0
        L33:
            java.lang.String r1 = r11.getBasePath()     // Catch: java.lang.Exception -> Lb6
            com.hippo.unifile.UniFile r1 = r9.basePathToFile(r10, r1)     // Catch: java.lang.Exception -> Lb6
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb6
            r3 = 29
            if (r2 < r3) goto L7a
            boolean r2 = r9.isDownloadDir(r1)     // Catch: java.lang.Exception -> Lb6
            if (r2 == 0) goto L7a
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Exception -> Lb6
            if (r10 != 0) goto L4e
            return r0
        L4e:
            java.lang.String r1 = r11.getRelativePath()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r2 = r11.getDisplayName()     // Catch: java.lang.Exception -> Lb6
            android.net.Uri r8 = r9.getExistingDownloadUriOrNullQ(r10, r1, r2)     // Catch: java.lang.Exception -> Lb6
            if (r8 != 0) goto L5d
            return r0
        L5d:
            java.lang.Long r10 = r9.getFileLength(r10, r8)     // Catch: java.lang.Exception -> Lb6
            if (r10 == 0) goto L79
            long r4 = r10.longValue()     // Catch: java.lang.Exception -> Lb6
            r1 = 0
            int r10 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r10 != 0) goto L6e
            return r0
        L6e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfoResult r10 = new com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfoResult     // Catch: java.lang.Exception -> Lb6
            long r6 = r11.getTotalBytes()     // Catch: java.lang.Exception -> Lb6
            r3 = r10
            r3.<init>(r4, r6, r8)     // Catch: java.lang.Exception -> Lb6
            return r10
        L79:
            return r0
        L7a:
            r10 = 0
            if (r1 == 0) goto L90
            java.lang.String r2 = r11.getRelativePath()     // Catch: java.lang.Exception -> Lb6
            com.hippo.unifile.UniFile r1 = r9.gotoDir(r1, r2, r10)     // Catch: java.lang.Exception -> Lb6
            if (r1 == 0) goto L90
            java.lang.String r2 = r11.getDisplayName()     // Catch: java.lang.Exception -> Lb6
            com.hippo.unifile.UniFile r1 = r1.findFile(r2)     // Catch: java.lang.Exception -> Lb6
            goto L91
        L90:
            r1 = r0
        L91:
            r2 = 1
            if (r1 == 0) goto L9b
            boolean r3 = r1.exists()     // Catch: java.lang.Exception -> Lb6
            if (r3 != r2) goto L9b
            r10 = 1
        L9b:
            if (r10 != 0) goto L9e
            return r0
        L9e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfoResult r10 = new com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfoResult     // Catch: java.lang.Exception -> Lb6
            long r3 = r9.size(r1)     // Catch: java.lang.Exception -> Lb6
            long r5 = r11.getTotalBytes()     // Catch: java.lang.Exception -> Lb6
            android.net.Uri r7 = r1.getUri()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r11 = "file.uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r11)     // Catch: java.lang.Exception -> Lb6
            r2 = r10
            r2.<init>(r3, r5, r7)     // Catch: java.lang.Exception -> Lb6
            return r10
        Lb6:
            r10 = move-exception
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.getDownloadFileInfo(android.content.Context, int):com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfoResult");
    }

    public final long size(UniFile uniFile) {
        Intrinsics.checkNotNullParameter(uniFile, "<this>");
        long length = uniFile.length();
        if (length <= 1) {
            InputStream openInputStream = uniFile.openInputStream();
            Intrinsics.checkNotNullExpressionValue(openInputStream, "this.openInputStream()");
            long available = openInputStream.available();
            _UtilCommonKt.closeQuietly(openInputStream);
            return available;
        }
        return length;
    }

    public final boolean deleteFileAndUpdateSettings(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean deleteFile = deleteFile(context, i);
        if (deleteFile) {
            DataStore.INSTANCE.removeKey(context, KEY_DOWNLOAD_INFO, String.valueOf(i));
        }
        return deleteFile;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean deleteFile(android.content.Context r11, int r12) {
        /*
            r10 = this;
            com.lagradost.cloudstream3.utils.DataStore r0 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r2 = "download_info"
            java.lang.String r1 = r0.getFolderName(r2, r1)
            r2 = 0
            android.content.SharedPreferences r3 = r0.getSharedPrefs(r11)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r3.getString(r1, r2)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L18
            goto L2d
        L18:
            java.lang.String r3 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch: java.lang.Exception -> L2d
            com.fasterxml.jackson.databind.json.JsonMapper r0 = r0.getMapper()     // Catch: java.lang.Exception -> L2d
            java.lang.Class<com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo> r3 = com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo.class
            java.lang.Object r0 = r0.readValue(r1, r3)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2d:
            r0 = r2
        L2e:
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadedFileInfo r0 = (com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadedFileInfo) r0
            r1 = 0
            if (r0 != 0) goto L34
            return r1
        L34:
            com.lagradost.cloudstream3.utils.Event<kotlin.Pair<java.lang.Integer, com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadActionType>> r3 = com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadEvent
            kotlin.Pair r4 = new kotlin.Pair
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadActionType r6 = com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadActionType.Stop
            r4.<init>(r5, r6)
            r3.invoke(r4)
            com.lagradost.cloudstream3.utils.Event<kotlin.Triple<java.lang.Integer, java.lang.Long, java.lang.Long>> r3 = com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadProgressEvent
            kotlin.Triple r4 = new kotlin.Triple
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r6 = 0
            java.lang.Long r8 = java.lang.Long.valueOf(r6)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r4.<init>(r5, r8, r6)
            r3.invoke(r4)
            com.lagradost.cloudstream3.utils.Event<kotlin.Pair<java.lang.Integer, com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadType>> r3 = com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadStatusEvent
            kotlin.Pair r4 = new kotlin.Pair
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadType r6 = com.lagradost.cloudstream3.utils.VideoDownloadManager.DownloadType.IsStopped
            r4.<init>(r5, r6)
            r3.invoke(r4)
            com.lagradost.cloudstream3.utils.Event<java.lang.Integer> r3 = com.lagradost.cloudstream3.utils.VideoDownloadManager.downloadDeleteEvent
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r3.invoke(r12)
            java.lang.String r12 = r0.getBasePath()
            com.hippo.unifile.UniFile r4 = r10.basePathToFile(r11, r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            r9 = 1
            if (r12 < r3) goto La8
            boolean r12 = r10.isDownloadDir(r4)
            if (r12 == 0) goto La8
            android.content.ContentResolver r11 = r11.getContentResolver()
            if (r11 != 0) goto L91
            return r1
        L91:
            java.lang.String r12 = r0.getRelativePath()
            java.lang.String r0 = r0.getDisplayName()
            android.net.Uri r12 = r10.getExistingDownloadUriOrNullQ(r11, r12, r0)
            if (r12 != 0) goto La0
            return r9
        La0:
            int r11 = r11.delete(r12, r2, r2)
            if (r11 <= 0) goto La7
            r1 = 1
        La7:
            return r1
        La8:
            if (r4 == 0) goto Lc1
            java.lang.String r5 = r0.getRelativePath()
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r10
            com.hippo.unifile.UniFile r12 = gotoDir$default(r3, r4, r5, r6, r7, r8)
            if (r12 == 0) goto Lc1
            java.lang.String r0 = r0.getDisplayName()
            com.hippo.unifile.UniFile r12 = r12.findFile(r0)
            goto Lc2
        Lc1:
            r12 = r2
        Lc2:
            if (r12 == 0) goto Lcc
            boolean r0 = r12.exists()
            if (r0 != r9) goto Lcc
            r0 = 1
            goto Lcd
        Lcc:
            r0 = 0
        Lcd:
            if (r0 != 0) goto Ld0
            return r9
        Ld0:
            boolean r11 = r12.delete()     // Catch: java.lang.Exception -> Ld5
            goto Leb
        Ld5:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r0)
            android.content.ContentResolver r11 = r11.getContentResolver()
            android.net.Uri r12 = r12.getUri()
            int r11 = r11.delete(r12, r2, r2)
            if (r11 <= 0) goto Lea
            r1 = 1
        Lea:
            r11 = r1
        Leb:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager.deleteFile(android.content.Context, int):boolean");
    }

    public final DownloadResumePackage getDownloadResumePackage(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataStore dataStore = DataStore.INSTANCE;
        Object obj = null;
        try {
            String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(KEY_RESUME_PACKAGES, String.valueOf(i)), null);
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                Object readValue = dataStore.getMapper().readValue(string, DownloadResumePackage.class);
                Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                obj = readValue;
            }
        } catch (Exception unused) {
        }
        return (DownloadResumePackage) obj;
    }

    public static /* synthetic */ void downloadFromResume$default(VideoDownloadManager videoDownloadManager, Context context, DownloadResumePackage downloadResumePackage, Function2 function2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        videoDownloadManager.downloadFromResume(context, downloadResumePackage, function2, z);
    }

    public final void downloadFromResume(Context context, DownloadResumePackage pkg, Function2<? super Integer, ? super Notification, Unit> notificationCallback, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(notificationCallback, "notificationCallback");
        List<Integer> list = currentDownloads;
        boolean z3 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                if (number.intValue() == pkg.getItem().getEp().getId()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
        }
        z3 = false;
        if (!z3) {
            downloadQueue.addLast(pkg);
            downloadCheck(context, notificationCallback);
            if (z) {
                saveQueue();
                return;
            }
            return;
        }
        downloadEvent.invoke(new Tuples<>(Integer.valueOf(pkg.getItem().getEp().getId()), DownloadActionType.Resume));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveQueue() {
        List list = CollectionsKt.toList(downloadQueue);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new DownloadQueueResumePackage(i, (DownloadResumePackage) obj));
            i = i2;
        }
        Object[] array = arrayList.toArray(new DownloadQueueResumePackage[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        AcraApplication.Companion.setKey(KEY_RESUME_QUEUE_PACKAGES, (DownloadQueueResumePackage[]) array);
    }

    public final void downloadEpisode(Context context, String str, String str2, DownloadEpisodeMetadata ep, List<? extends ExtractorLink> links, Function2<? super Integer, ? super Notification, Unit> notificationCallback) {
        Intrinsics.checkNotNullParameter(ep, "ep");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(notificationCallback, "notificationCallback");
        if (context != null && (!links.isEmpty())) {
            downloadFromResume$default(this, context, new DownloadResumePackage(new DownloadItem(str, str2, ep, links), null), notificationCallback, false, 8, null);
        }
    }

    private final void startWork(Context context, String str) {
        OneTimeWorkRequest build = new OneTimeWorkRequest.Builder(DownloadFileWorkManager.class).setInputData(new Data.Builder().putString(SDKConstants.PARAM_KEY, str).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(DownloadFileWork…   )\n            .build()");
        WorkManager.getInstance(context).enqueueUniqueWork(str, ExistingWorkPolicy.KEEP, build);
    }

    public final void downloadCheckUsingWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        startWork(context, DownloadFileWorkManagerKt.DOWNLOAD_CHECK);
    }

    public final void downloadFromResumeUsingWorker(Context context, DownloadResumePackage pkg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        String valueOf = String.valueOf(pkg.getItem().getEp().getId());
        AcraApplication.Companion.setKey(WORK_KEY_PACKAGE, valueOf, pkg);
        startWork(context, valueOf);
    }

    public final void downloadEpisodeUsingWorker(Context context, String str, String str2, DownloadEpisodeMetadata ep, List<? extends ExtractorLink> links) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ep, "ep");
        Intrinsics.checkNotNullParameter(links, "links");
        DownloadInfo downloadInfo = new DownloadInfo(str, str2, ep, links);
        String valueOf = String.valueOf(downloadInfo.getEp().getId());
        AcraApplication.Companion.setKey(WORK_KEY_INFO, valueOf, downloadInfo);
        startWork(context, valueOf);
    }

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadInfo;", "", "source", "", "folder", "ep", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "links", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;Ljava/util/List;)V", "getEp", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "getFolder", "()Ljava/lang/String;", "getLinks", "()Ljava/util/List;", "getSource", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadInfo {

        /* renamed from: ep */
        private final DownloadEpisodeMetadata f10036ep;
        private final String folder;
        private final List<ExtractorLink> links;
        private final String source;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DownloadInfo copy$default(DownloadInfo downloadInfo, String str, String str2, DownloadEpisodeMetadata downloadEpisodeMetadata, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadInfo.source;
            }
            if ((i & 2) != 0) {
                str2 = downloadInfo.folder;
            }
            if ((i & 4) != 0) {
                downloadEpisodeMetadata = downloadInfo.f10036ep;
            }
            if ((i & 8) != 0) {
                list = downloadInfo.links;
            }
            return downloadInfo.copy(str, str2, downloadEpisodeMetadata, list);
        }

        public final String component1() {
            return this.source;
        }

        public final String component2() {
            return this.folder;
        }

        public final DownloadEpisodeMetadata component3() {
            return this.f10036ep;
        }

        public final List<ExtractorLink> component4() {
            return this.links;
        }

        public final DownloadInfo copy(@JsonProperty("source") String str, @JsonProperty("folder") String str2, @JsonProperty("ep") DownloadEpisodeMetadata ep, @JsonProperty("links") List<? extends ExtractorLink> links) {
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(links, "links");
            return new DownloadInfo(str, str2, ep, links);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadInfo) {
                DownloadInfo downloadInfo = (DownloadInfo) obj;
                return Intrinsics.areEqual(this.source, downloadInfo.source) && Intrinsics.areEqual(this.folder, downloadInfo.folder) && Intrinsics.areEqual(this.f10036ep, downloadInfo.f10036ep) && Intrinsics.areEqual(this.links, downloadInfo.links);
            }
            return false;
        }

        public int hashCode() {
            String str = this.source;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.folder;
            return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f10036ep.hashCode()) * 31) + this.links.hashCode();
        }

        public String toString() {
            return "DownloadInfo(source=" + this.source + ", folder=" + this.folder + ", ep=" + this.f10036ep + ", links=" + this.links + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DownloadInfo(@JsonProperty("source") String str, @JsonProperty("folder") String str2, @JsonProperty("ep") DownloadEpisodeMetadata ep, @JsonProperty("links") List<? extends ExtractorLink> links) {
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(links, "links");
            this.source = str;
            this.folder = str2;
            this.f10036ep = ep;
            this.links = links;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getFolder() {
            return this.folder;
        }

        public final DownloadEpisodeMetadata getEp() {
            return this.f10036ep;
        }

        public final List<ExtractorLink> getLinks() {
            return this.links;
        }
    }

    private static final void downloadHLS$logcatPrint(Object... objArr) {
        for (Object obj : objArr) {
            System.out.println((Object) ("[HLS]: " + obj));
        }
    }
}
