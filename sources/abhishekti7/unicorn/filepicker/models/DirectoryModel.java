package abhishekti7.unicorn.filepicker.models;

/* loaded from: classes.dex */
public class DirectoryModel {
    private boolean isDirectory;
    private long last_modif_time;
    private String name;
    private int num_files;
    private String path;

    public DirectoryModel() {
    }

    public DirectoryModel(boolean z, String str, String str2, long j, int i) {
        this.isDirectory = z;
        this.path = str;
        this.name = str2;
        this.last_modif_time = j;
        this.num_files = i;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getLast_modif_time() {
        return this.last_modif_time;
    }

    public void setLast_modif_time(long j) {
        this.last_modif_time = j;
    }

    public int getNum_files() {
        return this.num_files;
    }

    public void setNum_files(int i) {
        this.num_files = i;
    }

    public String toString() {
        return "DirectoryModel{isDirectory=" + this.isDirectory + ", path='" + this.path + "', name='" + this.name + "', last_modif_time=" + this.last_modif_time + ", num_files=" + this.num_files + '}';
    }
}
