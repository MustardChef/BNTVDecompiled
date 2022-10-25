package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int capacityHint) {
        this.capacityHint = capacityHint;
    }

    public void add(Object o) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = o;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i = this.indexInTail;
        int i2 = this.capacityHint;
        if (i == i2) {
            Object[] objArr2 = new Object[i2 + 1];
            objArr2[0] = o;
            this.tail[i2] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i] = o;
        this.indexInTail = i + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] head = head();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(head[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i];
        }
    }
}
