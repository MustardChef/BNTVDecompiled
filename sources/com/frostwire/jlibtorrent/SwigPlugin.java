package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.bdecode_node;
import com.frostwire.jlibtorrent.swig.entry;
import com.frostwire.jlibtorrent.swig.string_view;
import com.frostwire.jlibtorrent.swig.swig_plugin;
import com.frostwire.jlibtorrent.swig.udp_endpoint;

/* loaded from: classes2.dex */
class SwigPlugin extends swig_plugin {

    /* renamed from: p */
    private final Plugin f2828p;

    public SwigPlugin(Plugin plugin) {
        this.f2828p = plugin;
    }

    @Override // com.frostwire.jlibtorrent.swig.swig_plugin
    public boolean on_dht_request(string_view string_viewVar, udp_endpoint udp_endpointVar, bdecode_node bdecode_nodeVar, entry entryVar) {
        return this.f2828p.onDhtRequest(Vectors.byte_vector2ascii(string_viewVar.to_bytes()), new UdpEndpoint(udp_endpointVar), new BDecodeNode(bdecode_nodeVar), new Entry(entryVar));
    }
}
