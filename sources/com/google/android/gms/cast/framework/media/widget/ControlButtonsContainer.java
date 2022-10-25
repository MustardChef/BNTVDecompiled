package com.google.android.gms.cast.framework.media.widget;

import android.widget.ImageView;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface ControlButtonsContainer {
    ImageView getButtonImageViewAt(int i) throws IndexOutOfBoundsException;

    int getButtonSlotCount();

    int getButtonTypeAt(int i) throws IndexOutOfBoundsException;

    UIMediaController getUIMediaController();
}
