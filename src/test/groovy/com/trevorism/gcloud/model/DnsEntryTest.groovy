package com.trevorism.gcloud.model

import org.junit.Test

class DnsEntryTest {

    @Test
    void testFromGodaddyDnsRecord() {
        GodaddyDnsRecord dnsRecord = new GodaddyDnsRecord(data: "ghs.googlehosted.com", name: "*.build", type: "CNAME", ttl: 3600)
        DnsEntry entry = DnsEntry.fromGodaddyDnsRecord(dnsRecord)

        assert entry
        assert entry.id == "CNAME:*.build"
        assert entry.type == "CNAME"
        assert entry.host == "*.build"
        assert entry.pointsTo == "ghs.googlehosted.com"
        assert entry.ttl == 3600
    }
}
