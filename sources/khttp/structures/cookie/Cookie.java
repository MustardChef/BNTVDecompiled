package khttp.structures.cookie;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: Cookie.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, m107d2 = {"Lkhttp/structures/cookie/Cookie;", "", TypedValues.Custom.S_STRING, "", "(Ljava/lang/String;)V", "cookie", "(Lkhttp/structures/cookie/Cookie;)V", SDKConstants.PARAM_KEY, "value", "attributes", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;)V", "getAttributes", "()Ljava/util/Map;", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "valueWithAttributes", "getValueWithAttributes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class Cookie {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> attributes;
    private final String key;
    private final Object value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, Object obj, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = cookie.key;
        }
        if ((i & 2) != 0) {
            obj = cookie.value;
        }
        if ((i & 4) != 0) {
            map = cookie.attributes;
        }
        return cookie.copy(str, obj, map);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value;
    }

    public final Map<String, Object> component3() {
        return this.attributes;
    }

    public final Cookie copy(String key, Object value, Map<String, ? extends Object> attributes) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(attributes, "attributes");
        return new Cookie(key, value, attributes);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Cookie) {
                Cookie cookie = (Cookie) obj;
                return Intrinsics.areEqual(this.key, cookie.key) && Intrinsics.areEqual(this.value, cookie.value) && Intrinsics.areEqual(this.attributes, cookie.attributes);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Map<String, Object> map = this.attributes;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "Cookie(key=" + this.key + ", value=" + this.value + ", attributes=" + this.attributes + ")";
    }

    public Cookie(String key, Object value, Map<String, ? extends Object> attributes) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(attributes, "attributes");
        this.key = key;
        this.value = value;
        this.attributes = attributes;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, Object obj, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    /* compiled from: Cookie.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, m107d2 = {"Lkhttp/structures/cookie/Cookie$Companion;", "", "()V", "toCookie", "Lkhttp/structures/cookie/Cookie;", "", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Cookie toCookie(String str) {
            Map map;
            String str2;
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 2, 2, (Object) null);
            if (!(split$default.size() == 2)) {
                throw new IllegalArgumentException(('\"' + str + "\" is not a cookie.").toString());
            }
            String str3 = (String) split$default.get(0);
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj = StringsKt.trim((CharSequence) str3).toString();
            List split$default2 = StringsKt.split$default((CharSequence) split$default.get(1), new String[]{";"}, false, 0, 6, (Object) null);
            String str4 = (String) split$default2.get(0);
            if (str4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj2 = StringsKt.trim((CharSequence) str4).toString();
            if (split$default2.size() < 2) {
                map = MapsKt.emptyMap();
            } else {
                List<String> subList = split$default2.subList(1, split$default2.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(subList, 10)), 16));
                for (String str5 : subList) {
                    String str6 = (String) StringsKt.split$default((CharSequence) str5, new String[]{"="}, false, 0, 6, (Object) null).get(0);
                    if (str6 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String obj3 = StringsKt.trim((CharSequence) str6).toString();
                    String str7 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str5, new String[]{"="}, false, 0, 6, (Object) null), 1);
                    if (str7 == null) {
                        str2 = null;
                    } else if (str7 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    } else {
                        str2 = StringsKt.trim((CharSequence) str7).toString();
                    }
                    Tuples m100to = TuplesKt.m100to(obj3, str2);
                    linkedHashMap.put(m100to.getFirst(), m100to.getSecond());
                }
                map = linkedHashMap;
            }
            return new Cookie(obj, obj2, map);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cookie(String string) {
        this(Companion.toCookie(string));
        Intrinsics.checkParameterIsNotNull(string, "string");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cookie(Cookie cookie) {
        this(cookie.key, cookie.value, cookie.attributes);
        Intrinsics.checkParameterIsNotNull(cookie, "cookie");
    }

    public final String getValueWithAttributes() {
        if (this.attributes.isEmpty()) {
            return this.value.toString();
        }
        return this.value.toString() + "; " + SequencesKt.joinToString$default(MapsKt.asSequence(this.attributes), "; ", null, null, 0, null, Cookie$valueWithAttributes$1.INSTANCE, 30, null);
    }
}
