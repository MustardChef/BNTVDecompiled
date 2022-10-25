package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes4.dex */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverValue getValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    ReceiverParameterDescriptor substitute(TypeSubstitutor typeSubstitutor);
}
