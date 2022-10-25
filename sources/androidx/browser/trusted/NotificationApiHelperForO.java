package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes.dex */
class NotificationApiHelperForO {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isChannelEnabled(NotificationManager manager, String channelId) {
        NotificationChannel notificationChannel = manager.getNotificationChannel(channelId);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Notification copyNotificationOntoChannel(Context context, NotificationManager manager, Notification notification, String channelId, String channelName) {
        manager.createNotificationChannel(new NotificationChannel(channelId, channelName, 3));
        if (manager.getNotificationChannel(channelId).getImportance() == 0) {
            return null;
        }
        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
        recoverBuilder.setChannelId(channelId);
        return recoverBuilder.build();
    }

    private NotificationApiHelperForO() {
    }
}
