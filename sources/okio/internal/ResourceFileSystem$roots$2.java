package okio.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceFileSystem.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001H\n"}, m107d2 = {"<anonymous>", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Lokio/Path;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ResourceFileSystem$roots$2 extends Lambda implements Functions<List<? extends Tuples<? extends FileSystem, ? extends Path>>> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceFileSystem$roots$2(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends Tuples<? extends FileSystem, ? extends Path>> invoke() {
        return ResourceFileSystem.Companion.toClasspathRoots(this.$classLoader);
    }
}
