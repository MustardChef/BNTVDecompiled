package com.github.se_bastiaan.torrentstream;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.browser.trusted.sharing.ShareTarget;
import com.frostwire.jlibtorrent.Priority;
import com.frostwire.jlibtorrent.SessionManager;
import com.frostwire.jlibtorrent.SessionParams;
import com.frostwire.jlibtorrent.SettingsPack;
import com.frostwire.jlibtorrent.TorrentHandle;
import com.frostwire.jlibtorrent.TorrentInfo;
import com.frostwire.jlibtorrent.alerts.AddTorrentAlert;
import com.frostwire.jlibtorrent.swig.settings_pack;
import com.github.se_bastiaan.torrentstream.exceptions.DirectoryModifyException;
import com.github.se_bastiaan.torrentstream.exceptions.NotInitializedException;
import com.github.se_bastiaan.torrentstream.exceptions.TorrentInfoException;
import com.github.se_bastiaan.torrentstream.listeners.DHTStatsAlertListener;
import com.github.se_bastiaan.torrentstream.listeners.TorrentAddedAlertListener;
import com.github.se_bastiaan.torrentstream.listeners.TorrentListener;
import com.github.se_bastiaan.torrentstream.utils.FileUtils;
import com.github.se_bastiaan.torrentstream.utils.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class TorrentStream {
    private static final String LIBTORRENT_THREAD_NAME = "TORRENTSTREAM_LIBTORRENT";
    private static final String STREAMING_THREAD_NAME = "TORRENTSTREAMER_STREAMING";
    private static TorrentStream sThis;
    private Torrent currentTorrent;
    private String currentTorrentUrl;
    private CountDownLatch initialisingLatch;
    private Handler libTorrentHandler;
    private HandlerThread libTorrentThread;
    private Handler streamingHandler;
    private HandlerThread streamingThread;
    private TorrentOptions torrentOptions;
    private SessionManager torrentSession;
    private Boolean initialising = false;
    private Boolean initialised = false;
    private Boolean isStreaming = false;
    private Boolean isCanceled = false;
    private Integer dhtNodes = 0;
    private final List<TorrentListener> listeners = new ArrayList();
    private final DHTStatsAlertListener dhtStatsAlertListener = new DHTStatsAlertListener() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.1
        @Override // com.github.se_bastiaan.torrentstream.listeners.DHTStatsAlertListener
        public void stats(int i) {
            TorrentStream.this.dhtNodes = Integer.valueOf(i);
        }
    };
    private final TorrentAddedAlertListener torrentAddedAlertListener = new TorrentAddedAlertListener() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.2
        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentAddedAlertListener
        public void torrentAdded(AddTorrentAlert addTorrentAlert) {
            InternalTorrentListener internalTorrentListener = new InternalTorrentListener();
            TorrentHandle find = TorrentStream.this.torrentSession.find(addTorrentAlert.handle().infoHash());
            TorrentStream.this.currentTorrent = new Torrent(find, internalTorrentListener, TorrentStream.this.torrentOptions.prepareSize);
            TorrentStream.this.torrentSession.addListener(TorrentStream.this.currentTorrent);
        }
    };

    private TorrentStream(TorrentOptions torrentOptions) {
        this.torrentOptions = torrentOptions;
        initialise();
    }

    public static TorrentStream init(TorrentOptions torrentOptions) {
        TorrentStream torrentStream = new TorrentStream(torrentOptions);
        sThis = torrentStream;
        return torrentStream;
    }

    public static TorrentStream getInstance() throws NotInitializedException {
        TorrentStream torrentStream = sThis;
        if (torrentStream != null) {
            return torrentStream;
        }
        throw new NotInitializedException();
    }

    private void initialise() {
        HandlerThread handlerThread;
        if (this.libTorrentThread != null && this.torrentSession != null) {
            resumeSession();
            return;
        }
        if ((this.initialising.booleanValue() || this.initialised.booleanValue()) && (handlerThread = this.libTorrentThread) != null) {
            handlerThread.interrupt();
        }
        this.initialising = true;
        this.initialised = false;
        this.initialisingLatch = new CountDownLatch(1);
        HandlerThread handlerThread2 = new HandlerThread(LIBTORRENT_THREAD_NAME);
        this.libTorrentThread = handlerThread2;
        handlerThread2.start();
        Handler handler = new Handler(this.libTorrentThread.getLooper());
        this.libTorrentHandler = handler;
        handler.post(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.3
            @Override // java.lang.Runnable
            public void run() {
                TorrentStream.this.torrentSession = new SessionManager();
                TorrentStream torrentStream = TorrentStream.this;
                torrentStream.setOptions(torrentStream.torrentOptions);
                TorrentStream.this.torrentSession.addListener(TorrentStream.this.dhtStatsAlertListener);
                TorrentStream.this.torrentSession.startDht();
                TorrentStream.this.initialising = false;
                TorrentStream.this.initialised = true;
                TorrentStream.this.initialisingLatch.countDown();
            }
        });
    }

    public void resumeSession() {
        if (this.libTorrentThread == null || this.torrentSession == null) {
            return;
        }
        this.libTorrentHandler.removeCallbacksAndMessages(null);
        if (this.torrentSession.isPaused()) {
            this.libTorrentHandler.post(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.4
                @Override // java.lang.Runnable
                public void run() {
                    TorrentStream.this.torrentSession.resume();
                }
            });
        }
        if (this.torrentSession.isDhtRunning()) {
            return;
        }
        this.libTorrentHandler.post(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.5
            @Override // java.lang.Runnable
            public void run() {
                TorrentStream.this.torrentSession.startDht();
            }
        });
    }

    public void pauseSession() {
        if (this.isStreaming.booleanValue()) {
            return;
        }
        this.libTorrentHandler.post(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.6
            @Override // java.lang.Runnable
            public void run() {
                TorrentStream.this.torrentSession.pause();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TorrentInfo getTorrentInfo(String str) throws TorrentInfoException {
        if (str.startsWith("magnet")) {
            byte[] fetchMagnet = this.torrentSession.fetchMagnet(str, 30000);
            if (fetchMagnet != null) {
                try {
                    return TorrentInfo.bdecode(fetchMagnet);
                } catch (IllegalArgumentException e) {
                    throw new TorrentInfoException(e);
                }
            }
            return null;
        } else if (str.startsWith("http") || str.startsWith("https")) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[0];
                if (httpURLConnection.getResponseCode() == 200) {
                    bArr = getBytesFromInputStream(inputStream);
                }
                inputStream.close();
                httpURLConnection.disconnect();
                if (bArr.length > 0) {
                    return TorrentInfo.bdecode(bArr);
                }
                return null;
            } catch (IOException | IllegalArgumentException e2) {
                throw new TorrentInfoException(e2);
            }
        } else if (str.startsWith("file")) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(Uri.parse(str).getPath()));
                byte[] bytesFromInputStream = getBytesFromInputStream(fileInputStream);
                fileInputStream.close();
                if (bytesFromInputStream.length > 0) {
                    return TorrentInfo.bdecode(bytesFromInputStream);
                }
                return null;
            } catch (IOException | IllegalArgumentException e3) {
                throw new TorrentInfoException(e3);
            }
        } else {
            return null;
        }
    }

    private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void startStream(final String str) {
        if (!this.initialising.booleanValue() && !this.initialised.booleanValue()) {
            initialise();
        }
        if (this.libTorrentHandler == null || this.isStreaming.booleanValue()) {
            return;
        }
        this.isCanceled = false;
        HandlerThread handlerThread = new HandlerThread(STREAMING_THREAD_NAME);
        this.streamingThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.streamingThread.getLooper());
        this.streamingHandler = handler;
        handler.post(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.7
            @Override // java.lang.Runnable
            public void run() {
                TorrentStream.this.isStreaming = true;
                TorrentInfo torrentInfo = null;
                if (TorrentStream.this.initialisingLatch != null) {
                    try {
                        TorrentStream.this.initialisingLatch.await();
                        TorrentStream.this.initialisingLatch = null;
                    } catch (InterruptedException unused) {
                        TorrentStream.this.isStreaming = false;
                        return;
                    }
                }
                TorrentStream.this.currentTorrentUrl = str;
                File file = new File(TorrentStream.this.torrentOptions.saveLocation);
                if (file.isDirectory() || file.mkdirs()) {
                    TorrentStream.this.torrentSession.removeListener(TorrentStream.this.torrentAddedAlertListener);
                    try {
                        torrentInfo = TorrentStream.this.getTorrentInfo(str);
                    } catch (TorrentInfoException e) {
                        for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.7.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    torrentListener.onStreamError(null, e);
                                }
                            });
                        }
                    }
                    TorrentInfo torrentInfo2 = torrentInfo;
                    TorrentStream.this.torrentSession.addListener(TorrentStream.this.torrentAddedAlertListener);
                    if (torrentInfo2 == null) {
                        for (final TorrentListener torrentListener2 : TorrentStream.this.listeners) {
                            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.7.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    torrentListener2.onStreamError(null, new TorrentInfoException(null));
                                }
                            });
                        }
                        TorrentStream.this.isStreaming = false;
                        return;
                    }
                    int numFiles = torrentInfo2.numFiles();
                    Priority[] priorityArr = new Priority[numFiles];
                    for (int i = 0; i < numFiles; i++) {
                        priorityArr[i] = Priority.IGNORE;
                    }
                    if (!TorrentStream.this.currentTorrentUrl.equals(str) || TorrentStream.this.isCanceled.booleanValue()) {
                        return;
                    }
                    TorrentStream.this.torrentSession.download(torrentInfo2, file, null, priorityArr, null);
                    return;
                }
                for (final TorrentListener torrentListener3 : TorrentStream.this.listeners) {
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            torrentListener3.onStreamError(null, new DirectoryModifyException());
                        }
                    });
                }
                TorrentStream.this.isStreaming = false;
            }
        });
    }

    public void stopStream() {
        Handler handler = this.libTorrentHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.streamingHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        this.isCanceled = true;
        this.isStreaming = false;
        Torrent torrent = this.currentTorrent;
        if (torrent != null) {
            final File saveLocation = torrent.getSaveLocation();
            this.currentTorrent.pause();
            this.torrentSession.removeListener(this.currentTorrent);
            this.torrentSession.remove(this.currentTorrent.getTorrentHandle());
            this.currentTorrent = null;
            if (this.torrentOptions.removeFiles.booleanValue()) {
                new Thread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.8
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (!FileUtils.recursiveDelete(saveLocation) && i < 5) {
                            i++;
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException unused) {
                                for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.8.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            torrentListener.onStreamError(TorrentStream.this.currentTorrent, new DirectoryModifyException());
                                        }
                                    });
                                }
                            }
                        }
                    }
                }).start();
            }
        }
        HandlerThread handlerThread = this.streamingThread;
        if (handlerThread != null) {
            handlerThread.interrupt();
        }
        for (final TorrentListener torrentListener : this.listeners) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.9
                @Override // java.lang.Runnable
                public void run() {
                    torrentListener.onStreamStopped();
                }
            });
        }
    }

    public TorrentOptions getOptions() {
        return this.torrentOptions;
    }

    public void setOptions(TorrentOptions torrentOptions) {
        this.torrentOptions = torrentOptions;
        SettingsPack activeDhtLimit = new SettingsPack().anonymousMode(this.torrentOptions.anonymousMode.booleanValue()).connectionsLimit(this.torrentOptions.maxConnections.intValue()).downloadRateLimit(this.torrentOptions.maxDownloadSpeed.intValue()).uploadRateLimit(this.torrentOptions.maxUploadSpeed.intValue()).activeDhtLimit(this.torrentOptions.maxDht.intValue());
        if (this.torrentOptions.listeningPort.intValue() != -1) {
            activeDhtLimit.setString(settings_pack.string_types.listen_interfaces.swigValue(), String.format(Locale.ENGLISH, "%s:%d", "0.0.0.0", this.torrentOptions.listeningPort));
        }
        if (this.torrentOptions.proxyHost != null) {
            activeDhtLimit.setString(settings_pack.string_types.proxy_hostname.swigValue(), this.torrentOptions.proxyHost);
            if (this.torrentOptions.proxyUsername != null) {
                activeDhtLimit.setString(settings_pack.string_types.proxy_username.swigValue(), this.torrentOptions.proxyUsername);
                if (this.torrentOptions.proxyPassword != null) {
                    activeDhtLimit.setString(settings_pack.string_types.proxy_password.swigValue(), this.torrentOptions.proxyPassword);
                }
            }
        }
        if (this.torrentOptions.peerFingerprint != null) {
            activeDhtLimit.setString(settings_pack.string_types.peer_fingerprint.swigValue(), this.torrentOptions.peerFingerprint);
        }
        if (!this.torrentSession.isRunning()) {
            this.torrentSession.start(new SessionParams(activeDhtLimit));
        } else {
            this.torrentSession.applySettings(activeDhtLimit);
        }
    }

    public boolean isStreaming() {
        return this.isStreaming.booleanValue();
    }

    public String getCurrentTorrentUrl() {
        return this.currentTorrentUrl;
    }

    public Integer getTotalDhtNodes() {
        return this.dhtNodes;
    }

    public Torrent getCurrentTorrent() {
        return this.currentTorrent;
    }

    public void addListener(TorrentListener torrentListener) {
        if (torrentListener != null) {
            this.listeners.add(torrentListener);
        }
    }

    public void removeListener(TorrentListener torrentListener) {
        if (torrentListener != null) {
            this.listeners.remove(torrentListener);
        }
    }

    /* loaded from: classes2.dex */
    protected class InternalTorrentListener implements TorrentListener {
        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamStopped() {
        }

        protected InternalTorrentListener() {
        }

        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamStarted(final Torrent torrent) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.InternalTorrentListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        torrentListener.onStreamStarted(torrent);
                    }
                });
            }
        }

        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamError(final Torrent torrent, final Exception exc) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.InternalTorrentListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        torrentListener.onStreamError(torrent, exc);
                    }
                });
            }
        }

        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamReady(final Torrent torrent) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.InternalTorrentListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        torrentListener.onStreamReady(torrent);
                    }
                });
            }
        }

        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamProgress(final Torrent torrent, final StreamStatus streamStatus) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.InternalTorrentListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        torrentListener.onStreamProgress(torrent, streamStatus);
                    }
                });
            }
        }

        @Override // com.github.se_bastiaan.torrentstream.listeners.TorrentListener
        public void onStreamPrepared(final Torrent torrent) {
            if (TorrentStream.this.torrentOptions.autoDownload.booleanValue()) {
                torrent.startDownload();
            }
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.github.se_bastiaan.torrentstream.TorrentStream.InternalTorrentListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        torrentListener.onStreamPrepared(torrent);
                    }
                });
            }
        }
    }
}
