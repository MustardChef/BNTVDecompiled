package org.mozilla.javascript;

import org.mozilla.javascript.ContextFactory;

/* loaded from: classes5.dex */
public interface ContextListener extends ContextFactory.Listener {
    void contextEntered(Context context);

    void contextExited(Context context);
}
