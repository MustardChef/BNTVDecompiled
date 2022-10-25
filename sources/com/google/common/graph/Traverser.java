package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public abstract class Traverser<N> {

    /* loaded from: classes3.dex */
    private enum Order {
        PREORDER,
        POSTORDER
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    private Traverser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class GraphTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> graph;

        GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInGraph(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        private void checkThatNodeIsInGraph(N n) {
            this.graph.successors(n);
        }

        /* loaded from: classes3.dex */
        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n : iterable) {
                    if (this.visited.add(n)) {
                        this.queue.add(n);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                for (N n : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(n)) {
                        this.queue.add(n);
                    }
                }
                return remove;
            }
        }

        /* loaded from: classes3.dex */
        private final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack;
            private final Set<N> visited;

            DepthFirstIterator(Iterable<? extends N> iterable, Order order) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                this.visited = new HashSet();
                arrayDeque.push(new NodeAndSuccessors(null, iterable));
                this.order = order;
            }

            @Override // com.google.common.collect.AbstractIterator
            protected N computeNext() {
                while (!this.stack.isEmpty()) {
                    GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors first = this.stack.getFirst();
                    boolean add = this.visited.add(first.node);
                    boolean z = true;
                    boolean z2 = !first.successorIterator.hasNext();
                    if ((!add || this.order != Order.PREORDER) && (!z2 || this.order != Order.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.stack.pop();
                    } else {
                        N next = first.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    }
                    if (z && first.node != null) {
                        return first.node;
                    }
                }
                return (N) endOfData();
            }

            GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n) {
                return new NodeAndSuccessors(n, GraphTraverser.this.graph.successors(n));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes3.dex */
            public final class NodeAndSuccessors {
                @NullableDecl
                final N node;
                final Iterator<? extends N> successorIterator;

                NodeAndSuccessors(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.successorIterator = iterable.iterator();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TreeTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> tree;

        TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.m252of(n));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.m253of();
            }
            for (N n : iterable) {
                checkThatNodeIsInTree(n);
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        private void checkThatNodeIsInTree(N n) {
            this.tree.successors(n);
        }

        /* loaded from: classes3.dex */
        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n : iterable) {
                    this.queue.add(n);
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        /* loaded from: classes3.dex */
        private final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;

            DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.stack.getLast();
                N n = (N) Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator<? extends N> it = TreeTraverser.this.tree.successors(n).iterator();
                if (it.hasNext()) {
                    this.stack.addLast(it);
                }
                return n;
            }
        }

        /* loaded from: classes3.dex */
        private final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;

            DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            @Override // com.google.common.collect.AbstractIterator
            protected N computeNext() {
                while (!this.stack.isEmpty()) {
                    TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        if (last.node != null) {
                            return last.node;
                        }
                    }
                }
                return (N) endOfData();
            }

            TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n) {
                return new NodeAndChildren(n, TreeTraverser.this.tree.successors(n));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes3.dex */
            public final class NodeAndChildren {
                final Iterator<? extends N> childIterator;
                @NullableDecl
                final N node;

                NodeAndChildren(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.childIterator = iterable.iterator();
                }
            }
        }
    }
}
