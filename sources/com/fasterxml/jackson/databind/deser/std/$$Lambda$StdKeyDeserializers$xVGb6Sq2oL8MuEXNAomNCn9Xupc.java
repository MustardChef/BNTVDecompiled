package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import java.util.function.Predicate;

/* compiled from: lambda */
/* renamed from: com.fasterxml.jackson.databind.deser.std.-$$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc implements Predicate {
    public static final /* synthetic */ $$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc INSTANCE = new $$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc();

    private /* synthetic */ $$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((AnnotatedAndMetadata) obj);
    }
}
