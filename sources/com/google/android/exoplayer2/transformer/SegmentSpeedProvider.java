package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class SegmentSpeedProvider implements SpeedProvider {
    private static final int INPUT_FRAME_RATE = 30;
    private final float baseSpeedMultiplier;
    private final ImmutableSortedMap<Long, Float> speedsByStartTimeUs;

    public SegmentSpeedProvider(Format format) {
        float captureFrameRate = getCaptureFrameRate(format);
        float f = captureFrameRate == -3.4028235E38f ? 1.0f : captureFrameRate / 30.0f;
        this.baseSpeedMultiplier = f;
        this.speedsByStartTimeUs = buildSpeedByStartTimeUsMap(format, f);
    }

    @Override // com.google.android.exoplayer2.transformer.SpeedProvider
    public float getSpeed(long j) {
        Assertions.checkArgument(j >= 0);
        Map.Entry<Long, Float> floorEntry = this.speedsByStartTimeUs.floorEntry(Long.valueOf(j));
        return floorEntry != null ? floorEntry.getValue().floatValue() : this.baseSpeedMultiplier;
    }

    private static ImmutableSortedMap<Long, Float> buildSpeedByStartTimeUsMap(Format format, float f) {
        ImmutableList<SlowMotionData.Segment> extractSlowMotionSegments = extractSlowMotionSegments(format);
        if (extractSlowMotionSegments.isEmpty()) {
            return ImmutableSortedMap.m240of();
        }
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < extractSlowMotionSegments.size(); i++) {
            SlowMotionData.Segment segment = extractSlowMotionSegments.get(i);
            treeMap.put(Long.valueOf(Util.msToUs(segment.startTimeMs)), Float.valueOf(f / segment.speedDivisor));
        }
        for (int i2 = 0; i2 < extractSlowMotionSegments.size(); i2++) {
            SlowMotionData.Segment segment2 = extractSlowMotionSegments.get(i2);
            if (!treeMap.containsKey(Long.valueOf(Util.msToUs(segment2.endTimeMs)))) {
                treeMap.put(Long.valueOf(Util.msToUs(segment2.endTimeMs)), Float.valueOf(f));
            }
        }
        return ImmutableSortedMap.copyOf((Map) treeMap);
    }

    private static float getCaptureFrameRate(Format format) {
        Metadata metadata = format.metadata;
        if (metadata == null) {
            return -3.4028235E38f;
        }
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof SmtaMetadataEntry) {
                return ((SmtaMetadataEntry) entry).captureFrameRate;
            }
        }
        return -3.4028235E38f;
    }

    private static ImmutableList<SlowMotionData.Segment> extractSlowMotionSegments(Format format) {
        ArrayList arrayList = new ArrayList();
        Metadata metadata = format.metadata;
        if (metadata != null) {
            for (int i = 0; i < metadata.length(); i++) {
                Metadata.Entry entry = metadata.get(i);
                if (entry instanceof SlowMotionData) {
                    arrayList.addAll(((SlowMotionData) entry).segments);
                }
            }
        }
        return ImmutableList.sortedCopyOf(SlowMotionData.Segment.BY_START_THEN_END_THEN_DIVISOR, arrayList);
    }
}
