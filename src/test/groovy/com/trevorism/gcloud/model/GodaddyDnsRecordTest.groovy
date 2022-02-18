package com.trevorism.gcloud.model

import org.junit.Test

class GodaddyDnsRecordTest {

    @Test
    void testFromDnsEntry() {
        DnsEntry dnsEntry = new DnsEntry(type: "A", host: "@", pointsTo: "216.15.234.2", ttl: 1440)
        GodaddyDnsRecord godaddyDnsRecord = GodaddyDnsRecord.fromDnsEntry(dnsEntry)

        assert godaddyDnsRecord
        assert godaddyDnsRecord.name == "@"
        assert godaddyDnsRecord.ttl == 1440
        assert godaddyDnsRecord.type == "A"
        assert godaddyDnsRecord.data == "216.15.234.2"
    }

}
