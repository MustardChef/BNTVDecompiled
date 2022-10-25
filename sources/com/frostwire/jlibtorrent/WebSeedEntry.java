package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.string_string_pair;
import com.frostwire.jlibtorrent.swig.string_string_pair_vector;
import com.frostwire.jlibtorrent.swig.web_seed_entry;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class WebSeedEntry {

    /* renamed from: e */
    private final web_seed_entry f2834e;

    public WebSeedEntry(web_seed_entry web_seed_entryVar) {
        this.f2834e = web_seed_entryVar;
    }

    public web_seed_entry swig() {
        return this.f2834e;
    }

    public String url() {
        return this.f2834e.getUrl();
    }

    public String auth() {
        return this.f2834e.getAuth();
    }

    public ArrayList<Pair<String, String>> extraHeaders() {
        string_string_pair_vector extra_headers = this.f2834e.getExtra_headers();
        int size = (int) extra_headers.size();
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            string_string_pair string_string_pairVar = extra_headers.get(i);
            arrayList.add(new Pair<>(string_string_pairVar.getFirst(), string_string_pairVar.getSecond()));
        }
        return arrayList;
    }

    public Type type() {
        return Type.fromSwig(this.f2834e.getType());
    }

    /* loaded from: classes2.dex */
    public enum Type {
        URL_SEED(web_seed_entry.type_t.url_seed.swigValue()),
        HTTP_SEED(web_seed_entry.type_t.http_seed.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        Type(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static Type fromSwig(int i) {
            Type[] typeArr;
            for (Type type : (Type[]) Type.class.getEnumConstants()) {
                if (type.swig() == i) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }
}
