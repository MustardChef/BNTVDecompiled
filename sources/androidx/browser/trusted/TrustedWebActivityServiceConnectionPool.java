package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class TrustedWebActivityServiceConnectionPool {
    private static final String TAG = "TWAConnectionPool";
    private final Map<Uri, ConnectionHolder> mConnections = new HashMap();
    private final Context mContext;

    private TrustedWebActivityServiceConnectionPool(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static TrustedWebActivityServiceConnectionPool create(Context context) {
        return new TrustedWebActivityServiceConnectionPool(context);
    }

    public ListenableFuture<TrustedWebActivityServiceConnection> connect(final Uri scope, Set<Token> possiblePackages, Executor executor) {
        ConnectionHolder connectionHolder = this.mConnections.get(scope);
        if (connectionHolder != null) {
            return connectionHolder.getServiceWrapper();
        }
        Intent createServiceIntent = createServiceIntent(this.mContext, scope, possiblePackages, true);
        if (createServiceIntent == null) {
            return FutureUtils.immediateFailedFuture(new IllegalArgumentException("No service exists for scope"));
        }
        ConnectionHolder connectionHolder2 = new ConnectionHolder(new Runnable() { // from class: androidx.browser.trusted.-$$Lambda$TrustedWebActivityServiceConnectionPool$UnV68pH1fPB4ehvH7n0YXCAXMiI
            @Override // java.lang.Runnable
            public final void run() {
                TrustedWebActivityServiceConnectionPool.this.lambda$connect$0$TrustedWebActivityServiceConnectionPool(scope);
            }
        });
        this.mConnections.put(scope, connectionHolder2);
        new BindToServiceAsyncTask(this.mContext, createServiceIntent, connectionHolder2).executeOnExecutor(executor, new Void[0]);
        return connectionHolder2.getServiceWrapper();
    }

    public /* synthetic */ void lambda$connect$0$TrustedWebActivityServiceConnectionPool(Uri uri) {
        this.mConnections.remove(uri);
    }

    /* loaded from: classes.dex */
    static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {
        private final Context mAppContext;
        private final ConnectionHolder mConnection;
        private final Intent mIntent;

        BindToServiceAsyncTask(Context context, Intent intent, ConnectionHolder connection) {
            this.mAppContext = context.getApplicationContext();
            this.mIntent = intent;
            this.mConnection = connection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Exception doInBackground(Void... voids) {
            try {
                if (this.mAppContext.bindService(this.mIntent, this.mConnection, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)) {
                    return null;
                }
                this.mAppContext.unbindService(this.mConnection);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                Log.w(TrustedWebActivityServiceConnectionPool.TAG, "SecurityException while binding.", e);
                return e;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Exception bindingException) {
            if (bindingException != null) {
                this.mConnection.cancel(bindingException);
            }
        }
    }

    public boolean serviceExistsForScope(Uri scope, Set<Token> possiblePackages) {
        return (this.mConnections.get(scope) == null && createServiceIntent(this.mContext, scope, possiblePackages, false) == null) ? false : true;
    }

    void unbindAllConnections() {
        for (ConnectionHolder connectionHolder : this.mConnections.values()) {
            this.mContext.unbindService(connectionHolder);
        }
        this.mConnections.clear();
    }

    private Intent createServiceIntent(Context appContext, Uri scope, Set<Token> possiblePackages, boolean shouldLog) {
        if (possiblePackages == null || possiblePackages.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(scope);
        intent.setAction("android.intent.action.VIEW");
        String str = null;
        for (ResolveInfo resolveInfo : appContext.getPackageManager().queryIntentActivities(intent, 65536)) {
            String str2 = resolveInfo.activityInfo.packageName;
            Iterator<Token> it = possiblePackages.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().matches(str2, appContext.getPackageManager())) {
                        str = str2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (str == null) {
            if (shouldLog) {
                Log.w(TAG, "No TWA candidates for " + scope + " have been registered.");
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str);
        intent2.setAction(TrustedWebActivityService.ACTION_TRUSTED_WEB_ACTIVITY_SERVICE);
        ResolveInfo resolveService = appContext.getPackageManager().resolveService(intent2, 131072);
        if (resolveService == null) {
            if (shouldLog) {
                Log.w(TAG, "Could not find TWAService for " + str);
            }
            return null;
        }
        if (shouldLog) {
            Log.i(TAG, "Found " + resolveService.serviceInfo.name + " to handle request for " + scope);
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str, resolveService.serviceInfo.name));
        return intent3;
    }
}
