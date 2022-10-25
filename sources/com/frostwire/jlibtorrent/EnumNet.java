package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.ip_interface;
import com.frostwire.jlibtorrent.swig.ip_interface_vector;
import com.frostwire.jlibtorrent.swig.ip_route;
import com.frostwire.jlibtorrent.swig.ip_route_vector;
import com.frostwire.jlibtorrent.swig.libtorrent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class EnumNet {
    private EnumNet() {
    }

    public static List<IpInterface> enumInterfaces(SessionManager sessionManager) {
        if (sessionManager.swig() == null) {
            return Collections.emptyList();
        }
        ip_interface_vector enum_net_interfaces = libtorrent.enum_net_interfaces(sessionManager.swig());
        int size = (int) enum_net_interfaces.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new IpInterface(enum_net_interfaces.get(i)));
        }
        return arrayList;
    }

    public static List<IpRoute> enumRoutes(SessionManager sessionManager) {
        if (sessionManager.swig() == null) {
            return Collections.emptyList();
        }
        ip_route_vector enum_routes = libtorrent.enum_routes(sessionManager.swig());
        int size = (int) enum_routes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new IpRoute(enum_routes.get(i)));
        }
        return arrayList;
    }

    public static Address getGateway(SessionManager sessionManager, IpInterface ipInterface, ip_route_vector ip_route_vectorVar) {
        return new Address(libtorrent.get_gateway(sessionManager.swig(), ipInterface.swig(), ip_route_vectorVar));
    }

    /* loaded from: classes2.dex */
    public static final class IpInterface {
        private final String description;
        private final String friendlyName;
        private final Address interfaceAddress;
        private final String name;
        private final Address netmask;
        private final boolean preferred;

        /* renamed from: s */
        private final ip_interface f2815s;

        IpInterface(ip_interface ip_interfaceVar) {
            this.f2815s = ip_interfaceVar;
            this.interfaceAddress = new Address(ip_interfaceVar.getInterface_address());
            this.netmask = new Address(ip_interfaceVar.getNetmask());
            this.name = Vectors.byte_vector2ascii(ip_interfaceVar.getName());
            this.friendlyName = Vectors.byte_vector2ascii(ip_interfaceVar.getFriendly_name());
            this.description = Vectors.byte_vector2ascii(ip_interfaceVar.getDescription());
            this.preferred = ip_interfaceVar.getPreferred();
        }

        public ip_interface swig() {
            return this.f2815s;
        }

        public Address interfaceAddress() {
            return this.interfaceAddress;
        }

        public Address netmask() {
            return this.netmask;
        }

        public String name() {
            return this.name;
        }

        public String friendlyName() {
            return this.friendlyName;
        }

        public String description() {
            return this.description;
        }

        public boolean preferred() {
            return this.preferred;
        }

        public String toString() {
            return "address: " + this.interfaceAddress + ", netmask: " + this.netmask + ", name: " + this.name + ", friendlyName: " + this.friendlyName + ", description: " + this.description + ", preferred: " + this.preferred;
        }
    }

    /* loaded from: classes2.dex */
    public static final class IpRoute {
        private final Address destination;
        private final Address gateway;
        private final int mtu;
        private final String name;
        private final Address netmask;

        /* renamed from: s */
        private final ip_route f2816s;

        IpRoute(ip_route ip_routeVar) {
            this.f2816s = ip_routeVar;
            this.destination = new Address(ip_routeVar.getDestination());
            this.netmask = new Address(ip_routeVar.getNetmask());
            this.gateway = new Address(ip_routeVar.getGateway());
            this.name = Vectors.byte_vector2ascii(ip_routeVar.getName());
            this.mtu = ip_routeVar.getMtu();
        }

        public ip_route swig() {
            return this.f2816s;
        }

        public Address destination() {
            return this.destination;
        }

        public Address netmask() {
            return this.netmask;
        }

        public Address gateway() {
            return this.gateway;
        }

        public String name() {
            return this.name;
        }

        public int mtu() {
            return this.mtu;
        }

        public String toString() {
            return "destination: " + this.destination + ", netmask: " + this.netmask + ", gateway: " + this.gateway + ", name: " + this.name + ", mtu: " + this.mtu;
        }
    }
}
