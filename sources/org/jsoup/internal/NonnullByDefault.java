package org.jsoup.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@TypeQualifierDefault({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Nonnull
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface NonnullByDefault {
}
