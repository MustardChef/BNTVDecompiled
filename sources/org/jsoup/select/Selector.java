package org.jsoup.select;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

/* loaded from: classes5.dex */
public class Selector {
    private Selector() {
    }

    public static Elements select(String str, Element element) {
        Validate.notEmpty(str);
        return select(QueryParser.parse(str), element);
    }

    public static Elements select(Evaluator evaluator, Element element) {
        Validate.notNull(evaluator);
        Validate.notNull(element);
        return Collector.collect(evaluator, element);
    }

    public static Elements select(String str, Iterable<Element> iterable) {
        Validate.notEmpty(str);
        Validate.notNull(iterable);
        Evaluator parse = QueryParser.parse(str);
        Elements elements = new Elements();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        for (Element element : iterable) {
            Iterator<Element> it = select(parse, element).iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (identityHashMap.put(next, Boolean.TRUE) == null) {
                    elements.add(next);
                }
            }
        }
        return elements;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Elements filterOut(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element element : collection) {
            boolean z = false;
            Iterator<Element> it = collection2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (element.equals(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                elements.add(element);
            }
        }
        return elements;
    }

    @Nullable
    public static Element selectFirst(String str, Element element) {
        Validate.notEmpty(str);
        return Collector.findFirst(QueryParser.parse(str), element);
    }

    /* loaded from: classes5.dex */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }
}
