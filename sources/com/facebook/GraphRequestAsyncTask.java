package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    private static final String TAG = "com.facebook.GraphRequestAsyncTask";
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ List<GraphResponse> doInBackground(Void[] voidArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground2(voidArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(List<GraphResponse> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            onPostExecute2(list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch(graphRequestArr));
    }

    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch(graphRequestArr));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.requests = graphRequestBatch;
        this.connection = httpURLConnection;
    }

    protected final Exception getException() {
        return this.exception;
    }

    protected final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Handler handler;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onPreExecute();
            if (FacebookSdk.isDebugEnabled()) {
                Utility.logd(TAG, String.format("execute async task: %s", this));
            }
            if (this.requests.getCallbackHandler() == null) {
                if (Thread.currentThread() instanceof HandlerThread) {
                    handler = new Handler();
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                this.requests.setCallbackHandler(handler);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* renamed from: onPostExecute  reason: avoid collision after fix types in other method */
    protected void onPostExecute2(List<GraphResponse> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onPostExecute((GraphRequestAsyncTask) list);
            Exception exc = this.exception;
            if (exc != null) {
                Utility.logd(TAG, String.format("onPostExecute: exception encountered during request: %s", exc.getMessage()));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* renamed from: doInBackground  reason: avoid collision after fix types in other method */
    protected List<GraphResponse> doInBackground2(Void... voidArr) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                HttpURLConnection httpURLConnection = this.connection;
                if (httpURLConnection == null) {
                    return this.requests.executeAndWait();
                }
                return GraphRequest.executeConnectionAndWait(httpURLConnection, this.requests);
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
