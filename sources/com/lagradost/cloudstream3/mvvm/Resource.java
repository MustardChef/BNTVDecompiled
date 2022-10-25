package com.lagradost.cloudstream3.mvvm;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArchComponentExt.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/mvvm/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Failure", "Loading", "Success", "Lcom/lagradost/cloudstream3/mvvm/Resource$Success;", "Lcom/lagradost/cloudstream3/mvvm/Resource$Failure;", "Lcom/lagradost/cloudstream3/mvvm/Resource$Loading;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public abstract class Resource<T> {
    public /* synthetic */ Resource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ArchComponentExt.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/mvvm/Resource$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lagradost/cloudstream3/mvvm/Resource;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/lagradost/cloudstream3/mvvm/Resource$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success<T> extends Resource<T> {
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.value;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.value, ((Success) obj).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ')';
        }

        public Success(T t) {
            super(null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private Resource() {
    }

    /* compiled from: ArchComponentExt.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0013¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/mvvm/Resource$Failure;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "isNetworkError", "", "errorCode", "", "errorResponse", "", "errorString", "", "(ZLjava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorResponse", "()Ljava/lang/Object;", "getErrorString", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;)Lcom/lagradost/cloudstream3/mvvm/Resource$Failure;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure extends Resource {
        private final Integer errorCode;
        private final Object errorResponse;
        private final String errorString;
        private final boolean isNetworkError;

        public static /* synthetic */ Failure copy$default(Failure failure, boolean z, Integer num, Object obj, String str, int i, Object obj2) {
            if ((i & 1) != 0) {
                z = failure.isNetworkError;
            }
            if ((i & 2) != 0) {
                num = failure.errorCode;
            }
            if ((i & 4) != 0) {
                obj = failure.errorResponse;
            }
            if ((i & 8) != 0) {
                str = failure.errorString;
            }
            return failure.copy(z, num, obj, str);
        }

        public final boolean component1() {
            return this.isNetworkError;
        }

        public final Integer component2() {
            return this.errorCode;
        }

        public final Object component3() {
            return this.errorResponse;
        }

        public final String component4() {
            return this.errorString;
        }

        public final Failure copy(boolean z, Integer num, Object obj, String errorString) {
            Intrinsics.checkNotNullParameter(errorString, "errorString");
            return new Failure(z, num, obj, errorString);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.isNetworkError == failure.isNetworkError && Intrinsics.areEqual(this.errorCode, failure.errorCode) && Intrinsics.areEqual(this.errorResponse, failure.errorResponse) && Intrinsics.areEqual(this.errorString, failure.errorString);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z = this.isNetworkError;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.errorCode;
            int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
            Object obj = this.errorResponse;
            return ((hashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.errorString.hashCode();
        }

        public String toString() {
            return "Failure(isNetworkError=" + this.isNetworkError + ", errorCode=" + this.errorCode + ", errorResponse=" + this.errorResponse + ", errorString=" + this.errorString + ')';
        }

        public final boolean isNetworkError() {
            return this.isNetworkError;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final Object getErrorResponse() {
            return this.errorResponse;
        }

        public final String getErrorString() {
            return this.errorString;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(boolean z, Integer num, Object obj, String errorString) {
            super(null);
            Intrinsics.checkNotNullParameter(errorString, "errorString");
            this.isNetworkError = z;
            this.errorCode = num;
            this.errorResponse = obj;
            this.errorString = errorString;
        }
    }

    /* compiled from: ArchComponentExt.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/mvvm/Resource$Loading;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Loading extends Resource {
        private final String url;

        public Loading() {
            this(null, 1, null);
        }

        public static /* synthetic */ Loading copy$default(Loading loading, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loading.url;
            }
            return loading.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Loading copy(String str) {
            return new Loading(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.areEqual(this.url, ((Loading) obj).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Loading(url=" + this.url + ')';
        }

        public Loading(String str) {
            super(null);
            this.url = str;
        }

        public /* synthetic */ Loading(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getUrl() {
            return this.url;
        }
    }
}
