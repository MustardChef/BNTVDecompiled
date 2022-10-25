package abhishekti7.unicorn.filepicker.models;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Config {
    private boolean addItemDivider;
    private ArrayList<String> extensionFilters;
    private int ic_arrow;
    private int ic_folder;
    private int reqCode;
    private String rootDir;
    private boolean selectMultiple;
    private boolean showHidden;
    private boolean showOnlyDirectory;
    private int themeId;

    public static Config getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static Config getCleanInstance() {
        Config config = getInstance();
        config.reset();
        return config;
    }

    private Config() {
    }

    private void reset() {
        this.selectMultiple = false;
        this.rootDir = null;
        this.showHidden = false;
        this.extensionFilters = null;
        this.addItemDivider = false;
    }

    public ArrayList<String> getExtensionFilters() {
        return this.extensionFilters;
    }

    public void setExtensionFilters(ArrayList<String> arrayList) {
        this.extensionFilters = arrayList;
    }

    public boolean showOnlyDirectory() {
        return this.showOnlyDirectory;
    }

    public void setShowOnlyDirectory(boolean z) {
        this.showOnlyDirectory = z;
    }

    public boolean addItemDivider() {
        return this.addItemDivider;
    }

    public void setAddItemDivider(boolean z) {
        this.addItemDivider = z;
    }

    public int getThemeId() {
        return this.themeId;
    }

    public void setThemeId(int i) {
        this.themeId = i;
    }

    public int getReqCode() {
        return this.reqCode;
    }

    public void setReqCode(int i) {
        this.reqCode = i;
    }

    public boolean showHidden() {
        return this.showHidden;
    }

    public void setShowHidden(boolean z) {
        this.showHidden = z;
    }

    public boolean isSelectMultiple() {
        return this.selectMultiple;
    }

    public void setSelectMultiple(boolean z) {
        this.selectMultiple = z;
    }

    public String getRootDir() {
        return this.rootDir;
    }

    public void setRootDir(String str) {
        this.rootDir = str;
    }

    public void setFolderIcon(int i) {
        this.ic_folder = i;
    }

    public int getFolderIcon() {
        return this.ic_folder;
    }

    public void setArrowIcon(int i) {
        this.ic_arrow = i;
    }

    public int getArrowIcon() {
        return this.ic_arrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class InstanceHolder {
        private static final Config INSTANCE = new Config();

        private InstanceHolder() {
        }
    }
}
