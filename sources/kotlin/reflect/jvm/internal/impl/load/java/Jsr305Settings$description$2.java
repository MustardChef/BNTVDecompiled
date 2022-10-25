package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Jsr305Settings.kt */
/* loaded from: classes4.dex */
final class Jsr305Settings$description$2 extends Lambda implements Functions<String[]> {
    final /* synthetic */ Jsr305Settings this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Jsr305Settings$description$2(Jsr305Settings jsr305Settings) {
        super(0);
        this.this$0 = jsr305Settings;
    }

    @Override // kotlin.jvm.functions.Functions
    public final String[] invoke() {
        Jsr305Settings jsr305Settings = this.this$0;
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(jsr305Settings.getGlobalLevel().getDescription());
        ReportLevel migrationLevel = jsr305Settings.getMigrationLevel();
        if (migrationLevel != null) {
            createListBuilder.add("under-migration:" + migrationLevel.getDescription());
        }
        for (Map.Entry<FqName, ReportLevel> entry : jsr305Settings.getUserDefinedLevelForSpecificAnnotation().entrySet()) {
            createListBuilder.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        Object[] array = CollectionsKt.build(createListBuilder).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }
}
