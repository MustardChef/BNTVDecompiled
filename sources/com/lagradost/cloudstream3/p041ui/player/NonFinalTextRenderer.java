package com.lagradost.cloudstream3.p041ui.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* compiled from: NonFinalTextRenderer.kt */
@Metadata(m108d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002HIB%\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020&H\u0002J\u0016\u00100\u001a\u00020&2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\b\u00106\u001a\u00020&H\u0014J\u0018\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0015H\u0014J+\u0010:\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\"0<2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0018\u0010B\u001a\u00020&2\u0006\u00108\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020&H\u0002J\u0010\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\"H\u0016J\u0016\u0010G\u001a\u00020&2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/NonFinalTextRenderer;", "Lcom/google/android/exoplayer2/BaseRenderer;", "Landroid/os/Handler$Callback;", AgentOptions.OUTPUT, "Lcom/google/android/exoplayer2/text/TextOutput;", "outputLooper", "Landroid/os/Looper;", "decoderFactory", "Lcom/google/android/exoplayer2/text/SubtitleDecoderFactory;", "(Lcom/google/android/exoplayer2/text/TextOutput;Landroid/os/Looper;Lcom/google/android/exoplayer2/text/SubtitleDecoderFactory;)V", "decoder", "Lcom/google/android/exoplayer2/text/SubtitleDecoder;", "decoderReplacementState", "", "getDecoderReplacementState$annotations", "()V", "finalStreamEndPositionUs", "", "formatHold", "Lcom/google/android/exoplayer2/FormatHolder;", "inputStreamEnded", "", "nextEventTime", "getNextEventTime", "()J", "nextInputBuffer", "Lcom/google/android/exoplayer2/text/SubtitleInputBuffer;", "nextSubtitle", "Lcom/google/android/exoplayer2/text/SubtitleOutputBuffer;", "nextSubtitleEventIndex", "outputHandler", "Landroid/os/Handler;", "outputStreamEnded", "streamFormat", "Lcom/google/android/exoplayer2/Format;", "subtitle", "waitingForKeyFrame", "clearOutput", "", "getName", "", "handleDecoderError", "e", "Lcom/google/android/exoplayer2/text/SubtitleDecoderException;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "initDecoder", "invokeUpdateOutputInternal", "cues", "", "Lcom/google/android/exoplayer2/text/Cue;", "isEnded", "isReady", "onDisabled", "onPositionReset", "positionUs", "joining", "onStreamChanged", "formats", "", "startPositionUs", "offsetUs", "([Lcom/google/android/exoplayer2/Format;JJ)V", "releaseBuffers", "releaseDecoder", "render", "elapsedRealtimeUs", "replaceDecoder", "supportsFormat", "format", "updateOutput", "Companion", "ReplacementState", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.NonFinalTextRenderer */
/* loaded from: classes3.dex */
public class NonFinalTextRenderer extends BaseRenderer implements Handler.Callback {
    public static final Companion Companion = new Companion(null);
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private long finalStreamEndPositionUs;
    private final FormatHolder formatHold;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;
    private boolean waitingForKeyFrame;

    /* compiled from: NonFinalTextRenderer.kt */
    @MustBeDocumented
    @Metadata(m108d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/NonFinalTextRenderer$ReplacementState;", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* renamed from: com.lagradost.cloudstream3.ui.player.NonFinalTextRenderer$ReplacementState */
    /* loaded from: classes3.dex */
    private @interface ReplacementState {
    }

    public NonFinalTextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, null, 4, null);
    }

    private static /* synthetic */ void getDecoderReplacementState$annotations() {
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ NonFinalTextRenderer(com.google.android.exoplayer2.text.TextOutput r1, android.os.Looper r2, com.google.android.exoplayer2.text.SubtitleDecoderFactory r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto Lb
            com.google.android.exoplayer2.text.SubtitleDecoderFactory r3 = com.google.android.exoplayer2.text.SubtitleDecoderFactory.DEFAULT
            java.lang.String r4 = "DEFAULT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        Lb:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.NonFinalTextRenderer.<init>(com.google.android.exoplayer2.text.TextOutput, android.os.Looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonFinalTextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory decoderFactory) {
        super(3);
        Intrinsics.checkNotNullParameter(decoderFactory, "decoderFactory");
        this.decoderFactory = decoderFactory;
        this.outputHandler = looper == null ? null : Util.createHandler(looper, this);
        Object checkNotNull = Assertions.checkNotNull(textOutput);
        Intrinsics.checkNotNullExpressionValue(checkNotNull, "checkNotNull(output)");
        this.output = (TextOutput) checkNotNull;
        this.formatHold = new FormatHolder();
        this.finalStreamEndPositionUs = C3282C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (this.decoderFactory.supportsFormat(format)) {
            return RendererCapabilities.CC.create(format.cryptoType == 0 ? 4 : 2);
        } else if (MimeTypes.isText(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(1);
        } else {
            return RendererCapabilities.CC.create(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formats, long j, long j2) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.streamFormat = formats[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            initDecoder();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.finalStreamEndPositionUs = C3282C.TIME_UNSET;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
            return;
        }
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).flush();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean z;
        if (isCurrentStreamFinal()) {
            long j3 = this.finalStreamEndPositionUs;
            if (j3 != C3282C.TIME_UNSET && j >= j3) {
                releaseBuffers();
                this.outputStreamEnded = true;
            }
        }
        if (this.outputStreamEnded) {
            return;
        }
        if (this.nextSubtitle == null) {
            ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).setPositionUs(j);
            try {
                this.nextSubtitle = ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                handleDecoderError(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z = false;
            while (nextEventTime <= j) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z = true;
            }
        } else {
            z = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
        if (subtitleOutputBuffer != null) {
            Intrinsics.checkNotNull(subtitleOutputBuffer);
            if (subtitleOutputBuffer.isEndOfStream()) {
                if (!z && getNextEventTime() == Long.MAX_VALUE) {
                    if (this.decoderReplacementState == 2) {
                        replaceDecoder();
                    } else {
                        releaseBuffers();
                        this.outputStreamEnded = true;
                    }
                }
            } else if (subtitleOutputBuffer.timeUs <= j) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                if (subtitleOutputBuffer2 != null) {
                    Intrinsics.checkNotNull(subtitleOutputBuffer2);
                    subtitleOutputBuffer2.release();
                }
                this.nextSubtitleEventIndex = subtitleOutputBuffer.getNextEventTimeIndex(j);
                this.subtitle = subtitleOutputBuffer;
                this.nextSubtitle = null;
                z = true;
            }
        }
        if (z) {
            Assertions.checkNotNull(this.subtitle);
            SubtitleOutputBuffer subtitleOutputBuffer3 = this.subtitle;
            Intrinsics.checkNotNull(subtitleOutputBuffer3);
            List<Cue> cues = subtitleOutputBuffer3.getCues(j);
            Intrinsics.checkNotNullExpressionValue(cues, "subtitle!!.getCues(positionUs)");
            updateOutput(cues);
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                SubtitleInputBuffer subtitleInputBuffer = this.nextInputBuffer;
                if (subtitleInputBuffer == null) {
                    subtitleInputBuffer = ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueInputBuffer();
                    if (subtitleInputBuffer == null) {
                        return;
                    }
                    this.nextInputBuffer = subtitleInputBuffer;
                }
                if (this.decoderReplacementState == 1) {
                    subtitleInputBuffer.setFlags(4);
                    ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = 2;
                    return;
                }
                int readSource = readSource(this.formatHold, subtitleInputBuffer, 0);
                if (readSource == -4) {
                    if (subtitleInputBuffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                        this.waitingForKeyFrame = false;
                    } else {
                        Format format = this.formatHold.format;
                        if (format == null) {
                            return;
                        }
                        subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                        subtitleInputBuffer.flip();
                        this.waitingForKeyFrame &= !subtitleInputBuffer.isKeyFrame();
                    }
                    if (!this.waitingForKeyFrame) {
                        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                        this.nextInputBuffer = null;
                    }
                } else if (readSource == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                handleDecoderError(e2);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.streamFormat = null;
        this.finalStreamEndPositionUs = C3282C.TIME_UNSET;
        clearOutput();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    private final void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            Intrinsics.checkNotNull(subtitleOutputBuffer);
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            Intrinsics.checkNotNull(subtitleOutputBuffer2);
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private final void releaseDecoder() {
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private final void initDecoder() {
        this.waitingForKeyFrame = true;
        this.decoder = this.decoderFactory.createDecoder((Format) Assertions.checkNotNull(this.streamFormat));
    }

    private final void replaceDecoder() {
        releaseDecoder();
        initDecoder();
    }

    private final long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.subtitle);
        int i = this.nextSubtitleEventIndex;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        Intrinsics.checkNotNull(subtitleOutputBuffer);
        if (i >= subtitleOutputBuffer.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
        Intrinsics.checkNotNull(subtitleOutputBuffer2);
        return subtitleOutputBuffer2.getEventTime(this.nextSubtitleEventIndex);
    }

    private final void updateOutput(List<Cue> list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    private final void clearOutput() {
        updateOutput(CollectionsKt.emptyList());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 0) {
            Object obj = msg.obj;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.google.android.exoplayer2.text.Cue>");
            invokeUpdateOutputInternal((List) obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private final void invokeUpdateOutputInternal(List<Cue> list) {
        TextOutput textOutput = this.output;
        List<Cue> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Cue cue : list2) {
            arrayList.add(cue.buildUpon().setSize(-3.4028235E38f).build());
        }
        textOutput.onCues(arrayList);
    }

    private final void handleDecoderError(SubtitleDecoderException subtitleDecoderException) {
        Log.m382e(TAG, "Subtitle decoding failed. streamFormat=" + this.streamFormat, subtitleDecoderException);
        clearOutput();
        replaceDecoder();
    }

    /* compiled from: NonFinalTextRenderer.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/NonFinalTextRenderer$Companion;", "", "()V", "MSG_UPDATE_OUTPUT", "", "REPLACEMENT_STATE_NONE", "REPLACEMENT_STATE_SIGNAL_END_OF_STREAM", "REPLACEMENT_STATE_WAIT_END_OF_STREAM", "TAG", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.NonFinalTextRenderer$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
