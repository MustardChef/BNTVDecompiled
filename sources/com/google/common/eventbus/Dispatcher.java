package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class Dispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dispatch(Object obj, Iterator<Subscriber> it);

    Dispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0037 A[Catch: all -> 0x005e, LOOP:1: B:7:0x0037->B:9:0x0041, LOOP_START, TryCatch #0 {all -> 0x005e, blocks: (B:5:0x002f, B:7:0x0037, B:9:0x0041), top: B:16:0x002f }] */
        @Override // com.google.common.eventbus.Dispatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch(java.lang.Object r4, java.util.Iterator<com.google.common.eventbus.Subscriber> r5) {
            /*
                r3 = this;
                com.google.common.base.Preconditions.checkNotNull(r4)
                com.google.common.base.Preconditions.checkNotNull(r5)
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r3.queue
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = 0
                r1.<init>(r4, r5)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                java.lang.Object r4 = r4.get()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L6a
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                r5 = 1
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                r4.set(r5)
            L2f:
                java.lang.Object r4 = r0.poll()     // Catch: java.lang.Throwable -> L5e
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r4 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r4     // Catch: java.lang.Throwable -> L5e
                if (r4 == 0) goto L53
            L37:
                java.util.Iterator r5 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r4)     // Catch: java.lang.Throwable -> L5e
                boolean r5 = r5.hasNext()     // Catch: java.lang.Throwable -> L5e
                if (r5 == 0) goto L2f
                java.util.Iterator r5 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r4)     // Catch: java.lang.Throwable -> L5e
                java.lang.Object r5 = r5.next()     // Catch: java.lang.Throwable -> L5e
                com.google.common.eventbus.Subscriber r5 = (com.google.common.eventbus.Subscriber) r5     // Catch: java.lang.Throwable -> L5e
                java.lang.Object r1 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$500(r4)     // Catch: java.lang.Throwable -> L5e
                r5.dispatchEvent(r1)     // Catch: java.lang.Throwable -> L5e
                goto L37
            L53:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                r4.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r4 = r3.queue
                r4.remove()
                goto L6a
            L5e:
                r4 = move-exception
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r3.dispatching
                r5.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r5 = r3.queue
                r5.remove()
                throw r4
            L6a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.dispatch(java.lang.Object, java.util.Iterator):void");
        }

        /* loaded from: classes3.dex */
        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                poll.subscriber.dispatchEvent(poll.event);
            }
        }

        /* loaded from: classes3.dex */
        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.event = obj;
                this.subscriber = subscriber;
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }
}
