package com.google.common.graph;

/* loaded from: classes3.dex */
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n);
}
