package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class file_storage {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;
    public static final file_flags_t flag_pad_file = new file_flags_t(libtorrent_jni.file_storage_flag_pad_file_get(), false);
    public static final file_flags_t flag_hidden = new file_flags_t(libtorrent_jni.file_storage_flag_hidden_get(), false);
    public static final file_flags_t flag_executable = new file_flags_t(libtorrent_jni.file_storage_flag_executable_get(), false);
    public static final file_flags_t flag_symlink = new file_flags_t(libtorrent_jni.file_storage_flag_symlink_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public file_storage(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(file_storage file_storageVar) {
        if (file_storageVar == null) {
            return 0L;
        }
        return file_storageVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_file_storage(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public file_storage() {
        this(libtorrent_jni.new_file_storage__SWIG_0(), true);
    }

    public file_storage(file_storage file_storageVar) {
        this(libtorrent_jni.new_file_storage__SWIG_1(getCPtr(file_storageVar), file_storageVar), true);
    }

    public boolean is_valid() {
        return libtorrent_jni.file_storage_is_valid(this.swigCPtr, this);
    }

    public void reserve(int i) {
        libtorrent_jni.file_storage_reserve(this.swigCPtr, this, i);
    }

    public void add_file_borrow(string_view string_viewVar, String str, long j, file_flags_t file_flags_tVar, String str2, long j2, string_view string_viewVar2) {
        libtorrent_jni.file_storage_add_file_borrow__SWIG_0(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, str2, j2, string_view.getCPtr(string_viewVar2), string_viewVar2);
    }

    public void add_file_borrow(string_view string_viewVar, String str, long j, file_flags_t file_flags_tVar, String str2, long j2) {
        libtorrent_jni.file_storage_add_file_borrow__SWIG_1(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, str2, j2);
    }

    public void add_file_borrow(string_view string_viewVar, String str, long j, file_flags_t file_flags_tVar, String str2) {
        libtorrent_jni.file_storage_add_file_borrow__SWIG_2(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, str2);
    }

    public void add_file_borrow(string_view string_viewVar, String str, long j, file_flags_t file_flags_tVar) {
        libtorrent_jni.file_storage_add_file_borrow__SWIG_3(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar);
    }

    public void add_file_borrow(string_view string_viewVar, String str, long j) {
        libtorrent_jni.file_storage_add_file_borrow__SWIG_4(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, str, j);
    }

    public void add_file(String str, long j, file_flags_t file_flags_tVar, long j2, string_view string_viewVar) {
        libtorrent_jni.file_storage_add_file__SWIG_0(this.swigCPtr, this, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, j2, string_view.getCPtr(string_viewVar), string_viewVar);
    }

    public void add_file(String str, long j, file_flags_t file_flags_tVar, long j2) {
        libtorrent_jni.file_storage_add_file__SWIG_1(this.swigCPtr, this, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, j2);
    }

    public void add_file(String str, long j, file_flags_t file_flags_tVar) {
        libtorrent_jni.file_storage_add_file__SWIG_2(this.swigCPtr, this, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar);
    }

    public void add_file(String str, long j) {
        libtorrent_jni.file_storage_add_file__SWIG_3(this.swigCPtr, this, str, j);
    }

    public void rename_file(int i, String str) {
        libtorrent_jni.file_storage_rename_file(this.swigCPtr, this, i, str);
    }

    public file_slice_vector map_block(int i, long j, int i2) {
        return new file_slice_vector(libtorrent_jni.file_storage_map_block(this.swigCPtr, this, i, j, i2), true);
    }

    public peer_request map_file(int i, long j, int i2) {
        return new peer_request(libtorrent_jni.file_storage_map_file(this.swigCPtr, this, i, j, i2), true);
    }

    public int num_files() {
        return libtorrent_jni.file_storage_num_files(this.swigCPtr, this);
    }

    public int end_file() {
        return libtorrent_jni.file_storage_end_file(this.swigCPtr, this);
    }

    public long total_size() {
        return libtorrent_jni.file_storage_total_size(this.swigCPtr, this);
    }

    public void set_num_pieces(int i) {
        libtorrent_jni.file_storage_set_num_pieces(this.swigCPtr, this, i);
    }

    public int num_pieces() {
        return libtorrent_jni.file_storage_num_pieces(this.swigCPtr, this);
    }

    public int end_piece() {
        return libtorrent_jni.file_storage_end_piece(this.swigCPtr, this);
    }

    public int last_piece() {
        return libtorrent_jni.file_storage_last_piece(this.swigCPtr, this);
    }

    public void set_piece_length(int i) {
        libtorrent_jni.file_storage_set_piece_length(this.swigCPtr, this, i);
    }

    public int piece_length() {
        return libtorrent_jni.file_storage_piece_length(this.swigCPtr, this);
    }

    public int piece_size(int i) {
        return libtorrent_jni.file_storage_piece_size(this.swigCPtr, this, i);
    }

    public void set_name(String str) {
        libtorrent_jni.file_storage_set_name(this.swigCPtr, this, str);
    }

    public String name() {
        return libtorrent_jni.file_storage_name(this.swigCPtr, this);
    }

    public void swap(file_storage file_storageVar) {
        libtorrent_jni.file_storage_swap(this.swigCPtr, this, getCPtr(file_storageVar), file_storageVar);
    }

    public void optimize(int i, int i2, boolean z) {
        libtorrent_jni.file_storage_optimize__SWIG_0(this.swigCPtr, this, i, i2, z);
    }

    public void optimize(int i, int i2) {
        libtorrent_jni.file_storage_optimize__SWIG_1(this.swigCPtr, this, i, i2);
    }

    public void optimize(int i) {
        libtorrent_jni.file_storage_optimize__SWIG_2(this.swigCPtr, this, i);
    }

    public void optimize() {
        libtorrent_jni.file_storage_optimize__SWIG_3(this.swigCPtr, this);
    }

    public sha1_hash hash(int i) {
        return new sha1_hash(libtorrent_jni.file_storage_hash(this.swigCPtr, this, i), true);
    }

    public String symlink(int i) {
        return libtorrent_jni.file_storage_symlink(this.swigCPtr, this, i);
    }

    public long mtime(int i) {
        return libtorrent_jni.file_storage_mtime(this.swigCPtr, this, i);
    }

    public String file_path(int i, String str) {
        return libtorrent_jni.file_storage_file_path__SWIG_0(this.swigCPtr, this, i, str);
    }

    public String file_path(int i) {
        return libtorrent_jni.file_storage_file_path__SWIG_1(this.swigCPtr, this, i);
    }

    public string_view file_name(int i) {
        return new string_view(libtorrent_jni.file_storage_file_name(this.swigCPtr, this, i), true);
    }

    public long file_size(int i) {
        return libtorrent_jni.file_storage_file_size(this.swigCPtr, this, i);
    }

    public boolean pad_file_at(int i) {
        return libtorrent_jni.file_storage_pad_file_at(this.swigCPtr, this, i);
    }

    public long file_offset(int i) {
        return libtorrent_jni.file_storage_file_offset(this.swigCPtr, this, i);
    }

    public string_vector paths() {
        return new string_vector(libtorrent_jni.file_storage_paths(this.swigCPtr, this), false);
    }

    public file_flags_t file_flags(int i) {
        return new file_flags_t(libtorrent_jni.file_storage_file_flags(this.swigCPtr, this, i), true);
    }

    public boolean file_absolute_path(int i) {
        return libtorrent_jni.file_storage_file_absolute_path(this.swigCPtr, this, i);
    }

    public int file_index_at_offset(long j) {
        return libtorrent_jni.file_storage_file_index_at_offset(this.swigCPtr, this, j);
    }

    public void add_file(String str, long j, file_flags_t file_flags_tVar, long j2, String str2) {
        libtorrent_jni.file_storage_add_file__SWIG_4(this.swigCPtr, this, str, j, file_flags_t.getCPtr(file_flags_tVar), file_flags_tVar, j2, str2);
    }
}
