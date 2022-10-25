package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0003\b\u0080\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0005\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0001\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0001\u0010?\u001a\u0004\u0018\u00010@¢\u0006\u0002\u0010AJ\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u000107HÆ\u0003¢\u0006\u0002\u0010YJ\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010@HÆ\u0003¢\u0006\u0002\u0010_J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÔ\u0005\u0010¾\u0001\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00106\u001a\u0004\u0018\u0001072\n\b\u0003\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0003\u0010?\u001a\u0004\u0018\u00010@HÆ\u0001¢\u0006\u0003\u0010¿\u0001J\u0016\u0010À\u0001\u001a\u00030Á\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ã\u0001\u001a\u000207HÖ\u0001J\n\u0010Ä\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010CR\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010CR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010CR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010CR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010CR\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010CR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010CR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010CR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010CR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010CR\u0013\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010CR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010CR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010CR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010CR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010CR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010CR\u0015\u00106\u001a\u0004\u0018\u000107¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR\u0013\u0010<\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010CR\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0015\u0010?\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0002\u0010`\u001a\u0004\b^\u0010_R\u0013\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010CR\u0013\u00101\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010CR\u0013\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010CR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010CR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010CR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010CR\u0013\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010CR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bh\u0010CR\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010CR\u0013\u00109\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010CR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010CR\u0013\u00102\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010CR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010CR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010CR\u0013\u00104\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bo\u0010CR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010CR\u0013\u00105\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010CR\u0013\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010CR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bs\u0010CR\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bt\u0010CR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bu\u0010CR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010CR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010CR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010CR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010CR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010CR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010CR\u0013\u00108\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010CR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010CR\u0013\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010CR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010CR\u0014\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010CR\u0014\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010CR\u0014\u0010:\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010C¨\u0006Å\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;", "", "MatchedBy", "", "IDSubMovieFile", "MovieHash", "MovieByteSize", "MovieTimeMS", "IDSubtitleFile", "SubFileName", "SubActualCD", "SubSize", "SubHash", "SubLastTS", "SubTSGroup", "InfoReleaseGroup", "InfoFormat", "InfoOther", "IDSubtitle", "UserID", "SubLanguageID", "SubFormat", "SubSumCD", "SubAuthorComment", "SubAddDate", "SubBad", "SubRating", "SubSumVotes", "SubDownloadsCnt", "MovieReleaseName", "MovieFPS", "IDMovie", "IDMovieImdb", "MovieName", "MovieNameEng", "MovieYear", "MovieImdbRating", "SubFeatured", "UserNickName", "SubTranslator", "ISO639", "LanguageName", "SubComments", "SubHearingImpaired", "UserRank", "SeriesSeason", "SeriesEpisode", "MovieKind", "SubHD", "SeriesIMDBParent", "SubEncoding", "SubAutoTranslation", "SubForeignPartsOnly", "SubFromTrusted", "QueryCached", "", "SubTSGroupHash", "SubDownloadLink", "ZipDownloadLink", "SubtitlesLink", "QueryNumber", "QueryParameters", "Lcom/lagradost/cloudstream3/movieproviders/QueryParameters;", "Score", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/QueryParameters;Ljava/lang/Double;)V", "getIDMovie", "()Ljava/lang/String;", "getIDMovieImdb", "getIDSubMovieFile", "getIDSubtitle", "getIDSubtitleFile", "getISO639", "getInfoFormat", "getInfoOther", "getInfoReleaseGroup", "getLanguageName", "getMatchedBy", "getMovieByteSize", "getMovieFPS", "getMovieHash", "getMovieImdbRating", "getMovieKind", "getMovieName", "getMovieNameEng", "getMovieReleaseName", "getMovieTimeMS", "getMovieYear", "getQueryCached", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQueryNumber", "getQueryParameters", "()Lcom/lagradost/cloudstream3/movieproviders/QueryParameters;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSeriesEpisode", "getSeriesIMDBParent", "getSeriesSeason", "getSubActualCD", "getSubAddDate", "getSubAuthorComment", "getSubAutoTranslation", "getSubBad", "getSubComments", "getSubDownloadLink", "getSubDownloadsCnt", "getSubEncoding", "getSubFeatured", "getSubFileName", "getSubForeignPartsOnly", "getSubFormat", "getSubFromTrusted", "getSubHD", "getSubHash", "getSubHearingImpaired", "getSubLanguageID", "getSubLastTS", "getSubRating", "getSubSize", "getSubSumCD", "getSubSumVotes", "getSubTSGroup", "getSubTSGroupHash", "getSubTranslator", "getSubtitlesLink", "getUserID", "getUserNickName", "getUserRank", "getZipDownloadLink", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/QueryParameters;Ljava/lang/Double;)Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MetaInfo {
    private final String IDMovie;
    private final String IDMovieImdb;
    private final String IDSubMovieFile;
    private final String IDSubtitle;
    private final String IDSubtitleFile;
    private final String ISO639;
    private final String InfoFormat;
    private final String InfoOther;
    private final String InfoReleaseGroup;
    private final String LanguageName;
    private final String MatchedBy;
    private final String MovieByteSize;
    private final String MovieFPS;
    private final String MovieHash;
    private final String MovieImdbRating;
    private final String MovieKind;
    private final String MovieName;
    private final String MovieNameEng;
    private final String MovieReleaseName;
    private final String MovieTimeMS;
    private final String MovieYear;
    private final Integer QueryCached;
    private final String QueryNumber;
    private final QueryParameters QueryParameters;
    private final Double Score;
    private final String SeriesEpisode;
    private final String SeriesIMDBParent;
    private final String SeriesSeason;
    private final String SubActualCD;
    private final String SubAddDate;
    private final String SubAuthorComment;
    private final String SubAutoTranslation;
    private final String SubBad;
    private final String SubComments;
    private final String SubDownloadLink;
    private final String SubDownloadsCnt;
    private final String SubEncoding;
    private final String SubFeatured;
    private final String SubFileName;
    private final String SubForeignPartsOnly;
    private final String SubFormat;
    private final String SubFromTrusted;
    private final String SubHD;
    private final String SubHash;
    private final String SubHearingImpaired;
    private final String SubLanguageID;
    private final String SubLastTS;
    private final String SubRating;
    private final String SubSize;
    private final String SubSumCD;
    private final String SubSumVotes;
    private final String SubTSGroup;
    private final String SubTSGroupHash;
    private final String SubTranslator;
    private final String SubtitlesLink;
    private final String UserID;
    private final String UserNickName;
    private final String UserRank;
    private final String ZipDownloadLink;

    public final String component1() {
        return this.MatchedBy;
    }

    public final String component10() {
        return this.SubHash;
    }

    public final String component11() {
        return this.SubLastTS;
    }

    public final String component12() {
        return this.SubTSGroup;
    }

    public final String component13() {
        return this.InfoReleaseGroup;
    }

    public final String component14() {
        return this.InfoFormat;
    }

    public final String component15() {
        return this.InfoOther;
    }

    public final String component16() {
        return this.IDSubtitle;
    }

    public final String component17() {
        return this.UserID;
    }

    public final String component18() {
        return this.SubLanguageID;
    }

    public final String component19() {
        return this.SubFormat;
    }

    public final String component2() {
        return this.IDSubMovieFile;
    }

    public final String component20() {
        return this.SubSumCD;
    }

    public final String component21() {
        return this.SubAuthorComment;
    }

    public final String component22() {
        return this.SubAddDate;
    }

    public final String component23() {
        return this.SubBad;
    }

    public final String component24() {
        return this.SubRating;
    }

    public final String component25() {
        return this.SubSumVotes;
    }

    public final String component26() {
        return this.SubDownloadsCnt;
    }

    public final String component27() {
        return this.MovieReleaseName;
    }

    public final String component28() {
        return this.MovieFPS;
    }

    public final String component29() {
        return this.IDMovie;
    }

    public final String component3() {
        return this.MovieHash;
    }

    public final String component30() {
        return this.IDMovieImdb;
    }

    public final String component31() {
        return this.MovieName;
    }

    public final String component32() {
        return this.MovieNameEng;
    }

    public final String component33() {
        return this.MovieYear;
    }

    public final String component34() {
        return this.MovieImdbRating;
    }

    public final String component35() {
        return this.SubFeatured;
    }

    public final String component36() {
        return this.UserNickName;
    }

    public final String component37() {
        return this.SubTranslator;
    }

    public final String component38() {
        return this.ISO639;
    }

    public final String component39() {
        return this.LanguageName;
    }

    public final String component4() {
        return this.MovieByteSize;
    }

    public final String component40() {
        return this.SubComments;
    }

    public final String component41() {
        return this.SubHearingImpaired;
    }

    public final String component42() {
        return this.UserRank;
    }

    public final String component43() {
        return this.SeriesSeason;
    }

    public final String component44() {
        return this.SeriesEpisode;
    }

    public final String component45() {
        return this.MovieKind;
    }

    public final String component46() {
        return this.SubHD;
    }

    public final String component47() {
        return this.SeriesIMDBParent;
    }

    public final String component48() {
        return this.SubEncoding;
    }

    public final String component49() {
        return this.SubAutoTranslation;
    }

    public final String component5() {
        return this.MovieTimeMS;
    }

    public final String component50() {
        return this.SubForeignPartsOnly;
    }

    public final String component51() {
        return this.SubFromTrusted;
    }

    public final Integer component52() {
        return this.QueryCached;
    }

    public final String component53() {
        return this.SubTSGroupHash;
    }

    public final String component54() {
        return this.SubDownloadLink;
    }

    public final String component55() {
        return this.ZipDownloadLink;
    }

    public final String component56() {
        return this.SubtitlesLink;
    }

    public final String component57() {
        return this.QueryNumber;
    }

    public final QueryParameters component58() {
        return this.QueryParameters;
    }

    public final Double component59() {
        return this.Score;
    }

    public final String component6() {
        return this.IDSubtitleFile;
    }

    public final String component7() {
        return this.SubFileName;
    }

    public final String component8() {
        return this.SubActualCD;
    }

    public final String component9() {
        return this.SubSize;
    }

    public final MetaInfo copy(@JsonProperty("MatchedBy") String str, @JsonProperty("IDSubMovieFile") String str2, @JsonProperty("MovieHash") String str3, @JsonProperty("MovieByteSize") String str4, @JsonProperty("MovieTimeMS") String str5, @JsonProperty("IDSubtitleFile") String str6, @JsonProperty("SubFileName") String str7, @JsonProperty("SubActualCD") String str8, @JsonProperty("SubSize") String str9, @JsonProperty("SubHash") String str10, @JsonProperty("SubLastTS") String str11, @JsonProperty("SubTSGroup") String str12, @JsonProperty("InfoReleaseGroup") String str13, @JsonProperty("InfoFormat") String str14, @JsonProperty("InfoOther") String str15, @JsonProperty("IDSubtitle") String str16, @JsonProperty("UserID") String str17, @JsonProperty("SubLanguageID") String str18, @JsonProperty("SubFormat") String str19, @JsonProperty("SubSumCD") String str20, @JsonProperty("SubAuthorComment") String str21, @JsonProperty("SubAddDate") String str22, @JsonProperty("SubBad") String str23, @JsonProperty("SubRating") String str24, @JsonProperty("SubSumVotes") String str25, @JsonProperty("SubDownloadsCnt") String str26, @JsonProperty("MovieReleaseName") String str27, @JsonProperty("MovieFPS") String str28, @JsonProperty("IDMovie") String str29, @JsonProperty("IDMovieImdb") String str30, @JsonProperty("MovieName") String str31, @JsonProperty("MovieNameEng") String str32, @JsonProperty("MovieYear") String str33, @JsonProperty("MovieImdbRating") String str34, @JsonProperty("SubFeatured") String str35, @JsonProperty("UserNickName") String str36, @JsonProperty("SubTranslator") String str37, @JsonProperty("ISO639") String str38, @JsonProperty("LanguageName") String str39, @JsonProperty("SubComments") String str40, @JsonProperty("SubHearingImpaired") String str41, @JsonProperty("UserRank") String str42, @JsonProperty("SeriesSeason") String str43, @JsonProperty("SeriesEpisode") String str44, @JsonProperty("MovieKind") String str45, @JsonProperty("SubHD") String str46, @JsonProperty("SeriesIMDBParent") String str47, @JsonProperty("SubEncoding") String str48, @JsonProperty("SubAutoTranslation") String str49, @JsonProperty("SubForeignPartsOnly") String str50, @JsonProperty("SubFromTrusted") String str51, @JsonProperty("QueryCached") Integer num, @JsonProperty("SubTSGroupHash") String str52, @JsonProperty("SubDownloadLink") String str53, @JsonProperty("ZipDownloadLink") String str54, @JsonProperty("SubtitlesLink") String str55, @JsonProperty("QueryNumber") String str56, @JsonProperty("QueryParameters") QueryParameters queryParameters, @JsonProperty("Score") Double d) {
        return new MetaInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, num, str52, str53, str54, str55, str56, queryParameters, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MetaInfo) {
            MetaInfo metaInfo = (MetaInfo) obj;
            return Intrinsics.areEqual(this.MatchedBy, metaInfo.MatchedBy) && Intrinsics.areEqual(this.IDSubMovieFile, metaInfo.IDSubMovieFile) && Intrinsics.areEqual(this.MovieHash, metaInfo.MovieHash) && Intrinsics.areEqual(this.MovieByteSize, metaInfo.MovieByteSize) && Intrinsics.areEqual(this.MovieTimeMS, metaInfo.MovieTimeMS) && Intrinsics.areEqual(this.IDSubtitleFile, metaInfo.IDSubtitleFile) && Intrinsics.areEqual(this.SubFileName, metaInfo.SubFileName) && Intrinsics.areEqual(this.SubActualCD, metaInfo.SubActualCD) && Intrinsics.areEqual(this.SubSize, metaInfo.SubSize) && Intrinsics.areEqual(this.SubHash, metaInfo.SubHash) && Intrinsics.areEqual(this.SubLastTS, metaInfo.SubLastTS) && Intrinsics.areEqual(this.SubTSGroup, metaInfo.SubTSGroup) && Intrinsics.areEqual(this.InfoReleaseGroup, metaInfo.InfoReleaseGroup) && Intrinsics.areEqual(this.InfoFormat, metaInfo.InfoFormat) && Intrinsics.areEqual(this.InfoOther, metaInfo.InfoOther) && Intrinsics.areEqual(this.IDSubtitle, metaInfo.IDSubtitle) && Intrinsics.areEqual(this.UserID, metaInfo.UserID) && Intrinsics.areEqual(this.SubLanguageID, metaInfo.SubLanguageID) && Intrinsics.areEqual(this.SubFormat, metaInfo.SubFormat) && Intrinsics.areEqual(this.SubSumCD, metaInfo.SubSumCD) && Intrinsics.areEqual(this.SubAuthorComment, metaInfo.SubAuthorComment) && Intrinsics.areEqual(this.SubAddDate, metaInfo.SubAddDate) && Intrinsics.areEqual(this.SubBad, metaInfo.SubBad) && Intrinsics.areEqual(this.SubRating, metaInfo.SubRating) && Intrinsics.areEqual(this.SubSumVotes, metaInfo.SubSumVotes) && Intrinsics.areEqual(this.SubDownloadsCnt, metaInfo.SubDownloadsCnt) && Intrinsics.areEqual(this.MovieReleaseName, metaInfo.MovieReleaseName) && Intrinsics.areEqual(this.MovieFPS, metaInfo.MovieFPS) && Intrinsics.areEqual(this.IDMovie, metaInfo.IDMovie) && Intrinsics.areEqual(this.IDMovieImdb, metaInfo.IDMovieImdb) && Intrinsics.areEqual(this.MovieName, metaInfo.MovieName) && Intrinsics.areEqual(this.MovieNameEng, metaInfo.MovieNameEng) && Intrinsics.areEqual(this.MovieYear, metaInfo.MovieYear) && Intrinsics.areEqual(this.MovieImdbRating, metaInfo.MovieImdbRating) && Intrinsics.areEqual(this.SubFeatured, metaInfo.SubFeatured) && Intrinsics.areEqual(this.UserNickName, metaInfo.UserNickName) && Intrinsics.areEqual(this.SubTranslator, metaInfo.SubTranslator) && Intrinsics.areEqual(this.ISO639, metaInfo.ISO639) && Intrinsics.areEqual(this.LanguageName, metaInfo.LanguageName) && Intrinsics.areEqual(this.SubComments, metaInfo.SubComments) && Intrinsics.areEqual(this.SubHearingImpaired, metaInfo.SubHearingImpaired) && Intrinsics.areEqual(this.UserRank, metaInfo.UserRank) && Intrinsics.areEqual(this.SeriesSeason, metaInfo.SeriesSeason) && Intrinsics.areEqual(this.SeriesEpisode, metaInfo.SeriesEpisode) && Intrinsics.areEqual(this.MovieKind, metaInfo.MovieKind) && Intrinsics.areEqual(this.SubHD, metaInfo.SubHD) && Intrinsics.areEqual(this.SeriesIMDBParent, metaInfo.SeriesIMDBParent) && Intrinsics.areEqual(this.SubEncoding, metaInfo.SubEncoding) && Intrinsics.areEqual(this.SubAutoTranslation, metaInfo.SubAutoTranslation) && Intrinsics.areEqual(this.SubForeignPartsOnly, metaInfo.SubForeignPartsOnly) && Intrinsics.areEqual(this.SubFromTrusted, metaInfo.SubFromTrusted) && Intrinsics.areEqual(this.QueryCached, metaInfo.QueryCached) && Intrinsics.areEqual(this.SubTSGroupHash, metaInfo.SubTSGroupHash) && Intrinsics.areEqual(this.SubDownloadLink, metaInfo.SubDownloadLink) && Intrinsics.areEqual(this.ZipDownloadLink, metaInfo.ZipDownloadLink) && Intrinsics.areEqual(this.SubtitlesLink, metaInfo.SubtitlesLink) && Intrinsics.areEqual(this.QueryNumber, metaInfo.QueryNumber) && Intrinsics.areEqual(this.QueryParameters, metaInfo.QueryParameters) && Intrinsics.areEqual((Object) this.Score, (Object) metaInfo.Score);
        }
        return false;
    }

    public int hashCode() {
        String str = this.MatchedBy;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.IDSubMovieFile;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.MovieHash;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.MovieByteSize;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.MovieTimeMS;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.IDSubtitleFile;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.SubFileName;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.SubActualCD;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.SubSize;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.SubHash;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.SubLastTS;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.SubTSGroup;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.InfoReleaseGroup;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.InfoFormat;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.InfoOther;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.IDSubtitle;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.UserID;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.SubLanguageID;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.SubFormat;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.SubSumCD;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.SubAuthorComment;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.SubAddDate;
        int hashCode22 = (hashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.SubBad;
        int hashCode23 = (hashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.SubRating;
        int hashCode24 = (hashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.SubSumVotes;
        int hashCode25 = (hashCode24 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.SubDownloadsCnt;
        int hashCode26 = (hashCode25 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.MovieReleaseName;
        int hashCode27 = (hashCode26 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.MovieFPS;
        int hashCode28 = (hashCode27 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.IDMovie;
        int hashCode29 = (hashCode28 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.IDMovieImdb;
        int hashCode30 = (hashCode29 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.MovieName;
        int hashCode31 = (hashCode30 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.MovieNameEng;
        int hashCode32 = (hashCode31 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.MovieYear;
        int hashCode33 = (hashCode32 + (str33 == null ? 0 : str33.hashCode())) * 31;
        String str34 = this.MovieImdbRating;
        int hashCode34 = (hashCode33 + (str34 == null ? 0 : str34.hashCode())) * 31;
        String str35 = this.SubFeatured;
        int hashCode35 = (hashCode34 + (str35 == null ? 0 : str35.hashCode())) * 31;
        String str36 = this.UserNickName;
        int hashCode36 = (hashCode35 + (str36 == null ? 0 : str36.hashCode())) * 31;
        String str37 = this.SubTranslator;
        int hashCode37 = (hashCode36 + (str37 == null ? 0 : str37.hashCode())) * 31;
        String str38 = this.ISO639;
        int hashCode38 = (hashCode37 + (str38 == null ? 0 : str38.hashCode())) * 31;
        String str39 = this.LanguageName;
        int hashCode39 = (hashCode38 + (str39 == null ? 0 : str39.hashCode())) * 31;
        String str40 = this.SubComments;
        int hashCode40 = (hashCode39 + (str40 == null ? 0 : str40.hashCode())) * 31;
        String str41 = this.SubHearingImpaired;
        int hashCode41 = (hashCode40 + (str41 == null ? 0 : str41.hashCode())) * 31;
        String str42 = this.UserRank;
        int hashCode42 = (hashCode41 + (str42 == null ? 0 : str42.hashCode())) * 31;
        String str43 = this.SeriesSeason;
        int hashCode43 = (hashCode42 + (str43 == null ? 0 : str43.hashCode())) * 31;
        String str44 = this.SeriesEpisode;
        int hashCode44 = (hashCode43 + (str44 == null ? 0 : str44.hashCode())) * 31;
        String str45 = this.MovieKind;
        int hashCode45 = (hashCode44 + (str45 == null ? 0 : str45.hashCode())) * 31;
        String str46 = this.SubHD;
        int hashCode46 = (hashCode45 + (str46 == null ? 0 : str46.hashCode())) * 31;
        String str47 = this.SeriesIMDBParent;
        int hashCode47 = (hashCode46 + (str47 == null ? 0 : str47.hashCode())) * 31;
        String str48 = this.SubEncoding;
        int hashCode48 = (hashCode47 + (str48 == null ? 0 : str48.hashCode())) * 31;
        String str49 = this.SubAutoTranslation;
        int hashCode49 = (hashCode48 + (str49 == null ? 0 : str49.hashCode())) * 31;
        String str50 = this.SubForeignPartsOnly;
        int hashCode50 = (hashCode49 + (str50 == null ? 0 : str50.hashCode())) * 31;
        String str51 = this.SubFromTrusted;
        int hashCode51 = (hashCode50 + (str51 == null ? 0 : str51.hashCode())) * 31;
        Integer num = this.QueryCached;
        int hashCode52 = (hashCode51 + (num == null ? 0 : num.hashCode())) * 31;
        String str52 = this.SubTSGroupHash;
        int hashCode53 = (hashCode52 + (str52 == null ? 0 : str52.hashCode())) * 31;
        String str53 = this.SubDownloadLink;
        int hashCode54 = (hashCode53 + (str53 == null ? 0 : str53.hashCode())) * 31;
        String str54 = this.ZipDownloadLink;
        int hashCode55 = (hashCode54 + (str54 == null ? 0 : str54.hashCode())) * 31;
        String str55 = this.SubtitlesLink;
        int hashCode56 = (hashCode55 + (str55 == null ? 0 : str55.hashCode())) * 31;
        String str56 = this.QueryNumber;
        int hashCode57 = (hashCode56 + (str56 == null ? 0 : str56.hashCode())) * 31;
        QueryParameters queryParameters = this.QueryParameters;
        int hashCode58 = (hashCode57 + (queryParameters == null ? 0 : queryParameters.hashCode())) * 31;
        Double d = this.Score;
        return hashCode58 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MetaInfo(MatchedBy=" + this.MatchedBy + ", IDSubMovieFile=" + this.IDSubMovieFile + ", MovieHash=" + this.MovieHash + ", MovieByteSize=" + this.MovieByteSize + ", MovieTimeMS=" + this.MovieTimeMS + ", IDSubtitleFile=" + this.IDSubtitleFile + ", SubFileName=" + this.SubFileName + ", SubActualCD=" + this.SubActualCD + ", SubSize=" + this.SubSize + ", SubHash=" + this.SubHash + ", SubLastTS=" + this.SubLastTS + ", SubTSGroup=" + this.SubTSGroup + ", InfoReleaseGroup=" + this.InfoReleaseGroup + ", InfoFormat=" + this.InfoFormat + ", InfoOther=" + this.InfoOther + ", IDSubtitle=" + this.IDSubtitle + ", UserID=" + this.UserID + ", SubLanguageID=" + this.SubLanguageID + ", SubFormat=" + this.SubFormat + ", SubSumCD=" + this.SubSumCD + ", SubAuthorComment=" + this.SubAuthorComment + ", SubAddDate=" + this.SubAddDate + ", SubBad=" + this.SubBad + ", SubRating=" + this.SubRating + ", SubSumVotes=" + this.SubSumVotes + ", SubDownloadsCnt=" + this.SubDownloadsCnt + ", MovieReleaseName=" + this.MovieReleaseName + ", MovieFPS=" + this.MovieFPS + ", IDMovie=" + this.IDMovie + ", IDMovieImdb=" + this.IDMovieImdb + ", MovieName=" + this.MovieName + ", MovieNameEng=" + this.MovieNameEng + ", MovieYear=" + this.MovieYear + ", MovieImdbRating=" + this.MovieImdbRating + ", SubFeatured=" + this.SubFeatured + ", UserNickName=" + this.UserNickName + ", SubTranslator=" + this.SubTranslator + ", ISO639=" + this.ISO639 + ", LanguageName=" + this.LanguageName + ", SubComments=" + this.SubComments + ", SubHearingImpaired=" + this.SubHearingImpaired + ", UserRank=" + this.UserRank + ", SeriesSeason=" + this.SeriesSeason + ", SeriesEpisode=" + this.SeriesEpisode + ", MovieKind=" + this.MovieKind + ", SubHD=" + this.SubHD + ", SeriesIMDBParent=" + this.SeriesIMDBParent + ", SubEncoding=" + this.SubEncoding + ", SubAutoTranslation=" + this.SubAutoTranslation + ", SubForeignPartsOnly=" + this.SubForeignPartsOnly + ", SubFromTrusted=" + this.SubFromTrusted + ", QueryCached=" + this.QueryCached + ", SubTSGroupHash=" + this.SubTSGroupHash + ", SubDownloadLink=" + this.SubDownloadLink + ", ZipDownloadLink=" + this.ZipDownloadLink + ", SubtitlesLink=" + this.SubtitlesLink + ", QueryNumber=" + this.QueryNumber + ", QueryParameters=" + this.QueryParameters + ", Score=" + this.Score + ')';
    }

    public MetaInfo(@JsonProperty("MatchedBy") String str, @JsonProperty("IDSubMovieFile") String str2, @JsonProperty("MovieHash") String str3, @JsonProperty("MovieByteSize") String str4, @JsonProperty("MovieTimeMS") String str5, @JsonProperty("IDSubtitleFile") String str6, @JsonProperty("SubFileName") String str7, @JsonProperty("SubActualCD") String str8, @JsonProperty("SubSize") String str9, @JsonProperty("SubHash") String str10, @JsonProperty("SubLastTS") String str11, @JsonProperty("SubTSGroup") String str12, @JsonProperty("InfoReleaseGroup") String str13, @JsonProperty("InfoFormat") String str14, @JsonProperty("InfoOther") String str15, @JsonProperty("IDSubtitle") String str16, @JsonProperty("UserID") String str17, @JsonProperty("SubLanguageID") String str18, @JsonProperty("SubFormat") String str19, @JsonProperty("SubSumCD") String str20, @JsonProperty("SubAuthorComment") String str21, @JsonProperty("SubAddDate") String str22, @JsonProperty("SubBad") String str23, @JsonProperty("SubRating") String str24, @JsonProperty("SubSumVotes") String str25, @JsonProperty("SubDownloadsCnt") String str26, @JsonProperty("MovieReleaseName") String str27, @JsonProperty("MovieFPS") String str28, @JsonProperty("IDMovie") String str29, @JsonProperty("IDMovieImdb") String str30, @JsonProperty("MovieName") String str31, @JsonProperty("MovieNameEng") String str32, @JsonProperty("MovieYear") String str33, @JsonProperty("MovieImdbRating") String str34, @JsonProperty("SubFeatured") String str35, @JsonProperty("UserNickName") String str36, @JsonProperty("SubTranslator") String str37, @JsonProperty("ISO639") String str38, @JsonProperty("LanguageName") String str39, @JsonProperty("SubComments") String str40, @JsonProperty("SubHearingImpaired") String str41, @JsonProperty("UserRank") String str42, @JsonProperty("SeriesSeason") String str43, @JsonProperty("SeriesEpisode") String str44, @JsonProperty("MovieKind") String str45, @JsonProperty("SubHD") String str46, @JsonProperty("SeriesIMDBParent") String str47, @JsonProperty("SubEncoding") String str48, @JsonProperty("SubAutoTranslation") String str49, @JsonProperty("SubForeignPartsOnly") String str50, @JsonProperty("SubFromTrusted") String str51, @JsonProperty("QueryCached") Integer num, @JsonProperty("SubTSGroupHash") String str52, @JsonProperty("SubDownloadLink") String str53, @JsonProperty("ZipDownloadLink") String str54, @JsonProperty("SubtitlesLink") String str55, @JsonProperty("QueryNumber") String str56, @JsonProperty("QueryParameters") QueryParameters queryParameters, @JsonProperty("Score") Double d) {
        this.MatchedBy = str;
        this.IDSubMovieFile = str2;
        this.MovieHash = str3;
        this.MovieByteSize = str4;
        this.MovieTimeMS = str5;
        this.IDSubtitleFile = str6;
        this.SubFileName = str7;
        this.SubActualCD = str8;
        this.SubSize = str9;
        this.SubHash = str10;
        this.SubLastTS = str11;
        this.SubTSGroup = str12;
        this.InfoReleaseGroup = str13;
        this.InfoFormat = str14;
        this.InfoOther = str15;
        this.IDSubtitle = str16;
        this.UserID = str17;
        this.SubLanguageID = str18;
        this.SubFormat = str19;
        this.SubSumCD = str20;
        this.SubAuthorComment = str21;
        this.SubAddDate = str22;
        this.SubBad = str23;
        this.SubRating = str24;
        this.SubSumVotes = str25;
        this.SubDownloadsCnt = str26;
        this.MovieReleaseName = str27;
        this.MovieFPS = str28;
        this.IDMovie = str29;
        this.IDMovieImdb = str30;
        this.MovieName = str31;
        this.MovieNameEng = str32;
        this.MovieYear = str33;
        this.MovieImdbRating = str34;
        this.SubFeatured = str35;
        this.UserNickName = str36;
        this.SubTranslator = str37;
        this.ISO639 = str38;
        this.LanguageName = str39;
        this.SubComments = str40;
        this.SubHearingImpaired = str41;
        this.UserRank = str42;
        this.SeriesSeason = str43;
        this.SeriesEpisode = str44;
        this.MovieKind = str45;
        this.SubHD = str46;
        this.SeriesIMDBParent = str47;
        this.SubEncoding = str48;
        this.SubAutoTranslation = str49;
        this.SubForeignPartsOnly = str50;
        this.SubFromTrusted = str51;
        this.QueryCached = num;
        this.SubTSGroupHash = str52;
        this.SubDownloadLink = str53;
        this.ZipDownloadLink = str54;
        this.SubtitlesLink = str55;
        this.QueryNumber = str56;
        this.QueryParameters = queryParameters;
        this.Score = d;
    }

    public final String getMatchedBy() {
        return this.MatchedBy;
    }

    public final String getIDSubMovieFile() {
        return this.IDSubMovieFile;
    }

    public final String getMovieHash() {
        return this.MovieHash;
    }

    public final String getMovieByteSize() {
        return this.MovieByteSize;
    }

    public final String getMovieTimeMS() {
        return this.MovieTimeMS;
    }

    public final String getIDSubtitleFile() {
        return this.IDSubtitleFile;
    }

    public final String getSubFileName() {
        return this.SubFileName;
    }

    public final String getSubActualCD() {
        return this.SubActualCD;
    }

    public final String getSubSize() {
        return this.SubSize;
    }

    public final String getSubHash() {
        return this.SubHash;
    }

    public final String getSubLastTS() {
        return this.SubLastTS;
    }

    public final String getSubTSGroup() {
        return this.SubTSGroup;
    }

    public final String getInfoReleaseGroup() {
        return this.InfoReleaseGroup;
    }

    public final String getInfoFormat() {
        return this.InfoFormat;
    }

    public final String getInfoOther() {
        return this.InfoOther;
    }

    public final String getIDSubtitle() {
        return this.IDSubtitle;
    }

    public final String getUserID() {
        return this.UserID;
    }

    public final String getSubLanguageID() {
        return this.SubLanguageID;
    }

    public final String getSubFormat() {
        return this.SubFormat;
    }

    public final String getSubSumCD() {
        return this.SubSumCD;
    }

    public final String getSubAuthorComment() {
        return this.SubAuthorComment;
    }

    public final String getSubAddDate() {
        return this.SubAddDate;
    }

    public final String getSubBad() {
        return this.SubBad;
    }

    public final String getSubRating() {
        return this.SubRating;
    }

    public final String getSubSumVotes() {
        return this.SubSumVotes;
    }

    public final String getSubDownloadsCnt() {
        return this.SubDownloadsCnt;
    }

    public final String getMovieReleaseName() {
        return this.MovieReleaseName;
    }

    public final String getMovieFPS() {
        return this.MovieFPS;
    }

    public final String getIDMovie() {
        return this.IDMovie;
    }

    public final String getIDMovieImdb() {
        return this.IDMovieImdb;
    }

    public final String getMovieName() {
        return this.MovieName;
    }

    public final String getMovieNameEng() {
        return this.MovieNameEng;
    }

    public final String getMovieYear() {
        return this.MovieYear;
    }

    public final String getMovieImdbRating() {
        return this.MovieImdbRating;
    }

    public final String getSubFeatured() {
        return this.SubFeatured;
    }

    public final String getUserNickName() {
        return this.UserNickName;
    }

    public final String getSubTranslator() {
        return this.SubTranslator;
    }

    public final String getISO639() {
        return this.ISO639;
    }

    public final String getLanguageName() {
        return this.LanguageName;
    }

    public final String getSubComments() {
        return this.SubComments;
    }

    public final String getSubHearingImpaired() {
        return this.SubHearingImpaired;
    }

    public final String getUserRank() {
        return this.UserRank;
    }

    public final String getSeriesSeason() {
        return this.SeriesSeason;
    }

    public final String getSeriesEpisode() {
        return this.SeriesEpisode;
    }

    public final String getMovieKind() {
        return this.MovieKind;
    }

    public final String getSubHD() {
        return this.SubHD;
    }

    public final String getSeriesIMDBParent() {
        return this.SeriesIMDBParent;
    }

    public final String getSubEncoding() {
        return this.SubEncoding;
    }

    public final String getSubAutoTranslation() {
        return this.SubAutoTranslation;
    }

    public final String getSubForeignPartsOnly() {
        return this.SubForeignPartsOnly;
    }

    public final String getSubFromTrusted() {
        return this.SubFromTrusted;
    }

    public final Integer getQueryCached() {
        return this.QueryCached;
    }

    public final String getSubTSGroupHash() {
        return this.SubTSGroupHash;
    }

    public final String getSubDownloadLink() {
        return this.SubDownloadLink;
    }

    public final String getZipDownloadLink() {
        return this.ZipDownloadLink;
    }

    public final String getSubtitlesLink() {
        return this.SubtitlesLink;
    }

    public final String getQueryNumber() {
        return this.QueryNumber;
    }

    public final QueryParameters getQueryParameters() {
        return this.QueryParameters;
    }

    public final Double getScore() {
        return this.Score;
    }
}
