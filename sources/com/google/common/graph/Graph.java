package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public interface Graph<N> extends BaseGraph<N> {
    @Override // 
    Set<N> adjacentNodes(N n);

    @Override // 
    boolean allowsSelfLoops();

    @Override // com.google.common.graph.BaseGraph
    int degree(N n);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> edges();

    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N n);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // 
    boolean isDirected();

    @Override // 
    ElementOrder<N> nodeOrder();

    @Override // 
    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N n);

    @Override // 
    Set<N> predecessors(N n);

    @Override // 
    Set<N> successors(N n);
}
