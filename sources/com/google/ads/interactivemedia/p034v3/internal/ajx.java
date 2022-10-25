package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2483ba;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh;
import com.google.ads.interactivemedia.p034v3.impl.data.C2476au;
import com.google.ads.interactivemedia.p034v3.impl.data.C2496bn;
import com.google.ads.interactivemedia.p034v3.impl.data.C2509c;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajx */
/* loaded from: classes2.dex */
public final class ajx implements akb, akc {

    /* renamed from: g */
    private final Context f4262g;

    /* renamed from: h */
    private final String f4263h;

    /* renamed from: i */
    private final akd f4264i;

    /* renamed from: k */
    private final float f4266k;

    /* renamed from: l */
    private final ExecutorService f4267l;

    /* renamed from: m */
    private final TestingConfiguration f4268m;

    /* renamed from: n */
    private final TaskCompletionSource f4269n;

    /* renamed from: o */
    private final TaskCompletionSource f4270o;

    /* renamed from: p */
    private akk f4271p;

    /* renamed from: q */
    private ajw f4272q;

    /* renamed from: r */
    private long f4273r;

    /* renamed from: s */
    private boolean f4274s;

    /* renamed from: a */
    private final Map f4256a = new HashMap();

    /* renamed from: b */
    private final Set f4257b = new HashSet();

    /* renamed from: c */
    private final Map f4258c = new HashMap();

    /* renamed from: d */
    private final Map f4259d = new HashMap();

    /* renamed from: e */
    private final Map f4260e = new HashMap();

    /* renamed from: f */
    private final Map f4261f = new HashMap();

    /* renamed from: j */
    private final Queue f4265j = new ConcurrentLinkedQueue();

