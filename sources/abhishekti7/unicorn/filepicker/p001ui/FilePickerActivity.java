package abhishekti7.unicorn.filepicker.p001ui;

import abhishekti7.unicorn.filepicker.C0000R;
import abhishekti7.unicorn.filepicker.adapters.DirectoryAdapter;
import abhishekti7.unicorn.filepicker.adapters.DirectoryStackAdapter;
import abhishekti7.unicorn.filepicker.databinding.UnicornActivityFilePickerBinding;
import abhishekti7.unicorn.filepicker.models.Config;
import abhishekti7.unicorn.filepicker.models.DirectoryModel;
import abhishekti7.unicorn.filepicker.utils.UnicornSimpleItemDecoration;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: abhishekti7.unicorn.filepicker.ui.FilePickerActivity */
/* loaded from: classes.dex */
public class FilePickerActivity extends AppCompatActivity {
    private static final String TAG = "FilePickerActivity";
    private final String[] REQUIRED_PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    private ArrayList<DirectoryModel> arr_dir_stack;
    private ArrayList<DirectoryModel> arr_files;
    private Config config;
    private DirectoryAdapter directoryAdapter;
    private UnicornActivityFilePickerBinding filePickerBinding;
    private ArrayList<String> filters;
    private File root_dir;
    private ArrayList<String> selected_files;
    private DirectoryStackAdapter stackAdapter;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Config config = Config.getInstance();
        this.config = config;
        setTheme(config.getThemeId());
        UnicornActivityFilePickerBinding inflate = UnicornActivityFilePickerBinding.inflate(getLayoutInflater());
        this.filePickerBinding = inflate;
        setContentView(inflate.getRoot());
        initConfig();
    }

    private void initConfig() {
        this.filters = this.config.getExtensionFilters();
        setSupportActionBar(this.filePickerBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (this.config.getRootDir() != null) {
            this.root_dir = new File(this.config.getRootDir());
        } else {
            this.root_dir = Environment.getExternalStorageDirectory();
        }
        this.selected_files = new ArrayList<>();
        this.arr_dir_stack = new ArrayList<>();
        this.arr_files = new ArrayList<>();
        setUpDirectoryStackView();
        setUpFilesView();
        if (allPermissionsGranted()) {
            fetchDirectory(new DirectoryModel(true, this.root_dir.getAbsolutePath(), this.root_dir.getName(), this.root_dir.lastModified(), this.root_dir.listFiles() == null ? 0 : this.root_dir.listFiles().length));
        } else {
            Log.e(TAG, "Storage permissions not granted. You have to implement it before starting the file picker");
            finish();
        }
        this.filePickerBinding.fabSelect.setOnClickListener(new View.OnClickListener() { // from class: abhishekti7.unicorn.filepicker.ui.-$$Lambda$FilePickerActivity$SInmPdRndBULGMnDi1h_ScEiNqQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePickerActivity.this.lambda$initConfig$0$FilePickerActivity(view);
            }
        });
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(C0000R.attr.unicorn_fabColor, typedValue, true);
        if (typedValue.data != 0) {
            this.filePickerBinding.fabSelect.setBackgroundTintList(ColorStateList.valueOf(typedValue.data));
        } else {
            this.filePickerBinding.fabSelect.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(C0000R.C0001color.unicorn_colorAccent)));
        }
    }

    public /* synthetic */ void lambda$initConfig$0$FilePickerActivity(View view) {
        Intent intent = new Intent();
        if (this.config.showOnlyDirectory()) {
            this.selected_files.clear();
            ArrayList<String> arrayList = this.selected_files;
            ArrayList<DirectoryModel> arrayList2 = this.arr_dir_stack;
            arrayList.add(arrayList2.get(arrayList2.size() - 1).getPath());
        }
        intent.putStringArrayListExtra("filePaths", this.selected_files);
        setResult(this.config.getReqCode(), intent);
        setResult(-1, intent);
        finish();
    }

    private void setUpFilesView() {
        this.filePickerBinding.rvFiles.setLayoutManager(new LinearLayoutManager(this));
        this.directoryAdapter = new DirectoryAdapter(this, this.arr_files, false, new DirectoryAdapter.onFilesClickListener() { // from class: abhishekti7.unicorn.filepicker.ui.FilePickerActivity.1
            @Override // abhishekti7.unicorn.filepicker.adapters.DirectoryAdapter.onFilesClickListener
            public void onClicked(DirectoryModel directoryModel) {
                FilePickerActivity.this.fetchDirectory(directoryModel);
            }

            @Override // abhishekti7.unicorn.filepicker.adapters.DirectoryAdapter.onFilesClickListener
            public void onFileSelected(DirectoryModel directoryModel) {
                if (FilePickerActivity.this.config.isSelectMultiple()) {
                    if (FilePickerActivity.this.selected_files.contains(directoryModel.getPath())) {
                        FilePickerActivity.this.selected_files.remove(directoryModel.getPath());
                        return;
                    } else {
                        FilePickerActivity.this.selected_files.add(directoryModel.getPath());
                        return;
                    }
                }
                FilePickerActivity.this.selected_files.clear();
                FilePickerActivity.this.selected_files.add(directoryModel.getPath());
            }
        });
        this.filePickerBinding.rvFiles.setAdapter(this.directoryAdapter);
        this.directoryAdapter.notifyDataSetChanged();
        if (this.config.addItemDivider()) {
            this.filePickerBinding.rvFiles.addItemDecoration(new UnicornSimpleItemDecoration(this));
        }
    }

    private void setUpDirectoryStackView() {
        this.filePickerBinding.rvDirPath.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.stackAdapter = new DirectoryStackAdapter(this, this.arr_dir_stack, new DirectoryStackAdapter.onDirectoryStackListener() { // from class: abhishekti7.unicorn.filepicker.ui.-$$Lambda$FilePickerActivity$QpjuWUpjyis8YXZOYgAS20PCSWQ
            @Override // abhishekti7.unicorn.filepicker.adapters.DirectoryStackAdapter.onDirectoryStackListener
            public final void onDirClicked(DirectoryModel directoryModel) {
                FilePickerActivity.this.lambda$setUpDirectoryStackView$1$FilePickerActivity(directoryModel);
            }
        });
        this.filePickerBinding.rvDirPath.setAdapter(this.stackAdapter);
        this.stackAdapter.notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$setUpDirectoryStackView$1$FilePickerActivity(DirectoryModel directoryModel) {
        Log.e(TAG, directoryModel.toString());
        ArrayList<DirectoryModel> arrayList = this.arr_dir_stack;
        this.arr_dir_stack = new ArrayList<>(arrayList.subList(0, arrayList.indexOf(directoryModel) + 1));
        setUpDirectoryStackView();
        ArrayList<DirectoryModel> arrayList2 = this.arr_dir_stack;
        fetchDirectory(arrayList2.remove(arrayList2.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchDirectory(DirectoryModel directoryModel) {
        this.filePickerBinding.rlProgress.setVisibility(0);
        this.selected_files.clear();
        this.arr_files.clear();
        File[] listFiles = new File(directoryModel.getPath()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                DirectoryModel directoryModel2 = new DirectoryModel();
                directoryModel2.setDirectory(file.isDirectory());
                directoryModel2.setName(file.getName());
                directoryModel2.setPath(file.getAbsolutePath());
                directoryModel2.setLast_modif_time(file.lastModified());
                if (this.config.showHidden() || (!this.config.showHidden() && !file.isHidden())) {
                    if (file.isDirectory()) {
                        if (file.listFiles() != null) {
                            directoryModel2.setNum_files(file.listFiles().length);
                        }
                        this.arr_files.add(directoryModel2);
                    } else if (!this.config.showOnlyDirectory()) {
                        if (this.filters != null) {
                            try {
                                String name = file.getName();
                                String substring = name.substring(name.lastIndexOf("."));
                                Iterator<String> it = this.filters.iterator();
                                while (it.hasNext()) {
                                    if (substring.toLowerCase().contains(it.next())) {
                                        this.arr_files.add(directoryModel2);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            this.arr_files.add(directoryModel2);
                        }
                    }
                }
            }
            Collections.sort(this.arr_files, new CustomFileComparator());
            this.arr_dir_stack.add(directoryModel);
            this.filePickerBinding.rvDirPath.scrollToPosition(this.arr_dir_stack.size() - 1);
            this.filePickerBinding.toolbar.setTitle(directoryModel.getName());
        }
        if (this.arr_files.size() == 0) {
            this.filePickerBinding.rlNoFiles.setVisibility(0);
        } else {
            this.filePickerBinding.rlNoFiles.setVisibility(8);
        }
        this.filePickerBinding.rlProgress.setVisibility(8);
        this.stackAdapter.notifyDataSetChanged();
        this.directoryAdapter.notifyDataSetChanged();
    }

    /* renamed from: abhishekti7.unicorn.filepicker.ui.FilePickerActivity$CustomFileComparator */
    /* loaded from: classes.dex */
    public static class CustomFileComparator implements Comparator<DirectoryModel> {
        @Override // java.util.Comparator
        public int compare(DirectoryModel directoryModel, DirectoryModel directoryModel2) {
            if (directoryModel.isDirectory() && directoryModel2.isDirectory()) {
                return directoryModel.getName().toLowerCase().compareTo(directoryModel2.getName().toLowerCase());
            }
            if (!directoryModel.isDirectory() || directoryModel2.isDirectory()) {
                if (directoryModel.isDirectory() || !directoryModel2.isDirectory()) {
                    return directoryModel.getName().toLowerCase().compareTo(directoryModel2.getName().toLowerCase());
                }
                return 1;
            }
            return -1;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0000R.C0006menu.unicorn_menu_file_picker, menu);
        SearchView searchView = (SearchView) menu.findItem(C0000R.C0003id.action_search).getActionView();
        searchView.setImeOptions(6);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: abhishekti7.unicorn.filepicker.ui.FilePickerActivity.2
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                FilePickerActivity.this.directoryAdapter.getFilter().filter(str);
                return false;
            }
        });
        return true;
    }

    private boolean allPermissionsGranted() {
        for (String str : this.REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.arr_dir_stack.size() > 1) {
            ArrayList<DirectoryModel> arrayList = this.arr_dir_stack;
            arrayList.remove(arrayList.size() - 1);
            ArrayList<DirectoryModel> arrayList2 = this.arr_dir_stack;
            fetchDirectory(arrayList2.remove(arrayList2.size() - 1));
            return;
        }
        Intent intent = new Intent();
        setResult(this.config.getReqCode(), intent);
        setResult(0, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return true;
    }
}
