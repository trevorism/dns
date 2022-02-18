package com.trevorism.gcloud.model

import groovy.transform.ToString

@ToString
class DnsEntry {

    String id
    String type
    String host
    String pointsTo
    int ttl

    static DnsEntry fromGodaddyDnsRecord(GodaddyDnsRecord dnsRecord) {
        new DnsEntry(id:"${dnsRecord.type}:${dnsRecord.name}", pointsTo: dnsRecord.data, host: dnsRecord.name, ttl: dnsRecord.ttl, type: dnsRecord.type)
    }
}
