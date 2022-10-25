package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ErrorReporter;

/* loaded from: classes5.dex */
public class ShellContextFactory extends ContextFactory {
    private String characterEncoding;
    private ErrorReporter errorReporter;
    private boolean generatingDebug;
    private int optimizationLevel;
    private boolean strictMode;
    private boolean warningAsError;
    private int languageVersion = 170;
    private boolean allowReservedKeywords = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ContextFactory
    public boolean hasFeature(Context context, int i) {
        if (i != 3) {
            switch (i) {
                case 8:
                case 9:
                case 11:
                    return this.strictMode;
                case 10:
                    return this.generatingDebug;
                case 12:
                    return this.warningAsError;
                default:
                    return super.hasFeature(context, i);
            }
        }
        return this.allowReservedKeywords;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ContextFactory
    public void onContextCreated(Context context) {
        context.setLanguageVersion(this.languageVersion);
        context.setOptimizationLevel(this.optimizationLevel);
        ErrorReporter errorReporter = this.errorReporter;
        if (errorReporter != null) {
            context.setErrorReporter(errorReporter);
        }
        context.setGeneratingDebug(this.generatingDebug);
        super.onContextCreated(context);
    }

    public void setStrictMode(boolean z) {
        checkNotSealed();
        this.strictMode = z;
    }

    public void setWarningAsError(boolean z) {
        checkNotSealed();
        this.warningAsError = z;
    }

    public void setLanguageVersion(int i) {
        Context.checkLanguageVersion(i);
        checkNotSealed();
        this.languageVersion = i;
    }

    public void setOptimizationLevel(int i) {
        Context.checkOptimizationLevel(i);
        checkNotSealed();
        this.optimizationLevel = i;
    }

    public void setErrorReporter(ErrorReporter errorReporter) {
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        this.errorReporter = errorReporter;
    }

    public void setGeneratingDebug(boolean z) {
        this.generatingDebug = z;
    }

    public String getCharacterEncoding() {
        return this.characterEncoding;
    }

    public void setCharacterEncoding(String str) {
        this.characterEncoding = str;
    }

    public void setAllowReservedKeywords(boolean z) {
        this.allowReservedKeywords = z;
    }
}
