package abhishekti7.unicorn.filepicker.adapters;

import abhishekti7.unicorn.filepicker.C0000R;
import abhishekti7.unicorn.filepicker.models.DirectoryModel;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DirectoryStackAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<DirectoryModel> directoryList;
    private onDirectoryStackListener onDirectoryStackListener;
    private int selectedTextColor;
    private int textColor;
    private TypedValue typedValue = new TypedValue();

    /* loaded from: classes.dex */
    public interface onDirectoryStackListener {
        void onDirClicked(DirectoryModel directoryModel);
    }

    public DirectoryStackAdapter(Context context, ArrayList<DirectoryModel> arrayList, onDirectoryStackListener ondirectorystacklistener) {
        this.context = context;
        this.directoryList = arrayList;
        this.onDirectoryStackListener = ondirectorystacklistener;
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(C0000R.attr.unicorn_primaryTextColor, this.typedValue, true);
        this.textColor = this.typedValue.data;
        theme.resolveAttribute(C0000R.attr.unicorn_colorAccent, this.typedValue, true);
        this.selectedTextColor = this.typedValue.data;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C0000R.C0005layout.unicorn_item_layout_directory_stack, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.tv_dir_name.setText(this.directoryList.get(i).getName());
        if (i == getItemCount() - 1) {
            viewHolder.tv_dir_name.setTextColor(this.selectedTextColor);
        } else {
            viewHolder.tv_dir_name.setTextColor(this.textColor);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: abhishekti7.unicorn.filepicker.adapters.-$$Lambda$DirectoryStackAdapter$ibc3EWpY4DTmAHXNicbXzuLGryY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DirectoryStackAdapter.this.lambda$onBindViewHolder$0$DirectoryStackAdapter(i, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DirectoryStackAdapter(int i, View view) {
        this.onDirectoryStackListener.onDirClicked(this.directoryList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.directoryList.size();
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_dir_name;

        public ViewHolder(View view) {
            super(view);
            this.tv_dir_name = (TextView) view.findViewById(C0000R.C0003id.tv_dir_name);
        }
    }
}
