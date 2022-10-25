package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Update {
    Class<?> entity() default Object.class;

    int onConflict() default 3;
}
