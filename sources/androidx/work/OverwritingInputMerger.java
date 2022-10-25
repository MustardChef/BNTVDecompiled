package androidx.work;

import androidx.work.Data;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public Data merge(List<Data> inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data data : inputs) {
            hashMap.putAll(data.getKeyValueMap());
        }
        builder.putAll(hashMap);
        return builder.build();
    }
}
