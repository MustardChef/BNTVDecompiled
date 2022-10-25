package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addNode(N n) {
        Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        addNodeInternal(n);
        return true;
    }

    private NetworkConnections<N, E> addNodeInternal(N n) {
        NetworkConnections<N, E> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n, newConnections) == null);
        return newConnections;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(N n, N n2, E e) {
        Preconditions.checkNotNull(n, "nodeU");
        Preconditions.checkNotNull(n2, "nodeV");
        Preconditions.checkNotNull(e, "edge");
        boolean z = false;
        if (containsEdge(e)) {
            EndpointPair<N> incidentNodes = incidentNodes(e);
            EndpointPair m195of = EndpointPair.m195of(this, n, n2);
            Preconditions.checkArgument(incidentNodes.equals(m195of), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e, incidentNodes, m195of);
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument((networkConnections == null || !networkConnections.successors().contains(n2)) ? true : true, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n, n2);
        }
        boolean equals = n.equals(n2);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n);
        }
        networkConnections.addOutEdge(e, n2);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(n2);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n2);
        }
        networkConnections2.addInEdge(e, n, equals);
        this.edgeToReferenceNode.put(e, n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(EndpointPair<N> endpointPair, E e) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeNode(N n) {
        Preconditions.checkNotNull(n, "node");
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeEdge(E e) {
        Preconditions.checkNotNull(e, "edge");
        N n = this.edgeToReferenceNode.get(e);
        boolean z = false;
        if (n == null) {
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n);
        N adjacentNode = networkConnections.adjacentNode(e);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(adjacentNode);
        networkConnections.removeOutEdge(e);
        if (allowsSelfLoops() && n.equals(adjacentNode)) {
            z = true;
        }
        networkConnections2.removeInEdge(e, z);
        this.edgeToReferenceNode.remove(e);
        return true;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.m198of();
            }
            return DirectedNetworkConnections.m197of();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.m192of();
        } else {
            return UndirectedNetworkConnections.m191of();
        }
    }
}
