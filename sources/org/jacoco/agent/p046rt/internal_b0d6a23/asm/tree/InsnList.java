package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.InsnList */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/InsnList.class */
public class InsnList {
    private int size;
    private AbstractInsnNode first;
    private AbstractInsnNode last;
    AbstractInsnNode[] cache;

    public int size() {
        return this.size;
    }

    public AbstractInsnNode getFirst() {
        return this.first;
    }

    public AbstractInsnNode getLast() {
        return this.last;
    }

    public AbstractInsnNode get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.cache == null) {
            this.cache = toArray();
        }
        return this.cache[index];
    }

    public boolean contains(AbstractInsnNode insn) {
        AbstractInsnNode i;
        AbstractInsnNode abstractInsnNode = this.first;
        while (true) {
            i = abstractInsnNode;
            if (i == null || i == insn) {
                break;
            }
            abstractInsnNode = i.next;
        }
        return i != null;
    }

    public int indexOf(AbstractInsnNode insn) {
        if (this.cache == null) {
            this.cache = toArray();
        }
        return insn.index;
    }

    public void accept(MethodVisitor mv) {
        AbstractInsnNode abstractInsnNode = this.first;
        while (true) {
            AbstractInsnNode insn = abstractInsnNode;
            if (insn != null) {
                insn.accept(mv);
                abstractInsnNode = insn.next;
            } else {
                return;
            }
        }
    }

    public ListIterator<AbstractInsnNode> iterator() {
        return iterator(0);
    }

    public ListIterator<AbstractInsnNode> iterator(int index) {
        return new InsnListIterator(index);
    }

    public AbstractInsnNode[] toArray() {
        int i = 0;
        AbstractInsnNode[] insns = new AbstractInsnNode[this.size];
        for (AbstractInsnNode elem = this.first; elem != null; elem = elem.next) {
            insns[i] = elem;
            int i2 = i;
            i++;
            elem.index = i2;
        }
        return insns;
    }

    public void set(AbstractInsnNode location, AbstractInsnNode insn) {
        AbstractInsnNode next = location.next;
        insn.next = next;
        if (next != null) {
            next.prev = insn;
        } else {
            this.last = insn;
        }
        AbstractInsnNode prev = location.prev;
        insn.prev = prev;
        if (prev != null) {
            prev.next = insn;
        } else {
            this.first = insn;
        }
        if (this.cache != null) {
            int index = location.index;
            this.cache[index] = insn;
            insn.index = index;
        } else {
            insn.index = 0;
        }
        location.index = -1;
        location.prev = null;
        location.next = null;
    }

    public void add(AbstractInsnNode insn) {
        this.size++;
        if (this.last == null) {
            this.first = insn;
            this.last = insn;
        } else {
            this.last.next = insn;
            insn.prev = this.last;
        }
        this.last = insn;
        this.cache = null;
        insn.index = 0;
    }

    public void add(InsnList insns) {
        if (insns.size == 0) {
            return;
        }
        this.size += insns.size;
        if (this.last == null) {
            this.first = insns.first;
            this.last = insns.last;
        } else {
            AbstractInsnNode elem = insns.first;
            this.last.next = elem;
            elem.prev = this.last;
            this.last = insns.last;
        }
        this.cache = null;
        insns.removeAll(false);
    }

    public void insert(AbstractInsnNode insn) {
        this.size++;
        if (this.first == null) {
            this.first = insn;
            this.last = insn;
        } else {
            this.first.prev = insn;
            insn.next = this.first;
        }
        this.first = insn;
        this.cache = null;
        insn.index = 0;
    }

    public void insert(InsnList insns) {
        if (insns.size == 0) {
            return;
        }
        this.size += insns.size;
        if (this.first == null) {
            this.first = insns.first;
            this.last = insns.last;
        } else {
            AbstractInsnNode elem = insns.last;
            this.first.prev = elem;
            elem.next = this.first;
            this.first = insns.first;
        }
        this.cache = null;
        insns.removeAll(false);
    }

    public void insert(AbstractInsnNode location, AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode next = location.next;
        if (next == null) {
            this.last = insn;
        } else {
            next.prev = insn;
        }
        location.next = insn;
        insn.next = next;
        insn.prev = location;
        this.cache = null;
        insn.index = 0;
    }

    public void insert(AbstractInsnNode location, InsnList insns) {
        if (insns.size == 0) {
            return;
        }
        this.size += insns.size;
        AbstractInsnNode ifirst = insns.first;
        AbstractInsnNode ilast = insns.last;
        AbstractInsnNode next = location.next;
        if (next == null) {
            this.last = ilast;
        } else {
            next.prev = ilast;
        }
        location.next = ifirst;
        ilast.next = next;
        ifirst.prev = location;
        this.cache = null;
        insns.removeAll(false);
    }

    public void insertBefore(AbstractInsnNode location, AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode prev = location.prev;
        if (prev == null) {
            this.first = insn;
        } else {
            prev.next = insn;
        }
        location.prev = insn;
        insn.next = location;
        insn.prev = prev;
        this.cache = null;
        insn.index = 0;
    }

    public void insertBefore(AbstractInsnNode location, InsnList insns) {
        if (insns.size == 0) {
            return;
        }
        this.size += insns.size;
        AbstractInsnNode ifirst = insns.first;
        AbstractInsnNode ilast = insns.last;
        AbstractInsnNode prev = location.prev;
        if (prev == null) {
            this.first = ifirst;
        } else {
            prev.next = ifirst;
        }
        location.prev = ilast;
        ilast.next = location;
        ifirst.prev = prev;
        this.cache = null;
        insns.removeAll(false);
    }

    public void remove(AbstractInsnNode insn) {
        this.size--;
        AbstractInsnNode next = insn.next;
        AbstractInsnNode prev = insn.prev;
        if (next == null) {
            if (prev == null) {
                this.first = null;
                this.last = null;
            } else {
                prev.next = null;
                this.last = prev;
            }
        } else if (prev == null) {
            this.first = next;
            next.prev = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        this.cache = null;
        insn.index = -1;
        insn.prev = null;
        insn.next = null;
    }

    void removeAll(boolean mark) {
        if (mark) {
            AbstractInsnNode abstractInsnNode = this.first;
            while (true) {
                AbstractInsnNode insn = abstractInsnNode;
                if (insn == null) {
                    break;
                }
                AbstractInsnNode next = insn.next;
                insn.index = -1;
                insn.prev = null;
                insn.next = null;
                abstractInsnNode = next;
            }
        }
        this.size = 0;
        this.first = null;
        this.last = null;
        this.cache = null;
    }

    public void clear() {
        removeAll(false);
    }

    public void resetLabels() {
        AbstractInsnNode abstractInsnNode = this.first;
        while (true) {
            AbstractInsnNode insn = abstractInsnNode;
            if (insn != null) {
                if (insn instanceof LabelNode) {
                    ((LabelNode) insn).resetLabel();
                }
                abstractInsnNode = insn.next;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.InsnList$InsnListIterator */
    /* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/InsnList$InsnListIterator.class */
    public final class InsnListIterator implements ListIterator {
        AbstractInsnNode next;
        AbstractInsnNode prev;
        AbstractInsnNode remove;

        InsnListIterator(int index) {
            if (index == InsnList.this.size()) {
                this.next = null;
                this.prev = InsnList.this.getLast();
                return;
            }
            this.next = InsnList.this.get(index);
            this.prev = this.next.prev;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            AbstractInsnNode result = this.next;
            this.prev = result;
            this.next = result.next;
            this.remove = result;
            return result;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.remove != null) {
                if (this.remove == this.next) {
                    this.next = this.next.next;
                } else {
                    this.prev = this.prev.prev;
                }
                InsnList.this.remove(this.remove);
                this.remove = null;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prev != null;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            AbstractInsnNode result = this.prev;
            this.next = result;
            this.prev = result.prev;
            this.remove = result;
            return result;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            if (this.next == null) {
                return InsnList.this.size();
            }
            if (InsnList.this.cache == null) {
                InsnList.this.cache = InsnList.this.toArray();
            }
            return this.next.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            if (this.prev == null) {
                return -1;
            }
            if (InsnList.this.cache == null) {
                InsnList.this.cache = InsnList.this.toArray();
            }
            return this.prev.index;
        }

        @Override // java.util.ListIterator
        public void add(Object o) {
            InsnList.this.insertBefore(this.next, (AbstractInsnNode) o);
            this.prev = (AbstractInsnNode) o;
            this.remove = null;
        }

        @Override // java.util.ListIterator
        public void set(Object o) {
            InsnList.this.set(this.next.prev, (AbstractInsnNode) o);
            this.prev = (AbstractInsnNode) o;
        }
    }
}