    public ajx(akd akdVar, Context context, Uri uri, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4269n = taskCompletionSource;
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.f4270o = taskCompletionSource2;
        this.f4274s = false;
        this.f4262g = context;
        this.f4266k = context.getResources().getDisplayMetrics().density;
        Uri.Builder appendQueryParameter = uri.buildUpon().appendQueryParameter("sdk_version", "a.3.25.1").appendQueryParameter("hl", imaSdkSettings.getLanguage()).appendQueryParameter("omv", agd.m5370a()).appendQueryParameter("app", context.getApplicationContext().getPackageName());
        if (testingConfiguration != null) {
            bgi bgiVar = new bgi();
            bgiVar.m3716c(new atf());
            bgiVar.m3715d(new C2476au());
            appendQueryParameter.appendQueryParameter(TestingConfiguration.PARAMETER_KEY, bgiVar.m3718a().m3722g(testingConfiguration));
        }
        this.f4263h = appendQueryParameter.build().toString();
        this.f4268m = testingConfiguration;
        this.f4264i = akdVar;
        akdVar.m5115g(this);
        this.f4267l = executorService;
        Tasks.whenAllComplete(taskCompletionSource2.getTask(), taskCompletionSource.getTask()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.internal.ajr
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ajx.this.m5131p();
            }
        });
    }

    /* renamed from: q */
    private static String m5130q(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + str2.length());
        sb.append(str);
        sb.append(" Caused by: ");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: r */
    private final void m5129r(ajo ajoVar, ajp ajpVar, String str, C2496bn c2496bn) {
        akv akvVar = (akv) this.f4261f.get(str);
        if (akvVar == null) {
            String valueOf = String.valueOf(ajoVar);
            String valueOf2 = String.valueOf(ajpVar);
            int length = String.valueOf(valueOf).length();
            StringBuilder sb = new StringBuilder(length + 44 + String.valueOf(valueOf2).length() + String.valueOf(str).length());
            sb.append("Received ");
            sb.append(valueOf);
            sb.append(" message: ");
            sb.append(valueOf2);
            sb.append(" for invalid session id: ");
            sb.append(str);
            C2525p.m5988d(sb.toString());
            return;
        }
        akvVar.mo5065f(ajoVar, ajpVar, c2496bn);
    }

    /* renamed from: s */
    private static final void m5128s(String str, ajp ajpVar) {
        String valueOf = String.valueOf(ajpVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43 + String.valueOf(str).length());
        sb.append("Illegal message type ");
        sb.append(valueOf);
        sb.append(" received for ");
        sb.append(str);
        sb.append(" channel");
        C2525p.m5989c(sb.toString());
    }

    /* renamed from: a */
    public final WebView m5144a() {
        return this.f4264i.m5121a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final TestingConfiguration m5143b() {
        return this.f4268m;
    }

    /* renamed from: c */
    public final Task m5142c() {
        this.f4273r = SystemClock.elapsedRealtime();
        this.f4264i.m5117e(this.f4263h);
        return this.f4270o.getTask();
    }

    /* renamed from: d */
    public final void m5141d(ajs ajsVar, String str) {
        this.f4256a.put(str, ajsVar);
    }

    /* renamed from: e */
    public final void m5140e(BaseDisplayContainer baseDisplayContainer, String str) {
        this.f4258c.put(str, baseDisplayContainer);
    }

    /* renamed from: f */
    public final void m5139f(ajt ajtVar, String str) {
        this.f4259d.put(str, ajtVar);
    }

    /* renamed from: g */
    public final void m5138g(ajv ajvVar, String str) {
        this.f4260e.put(str, ajvVar);
    }

    /* renamed from: h */
    public final void m5137h(ajw ajwVar) {
        this.f4272q = ajwVar;
    }

    /* renamed from: i */
    public final void m5136i(akv akvVar, String str) {
        this.f4261f.put(str, akvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final void m5135j(AbstractC2490bh abstractC2490bh) {
        this.f4269n.trySetResult(abstractC2490bh);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akb
    /* renamed from: k */
    public final void mo5123k(ajq ajqVar) {
        Map<String, CompanionData> map;
        String str;
        String str2;
        C2496bn c2496bn = (C2496bn) ajqVar.m5158d();
        String m5157e = ajqVar.m5157e();
        ajp m5160b = ajqVar.m5160b();
        String name = ajqVar.m5161a().name();
        String name2 = m5160b.name();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 24 + String.valueOf(name2).length());
        sb.append("Received js message: ");
        sb.append(name);
        sb.append(" [");
        sb.append(name2);
        sb.append("]");
        C2525p.m5989c(sb.toString());
        switch (ajqVar.m5161a().ordinal()) {
            case 0:
                if (this.f4257b.contains(m5157e)) {
                    return;
                }
                ajs ajsVar = (ajs) this.f4256a.get(m5157e);
                if (ajsVar == null) {
                    String valueOf = String.valueOf(m5160b);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(m5157e).length());
                    sb2.append("Received monitor message: ");
                    sb2.append(valueOf);
                    sb2.append(" for invalid session id: ");
                    sb2.append(m5157e);
                    C2525p.m5988d(sb2.toString());
                    return;
                } else if (c2496bn == null) {
                    String valueOf2 = String.valueOf(m5160b);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 56 + String.valueOf(m5157e).length());
                    sb3.append("Received monitor message: ");
                    sb3.append(valueOf2);
                    sb3.append(" for session id: ");
                    sb3.append(m5157e);
                    sb3.append(" with no data");
                    C2525p.m5988d(sb3.toString());
                    return;
                } else if (m5160b.ordinal() == 37) {
                    ajsVar.mo5155h(c2496bn.queryId, c2496bn.eventId);
                    return;
                } else {
                    m5128s(ajo.activityMonitor.toString(), m5160b);
                    return;
                }
            case 1:
                ajt ajtVar = (ajt) this.f4259d.get(m5157e);
                if (ajtVar == null) {
                    String valueOf3 = String.valueOf(m5160b);
                    StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(m5157e).length());
                    sb4.append("Received request message: ");
                    sb4.append(valueOf3);
                    sb4.append(" for invalid session id: ");
                    sb4.append(m5157e);
                    C2525p.m5991a(sb4.toString());
                    return;
                }
                int ordinal = m5160b.ordinal();
                if (ordinal == 11) {
                    if (c2496bn == null) {
                        ajtVar.mo5151d(m5157e, AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR);
                        return;
                    } else {
                        ajtVar.mo5153b(m5157e, c2496bn.adCuePoints, c2496bn.internalCuePoints, c2496bn.monitorAppLifecycle);
                        return;
                    }
                } else if (ordinal == 31) {
                    ajtVar.mo5154a(m5157e, AdError.AdErrorType.LOAD, c2496bn.errorCode, m5130q(c2496bn.errorMessage, c2496bn.innerError));
                    return;
                } else if (ordinal == 68) {
                    ajtVar.mo5152c(m5157e, c2496bn.streamId, c2496bn.monitorAppLifecycle);
                    String valueOf4 = String.valueOf(c2496bn.streamId);
                    C2525p.m5989c(valueOf4.length() != 0 ? "Stream initialized with streamId: ".concat(valueOf4) : new String("Stream initialized with streamId: "));
                    return;
                } else {
                    m5128s(ajo.adsLoader.toString(), m5160b);
                    return;
                }
            case 2:
                ajv ajvVar = (ajv) this.f4260e.get(m5157e);
                if (ajvVar == null) {
                    String valueOf5 = String.valueOf(m5160b);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf5).length() + 51 + String.valueOf(m5157e).length());
                    sb5.append("Received manager message: ");
                    sb5.append(valueOf5);
                    sb5.append(" for invalid session id: ");
                    sb5.append(m5157e);
                    C2525p.m5988d(sb5.toString());
                    return;
                }
                C2509c c2509c = (c2496bn == null || (c2509c = c2496bn.adData) == null) ? null : null;
                int ordinal2 = m5160b.ordinal();
                if (ordinal2 == 12) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.ALL_ADS_COMPLETED, null));
                    return;
                } else if (ordinal2 == 16) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.CLICKED, c2509c));
                    return;
                } else if (ordinal2 == 18) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.COMPLETED, c2509c));
                    return;
                } else if (ordinal2 == 25) {
                    aju ajuVar = new aju(AdEvent.AdEventType.CUEPOINTS_CHANGED, null);
                    ajuVar.f4253d = new ArrayList();
                    for (AbstractC2483ba abstractC2483ba : c2496bn.cuepoints) {
                        ajuVar.f4253d.add(new ajh(abstractC2483ba.start(), abstractC2483ba.end(), abstractC2483ba.played()));
                    }
                    ajvVar.mo5088b(ajuVar);
                    return;
                } else if (ordinal2 == 44) {
                    if (c2509c != null) {
                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.LOADED, c2509c));
                        return;
                    }
                    C2525p.m5991a("Ad loaded message requires adData");
                    ajvVar.mo5149g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Ad loaded message did not contain adData.");
                    return;
                } else if (ordinal2 == 52) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.PAUSED, c2509c));
                    return;
                } else if (ordinal2 == 61) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.RESUMED, c2509c));
                    return;
                } else if (ordinal2 == 69) {
                    ajvVar.mo5088b(new aju(AdEvent.AdEventType.THIRD_QUARTILE, c2509c));
                    return;
                } else if (ordinal2 != 77) {
                    if (ordinal2 == 20) {
                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED, null));
                        return;
                    } else if (ordinal2 == 21) {
                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.CONTENT_RESUME_REQUESTED, null));
                        return;
                    } else if (ordinal2 == 31) {
                        ajvVar.mo5150f(AdError.AdErrorType.PLAY, c2496bn.errorCode, m5130q(c2496bn.errorMessage, c2496bn.innerError));
                        return;
                    } else if (ordinal2 == 32) {
                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.FIRST_QUARTILE, c2509c));
                        return;
                    } else if (ordinal2 == 39) {
                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.ICON_FALLBACK_IMAGE_CLOSED, null));
                        return;
                    } else if (ordinal2 != 40) {
                        switch (ordinal2) {
                            case 1:
                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.AD_BREAK_ENDED, c2509c));
                                return;
                            case 2:
                                aju ajuVar2 = new aju(AdEvent.AdEventType.AD_BREAK_FETCH_ERROR, null);
                                ajuVar2.f4252c = avj.m4502j(c2496bn.adBreakTime);
                                ajvVar.mo5088b(ajuVar2);
                                return;
                            case 3:
                                aju ajuVar3 = new aju(AdEvent.AdEventType.AD_BREAK_READY, null);
                                ajuVar3.f4252c = avj.m4502j(c2496bn.adBreakTime);
                                ajvVar.mo5088b(ajuVar3);
                                return;
                            case 4:
                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.AD_BREAK_STARTED, c2509c));
                                return;
                            case 5:
                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.AD_BUFFERING, null));
                                return;
                            case 6:
                            case 7:
                                return;
                            case 8:
                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.AD_PERIOD_ENDED, null));
                                return;
                            case 9:
                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.AD_PERIOD_STARTED, null));
                                return;
                            case 10:
                                aju ajuVar4 = new aju(AdEvent.AdEventType.AD_PROGRESS, c2509c);
                                ajuVar4.f4254e = new aif(c2496bn.currentTime, c2496bn.duration, c2496bn.adPosition, c2496bn.totalAds, c2496bn.adBreakDuration, c2496bn.adPeriodDuration);
                                ajvVar.mo5088b(ajuVar4);
                                return;
                            default:
                                switch (ordinal2) {
                                    case 46:
                                        aju ajuVar5 = new aju(AdEvent.AdEventType.LOG, c2509c);
                                        ajuVar5.f4252c = c2496bn.logData.constructMap();
                                        ajvVar.mo5088b(ajuVar5);
                                        return;
                                    case 47:
                                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.MIDPOINT, c2509c));
                                        return;
                                    case 48:
                                        return;
                                    case 49:
                                        ajvVar.mo5148h(c2496bn.url);
                                        return;
                                    default:
                                        switch (ordinal2) {
                                            case 63:
                                                aju ajuVar6 = new aju(AdEvent.AdEventType.SKIPPED, null);
                                                ajuVar6.f4255f = c2496bn.seekTime;
                                                ajvVar.mo5088b(ajuVar6);
                                                return;
                                            case 64:
                                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.SKIPPABLE_STATE_CHANGED, c2509c));
                                                return;
                                            case 65:
                                                ajvVar.mo5088b(new aju(AdEvent.AdEventType.STARTED, c2509c));
                                                return;
                                            default:
                                                switch (ordinal2) {
                                                    case 73:
                                                        return;
                                                    case 74:
                                                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.TAPPED, c2509c));
                                                        return;
                                                    case 75:
                                                        ajvVar.mo5088b(new aju(AdEvent.AdEventType.ICON_TAPPED, null));
                                                        return;
                                                    default:
                                                        m5128s(ajo.adsManager.toString(), m5160b);
                                                        return;
                                                }
                                        }
                                }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 3:
            case 8:
            default:
                String valueOf6 = String.valueOf(ajqVar.m5161a());
                String.valueOf(valueOf6).length();
                C2525p.m5991a("Unknown message channel: ".concat(String.valueOf(valueOf6)));
                return;
            case 4:
                aja ajaVar = (aja) this.f4258c.get(m5157e);
                ajv ajvVar2 = (ajv) this.f4260e.get(m5157e);
                akv akvVar = (akv) this.f4261f.get(m5157e);
                if (ajaVar == null || ajvVar2 == null || akvVar == null) {
                    String valueOf7 = String.valueOf(m5160b);
                    StringBuilder sb6 = new StringBuilder(String.valueOf(valueOf7).length() + 60 + String.valueOf(m5157e).length());
                    sb6.append("Received displayContainer message: ");
                    sb6.append(valueOf7);
                    sb6.append(" for invalid session id: ");
                    sb6.append(m5157e);
                    C2525p.m5991a(sb6.toString());
                    return;
                }
                int ordinal3 = m5160b.ordinal();
                if (ordinal3 != 28) {
                    if (ordinal3 == 38 || ordinal3 == 62) {
                        return;
                    }
                    if (ordinal3 == 59) {
                        ajvVar2.mo5146j(c2496bn.resizeAndPositionVideo);
                        return;
                    } else if (ordinal3 == 60) {
                        ajvVar2.mo5145k();
                        return;
                    } else {
                        m5128s(ajo.displayContainer.toString(), m5160b);
                        return;
                    }
                } else if (c2496bn == null || (map = c2496bn.companions) == null) {
                    ajvVar2.mo5149g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display companions message requires companions in data.");
                    return;
                } else {
                    Set<String> keySet = map.keySet();
                    HashMap m4394r = axd.m4394r(keySet.size());
                    for (String str3 : keySet) {
                        CompanionAdSlot companionAdSlot = (CompanionAdSlot) ajaVar.m5180a().get(str3);
                        ViewGroup container = companionAdSlot != null ? companionAdSlot.getContainer() : null;
                        if (container != null) {
                            m4394r.put(str3, container);
                        } else {
                            ajvVar2.mo5149g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display requested for invalid companion slot.");
                        }
                    }
                    for (String str4 : m4394r.keySet()) {
                        ajvVar2.mo5147i((ViewGroup) m4394r.get(str4), c2496bn.companions.get(str4), m5157e, (CompanionAdSlot) ajaVar.m5180a().get(str4), this, new alt(this.f4267l, this.f4266k));
                    }
                    return;
                }
            case 5:
            case 11:
                int ordinal4 = m5160b.ordinal();
                if (ordinal4 == 42) {
                    this.f4270o.trySetResult(c2496bn);
                    this.f4274s = true;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = this.f4273r;
                    HashMap m4394r2 = axd.m4394r(1);
                    m4394r2.put("webViewLoadingTime", Long.valueOf(elapsedRealtime - j));
                    mo5122o(new ajq(ajo.webViewLoaded, ajp.csi, m5157e, m4394r2));
                    return;
                } else if (ordinal4 == 46) {
                    if (c2496bn.f2853ln == null || (str = c2496bn.f2855n) == null || (str2 = c2496bn.f2854m) == null) {
                        String valueOf8 = String.valueOf(c2496bn);
                        String.valueOf(valueOf8).length();
                        C2525p.m5991a("Invalid logging message data: ".concat(String.valueOf(valueOf8)));
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder(String.valueOf(str).length() + 14 + String.valueOf(str2).length());
                    sb7.append("JsMessage (");
                    sb7.append(str);
                    sb7.append("): ");
                    sb7.append(str2);
                    String sb8 = sb7.toString();
                    char charAt = c2496bn.f2853ln.charAt(0);
                    if (charAt != 'D') {
                        if (charAt != 'E') {
                            if (charAt != 'I') {
                                if (charAt != 'S') {
                                    if (charAt != 'V') {
                                        if (charAt == 'W') {
                                            C2525p.m5988d(sb8);
                                            return;
                                        }
                                        String valueOf9 = String.valueOf(c2496bn.f2853ln);
                                        C2525p.m5988d(valueOf9.length() != 0 ? "Unrecognized log level: ".concat(valueOf9) : new String("Unrecognized log level: "));
                                        C2525p.m5988d(sb8);
                                        return;
                                    }
                                }
                            }
                        }
                        C2525p.m5991a(sb8);
                        return;
                    }
                    C2525p.m5989c(sb8);
                    return;
                } else {
                    m5128s("other", m5160b);
                    return;
                }
            case 6:
                akk akkVar = this.f4271p;
                if (akkVar != null) {
                    akkVar.m5106c(m5160b, m5157e, c2496bn.networkRequest);
                    return;
                } else {
                    C2525p.m5991a("Native network handler not initialized.");
                    return;
                }
            case 7:
                if (this.f4272q == null) {
                    C2525p.m5991a("Null 'omidManagerListener': cannot send 'onOmidMessage'.");
                    return;
                }
                int ordinal5 = m5160b.ordinal();
                if (ordinal5 == 50) {
                    this.f4272q.mo5104b();
                    return;
                } else if (ordinal5 != 51) {
                    return;
                } else {
                    this.f4272q.mo5105a();
                    return;
                }
            case 9:
                m5129r(ajo.videoDisplay1, m5160b, m5157e, c2496bn);
                return;
            case 10:
                m5129r(ajo.videoDisplay2, m5160b, m5157e, c2496bn);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final void m5134l() {
        this.f4264i.m5120b();
    }

    /* renamed from: m */
    public final void m5133m(String str) {
        this.f4256a.remove(str);
        this.f4257b.add(str);
    }

    /* renamed from: n */
    public final void m5132n(String str) {
        this.f4259d.remove(str);
        this.f4260e.remove(str);
        this.f4258c.remove(str);
        this.f4261f.remove(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akc
    /* renamed from: o */
    public final void mo5122o(ajq ajqVar) {
        String name = ajqVar.m5161a().name();
        String name2 = ajqVar.m5160b().name();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 23 + String.valueOf(name2).length());
        sb.append("Sending js message: ");
        sb.append(name);
        sb.append(" [");
        sb.append(name2);
        sb.append("]");
        C2525p.m5989c(sb.toString());
        this.f4265j.add(ajqVar);
        if (this.f4274s) {
            ajq ajqVar2 = (ajq) this.f4265j.poll();
            while (ajqVar2 != null) {
                this.f4264i.m5114h(ajqVar2);
                ajqVar2 = (ajq) this.f4265j.poll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final /* synthetic */ void m5131p() {
        aki akhVar;
        AbstractC2490bh abstractC2490bh = (AbstractC2490bh) this.f4269n.getTask().getResult();
        Context context = this.f4262g;
        boolean z = ((C2496bn) this.f4270o.getTask().getResult()).enableGks;
        ExecutorService executorService = this.f4267l;
        if (z) {
            akhVar = new akj(context, abstractC2490bh);
        } else {
            akhVar = new akh(null);
        }
        this.f4271p = new akk(this, executorService, akhVar);
    }
}
