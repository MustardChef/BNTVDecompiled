package com.lagradost.cloudstream3.mvvm;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.HttpException;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Standard;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchComponentExt.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.mvvm.ArchComponentExtKt$safeApiCall$2", m98f = "ArchComponentExt.kt", m97i = {}, m96l = {77}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class ArchComponentExtKt$safeApiCall$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Resource<? extends T>>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $apiCall;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArchComponentExtKt$safeApiCall$2(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super ArchComponentExtKt$safeApiCall$2> continuation) {
        super(2, continuation);
        this.$apiCall = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchComponentExtKt$safeApiCall$2(this.$apiCall, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Resource<? extends T>> continuation) {
        return ((ArchComponentExtKt$safeApiCall$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Resource.Failure safeFail;
        String fileName;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super T>, Object> function1 = this.$apiCall;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return new Resource.Success(obj);
        } catch (Throwable th) {
            ArchComponentExt.logError(th);
            if (th instanceof NullPointerException) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
                int length = stackTrace.length;
                for (int i2 = 0; i2 < length; i2++) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if ((stackTraceElement == null || (fileName = stackTraceElement.getFileName()) == null || !StringsKt.endsWith(fileName, "provider.kt", true)) ? false : true) {
                        return new Resource.Failure(false, null, null, "NullPointerException at " + stackTraceElement.getFileName() + ' ' + stackTraceElement.getLineNumber() + "\nSite might have updated or added Cloudflare/DDOS protection");
                    }
                }
                safeFail = ArchComponentExt.safeFail(th);
            } else if (th instanceof SocketTimeoutException) {
                safeFail = new Resource.Failure(true, null, null, "Connection Timeout\nPlease try again later.");
            } else if (th instanceof HttpException) {
                Integer boxInt = boxing.boxInt(((HttpException) th).getStatusCode());
                String message = th.getMessage();
                if (message == null) {
                    message = "HttpException";
                }
                return new Resource.Failure(false, boxInt, null, message);
            } else if (th instanceof UnknownHostException) {
                safeFail = new Resource.Failure(true, null, null, "Cannot connect to server, try again later.");
            } else if (th instanceof ErrorLoadingException) {
                String message2 = th.getMessage();
                if (message2 == null) {
                    message2 = "Error loading, try again later.";
                }
                return new Resource.Failure(true, null, null, message2);
            } else if (th instanceof Standard) {
                safeFail = new Resource.Failure(false, null, null, "This operation is not implemented.");
            } else if (th instanceof SSLHandshakeException) {
                StringBuilder sb = new StringBuilder();
                String message3 = th.getMessage();
                if (message3 == null) {
                    message3 = "SSLHandshakeException";
                }
                sb.append(message3);
                sb.append("\nTry again later.");
                return new Resource.Failure(true, null, null, sb.toString());
            } else {
                safeFail = ArchComponentExt.safeFail(th);
            }
            return safeFail;
        }
    }
}
