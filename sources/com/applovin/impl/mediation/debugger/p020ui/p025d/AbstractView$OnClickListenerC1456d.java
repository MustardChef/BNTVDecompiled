package com.applovin.impl.mediation.debugger.p020ui.p025d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.d */
/* loaded from: classes.dex */
public abstract class AbstractView$OnClickListenerC1456d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a */
    private final LayoutInflater f1244a;

    /* renamed from: c */
    protected final Context f1246c;

    /* renamed from: e */
    private InterfaceC1458a f1248e;

    /* renamed from: b */
    private List<C1452c> f1245b = new ArrayList();

    /* renamed from: d */
    private Map<Integer, Integer> f1247d = new HashMap();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1458a {
        /* renamed from: a */
        void mo7365a(C1450a c1450a, C1452c c1452c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractView$OnClickListenerC1456d(Context context) {
        this.f1246c = context;
        this.f1244a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: e */
    private C1450a m7375e(int i) {
        for (int i2 = 0; i2 < mo7368b(); i2++) {
            Integer num = this.f1247d.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + mo7369a(i2)) {
                    return new C1450a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    protected abstract int mo7369a(int i);

    /* renamed from: a */
    public Bitmap m7378a(ListView listView) {
        int count = getCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824);
        int i = 0;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ArrayList<Bitmap> arrayList = new ArrayList(count);
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View view = getView(i3, null, listView);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            arrayList.add(createBitmap);
            i2 += view.getMeasuredHeight();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(listView.getMeasuredWidth(), i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        for (Bitmap bitmap : arrayList) {
            canvas.drawBitmap(bitmap, 0.0f, i, paint);
            i += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap2;
    }

    /* renamed from: a */
    public void m7377a(InterfaceC1458a interfaceC1458a) {
        this.f1248e = interfaceC1458a;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    /* renamed from: b */
    protected abstract int mo7368b();

    /* renamed from: b */
    protected abstract C1452c mo7367b(int i);

    /* renamed from: c */
    protected abstract List<C1452c> mo7366c(int i);

    @Override // android.widget.Adapter
    /* renamed from: d */
    public C1452c getItem(int i) {
        return this.f1245b.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1245b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).m7400i();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1451b c1451b;
        C1452c item = getItem(i);
        if (view == null) {
            view = this.f1244a.inflate(item.m7399j(), viewGroup, false);
            c1451b = new C1451b();
            c1451b.f1204a = (TextView) view.findViewById(16908308);
            c1451b.f1205b = (TextView) view.findViewById(16908309);
            c1451b.f1206c = (ImageView) view.findViewById(C1799R.C1802id.imageView);
            c1451b.f1207d = (ImageView) view.findViewById(C1799R.C1802id.detailImageView);
            view.setTag(c1451b);
            view.setOnClickListener(this);
        } else {
            c1451b = (C1451b) view.getTag();
        }
        c1451b.m7410a(i);
        c1451b.m7409a(item);
        view.setEnabled(item.mo7406b());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return C1452c.m7401h();
    }

    /* renamed from: i */
    public void m7374i() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractView$OnClickListenerC1456d.this.notifyDataSetChanged();
            }
        });
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).mo7406b();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f1245b = new ArrayList();
        Integer valueOf = Integer.valueOf(mo7368b());
        this.f1247d = new HashMap(valueOf.intValue());
        Integer num = 0;
        for (int i = 0; i < valueOf.intValue(); i++) {
            Integer valueOf2 = Integer.valueOf(mo7369a(i));
            if (valueOf2.intValue() != 0) {
                this.f1245b.add(mo7367b(i));
                this.f1245b.addAll(mo7366c(i));
                this.f1247d.put(Integer.valueOf(i), num);
                num = Integer.valueOf(num.intValue() + valueOf2.intValue() + 1);
            }
        }
        this.f1245b.add(new C1459e(""));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1451b c1451b = (C1451b) view.getTag();
        C1452c m7408b = c1451b.m7408b();
        C1450a m7375e = m7375e(c1451b.m7411a());
        InterfaceC1458a interfaceC1458a = this.f1248e;
        if (interfaceC1458a == null || m7375e == null) {
            return;
        }
        interfaceC1458a.mo7365a(m7375e, m7408b);
    }
}
