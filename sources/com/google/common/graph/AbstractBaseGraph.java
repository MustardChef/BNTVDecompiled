package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    protected long edgeCount() {
        Iterator<N> it;
        long j = 0;
        while (nodes().iterator().hasNext()) {
            j += degree(it.next());
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.m194of(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (obj instanceof EndpointPair) {
                    EndpointPair<?> endpointPair = (EndpointPair) obj;
                    return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
                }
                return false;
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        return IncidentEdgeSet.m200of((BaseGraph) this, (Object) n);
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((AbstractBaseGraph<N>) n).size(), successors((AbstractBaseGraph<N>) n).size());
        }
        Set<N> adjacentNodes = adjacentNodes(n);
        return IntMath.saturatedAdd(adjacentNodes.size(), (allowsSelfLoops() && adjacentNodes.contains(n)) ? 1 : 0);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n) {
        return isDirected() ? predecessors((AbstractBaseGraph<N>) n).size() : degree(n);
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n) {
        return isDirected() ? successors((AbstractBaseGraph<N>) n).size() : degree(n);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors((AbstractBaseGraph<N>) n).contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            N nodeU = endpointPair.nodeU();
            return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(endpointPair.nodeV());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final BaseGraph<N> graph;
        protected final N node;

        /* renamed from: of */
        public static <N> IncidentEdgeSet<N> m200of(BaseGraph<N> baseGraph, N n) {
            return baseGraph.isDirected() ? new Directed(baseGraph, n) : new Undirected(baseGraph, n);
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n) {
            this.graph = baseGraph;
            this.node = n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class Directed<N> extends IncidentEdgeSet<N> {
            private Directed(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((BaseGraph<N>) this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.1
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((C42341) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(n, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors((BaseGraph<N>) this.node), ImmutableSet.m252of(this.node)).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.2
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((C42352) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(Directed.this.node, n);
                    }
                })));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors((BaseGraph<N>) this.node).contains(this.node) ? 1 : 0);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (obj instanceof EndpointPair) {
                    EndpointPair endpointPair = (EndpointPair) obj;
                    if (endpointPair.isOrdered()) {
                        Object source = endpointPair.source();
                        Object target = endpointPair.target();
                        return (this.node.equals(source) && this.graph.successors((BaseGraph<N>) this.node).contains(target)) || (this.node.equals(target) && this.graph.predecessors((BaseGraph<N>) this.node).contains(source));
                    }
                    return false;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            private Undirected(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.1
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((C42361) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.unordered(Undirected.this.node, n);
                    }
                }));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (obj instanceof EndpointPair) {
                    EndpointPair endpointPair = (EndpointPair) obj;
                    if (endpointPair.isOrdered()) {
                        return false;
                    }
                    Set<N> adjacentNodes = this.graph.adjacentNodes(this.node);
                    Object nodeU = endpointPair.nodeU();
                    Object nodeV = endpointPair.nodeV();
                    return (this.node.equals(nodeV) && adjacentNodes.contains(nodeU)) || (this.node.equals(nodeU) && adjacentNodes.contains(nodeV));
                }
                return false;
            }
        }
    }
}
