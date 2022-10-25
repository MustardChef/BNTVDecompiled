package com.applovin.impl.p010a;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.c */
/* loaded from: classes.dex */
public class C1135c {

    /* renamed from: c */
    private static final List<String> f216c = Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_WEBM, MimeTypes.VIDEO_H263, MimeTypes.VIDEO_MATROSKA);

    /* renamed from: b */
    private final C1662k f218b;

    /* renamed from: d */
    private final JSONObject f219d;

    /* renamed from: e */
    private final JSONObject f220e;

    /* renamed from: f */
    private final EnumC1528b f221f;

    /* renamed from: a */
    protected List<C1766p> f217a = new ArrayList();

    /* renamed from: g */
    private final long f222g = System.currentTimeMillis();

    public C1135c(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, C1662k c1662k) {
        this.f218b = c1662k;
        this.f219d = jSONObject;
        this.f220e = jSONObject2;
        this.f221f = enumC1528b;
    }

    /* renamed from: a */
    public int m8380a() {
        return this.f217a.size();
    }

    /* renamed from: b */
    public List<C1766p> m8379b() {
        return this.f217a;
    }

    /* renamed from: c */
    public JSONObject m8378c() {
        return this.f219d;
    }

    /* renamed from: d */
    public JSONObject m8377d() {
        return this.f220e;
    }

    /* renamed from: e */
    public EnumC1528b m8376e() {
        return this.f221f;
    }

    /* renamed from: f */
    public long m8375f() {
        return this.f222g;
    }

    /* renamed from: g */
    public List<String> m8374g() {
        List<String> explode = CollectionUtils.explode(JsonUtils.getString(this.f219d, "vast_preferred_video_types", null));
        return !explode.isEmpty() ? explode : f216c;
    }

    /* renamed from: h */
    public int m8373h() {
        return Utils.getVideoCompletionPercent(this.f219d);
    }
}
