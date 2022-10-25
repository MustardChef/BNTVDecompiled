package org.jacoco.agent.p046rt;

import androidx.palette.graphics.ColorCutQuantizer;
import androidx.palette.graphics.Palette;

/* renamed from: org.jacoco.agent.rt.IAgent */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/IAgent.class */
public interface IAgent {
    Palette.Swatch getAverageColor();

    int getColorCount();

    int getLongestColorDimension();

    int getVolume();

    ColorCutQuantizer.Vbox splitBox();

    static;
}
