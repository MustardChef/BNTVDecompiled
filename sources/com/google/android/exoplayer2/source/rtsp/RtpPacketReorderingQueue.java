package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.audio.WavUtil;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class RtpPacketReorderingQueue {
    static final int MAX_SEQUENCE_LEAP_ALLOWED = 1000;
    private static final int MAX_SEQUENCE_NUMBER = 65535;
    private static final int QUEUE_SIZE_THRESHOLD_FOR_RESET = 5000;
    private int lastDequeuedSequenceNumber;
    private int lastReceivedSequenceNumber;
    private final TreeSet<RtpPacketContainer> packetQueue = new TreeSet<>($$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk.INSTANCE);
    private boolean started;

    public RtpPacketReorderingQueue() {
        reset();
    }

    public synchronized void reset() {
        this.packetQueue.clear();
        this.started = false;
        this.lastDequeuedSequenceNumber = -1;
        this.lastReceivedSequenceNumber = -1;
    }

    public synchronized boolean offer(RtpPacket rtpPacket, long j) {
        if (this.packetQueue.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i = rtpPacket.sequenceNumber;
        if (!this.started) {
            reset();
            this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
            this.started = true;
            addToQueue(new RtpPacketContainer(rtpPacket, j));
            return true;
        } else if (Math.abs(calculateSequenceNumberShift(i, nextSequenceNumber(this.lastReceivedSequenceNumber))) < 1000) {
            if (calculateSequenceNumberShift(i, this.lastDequeuedSequenceNumber) > 0) {
                addToQueue(new RtpPacketContainer(rtpPacket, j));
                return true;
            }
            return false;
        } else {
            this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
            this.packetQueue.clear();
            addToQueue(new RtpPacketContainer(rtpPacket, j));
            return true;
        }
    }

    public synchronized RtpPacket poll(long j) {
        if (this.packetQueue.isEmpty()) {
            return null;
        }
        RtpPacketContainer first = this.packetQueue.first();
        int i = first.packet.sequenceNumber;
        if (i == nextSequenceNumber(this.lastDequeuedSequenceNumber) || j >= first.receivedTimestampMs) {
            this.packetQueue.pollFirst();
            this.lastDequeuedSequenceNumber = i;
            return first.packet;
        }
        return null;
    }

    private synchronized void addToQueue(RtpPacketContainer rtpPacketContainer) {
        this.lastReceivedSequenceNumber = rtpPacketContainer.packet.sequenceNumber;
        this.packetQueue.add(rtpPacketContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class RtpPacketContainer {
        public final RtpPacket packet;
        public final long receivedTimestampMs;

        public RtpPacketContainer(RtpPacket rtpPacket, long j) {
            this.packet = rtpPacket;
            this.receivedTimestampMs = j;
        }
    }

    private static int nextSequenceNumber(int i) {
        return (i + 1) % 65535;
    }

    private static int prevSequenceNumber(int i) {
        return i == 0 ? WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE : (i - 1) % 65535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateSequenceNumberShift(int i, int i2) {
        int min;
        int i3 = i - i2;
        return (Math.abs(i3) <= 1000 || (min = (Math.min(i, i2) - Math.max(i, i2)) + 65535) >= 1000) ? i3 : i < i2 ? min : -min;
    }
}
