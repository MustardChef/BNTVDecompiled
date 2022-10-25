package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: MapWithDefault.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tR\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m107d2 = {"Lkotlin/collections/MapWithDefault;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "getMap", "()Ljava/util/Map;", "getOrImplicitDefault", SDKConstants.PARAM_KEY, "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMarkers {
    Map<K, V> getMap();

    V getOrImplicitDefault(K k);
}