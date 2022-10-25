package androidx.work;

/* loaded from: classes.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String className);

    public final InputMerger createInputMergerWithDefaultFallback(String className) {
        InputMerger createInputMerger = createInputMerger(className);
        return createInputMerger == null ? InputMerger.fromClassName(className) : createInputMerger;
    }

    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new InputMergerFactory() { // from class: androidx.work.InputMergerFactory.1
            @Override // androidx.work.InputMergerFactory
            public InputMerger createInputMerger(String className) {
                return null;
            }
        };
    }
}
