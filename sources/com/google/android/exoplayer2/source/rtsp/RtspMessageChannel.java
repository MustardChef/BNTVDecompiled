package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RtspMessageChannel implements Closeable {
    public static final Charset CHARSET = Charsets.UTF_8;
    public static final int DEFAULT_RTSP_PORT = 554;
    private static final String TAG = "RtspMessageChannel";
    private volatile boolean closed;
    private final MessageListener messageListener;
    private Sender sender;
    private Socket socket;
    private final Loader receiverLoader = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");
    private final Map<Integer, InterleavedBinaryDataListener> interleavedBinaryDataListeners = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes2.dex */
    public interface InterleavedBinaryDataListener {
        void onInterleavedBinaryDataReceived(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface MessageListener {

        /* renamed from: com.google.android.exoplayer2.source.rtsp.RtspMessageChannel$MessageListener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onReceivingFailed(MessageListener messageListener, Exception exc) {
            }

            public static void $default$onSendingFailed(MessageListener messageListener, List list, Exception exc) {
            }
        }

        void onReceivingFailed(Exception exc);

        void onRtspMessageReceived(List<String> list);

        void onSendingFailed(List<String> list, Exception exc);
    }

    public RtspMessageChannel(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    public void open(Socket socket) throws IOException {
        this.socket = socket;
        this.sender = new Sender(socket.getOutputStream());
        this.receiverLoader.startLoading(new Receiver(socket.getInputStream()), new LoaderCallbackImpl(), 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            Sender sender = this.sender;
            if (sender != null) {
                sender.close();
            }
            this.receiverLoader.release();
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } finally {
            this.closed = true;
        }
    }

    public void send(List<String> list) {
        Assertions.checkStateNotNull(this.sender);
        this.sender.send(list);
    }

    public void registerInterleavedBinaryDataListener(int i, InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.interleavedBinaryDataListeners.put(Integer.valueOf(i), interleavedBinaryDataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class Sender implements Closeable {
        private final OutputStream outputStream;
        private final HandlerThread senderThread;
        private final Handler senderThreadHandler;

        public Sender(OutputStream outputStream) {
            this.outputStream = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.senderThread = handlerThread;
            handlerThread.start();
            this.senderThreadHandler = new Handler(handlerThread.getLooper());
        }

        public void send(final List<String> list) {
            final byte[] convertMessageToByteArray = RtspMessageUtil.convertMessageToByteArray(list);
            this.senderThreadHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.-$$Lambda$RtspMessageChannel$Sender$qNc8ZA9RRSNbPVjujjJVM1pYJc0
                @Override // java.lang.Runnable
                public final void run() {
                    RtspMessageChannel.Sender.this.lambda$send$0$RtspMessageChannel$Sender(convertMessageToByteArray, list);
                }
            });
        }

        public /* synthetic */ void lambda$send$0$RtspMessageChannel$Sender(byte[] bArr, List list) {
            try {
                this.outputStream.write(bArr);
            } catch (Exception e) {
                if (RtspMessageChannel.this.closed) {
                    return;
                }
                RtspMessageChannel.this.messageListener.onSendingFailed(list, e);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.senderThreadHandler;
            final HandlerThread handlerThread = this.senderThread;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.-$$Lambda$7HecldtNx9CUzQpud0GqXIDuFH0
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.senderThread.join();
            } catch (InterruptedException unused) {
                this.senderThread.interrupt();
            }
        }
    }

    /* loaded from: classes2.dex */
    private final class Receiver implements Loader.Loadable {
        private static final byte INTERLEAVED_MESSAGE_MARKER = 36;
        private final DataInputStream dataInputStream;
        private volatile boolean loadCanceled;
        private final MessageParser messageParser = new MessageParser();

        public Receiver(InputStream inputStream) {
            this.dataInputStream = new DataInputStream(inputStream);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            while (!this.loadCanceled) {
                byte readByte = this.dataInputStream.readByte();
                if (readByte == 36) {
                    handleInterleavedBinaryData();
                } else {
                    handleRtspMessage(readByte);
                }
            }
        }

        private void handleRtspMessage(byte b) throws IOException {
            if (RtspMessageChannel.this.closed) {
                return;
            }
            RtspMessageChannel.this.messageListener.onRtspMessageReceived(this.messageParser.parseNext(b, this.dataInputStream));
        }

        private void handleInterleavedBinaryData() throws IOException {
            int readUnsignedByte = this.dataInputStream.readUnsignedByte();
            int readUnsignedShort = this.dataInputStream.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.dataInputStream.readFully(bArr, 0, readUnsignedShort);
            InterleavedBinaryDataListener interleavedBinaryDataListener = (InterleavedBinaryDataListener) RtspMessageChannel.this.interleavedBinaryDataListeners.get(Integer.valueOf(readUnsignedByte));
            if (interleavedBinaryDataListener == null || RtspMessageChannel.this.closed) {
                return;
            }
            interleavedBinaryDataListener.onInterleavedBinaryDataReceived(bArr);
        }
    }

    /* loaded from: classes2.dex */
    private final class LoaderCallbackImpl implements Loader.Callback<Receiver> {
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(Receiver receiver, long j, long j2, boolean z) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(Receiver receiver, long j, long j2) {
        }

        private LoaderCallbackImpl() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(Receiver receiver, long j, long j2, IOException iOException, int i) {
            if (!RtspMessageChannel.this.closed) {
                RtspMessageChannel.this.messageListener.onReceivingFailed(iOException);
            }
            return Loader.DONT_RETRY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MessageParser {
        private static final int STATE_READING_BODY = 3;
        private static final int STATE_READING_FIRST_LINE = 1;
        private static final int STATE_READING_HEADER = 2;
        private long messageBodyLength;
        private final List<String> messageLines = new ArrayList();
        private int state = 1;

        public ImmutableList<String> parseNext(byte b, DataInputStream dataInputStream) throws IOException {
            ImmutableList<String> addMessageLine = addMessageLine(parseNextLine(b, dataInputStream));
            while (addMessageLine == null) {
                if (this.state == 3) {
                    long j = this.messageBodyLength;
                    if (j > 0) {
                        int checkedCast = Ints.checkedCast(j);
                        Assertions.checkState(checkedCast != -1);
                        byte[] bArr = new byte[checkedCast];
                        dataInputStream.readFully(bArr, 0, checkedCast);
                        addMessageLine = addMessageBody(bArr);
                    } else {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                } else {
                    addMessageLine = addMessageLine(parseNextLine(dataInputStream.readByte(), dataInputStream));
                }
            }
            return addMessageLine;
        }

        private static byte[] parseNextLine(byte b, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] != 13 || bArr[1] != 10) {
                    bArr[0] = bArr[1];
                    bArr[1] = dataInputStream.readByte();
                    byteArrayOutputStream.write(bArr[1]);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }

        private ImmutableList<String> addMessageLine(byte[] bArr) throws ParserException {
            Assertions.checkArgument(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, RtspMessageChannel.CHARSET);
            this.messageLines.add(str);
            int i = this.state;
            if (i == 1) {
                if (RtspMessageUtil.isRtspStartLine(str)) {
                    this.state = 2;
                    return null;
                }
                return null;
            } else if (i == 2) {
                long parseContentLengthHeader = RtspMessageUtil.parseContentLengthHeader(str);
                if (parseContentLengthHeader != -1) {
                    this.messageBodyLength = parseContentLengthHeader;
                }
                if (str.isEmpty()) {
                    if (this.messageBodyLength > 0) {
                        this.state = 3;
                        return null;
                    }
                    ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) this.messageLines);
                    reset();
                    return copyOf;
                }
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        private ImmutableList<String> addMessageBody(byte[] bArr) {
            String str;
            Assertions.checkState(this.state == 3);
            if (bArr.length > 0 && bArr[bArr.length - 1] == 10) {
                if (bArr.length > 1 && bArr[bArr.length - 2] == 13) {
                    str = new String(bArr, 0, bArr.length - 2, RtspMessageChannel.CHARSET);
                } else {
                    str = new String(bArr, 0, bArr.length - 1, RtspMessageChannel.CHARSET);
                }
                this.messageLines.add(str);
                ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) this.messageLines);
                reset();
                return copyOf;
            }
            throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
        }

        private void reset() {
            this.messageLines.clear();
            this.state = 1;
            this.messageBodyLength = 0L;
        }
    }
}
