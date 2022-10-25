package com.evgenii.jsevaluator;

import android.webkit.JavascriptInterface;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;

/* loaded from: classes.dex */
public class JavaScriptInterface {
    private final CallJavaResultInterface mCallJavaResultInterface;

    public JavaScriptInterface(CallJavaResultInterface callJavaResultInterface) {
        this.mCallJavaResultInterface = callJavaResultInterface;
    }

    @JavascriptInterface
    public void returnResultToJava(String str) {
        this.mCallJavaResultInterface.jsCallFinished(str);
    }
}
