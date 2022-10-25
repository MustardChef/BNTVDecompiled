package org.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ConsString implements CharSequence, Serializable {
    private static final long serialVersionUID = -8432806714471372570L;
    private int depth;
    private final int length;

    /* renamed from: s1 */
    private CharSequence f10716s1;

    /* renamed from: s2 */
    private CharSequence f10717s2;

    public ConsString(CharSequence charSequence, CharSequence charSequence2) {
        this.f10716s1 = charSequence;
        this.f10717s2 = charSequence2;
        this.length = charSequence.length() + charSequence2.length();
        this.depth = 1;
        if (charSequence instanceof ConsString) {
            this.depth = 1 + ((ConsString) charSequence).depth;
        }
        if (charSequence2 instanceof ConsString) {
            this.depth += ((ConsString) charSequence2).depth;
        }
        if (this.depth > 2000) {
            flatten();
        }
    }

    private Object writeReplace() {
        return toString();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.depth == 0 ? (String) this.f10716s1 : flatten();
    }

    private synchronized String flatten() {
        if (this.depth > 0) {
            StringBuilder sb = new StringBuilder(this.length);
            appendTo(sb);
            this.f10716s1 = sb.toString();
            this.f10717s2 = "";
            this.depth = 0;
        }
        return (String) this.f10716s1;
    }

    private synchronized void appendTo(StringBuilder sb) {
        appendFragment(this.f10716s1, sb);
        appendFragment(this.f10717s2, sb);
    }

    private static void appendFragment(CharSequence charSequence, StringBuilder sb) {
        if (charSequence instanceof ConsString) {
            ((ConsString) charSequence).appendTo(sb);
        } else {
            sb.append(charSequence);
        }
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (this.depth == 0 ? (String) this.f10716s1 : flatten()).charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return (this.depth == 0 ? (String) this.f10716s1 : flatten()).substring(i, i2);
    }
}
