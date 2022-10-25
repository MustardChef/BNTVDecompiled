package abhishekti7.unicorn.filepicker;

import abhishekti7.unicorn.filepicker.models.Config;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ConfigBuilder {
    private ArrayList<String> extensionFilters;
    private String rootDir;
    private final UnicornFilePicker unicornFilePicker;
    private boolean showHidden = false;
    private boolean selectMultiple = false;
    private boolean addDivider = false;
    private boolean showOnlyDir = false;
    private int themeId = C0000R.style.UnicornFilePicker_Default;
    private Config config = Config.getCleanInstance();

    public ConfigBuilder(UnicornFilePicker unicornFilePicker) {
        this.unicornFilePicker = unicornFilePicker;
    }

    public ConfigBuilder setRootDirectory(String str) {
        this.rootDir = str;
        return this;
    }

    public ConfigBuilder showHiddenFiles(boolean z) {
        this.showHidden = z;
        return this;
    }

    public ConfigBuilder selectMultipleFiles(boolean z) {
        this.selectMultiple = z;
        return this;
    }

    public ConfigBuilder setFilters(String[] strArr) {
        this.extensionFilters = new ArrayList<>(Arrays.asList(strArr));
        return this;
    }

    public ConfigBuilder addItemDivider(boolean z) {
        this.addDivider = z;
        return this;
    }

    public ConfigBuilder theme(int i) {
        this.themeId = i;
        return this;
    }

    public ConfigBuilder showOnlyDirectory(boolean z) {
        this.showOnlyDir = z;
        return this;
    }

    public UnicornFilePicker build() {
        this.config.setRootDir(this.rootDir);
        this.config.setSelectMultiple(this.selectMultiple);
        this.config.setShowHidden(this.showHidden);
        this.config.setExtensionFilters(this.extensionFilters);
        this.config.setAddItemDivider(this.addDivider);
        this.config.setThemeId(this.themeId);
        this.config.setShowOnlyDirectory(this.showOnlyDir);
        return this.unicornFilePicker;
    }
}
