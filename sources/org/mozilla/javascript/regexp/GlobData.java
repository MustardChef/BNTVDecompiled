package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/* compiled from: RegExpImpl.java */
/* loaded from: classes5.dex */
final class GlobData {
    Scriptable arrayobj;
    StringBuilder charBuf;
    int dollar = -1;
    boolean global;
    Function lambda;
    int leftIndex;
    int mode;
    int optarg;
    String repstr;
    String str;
}
