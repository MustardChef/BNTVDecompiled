package org.jsoup.nodes;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.Debug;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: classes5.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public Elements elements() {
        return this.elements;
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String absUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(absUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        Connection.Method method = attr(FirebaseAnalytics.Param.METHOD).equalsIgnoreCase(ShareTarget.METHOD_POST) ? Connection.Method.POST : Connection.Method.GET;
        Document ownerDocument = ownerDocument();
        return (ownerDocument != null ? ownerDocument.connection().newRequest() : Jsoup.newSession()).url(absUrl).data(formData()).method(method);
    }

    public List<Connection.KeyVal> formData() {
        Element selectFirst;
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.tag().isFormSubmittable() && !next.hasAttr("disabled")) {
                String attr = next.attr("name");
                if (attr.length() != 0) {
                    String attr2 = next.attr("type");
                    if (!attr2.equalsIgnoreCase("button")) {
                        if ("select".equals(next.normalName())) {
                            boolean z = false;
                            Iterator<Element> it2 = next.select("option[selected]").iterator();
                            while (it2.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, it2.next().val()));
                                z = true;
                            }
                            if (!z && (selectFirst = next.selectFirst("option")) != null) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, selectFirst.val()));
                            }
                        } else if ("checkbox".equalsIgnoreCase(attr2) || "radio".equalsIgnoreCase(attr2)) {
                            if (next.hasAttr("checked")) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, next.val().length() > 0 ? next.val() : Debug.DEBUG_PROPERTY_VALUE_ON));
                            }
                        } else {
                            arrayList.add(HttpConnection.KeyVal.create(attr, next.val()));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public FormElement clone() {
        return (FormElement) super.clone();
    }
}
