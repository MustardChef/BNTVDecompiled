package abhishekti7.unicorn.filepicker.adapters;

import abhishekti7.unicorn.filepicker.C0000R;
import abhishekti7.unicorn.filepicker.models.Config;
import abhishekti7.unicorn.filepicker.models.DirectoryModel;
import abhishekti7.unicorn.filepicker.utils.Utils;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DirectoryAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
    private int backgroundTint;
    private Context context;
    private ArrayList<DirectoryModel> filesList;
    private ArrayList<DirectoryModel> filesListFiltered;
    private onFilesClickListener onFilesClickListener;
    private int selectionTint;
    private Filter tempFilter = new Filter() { // from class: abhishekti7.unicorn.filepicker.adapters.DirectoryAdapter.1
        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList = new ArrayList();
            if (charSequence == null || charSequence.length() == 0) {
                arrayList = DirectoryAdapter.this.filesList;
            } else {
                String trim = charSequence.toString().toLowerCase().trim();
                Iterator it = DirectoryAdapter.this.filesList.iterator();
                while (it.hasNext()) {
                    DirectoryModel directoryModel = (DirectoryModel) it.next();
                    if (directoryModel.getName().toLowerCase().contains(trim)) {
                        arrayList.add(directoryModel);
                    }
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = arrayList;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            DirectoryAdapter.this.filesListFiltered = (ArrayList) filterResults.values;
            DirectoryAdapter.this.notifyDataSetChanged();
        }
    };
    private ArrayList<String> selected = new ArrayList<>();
    private Config config = Config.getInstance();
    private TypedValue typedValue = new TypedValue();

    /* loaded from: classes.dex */
    public interface onFilesClickListener {
        void onClicked(DirectoryModel directoryModel);

        void onFileSelected(DirectoryModel directoryModel);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.tempFilter;
    }

    public DirectoryAdapter(Context context, ArrayList<DirectoryModel> arrayList, boolean z, onFilesClickListener onfilesclicklistener) {
        this.context = context;
        this.filesList = arrayList;
        this.filesListFiltered = arrayList;
        this.onFilesClickListener = onfilesclicklistener;
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(C0000R.attr.unicorn_file_selectionTint, this.typedValue, true);
        this.selectionTint = this.typedValue.data;
        theme.resolveAttribute(C0000R.attr.unicorn_background, this.typedValue, true);
        this.backgroundTint = this.typedValue.data;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == 1) {
            inflate = LayoutInflater.from(this.context).inflate(C0000R.C0005layout.unicorn_item_layout_directory, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(this.context).inflate(C0000R.C0005layout.unicorn_item_layout_files, viewGroup, false);
        }
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        if (this.filesListFiltered.get(i).isDirectory()) {
            viewHolder.tv_folder_name.setText(this.filesListFiltered.get(i).getName());
            TextView textView = viewHolder.tv_num_files;
            textView.setText(this.filesListFiltered.get(i).getNum_files() + " files");
        } else {
            viewHolder.tv_file_name.setText(this.filesListFiltered.get(i).getName());
        }
        if (!this.filesListFiltered.get(i).isDirectory()) {
            changeFileIcon(viewHolder, this.filesListFiltered.get(i).getName());
            if (this.selected.contains(String.valueOf(i))) {
                viewHolder.rl_file_root.setBackgroundColor(this.selectionTint);
                viewHolder.rg_selected.setVisibility(0);
            } else {
                viewHolder.rl_file_root.setBackgroundColor(this.backgroundTint);
                viewHolder.rg_selected.setVisibility(8);
            }
        }
        viewHolder.tv_date.setText(Utils.longToReadableDate(this.filesListFiltered.get(i).getLast_modif_time()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: abhishekti7.unicorn.filepicker.adapters.-$$Lambda$DirectoryAdapter$AZuPZAEEZNceCMA3rJ5uFf-Duoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DirectoryAdapter.this.lambda$onBindViewHolder$0$DirectoryAdapter(i, viewHolder, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DirectoryAdapter(int i, ViewHolder viewHolder, View view) {
        if (this.filesListFiltered.get(i).isDirectory()) {
            this.onFilesClickListener.onClicked(this.filesListFiltered.get(i));
            return;
        }
        if (this.config.isSelectMultiple()) {
            if (this.selected.contains(String.valueOf(i))) {
                this.selected.remove(String.valueOf(i));
                viewHolder.rg_selected.setVisibility(8);
                viewHolder.rl_file_root.setBackgroundColor(this.backgroundTint);
            } else {
                this.selected.add(String.valueOf(i));
                viewHolder.rg_selected.setVisibility(0);
                viewHolder.rl_file_root.setBackgroundColor(this.selectionTint);
            }
        } else if (this.selected.size() == 0) {
            this.selected.add(0, String.valueOf(i));
        } else if (this.selected.get(0).equals(String.valueOf(i))) {
            this.selected.remove(0);
        } else {
            this.selected.remove(0);
            this.selected.add(0, String.valueOf(i));
        }
        notifyDataSetChanged();
        this.onFilesClickListener.onFileSelected(this.filesListFiltered.get(i));
    }

    private void changeFileIcon(ViewHolder viewHolder, String str) {
        try {
            String substring = str.substring(str.lastIndexOf("."));
            if (!substring.toLowerCase().contains("pdf")) {
                if (substring.toLowerCase().contains("png") || substring.toLowerCase().contains("jpg") || substring.toLowerCase().contains("jpeg")) {
                    viewHolder.item_icon.setImageResource(C0000R.C0002drawable.unicorn_ic_images);
                }
            } else {
                viewHolder.item_icon.setImageResource(C0000R.C0002drawable.unicorn_ic_pdf);
            }
        } catch (Exception unused) {
            viewHolder.item_icon.setImageResource(C0000R.C0002drawable.unicorn_ic_file);
        }
    }

    public void resetSelection() {
        this.selected = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.filesListFiltered.get(i).isDirectory() ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filesListFiltered.size();
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_icon;
        private RadioButton rg_selected;
        private RelativeLayout rl_file_root;
        private TextView tv_date;
        private TextView tv_file_name;
        private TextView tv_folder_name;
        private TextView tv_num_files;

        public ViewHolder(View view) {
            super(view);
            this.tv_file_name = (TextView) view.findViewById(C0000R.C0003id.tv_file_name);
            this.tv_folder_name = (TextView) view.findViewById(C0000R.C0003id.tv_folder_name);
            this.tv_date = (TextView) view.findViewById(C0000R.C0003id.tv_date);
            this.tv_num_files = (TextView) view.findViewById(C0000R.C0003id.tv_num_files);
            this.rg_selected = (RadioButton) view.findViewById(C0000R.C0003id.rg_selected);
            this.rl_file_root = (RelativeLayout) view.findViewById(C0000R.C0003id.rl_file_root);
            this.item_icon = (ImageView) view.findViewById(C0000R.C0003id.item_icon);
        }
    }
}
