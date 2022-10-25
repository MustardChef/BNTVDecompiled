package com.lagradost.cloudstream3.services;

import android.util.Log;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.phimhd.AppController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FCMService.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/FCMService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "handleNow", "", "map", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "sendRegistrationToServer", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class FCMService extends FirebaseMessagingService {
    private String TAG = "DuongKK";

    public final String getTAG() {
        return this.TAG;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        String str = this.TAG;
        Log.d(str, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private final void sendRegistrationToServer(String str) {
        LogUtils.m6080d("sendRegistrationToServer = " + str, new Object[0]);
        AppController companion = AppController.Companion.getInstance();
        if (companion != null) {
            companion.setTokenFCM(str);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        LogUtils.m6080d(this.TAG, "onMessageReceived:=====> ");
        String str = this.TAG;
        LogUtils.m6080d(str, "From: " + remoteMessage.getFrom());
        Map<String, String> data = remoteMessage.getData();
        if ((data != null ? Integer.valueOf(data.size()) : null).intValue() > 0) {
            String str2 = this.TAG;
            LogUtils.m6080d(str2, "Message data payload: " + remoteMessage.getData());
            Map<String, String> data2 = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "remoteMessage.getData()");
            handleNow(data2);
        }
        if (remoteMessage.getNotification() != null) {
            String str3 = this.TAG;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("Message Notification Body: ");
            RemoteMessage.Notification notification = remoteMessage.getNotification();
            sb.append(notification != null ? notification.getBody() : null);
            objArr[0] = sb.toString();
            LogUtils.m6080d(str3, objArr);
        }
    }

    private final void handleNow(Map<String, String> map) {
        LogUtils.m6080d("New Notification ====> handleNow()", new Object[0]);
    }
}
