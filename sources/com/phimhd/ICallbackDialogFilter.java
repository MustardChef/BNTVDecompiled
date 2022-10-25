package com.phimhd;

import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ICallbackDialogFilter.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\n"}, m107d2 = {"Lcom/phimhd/ICallbackDialogFilter;", "", "hideDialogFilter", "", "showDialogFilter", "list", "", "Lcom/lagradost/cloudstream3/Page;", "itemICallback", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ICallbackDialogFilter {
    void hideDialogFilter();

    void showDialogFilter(List<Page> list, ICallback<Page> iCallback);
}
