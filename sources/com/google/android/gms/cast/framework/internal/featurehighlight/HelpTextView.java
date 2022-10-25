package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.C3616R;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class HelpTextView extends LinearLayout {
    private TextView zza;
    private TextView zzb;

    public HelpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static final void zza(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(true != TextUtils.isEmpty(charSequence) ? 0 : 8);
    }

    public View asView() {
        return this;
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(C3616R.C3619id.cast_featurehighlight_help_text_header_view);
        Objects.requireNonNull(textView);
        this.zza = textView;
        TextView textView2 = (TextView) findViewById(C3616R.C3619id.cast_featurehighlight_help_text_body_view);
        Objects.requireNonNull(textView2);
        this.zzb = textView2;
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        zza(this.zza, charSequence);
        zza(this.zzb, charSequence2);
    }
}
