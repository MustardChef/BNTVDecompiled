package com.fasterxml.jackson.module.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;

@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\r\u0010\n\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0007J\r\u0010\u000b\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0007J\r\u0010\f\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0007J\r\u0010\r\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0007J\r\u0010\u000e\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H'R\u0015\u0010\u0004\u001a\u00028\u00008\u0007¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/ClosedRangeMixin;", ExifInterface.GPS_DIRECTION_TRUE, "", TtmlNode.START, "endInclusive", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getEndInclusive", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getEnd", "getFirst", "getIncrement", "getLast", "getStep", "isEmpty", "", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.fasterxml.jackson.module.kotlin.ClosedRangeMixin */
/* loaded from: classes2.dex */
public abstract class KotlinMixins<T> {
    private final T endInclusive;
    private final T start;

    @JsonIgnore
    public abstract T getEnd();

    @JsonIgnore
    public abstract T getFirst();

    @JsonIgnore
    public abstract T getIncrement();

    @JsonIgnore
    public abstract T getLast();

    @JsonIgnore
    public abstract T getStep();

    @JsonIgnore
    public abstract boolean isEmpty();

    @JsonCreator
    public KotlinMixins(T t, T t2) {
        this.start = t;
        this.endInclusive = t2;
    }

    @JsonProperty(TtmlNode.END)
    public final T getEndInclusive() {
        return this.endInclusive;
    }

    public final T getStart() {
        return this.start;
    }
}
