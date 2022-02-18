package com.trevorism.gcloud.model

class GodaddyDnsRecord {
    String data
    String name
    int ttl
    String type

    static GodaddyDnsRecord fromDnsEntry(DnsEntry dnsEntry) {
        new GodaddyDnsRecord(data: dnsEntry.pointsTo, name: dnsEntry.host, ttl: dnsEntry.ttl, type: dnsEntry.type)
    }
}
