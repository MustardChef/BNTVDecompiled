package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.entry;
import com.frostwire.jlibtorrent.swig.entry_vector;
import com.frostwire.jlibtorrent.swig.string_entry_map;
import com.frostwire.jlibtorrent.swig.string_vector;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Entry {

    /* renamed from: e */
    private final entry f2812e;

    public Entry(entry entryVar) {
        this.f2812e = entryVar;
    }

    public Entry(String str) {
        this(new entry(str));
    }

    public Entry(long j) {
        this(new entry(j));
    }

    public entry swig() {
        return this.f2812e;
    }

    public byte[] bencode() {
        return Vectors.byte_vector2bytes(this.f2812e.bencode());
    }

    public String string() {
        return this.f2812e.string();
    }

    public long integer() {
        return this.f2812e.integer();
    }

    public List<Entry> list() {
        return new EntryList(this.f2812e.list());
    }

    public Map<String, Entry> dictionary() {
        return new EntryMap(this.f2812e.dict());
    }

    public String toString() {
        return this.f2812e.to_string();
    }

    public static Entry bdecode(byte[] bArr) {
        return new Entry(entry.bdecode(Vectors.bytes2byte_vector(bArr)));
    }

    public static Entry bdecode(File file) throws IOException {
        return bdecode(Files.bytes(file));
    }

    public static Entry fromList(List<?> list) {
        entry entryVar = new entry(entry.data_type.list_t);
        entry_vector list2 = entryVar.list();
        for (Object obj : list) {
            if (obj instanceof String) {
                list2.push_back(new entry((String) obj));
            } else if (obj instanceof Integer) {
                list2.push_back(new entry(((Integer) obj).intValue()));
            } else if (obj instanceof Entry) {
                list2.push_back(((Entry) obj).swig());
            } else if (obj instanceof entry) {
                list2.push_back((entry) obj);
            } else if (obj instanceof List) {
                list2.push_back(fromList((List) obj).swig());
            } else if (obj instanceof Map) {
                list2.push_back(fromMap((Map) obj).swig());
            } else {
                list2.push_back(new entry(obj.toString()));
            }
        }
        return new Entry(entryVar);
    }

    public static Entry fromMap(Map<String, ?> map) {
        entry entryVar = new entry(entry.data_type.dictionary_t);
        string_entry_map dict = entryVar.dict();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                dict.set(str, new entry((String) obj));
            } else if (obj instanceof Integer) {
                dict.set(str, new entry(((Integer) obj).intValue()));
            } else if (obj instanceof Entry) {
                dict.set(str, ((Entry) obj).swig());
            } else if (obj instanceof entry) {
                dict.set(str, (entry) obj);
            } else if (obj instanceof List) {
                dict.set(str, fromList((List) obj).swig());
            } else if (obj instanceof Map) {
                dict.set(str, fromMap((Map) obj).swig());
            } else {
                dict.set(str, new entry(obj.toString()));
            }
        }
        return new Entry(entryVar);
    }

    /* loaded from: classes2.dex */
    private static final class EntryList extends AbstractList<Entry> {

        /* renamed from: v */
        private final entry_vector f2813v;

        public EntryList(entry_vector entry_vectorVar) {
            this.f2813v = entry_vectorVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public Entry get(int i) {
            return new Entry(this.f2813v.get(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Entry entry) {
            this.f2813v.push_back(entry.swig());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return (int) this.f2813v.size();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f2813v.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f2813v.empty();
        }
    }

    /* loaded from: classes2.dex */
    private static final class EntryMap extends AbstractMap<String, Entry> {

        /* renamed from: m */
        private final string_entry_map f2814m;

        public EntryMap(string_entry_map string_entry_mapVar) {
            this.f2814m = string_entry_mapVar;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Entry get(Object obj) {
            if (this.f2814m.has_key(obj.toString())) {
                return new Entry(this.f2814m.get(obj.toString()));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Entry put(String str, Entry entry) {
            Entry entry2 = get((Object) str);
            this.f2814m.set(str, entry.swig());
            return entry2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return (int) this.f2814m.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f2814m.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f2814m.has_key(obj.toString());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f2814m.empty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<String> keySet() {
            HashSet hashSet = new HashSet();
            string_vector keys = this.f2814m.keys();
            int size = (int) keys.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(keys.get(i));
            }
            return hashSet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, Entry>> entrySet() {
            throw new UnsupportedOperationException();
        }
    }
}
