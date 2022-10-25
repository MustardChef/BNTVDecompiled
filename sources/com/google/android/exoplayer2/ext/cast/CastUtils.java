package com.google.android.exoplayer2.ext.cast;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;

/* loaded from: classes2.dex */
final class CastUtils {
    private static final long LIVE_STREAM_DURATION = -1000;

    public static long getStreamDurationUs(MediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return C3282C.TIME_UNSET;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        return (streamDuration == -1 || streamDuration == LIVE_STREAM_DURATION) ? C3282C.TIME_UNSET : Util.msToUs(streamDuration);
    }

    public static String getLogString(int i) {
        if (i != 0) {
            if (i != 2100) {
                if (i != 2103) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 2200) {
                                if (i != 2201) {
                                    switch (i) {
                                        case 13:
                                            return "An unknown, unexpected error has occurred.";
                                        case 14:
                                            return "A blocking call was interrupted while waiting and did not run to completion.";
                                        case 15:
                                            return "An operation has timed out.";
                                        default:
                                            switch (i) {
                                                case 2000:
                                                    return "Authentication failure.";
                                                case 2001:
                                                    return "An invalid request was made.";
                                                case 2002:
                                                    return "An in-progress request has been canceled, most likely because another action has preempted it.";
                                                case 2003:
                                                    return "The request was disallowed and could not be completed.";
                                                case 2004:
                                                    return "A requested application could not be found.";
                                                case 2005:
                                                    return "A requested application is not currently running.";
                                                case 2006:
                                                    return "A message could not be sent because it is too large.";
                                                case 2007:
                                                    return "A message could not be sent because there is not enough room in the send buffer at this time.";
                                                default:
                                                    return CastStatusCodes.getStatusCodeString(i);
                                            }
                                    }
                                }
                                return "The Cast Remote Display service was disconnected.";
                            }
                            return "The Cast Remote Display service could not be created.";
                        }
                        return "An internal error has occurred.";
                    }
                    return "Network I/O error.";
                }
                return "The request's progress is no longer being tracked because another request of the same type has been made before the first request completed.";
            }
            return "The in-progress request failed.";
        }
        return "Success.";
    }

    public static Format mediaTrackToFormat(MediaTrack mediaTrack) {
        return new Format.Builder().setId(mediaTrack.getContentId()).setContainerMimeType(mediaTrack.getContentType()).setLanguage(mediaTrack.getLanguage()).build();
    }

    private CastUtils() {
    }
}
