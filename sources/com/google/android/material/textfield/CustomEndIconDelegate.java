package com.google.android.material.textfield;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CustomEndIconDelegate extends EndIconDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(this.customEndIcon);
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
